package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRCreditCard extends LoginLib {
    public static String autoSpotId = null;
    CRHomeLib crHomeLib = new CRHomeLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib CRServiceLib = new CRServiceLib();

    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void verifyCreditCard(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyCreditCard", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("clearCallFullServices", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1606:TC-Credit Card"+ " From Iteration " + StartRow + " to " + EndRow );
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
		                crMemberSearchLib.memberNumClick();
		                crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
		                crLocationsLib.clickOnLocationTab();
		                crLocationsLib.clickOnSecondKownBrkDowLocation();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.selectExistingVehicleModel();
		                crVehicleTriageLib.clickonProblemTypeButton(data.get("ProblemType1"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                crVehicleTriageLib.validateSelectedPaceSetterCode();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                CRServiceLib.clickOnServiceTab();
		                autoSpotId = CRServiceLib.validateFacilityAutospotID();
		                CRServiceLib.clickOnCreditCard();
		                String creditCardIconInCallRibbon = CRServiceLib.verifyCreditCardInCallRibbon();
		                assertTrue(creditCardIconInCallRibbon != null, " Credit Card icon is displayed in the call ribbon."+creditCardIconInCallRibbon);
		                //verify on step
		                CRServiceLib.clickOnCreditCardInCallRibbion();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1606",ReportStatus.strMethodName,intCounter,browser);
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
