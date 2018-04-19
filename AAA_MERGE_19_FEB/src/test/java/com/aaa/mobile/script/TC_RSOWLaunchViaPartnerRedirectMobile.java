package com.aaa.mobile.script;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.accelerators.AppiumActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.mobile.lib.RSOMembershipLib;
import com.aaa.mobile.lib.RSOWebHomeLib;
import com.aaa.mobile.lib.RSOWebLoginLib;

public class TC_RSOWLaunchViaPartnerRedirectMobile extends ActionEngine{
	

	/**
	 *methodName :: launchViaPartnerRedirect
	 *date :: 18-Dec-2017
	 * author :: E002490
	 *@param
	 * throws Throwable
	 */
	
	

	@Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void launchViaPartnerRedirect(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "launchViaPartnerRedirect", TestData, "RSOWeb");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("launchViaPartnerRedirect", TestData, "RSOWeb",intCounter);
		
		                this.reporter.initTestCaseDescription("1668 : TC -Launch via Partner Redirect"+ " From Iteration " + StartRow + " to " + EndRow );
		            	reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			    		
		                //driver.manage().deleteAllCookies();
		    			
		    			
		                //Launch  http://<domain>.aaa.com/stop.
		                navigateToApplication("RSOWEBMestag");
		                
		                //Object Creation
		                RSOWebHomeLib hml =new RSOWebHomeLib();
		                RSOWebLoginLib wl =new RSOWebLoginLib();
		                RSOMembershipLib ml =new RSOMembershipLib();
		                
		                //Enter club code and go
		                hml.enterClubCodeAndClickGo(data.get("clubCode"));
		                
		                //Club login page
		                hml.clickGiftMembershipPopUpCross();
		                
		                //Launch the browser to https://<domain>.aaa.com/scripts/WebObjects.dll/AAAOnline.woa?association=<association>&club=<clubNumber>&page=PartnerRedirect&PID=1147
		                navigateToApplication("RSOWEB");
		                
		                //Club login page
		                hml.clickFeedbackPopUpCross();
		                 wl.clickSignIn();
		                
		                //Verify Club login page
		                wl.verifyClubLogin();
		                System.out.println("Test Completed");
		    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("RSO","1668",ReportStatus.strMethodName,intCounter,platformNameMobile);
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
