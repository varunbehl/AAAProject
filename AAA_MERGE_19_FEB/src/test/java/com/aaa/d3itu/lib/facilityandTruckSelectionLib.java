package com.aaa.d3itu.lib;
import java.util.Hashtable;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.LaunchPage;
import com.aaa.d3itu.page.LoginPage;
import com.aaa.d3itu.page.facilityandTruckSelectionPage;

public class facilityandTruckSelectionLib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
		
	}
	
	public String getFacility() throws Throwable {
		//Thread.sleep(25000);
		waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
		waitForVisibilityOfElement(facilityandTruckSelectionPage.facilityDetails, "Facility Details");
		String retFacility = "";
		retFacility = getText(facilityandTruckSelectionPage.facilityDetails, "Facility Details");
		//Thread.sleep(25000);
		return retFacility;

	}
	
	public void clickContinueButton() throws Throwable {
		waitForVisibilityOfElement(facilityandTruckSelectionPage.continueButton, "click on Continue Button");
		click(facilityandTruckSelectionPage.continueButton, "click on Continue Button");
		//type(LaunchPage.environment, environment, "Environment");		
	}
	
	public void selectFacility(String inputFacility) throws Throwable {
		
		click(facilityandTruckSelectionPage.facilityDetails,"Facility Details");
		switch (inputFacility){
		case "P" :
			click(facilityandTruckSelectionPage.truckP,"selected facility : "+inputFacility);
			break;
		case "W" :
			click(facilityandTruckSelectionPage.truckW,"selected facility : "+inputFacility);
			break;
		case "X" :
			click(facilityandTruckSelectionPage.truckX,"selected facility : "+inputFacility);
			break;		
		}
		Thread.sleep(16000);
	}
	
	
	public void selectFacilityandContinue(String inputFacility) throws Throwable {
		if (!(getFacility().equalsIgnoreCase(inputFacility))){
			selectFacility(inputFacility);			
		}		
		clickContinueButton();
		waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
       // Thread.sleep(20000);
	}
}
