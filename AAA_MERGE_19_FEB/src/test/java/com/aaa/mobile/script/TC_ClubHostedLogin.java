package com.aaa.mobile.script;


import java.util.Hashtable;

import com.aaa.mobile.lib.NotificationsLib;
import com.aaa.mobile.page.HomePage;
import com.aaa.mobile.page.LaunchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aaa.utilities.TestUtil;
import com.aaa.mobile.lib.LaunchLib;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.mobile.lib.ClubSelectionLib;
import com.aaa.mobile.page.NotificationsPage;
import com.aaa.mobile.lib.HomeLib;
import com.aaa.mobile.lib.MembershipInfoLib;


/**
 * Created by E002734 on 12/7/2017.
 */
public class TC_ClubHostedLogin extends LaunchLib  {
	//Object Creation for LaunchLib
	LaunchLib launch = new LaunchLib();
	NotificationsLib notifications = new NotificationsLib();
	MembershipInfoLib membershipinfo =new MembershipInfoLib();
	MembershipInfoLib memberInfo=new MembershipInfoLib();
	ClubSelectionLib club=new ClubSelectionLib();
	NotificationsLib popup=new NotificationsLib();
	HomeLib home=new HomeLib();

	public static final int WAITTIME = 50000;
	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws Throwable {
		//logOut();
		this.appiumDriver.resetApp();
		super.afterMethod();
	}

	/**
	 * param testContext
	 * param data
	 * throws Throwable
	 * description: 1706 : AAA Mobile - Club Hosted Login
	 * author:Ravi
	 */

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void clubHostedLogin(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "clubHostedLogin", TestData, "RSOMobile");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("clubHostedLogin", TestData, "RSOMobile",intCounter);
					
							this.reporter.initTestCaseDescription("1706: TC AAA Mobile- Club Hosted Login"+ " From Iteration " + StartRow + " to " + EndRow );
							reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
				    		
			
							if (!isVisibleOnly(LaunchPage.continueButton, "launch page continue btn")) {
								click(NotificationsPage.allowButton,"Allow Permissions");
							}
							
			
							if(isVisibleOnly(HomePage.loginButton, "fetch logininHomePage"))
							{
								home.clickLogin();
							}
							launch.enterZIPCodeandselectContinue(data.get("ZIPCode"));
							club.verifySelectedClubName();
							//select club
							club.clickOnSelectedClub();
							if(waitForVisibilityOfElement(NotificationsPage.allowButton,"Allow Permissions"))
							{
								click(NotificationsPage.allowButton,"Allow Permissions");
								Thread.sleep(1000);
							}
							if(isVisibleOnly(HomePage.loginButton, "fetch logininHomePage"))
							{
								home.clickLogin();
								//select club
								club.clickOnSelectedClub();
							}
			
							memberInfo.clickAndEnterMembershipNumber(data.get("MemberNumber"));
							memberInfo.clickContinueButton();
							notifications.verifyPushNotificationsLabel();
							notifications.yesPushNotificationsLabel();
							home.verifyRoadSideAssistanceExistence();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("NA","1706",ReportStatus.strMethodName,intCounter,platformNameMobile);
    			
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