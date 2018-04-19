package com.aaa.d3itu.lib;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.*;

import java.util.Hashtable;

import io.appium.java_client.TouchAction;
import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.LoginPage;

public class ETALib extends ActionEngineMobile {
    public ITestContext testcontext;

    public void setTestContext(ITestContext testContext) {
        this.testcontext = testContext;

    }
    CallsLib callslib =new CallsLib();

    public void clickOnETAMinutes() throws Throwable {
        waitForVisibilityOfElement(ETAPage.ETAMinutes, "click on ETA minutes");
        click(ETAPage.ETAMinutes, "click on ETA minutes");

    }
    public void clickOnSave() throws Throwable {
        waitForVisibilityOfElement(ETAPage.btnSave, "click on save");
        click(ETAPage.btnSave, "click on save");

    }

    public void statusUpdateAsETA(String statusUpdateAsETA) throws Throwable {
        if (waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner")) {
            if (statusUpdateAsETA.equalsIgnoreCase("ETA")) {
                callslib.clickOnNextStatus();
                clickOnETAMinutes();
                clickOnSave();
            }
        }
    }
}