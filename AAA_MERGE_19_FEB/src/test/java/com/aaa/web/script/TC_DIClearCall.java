package com.aaa.web.script;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.CRHomeLib;
import com.aaa.web.lib.CommonDb;
import com.aaa.web.lib.DIHomeLib;
import com.aaa.web.lib.DILoginLib;
import com.aaa.web.lib.DIMCDLib;
import com.aaa.web.lib.DISearchCallsLib;
import com.aaa.web.lib.LoginLib;
import com.aaa.web.lib.LoginRoleLib;

public class TC_DIClearCall extends LoginLib {

	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void ClearCalls(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "ClearCalls", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ClearCalls", TestData, "D3Dispatch",intCounter);
    	
						this.reporter.initTestCaseDescription("clear Call"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						//login to application
						
						
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                /*CommonDb condb = new CommonDb();
		                
		                int rownum = IntRandomNumberGenerator(50,100);
		                //condb.retrieveMemberData("d3cr","retrieveMemberRandomly.sql");
		                String Member = condb.selectRandomMemberFromDB("d3cr","retrieveMemberRandomly.sql","MBR_ID_16",rownum);
		               System.out.println("member : "+Member);*/
		                navigateToApplication("DI");
		                login(data.get("LoginName"),data.get("Password"));
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnContinueQueuesInDispatch();
						clearCallfunc();
						home.logout();
						
						System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
	
	public void clearCallfunc() throws Throwable {
		//click on search calls
		DIHomeLib diHome = new DIHomeLib();
		DISearchCallsLib disearchlib = new DISearchCallsLib();
		DIMCDLib dimcd = new DIMCDLib();
		for (i=0; i < 52;i++){
			System.out.println("***********^^^^^^ iteration count  "+i);
		diHome.clickOnSearchCallsLink();
		disearchlib.enterStartDate("01/04/2017");
		disearchlib.enterEndDate("01/22/2018");
		//enter spotted text in SP status
		disearchlib.selectCallStatus("SP");
		disearchlib.clickOnSearchButtonInSearchCallDispatch();
		disearchlib.selectOddRow();
		//disearchlib.selectSPStatusRowInSearchCallDispatch();
		dimcd.clickOnAssign();
		dimcd.selectFacility();
		dimcd.selectDispatch();
		dimcd.selectEnroute();
		dimcd.selectEnrouteTime();
		dimcd.selectOnLocation();
		dimcd.selectClearCall();
		dimcd.selectExitCode();
		dimcd.enterReason("03");
		dimcd.clickOnContinue();
		/*dimcd.selectCancelinClearCall();
		dimcd.selectServiceNotEnroute();*/
		dimcd.clickOnSubmit();
		}
		
		
		
	}
}
