package com.aaa.d3itu.lib;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.*;

import java.util.Hashtable;

import com.aaa.mobile.page.TellAboutVehiclePage;
import io.appium.java_client.TouchAction;
import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.LoginPage;

public class VehicleLookupLib extends ActionEngineMobile {
    public ITestContext testcontext;

    public void setTestContext(ITestContext testContext) {
        this.testcontext = testContext;

    }

    public void selectYear() throws Throwable {
        Thread.sleep(3000);
       if(isVisibleOnly(VehicleLookupPage.drpDwnYear, "select year"))
       {
           click(VehicleLookupPage.drpDwnYear, "click on select year");
           Thread.sleep(3000);
           TouchAction tapCoordinates = new TouchAction(appiumDriver);
           tapCoordinates.tap(565,677).perform();
       }


    }
    public void selectMake() throws Throwable {
        Thread.sleep(3000);
       if(isVisibleOnly(VehicleLookupPage.drpDwnMake, "select make"))
       {
           click(VehicleLookupPage.drpDwnMake, "click on select make");
           Thread.sleep(3000);
           TouchAction tapCoordinates = new TouchAction(appiumDriver);
           tapCoordinates.tap(584,418).perform();
       }
    }
    public void selectModel() throws Throwable {
        Thread.sleep(3000);
        if (isVisibleOnly(VehicleLookupPage.drpDwnModel, "select model")) {
            click(VehicleLookupPage.drpDwnModel, "click on select model");
            Thread.sleep(3000);
            TouchAction tapCoordinates = new TouchAction(appiumDriver);
            tapCoordinates.tap(632, 610).perform();
        }

    }

    public void selectVehicleDetails() throws Throwable {
        selectYear();
        selectMake();
        selectModel();
    }

    public void clickOnContinue() throws Throwable {
        selectVehicleDetails();
        Thread.sleep(3000);
        waitForVisibilityOfElement(VehicleLookupPage.btnContinue, "click on continue");
        click(VehicleLookupPage.btnContinue, "click on continue");
        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
            }
        }
