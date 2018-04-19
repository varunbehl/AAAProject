/**
 * 12/27/2017 Created by Neil McCormick
 * This is the page object definitions Tow Destination sub-page 
 * for the RSO redesign app.
 * Note, this is the panel below the Problem Description sub-page and the Contact Information page.
 */
package com.aaa.mobile.rsoredesign.page;

import org.openqa.selenium.By;

public class RSORedesignTowDestinationSubPage {

	public static By pageTitle;
	public static By editTowDestinationButton;
	public static By towDestinationLocationText;

	
	public static void initialize(String platform){
		
		if(platform.equals("iOS")){
			pageTitle = By.id("(//XCUIElementTypeStaticText[@name='Tow Destination'])[2]");
			editTowDestinationButton = By.xpath("(//XCUIElementTypeButton[@name='Pencil'])[6]");
			towDestinationLocationText = By.xpath(""); // //XCUIElementTypeStaticText[@name="2010 N Parkton Dr, Deltona, FL 32725"]  Label 1 and label 2 for AARs.
		}
		
		if(platform.equals("Android")){
			pageTitle = By.id("");
			editTowDestinationButton = By.xpath("");
			towDestinationLocationText = By.xpath("");
		}
	}
}
