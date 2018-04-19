package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRSearchCallsPage;
import com.aaa.web.page.CRServicePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by e002222 on 16-01-2018.
 */
public class TC_CRDuplicateCall extends ActionEngine {
    public String callid;
    public String callIdOnMemberTab;
    public static long ran;
    public int Num;
    public String RandomNum;
   
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void DuplicateLiveCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DuplicateLiveCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DuplicateLiveCall", TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("1640: TC-Duplicate a Live Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                CRHomeLib home = new CRHomeLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCall.clickOnSearchCalls();
		                Thread.sleep(2000);
		                crSearchCall.enterCallsTypeInSearchCalls(data.get("Calls"));
		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
		                crSearchCall.enterRAPNumberOnSearchCallsWindow(data.get("RAP"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		
		                callid = crSearchCall.getCallIdOnSearCallWindow();
		
		
		
		                String CallIdDate=crSearchCall.getCallIdAndDate();
		
		                String splitStr[] = CallIdDate.split("\n");
		                String startDateValue= splitStr[0];
		
		                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		                Date CurrentCallIdDate = dateFormat.parse(startDateValue);
		
		                System.out.println("CurrentCallIdDate is ++++++++++++++++++++ " +CurrentCallIdDate);
		
		                int oldCallId = Integer.parseInt(callid);
		                crSearchCall.clickDuplicateIconOnSearCallWindow();
		                crSearchCall.clickDuplicateCallIDConfYes();
		                Thread.sleep(4000);
		                member.currentCallClose();
		
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                callIdOnMemberTab = crSearchCall.getCallIdFromMemberTab();
		
		                assertFalse(callIdOnMemberTab.contains(callid), "Call id should not present");
		
		
		                Num = (int) (Math.random() * 90000000) + 10000000;
		                RandomNum = Integer.toString(Num);
		                System.out.println(RandomNum);
		                member.enterRAPonMemberTab(RandomNum);
		                Thread.sleep(2000);
		                member.enterSecondPhoneNumber(data.get("SecondPhoneNumber"));
		                crLocationsLib.clickOnLocationTab();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                service.clickOnServiceTab();
		                crHomeLib.saveButton();
		                Date ptaDate=service.getPTADateAfterCallSave();
		                System.out.println("ptaDate is ++++++++++++++++++++ " +ptaDate);
		                String CDate=service.getCurrentDate();
		
		                String splitStr1[] = CDate.split("\n");
		                String currentdateValue1= splitStr1[0];
		
		                SimpleDateFormat dateFormat11 = new SimpleDateFormat("MM/dd/yyyy");
		                Date CyrrentDte = dateFormat11.parse(currentdateValue1);
		
		                System.out.println("currentDate is ++++++++++++++++++++ " +CyrrentDte);
		
		                if(CurrentCallIdDate.before(CyrrentDte)){
		                 assertTrue(ptaDate.equals(CyrrentDte),"PTA date should be equal to current date i.e. " + CyrrentDte);
		                }
		                else if(CurrentCallIdDate.equals(CyrrentDte)) {
		                    assertTrue(ptaDate.equals(CyrrentDte), "PTA date is equal to todays date");
		                }
		
		                String newCallId = service.getCallId();
		                int CallIdNew = Integer.parseInt(newCallId);
		
		                assertTrue(CallIdNew > 20001, "New Call Id Generated");
		                service.closeCallWindow();
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1640",ReportStatus.strMethodName,intCounter,browser);
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
    public void cancelDuplicateCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "cancelDuplicateCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("cancelDuplicateCall", TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("1640: Cancel a duplicate Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                CRHomeLib home = new CRHomeLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.enterCallsTypeInSearchCalls(data.get("Calls"));
		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
		
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		
		                callid = crSearchCall.getCallIdOnSearCallWindow();
		                int oldCallId = Integer.parseInt(callid);
		                crSearchCall.clickDuplicateIconOnSearCallWindow();
		                crSearchCall.clickDuplicateCallIDConfNo();
		                Thread.sleep(4000);
		                crSearchCall.clickCloseBtnOnSearchCallwindow();
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1640",ReportStatus.strMethodName,intCounter,browser);
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
    public void duplicateAnArchivedCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "duplicateAnArchivedCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("duplicateAnArchivedCall", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1640: Duplicate an Archived call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                CRHomeLib home = new CRHomeLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDateArchive"));
		                crSearchCall.enterEndDateOnSearchCallsWindow(data.get("EndDateArchive"));
		                crSearchCall.enterRAPNumberOnSearchCallsWindow(data.get("RAP"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		
		                callid = crSearchCall.getCallIdOnSearCallWindow();
		
		
		                String CallIdDate=crSearchCall.getCallIdAndDate();
		
		                String splitStr[] = CallIdDate.split("\n");
		                String startDateValue= splitStr[0];
		
		                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		                Date CurrentCallIdDate = dateFormat.parse(startDateValue);
		
		                System.out.println("CurrentCallIdDate is ++++++++++++++++++++ " +CurrentCallIdDate);
		
		
		
		                int oldCallId = Integer.parseInt(callid);
		                crSearchCall.clickDuplicateIconOnSearCallWindow();
		                crSearchCall.clickDuplicateCallIDConfYes();
		                Thread.sleep(4000);
		                member.currentCallClose();
		
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                callIdOnMemberTab = crSearchCall.getCallIdFromMemberTab();
		
		                assertFalse(callIdOnMemberTab.contains(callid), "Call id should not present");
		                Num = (int) (Math.random() * 90000000) + 10000000;
		                RandomNum = Integer.toString(Num);
		                System.out.println(RandomNum);
		                member.enterRAPonMemberTab(RandomNum);
		                Thread.sleep(2000);
		                member.enterSecondPhoneNumber(data.get("SecondPhoneNumber"));
		                crLocationsLib.clickOnLocationTab();
		                crLocationsLib.enterBKDownLocCode(data.get("LocationCode"));
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                service.clickOnServiceTab();
		                crHomeLib.saveButton();
		                Date ptaDate=service.getPTADateAfterCallSave();
		                System.out.println("ptaDate is ++++++++++++++++++++ " +ptaDate);
		                String CDate=service.getCurrentDate();
		
		                String splitStr1[] = CDate.split("\n");
		                String currentdateValue1= splitStr1[0];
		
		                SimpleDateFormat dateFormat11 = new SimpleDateFormat("MM/dd/yyyy");
		                Date CyrrentDte = dateFormat11.parse(currentdateValue1);
		
		                System.out.println("currentDate is ++++++++++++++++++++ " +CyrrentDte);
		                if(CurrentCallIdDate.before(CyrrentDte)){
		                    assertTrue(ptaDate.equals(CyrrentDte),"PTA date should be equal to current date i.e. " + CyrrentDte);
		                }
		                else if(CurrentCallIdDate.equals(CyrrentDte)) {
		                    assertTrue(ptaDate.equals(CyrrentDte), "PTA date is equal to todays date");
		                }
		                String newCallId = service.getCallId();
		                int CallIdNew = Integer.parseInt(newCallId);
		
		                assertTrue(CallIdNew > 20001, "New Call Id Generated");
		                service.closeCallWindow();
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1640",ReportStatus.strMethodName,intCounter,browser);
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
    public void DuplicateLiveCallAfterCallLoads(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DuplicateLiveCallAfterCallLoads", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DuplicateLiveCallAfterCallLoads", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1640: TC-Duplicate a Live Call after call loads from search call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                CRHomeLib home = new CRHomeLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCall.clickOnSearchCalls();
		                Thread.sleep(2000);
		                crSearchCall.enterCallsTypeInSearchCalls(data.get("Calls"));
		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
		                crSearchCall.enterRAPNumberOnSearchCallsWindow(data.get("RAP"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                callid = crSearchCall.getCallIdOnSearCallWindow();
		                //crSearchCall.searchAndSelectCallIDOnSearCallWindow(data);
		                crSearchCall.ClickOnCallIdOnSearchCallsWindow();
		                Thread.sleep(3000);
		
		               //callid = crSearchCall.getCallIdOnRecentCallWindow();
		                int oldCallId = Integer.parseInt(callid);
		                home.duplicateButton();
		                crSearchCall.clickDuplicateCallIDConfYes();
		                home.allErrorAlertsNoButton();
		                home.messageDialogBoxClose();
		
		                Thread.sleep(4000);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(4000);
		                callIdOnMemberTab = crSearchCall.getCallIdFromMemberTab();
		
		               assertFalse(callIdOnMemberTab.contains(callid), "Call id should not present");
		                Num = (int) (Math.random() * 90000000) + 10000000;
		                RandomNum = Integer.toString(Num);
		                System.out.println(RandomNum);
		                member.enterRAPonMemberTab(RandomNum);
		                Thread.sleep(2000);
		                member.enterSecondPhoneNumber(data.get("SecondPhoneNumber"));
		
		
		                //member.currentCallClose();
		
		
		                crLocationsLib.clickOnLocationTab();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                service.clickOnServiceTab();
		                crHomeLib.saveButton();
		
		                Thread.sleep(4000);
		                String newCallId = service.getCallId();
		                Thread.sleep(3000);
		                int CallIdNew = Integer.parseInt(newCallId);
		
		                assertTrue(CallIdNew > 20001, "New Call Id Generated");
		                service.closeCallWindow();
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1640",ReportStatus.strMethodName,intCounter,browser);
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
    public void duplicateAnArchivedRAPCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "duplicateAnArchivedRAPCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("duplicateAnArchivedRAPCall", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1640: TC-Duplicate a Live Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                CRHomeLib home = new CRHomeLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDateArchive"));
		                crSearchCall.enterEndDateOnSearchCallsWindow(data.get("EndDateArchive"));
		                //ran=generateRandomNumber();
		
		                 Num = (int) (Math.random() * 90000000) + 10000000;
		                // use this String wherever you want
		
		                RandomNum = Integer.toString(Num);
		
		               // ordNameValue = ScheduleOrdName + RandomNum;
		                System.out.println(RandomNum);
		                crSearchCall.enterRAPNumberOnSearchCallsWindow(data.get("RAP"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		               // crSearchCall.searchAndSelectRAPOnSearCallWindow(data);
		
		
		
		
		                callid = crSearchCall.getCallIdOnSearCallWindow();
		                int oldCallId = Integer.parseInt(callid);
		                crSearchCall.clickDuplicateIconOnSearCallWindow();
		                crSearchCall.clickDuplicateCallIDConfYes();
		                Thread.sleep(4000);
		                member.currentCallClose();
		
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                callIdOnMemberTab = crSearchCall.getCallIdFromMemberTab();
		
		                assertFalse(callIdOnMemberTab.contains(callid), "Call id should not present");
		
		                member.enterRAPonMemberTab(RandomNum);
		                member.enterSecondPhoneNumber(data.get("SecondPhoneNumber"));
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crLocationsLib.clickOnLocationTab();
		
		                service.clickOnServiceTab();
		                crHomeLib.saveButton();
		                Thread.sleep(4000);
		
		                String newCallId = service.getCallId();
		                int CallIdNew = Integer.parseInt(newCallId);
		
		                assertTrue(CallIdNew > 20001, "New Call Id Generated");
		                service.closeCallWindow();
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1640",ReportStatus.strMethodName,intCounter,browser);
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
    public void duplicateFacilityCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "duplicateFacilityCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("duplicateFacilityCall", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1640: TC-Duplicate a  Facility Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                CRHomeLib home = new CRHomeLib();
		                login.login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.enterStartDateOnSearchCallsWindow(data.get("StartDate"));
		                crSearchCall.enterFacilityOnSearchCallsWindow(data.get("Facility"));
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                // crSearchCall.searchAndSelectRAPOnSearCallWindow(data);
		
		
		
		
		                callid = crSearchCall.getCallIdOnSearCallWindow();
		                int oldCallId = Integer.parseInt(callid);
		                crSearchCall.clickDuplicateIconOnSearCallWindow();
		                crSearchCall.clickDuplicateCallIDConfYes();
		                Thread.sleep(10000);
		
		                member.currentCallCloseForfacilityWithDuplicate();
		                Thread.sleep(4000);
		                Boolean facilityErrorPopupMsgVisible=isVisibleOnly(CRSearchCallsPage.facilityErrorPopupMsg, "Facility Error Message");
		                assertTrue(facilityErrorPopupMsgVisible, "Facility Error Message");
		                //crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(4000);
		                crHomeLib.allErrorAlerts();
		
		                //crVehicleTriageLib.errorAlertHandlingBeforeEnterMandatoryFields();
		                Thread.sleep(4000);
		                //member.currentCallClose();
		                //Thread.sleep(2000);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		
		               // crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(2000);
		                callIdOnMemberTab = crSearchCall.getCallIdFromMemberTab();
		
		                assertFalse(callIdOnMemberTab.contains(callid), "Call id should not present");
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crLocationsLib.clickOnLocationTab();
		                crLocationsLib.enterBKDownLocCode(data.get("LocationCode"));
		                //service.clickOnServiceTab();
		
		                String newFacilityValue=service.validateFacilityAutospotID();
		                assertTrue(newFacilityValue.contains(data.get("Facility")) , "Facility got respot to" + newFacilityValue);
		                Thread.sleep(4000);
		                crHomeLib.saveButton();
		                Thread.sleep(4000);
		
		                String newCallId = service.getCallId();
		                int CallIdNew = Integer.parseInt(newCallId);
		
		                assertTrue(CallIdNew > 20001, "New Call Id Generated");
		                service.closeCallWindow();
		                acceptAlert();
		                home.logout();
		                acceptAlert();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1640",ReportStatus.strMethodName,intCounter,browser);
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