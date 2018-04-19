package com.aaa.web.script;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DISearchCallsPage;
import com.aaa.web.page.LoginPage;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DIProfileRedFlagCallsTab extends DILoginLib {
    public static String callID;
    public static String callIDWithRedFlag;
    LoginLib login = new LoginLib();
    CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib services = new CRServiceLib();
    DILoginLib diLoginLib = new DILoginLib();
    LoginRoleLib role = new LoginRoleLib();
    DIHomeLib diHome = new DIHomeLib();
    DIMCDLib dimcdLib = new DIMCDLib();
    DISearchCallsPage diSearchCallsPage=new DISearchCallsPage();
    CommonLib commonLib=new CommonLib();

    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * description ::1802: TC-DI Profile Red Flag Calls Tab
     * date :: 01-01-2018
     * author :: Nidhi Kumari Raut
     */
   
    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyCallWithRedFlag(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyCallWithRedFlag", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyCallWithRedFlag", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1802: TC-DI Profile Red Flag Calls Tab"+ " From Iteration " + StartRow + " to " + EndRow );    
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		                login.login(data.get("LoginName"),data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                if (Member.isEmpty())
		                {
		                	Member = data.get("Membersearch");
		                }
		                crHomeLib.memberSearchTextBox(Member);
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Address"));
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                String VehicleDet[] = data.get("Vehiclemodel").split("#");
		                crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
		                crVehicleTriageLib.clickOnTheVehicleSearchIcon();
		                crVehicleTriageLib.clickOnTheVehicleSearch();
		                crVehicleTriageLib.vehicleColor(VehicleDet[1]);
		                String combineKeys3 = Keys.chord(Keys.TAB);
		                sendKeys(combineKeys3, "Tab");
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.clickOnOutOfGas();
		                services.clickOnServiceTab();
		                services.clickOnRedFlagOnServiceTab();
		                crHomeLib.saveButton();
		                crHomeLib.allErrorAlerts();
		                services.getCallId();
		                callIDWithRedFlag = services.getCallId();
		                services.clickOnRemainInCall();
		                Thread.sleep(5000);
		                crHomeLib.logout();
		                acceptAlert();
		                navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"),data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.selectAllDispatchCallsAddAndContinueInQueueSelection();
		                diHome.clickOnProfile();
		               /* diHome.clickOnHiddenTabsDropdown();
		                diHome.selectRedFlagCallTabOnHiddenTab();*/
		                diHome.selectRedflagCall();
		                diHome.verifyRedFlagCallID(callIDWithRedFlag);
		                acceptAlert();
		                crHomeLib.allErrorAlerts();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.enterStartDate(data.get("startDate"));
		                diHome.enterCallIDInfo(callIDWithRedFlag);
		                diHome.clickOnSearchInSearchCalls();
		                diHome.clickOnCallDateOrIDLink();
		                dimcdLib.clickOnStatusUpdateTab();
		                dimcdLib.enterStatusInStatusUpdateTab(data.get("statusForStatusUpdate"));
		                dimcdLib.enterReasonForRedFlagInStatusUpdateTab(data.get("reasonForRedFlagStatusUpdate"));
		                dimcdLib.clickOnUpdate();
		                dimcdLib.clickOnAssign();
		                dimcdLib.selectFacility();
		                dimcdLib.selectDispatch();
		                dimcdLib.selectEnroute();
		                dimcdLib.selectEnrouteTime();
		                dimcdLib.selectOnLocation();
		                dimcdLib.selectClearCall();
		                dimcdLib.selectExitCode();
		                dimcdLib.enterReason(data.get("Reason"));
		                dimcdLib.clickOnContinue();
		                Thread.sleep(5000);
		                dimcdLib.labelCallCleared(data.get("DIStatusCL"));
		                dimcdLib.clickOnMCDCloseWindow();
		                diHome.logOut();
		                acceptAlert();
		                acceptAlert();
		                Thread.sleep(5000);
		               
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1802",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    
    /************************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    *************************************************************************/

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyCallWithoutRedFlag(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyCallWithoutRedFlag", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyCallWithoutRedFlag", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1802: TC-DI Profile Red Flag Calls Tab"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		                login.login(data.get("LoginName"),data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                if (Member.isEmpty())
		                {
		                	Member = data.get("Membersearch");
		                }
		                crHomeLib.memberSearchTextBox(Member);
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Address"));
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                String VehicleDet[] = data.get("Vehiclemodel").split("#");
		                crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
		                crVehicleTriageLib.clickOnTheVehicleSearchIcon();
		                crVehicleTriageLib.clickOnTheVehicleSearch();
		                crVehicleTriageLib.vehicleColor(VehicleDet[1]);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.clickOnOutOfGas();
		                crHomeLib.saveButton();
		                crHomeLib.allErrorAlerts();
		                services.getCallId();
		                callID = services.getCallId();
		                services.clickOnRemainInCall();
		                Thread.sleep(5000);
		                crHomeLib.logout();
		                acceptAlert();
		                navigateToApplication("DI");
		                if(isVisibleOnly(LoginPage.txtLoginName,"User Name Text Field"))
		                {
		                	 diLoginLib.login(data.get("DILoginName"),data.get("DIPassword"));
		                     Thread.sleep(5000);
		                     role.clickOnProceedBtnInDispatchRoleLogin();
		                     diLoginLib.waitcloseAllBusyIcons();
		                }
		                diHome.selectAllDispatchCallsAddAndContinueInQueueSelection();
		                diHome.clickOnProfile();
		               /* diHome.clickOnHiddenTabsDropdown();
		                diHome.selectRedFlagCallTabOnHiddenTab();*/
		                diHome.selectRedflagCall();
		                diHome.verifyNonRedFlagCallID(callID);
		                acceptAlert();
		                crHomeLib.allErrorAlerts();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.enterStartDate(data.get("startDate"));
		                diHome.enterCallIDInfo(callID);
		                diHome.clickOnSearchInSearchCalls();
		                diHome.clickOnCallDateOrIDLink();
		                dimcdLib.clickOnStatusUpdateTab();
		                dimcdLib.enterStatusInStatusUpdateTab(data.get("statusForStatusUpdate"));
		                dimcdLib.enterReasonInStatusUpdateTab(data.get("reasonForStatusUpdate"));
		                dimcdLib.clickOnUpdate();
		                dimcdLib.clickOnAssign();
		                dimcdLib.selectFacility();
		                dimcdLib.selectDispatch();
		                dimcdLib.selectEnroute();
		                dimcdLib.selectEnrouteTime();
		                dimcdLib.selectOnLocation();
		                dimcdLib.selectClearCall();
		                dimcdLib.selectExitCode();
		                dimcdLib.enterReason(data.get("Reason"));
		                dimcdLib.clickOnContinue();
		                Thread.sleep(5000);
		                dimcdLib.labelCallCleared(data.get("DIStatusCL"));
		                dimcdLib.clickOnMCDCloseWindow();
		                diHome.logOut();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1802",ReportStatus.strMethodName,intCounter,browser);
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