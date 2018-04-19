package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E003999 on 01-02-2018.
 */
public class TC_DICallClearingBatteryService extends DILoginLib {
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String level;
    public static String levelMCD;
    public static int totalnumberOfSpecialEquipment;

   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void clearCallBatteryServices(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "clearCallBatteryServices", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("clearCallBatteryServices", TestData, "D3Dispatch",intCounter);
    	
			                this.reporter.initTestCaseDescription("1995: TC-DI Call Clearing Battery Service"+ " From Iteration " + StartRow + " to " + EndRow );
			                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			                CRHomeLib home = new CRHomeLib();
			                LoginRoleLib role = new LoginRoleLib();
			                DIHomeLib diHome = new DIHomeLib();
			                CRHomeLib crHomeLib = new CRHomeLib();
			                CRMemberSearchLib member = new CRMemberSearchLib();
			                CRLocationsLib locations = new CRLocationsLib();
			                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
			                CRServiceLib services = new CRServiceLib();
			                CRTowDestinationLib tow = new CRTowDestinationLib();
			                CR_DI crDI = new CR_DI();
			                DISearchCallsLib diSearchCalls = new DISearchCallsLib();
			                DIMCDLib diMCD = new DIMCDLib();
			                CommonLib commonLib=new CommonLib();
			                navigateToApplication("CR");
			                login(data.get("CRLoginName"), data.get("Password"));
			                waitcloseAllBusyIcons();
			                home.messageDialogBoxClose();
			                commonLib.crMemberSearchTab(data.get("Member"),data.get("Membersearch"),data.get("dbServer"),data.get("dbqueryFileName"), data.get("colomnName"),data.get("PhoneNumber"),data.get("Primaryphonenum1"));
			                level = member.memberLevelVerification();
			                locations.breakdownLocTabSel();
			                locations.clickOnManualEntryLinkInLocation();
			                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
			                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
			                Thread.sleep(2000);
			                locations.enterBKDownLocCode(data.get("LocationCode"));
			                crVehicleTriageLib.clickOnVehicleTriageTab();
			                crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
			                Thread.sleep(1000);
			                crVehicleTriageLib.enterVehicleType(data.get("ReEnterType"));
			                crVehicleTriageLib.clickOnTheTypeSearchFromDropDown();
			                Thread.sleep(3000);
			                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			                crVehicleTriageLib.getMoreInfoTab();
			                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			                Thread.sleep(2000);
			                crVehicleTriageLib.enterVehicleYear(data.get("ReEnterYear"));
			                Thread.sleep(2000);
			                crVehicleTriageLib.enterVehicleMake(data.get("ReEnterMake"));
			                crVehicleTriageLib.enterVehicleModel(data.get("ReEnterModel"));
			                crVehicleTriageLib.enterVehicleColor(data.get("Color"));
			
			                Thread.sleep(3000);
			                if (data.get("ClearType").equalsIgnoreCase("GO")) {
			                    crVehicleTriageLib.enterPaceSetterCodeManually(data.get("ProblemType"));
			                    crHomeLib.allErrorAlerts();
			                    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			                    home.allErrorAlerts();
			                    home.allErrorAlerts();
			                    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			                    Thread.sleep(3000);
			                    home.saveButton();
			                    // member.confirmationAlert();
			                    Thread.sleep(3000);
			                    callID = services.getCallId();
			                    services.closeCall();
			                    home.allErrorAlerts();
			                    home.logout();
			                    acceptAlert();
			                    acceptAlert();
			                } else {
			                    crVehicleTriageLib.enterPaceSetterCodeManually(data.get("ProblemType"));
			                    Thread.sleep(2000);
			                    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			                    Thread.sleep(1000);
			                    boolean towTab = tow.verifyTowDestinationTabAvailablity();
			                    if (towTab) {
			                        tow.clickOnTowDestinationTab();
			                        Thread.sleep(3000);
			                        crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			                        Thread.sleep(3000);
			                        tow.clickOnManualEntryLinkOnTowDestination();
			                        Thread.sleep(3000);
			                        tow.enterTowLocationName(data.get("TDLocationAddress"));
			                        tow.enterFirstCrossStreet(data.get("TDcrossStreet"));
			                        tow.enterSecondCrossStreet(data.get("TDsecondCrossStreet"));
			                        tow.enterCityCodeInTow(data.get("TDCity"));
			                        tow.enterStateInTow(data.get("TDState"));
			                        tow.enterLandMarkInTow(data.get("TDLandMark"));
			                        tow.enterTowPassengers(data.get("Towpassengers"));
			                    }
			                    Thread.sleep(3000);
			                    home.saveButton();
			                    home.allErrorAlerts();
			                    callID = services.getCallId();
			                    services.closeCall();
			                    home.logout();
			                    acceptAlert();
			                    acceptAlert();
			
			                }
			
			                navigateToApplication("DI");
			                waitcloseAllBusyIcons();
			                waitcloseAllBusyIcons();
			                login(data.get("DILoginName"), data.get("Password"));
			                role.clickOnProceedBtnInDispatchRoleLogin();
			                waitcloseAllBusyIcons();
			                diHome.clickOnCloseIconOnQueueSelection();
			                diHome.clickOnSearchCallsInDispatch();
			                diHome.searchAndSelectCallIDInDI(callID);
			                Thread.sleep(3000);
			                if (data.get("ClearType").equalsIgnoreCase("GO")) {
			                    pacesetterCode = diMCD.getPaceSetterCodeOnSummaryTab();
			                    Thread.sleep(3000);
			                    levelMCD = diMCD.getMemberLevelOnSummaryTab();
			                    assertTrue(level.equalsIgnoreCase(levelMCD), "Member ship is same");
			                    String currentPaceCode[] = pacesetterCode.split("-");
			                    String paceSetterCode = currentPaceCode[0]; //facilityname
			                    assertTrue(data.get("ProblemType").contains(paceSetterCode), "pacesetter code that we  selected populates the reason code based on the mapping");
			                    //assertTrue(data.get("TroubleCode").contains(paceSetterCode), "pacesetter code that we  selected populates the reason code based on the mapping");
			                    troubleCode = diMCD.getTroubleCodeOnSummaryTab();
			                    assertTrue(troubleCode.contains(data.get("TroubleCode")), " trouble code displays based on the mapping");
			                    //diMCD.clearCallID(data.get("clearType"), data.get("TowConfirmation"), data.get("DITowConfComments"), data.get("DITowConfEnterAddress"), data.get("MCDLocationAddress"), data.get("MCDcrossStreet"), data.get("MCDsecondCrossStreet"), data.get("MCDCity"), data.get("DITowConfEnterOtherAddress"));
			                    diMCD.selectClearCall();
			                    diMCD.selectExitCode();
			                    diMCD.enterReason(data.get("Reason"));
			                    diMCD.clickOnContinue();
			                    //diMCD.batteyInfo(data.get("BatteryInfo"), data.get("ODOMeterreading"), data.get("BatteryComments"));
			                    diMCD.clickAndEnterBatteryInformation(data.get("ODOMeterreading"), data.get("BatteryComments"), data.get("TestCode"), data.get("BatteryType"), data.get("BatteryPrice"));
			                    diMCD.clickOnSubmitButton();
			                    Thread.sleep(5000);
			                    diMCD.getCallStatusOnMCDwindow();
			                    diHome.logOut();
			                    acceptAlert();
			                    acceptAlert();
			                } else {
			                    pacesetterCode = diMCD.getPaceSetterCodeOnSummaryTab();
			                    Thread.sleep(3000);
			                    levelMCD = diMCD.getMemberLevelOnSummaryTab();
			                    assertTrue(level.equalsIgnoreCase(levelMCD), "Member ship is same");
			                    String currentPaceCode[] = pacesetterCode.split("-");
			                    String paceSetterCode = currentPaceCode[0]; //facilityname
			                    assertTrue(data.get("ProblemType").contains(paceSetterCode), "pacesetter code that we  selected populates the reason code based on the mapping");
			                    //assertTrue(data.get("TroubleCode").contains(paceSetterCode), "pacesetter code that we  selected populates the reason code based on the mapping");
			                    troubleCode = diMCD.getTroubleCodeOnSummaryTab();
			                    assertTrue(troubleCode.contains(data.get("TroubleCode")), " trouble code displays based on the mapping");
			                    diMCD.clickOnAssign();
			                    diMCD.selectSecondFacilityOnAssignTabInMCD();
			                    diMCD.selectDispatch();
			                    diMCD.selectEnroute();
			                    diMCD.selectEnrouteTime();
			                    diMCD.selectClearCall();
			                    diMCD.clickOnNoGo();
			                    diMCD.selectExitCode();
			                    diMCD.enterReason(data.get("Reason"));
			                    diMCD.clickOnContinue();
			                    boolean originalTowDestination = diMCD.verifyOriginalTowDestination();
			                    if (originalTowDestination) {
			                        diMCD.clickOnOriginalTowDestination();
			                        boolean addressVerified = diMCD.verifyAddressverifiedIconOnOriginalTowDestinationTab();
			                        assertTrue(addressVerified, "Address ");
			                    } else {
			                        diMCD.clickOnNoTowPerformed();
			                    }
			                    diMCD.clickOnContinue();
			                    Thread.sleep(3000);
			                    diMCD.clickAndEnterBatteryInformation(data.get("ODOMeterreading"), data.get("BatteryComments"), data.get("TestCode"), data.get("BatteryType"), data.get("BatteryPrice"));
			                    // diMCD.batteyInfo(data.get("BatteryInfo"),data.get("ODOMeterreading"),data.get("BatteryComments"));
			                    diMCD.clickOnSubmitButton();
			                    Thread.sleep(5000);
			                    diMCD.getCallStatusOnMCDwindow();
			                    diHome.logOut();
			                    acceptAlert();
			                    acceptAlert();
			                }
    					}	
			    			catch(Exception e)
			    			{
			    				ReportStatus.blnStatus=false;
			    			}
			    			ReportControl.fnEnableJoin();
			    			ReportStatus.fnUpdateResultStatus("DI","1995",ReportStatus.strMethodName,intCounter,browser);
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

