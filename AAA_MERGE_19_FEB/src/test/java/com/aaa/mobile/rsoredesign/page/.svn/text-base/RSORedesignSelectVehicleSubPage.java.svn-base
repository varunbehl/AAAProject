/**
 * 12/27/2017 Created by Neil McCormick
 * This is the page object definitions Select Vehicle sub-page 
 * for the RSO redesign app.
 * Note, this is the panel below the Breakdown Location sub-page and the problem description page.
 */
package com.aaa.mobile.rsoredesign.page;

import org.openqa.selenium.By;

public class RSORedesignSelectVehicleSubPage {

	public static By pageTitle;
	public static By vehicleName;
	public static By vehicleColor;
	public static By vehicleIcon;
	public static By vehicleEditButton;
	
	public static void initialize(String platform){
		
		if(platform.equals("iOS")){
			pageTitle = By.id("Selected Vehicle");
			vehicleName = By.id(""); //(//XCUIElementTypeStaticText[@name="2013 Chevrolet Cruze"])[2]
			vehicleColor = By.id(""); //(//XCUIElementTypeStaticText[@name="Silver"])[2]
			vehicleIcon = By.id("dummyCar");
			vehicleEditButton = By.id("(//XCUIElementTypeButton[@name='Pencil'])[4]");
		}
		
		if(platform.equals("Android")){
			pageTitle = By.id("rso2.aaa.com.rso2:id/selectVehicleLabel");
			vehicleName = By.id("rso2.aaa.com.rso2:id/selectVehicleName");
			vehicleColor = By.id("rso2.aaa.com.rso2:id/selectVehicleColor");
			vehicleIcon = By.id("rso2.aaa.com.rso2:id/selectVehicleIcon");
			vehicleEditButton = By.id("rso2.aaa.com.rso2:id/selectVehicleEditIcon");
		}
	}
	
}
