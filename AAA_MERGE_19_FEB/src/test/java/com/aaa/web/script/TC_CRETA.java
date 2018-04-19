package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E003999 on 17-01-2018.
 */
public class TC_CRETA extends LoginLib {
   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void eta(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "ETA", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ETA", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1725:CR_ETA"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                LoginRoleLib loginRole = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                DIMCDLib diMCD = new DIMCDLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                navigateToApplication("CR");
		                home.verifyandClickLogout();
		                login(data.get("LoginName"), data.get("Password"));
		                home.messageDialogBoxClose();
		                member.currentCallClose();
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
		                //home.memberSearchTextBox(data.get("MemberSearch"));
		                member.memberNumClick();
		                locations.clickOnLocationTab();
		                enterBreakDownLocation(data);
		                vehicle.selectVehicleModel();
		                service.clickOnServiceTab();
		                home.saveButton();
		                String callID = service.getCallId();
		                service.closeCall();
		                home.verifyandClickLogout();
		                login(data.get("LoginName"), data.get("Password"));
		                home.messageDialogBoxClose();
		                member.clickOnPartialCallCloseButton();
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();
		                crSearchCall.enterCallIdOnSearchCallsWindow(callID);
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.clickOnCallIdDateOnSearchCallsWindow();
		                Thread.sleep(10000);
		                crSearchCall.clickOnCurrentCallsDropDown();
		                crSearchCall.clickOnSendETARequestLink();
		                openURLInNewWindow("https://qaautoap1.national.aaa.com:8443/D3Dispatch/login.jsp");
		                switchToWindow();
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                boolean messagePopup = diHome.verifyHyperLinkOnMessagePopup();
		                assertTrue(messagePopup, "Message popup Appeared");
		                diHome.verifyETStatusOnMessagePopup();
		                diHome.clickOnCallIDOfMessagePopUp(callID);
		                diMCD.clickOnETAButtonOnMCDWindow();
		                diMCD.setTimeForETA();
		                String etaOnMCD = diMCD.verifyETATimeOnMCDWindow();
		                diHome.clickOnMessagePopUpButton();
		                diHome.clearAllMessagesInMessagepopup();
		                home.allErrorAlerts();
		                diHome.logOut();
		                closeWindow();
		                switchToWindow();
		                home.verifyPopupMessageForETAUpdate();
		                String etaOnCRHome = home.verifyETATime();
		                assertTrue(etaOnMCD.equalsIgnoreCase(etaOnCRHome), "ETA Time is updated");
		                home.verifyandClickLogout();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1725",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    public void enterBreakDownLocation(Hashtable<String, String> data) throws Throwable {
        CRLocationsLib locations = new CRLocationsLib();
        type(CRLocationsPage.txtBrkDowLocSrch, data.get("BreakdownAddress"), "Breakdown location");
        click(CRLocationsPage.btnBrkDowLocSrch, "Breakdown Location search button");
        click(CRLocationsPage.linkBrkDowSrchAddress, "BreakDown location");
        locations.enterBKDownLocCode(data.get("LocationCode"));
    }
}
