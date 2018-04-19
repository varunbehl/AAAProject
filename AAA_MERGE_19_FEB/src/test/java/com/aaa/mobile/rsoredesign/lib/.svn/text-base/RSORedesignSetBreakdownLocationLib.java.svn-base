/**
 * Created 1/2/2018 - Neil McCormick
 * These are all the actions and methods that perform set breakdown location actions on the 
 * standalone AAARSO.ipa application for RSO testing.
 * 
 * The RSO Standalone IPA is located here: https://itt101.aaa.com/AAARSO/AAARSO.ipa
 * The primary download page is located here: https://itt101.aaa.com/AAARSO
 */
package com.aaa.mobile.rsoredesign.lib;

import java.util.Hashtable;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.rsoredesign.page.RSORedesignSetBreakdownLocationPage;
//import com.aaa.utilities.DataBean;

public class RSORedesignSetBreakdownLocationLib extends ActionEngineMobile {
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
	 * Method Name: advisoryExists
	 * Description: Checks to see if there is an advisory present.  
	 * @return 
	 * @throws Throwable
	 */
	public boolean advisoryExists() throws Throwable {
		RSORedesignSetBreakdownLocationPage.intitialize(this.platform);
		return this.waitForVisibilityOfElement(RSORedesignSetBreakdownLocationPage.Advisory, "Advisory");
	}
	
	/**
	 * Method Name: getAdvisoryText
	 * Description: Gets the actual text of the advisory displayed.
	 * @return
	 * @throws Throwable
	 */
	public String getAdvisoryText() throws Throwable {
		RSORedesignSetBreakdownLocationPage.intitialize(this.platform);
		String advisory = "";
		
		if(this.advisoryExists()){
			reporter.SuccessReport("The advisory exists, getting text.", "Advisory Exists");
			advisory = this.getText(RSORedesignSetBreakdownLocationPage.AdvisoryText, "AdvisoryText");
		}
		
		return advisory;
	}
	
	/**
	 * Method Name: verifyAdvisoryTitle
	 * Description: Verifies the advisory title is present.
	 * @throws Throwable
	 */
	public void verifyAdvisoryTitle() throws Throwable {
		RSORedesignSetBreakdownLocationPage.intitialize(this.platform);
		
		this.waitForVisibilityOfElement(RSORedesignSetBreakdownLocationPage.Advisory, "Advisory Title");
	}
	
	/**
	 * Method Name: verifyPhoneLocationDot
	 * Description: Verifies the phone geo-location dot is present.
	 * @throws Throwable
	 */
	public void verifyPhoneLocationDot() throws Throwable {
		RSORedesignSetBreakdownLocationPage.intitialize(this.platform);
		
		this.waitForVisibilityOfElement(RSORedesignSetBreakdownLocationPage.PhoneLocationDot, "Phone Location Dot");
	}
	
	/**
	 * Method Name: verifyGoogleMap
	 * Description: Verifies the Google Map locator is present and visible.
	 * @throws Throwable
	 */
	public void verifyGoogleMap() throws Throwable {
		RSORedesignSetBreakdownLocationPage.intitialize(this.platform);
		
		this.waitForVisibilityOfElement(RSORedesignSetBreakdownLocationPage.GoogleMap, "Google Map");
	}
	
	/**
	 * Method Name: setBreakdownText
	 * Description: This sets the text box that the application uses to set the breakdown location
	 * in the road service request.
	 * @param data
	 * @throws Throwable
	 */
	public void setBreakdownText(Hashtable<String,String> data) throws Throwable {
		RSORedesignSetBreakdownLocationPage.intitialize(this.platform);
		if(waitForVisibilityOfElement(RSORedesignSetBreakdownLocationPage.LocationTextBox, "BreakdownLocationTextBox")){
			reporter.SuccessReport("Setting B/L", "Entering the B/L into the text box.");
			this.type(RSORedesignSetBreakdownLocationPage.LocationTextBox, dataBean.getValue(data, "BreakdownLocation"), "BreakdownLocationTextBox");
			this.keyBoardOperations(RSORedesignSetBreakdownLocationPage.LocationTextBox, Keys.ENTER, "BreakdownLocationTextBox");
			//appiumDriver.hideKeyboard();
		}
		else{
			reporter.failureReport("setBreakdownText", "Setting the breakdown location failed in the RSO Reimagined app.", appiumDriver);
		}
	}
	
	/**
	 * Method Name: clickLocateMeButton
	 * Description: Click the Locate Me button on the screen to recenter the map view to the phone's
	 * physical location as returned by the device's lat/long.
	 * @throws Throwable
	 */
	public void clickLocateMeButton() throws Throwable {
		RSORedesignSetBreakdownLocationPage.intitialize(this.platform);
		if(waitForVisibilityOfElement(RSORedesignSetBreakdownLocationPage.LocateMeButton, "LocateMeButton")){
			reporter.SuccessReport("Clicking Locate Me", "Now clicking the Locate Me button.");
			this.click(RSORedesignSetBreakdownLocationPage.LocateMeButton, "LocateMeButton");
		}
		else{
			reporter.failureReport("clickLocateMeButton", "Clicking the locate me button failed in the RSO Reimagined app.", appiumDriver);
		}
	}
	
	/**
	 * Method Name: clickSetBreakdownLocationButton
	 * Description: This clicks the Set Breakdown Location button and moves to the next step in the 
	 * service submission process.
	 * @throws Throwable
	 */
	public void clickSetBreakdownLocationButton() throws Throwable {
		RSORedesignSetBreakdownLocationPage.intitialize(this.platform);
		if(waitForVisibilityOfElement(RSORedesignSetBreakdownLocationPage.LocationPinStartRequest, "ClickStartRequest")){
			reporter.SuccessReport("Clicking 'Set Breakdown Location' Button", "Clicking the Set B/L button to continue to the car selection screen.");
			click(RSORedesignSetBreakdownLocationPage.LocationPinStartRequest, "ClickStartRequest");
		}
		else{
			reporter.failureReport("clickSetBreakdownLocationButton", "Clicking the Start Request button failed in the RSO Reimagined app.", appiumDriver);
		}
	}
	
	/**
	 * 
	 * @throws Throwable
	 */
	public void checkForAllowPhoneCallsModal() throws Throwable{
		RSORedesignSetBreakdownLocationPage.intitialize(this.platform);  // I don't understand why this was throwing an exception.
		this.isPageLoaded();
		reporter.SuccessReport("Checking for modal dialogue", "Checking for the Allow Phone Calls Permission modal dialogue");
		if(waitForElementPresent(RSORedesignSetBreakdownLocationPage.AllowPhoneCallsText, "Allow Phone Calls Permission Modal", 20) 
				&& this.getText(RSORedesignSetBreakdownLocationPage.AllowPhoneCallsText, "Allow Phone Calls Permission").equals("Allow RSO2 to make and manage phone calls?") ){
			click(RSORedesignSetBreakdownLocationPage.AllowPhoneCallsButton, "Allow Phone Calls Button");
			reporter.warningReport("Checking for modal dialogue", "Checking for the Allow Phone Calls Permission modal dialogue");
		}
	}
	
	/**
	 * 
	 * @throws Throwable
	 */
	public void checkForCallAAAModal() throws Throwable{
		RSORedesignSetBreakdownLocationPage.intitialize(this.platform); 
		this.isPageLoaded();
		reporter.SuccessReport("Checking for modal dialogue", "Checking for the Call AAA modal dialogue");
		if(waitForElementPresent(RSORedesignSetBreakdownLocationPage.CallAAAModalMessage, "Tap To Call AAA", 10) ){ // &&
			//	getText(RSORedesignSetBreakdownLocationPage.CallAAAModalMessage, "Tap To Call AAA").equals("We could not complete your request at this time.")){
			reporter.failureReport("Could not submit RSO Request", "AAA Mobile RSO could not complete an RSO request due to the tap to call button appearing.", appiumDriver);
			reporter.updateTestCaseStatus();
			throw new Throwable("Test could not continue, back end seems to be down.");
		}
	}
	
	public void isPageLoaded() throws Throwable {
		RSORedesignSetBreakdownLocationPage.intitialize(this.platform);
		//boolean pageLoaded = false;
		reporter.SuccessReport("Verify Set Breakdown Location Page Load", "Verifying the Set Breakdown Location screen is displaying correctly.");
		
		Thread.sleep(5000);
		if(isElementPresent(RSORedesignSetBreakdownLocationPage.LoadingSpinner, "Loading Spinner Present")){
			reporter.warningReport("Loading Spinner Present", "The page loading spinner is present.");
			Thread.sleep(5000);
		}
		/*
		if(waitForElementPresent(RSORedesignSetBreakdownLocationPage.Advisory, "Advisory is Visible", 15)){
			reporter.SuccessReport("Verify Set Breakdown Location Page Load", "The page has loaded successfully!");
			pageLoaded = true;
		}else{
			reporter.warningReport("Verify Set Breakdown Location Page Load", "The page is not displaying correctly!");
		}
		*/
		//return pageLoaded;
	}
	
	/**
	 * Method Name: setBreakdownLocaionAndContinue
	 * Description: This function follows the happy path of setting the breakdown location 
	 * and continuing to the next page.
	 * @param data
	 * @throws Throwable
	 */
	public void setBreakdownLocationAndContinue(Hashtable<String,String> data) throws Throwable {
		reporter.SuccessReport("setBreakdownLocationAndContinue()", "Starting on the Start Submit Request page. On Platform: " + this.platform);
		RSORedesignSetBreakdownLocationPage.intitialize(this.platform);
		if(RSORedesignSetBreakdownLocationPage.LocationTextBox == null)
			reporter.failureReport("Object Not Defined", "RSORedesignSetBreakdownLocationPage.LocationTextBox was not defined!", appiumDriver);

		this.isPageLoaded();
		this.checkForAllowPhoneCallsModal();
		this.checkForCallAAAModal();
		this.isPageLoaded();
		//Implicit wait for the app to load data.
		if(this.advisoryExists()){
			reporter.SuccessReport("Checking for Advisory: " + this.getAdvisoryText(), "GetAdvisory");
		}
		//RSORedesignSetBreakdownLocationPage.intitialize(platform);
			//waitForElementPresent(RSORedesignSetBreakdownLocationPage.Advisory, "Advisory is Visible", 15);	
			//waitForVisibilityOfElement(RSORedesignSetBreakdownLocationPage.Advisory, "Advisory is Visible")){
			this.setBreakdownText(data);
			this.clickSetBreakdownLocationButton();
		//}else{
		//	reporter.failureReport("Could not submit RSO Request", "AAA Mobile RSO could not complete an RSO request due to the Set Breakdown Location screen failed to properly display.", appiumDriver);
			//throw new Throwable();
		//}
	}
		
	
}
