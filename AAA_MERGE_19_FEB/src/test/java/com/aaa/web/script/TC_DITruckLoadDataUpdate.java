package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DISearchCallsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DITruckLoadDataUpdate extends LoginLib {
    public static String callID;
    LoginLib login = new LoginLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib services = new CRServiceLib();
    DILoginLib diLoginLib = new DILoginLib();
    LoginRoleLib role = new LoginRoleLib();
    DIHomeLib diHome = new DIHomeLib();
    DIMCDLib dimcdLib = new DIMCDLib();
    DISearchCallsPage diSearchCallsPage = new DISearchCallsPage();
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String callDateCreated;
    public static String callIDAndDateCombined;
    public static String [] callandfacilityId = new String[4];
    CRSearchCallsLib crSearchCallsLib = new CRSearchCallsLib();
    DITruckLoadDeafultViewLib DITruckload= new DITruckLoadDeafultViewLib();

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
    public void verifyDITruckLoadDataUpdate(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"verifyDITruckLoadDataUpdate", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyDITruckLoadDataUpdate", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1806:TC_DI Truck Load Data Update"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                /*navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.setTruckAtoInactive();
		                //itu action TC_DITruckLoadDataUpdate_Mobile
		                //diHome.verifyTrucksettoActive();
		                diHome.logOut();
		*/
		
		                //new call//d3 call recev.
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
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
		                crHomeLib.memberSearchTextBox(Member);
		                //crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickOnSecondKownBrkDowLocation();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.clickOnOutOfGas();
		                services.clickOnServiceTab();
		                services.enterManualFacilityNumber(data.get("spotFacilityID"));
		                services.clickOnSpotInServicePage();
		                completeCall(data.get("CompleteCall"));
		                crHomeLib.logout();
		
		                //d3 dispatch truckload//truck to acive
		                navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.setTruckBtoActive();
		                DITruckload.verifyIconChangeToActive(data.get("TruckBactive"));
		                diHome.logOut();
		
		
		                //D3 SPP DISPTACH//assign driver
		                // navigateToApplication("DI");
		                diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnFacilityPTA();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
		                diHome.clickOnSearchInSearchCalls();
		                diHome.clickOnCallDateOrIDLink();
		                dimcdLib.clickOnAssign();
		                dimcdLib.selectFacilityOnAssignTabForDataUpdate();  //assign to B
		                diHome.logOut();
		
		
		                //d3 dispatch truckload//verify assign Status
		                navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.clickOnTruckB();
		                callFlow(data);
		                dimcdLib.lblCallAssignedStatus(data.get("StatusupdateAS"));
		                diHome.logOut();
		
		
		                //D3 SPP DISPTACH//select dispatch
		                // navigateToApplication("DI");
		                diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnFacilityPTA();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
		                diHome.clickOnSearchInSearchCalls();
		                diHome.clickOnCallDateOrIDLink();
		                dimcdLib.selectDispatch();
		                diHome.logOut();
		
		                //d3 dispatch truckload//verify dispatch status
		                // navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.clickOnTruckB();
		                callFlow(data);
		                dimcdLib.lblCallDispatchedStatus(data.get("StatusupdateDI"));
		                diHome.logOut();
		
		                //D3 SPP DISPTACH//select enrout
		                //  navigateToApplication("DI");
		                diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnFacilityPTA();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
		                diHome.clickOnSearchInSearchCalls();
		                diHome.clickOnCallDateOrIDLink();
		                dimcdLib.selectEnroute();
		                dimcdLib.selectEnrouteTime();
		                diHome.logOut();
		
		
		                //d3 dispatch truckload// verify enroute status
		                //  navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.clickOnTruckB();
		                callFlow(data);
		                dimcdLib.lblCallENRouteStatus(data.get("StatusupdateER"));
		                diHome.logOut();
		
		
		                //D3 SPP DISPTACH//select location
		                //  navigateToApplication("DI");
		                diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnFacilityPTA();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
		                diHome.clickOnSearchInSearchCalls();
		                diHome.clickOnCallDateOrIDLink();
		                dimcdLib.selectOnLocation();
		                diHome.logOut();
		
		
		                //d3 dispatch truckload//verify location status
		                // navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.clickOnTruckB();
		                callFlow(data);
		                dimcdLib.lblCallOnLocationStatus(data.get("StatusupdateOL"));
		                diHome.logOut();
		
		                //d3 call receiving//cancel call
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crSearchCallsLib.clickOnSearchCalls();
		                crSearchCallsLib.enterCallIdOnSearchCallsWindow(callandfacilityId[0]);
		                crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
		                diHome.clickOnCallDateOrIDLink();
		                Thread.sleep(5000);
		                crHomeLib.cancelButton();
		                crHomeLib.allErrorAlerts();
		                crHomeLib.clickOnContinueButtonOnKillCallPopup();
		                crHomeLib.logout();
		
		
		                //d3 dispatch truckload//verify call clear
		                navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.clickOnTruckB();
		                callFlow(data);
		                dimcdLib.labelCallCleared(data.get("StatusupdateCL"));
		                diHome.logOut();
		
		
		                //D3 SPP DISPTACH//clear and submit
		                //  navigateToApplication("DI");
		                diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnFacilityPTA();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
		                diHome.clickOnSearchInSearchCalls();
		                diHome.clickOnCallDateOrIDLink();
		                dimcdLib.selectClearCall();
		                Thread.sleep(3000);
		                dimcdLib.selectCancelinClearCall();
		                dimcdLib.selectServiceNotEnroute();
		                dimcdLib.clickOnSubmit();
		                diHome.logOut();
		
		                //d3 dispatch truckload//verify call is not present or removed
		                //  navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.clickOnTruckB();
		                callFlow(data);
		                diHome.logOut();
		
		
		                //D3 SPP DISPTACH//out of vehicle
		                //  navigateToApplication("DI");
		                diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnFacilityPTA();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.setTruckBToOutOfVehicle();
		                diHome.logOut();
		
		                //d3 dispatch truckload//verify out of vehicle
		                // navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.clickOnTruckB();
		                DITruckload.verifyTruckBStatusOutOfVehicle();
		                diHome.logOut();
		
		                //D3 SPP DISPTACH//in vehicle
		                //  navigateToApplication("DI");
		                diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnFacilityPTA();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.setTruckBToInVehicle();
		                diHome.logOut();
		
		                //d3 dispatch truckload//verify in vehicle
		                //  navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.clickOnTruckB();
		                DITruckload.verifyTruckBStatusInVehicle();
		                diHome.logOut();
		
		                //D3 SPP DISPTACH//add comments
		                //  navigateToApplication("DI");
		                diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnFacilityPTA();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.clickOnTruckBToAddComment();
		                DITruckload.mouseHoverOnDefaultTruckLoad();
		                DITruckload.clickSetDriverCommentDefaultTruckLoad();
		                DITruckload.typeDrivercomment(data.get("DriverComment"));
		                DITruckload.clickDrivercommentSaveBtn();
		                diHome.logOut();
		
		                //d3 dispatch truckload//verify comment
		                // navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.verifyDriverComment();
		
		                //D3 SPP DISPTACH//remocve comments
		                //  navigateToApplication("DI");
		                diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnFacilityPTA();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.clickOnTruckBToAddComment();
		                DITruckload.mouseHoverOnDefaultTruckLoad();
		                DITruckload.clickClearDriverCommentDefaultTruckLoad();
		                diHome.logOut();
		
		                //d3 dispatch truckload//verify remove comment
		                //  navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.verifyDriverCommentClear();
		                diHome.logOut();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1806",ReportStatus.strMethodName,intCounter,browser);
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
        public void verifyDITruckLoadDataUpdateInPopOut(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    		try
        	{
        		int intStartRow=StartRow;
        		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyDITruckLoadDataUpdate", TestData, "D3Dispatch");
        		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
        		{
        			try {
        					ReportStatus.fnDefaultReportStatus();
        					ReportControl.intRowCount=intCounter;
        					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyDITruckLoadDataUpdate", TestData, "D3Dispatch",intCounter);
        	
		                    this.reporter.initTestCaseDescription("1806:TC_DI Truck Load Data Update"+ " From Iteration " + StartRow + " to " + EndRow );
		                    reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                /*navigateToApplication("DI");
		                diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                Thread.sleep(5000);
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diLoginLib.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnTruckLoadTab();
		                diHome.clickOnTruckLoadDefaultOption();
		                diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                DITruckload.setTruckAtoInactive();
		                //itu action TC_DITruckLoadDataUpdate_Mobile
		                //diHome.verifyTrucksettoActive();
		                diHome.logOut();
		*/
		
		                    //new call//d3 call recev.
		                    navigateToApplication("CR");
		                    login(data.get("LoginName"), data.get("Password"));
		                    Thread.sleep(5000);
		                    crMemberSearchLib.clickOnPartialCallCloseButton();
		                    crHomeLib.messageDialogBoxClose();
		                    Thread.sleep(5000);
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
		                    crHomeLib.memberSearchTextBox(Member);
		                    //crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		                    crMemberSearchLib.memberNumClick();
		                    crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                    crLocationsLib.clickOnLocationTab();
		                    //select location
		                    crLocationsLib.clickOnSecondKownBrkDowLocation();
		                    crVehicleTriageLib.clickOnVehicleTriageTab();
		                    crVehicleTriageLib.selectExistingVehicleModel();
		                    crVehicleTriageLib.clickOnFuel();
		                    crVehicleTriageLib.clickOnOutOfGas();
		                    services.clickOnServiceTab();
		                    services.enterManualFacilityNumber(data.get("spotFacilityID"));
		                    services.clickOnSpotInServicePage();
		                    completeCall(data.get("CompleteCall"));
		                    crHomeLib.logout();
		
		                    //d3 dispatch truckload//truck to acive
		                    navigateToApplication("DI");
		                    diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.setTruckBtoActive();
		                    DITruckload.verifyIconChangeToActive(data.get("TruckBactive"));
		                    diHome.logOut();
		
		
		                    //D3 SPP DISPTACH//assign driver
		                    // navigateToApplication("DI");
		                    diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                    diHome.clickOnSearchCallsInDispatch();
		                    diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
		                    diHome.clickOnSearchInSearchCalls();
		                    diHome.clickOnCallDateOrIDLink();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    dimcdLib.clickOnAssign();
		                    dimcdLib.selectFacilityOnAssignTabForDataUpdate();  //assign to B
		                    diHome.logOut();
		
		
		                    //d3 dispatch truckload//verify assign Status
		                    navigateToApplication("DI");
		                    diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.clickOnTruckB();
		                    callFlow(data);
		                    dimcdLib.lblCallAssignedStatus(data.get("StatusupdateAS"));
		                    diHome.logOut();
		
		
		                    //D3 SPP DISPTACH//select dispatch
		                    // navigateToApplication("DI");
		                    diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                    diHome.clickOnSearchCallsInDispatch();
		                    diHome.enterCallIDInfo( callandfacilityId[0]); //callIDCreated
		                    diHome.clickOnSearchInSearchCalls();
		                    diHome.clickOnCallDateOrIDLink();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    dimcdLib.selectDispatch();
		                    diHome.logOut();
		
		                    //d3 dispatch truckload//verify dispatch status
		                    // navigateToApplication("DI");
		                    diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.clickOnTruckB();
		                    callFlow(data);
		                    dimcdLib.lblCallDispatchedStatus(data.get("StatusupdateDI"));
		                    diHome.logOut();
		
		                    //D3 SPP DISPTACH//select enrout
		                    //  navigateToApplication("DI");
		                    diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                    diHome.clickOnSearchCallsInDispatch();
		                    diHome.enterCallIDInfo( callandfacilityId[0]); //callIDCreated
		                    diHome.clickOnSearchInSearchCalls();
		                    diHome.clickOnCallDateOrIDLink();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    dimcdLib.selectEnroute();
		                    dimcdLib.selectEnrouteTime();
		                    diHome.logOut();
		
		
		                    //d3 dispatch truckload// verify enroute status
		                    //  navigateToApplication("DI");
		                    diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.clickOnTruckB();
		                    callFlow(data);
		                    dimcdLib.lblCallENRouteStatus(data.get("StatusupdateER"));
		                    diHome.logOut();
		
		
		                    //D3 SPP DISPTACH//select location
		                    //  navigateToApplication("DI");
		                    diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                    diHome.clickOnSearchCallsInDispatch();
		                    diHome.enterCallIDInfo( callandfacilityId[0]); //callIDCreated
		                    diHome.clickOnSearchInSearchCalls();
		                    diHome.clickOnCallDateOrIDLink();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    dimcdLib.selectOnLocation();
		                    diHome.logOut();
		
		
		                    //d3 dispatch truckload//verify location status
		                    // navigateToApplication("DI");
		                    diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.clickOnTruckB();
		                    callFlow(data);
		                    dimcdLib.lblCallOnLocationStatus(data.get("StatusupdateOL"));
		                    diHome.logOut();
		
		                    //d3 call receiving//cancel call
		                    navigateToApplication("CR");
		                    login(data.get("LoginName"), data.get("Password"));
		                    Thread.sleep(5000);
		                    crMemberSearchLib.clickOnPartialCallCloseButton();
		                    crHomeLib.messageDialogBoxClose();
		                    Thread.sleep(5000);
		                    crSearchCallsLib.clickOnSearchCalls();
		                    crSearchCallsLib.enterCallIdOnSearchCallsWindow( callandfacilityId[0]);
		                    crSearchCallsLib.clickOnSearchBtnOnSearchCallsWindow();
		                    diHome.clickOnCallDateOrIDLink();
		                    Thread.sleep(5000);
		                    crHomeLib.cancelButton();
		                    crHomeLib.allErrorAlerts();
		                    crHomeLib.clickOnContinueButtonOnKillCallPopup();
		                    crHomeLib.logout();
		
		
		                    //d3 dispatch truckload//verify call clear
		                    navigateToApplication("DI");
		                    diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.clickOnTruckB();
		                    callFlow(data);
		                    dimcdLib.labelCallCleared(data.get("StatusupdateCL"));
		                    diHome.logOut();
		
		
		                    //D3 SPP DISPTACH//clear and submit
		                    //  navigateToApplication("DI");
		                    diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                    diHome.clickOnSearchCallsInDispatch();
		                    diHome.enterCallIDInfo( callandfacilityId[0]); //callIDCreated
		                    diHome.clickOnSearchInSearchCalls();
		                    diHome.clickOnCallDateOrIDLink();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    dimcdLib.selectClearCall();
		                    Thread.sleep(3000);
		                    dimcdLib.selectCancelinClearCall();
		                    dimcdLib.selectServiceNotEnroute();
		                    dimcdLib.clickOnSubmit();
		                    diHome.logOut();
		
		                    //d3 dispatch truckload//verify call is not present or removed
		                    //  navigateToApplication("DI");
		                    diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.clickOnTruckB();
		                    callFlow(data);
		                    diHome.logOut();
		
		
		                    //D3 SPP DISPTACH//out of vehicle
		                    //  navigateToApplication("DI");
		                    diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.setTruckBToOutOfVehicle();
		                    diHome.logOut();
		
		                    //d3 dispatch truckload//verify out of vehicle
		                    // navigateToApplication("DI");
		                    diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.clickOnTruckB();
		                    DITruckload.verifyTruckBStatusOutOfVehicle();
		                    diHome.logOut();
		
		                    //D3 SPP DISPTACH//in vehicle
		                    //  navigateToApplication("DI");
		                    diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.setTruckBToInVehicle();
		                    diHome.logOut();
		
		                    //d3 dispatch truckload//verify in vehicle
		                    //  navigateToApplication("DI");
		                    diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.clickOnTruckB();
		                    DITruckload.verifyTruckBStatusInVehicle();
		                    diHome.logOut();
		
		                    //D3 SPP DISPTACH//add comments
		                    //  navigateToApplication("DI");
		                    diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.clickOnTruckBToAddComment();
		                    DITruckload.mouseHoverOnDefaultTruckLoad();
		                    DITruckload.clickSetDriverCommentDefaultTruckLoad();
		                    DITruckload.typeDrivercomment(data.get("DriverComment"));
		                    DITruckload.clickDrivercommentSaveBtn();
		                    diHome.logOut();
		
		                    //d3 dispatch truckload//verify comment
		                    // navigateToApplication("DI");
		                    diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.verifyDriverComment();
		
		                    //D3 SPP DISPTACH//remocve comments
		                    //  navigateToApplication("DI");
		                    diLoginLib.login(data.get("DISPPLoginName"), data.get("DISPPPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnFacilityPTA();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.clickOnTruckBToAddComment();
		                    DITruckload.mouseHoverOnDefaultTruckLoad();
		                    DITruckload.clickClearDriverCommentDefaultTruckLoad();
		                    diHome.logOut();
		
		                    //d3 dispatch truckload//verify remove comment
		                    //  navigateToApplication("DI");
		                    diLoginLib.login(data.get("DILoginName"), data.get("DIPassword"));
		                    Thread.sleep(5000);
		                    role.clickOnProceedBtnInDispatchRoleLogin();
		                    diLoginLib.waitcloseAllBusyIcons();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                    diHome.clickOnTruckLoadTab();
		                    diHome.clickOnTruckLoadDefaultOption();
		                    dimcdLib.clickOnPoppedOutButtonInActionRequiredTab();
		                    diHome.verifyAndEnterSpotFacilityIDInfoOnTruckLoad(data.get("spotFacilityID"));
		                    DITruckload.verifyDriverCommentClear();
		                    diHome.logOut();

        			}
        			catch(Exception e)
        			{
        				ReportStatus.blnStatus=false;
        			}
        			ReportControl.fnEnableJoin();
        			ReportStatus.fnUpdateResultStatus("DI","1806",ReportStatus.strMethodName,intCounter,browser);
        		}
        	}
        	catch (Exception e) 
        	{
        		e.printStackTrace();
        		throw new RuntimeException(e);
        	}
        	ReportControl.fnNextTestJoin(nextTestJoin);
        }


    public void callFlow(Hashtable<String, String> data) throws Throwable {
        //Map is out of scope
        crHomeLib.messageDialogBoxClose();
        switch (data.get("CallFlow")) {
            case "Profile":
                diHome.clickOnProfile();
                callIDAndDateCombined = callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
                diHome.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombined);
                break;
            case "MCD":
                diHome.clickOnSearchCallsInDispatch();
                diHome.enterCallIDInfo(callandfacilityId[0]); //callIDCreated
                diHome.clickOnSearchInSearchCalls();
                diHome.clickOnCallDateOrIDLink();
                break;
            case "Truckload":
               /* diHome.clickOnTruckLoad();
                diHome.enterSpotFacilityIDInfoOnTruckLoad(callandfacilityId[1]); //spotIDCreated
                diHome.clickOnSpotFacilityOntruckLoadTextBox();
                Thread.sleep(5000);
                diHome.dateDecendingOrder();*/
                callIDAndDateCombined = callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
                diHome.searchAndClickOnCallIdOnTruckloadWindow(callIDAndDateCombined);
                break;
            default:
                break;
        }
    }

    public String[] completeCall(String CompleteCall) throws Throwable {
        switch (CompleteCall) {
            case "Save":
                crHomeLib.saveButton();
                crHomeLib.allErrorAlerts();
                callIDCreated = services.getCallId();
                spotIDCreated = services.getSpotFacilityId();
                callDateCreated=services.getCallDate();
                services.closeCall();
                break;
            case "Cancel":
                crHomeLib.cancelButton();
                //below function will click on Yes on confirmation window
                crHomeLib.allErrorAlerts();
                break;
            default:
                break;
        }
        callandfacilityId[0] = callIDCreated;
        callandfacilityId[1] = spotIDCreated;
        callandfacilityId[2] = callDateCreated;
        return callandfacilityId;
    }

}
