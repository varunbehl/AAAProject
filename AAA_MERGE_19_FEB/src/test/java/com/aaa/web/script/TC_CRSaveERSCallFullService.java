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

public class TC_CRSaveERSCallFullService extends ActionEngine {
    LoginLib login = new LoginLib();
    CRMemberSearchLib member = new CRMemberSearchLib();
    CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
    CRLocationsLib location = new CRLocationsLib();
    CRTowDestinationLib towdestination = new CRTowDestinationLib();
    CRHomeLib home = new CRHomeLib();
    CRServiceLib service = new CRServiceLib();

    public void saveERSCallFullService(Hashtable<String, String> data)throws  Throwable{
        navigateToApplication("CR");
        login.login(data.get("LoginName"),data.get("Password"));
        member.clickOnPartialCallCloseButton();
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
        else
        {
        	Member = data.get("Membersearch");
        }
        home.memberSearchTextBox(Member);
        //home.memberSearchTextBox(data.get("Membersearch"));
        member.memberNumClick();
        Thread.sleep(2000);
        member.currentCallClose();
        home.waitCloseAllBusyIconsResults();
        //member.enterSecondaryPhoneType(data.get("PhoneType"));
        member.clickPrimRadioBtnSecondRow();
        //Location
        location.clickOnLocationTab();
        //location.clickOnManualEntryLinkInLocation();
        location.enterTxtinBrkDowLocSrch(data.get("BreakDownLocation"));
        location.brkDowLocSrchBtn();
        location.clickOnLocationResultsLink();
        location.acceptAddressDifferenceAlert();
        location.enterBKDownLocCode(data.get("LocationCode"));
       /* Thread.sleep(2000);
        location.clickOnLocationCodeDropDown();*/

        //Verify Location Fields
        String streenNumber = location.getBlockRange();
        boolean streenNumberValue = streenNumber != null;
        assertTrue(streenNumberValue,"verified the Streen Number that is entered in Breakdown Location & entered StreenNumber is   -"+streenNumber);

        String streetAddressValue=location.getBKDownStreetAddress();
        boolean streetAddress = streetAddressValue != null;
        assertTrue(streetAddress,"Verified the Street Address That is entered in Breakdown Location & entered StreetAddress is    -"+streetAddressValue);

        String northStreetValue = location.getNarthCrossStreetsValue();
        boolean crossStreet=northStreetValue != null;
        assertTrue(crossStreet,"Verified the cross Street That is entered in Breakdown Location & entered crossStreet is    -"+northStreetValue);

        String cityValue=location.getCityValue();
        boolean city=cityValue != null;
        assertTrue(city,"Verified the City That is entered in Breakdown Location & entered city is  -"+cityValue);

        String stateValue=location.getStateValue();
        boolean state = stateValue != null;
        assertTrue(state,"Verified the State That is entered in Breakdown Location & entered State is   -"+stateValue);

        //location.enterZipCode(data.get("ZipCode"));

        Thread.sleep(3000);

        String locationCodeValue=location.getLocationCode();
        boolean locationCode=locationCodeValue != null;
        Thread.sleep(1000);
        assertTrue(locationCode,"Verified the Location Code that is entered in Breakdown Location & entered LocationCode is    -"+locationCodeValue);

        String latitudeValue=location.getLatitudeValue();
        boolean latitude = latitudeValue != null;
        assertTrue(latitude,"Verified the latitude that is entered in Breakdown Location & entered latitude is   -"+latitudeValue);

        String longitudeValue=location.getLongitudeValue();
        boolean longitude=longitudeValue !=null;
        assertTrue(longitude,"verified the longitude that is entered in Breakdown Location & entered longitude is   -"+longitudeValue);
        //Vehicle
        vehicle.clickOnVehicleTriageTab();
        vehicle.Entervehicleinfomanually(data.get("Vehicle"));
        vehicle.clickOnTheVehicleSearchIcon();
        home.waitCloseAllBusyIconsResults();
        vehicle.clickOnTheVehicleSearch();
        Thread.sleep(1000);
        vehicle.enterVehicleColor(data.get("Color"));
        //Verify Vehicle Fields
        String type=vehicle.getTypeValue();
        boolean typeValue=type !=null;
        assertTrue(typeValue,"verified the Vehicle Type that is entered in VehicleTriage & entered Vehicle Type is   -"+type);

        String year=vehicle.getYearValue();
        boolean yearValue=type !=null;
        assertTrue(yearValue,"verified the Vehicle year that is entered in VehicleTriage & entered Vehicle year is   -"+year);

        String make=vehicle.getMakeValue();
        boolean makeValue=type !=null;
        assertTrue(makeValue,"verified the Vehicle Make that is entered in VehicleTriage & entered Vehicle Make is   -"+make);

        String model=vehicle.getModelValue();
        boolean modelValue=type !=null;
        assertTrue(modelValue,"verified the Vehicle Model that is entered in VehicleTriage & entered Vehicle Model is   -"+model);

        String color=vehicle.getVehicleColor();
        boolean colorValue=type !=null;
        assertTrue(colorValue,"verified the Vehicle color that is entered in VehicleTriage & entered Vehicle color is   -"+color);
        vehicle.clickonProblemTypeButton(data.get("ProblemType"));
        Thread.sleep(3000);
        vehicle.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
        //Thread.sleep(2000);
        //vehicle.clickonProblemTypeOptions(data.get("ProblemTypeOption2"));
        towdestination.alertForTowMilesOffer();
        towdestination.clickOnTowDestinationTab();
        Thread.sleep(2000);
        vehicle.handleScriptErrorInVehicleTriagePage();
        Thread.sleep(2000);


    }
 //1Basic member less Than 5 miles
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallForBasicMemberLessThan5Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForBasicLessThan5Miles", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForBasicLessThan5Miles", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                Thread.sleep(2000);
		                boolean flagMiles=towdestination.verifyTowMilesForBasicLevellessThan5Miles(data.get("BasicMemberMiles"));
		                if(flagMiles) {
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
		                    towdestination.verifyEstimatedtowmiles();
		                    towdestination.verifyEntitledMiles();
		                    towdestination.verifyEstimatedOverMiles();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(flagMiles, "No Tow destinations are available in Specified Range");
		                }
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                service.getCallId();
		                service.closeCallWindow();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }



//2Basic member Greater Than 5 miles
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallForBasicMemberGreaterThan5Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
           //4299811247566105
        	try
        	{
        		int intStartRow=StartRow;
        		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForBasicGreateThan5Miles", TestData, "D3CallRecieving");
        		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
        		{
        			try {
        					ReportStatus.fnDefaultReportStatus();
        					ReportControl.intRowCount=intCounter;
        					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForBasicGreateThan5Miles", TestData, "D3CallRecieving",intCounter);
        	
			                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
			                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			                saveERSCallFullService(data);
			
			                //towdestination.alertForTowMilesOffer();
			                home.waitCloseAllBusyIconsResults();
			                towdestination.clickOnShowCriteriaCollapseButton();
			                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
			                towdestination.clickOnSearchButtonOnTow();
			                vehicle.handleScriptErrorInVehicleTriagePage();
			                home.waitCloseAllBusyIconsResults();
			               // towdestination.verifyTowMilesForBasicLevelGreaterThan5Miles(data.get("BasicMemberMiles"));
			                boolean flagMiles = towdestination.verifyTowMilesBasedOnLevel(data.get("BasicMemberMiles"));
			                if(flagMiles) {
			                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
			                    towdestination.verifyEstimatedtowmiles();
			                    towdestination.verifyEntitledMiles();
			                    towdestination.verifyEstimatedOverMiles();
			                    towdestination.enterTowPassengers(data.get("TowPassengers"));
			                }
			                else{
			                    towdestination.clickOnManualEntryLinkOnTowDestination();
			                    towdestination.enterTowPassengers(data.get("TowPassengers"));
			                    assertTrue(flagMiles, "No Tow destinations are available in Specified Range");
			                }
			                home.saveButton();
			                home.allErrorAlerts();
			                Thread.sleep(2000);
			                service.getCallId();
			                service.closeCallWindow();
			                home.logout();

        			}
        			catch(Exception e)
        			{
        				ReportStatus.blnStatus=false;
        			}
        			ReportControl.fnEnableJoin();
        			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
        		}
        	}
        	catch (Exception e) 
        	{
        		e.printStackTrace();
        		throw new RuntimeException(e);
        	}
        	ReportControl.fnNextTestJoin(nextTestJoin);
        }

//3 plus Member approximately 50 miles
    

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPlusMemberApproximately50Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
              //4299811247566105
        	try
        	{
        		int intStartRow=StartRow;
        		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForPlusMemberHaving50Miles", TestData, "D3CallRecieving");
        		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
        		{
        			try {
        					ReportStatus.fnDefaultReportStatus();
        					ReportControl.intRowCount=intCounter;
        					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForPlusMemberHaving50Miles", TestData, "D3CallRecieving",intCounter);
        	
		                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                Thread.sleep(2000);
		                boolean flagMiles=towdestination.verifyTowMilesForPlusMemberApproximately50Miles(data.get("PlusMemberMilesStartRange"),data.get("PlusMemberMilesEndRange"));
		                if(flagMiles) {
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
		                    towdestination.verifyEstimatedtowmiles();
		                    towdestination.verifyEntitledMiles();
		                    towdestination.verifyEstimatedOverMiles();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(flagMiles, "No Tow destinations are available in Specified Range");
		                }
		
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                service.getCallId();
		                service.closeCallWindow();
		                home.logout();

        			}
        			catch(Exception e)
        			{
        				ReportStatus.blnStatus=false;
        			}
        			ReportControl.fnEnableJoin();
        			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
        		}
        	}
        	catch (Exception e) 
        	{
        		e.printStackTrace();
        		throw new RuntimeException(e);
        	}
        	ReportControl.fnNextTestJoin(nextTestJoin);
        }
 //4Plus Member miles Between 80 To 100
    

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPlusMemberBetween80To100Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
             //4299811247566105
        	try
        	{
        		int intStartRow=StartRow;
        		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForPlusBetwween80To100Miles", TestData, "D3CallRecieving");
        		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
        		{
        			try {
        					ReportStatus.fnDefaultReportStatus();
        					ReportControl.intRowCount=intCounter;
        					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForPlusBetwween80To100Miles", TestData, "D3CallRecieving",intCounter);
        	
		                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                Thread.sleep(2000);
		                boolean flagMiles=towdestination.verifyTowMilesForMembersInBetweenTheMileRange(data.get("PlusMemberMilesStartRange"),data.get("PlusMemberMilesEndRange"));
		                if(flagMiles) {
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
		                    towdestination.verifyEstimatedtowmiles();
		                    towdestination.verifyEntitledMiles();
		                    towdestination.verifyEstimatedOverMiles();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(flagMiles, "No Tow destinations are available in Specified Range");
		                }
		            //verifyTowMilesForPlusMemberBetween80To100
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                service.getCallId();
		                service.closeCallWindow();
		                home.logout();
        			}
        			catch(Exception e)
        			{
        				ReportStatus.blnStatus=false;
        			}
        			ReportControl.fnEnableJoin();
        			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
        		}
        	}
        	catch (Exception e) 
        	{
        		e.printStackTrace();
        		throw new RuntimeException(e);
        	}
        	ReportControl.fnNextTestJoin(nextTestJoin);
        }

    //5Premier Member, greaterThan 100 Miles and Allow Long Tow Parameter set to "Y"
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPremierMemberGreaterThan100Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForPremierMemberGreaterThan100", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForPremierMemberGreaterThan100", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                Thread.sleep(2000);
		                boolean flagMiles=towdestination.verifyTowMilesBasedOnLevel(data.get("PremireMemberMiles"));
		                if(flagMiles) {
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
		                    towdestination.verifyEstimatedtowmiles();
		                    towdestination.verifyEntitledMiles();
		                    towdestination.verifyEstimatedOverMiles();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(flagMiles, "No Tow destinations are available in Specified Range");
		                }
		
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                service.getCallId();
		                service.closeCallWindow();
		                home.waitCloseAllBusyIconsResults();
		                home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		                member.verifyLongTowAllowed(data.get("AllowLongTow"));
		                home.logout();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    //6Premier Tow Miles Between 180 To 200
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPremierMemBetween180To200Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForPremierMemBetween180To200", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForPremierMemBetween180To200", TestData, "D3CallRecieving",intCounter);
    		            this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                Thread.sleep(2000);
		                boolean flagMiles=towdestination.verifyTowMilesForMembersInBetweenTheMileRange(data.get("PremierMemberMilesStartRange"),data.get("PremierMemberMilesEndRange"));
		                if(flagMiles) {
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
		                    towdestination.verifyEstimatedtowmiles();
		                    towdestination.verifyEntitledMiles();
		                    towdestination.verifyEstimatedOverMiles();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(flagMiles, "No Tow destinations are available in Specified Range");
		                }
		
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                service.getCallId();
		                service.closeCallWindow();
		                home.waitCloseAllBusyIconsResults();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    // 7 Plus RV -- RV Capable  servicing a RV < 100



	@Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPlusRvMemberLessThan100Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallPlusRVMember", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallPlusRVMember", TestData, "D3CallRecieving",intCounter);
    					this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnRVType();
		                Thread.sleep(1000);
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                boolean flagMiles=towdestination.verifyTowMilesForBasicLevellessThan5Miles(data.get("PlusMemberMiles"));
		                //towdestination.clickOnAARTowDetinationLink();
		                if(flagMiles) {
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
		                    towdestination.verifyEstimatedtowmiles();
		                    towdestination.verifyEntitledMiles();
		                    String estimatedOverMiles = towdestination.verifyEstimatedOverMiles();
		                    boolean estimatedMiles = estimatedOverMiles != null;
		                    assertTrue(estimatedMiles, "Tow destination is RV capable");
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(flagMiles, "No Tow destinations are available in Specified Range");
		                }
		
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                service.getCallId();
		                service.closeCallWindow();
		                home.logout();
    					}
    	    			catch(Exception e)
    	    			{
    	    				ReportStatus.blnStatus=false;
    	    			}
    	    			ReportControl.fnEnableJoin();
    	    			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
    	    		}
    	    	}
    	    	catch (Exception e) 
    	    	{
    	    		e.printStackTrace();
    	    		throw new RuntimeException(e);
    	    	}
    	    	ReportControl.fnNextTestJoin(nextTestJoin);
    	    }

    //8Premier Rv ,Greater Than 100,
    

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPremierRVMemberGreaterThan100Miles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForPremierRVMemberGreaterThan100", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForPremierRVMemberGreaterThan100", TestData, "D3CallRecieving",intCounter);
    	                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnRVType();
		                Thread.sleep(1000);
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                boolean flagMiles=towdestination.verifyTowMilesBasedOnLevel(data.get("PremireMemberMiles"));
		                if(flagMiles) {
		                    towdestination.getTextFromAlertOnTowDestinationMiles();
		                    towdestination.clickOnRepairShopVerificationCloseButton();
		                    vehicle.handleScriptErrorInVehicleTriagePage();
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
		                    towdestination.verifyEstimatedtowmiles();
		                    towdestination.verifyEntitledMiles();
		                    String estimatedOverMiles = towdestination.verifyEstimatedOverMiles();
		                    boolean estimatedMiles = estimatedOverMiles != null;
		                    assertTrue(estimatedMiles, "Tow destination is RV capable");
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    towdestination.getTextFromAlertOnTowDestinationMiles();
		                    towdestination.clickOnRepairShopVerificationCloseButton();
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(flagMiles, "No Tow destinations are available in Specified Range");
		                }
		
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                service.getCallId();
		                service.closeCallWindow();
		                home.waitCloseAllBusyIconsResults();
		                home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.currentCallClose();
		                member.verifyLongTowAllowed(data.get("AllowLongTow"));
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    //Premier Rv ,Miles Between 180 To 200,//Pending RV Capable
   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void saveERSCallFullServiceForPremierRVMemBetween180To200(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SaveERSCallForPremierRVMemBetween180To200", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SaveERSCallForPremierRVMemBetween180To200", TestData, "D3CallRecieving",intCounter);
    	                this.reporter.initTestCaseDescription("1611_Save ERSCall FullService"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                saveERSCallFullService(data);
		
		                //towdestination.alertForTowMilesOffer();
		                home.waitCloseAllBusyIconsResults();
		                towdestination.clickOnShowCriteriaCollapseButton();
		                towdestination.enterMilesToSearchRepairShopWithInRange(data.get("MilesToSearchWithInRange"));
		                towdestination.clickOnRVType();
		                Thread.sleep(1000);
		                towdestination.clickOnSearchButtonOnTow();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                boolean flagMiles=towdestination.verifyTowMilesForMembersInBetweenTheMileRange(data.get("PremierMemberMilesStartRange"),data.get("PremierMemberMilesEndRange"));
		                if(flagMiles) {
		                    towdestination.mouseHoverTowMileDetailsOnTowDestination();
		                    towdestination.verifyEstimatedtowmiles();
		                    towdestination.verifyEntitledMiles();
		                    String estimatedOverMiles = towdestination.verifyEstimatedOverMiles();
		                    boolean estimatedMiles = estimatedOverMiles != null;
		                    assertTrue(estimatedMiles, "Tow destination is RV capable");
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                }else{
		                    towdestination.clickOnManualEntryLinkOnTowDestination();
		                    towdestination.enterTowPassengers(data.get("TowPassengers"));
		                    assertTrue(flagMiles, "No Tow destinations are available in Specified Range");
		                }
		
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                service.getCallId();
		                service.closeCallWindow();
		                Thread.sleep(4000);
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1611",ReportStatus.strMethodName,intCounter,browser);
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
