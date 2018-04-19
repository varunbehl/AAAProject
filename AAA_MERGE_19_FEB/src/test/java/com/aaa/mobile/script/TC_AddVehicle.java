package com.aaa.mobile.script;

import java.util.Hashtable;

import com.aaa.mobile.page.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
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

public class TC_AddVehicle extends VehicleInformationLib{
	//Object Creation for LaunchLib
	LaunchLib launch = new LaunchLib();
	NotificationsLib notifications = new NotificationsLib();
	MembershipInfoLib membershipinfo =new MembershipInfoLib();
	ClubSelectionLib club=new ClubSelectionLib();
	NotificationsLib popup=new NotificationsLib();
	BreakDownLocationLib breakdownlocation = new BreakDownLocationLib();
	VehicleInformationLib vehicleinformation = new VehicleInformationLib();
	TellAboutVehicleLib tellaboutvehicle=new TellAboutVehicleLib();
	MembershipInfoLib memberInfo=new MembershipInfoLib();
	HomeLib home=new HomeLib();
	
	
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
	 * description: 1637 : TC - AAA Mobile - Add Vehicle
	 * author : Ravi
	 */
	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void addAndModifyVehicle(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "addAndModifyVehicle", TestData, "RSOMobile");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("addAndModifyVehicle", TestData, "RSOMobile",intCounter);
		
    					this.reporter.initTestCaseDescription("1637 TC - AAA Mobile - Add Vehicle"+ " From Iteration " + StartRow + " to " + EndRow );
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
						if(isVisibleOnly(NotificationsPage.allowButton,"Allow Permissions"))
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
						home.clickRoadSideAssistance();
						waitForVisibilityOfElement(NotificationsPage.allowButton,"Allow Permissions");
						notifications.clickUntillOkDisappears();
						breakdownlocation.enterAndSelectBreakDownLocation(data.get("BreakdownLocation"));
						vehicleinformation.clickAddNewVehicle();
						tellaboutvehicle.verifySaveButtonDisable();
						tellaboutvehicle.clickVehicleYearNumber();
						tellaboutvehicle.clickVehicleMakeName();
						tellaboutvehicle.clickVehicleModeleName();
						tellaboutvehicle.clickVehicleColor();
						tellaboutvehicle.modifyVehicleYearNumber();
						tellaboutvehicle.modifyVehicleMakeName();
						tellaboutvehicle.modifyVehicleModelName();
						tellaboutvehicle.modifyVehicleColor();
						tellaboutvehicle.clickSaveVehicle();
				
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("NA","1637",ReportStatus.strMethodName,intCounter,platformNameMobile);
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
