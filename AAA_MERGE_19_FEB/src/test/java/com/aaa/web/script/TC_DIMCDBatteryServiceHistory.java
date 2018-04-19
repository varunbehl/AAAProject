package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIMCDBatteryServiceHistory extends DILoginLib {

    String callIDCallReceiving;
    String callIDDispatch;
    public static long ran;
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String reasonCode;
    public static String memberNumber;
    CRHomeLib home = new CRHomeLib();
    LoginRoleLib role = new LoginRoleLib();
    DIHomeLib diHome = new DIHomeLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRMemberSearchLib member = new CRMemberSearchLib();
    CRLocationsLib locations = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib services = new CRServiceLib();
    CRTowDestinationLib tow = new CRTowDestinationLib();
    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
    CR_DI crDI = new CR_DI();
    DIMCDLib dimcd = new DIMCDLib();
    LoginRoleLib loginRole=new LoginRoleLib();
    DILoginLib diLogin = new DILoginLib();
    CommonLib common = new CommonLib();

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

    public void MCDBatteryServiceHistory(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "MCDBatteryServiceHistory", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("MCDBatteryServiceHistory", TestData, "D3Dispatch",intCounter);
    	
			                this.reporter.initTestCaseDescription("1940: TC-DI MCD Battery Service History"+ " From Iteration " + StartRow + " to " + EndRow );
			                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			
			
			                /*//navigateToApplication("CR");
			                String CRLoginName,String CRPassword,String LoginRoleCallReceiving,String role,String Member,String Membersearch,String dbServer,String dbqueryFileName,String colomnName,String PhoneNumber,String Primaryphonenum1,
			                        String VehicleSearch,String VehicleDetails,String ProblemTriage,String ProblemType,
			                        String WillThisCallBeATow,String TowDestination,String RSPReferral,String TowAddress,String OmniBarAddress*/
			                common.crCallCreation(data.get("CRLoginName"), data.get("CRPassword"), data.get("LoginRoleCallReceiving"), data.get("role"),
			                        data.get("Member"), data.get("Membersearch"), data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), data.get("PhoneNumber"), data.get("Primaryphonenum1"),
			                        data.get("VehicleSearch"), data.get("VehicleDetails"), data.get("ProblemTriage"), data.get("ProblemType"),
			                        data.get("WillThisCallBeATow"), data.get("TowDestination"), data.get("RSPReferral"), data.get("TowAddress"),
			                        data.get("OmniBarAddress"));
			
			                services.clickOnServiceTab();
			                services.enterManualSpotDetails(data.get("facilityNumber"));
			                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			
			                home.saveButton();
			                crHomeLib.allErrorAlerts();
			                Thread.sleep(1000);
			                callID = services.getCallId();
			                services.closeCall();
			                Thread.sleep(4000);
			                home.logout();
			
			
			                navigateToApplication("DI");
			                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
			                if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
			                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
			                    Thread.sleep(4000);
			                    diLogin.waitcloseAllBusyIcons();
			                    diHome.clickOnCloseIconOnQueueSelection();
			                } else {
			                    diLogin.waitcloseAllBusyIcons();
			                    Thread.sleep(5000);
			                    diHome.closeFacilityWindow();
			                }
			
			                diLogin.waitcloseAllBusyIcons();
			                diHome.clickOnSearchCallsLink();
			                diHome.searchAndSelectCallIDInDI(callID);
			
			                commonMCDFunction(data);
			
			                boolean poppedOutButtonFlag = dimcd.verifyPoppedOutButtonOnMCD();
			                if (poppedOutButtonFlag) {
			                    dimcd.maximizeMCDWindow();
			                    Thread.sleep(3000);
			                    switchToWindow();
			                    commonMCDFunction(data);
			                    dimcd.minimizeMCDWindow();
			                    dimcd.closeTheOpendCallInMCD();
			                    //reporter.SuccessReport("Reason Code","Reason code is "+reasonCode);
			                }
			               /* String memberNumber = dimcd.getMemberNumberOnSummaryTab();
			                dimcd.paymentForRAPCall(data.get("cost"), data.get("cashCollected"), data.get("serviceType"), data.get("towServiceType"));
			                dimcd.clearCallProcess();
			                dimcd.selectBatterlyResolutionCodeInMCDClearWindow();
			                dimcd.clickOnContinue();
			                dimcd.clickAndEnterBatteryInformation(data.get("odoMeterReading"), data.get("comments"), data.get("testCode"), data.get("batteryType"), data.get("batteryPrice"));
			                dimcd.clickOnContinue();
			                dimcd.clickOnSubmitButton();
			                dimcd.clickOnMemberTabInMCDWindow();
			                dimcd.clickOnShowBatteryServiceHistory();
			
			                boolean tabAvailability = dimcd.verifyShowBatteryServiceHisotryTabAvailablity();
			                assertTrue(tabAvailability, "Battery information Tab opened");
			
			                String dataAndCallId = dimcd.getDateAndCallIdInShowBatteryHistory();
			                reporter.SuccessReport("Date and Call ID", "Date and Call ID values is:: " + dataAndCallId);
			
			                String resolutionLable = dimcd.getResoultionCodeLableInShowBatteryHistory();
			                String resolutionCode = dimcd.getResoultionCodeValueInShowBatteryHistory();
			                reporter.SuccessReport("ResolutionCode", resolutionLable + " is " + resolutionCode);
			
			                String testCodeLable = dimcd.getTestCodeLabelInShowBatteryHistory();
			                String testCodeValue = dimcd.getTestCodeValueInShowBatteryHistory();
			                reporter.SuccessReport("Test Code", testCodeLable + " :Is: " + testCodeValue);
			
			                String facilityLabel = dimcd.getlblFacilityLabelInShowBatteryHistory();
			                String facilityValue = dimcd.getlblFacilityValueInShowBatteryHistory();
			                reporter.SuccessReport("Facility Code", facilityLabel + " is: " + facilityValue);
			
			                String vehicleLabel = dimcd.getVehicleLableInShowBatteryHistory();
			                String vehicleValue = dimcd.getFacilityValueInShowBatteryHistory();
			                reporter.SuccessReport("Vehicle Details Year Make Model", vehicleLabel + " is: " + vehicleValue);
			
			
			                dimcd.clickOnDateAndCallIdInShowBatteryHistory();
			                switchToWindow();
			                boolean printButton = dimcd.verifyPrintButton();
			                assertTrue(printButton, "Print Page opened");
			                closeWindow();
			                switchToWindow();
			                dimcd.clickOnBatteryInformationCloseIcon();
			                dimcd.clickOnMCDCloseWindow();*/
			                diHome.logOut();
			
			                common.crCallCreation(data.get("CRLoginName"), data.get("CRPassword"), data.get("LoginRoleCallReceiving"), data.get("role"),
			                        data.get("Member1"), memberNumber, data.get("dbServer1"), data.get("dbqueryFileName1"), data.get("colomnName1"), data.get("PhoneNumber"), data.get("Primaryphonenum1"),
			                        data.get("VehicleSearch"), data.get("VehicleDetails"), data.get("ProblemTriage"), data.get("ProblemType1"),
			                        data.get("WillThisCallBeATow"), data.get("TowDestination"), data.get("RSPReferral"), data.get("TowAddress"),
			                        data.get("OmniBarAddress"));
			
			                services.clickOnServiceTab();
			                services.enterManualSpotDetails(data.get("facilityNumber"));
			                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			
			                home.saveButton();
			                crHomeLib.allErrorAlerts();
			                Thread.sleep(1000);
			                callID = services.getCallId();
			                services.closeCall();
			                Thread.sleep(4000);
			                home.logout();
			
			                driver.manage().deleteAllCookies();
			                navigateToApplication("DI");
			                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
			                if (!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
			                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
			                    Thread.sleep(4000);
			                    diLogin.waitcloseAllBusyIcons();
			                    diHome.clickOnCloseIconOnQueueSelection();
			                } else {
			                    diLogin.waitcloseAllBusyIcons();
			                    Thread.sleep(5000);
			                    diHome.closeFacilityWindow();
			                }
			                diLogin.waitcloseAllBusyIcons();
			                diHome.clickOnSearchCallsLink();
			                diHome.searchAndSelectCallIDInDI(callID);
			                commonMCDFunction(data);
			
			                boolean poppedOutButtonFlag1 = dimcd.verifyPoppedOutButtonOnMCD();
			                if (poppedOutButtonFlag1) {
			                    dimcd.maximizeMCDWindow();
			                    Thread.sleep(3000);
			                    switchToWindow();
			                    commonMCDFunction(data);
			                    dimcd.minimizeMCDWindow();
			                    dimcd.closeTheOpendCallInMCD();
			
			
			
			                /*
			                String memberNumber1=dimcd.getMemberNumberOnSummaryTab();
			                dimcd.paymentForRAPCall(data.get("cost"),data.get("cashCollected"),data.get("serviceType"),data.get("towServiceType"));
			                dimcd.clearCallProcess();
			                dimcd.selectBatterlyResolutionCodeInMCDClearWindow();
			                dimcd.clickOnContinue();
			                dimcd.clickAndEnterBatteryInformation(data.get("odoMeterReading"),data.get("comments"),data.get("testCode"),data.get("batteryType"),data.get("batteryPrice"));
			                dimcd.clickOnContinue();
			                dimcd.clickOnSubmitButton();
			                dimcd.clickOnMemberTabInMCDWindow();
			                dimcd.clickOnShowBatteryServiceHistory();
			
			                boolean tabAvailability1=dimcd.verifyShowBatteryServiceHisotryTabAvailablity();
			                assertTrue(tabAvailability1,"Battery information Tab opened");
			
			                String dataAndCallId1=dimcd.getDateAndCallIdInShowBatteryHistory();
			                reporter.SuccessReport("Date and Call ID","Date and Call ID values is:: "+dataAndCallId1);
			
			                String resolutionLable1=dimcd.getResoultionCodeLableInShowBatteryHistory();
			                String resolutionCode1=dimcd.getResoultionCodeValueInShowBatteryHistory();
			                reporter.SuccessReport("ResolutionCode",resolutionLable1+" is "+resolutionCode1);
			
			                String testCodeLable1=dimcd.getTestCodeLabelInShowBatteryHistory();
			                String testCodeValue1=dimcd.getTestCodeValueInShowBatteryHistory();
			                reporter.SuccessReport("Test Code",testCodeLable1+" :Is: "+testCodeValue1);
			
			                String facilityLabel1 =dimcd.getlblFacilityLabelInShowBatteryHistory();
			                String facilityValue1 =dimcd.getlblFacilityValueInShowBatteryHistory();
			                reporter.SuccessReport("Facility Code",facilityLabel1+" is: "+facilityValue1);
			
			                String vehicleLabel1=dimcd.getVehicleLableInShowBatteryHistory();
			                String vehicleValue1=dimcd.getFacilityValueInShowBatteryHistory();
			                reporter.SuccessReport("Vehicle Details Year Make Model",vehicleLabel1+" is: "+vehicleValue1);
			
			
			                dimcd.clickOnDateAndCallIdInShowBatteryHistory();
			                boolean printButton1=dimcd.verifyPrintButton();
			                assertTrue(printButton1,"Print Page opened");
			
			                dimcd.clickOnBatteryInformationCloseIcon();*/
			                    //reporter.SuccessReport("Reason Code","Reason code is "+reasonCode);
			                    diHome.logOut();
			                    //diLogin.CloseLogoutAlert();
			
			                    System.out.println("Test completed");
			                    //driver.quit();
			                }
			                }
			    			catch(Exception e)
			    			{
			    				ReportStatus.blnStatus=false;
			    			}
			    			ReportControl.fnEnableJoin();
			    			ReportStatus.fnUpdateResultStatus("DI","1940",ReportStatus.strMethodName,intCounter,browser);
			    		}
			    	}
			    	catch (Exception e) 
			    	{
			    		e.printStackTrace();
			    		throw new RuntimeException(e);
			    	}
			    	ReportControl.fnNextTestJoin(nextTestJoin);
			    }

    public void commonMCDFunction(Hashtable<String, String> data)throws Throwable{

        String memberNumber=dimcd.getMemberNumberOnSummaryTab();
        dimcd.paymentForRAPCall(data.get("cost"),data.get("cashCollected"),data.get("serviceType"),data.get("towServiceType"));
        dimcd.clearCallProcess();
        dimcd.selectBatterlyResolutionCodeInMCDClearWindow();
        dimcd.selectExitCodeandChangeReasonandClickonContinue(data.get("reason"));
        dimcd.clickAndEnterBatteryInformation(data.get("odoMeterReading"),data.get("comments"),data.get("testCode"),data.get("batteryType"),data.get("batteryPrice"));
        dimcd.clickOnContinue();
        dimcd.clickOnSubmitButton();
        dimcd.clickOnMemberTabInMCDWindow();
        dimcd.clickOnShowBatteryServiceHistory();

        boolean tabAvailability1=dimcd.verifyShowBatteryServiceHisotryTabAvailablity();
        assertTrue(tabAvailability1,"Battery information Tab opened");

        String dataAndCallId1=dimcd.getDateAndCallIdInShowBatteryHistory();
        reporter.SuccessReport("Date and Call ID","Date and Call ID values is:: "+dataAndCallId1);

        String resolutionLable1=dimcd.getResoultionCodeLableInShowBatteryHistory();
        String resolutionCode1=dimcd.getResoultionCodeValueInShowBatteryHistory();
        reporter.SuccessReport("ResolutionCode",resolutionLable1+" is "+resolutionCode1);

        String testCodeLable1=dimcd.getTestCodeLabelInShowBatteryHistory();
        String testCodeValue1=dimcd.getTestCodeValueInShowBatteryHistory();
        reporter.SuccessReport("Test Code",testCodeLable1+" :Is: "+testCodeValue1);

        String facilityLabel1 =dimcd.getlblFacilityLabelInShowBatteryHistory();
        String facilityValue1 =dimcd.getlblFacilityValueInShowBatteryHistory();
        reporter.SuccessReport("Facility Code",facilityLabel1+" is: "+facilityValue1);

        String vehicleLabel1=dimcd.getVehicleLableInShowBatteryHistory();
        String vehicleValue1=dimcd.getFacilityValueInShowBatteryHistory();
        reporter.SuccessReport("Vehicle Details Year Make Model",vehicleLabel1+" is: "+vehicleValue1);


        dimcd.clickOnDateAndCallIdInShowBatteryHistory();
        boolean printButton1=dimcd.verifyPrintButton();
        assertTrue(printButton1,"Print Page opened");

        dimcd.clickOnBatteryInformationCloseIcon();
        switchToWindow();
        closeWindow();
    }
}
