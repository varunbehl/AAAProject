package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E003999 on 02-01-2018.
 */
public class TC_DIProfileBeyondETATab extends DILoginLib {
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
    public void profileBeyondETATab(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "ProfileBeyondETATab", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ProfileBeyondETATab", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1768: DI Profile Beyond ETA Tab"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                DIHomeLib diHome = new DIHomeLib();
		                DIMCDLib diMCD = new DIMCDLib();
		                LoginLib login = new LoginLib();
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib memeber = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		                LoginRoleLib loginRole = new LoginRoleLib();
		                //DI
		                navigateToApplication("DI");
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnProfileMenu();
		                diHome.clickOnParamUnderProfileMenu();
		                Thread.sleep(10000);
		                diHome.clickOnHiddenTabsDropdown();
		                diHome.selectBeyonETATabOnHiddenTab();
		
		                // diHome.logOut();
		
		                //CR
		                navigateToApplication("CR");
		                login.login(data.get("LoginNameForCR"), data.get("PasswordForCR"));
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
		                //home.memberSearchTextBox(data.get("MemberNumber"));
		                memeber.memberNumClick();
		                locations.clickOnLocationTab();
		                locations.enterTxtinBrkDowLocSrch(data.get("NoFacilityAddress"));
		                locations.brkDowLocSrchBtn();
		                locations.clickOnLocationResultsLink();
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		                vehicle.selectVehicleModel();
		                vehicle.errorAlertHandlingBeforeEnterMandatoryFields();
		                service.clickOnServiceTab();
		                home.saveButton();
		
		
		                //DI
		                navigateToApplication("DI");
		                // login(data.get("LoginNameForDI"),data.get("PasswordForDI"));
		                // loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnProfileMenu();
		                diHome.clickOnParamUnderProfileMenu();
		                Thread.sleep(10000);
		                diHome.clickOnHiddenTabsDropdown();
		                diHome.selectBeyonETATabOnHiddenTab();
		                diHome.clickOnParamWindow();
		                diHome.verifyStatusinBeyondETATab(data.get("RE Status"));
		                // diHome.logOut();
		
		                //CR
		                navigateToApplication("CR");
		                //login.login(data.get("LoginNameForCR"),data.get("PasswordForCR"));
		                home.messageDialogBoxClose();
		                home.memberSearchTextBox(Member);
		                memeber.memberNumClick();
		                locations.clickOnLocationTab();
		                locations.enterTxtinBrkDowLocSrch(data.get("BreakDownLocation"));
		                locations.brkDowLocSrchBtn();
		                locations.clickOnLocationResultsLink();
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		                vehicle.selectVehicleModel();
		                vehicle.errorAlertHandlingBeforeEnterMandatoryFields();
		                service.clickOnServiceTab();
		                home.saveButton();
		                String callID = service.getCallId();
		
		                //DI
		                navigateToApplication("DI");
		
		
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnProfileMenu();
		                diHome.clickOnParamUnderProfileMenu();
		                Thread.sleep(10000);
		                diHome.clickOnHiddenTabsDropdown();
		                diHome.selectBeyonETATabOnHiddenTab();
		                diHome.clickOnParamWindow();
		                diHome.verifyStatusinBeyondETATab(data.get("SP Status"));
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.searchAndSelectCallIDInDI(callID);
		                diMCD.clickOnETAButtonOnMCDWindow();
		                diMCD.setTimeForETA();
		                Thread.sleep(360000);
		                diHome.clickOnProfileMenu();
		                // diHome.clickOnHiddenTabsDropdown();
		                //diHome.selectBeyonETATabOnHiddenTab();
		                //diHome.clickOnParamWindow();
		                diHome.verifyStatusinBeyondETATab(data.get("SP Status"));
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.searchAndSelectCallIDInDI(callID);
		                diMCD.clickOnAssign();
		                diMCD.selectSecondFacilityOnAssignTabInMCD();
		                //
		                diHome.clickOnProfileMenu();
		                diHome.clickOnParamUnderProfileMenu();
		                Thread.sleep(10000);
		                diHome.clickOnHiddenTabsDropdown();
		                diHome.selectBeyonETATabOnHiddenTab();
		                diHome.clickOnParamWindow();
		                diHome.verifyStatusinBeyondETATab(data.get("AS Status"));
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.searchAndSelectCallIDInDI(callID);
		                diMCD.selectDispatch();
		                //diMCD.selectSecondFacilityOnDispatchTabInMCD();
		                //
		                diHome.clickOnProfileMenu();
		                diHome.clickOnParamUnderProfileMenu();
		                Thread.sleep(10000);
		                // diHome.clickOnHiddenTabsDropdown();
		                //diHome.selectBeyonETATabOnHiddenTab();
		                //diHome.clickOnParamWindow();
		                diHome.verifyStatusinBeyondETATab(data.get("DI Status"));
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.searchAndSelectCallIDInDI(callID);
		                diMCD.selectEnroute();
		                diMCD.selectEnrouteTime();
		                //
		                diHome.clickOnProfileMenu();
		                diHome.clickOnParamUnderProfileMenu();
		                Thread.sleep(10000);
		                //diHome.clickOnHiddenTabsDropdown();
		                //diHome.selectBeyonETATabOnHiddenTab();
		                //diHome.clickOnParamWindow();
		                diHome.verifyStatusinBeyondETATab(data.get("ER Status"));
		                Thread.sleep(360000);
		                diHome.verifyStatusinBeyondETATab(data.get("ER Status"));
		                diHome.clickOnSearchCallsInDispatch();
		
		                diHome.searchAndSelectCallIDInDI(callID);
		                Thread.sleep(3000);
		                diMCD.clickOnStatusUpdateTabOnMCDWindow();
		                diMCD.enterStatusOnStatusUpdateTab(data.get("Status"));
		                diMCD.enterReasonOnStatusUpdateTab(data.get("Reason"));
		                diMCD.clickOnUpdate();
		                diHome.logOut();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1768",ReportStatus.strMethodName,intCounter,browser);
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
    public void profileBeyondETATabOnPoppedOutWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "ProfileBeyondETATab", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ProfileBeyondETATab", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1768: DI Profile Beyond ETA Tab"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                DIHomeLib diHome = new DIHomeLib();
		                DIMCDLib diMCD = new DIMCDLib();
		                LoginLib login = new LoginLib();
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib memeber = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		                LoginRoleLib loginRole = new LoginRoleLib();
		
		
		                navigateToApplication("DI");
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnProfileMenu();
		                diHome.clickOnParamUnderProfileMenu();
		                Thread.sleep(10000);
		                diHome.clickOnHiddenTabsDropdown();
		                diHome.selectBeyonETATabOnHiddenTab();
		                diHome.clickToOpenPoppedOutWindow();
		                switchToWindow();
		                diHome.clickToOpenPoppedOutWindow();
		                switchToWindow();
		                //diHome.clickToMinimizeProfileWindow();
		
		
		                //CR
		                navigateToApplication("CR");
		                login.login(data.get("LoginNameForCR"), data.get("PasswordForCR"));
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
		                //home.memberSearchTextBox(Member);
		                memeber.memberNumClick();
		                locations.clickOnLocationTab();
		                locations.enterTxtinBrkDowLocSrch(data.get("NoFacilityAddress"));
		                locations.brkDowLocSrchBtn();
		                locations.clickOnLocationResultsLink();
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		                vehicle.selectVehicleModel();
		                vehicle.errorAlertHandlingBeforeEnterMandatoryFields();
		                service.clickOnServiceTab();
		                home.saveButton();
		                //DI
		                navigateToApplication("DI");
		                // login(data.get("LoginNameForDI"),data.get("PasswordForDI"));
		                // loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnProfileMenu();
		                diHome.clickOnParamUnderProfileMenu();
		                Thread.sleep(10000);
		                diHome.clickOnHiddenTabsDropdown();
		                diHome.selectBeyonETATabOnHiddenTab();
		                diHome.clickToOpenPoppedOutWindow();
		                diHome.verifyStatusinBeyondETATab(data.get("RE Status"));
		                switchToWindow();
		                diHome.clickToOpenPoppedOutWindow();
		                switchToWindow();
		
		
		                // diHome.logOut();
		
		                //CR
		                navigateToApplication("CR");
		                //login.login(data.get("LoginNameForCR"),data.get("PasswordForCR"));
		                home.messageDialogBoxClose();
		                home.memberSearchTextBox(Member);
		                memeber.memberNumClick();
		                locations.clickOnLocationTab();
		                locations.enterTxtinBrkDowLocSrch(data.get("BreakDownLocation"));
		                locations.brkDowLocSrchBtn();
		                locations.clickOnLocationResultsLink();
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		                vehicle.selectVehicleModel();
		                vehicle.errorAlertHandlingBeforeEnterMandatoryFields();
		                service.clickOnServiceTab();
		                home.saveButton();
		                String callID2 = service.getCallId();
		
		                //DI
		                navigateToApplication("DI");
		                // login(data.get("LoginNameForDI"),data.get("PasswordForDI"));
		                //loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnProfileMenu();
		                diHome.clickOnParamUnderProfileMenu();
		                Thread.sleep(10000);
		                diHome.clickOnHiddenTabsDropdown();
		                diHome.selectBeyonETATabOnHiddenTab();
		                diHome.clickToOpenPoppedOutWindow();
		                switchToWindow();
		                diHome.verifyStatusinBeyondETATab(data.get("SP Status"));
		                diHome.clickToOpenPoppedOutWindow();
		                switchToWindow();
		                Thread.sleep(10000);
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.searchAndSelectCallIDInDI(callID2);
		                diMCD.clickOnETAButtonOnMCDWindow();
		                diMCD.setTimeForETA();
		                Thread.sleep(360000);
		                diHome.clickOnProfile();
		                diHome.clickOnHiddenTabsDropdown();
		                diHome.selectBeyonETATabOnHiddenTab();
		                diHome.clickToOpenPoppedOutWindow();
		                switchToWindow();
		                diHome.verifyStatusinBeyondETATab(data.get("SP Status"));
		                diHome.clickToOpenPoppedOutWindow();
		                switchToWindow();
		                Thread.sleep(10000);
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.searchAndSelectCallIDInDI(callID2);
		                diMCD.clickOnAssign();
		                diMCD.selectSecondFacilityOnAssignTabInMCD();
		                //
		                diHome.clickOnProfileMenu();
		                diHome.clickOnParamUnderProfileMenu();
		                Thread.sleep(10000);
		                diHome.clickOnHiddenTabsDropdown();
		                diHome.selectBeyonETATabOnHiddenTab();
		                diHome.clickToOpenPoppedOutWindow();
		                switchToWindow();
		                diHome.verifyStatusinBeyondETATab(data.get("AS Status"));
		                diHome.clickToOpenPoppedOutWindow();
		                switchToWindow();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.searchAndSelectCallIDInDI(callID2);
		                diMCD.selectDispatch();
		                //diMCD.selectSecondFacilityOnDispatchTabInMCD();
		                //
		                diHome.clickOnProfileMenu();
		                diHome.clickOnParamUnderProfileMenu();
		                Thread.sleep(10000);
		                // diHome.clickOnHiddenTabsDropdown();
		                // diHome.selectBeyonETATabOnHiddenTab();
		                diHome.clickToOpenPoppedOutWindow();
		                switchToWindow();
		                diHome.verifyStatusinBeyondETATab(data.get("DI Status"));
		                diHome.clickToOpenPoppedOutWindow();
		                switchToWindow();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.searchAndSelectCallIDInDI(callID2);
		                diMCD.selectEnroute();
		                diMCD.selectEnrouteTime();
		                //
		                diHome.clickOnProfileMenu();
		                diHome.clickOnParamUnderProfileMenu();
		                Thread.sleep(10000);
		                // diHome.clickOnHiddenTabsDropdown();
		                //diHome.selectBeyonETATabOnHiddenTab();
		                diHome.clickToOpenPoppedOutWindow();
		                switchToWindow();
		                diHome.verifyStatusinBeyondETATab(data.get("ER Status"));
		                Thread.sleep(360000);
		                diHome.verifyStatusinBeyondETATab(data.get("ER Status"));
		                diHome.clickToOpenPoppedOutWindow();
		                switchToWindow();
		
		                diHome.clickOnSearchCallsInDispatch();
		
		                diHome.searchAndSelectCallIDInDI(callID2);
		                Thread.sleep(3000);
		                diMCD.clickOnStatusUpdateTabOnMCDWindow();
		                diMCD.enterStatusOnStatusUpdateTab(data.get("Status"));
		                diMCD.enterReasonOnStatusUpdateTab(data.get("Reason"));
		                diMCD.clickOnUpdate();
		                diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1768",ReportStatus.strMethodName,intCounter,browser);
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
