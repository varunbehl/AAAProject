package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.CRHomeLib;
import com.aaa.web.lib.CRSearchCallsLib;
import com.aaa.web.lib.CRVehicleTriageLib;
import com.aaa.web.lib.LoginLib;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static com.aaa.web.lib.CRSearchCallsLib.*;

/**
 * Created by E002734 on 1/11/2018.
 */
public class TC_CRArchivedCallSearchScript extends ActionEngine {

	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void archivedCallSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "archivedCallSearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("archivedCallSearch", TestData, "D3CallRecieving",intCounter);
		    			this.reporter.initTestCaseDescription("1685: TC-CR Archived Call Search"+ " From Iteration " + StartRow + " to " + EndRow );
		    			reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		    			LoginLib login = new LoginLib();
						CRHomeLib crHomeLib = new CRHomeLib();
						CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
						CRVehicleTriageLib crVehicleTriageLib= new CRVehicleTriageLib();
						navigateToApplication("CR");
						login.login(data.get("LoginName"), data.get("Password"));
						Thread.sleep(10000);
						crHomeLib.messageDialogBoxClose();
						Thread.sleep(10000);
						crSearchCall.clickOnSearchCalls();
						crSearchCall.clickOnClearOnSearchCallsWindow();
		
						//3&5 point
						crSearchCall.enterCommCenterOnSearchCallsWindow(data.get("commCenter"));
						crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDateArchive"));
						crSearchCall.enterEndDateOnSearchCallsWindow(data.get("EndDateArchive"));
						//crSearchCall.searchAndSelectDatesOnSearCallWindow(data);
						crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
						//crSearchCall.verifyStartAndEndDateOnSearchCallWindow(data);
						crSearchCall.clickOnFirstRowInSearchCalls();
						crHomeLib.allErrorAlerts();
						crHomeLib.allErrorAlerts();
						//validate call loads d3 call receviing
						crHomeLib.getTextD3CallReceivingText();
						Thread.sleep(3000);
						crSearchCall.clickOnSearchCalls();
						crSearchCall.clickOnClearOnSearchCallsWindow();
						//crSearchCall.searchAndSelectCallIDOnSearCallWindow(data);
		
		
						//6-9
						crSearchCall.enterStartDateOnSearchCallsWindow(data.get("InvalidStartDate"));
						crSearchCall.enterEndDateOnSearchCallsWindow(data.get("InvalidEndDate"));
						crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
						crSearchCall.getTextAndClickOnOkOnInvalidErrorPopup();
						crSearchCall.clickSearchAgainOnSearchCalls();
						crSearchCall.clickOnClearOnSearchCallsWindow();
		
						//10-13
						crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDateArchive"));
						crSearchCall.enterEndDateOnSearchCallsWindow(data.get("EndDateArchive"));
						crSearchCall.enterCallIdOnSearchCallsWindow(data.get("CallID"));
						crSearchCall.enterCommCenterOnSearchCallsWindow(data.get("commCenter"));
						crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
						crSearchCall.searchAndSelectCallIDOnSearCallWindow(data.get("CallID"));
						crSearchCall.clickSearchAgainOnSearchCalls();
						crSearchCall.clickOnClearOnSearchCallsWindow();
		
		
						//14-16
						crSearchCall.enterCommCenterOnSearchCallsWindow(data.get("commCenter"));
						crSearchCall.enterFacilityOnSearchCallsWindow(data.get("Facility"));
						crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
						crSearchCall.enterEndDateOnSearchCallsWindow(data.get("EndDate"));
						crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
						crSearchCall.searchAndSelectFacilityOnSearCallWindow(data.get("Facility"));
						//crSearchCall.getTextOfNoMatchingRecords();
						crSearchCall.clickSearchAgainOnSearchCalls();
						crSearchCall.clickOnClearOnSearchCallsWindow();
		
						//17-18
						crSearchCall.enterCommCenterOnSearchCallsWindow(data.get("commCenter"));
						crSearchCall.enterClubNumberOnSearchCallsWindow(data.get("ClubNumber"));
						crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
						crSearchCall.enterEndDateOnSearchCallsWindow(data.get("EndDate"));
						crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
						Thread.sleep(3000);
						crSearchCall.searchAndSelectClubNumberOnSearCallWindow(data.get("ClubNumber"));
						crSearchCall.clickSearchAgainOnSearchCalls();
						crSearchCall.clickOnClearOnSearchCallsWindow();
		
						//19-21
						crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDateArchive"));
						crSearchCall.enterEndDateOnSearchCallsWindow(data.get("EndDateArchive"));
						crSearchCall.enterMemberFirstNameAndLastNameOnSearchCallsWindow(data.get("MemberFirstName"),data.get("MemberLastName"));
						crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
						crSearchCall.searchAndSelectMemberFirstandLastNameOnSearCallWindow(data);
						crSearchCall.clickSearchAgainOnSearchCalls();
						crSearchCall.clickOnClearOnSearchCallsWindow();
		
		
						//22-24
						crSearchCall.enterMemberNumberOnSearchCallsWindow(data.get("MemberNumber"));
						crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
						crSearchCall.enterEndDateOnSearchCallsWindow(data.get("EndDate"));
						crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
						crSearchCall.searchAndSelectMemberNumberOnSearCallWindow(data.get("MemberNumber"));
						crSearchCall.clickSearchAgainOnSearchCalls();
						crSearchCall.clickOnClearOnSearchCallsWindow();
		
						//liveonly
						crSearchCall.enterCallTypeAsLiveOnly(data.get("LiveOnly"));
						crSearchCall.enterStartDateOnSearchCallsWindow(data.get("InvalidStartDate"));
						crSearchCall.enterEndDateOnSearchCallsWindow(data.get("InvalidEndDate"));
						crSearchCall.enterCallIdOnSearchCallsWindow(data.get("CallIDvalue"));
						crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
						crSearchCall.getTextNoMatchingRecords();
						crSearchCall.clickSearchAgainOnSearchCalls();
						crSearchCall.clickOnClearOnSearchCallsWindow();
		
						//live and archived
						crSearchCall.getTextOfCallType();
						crSearchCall.enterStartDateOnSearchCallsWindow(data.get("InvalidArchivedStartDate"));
						crSearchCall.enterEndDateOnSearchCallsWindow(data.get("InvalidArchivedEndDate"));
						crSearchCall.enterCommCenterOnSearchCallsWindow(data.get("commCenter"));
						crSearchCall.enterCallIdOnSearchCallsWindow(data.get("CallIDvalue"));
						String expectedStrDate= crSearchCall.getStartDateSearchDetails();
						//add 2 lines and checkin
						crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
						crSearchCall.verifyStartAndEndDateOnSearchCallWindow(expectedStrDate);
		
						crSearchCall.clickSearchAgainOnSearchCalls();
						crSearchCall.clickOnClearOnSearchCallsWindow();
		
						crSearchCall.clickOnCloseButton();
						crHomeLib.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1685",ReportStatus.strMethodName,intCounter,browser);
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
