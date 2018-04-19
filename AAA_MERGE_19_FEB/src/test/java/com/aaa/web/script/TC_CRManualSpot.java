package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRManualSpot extends DILoginLib {
        public static String callID;
        public static String autoFacility;
        public static String manualFacility;
        public static String autoSpotId;
        public static String numberOfSpecialEquipment;
        public static int totalnumberOfSpecialEquipment;
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: activeManualSpot
     * description :: activeManualSpot
     * date :: 11-01-2018
     * author :: Chandu Dendukuri
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void activeManualSpot(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "activeManualSpot", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("activeManualSpot", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("2202: TS-CR Manual Spot "+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRServiceLib services = new CRServiceLib();
		
		                navigateToApplication("CR");
		                login(data.get("CRLoginName"), data.get("Password"));
		                waitcloseAllBusyIcons();
		                //home.messageDialogBoxClose();
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                else
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
		                member.memberNumClick();
		               // member.currentCallClose();
		                /*member.enterMemberContactInfoPrimaryPhoneNumber(data.get("PhoneNumber"));
		                member.selectType(data.get("PhoneType"));*/
		                locations.breakdownLocTabSel();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"),data.get("Address"),data.get("crossStreet"),data.get("secondCrossStreet"),data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"),data.get("City"),data.get("State"),data.get("LocationCode"));
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		               /* Thread.sleep(2000);
		                locations.clickOnLocationCodeDropDown();*/
		                Thread.sleep(5000);
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
		                Thread.sleep(1000);
		                crVehicleTriageLib.enterVehicleType(data.get("ReEnterType"));
		                crVehicleTriageLib.clickOnTheTypeSearchFromDropDown();
		                Thread.sleep(3000);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                //crVehicleTriageLib.getMoreInfoTab();
		                Thread.sleep(2000);
		                crVehicleTriageLib.enterVehicleYear(data.get("ReEnterYear"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.enterVehicleMake(data.get("ReEnterMake"));
		                crVehicleTriageLib.enterVehicleModel(data.get("ReEnterModel"));
		                crVehicleTriageLib.enterVehicleColor(data.get("Color"));
		                Thread.sleep(3000);
		                crVehicleTriageLib.clickOnFlatTire();
		                crVehicleTriageLib.clickOnAirOnlyOptionInFlatTyreType();
		                Thread.sleep(5000);
		                services.clickOnServiceTab();
		                autoFacility=services.validateFacilityAutospotID();
		                services.validateFacilityAutospotAddress();
		                services.enterManualFacilityNumber(data.get("facilityNumber"));
		                services.clickOnSpotInServicePage();
		                Thread.sleep(5000);
		                crVehicleTriageLib.scriptErrorHandle();
		                manualFacility=services.validateFacilityAutospotID();
		                services.validateFacilityAutospotAddress();
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(2000);
		                assertTrue(autoFacility!=manualFacility,"Manual Facility::  "+manualFacility+ " ::and Auto facility:: "+autoFacility+" ::both are different and call is spotted regardless of business rule");
		                home.leaveButton();
		                home.clickOnConfirmationAlert();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","2202",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: inActiveManualSpot
     * description :: inActiveManualSpot
     * date :: 11-01-2018
     * author :: Chandu Dendukuri
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void inActiveManualSpot(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "inactiveManualSpot", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("inactiveManualSpot", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("2202: TS-CR Manual Spot "+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRServiceLib services = new CRServiceLib();
		
		                navigateToApplication("CR");
		                login(data.get("CRLoginName"), data.get("Password"));
		                waitcloseAllBusyIcons();
		                //home.messageDialogBoxClose();
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                else
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
		                //home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                //member.currentCallClose();
		                /*member.enterMemberContactInfoPrimaryPhoneNumber(data.get("PhoneNumber"));
		                member.selectType(data.get("PhoneType"));*/
		                locations.breakdownLocTabSel();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"),data.get("Address"),data.get("crossStreet"),data.get("secondCrossStreet"),data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"),data.get("City"),data.get("State"),data.get("LocationCode"));
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		              /*  Thread.sleep(2000);
		                locations.clickOnLocationCodeDropDown();*/
		                Thread.sleep(5000);
		
		                Thread.sleep(1000);
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		
		                crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
		
		                Thread.sleep(1000);
		                crVehicleTriageLib.enterVehicleType(data.get("ReEnterType"));
		                crVehicleTriageLib.clickOnTheTypeSearchFromDropDown();
		                Thread.sleep(3000);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                //crVehicleTriageLib.getMoreInfoTab();
		                Thread.sleep(2000);
		                crVehicleTriageLib.enterVehicleYear(data.get("ReEnterYear"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.enterVehicleMake(data.get("ReEnterMake"));
		                crVehicleTriageLib.enterVehicleModel(data.get("ReEnterModel"));
		                crVehicleTriageLib.enterVehicleColor(data.get("Color"));
		                Thread.sleep(3000);
		                crVehicleTriageLib.clickOnFlatTire();
		                crVehicleTriageLib.clickOnAirOnlyOptionInFlatTyreType();
		                Thread.sleep(5000);
		                Thread.sleep(2000);
		                services.clickOnServiceTab();
		                autoFacility=services.validateFacilityAutospotID();
		                services.validateFacilityAutospotAddress();
		                services.enterManualFacilityNumber(data.get("facilityNumber"));
		                services.clickOnSpotInServicePage();
		                services.getInactiveFacilityErrorMessage(data.get("inactiveErrorMesage"));
		                Thread.sleep(5000);
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                home.leaveButton();
		                home.clickOnConfirmationAlert();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","2202",ReportStatus.strMethodName,intCounter,browser);
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
