package com.aaa.d3itu.lib;
import java.util.Hashtable;

import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.LaunchPage;
import com.aaa.d3itu.page.LoginPage;

public class LoginITULib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;

	}

	public void enterUserName(String UserName) throws Throwable {
		waitForVisibilityOfElement(LoginPage.userName, "User Name");
		type(LoginPage.userName, UserName, "User Name");
	}

	public void enterPassword(String Password) throws Throwable {
		waitForVisibilityOfElement(LoginPage.password, "Password");
		type(LoginPage.password, Password+"\n", "Password");
	}

	public void clickLoginButton() throws Throwable {
		waitForVisibilityOfElement(LoginPage.login, "click on Login");
		click(LoginPage.login, "click on Login");
		//type(LaunchPage.environment, environment, "Environment");		
	}

	public void enterLoginDetails(String UserName, String Password) throws Throwable {
		waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
			//Thread.sleep(20000);
				enterUserName(UserName);
				enterPassword(Password);
				//clickLoginButton();
			}
		}


