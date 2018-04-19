/**
 * 12/27/2017 Created by Neil McCormick
 * This is the page object definitions Triage sub-page 
 * for the RSO redesign app.
 * Note, this is the panel below the Breakdown Location sub-page and the problem description page.
 */
package com.aaa.mobile.rsoredesign.page;

import org.openqa.selenium.By;

public class RSORedesignTriageSubPage {

	public static By pageTitle;
	public static By problemDescription;
	public static By problemIcon;
	public static By problemEditButton;
	
	public static void initialize(String platform){
		
		if(platform.equals("iOS")){
			pageTitle = By.id("(//XCUIElementTypeStaticText[@name='Problem Description'])[2]");
			problemDescription = By.id(""); //  (//XCUIElementTypeStaticText[@name="Possible Engine Problem"])[2]
			problemIcon = By.id(""); // Need to determine good xpath for dynamic icon names.  //XCUIElementTypeImage[@name="possibleEngineProblemIcon"]
			problemEditButton = By.xpath("(//XCUIElementTypeButton[@name='Pencil'])[5]");
		}
		
		if(platform.equals("Android")){
			pageTitle = By.id("rso2.aaa.com.rso2:id/selectProblemLabel");
			problemDescription = By.id("rso2.aaa.com.rso2:id/selectProblemName");
			problemIcon = By.id("rso2.aaa.com.rso2:id/selectProblemIcon");
			problemEditButton = By.id("rso2.aaa.com.rso2:id/selectProblemEditIcon");
		}
	}
	
}



