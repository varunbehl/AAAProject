package com.aaa.web.script;


import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DIMCDRAPCallsDataPoints extends ActionEngine {


    public static long ran;


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

    public void diMCDRAPCallsDataPoints(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMCDRAPCallsDataPoints", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMCDRAPCallsDataPoints", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1818-DI MCD RAP Calls DataPoints"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRServiceLib services = new CRServiceLib();
		                DIHomeLib diHome = new DIHomeLib();
		                DIMCDLib diMCD = new DIMCDLib();
		                DILoginLib diLogin = new DILoginLib();
		                LoginLib login = new LoginLib();
		                LoginRoleLib loginRole = new LoginRoleLib();
		
		                home.verifyandClickLogout();
		                navigateToApplication("CR");
		                login.login(data.get("CrLogin"), data.get("CrPassword"));
		                home.verifyHomeScreen();
		                home.workFlowSelectionForRAP();
		                member.verifyIsRapWorkFlowSet();
		                member.enterDataInClubCode(data.get("clubCode"));
		                member.clickOnClubClodeSuggestedOption();
		                ran = generateRandomNumber();
		                member.mandatoryFieldsForRAPCall(data.get("firstName"), data.get("lastName"), ran, data.get("paymentCode"));
		                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("phoneNumber"));
		                member.selectType(data.get("phoneType"));
		                member.clickPrimRadioBtnRowOne();
		                locations.clickOnLocationTab();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterBreakDownLocationMandatoryFields(data.get("Address"));
		               /* Thread.sleep(2000);
		                locations.clickOnLocationCodeDropDown();*/
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
		                Thread.sleep(1000);
		                crVehicleTriageLib.enterVehicleType(data.get("VehicleType"));
		                crVehicleTriageLib.clickOnTheTypeSearchFromDropDown();
		                Thread.sleep(3000);
		                crVehicleTriageLib.enterVehicleYear(data.get("VehicleYear"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.enterVehicleMake(data.get("VehicleMake"));
		                crVehicleTriageLib.enterVehicleModel(data.get("VehicleModel"));
		                crVehicleTriageLib.enterVehicleColor(data.get("VehicleColor"));
		                Thread.sleep(3000);
		                crVehicleTriageLib.clickOnRAPTabOnVehicleTriage();
		                crVehicleTriageLib.enterVINForRAPOnVehicleTriage(data.get("Vin"));
		                crVehicleTriageLib.clickonProblemTypeButton(data.get("ProblemType7"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.clickonProblemTypeOptions(data.get("ProblemType7Option1"));
		                Thread.sleep(5000);
		                tow.clickOnTowDestinationTab();
		                Thread.sleep(5000);
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(1000);
		                tow.clickOnManualEntryLinkOnTowDestination();
		                tow.enterTowLocationName(data.get("TDLocationAddress"));
		                tow.enterFirstCrossStreet(data.get("TDcrossStreet"));
		                tow.enterSecondCrossStreet(data.get("TDsecondCrossStreet"));
		                tow.enterCityCodeInTow(data.get("TDCity"));
		                tow.enterStateInTow(data.get("TDState"));
		                tow.enterLandMarkInTow(data.get("TDLandMark"));
		                tow.enterTowPassengers(data.get("TowPassangers"));
		                Thread.sleep(2000);
		                services.clickOnServiceTab();
		                services.getFacilityType();
		                home.saveButton();
		                Thread.sleep(1000);
		                String callID = services.getCallId();
		                services.closeCall();
		                Thread.sleep(4000);
		                home.logout();
		                navigateToApplication("DI");
		                login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                diLogin.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.searchAndSelectCallIDInDI(callID);
		                boolean firstNameOnSummaryTab = diMCD.verifyMemberFirstNameOnSummaryTab();
		                assertTrue(firstNameOnSummaryTab, "Member First Name is Listed");
		                boolean lastNameOnSummaryTab = diMCD.verifyMemberLastNameOnSummaryTab();
		                assertTrue(lastNameOnSummaryTab, "Member Last Name is Listed");
		                boolean breakdownLocationOnSummaryTab = diMCD.verifyBreakDownLocationOnSummaryTab();
		                assertTrue(breakdownLocationOnSummaryTab, "BreakDown Location is Listed");
		                boolean vehicleYearOnSummaryTab = diMCD.verifyVehicleYearOnSummaryTab();
		                assertTrue(vehicleYearOnSummaryTab, "Vehicle year is Listed");
		                boolean vehicleMakeOnSummaryTab = diMCD.verifyVehicleMakeOnSummaryTab();
		                assertTrue(vehicleMakeOnSummaryTab, "Vehicle Make is Listed");
		                boolean vehicleModelOnSummaryTab = diMCD.verifyVehicleModelOnSummaryTab();
		                assertTrue(vehicleModelOnSummaryTab, "Vehicle Model is Listed");
		                boolean vehicleColorOnSummaryTab = diMCD.verifyVehicleColorOnSummaryTab();
		                assertTrue(vehicleColorOnSummaryTab, "Vehicle color is Listed");
		                boolean pacesetterCodeOnSummaryTab = diMCD.verifyPaceSetterCodeOnSummaryTab();
		                assertTrue(pacesetterCodeOnSummaryTab, "Pacesettercode is Listed");
		                boolean troubleCodeOnSummaryTab = diMCD.verifyTroubleCodeOnSummaryTab();
		                assertTrue(troubleCodeOnSummaryTab, "Trouble code is Listed");
		                boolean functioCodeOnSummaryTab = diMCD.verifyFunctionCodeOnSummaryTab();
		                assertTrue(functioCodeOnSummaryTab, "FunctionCode is Listed");
		                boolean facilityIdAndNameOnSummaryTab = diMCD.verifyFaclityIdandNameOnSummaryTab();
		                assertTrue(facilityIdAndNameOnSummaryTab, "Facility Id and Name is Listed");
		                boolean truckLoadButtonOnSummaryTab = diMCD.verifyTruckLoadButtonOnSummaryTab();
		                assertTrue(truckLoadButtonOnSummaryTab, "truck load button is Listed");
		                diMCD.clickOnMemberTabInMCDWindow();
		                boolean memberFirstNameOnmemberTab = diMCD.verifyMemberFirstNameOnMemberTab();
		                assertTrue(memberFirstNameOnmemberTab, "Member First Name is Listed");
		                boolean memberLastNameOnmemberTab = diMCD.verifyMemberLastNameOnMemberTab();
		                assertTrue(memberLastNameOnmemberTab, "Member Last Name is Listed");
		                boolean memberClubCodeOnmemberTab = diMCD.verifyMemberClubCodeForRAPCall();
		                assertTrue(memberClubCodeOnmemberTab, "Member Club Code is Listed");
		                boolean memberPhoneNumberOnmemberTab = diMCD.verifyMemberPhoneNumberOnMemberTab();
		                assertTrue(memberPhoneNumberOnmemberTab, "Member Phone Number is Listed");
		                boolean LanguagePreferenceOnmemberTab = diMCD.verifyLanguagepreferenceOnMemberTab();
		                assertTrue(LanguagePreferenceOnmemberTab, "Language Preference is Listed");
		                boolean ShowBatteryServiceHistoryButtonForRAPCall = diMCD.verifyShowBatteryServiceHistoryButtonForRAPCall();
		                assertTrue(ShowBatteryServiceHistoryButtonForRAPCall, "Show Battery Service History Button For RAP Call is Listed");
		                diMCD.clickOnServiceTabInMCDWindow();
		                boolean pacesetterCodeOnServiceTab = diMCD.verifyPacesetterCodeOnServiceTab();
		                assertTrue(pacesetterCodeOnServiceTab, "Pacesetter Code is Listed");
		                boolean troubleCodeOnServiceTab = diMCD.verifyTroubleCodeOnServiceTab();
		                assertTrue(troubleCodeOnServiceTab, "Trouble Code is Listed");
		                boolean serviceTypeOnServiceTab = diMCD.verifyServiceTypeinfoOnServiceTab();
		                assertTrue(serviceTypeOnServiceTab, "Service type info is Listed");
		                boolean ShowDuplicateCallHistoryButtonForRAPCall = diMCD.verifyShowDuplicateCallHistoryButtonForRAPCall();
		                assertTrue(ShowDuplicateCallHistoryButtonForRAPCall, "Show Duplicate Call History Button For RAP Call is Listed");
		                boolean facilityNameAndnumberOnServiceTabOnServiceTab = diMCD.verifyFacilityNameAndnumberOnServiceTab();
		                assertTrue(facilityNameAndnumberOnServiceTabOnServiceTab, "Facility Name And Number is Listed");
		                boolean FunctionCodeOnServiceTab = diMCD.verifyFunctionCodeOnServiceTab();
		                assertTrue(FunctionCodeOnServiceTab, "FunctionCode On Service Tab is Listed");
		                boolean TruckLoadButtonOnServiceTab = diMCD.verifyTruckLoadButtonOnServiceTab();
		                assertTrue(TruckLoadButtonOnServiceTab, "TruckLoadButton On Service Tab is Listed");
		                boolean Vin=diMCD.verifyVehicleVinOnServiceTabForRAPCall();
		                assertTrue(Vin,"Vin is Listed");
		                boolean odometer=diMCD.verifyVehicleOdometerOnServiceTabForRAPCall();
		                assertTrue(odometer,"Odometer is Listed");
		                boolean isRAPOnly=diMCD.verifyVehicleIsRAPOnlyOnServiceTabForRAPCall();
		                assertTrue(isRAPOnly,"Is RAP Only is Listed");
		                boolean rapEDSNumber=diMCD.verifyVehicleRAPEDSNumberOnServiceTabForRAPCall();
		                assertTrue(rapEDSNumber,"RAP EDS is Listed");
		                diMCD.clickOnLocationsTabInMCDWindow();
		                boolean breakDownLocationOnLocationsTab = diMCD.verifyBreakDownLocationOnLocationsTab();
		                assertTrue(breakDownLocationOnLocationsTab, "BreakDown Location Address is Listed");
		                boolean towDestinationOnLocationsTab = diMCD.verifyTowDestinationForRAPCall();
		                assertTrue(towDestinationOnLocationsTab, "Tow Destination is Listed");
		                diMCD.clickOnVehicleTabInMCDWindow();
		                boolean vehicleYearOnVehicleTab = diMCD.verifyVehicleYearOnVehicleTab();
		                assertTrue(vehicleYearOnVehicleTab, "Vehicle Year is Listed");
		                boolean vehicleMakeOnVehicleTab = diMCD.verifyVehicleMakeOnVehicleTab();
		                assertTrue(vehicleMakeOnVehicleTab, "Vehicle Make is Listed");
		                boolean vehicleModelOnVehicleTab = diMCD.verifyVehicleModelOnVehicleTab();
		                assertTrue(vehicleModelOnVehicleTab, "Vehicle Model is Listed");
		                boolean vehicleColorOnVehicleTab = diMCD.verifyVehicleColorOnVehicleTab();
		                assertTrue(vehicleColorOnVehicleTab, "Vehicle Color is Listed");
		                boolean vehicleTypeOnVehicleTab = diMCD.verifyVehicleTypeOnVehicleTab();
		                assertTrue(vehicleTypeOnVehicleTab, "Vehicle Type is Listed");
		                boolean RAPIcon = diMCD.verifyRAPIconOnServiceTabForRAPCall();
		                assertTrue(RAPIcon, "RAP ICON is Listed");
		                diHome.logOut();
		
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1818",ReportStatus.strMethodName,intCounter,browser);
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
