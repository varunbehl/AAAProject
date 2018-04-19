package com.aaa.mobile.lib;
import java.util.Hashtable;
import org.testng.ITestContext;
import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.page.LaunchPage;

public class LaunchLib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
	}
	
	/**
	 *methodName : enterZipCode
	 *description: enter the zip Code
	 *param :String inputs
	 * throws Throwable
	 */	
	public void enterZipCode(String enterZIPCode) throws Throwable {
		waitForVisibilityOfElement(LaunchPage.zipCode, "ZIP Code");
		click(LaunchPage.zipCode, "ZIPCode");
		type(LaunchPage.zipCode, enterZIPCode, "ZIPCode");
	}
	
	/**
	 *methodName : checkAgreeTermsAndConditions
	 *description: Tick on agree terms and conditions check box
	 *param
	 * throws Throwable
	 */	
	public void checkAgreeTermsAndConditions() throws Throwable {
		waitForVisibilityOfElement(LaunchPage.agreeTermsConditionsCheckBox, "Agree Terms and Conditions");
		click(LaunchPage.agreeTermsConditionsCheckBox, "Agree Terms and Conditions");
	}
	
	/**
	 *methodName : clickContinueButton
	 *description: click on continue button
	 *param
	 * throws Throwable
	 */	
	public void clickContinueButton() throws Throwable {
		waitForVisibilityOfElement(LaunchPage.continueButton, "Continue Button");
		click(LaunchPage.continueButton, "Continue Button");
	}
	
	/**
	 *methodName : enterZIPCodeandselectContinue
	 *description: enter zip code and select Continue
	 *param :String inputs
	 * throws Throwable
	 */	
	public void enterZIPCodeandselectContinue(String ZIPCode) throws Throwable {
		enterZipCode(ZIPCode);
		checkAgreeTermsAndConditions();
		clickContinueButton();


	}
}
