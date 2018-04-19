package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DIDupeCall extends ActionEngine {

    public static  String callId;
    DIHomeLib diHome = new DIHomeLib();
    LoginLib login = new LoginLib();
    DILoginLib diLogin = new DILoginLib();
    LoginRoleLib loginRole = new LoginRoleLib();
    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
    DIMCDLib mcdlib = new DIMCDLib();
    CRServiceLib service = new CRServiceLib();
    CRTowDestinationLib tow = new CRTowDestinationLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    //Create Call

    
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
    public void saveCallForDIDupeCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "saveCallForDIDupeCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("saveCallForDIDupeCall", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("2024_DIDupe Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		                Thread.sleep(4000);
		                login.login(data.get("LoginName"), data.get("Password"));
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.verifyHomeScreen();
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
		                crHomeLib.memberSearchTextBox(Member);
		                //crHomeLib.memberSearchTextBox(data.get("Membersearch"));
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.ClickPrimRadioBtnInRowTwo();
		                //crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                Thread.sleep(2000);
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
		                Thread.sleep(4000);
		                crVehicleTriageLib.scriptErrorHandle();
		                crHomeLib.saveButton();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                Thread.sleep(3000);
		                callId = service.getCallId();
		                service.closeCall();
		                crHomeLib.logout();
		                acceptAlert();
		                Thread.sleep(2000);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2024",ReportStatus.strMethodName,intCounter,browser);
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
    public void dupeCallInPoppedInMCDWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIDupeCall", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIDupeCall", TestData, "D3Dispatch",intCounter);
    	
			            this.reporter.initTestCaseDescription("2024_DIDupe Call"+ " From Iteration " + StartRow + " to " + EndRow );
			            reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			            //Calling the Common Function to go to MCD Window
			            commonFunToGoToMCDWindow(data);
			            //Calling common Function to Verify Duplicall
			            verificationOfDuplicatiteCall(data);
			            mcdlib.closeTheOpendCallInMCD();
			            Thread.sleep(2000);
			            switchToWindow();
			           // mcdlib.clickOnMCDCloseWindow();
			            crHomeLib.logout();
			            acceptAlert();
			            Thread.sleep(2000);
			            acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2024",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    //Verification of Dupe call When it is popped out

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
    public void dupeCallInPoppedOutMCDWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIDupeCall", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIDupeCall", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("2024_DIDupe Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                //Calling the Common Function to go to MCD Window
		                commonFunToGoToMCDWindow(data);
		                mcdlib.maximizeMCDWindow();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                switchToWindow();
		                Thread.sleep(3000);
		                boolean poppedOutFlag = mcdlib.verifyPoppedOutWindow();
		                assertTrue(poppedOutFlag, "Switched To PoppedOut MCD window ");
		                verificationOfDuplicatiteCall(data);
		                mcdlib.closeTheOpendCallInMCD();
		                Thread.sleep(2000);
		                switchToWindow();
		                // mcdlib.clickOnMCDCloseWindow();
		                crHomeLib.logout();
		                acceptAlert();
		                Thread.sleep(2000);
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2024",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    //Common Functionality to go to MCD Window
    public void commonFunToGoToMCDWindow(Hashtable<String,String> data) throws Throwable{
        navigateToApplication("DI");
        Thread.sleep(3000);
        login.login(data.get("LoginName"), data.get("Password"));
        loginRole.clickOnProceedBtnInDispatchRoleLogin();
        diLogin.waitcloseAllBusyIcons();
        diHome.clickOnCloseIconOnQueueSelection();
        diHome.clickOnSearchCallsInDispatch();
        diSearchCalls.clickAndEnterCallIDInfo(callId);
        diSearchCalls.clickOnSearchButtonInSearchCallDispatch();
        crHomeLib.waitCloseAllBusyIconsResults();
        diSearchCalls.ClickOnCallIdOnSearchCallsWindow();
        Thread.sleep(2000);
    }
    //Common Functionality for verifing Duplicate call
    public void verificationOfDuplicatiteCall(Hashtable<String,  String> data)throws  Throwable{
        String duplicateCallButtonName =  mcdlib.verifyDuplicateCallButton();
        boolean DuplicateCallFlag=duplicateCallButtonName!=null;
        assertTrue(DuplicateCallFlag,"Verified the Duplicate call button and Duplicate Call button is available on the MCD window. Button name is   ::  "+duplicateCallButtonName);
        //Get Callid , Facility, PaceSetter Code Comments and Reason Before clicking On DupeCall icon
        String callIdBeforeDupeCall = mcdlib.getCallIdFromMcdWindow();
        String paceSetterCodeFromSummary = mcdlib.getPaceSetterCodeFromSummary();
        String facilityValue = mcdlib.getFacilityFromFacilitySummary();

        mcdlib.clickOnDuplicateCallIcon();
        //verify DulicateThisCall Tab
        String duplicateCallTab = mcdlib.verifyDulicateThisCallTab();
        boolean dupeCallTabFlag = duplicateCallTab!=null;
        assertTrue(dupeCallTabFlag,"Verified the Duplicate Call Tab & " +duplicateCallTab+ " is opened");
        //verify Current Call option
        String currentCallInfoOption =  mcdlib.verifyCurrentCallInfoOption();
        boolean currentCallFlag = currentCallInfoOption!=null;
        assertTrue(currentCallFlag,"Verified the Current Call option , Option name on the Duplicate Call Tab  is   ::"+currentCallInfoOption);
        //Verify Call Id Option
        String callIdOption = mcdlib.verifryCallIdOnDuplicateThisCallTab();
        boolean callIdOptionFlag = callIdOption!=null;
        assertTrue(callIdOptionFlag,"Verified the Call ID option , Option name on the Duplicate Call Tab is   ::  "+callIdOption);
        //verify Facility
        String facilityOption = mcdlib.verifryFacilityOnDuplicateThisCallTab();
        boolean facilityOptionFlag = facilityOption!=null;
        assertTrue(facilityOptionFlag,"Verified the Facility Option  , Option name on the Duplicate Call Tab is   ::  "+facilityOption);
        //VerifyTruckId
        String truckOption =  mcdlib.verifyTruckOnDuplicateThisCallTab();
        boolean truckIdFlag = truckOption!=null;
        assertTrue(truckIdFlag,"Verified the Truck Option  , Option name on the Duplicate Call Tab is   ::  "+truckOption);
        //verify PaceSetterCode
        String paceSetterCode = mcdlib.verifyPaceSetterCodeOnDuplicateThisCallTab();
        boolean paceSetterCodeFlag=paceSetterCode!=null;
        assertTrue(paceSetterCodeFlag,"Verified the PaceSetter Code Option  , Option name on the Duplicate Call Tab is    ::  "+paceSetterCode);
        //Verify Status option
        String status = mcdlib.verifyStatusOnDuplicateThisCallTab();
        boolean statusFlag = status!=null;
        assertTrue(statusFlag,"Verified the Status Option  , Option name on the Duplicate Call Tab is    ::  "+status);
        //Verify New Duplicate Call Info
        String newDuplicateCallInfo = mcdlib.verifyNewDuplicateCallInfoOnDuplicateThisCallTab();
        boolean newDuplicateCallFlag = newDuplicateCallInfo!=null;
        assertTrue(newDuplicateCallFlag,"Verified the New Duplicate Call Info Option  , Option name on the Duplicate Call Tab is   ::  "+newDuplicateCallInfo);
        //verify Spot To facility Drp Dwn
        String spotTofacility = mcdlib.verifySpotToFacilityDrpDwnOnDuplicateThisCallTab();
        boolean spotTofacilityFlag=spotTofacility!=null;
        assertTrue(spotTofacilityFlag,"Verified the Spot To Facility Drop-Down    , Option name on the Duplicate Call Tab is   ::  "+spotTofacility);
        //Verify PaceSetter Code rp Dwn
        String paceSettercode = mcdlib.verifyPaceSetterDrpDwnOnDuplicateThisCallTab();
        boolean paceSetterFlag = paceSettercode!=null;
        assertTrue(paceSetterFlag,"Verified the PaceSetter Code Drop-Down    , Option name on the Duplicate Call Tab is   ::  "+paceSettercode);

        //Verify Reason Drp Dwn
        String reason = mcdlib.verifyReasonDrpDwnOnDuplicateThisCallTab();
        boolean reasonFlag=reason!=null;
        assertTrue(reasonFlag,"Verified the Reason Drop-Down   , Option name on the Duplicate Call Tab is   :: "+reason);
        //Verify Comments
        String cooments = mcdlib.verifyCommentsOnDuplicateThisCallTab();
        boolean commentsFlag = cooments!=null;
        assertTrue(commentsFlag,"Verified the Comments , Option name on the Duplicate Call Tab is   ::  "+cooments);
        mcdlib.clickOnDuplicateCallButton();
        String errorMsgFromMCD=mcdlib.verifyErrorMessageForMandatoryFields();
        //boolean errorFlag = mcdlib.compareTwoValues(data.get("ErrorMessage"),errorMsgFromMCD);
        boolean errorMsgFromMCDFlag=errorMsgFromMCD!=null;
        assertTrue(errorMsgFromMCDFlag,"Verified the error message,  The Errror Message is    ::  "+errorMsgFromMCD);
        mcdlib.clickOnErrorAlrertOkButton();
        mcdlib.enterFacilityToSpotOnDuplicateCallTab(data.get("Facility"));
        String facility = data.get("Facility");
        String selectedFacility = mcdlib.getSelectedFacility();
        boolean fecilityFlag = (selectedFacility.contains(facility));
        assertTrue(fecilityFlag,"Verified the facility Field & able to select a Facility ,Selected Facility is   :: "+selectedFacility);
        mcdlib.enterPaceSetterCodeOnDuplicateCallTab(data.get("PaceSetterCode"));
        /*String combineKeys4 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(2000);
        String combineKeys1 = Keys.chord(Keys.SPACE);
        sendKeys(combineKeys2, "SPACE");*/
        String paceSetterCodeValue = data.get("PaceSetterCode");
        String selectedPaceSetterCode =mcdlib.getSelectedPaceSetterCode();
        boolean paceSetterCodeFlag1 =  selectedPaceSetterCode.contains((paceSetterCodeValue));
        assertTrue(paceSetterCodeFlag1,"Verified the PaceSetter Code Field & able to select a PaceSetter Code ,Selected PaceSetter Code is   :: "+selectedPaceSetterCode);
        mcdlib.enterReasonOnDuplicateCallTab(data.get("Reason"));
        /*String combineKeys5 = Keys.chord(Keys.TAB);
        *//*sendKeys(combineKeys3, "Tab");
        Thread.sleep(2000);
        String combineKeys = Keys.chord(Keys.SPACE);
        sendKeys(combineKeys2, "SPACE");*/
        String reasonValue = data.get("Reason");
        String selectedReason =mcdlib.getSelectedReason();
        boolean reasonFlag1 = selectedReason.contains(reasonValue);
        assertTrue(reasonFlag1,"Verified the Reason Field & able to select a Reason,Selected Reason is   :: "+selectedReason);
        mcdlib.enterCommentsOnDuplicateCallTab(data.get("Comments"));
        /*String combineKeys6 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(2000);
        String combineKeys7 = Keys.chord(Keys.SPACE);
        sendKeys(combineKeys2, "SPACE");*/
        String commentsValue = data.get("Comments");
        String enteredComments = mcdlib.getEnteredComments();
        boolean commentsFlag1 = (enteredComments.contains(commentsValue));
        assertTrue(commentsFlag1,"Verified the Comments & able to enter Comments, Entered Comment is   :: "+enteredComments);
        Thread.sleep(2000);

        mcdlib.clickOnDuplicateCallButton();
        crHomeLib.waitCloseAllBusyIconsResults();
        switchToWindow();
        //Get Callid , Facility, PaceSetter Code Comments and Reason After clicking On DupeCall icon
        Thread.sleep(3000);
        String callIdInDupeCall = mcdlib.getCallIdFromMcdWindow();
        assertTrue(callIdInDupeCall!=callIdBeforeDupeCall,"New MCD Window Is Opened ,Call Id is Duplicated & Duplicated CallId   is  ::  "+callIdInDupeCall);
        Thread.sleep(3000);
        String paceSetterCodeInDupeCall = mcdlib.getPaceSetterCodeFromSummary();
        boolean paceSettrCodeFlag = !paceSetterCodeInDupeCall.contains(paceSetterCodeFromSummary);
        assertTrue(paceSettrCodeFlag,"New MCD Window Is Opened ,PaceSetter Code is Duplicated & Duplicated PaceSetter Code   is  ::  "+paceSetterCodeInDupeCall);
        Thread.sleep(3000);
        String facilityValueInDupecall = mcdlib.getFacilityFromFacilitySummary();
        boolean facilityFlag = !facilityValueInDupecall.contains(facilityValue);
        assertTrue(facilityFlag,"New MCD Window Is Opened,Facility is Duplicated &  Duplicated Facility  is ::  "+facilityValueInDupecall);

        mcdlib.validateComentsInMCDWindow(enteredComments);
        switchToWindow();

    }
}
