package com.aaa.mobile.lib;
import java.util.Hashtable;

import com.aaa.mobile.page.TellAboutVehiclePage;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.page.BreakDownLocationPage;

public class BreakDownLocationLib extends ActionEngineMobile {
	
	public ITestContext testcontext;
	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
	}
	
	/**
	 *methodName : enterBreakDownLocation
	 *description: enter the breakdown location
	 *param :String inputs
	 * throws Throwable
	 */
	public void enterBreakDownLocation(String BreakdownLocation) throws Throwable {
		waitForVisibilityOfElement(BreakDownLocationPage.enterBreakdownLocation, "Break Down Location");
		//address icon
		click(BreakDownLocationPage.enterBreakdownLocation, "Break down Location");
		type(BreakDownLocationPage.enterBreakdownLocation, BreakdownLocation, "Break down Location");
		//select addres slis
		click(BreakDownLocationPage.enterBreakdownLocation, "Break down Location");
	}
	
	/**
	 *methodName : clickSetBreakDownLocation
	 *description: click on Set BreakDown Location
	 *param :String inputs
	 * throws Throwable
	 */
	public void clickSetBreakDownLocation() throws Throwable {
		waitForVisibilityOfElement(BreakDownLocationPage.setBreakdownLocation, "Set BreakDown Location ");
		click(BreakDownLocationPage.setBreakdownLocation, "Set BreakDown Location ");
	}
	
	/**
	 *methodName : clickBreakDownLocation
	 *description: click on Break Down Location
	 *param :String inputs
	 * throws Throwable
	 */
	public void clickBreakDownLocation() throws Throwable {
		waitForVisibilityOfElement(BreakDownLocationPage.breakdownLocation, "Select BreakDown Location ");
		click(BreakDownLocationPage.breakdownLocation, "Select BreakDown Location ");
		
		/*Uncomment below 2 lines for TAB Execution
		//appiumDriver.tap(380, 400, 700, 720);
		TouchAction tapCoordinates = new TouchAction(appiumDriver);
		tapCoordinates.tap(400,700).perform();
		//new TouchAction(appiumDriver().tap(400,700).perform());
*/		
	}
	
	/**
	 *methodName : enterAndSelectBreakDownLocation
	 *description: enter and Select BreakDown Location
	 *param :String inputs
	 * throws Throwable
	 *//*
	public void enterAndSelectBreakDownLocation(String BreakdownLocation) throws Throwable {

		if(appiumDriver.findElement(BreakDownLocationPage.addressIcon).getAttribute("enabled").contains("true"))
		{
			click(BreakDownLocationPage.setBreakdownLocation,"set breakdown location");
		}
		else
		{
			click(BreakDownLocationPage.addressIcon,"Click on address icon");
			type(BreakDownLocationPage.enterBreakdownLocation, BreakdownLocation, "Break down Location");
			Thread.sleep(2000);
			//	click(BreakDownLocationPage.selectAddressFromList,"click on selected address");
			TouchAction tapCoordinates = new TouchAction(appiumDriver);
			tapCoordinates.tap(400,700).perform();
			//tab coordinates
			//tapCoordinates.tap(332,181).perform();
			//tapCoordinates.tap(166,325).perform();
			Thread.sleep(2000);
			click(BreakDownLocationPage.setBreakdownLocation,"set breakdown location");


		}
	}*/

	/**
	 *methodName : enterAndSelectBreakDownLocation
	 *description: enter and Select BreakDown Location
	 *param :String inputs
	 * throws Throwable
	 */
	public void enterAndSelectBreakDownLocation(String BreakdownLocation) throws Throwable {

		//click(BreakDownLocationPage.addressIcon,"Click on address icon");
		type(BreakDownLocationPage.enterBreakdownLocation, BreakdownLocation, "Break down Location");
		Thread.sleep(4000);
		//click(BreakDownLocationPage.addressArrow,"click on address arrow");
		click(BreakDownLocationPage.selectAddressFromList,"click on selected address");
		Thread.sleep(3000);
		click(BreakDownLocationPage.setBreakdownLocation,"set breakdown location");

		/*Uncomment below 2 lines for TAB Execution
		TouchAction tapCoordinates = new TouchAction(appiumDriver);
		tapCoordinates.tap(166,325).perform();*/
	}
	/**
	 *methodName : enterAndSelectBreakDownLocation
	 *description: enter and Select BreakDown Location
	 *param :String inputs
	 * throws Throwable
	 */
	public void enterAndSelectBreakDownLocationFromCancelRequest() throws Throwable {
		/*click(BreakDownLocationPage.allowDeviceLocation, "allow Device Location");
		Thread.sleep(3000);*/
		//type(BreakDownLocationPage.addressBarField, BreakdownLocation, "enter break down location");
		//Thread.sleep(3000);

	//	Uncomment below 2 lines for TAB Execution
		TouchAction tapCoordinates = new TouchAction(appiumDriver);
		tapCoordinates.tap(530,214).perform();
		{
			reporter.SuccessReport("tap on", "successfully tapped on cancel using coordinates");
		}

		Thread.sleep(5000);
		/*Uncomment below 2 lines for TAB Execution
		TouchAction tapCoordinates = new TouchAction(appiumDriver);
		tapCoordinates.tap(166,325).perform();*/

		//click(BreakDownLocationPage.selectAddressFromList,"click on selected address");
	}

	/**
	 *methodName : clickSetBreakdownLocation
	 *description: click on SetBreakdownLocation
	 *param :
	 * throws Throwable
	 */
	public void clickSetBreakdownLocation() throws Throwable {

		waitForVisibilityOfElement(BreakDownLocationPage.setBreakdownLocation, "click on setBreakdownLocation ");
		click(BreakDownLocationPage.setBreakdownLocation,"set breakdown location");


	}



	@Override
	public boolean isVisibleOnly(By locator, String locatorName) throws Throwable {
		return super.isVisibleOnly(locator, locatorName);
	}
}
