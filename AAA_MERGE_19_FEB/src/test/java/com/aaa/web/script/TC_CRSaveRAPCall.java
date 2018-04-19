package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRSaveRAPCall extends CRMemberSearchLib {
    public static long ran;


   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void saveRAPCallsLightService(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveRapCalls", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveRapCalls", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1924-Save RAP Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib=new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRServiceLib services = new CRServiceLib();
		
		                home.verifyandClickLogout();
		                navigateToApplication("CR");
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
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
		               /* Thread.sleep(2000);
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
		                services.getCallId();
		                services.closeCall();
		                Thread.sleep(4000);
		                home.logout();
		                System.out.println("Test completed");

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1924",ReportStatus.strMethodName,intCounter,browser);
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

    public void saveRAPCallsForFullService(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveRapCalls", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveRapCalls", TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("1924-Save RAP Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib=new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRServiceLib services = new CRServiceLib();
		
		                home.verifyandClickLogout();
		                navigateToApplication("CR");
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
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
		               /* Thread.sleep(2000);
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
		                crVehicleTriageLib.clickOnTow();
		                crVehicleTriageLib.clickOnBrakeFailurOnTow();
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(1000);
		                tow.clickOnTowDestinationTab();
		                Thread.sleep(5000);
		                crVehicleTriageLib.scriptErrorHandle();
		                tow.clickOnManualEntryLinkOnTowDestination();
		                tow.enterTowPassengers(data.get("Towpassengers"));
		                Thread.sleep(2000);
		                services.clickOnServiceTab();
		                services.getFacilityType();
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                services.getCallId();
		                services.closeCall();
		                Thread.sleep(4000);
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1924",ReportStatus.strMethodName,intCounter,browser);
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

    public void saveRAPCallsForLockOutServices(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveRapCalls", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveRapCalls", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1924-Save RAP Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib=new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRServiceLib services = new CRServiceLib();
		
		
		                navigateToApplication("CR");
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
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
		               /* Thread.sleep(2000);
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
		                crVehicleTriageLib.clickOnKeysButton();
		                crVehicleTriageLib.clickOnKeysLockedRadioButton();
		                Thread.sleep(5000);
		                tow.clickOnTowDestinationTab();
		                crVehicleTriageLib.scriptErrorHandle();
		                tow.clickOnManualEntryLinkOnTowDestination();
		                tow.enterTowPassengers(data.get("Towpassengers"));
		                services.clickOnServiceTab();
		                services.getFacilityType();
		                Thread.sleep(2000);
		                home.saveButton();
		                Thread.sleep(2000);
		                services.getCallId();
		                services.closeCall();
		                Thread.sleep(4000);
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1924",ReportStatus.strMethodName,intCounter,browser);
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
