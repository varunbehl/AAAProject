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

public class TC_CRPacesetterAndTroubleCodeMapping extends ActionEngine {

    public static String PaceSetterCodeInSummaryCallWindow;
    public static String PaceSetterCodeInExcel;
    public static String PaceSetterCodes;
    public static int totalPaceSetterCodes;
    public static String TroubleCodeInSummaryCallWindow;
    public static String TroubleCodeInExcel;

  

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void crPacesetterAndTroubleCodeMapping(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "CRPacesetterAndTroubleCodeMapping", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("CRPacesetterAndTroubleCodeMapping", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1938: TC-CR Pacesetter & Trouble Code Mapping"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                Thread.sleep(5000);
		                LoginLib login = new LoginLib();
		                CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRLocationsLib crLocationsLib = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRServiceLib services = new CRServiceLib();
		                DILoginLib diLoginLib = new DILoginLib();
		                navigateToApplication("CR");
		                login.login(data.get("LoginName"),data.get("Password"));
		                crHomeLib.messageDialogBoxClose();
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
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                PaceSetterCodes=data.get("TotalPacesetterCodes");
		                totalPaceSetterCodes=Integer.parseInt(PaceSetterCodes);
		                for(int i=1;i<=totalPaceSetterCodes;i++)
		                {
		                    Thread.sleep(3000);
		                    crVehicleTriageLib.enterPaceSetterCode(data.get("PaceSetterCode"+i));
		                    crVehicleTriageLib.clickOnTheSelectedPaceSetterCodeFromDropDown();
		                    crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                    crVehicleTriageLib.clickOnCallSummary();
		
		                    PaceSetterCodeInSummaryCallWindow = crVehicleTriageLib.lblCallSummaryPaceSetterCodes();
		                    PaceSetterCodeInExcel = data.get("PaceSetterCode"+i);
		
		                    TroubleCodeInSummaryCallWindow=crVehicleTriageLib.lblCallSummaryTroubleCodes();
		                    TroubleCodeInExcel = data.get("TroubleCode"+i);
		
		                    boolean paceSetterValue = PaceSetterCodeInExcel.equalsIgnoreCase(PaceSetterCodeInSummaryCallWindow);
		                    assertTrue(paceSetterValue, "Pacesetter Codes summery on the sidebar" + PaceSetterCodeInSummaryCallWindow + " and Pacesetter Code Maps are correct" + PaceSetterCodeInExcel);
		
		                    boolean troubleValue = TroubleCodeInExcel.equalsIgnoreCase(TroubleCodeInSummaryCallWindow);
		                    assertTrue(troubleValue, "Trouble Codes summery on the sidebar" + TroubleCodeInSummaryCallWindow + " and Trouble Code Maps are correct" + TroubleCodeInExcel);
		
		                    crVehicleTriageLib.clickOnCloseCallSummary();
		                    crVehicleTriageLib.clickCloseIconInSelectedPaceSetterCodeSection();
		                    Thread.sleep(3000);
		                }
		                crHomeLib.logout();
		                System.out.println("Test Completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1938",ReportStatus.strMethodName,intCounter,browser);
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
