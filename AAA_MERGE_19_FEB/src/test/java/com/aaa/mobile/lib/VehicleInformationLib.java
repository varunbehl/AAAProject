package com.aaa.mobile.lib;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.page.VehicleInformationPage;

import static org.apache.xmlbeans.impl.common.GlobalLock.release;

public class VehicleInformationLib extends ActionEngineMobile {
	public ITestContext testcontext;
	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
	}

	/**
	 *methodName : clickExistingVehicle
	 *description: click on existing vehicle
	 *param
	 * throws Throwable
	 */	
	public void clickExistingVehicle() throws Throwable {
		Thread.sleep(2000);
		waitForVisibilityOfElement(VehicleInformationPage.existingVehicle, "select Existing Vehicle ");
		click(VehicleInformationPage.existingVehicle, "select Existing Vehicle");
	}

	/**
	 *methodName : clickAddNewVehicle
	 *description: click on add new vehicle
	 *
	 *@param
	 * @throws Throwable
	 */
	public void clickAddNewVehicle() throws Throwable
	{

		waitForVisibilityOfElement(VehicleInformationPage.selectVehicleTitle, "Select vehicle title ");
		isElementPresent(VehicleInformationPage.selectVehicleTitle, "Select Club", true);
		click(VehicleInformationPage.addNewVehicle,"Add New Vehicle in select vehicle");

	}


	/**
	 *methodName : deleteVehicle
	 *description: delete a vehicle
	 *
	 *param
	 * throws Throwable
	 */
	public void deleteVehicle() throws Throwable
	{
		waitForVisibilityOfElement(VehicleInformationPage.existingVehicle, "Select vehicle title ");
		getText(VehicleInformationPage.existingVehicle, "Select Club");
		//*TouchAction action = new TouchAction(AndroidDriver);
		//WebElement source = AndroidDriver.findElement(VehicleInformationPage.selectVehicleTitle);

		TouchAction action = new TouchAction(appiumDriver);
		WebElement source = appiumDriver.findElement(VehicleInformationPage.existingVehicle);
		action.longPress(source).release().perform();
	}

	/**
	 *methodName : deleteVehicle
	 *description: delete a vehicle
	 *
	 *param
	 * throws Throwable
	 */
	public void swipeLeftDeleteVehicle(WebElement element) throws Throwable
	{
		WebElement elem = appiumDriver.findElement(By.xpath("af"));
		int xaxis = element.getLocation().getX();
		int yaxis = element.getLocation().getY();

		appiumDriver.swipe(xaxis+300,yaxis,xaxis,yaxis,3000);
	}
	/**
	 *methodName : clickYesDeleteConformationLabel
	 *description: click yes Delete Conformation Label
	 *
	 *@param
	 * @throws Throwable
	 */
	public void clickYesDeleteConformationLabel() throws Throwable
	{
		waitForVisibilityOfElement(VehicleInformationPage.yesDeleteConformationLabel, "yes Delete ConformationLabel");
		click(VehicleInformationPage.yesDeleteConformationLabel,"yes Delete ConformationLabel");

	}

	/**
	 *methodName : clickCancelDeleteConformationLabel
	 *description: click Cancel Delete Conformation Label
	 *
	 *@param
	 * @throws Throwable
	 */
	public void clickCancelDeleteConformationLabel() throws Throwable
	{
		waitForVisibilityOfElement(VehicleInformationPage.cancelDeleteConformationLabel, "cancel Delete ConformationLabel");
		click(VehicleInformationPage.cancelDeleteConformationLabel,"cancel Delete ConformationLabel");

	}



}
