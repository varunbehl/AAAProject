package com.aaa.web.script;


import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

public class TC_DIArchivedCallSearch extends ActionEngine {

   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void diArchivedCallSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIArchivedCallSearch", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIArchivedCallSearch", TestData, "D3Dispatch",intCounter);
    	
			                this.reporter.initTestCaseDescription("1748: TC-DI Archived Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
			                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			                CRHomeLib home = new CRHomeLib();
			                CRLocationsLib locations = new CRLocationsLib();
			                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
			                CRMemberSearchLib member = new CRMemberSearchLib();
			                CRTowDestinationLib tow = new CRTowDestinationLib();
			                CRServiceLib services = new CRServiceLib();
			                DIHomeLib diHome = new DIHomeLib();
			                DIMCDLib diMCD = new DIMCDLib();
			                DILoginLib diLogin = new DILoginLib();
			                DISearchCallsLib diSearchCalls = new DISearchCallsLib();
			                LoginLib login = new LoginLib();
			                LoginRoleLib loginRole = new LoginRoleLib();
			
			                navigateToApplication("DI");
			                login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
			                loginRole.clickOnProceedBtnInDispatchRoleLogin();
			                diLogin.waitcloseAllBusyIcons();
			                diHome.clickOnCloseIconOnQueueSelection();
			                diHome.clickOnSearchCallsInDispatch();
			                diSearchCalls.enterCommCenterOnSearchCallsWindow(data.get("CommCenter"));
			                diSearchCalls.enterStartDate(data.get("ArchivedStartdate"));
			                diSearchCalls.enterEndDate(data.get("ArchivedEnddate"));
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                diSearchCalls.getFirstCallIdAndDateInSearchCallsTable();
			                diSearchCalls.clickOnFirstCallIdInSearchCallsTable();
			                diMCD.getCallDateFromMCD();
			                diMCD.clickOnMCDCloseWindow();
			                diHome.clickOnSearchCallsInDispatch();
			                diSearchCalls.clickOnClearbuttonInSearchCalls();
			                String currentDay = getCurrentDate();
			                String nextDay = getNextDay(currentDay);
			                diSearchCalls.enterStartDate(nextDay);
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                diSearchCalls.verifyInvalidSearchCriteriaForDate();
			                home.allErrorAlerts();
			                diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
			                diSearchCalls.clickOnClearbuttonInSearchCalls();
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                String validCallId = diSearchCalls.getValidArchivedCall();
			                diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
			                diSearchCalls.enterCommCenterOnSearchCallsWindow(data.get("CommCenter"));
			                diSearchCalls.clickAndEnterCallIDInfo(validCallId);
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                diSearchCalls.clickOnFirstCallIdInSearchCallsTable();
			                diMCD.getCallDateFromMCD();
			                diMCD.clickOnMCDCloseWindow();
			                diHome.clickOnSearchCallsInDispatch();
			                diSearchCalls.clickOnClearbuttonInSearchCalls();
			                diSearchCalls.clickAndEnterCallIDInfo(data.get("InvalidCallId"));
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                diSearchCalls.verifyNoRecordFoundForSearchResults();
			                diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
			                diSearchCalls.clickOnClearbuttonInSearchCalls();
			                diSearchCalls.enterCommCenterOnSearchCallsWindow(data.get("CommCenter"));
			                diSearchCalls.enterStartDate(data.get("ArchivedStartdate"));
			                diSearchCalls.enterFacilityOnSearchCallsWindow(data.get("Facility"));
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                boolean facility = diSearchCalls.verifyResultsWithFacility(data.get("Facility"));
			                assertTrue(facility, "Facility Entered are Displayed");
			                diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
			                diSearchCalls.clickOnClearbuttonInSearchCalls();
			                diSearchCalls.enterCommCenterOnSearchCallsWindow(data.get("CommCenter"));
			                diSearchCalls.enterClubNumberOnSearchCallsWindow(data.get("ClubCode"));
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                boolean clubcode = diSearchCalls.verifyResultsWithClubCode(data.get("ClubCode"));
			                assertTrue(clubcode, "Clubcode entered is displayed");
			                diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
			                diSearchCalls.clickOnClearbuttonInSearchCalls();
			                diSearchCalls.enterMemberLastNameSearchOnSearchCallsWindow(data.get("MemberLastName"));
			                diSearchCalls.enterMemberFirstNameSearchOnSearchCallsWindow(data.get("MemberFirstName"));
			                diSearchCalls.enterStartDate(data.get("ArchivedStartdate"));
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                boolean lastName = diSearchCalls.verifyFirstNameLastNameInArchivedCall(data.get("MemberLastName"));
			                assertTrue(lastName, "Member LastName Entered is Displayed");
			                diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
			                diSearchCalls.clickOnClearbuttonInSearchCalls();
			                diSearchCalls.enterMemberNumberInSearchCallDispatch(data.get("MemberNumber"));
			                diSearchCalls.enterStartDate(data.get("ArchivedStartdate"));
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                boolean memberNumber = diSearchCalls.verifyResultsWithMemberNumber(data.get("MemberNumber"));
			                assertTrue(memberNumber, "Entered MemberNumber is Displayed");
			                diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
			                diSearchCalls.clickOnClearbuttonInSearchCalls();
			                diSearchCalls.enterCallType(data.get("LiveCallType"));
			                diSearchCalls.enterStartDate(data.get("ArchivedStartdate"));
			                diSearchCalls.enterEndDate(data.get("ArchivedEnddate"));
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                diSearchCalls.verifyNoRecordFoundForSearchResults();
			                diSearchCalls.clickOnSearchAgainbuttonInSearchCalls();
			                diSearchCalls.clickOnClearbuttonInSearchCalls();
			                diSearchCalls.enterCallType(data.get("LiveAndArchivedCallType"));
			                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
			                diSearchCalls.getFirstCallIdAndDateInSearchCallsTable();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1748",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    
    public String getNextDay(String curDate) throws Exception {
        final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        final Date date = format.parse(curDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return format.format(calendar.getTime());
    }

    public String getCurrentDate() {
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String currentdate = sdf.format(date);
        return currentdate;
    }
}
