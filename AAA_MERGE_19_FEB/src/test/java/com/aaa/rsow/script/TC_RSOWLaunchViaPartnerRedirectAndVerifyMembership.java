package com.aaa.rsow.script;

import java.util.Hashtable;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.rsow.lib.RSOMembershipLib;
import com.aaa.rsow.lib.RSOWebHomeLib;
import com.aaa.rsow.lib.RSOWebLoginLib;

public class TC_RSOWLaunchViaPartnerRedirectAndVerifyMembership extends ActionEngine{
	
	/**
	 *methodName :: launchViaPartnerRedirectAndVerifyMembership
	 *date :: 18-Dec-2017
	 * author :: E002490
	 *@param
	 * throws Throwable
	 */
	
	
	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	 @Test()

	    public void launchViaPartnerRedirectAndVerifyMembership(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "launchViaPartnerRedirectAndVerifyMembership", TestData, "RSOWeb_Login");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("launchViaPartnerRedirectAndVerifyMembership", TestData, "RSOWeb_Login",intCounter);
		
		                this.reporter.initTestCaseDescription("TC -Launch via Partner Redirect & Verify Membership"+ " From Iteration " + StartRow + " to " + EndRow ); 
		            	reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			    		
		                //Object Creation
		                RSOWebHomeLib hml =new RSOWebHomeLib();
		                RSOWebLoginLib wl =new RSOWebLoginLib();
		                RSOMembershipLib ml =new RSOMembershipLib();
		                
		                hml.clearBrowserCookies();
		    			
		                navigateToApplication("RSOWEBMestag");
		                
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
		                
		                //Sign with username and password
		                wl.enterUserNamePasswordAndSignIn(data.get("username"),data.get("password"));
		                
		                hml.clickFeedbackPopUpCross();
		                
		                //verify membership card an sign out
		                ml.verifyMembershipCard();
		                hml.clickSignOut();
		                
		                System.out.println("Test Completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("RSO","7777",ReportStatus.strMethodName,intCounter,browser);
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
