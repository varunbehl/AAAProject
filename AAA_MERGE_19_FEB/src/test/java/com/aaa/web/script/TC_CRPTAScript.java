package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by E003999 on 16-01-2018.
 */
public class TC_CRPTAScript extends LoginLib {
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void pta(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "PTA", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("PTA", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1724:CR_PTA"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		                LoginRoleLib loginRole = new LoginRoleLib();
		
		                home.verifyandClickLogout();
		                login(data.get("LoginName"), data.get("Password"));
		                home.messageDialogBoxClose();
		                member.currentCallClose();
		                boolean ptaFlag = home.verifyPTAFlag();
		                assertTrue(ptaFlag, "PTA Flag is Found");
		                home.verifyPTAValue();
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,100);
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                if(Member.isEmpty())
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
		                //home.memberSearchTextBox(data.get("MemberSearch"));
		                member.memberNumClick();
		                locations.clickOnLocationTab();
		                enterBreakDownLocation(data);
		                vehicle.selectVehicleModel();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                service.clickOnServiceTab();
		                String superOverride = service.getSuperOverdidePTAValue();
		                assertTrue(superOverride.equalsIgnoreCase(data.get("SuperOveride")), "Super Override value is 90");
		                String manualoverride = service.getManualOverdidePTAValue();
		                assertTrue(manualoverride.equalsIgnoreCase(data.get("ManualOverride")), "Manual Override value is 60");
		                home.verifyPTAValue();
		                service.setManualOverrideOnSpottedFacility(data.get("ManualOverrideValue"));
		                String combineKeys = Keys.chord(Keys.TAB);
		                sendKeys(combineKeys, "Tab");
		                home.verifyPTAValue();
		                home.saveButton();
		                String time=getFutureTime();
		                boolean pta= service.verifyPTAAfterCallSave(time);
		                assertTrue(pta,"PTA Updated to 45 min");
		                service.closeCall();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1724",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

    public void enterBreakDownLocation(Hashtable<String, String> data) throws Throwable {
        CRLocationsLib locations = new CRLocationsLib();
        locations.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
       /* type(CRLocationsPage.txtBrkDowLocSrch, data.get("BreakdownAddress"), "Breakdown location");
        click(CRLocationsPage.btnBrkDowLocSrch, "Breakdown Location search button");
        click(CRLocationsPage.linkBrkDowSrchAddress, "BreakDown location");
        locations.enterBKDownLocCode(data.get("LocationCode"));*/
    }
    public String getFutureTime(){
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = new Date(System.currentTimeMillis()+45*60*1000);
        String futureTime=sdf.format(date);
        return futureTime;

    }

}
