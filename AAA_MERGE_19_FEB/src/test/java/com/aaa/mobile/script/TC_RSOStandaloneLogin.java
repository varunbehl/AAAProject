package com.aaa.mobile.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.mobile.lib.*;
import com.aaa.mobile.page.HomePage;
import com.aaa.mobile.page.LaunchPage;
import com.aaa.mobile.page.NotificationsPage;
import com.aaa.utilities.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E002734 on 12/18/2017.
 */
public class TC_RSOStandaloneLogin extends LaunchLib {
	//Object Creation for LaunchLib
	LaunchLib launch = new LaunchLib();
	NotificationsLib notifications = new NotificationsLib();
	MembershipInfoLib membershipinfo =new MembershipInfoLib();
	ClubSelectionLib club=new ClubSelectionLib();
	NotificationsLib popup=new NotificationsLib();
	BreakDownLocationLib breakdownlocation = new BreakDownLocationLib();
	VehicleInformationLib vehicleinformation = new VehicleInformationLib();
	TellAboutVehicleLib tellaboutvehicle=new TellAboutVehicleLib();
	HomeLib home=new HomeLib();
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws Throwable {
		this.appiumDriver.resetApp();
		Thread.sleep(10000);
		super.afterMethod();
	}
	public static final int WAITTIME = 50000;
	/**
	 * param testContext
	 * param data
	 * throws Throwable
	 * description:1708 TC-AAA Mobile-RSO Standalone Login
	 * author :Ravi
	 */
	
	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void rsoStandaloneLogin(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "rsoStandaloneLogin", TestData, "RSOMobile");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("rsoStandaloneLogin", TestData, "RSOMobile",intCounter);
		
						this.reporter.initTestCaseDescription("1708 TC-AAA Mobile-RSO Standalone Login"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			    		
						if (!isVisibleOnly(LaunchPage.continueButton, "launch page continue btn")) {
							click(NotificationsPage.allowButton,"Allow Permissions");
						}
						if(isVisibleOnly(HomePage.loginButton, "fetch logininHomePage"))
						{
							home.clickLogin();
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
		
						MembershipInfoLib memberInfo=new MembershipInfoLib();
						memberInfo.clickAndEnterMembershipNumber(data.get("MemberNumber"));
						memberInfo.clickContinueButton();
						notifications.verifyPushNotificationsLabel();
						notifications.yesPushNotificationsLabel();
						home.clickhamburgerButton();
						home.firstAndLastName();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("RSO","1708",ReportStatus.strMethodName,intCounter,platformNameMobile);
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
