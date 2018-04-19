/**
 * 12/27/2017 Created by Neil McCormick
 * This is the page object definitions Breakdown Location sub-page 
 * for the RSO redesign app.  THis is the portion that displays at the top of the 
 * screens for Select Vehicle, etc.
 */
package com.aaa.mobile.rsoredesign.page;

import org.openqa.selenium.By;

public class RSORedesignBreakdownSubPage {

	public static By breakdownLocationHeader;
	public static By pageTitle;
	public static By locationText;
	public static By pinIcon;
	public static By editButton;
	
	public static void initialize(String platform){
		
		if(platform.equals("iOS")){
			breakdownLocationHeader = By.id("Breakdown Location");
			pageTitle = By.xpath("Breakdown Location"); 
			locationText = By.id(""); //RSO-47  selectVehicleBL
			pinIcon = By.id("breakdownLocation");
			editButton = By.id("Pencil");
		}
		
		if(platform.equals("Android")){
			breakdownLocationHeader = By.id("rso2.aaa.com.rso2:id/breakdownLocationHeader");
			pageTitle = By.xpath("//android.widget.TextView[@resource-id='rso2.aaa.com.rso2:id/breakdownLocationLabel']"); // //android.widget.TextView[@resource-id='rso2.aaa.com.rso2:id/breakdownLocationLabel']
			locationText = By.id("rso2.aaa.com.rso2:id/breakdownLocationItem");
			pinIcon = By.id("rso2.aaa.com.rso2:id/breakdownLocationIcon");
			editButton = By.id("rso2.aaa.com.rso2:id/breakdownLocationEditIcon");
		}
	}
}
