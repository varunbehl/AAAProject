package com.aaa.e2e.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.accelerators.TestEngineWeb;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.script.TC_CRSaveAppointmentCall;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class RAP_DI extends LoginLib
{
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String callDateCreated;
    public static String callIDAndDateCombined;
    public static String [] callandfacilityId = new String[3];
    public static long ranRAPID;

    CRLocationsLib crLocationsLib =new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
    CRServiceLib crServiceLib = new CRServiceLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRTowDestinationLib crTowDestinationLib = new CRTowDestinationLib();
    DIMCDLib dimcdLib = new DIMCDLib();
    DIHomeLib diHomeLib = new DIHomeLib();
    CommonLib commonLib=new CommonLib();

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void RAPDIEnd2End(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "RAPDI", TestData, "e2eRAPDI");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("RAPDI", TestData, "e2eRAPDI",intCounter);
		
    					TestEngineWeb.reporter.initTestCaseDescription("RAP DI End to End"+ " From Iteration " + StartRow + " to " + EndRow );
            			reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
	    		        callReceivingLogin(data);
		                crRAPTab(data);
		                crVehicleTab(data);
		                crLocationsTab(data);
		                crTowDestinationTab(data);
		                crServiceTab(data);
		                callReceivingLogout();
		                navigateToApplication("DI");
		                commonLib.dispatchLogin(data.get("DILoginName"),data.get("DIPassword"),data.get("LoginRoleDispatch"),data.get("DI-RoleinDispatch"));
		                diCallClearProcess(data);
		                System.out.println("Test completed");
		    		}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("RAP_DI","7777",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    public void callReceivingLogin(Hashtable<String, String> data) throws Throwable {
        navigateToApplication("CR");
        crHomeLib.verifyandClickLogout();
        switch (data.get( "LoginRoleCallReceiving")) {
            case "CR":
                login(data.get("LoginName"),data.get("Password"));
                break;
            default:
                break;
        }
        crMemberSearchLib.clickOnPartialCallCloseButton();
        crHomeLib.messageDialogBoxClose();
    }

    public void crRAPTab(Hashtable<String, String> data) throws Throwable
    {
        crHomeLib.verifyHomeScreen();
        crHomeLib.workFlowSelectionForRAP();
        crMemberSearchLib.verifyIsRapWorkFlowSet();
        crMemberSearchLib.enterDataInClubCode(data.get("clubCode"));
        crMemberSearchLib.clickOnClubClodeSuggestedOption();
        ranRAPID=generateRandomNumber();
        crMemberSearchLib.mandatoryFieldsForRAPCall(data.get("firstName"),data.get("lastName"),ranRAPID,data.get("paymentCode"));
        crMemberSearchLib.enterMemberContactInfoPrimaryPhoneNumber(data.get("phoneNumber"));
        crMemberSearchLib.selectType(data.get("phoneType"));
        crMemberSearchLib.clickPrimRadioBtnRowOne();
    }

    public void crLocationsTab(Hashtable<String, String> data) throws Throwable
    {
        crLocationsLib.breakdownLocTabSel();
        crLocationsLib.enterBreakDownLocationManually(data.get("Address"));
    }

    public void crVehicleTab(Hashtable<String, String> data) throws Throwable
    {
        crVehicleTriageLib.clickOnVehicleTriageTab();
        crVehicleTriageLib.enterVehicleDetailsManually(data.get("VehicleDetails"));
        crVehicleTriageLib.problemTriage(data.get( "ProblemTriage"),data.get("ProblemType"));
    }

    public void crTowDestinationTab(Hashtable<String, String> data) throws Throwable
    {
        String TowAddressVal[] =  data.get("TowAddress").split("#");

        crTowDestinationLib.clickOnTowDestinationTab();
        crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
        boolean noAddressLocationAvailable = crTowDestinationLib.verifyAddressAvailableInTowDestination();
        if (noAddressLocationAvailable) {
            crTowDestinationLib.enterTowDestinationLocationFields(data.get("TowAddress"));
        } else {
            crTowDestinationLib.enterExistingTowDestAddr(TowAddressVal[9]);
        }
        Thread.sleep(2000);
    }

    public void crServiceTab(Hashtable<String, String> data) throws Throwable
    {
        crServiceLib.clickOnServiceTab();
        crServiceLib.getFacilityType();
        completeCall(data.get("CompleteCall"));
    }

    public String[] completeCall(String CompleteCall) throws Throwable {
        switch (CompleteCall) {
            case "Save":
                crHomeLib.saveButton();
                crHomeLib.allErrorAlerts();
                //crServiceLib.getCallId();
                callIDCreated = crServiceLib.getCallId();
                spotIDCreated = crServiceLib.getSpotFacilityId();
                callDateCreated=crServiceLib.getCallDate();
                crServiceLib.closeCall();
                break;
            default:
                break;
        }
        callandfacilityId[0] = callIDCreated;
        callandfacilityId[1] = spotIDCreated;
        callandfacilityId[2] = callDateCreated;
        return callandfacilityId;
    }

    public void callReceivingLogout() throws Throwable
    {
        crHomeLib.logout();
        acceptAlert();
        acceptAlert();
    }
    /****************************************************** DISPATCH ******************************************************/

    public void diCallClearProcess(Hashtable<String, String> data) throws Throwable
    {
        callFlow(data);
        dimcdLib.paymentForRAPCall(data.get("Cost"),data.get("CashCollected"),data.get("ServiceType"),data.get("towServiceType"));
        spotDispatch(data.get("SpotDispatch"),data.get("ResoptFacilityID"),data.get("SPEnterReason"),data.get("ResoptFacilityIDNew") );
        dimcdLib.statusUpdateAsSP(data.get("StatusUpdateSP"));
        dimcdLib.statusUpdateAsAS(data.get("StatusUpdateAS"));
        dimcdLib.statusUpdateAsDI(data.get("StatusUpdateDI"));
        dimcdLib.statusUpdateAsER(data.get("StatusUpdateER"));
        dimcdLib.statusUpdateAsETA(data.get("StatusUpdateETA"));
        dimcdLib.statusUpdateAsOL(data.get("StatusUpdateOL"));
        dimcdLib.statusUpdateAsTW(data.get("StatusUpdateTW"));
        dimcdLib.statusUpdateAsCL(data.get("StatusUpdateCL"));
        dimcdLib.resolutionCode(data.get("ResolutionCode"),data.get("Reason"),data.get("BatteryInfo"),data.get("ResolutionCode"),data.get("StatusUpdateCL"));
        dimcdLib.towConfirmation(data.get("TowConfirmation"),data.get("DITowConfComments"),data.get("DITowConfEnterAddress"),data.get("MCDLocationAddress"), data.get("MCDcrossStreet"), data.get("MCDsecondCrossStreet"), data.get("MCDCity"),data.get("DITowConfEnterOtherAddress"),data.get("StatusUpdateCL"));
        dimcdLib.batteyInfo(data.get("BatteryInfo"),data.get("ODOMeterreading"),data.get("BatteryComments"),data.get("StatusUpdateCL"));
        commonLib.dispatchlogout(data.get("CallFlow"));
    }

    public void callFlow(Hashtable<String, String> data) throws Throwable {
        //Map is out of scope
        crHomeLib.messageDialogBoxClose();
        switch (data.get("CallFlow") ){
            case "Profile" :
                diHomeLib.clickOnProfile();
                callIDAndDateCombined = callandfacilityId[2].substring(0,4) + callandfacilityId[2].substring(5,7)+ callandfacilityId[2].substring(8,10)+callandfacilityId[2].substring(4,5)+callandfacilityId[0];
                diHomeLib.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombined);
                break;
            case "MCD" :
                diHomeLib.clickOnSearchCallsInDispatch();
                diHomeLib.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
                diHomeLib.clickOnSearchInSearchCalls();
                diHomeLib.clickOnCallDateOrIDLink();
                break;
            case "Truckload" :
                diHomeLib.clickOnTruckLoad();
                diHomeLib.enterSpotFacilityIDInfoOnTruckLoad(callandfacilityId[1]); //spotIDCreated
                Thread.sleep(5000);
                diHomeLib.dateDecendingOrder();
                callIDAndDateCombined = callandfacilityId[2].substring(0,4) + callandfacilityId[2].substring(5,7)+ callandfacilityId[2].substring(8,10)+callandfacilityId[2].substring(4,5)+callandfacilityId[0];
                diHomeLib.searchAndClickOnCallIdOnTruckloadWindow(callIDAndDateCombined);
                break;
            default :
                break;
        }
    }

    public void spotDispatch(String SpotDispatch, String ResoptFacilityID, String SPEnterReason, String ResoptFacilityIDNew ) throws Throwable {
        switch (SpotDispatch){
            case "Respot" :
                dimcdLib.clickOnServiceTabInMCDWindow();
                if(callandfacilityId[1]!=ResoptFacilityID) //spotIDCreated
                {
                    dimcdLib.verifyFacilityAndEnterReasonAndReSpot(SPEnterReason, ResoptFacilityID);
                }
                else
                {
                    dimcdLib.verifyFacilityAndEnterReasonAndReSpot(SPEnterReason, ResoptFacilityIDNew);
                }
                break;
            default :
                break;
        }
    }
}
