package com.aaa.mobile.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.mobile.lib.*;
import com.aaa.mobile.page.*;
import com.aaa.utilities.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.Hashtable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aaa.mobile.lib.BreakDownLocationLib;
import com.aaa.mobile.lib.ClubSelectionLib;
import com.aaa.mobile.lib.HomeLib;
import com.aaa.mobile.lib.LaunchLib;
import com.aaa.mobile.lib.MembershipInfoLib;
import com.aaa.mobile.lib.NotificationsLib;
import com.aaa.mobile.lib.TellAboutVehicleLib;
import com.aaa.mobile.lib.VehicleInformationLib;
import com.aaa.mobile.page.LaunchPage;
import com.aaa.mobile.page.NotificationsPage;
import com.aaa.utilities.TestUtil;

import java.util.Hashtable;

/**
 * Created by E002734 on 12/20/2017.
 */
public class TC_SubmitLightRSORequests extends VehicleInformationLib {
	//Object Creation for LaunchLib
	LaunchLib launch = new LaunchLib();
	NotificationsLib notifications = new NotificationsLib();
	MembershipInfoLib membershipinfo =new MembershipInfoLib();
	ClubSelectionLib club=new ClubSelectionLib();
	NotificationsLib popup=new NotificationsLib();
	HomeLib home=new HomeLib();
	BreakDownLocationLib breakdownlocation=new BreakDownLocationLib();
	MembershipInfoLib memberInfo=new MembershipInfoLib();
	VehicleInformationLib vehicleinformation = new VehicleInformationLib();
	ProblemDescriptionLib primaryProblem=new ProblemDescriptionLib();
	AnxietyManagementScreenLib anxietyScreen=new AnxietyManagementScreenLib();
	SecondaryProblemDiscriptionLib secondaryProblem=new SecondaryProblemDiscriptionLib();
	ContactInformationLib contactInformation=new ContactInformationLib();

		@AfterMethod(alwaysRun = true)
		public void afterMethod() throws Throwable {
			//logOut();
			this.appiumDriver.resetApp();
			super.afterMethod();
		}
		public static final int WAITTIME = 50000;

		/**
		 * param testContext
		 * param data
		 * throws Throwable
		 * description: 1622 : TC - Submit Light RSO Requests
		 * author :Ravi
		 */
	
		@Parameters({"StartRow","EndRow","nextTestJoin"})
		@Test()
		public void submitLightRSORequest(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
			try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "submitLightRSORequest", TestData, "RSOMobile");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("submitLightRSORequest", TestData, "RSOMobile",intCounter);
			
							this.reporter.initTestCaseDescription("1622-TC-Submit Light RSO Requests"+ " From Iteration " + StartRow + " to " + EndRow );
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
							club.clickOnSelectedClub();
							if(waitForVisibilityOfElement(NotificationsPage.allowButton,"Allow Permissions"))
							{
								click(NotificationsPage.allowButton,"Allow Permissions");
								Thread.sleep(1000);
							}
							if(isVisibleOnly(HomePage.loginButton, "fetch logininHomePage"))
							{
								home.clickLogin();
								club.clickOnSelectedClub();
							}
		
							memberInfo.clickAndEnterMembershipNumber(data.get("MemberNumber"));
							memberInfo.clickContinueButton();
							notifications.verifyPushNotificationsLabel();
							notifications.yesPushNotificationsLabel();
							home.clickRoadSideAssistance();
							notifications.clickUntillOkDisappears();
							breakdownlocation.enterAndSelectBreakDownLocation(data.get("BreakdownLocation"));
							vehicleinformation.clickExistingVehicle();
							primaryProblem.clickOnBattary();
							secondaryProblem.needJumpStart();
							contactInformation.getContactNumber();
							contactInformation.clickonSendRequest();
							anxietyScreen.estimatedTimeToArrive();
							anxietyScreen.verifyDidYouKnow();
							anxietyScreen.didYouKnowUpdatesLabel();
	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("RSO","1622",ReportStatus.strMethodName,intCounter,platformNameMobile);
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

