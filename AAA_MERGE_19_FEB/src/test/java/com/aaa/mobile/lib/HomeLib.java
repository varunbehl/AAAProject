package com.aaa.mobile.lib;
import java.util.Hashtable;

import com.thoughtworks.selenium.webdriven.commands.GetText;
import org.testng.ITestContext;
import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.page.HomePage;

public class HomeLib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
	}

	/**
	 *methodName : verifyRoadSideAssistanceExistance
	 *description: verify RoadSide Assistance Existence
	 *param
	 * throws Throwable
	 */	
	public void verifyRoadSideAssistanceExistence() throws Throwable {
		/*boolean verifyRoadSideAssistance = false;
		waitForVisibilityOfElement(HomePage.roadSideAssisstanceLabel, "Select road side Assistance ");
		verifyRoadSideAssistance = isElementPresent(HomePage.roadSideAssisstanceLabel, "Select road side Assistance", true);
		return verifyRoadSideAssistance;*/
        Thread.sleep(3000);
		//waitForVisibilityOfElement(HomePage.roadSideAssisstanceLabel, "Select road side Assistance ");
		if(isVisibleOnly(HomePage.activeRequestLabel, "Select road side Assistance "))
		{
			getText(HomePage.roadSideAssisstanceLabel, "Select road side Assistance ");
		}
		else
		{
			getText(HomePage.roadSideAssisstanceWithoutActiveRequest, "Select road side Assistance ");
		}
	}
	
	/**
	 *methodName : clickRoadSideAssistance
	 *description: click RoadSide Assistance
	 *param
	 * throws Throwable
	 */	
	public void clickRoadSideAssistance() throws Throwable {
		Thread.sleep(3000);
		if(isVisibleOnly(HomePage.activeRequestLabel, "Active request label "))
		{
			click(HomePage.roadSideAssisstanceLabel, "Select road side Assistance ");
		}
		else
		{
			click(HomePage.roadSideAssisstanceWithoutActiveRequest, "Select road side Assistance ");
		}
	}

	/**
	 *methodName : clickLogin
	 *description: click Login
	 *param
	 * throws Throwable
	 */	
	public void clickLogin() throws Throwable {
		//waitForVisibilityOfElement(HomePage.loginButton, "fetch logininHomePage");
		click(HomePage.loginButton, "click on logininHomePage");
	}

	/**
	 *methodName : clickhamburgerButton
	 *description: click hamburger Button
	 *param
	 * throws Throwable
	 */	
	public void clickhamburgerButton() throws Throwable {
		waitForVisibilityOfElement(HomePage.hamburgerButton, "hamburger Button");
		click(HomePage.hamburgerButton, "Page will flyout successfully");
		Thread.sleep(3000);
	}

	/**
	 *methodName : verifyLoginErrorPopup
	 *description: check the login error popup
	 *param
	 * throws Throwable
	 */
	public void verifyLoginErrorPopup() throws Throwable {
		waitForVisibilityOfElement(HomePage.loginButton, "fetch logininErrorPopup");
		getText(HomePage.loginButton, "click on logininErrorPopup");
	}

	/**
	 *methodName : clickLoginOnErrorPopup
	 *description: click Login On Error Popup
	 *param
	 * throws Throwable
	 */
	public void clickLoginOnErrorPopup() throws Throwable {
		waitForVisibilityOfElement(HomePage.loginButton, "fetch logininErrorPopup");
		click(HomePage.loginButton, "click on logininErrorPopup");
	}

	/**
	 *methodName : firstAndLastName
	 *description: check the login error popup
	 *param
	 * throws Throwable
	 */
	public void firstAndLastName() throws Throwable {
		String FullNAme=getText(HomePage.firstAndLastName,"first and last name");
		String[] NamesArray=FullNAme.split(" ");
		String firstName=NamesArray[0];
		reporter.SuccessReport("Verify  On"+firstName, "Successfully GetTExt On"+ firstName);
		String SecondtName=NamesArray[1];
		reporter.SuccessReport("Verify  On"+SecondtName, "Successfully GetTExt On"+ SecondtName);
	}



	/**
	 *methodName : clickRedRoadsideAssitance
	 *description: click RedRoadside Assitance
	 *param
	 * throws Throwable
	 */
	public void clickRedRoadsideAssitance() throws Throwable {
		waitForVisibilityOfElement(HomePage.redRoadsideAssitance, "fetch logininHomePage");
		click(HomePage.redRoadsideAssitance, "click on logininHomePage");

	}


}
