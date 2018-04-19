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
import com.aaa.mobile.rsoredesign.page.RSORedesignTriageSubPage;

public class RSORedesignTriageSubPageLib extends ActionEngineMobile {
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
	 * Method titleExists
	 * Description: Checks to see that the page title is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean titleExists() throws Throwable {
		RSORedesignTriageSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignTriageSubPage.pageTitle, "Triage Sub Page Title");
	}
	
	/**
	 * Method problemDescriptionExists
	 * Description: Checks to see that the problem text is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean problemDescriptionExists() throws Throwable {
		RSORedesignTriageSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignTriageSubPage.problemDescription, "Problem Description");
	}
	
	/**
	 * Method Name: problemDescriptionValue
	 * Description: Gets the text value of the text box.
	 * @return
	 * @throws Throwable
	 */
	public String problemDescriptionValue() throws Throwable {
		RSORedesignTriageSubPage.initialize(platform);
		return this.getText(RSORedesignTriageSubPage.problemDescription, "Problem Description");
	}
	
	/**
	 * Method problemIconExists
	 * Description: Checks to see that the problem icon is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean problemIconExists() throws Throwable {
		RSORedesignTriageSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignTriageSubPage.problemIcon, "Problem Icon");
	}
	
	/**
	 * Method Name: editButtonExists
	 * Description: Checks to see that the page header is displaying.
	 * @return
	 * @throws Throwable
	 */
	public boolean editButtonExists() throws Throwable {
		RSORedesignTriageSubPage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignTriageSubPage.problemEditButton, "Problem Edit Button");
	}
	
	/**
	 * Method Name: clickEditButton
	 * Description: Clicks the Edit Button to return the user to the Set Breakdown Location screen.
	 * @throws Throwable
	 */
	public void clickEditButton() throws Throwable {
		this.click(RSORedesignTriageSubPage.problemEditButton, "Problem Edit Button");
	}
	
	/**
	 * Method Name: validatePage
	 * Description: Validates the objects exist on the page and in some cases will get the value.
	 * @throws Throwable
	 */
	public void validatePage(Hashtable<String, String> data) throws Throwable {
		this.titleExists();
		this.problemIconExists();
		this.problemDescriptionExists();
		if(this.problemDescriptionValue().equals(dataBean.getValue(data, "ProblemDescription"))){
			reporter.SuccessReport("Problem Description Verification", "The Problem Description on the Problem Description Sub Page matched what was entered in the problem description Screen.");
		}
		else{
			reporter.failureReport("Problem Description Verification", "The problem description entered on Triage Screens didn't match the problem description on the subscreen.  Check for errors!");
		} 
		
		this.editButtonExists();
	}
}
