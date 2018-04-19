/**
 * Created 1/2/2018 - Neil McCormick
 * These are all the actions and methods that perform Select Vehicle actions on the 
 * standalone AAARSO.ipa application for RSO testing.
 * 
 * The RSO Standalone IPA is located here: https://itt101.aaa.com/AAARSO/AAARSO.ipa
 * The primary download page is located here: https://itt101.aaa.com/AAARSO
 */
package com.aaa.mobile.rsoredesign.lib;

import java.util.Hashtable;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.rsoredesign.page.RSORedesignSelectVehiclePage;

public class RSORedesignSelectVehicleLib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
	}
	
	/**
	 * Method Name: setPlatform
	 * Description: To set the running platform.  Not intrinsically set unless the test case inherits from this class.
	 * @param platform
	 */
	public void setPlatform(String platform){
		this.platform = platform;
	}
	
	/**
	 * Method Name:pageLoaded
	 * Description: Checks to see that the page title is displaying and assumes the page has loaded correctly.
	 * @return
	 * @throws Throwable
	 */
	public boolean pageLoaded() throws Throwable {
		RSORedesignSelectVehiclePage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignSelectVehiclePage.pageTitle, "PageTitle");
	}
	
	/**
	 * Method Name: clickAddNewVehicleButton
	 * Description: Looks for and clicks the Add New Vehcile Button.  Fails the test if it's not present/visible.
	 * @throws Throwable
	 */
	public void clickAddNewVehicleButton() throws Throwable {
		RSORedesignSelectVehiclePage.initialize(platform);
		if(this.waitForVisibilityOfElement(RSORedesignSelectVehiclePage.addNewVehicleButton, "Add New Vehicle Button")){
			this.click(RSORedesignSelectVehiclePage.addNewVehicleButton, "Add New Vehicle Button");
		}
		else{
			reporter.failureReport("Click Add New Vehicle Button", "The Add New Vehicle button was not present to be clicked.", appiumDriver);
		}
	}
	
	/**
	 * Method Name: clickEditVehicleButton
	 * Description: Looks for and clicks the Edit Vehcile Button.  Fails the test if it's not present/visible.
	 * @throws Throwable
	 */
	public void clickEditVehicleButton() throws Throwable {
		RSORedesignSelectVehiclePage.initialize(platform);
		if(this.waitForVisibilityOfElement(RSORedesignSelectVehiclePage.editVehicleButton, "Edit Vehicle Button")){
			this.click(RSORedesignSelectVehiclePage.editVehicleButton, "Edit Vehicle Button");
		}
		else{
			reporter.failureReport("Click Edit Vehicle Button", "The Edit Vehicle button was not present to be clicked.", appiumDriver);
		}
	}
	
	/**
	 * Method Name: clickDeleteVehicleButton
	 * Description: Looks for and clicks the Edit Vehcile Button.  Fails the test if it's not present/visible.
	 * @throws Throwable
	 */
	public void clickDeleteVehicleButton() throws Throwable {
		RSORedesignSelectVehiclePage.initialize(platform);
		if(this.waitForVisibilityOfElement(RSORedesignSelectVehiclePage.deleteVehicleButton, "Delete Vehicle Button")){
			this.click(RSORedesignSelectVehiclePage.deleteVehicleButton, "Delete Vehicle Button");
		}
		else{
			reporter.failureReport("Click Delete Vehicle Button", "The Delete Vehicle button was not present to be clicked.", appiumDriver);
		}
	}
	
	/**
	 * Method Name: getVehicleName
	 * Description: Gets the text of the vehicle year, make and model
	 * @return
	 * @throws Throwable
	 */
	public String getVehicleName() throws Throwable {
		RSORedesignSelectVehiclePage.initialize(platform);
		String vehicleName = "";
		
		if(waitForVisibilityOfElement(RSORedesignSelectVehiclePage.selectVehicleName, "Vehicle Name")){
			vehicleName = this.getText(RSORedesignSelectVehiclePage.selectVehicleName, "Vehicle Name");
		}
		
		return vehicleName;
	}
	
	/**
	 * Method Name: getVehicleColor
	 * Description: Returns the text of the vehicle color.
	 * @return
	 * @throws Throwable
	 */
	public String getVehicleColor() throws Throwable {
		RSORedesignSelectVehiclePage.initialize(platform);
		String vehicleColor = "";
		
		if(waitForVisibilityOfElement(RSORedesignSelectVehiclePage.selectVehicleColor, "Vehicle Color")){
			vehicleColor = this.getText(RSORedesignSelectVehiclePage.selectVehicleColor, "Vehicle Color");
		}
		
		return vehicleColor;
	}
	
	/**
	 * Method Name: isVehicleIconPresent
	 * Description: Checks for the existence of the vehicle icon.
	 * @return
	 * @throws Throwable
	 */
	public boolean isVehicleIconPresent() throws Throwable {
		RSORedesignSelectVehiclePage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignSelectVehiclePage.selectVehicleImageIcon, "Selected Vehicle Icon");
	}
	
	/**
	 * Mehtod Name: clickFirstVehcile
	 * Descritpion: Clicks the first vehicle in the list.
	 * @throws Throwable
	 */
	public void clickFirstVehicle() throws Throwable {
		RSORedesignSelectVehiclePage.initialize(platform);
		
		if(waitForVisibilityOfElement(RSORedesignSelectVehiclePage.selectVehicleName, "Vehicle Name")){
			click(RSORedesignSelectVehiclePage.selectVehicleName, "Vehicle Name");
		}
		else{
			reporter.failureReport("Click on first vehicle", "Failed to select the first vehicle in the list.", appiumDriver);
		}
	}
	
	/**
	 * Method Name:
	 * Description: This function follows the happy path of selecting the first vehicle in the list
	 * and continuing on to the next page.
	 * @param data
	 * @throws Throwable
	 */
	public void selectVehicleAndContinue(Hashtable<String,String> data) throws Throwable {
		if(this.pageLoaded()){
			this.clickFirstVehicle();
		}
	}
}
