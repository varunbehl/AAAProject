package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import com.aaa.web.page.CRVehicleTriagePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRTriage extends ActionEngine {
    String problemTypes;

   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ValidateCommentsAndEnteredManualPaceSetterCode(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crTriage", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("clearCallFullServices", TestData, "D3Dispatch",intCounter);
    	
			                this.reporter.initTestCaseDescription("1620:TC-Vehicle Triage"+ " From Iteration " + StartRow + " to " + EndRow );
			                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			                CRHomeLib home = new CRHomeLib();
			                CRLocationsLib locations = new CRLocationsLib();
			                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
			                // Logging into the application
			                LoginToApplication(data);
			                // Navigating to Vehicle Triage Page and Validating Manual Entry of Pacesetter Code(Step 11)
			                vehicle.clickOnVehicleTriageTab();
			                vehicle.selectpaceSettercode(data.get("PaceSetterCode"));
			                vehicle.validateSelectedPaceSetterCode();
			                Thread.sleep(5000);
			                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
			
			                // Updated Comments
			                vehicle.clickonProblemTypeButton(data.get("ProblemType4"));
			                Thread.sleep(1000);
			                vehicle.clickonProblemTypeOptions(data.get("ProblemType4Option4"));
			                Thread.sleep(1000);
			                vehicle.clickonProblemTypeOptions(data.get("ProblemType4Option5"));
			                Thread.sleep(1000);
			                vehicle.clickonProblemTypeOptions(data.get("ProblemType4Option6"));
			                vehicle.clickOnAddButtonTriageSection();
			
			                String errMessage = vehicle.getTextInvalidCommentProvided();
			                assertTrue(errMessage.equalsIgnoreCase(data.get("InvalidCommentProvided")),"Error displays-Invalid Comment Provided");
			                vehicle.EnterTextCommentTriageSection(data.get("FuelLeakComments"));
			                vehicle.clickOnAddButtonTriageSection();
			                vehicle.validateSelectedPaceSetterCode();
			                locations.clickOnCallCommentsButton();
			                String strSelectedPaceSetterCode = vehicle.GetSelectedPaceSetterCode();
			                String commentsFromCommentWindow = locations.GetComentsFromCommentWindow();
			                assertTrue(commentsFromCommentWindow.contains(strSelectedPaceSetterCode) && commentsFromCommentWindow.contains(data.get("FuelLeakComments")),"There is a comment for Triage Selection");
			                locations.clickOnCallCommentsButton();
			                locations.enterCallComments(data.get("Comments"));
			                locations.clickOnCallCommentsAddButton();
			                locations.clickOnCallCommentsButton();
			                locations.validateComentsInCommentPopUp(data.get("Comments"));
			                locations.clickOnCallCommentsButton();
			                Thread.sleep(1000);
			                //Validating Comments part (Steps 13,14,15,16,18)
			               /* locations.verifyCommentBoxExists();
			                locations.clickOnCallCommentsAddButton();  // Clicking on Add Button
			                String commentsActual = locations.getCallComments();
			                String commentsExpected = data.get("ErrMessage");
			                locations.validateCommentsErrorMessage(commentsExpected,commentsActual);
			                locations.enterCallComments(data.get("Comments"));
			                String initialCommentsCount =locations.getCommentsCountFromCommentsButton();
			                locations.clickOnCallCommentsAddButton();
			                Thread.sleep(1000);
			                String finalCommentsCount =locations.getCommentsCountFromCommentsButton();
			                locations.VerifyCallReceivesPacesetterCode(initialCommentsCount,finalCommentsCount);
			                locations.clickOnCallCommentsButton();
			                Thread.sleep(2000);
			                locations.validateComentsInCommentPopUp(data.get("Comments"));
			                locations.clickIconMessageWindowClose();*/
			                home.logout();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1620",ReportStatus.strMethodName,intCounter,browser);
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
    public void ValidateBatteryTriageQuestions(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"crTriage", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crTriage", TestData, "D3CallRecieving",intCounter);
    	
			                this.reporter.initTestCaseDescription("1620:TC-Vehicle Triage"+ " From Iteration " + StartRow + " to " + EndRow );
			                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
			
			                LoginToApplication(data);
			                addingMemberShipLocationVehicleDetails(data);
			
			                vehicle.clickonProblemTypeButton(data.get("ProblemType1"));
			                Thread.sleep(1000);
			                vehicle.clickonProblemTypeOptions(data.get("ProblemType1Option1"));
			                vehicle.handleScriptErrorInVehicleTriagePage();
			                vehicle.validateSelectedPaceSetterCode();
			                Thread.sleep(1000);
			                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
			                vehicle.clickonProblemTypeButton(data.get("ProblemType1"));
			                Thread.sleep(2000);
			                vehicle.clickonProblemTypeOptions(data.get("ProblemType1Option2"));
			                Thread.sleep(2000);
			                vehicle.validateQuestionDisplayedInTriageSection();
			                vehicle.clickonProblemTypeOptions(data.get("ProblemType1Option3"));
			                vehicle.handleScriptErrorInVehicleTriagePage();
			                vehicle.validateSelectedPaceSetterCode();
			                Thread.sleep(2000);
			                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
			                //Changing Vehicle Type
			                vehicle.enterVehicleType(data.get("VehicleTypeNew"));
			                vehicle.clickTag();
			                Thread.sleep(2000);
			                vehicle.clickonProblemTypeButton(data.get("ProblemType1"));
			                Thread.sleep(2000);
			                vehicle.clickonProblemTypeOptions(data.get("ProblemType1Option4"));
			                Thread.sleep(5000);
			                vehicle.handleScriptErrorInVehicleTriagePage();
			                vehicle.validateSelectedPaceSetterCode();
			                vehicle.handleScriptErrorInVehicleTriagePage();
			                String Code = vehicle.getCodeNumberFromSelectedPaceSetterCode();
			
			                SaveAndValidateCallId(data,Code);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1620",ReportStatus.strMethodName,intCounter,browser);
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
    public void ValidateEngineTriageQuestions(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"crTriage", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crTriage", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1620:TC-Vehicle Triage"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRTowDestinationLib towdestination = new CRTowDestinationLib();
		
		                LoginToApplication(data);
		                addingMemberShipLocationVehicleDetails(data);
		
		                vehicle.clickonProblemTypeButton(data.get("ProblemType2"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType2Option1"));
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                vehicle.validateSelectedPaceSetterCode();
		                Thread.sleep(2000);
		                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		                vehicle.clickonProblemTypeButton(data.get("ProblemType2"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType2Option2"));
		                Thread.sleep(2000);
		
		                vehicle.validateQuestionDisplayedInTriageSection();
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType2Option3"));
		
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                vehicle.validateSelectedPaceSetterCode();
		                Thread.sleep(3000);
		                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		                //Changing Vehicle Type
		                vehicle.enterVehicleType(data.get("VehicleTypeNew"));
		                vehicle.clickTag();
		                Thread.sleep(2000);
		
		                vehicle.clickonProblemTypeButton(data.get("ProblemType2"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType2Option4"));
		                Thread.sleep(2000);
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(2000);
		                vehicle.validateSelectedPaceSetterCode();
		                String Code = vehicle.getCodeNumberFromSelectedPaceSetterCode();
		                // Navigating to Tow Destination Tab
		                towdestination.clickOnTowDestinationTab();
		                Thread.sleep(3000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(3000);
		                towdestination.clickOnManualEntryLinkOnTowDestination();
		                Thread.sleep(3000);
		                towdestination.enterTowPassengers(data.get("TowPassangers"));
		
		                SaveAndValidateCallId(data,Code);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1620",ReportStatus.strMethodName,intCounter,browser);
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
    public void ValidateFlatTireTriageQuestions(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crTriage", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crTriage", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1620:TC-Vehicle Triage"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		
		                LoginToApplication(data);
		                addingMemberShipLocationVehicleDetails(data);
		
		                vehicle.clickonProblemTypeButton(data.get("ProblemType3"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType3Option1"));
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                vehicle.validateSelectedPaceSetterCode();
		                Thread.sleep(2000);
		                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		                vehicle.clickonProblemTypeButton(data.get("ProblemType3"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType3Option2"));
		                Thread.sleep(2000);
		
		                vehicle.validateQuestionDisplayedInTriageSection();
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType3Option3"));
		
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                vehicle.validateSelectedPaceSetterCode();
		                Thread.sleep(2000);
		                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		                //Changing Vehicle Type
		                vehicle.enterVehicleType(data.get("VehicleTypeNew"));
		                vehicle.clickTag();
		
		                Thread.sleep(2000);
		
		                vehicle.clickonProblemTypeButton(data.get("ProblemType3"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType3Option4"));
		                Thread.sleep(2000);
		                home.allErrorAlerts();
		                Thread.sleep(2000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(2000);
		                vehicle.validateSelectedPaceSetterCode();
		                String Code = vehicle.getCodeNumberFromSelectedPaceSetterCode();
		                SaveAndValidateCallId(data,Code);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1620",ReportStatus.strMethodName,intCounter,browser);
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
    public void ValidateFuelTriageQuestions(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crTriage", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crTriage", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1620:TC-Vehicle Triage"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		
		                LoginToApplication(data);
		                addingMemberShipLocationVehicleDetails(data);
		
		                vehicle.clickonProblemTypeButton(data.get("ProblemType4"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType4Option1"));
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                vehicle.validateSelectedPaceSetterCode();
		                Thread.sleep(2000);
		                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		                vehicle.clickonProblemTypeButton(data.get("ProblemType4"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType4Option2"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType4Option3"));
		                vehicle.validateQuestionDisplayedInTriageSection();
		                vehicle.clickonProblemTypeOptions(data.get("ProbmenType4Fuel"));
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                vehicle.validateSelectedPaceSetterCode();
		                Thread.sleep(2000);
		                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		                //Changing Vehicle Type
		                vehicle.enterVehicleType(data.get("VehicleTypeNew"));
		                vehicle.clickTag();
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeButton(data.get("ProblemType4"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType4Option4"));
		                Thread.sleep(2000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(2000);
		                vehicle.validateSelectedPaceSetterCode();
		                Thread.sleep(2000);
		                String Code = vehicle.getCodeNumberFromSelectedPaceSetterCode();
		                SaveAndValidateCallId(data,Code);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1620",ReportStatus.strMethodName,intCounter,browser);
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
    public void ValidateKeyslTriageQuestions(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crTriage", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crTriage", TestData, "D3CallRecieving",intCounter);
    	
		               this.reporter.initTestCaseDescription("1620:TC-Vehicle Triage"+ " From Iteration " + StartRow + " to " + EndRow );
		               reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		               CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		               LoginToApplication(data);
		               addingMemberShipLocationVehicleDetails(data);
		               vehicle.clickonProblemTypeButton(data.get("ProblemType5"));
		               Thread.sleep(2000);
		               vehicle.clickonProblemTypeOptions(data.get("ProblemType5Option1"));
		               vehicle.handleScriptErrorInVehicleTriagePage();
		               vehicle.validateSelectedPaceSetterCode();
		               Thread.sleep(2000);
		               vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		               vehicle.clickonProblemTypeButton(data.get("ProblemType5"));
		               Thread.sleep(2000);
		               vehicle.clickonProblemTypeOptions(data.get("ProblemType5Option2"));
		               Thread.sleep(2000);
		               vehicle.validateQuestionDisplayedInTriageSection();
		               vehicle.clickonProblemTypeOptions(data.get("ProblemType5Option3"));
		               vehicle.handleScriptErrorInVehicleTriagePage();
		               Thread.sleep(2000);
		               vehicle.validateSelectedPaceSetterCode();
		               Thread.sleep(2000);
		               vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		               //Changing Vehicle Type
		               vehicle.enterVehicleType(data.get("VehicleTypeNew"));
		               vehicle.clickTag();
		               Thread.sleep(2000);
		               vehicle.clickonProblemTypeButton(data.get("ProblemType5"));
		               Thread.sleep(2000);
		               vehicle.clickonProblemTypeOptions(data.get("ProblemType5Option4"));
		               vehicle.handleScriptErrorInVehicleTriagePage();
		               vehicle.validateSelectedPaceSetterCode();
		               String Code = vehicle.getCodeNumberFromSelectedPaceSetterCode();
		
		               SaveAndValidateCallId(data,Code);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1620",ReportStatus.strMethodName,intCounter,browser);
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
    public void ValidateShortCutslTriageQuestions(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crTriage", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crTriage", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1620:TC-Vehicle Triage"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		
		                LoginToApplication(data);
		                addingMemberShipLocationVehicleDetails(data);
		
		                vehicle.clickonProblemTypeButton(data.get("ProblemType6"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType6Option1"));
		                Thread.sleep(2000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(2000);
		                vehicle.validateSelectedPaceSetterCode();
		                Thread.sleep(2000);
		                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		                vehicle.clickonProblemTypeButton(data.get("ProblemType6"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType6Option2"));
		                Thread.sleep(2000);
		                vehicle.validateQuestionDisplayedInTriageSection();
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType6Option3"));
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                vehicle.validateSelectedPaceSetterCode();
		                Thread.sleep(3000);
		                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		                //Changing Vehicle Type
		                vehicle.enterVehicleType(data.get("VehicleTypeNew"));
		                vehicle.clickTag();
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeButton(data.get("ProblemType6"));
		                Thread.sleep(2000);
		                //if (data.get("ProblemType"+i).equalsIgnoreCase("Shortcuts") ) {
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType6Option4"));
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType6ShortCuts"));
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                vehicle.validateSelectedPaceSetterCode();
		                String Code = vehicle.getCodeNumberFromSelectedPaceSetterCode();
		                SaveAndValidateCallId(data,Code);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1620",ReportStatus.strMethodName,intCounter,browser);
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
    public void ValidateTowlTriageQuestions(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crTriage", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crTriage", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1620:TC-Vehicle Triage"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRTowDestinationLib towdestination = new CRTowDestinationLib();
		                LoginToApplication(data);
		                addingMemberShipLocationVehicleDetails(data);
		                vehicle.clickTag();
		                vehicle.clickonProblemTypeButton(data.get("ProblemType7"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType7Option1"));
		                Thread.sleep(2000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(1000);
		                vehicle.validateSelectedPaceSetterCode();
		                Thread.sleep(1000);
		                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		                vehicle.clickonProblemTypeButton(data.get("ProblemType7"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType7Option2"));
		                Thread.sleep(2000);
		                vehicle.validateQuestionDisplayedInTriageSection();
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType7Option3"));
		                Thread.sleep(2000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                vehicle.validateSelectedPaceSetterCode();
		                Thread.sleep(2000);
		                vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
		                //Changing Vehicle Type
		                vehicle.enterVehicleType(data.get("VehicleTypeNew"));
		                vehicle.clickTag();
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeButton(data.get("ProblemType7"));
		                Thread.sleep(2000);
		                vehicle.clickonProblemTypeOptions(data.get("ProblemType7Option4"));
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                vehicle.validateSelectedPaceSetterCode();
		                String Code = vehicle.getCodeNumberFromSelectedPaceSetterCode();
		                towdestination.clickOnTowDestinationTab();
		                Thread.sleep(3000);
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(3000);
		                towdestination.clickOnManualEntryLinkOnTowDestination();
		                Thread.sleep(3000);
		                towdestination.enterTowPassengers(data.get("TowPassangers"));
		                SaveAndValidateCallId(data,Code);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1620",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    public void SaveAndValidateCallId(Hashtable<String, String> data, String code)throws Throwable{

        CRHomeLib home = new CRHomeLib();

        CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
        CRServiceLib service = new CRServiceLib();
        CRSearchCallsLib servicecalls = new CRSearchCallsLib();

        home.saveButton();
        Thread.sleep(6000);
        home.allErrorAlerts();
        vehicle.handleScriptErrorInVehicleTriagePage();
        String callID = service.getCallId();
        service.closeCallWindow();
        servicecalls.clickOnSearchCalls();
        Thread.sleep(3000);
        home.enterCallIdForSearch(callID);
        home.clickOnSearchButtonOnSearchCalls();
        Thread.sleep(5000);
        home.validateDispatchCodeInSearchCallsPoPUpWindow(code);// Add Dynamic Parameter Later
        home.clickOnCloseIconOnSearchCallsWindow();
        home.logout();
    }

    public void addingMemberShipLocationVehicleDetails(Hashtable<String, String> data) throws Throwable{

        CRHomeLib home = new CRHomeLib();
        CRMemberSearchLib memeber = new CRMemberSearchLib();
        CRLocationsLib locations = new CRLocationsLib();
        CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
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
        	Member = data.get("MemberNumber");
        }
        home.memberSearchTextBox(Member);
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


