package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIMCDEditServiceTabAdditionalInfo extends DILoginLib {

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

    public void MCDEditServiceTabAdditionalInfo(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "MCDEditServiceTabAdditionalInfo", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("MCDEditServiceTabAdditionalInfo", TestData, "D3Dispatch",intCounter);
		    	
		                this.reporter.initTestCaseDescription("2046: DI MCD Edit Service Tab Additional Info "+ " From Iteration " + StartRow + " to " + EndRow );
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
		
		                common.crCallCreation(data.get("CRLoginName"),data.get("CRPassword"),data.get("LoginRoleCallReceiving"),data.get("role"),
		                        data.get("Member"),data.get("Membersearch"),data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),data.get("PhoneNumber"),data.get("Primaryphonenum1"),
		                        data.get("VehicleSearch"),data.get("VehicleDetails"),data.get("ProblemTriage"),data.get("ProblemType"),
		                        data.get("WillThisCallBeATow"),data.get("TowDestination"),data.get("RSPReferral"),data.get("TowAddress"),
		                        data.get("OmniBarAddress"));
		                services.clickOnServiceTab();
		
		                if(data.get("sppUser").equalsIgnoreCase("Yes")) {
		                    Thread.sleep(5000);
		                    services.enterManualSpotDetails(data.get("facilityNumber"));
		                    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		
		                }
		                services.enterSpecialEquipement(data.get("specialequipement"));
		                home.saveButton();
		                //crHomeLib.allErrorAlerts();
		                crHomeLib.allErrorAlerts();
		                callID = services.getCallId();
		                services.closeCall();
		                Thread.sleep(4000);
		                home.logout();
		
		                navigateToApplication("DI");
		                login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                if(!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                    Thread.sleep(4000);
		                    diLogin.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                }else {
		                    diLogin.waitcloseAllBusyIcons();
		                    Thread.sleep(5000);
		                    diHome.closeFacilityWindow();
		                }
		
		                diLogin.waitcloseAllBusyIcons();
		
		                diHome.clickOnSearchCallsLink();
		
		                diHome.searchAndSelectCallIDInDI(callID);
		                dimcd.clickOnServiceTabInMCDWindow();
		                dimcd.clickOnAdditionalInfoLinkInMCDServiceTab();
		                String specialEqupementInMCD = dimcd.enterSpecialEquipmentInMCDServiceTab(data.get("specialEqupementInMCD"));
		                Thread.sleep(2000);
		                dimcd.clickOnSaveButtonInSpecialEquiptmentSection();
		                String updateStatus=dimcd.getStatusUpdateValueInMCDWindow();
		                String reasonForStatus = dimcd.enterReasonForStatus(data.get("reasonForStatus"));
		                String comments = dimcd.enterCommentsInUpdateCallStatus(data.get("comments"));
		                dimcd.clickOnUpdateButtonInUpdateStatus();
		                crHomeLib.getErrorMessageTextFromAlert();
		                Thread.sleep(3000);
		
		                String latestComments=dimcd.getlblLatestCommentsInMCDWindow();
		                Boolean resultsForComments=dimcd.compareTwoValues(latestComments,comments);
		                assertTrue(resultsForComments,"Comments are saved in comments section");
		                dimcd.clickOnStatusHistoryLinkOnMCDWindow();
		                dimcd.clickOnDateHeaderToSortDate();
		                dimcd.getStatusInHistoryStatusScreenInMCDWindow();
		                dimcd.clickOnMCDCloseWindow();
		                diHome.logOut();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2046",ReportStatus.strMethodName,intCounter,browser);
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
