package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRMemberSearchPage;
import com.aaa.web.page.CRTowDestinationPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRRules extends LoginLib {
	CRHomeLib crHomeLib = new CRHomeLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib CRServiceLib = new CRServiceLib();
    CRTowDestinationLib crTowDestinationLib=new CRTowDestinationLib();
    public static String towDestination=null;
    public static String confirmationQuestion=null;

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyEndCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyEndCall",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyEndCall",TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("1717: TC-Rules"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		                login(data.get("LoginName"),data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
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
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.clickOnOutOfGas();
		                crHomeLib.saveButton();
		                acceptAlert();
		                crHomeLib.allErrorAlerts();
		                CRServiceLib.getCallId();
		                CRServiceLib.closeCallWindow();
		                crHomeLib.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1717",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }


    //Red Flag(3)

   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyRedFlag(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyRedFlag",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyRedFlag",TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1717: TC-Rules"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                //navigateToApplication("CR");
		                login(data.get("LoginName"),data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
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
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.clickOnOutOfGas();
		                CRServiceLib.clickOnServiceTab();
		                CRServiceLib.enterPriority1(data.get("priority"));
		                CRServiceLib.verifyRedFlagChecked();
		                crHomeLib.saveButton();
		                acceptAlert();
		                crHomeLib.allErrorAlerts();
		                CRServiceLib.getCallId();
		                CRServiceLib.closeCallWindow();
		                crHomeLib.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1717",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }


    //Tow Destination Required - Towing Service(6)


    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyTowDestinationRequiredTowingService(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyTowDestinationRequiredTowingService",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyTowDestinationRequiredTowingService",TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1717: TC-Rules"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		                login(data.get("LoginName"),data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
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
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickonProblemTypeButton(data.get("ProblemType7"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.clickonProblemTypeOptions(data.get("ProblemType7Option4"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crTowDestinationLib.clickOnTowDestinationTab();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crTowDestinationLib.clickOnExistingTowDetinationLink();
		                crTowDestinationLib.verifyTowPassengers();
		                crTowDestinationLib.enterTowPassengers(data.get("TowPassengers"));
		                crHomeLib.saveButton();
		                acceptAlert();
		                crHomeLib.allErrorAlerts();
		                CRServiceLib.getCallId();
		                CRServiceLib.closeCallWindow();
		                crHomeLib.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1717",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }



    //Tow Destination Un-required - Light service(9)


   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyTowDestinationUnrequiredLightService(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyTowDestinationUnrequiredLightService",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyTowDestinationUnrequiredLightService",TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1717: TC-Rules"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		                login(data.get("LoginName"),data.get("Password"));
		                Thread.sleep(5000);
		               crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
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
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickonProblemTypeButton(data.get("ProblemType7"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.clickonProblemTypeOptions(data.get("ProblemType7Option4"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.validateSelectedPaceSetterCode();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crTowDestinationLib.clickOnTowDestinationTab();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crTowDestinationLib.clickOnExistingTowDetinationLink();
		                crTowDestinationLib.verifyTowPassengers();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.clickCloseIconInSelectedPaceSetterCodeSection();
		                Thread.sleep(2000);
		                crVehicleTriageLib.clickonProblemTypeButton(data.get("ProblemType"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.clickonProblemTypeOptions(data.get("ProblemTypeOption"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.validateSelectedPaceSetterCode();
		                crHomeLib.allErrorAlerts();
		                crHomeLib.saveButton();
		                acceptAlert();
		                crHomeLib.allErrorAlerts();
		                CRServiceLib.getCallId();
		                CRServiceLib.closeCallWindow();
		                crHomeLib.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1717",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    //Tow Destination Required - Extrication Service(13)


   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyTowDestinationRequiredExtricationService(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyTowDestinationRequiredExtricationService",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyTowDestinationRequiredExtricationService",TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1717: TC-Rules"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		              login(data.get("LoginName"),data.get("Password"));
		              Thread.sleep(5000);
		               crMemberSearchLib.clickOnPartialCallCloseButton();
		               crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
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
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.validateSelectedPaceSetterCode();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crTowDestinationLib.clickOnTowDestinationTab();
		                Thread.sleep(2000);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crTowDestinationLib.clickOnExistingTowDetinationLink();
		                crTowDestinationLib.verifyTowPassengers();
		                crTowDestinationLib.enterTowPassengers(data.get("TowPassengers"));
		                crHomeLib.saveButton();
		                acceptAlert();
		                crHomeLib.allErrorAlerts();
		                CRServiceLib.getCallId();
		                CRServiceLib.closeCallWindow();
		                crHomeLib.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1717",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }


    //Tow Destination Un-required Fields - Extrication(16)


  
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyTowDestinationUnrequiredFieldsExtrication(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyTowDestinationUnrequiredFieldsExtrication",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyTowDestinationUnrequiredFieldsExtrication",TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1717: TC-Rules"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		               login(data.get("LoginName"),data.get("Password"));
		              Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
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
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode1"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.validateSelectedPaceSetterCode();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crTowDestinationLib.clickOnTowDestinationTab();
		                Thread.sleep(2000);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crTowDestinationLib.clickOnExistingTowDetinationLink();
		                crTowDestinationLib.verifyTowPassengers();
		                Thread.sleep(2000);
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.clickCloseIconInSelectedPaceSetterCodeSection();
		                Thread.sleep(2000);
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode2"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.validateSelectedPaceSetterCode();
		                towDestination = crTowDestinationLib.verifyTowDestinationTab();
		                assertTrue(towDestination != null, "Tow Destination Tab become not required:"+towDestination);
		                crHomeLib.allErrorAlerts();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.saveButton();
		                acceptAlert();
		                crHomeLib.allErrorAlerts();
		                CRServiceLib.getCallId();
		                CRServiceLib.closeCallWindow();
		                crHomeLib.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1717",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    //Tow Destination tab - Hiding the tab for Light Service(20)

  
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyTowDestinationTabHidingTabForLightService(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyTowDestinationTabHidingTabForLightService",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyTowDestinationTabHidingTabForLightService",TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1717: TC-Rules"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		                login(data.get("LoginName"),data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
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
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode1"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                towDestination = crTowDestinationLib.verifyTowDestinationTab();
		                assertTrue(towDestination != null, "Tow Destination Tab is hidden:"+towDestination);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.clickCloseIconInSelectedPaceSetterCodeSection();
		                Thread.sleep(2000);
		                crHomeLib.allErrorAlerts();
		
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode2"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                towDestination = crTowDestinationLib.verifyTowDestinationTab();
		                assertTrue(towDestination != null, "Tow Destination Tab is hidden:"+towDestination);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.clickCloseIconInSelectedPaceSetterCodeSection();
		                Thread.sleep(2000);
		                crHomeLib.allErrorAlerts();
		
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode3"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                towDestination = crTowDestinationLib.verifyTowDestinationTab();
		                assertTrue(towDestination != null, "Tow Destination Tab is hidden:"+towDestination);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.clickCloseIconInSelectedPaceSetterCodeSection();
		                Thread.sleep(2000);
		                crHomeLib.allErrorAlerts();
		
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode4"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                towDestination = crTowDestinationLib.verifyTowDestinationTab();
		                assertTrue(towDestination != null, "Tow Destination Tab is hidden:"+towDestination);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.clickCloseIconInSelectedPaceSetterCodeSection();
		                Thread.sleep(2000);
		                crHomeLib.allErrorAlerts();
		
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode5"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                towDestination = crTowDestinationLib.verifyTowDestinationTab();
		                assertTrue(towDestination != null, "Tow Destination Tab is hidden:"+towDestination);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.clickCloseIconInSelectedPaceSetterCodeSection();
		                Thread.sleep(2000);
		                crHomeLib.allErrorAlerts();
		                crHomeLib.leaveButton();
		                crHomeLib.allErrorAlerts();
		                crHomeLib.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1717",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }



    //Tow Destination Tab - Showing the tab of Towing(22)

   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyTowDestinationTabShowingTabOfTowing(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyTowDestinationTabShowingTabOfTowing",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyTowDestinationTabShowingTabOfTowing",TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1717: TC-Rules"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		                 login(data.get("LoginName"),data.get("Password"));
		                 Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
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
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode1"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                towDestination = crTowDestinationLib.verifyTowDestinationTab();
		                assertTrue(towDestination != null, "Tow Destination Tab is visible:"+towDestination);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.clickCloseIconInSelectedPaceSetterCodeSection();
		                Thread.sleep(2000);
		                crHomeLib.allErrorAlerts();
		
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode2"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                towDestination = crTowDestinationLib.verifyTowDestinationTab();
		                assertTrue(towDestination != null, "Tow Destination Tab is visible:"+towDestination);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.clickCloseIconInSelectedPaceSetterCodeSection();
		                Thread.sleep(2000);
		                crHomeLib.allErrorAlerts();
		
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode3"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                towDestination = crTowDestinationLib.verifyTowDestinationTab();
		                assertTrue(towDestination != null, "Tow Destination Tab is visible:"+towDestination);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.clickCloseIconInSelectedPaceSetterCodeSection();
		                Thread.sleep(2000);
		                crHomeLib.allErrorAlerts();
		
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode4"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                towDestination = crTowDestinationLib.verifyTowDestinationTab();
		                assertTrue(towDestination != null, "Tow Destination Tab is visible:"+towDestination);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.clickCloseIconInSelectedPaceSetterCodeSection();
		                Thread.sleep(2000);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.leaveButton();
		                crHomeLib.allErrorAlerts();
		                crHomeLib.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1717",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }



    //Tow Destination Tab - Extrication T931(24)

  
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyTowDestinationExtricationT931(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyTowDestinationExtricationT931",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyTowDestinationExtricationT931",TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1717: TC-Rules"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		              login(data.get("LoginName"),data.get("Password"));
		              Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
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
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.validateSelectedPaceSetterCode();
		                towDestination = crTowDestinationLib.verifyTowDestinationTab();
		                assertTrue(towDestination != null, "Tow Destination Tab is hidden:"+towDestination);
		                crHomeLib.allErrorAlerts();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.saveButton();
		                acceptAlert();
		                crHomeLib.allErrorAlerts();
		                CRServiceLib.getCallId();
		                CRServiceLib.closeCallWindow();
		                crHomeLib.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1717",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }


    //Tow Destination - Extrication T932(27)
  
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyTowDestinationExtricationT932(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyTowDestinationExtricationT932",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyTowDestinationExtricationT932",TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1717: TC-Rules"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		                login(data.get("LoginName"),data.get("Password"));
		                Thread.sleep(5000);
		               crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
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
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.enterPaceSetterCodeManually(data.get("paceSettercode"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.validateSelectedPaceSetterCode();
		                towDestination = crTowDestinationLib.verifyTowDestinationTab();
		                assertTrue(towDestination != null, "Tow Destination Tab is visible:"+towDestination);
		                crHomeLib.allErrorAlerts();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.leaveButton();
		                crHomeLib.allErrorAlerts();
		                crHomeLib.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1717",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }




    //SMS Opt-in(30)
   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifySMSOptIn(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifySMSOptIn",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifySMSOptIn",TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1717: TC-Rules"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                Thread.sleep(5000);
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
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
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crMemberSearchLib.checkOnSmsCheckBox();
		                confirmationQuestion = crMemberSearchLib.getConfirmationPopup();
		                assertTrue(confirmationQuestion != null, "SMS script fires with Yes/No options");
		                crHomeLib.allErrorAlerts();
		                //verify sms flag
		                boolean Status = isCheckBoxSelected(CRMemberSearchPage.chkBoxSms);
		                assertTrue(Status , "SMS flag is still set");
		                crHomeLib.leaveButton();
		                crHomeLib.allErrorAlerts();
		                Thread.sleep(5000);
		                crHomeLib.memberSearchTextBox(Member);
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crMemberSearchLib.checkOnSmsCheckBox();
		                confirmationQuestion = crMemberSearchLib.getConfirmationPopup();
		                assertTrue(confirmationQuestion != null, "SMS script fires with Yes/No options");
		                crHomeLib.allErrorAlertsNoButton();
		                //verify sms flag
		                boolean Status1 =  !isCheckBoxSelected(CRMemberSearchPage.chkBoxSms);
		                assertTrue(Status1 , "SMS flag  is unchecked");
		                Thread.sleep(5000);
		                crHomeLib.leaveButton();
		                crHomeLib.allErrorAlerts();
		                crHomeLib.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1717",ReportStatus.strMethodName,intCounter,browser);
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

