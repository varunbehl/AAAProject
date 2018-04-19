package com.aaa.mobile.lib;
import org.testng.ITestContext;
import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.page.TellAboutVehiclePage;

public class TellAboutVehicleLib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
	}
	
	/**
	 *methodName : verifySaveButtonDisable
	 *description: check whether save button is disable
	 *@param
	 * @throws Throwable
	 */
	public void verifySaveButtonDisable() throws Throwable
	{	
	appiumDriver.findElement(TellAboutVehiclePage.saveButtton).getAttribute("enabled").contains("false");
	{
		reporter.SuccessReport("Verify enter discription", "Verified Enter discription is disabled");
	}
		Thread.sleep(5000);
		click(TellAboutVehiclePage.tellVehicleYear,"vehicle year");
	}


	/**
	 *methodName : clickVehicleYearNumber
	 *description: click on vehicle year number
	 *
	 *@param
	 * @throws Throwable
	 */
	public void clickVehicleYearNumber() throws Throwable
	{
		waitForVisibilityOfElement(TellAboutVehiclePage.vehicleYearNumber, "click on year number");
		getText(TellAboutVehiclePage.vehicleYearNumber, "click on year number");
		click(TellAboutVehiclePage.vehicleYearNumber, "click on year number");
		Thread.sleep(2000);
	}

	/**
	 *methodName : clickVehicleMakeName
	 *description: click on vehicle make name
	 *
	 *@param
	 * @throws Throwable
	 */
	public void clickVehicleMakeName() throws Throwable
	{
		waitForVisibilityOfElement(TellAboutVehiclePage.vehicleMakeName, "click on make name");
		getText(TellAboutVehiclePage.vehicleMakeName, "click on make name");
		click(TellAboutVehiclePage.vehicleMakeName, "click on make name");
		Thread.sleep(2000);
	}

	/**
	 *methodName : clickVehicleModeleName
	 *description: click on vehicle model name
	 *
	 *@param
	 * @throws Throwable
	 */
	public void clickVehicleModeleName() throws Throwable
	{
		waitForVisibilityOfElement(TellAboutVehiclePage.vehicleModelName, "click on model name");
		getText(TellAboutVehiclePage.vehicleModelName, "click on model name");
		click(TellAboutVehiclePage.vehicleModelName, "click on model name");
		Thread.sleep(2000);
	}
	/**
	 *methodName : clickVehicleColor
	 *description: click on vehicle color
	 *
	 *@param
	 * @throws Throwable
	 */
	public void clickVehicleColor() throws Throwable
	{
		waitForVisibilityOfElement(TellAboutVehiclePage.vehicleColor, "click on color");
		getText(TellAboutVehiclePage.vehicleColor, "click on color");
		click(TellAboutVehiclePage.vehicleColor, "click on color");
		Thread.sleep(2000);
	}


	/**
	 *methodName : modifyVehicleYearNumber
	 *description: modify the vehicle year number
	 *
	 *@param
	 * @throws Throwable
	 */
	public void modifyVehicleYearNumber() throws Throwable
	{
		click(TellAboutVehiclePage.tellVehicleYear,"vehicle year");
		waitForVisibilityOfElement(TellAboutVehiclePage.vehicleYearNumber, "click on year number");
		getText(TellAboutVehiclePage.vehicleYearNumber, "click on year number");
		click(TellAboutVehiclePage.vehicleYearNumber, "click on year number");
		Thread.sleep(2000);
	}

	/**
	 *methodName : modifyVehicleMakeName
	 *description: modify the vehicle make name
	 *
	 *@param
	 * @throws Throwable
	 */
	public void modifyVehicleMakeName() throws Throwable
	{
		waitForVisibilityOfElement(TellAboutVehiclePage.vehicleMakeName, "click on make name");
		getText(TellAboutVehiclePage.vehicleMakeName, "click on make name");
		click(TellAboutVehiclePage.vehicleMakeName, "click on make name");
		Thread.sleep(2000);
	}

	/**
	 *methodName : modifyVehicleModelName
	 *description: modify the vehicle model name
	 *
	 *@param
	 * @throws Throwable
	 */
	public void modifyVehicleModelName() throws Throwable
	{
		waitForVisibilityOfElement(TellAboutVehiclePage.vehicleModelName, "click on model name");
		getText(TellAboutVehiclePage.vehicleModelName, "click on model name");
		click(TellAboutVehiclePage.vehicleModelName, "click on model name");
		Thread.sleep(2000);
	}
	/**
	 *methodName : modifyVehicleColor
	 *description: modify the vehicle color
	 *
	 *@param
	 * @throws Throwable
	 */
	public void modifyVehicleColor() throws Throwable
	{
		waitForVisibilityOfElement(TellAboutVehiclePage.vehicleColor, "click on color");
		getText(TellAboutVehiclePage.vehicleColor, "click on color");
		click(TellAboutVehiclePage.vehicleColor, "click on color");
		Thread.sleep(2000);
	}

	/**
	 * methodName : clickSaveVehicle
	 * description: click on save vehicle
	 *
	 *@param
	 * @throws Throwable
	 */
	public void clickSaveVehicle() throws Throwable
	{
		waitForVisibilityOfElement(TellAboutVehiclePage.saveButtton, "click on save");
		click(TellAboutVehiclePage.saveButtton, "click on save");
	}


}

