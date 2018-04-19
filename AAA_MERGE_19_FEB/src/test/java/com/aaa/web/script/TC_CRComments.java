package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.lib.DILoginLib;
import com.aaa.web.page.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRComments extends ActionEngine {
    String problemTypes;
    String strStatus;
    String strType;
    String strDateTimeStamp;
    String strUser;
    String strLocation;
    String CallID;

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void CreateCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crComments", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crComments", TestData, "D3CallRecieving",intCounter);
		    	
		
		              /*  String s="AUTOCRDI (DI)";
		                String a = "AUTOCRDI (DI)";
		                String s1 = s.replaceAll("[^\\w\\d\\s]", " ");
		                String s2 = a.replaceAll("[^\\w\\d\\s]", " ");
		
		                boolean res = s1.equalsIgnoreCase(s2);
		                boolean res1 = s2.equalsIgnoreCase(s2);*/
		
		
		                this.reporter.initTestCaseDescription("1593:TC-Comments"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRServiceLib service = new CRServiceLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRMemberSearchLib memeber =new CRMemberSearchLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                LoginToApplication(data);
		                home.memberSearchTextBox(data.get("MemberNumber"));
		                memeber.memberNumClick();
		                memeber.currentCallClose();
		                memeber.ClickPrimRadioBtnInRowThree();
		                // Locations Page Starts
		                locations.clickOnLocationTab();
		                Thread.sleep(3000);
		                locations.clickOnSecondKownBrkDowLocation();
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
		                vehicle.clickonProblemTypeOptions(data.get("TriageTypeOption"));
		                home.saveButton();
		                Thread.sleep(6000);
		                home.allErrorAlerts();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                CallID = service.getCallId();
		                service.closeCallWindow();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1593",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ValidateNormalCommentsInCR(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crComments", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crComments", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1593:TC-Comments"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRServiceLib service = new CRServiceLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                LoginToApplication(data);
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();
		                Thread.sleep(3000);
		
		                //crSearchCall.enterCallIdOnSearchCallsWindow(data.get("CallID"));
		                crSearchCall.enterCallIdOnSearchCallsWindow(CallID);
		
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                crSearchCall.clickCallIDLinkOnSearchCallsWindow();
		                Thread.sleep(5000);
		
		                locations.enterCallComments(data.get("NormalComments"));
		                locations.clickOnCallCommentsAddButton();
		                locations.clickOnCallCommentsButton();
		                locations.validateComentsInCommentPopUp(data.get("NormalComments"));
		                locations.clickIconMessageWindowClose();
		                home.saveButton();
		                service.enterInResonForStatusStatus(data.get("ReasonForStatus"));
		                Thread.sleep(4000);
		                service.enterInCommentStatus(data.get("UpdateCommentsInPopUp"));
		                service.clickOnComment();
		                //service.clickUpdateButton();
		                service.clickOnUpdateButtonOnCallStatusWindow();
		                service.closeCall();
		                home.logout();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1593",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ValidateInternalCommentsInCR(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crComments", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crComments", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1593:TC-Comments"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRServiceLib service = new CRServiceLib();
		
		                LoginToApplication(data);
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();
		                Thread.sleep(3000);
		
		                //crSearchCall.enterCallIdOnSearchCallsWindow(data.get("CallID"));
		                crSearchCall.enterCallIdOnSearchCallsWindow(CallID);
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                Thread.sleep(7000);
		                crSearchCall.clickCallIDLinkOnSearchCallsWindow();
		                Thread.sleep(5000);
		                home.clickOnInternalIcon();
		                locations.enterCallComments(data.get("InternalComments"));
		                locations.clickOnCallCommentsAddButton();
		                locations.clickOnCallCommentsButton();
		                locations.validateComentsTypeInCommentWindow(data.get("InternalComments"),data.get("CommentTypeInternal"));
		                locations.clickIconMessageWindowClose();
		                home.saveButton();
		                service.enterInResonForStatusStatus(data.get("ReasonForStatus"));
		                Thread.sleep(4000);
		                service.enterInCommentStatus(data.get("UpdateCommentsInPopUp"));
		                service.clickOnComment();
		                //service.clickUpdateButton();
		                service.clickOnUpdateButtonOnCallStatusWindow();
		                service.closeCall();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","34679",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    // Step 14 and 15
    @Test()
    public void ValidateInternalCommentsNotVisibleNotAbleToCreatForCR(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crComments", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crComments", TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("1593:TC-Comments"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib loginRole=new LoginRoleLib();
		                CRServiceLib service = new CRServiceLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                LoginLib login = new LoginLib();
		                navigateToApplication("CR");
		                login.login(data.get("D3CRDUserName"), data.get("Password"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                Thread.sleep(5000);
		                home.messageDialogBoxClose();
		                crSearchCall.clickOnSearchCalls();
		
		                crSearchCall.clickOnClearOnSearchCallsWindow();
		                Thread.sleep(3000);
		                //crSearchCall.enterCallIdOnSearchCallsWindow(data.get("CallID"));
		                crSearchCall.enterCallIdOnSearchCallsWindow(CallID);
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                Thread.sleep(5000);
		                crSearchCall.clickCallIDLinkOnSearchCallsWindow();
		                Thread.sleep(5000);
		                //<Pop Up Coming Battery service not available at this time need to click on OKAY button>---------------------------------
		                //home.allErrorAlerts();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                locations.clickOnCallCommentsButton();
		                //locations.validateComentsTypeInCommentWindow(data.get("InternalComments"),data.get("CommentTypeInternal"));
		                boolean commentType = locations.validateComentsTypeInCommentWindow(data.get("InternalComments"));
		                assertTrue(commentType,"Comment type internal does not exist");
		                locations.clickIconMessageWindowClose();
		                Thread.sleep(2000);
		                // Step 15
		                boolean internalIcon = isEnabled(CRHomePage.iconInernal,"Inernal Icon");
		                assertTrue(internalIcon,"Not able to create an internal comment as it is disabled");
		
		                home.saveButton();
		                service.enterInResonForStatusStatus(data.get("ReasonForStatus"));
		                Thread.sleep(4000);
		                service.enterInCommentStatus(data.get("UpdateCannedCommentsInPopUp"));
		                service.clickOnComment();
		                service.clickOnUpdateButtonOnCallStatusWindow();
		                service.closeCall();
		                home.logout();
		
		
		               /* locations.enterCallComments(data.get("CannedComment"));
		                //home.clickOnAddDropDownArrow(); ---
		                //home.selectCannedComment(data.get("CannedComment")); ---
		                //selectByValue(CRHomePage.lstCannedComments,data.get("CannedCommentValue"),"Canned Comment List");---
		                locations.clickOnCallCommentsAddButton();
		                locations.clickOnCallCommentsButton();
		                locations.validateComentsInCommentPopUp(data.get("CannedComment"));
		                home.logout();*/
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","34679",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ValidateCannedCommentsInCR(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crComments", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crComments", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1593:TC-Comments"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRServiceLib service = new CRServiceLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib vehicle =new  CRVehicleTriageLib();
		                LoginToApplication(data);
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();
		
		                Thread.sleep(3000);
		
		                //crSearchCall.enterCallIdOnSearchCallsWindow(data.get("CallID"));
		                crSearchCall.enterCallIdOnSearchCallsWindow(CallID);
		                Thread.sleep(3000);
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                Thread.sleep(3000);
		                crSearchCall.clickCallIDLinkOnSearchCallsWindow();
		                Thread.sleep(5000);
		                //<<Code to click on OK button >>
		                //home.allErrorAlerts();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(5000);
		                click(CRHomePage.autoCommentDownArrow,"auto-comment down arrow");
		                Thread.sleep(2000);
		                click(CRHomePage.ddnselCannedComments,"Select Canned Comments");
		                //locations.enterCallComments(data.get("CannedComment"));
		                Thread.sleep(1000);
		                //locations.clickOnCallCommentsAddButton();
		                Thread.sleep(1000);
		                locations.clickOnCallCommentsButton();
		                Thread.sleep(3000);
		                locations.validateComentsInCommentPopUp(data.get("CannedComment"));
		                strStatus = getText(CRLocationsPage.lblStatusCommentWindow,"Comment Status");
		                strType = locations.GetComentTypeFromommentWindow(data.get("CannedComment"));
		                strDateTimeStamp = getText(CRLocationsPage.lblDateTimeCommentWindow,"Comment Date Time");
		                strUser = getText(CRLocationsPage.lblUserCommentWindow,"Comment User");
		                strLocation = getText(CRLocationsPage.lblLocationCommentWindow,"Comment Location");
		
		
		                locations.clickIconMessageWindowClose();
		                home.saveButton();
		                service.enterInResonForStatusStatus(data.get("ReasonForStatus"));
		                Thread.sleep(4000);
		                service.enterInCommentStatus(data.get("UpdateCannedCommentsInPopUp"));
		                service.clickOnComment();
		                //service.clickUpdateButton();
		                service.clickOnUpdateButtonOnCallStatusWindow();
		                service.closeCall();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","34679",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ValidateHiddenDeletedCommentsForCR(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crComments", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crComments", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1593:TC-Comments"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib loginRole=new LoginRoleLib();
		                CRServiceLib service = new CRServiceLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                LoginLib login = new LoginLib();
		                navigateToApplication("CR");
		                login.login(data.get("D3CRDUserName"), data.get("Password"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                Thread.sleep(5000);
		                home.messageDialogBoxClose();
		                crSearchCall.clickOnSearchCalls();
		                //crSearchCall.clickOnClearOnSearchCallsWindow();
		                Thread.sleep(3000);
		                //crSearchCall.enterCallIdOnSearchCallsWindow(data.get("CallID"));
		                crSearchCall.enterCallIdOnSearchCallsWindow(CallID);
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                Thread.sleep(3000);
		                crSearchCall.clickCallIDLinkOnSearchCallsWindow();
		                Thread.sleep(15000);
		                //<Pop Up Coming Battery service not available at this time need to click on OKAY button>---------------------------------
		                member.currentCallClose();
		                /*vehicle.handleScriptErrorInVehicleTriagePage();
		                home.allErrorAlerts();*/
		                locations.enterCallComments(data.get("CommentsHiddenDeleted"));
		                locations.clickOnCallCommentsAddButton();
		                locations.clickOnCallCommentsButton();
		                //DB Click
		                String countHiddenDeletedBefDel = getText(CRHomePage.lblHiddenDeletedCount,"Hidden Deleted Comment Count");
		                mouseDoubleClick(CRLocationsPage.txtCommentRowOneInCommentsPopup,"Comments in First Row of Comment Window");
		                boolean editCommentWindow = isVisible(CRHomePage.editCommentWindow,"Edit Comment Window");
		                assertTrue(editCommentWindow,"Edit Comment Window is displayed");
		                //selectByValue(CRHomePage.ddnStatusInEditComment,"Hidden","Status Drop Down");
		                click(CRHomePage.ddnStatusInEditComment,"Status Drop Down");
		                selectByVisibleText(CRHomePage.ddnStatusInEditComment,"Hidden","Status Drop Down");
		                Thread.sleep(3000);
		                click(CRHomePage.lblStatus,"Status Label");
		                click(CRHomePage.btnSaveEditCommentWindow,"Save Button on Edit Comment Window");
		                locations.validateComentsNotAvailableInCommentPopUp(data.get("CommentsHiddenDeleted"));
		                String countHiddenDeletedAfterDel = getText(CRHomePage.lblHiddenDeletedCount,"Hidden Deleted Comment Count");
		                // Validating Hidden Deleted Comments Count
		                boolean valHiddenDeleted = countHiddenDeletedBefDel.equalsIgnoreCase(countHiddenDeletedAfterDel);
		                assertTrue(!valHiddenDeleted,"Count next to Hidden/Deleted comments was incremented by one");
		                click(CRHomePage.chkboxHiddenDeleted,"CheckBox Hidden/Deleted Comments");
		                locations.validateComentsInCommentPopUp(data.get("CommentsHiddenDeleted"));
		                locations.clickIconMessageWindowClose();
		                home.saveButton();
		                service.enterInResonForStatusStatus(data.get("ReasonForStatus"));
		                Thread.sleep(4000);
		                service.enterInCommentStatus(data.get("UpdateHiddenCommentsInPopUp"));
		                service.clickOnComment();
		                //service.clickUpdateButton();
		                service.clickOnUpdateButtonOnCallStatusWindow();
		                service.closeCall();
		                home.logout();
		                Thread.sleep(5000);
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","34679",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ValidateStatusTypeDateTimeLocationUserComment(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crComments", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crComments", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1593:TC-Comments"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRServiceLib service = new CRServiceLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                LoginToApplication(data);
		                crSearchCall.clickOnSearchCalls();
		                crSearchCall.clickOnClearOnSearchCallsWindow();
		                Thread.sleep(3000);
		
		                //crSearchCall.enterCallIdOnSearchCallsWindow(data.get("CallID"));
		                crSearchCall.enterCallIdOnSearchCallsWindow(CallID);
		                crSearchCall.clickOnSearchBtnOnSearchCallsWindow();
		                Thread.sleep(4000);
		                crSearchCall.clickCallIDLinkOnSearchCallsWindow();
		                Thread.sleep(7000);
		                member.currentCallClose();
		                locations.clickOnCallCommentsButton();
		                Thread.sleep(7000);
		                locations.validateComentsStatusInCommentWindow(data.get("CannedComment"),strStatus);
		
		                locations.validateComentsTypeInCommentWindow(data.get("CannedComment"),strType);
		
		                locations.validateComentsDateTimeCommentWindow(data.get("CannedComment"),strDateTimeStamp);
		
		                locations.validateComentsUserCommentWindow(data.get("CannedComment"),strUser);
		
		                locations.validateLocationCommentWindow(data.get("CannedComment"),strLocation);
		
		                locations.clickOnCallCommentsButton();
		                home.saveButton();
		                service.enterInResonForStatusStatus(data.get("ReasonForStatus"));
		                Thread.sleep(4000);
		                service.enterInCommentStatus(data.get("UpdateComments"));
		                service.clickOnComment();
		                //service.clickUpdateButton();
		                service.clickOnUpdateButtonOnCallStatusWindow();
		                service.closeCall();
		                home.logout();
		                Thread.sleep(5000);
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","34679",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ValidateAutoGeneratedComments(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crComments", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crComments", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1593:TC-Comments"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRServiceLib service = new CRServiceLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRMemberSearchLib memeber =new CRMemberSearchLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                LoginRoleLib loginRole=new LoginRoleLib();
		                LoginLib login = new LoginLib();
		                navigateToApplication("CR");
		                //login.login(data.get("D3CRDUserName"), data.get("Password"));
		                login.login(data.get("CRAdminUserName"), data.get("Password"));
		                Thread.sleep(5000);
		                String location = login.getLocationName();
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                home.allErrorAlertsNoButton();
		                home.messageDialogBoxClose();
		                home.memberSearchTextBox(data.get("MemberNumber"));
		                memeber.memberNumClick();
		                memeber.currentCallClose();
		                memeber.ClickPrimRadioBtnInRowThree();
		                // Locations Page Starts
		                locations.clickOnLocationTab();
		                Thread.sleep(3000);
		                locations.clickOnSecondKownBrkDowLocation();
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
		                //String initialCommentsCount =locations.getCommentsCountFromCommentsButton();
		                vehicle.clickonProblemTypeOptions(data.get("TriageTypeOption"));
		                String strPaceSetterCode = getText(CRVehicleTriagePage.lblSelectedPacesetterCodes,"Selected Pacesetter Code");
		                locations.clickOnCallCommentsAddButton();
		                Thread.sleep(1000);
		                String initialCommentsCount =locations.getCommentsCountFromCommentsButton();
		                //locations.VerifyCallReceivesPacesetterCode(initialCommentsCount,finalCommentsCount);
		                assertTrue(initialCommentsCount.equalsIgnoreCase(data.get("AutoGenerateCommentCountInitial")),"comments button at the bottom becomes active with "+initialCommentsCount+" as the comment count");
		                locations.clickOnCallCommentsButton();
		                String strAutoGenetaredComments = getText(CRLocationsPage.txtCommentsCol,"Comments").trim();
		                String strCOmmentPaceSetterCode = strAutoGenetaredComments.substring(strAutoGenetaredComments.lastIndexOf(':') + 1).trim();
		                assertTrue(strPaceSetterCode.equalsIgnoreCase(strCOmmentPaceSetterCode),"Selected pacesetter code displayed in Comments window"+strCOmmentPaceSetterCode);
		
		                locations.validateComentsTypeInCommentWindow(strAutoGenetaredComments,data.get("AutoGenerateCommentType"));
		
		                locations.validateComentsStatusInCommentWindow(strAutoGenetaredComments,data.get("AutoGenerateCommentStatus"));
		
		                locations.validateComentsUserCommentWindow(strAutoGenetaredComments,data.get("AutoGenerateCommentUser"));
		                //locations.validateLocationCommentWindow(strAutoGenetaredComments,data.get("AutoGenerateCommentLocation"));
		                locations.validateLocationCommentWindow(strAutoGenetaredComments,location);
		
		                String strTimeStamp = getText(CRLocationsPage.lblDateTimeCommentWindow,"Date Time in Comments Window");
		                assertTrue( strTimeStamp!="","Date Time data updated in Comments window"  );
		
		                locations.clickOnCallCommentsButton();
		                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeButton(data.get("TriageType"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("TriageTypeOption2"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("TriageTypeOption3"));
		                Thread.sleep(2000);
		                locations.clickOnCallCommentsButton();
		                Thread.sleep(2000);
		                click(CRHomePage.chkboxHiddenDeleted,"CheckBox Hidden/Deleted Comments");
		                String finalCommentsCount =locations.getCommentsCountFromCommentsButton();
		                assertTrue(finalCommentsCount.equalsIgnoreCase(data.get("AutoGenerateCommentCountFinal")),"Total comment count is "+finalCommentsCount);
		                Thread.sleep(2000);
		                //<>
		                String strAutoGenetaredCommentsNew = getText(CRLocationsPage.txtCommentsCol,"Comments").trim();
		                String strCOmmentPaceSetterCodeNew = strAutoGenetaredCommentsNew.substring(strAutoGenetaredCommentsNew.lastIndexOf(':') + 1).trim();
		                assertTrue(strCOmmentPaceSetterCodeNew.equalsIgnoreCase(data.get("NewPaceSetterCode")),"Selected pacesetter code displayed in Comments window"+strCOmmentPaceSetterCodeNew);
		
		                locations.validateComentsStatusInCommentWindow(strAutoGenetaredComments,data.get("AutoGenerateCommentDeleteStatus"));
		                locations.validateComentsTypeInCommentWindow(strAutoGenetaredComments,data.get("AutoGenerateCommentType"));
		                locations.validateComentsUserCommentWindow(strAutoGenetaredComments,data.get("AutoGenerateCommentUser"));
		                //locations.validateLocationCommentWindow(strAutoGenetaredComments,data.get("AutoGenerateCommentLocation"));
		                locations.validateLocationCommentWindow(strAutoGenetaredComments,location);
		                String strTimeStampDelComment = locations.GetDateTimeFromCommentWindow(strAutoGenetaredComments);
		                assertTrue(strTimeStampDelComment.equalsIgnoreCase(strTimeStamp),"Date Time");
		                home.saveButton();
		                service.closeCallWindow();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","34679",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ValidateNormalCommentsInDispatch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crComments", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crComments", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1593:TC-Comments"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                DILoginLib diLogin = new DILoginLib();
		                DIHomeLib diHome = new DIHomeLib();
		                LoginRoleLib loginRole=new LoginRoleLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                DIMCDLib mcdLib = new DIMCDLib();
		                navigateToApplication("DI");
		                diLogin.login(data.get("DispatchLoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                Thread.sleep(15000);
		                diLogin.waitcloseAllBusyIcons();
		                Thread.sleep(5000);
		                diHome.clickOnCloseIconOnQueueSelection();
		                Thread.sleep(5000);
		                diHome.clickOnSearchCallsInDispatch();
		                //diHome.enterCallIDInfo(data.get("CallID"));
		                diHome.enterCallIDInfo(CallID);
		                diHome.clickOnSearchInSearchCalls();
		                Thread.sleep(5000);
		                diHome.clickOnCallDateOrIDLink();
		                Thread.sleep(5000);
		                mcdLib.validateComentsInMCDWindow(data.get("NormalComments"));
		                mcdLib.clickOnMCDCloseWindow();
		                diHome.logOut();
		                Thread.sleep(5000);
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","34679",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ValidateInternalCommentsInDispatch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crComments", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crComments", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1593:TC-Comments"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                DILoginLib diLogin = new DILoginLib();
		                DIHomeLib diHome = new DIHomeLib();
		                LoginRoleLib loginRole=new LoginRoleLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                DIMCDLib mcdLib = new DIMCDLib();
		                navigateToApplication("DI");
		                Thread.sleep(5000);
		                diLogin.login(data.get("DispatchLoginName"), data.get("Password"));
		                Thread.sleep(10000);
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                Thread.sleep(25000);
		                //diHome.closeFacilityWindow();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diLogin.waitcloseAllBusyIcons();
		                Thread.sleep(5000);
		                diHome.clickOnSearchCallsInDispatch();
		                Thread.sleep(3000);
		                //diHome.enterCallIDInfo(data.get("CallID"));
		                diHome.enterCallIDInfo(CallID);
		                diHome.clickOnSearchInSearchCalls();
		                Thread.sleep(5000);
		                diHome.clickOnCallDateOrIDLink();
		                Thread.sleep(7000);
		                mcdLib.validateComentsInMCDWindow(data.get("InternalComments"));
		                mcdLib.clickOnMCDCloseWindow();
		                diHome.logOut();
		                Thread.sleep(5000);
		                acceptAlert();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","34679",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ValidateCannedCommentsInDispatch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crComments", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crComments", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1593:TC-Comments"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                DILoginLib diLogin = new DILoginLib();
		                DIHomeLib diHome = new DIHomeLib();
		                LoginRoleLib loginRole=new LoginRoleLib();
		                CRSearchCallsLib crSearchCall = new CRSearchCallsLib();
		                DIMCDLib mcdLib = new DIMCDLib();
		                navigateToApplication("DI");
		                diLogin.login(data.get("DispatchLoginName"), data.get("Password"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                diLogin.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                Thread.sleep(5000);
		                diHome.clickOnSearchCallsInDispatch();
		                //diHome.enterCallIDInfo(data.get("CallID"));
		                diHome.enterCallIDInfo(CallID);
		                diHome.clickOnSearchInSearchCalls();
		                Thread.sleep(5000);
		                diHome.clickOnCallDateOrIDLink();
		                Thread.sleep(5000);
		                mcdLib.validateComentsInMCDWindow(data.get("CannedComment"));
		
		                mcdLib.clickOnMCDCloseWindow();
		                diHome.logOut();
		                Thread.sleep(5000);
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","34679",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ValidateNormalCommentsInSPPDispatch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crComments", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crComments", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1593:TC-Comments"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                DILoginLib diLogin = new DILoginLib();
		                DIHomeLib diHome = new DIHomeLib();
		                DIMCDLib mcdLib = new DIMCDLib();
		
		                navigateToApplication("DI");
		                diLogin.login(data.get("SPPDispatchLoginName"), data.get("Password"));
		                //loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                Thread.sleep(15000);
		                diLogin.waitcloseAllBusyIcons();
		                diHome.closeFacilityWindow();
		                Thread.sleep(5000);
		                diHome.clickOnSearchCallsInDispatch();
		                //diHome.enterCallIDInfo(data.get("CallID"));
		                diHome.enterCallIDInfo(CallID);
		                diHome.clickOnSearchInSearchCalls();
		                String noRecordsFound = getText(DISearchCallsPage.lblNoMatchingRecordsFound,"No matching records found, try refining your search");
		                if (noRecordsFound.equalsIgnoreCase(data.get("NoMatchingRecords"))){
		                    click(DISearchCallsPage.btnCloseSearchCallsWindow,"Close Button on Search Calls Window");
		                }
		                Thread.sleep(5000);
		                diHome.clickOnCallDateOrIDLink();
		                mcdLib.validateComentsInMCDWindow(data.get("NormalComments"));
		                mcdLib.clickOnMCDCloseWindow();
		                diHome.logOut();
		                Thread.sleep(5000);
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","34679",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }


    public void LoginToApplication(Hashtable<String, String> data) throws Throwable {
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

