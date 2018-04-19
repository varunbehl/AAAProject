package com.aaa.mobile.lib;

import java.util.Hashtable;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.page.ContactInformationPage;


public class ContactInformationLib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
	}
	
	/**
	 * enterContactInformation
	 *param String input
	 * throws Throwable
	 *//*
	public void enterContactInformation(String ContactInformation) throws Throwable {
		
		waitForVisibilityOfElement(ContactInformationPage.enterContactInformation, "Contact information");
		click(ContactInformationPage.enterContactInformation, "Contact Information");
		type(ContactInformationPage.enterContactInformation, ContactInformation, "enter Contact Information");
	}*/
	
	/**
	 * clickonSendRequest
	 *param
	 * throws Throwable
	 */
	public void clickonSendRequest() throws Throwable {
		waitForVisibilityOfElement(ContactInformationPage.sendRequest, "Send Request");
		click(ContactInformationPage.sendRequest, "Submit Request");

	}

	/**
	 * getContactNumber
	 *param
	 * throws Throwable
	 */
	public void getContactNumber() throws Throwable {
		waitForVisibilityOfElement(ContactInformationPage.contactNumber, "Contact number");
		isVisibleOnly(ContactInformationPage.contactInformationTitle,"Contact Information title");
		getText(ContactInformationPage.contactNumber, "Contact number");
	}




}
