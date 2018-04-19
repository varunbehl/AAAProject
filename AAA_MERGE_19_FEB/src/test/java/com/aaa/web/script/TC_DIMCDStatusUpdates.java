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

public class TC_DIMCDStatusUpdates extends ActionEngine {
	//String callId1;
	String callID;
	String currentStatus;
	String nextStatus;
	String spotStatus;
	String assignStatus;
	String currentStatusData;
	String nextStatusData;
	String dispatchStatus;
	String enrouteStatus;
	String onLocationStatus;
	String towStatus;
	String clearStatus;
	String bidStatus;

	DIHomeLib diHome = new DIHomeLib();
	LoginLib login = new LoginLib();
	DILoginLib diLogin = new DILoginLib();
	LoginRoleLib role = new LoginRoleLib();
	DIMCDLib mcdlib = new DIMCDLib();
	CRServiceLib service = new CRServiceLib();
	CRTowDestinationLib tow = new CRTowDestinationLib();
	CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
	CRHomeLib crHomeLib = new CRHomeLib();
	CRLocationsLib crLocationsLib = new CRLocationsLib();
	CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
	public static String Member = "";
	CRMemberSearchLib member = new CRMemberSearchLib();
	CRHomeLib home = new CRHomeLib();
	DILoginLib diLoginLib = new DILoginLib();


	public void createCallForDispatchMCDStatusUpdate(Hashtable<String,String> data)throws  Throwable {
		try {
			this.reporter.initTestCaseDescription("1713: TC-Update Calls");
			login.login(data.get("LoginName"), data.get("Password"));
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
			member.clickPrimRadioBtnSecondRow();
			crLocationsLib.clickOnLocationTab();
			crLocationsLib.enterTxtinBrkDowLocSrch(data.get("Breakdownaddress"));
			crLocationsLib.brkDowLocSrchBtn();
			crLocationsLib.brkdowLocAddrLink();
			crLocationsLib.acceptAddressDifferenceAlert();
			crLocationsLib.brkdownLocationCode(dataBean.getValue(data, "Breakdownlocationcode"));
			crVehicleTriageLib.clickOnVehicleTriageTab();

			crVehicleTriageLib.enterVehicleSearch(data.get("VehicleDetails"));
			Thread.sleep(2000);
			crVehicleTriageLib.clickOnTheVehicleSearchIcon();
			crVehicleTriageLib.clickOnTheVehicleSearch();
			// crVehicleTriageLib.availableVehicleaftersrch();
			Thread.sleep(2000);
			crVehicleTriageLib.enterVehicleColor(data.get("Color"));
			//*crVehicleTriageLib.clickOnFuel();
			//crVehicleTriageLib.clickOnOutOfGas();//
			crVehicleTriageLib.clickonProblemTypeButton(data.get("ProblemType"));
			Thread.sleep(3000);
			crVehicleTriageLib.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
			Thread.sleep(3000);
			//crHomeLib.allErrorAlerts();
			crVehicleTriageLib.scriptErrorHandle();
			Thread.sleep(2000);
			tow.clickOnTowDestinationTab();
			crHomeLib.waitCloseAllBusyIconsResults();
			crVehicleTriageLib.scriptErrorHandle();
			crHomeLib.allErrorAlerts();
			Thread.sleep(3000);
			tow.clickOnAARTowDetinationLink();
			//tow.clickOnManualEntryLinkOnTowDestination();
			tow.enterTowPassengers(data.get("TowPassengers"));
			Thread.sleep(2000);
			service.clickOnServiceTab();
			crHomeLib.waitCloseAllBusyIconsResults();
			service.enterManualSpotDetails(data.get("SPPFacilitySpot"));
			crVehicleTriageLib.scriptErrorHandle();
			crHomeLib.saveButton();
			crHomeLib.waitCloseAllBusyIconsResults();
			Thread.sleep(3000);
			//  callId1 = service.getCallId();
			callID = service.getCallId();
			service.closeCall();
			crHomeLib.logout();
			acceptAlert();
			Thread.sleep(2000);
			acceptAlert();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
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
	public void saveCallForStatusUpdateButton(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "saveCallForLiveCallSearchstatusUpdateButtonDI", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("saveCallForLiveCallSearchstatusUpdateButtonDI", TestData, "D3CallRecieving",intCounter);
    	
						this.reporter.initTestCaseDescription("1788 dispatch Status Update Buttons"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						createCallForDispatchMCDStatusUpdate(data);

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1788",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

	// dispatch MCD Window
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
	public void statusUpdatesOnDIMCDWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMCDWindowStatusUpdates", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMCDWindowStatusUpdates", TestData, "D3Dispatch",intCounter);
    	
						this.reporter.initTestCaseDescription("1788 dispatch Status Update Buttons"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						navigateToApplication("DI");
						Thread.sleep(8000);
						diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
						Thread.sleep(3000);
						role.clickOnProceedBtnInDispatchRoleLogin();
						diLoginLib.waitcloseAllBusyIcons();
						diHome.clickOnCloseIconOnQueueSelection();
						diHome.clickOnSearchCallsInDispatch();
						//diHome.enterCallIDInfo(callId1);
						diHome.enterCallIDInfo(callID);
						diHome.clickOnSearchInSearchCalls();
						crHomeLib.waitCloseAllBusyIconsResults();
						diHome.clickOnCallDateOrIDLink();
						crHomeLib.waitCloseAllBusyIconsResults();
						currentStatus = mcdlib.getStatusOnCurrentButton();
						nextStatus = mcdlib.getStatusOnNextButton();
						spotStatus = mcdlib.getCallStatusOnMCDwindow();
		
						currentStatusData = data.get("CurrentStatus");
						nextStatusData = data.get("NextStatus");
		
						boolean statusFlag1 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
						assertTrue(statusFlag1, "SP button is highlighted and the AS button  is marked as the next status");
						mcdlib.clickOnAssign();
						mcdlib.selectSecondFacilityOnAssignTabInMCD();
		
						Thread.sleep(3000);
						assignStatus = mcdlib.getCallStatusOnMCDwindow();
						assertTrue(spotStatus != assignStatus, "Status changed from  SP  To As ");
		
						currentStatus = mcdlib.getStatusOnCurrentButton();
						nextStatus = mcdlib.getStatusOnNextButton();
						//spotStatus = mcdlib.getCallStatusOnMCDwindow();
		
						boolean statusFlag2 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
						assertTrue(statusFlag2, " AS button is highlighted and the DI status button is marked as the next status");
						mcdlib.selectDispatch();
						dispatchStatus = mcdlib.getCallStatusOnMCDwindow();
						assertTrue(assignStatus != dispatchStatus, "Status changed from  AS To DI " );
		
						currentStatus = mcdlib.getStatusOnCurrentButton();
						nextStatus = mcdlib.getStatusOnNextButton();
						boolean statusFlag3 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
						assertTrue(statusFlag3, "DI button is highlighted and the ER status button  is marked as the next status");
		
						mcdlib.selectEnroute();
						mcdlib.selectEnrouteTime();
						Thread.sleep(2000);
		
						enrouteStatus = mcdlib.getCallStatusOnMCDwindow();
						assertTrue(dispatchStatus != enrouteStatus, "Status changed from   DI To EN ");
						currentStatus = mcdlib.getStatusOnCurrentButton();
						nextStatus = mcdlib.getStatusOnNextButton();
						boolean statusFlag4 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
						assertTrue(statusFlag4, " ER button is highlighted and the OL status button  is marked as the next status");
		
						mcdlib.selectOnLocation();
						Thread.sleep(2000);
						onLocationStatus = mcdlib.getCallStatusOnMCDwindow();
						assertTrue(enrouteStatus != onLocationStatus, "Status changed from  En To OL ");
		
						currentStatus = mcdlib.getStatusOnCurrentButton();
						nextStatus = mcdlib.getStatusOnNextButton();
						boolean statusFlag5 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
						assertTrue(statusFlag5, "OL button is highlighted and the TW status button is marked as the next status");
		
						mcdlib.clickOnTW();
						Thread.sleep(2000);
						towStatus = mcdlib.getCallStatusOnMCDwindow();
						assertTrue(onLocationStatus != towStatus, "Status changed from  OL To TW ");
						currentStatus = mcdlib.getStatusOnCurrentButton();
						nextStatus = mcdlib.getStatusOnNextButton();
						boolean statusFlag6 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
						assertTrue(statusFlag6, "TW button is highlighted and the CL status button is marked as the next status");
						//Payment
						mcdlib.paymentForRAPCall(data.get("cost"),data.get("cashCollected"),data.get("serviceType"),data.get("towServiceType"));
		
		
						mcdlib.selectClearCall();
		
		
						Thread.sleep(3000);
						boolean clearingTabFlag = mcdlib.verifyClearingTabOnSPPMCDWindow();
						assertTrue(clearingTabFlag, "Clearing tab is Visible on MCD Window after click On call");
		
						mcdlib.clickOnNoGo();
						mcdlib.selectExitCode();
						mcdlib.clickOnContinue();
						Thread.sleep(3000);
						mcdlib.clickOnOriginalTowDestination();
						mcdlib.clickOnContinue();
						Thread.sleep(5000);
						mcdlib.clickOnSubmitButton();
						Thread.sleep(3000);
						clearStatus = mcdlib.getCallStatusOnMCDwindow();
						assertTrue(towStatus != clearStatus, "The status of the call changed to cl  ");
						mcdlib.clickOnMCDCloseWindow();
						diHome.logOut();
						acceptAlert();
						Thread.sleep(2000);
						acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1788",ReportStatus.strMethodName,intCounter,browser);
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
	public void saveCallForPoppedInWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "saveCallForLiveCallSearchstatusUpdateButtonDI", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("saveCallForLiveCallSearchstatusUpdateButtonDI", TestData, "D3CallRecieving",intCounter);
    	
						this.reporter.initTestCaseDescription("1788 dispatch Status Update Buttons"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						createCallForDispatchMCDStatusUpdate(data);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1788",ReportStatus.strMethodName,intCounter,browser);
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
	public void buttonStatusUpdatesOnMCDPoppedInWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"DIMCDWindowStatusUpdates", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMCDWindowStatusUpdates", TestData, "D3Dispatch",intCounter);
    	
						this.reporter.initTestCaseDescription("1788 dispatch Status Update Buttons"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						navigateToApplication("DI");
						Thread.sleep(8000);
						diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
						Thread.sleep(3000);
						role.clickOnProceedBtnInDispatchRoleLogin();
						diLoginLib.waitcloseAllBusyIcons();
						diHome.clickOnCloseIconOnQueueSelection();
						diHome.clickOnSearchCallsInDispatch();
						//  diHome.enterCallIDInfo(callId1);
						diHome.enterCallIDInfo(callID);
						diHome.clickOnSearchInSearchCalls();
						crHomeLib.waitCloseAllBusyIconsResults();
						diHome.clickOnCallDateOrIDLink();
						crHomeLib.waitCloseAllBusyIconsResults();
		
						//Calling method
						bidStatusverificationOnMCD(data);
						mcdlib.clickOnMCDCloseWindow();
						diHome.logOut();
						acceptAlert();
						Thread.sleep(2000);
						acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1788",ReportStatus.strMethodName,intCounter,browser);
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
	public void saveCallForPoppedOutWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "saveCallForLiveCallSearchstatusUpdateButton", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("saveCallForLiveCallSearchstatusUpdateButton", TestData, "D3CallRecieving",intCounter);
    	
						this.reporter.initTestCaseDescription("1788 dispatch Status Update Buttons"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						createCallForDispatchMCDStatusUpdate(data);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1788",ReportStatus.strMethodName,intCounter,browser);
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
	public void buttonStatusUpdatesOnMCDPoppedOutWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMCDWindowStatusUpdates", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMCDWindowStatusUpdates", TestData, "D3Dispatch",intCounter);
    	
						this.reporter.initTestCaseDescription("1788 dispatch Status Update Buttons"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						navigateToApplication("DI");
						Thread.sleep(8000);
						diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
						Thread.sleep(3000);
						role.clickOnProceedBtnInDispatchRoleLogin();
						diLoginLib.waitcloseAllBusyIcons();
						diHome.clickOnCloseIconOnQueueSelection();
						diHome.clickOnSearchCallsInDispatch();
						//   diHome.enterCallIDInfo(callId1);
						diHome.enterCallIDInfo(callID);
						diHome.clickOnSearchInSearchCalls();
						crHomeLib.waitCloseAllBusyIconsResults();
						diHome.clickOnCallDateOrIDLink();
						crHomeLib.waitCloseAllBusyIconsResults();
		
						mcdlib.clickOnPoppedOutButton();
						crHomeLib.waitCloseAllBusyIconsResults();
						switchToWindow();
						Thread.sleep(3000);
						boolean poppedoutFlag = mcdlib.verifyPoppedOutWindow();
						assertTrue(poppedoutFlag, "Switched To PoppedOut MCD window ");
						bidStatusverificationOnMCD(data);
						mcdlib.clickOnPoppedInButton();
						//Calling method
						switchToWindow();
						mcdlib.clickOnMCDCloseWindow();
						diHome.logOut();
						acceptAlert();
						Thread.sleep(2000);
						acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1788",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }


	public void bidStatusverificationOnMCD(Hashtable<String, String> data) throws Throwable {
		try {
			currentStatus = mcdlib.getStatusOnCurrentButton();
			nextStatus = mcdlib.getStatusOnNextButton();
			spotStatus = mcdlib.getCallStatusOnMCDwindow();
			currentStatusData = data.get("CurrentStatus");
			nextStatusData = data.get("NextStatus");
			Thread.sleep(3000);
			boolean statusFlag1 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
			assertTrue(statusFlag1, "SP button is highlighted and the AS button  is marked as the next status");

			mcdlib.clickOnBidCallButton();
			bidStatus = mcdlib.getCallStatusOnMCDwindow();
			assertTrue(spotStatus != assignStatus, "Status changed from  SP To BD ");

			currentStatus = mcdlib.getStatusOnCurrentButton();
			nextStatus = mcdlib.getStatusOnNextButton();
			//spotStatus = mcdlib.getCallStatusOnMCDwindow();

			boolean statusFlag2 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
			assertTrue(statusFlag2, " The BD button highlighted and the AS button should be marked as the next status");
			mcdlib.clickOnAssign();
			Thread.sleep(2000);
			mcdlib.selectSecondFacilityOnAssignTabInMCD();
			String asStatus = mcdlib.getCallStatusOnMCDwindow();
			assertTrue(bidStatus != asStatus, "Status changed from  BD To AS ");
			currentStatus = mcdlib.getStatusOnCurrentButton();
			nextStatus = mcdlib.getStatusOnNextButton();
			//spotStatus = mcdlib.getCallStatusOnMCDwindow();

			boolean statusFlag3 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
			assertTrue(statusFlag3, " AS button is highlighted with the DI button marked as the next status");

			mcdlib.clickOnDeclineButton();
			String declineBtnStatus = mcdlib.getCallStatusOnMCDwindow();
			assertTrue(asStatus != declineBtnStatus, "Status changed from AS TO DC  ");
			currentStatus = mcdlib.getStatusOnCurrentButton();
			nextStatus = mcdlib.getStatusOnNextButton();
			//spotStatus = mcdlib.getCallStatusOnMCDwindow();

			boolean statusFlag4 = mcdlib.verifyTheStatusChange(currentStatus, nextStatus, currentStatusData, nextStatusData);
			assertTrue(statusFlag4, " DC button is highlighted and  AS button is marked as the next status");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
