package com.aaa.d3itu.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.*;

import java.util.Hashtable;

import io.appium.java_client.ScrollsTo;
import io.appium.java_client.TouchAction;
import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.LoginPage;

    public class AssignTruckLib extends ActionEngineMobile {
        public ITestContext testcontext;

        public void setTestContext(ITestContext testContext) {
            this.testcontext = testContext;

        }

        public void clickOnAssignTruck() throws Throwable {
            Thread.sleep(2000);
            appiumDriver.scrollTo("5140/P");
            Thread.sleep(3000);
            waitForVisibilityOfElement(AssignTruckPage.assignTruckP, "click on assign truck");
            click(AssignTruckPage.assignTruckP, "click on assign truck");

        }
    }
