package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIMCDArchivedCalls extends DILoginLib {

    String callIDCallReceiving;
    String callIDDispatch;
    public static long ran;
    public static String callID;
    public static String pacesetterCode;
    public static String troubleCode;
    public static String reasonCode;

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

    public void DIMCDArchivedCalls(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMCDArchivedCalls", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMCDArchivedCalls", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("2009: TS-DI MCD Archived Calls"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRServiceLib services = new CRServiceLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                DISearchCallsLib diSearchCalls = new DISearchCallsLib();
		                CR_DI crDI = new CR_DI();
		                DIMCDLib dimcd = new DIMCDLib();
		                LoginRoleLib loginRole=new LoginRoleLib();
		                DILoginLib diLogin = new DILoginLib();
		                CommonLib common = new CommonLib();
		
		                navigateToApplication("DI");
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                if(!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                    diLogin.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                }else {
		                    diLogin.waitcloseAllBusyIcons();
		                    diHome.closeFacilityWindow();
		                }
		                diHome.clickOnSearchCallsLink();
		
		//entering values in searchcalls
		                diSearchCalls.enterStartDate(data.get("startDate"));
		                diSearchCalls.enterEndDate(data.get("endDate"));
		                //diSearchCalls.clickAndEnterCallIDInfo(data.get("callID"));
		                diSearchCalls.enterValueInStatusTextBonInSearchCalls(data.get("status"));
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                //diSearchCalls.selectClearedCallsFromSearchResults();
		               // String rapAvail = diSearchCalls.verifyRAPIDsOnMCD();
		                diSearchCalls.selectClearCallRow();
		//Selecting Archived calls
		               // diSearchCalls.selectClearedCallsFromSearchResults();
		//Validating Update Pannel and bottom 5 buttons
		
		                boolean updatePanelVisibility = dimcd.validateAssign();
		                assertTrue(!updatePanelVisibility,"Update Panel Container is not available");
		                if(!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    boolean editCallButton = dimcd.verifyEditCallButtonOnMCDWindow();
		                    assertTrue(editCallButton, "Edit call button is visible");
		
		                    boolean duplicateCallButton = dimcd.verifyDuplicateCallButtonOnMCDWindow();
		                    assertTrue(duplicateCallButton, "Duplicate Call button is visible");
		                }
		                Thread.sleep(2000);
		                boolean printCallButton = dimcd.verifyPrintCallButtonOnMCDWindow();
		                assertTrue(printCallButton,"Print button is visible");
		                boolean paymentButton = dimcd.verifyPaymentButtonOnMCDWindow();
		                assertTrue(paymentButton,"Payment Button is visible");
		                if(!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    boolean creditCardButton = dimcd.verifyCreditCardButtonOnMCDWindow();
		                    assertTrue(creditCardButton, "Credit card Button is visible");
		                }
		                dimcd.clickOnServiceTabInMCDWindow();
		                dimcd.clickOnAdditionalInfoLinkInMCDServiceTab();
		                dimcd.enterSpecialEquipmentInMCDServiceTab(data.get("specialEqupementInMCD"));
		                dimcd.clickOnSaveButtonInSpecialEquiptmentSection();
		                Thread.sleep(2000);
		                String reasonForStatus = dimcd.enterReasonForStatus(data.get("reasonForStatus"));
		                String comments = dimcd.enterCommentsInUpdateCallStatus(data.get("comments"));
		                dimcd.clickOnUpdateButtonInUpdateStatus();
		                crHomeLib.getErrorMessageTextFromAlert();
		                dimcd.clickOnMCDCloseWindow();
		                diHome.logOut();
		
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2009",ReportStatus.strMethodName,intCounter,browser);
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
