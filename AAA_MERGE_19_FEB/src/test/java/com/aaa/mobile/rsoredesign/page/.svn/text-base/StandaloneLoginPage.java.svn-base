/**
 * 12/21/2017 Created by Neil McCormick
 * This is the page object definitions of the AAARSO.ipa app 
 * for the RSO redesign app.
 */
package com.aaa.mobile.rsoredesign.page;

import org.openqa.selenium.By;

public class StandaloneLoginPage {
	
	public static By AAAButton;
	public static By CAAButton; // iOS Only.
	public static By PhoneNumberTextBox;
	public static By MemberNumberTextBox;
	public static By MemberNumberButton;
	public static By StartRSOButton;
	public static By ClubNumber; // Used on Android only.
	public static By VersionNumber;
	public static By LanguageSelector;
	public static By KeyboardReturnButton;
	public static By AllowLocationText;
	public static By DontAllowButton;
	public static By AllowButton;
	
	/**
	 * Method Name: intiialize
	 * Description: Receives a string detailing the platform name in which the test is running.
	 * Based on the platform it will decide how to initialize the PageObject Factory.
	 * @param platform
	 */
	public static void intitialize(String platform){
		if(platform.equals("iOS")){
			AAAButton = By.xpath("//XCUIElementTypeButton[@name='AAA']");
			CAAButton = By.xpath("//XCUIElementTypeButton[@name='CAA']");
			// Full xpath: //XCUIElementTypeApplication[@name=\"AAARSO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]/XCUIElementTypeTextField
			PhoneNumberTextBox = By.id("PhoneNumber");
			// Full xpath: //XCUIElementTypeApplication[@name=\"AAARSO\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]/XCUIElementTypeTextField
			MemberNumberTextBox = By.id("MemberNumber");
			StartRSOButton = By.id("Start RSO");
			KeyboardReturnButton = By.xpath("//XCUIElementTypeButton[@name='Return']");
			MemberNumberButton = By.xpath("//XCUIElementTypeButton[@name='4290141616017805']");
			///AppiumAUT/XCUIElementTypeApplication/XCUIElementTypeWindow[6]/XCUIElementTypeOther[2]/XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText
			AllowLocationText = By.id("Allow “AAARSO” to access your location while you use the app?");
			DontAllowButton = By.id("Don’t Allow");
			AllowButton = By.id("Allow");
		
		}
		if(platform.equals("Android")){
			AAAButton = By.id("rso2.aaa.com.rso2:id/associationTextView"); //Edit box on Android, disabled.
			//CAAButton = By.xpath("//XCUIElementTypeButton[@name='CAA']");  //Not used on Android
			PhoneNumberTextBox = By.id("rso2.aaa.com.rso2:id/helpNumberEdit");
			ClubNumber = By.id("rso2.aaa.com.rso2:id/clubCodeEdit"); //Android requires a club number to be entered.
			MemberNumberTextBox = By.id("rso2.aaa.com.rso2:id/memberNumberEdit");
			StartRSOButton = By.id("rso2.aaa.com.rso2:id/launchRSORequest"); //Launch Breakdown Selector Map" button.
			KeyboardReturnButton = By.xpath("//XCUIElementTypeButton[@name='Return']");
			MemberNumberButton = By.xpath("//XCUIElementTypeButton[@name='4290141616017805']");
			AllowLocationText = By.id("com.android.packageinstaller:id/permission_message");
			DontAllowButton = By.id("com.android.packageinstaller:id/permission_deny_button");
			AllowButton = By.id("com.android.packageinstaller:id/permission_allow_button");
			VersionNumber = By.id("rso2.aaa.com.rso2:id/rso2Version");
			LanguageSelector = By.id("rso2.aaa.com.rso2:id/languageEdit");
		}
	}
}
