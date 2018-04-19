/**
 * 12/27/2017 Created by Neil McCormick
 * This is the page object definitions Set Breakdown Location page 
 * for the RSO redesign app.
 */
package com.aaa.mobile.rsoredesign.page;

import org.openqa.selenium.By;

public class RSORedesignSetBreakdownLocationPage {
	
	public static By Advisory; // Avisory title
	public static By AdvisoryText; // Advisory text, assumes in iOS the "Testing in CERTC text."
	public static By LocationTextBox; // The text box that displays the address to be submitted.
	public static By LocationPinStartRequest; //The Start request button.
	public static By LocateMeButton; // The Locate me button that recenters the map on the phone location.
	public static By PhoneLocationDot; // The phone's location displayed on the map.
	public static By GoogleMap; // The Google Map container.
	public static By AllowPhoneCallsText; // Permission to launch phone app.
	public static By AllowPhoneCallsButton;
	public static By CallAAAModalMessage;
	public static By TapToCallAAAButton;
	public static By LoadingSpinner; //rso2.aaa.com.rso2:id/loadingProgress
	
	/**
	 * Method Name: initialize
	 * Description: Receives a string detailing the platform name in which the test is running.
	 * Based on the platform it will decide how to initialize the PageObject Factory.
	 * @param platform
	 */
	public static void intitialize(String platform){
				
		if(platform.equals("iOS"))
		{
			Advisory = By.id("Advisory");
			AdvisoryText = By.xpath("//XCUIElementTypeStaticText[@name='You are testing in CERTC!']");
			LocationTextBox = By.id(""); //RSO-45 opened for this field.  Look for searchField.
			LocationPinStartRequest = By.id("SetBreakdownOvalValue");
			LocateMeButton = By.id("FindMeOn");
			PhoneLocationDot = By.xpath("");// Doesn't locate well, only by xpath full path. //currentLocaation
			GoogleMap = By.id(""); // Also in RSO-45  mapViewContainer
		}
		if(platform.equals("Android")){
			Advisory = By.id("rso2.aaa.com.rso2:id/advisoryBarParent");
			AdvisoryText = By.id("rso2.aaa.com.rso2:id/advisoryDetailsContent");
			LocationTextBox = By.id("rso2.aaa.com.rso2:id/display_info");
			LocationPinStartRequest = By.id("rso2.aaa.com.rso2:id/launch_rso_request");
			LocateMeButton = By.id("rso2.aaa.com.rso2:id/myLocationButton");
			PhoneLocationDot = By.xpath("//android.view.View[@content-desc='Google Map']/android.view.View//android.view.View[@content-desc='Google Map']/android.view.View");
			GoogleMap = By.id("//android.view.View[@content-desc='Google Map']");
			AllowPhoneCallsText = By.id("com.android.packageinstaller:id/permission_message");
			AllowPhoneCallsButton = By.id("com.android.packageinstaller:id/permission_allow_button");
			CallAAAModalMessage = By.id("rso2.aaa.com.rso2:id/md_content"); // Text: We could not complete your request at this time.
			TapToCallAAAButton = By.id("rso2.aaa.com.rso2:id/md_buttonDefaultPositive"); // Text: TAP HERE TO CALL AAA
			LoadingSpinner = By.id("rso2.aaa.com.rso2:id/loadingProgress");
		}
	}
	
}
