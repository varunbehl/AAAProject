/**
 * Created 1/2/2018 - Neil McCormick
 * These are all the actions and methods that perform Standalone App Menu Bar actions on the 
 * standalone AAARSO.ipa application for RSO testing.
 * 
 * The RSO Standalone IPA is located here: https://itt101.aaa.com/AAARSO/AAARSO.ipa
 * The primary download page is located here: https://itt101.aaa.com/AAARSO
 */
package com.aaa.mobile.rsoredesign.lib;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.rsoredesign.page.StandaloneMenuBarPage;

public class StandaloneMenuBarLib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
	}
	
	/**
	 * Method Name: setPlatform
	 * Description: To set the running platform.  Not intrinsically set unless the test case inherits from this class.
	 * @param platform
	 */
	public void setPlatform(String platform){
		this.platform = platform;
	}
	
	/**
	 * Method Name: titleExists
	 * Description: Checks to see that the page title is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean titleExists() throws Throwable {
		//StandaloneMenuBarPage.initialize(platform);
		return this.waitForVisibilityOfElement(StandaloneMenuBarPage.Title, "Menu Bar Title");
	}
	
	/**
	 * Method Name: getTitleValue
	 * Description: Gets the text value of the title.
	 * @return
	 * @throws Throwable
	 */
	public String getTitleValue() throws Throwable{
		return this.getText(StandaloneMenuBarPage.Title, "Menu Bar Title");
	}
	
	/**
	 * Method Name: callAAAExists
	 * Description: Checks to see that the page title is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean callAAAExists() throws Throwable {
		//StandaloneMenuBarPage.initialize(platform);
		return this.waitForVisibilityOfElement(StandaloneMenuBarPage.CallAAA, "Call AAA");
	}
	
	/**
	 * Method Name: clickCallAAA
	 * Description: Click the Call AAA button to launch the phone application.
	 * @throws Throwable
	 */
	public void clickCallAAA() throws Throwable {
		//StandaloneMenuBarPage.initialize(platform);
		this.click(StandaloneMenuBarPage.CallAAA, "Call AAA");
	}
	
	/**
	 * Method Name: backButtonExists
	 * Description: Checks to see that the page title is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean backButtonExists() throws Throwable {
		//StandaloneMenuBarPage.initialize(platform);
		return this.waitForVisibilityOfElement(StandaloneMenuBarPage.BackButton, "Back Button");
	}
	
	/**
	 * Method Name: clickBackButton
	 * Description: Click the Call AAA button to launch the phone application.
	 * @throws Throwable
	 */
	public void clickBackButton() throws Throwable {
		//StandaloneMenuBarPage.initialize(platform);
		this.click(StandaloneMenuBarPage.BackButton, "Back Button");
	}
	
	/**
	 * Method Name: validateMenuBar
	 * Description: Verifies the presence and values of the items in the standalone container app menu bar.
	 * @throws Throwable
	 */
	public void validateMenuBar() throws Throwable{
		this.titleExists();
		reporter.SuccessReport("Container App Title", "The Standalone App title is: " + this.getTitleValue());
		this.callAAAExists();
		this.backButtonExists();
	}

}
