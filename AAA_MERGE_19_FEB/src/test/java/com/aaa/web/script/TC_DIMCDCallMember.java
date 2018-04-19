

package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.*;
import com.sun.mail.util.CRLFOutputStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DIMCDCallMember extends ActionEngine {
    String problemTypes;
    String callId;
    String callIdDate;
  
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
    public void CreateCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "MCDCallMember", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("MCDCallMember", TestData, "D3Dispatch",intCounter);
    	
		
		                this.reporter.initTestCaseDescription("2048:TC-DIMCDCallMCDCallMember"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRMemberSearchLib memeber = new CRMemberSearchLib();
		                CRServiceLib crServiceLib = new CRServiceLib();
		                // Logging into the application
		                LoginToCRApplication(data);
		
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
		                //memeber.currentCallClose();
		                memeber.ClickPrimRadioBtnInRowTwo();
		                // Locations Page Starts
		                locations.clickOnLocationTab();
		                //Entering Location Details
		                click(CRLocationsPage.linkManualEntryOnLocationTab,"Enter Address Manually");
		                type(CRLocationsPage.txtStreetAddress,data.get("StreetAddress"),"Street Address");
		                // type(CRLocationsPage.txtLocCity,data.get("City"),"City");
		                click(CRLocationsPage.ddnStateZip,"State ZIP Drop Down");
		                type(CRLocationsPage.txtLocState,data.get("ZIPCode"),"ZIP Code");
		                type(CRLocationsPage.txtLocCity,data.get("City"),"City");
		                type(CRLocationsPage.txtLocCode,data.get("LocationCode"),"Location Code");
		                Thread.sleep(3000);
		                //locations.clickOnSecondKownBrkDowLocation();
		                Thread.sleep(3000);
		                // Vehicle Triage Page Starts here
		                vehicle.clickOnVehicleTriageTab();
		                Thread.sleep(3000);
		                vehicle.clickOnManualEntryLinkOnVehicle();
		                vehicle.enterVehicleType(data.get("VehicleType"));
		                Thread.sleep(3000);
		                vehicle.enterVehicleYear(data.get("VehicleYear"));
		                Thread.sleep(1000);
		                vehicle.enterVehicleMake(data.get("VehicleMake"));
		                Thread.sleep(1000);
		                vehicle.enterVehicleModel(data.get("VehicleModel"));
		                Thread.sleep(1000);
		                vehicle.enterVehicleColor(data.get("VehicleColor"));
		                Thread.sleep(1000);
		                vehicle.clickTag();
		                vehicle.clickonProblemTypeButton(data.get("TriageType"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("TriageOption"));
		                // vehicle.handleScriptErrorInVehicleTriagePage();// If popup comes handle
		                // Navigating to services tab
		                crServiceLib.clickOnServiceTab();
		                home.waitCloseAllBusyIconsResults();
		                crServiceLib.enterManualSpotDetails(data.get("SPPFacilitySpot"));
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                //click(CRServicePage.btnSpot,"SPOT");
		                //vehicle.scriptErrorHandle();
		                home.saveButton();
		                callId = crServiceLib.getCallId();
		                callIdDate = getText(CRServicePage.dateInCallInformationWindow,"Call Date");
		                System.out.println(callId);
		                crServiceLib.closeCall();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2048",ReportStatus.strMethodName,intCounter,browser);
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
    public void DIMCDCallMemberCMButton(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "MCDCallMember", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("MCDCallMember", TestData, "D3Dispatch",intCounter);
    	

		                this.reporter.initTestCaseDescription("2048:TC-DIMCDCallMCDCallMember"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                DISearchCallsLib diSearchCalls = new DISearchCallsLib();
		                CRSearchCallsLib search = new CRSearchCallsLib();
		                DIHomeLib diHome = new DIHomeLib();
		                DILoginLib diLogin = new DILoginLib();
		                DIProfileLib profile = new DIProfileLib();
		                LoginToDIApplication(data);
		
		                //diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                waitForVisibilityOfElement(DISearchCallsPage.btnSearchCallsSPP,"Search Calls");
		                click(DISearchCallsPage.btnSearchCallsSPP,"Search Calls");
		                diSearchCalls.clickAndEnterCallIDInfo(callId);
		                //diSearchCalls.clickAndEnterCallIDInfo(data.get("CallID"));
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
		                Thread.sleep(5000);
		                // Validate MCD Window is opened or not  Step 1
		                waitForVisibilityOfElement(DIMCDPage.MCDWindow,"MCD Window opens successfully");
		                boolean mcdWindow = isVisible(DIMCDPage.MCDWindow,"MCD Window");
		                assertTrue(mcdWindow,"MCD Window opens successfully");
		
		                waitForVisibilityOfElement(DIMCDPage.btnCalldetailsUpdateActionButtons(data.get("ActionButtonName")),""+data.get("ActionButtonName"));
		                click(DIMCDPage.btnCalldetailsUpdateActionButtons(data.get("ActionButtonName")),"CM");
		                waitForVisibilityOfElement(DIMCDPage.lblMemberNeedsCallBack,"Member Needs Call Back");
		                click(DIMCDPage.lblMemberNeedsCallBack,"Member Needs Call Back");
		                boolean phoneicon = isVisible(DIMCDPage.iconPhone,"Phone Icon");
		                assertTrue(phoneicon,"phone icon appears on the MCD");
		                click(DIMCDPage.linkMinimizeMCDwindow,"Minimize MCD Window");
		                waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
		                click(DIHomePage.tabDiProfile, "Profile Menu Item");
		                click(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
		                Thread.sleep(5000);
		                waitForVisibilityOfElement(DIProfilePage.btnVIewHiddenProfile,"View Hidden Profile Button");
		                click(DIProfilePage.btnVIewHiddenProfile,"View Hidden Profile Button");
		                Thread.sleep(1000);
		                click(DIProfilePage.lblHiddenTabNamesInDropDown(data.get("TabName")),""+data.get("TabName"));
		                Thread.sleep(5000);
		                String  callIdDateFor =callIdDate.replaceAll("-","");
		                boolean callIDinCallBackProfiletab = isVisible(DIProfilePage.txtCallidOnProfileWindow(callId,callIdDateFor),"CallId On Call Backs profile tab");
		                assertTrue(callIDinCallBackProfiletab,"call is moved to the Call Back profile tab, call id is: "+callId);
		                Thread.sleep(3000);
		                // verifying phone icon appears in Profile window
		                boolean phoneIcon = isVisible(DIProfilePage.iconPhoneProfileWIndow(callId,callIdDateFor),"Phone Icon on Profile Window");
		                assertTrue(phoneIcon,"phone icon appears on the profile window.");
		                // Close Profie WIndow
		                click(DIProfilePage.iconCloseTheProfile,"Icon Close Profile Window");
		
		                waitForVisibilityOfElement(DISearchCallsPage.btnSearchCallsSPP,"Search Calls");
		                click(DISearchCallsPage.btnSearchCallsSPP,"Search Calls");
		                diSearchCalls.clickAndEnterCallIDInfo(callId);
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
		
		                Thread.sleep(3000);
		                click(DIMCDPage.btnCalldetailsUpdateActionButtons(data.get("ActionButtonNameUP")),"UP");
		                waitForVisibilityOfElement(DIMCDPage.selectOptionsActionsUPButton(data.get("ActionButtonUpOptions")),""+data.get("ActionButtonUpOptions"));
		                Thread.sleep(1000);
		                click(DIMCDPage.selectOptionsActionsUPButton(data.get("ActionButtonUpOptions")),""+data.get("ActionButtonUpOptions"));
		                // Closing MCD window
		                click(DIMCDPage.btnWindowCloseInMCD,"Close MCD Window");
		                Thread.sleep(5000);
		                // Going Back to PRofile Window and checking
		                //click(DIProfilePage.maximizeProfileWinodw,"Profile Window");
		                 Thread.sleep(6000);
		                waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
		                click(DIHomePage.tabDiProfile, "Profile Menu Item");
		                Thread.sleep(1000);
		                click(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
		                Thread.sleep(6000);
		                waitForVisibilityOfElement(DIProfilePage.btnVIewHiddenProfile,"View Hidden Profile Button");
		                click(DIProfilePage.btnVIewHiddenProfile,"View Hidden Profile Button");
		                Thread.sleep(1000);
		                click(DIProfilePage.lblHiddenTabNamesInDropDown(data.get("TabName")),""+data.get("TabName"));
		                callIDinCallBackProfiletab = isVisibleOnly(DIProfilePage.txtCallidOnProfileWindow(callId,callIdDateFor),"CallId On Call Backs profile tab");
		                assertTrue(!callIDinCallBackProfiletab,"call is moved off the Call Back profile tab, call id is: "+callId);
		                // Closing Profile Window
		                click(DIProfilePage.iconCloseTheProfile,"Close Icon Profile Window");
		                diHome.logOut();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2048",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }


    public void LoginToDIApplication(Hashtable<String, String> data) throws Throwable {

        DILoginLib diLogin = new DILoginLib();
        DIHomeLib diHome = new DIHomeLib();
        LoginRoleLib loginRole=new LoginRoleLib();
        navigateToApplication("DI");
        diLogin.login(data.get("SPPDILoginName"), data.get("SPPDIPassword"));
        Thread.sleep(5000);
        diLogin.waitcloseAllBusyIcons();
        if (data.get("SPPUser").equalsIgnoreCase("No")){
        loginRole.clickOnProceedBtnInDispatchRoleLogin();
        }
        //diLogin.waitcloseAllBusyIcons();
        Thread.sleep(5000);
        if (data.get("SPPUser").equalsIgnoreCase("No")) {
            diHome.clickOnCloseIconOnQueueSelection();
        }
        if (data.get("SPPUser").equalsIgnoreCase("Yes")) {
            diHome.closeFacilityWindow();
        }
    }

    public void LoginToCRApplication(Hashtable<String, String> data) throws Throwable {
        LoginLib login = new LoginLib();
        CRHomeLib home = new CRHomeLib();
        // Logging into the application
        navigateToApplication("CR");
        login.login(data.get("LoginName"), data.get("Password"));
        // Need to handle spinner image here
        Thread.sleep(5000);
        home.allErrorAlertsNoButton();
        home.messageDialogBoxClose();
    }
}