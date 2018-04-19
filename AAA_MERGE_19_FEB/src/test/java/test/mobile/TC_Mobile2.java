package test.mobile;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aaa.mobile.rsoredesign.lib.StandaloneLoginLib;
import com.aaa.mobile.rsoredesign.lib.StandaloneMenuBarLib;
import com.aaa.mobile.rsoredesign.lib.RSORedesignSetBreakdownLocationLib;
import com.aaa.accelerators.ReportControl;
import com.aaa.mobile.lib.ClubSelectionLib;
import com.aaa.mobile.lib.HomeLib;
import com.aaa.mobile.lib.LaunchLib;
import com.aaa.mobile.lib.MembershipInfoLib;
import com.aaa.mobile.lib.NotificationsLib;
import com.aaa.mobile.page.HomePage;
import com.aaa.mobile.page.LaunchPage;
import com.aaa.mobile.page.NotificationsPage;
import com.aaa.mobile.rsoredesign.lib.RSORedesignBreakdownSubPageLib;
import com.aaa.mobile.rsoredesign.lib.RSORedesignSelectVehicleLib;
import com.aaa.mobile.rsoredesign.lib.RSORedesignSelectVehicleSubPageLib;
import com.aaa.mobile.rsoredesign.lib.RSORedesignTriageLib;
import com.aaa.mobile.rsoredesign.lib.RSORedesignContactInfoLib;
import com.aaa.utilities.TestUtil;



/**
 * Class: TC_StandaloneSubmitLightServiceCall
 * Test Cases included
 * Login: RQM 1708 TC - AAA Mobile - RSO Standalone Login
 * 
 * @author neilmccormick
 * Description: This test case is 
 * 
 */
public class TC_Mobile2 extends LaunchLib {
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
	@DataProvider
	public Object[][] getTestDataFor_clubHostedLogin() {
		return TestUtil.getData("clubHostedLogin", TestData, "RSOMobile");
	}

	@Test(dataProvider = "getTestDataFor_clubHostedLogin")
	public void clubHostedLoginnew(Hashtable<String, String> data) throws Throwable {
		try {
			reporter.SuccessReport("Mobile 2 Script is Started", "Mobile Scrpt is Started in Android device");
			if (data.get("RunMode").equals("Y")) {
				this.reporter.initTestCaseDescription("1706: TC AAA Mobile- Club Hosted Login");


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
				//notifications.verifyPushNotificationsLabel();
				//notifications.yesPushNotificationsLabel();
				//home.verifyRoadSideAssistanceExistence();
				ReportControl.fnDisableJoin();
				ReportControl.fnSwitchToWeb();

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}