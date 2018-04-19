package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.CRHomeLib;
import com.aaa.web.lib.CRLocationsLib;
import com.aaa.web.lib.CRMemberSearchLib;
import com.aaa.web.lib.CommonDb;
import com.aaa.web.lib.LoginLib;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRLocations extends CRLocationsLib {
    public static String streetAddress;
    public static String narthCrossStreet;
    public static String southCrossStreet;
    public static String city;
    public static String state;
    public static String zipCode;
    public static String latitude;
    public static String longitude;
    public static String landMark;


    LoginLib login = new LoginLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();

    CRMemberSearchLib member = new CRMemberSearchLib();
    CRHomeLib home = new CRHomeLib();
    CRLocationsLib location = new CRLocationsLib();

    public void verifyLocationFields(Hashtable<String, String> data) throws Throwable {
        //navigateToApplication("CR");
        Thread.sleep(2000);
        login.login(data.get("LoginName"), data.get("Password"));
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
        	Member = data.get("MemberNumber");
        }
        home.memberSearchTextBox(Member);
        member.memberNumClick();
        member.currentCallClose();
        location.clickOnLocationTab();
    }

    public void verifyTheEmptyFields() throws Throwable {
        streetAddress = location.getBKDownStreetAddress();
        narthCrossStreet = location.getNarthCrossStreetsValue();
        southCrossStreet = location.getSouthCrossStreetsValue();
        city = location.getCityValue();
        state = location.getStateValue();
        zipCode = location.getZipCodeValue();
        latitude = location.getLatitudeValue();
        longitude = location.getLongitudeValue();
        landMark = location.getLandMarkField();

        if (streetAddress.isEmpty()) {
            assertTrue(streetAddress.isEmpty(), "Street Address Field is empty");
        }
        if (narthCrossStreet.isEmpty()) {
            assertTrue(narthCrossStreet.isEmpty(), "Narth CrossStreet Field is empty");
        }
        if (southCrossStreet.isEmpty()) {
            assertTrue(southCrossStreet.isEmpty(), "South CrossStreet Field is empty");
        }
        if (city.isEmpty()) {
            assertTrue(city.isEmpty(), "city Field is empty");
        }
        if (state.isEmpty()) {
            assertTrue(state.isEmpty(), "State  Field is empty");
        }
        if (zipCode.isEmpty()) {
            assertTrue(zipCode.isEmpty(), "zipCode  Field is empty");
        }
        if (latitude.isEmpty()) {
            assertTrue(latitude.isEmpty(), "latitude  Field is empty");
        }
        if (longitude.isEmpty()) {
            assertTrue(longitude.isEmpty(), "longitude  Field is empty");
        }
        if (landMark.isEmpty()) {
            assertTrue(longitude.isEmpty(), "Land Mark  Field is empty");
        }
    }

  

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void addressLookUp(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "LocationsAddresslookup", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("LocationsAddresslookup", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                verifyLocationFields(data);
		                location.clickOnManualEntryLinkInLocation();
		                location.clickOnClearLocationButton();
		                verifyTheEmptyFields();
		                location.clickOnManualEntryLinkInLocation();
		                location.enterTxtinBrkDowLocSrch(data.get("AddressLookup"));
		                location.brkDowLocSrchBtn();
		                location.clickOnLocationResultsLink();
		                location.acceptAddressDifferenceAlert();
		                location.verifyBreakDownStreetValue();
		                location.verifyNarthCrossStreetFieldValue();
		                location.verifySouthCrossStreetFieldValue();
		                location.verifyCityField();
		                location.verifyStateField();
		                location.verifyLatitudeField();
		                location.verifyLongitude();
		                location.verifyAddressVerifiedBtn();
		                home.leaveButton();
		                home.allErrorAlerts();
		                location.clickOnLocationTab();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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
    public void verifyFieldsWithCrossStreet(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "CrossStreet", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("CrossStreet", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                verifyLocationFields(data);
		                location.clickOnManualEntryLinkInLocation();
		                location.clickOnClearLocationButton();
		                verifyTheEmptyFields();
		                location.clickOnManualEntryLinkInLocation();
		                location.enterTxtinBrkDowLocSrch(data.get("CrossStreet"));
		                location.brkDowLocSrchBtn();
		                //home.allErrorAlerts();
		                location.clickOnLocationResultsLink();
		                location.acceptAddressDifferenceAlert();
		                location.verifyBreakDownStreetValue();
		                location.verifyNarthCrossStreetFieldValue();
		                location.verifyCityField();
		                location.verifyStateField();
		                //location.verifyZipCodeField();
		                boolean landMrk = location.verifyLandMarkField();
		                if (landMrk) {
		                    assertTrue(landMrk, "Bike trail is not returned as the cross street");
		                }
		                location.verifyLatitudeField();
		                location.verifyLongitude();
		                location.verifyAddressVerifiedBtn();
		                home.leaveButton();
		                home.allErrorAlerts();
		                location.clickOnLocationTab();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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
    public void verifyAddressWithLongitudeAndLatitude(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "LongitudeAndLatitudeVerification", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("LongitudeAndLatitudeVerification", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                verifyLocationFields(data);
		                location.clickOnManualEntryLinkInLocation();
		                location.clickOnClearLocationButton();
		                verifyTheEmptyFields();
		                location.enterLatitude(data.get("Latitude"));
		                location.enterLongitude(data.get("Longitude"));
		                location.clickOnVerifyItButton();
		                location.clickOnAddressLinkAfterLongitudeAndLatitudeVerification();
		                location.verifyBlockRange();
		                location.verifyBreakDownStreetValue();
		                location.verifyCityField();
		                location.verifyStateField();
		                home.leaveButton();
		                home.allErrorAlerts();
		                location.clickOnLocationTab();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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
    public void verifySpecialCharactersOnAddress(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "SpecialCharacters", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("SpecialCharacters", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                verifyLocationFields(data);
		                    location.clickOnManualEntryLinkInLocation();
		                    location.clickOnClearLocationButton();
		                    verifyTheEmptyFields();
		                    location.clickOnManualEntryLinkInLocation();
		                    location.enterTxtinBrkDowLocSrch(data.get("SpecialCharacters"));
		                    location.brkDowLocSrchBtn();
		                    location.clickOnLocationResultsLink();
		                    Thread.sleep(2000);
		                    location.verifySpecialCharactersWithResults(data.get("SpecialCharacters"));
		                    location.acceptAddressDifferenceAlert();
		                    location.verifyBreakDownStreetValue();
		                    location.verifyCityField();
		                    location.verifyStateField();
		                    home.leaveButton();
		                    home.allErrorAlerts();
		                    location.clickOnLocationTab();
		                    Thread.sleep(2000);
		                    home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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
    public void verifyPointsOfInterest(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "PointsofInterest", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("PointsofInterest", TestData, "D3CallRecieving",intCounter);
    	
    					this.reporter.initTestCaseDescription("CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
    					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
    					verifyLocationFields(data);
	                    location.clickOnManualEntryLinkInLocation();
	                    location.clickOnClearLocationButton();
	                    verifyTheEmptyFields();
	                    location.clickOnManualEntryLinkInLocation();
	                    location.enterTxtinBrkDowLocSrch(data.get("PointsofInterest"));
	                    location.brkDowLocSrchBtn();
	                    location.getNumberOfRecordsInResultsGrid();
	                    location.clickOnLocationResultsLink();
	                    location.acceptAddressDifferenceAlert();
	                    location.verifyLandMarkFieldForPointOfInterest(data.get("PointsofInterest"));
		                home.leaveButton();
		                home.allErrorAlerts();
		                location.clickOnLocationTab();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
//Found number of record for wild card search.



   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyWildCardSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "WildCardSearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("WildCardSearch", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                verifyLocationFields(data);
		                location.clickOnManualEntryLinkInLocation();
		                location.clickOnClearLocationButton();
		                verifyTheEmptyFields();
		                location.clickOnManualEntryLinkInLocation();
		                location.enterTxtinBrkDowLocSrch(data.get("WildCardSearch"));
		                location.brkDowLocSrchBtn();
		                //location.getNumberOfRecordsInResultsGrid();
		                location.getNumberOfRecordsWithWildCardSearch();
		                home.leaveButton();
		                home.allErrorAlerts();
		                location.clickOnLocationTab();
		                home.logout();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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
    public void verifyLandMark(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "LandMarks", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("LandMarks", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                verifyLocationFields(data);
		                location.clickOnManualEntryLinkInLocation();
		                location.clickOnClearLocationButton();
		                verifyTheEmptyFields();
		                location.clickOnManualEntryLinkInLocation();
		                location.enterTxtinBrkDowLocSrch(data.get("Landmarks"));
		                location.brkDowLocSrchBtn();
		                location.getNumberOfRecordsInResultsGrid();
		                location.clickOnLocationResultsLink();
		                location.verifyBreakDownStreetValue();
		                location.verifyCityField();
		                location.verifyStateField();
		                location.verifyLandMarkField();
		                location.veryfyPickUpPoints();
		                home.leaveButton();
		                home.allErrorAlerts();
		                location.clickOnLocationTab();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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
    public void membershipKnownLocations(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "KnownLocations", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("KnownLocations", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                //navigateToApplication("CR");
		                Thread.sleep(2000);
		                login.login(data.get("LoginName"), data.get("Password"));
		                home.messageDialogBoxClose();
		                home.memberSearchTextBox(data.get("membershipKnownLocations"));
		                member.memberNumClick();
		                member.currentCallClose();
		                location.clickOnLocationTab();
		                location.clickOnManualEntryLinkInLocation();
		                location.clickOnClearLocationButton();
		                verifyTheEmptyFields();
		                location.clickOnManualEntryLinkInLocation();
		                location.clickOnExistingBreakDwnLoc();
		                location.verifyBreakDownStreetValue();
		                location.verifyCityField();
		                location.verifyStateField();
		                location.verifyLatitudeField();
		                location.verifyLongitude();
		                location.verifyAddressVerifiedBtn();
		                location.clickOnClearLocationButton();
		                location.clickOnManualEntryLinkInLocation();
		                location.clickOnSecondKownBrkDowLocation();
		                location.verifyBreakDownStreetValue();
		                location.verifyCityField();
		                location.verifyStateField();
		                location.verifyLatitudeField();
		                location.verifyLongitude();
		                location.verifyAddressVerifiedBtn();
		                home.leaveButton();
		                home.allErrorAlerts();
		                location.clickOnLocationTab();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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
    public void verifyCityAlias(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        Thread.sleep(2000);
        try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"CityAlias", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("CityAlias", TestData, "D3CallRecieving",intCounter);
    	
    					this.reporter.initTestCaseDescription("CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
    					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
    					verifyLocationFields(data);
    					Thread.sleep(2000);
	                    location.clickOnManualEntryLinkInLocation();
	                    location.clickOnClearLocationButton();
	                    verifyTheEmptyFields();
	                    location.clickOnManualEntryLinkInLocation();
	                    location.enterTxtinBrkDowLocSrch(data.get("CityAlias"));
	                    location.brkDowLocSrchBtn();
	                    location.clickOnLocationResultsLink();
	                    location.acceptAddressDifferenceAlert();
	                    location.verifyCityField();
	                    location.verifyStateField();
	                    home.leaveButton();
	                    home.allErrorAlerts();
	                    location.clickOnLocationTab();
	                    home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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
    public void verifyManualEntryAddressLookUp(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "ManualEntry", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ManualEntry", TestData, "D3CallRecieving",intCounter);
    	
    					this.reporter.initTestCaseDescription("CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
    					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
    					//navigateToApplication("CR");
    					Thread.sleep(2000);
    					login.login(data.get("LoginName"), data.get("Password"));
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
		                	Member = data.get("MemberNumber");
		                }
		                //home.memberSearchTextBox(data.get("MemberNumber"));
		                member.memberNumClick();
		                member.currentCallClose();
		                location.clickOnLocationTab();
		                location.clickOnManualEntryLinkInLocation();
		                location.clickOnClearLocationButton();
		                verifyTheEmptyFields();
		                location.clickOnManualEntryLinkInLocation();
		                location.enterTxtinBrkDowLocSrch(data.get("ManualEntryOfAddressLookUp"));
		                location.brkDowLocSrchBtn();
		                location.clickOnLocationResultsLink();
		                location.acceptAddressDifferenceAlert();
		                location.verifyBreakDownStreetValue();
		                location.verifyCityField();
		                location.verifyStateField();
		                location.verifyLatitudeField();
		                location.verifyLongitude();
		                location.verifyAddressVerifiedBtn();
		                home.leaveButton();
		                home.allErrorAlerts();
		                location.clickOnLocationTab();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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
    public void verifyManualEntryCrossStreet(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"ManualEntry", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ManualEntry", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");	
		                verifyLocationFields(data);
		                location.clickOnManualEntryLinkInLocation();
		                location.clickOnClearLocationButton();
		                verifyTheEmptyFields();
		                location.clickOnManualEntryLinkInLocation();
		                location.enterTxtinBrkDowLocSrch(data.get("ManualEntryCrossStreet"));
		                location.brkDowLocSrchBtn();
		                location.clickOnLocationResultsLink();
		                location.acceptAddressDifferenceAlert();
		                location.verifyBreakDownStreetValue();
		                location.verifyNarthCrossStreetFieldValue();
		                //location.verifySouthCrossStreetFieldValue();
		                location.verifyCityField();
		                location.verifyStateField();
		                location.verifyZipCodeField();
		                location.verifyAddressVerifiedBtn();
		                home.leaveButton();
		                home.allErrorAlerts();
		                location.clickOnLocationTab();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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
    public void verifyManualEntryOfLandMark(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "ManualEntry", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ManualEntry", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                verifyLocationFields(data);
		                location.clickOnManualEntryLinkInLocation();
		                location.clickOnClearLocationButton();
		                verifyTheEmptyFields();
		                location.clickOnManualEntryLinkInLocation();
		                location.enterTxtinBrkDowLocSrch(data.get("ManualEntryLandMark"));
		                location.brkDowLocSrchBtn();
		                location.getNumberOfRecordsInResultsGrid();
		                location.clickOnLocationResultsLink();
		                location.verifyBreakDownStreetValue();
		                location.verifyCityField();
		                location.verifyStateField();
		                location.verifyLandMarkField();
		                location.veryfyPickUpPoints();
		                home.leaveButton();
		                home.allErrorAlerts();
		                location.clickOnLocationTab();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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
    public void verifyManualEntryOfSpecialCharactersOnAddress(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "ManualEntry", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ManualEntry", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Locations"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                verifyLocationFields(data);
		                location.clickOnManualEntryLinkInLocation();
		                location.clickOnClearLocationButton();
		                verifyTheEmptyFields();
		
		                location.clickOnManualEntryLinkInLocation();
		                location.enterTxtinBrkDowLocSrch(data.get("ManualEntryOfSpecialCharacter"));
		                location.brkDowLocSrchBtn();
		                location.clickOnLocationResultsLink();
		                location.verifySpecialCharactersWithResults(data.get("ManualEntryOfSpecialCharacter"));
		                location.acceptAddressDifferenceAlert();
		                location.verifyBreakDownStreetValue();
		                location.verifyCityField();
		                location.verifyStateField();
		                home.leaveButton();
		                home.allErrorAlerts();
		                location.clickOnLocationTab();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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