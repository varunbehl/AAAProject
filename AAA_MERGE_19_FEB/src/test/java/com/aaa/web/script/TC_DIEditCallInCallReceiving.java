package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRSearchCallsPage;
import com.aaa.web.page.DIHomePage;
import com.aaa.web.page.DIMCDPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E002734 on 1/29/2018.
 */
public class TC_DIEditCallInCallReceiving  extends ActionEngine {




	LoginLib login = new LoginLib();
	CRMemberSearchLib member = new CRMemberSearchLib();
	CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
	CRLocationsLib location = new CRLocationsLib();
	CRTowDestinationLib towdestination = new CRTowDestinationLib();
	CRHomeLib home = new CRHomeLib();
	CRServiceLib service = new CRServiceLib();
	CRServiceLib services = new CRServiceLib();
	DIMCDLib dimcdLib = new DIMCDLib();
	DIHomeLib diHome = new DIHomeLib();
	DILoginLib diLoginLib = new DILoginLib();
	LoginRoleLib role = new LoginRoleLib();
	public static String callID;
	CRSearchCallsLib  searchCall=new CRSearchCallsLib();

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
	public void diEditCallInCallRecevingLiveOnly(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		 try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "diEditCallInCallRecevingLiveOnly", TestData, "D3Dispatch");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("diEditCallInCallRecevingLiveOnly", TestData, "D3Dispatch",intCounter);
	    	
						this.reporter.initTestCaseDescription("1745: TC-DI_Edit Call In Call Receving"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						loginD3ToSearchCallInDispatch(data);
		
						//live
						diHome.enterCallTypeAsLiveOnlyInDispatch(data.get("LiveOnly"));
						diHome.enterCallIDInfo(callID);
						diHome.clickOnSearchInSearchCalls();
						diHome.clickOnCallDateOrIDLink();
						dimcdLib.mousehoverAndClickOnPencil();
						Thread.sleep(8000);
						home.allErrorAlerts();
						vehicle.handleScriptErrorInVehicleTriagePage();
						/*String callIdValue=	searchCall.getCallIdInSearchCall();
						assertTextStringMatching(callID,callIdValue);*/
						switchToWindow();
						vehicle.handleScriptErrorInVehicleTriagePage();
						vehicle.clickOnVehicleTriageTab();
						vehicle.handleScriptErrorInVehicleTriagePage();
						vehicle.selectExistingVehicleModel();
		
						vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
						Thread.sleep(2000);
						vehicle.clickonProblemTypeButton(data.get("ProblemType1"));
						Thread.sleep(2000);
						vehicle.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
						service.clickOnServiceTab();
						Thread.sleep(3000);
						service.validateNoFacilityAutoSpot();
						Thread.sleep(2000);
						home.saveButton();
						service.clickOnCancel();
						home.allErrorAlerts();
						driver.close();
		
						diHome.getTextDispatchTitle();
						dimcdLib.clickOnMCDCloseWindow();
						diHome.clickOnSearchCallsInDispatch();
						diHome.enterCallTypeAsLiveOnlyInDispatch(data.get("LiveOnly"));
						diHome.enterCallIDInfo(callID);
						diHome.clickOnSearchInSearchCalls();
						diHome.clickOnCallDateOrIDLink();
						dimcdLib.getPacesetterValue();
						dimcdLib.clickOnAddButton();
						dimcdLib.enterAddCommentAndSave(data.get("AddComment"));
						dimcdLib.clickOnCommentedData();
						dimcdLib.clickOnMCDCloseWindow();
						diHome.logOut();
	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("DI","1745",ReportStatus.strMethodName,intCounter,browser);
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
	public void diEditCallInCallRecevingArchivedCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		 try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "diEditCallInCallRecevingArchivedCall", TestData, "D3Dispatch");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("diEditCallInCallRecevingArchivedCall", TestData, "D3Dispatch",intCounter);
	    	
						this.reporter.initTestCaseDescription("1745: TC-DI_Edit Call In Call Receving"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						loginD3ToSearchCallInDispatch(data);
		
					//archivedcall
						diHome.enterStartDateOnSearchCallsWindow(data.get("StartDateArchive"));
						diHome.enterEndDateOnSearchCallsWindow(data.get("EndDateArchive"));
						diHome.enterCallIDInfo(callID);
						diHome.clickOnSearchInSearchCalls();
						diHome.clickOnCallDateOrIDLink();
						dimcdLib.clickOnPencilIcon();
						Thread.sleep(8000);
						home.allErrorAlerts();
						vehicle.handleScriptErrorInVehicleTriagePage();
						switchToWindow();
						vehicle.handleScriptErrorInVehicleTriagePage();
						home.getTextD3CallReceivingText();
						home.logout();
	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("DI","1745",ReportStatus.strMethodName,intCounter,browser);
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
	public void openCallReceivingSession(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		 try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "openCallReceivingSession", TestData, "D3Dispatch");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("openCallReceivingSession", TestData, "D3Dispatch",intCounter);
	    	
							this.reporter.initTestCaseDescription("1745: TC-DI_Edit Call In Call Receving"+ " From Iteration " + StartRow + " to " + EndRow );
							reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
							loginD3ToSearchCallInDispatch(data);
			
							//live
							diHome.enterCallTypeAsLiveOnlyInDispatch(data.get("LiveOnly"));
							diHome.enterCallIDInfo(callID);
							diHome.clickOnSearchInSearchCalls();
							diHome.clickOnCallDateOrIDLink();
							dimcdLib.clickOnPencilIcon();
							Thread.sleep(8000);
							home.allErrorAlerts();
							vehicle.handleScriptErrorInVehicleTriagePage();
			
							switchToWindow();
							vehicle.handleScriptErrorInVehicleTriagePage();
							home.getTextD3CallReceivingText();
							home.logout();
	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("DI","1745",ReportStatus.strMethodName,intCounter,browser);
	    		}
	    	}
	    	catch (Exception e) 
	    	{
	    		e.printStackTrace();
	    		throw new RuntimeException(e);
	    	}
	    	ReportControl.fnNextTestJoin(nextTestJoin);
	    }


	public void loginD3ToSearchCallInDispatch(Hashtable<String, String> data) throws Throwable
	   {

		login.login(data.get("LoginName"), data.get("Password"));
		member.clickOnPartialCallCloseButton();
		home.messageDialogBoxClose();
		String Member = "";
		if (data.get("Member").equals("db")) {
			//fetch member details from db
			//generating a random number everytime to fetch a new record everytime
			int rownum = IntRandomNumberGenerator(50, 1000);
			//member from db
			Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
			System.out.println("member : " + Member);
		} else {
			Member = data.get("Membersearch");
		}
		home.memberSearchTextBox(Member);
		//home.memberSearchTextBox(data.get("Membersearch"));
		member.memberNumClick();
		member.currentCallClose();
		member.clickPrimRadioBtnSecondRow();
		location.clickOnLocationTab();
		Thread.sleep(5000);
		location.clickOnManualEntryLinkInLocation();
		Thread.sleep(2000);
		location.enterNonMandatoryFieldsInLocations(data.get("LandMark"), data.get("Address"), data.get("crossStreet"), data.get("secondCrossStreet"), data.get("Zip"));
		location.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"), data.get("City"), data.get("State"), data.get("LocationCode"));
		Thread.sleep(2000);
		location.enterBKDownLocCode(data.get("LocationCode"));
		//location.clickOnLocationCodeDropDown();
		Thread.sleep(5000);
		//vehicle
		enterVehicleDetailsInVehicleTraige(data);
		vehicle.clickonProblemTypeButton(data.get("ProblemType7"));
		Thread.sleep(2000);
		vehicle.clickonProblemTypeOptions(data.get("ProblemType7Option1"));
		Thread.sleep(2000);
		vehicle.handleScriptErrorInVehicleTriagePage();
		Thread.sleep(1000);
		towdestination.clickOnTowDestinationTab();
		Thread.sleep(3000);
		vehicle.handleScriptErrorInVehicleTriagePage();
		Thread.sleep(3000);
		towdestination.clickOnManualEntryLinkOnTowDestination();
		Thread.sleep(3000);
		towdestination.enterTowLocationName(data.get("TDLocationAddress"));
		towdestination.enterFirstCrossStreet(data.get("TDcrossStreet"));
		towdestination.enterSecondCrossStreet(data.get("TDsecondCrossStreet"));
		towdestination.enterCityCodeInTow(data.get("TDCity"));
		towdestination.enterStateInTow(data.get("TDState"));
		towdestination.enterLandMarkInTow(data.get("TDLandMark"));
		towdestination.enterTowPassengers(data.get("Towpassengers"));

		home.saveButton();
		home.allErrorAlerts();
		//services.getCallId();
		callID = services.getCallId();
		services.clickOnRemainInCall();
		vehicle.handleScriptErrorInVehicleTriagePage();
		diHome.logOut();
		   Thread.sleep(3000);
		vehicle.handleScriptErrorInVehicleTriagePage();
		acceptAlert();
		acceptAlert();
		acceptAlert();

		navigateToApplication("DI");
		diLoginLib.login(data.get("DILoginName"),data.get("DIPassword"));
		role.clickOnProceedBtnInDispatchRoleLogin();
		diLoginLib.waitcloseAllBusyIcons();
		diHome.clickOnCloseIconOnQueueSelection();
		  // dimcdLib.clickOnMCDCloseWindow();
		diHome.clickOnSearchCallsInDispatch();


	}



	public void enterVehicleDetailsInVehicleTraige(Hashtable<String, String> data) throws Throwable{


		vehicle.clickOnVehicleTriageTab();
		Thread.sleep(3000);
		vehicle.clickOnManualEntryLinkOnVehicle();
		Thread.sleep(3000);
		vehicle.enterVehicleType(data.get("VehicleType"));
		vehicle.clickOnTheTypeSearchFromDropDown();
		vehicle.enterVehicleYear(data.get("VehicleYear"));
		Thread.sleep(2000);
		vehicle.enterVehicleMake(data.get("VehicleMake"));
		vehicle.enterVehicleModel(data.get("VehicleModel"));
		vehicle.enterVehicleColor(data.get("VehicleColor"));

	}




}
