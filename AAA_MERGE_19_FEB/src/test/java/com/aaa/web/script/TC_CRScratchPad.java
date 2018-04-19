package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRMemberSearchPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E003999 on 18-12-2017.
 */
public class TC_CRScratchPad extends LoginLib {
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void scratchPad(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "scratchPad",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("scratchPad",TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR ScratchPad"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib memeber = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                home.verifyHomeScreen();
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
		                memeber.memberNumClick();
		                memeber.verifyScratchPad();
		                memeber.enterTextInScratchPad(data.get("BreakdownAddress"));
		                locations.clickOnLocationTab();
		                dragAndDropFromScratchPad(data);
		                vehicle.selectVehicleModel();
		                service.clickOnServiceTab();
		                home.saveButton();
		                String callID = service.getCallId();
		                service.closeCall();
		                home.clickOnSearchCallDroupDown();
		                home.clickOnSearchCallsLink();
		                home.enterCallIdForSearch(callID);
		                home.clickOnSearchButtonOnSearchCalls();
		                memeber.verifyTheCreatedCall(callID);
		                memeber.closeSearchCallsWindow();
		
		                home.logout();
		                System.out.println("Test completed");
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

    public void dragAndDropFromScratchPad(Hashtable<String, String> data) throws Throwable {
        CRLocationsLib locations = new CRLocationsLib();
        //dragAndDrop(CRMemberSearchPage.txtScratchPad, CRLocationsPage.txtBrkDowLocSrch, "BreakdownLocation search bar");
        type(CRLocationsPage.txtBrkDowLocSrch,data.get("BreakdownAddress"),"Breakdown location");
        clearData(CRMemberSearchPage.txtScratchPad);
        boolean closeScratchPad = isVisibleOnly(CRMemberSearchPage.iconScratchPadClose,"Scrach Pad Close icon");
        if (closeScratchPad){
        	click(CRMemberSearchPage.iconScratchPadClose,"Scrach Pad Close icon");
        }
        click(CRLocationsPage.btnBrkDowLocSrch, "Breakdown Location search button");
        click(CRLocationsPage.linkBrkDowSrchAddress, "BreakDown location");
        locations.enterBKDownLocCode(data.get("LocationCode"));

    }
}

