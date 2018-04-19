/**
 * Created 12/21/2017 - Neil McCormick
 * These are all the actions and methods that perform the login on the 
 * standalone AAARSO.ipa applciation for RSO testing.
 * 
 * The RSO Standalone IPA is located here: https://itt101.aaa.com/AAARSO/AAARSO.ipa
 * The primary download page is located here: https://itt101.aaa.com/AAARSO
 */
package com.aaa.mobile.rsoredesign.lib;

//import io.appium.java_client.TouchAction;

import java.util.Hashtable;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.rsoredesign.page.StandaloneLoginPage;

public class StandaloneLoginLib extends ActionEngineMobile  {
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
	 * Method Name: setAssociation
	 * Description: Takes a hash table of data, one field MUST be the Association field.
	 * Throws a potential error when the Association buttons aren't found.
	 * @param data
	 * @throws Throwable
	 */
	public void setAssociation(Hashtable<String, String> data) throws Throwable{
		String association = dataBean.getValue(data, "Association");
		StandaloneLoginPage.intitialize(this.platform );
		waitForVisibilityOfElement(StandaloneLoginPage.AAAButton, "AAAButton");
		if(this.platform.equals("iOS")){
			if(association.equals("AAA")){
				if(appiumDriver.findElement(StandaloneLoginPage.AAAButton).getAttribute("value").equals("1")){
					click(StandaloneLoginPage.AAAButton, "AAAButton");
				}
			}else{
				if(appiumDriver.findElement(StandaloneLoginPage.AAAButton).getAttribute("value").equals("1")){
					click(StandaloneLoginPage.CAAButton, "CAAButton");
				}
			}
		}
		if(this.platform.equals("Android")){
			String associationText = this.getText(StandaloneLoginPage.AAAButton, "Association Selection");
			if(!association.equals(associationText)){
				click(StandaloneLoginPage.AAAButton, "Association Selection");
			}
		}
	}
	
	/**
	 * Method Name: setMemberNumber
	 * Description: Takes a hash table of data, one field MUST be the MemberNumber field.
	 * @param data
	 * @throws Throwable
	 */
	public void setMemberNumber(Hashtable<String, String> data) throws Throwable{
		StandaloneLoginPage.intitialize(this.platform );
		waitForVisibilityOfElement(StandaloneLoginPage.MemberNumberTextBox, "MemberNumberTextBox");
		if(this.platform.equals("iOS")){
			click(StandaloneLoginPage.MemberNumberTextBox, "MemberNumberTextBox");
			type(StandaloneLoginPage.MemberNumberTextBox, dataBean.getValue(data, "MemberNumber"), "Member Number");
			appiumDriver.hideKeyboard();
		}
		if(this.platform.equals("Android")){
			type(StandaloneLoginPage.MemberNumberTextBox, dataBean.getValue(data, "MemberNumber"), "Member Number");
			appiumDriver.hideKeyboard();
		}
	}
	
	/**
	 * Method Name: setClubNumber
	 * Description: This is an Android Specific login function that sets the required club number for the
	 * test login for the standalone app.
	 * @param data
	 * @throws Throwable
	 */
	public void setClubNumber(Hashtable<String, String> data) throws Throwable{
		if(this.platform.equals("Android")){
			StandaloneLoginPage.intitialize(this.platform );
			String clubNumber = dataBean.getValue(data, "ClubNumber");
			if(clubNumber.contains(".0")){
				clubNumber = clubNumber.substring(0, clubNumber.indexOf("."));  //Has this weird thing about passing a decimal...
			}
			type(StandaloneLoginPage.ClubNumber, clubNumber, "Club Number");
			appiumDriver.hideKeyboard();
		}
	}
	
	/**
	 * Method Name: setPhoneNumber
	 * Description: Sets the main toll free phone number in the phone number fields of the applications
	 * standalone login page.  This is the association level phone number that services all clubs for
	 * the RSO systems: 800-222-4357
	 * The number is "hard coded" in this test case, but can be parameterized in the data set.
	 * @throws Throwable
	 */
	public void setPhoneNumber() throws Throwable{
		if(this.platform.equals("Android")){ // iOS is prepopulated, so only for Android do we need to set this value.
			StandaloneLoginPage.intitialize(this.platform );
			type(StandaloneLoginPage.PhoneNumberTextBox, "800-222-4357", "Phone Number");
			appiumDriver.hideKeyboard();
		}
	}
	
	/**
	 * Method Name: clickLogInButton
	 * Description: Clicks the login button to start the RSO portion of the application in 
	 * the standalone AAARSO.ipa application.
	 * @throws Throwable
	 */
	public void clickLogInButton() throws Throwable{
		waitForVisibilityOfElement(StandaloneLoginPage.StartRSOButton, "StartRSOButton");
		click(StandaloneLoginPage.StartRSOButton, "RSO Login");
	}
	
	/**
	 * Method Name: loginPageVisible
	 * Description: checks for and clicks the StartRSOButton for both iOS and Android.
	 * @return
	 * @throws Throwable
	 */
	public boolean loginPageVisible() throws Throwable{
		boolean isVisible = false;
		
		StandaloneLoginPage.intitialize(this.platform);
		if(isVisibleOnly(StandaloneLoginPage.StartRSOButton, "StartRSOButton")){
			isVisible = true;
		}
		return isVisible;
	}
	
	/**
	 * Method Name: allowLocationAccess
	 * Description: Click the allow button on the OS Modal for requesting Location Services
	 * access.
	 */
	public void allowLocationAccess() throws Throwable{
		StandaloneLoginPage.intitialize(this.platform);
		if(waitForElementPresent(StandaloneLoginPage.AllowLocationText, "Allow Location Text", 15)){
			waitForVisibilityOfElement(StandaloneLoginPage.AllowLocationText, "Allow Location Text");
			click(StandaloneLoginPage.AllowButton, "Allow Location Access Button");
		}
	}
	
	/**
	 * Method Name: setLanguage
	 * Description: For the standalone app, will set the language for the RSO library.  Facilitates testing French translations for CAA.
	 * @param data
	 * @throws Throwable
	 */
	public void setLanguage(Hashtable<String, String> data) throws Throwable{
		String language = dataBean.getValue(data, "Language");
		if(language.isEmpty()){
			language = "English";
		}
		
		if(platform.equals("iOS")){
			
		}
		
		if(platform.equals("Android")){
			if(!language.toUpperCase().equals(getText(StandaloneLoginPage.LanguageSelector, "Language Selector"))){
				click(StandaloneLoginPage.LanguageSelector, "Language Selector");
			}
		}
	}
	
	/**
	 * Method Name: loginRSOStandalone
	 * Description: This is the primary method that handles the whole login experience in the 
	 * AAARSO.ipa mobile standalone app.
	 * @param data
	 * @throws Throwable
	 */
	public void loginRSOStandalone(Hashtable<String,String> data) throws Throwable{
		loginPageVisible();
		setAssociation(data);
		setLanguage(data);
		setPhoneNumber();
		setMemberNumber(data);
		setClubNumber(data); //Added for Android specific login requirements.
		clickLogInButton();
		allowLocationAccess();
	}
}
