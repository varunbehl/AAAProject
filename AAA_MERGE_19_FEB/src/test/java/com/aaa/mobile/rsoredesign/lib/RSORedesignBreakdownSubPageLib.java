/**
 * Created 1/2/2018 - Neil McCormick
 * These are all the actions and methods that perform Contact Page actions on the 
 * standalone AAARSO.ipa application for RSO testing.
 * 
 * The RSO Standalone IPA is located here: https://itt101.aaa.com/AAARSO/AAARSO.ipa
 * The primary download page is located here: https://itt101.aaa.com/AAARSO
 */
package com.aaa.mobile.rsoredesign.lib;

import java.util.Hashtable;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.rsoredesign.page.RSORedesignBreakdownSubPage;

public class RSORedesignBreakdownSubPageLib extends ActionEngineMobile {
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
		//RSORedesignBreakdownSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignBreakdownSubPage.pageTitle, "Breakdown Sub Page Title");
	}
	
	/**
	 * Method pinIconExists
	 * Description: Checks to see that the location icon is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean pinIconExists() throws Throwable {
		//RSORedesignBreakdownSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignBreakdownSubPage.pinIcon, "Pin Icon");
	}
	
	/**
	 * Method breakdownHeaderExists
	 * Description: Checks to see that the page header is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean breakdownHeaderExists() throws Throwable {
		//RSORedesignBreakdownSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignBreakdownSubPage.breakdownLocationHeader, "Location Header");
	}
	
	/**
	 * Method locationTextExists
	 * Description: Checks to see that the page header is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean locationTextExists() throws Throwable {
		//RSORedesignBreakdownSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignBreakdownSubPage.locationText, "Location Header");
	}
	
	/**
	 * Method Name: locationTextValue
	 * Description: Gets the text value of the text box.
	 * @return
	 * @throws Throwable
	 */
	public String locationTextValue() throws Throwable {
		//RSORedesignBreakdownSubPage.initialize(platform);
		return this.getText(RSORedesignBreakdownSubPage.locationText, "Location Header");
	}
	
	/**
	 * Method Name: editButtonExists
	 * Description: Checks to see that the page header is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean editButtonExists() throws Throwable {
		//RSORedesignBreakdownSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignBreakdownSubPage.editButton, " BL Edit Button");
	}
	
	/**
	 * Method Name: clickEditButton
	 * Description: Clicks the Edit Button to return the user to the Set Breakdown Location screen.
	 * @throws Throwable
	 */
	public void clickEditButton() throws Throwable {
		this.click(RSORedesignBreakdownSubPage.editButton, "BL Edit Button");
	}
	
	/**
	 * Method Name: validatePage
	 * Description: Validates the objects exist on the page and in some cases will get the value.
	 * @throws Throwable
	 */
	public void validatePage(Hashtable<String, String> data) throws Throwable {
		this.titleExists();
		this.pinIconExists();
		this.breakdownHeaderExists();
		this.locationTextExists();
		if(this.locationTextValue().equals(dataBean.getValue(data, "BreakdownLocation"))){
			reporter.SuccessReport("Breakdown Location Verification", "The breakdown location on the B/L Sub Page matched what was entered in the B/L Screen.");
		}
		else{
			reporter.warningReport("Breakdown Location Verification", "The breakdown location entered on the B/L Screen didn't match the B/L on the subscreen.  Check for errors!");
		}
		
		this.editButtonExists();
	}
}
