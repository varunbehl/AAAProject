/**
 * 12/27/2017 Created by Neil McCormick
 * This is the page object definitions Tow Destination page 
 * for the RSO redesign app.
 * 
 */
package com.aaa.mobile.rsoredesign.page;

import org.openqa.selenium.By;

public class RSORedesignTowDestinationPage {

	public static By pageTitle;
	public static By selectAAR;
	public static By selectHome;
	public static By selectFromContacts;
	public static By selectAddress;
	
	public static void initialize(String platform){
		
		if(platform.equals("iOS")){
			pageTitle = By.id("Tow Destination");
			selectAAR = By.id("AAA Approved Auto Repair Facility");
			selectHome = By.id("Home");
			selectFromContacts = By.id("Select from Contacts");
			selectAddress = By.id("Add New Address"); //Jira needs to be opened align both Android and iOS.
		}
		
		if(platform.equals("Android")){
			pageTitle = By.id("rso2.aaa.com.rso2:id/towDestinationLabe");
			selectAAR = By.xpath("//android.widget.TextView[@text='AAA Approved Auto Repair Facility']");
			selectHome = By.id("//android.widget.TextView[@text='AAA Approved Auto Repair Facility']"); //The actual displayed "home" address returned from CDX
			selectFromContacts = By.xpath("//android.widget.TextView[@text='Select from Contacts']");
			selectAddress = By.id("//android.widget.TextView[@text='Select Address']");
		}
	}
}
