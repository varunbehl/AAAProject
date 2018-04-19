package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DIMCDPage;
import com.aaa.web.page.DISearchCallsPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CREntitlements extends ActionEngine {
    public static String callID;
    LoginLib login = new LoginLib();
    CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRServiceLib services = new CRServiceLib();
    DILoginLib diLoginLib = new DILoginLib();
    LoginRoleLib role = new LoginRoleLib();
    DIHomeLib diHome = new DIHomeLib();
    DIMCDLib dimcdLib = new DIMCDLib();
    DISearchCallsPage diSearchCallsPage=new DISearchCallsPage();

    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: entitlements
     * description :: entitlements
     * date :: 18-Dec-2017
     * author :: Abhiram Vajrapu - E004118
     */

    public void entitlements(Hashtable<String, String> data) throws Throwable {
        try {
            if (data.get("RunMode").equals("Y")) {
                this.reporter.initTestCaseDescription("1983:TS-CR Entitlements");
                login.login(data.get("LoginName"),data.get("Password"));
                Thread.sleep(12000);
                crHomeLib.messageDialogBoxClose();
                Thread.sleep(16000);
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
                crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
                crVehicleTriageLib.clickOnVehicleTriageTab();
                String VehicleDet[] = data.get("Vehiclemodel").split("#");
                crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
                crVehicleTriageLib.clickOnTheVehicleSearchIcon();
                crVehicleTriageLib.clickOnTheVehicleSearch();
                crVehicleTriageLib.vehicleColor(VehicleDet[1]);
                crVehicleTriageLib.clickOnFuel();
                crVehicleTriageLib.clickOnOutOfGas();
                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
                crHomeLib.saveButton();
                crHomeLib.allErrorAlerts();
                //services.getCallId();
                callID = services.getCallId();
                services.clickOnRemainInCall();
                crMemberSearchLib.clickOnMemberTab();
                crMemberSearchLib.memberCurrentCalls();
                navigateToApplication("DI");
                diLoginLib.login(data.get("DILoginName"),data.get("DIPassword"));
                role.clickOnProceedBtnInDispatchRoleLogin();
                diLoginLib.waitcloseAllBusyIcons();
                diHome.clickOnCloseIconOnQueueSelection();
                diHome.clickOnSearchCallsInDispatch();
                diHome.enterCallIDInfo(callID);
                diHome.clickOnSearchInSearchCalls();
                diHome.clickOnCallDateOrIDLink();
                dimcdLib.clickOnAssign();
                dimcdLib.selectFacility();
                dimcdLib.selectDispatch();
                dimcdLib.selectEnroute();
                dimcdLib.selectEnrouteTime();
                dimcdLib.selectOnLocation();
                dimcdLib.selectClearCall();
                dimcdLib.selectExitCode();
            }
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

  
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void entitlementsCallClear(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "entitlements", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("entitlements", TestData, "D3CallRecieving",intCounter);
    	
    					this.reporter.initTestCaseDescription("entitlementsCallClear "+ " From Iteration " + StartRow + " to " + EndRow );		
		    			reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");		
		                entitlements(data);
		                dimcdLib.enterReason(data.get("Reason"));
		                dimcdLib.clickOnContinue();
		                Thread.sleep(5000);
		                dimcdLib.labelCallCleared(data.get("DIStatusCL"));
		                dimcdLib.clickOnMCDCloseWindow();
		                diHome.logOut();
		                acceptAlert();
		                acceptAlert();
		                Thread.sleep(5000);
		
		                driver.manage().deleteAllCookies();
		                navigateToApplication("CR");
		              /*  entitlements(data);
		                dimcdLib.enterReason(data.get("Reason"));
		                dimcdLib.clickOnContinue();
		                dimcdLib.clickOnSubmit();
		                dimcdLib.labelCallCleared();*/
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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
    public void entitlementsCallClearGOA(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "entitlementsCallClearGOA", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("entitlementsCallClearGOA", TestData, "D3CallRecieving",intCounter);
    					this.reporter.initTestCaseDescription("entitlementsCallClear "+ " From Iteration " + StartRow + " to " + EndRow );		
    		    		reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");		
    		              
    					
		                //navigateToApplication("CR");
		                entitlements(data);
		
		                boolean errorMessage = false;
		                dimcdLib.selectExitCode();
		                dimcdLib.enterReason(data.get("Reason"));
		                dimcdLib.clickOnContinue();
		                Thread.sleep(3000);
		                errorMessage = dimcdLib.verifyErrorMessageAtReasonInMCDWindow();
		                if(errorMessage)
		                {
		                    dimcdLib.closeErrorAlert();
		                    clearData(DIMCDPage.txtReason);
		                    dimcdLib.enterReason(data.get("ReenterReason"));
		                    dimcdLib.clickOnContinue();
		                    dimcdLib.labelCallCleared(data.get("DIStatusCL"));
		                }
		                else {
		                    dimcdLib.clickonSubmitandVerifyClearCallLabel(data.get("DIStatusCL"));
		                }
		                System.out.println("Test completed");
    					
    		}
			catch(Exception e)
			{
				ReportStatus.blnStatus=false;
			}
			ReportControl.fnEnableJoin();
			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
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
