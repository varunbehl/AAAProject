package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DILiveCallSearch extends ActionEngine {
    String callId;
    public static long rapNumber;
    String startDate;
    String endDate;
    String facility;
    String memberNumber;
    String lastName;
    String phoneNumber;

    DIHomeLib diHome = new DIHomeLib();
    LoginLib login = new LoginLib();
    DILoginLib diLogin = new DILoginLib();
    LoginRoleLib loginRole = new LoginRoleLib();
    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
    DIMCDLib mcdlib = new DIMCDLib();
    CRServiceLib service = new CRServiceLib();
    CRTowDestinationLib tow = new CRTowDestinationLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();

    //Common Functionality
    public void diLiveCallSearch(Hashtable<String, String> data) throws Throwable {

        //DI
        navigateToApplication("DI");
        Thread.sleep(3000);
        login.login(data.get("LoginName"), data.get("Password"));
        loginRole.clickOnProceedBtnInDispatchRoleLogin();
        diLogin.waitcloseAllBusyIcons();
        diHome.clickOnCloseIconOnQueueSelection();
        diHome.clickOnSearchCallsInDispatch();
        Thread.sleep(2000);
        startDate = diSearchCalls.getStartDate();
        endDate = diSearchCalls.getEndDate();
        Thread.sleep(3000);
    }


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
    public void saveCallForLiveCallSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "saveCallForLiveCallSearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("saveCallForLiveCallSearch", TestData, "D3CallRecieving",intCounter);
    	
    					this.reporter.initTestCaseDescription("saveCallForLiveCallSearch "+ " From Iteration " + StartRow + " to " + EndRow );
    					
    					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
    					
			            navigateToApplication("CR");
			            Thread.sleep(4000);
			            login.login(data.get("LoginName"), data.get("Password"));
			            crMemberSearchLib.clickOnPartialCallCloseButton();
			            crHomeLib.verifyHomeScreen();
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
			            crHomeLib.memberSearchTextBox(Member);
			            //crHomeLib.memberSearchTextBox(data.get("Membersearch"));
			            crMemberSearchLib.memberNumClick();
			            memberNumber=crMemberSearchLib.labelMemberShipNumberInMemberDetailsSection();
			            lastName = crMemberSearchLib.memberLastNameVerification();
			            crMemberSearchLib.ClickPrimRadioBtnInRowTwo();
			            //crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
			            Thread.sleep(2000);
			            crLocationsLib.clickOnLocationTab();
			            crLocationsLib.enterTxtinBrkDowLocSrch(data.get("Breakdownaddress"));
			            crLocationsLib.brkDowLocSrchBtn();
			            crLocationsLib.brkdowLocAddrLink();
			            crLocationsLib.acceptAddressDifferenceAlert();
			            crLocationsLib.brkdownLocationCode(dataBean.getValue(data, "Breakdownlocationcode"));
			            crVehicleTriageLib.clickOnVehicleTriageTab();
			
			            crVehicleTriageLib.enterVehicleSearch(data.get("VehicleDetails"));
			            Thread.sleep(2000);
			            crVehicleTriageLib.clickOnTheVehicleSearchIcon();
			            crVehicleTriageLib.clickOnTheVehicleSearch();
			            // crVehicleTriageLib.availableVehicleaftersrch();
			            Thread.sleep(2000);
			            crVehicleTriageLib.enterVehicleColor(data.get("Color"));
			            //*crVehicleTriageLib.clickOnFuel();
			            //crVehicleTriageLib.clickOnOutOfGas();//
			            crVehicleTriageLib.clickonProblemTypeButton(data.get("ProblemType"));
			            Thread.sleep(3000);
			            crVehicleTriageLib.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
			            Thread.sleep(3000);
			            //crHomeLib.allErrorAlerts();
			            crVehicleTriageLib.scriptErrorHandle();
			            Thread.sleep(2000);
			            tow.clickOnTowDestinationTab();
			            crHomeLib.waitCloseAllBusyIconsResults();
			            crVehicleTriageLib.scriptErrorHandle();
			            crHomeLib.allErrorAlerts();
			            Thread.sleep(3000);
			            tow.clickOnAARTowDetinationLink();
			            //tow.clickOnManualEntryLinkOnTowDestination();
			            tow.enterTowPassengers(data.get("TowPassengers"));
			            Thread.sleep(2000);
			            service.clickOnServiceTab();
			            facility = service.validateFacilityAutospot();
			            Thread.sleep(3000);
			            phoneNumber = crMemberSearchLib.getPhoneNumberFromCallerInfo();
			            crVehicleTriageLib.scriptErrorHandle();
			            crHomeLib.saveButton();
			            crHomeLib.waitCloseAllBusyIconsResults();
			            Thread.sleep(3000);
			            callId = service.getCallId();
			            service.closeCall();
			            crHomeLib.logout();
			            acceptAlert();
			            Thread.sleep(2000);
			            acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }


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

    public void saveRAPCallsForDiLivaCallSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "saveRAPCallsForDiLivaCallSearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("saveRAPCallsForDiLivaCallSearch", TestData, "D3CallRecieving",intCounter);
    	
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
			                crMemberSearchLib.clickOnPartialCallCloseButton();
			                home.verifyHomeScreen();
			                home.workFlowSelectionForRAP();
			                member.verifyIsRapWorkFlowSet();
			                member.enterDataInClubCode(data.get("clubCode"));
			                member.clickOnClubClodeSuggestedOption();
			                rapNumber=generateRandomNumber();
			                member.mandatoryFieldsForRAPCall(data.get("firstName"),data.get("lastName"),rapNumber,data.get("paymentCode"));
			                member.enterMemberContactInfoPrimaryPhoneNumber(data.get("phoneNumber"));
			                Thread.sleep(2000);
			                member.selectType(data.get("phoneType"));
			                Thread.sleep(2000);
			                member.clickPrimRadioBtnRowOne();
			                //member.clickPrimRadioBtnSecondRow();
			                locations.clickOnLocationTab();
			                Thread.sleep(3000);
			                locations.clickOnManualEntryLinkInLocation();
			                //locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
			                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
			                Thread.sleep(2000);
			                //locations.clickOnLocationCodeDropDown();
			                crVehicleTriageLib.clickOnVehicleTriageTab();
			                Thread.sleep(2000);
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
			                crVehicleTriageLib.clickonProblemTypeButton(data.get("ProblemType"));
			                Thread.sleep(3000);
			                crVehicleTriageLib.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
			                Thread.sleep(5000);
			                crHomeLib.allErrorAlerts();
			                tow.clickOnTowDestinationTab();
			                home.waitCloseAllBusyIconsResults();
			                crVehicleTriageLib.scriptErrorHandle();
			                crHomeLib.allErrorAlerts();
			                Thread.sleep(3000);
			                tow.clickOnManualEntryLinkOnTowDestination();
			                tow.enterTowPassengers(data.get("Towpassengers"));
			                Thread.sleep(2000);
			                services.clickOnServiceTab();
			                crHomeLib.waitCloseAllBusyIconsResults();
			                service.enterManualSpotDetails(data.get("SPPFacilitySpot"));
			                crHomeLib.allErrorAlerts();
			                home.saveButton();
			                crHomeLib.allErrorAlerts();
			                crHomeLib.waitCloseAllBusyIconsResults();
			                //Thread.sleep(4000);
			                home.waitCloseAllBusyIconsResults();
			                Thread.sleep(2000);
			                services.getCallId();
			                services.closeCall();
			                home.waitCloseAllBusyIconsResults();
			                Thread.sleep(4000);
			                home.logout();
			                acceptAlert();
			                Thread.sleep(2000);
			                acceptAlert();
			                acceptAlert();
			                acceptAlert();
			                acceptAlert();
			
			                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1924",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }


   //dateRange Search
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
    public void dateRangeSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithDateRange", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithDateRange", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                diLiveCallSearch(data);
		                diSearchCalls.enterStartDate(startDate);
		                diSearchCalls.enterEndDate(endDate);
		                Thread.sleep(2000);
		                String combineKeys3 = Keys.chord(Keys.TAB);
		                sendKeys(combineKeys3, "Tab");
		                Thread.sleep(2000);
		                String currentDate = diSearchCalls.getStartDate();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean currentDateFlag = diSearchCalls.verifyResultsWithCurrentDate(currentDate);
		                assertTrue(currentDateFlag, "Verified the results returned & all results are for the current day   "+currentDate);
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    // Search With CallID
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
    public void callIdSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithCallID", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithCallID", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                diLiveCallSearch(data);
		                diSearchCalls.enterStartDate(startDate);
		                diSearchCalls.enterEndDate(endDate);
		                Thread.sleep(2000);
		                String combineKeys3 = Keys.chord(Keys.TAB);
		                sendKeys(combineKeys3, "Tab");
		                Thread.sleep(2000);
		                diSearchCalls.clickAndEnterCallIDInfo(callId);
		                String callId= diSearchCalls.getCallID();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean callIdFlag = diSearchCalls.verifyResultsWithCallID(callId);
		                assertTrue(callIdFlag, "Verified the results returned & one call is returned for the call ID    " + callId);
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

//Time Range Search
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
    public void timeRangeSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithTimeRange", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithTimeRange", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                diLiveCallSearch(data);
		                diSearchCalls.enterStartDate(startDate);
		                diSearchCalls.enterEndDate(endDate);
		                Thread.sleep(2000);
		                String combineKeys3 = Keys.chord(Keys.TAB);
		                sendKeys(combineKeys3, "Tab");
		                Thread.sleep(2000);
		                diSearchCalls.enterStartTimeOnSearchCallsWindow(data.get("StartTime"));
		                diSearchCalls.enterEndTimeOnSearchCallsWindow(data.get("EndTime"));
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                boolean noRecordsFlag=diSearchCalls.verifyMatchingRecordsOnMCD();
		                if(noRecordsFlag){
		                    assertFalse(noRecordsFlag,"No matching Records Found ");
		                    diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                }else {
		                    crHomeLib.waitCloseAllBusyIconsResults();
		                    diSearchCalls.verifyTheTimeRange(data.get("StartTime"), data.get("EndTime"));
		                    mcdlib.clickOnMCDCloseWindow();
		                }
		                Thread.sleep(2000);
		                diHome.logOut();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
		                acceptAlert();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
//RapId search
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
    public void rapNumberSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithRapNumber", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithRapNumber", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                diLiveCallSearch(data);
		                diSearchCalls.enterStartDate(data.get("RAPStartDate"));
		                String rapId = String.valueOf(rapNumber);
		                diSearchCalls.enterRAPNumberOnSearchCallsWindow(rapId);
		                String rapNumberFronList = diSearchCalls.getRapNumber();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean rapIdFlag = diSearchCalls.verifyResultsWithRAPId(rapNumberFronList);
		                assertTrue(rapIdFlag, "Verified the results returned & RAP call is returned in the search results    " + rapNumber);
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert(); acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    //facility Search
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
    public void facilitySearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithFacility", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithFacility", TestData, "D3Dispatch",intCounter);
		    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                diLiveCallSearch(data);
		                diSearchCalls.enterStartDate(startDate);
		                diSearchCalls.enterEndDate(endDate);
		                Thread.sleep(2000);
		                String combineKeys3 = Keys.chord(Keys.TAB);
		                sendKeys(combineKeys3, "Tab");
		                Thread.sleep(2000);
		                diSearchCalls.enterFacilityOnSearchCallsWindow(facility);
		                String facilityFromSearch = diSearchCalls.getFacility();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean facilityFlag = diSearchCalls.verifyResultsWithFacility(facilityFromSearch);
		                assertTrue(facilityFlag, " Results matched the criteria :: Facility " + facilityFromSearch + "Exists in Selected List");
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    //TruckSearch
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
    public void truckSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithTruckId", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithTruckId", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                diLiveCallSearch(data);
		                diSearchCalls.clickAndEnterCallIDInfo(callId);
		                //String callId= diSearchCalls.getCallID();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
		                Thread.sleep(2000);
		                //String truck = diSearchCalls.getTruckFromSearchCallsWindow();
		                Thread.sleep(2000);
		                crHomeLib.waitCloseAllBusyIconsResults();
		                mcdlib.clickOnAssign();
		                Thread.sleep(2000);
		                String truckId = mcdlib.getTruckIdFromMCDWindow();
		                Thread.sleep(3000);
		                mcdlib.selectSecondFacilityOnAssignTabInMCD();
		                mcdlib.clickOnMCDCloseWindow();
		                diHome.clickOnSearchCallsInDispatch();
		                Thread.sleep(2000);
		                diSearchCalls.enterTruckOnSearchCallsWindow(truckId);
		                String truck1 = diSearchCalls.getTruckFromSearchCallsWindow();
		                //String callId= diSearchCalls.getCallID();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                //diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
		                boolean truckIdFlag = diSearchCalls.verifyResultsWithTruckId(truck1);
		                assertTrue(truckIdFlag, " Call is Serviced by the Truck,Truck Id is     " +truck1);
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
   //Call Taker Search
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
    public void callTakerSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithCallTaker", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithCallTaker", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                diLiveCallSearch(data);
		                diSearchCalls.enterUserIDOnSearchCallsWindow(data.get("CallTaker"));
		                String userId = diSearchCalls.getUserId();
		                Thread.sleep(2000);
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean noRecordsFlag=diSearchCalls.verifyMatchingRecordsOnMCD();
		                if(noRecordsFlag){
		                    assertFalse(noRecordsFlag,"No matching Records Found ");
		                    diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                }else {
		                    diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
		                    crHomeLib.waitCloseAllBusyIconsResults();
		                    Thread.sleep(4000);
		                    String callTakerFromMcd = mcdlib.getCallTakerFromMCDWindow();
		                    boolean callTakerFlag = diSearchCalls.verifyResultsWithCallTakerID(userId, callTakerFromMcd);
		                    Thread.sleep(2000);
		                    assertTrue(callTakerFlag, "calls are returned based on the user id   " + userId);
		                    mcdlib.clickOnMCDCloseWindow();
		                }
		                Thread.sleep(2000);
		                diHome.logOut();
		                //Thread.sleep(2000);
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    //Phone Number search
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
    public void phoneNumberSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithPhoneNumber", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithPhoneNumber", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                diLiveCallSearch(data);
		                diSearchCalls.enterPhoneNumberOnSearchCallsWindow(phoneNumber);
		               // diSearchCalls.enterPhoneNumberOnSearchCallsWindow(data.get("PhoneNumber"));
		                String phoneNumber = diSearchCalls.getPhoneNumber();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean noRecordsFlag=diSearchCalls.verifyMatchingRecordsOnMCD();
		                if(noRecordsFlag){
		                    assertFalse(noRecordsFlag,"No matching Records Found ");
		                    diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                }else {
		                    diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
		                    crHomeLib.waitCloseAllBusyIconsResults();
		                    mcdlib.clickOnMemberTabInMCDWindow();
		                    //String phoneNumFromMCD = mcdlib.getphoneNumberFromMCD(phoneNumber);
		                    boolean phoneNumberFlag = diSearchCalls.verifyResultsWithphoneNumber(phoneNumber);
		                    assertTrue(phoneNumberFlag, "Verified the results returned & call is returned for that specific member  " + phoneNumber);
		                    mcdlib.clickOnMCDCloseWindow();
		                }
		                Thread.sleep(2000);
		                diHome.logOut();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

   //Club search
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
    public void clubSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithClubCode", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithClubCode", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                diLiveCallSearch(data);
		                diSearchCalls.enterClubNumberOnSearchCallsWindow(data.get("ClubNumber"));
		                String clubCode = diSearchCalls.getClubCode();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean clubCodeFlag = diSearchCalls.verifyResultsWithClubCode(clubCode);
		                assertTrue(clubCodeFlag, "Verified the calls & Call is returned with club Code    "+clubCode);
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    //Last name Search
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
        public void lastNameSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithLastNamesearch", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithLastNamesearch", TestData, "D3Dispatch",intCounter);
    	
	                    this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
	                    reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
	
	                    diLiveCallSearch(data);
	                    String lastNameLowecase = lastName.toLowerCase();
	                    diSearchCalls.enterMemberLastNameSearchOnSearchCallsWindow(lastNameLowecase);
	                    String lastName = diSearchCalls.getLaseNameFromSearchCallsWindow();
	                    diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
	                    crHomeLib.waitCloseAllBusyIconsResults();
	                    boolean lastnameFlag = diSearchCalls.verifyResultsWithLastName(lastName);
	                    assertTrue(lastnameFlag, "Verified the results & call(s) is returned matching the last name    "+lastName);
	                    diSearchCalls.clickCloseBtnOnSearchCallwindow();
	                    diHome.logOut();
	                    acceptAlert();
	                    Thread.sleep(2000);
	                    acceptAlert();
	                    acceptAlert();
	                    acceptAlert();
    			
    		}
			catch(Exception e)
			{
				ReportStatus.blnStatus=false;
			}
			ReportControl.fnEnableJoin();
			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
		}
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	ReportControl.fnNextTestJoin(nextTestJoin);
}

    //Member Number Search
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
    public void memberNumberSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithMemNumber", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithMemNumber", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                diLiveCallSearch(data);
		                diSearchCalls.enterMemberNumberOnSearchCallsWindow(memberNumber);
		                String memNumber = diSearchCalls.getMemberNumberFromSearCalls();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean memberFlag = diSearchCalls.verifyResultsWithMemberNumber(memNumber);
		                assertTrue(memberFlag, "Verified the results & Call record is returned for the member    "+memNumber);
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    //vehicle Search
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
    public void vehicleSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithVehicle", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithVehicle", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                diLiveCallSearch(data);
		                diSearchCalls.enterYearVehicleInforationOnSearchCallsWindow(data.get("VehicleYear"));
		                diSearchCalls.enterMakeVehicleInforationOnSearchCallsWindow(data.get("VehicleMake"));
		                Thread.sleep(3000);
		                diSearchCalls.enterModelVehicleInforationOnSearchCallsWindow(data.get("VehicleModel"));
		                Thread.sleep(3000);
		                String year = diSearchCalls.getVehicleYearFromSearCalls();
		                String make = diSearchCalls.getVehicleMakeFromSearCalls();
		                String model = diSearchCalls.getVehicleModelFromSearCalls();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		               boolean vehicleFlag = diSearchCalls.verifyResultsWithVehicle(year,make,model);
		                assertTrue(vehicleFlag, "Verified the result & Call is returned for  Vehicle Search  with     "+year+"   "+make+"   "+model);
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

//Breakdown location
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
    public void breakdownLocationSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
	try
	{
		int intStartRow=StartRow;
		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithBreakdownLocation", TestData, "D3Dispatch");
		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
		{
			try {
					ReportStatus.fnDefaultReportStatus();
					ReportControl.intRowCount=intCounter;
					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithBreakdownLocation", TestData, "D3Dispatch",intCounter);
	
			                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
			                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			
			                diLiveCallSearch(data);
			                diSearchCalls.enterLocationOnSearchCallsWindow(data.get("BKDownStreetAddress"));
			                diSearchCalls.enterCityOnSearchCallsWindow(data.get("BKDownCityLocation"));
			                String bkDwnStreetAddress = diSearchCalls.getStreetAddressFromSearCalls();
			                String bkDownCity = diSearchCalls.getCityLocationFromSearCalls();
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                crHomeLib.waitCloseAllBusyIconsResults();
			                boolean locationFlag = diSearchCalls.verifyResultsWithBreakdownLocation(bkDwnStreetAddress,bkDownCity);
			                assertTrue(locationFlag, "Verified the result & Call is returned for Breakdown location Search  with     "+bkDwnStreetAddress+"   "+bkDownCity);
			                diSearchCalls.clickCloseBtnOnSearchCallwindow();
			                diHome.logOut();
			                acceptAlert();
			                Thread.sleep(2000);
			                acceptAlert();
			                acceptAlert();
			                acceptAlert();
			}
			catch(Exception e)
			{
				ReportStatus.blnStatus=false;
			}
			ReportControl.fnEnableJoin();
			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
		}
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	ReportControl.fnNextTestJoin(nextTestJoin);
}
    //Wrong clubcode search
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
    public void errorScenario(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DILiveCallSearchWithWrongInfo", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DILiveCallSearchWithWrongInfo", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1747: DILive Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                diLiveCallSearch(data);
		                diSearchCalls.enterClubNumberOnSearchCallsWindow(data.get("WrongClubCode"));
		                String wrongClubCode = diSearchCalls.getClubCode();
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                boolean clubCodeFlag = diSearchCalls.verifyResultsWithClubCode(wrongClubCode);
		                assertFalse(clubCodeFlag, "Verified the results &  Error displayed In the search results as No matching records found,try refining your search"+wrongClubCode);
		                diSearchCalls.clickCloseBtnOnSearchCallwindow();
		                diHome.logOut();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1747",ReportStatus.strMethodName,intCounter,browser);
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

