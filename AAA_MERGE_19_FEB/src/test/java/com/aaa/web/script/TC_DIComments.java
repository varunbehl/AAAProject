
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
import java.util.List;

public class TC_DIComments extends ActionEngine {
    public static String callID;
    public static String facilify;
    //public static String verificationTime;
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String callDateCreated;
    public static String callIDAndDateCombined;
    public  String [] callandfacilityId = new String[3];
    LoginLib login = new LoginLib();
    DIHomeLib diHome = new DIHomeLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    LoginRoleLib loginRole = new LoginRoleLib();
    DILoginLib diLogin = new DILoginLib();
    CommonLib common = new CommonLib();
    CRServiceLib services = new CRServiceLib();
    CRHomeLib home = new CRHomeLib();
    DIProfileLib profileLib =  new DIProfileLib();
    DIMCDLib mcdLib = new DIMCDLib();
    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
    DITruckLoadDeafultViewLib truckLoad = new DITruckLoadDeafultViewLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRTowDestinationLib tow = new CRTowDestinationLib();
    CRServiceLib service = new CRServiceLib();

  
    /************************************************************************
     * Script Name :-
     * Method Name :-
     * Module	   :- DI 
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
    public void commentsOnDispatch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1729 : DICOMMENTS"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		                Thread.sleep(4000);
		                login.login(data.get("LoginName"), data.get("Password"));
		                crHomeLib.waitCloseAllBusyIconsResults();
		                crHomeLib.messageDialogBoxClose();
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
		                //crMemberSearchLib.ClickPrimRadioBtnInRowTwo();
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
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                ///crHomeLib.allErrorAlerts();
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
		                //service.enterManualSpotDetails(data.get("SPPFacilitySpot"));
		                crHomeLib.allErrorAlerts();
		                facilify = service.validateFacilityAutospot();
		                crHomeLib.saveButton();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                Thread.sleep(3000);
		                getCallIDAndDate();
		                callID = service.getCallId();
		                service.closeCall();
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
    			ReportStatus.fnUpdateResultStatus("DI","1729",ReportStatus.strMethodName,intCounter,browser);
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
     * Module	   :- DI 
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
        public void commentsOnPoppedInAndPoppedOutMCDWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        	try
        	{
        		int intStartRow=StartRow;
        		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
        		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
        		{
        			try {
        					ReportStatus.fnDefaultReportStatus();
        					ReportControl.intRowCount=intCounter;
        					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch",intCounter);
        	
		                    this.reporter.initTestCaseDescription("1729 : DICOMMENTS"+ " From Iteration " + StartRow + " to " + EndRow );
		                    reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                    //NaviGate TO Dispatch
		                    navigateToApplication("DI");
		                    Thread.sleep(4000);
		                    diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
		                    crHomeLib.waitCloseAllBusyIconsResults();
		                    loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                    diHome.clickOnCloseIconOnQueueSelection();
		                    diHome.clickOnSearchCallsInDispatch();
		                    diHome.enterCallIDInfo("20104");
		                    //diHome.enterCallIDInfo("20004");
		                    diHome.clickOnSearchInSearchCalls();
		                    crHomeLib.waitCloseAllBusyIconsResults();
		                    diHome.clickOnCallDateOrIDLink();
		                    crHomeLib.waitCloseAllBusyIconsResults();
		                    //Call Common Functionality To veryfy Added Canned Comments
		                    commonFunctionToVerifyAddedCannedComments(data);
		                    boolean poppedOutButtonFlag = mcdLib.verifyPoppedOutButtonOnMCD();
		                    //Verify Comments In Popped Out MCD Window
		                    if (poppedOutButtonFlag) {
		                        mcdLib.maximizeMCDWindow();
		                        Thread.sleep(5000);
		                        switchToWindow();
		                        assertTrue(poppedOutButtonFlag, "MCD Window is PoppedOut");
		                        assertTrue(poppedOutButtonFlag, "Verification Of Canned Comments in Popped Out MCD Window");
		                        commonFunctionToVerifyAddedCannedComments(data);
		                        mcdLib.minimizeMCDWindow();
		                        mcdLib.closeTheOpendCallInMCD();
		                       // switchToWindow();
		                    }
		                    crHomeLib.logout();
        			}
        			catch(Exception e)
        			{
        				ReportStatus.blnStatus=false;
        			}
        			ReportControl.fnEnableJoin();
        			ReportStatus.fnUpdateResultStatus("DI","1729",ReportStatus.strMethodName,intCounter,browser);
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
         * Module	   :- DI 
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
            public void dispatchCommentsOnProfileWindow (int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
            	try
            	{
            		int intStartRow=StartRow;
            		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
            		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
            		{
            			try {
            					ReportStatus.fnDefaultReportStatus();
            					ReportControl.intRowCount=intCounter;
            					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch",intCounter);
            	
		                        this.reporter.initTestCaseDescription("1729 : DICOMMENTS"+ " From Iteration " + StartRow + " to " + EndRow );
		                        reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                        //NaviGate TO Dispatch
		                        navigateToApplication("DI");
		                        Thread.sleep(4000);
		                        diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
		                        crHomeLib.waitCloseAllBusyIconsResults();
		                        loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                        diHome.clickOnCloseIconOnQueueSelection();
		                        //Canned Comments: Profile AND Truck
		                        diHome.clickOnProfileMenu();
		                        diHome.clickOnProfileName(data.get("ProfileName"));
		                        Thread.sleep(2000);
		                        callIDAndDateCombined="20180215-20104";
		                        //callIDAndDateCombined = callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
		                        crHomeLib.waitCloseAllBusyIconsResults();
		                        profileLib.rightClickOnCallIdOnProfileWindow(callIDAndDateCombined);
		                        Thread.sleep(3000);
		                        profileLib.mouseHoverOnToComments(callIDAndDateCombined, data.get("Comments"));
		                        profileLib.mouseHoverOntoAutoComment();
		                        profileLib.selectComment(data.get("CannedCommentOnProfile"));
		                        List listOfComments = profileLib.getCommentsListFromProfile();
		                        String cannedComment1 = data.get("CannedComment1");
		                        String cannedComment2 = data.get("CannedComment2");
		                        boolean cannedCommentsFlag = mcdLib.verifyCannedCommentsInList(cannedComment1, cannedComment2, listOfComments);
		                        assertTrue(cannedCommentsFlag, "Verified the comments OnProfile  & Comments matches with   " + cannedComment1 + "  " + cannedComment2);
		                        diHome.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombined);
		                        String verificationTime = mcdLib.currentTime();
		                        boolean commentsFlag = mcdLib.commentVerification(callIDAndDateCombined, verificationTime, data.get("CannedComment"));
		                        assertTrue(commentsFlag, "Verified the comment & Canned Comment get inserted into the call with correct timestamp");
		                        crHomeLib.logout();
            			}
            			catch(Exception e)
            			{
            				ReportStatus.blnStatus=false;
            			}
            			ReportControl.fnEnableJoin();
            			ReportStatus.fnUpdateResultStatus("DI","1729",ReportStatus.strMethodName,intCounter,browser);
            		}
            	}
            	catch (Exception e) 
            	{
            		e.printStackTrace();
            		throw new RuntimeException(e);
            	}
            	ReportControl.fnNextTestJoin(nextTestJoin);
            }
                //Truck
              
            /************************************************************************
             * Script Name :-
             * Method Name :-
             * Module	   :- DI 
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
                public void dispatchCommentsOnTruckLoad (int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
                	try
                	{
                		int intStartRow=StartRow;
                		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
                		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
                		{
                			try {
                					ReportStatus.fnDefaultReportStatus();
                					ReportControl.intRowCount=intCounter;
                					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch",intCounter);
                	
		                            this.reporter.initTestCaseDescription("1729 : DICOMMENTS"+ " From Iteration " + StartRow + " to " + EndRow );
		                            reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                            //NaviGate TO Dispatch
		                            navigateToApplication("DI");
		                            Thread.sleep(4000);
		                            diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
		                            crHomeLib.waitCloseAllBusyIconsResults();
		                            loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                            diHome.clickOnCloseIconOnQueueSelection();
		                            diHome.clickOnTruckLoadTab();
		                            diHome.clickOnTruckLoadDefaultOption();
		                            //diHome.enterSpotFacilityIDInfoOnTruckLoad(facilify);
		                            diHome.enterSpotFacilityIDInfoOnTruckLoad("5140");
		                            truckLoad.clickOnFacilityOnDefaultTruck("5140");
		                            crHomeLib.waitCloseAllBusyIconsResults();
		                            Thread.sleep(3000);
		                            callIDAndDateCombined="20180215-20104";
		                            truckLoad.rightClickOnCallIDOnTruckLoad(callIDAndDateCombined);
		                            crHomeLib.waitCloseAllBusyIconsResults();
		                            truckLoad.mouseHoverToCommentsOnTruckLoad(callIDAndDateCombined);
		                            truckLoad.mouseHoverOntoAutoComment();
		                            truckLoad.selectComment(data.get("CannedCommentTruck"));
		                            List listOfCommentsFroTruck = truckLoad.getCommentsListFromTruckLoad();
		                            String cannedComment3 = data.get("CannedComment1");
		                            String cannedComment4 = data.get("CannedComment2");
		                            boolean truckcannedCommentsFlag = mcdLib.verifyCannedCommentsInList(cannedComment3, cannedComment4, listOfCommentsFroTruck);
		                            assertTrue(truckcannedCommentsFlag, "Verified the comments on TruckLoad, & Comments matches with   " + cannedComment3 + "  " + cannedComment4);
		                            diHome.clickOnSearchCallsInDispatch();
		                            diHome.enterCallIDInfo("20104");
		                            //diHome.enterCallIDInfo("20004");
		                            diHome.clickOnSearchInSearchCalls();
		                            crHomeLib.waitCloseAllBusyIconsResults();
		                            diHome.clickOnCallDateOrIDLink();
		                            String verificationTime = mcdLib.currentTime();
		                            boolean truckcommentsFlag = mcdLib.commentVerification(callIDAndDateCombined, verificationTime, data.get("CannedComment"));
		                            assertTrue(truckcommentsFlag, "Verified the comment & Canned Comment get inserted into the call with correct timestamp");
		                            crHomeLib.logout();
                			}
                			catch(Exception e)
                			{
                				ReportStatus.blnStatus=false;
                			}
                			ReportControl.fnEnableJoin();
                			ReportStatus.fnUpdateResultStatus("DI","1729",ReportStatus.strMethodName,intCounter,browser);
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
    public void manualEntryCancel(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1729 : DICOMMENTS"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                //NaviGate TO Dispatch
		                navigateToApplication("DI");
		                Thread.sleep(4000);
		                diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
		                crHomeLib.waitCloseAllBusyIconsResults();
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.enterCallIDInfo("20104");
		                //diHome.enterCallIDInfo("20004");
		                diHome.clickOnSearchInSearchCalls();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                diHome.clickOnCallDateOrIDLink();
		                crHomeLib.waitCloseAllBusyIconsResults();
		
		                String addButtonName = mcdLib.getAddButtonName();
		                String commentCountBeforeAddingComment = mcdLib.getCommentCountOnCommentSection();
		                assertTrue(addButtonName!=null,"Verified the Add Button In Comments section,Button Name is  "+addButtonName);
		                mcdLib.clickOnAddCommentsButton();
		                String addCommentsScreenName = mcdLib.verifyTheAddCommentScreen();
		                assertTrue(addCommentsScreenName!=null,"Veried the Add Comment screen,& Screen Name  is   "+addCommentsScreenName);
		                boolean isAddCommentsScreenModal = mcdLib.verifyTheAddCommentsScreenAsModal();
		                assertTrue(isAddCommentsScreenModal,"Verified the Add Comment screen ,Add Comment screen acts as modal (cannot edit any screens behind it).");
		
		                mcdLib.clickOnAddCommentsButton();
		                mcdLib.enterComments(data.get("CommentsToTextArea"));
		                mcdLib.clickOnCancelButtonOnAddCommentsScreen();
		                String commentCountAfterAddingComment = mcdLib.getCommentCountOnCommentSection();
		                boolean commentsCount = (commentCountBeforeAddingComment.equals(commentCountAfterAddingComment));
		                assertTrue(commentsCount,"Verified the Comment Count, Count is not Incremented   ,::Count Before add Comment  is"+commentCountBeforeAddingComment+"    ::Count After Cancel the comment is  "+commentCountAfterAddingComment);
		                boolean isAddCommentsWindowCloses = mcdLib.verifyAddCommentsWindowCloses();
		                assertTrue(isAddCommentsWindowCloses,"Verified the Add Comment window closes & Window closed after clicking on Cancel Button");
		                callIDAndDateCombined="20180215-20104";
		                //callIDAndDateCombined = callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
		                String verificationTime = mcdLib.currentTime();
		                boolean commentsFlag = mcdLib.commentVerification(callIDAndDateCombined, verificationTime, data.get("CommentsToTextArea"));
		                assertTrue(commentsFlag, "Verified the Manually Entered comment &  Comment Not added in the Comments Section");
		                //diHome.logOut();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1729",ReportStatus.strMethodName,intCounter,browser);
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
    public void manualEntrySave(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1729 : DICOMMENTS"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                //NaviGate TO Dispatch
		                navigateToApplication("DI");
		                Thread.sleep(4000);
		                diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
		                crHomeLib.waitCloseAllBusyIconsResults();
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.enterCallIDInfo("20104");
		                //diHome.enterCallIDInfo("20004");
		                diHome.clickOnSearchInSearchCalls();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                diHome.clickOnCallDateOrIDLink();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                String commentCountBeforeAddingComment = mcdLib.getCommentCountOnCommentSection();
		                mcdLib.clickOnAddCommentsButton();
		                mcdLib.enterComments(data.get("CommentsToTextArea"));
		                mcdLib.clickOnSaveButton();
		                boolean isAddCommentsWindowCloses = mcdLib.verifyAddCommentsWindowCloses();
		                assertTrue(isAddCommentsWindowCloses,"Verified the Add Comment window closes & Window closed after clicking on save Button");
		                callIDAndDateCombined="20180215-20104";
		                String verificationTime = mcdLib.currentTime();
		                //callIDAndDateCombined = callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
		                boolean commentsFlag = mcdLib.commentVerification(callIDAndDateCombined, verificationTime, data.get("CannedComment"));
		                assertTrue(commentsFlag, "Verified the comment & Comment added to the Comment Section");
		                String commentCountAfterAddingComment = mcdLib.getCommentCountOnCommentSection();
		                boolean commentsCount = (commentCountBeforeAddingComment.equals(commentCountAfterAddingComment));
		                assertTrue(commentsCount,"Verified the Comment Count, Count is  Incremented by 1  ,::Count Before add Comment  is"+commentCountBeforeAddingComment+"    ::Count After Cancel the comment is  "+commentCountAfterAddingComment);
		                assertTrue(commentsFlag, "Verified the Comment & Canned Comment get inserted into the call with correct Date And Time"+verificationTime);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1729",ReportStatus.strMethodName,intCounter,browser);
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
    public void commentsOther(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIComments", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIComments", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1729 : DICOMMENTS"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                //NaviGate TO Dispatch
		                navigateToApplication("DI");
		                Thread.sleep(4000);
		                diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
		                crHomeLib.waitCloseAllBusyIconsResults();
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.enterCallIDInfo("20104");
		                //diHome.enterCallIDInfo("20004");
		                diHome.clickOnSearchInSearchCalls();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                diHome.clickOnCallDateOrIDLink();
		                crHomeLib.waitCloseAllBusyIconsResults();
		                mcdLib.clickOnAddCommentsButton();
		
		
		                String commentCountBeforeAddingComment = mcdLib.getCommentCountOnCommentSection();
		                mcdLib.clickOnAddCommentsButton();
		                mcdLib.enterComments(data.get("CommentsLength250Char"));
		                mcdLib.getEnteredCommentsInTextArea();
		                mcdLib.clickOnSaveButton();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1729",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

        public String[] getCallIDAndDate() throws Throwable {
            callIDCreated = services.getCallId();
            spotIDCreated = services.getSpotFacilityId();
            callDateCreated = services.getCallDate();
            callandfacilityId[0] = callIDCreated;
            callandfacilityId[1] = spotIDCreated;
            callandfacilityId[2] = callDateCreated;

            return callandfacilityId;
        }

            public void commonFunctionToVerifyAddedCannedComments (Hashtable < String, String > data)throws Throwable {
                mcdLib.clickOnAddCommentsButton();
                mcdLib.clickOnCannedCommentsDroupDownLink();
                List<String> cannedCommentList = mcdLib.getCannedCommentsList();
                String cannedComment1 = data.get("CannedComment1");
                String cannedComment2 = data.get("CannedComment2");
                boolean cannedCommentsFlag = mcdLib.verifyCannedCommentsInList(cannedComment1, cannedComment2, cannedCommentList);
                assertTrue(cannedCommentsFlag, "Verified the comments showing on the drop-down list & Comments matches with   " + cannedComment1 + " AND  " + cannedComment2);
                boolean alphabeticalOrder = mcdLib.verifyAlphabeticalOrderOfCannedComments(cannedCommentList);
                assertTrue(alphabeticalOrder, "Verified the comments & Canned Comments are listed in alphabetical order");
                mcdLib.clickOnCannedCommentsDroupDownLink();
                mcdLib.selectCannedComment(data.get("CannedCommentOnMCD"));
                mcdLib.clickOnSaveButton();
                callIDAndDateCombined="20180215-20104";
                //callIDAndDateCombined = callandfacilityId[2].substring(0, 4) + callandfacilityId[2].substring(5, 7) + callandfacilityId[2].substring(8, 10) + callandfacilityId[2].substring(4, 5) + callandfacilityId[0];
                String verificationTime = mcdLib.currentTime();
                boolean commentsFlag = mcdLib.commentVerification(callIDAndDateCombined, verificationTime, data.get("CannedComment"));
                assertTrue(commentsFlag, "Verified the comment & Canned Comment get inserted into the call with correct timestamp");
            }
}


