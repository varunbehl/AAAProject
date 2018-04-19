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
 * Created by E002734 on 1/2/2018.
 */
public class TC_SubmitTowRSORequest extends SecondaryTowDestinationLib  {
	//Object Creation for LaunchLib
		BreakDownLocationLib breakdownlocation = new BreakDownLocationLib();
		LaunchLib launch = new LaunchLib();
		ClubSelectionLib club=new ClubSelectionLib();
		MembershipInfoLib memberInfo=new MembershipInfoLib();
		NotificationsLib notifications=new NotificationsLib();
		VehicleInformationLib vehicleinformation = new VehicleInformationLib();
		AnxietyManagementScreenLib anxietyScreen=new AnxietyManagementScreenLib();
		HomeLib home=new HomeLib();
		TellAboutVehicleLib tellaboutvehicle=new TellAboutVehicleLib();
		SecondaryTowDestinationLib secondaryTow=new SecondaryTowDestinationLib();
		PrimaryTowDestinationLib primaryTow=new PrimaryTowDestinationLib();
		ContactInformationLib contactInformation=new ContactInformationLib();
		public static final int WAITTIME = 50000;
		



	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws Throwable {
		this.appiumDriver.resetApp();
		super.afterMethod();
	}

	/**
	 * param testContext
	 * param data
	 * throws Throwable
	 * description: 1623 TC - AAA Mobile - Submit Tow RSO Requests
	 * author :Ravi
	 */
	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void submitTowRSORequest(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "submitTowRSORequest", TestData, "RSOMobile");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("submitTowRSORequest", TestData, "RSOMobile",intCounter);
		
						this.reporter.initTestCaseDescription("1623 TC - Submit Tow RSO Requests"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			    		
						if (!isVisibleOnly(LaunchPage.continueButton, "launch page continue btn")) {
							click(NotificationsPage.allowButton,"Allow Permissions");
						}
						if(isVisibleOnly(HomePage.loginButton, "fetch logininHomePage"))
						{
							home.clickLogin();
						}
						launch.enterZIPCodeandselectContinue(data.get("ZIPCode"));
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
						home.clickRoadSideAssistance();
						notifications.clickUntillOkDisappears();
						breakdownlocation.enterAndSelectBreakDownLocation(data.get("BreakdownLocation"));
						
						vehicleinformation.clickAddNewVehicle();
						tellaboutvehicle.verifySaveButtonDisable();
						tellaboutvehicle.clickVehicleYearNumber();
						tellaboutvehicle.clickVehicleMakeName();
						tellaboutvehicle.clickVehicleModeleName();
						tellaboutvehicle.clickVehicleColor();
						tellaboutvehicle.clickSaveVehicle();
		
						vehicleinformation.clickExistingVehicle();
						primaryTow.clickMechanicalProblemLabel();
						primaryTow.clickPossibleEngineProblemLabel();
						primaryTow.clickHomeLabel();
		
						//secondaryTow.clickSearchIcon();
						secondaryTow.clickTowLocationField();
						secondaryTow.clickCloseIcon();
						secondaryTow.enterTowLocationAddress(data.get("TowDestination"));
						notifications.clickunableAuthorizeServiceCancel();
						secondaryTow.clickNextBtn();
		
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
    			ReportStatus.fnUpdateResultStatus("RSO","1623",ReportStatus.strMethodName,intCounter,platformNameMobile);
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
