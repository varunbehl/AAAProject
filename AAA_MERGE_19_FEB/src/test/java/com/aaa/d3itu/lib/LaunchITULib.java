package com.aaa.d3itu.lib;
import java.util.Hashtable;

import io.appium.java_client.android.AndroidKeyCode;
import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;

import com.aaa.d3itu.page.LaunchPage;

public class LaunchITULib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;

	}

	/**
	 * methodName : enterEnvironmentDetails
	 * description: enter the environment Details
	 * param :String inputs
	 * throws Throwable
	 */
	public void enterEnvironmentDetails(String environment) throws Throwable {
		waitForVisibilityOfElement(LaunchPage.environment, "Environment");
		type(LaunchPage.environment, environment+"\n", "Environment");
		appiumDriver.hideKeyboard();
	}

	public void clickSubmitButton() throws Throwable {
		waitForVisibilityOfElement(LaunchPage.submit, "click on Submit");
		click(LaunchPage.submit, "click on Submit");
		//appiumDriver.hideKeyboard();
		//type(LaunchPage.environment, environment, "Environment");		
	}

	public void selectEnvironment(String environment) throws Throwable {
		//Thread.sleep(30000);
		 waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
			if (waitForVisibilityOfElement(LaunchPage.environment, "Environment")) {
				enterEnvironmentDetails(environment);
				//clickSubmitButton();
			}
		}

	}


