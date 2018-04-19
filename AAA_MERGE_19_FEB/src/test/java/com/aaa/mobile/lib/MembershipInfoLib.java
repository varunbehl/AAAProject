package com.aaa.mobile.lib;

import java.util.Hashtable;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.page.MembershipInfoPage;


public class MembershipInfoLib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
	}

	/**
	 *methodName : verifyMembershipNumberTitle
	 *description: verify Membership Number Title
	 *param
	 * throws Throwable
	 */	
	public void verifyMembershipNumberTitle() throws Throwable {
		Thread.sleep(8000);
		isVisibleOnly(MembershipInfoPage.membershipLabel, "Membership Message is displayed");
	}
	
	/**
	 *methodName : clickAndEnterMembershipNumber
	 *description: click And Enter Membership Number
	 *param :String inputs
	 * throws Throwable
	 */	
	public void clickAndEnterMembershipNumber(String MemberNumber) throws Throwable {
		Thread.sleep(8000);
		click(MembershipInfoPage.membershipSequence, "membership Number");
		type(MembershipInfoPage.membershipSequence,MemberNumber, "Member Number");
	}

	/**
	 *methodName : clickOnskip
	 *description: click On skip
	 *param
	 * throws Throwable
	 */	
	public void clickOnskip() throws Throwable {
		Thread.sleep(2000);
		click(MembershipInfoPage.skipButton, "clicks on skipMembership");
	}

	/**
	 *methodName : clickContinueButton
	 *description: click Continue Button
	 *param
	 * throws Throwable
	 */	
	public void clickContinueButton() throws Throwable {
		waitForVisibilityOfElement(MembershipInfoPage.continueButton, "Continue Button");
		click(MembershipInfoPage.continueButton, "Continue Button");
	}

	/**
	 *methodName : enterMembershipNumberAndContinue
	 *description: enter Membership Number And Continue
	 *param :String inputs
	 * throws Throwable
	 */	
	public void enterMembershipNumberAndContinue(String MemberNumber) throws Throwable {
		verifyMembershipNumberTitle();
		clickAndEnterMembershipNumber(MemberNumber);
		clickContinueButton();
	}


}
