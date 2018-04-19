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


public class TC_DICashCalClearing extends DILoginLib {
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String level;
    public static String levelMCD;
    public static String reasonCode;
    public static Boolean towAvailablity;
    public static int totalnumberOfSpecialEquipment;


    

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void clearCashCalls(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "clearCashCall", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("clearCashCall", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("2015: TC-DI Cash Call Clearing"+ " From Iteration " + StartRow + " to " + EndRow );
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
		                level= member.memberLevelVerification();
		                locations.breakdownLocTabSel();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		                Thread.sleep(2000);
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		                Thread.sleep(2000);
		                //locations.clickOnLocationCodeDropDown();
		                Thread.sleep(5000);
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
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("ProblemType"));
		                Thread.sleep(2000);
		                crHomeLib.allErrorAlerts();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		
		                towAvailablity=tow.verifyTowDestinationTabAvailablity();
		                if(towAvailablity) {
		                    tow.clickOnTowDestinationTab();
		                    crHomeLib.allErrorAlerts();
		                    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                    tow.clickOnManualEntryLinkOnTowDestination();
		                    tow.enterTowPassengers(data.get("towPassangers"));
		                }
		                services.clickOnServiceTab();
		                services.clickOnCashOnServiceTab();
		                home.saveButton();
		                //getText(CRServicePage.lblscriptErorrMessage,"Script Error");
		                home.allErrorAlerts();
		               // member.confirmationAlert();
		                callID=services.getCallId();
		                services.closeCall();
		                home.allErrorAlerts();
		                home.logout();
		
		                navigateToApplication("DI");
		                waitcloseAllBusyIcons();
		                waitcloseAllBusyIcons();
		                login(data.get("DILoginName"),data.get("Password"));
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseButtonOnQueueWindow();
		                diHome.clickOnSearchCallsLink();
		                diHome.enterCallIDInfo(callID);
		                diHome.clickOnSearchInSearchCalls();
		                diSearchCalls.selectSPStatusRowInSearchCallDispatch();
		                pacesetterCode = diMCD.getPaceSetterCodeOnSummaryTab();
		                Thread.sleep(3000);
		                /*levelMCD=diMCD.getMemberLevelOnSummaryTab();
		                assertTrue(level.equalsIgnoreCase(levelMCD),"Member ship is same");
		                */String currentPaceCode[] = pacesetterCode.split("-");
		                String paceSetterCode = currentPaceCode[0]; //facilityname
		                assertTrue(data.get("ProblemType").contains(paceSetterCode),"pacesetter code that we  selected populates the reason code based on the mapping");
		                troubleCode=diMCD.getTroubleCodeOnSummaryTab();
		                assertTrue(troubleCode.contains(data.get("TroubleCode"))," trouble code displays based on the mapping");
		                diMCD.clearCallID(data.get("clearType"),data.get("TowConfirmation"),data.get("DITowConfComments"),data.get("DITowConfEnterAddress"),data.get("MCDLocationAddress"), data.get("MCDcrossStreet"), data.get("MCDsecondCrossStreet"), data.get("MCDCity"),data.get("DITowConfEnterOtherAddress"),data.get("reason"));
		                diMCD.clickOnStatusHistoryLinkOnMCDWindow();
		                reasonCode =diMCD.getResaonCodeForClearedCallInMCDWindow();
		                diMCD.clickOnCloseIconOnHistoryStatus();
		                diMCD.clickOnMCDCloseWindow();
		                reporter.SuccessReport("PaceSetter Code","The Pacesetter Code is "+paceSetterCode);
		                reporter.SuccessReport("Trouble Code","The Trouble Code is "+troubleCode);
		                reporter.SuccessReport("Reason Code","Reason code is "+reasonCode);
		                diHome.logOut();
		                Thread.sleep(5000);
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2015",ReportStatus.strMethodName,intCounter,browser);
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