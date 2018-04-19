/**
 * 12/27/2017 Created by Neil McCormick
 * This is the page object definitions Select Vehicle page 
 * for the RSO redesign app.
 * 
 * NOTE: Only the first car object in the list returned is defined in this page object.
 */
package com.aaa.mobile.rsoredesign.page;

import org.openqa.selenium.By;

public class RSORedesignSelectVehiclePage {
	
	public static By pageTitle;
	public static By addNewVehicleButton;
	public static By selectVehicleName;
	public static By selectVehicleColor;
	public static By editVehicleButton;
	public static By deleteVehicleButton;
	public static By selectVehicleImageIcon;
	
	public static void initialize(String platform){
		
		if(platform.equals("iOS")){
			pageTitle = By.id("Select a Vehicle");
			addNewVehicleButton = By.id("Add New Vehicle");
			selectVehicleName = By.xpath(""); //Selects the first vehicle in the list.
			selectVehicleColor = By.xpath("");
			editVehicleButton = By.xpath("(//XCUIElementTypeButton[@name='Pencil'])[2]");
			deleteVehicleButton = By.xpath("(//XCUIElementTypeButton[@name='Trash'])[1]");
			selectVehicleImageIcon = By.xpath("");
		}
		
		if(platform.equals("Android")){
			pageTitle = By.id("selectVehicleLabel");
			addNewVehicleButton = By.id("rso2.aaa.com.rso2:id/selectVehicleLabel");
			selectVehicleName = By.xpath("(//android.widget.TextView[@resource-id='rso2.aaa.com.rso2:id/vehicleName'])[1]"); //Selects the first vehicle in the list.
			selectVehicleColor = By.xpath("(//android.widget.TextView[@resource-id='rso2.aaa.com.rso2:id/vehicleColor'])[1]");
			editVehicleButton = By.xpath("(//android.widget.RelativeLayout[@resource-id='rso2.aaa.com.rso2:id/vehicleEdit'])[1]");
			deleteVehicleButton = By.xpath("(//android.widget.RelativeLayout[@resource-id='rso2.aaa.com.rso2:id/vehicleDelete'])[1]");
			selectVehicleImageIcon = By.xpath("(//android.widget.ImageView[@resource-id='rso2.aaa.com.rso2:id/vehicleImageIcon'])[1]");
		}
	}
}
