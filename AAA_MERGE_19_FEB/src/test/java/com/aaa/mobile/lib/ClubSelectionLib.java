package com.aaa.mobile.lib;

import java.util.Hashtable;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.page.clubSelectionPage;


public class ClubSelectionLib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
	}
	
	/**
	 *methodName : verifySelectedClubName
	 *description: verify the Selected Club Name
	 *param
	 * throws Throwable
	 */	
	public void verifySelectedClubName() throws Throwable {
		waitForVisibilityOfElement(clubSelectionPage.selectClubName, "Select Club Message is displayed");
		isElementPresent(clubSelectionPage.selectClubName, "Select Club Message is displayed", true);
	}

	/**
	 *methodName : clickOnSelectedClub
	 *description: click On Selected Club
	 *param
	 * throws Throwable
	 */	
	public void clickOnSelectedClub() throws Throwable {
		waitForVisibilityOfElement(clubSelectionPage.selectClubName, "Select Club ");
		isVisibleOnly(clubSelectionPage.selectClubName, "Select Club");
		click(clubSelectionPage.selectClubName, "Select Club");
		Thread.sleep(8000);
	}
}
