/**
 * 12/27/2017 Created by Neil McCormick
 * This is the page object definitions Triage Selection page 
 * for the RSO redesign app.
 * 
 */
package com.aaa.mobile.rsoredesign.page;

import org.openqa.selenium.By;

public class RSORedesignTriagePage {

	public static By pageTitle;
	
	public static void initialize(String platform){
		if(platform.equals("iOS")){
			pageTitle = By.xpath("(//XCUIElementTypeStaticText[@name='Problem Description'])[1]");
			/* All other iOS items will be dynamically created via xpath or ID:
			 * //XCUIElementTypeStaticText[@name="Battery"]
			 */
		}
		if(platform.equals("Android")){
			pageTitle = By.id("rso2.aaa.com.rso2:id/problemDescriptionLabel");
			/* All other searches will be done by text.
			 * Example Xpath:
			 * //android.widget.TextView[@text='Mechanical Problem']
			 * This will be handled in the lib file.
			 */
		}
	}
	
}
