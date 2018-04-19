package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DIHomePage;
import com.aaa.web.page.DISearchCallsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DICancelCallsUpdate extends LoginLib {
    LoginLib login = new LoginLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib services = new CRServiceLib();
    DILoginLib diLoginLib = new DILoginLib();
    LoginRoleLib role = new LoginRoleLib();
    DIHomeLib diHome = new DIHomeLib();
    DIMCDLib dimcdLib = new DIMCDLib();
    CRSearchCallsLib crSearchCallsLib = new CRSearchCallsLib();

    String newCallId;
    String newCallId1;
    String callDateCreated;
    String callDateCreated1;
    String callDateStr;
    String callDateStr1;

  
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyDICancelCallsUpdate(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyDICancelCallsUpdate", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyDICancelCallsUpdate", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1803:TC_DI Cancel Calls Update"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                //D3 CALL RECEV.//NEW CALL CREATED
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                String Member = "";
		                if (data.get("Member").equals("db")) {
		                    //fetch member details from db
		                    //generating a random number everytime to fetch a new record everytime
		                    int rownum = IntRandomNumberGenerator(50, 1000);
		                    //member from db
		                    Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
		                    System.out.println("member : " + Member);
		                } else {
		                    Member = data.get("Membersearch");
		                }
		                crHomeLib.memberSearchTextBox(Member);
		                //crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickOnSecondKownBrkDowLocation();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.clickOnOutOfGas();
		                services.clickOnServiceTab();
		                services.enterManualFacilityNumber(data.get("spotFacilityID"));
		                crHomeLib.saveButton();
		                crHomeLib.allErrorAlerts();
		                newCallId = services.getCallId();
		                callDateCreated = services.getCallDate();
		                callDateStr = callDateCreated.replaceAll("-", "");
		                services.clickOnRemainInCall();
		                crHomeLib.logout();
		
		
		                //D3 DISPATCH //VERIFY CALL
		                navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.selectAllDispatchCallsAddAndContinueInQueueSelection();
		                } else {
		                    Thread.sleep(5000);
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                }
		                diHome.clickOnProfile();
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(10000);
		                Boolean veriFyCallInActionReq = diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
		                assertTrue(veriFyCallInActionReq, "Call ID with status SP in Required Profile Tab");
		                diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
		                diHome.logOut();
		
		                //D3 CALL RECEV.//CANCEL THE CALL CREATED
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCallsLib.clickOnSearchCalls();
		                crSearchCallsLib.enterCallIdOnSearchCallsWindow(newCallId);
		                crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
		                diHome.clickOnCallDateOrIDLink();
		                Thread.sleep(10000);
		                crHomeLib.cancelButton();
		                crHomeLib.allErrorAlerts();
		                crHomeLib.clickOnContinueButtonOnKillCallPopup();
		                crHomeLib.logout();
		
		                //D3 DISPATCH //VERIFY CANCEL CALL
		                navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.selectAllDispatchCallsAddAndContinueInQueueSelection();
		                } else {
		                    Thread.sleep(5000);
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                }
		                diHome.clickOnProfile();
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(10000);
		                Boolean veriFyCallInActionReq1 = diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
		                assertTrue(veriFyCallInActionReq1, "Call ID with status SP in Required Profile Tab");
		                diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
		                Thread.sleep(2000);
		                dimcdLib.getLabelCallCleared();
		                diHome.logOut();
		
		
		                //D3 CALL RECEV.//NEW CALL CREATED
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                String Member1 = "";
		                if (data.get("Member").equals("db")) {
		                    //fetch member details from db
		                    //generating a random number everytime to fetch a new record everytime
		                    int rownum = IntRandomNumberGenerator(50, 1000);
		                    //member from db
		                    Member1 = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
		                    System.out.println("member : " + Member1);
		                } else {
		                    Member1 = data.get("Membersearch");
		                }
		                crHomeLib.memberSearchTextBox(Member1);
		                //crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickOnSecondKownBrkDowLocation();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.clickOnOutOfGas();
		                services.clickOnServiceTab();
		                services.enterManualFacilityNumber(data.get("spotFacilityID"));
		                crHomeLib.saveButton();
		                crHomeLib.allErrorAlerts();
		                newCallId1 = services.getCallId();
		                callDateCreated1 = services.getCallDate();
		                callDateStr1 = callDateCreated1.replaceAll("-", "");
		                services.clickOnRemainInCall();
		                crHomeLib.logout();
		
		                //D3 DISPATCH //VERIFY CALL
		                navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.selectAllDispatchCallsAddAndContinueInQueueSelection();
		                } else {
		                    Thread.sleep(5000);
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                }
		                diHome.clickOnProfile();
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(10000);
		                Boolean veriFyCallInActionReq2 = diHome.verifyCallIdOnProfileWindow(newCallId1, callDateStr1);
		                assertTrue(veriFyCallInActionReq2, "Call ID with status SP in Required Profile Tab");
		                diHome.clickCallIdOnProfileWindow(newCallId1, callDateStr1);
		                diHome.logOut();
		
		                //D3 CALL RECEV.//LOAD CALLS AND UPDATE
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCallsLib.clickOnSearchCalls();
		                crSearchCallsLib.enterCallIdOnSearchCallsWindow(newCallId1);
		                crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
		                diHome.clickOnCallDateOrIDLink();
		                Thread.sleep(5000);
		                crHomeLib.saveButton();
		                services.enterInResonForStatusStatus(data.get("statusReason"));
		                services.enterInCommentStatus(data.get("commentStatusUpdate"));
		                services.clickOnUpdateButtonOnCallStatusWindow();
		                services.closeCall();
		                crHomeLib.logout();
		
		
		                //D3 DISPATCH //VERIFY CALL
		                navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.selectAllDispatchCallsAddAndContinueInQueueSelection();
		                } else {
		                    Thread.sleep(5000);
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                }
		                diHome.clickOnProfile();
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(10000);
		                Boolean veriFyCallInActionReq3 = diHome.verifyCallIdOnProfileWindow(newCallId1, callDateStr1);
		                assertTrue(veriFyCallInActionReq3, "Call ID with status SP in Required Profile Tab");
		                Thread.sleep(2000);
		                diHome.clickCallIdOnProfileWindow(newCallId1, callDateStr1);
		                Thread.sleep(2000);
		                dimcdLib.getLabelCallCleared();
		                diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1803",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyDICancelCallsUpdateOnPoppedoutWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyDICancelCallsUpdate", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyDICancelCallsUpdate", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1803:TC_DI Cancel Calls Update"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                //new call//d3 call recev.
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                String Member = "";
		                if (data.get("Member").equals("db")) {
		                    //fetch member details from db
		                    //generating a random number everytime to fetch a new record everytime
		                    int rownum = IntRandomNumberGenerator(50, 1000);
		                    //member from db
		                    Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
		                    System.out.println("member : " + Member);
		                } else {
		                    Member = data.get("Membersearch");
		                }
		                crHomeLib.memberSearchTextBox(Member);
		                //crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickOnSecondKownBrkDowLocation();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.clickOnOutOfGas();
		                services.clickOnServiceTab();
		                services.enterManualFacilityNumber(data.get("spotFacilityID"));
		                crHomeLib.saveButton();
		                crHomeLib.allErrorAlerts();
		                newCallId = services.getCallId();
		                callDateCreated=services.getCallDate();
		                callDateStr=callDateCreated.replaceAll("-","");
		                services.clickOnRemainInCall();
		                crHomeLib.logout();
		
		
		                //d3 dispatch truckload//truck to acive
		                navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                if(!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.selectAllDispatchCallsAddAndContinueInQueueSelection();
		                }
		                else
		                {
		                    Thread.sleep(5000);
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                }
		                diHome.clickOnProfile();
		                dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(10000);
		                Boolean veriFyCallInActionReq=diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
		                assertTrue(veriFyCallInActionReq, "Call ID with status SP in Required Profile Tab");
		                Thread.sleep(5000);
		                diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
		                Thread.sleep(5000);
		                dimcdLib.clickToClosePoppedOutButtonInActionRequiredTab();
		                diHome.clickToMinimizeProfileWindow();
		                diHome.logOut();
		
		                //call rece d3
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCallsLib.clickOnSearchCalls();
		                crSearchCallsLib.enterCallIdOnSearchCallsWindow(newCallId);
		                crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
		                diHome.clickOnCallDateOrIDLink();
		                Thread.sleep(5000);
		                crHomeLib.cancelButton();
		                crHomeLib.allErrorAlerts();
		                crHomeLib.clickOnContinueButtonOnKillCallPopup();
		                crHomeLib.logout();
		
		                //d3 dispatch truckload//truck to acive
		                navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                if(!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.selectAllDispatchCallsAddAndContinueInQueueSelection();
		                }
		                else
		                {
		                    Thread.sleep(5000);
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                }
		                diHome.clickOnProfile();
		                dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(10000);
		                Boolean veriFyCallInActionReq1=diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
		                assertTrue(veriFyCallInActionReq1, "Call ID with status SP in Required Profile Tab");
		                diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
		                Thread.sleep(5000);
		                dimcdLib.clickToClosePoppedOutButtonInActionRequiredTab();
		                diHome.clickToMinimizeProfileWindow();
		                dimcdLib.getLabelCallCleared();
		                diHome.logOut();
		
		
		
		                //new call//d3 call recev.
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                String Member1 = "";
		                if (data.get("Member").equals("db")) {
		                    //fetch member details from db
		                    //generating a random number everytime to fetch a new record everytime
		                    int rownum = IntRandomNumberGenerator(50, 1000);
		                    //member from db
		                    Member1 = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
		                    System.out.println("member : " + Member1);
		                } else {
		                    Member1 = data.get("Membersearch");
		                }
		                crHomeLib.memberSearchTextBox(Member1);
		                //crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickOnSecondKownBrkDowLocation();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.clickOnOutOfGas();
		                services.clickOnServiceTab();
		                services.enterManualFacilityNumber(data.get("spotFacilityID"));
		                crHomeLib.saveButton();
		                crHomeLib.allErrorAlerts();
		                newCallId1 = services.getCallId();
		                callDateCreated1=services.getCallDate();
		                callDateStr1=callDateCreated1.replaceAll("-","");
		                services.clickOnRemainInCall();
		                crHomeLib.logout();
		
		                //d3 dispatch truckload//truck to acive
		                navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                if(!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.selectAllDispatchCallsAddAndContinueInQueueSelection();
		                }
		                else
		                {
		                    Thread.sleep(5000);
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                }
		                diHome.clickOnProfile();
		                dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(10000);
		                Boolean veriFyCallInActionReq2=diHome.verifyCallIdOnProfileWindow(newCallId1, callDateStr1);
		                assertTrue(veriFyCallInActionReq2, "Call ID with status SP in Required Profile Tab");
		                diHome.clickCallIdOnProfileWindow(newCallId1, callDateStr1);
		                Thread.sleep(5000);
		                dimcdLib.clickToClosePoppedOutButtonInActionRequiredTab();
		                diHome.clickToMinimizeProfileWindow();
		                diHome.logOut();
		
		                //call rece d3
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCallsLib.clickOnSearchCalls();
		                crSearchCallsLib.enterCallIdOnSearchCallsWindow(newCallId1);
		                crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
		                diHome.clickOnCallDateOrIDLink();
		                Thread.sleep(5000);
		                crHomeLib.saveButton();
		                services.enterInResonForStatusStatus(data.get("statusReason"));
		                services.enterInCommentStatus(data.get("commentStatusUpdate"));
		                services.clickOnUpdateButtonOnCallStatusWindow();
		                services.closeCall();
		                crHomeLib.logout();
		
		
		                //d3 dispatch truckload//truck to acive
		                navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                if(!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.selectAllDispatchCallsAddAndContinueInQueueSelection();
		                }
		                else
		                {
		                    Thread.sleep(5000);
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                }
		                diHome.clickOnProfile();
		                dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(10000);
		                Boolean veriFyCallInActionReq3=diHome.verifyCallIdOnProfileWindow(newCallId1, callDateStr1);
		                assertTrue(veriFyCallInActionReq3, "Call ID with status SP in Required Profile Tab");
		                Thread.sleep(2000);
		                diHome.clickCallIdOnProfileWindow(newCallId1, callDateStr1);
		                Thread.sleep(5000);
		                dimcdLib.clickToClosePoppedOutButtonInActionRequiredTab();
		                diHome.clickToMinimizeProfileWindow();
		                dimcdLib.getLabelCallCleared();
		                diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1803",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
}

