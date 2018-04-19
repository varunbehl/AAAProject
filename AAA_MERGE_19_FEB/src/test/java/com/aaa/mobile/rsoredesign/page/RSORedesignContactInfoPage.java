/**
 * 12/27/2017 Created by Neil McCormick
 * This is the page object definitions Tow Destination sub-page 
 * for the RSO redesign app.
 * Note, this is the panel below the Problem Description sub-page and the Contact Information page.
 */
package com.aaa.mobile.rsoredesign.page;

import org.openqa.selenium.By;

public class RSORedesignContactInfoPage {
	
	public static By pageTitle;
	public static By contactIcon;
	public static By phoneTextBox;
	public static By submitButton;
	
	public static void initialize(String platform){
		
		if(platform.equals("iOS")){
			pageTitle = By.id("Contact Information");
			contactIcon = By.id("phoneBlack");
			phoneTextBox = By.id(""); // Needs accessability identifier
			submitButton = By.id("Submit Request");
		}
		
		if(platform.equals("Android")){
			pageTitle = By.id("rso2.aaa.com.rso2:id/contactInfoSubmitLabel");
			contactIcon = By.id("rso2.aaa.com.rso2:id/contactInfoSubmitIcon");
			phoneTextBox = By.id("rso2.aaa.com.rso2:id/intlPhoneEditPhone");
			submitButton = By.id("rso2.aaa.com.rso2:id/submitRoadsideRequest");
		}
	}
}
