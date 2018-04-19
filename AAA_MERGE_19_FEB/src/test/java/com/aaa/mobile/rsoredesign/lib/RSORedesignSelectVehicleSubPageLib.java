/**
 * Created 1/3/2018 - Neil McCormick
 * These are all the actions and methods that perform Selected Vehicle Sub Page actions on the 
 * standalone AAARSO.ipa application for RSO testing.
 * 
 * The RSO Standalone IPA is located here: https://itt101.aaa.com/AAARSO/AAARSO.ipa
 * The primary download page is located here: https://itt101.aaa.com/AAARSO
 */
package com.aaa.mobile.rsoredesign.lib;

import java.util.Hashtable;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.rsoredesign.page.RSORedesignSelectVehicleSubPage;

public class RSORedesignSelectVehicleSubPageLib extends ActionEngineMobile {
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
	 * Method titleExists
	 * Description: Checks to see that the page title is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean titleExists() throws Throwable {
		RSORedesignSelectVehicleSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignSelectVehicleSubPage.pageTitle, "Vehicle Sub Page Title");
	}
	
	/**
	 * Method vehicleNameExists
	 * Description: Checks to see that the page header is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean vehicleNameExists() throws Throwable {
		RSORedesignSelectVehicleSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignSelectVehicleSubPage.vehicleName, "Vehicle Name");
	}
	
	/**
	 * Method Name: vehicleNameValue
	 * Description: Gets the text value of the text box.
	 * @return
	 * @throws Throwable
	 */
	public String vehicleNameValue() throws Throwable {
		RSORedesignSelectVehicleSubPage.initialize(platform);
		return this.getText(RSORedesignSelectVehicleSubPage.vehicleName, "Vehicle Name");
	}
	
	/**
	 * Method vehicleColorExists
	 * Description: Checks to see that the page header is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean vehicleColorExists() throws Throwable {
		RSORedesignSelectVehicleSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignSelectVehicleSubPage.vehicleColor, "Vehicle Color");
	}
	
	/**
	 * Method Name: vehicleColorValue
	 * Description: Gets the text value of the text box.
	 * @return
	 * @throws Throwable
	 */
	public String vehicleColorValue() throws Throwable {
		RSORedesignSelectVehicleSubPage.initialize(platform);
		return this.getText(RSORedesignSelectVehicleSubPage.vehicleColor, "Vehicle Color");
	}
	
	/**
	 * Method vehicleIconExists
	 * Description: Checks to see that the location icon is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean vehicleIconExists() throws Throwable {
		RSORedesignSelectVehicleSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignSelectVehicleSubPage.vehicleIcon, "Vehicle Icon");
	}
	
	/**
	 * Method Name: editButtonExists
	 * Description: Checks to see that the page header is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean editButtonExists() throws Throwable {
		RSORedesignSelectVehicleSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignSelectVehicleSubPage.vehicleEditButton, " Vehicle Edit Button");
	}
	
	/**
	 * Method Name: clickEditButton
	 * Description: Clicks the Edit Button to return the user to the Set Breakdown Location screen.
	 * @throws Throwable
	 */
	public void clickEditButton() throws Throwable {
		this.click(RSORedesignSelectVehicleSubPage.vehicleEditButton, "Vehicle Edit Button");
	}
	
	/**
	 * Method Name: validatePage
	 * Description: Validates the objects exist on the page and in some cases will get the value.
	 * @throws Throwable
	 */
	public void validatePage(Hashtable<String, String> data) throws Throwable {
		this.titleExists();
		this.vehicleIconExists();
		this.vehicleColorExists();
		this.vehicleNameExists();
		this.vehicleNameValue();
		this.vehicleColorExists();
		this.vehicleColorValue();
		this.editButtonExists();
	}
}
