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


public class TC_DIMCDEditTowDestination extends DILoginLib {

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

    public void DIMCDEditTowDestination(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMCDEditTowDestination", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMCDEditTowDestination", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("2037: TS-DI MCD Edit Tow Destination"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                //CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRServiceLib services = new CRServiceLib();
		                //CRTowDestinationLib tow = new CRTowDestinationLib();
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
		                diSearchCalls.enterValueInStatusTextBonInSearchCalls(data.get("status"));
		                diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
		                diSearchCalls.selectSPStatusRowInSearchCallDispatch();
		                dimcd.clickOnLocationsTabInMCDWindow();
		                dimcd.clickOnBreakDownLocationsEditLinkInMCD();
		                dimcd.enterAddressInSearvicesInMCDWindow(data.get("addressSearch"));
		                dimcd.clickOnSearchButtonInServicesInMCDWindow();
		                boolean emptryRecords= dimcd.getEmptryRecordErrorMessageInMCD();
		                boolean recordsPanelNotFund = dimcd.verifySearchResultsGridAvailablity();
		                if(emptryRecords==true || recordsPanelNotFund==true)  {
		                    String searchedAddress =dimcd.getAddressFromResults();
		                    dimcd.clickOnTowDestinationAddressInResultsGrid();
		                    dimcd.getValueOfStreetNumberInMCDWindow();
		                    dimcd.getValueOfStreetNameInMCDWindow();
		                    dimcd.getValueOfCityInMCD();
		                    dimcd.getValueOfFirstCrossStreetInMCD();
		                    dimcd.getValueOfSecondCrossStreetInMCD();
		                    dimcd.getValueOfStateInMCD();
		                    dimcd.getValueOfZipInMCD();
		                    dimcd.getValueOfLandMarkInMCD();
		                    dimcd.getValueOfLatitudeInMCD();
		                    dimcd.getValueOfLongitudeInMCD();
		                    if(!(data.get("sppUser").equalsIgnoreCase("Yes"))) {
		                        dimcd.getAddressVerifiedInMCD();
		                    }else{
		                        dimcd.clickOnGetCoOrdinatesInMCD();
		                        dimcd.getAddressVerifiedInMCD();
		                    }
		                    String comments=dimcd.enterCommentsInTowDestinationAndLocationsTabsInMCDWindow(data.get("comments"));
		                    dimcd.enterUpdateReasonInMCD(data.get("reasonForStatus"));
		               /* String reasonForStatus = dimcd.enterReasonForStatus(data.get("reasonForStatus"));
		                String comments = dimcd.enterCommentsInUpdateCallStatus(data.get("comments"));
		               */
		
		                    dimcd.clickOnSaveButtonInMCDWindow();
		                    boolean errorAvailability=dimcd.verifyErrorMessageAvailability();
		                    if(errorAvailability)
		                    {
		                    dimcd.validateErrorMessage();
		                    //crHomeLib.getErrorMessageTextFromAlert();
		                    dimcd.clickOnErrorOkayButtonInMCDWindow();
		                    }else{
		                        //dimcd.closeBreakDownLocaitonTabInMCD();
		                        String latestComments=dimcd.getlblLatestCommentsInMCDWindow();
		                        Boolean resultsForComments=dimcd.compareTwoValues(latestComments,comments);
		                        assertTrue(resultsForComments,"Comments are saved in comments section");
		                        dimcd.clickOnStatusHistoryLinkOnMCDWindow();
		                        dimcd.clickOnDateHeaderToSortDate();
		                        dimcd.getStatusInHistoryStatusScreenInMCDWindow();
		
		                    }
		                }else
		                {
		                    assertTrue(emptryRecords|| recordsPanelNotFund," Records found");
		
		                }
		
		
		
		                dimcd.clickOnMCDCloseWindow();
		                diHome.logOut();
		
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2037",ReportStatus.strMethodName,intCounter,browser);
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
