/**
 * Created 1/2/2018 - Neil McCormick
 * These are all the actions and methods that perform Contact Page actions on the 
 * standalone AAARSO.ipa application for RSO testing.
 * 
 * The RSO Standalone IPA is located here: https://itt101.aaa.com/AAARSO/AAARSO.ipa
 * The primary download page is located here: https://itt101.aaa.com/AAARSO
 */
package com.aaa.mobile.rsoredesign.lib;

import java.util.Hashtable;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.rsoredesign.page.RSORedesignContactInfoPage;

public class RSORedesignContactInfoLib extends ActionEngineMobile {
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
	 * Method Name:pageLoaded
	 * Description: Checks to see that the page title is displaying and assumes the page has loaded correctly.
	 * @return
	 * @throws Throwable
	 */
	public boolean pageLoaded() throws Throwable {
		RSORedesignContactInfoPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignContactInfoPage.pageTitle, "Page Title");
	}
	
	/**
	 * Method Name: contactIconExists
	 * Description: Verifies the Contact Icon is present and visible. 
	 */
	public boolean contactIconExists() throws Throwable {
		RSORedesignContactInfoPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignContactInfoPage.contactIcon, "Contact Icon");
	}
	
	/**
	 * Method Name: getContactPhoneNumber
	 * Description: Returns the value of the text box containing the contact phone number.
	 * @return
	 * @throws Throwable
	 */
	public String getContactPhoneNumber() throws Throwable {
		RSORedesignContactInfoPage.initialize(platform);
		return getText(RSORedesignContactInfoPage.phoneTextBox, "Contact Phone Number");
	}
	
	/**
	 * Method Name: setContactPhoneNumber
	 * Description: Sets the contact phone number.
	 * @param phoneNumber
	 * @throws Throwable
	 */
	public void setContactPhoneNumber(String phoneNumber) throws Throwable {
		RSORedesignContactInfoPage.initialize(platform);
		this.type(RSORedesignContactInfoPage.phoneTextBox, phoneNumber, "Contact Phone Number");
	}
	
	/**
	 * Method Name: clickSubmitButton
	 * Description: Checks for the visibility of then clicks teh Submit Button.
	 * @throws Throwable
	 */
	public void clickSubmitButton() throws Throwable {
		if(this.waitForVisibilityOfElement(RSORedesignContactInfoPage.submitButton, "Submit Button")){
			this.click(RSORedesignContactInfoPage.submitButton, "Submit Button");
		}
	}
	
	/**
	 * Method Name: verifyContactSubmitRequest
	 * Description: Follows the happy path of ensuring the contact information is filled and 
	 * submits the RSO request.
	 * @param data
	 * @throws Throwable
	 */
	public void verifyContactSubmitRequest(Hashtable<String,String> data) throws Throwable {
		if(this.pageLoaded()){
			String phoneNumber = dataBean.getValue(data, "ContactInformation");
			
			if(!this.getContactPhoneNumber().isEmpty() && this.getContactPhoneNumber().equals(phoneNumber)){
				reporter.SuccessReport("Contact Information Phone Number", "The phone number was already set with the phone number from the data set.");
			}
			else{
				this.setContactPhoneNumber(phoneNumber);
			}
			
			this.clickSubmitButton();
		}
	}

}
