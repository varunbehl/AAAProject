package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRMemberSearchPage;
import com.aaa.web.page.CRServicePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRPhoneTempDelete extends LoginLib {
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void memberContactInfoSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "phoneTempDelete",TestData,"D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("phoneTempDelete",TestData,"D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("MemberContactInfo"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib crLocationsLib=new CRLocationsLib();
		                CRVehicleTriageLib crVehicletriageLib=new CRVehicleTriageLib();
		                CRServiceLib crServiceLib =new CRServiceLib();
		                home.verifyandClickLogout();
		                login(data.get("LoginName"),data.get("Password"));
		                home.messageDialogBoxClose();
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
		                home.memberSearchTextBox(Member);
		                member.memberNumberColNullValueCheck();
		                member.tempDelete();
		                crLocationsLib.breakdownLocTabSel();
		                crLocationsLib.enterBreakDownAddressOmniBarSearch(data.get("Breakdownaddress"));
		                //enter vehicle information
		                crVehicletriageLib.vehicletriageTabsel();
		                String VehicleDet[] = data.get("Vehiclemodel").split("#");
		                crVehicletriageLib.enterVehicleSearch(VehicleDet[0]);
		                crVehicletriageLib.clickOnTheVehicleSearchIcon();
		                crVehicletriageLib.clickOnTheVehicleSearch();
		                crVehicletriageLib.vehicleColor(VehicleDet[1]);
		                crVehicletriageLib.generatePacesetterCode();
		                crVehicletriageLib.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(3000);
		                home.saveButton();
		                crServiceLib.closeCall();
		                home.memberSearchTextBox(Member);
		                member.memberNumberColNullValueCheck();
		                home.logout();
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
