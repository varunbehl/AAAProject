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

public class TC_SaveERSCallLightService extends ActionEngine{

    //Object Creations
    LoginLib login = new LoginLib();
    CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib services = new CRServiceLib();
    DILoginLib diLoginLib = new DILoginLib();

    public void callLightService(Hashtable<String, String> data) throws Throwable {
        try {
            if (data.get("RunMode").equals("Y")) {
                this.reporter.initTestCaseDescription("1628:TS-Save ERS Call Light Service");
                Thread.sleep(5000);
                login.login(data.get("LoginName"),data.get("Password"));
                crHomeLib.messageDialogBoxClose();
                crHomeLib.memberSearchTextBox(data.get("Membersearch"));
                crMemberSearchLib.memberNumClick();
                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
                crLocationsLib.clickOnLocationTab();
                crLocationsLib.clickonBrkdownLocLink();
                crVehicleTriageLib.clickOnVehicleTriageTab();
                crVehicleTriageLib.selectExistingVehicleModel();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: basicMemberCallLightServiceForFuelTrouble
     * description :: basicMemberCallLightServiceForFuelTrouble
     * date :: 18-Dec-2017
     * author :: Abhiram Vajrapu - E004118
     */


    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void basicMemberCallLightServiceForFuelTrouble(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "basicMemberCallLightServiceForFuelTrouble", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("basicMemberCallLightServiceForFuelTrouble", TestData, "D3CallRecieving",intCounter);
    					this.reporter.initTestCaseDescription("basicMemberCallLightServiceForFuelTrouble"+ " From Iteration " + StartRow + " to " + EndRow );
    		          	reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                callLightService(data);
		                crVehicleTriageLib.clickOnFuel();
		                Thread.sleep(5000);
		                crVehicleTriageLib.clickOnOutOfGas();
		                Thread.sleep(5000);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.saveButton();
		                Thread.sleep(5000);
		                //crHomeLib.allErrorAlerts();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.allErrorAlerts();
		                services.closeCallWindow();
		                crHomeLib.logout();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("ERS","7777",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: plusOrPremierMemberCallLightServiceForFuelTrouble
     * description :: plusOrPremierMemberCallLightServiceForFuelTrouble
     * date :: 18-Dec-2017
     * author :: Abhiram Vajrapu - E004118
     */
   
    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void plusOrPremierMemberCallLightServiceForFuelTrouble(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "plusOrPremierMemberCallLightServiceForFuelTrouble", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("plusOrPremierMemberCallLightServiceForFuelTrouble", TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("1628:TS-Save ERS Call Light Service"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                callLightService(data);
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.clickOnOutOfGas();
		                crHomeLib.saveButton();
		                Thread.sleep(5000);
		
		                //crHomeLib.allErrorAlerts();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.allErrorAlerts();
		                services.closeCallWindow();
		                crHomeLib.logout();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("ERS","1628",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: basicMemberCallLightServiceForFlatTireSpare
     * description :: basicMemberCallLightServiceForFlatTireSpare
     * date :: 18-Dec-2017
     * author :: Abhiram Vajrapu - E004118
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void basicMemberCallLightServiceForFlatTireSpare(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "basicMemberCallLightServiceForFlatTireSpare", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("basicMemberCallLightServiceForFlatTireSpare", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1628:TS-Save ERS Call Light Service"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                callLightService(data);
		                crVehicleTriageLib.clickOnFlatTire();
		                crVehicleTriageLib.clickOnFlatTireFrontSide();
		                Thread.sleep(5000);
		                crVehicleTriageLib.clickOnFlatTireSpareTireYes();
		                Thread.sleep(5000);
		                crVehicleTriageLib.clickOnFlatTireLockingLugNuts();
		                Thread.sleep(5000);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.saveButton();
		                Thread.sleep(5000);
		
		                //crHomeLib.allErrorAlerts();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.allErrorAlerts();
		                services.closeCallWindow();
		                crHomeLib.logout();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("ERS","1628",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: basicMemberCallLightServiceForKeyLocked
     * description :: basicMemberCallLightServiceForKeyLocked
     * date :: 18-Dec-2017
     * author :: Abhiram Vajrapu - E004118
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void basicMemberCallLightServiceForKeyLocked(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "basicMemberCallLightServiceForKeyLocked", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("basicMemberCallLightServiceForKeyLocked", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1628:TS-Save ERS Call Light Service"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                callLightService(data);
		                crVehicleTriageLib.selectPaceSetterCode();
		                crHomeLib.saveButton();
		                Thread.sleep(5000);
		                // crHomeLib.allErrorAlerts();
		               // crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.allErrorAlerts();
		                services.closeCallWindow();
		                crHomeLib.logout();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("ERS","1628",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: plusMemberCallLightServiceForKeyLocked
     * description :: plusMemberCallLightServiceForKeyLocked
     * date :: 18-Dec-2017
     * author :: Abhiram Vajrapu - E004118
     */
  

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void plusMemberCallLightServiceForKeyLocked(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "plusMemberCallLightServiceForKeyLocked", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("plusMemberCallLightServiceForKeyLocked", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1628:TS-Save ERS Call Light Service"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                callLightService(data);
		                crVehicleTriageLib.selectPaceSetterCode();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                //crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.saveButton();
		                Thread.sleep(5000);
		
		                //crHomeLib.allErrorAlerts();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crHomeLib.allErrorAlerts();
		                services.closeCallWindow();
		                crHomeLib.logout();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("ERS","1628",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: premierMemberCallLightServiceForKeyLocked
     * description :: premierMemberCallLightServiceForKeyLocked
     * date :: 18-Dec-2017
     * author :: Abhiram Vajrapu - E004118
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void premierMemberCallLightServiceForKeyLocked(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "premierMemberCallLightServiceForKeyLocked", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("premierMemberCallLightServiceForKeyLocked", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1628:TS-Save ERS Call Light Service"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                callLightService(data);
		                crVehicleTriageLib.selectPaceSetterCode();
		                diLoginLib.closeErrorAlert();
		                crHomeLib.saveButton();
		                Thread.sleep(5000);
		
		                crHomeLib.allErrorAlerts();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                //crHomeLib.allErrorAlerts();
		                services.closeCallWindow();
		                crHomeLib.logout();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("ERS","1628",ReportStatus.strMethodName,intCounter,browser);
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

/* LoginLib login = new LoginLib();
                CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
                CRHomeLib crHomeLib = new CRHomeLib();
                CRServiceLib services = new CRServiceLib();
                CRLocationsLib crLocationsLib = new CRLocationsLib();
                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
                login.login(data.get("LoginName"),data.get("Password"));
                crHomeLib.messageDialogBoxClose();
                crHomeLib.memberSearchTextBox(data.get("Membersearch"));
                crMemberSearchLib.memberNumClick();
                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
                crLocationsLib.clickOnLocationTab();
                crLocationsLib.clickonBrkdownLocLink();
                //crLocationsLib.enterTxtinBrkDowLocSrch(data.get("Breakdownaddress"));
                crVehicleTriageLib.clickOnVehicleTriageTab();
                crVehicleTriageLib.selectExistingVehicle();*/