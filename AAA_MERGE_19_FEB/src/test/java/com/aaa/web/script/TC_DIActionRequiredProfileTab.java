package com.aaa.web.script;


import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.DIHomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

public class TC_DIActionRequiredProfileTab extends DILoginLib {
    String newCallId;
    String callDateCreated;
    String facilityId;
    String callDateStr;

   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void verifyREstatusOnProfileActionRequired(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyREstatusOnProfileActionRequired", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyREstatusOnProfileActionRequired", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1743: Action Required Profile Tab "+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib location = new CRLocationsLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CR_DI crDI = new CR_DI();
		                DIMCDLib dimcd = new DIMCDLib();
		                LoginRoleLib loginRole = new LoginRoleLib();
		                DILoginLib diLogin = new DILoginLib();
		
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                member.clickOnPartialCallCloseButton();
		                home.messageDialogBoxClose();
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		
		
		                location.clickOnLocationTab();
		                location.clickOnManualEntryLinkInLocation();
		                location.enterBlockRange(data.get("StreetNumber1"));
		                String streenNumber = location.getBlockRange();
		                boolean streenNumberValue = streenNumber != null;
		                assertTrue(streenNumberValue,"verified the Streen Number that is entered in Breakdown Location & entered StreenNumber    "+streenNumber);
		                location.enterBKDownStreetAddress(data.get("StreetAddress1"));
		                String streetAddressValue=location.getBKDownStreetAddress();
		                boolean streetAddress = streetAddressValue != null;
		                assertTrue(streetAddress,"Verified the Street Address That is entered in Breakdown Location & entered StreetAddress   "+streetAddressValue);
		                location.enterBKDownCityLocation(data.get("City1"));
		                String cityValue=location.getCityValue();
		                boolean city=cityValue != null;
		                assertTrue(city,"Verified the City That is entered in Breakdown Location & entered city   "+cityValue);
		                location.enterBKDownState(data.get("State1"));
		                String stateValue=location.getStateValue();
		                boolean state = stateValue != null;
		                assertTrue(state,"Verified the State That is entered in Breakdown Location & entered State  "+stateValue);
		                location.enterBKDownLocCode(data.get("LocationCode1"));
		                String locationCodeValue=location.getLocationCode();
		                boolean locationCode=locationCodeValue != null;
		                assertTrue(locationCode,"Verified the Location Code that is entered in Breakdown Location & entered LocationCode   "+locationCodeValue);
		                vehicle.clickOnVehicleTriageTab();
		                vehicle.selectExistingVehicleModel();
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeButton(data.get("ProblemType1"));
		                Thread.sleep(3000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
		                service.clickOnServiceTab();
		                Thread.sleep(3000);
		                service.validateNoFacilityAutoSpot();
		                Thread.sleep(2000);
		                home.saveButton();
		                home.allErrorAlerts();
		                newCallId = service.getCallId();
		
		                callDateCreated=service.getCallDate();
		
		
		                callDateStr=callDateCreated.replaceAll("-","");
		
		                service.clickOnRemainInCall();
		                Thread.sleep(2000);
		
		                home.allErrorAlerts();
		                service.clickOnCallStatusButton();
		                service.verifyToGetCallStatus(data.get("CallStatusForRE"));
		                service.getTextOfStatusValue();
		
		                home.logout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		
		                /*callIDCreated = crServiceLib.getCallId();
		                spotIDCreated = crServiceLib.getSpotFacilityId();*/
		
		
		
		
		                navigateToApplication("DI");
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                Thread.sleep(10000);
		                //diHome.closeFacilityWindow();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diLogin.waitcloseAllBusyIcons();
		                Thread.sleep(5000);
		                waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
		                click(DIHomePage.tabDiProfile, "Profile Menu Item");
		                diHome.clickOnProfileName(data.get("ProfileName"));
		                diHome.verifyActionReqTabOnProfile();
		                Thread.sleep(10000);
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(60000);
		                Boolean veriFyCallInActionReq=diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
		                assertTrue(veriFyCallInActionReq, "Call ID with status RE in Required Profile Tab");
		                diHome.clickToCloseProfileWindow();
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1743",ReportStatus.strMethodName,intCounter,browser);
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

    public void verifySPstatusOnProfileActionRequired(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifySPstatusOnProfileActionRequired", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifySPstatusOnProfileActionRequired", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1743: Action Required Profile Tab "+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib location = new CRLocationsLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CR_DI crDI = new CR_DI();
		                DIMCDLib dimcd = new DIMCDLib();
		                LoginRoleLib loginRole = new LoginRoleLib();
		                DILoginLib diLogin = new DILoginLib();
		
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                member.clickOnPartialCallCloseButton();
		                home.messageDialogBoxClose();
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		
		                location.clickOnLocationTab();
		                Thread.sleep(5000);
		                location.clickOnManualEntryLinkInLocation();
		                Thread.sleep(3000);
		                //location.enterTxtinBrkDowLocSrch(data.get("AddressLookup"));
		
		                //location.brkDowLocSrchBtn();
		
		                //location.getNumberOfRecordsInResultsGrid();
		
		               // location.clickOnLocationResultsLink();
		
		                //location.acceptAddressDifferenceAlert();
		
		                //location.clickOnManualEntryLinkInLocation();
		                location.enterBlockRange(data.get("StreetNumber2"));
		                String StreetNumber2=getAttributeByValue(CRLocationsPage.txtStreetNumber,"street number 2");
		                Thread.sleep(3000);
		                location.enterBKDownStreetAddress(data.get("StreetAddress2"));
		                String StreetAddress2=getAttributeByValue(CRLocationsPage.txtStreetAddressInput,"street address 2");
		                Thread.sleep(3000);
		                location.enterNorthCrossStreet(data.get("NorthCrossStreet2"));
		                location.enterBKDownCityLocation(data.get("City2"));
		                String city2=getAttributeByValue(CRLocationsPage.txtLocCity,"city 2");
		                Thread.sleep(3000);
		                location.enterBKDownState(data.get("State2"));
		                String State2=getAttributeByValue(CRLocationsPage.txtLocState,"State 2");
		                Thread.sleep(3000);
		                location.enterBKDownLocCode(data.get("LocationCode2"));
		                Thread.sleep(3000);
		                location.enterLocationZip(data.get("ZipCode2"));
		                //location.clickOnLocationCodeDropDown();
		                //String locationcode2=getAttributeByValue(CRLocationsPage.txtLocCode,"location code2");
		                Thread.sleep(3000);
		                vehicle.clickOnVehicleTriageTab();
		                Thread.sleep(3000);
		                vehicle.clickOnManualEntryLinkOnVehicle();
		                Thread.sleep(1000);
		                vehicle.enterVehicleType(data.get("ReEnterType"));
		                vehicle.clickOnTheTypeSearchFromDropDown();
		                Thread.sleep(3000);
		                vehicle.enterVehicleYear(data.get("ReEnterYear"));
		                Thread.sleep(2000);
		                vehicle.enterVehicleMake(data.get("ReEnterMake"));
		                vehicle.enterVehicleModel(data.get("ReEnterModel"));
		                vehicle.enterVehicleColor(data.get("Color"));
		                Thread.sleep(3000);
		
		                vehicle.clickonProblemTypeButton(data.get("ProblemType7"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType7Option1"));
		                Thread.sleep(2000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                tow.clickOnTowDestinationTab();
		                Thread.sleep(3000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(3000);
		                tow.clickOnManualEntryLinkOnTowDestination();
		                Thread.sleep(3000);
		                tow.enterTowPassengers(data.get("TowPassangers"));
		                //vehicle.enterPaceSetterCode(data.get("PaceSetterCode2"));
		                //vehicle.clickOnTheSelectedPaceSetterCodeFromDropDown();
		                //String paceSetterCode2=getAttributeByValue(CRVehicleTriagePage.txtSelectedPaceSetterCodes,"paceSetterCode 2");
		                Thread.sleep(3000);
		                //vehicle.handleScriptErrorInVehicleTriagePage();
		                service.clickOnServiceTab();
		                //service.enterManualFacilityNumber(data.get("facilityNumber"));
		                home.allErrorAlerts();
		               // service.clickOnSpotInServicePage();
		                Thread.sleep(5000);
		                vehicle.scriptErrorHandle();
		
		                String newFacilityValue=service.validateFacilityAutospotID();
		                //assertTrue(newFacilityValue.contains(data.get("Facility")) , "Facility got respot to" + newFacilityValue);
		                Thread.sleep(4000);
		                crHomeLib.saveButton();
		                Thread.sleep(4000);
		
		
		                 facilityId = service.getSpotFacilityId();
		                newCallId = service.getCallId();
		
		                callDateCreated=service.getCallDate();
		               // service.closeCallWindow();
		               // int CallIdNew = Integer.parseInt(newCallId);
		                //service.validateFacilityAutospotID();
		                //String facilityNumber=getAttributeByValue(CRServicePage.txtSpotFacilityLabel,data.get("facilityNumber"));
		                //service.clickOnRedFlagOnServiceTab();
		
		                //String redFlag2=getText(CRServicePage.btnRedFlagOnServiceTab,"Red falg");
		               // Thread.sleep(3000);
		               // home.saveButton();
		                /*service.verifyUpdateCallStatus();
		                Thread.sleep(3000);
		                service.verifyAuditStatusCode();
		                Thread.sleep(3000);
		                service.enterInCommentStatus(data.get("commentStatusUpdate2"));
		                //services.enterInResonForStatusStatus(data.get("statusReason2"));
		                service.selectFirstValueInResonStatus();
		                service.clickUpdateButton();*/
		
		
		
		
		
		
		                callDateStr=callDateCreated.replaceAll("-","");
		                service.clickOnRemainInCall();
		                Thread.sleep(2000);
		
		                home.allErrorAlerts();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		               /* service.clickOnCallStatusButton();
		                service.verifyToGetCallStatus(data.get("CallStatusForSP"));
		                service.getTextOfStatusValue();*/
		                acceptAlert();
		
		                home.logout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		
		
		                /*callIDCreated = crServiceLib.getCallId();
		                spotIDCreated = crServiceLib.getSpotFacilityId();*/
		
		
		
		
		                navigateToApplication("DI");
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                Thread.sleep(10000);
		                //diHome.closeFacilityWindow();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diLogin.waitcloseAllBusyIcons();
		                Thread.sleep(5000);
		                waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
		                click(DIHomePage.tabDiProfile, "Profile Menu Item");
		                diHome.clickOnProfileName(data.get("ProfileName"));
		                Thread.sleep(10000);
		                diHome.verifyActionReqTabOnProfile();
		
		                Thread.sleep(10000);
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(10000);
		                Boolean veriFyCallInActionReq=diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
		                assertTrue(veriFyCallInActionReq, "Call ID with status SP in Required Profile Tab");
		                String currentStatus=diHome.getCallIdStatusOnProfileWindowOfActionReqTab(newCallId, callDateStr);
		                diHome.clickActionReqTabOnProfile();
		                diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
		                Thread.sleep(2000);
		                String troubleCodeBefore=dimcd.captureTroubleCodeInDispatch();
		                String paceSetterCodeBefore=dimcd.capturePaceSetterCodeDispatchSummary();
		
		                dimcd.statusUpdateAsSP(data.get("StatusUpdateSP"));
		                dimcd.statusUpdateAsAS(data.get("StatusUpdateAS"));
		                dimcd.statusUpdateAsDI(data.get("StatusUpdateDI"));
		                dimcd.statusUpdateAsER(data.get("StatusUpdateER"));
		
		                assertFalse(veriFyCallInActionReq, "ER call should not be there in profile");
		                Thread.sleep(120000);
		                assertTrue(veriFyCallInActionReq, "ER call should be there in profile");
		                dimcd.statusUpdateAsOL(data.get("StatusUpdateOL"));
		                Thread.sleep(120000);
		                assertFalse(veriFyCallInActionReq, "OL call should not be there in profile");
		                Thread.sleep(120000);
		                assertTrue(veriFyCallInActionReq, "OL call should be there in profile");
		                dimcd.statusUpdateAsTW(data.get("StatusUpdateTW"));
		                assertFalse(veriFyCallInActionReq, "TOW call should not be there in profile");
		                Thread.sleep(120000);
		                assertTrue(veriFyCallInActionReq, "TOW call should be there in profile");
		                dimcd.statusUpdateAsCL(data.get("StatusUpdateCL"));
		
		
		                dimcd.resolutionCode(data.get("ResolutionCode"),data.get("Reason"), data.get("BatteryInfo"),data.get("ResolutionCode"),data.get("StatusUpdateCL"));
		
		                crHomeLib.allErrorAlerts();
		
		
		               // dimcd.clickPaymentonAPD();
		                dimcd.selectServicesDrpDwnOnPaymentonAPD(data.get("Services"));
		                dimcd.enterCashCollectedOnPaymentonAPD(data.get("CashCollected"));
		                //dimcd.enterServiceCostOnPaymentonAPD(data.get("Amount"));
		                dimcd.clickSaveBtnOnPaymentonAPD();
		                dimcd.clickCloseBtnOnPaymentonAPD();
		               dimcd.statusUpdateAsCL(data.get("StatusUpdateCL"));
		                //String troubleCodeDrpDwn=dimcd.captureTroubleCodeInDropdownDispatch();
		                //String reasonCodeDrpdwn=dimcd.captureReasonDispatchDrpDwn();
		               // assertTrue(troubleCodeBefore.equalsIgnoreCase(troubleCodeDrpDwn), "Expected Trouble Code: " + troubleCodeBefore + "Actual trouble code is " + troubleCodeDrpDwn);
		
		
		                dimcd.clickOnContinue();
		                Thread.sleep(5000);
		                dimcd.clickSubmitBtnOnPaymentonAPD();
		                Thread.sleep(5000);
		                dimcd.labelCallCleared(data.get("StatusUpdateCL"));
		                assertTrue(veriFyCallInActionReq, "CL call should not be there in profile");
		                home.logout();
		                //crDI.dispatchlogout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1743",ReportStatus.strMethodName,intCounter,browser);
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

    public void verifyHSandHCCallStatusOnProfileActionRequired(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyHSandHCCallStatusOnProfileActionRequired", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyHSandHCCallStatusOnProfileActionRequired", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Save Appointment Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib memeber = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		
		
		
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib location = new CRLocationsLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CR_DI crDI = new CR_DI();
		                DIMCDLib dimcd = new DIMCDLib();
		                LoginRoleLib loginRole = new LoginRoleLib();
		                DILoginLib diLogin = new DILoginLib();
		
		
		
		
		
		                navigateToApplication("CR");
		
		                login(data.get("LoginName"), data.get("Password"));
		                home.verifyHomeScreen();
		
		                member.clickOnPartialCallCloseButton();
		                home.messageDialogBoxClose();
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                home.memberSearchTextBox(data.get("Membersearch"));
		
		                memeber.memberNumClick();
		                locations.clickOnLocationTab();
		                locations.clickOnSecondKownBrkDowLocation();
		                vehicle.selectVehicleModel();
		                Thread.sleep(3000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                service.clickOnServiceTab();
		                service.clickOnAppointmentbutton();
		                String currentDate=getCurrentDate();
		                service.enterAppointmentDate(currentDate);
		                String futureTime=getFutureTime();
		                service.enterAppointmentTime(futureTime);
		                Thread.sleep(3000);
		                home.saveButton();
		                 String newHSCallId=service.getCallId();
		                String callDateCreatedHS=service.getCallDate();
		                String callDateStrHS=callDateCreatedHS.replaceAll("-","");
		                service.clickOnRemainInCall();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                service.verifyAppointmentIsReleased();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                service.clickOnCallStatusButton();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                service.clickOnDateColumnInstatustable();
		                service.verifyToGetCallStatus(data.get("CallStatusForHC"));
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                String timeStamp=currentDate+futureTime;
		                service.verifyTimeStamp(timeStamp);
		                home.leaveButton();
		                service.appointmentCallLeaveButton();
		                Thread.sleep(2000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.allErrorAlerts();
		
		                home.memberSearchTextBox(data.get("Membersearch"));
		                memeber.memberNumClick();
		                locations.clickOnLocationTab();
		                locations.clickOnSecondKownBrkDowLocation();
		                vehicle.selectVehicleModel();
		                Thread.sleep(3000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                service.clickOnServiceTab();
		                service.clickOnHold();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                service.enterHold(data.get("hold"));
		                Thread.sleep(2000);
		                service.clickOnHoldDropDown();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		
		                Thread.sleep(4000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.saveButton();
		                Thread.sleep(4000);
		                String newHCCallId=service.getCallId();
		                String callDateCreatedHC=service.getCallDate();
		                String callDateStrHC=callDateCreatedHC.replaceAll("-", "");
		                service.clickOnRemainInCall();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                service.clickOnCallStatusButton();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                service.clickOnDateColumnInstatustable();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                service.verifyToGetCallStatus(data.get("CallStatusForHS"));
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                String timeStamp1=currentDate+futureTime;
		                service.verifyTimeStamp(timeStamp1);
		                home.leaveButton();
		                service.appointmentCallLeaveButton();
		                Thread.sleep(2000);
		                home.allErrorAlerts();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		
		                home.logout();
		                //crDI.dispatchlogout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		
		
		                navigateToApplication("DI");
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                Thread.sleep(10000);
		                //diHome.closeFacilityWindow();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diLogin.waitcloseAllBusyIcons();
		                Thread.sleep(5000);
		                waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
		                click(DIHomePage.tabDiProfile, "Profile Menu Item");
		                diHome.clickOnProfileName(data.get("ProfileName"));
		                diHome.verifyActionReqTabOnProfile();
		                Thread.sleep(10000);
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(10000);
		                Boolean veriFyHCCallInActionReq=diHome.verifyCallIdIsNotOnProfileWindow(newHCCallId, callDateStrHC);
		                assertTrue(veriFyHCCallInActionReq, "Call ID with status HC in Required Profile Tab");
		                Boolean veriFyHSCallInActionReq = diHome.verifyCallIdIsNotOnProfileWindow(newHSCallId, callDateStrHS);
		                assertTrue(veriFyHSCallInActionReq, "Call ID with status HS in Required Profile Tab");
		                diHome.clickToCloseProfileWindow();
		
		                acceptAlert();
		
		
		                home.logout();
		                //crDI.dispatchlogout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1743",ReportStatus.strMethodName,intCounter,browser);
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

    public void verifyBDstatusOnProfileActionRequired(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyBDstatusOnProfileActionRequired", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyBDstatusOnProfileActionRequired", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1743: Action Required Profile Tab "+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib location = new CRLocationsLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CR_DI crDI = new CR_DI();
		                DIMCDLib dimcd = new DIMCDLib();
		                LoginRoleLib loginRole = new LoginRoleLib();
		                DILoginLib diLogin = new DILoginLib();
		
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                member.clickOnPartialCallCloseButton();
		                home.messageDialogBoxClose();
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		
		                location.clickOnLocationTab();
		                Thread.sleep(5000);
		                location.clickOnManualEntryLinkInLocation();
		                Thread.sleep(3000);
		
		                location.enterBlockRange(data.get("StreetNumber2"));
		                String StreetNumber2=getAttributeByValue(CRLocationsPage.txtStreetNumber,"street number 2");
		                Thread.sleep(3000);
		                location.enterBKDownStreetAddress(data.get("StreetAddress2"));
		                String StreetAddress2=getAttributeByValue(CRLocationsPage.txtStreetAddressInput,"street address 2");
		                Thread.sleep(3000);
		                location.enterNorthCrossStreet(data.get("NorthCrossStreet2"));
		                location.enterBKDownCityLocation(data.get("City2"));
		                String city2=getAttributeByValue(CRLocationsPage.txtLocCity,"city 2");
		                Thread.sleep(3000);
		                location.enterBKDownState(data.get("State2"));
		                String State2=getAttributeByValue(CRLocationsPage.txtLocState,"State 2");
		                Thread.sleep(3000);
		                location.enterBKDownLocCode(data.get("LocationCode2"));
		                Thread.sleep(3000);
		                location.enterLocationZip(data.get("ZipCode2"));
		
		                Thread.sleep(3000);
		                vehicle.clickOnVehicleTriageTab();
		                Thread.sleep(3000);
		
		                vehicle.clickOnManualEntryLinkOnVehicle();
		                Thread.sleep(1000);
		                vehicle.enterVehicleType(data.get("ReEnterType"));
		                vehicle.clickOnTheTypeSearchFromDropDown();
		                Thread.sleep(3000);
		                vehicle.enterVehicleYear(data.get("ReEnterYear"));
		                Thread.sleep(2000);
		                vehicle.enterVehicleMake(data.get("ReEnterMake"));
		                vehicle.enterVehicleModel(data.get("ReEnterModel"));
		                vehicle.enterVehicleColor(data.get("Color"));
		                Thread.sleep(3000);
		
		
		                vehicle.clickonProblemTypeButton(data.get("ProblemType7"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType7Option1"));
		                Thread.sleep(2000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                tow.clickOnTowDestinationTab();
		                Thread.sleep(3000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(3000);
		                tow.clickOnManualEntryLinkOnTowDestination();
		                Thread.sleep(3000);
		                tow.enterTowPassengers(data.get("TowPassangers"));
		
		                Thread.sleep(3000);
		
		                service.clickOnServiceTab();
		
		                home.allErrorAlerts();
		
		                Thread.sleep(5000);
		                vehicle.scriptErrorHandle();
		
		                String newFacilityValue=service.validateFacilityAutospotID();
		                //assertTrue(newFacilityValue.contains(data.get("Facility")) , "Facility got respot to" + newFacilityValue);
		                Thread.sleep(4000);
		                crHomeLib.saveButton();
		                Thread.sleep(4000);
		
		
		                facilityId = service.getSpotFacilityId();
		                newCallId = service.getCallId();
		
		                callDateCreated=service.getCallDate();
		
		
		
		
		
		
		                callDateStr=callDateCreated.replaceAll("-","");
		                service.clickOnRemainInCall();
		                Thread.sleep(2000);
		
		                home.allErrorAlerts();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		
		                acceptAlert();
		
		                home.logout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		
		
		                /*callIDCreated = crServiceLib.getCallId();
		                spotIDCreated = crServiceLib.getSpotFacilityId();*/
		
		
		
		
		                navigateToApplication("DI");
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                Thread.sleep(10000);
		                //diHome.closeFacilityWindow();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diLogin.waitcloseAllBusyIcons();
		                Thread.sleep(5000);
		                waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
		                click(DIHomePage.tabDiProfile, "Profile Menu Item");
		                diHome.clickOnProfileName(data.get("ProfileName"));
		                Thread.sleep(10000);
		                diHome.verifyActionReqTabOnProfile();
		
		                Thread.sleep(10000);
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(10000);
		                Boolean veriFyCallInActionReq=diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
		                assertTrue(veriFyCallInActionReq, "Call ID with status SP in Required Profile Tab");
		               // String currentStatus=diHome.getCallIdStatusOnProfileWindowOfActionReqTab(newCallId, callDateStr);
		
		
		                diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
		                Thread.sleep(2000);
		                String troubleCodeBefore=dimcd.captureTroubleCodeInDispatch();
		                String paceSetterCodeBefore=dimcd.capturePaceSetterCodeDispatchSummary();
		
		                dimcd.statusUpdateAsSP(data.get("StatusUpdateSP"));
		                dimcd.statusUpdateAsBD(data.get("StatusUpdateBD"));
		                dimcd.clickOnMCDMinimiseIcon();
		
		                Boolean veriFyBDCallInActionReq=diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
		                assertTrue(veriFyBDCallInActionReq, "Call ID with status BD in Required Profile Tab");
		                diHome.clickToCloseProfileWindow();
		
		                home.logout();
		                //crDI.dispatchlogout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                member.clickOnPartialCallCloseButton();
		                home.messageDialogBoxClose();
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.enterCallIdOnSearchCallsWindow(newCallId);
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                Thread.sleep(3000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(3000);
		                crSearchCall.clickCallIDLinkOnSearchCallsWindow();
		                Thread.sleep(20000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.cancelButton();
		                Thread.sleep(5000);
		                home.ClickOnYesButtonOnConfirmationWindow();
		                Thread.sleep(3000);
		                home.clickOnContinueButtonOnKillCallPopup();
		                home.logout();
		                //crDI.dispatchlogout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		
		
		
		                navigateToApplication("DI");
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                Thread.sleep(10000);
		                //diHome.closeFacilityWindow();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diLogin.waitcloseAllBusyIcons();
		                Thread.sleep(5000);
		                waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
		                click(DIHomePage.tabDiProfile, "Profile Menu Item");
		                diHome.clickOnProfileName(data.get("ProfileName"));
		                Thread.sleep(2000);
		                diHome.verifyActionReqTabOnProfile();
		
		                Thread.sleep(10000);
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(10000);
		                diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
		                Thread.sleep(4000);
		                String getStatus=dimcd.lblCallCAStatus();
		
		              assertTrue(getStatus.equalsIgnoreCase("CA - Cancelled"),"Verify CA status");
		
		
		                acceptAlert();
		                acceptAlert();
		
		                home.logout();
		                //crDI.dispatchlogout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1743",ReportStatus.strMethodName,intCounter,browser);
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

    public void acknowledgeERstatusOnProfileActionRequired(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "acknowledgeERstatusOnProfileActionRequired", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("acknowledgeERstatusOnProfileActionRequired", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1743: Action Required Profile Tab "+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib location = new CRLocationsLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CR_DI crDI = new CR_DI();
		                DIMCDLib dimcd = new DIMCDLib();
		                LoginRoleLib loginRole = new LoginRoleLib();
		                DILoginLib diLogin = new DILoginLib();
		
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                member.clickOnPartialCallCloseButton();
		                home.messageDialogBoxClose();
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		
		
		                location.clickOnLocationTab();
		                location.clickOnManualEntryLinkInLocation();
		                location.enterBlockRange(data.get("StreetNumber1"));
		                String streenNumber = location.getBlockRange();
		                boolean streenNumberValue = streenNumber != null;
		                assertTrue(streenNumberValue,"verified the Streen Number that is entered in Breakdown Location & entered StreenNumber    "+streenNumber);
		                location.enterBKDownStreetAddress(data.get("StreetAddress1"));
		                String streetAddressValue=location.getBKDownStreetAddress();
		                boolean streetAddress = streetAddressValue != null;
		                assertTrue(streetAddress,"Verified the Street Address That is entered in Breakdown Location & entered StreetAddress   "+streetAddressValue);
		                location.enterBKDownCityLocation(data.get("City1"));
		                String cityValue=location.getCityValue();
		                boolean city=cityValue != null;
		                assertTrue(city,"Verified the City That is entered in Breakdown Location & entered city   "+cityValue);
		                location.enterBKDownState(data.get("State1"));
		                String stateValue=location.getStateValue();
		                boolean state = stateValue != null;
		                assertTrue(state,"Verified the State That is entered in Breakdown Location & entered State  "+stateValue);
		                location.enterBKDownLocCode(data.get("LocationCode1"));
		                String locationCodeValue=location.getLocationCode();
		                boolean locationCode=locationCodeValue != null;
		                assertTrue(locationCode,"Verified the Location Code that is entered in Breakdown Location & entered LocationCode   "+locationCodeValue);
		                vehicle.clickOnVehicleTriageTab();
		                vehicle.selectExistingVehicleModel();
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeButton(data.get("ProblemType1"));
		                Thread.sleep(3000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
		                service.clickOnServiceTab();
		                Thread.sleep(3000);
		               // service.validateNoFacilityAutoSpot();
		                Thread.sleep(2000);
		                home.saveButton();
		                home.allErrorAlerts();
		                newCallId = service.getCallId();
		
		                callDateCreated=service.getCallDate();
		
		
		                callDateStr=callDateCreated.replaceAll("-","");
		
		                service.clickOnRemainInCall();
		                Thread.sleep(2000);
		
		                home.allErrorAlerts();
		              /*  service.clickOnCallStatusButton();
		                service.verifyToGetCallStatus(data.get("CallStatusForRE"));
		                service.getTextOfStatusValue();*/
		
		                home.logout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		
		                /*callIDCreated = crServiceLib.getCallId();
		                spotIDCreated = crServiceLib.getSpotFacilityId();*/
		
		
		
		
		                navigateToApplication("DI");
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                Thread.sleep(10000);
		                //diHome.closeFacilityWindow();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diLogin.waitcloseAllBusyIcons();
		                Thread.sleep(5000);
		                waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
		                click(DIHomePage.tabDiProfile, "Profile Menu Item");
		                diHome.clickOnProfileName(data.get("ProfileName"));
		                diHome.verifyActionReqTabOnProfile();
		                Thread.sleep(4000);
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(60000);
		                diHome.clickCallIdOnProfileWindow(newCallId, callDateStr);
		                Thread.sleep(2000);
		                dimcd.statusUpdateAsSP(data.get("StatusUpdateSP"));
		                dimcd.statusUpdateAsAS(data.get("StatusUpdateAS"));
		                dimcd.statusUpdateAsDI(data.get("StatusUpdateDI"));
		                dimcd.statusUpdateAsER(data.get("StatusUpdateER"));
		
		                dimcd.clickAckOnMCDwindow();
		                Thread.sleep(2000);
		                dimcd.clickOnMCDMinimiseIcon();
		                Thread.sleep(2000);
		                Boolean veriFyCallInActionReq=diHome.verifyCallIdIsNotOnProfileWindow(newCallId, callDateStr);
		                assertTrue(veriFyCallInActionReq, "Call ID with status ER in Required Profile Tab");
		                diHome.clickToCloseProfileWindow();
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1743",ReportStatus.strMethodName,intCounter,browser);
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

    public void ERstatusWithCommentsOnProfileActionRequired(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"ERstatusWithCommentsOnProfileActionRequired", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ERstatusWithCommentsOnProfileActionRequired", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1743: Action Required Profile Tab "+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib location = new CRLocationsLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CR_DI crDI = new CR_DI();
		                DIMCDLib dimcd = new DIMCDLib();
		                LoginRoleLib loginRole = new LoginRoleLib();
		                DILoginLib diLogin = new DILoginLib();
		
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                member.clickOnPartialCallCloseButton();
		                home.messageDialogBoxClose();
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.enterStatusOnSearchCallsWindow(data.get("SearchStatus"));
		                //crSearchCall.enterCallIdOnSearchCallsWindow(newCallId);
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                Thread.sleep(3000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(3000);
		                crSearchCall.clickOnFirstRowInSearchCalls();
		                Thread.sleep(20000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.saveButton();
		                service.getTextAndClickOnYesInSpStatusPopup();
		                Thread.sleep(2000);
		                service.verifyUpdateCallStatus();
		
		                service.enterInCommentStatus(data.get("commentStatusUpdate1"));
		                Thread.sleep(2000);
		                //service.verifyUpdateIsNotClikable();
		                Thread.sleep(2000);
		                service.enterInResonForStatusStatus(data.get("statusReason1"));
		                service.clickOnComment();
		                //service.verifyUpdateIsNowClikable();
		                Thread.sleep(2000);
		                home.allErrorAlerts();
		                service.clickUpdateButton();
		                Thread.sleep(2000);
		                newCallId = service.getCallId();
		
		                callDateCreated=service.getCallDate();
		
		
		                callDateStr=callDateCreated.replaceAll("-","");
		                service.clickOnRemainInCall();
		                home.allErrorAlerts();
		                home.allErrorAlerts();
		                home.logout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		
		                navigateToApplication("DI");
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                Thread.sleep(10000);
		                //diHome.closeFacilityWindow();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diLogin.waitcloseAllBusyIcons();
		                Thread.sleep(5000);
		                waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
		                click(DIHomePage.tabDiProfile, "Profile Menu Item");
		                diHome.clickOnProfileName(data.get("ProfileName"));
		                diHome.verifyActionReqTabOnProfile();
		                Thread.sleep(4000);
		                diHome.clickActionReqTabOnProfile();
		                Thread.sleep(60000);
		
		                Boolean veriFyCallInActionReq=diHome.verifyCallIdOnProfileWindow(newCallId, callDateStr);
		                assertTrue(veriFyCallInActionReq, "Call ID with status RE in Required Profile Tab");
		                diHome.clickToCloseProfileWindow();
		
		
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1743",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }




    public String getCurrentDate(){
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String currentdate=sdf.format(date);
        return currentdate;
    }
    public String getFutureTime(){
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = new Date(System.currentTimeMillis()+3*60*1000);
        String futureTime=sdf.format(date);
        return futureTime;

    }
    public String getNextDay(String curDate)throws Exception{
        final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        final Date date = format.parse(curDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return format.format(calendar.getTime());
    }







}
