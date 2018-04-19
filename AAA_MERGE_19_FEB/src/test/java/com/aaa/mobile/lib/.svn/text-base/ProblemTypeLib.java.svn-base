package com.aaa.mobile.lib;

import io.appium.java_client.TouchAction;

import java.util.Hashtable;

import org.testng.ITestContext;

import com.aaa.mobile.page.ProblemTypePage;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.accelerators.AppiumActionEngine;


public class ProblemTypeLib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
	}

	/**
	 * selectProblemType
	 *
	 *@param testdata
	 * throws Throwable
	 */	
	public void selectProblemType(Hashtable<String, String> data) throws Throwable  {
		waitForVisibilityOfElement(ProblemTypePage.batteryProblem, "select problem type ");
		click(ProblemTypePage.batteryProblem, "select problem type");
	}
	/**
	 * validateProblemType
	 *
	 *@param testdata
	 * throws Throwable
	 */	
	public void validateProblemType() throws Throwable  {
		waitForVisibilityOfElement(ProblemTypePage.batteryProblem, "select problem type ");
		isElementPresent(ProblemTypePage.batteryProblem, "problem type");
	}
}
