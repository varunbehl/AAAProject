package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRMemberSearchPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by e002222 on 29-01-2018.
 */
public class TC_DICallClearingRAP extends DILoginLib {

    String callIDCallReceiving;
    String callIDDispatch;
    public static long ran;
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String reasonCode;

  

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void clearCallRAP(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "clearCallRAP", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("clearCallRAP", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1915: DI Call Clearing RAP "+ " From Iteration " + StartRow + " to " + EndRow );
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
		                DISearchCallsLib diSearchCalls = new DISearchCallsLib();
		                CR_DI crDI = new CR_DI();
		                DIMCDLib dimcd = new DIMCDLib();
		                LoginRoleLib loginRole=new LoginRoleLib();
		                DILoginLib diLogin = new DILoginLib();
		
		
		
		                //navigateToApplication("CR");
		                login(data.get("CRLoginName"), data.get("Password"));
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                home.verifyHomeScreen();
		                home.workFlowSelectionForRAP();
		                member.verifyIsRapWorkFlowSet();
		                member.enterDataInClubCode(data.get("clubCode"));
		                member.clickOnClubClodeSuggestedOption();
		                ran=generateRandomNumber();
		                member.mandatoryFieldsForRAPCall(data.get("firstName"),data.get("lastName"),ran,data.get("paymentCode"));
		                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("phoneNumber"));
		                member.selectType(data.get("phoneType"));
		                member.clickPrimRadioBtnRowOne();
		                locations.clickOnLocationTab();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		                /*Thread.sleep(2000);
		                locations.clickOnLocationCodeDropDown();*/
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
		                Thread.sleep(1000);
		                crVehicleTriageLib.enterVehicleType(data.get("ReEnterType"));
		                crVehicleTriageLib.clickOnTheTypeSearchFromDropDown();
		                Thread.sleep(3000);
		                crVehicleTriageLib.enterVehicleYear(data.get("ReEnterYear"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.enterVehicleMake(data.get("ReEnterMake"));
		                crVehicleTriageLib.enterVehicleModel(data.get("ReEnterModel"));
		                crVehicleTriageLib.enterVehicleColor(data.get("Color"));
		                Thread.sleep(3000);
		                crVehicleTriageLib.clickOnFlatTire();
		                crVehicleTriageLib.clickOnAirOnlyOptionInFlatTyreType();
		                Thread.sleep(5000);
		                tow.clickOnTowDestinationTab();
		                Thread.sleep(5000);
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(1000);
		                tow.clickOnManualEntryLinkOnTowDestination();
		                tow.enterTowPassengers(data.get("Towpassengers"));
		                Thread.sleep(2000);
		                services.clickOnServiceTab();
		                services.getFacilityType();
		                home.saveButton();
		                Thread.sleep(1000);
		                callID = services.getCallId();
		                services.closeCall();
		                Thread.sleep(4000);
		                home.logout();
		                acceptAlert();
		
		
		                navigateToApplication("DI");
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                //Thread.sleep(10000);
		                //diHome.closeFacilityWindow();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diLogin.waitcloseAllBusyIcons();
		                //Thread.sleep(5000);
		
		                diHome.clickOnSearchCallsLink();
		                //diHome.enterCallIDInfo(callID);
		
		                diHome.enterCallIDInfo(callID);
		                diHome.clickOnSearchInSearchCalls();
		                diSearchCalls.selectSPStatusRowInSearchCallDispatch();
		                dimcd.paymentForRAPCall(data.get("cost"),data.get("cashCollected"),data.get("serviceType"),data.get("towServiceType"));
		
		                pacesetterCode = dimcd.getPaceSetterCodeOnSummaryTab();
		                Thread.sleep(3000);
		                String currentPaceCode[] = pacesetterCode.split("-");
		                String paceSetterCode = currentPaceCode[0]; //facilityname
		                assertTrue(data.get("ProblemType").contains(paceSetterCode),"pacesetter code that we  selected populates the reason code based on the mapping");
		                troubleCode=dimcd.getTroubleCodeOnSummaryTab();
		                assertTrue(troubleCode.contains(data.get("TroubleCode"))," trouble code displays based on the mapping");
		                dimcd.clearCallID(data.get("clearType"),data.get("TowConfirmation"),data.get("DITowConfComments"),data.get("DITowConfEnterAddress"),data.get("MCDLocationAddress"), data.get("MCDcrossStreet"), data.get("MCDsecondCrossStreet"), data.get("MCDCity"),data.get("DITowConfEnterOtherAddress"),data.get("Reason"));
		                //dimcd.clickOnStatusHistoryLinkOnMCDWindow();
		                //reasonCode =dimcd.getResaonCodeForClearedCallInMCDWindow();
		                //dimcd.clickOnCloseIconOnHistoryStatus();
		                dimcd.clickOnMCDCloseWindow();
		                reporter.SuccessReport("PaceSetter Code","The Pacesetter Code is "+paceSetterCode);
		                reporter.SuccessReport("Trouble Code","The Trouble Code is "+troubleCode);
		                //reporter.SuccessReport("Reason Code","Reason code is "+reasonCode);
		                diHome.logOut();
		                Thread.sleep(5000);
		                acceptAlert();
		                acceptAlert();
		                Thread.sleep(1000);
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1915",ReportStatus.strMethodName,intCounter,browser);
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
