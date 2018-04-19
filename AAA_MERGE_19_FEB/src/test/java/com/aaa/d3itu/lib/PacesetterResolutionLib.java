package com.aaa.d3itu.lib;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.*;

import java.util.Hashtable;

import io.appium.java_client.TouchAction;
import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.LoginPage;

public class PacesetterResolutionLib extends ActionEngineMobile {
    public ITestContext testcontext;

    public void setTestContext(ITestContext testContext) {
        this.testcontext = testContext;

    }

    public void clickOnProblemKeys() throws Throwable {
        Thread.sleep(4000);
        if (isVisibleOnly(PacesetterResolutionPage.towProblemKeys, "click on tow problem keys")) {
            click(PacesetterResolutionPage.towProblemKeys, "click on tow problem keys");

        } else if (  isVisibleOnly(PacesetterResolutionPage.fuelProblemKeys, "click on fuel problem keys")) {
            click(PacesetterResolutionPage.fuelProblemKeys, "click on fuel problem keys");

        } else if ( isVisibleOnly(PacesetterResolutionPage.tiresProblemKeys, "click on tires problem keys")) {
            click(PacesetterResolutionPage.tiresProblemKeys, "click on tires problem keys");

        } else if (isVisibleOnly(PacesetterResolutionPage.noServiceProblemKeys, "click on noservice problem keys")) {
            click(PacesetterResolutionPage.noServiceProblemKeys, "click on noservice problem keys");

        } else if ( isVisibleOnly(PacesetterResolutionPage.batteryProblemKeys, "click on battery problem keys")) {
            click(PacesetterResolutionPage.batteryProblemKeys, "click on battery problem keys");

        } else if ( isVisibleOnly(PacesetterResolutionPage.extricationProblemKeys, "click on extrication problem keys")) {
            click(PacesetterResolutionPage.extricationProblemKeys, "click on extrication problem keys");
        } else if (  isVisibleOnly(PacesetterResolutionPage.keysProblemKeys, "click on keys problem keys")) {
            click(PacesetterResolutionPage.keysProblemKeys, "click on keys problem keys");

        } else if ( isVisibleOnly(PacesetterResolutionPage.miscellaneousProblemKeys, "click on tow problem keys")) {
            click(PacesetterResolutionPage.miscellaneousProblemKeys, "click on tow problem keys");
        }
        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
    }

}


