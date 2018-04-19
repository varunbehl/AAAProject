package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRMemberSearchPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRFacilityPreference extends LoginLib {
	public static String autoSpotId=null;
	public static String autoSpotId1=null;
	public static String autoSpotId2=null;
	public static String autoSpotId3=null;
	public static String autoSpotId4=null;
    public static String autoSpotIdFl=null;
	CRHomeLib crHomeLib = new CRHomeLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib CRServiceLib = new CRServiceLib();
	
  
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyPostCondition(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyPostCondition",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyPostCondition",TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1653:TC-Facility Preference"+ " From Iteration " + StartRow + " to " + EndRow );
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
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                crVehicleTriageLib.selectVehicleModel();
		                CRServiceLib.clickOnServiceTab();
		                autoSpotId =  CRServiceLib.validateFacilityAutospotID();
		                System.out.println(autoSpotId);
		                CRServiceLib.enterFacilityPreference(autoSpotId);
		                CRServiceLib.clickOnAvoid();
		                autoSpotId1 =  CRServiceLib.validateFacilityAutospotID();
		                System.out.println(autoSpotId1);
		                Thread.sleep(2000);
		                boolean spotIdCompare =!(autoSpotId.equalsIgnoreCase(autoSpotId1));
		                assertTrue(spotIdCompare,"Expected::" +autoSpotId+  "::Value and Actual value::" +autoSpotId1+"::not matched::"+ "::Facility is removed");
		                CRServiceLib.clickOnPrefer();
		                autoSpotId2 =  CRServiceLib.validateFacilityAutospotID();
		                Thread.sleep(2000);
		                boolean spotIdCompare1 =(autoSpotId.equalsIgnoreCase(autoSpotId2));
		                assertTrue(spotIdCompare1,"Expected::" +autoSpotId+  "::Value and Actual value::" +autoSpotId2+"::matched::"+ "::Facility is set to the location");
		                crHomeLib.leaveButton();
		                crHomeLib.allErrorAlerts();
		
		                //To capture Invalid autospot ID
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crHomeLib.memberSearchTextBox(Member);
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickOnSecondKownBrkDowLocation();
		                crVehicleTriageLib.selectVehicleModel();
		                CRServiceLib.clickOnServiceTab();
		                autoSpotIdFl =  CRServiceLib.validateFacilityAutospotID();
		                crHomeLib.leaveButton();
		                crHomeLib.allErrorAlerts();
		
		                //To validate error msg by using invalid autospot ID
		                crMemberSearchLib.clickOnPartialCallCloseButton();
		                crHomeLib.messageDialogBoxClose();
		                Thread.sleep(5000);
		                crHomeLib.memberSearchTextBox(Member);
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                crVehicleTriageLib.selectVehicleModel();
		                CRServiceLib.clickOnServiceTab();
		                CRServiceLib.enterFacilityPreference(autoSpotIdFl);
		                CRServiceLib.clickOnPrefer();
		                CRServiceLib.clickOnPrefer();
		                CRServiceLib.verifyErrorMsgForAutospot();
		                Thread.sleep(1000);
		                crHomeLib.clickOnAutospotFailMsgOk();
		                Thread.sleep(2000);
		                crHomeLib.clickOnAutospotFailMsgOk();
		                Thread.sleep(2000);
		                crHomeLib.leaveButton();
		                crHomeLib.allErrorAlerts();
		                crHomeLib.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1653",ReportStatus.strMethodName,intCounter,browser);
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
    public void verifyPrecondition(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyPrecondition",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyPrecondition",TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("1653:TC-Facility Preference"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                // navigateToApplication("CR");
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
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                CRServiceLib.clickOnServiceTab();
		                CRServiceLib.enterFacilityPreference(autoSpotId);
		                CRServiceLib.clickOnAvoid();
		                crVehicleTriageLib.selectVehicleModel();
		                CRServiceLib.clickOnServiceTab();
		                autoSpotId3 =  CRServiceLib.validateFacilityAutospotID();
		                System.out.println(autoSpotId3);
		                boolean spotIdCompare3 =!(autoSpotId.equalsIgnoreCase(autoSpotId3));
		                assertTrue(spotIdCompare3,"Expected::" +autoSpotId+  "::Value and Actual value::" +autoSpotId3+"::not matched::"+ "::Call is not auto spotted to the facility");
		                crHomeLib.leaveButton();
		                crHomeLib.allErrorAlerts();
		
		                crHomeLib.memberSearchTextBox(Member);
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                //select location
		                crLocationsLib.clickonBrkdownLocLink();
		                CRServiceLib.clickOnServiceTab();
		                CRServiceLib.enterFacilityPreference(autoSpotId);
		                CRServiceLib.clickOnPrefer();
		                crVehicleTriageLib.selectVehicleModel();
		                CRServiceLib.clickOnServiceTab();
		                autoSpotId4 =  CRServiceLib.validateFacilityAutospotID();
		                System.out.println(autoSpotId4);
		                boolean spotIdCompare4 =(autoSpotId.equalsIgnoreCase(autoSpotId4));
		                assertTrue(spotIdCompare4,"Expected::" +autoSpotId+  "::Value and Actual value::" +autoSpotId4+"::matched::"+ "::call is auto spotted to the facility");
		                crHomeLib.allErrorAlerts();
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
    			ReportStatus.fnUpdateResultStatus("CR","1653",ReportStatus.strMethodName,intCounter,browser);
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

