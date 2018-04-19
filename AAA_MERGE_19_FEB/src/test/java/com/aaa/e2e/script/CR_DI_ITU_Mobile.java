package com.aaa.e2e.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.d3itu.lib.*;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CR_DI_ITU_Mobile extends LaunchITULib
{
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String [] callandfacilityId = new String[2];
    public static boolean verifyAddressAvailableForOtherLocationInMCDWindow;

    LoginITULib loginITU =new LoginITULib();
    facilityandTruckSelectionLib facilityandTruckSelectionlib =new facilityandTruckSelectionLib();
    CallsLib calllib=new CallsLib();
    PacesetterResolutionLib pacesetterResolutionlib = new PacesetterResolutionLib();
    ETALib etalib =new ETALib();
    @AfterMethod(alwaysRun = true)
    public void afterMethod() throws Throwable {
        //logOut();
        this.appiumDriver.resetApp();
        super.afterMethod();
    }
    public static final int WAITTIME = 50000;

    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void CRDIITUMobileEnd2End(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "CRDIITUMobile", TestData, "e2eCRDIITUMobile");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("CRDIITUMobile", TestData, "e2eCRDIITUMobile",intCounter);
		
    					reporter.initTestCaseDescription("CR DI ITU End to End"+ " From Iteration " + StartRow + " to " + EndRow );
    					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
	    		        selectEnvironment(data.get("ITUEnvironment"));
		                loginITU.enterLoginDetails(data.get("UserName"),data.get("Password"));
		                facilityandTruckSelectionlib.getFacility();
		                facilityandTruckSelectionlib.selectFacilityandContinue(data.get("TruckID"));
		                calllib.clickOnCallToClear();
		                calllib.statusUpdateAsAs(data.get("StatusupdateAS"));
		                calllib.statusUpdateAsAssignment(data.get("Assignmnet"));
		                calllib.statusUpdateAsDI(data.get("statusupdatediitu"));
		                etalib.statusUpdateAsETA(data.get("updatecalletaitu"));
		                calllib.statusUpdateAsER(data.get("statusupdateeritu"));
		                calllib.statusUpdateAsOL(data.get("statusupdateolitu"));
		                calllib.statusUpdateAsTW(data.get("statusupdatetwitu"));
		                calllib.statusUpdateAsCL(data.get("statusupdateclitu"));
		                System.out.println("Test completed");
		    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR_DI_ITU","7777",ReportStatus.strMethodName,intCounter,"EE");
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