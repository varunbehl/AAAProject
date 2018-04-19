package com.aaa.mobile.lib;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.page.SecondaryTowDestinationPage;
import io.appium.java_client.TouchAction;

/**
 * Created by E002734 on 12/29/2017.
 */
public class SecondaryTowDestinationLib  extends ActionEngineMobile {


	/**
	 *methodName : getSecondaryTowDestinationTitle
	 *description:get text of Secondary Tow DestinationTitle
	 *param
	 * author :E002734
	 * throws Throwable
	 */
	public void getSecondaryTowDestinationTitle() throws Throwable {
		waitForVisibilityOfElement(SecondaryTowDestinationPage.secondaryTowDestinationTitle, "Home Label ");
		getText(SecondaryTowDestinationPage.secondaryTowDestinationTitle, "Home label");
	}

	/**
	 *methodName : clickSearchIcon
	 *description:click Search Icon
	 *param
	 * author :E002734
	 * throws Throwable
	 */
	public void clickSearchIcon() throws Throwable {
		waitForVisibilityOfElement(SecondaryTowDestinationPage.searchIcon, "search Icon ");
		click(SecondaryTowDestinationPage.searchIcon, "click on search Icon");
	}


	/**
	 *methodName : clickCloseIcon
	 *description:click Cancel Icon
	 *param
	 * author :E002734
	 * throws Throwable
	 */
	public void clickCloseIcon() throws Throwable {
		waitForVisibilityOfElement(SecondaryTowDestinationPage.closeIcon, "Erase text in bar ");
		click(SecondaryTowDestinationPage.closeIcon, "Erase text in bar");
	}

	/**
	 *methodName : pickTowLocation
	 *description:click pick Tow Location
	 *param
	 * author :E002734
	 * throws Throwable
	 */
//	public void pickTowLocation() throws Throwable {
//		waitForVisibilityOfElement(SecondaryTowDestinationPage.firstIntelligence, "click on Tow location ");
//		click(SecondaryTowDestinationPage.firstIntelligence, "click on tow location");
//	}

	/**
	 *methodName : pickTowLocation
	 *description:click pick Tow Location
	 *param
	 * author :E002734
	 * throws Throwable
	 */
	public void clickNextBtn() throws Throwable {
		waitForVisibilityOfElement(SecondaryTowDestinationPage.nextBtn, "click on next  ");
		click(SecondaryTowDestinationPage.nextBtn, "click on next");
	}

	/**
	 *methodName : clickTowLocationField
	 *description:click TowLocationField
	 *param
	 * author :E002734
	 * throws Throwable
	 */
	public void clickTowLocationField() throws Throwable {
		waitForVisibilityOfElement(SecondaryTowDestinationPage.enterBarField, "click on location field  ");
		click(SecondaryTowDestinationPage.enterBarField, "click on tow location field");
	}

	/**
	 *methodName : enterTowLocationAddress
	 *description:enter TowLocation Address
	 *param
	 * author :E002734
	 * throws Throwable
	 */
	public void enterTowLocationAddress(String TowDestination) throws Throwable {
		waitForVisibilityOfElement(SecondaryTowDestinationPage.enterBarField, "click on location field  ");
		//click(SecondaryTowDestinationPage.enterBarField, "click on tow location field");
		type(SecondaryTowDestinationPage.enterBarField, TowDestination, "Tow destination Location");
		Thread.sleep(2000);
		TouchAction tapCoordinates = new TouchAction(appiumDriver);
		tapCoordinates.tap(250,470).perform();
		//click(SecondaryTowDestinationPage.nextBtn, "click on selected tow location field");
		//click(SecondaryTowDestinationPage.nextBtn, "click on next button");
		//click(SecondaryTowDestinationPage.addressArrow, "click on next button");


		Thread.sleep(4000);


	}

}
