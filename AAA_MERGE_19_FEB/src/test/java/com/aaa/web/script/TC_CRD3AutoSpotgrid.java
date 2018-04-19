package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRD3AutoSpotgrid extends DILoginLib {
    public static String callID;
    public static String pstTimeZone;
    public static String newZone;
    public static String autoSpotId;
    public static String numberOfSpecialEquipment;
    public static int totalnumberOfSpecialEquipment;


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: autoSpotGridForFullService
     * description :: autoSpotGridForFullService
     * date :: 09-01-2018
     * author :: Chandu Dendukuri
     */

   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void autoSpotGridForFullService(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "autoSpotGrid", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("autoSpotGrid", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1978: Auto Spot Grid Verification "+ " From Iteration " + StartRow + " to " + EndRow );
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
		
		                navigateToApplication("CR");
		                login(data.get("CRLoginName"), data.get("Password"));
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                if(Member.isEmpty())
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
		                //home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("PhoneNumber"));
		                member.selectType(data.get("PhoneType"));
		                locations.breakdownLocTabSel();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		               /* Thread.sleep(2000);
		                locations.clickOnLocationCodeDropDown();*/
		                Thread.sleep(5000);
		                //crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
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
		                services.validateFacilityAutospotID();
		                services.getFacilityType();
		
		                tow.clickOnTowDestinationTab();
		                tow.enterTowLocationName(data.get("LocationAddress"));
		                tow.enterFirstCrossStreet(data.get("crossStreet"));
		                tow.enterSecondCrossStreet(data.get("secondCrossStreet"));
		                tow.enterCityCodeInTow(data.get("City"));
		                tow.enterStateInTow(data.get("State"));
		                tow.enterLandMarkInTow(data.get("LandMark"));
		                Thread.sleep(5000);
		                tow.getLatitudeValueInTow();
		                tow.getLogitudeValueInTow();
		                home.saveButton();
		                Thread.sleep(2000);
		                services.getCallId();
		                services.closeCall();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1978",ReportStatus.strMethodName,intCounter,browser);
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
     * methodName :: autoSpotGridForLightService
     * description :: autoSpotGridForLightService
     * date :: 09-01-2018
     * author :: Chandu Dendukuri
     */

  
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void autoSpotGridForLightServiceFlatTyre(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "autoSpotGrid", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("autoSpotGrid", TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("1978: Auto Spot Grid Verification "+ " From Iteration " + StartRow + " to " + EndRow );
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
		
		                navigateToApplication("CR");
		                login(data.get("CRLoginName"), data.get("Password"));
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                if(Member.isEmpty())
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
		                //home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("PhoneNumber"));
		                member.selectType(data.get("PhoneType"));
		                locations.breakdownLocTabSel();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		               /* Thread.sleep(2000);
		                locations.clickOnLocationCodeDropDown();*/
		                Thread.sleep(5000);
		
		                Thread.sleep(1000);
		                //crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickOnFlatTire();
		                crVehicleTriageLib.clickOnAirOnlyOptionInFlatTyreType();
		                Thread.sleep(5000);
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(2000);
		                services.clickOnServiceTab();
		                services.validateFacilityAutospotID();
		                services.validateFacilityAutospotAddress();
		                services.getFacilityType();
		                Thread.sleep(2000);
		                home.saveButton();
		                Thread.sleep(2000);
		                services.getCallId();
		                services.closeCall();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1978",ReportStatus.strMethodName,intCounter,browser);
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
     * methodName :: autoSpotGridForJumpStart
     * description :: autoSpotGridForJumpStart
     * date :: 09-01-2018
     * author :: Chandu Dendukuri
     */

   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void autoSpotGridForJumpStart(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "autoSpotGrid", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("autoSpotGrid", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1978: Auto Spot Grid Verification "+ " From Iteration " + StartRow + " to " + EndRow );
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
		
		                navigateToApplication("CR");
		                login(data.get("CRLoginName"), data.get("Password"));
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                if(Member.isEmpty())
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
		                //home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("PhoneNumber"));
		                member.selectType(data.get("PhoneType"));
		                locations.breakdownLocTabSel();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		                /*locations.clickOnLocationCodeDropDown();*/
		                Thread.sleep(5000);
		
		                Thread.sleep(1000);
		                //crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.clickOnOutOfGas();
		                Thread.sleep(5000);
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(2000);
		                services.clickOnServiceTab();
		                services.validateFacilityAutospotID();
		                services.validateFacilityAutospotAddress();
		                services.getFacilityType();
		                Thread.sleep(2000);
		                home.saveButton();
		                Thread.sleep(2000);
		                services.getCallId();
		                services.closeCall();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1978",ReportStatus.strMethodName,intCounter,browser);
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
     * methodName :: autoSpotGridForLockOutServices
     * description :: autoSpotGridForLockOutServices
     * date :: 09-01-2018
     * author :: Chandu Dendukuri
     */

  

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void autoSpotGridForLockOutServices(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "autoSpotGrid", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("autoSpotGrid", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1978: Auto Spot Grid Verification "+ " From Iteration " + StartRow + " to " + EndRow );
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
		
		                navigateToApplication("CR");
		                login(data.get("CRLoginName"), data.get("Password"));
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
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
		                home.memberSearchTextBox(Member);
		                //home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("PhoneNumber"));
		                member.selectType(data.get("PhoneType"));
		                locations.breakdownLocTabSel();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		               /* Thread.sleep(2000);
		                locations.clickOnLocationCodeDropDown();*/
		                Thread.sleep(5000);
		                Thread.sleep(1000);
		                Thread.sleep(1000);
		                //crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickOnKeysButton();
		                crVehicleTriageLib.clickOnKeysLockedRadioButton();
		                Thread.sleep(5000);
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(2000);
		                services.clickOnServiceTab();
		                services.validateFacilityAutospotID();
		                services.validateFacilityAutospotAddress();
		                services.getFacilityType();
		                Thread.sleep(2000);
		                home.saveButton();
		                Thread.sleep(2000);
		                services.getCallId();
		                services.closeCall();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1978",ReportStatus.strMethodName,intCounter,browser);
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
     * methodName :: autoSpotGridForSpecialEquipement
     * description :: autoSpotGridForSpecialEquipement
     * date :: 09-01-2018
     * author :: Chandu Dendukuri
     */

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void autoSpotGridForSpecialEquipement(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "autoSpotGrid", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("autoSpotGrid", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1978: Auto Spot Grid Verification "+ " From Iteration " + StartRow + " to " + EndRow );
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
		
		                navigateToApplication("CR");
		                login(data.get("CRLoginName"), data.get("Password"));
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                if(Member.isEmpty())
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
		                //home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("PhoneNumber"));
		                member.selectType(data.get("PhoneType"));
		                locations.breakdownLocTabSel();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		               /* Thread.sleep(2000);
		                locations.clickOnLocationCodeDropDown();*/
		                Thread.sleep(5000);
		                Thread.sleep(1000);
		                Thread.sleep(1000);
		                //crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
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
		                autoSpotId = services.validateFacilityAutospotID();
		                numberOfSpecialEquipment = data.get("NumberOfSpecialEquipment");
		                totalnumberOfSpecialEquipment = Integer.parseInt(numberOfSpecialEquipment);
		                for (int i = 1; i <= totalnumberOfSpecialEquipment; i++) {
		                    services.enterSpeciLEquipment(data.get("SpecialEquipment" + i));
		                    home.allErrorAlerts();
		                    Thread.sleep(6000);
		                    home.waitCloseAllBusyIconsResults();
		                    String specialEquipmentAutoSpotId = services.validateFacilityAutospotID();
		                    services.verifySpeciLEquipmentWithAutoSpotID(autoSpotId, specialEquipmentAutoSpotId);
		                }
		                services.getFacilityType();
		                Thread.sleep(2000);
		                home.saveButton();
		                Thread.sleep(2000);
		                services.getCallId();
		                services.closeCall();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1978",ReportStatus.strMethodName,intCounter,browser);
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
     * methodName :: autoSpotGridForRVVehicle
     * description :: autoSpotGridForRVVehicle
     * date :: 09-01-2018
     * author :: Chandu Dendukuri
     */

   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void autoSpotGridForRVVehicle(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "autoSpotGrid", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("autoSpotGrid", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1978: Auto Spot Grid Verification "+ " From Iteration " + StartRow + " to " + EndRow );
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
		
		                navigateToApplication("CR");
		                login(data.get("CRLoginName"), data.get("Password"));
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                if(Member.isEmpty())
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
		                //home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("PhoneNumber"));
		                member.selectType(data.get("PhoneType"));
		                locations.breakdownLocTabSel();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		               /* Thread.sleep(2000);
		                locations.clickOnLocationCodeDropDown();*/
		                Thread.sleep(5000);
		                Thread.sleep(1000);
		                Thread.sleep(1000);
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
		               /* crVehicleTriageLib.clickOnTow();
		                crVehicleTriageLib.clickOnBreakDownForRVType();*/
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("PaceSetterCode"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(5000);
		                tow.clickOnTowDestinationTab();
		                Thread.sleep(5000);
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(1000);
		                tow.clickOnManualEntryLinkOnTowDestination();
		                tow.enterTowPassengers(data.get("Towpassengers"));
		                Thread.sleep(2000);
		                services.clickOnServiceTab();
		                services.validateFacilityAutospotID();
		                services.validateFacilityAutospotAddress();
		                services.getFacilityType();
		                Thread.sleep(2000);
		                home.saveButton();
		                Thread.sleep(2000);
		                services.getCallId();
		                services.closeCall();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1978",ReportStatus.strMethodName,intCounter,browser);
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
     * methodName :: autoSpotGridForLightServicesFuel
     * description :: autoSpotGridForLightServicesFuel
     * date :: 09-01-2018
     * author :: Chandu Dendukuri
     */

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void autoSpotGridForLightServicesFuel(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "autoSpotGrid", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("autoSpotGrid", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1978: Auto Spot Grid Verification "+ " From Iteration " + StartRow + " to " + EndRow );
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
		
		                navigateToApplication("CR");
		                login(data.get("CRLoginName"), data.get("Password"));
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                if(Member.isEmpty())
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
		                //home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("PhoneNumber"));
		                member.selectType(data.get("PhoneType"));
		                locations.breakdownLocTabSel();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		              /*  Thread.sleep(2000);
		                locations.clickOnLocationCodeDropDown();*/
		                Thread.sleep(5000);
		
		                Thread.sleep(1000);
		                //crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.clickOnOutOfGas();
		                Thread.sleep(5000);
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(2000);
		                services.clickOnServiceTab();
		                services.validateFacilityAutospotID();
		                services.validateFacilityAutospotAddress();
		                services.getFacilityType();
		                Thread.sleep(2000);
		                home.saveButton();
		                Thread.sleep(2000);
		                services.getCallId();
		                services.closeCall();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1978",ReportStatus.strMethodName,intCounter,browser);
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

    public void autoSpotGridForBattery(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "autoSpotGrid", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("autoSpotGrid", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1978: Auto Spot Grid Verification "+ " From Iteration " + StartRow + " to " + EndRow );
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
		
		                navigateToApplication("CR");
		                login(data.get("CRLoginName"), data.get("Password"));
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                if(Member.isEmpty())
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
		                //home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("PhoneNumber"));
		                member.selectType(data.get("PhoneType"));
		                locations.breakdownLocTabSel();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		                Thread.sleep(2000);
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		               /* Thread.sleep(2000);
		                locations.clickOnLocationCodeDropDown();*/
		                Thread.sleep(5000);
		                Thread.sleep(1000);
		                //locations.clickOnCallBox();
		                //crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickOnBatteryButton();
		                crVehicleTriageLib.clickOnLeftLightOnRadioBtnOfBattery();
		                Thread.sleep(5000);
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(2000);
		                services.clickOnServiceTab();
		                services.validateFacilityAutospotID();
		                services.validateFacilityAutospotAddress();
		                services.getFacilityType();
		                Thread.sleep(2000);
		                home.saveButton();
		                Thread.sleep(1000);
		                services.getCallId();
		                services.closeCall();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1978",ReportStatus.strMethodName,intCounter,browser);
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