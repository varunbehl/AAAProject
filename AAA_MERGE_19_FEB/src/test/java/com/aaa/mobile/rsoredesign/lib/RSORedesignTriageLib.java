/**
 * Created 1/2/2018 - Neil McCormick
 * These are all the actions and methods that perform Select Triage Items actions on the 
 * standalone AAARSO.ipa application for RSO testing.
 * 
 * The RSO Standalone IPA is located here: https://itt101.aaa.com/AAARSO/AAARSO.ipa
 * The primary download page is located here: https://itt101.aaa.com/AAARSO
 */
package com.aaa.mobile.rsoredesign.lib;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.rsoredesign.page.RSORedesignTriagePage;

public class RSORedesignTriageLib extends ActionEngineMobile {
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
	 * Method Name: pageTitlePresent
	 * Description: Checks for the presence of the page title, indicates that the page is loaded.
	 * @return
	 * @throws Throwable
	 */
	public boolean pageTitlePresent() throws Throwable{
		RSORedesignTriagePage.initialize(platform);
		return this.waitForVisibilityOfElement(RSORedesignTriagePage.pageTitle, "Page Title");
	}
	
	/**
	 * Method Name: xpathTraigeItem
	 * Description: Dynamically creates the triage locator by OS type.
	 * @param byText
	 * @return
	 */
	public By xpathTriageItem(String byText) {
		By toReturn = null;
		if(platform.equals("iOS")){
			toReturn = By.id(byText); 
		}
		
		if(platform.equals("Android")){
			toReturn = By.xpath("//android.widget.TextView[@text='" + byText + "']");
		}
		
		return toReturn;
	}
	
	/**
	 * Method Name: selectTriageItems
	 * Description: Selects the primary and sub triage selections 
	 * @param data
	 * @throws Throwable
	 */
	public void selectTriageItems(Hashtable<String,String> data) throws Throwable {
		if(this.pageTitlePresent()){
			String primaryTriageText = dataBean.getValue(data, "Problemtype");
			String secondaryTriageText = dataBean.getValue(data, "ProblemDescription");
			By primaryTriage = xpathTriageItem(primaryTriageText);
			By secondaryTriage = xpathTriageItem(secondaryTriageText);
			
			click(primaryTriage, primaryTriageText);
			click(secondaryTriage, secondaryTriageText);
			
		}
	}
}
