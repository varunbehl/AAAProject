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

public class TC_CRRecentCalls extends ActionEngine {
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void recentCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "RecentCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("RecentCall", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1912_Recent Calls"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRLocationsLib location = new CRLocationsLib();
		                CRHomeLib home = new CRHomeLib();
		                CRServiceLib service = new CRServiceLib();
		                CRRecentCallsLib recent = new CRRecentCallsLib();
		
		                navigateToApplication("CR");
		                Thread.sleep(1000);
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
		                member.currentCallClose();
		               // member.enterPhoneNumber(data.get("PhoneNumber"));
		               // member.selectType(data.get("PhoneType"));
		                member.clickPrimRadioBtnRowOne();
		                location.clickOnLocationTab();
		                location.clickOnSecondKownBrkDowLocation();
		                vehicle.clickOnVehicleTriageTab();
		                vehicle.selectExistingVehicleModel();
		                vehicle.clickOnFuel();
		                vehicle.clickOnOutOfGas();
		                home.saveButton();
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                String callID = service.getCallId();
		                service.closeCallWindow();
		
		                home.clickOnSearchCallDroupDown();
		                recent.clickOnRecentCallsFromDropDownMenu();
		                recent.verifyRecentCallsOptionName();
		                recent.verifyMostRecentlyAssociatedCallsWindow();
		                recent.getCallDateIDLabel();
		                recent.getContactInformationLabel();
		                recent.getVehicleInformationLabel();
		                recent.getActionLabel();
		                String memberNumberFromRecentCalls=recent.getMemberNumberfromRecentCallSearch(callID);
		                recent.searchAndSelectCallIDOnSearCallWindow(callID);
		                home.waitCloseAllBusyIconsResults();
		                String memberNumber=member.labelMemberShipNumberInMemberDetailsSection();
		                recent.verifyeMberNumberInLoadedCall(memberNumberFromRecentCalls,memberNumber);
		                Thread.sleep(4000);
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1912",ReportStatus.strMethodName,intCounter,browser);
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
