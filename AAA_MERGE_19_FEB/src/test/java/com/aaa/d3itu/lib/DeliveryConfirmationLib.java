package com.aaa.d3itu.lib;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.*;

import java.util.Hashtable;

import io.appium.java_client.TouchAction;
import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.LoginPage;

public class DeliveryConfirmationLib extends ActionEngineMobile {
    public ITestContext testcontext;

    public void setTestContext(ITestContext testContext) {
        this.testcontext = testContext;

    }

    public void getStatusUpdate() throws Throwable {
       if(isVisibleOnly(DeliveryConfirmationPage.txtStatusUpdate, "get the status"))
       {
           getText(DeliveryConfirmationPage.txtStatusUpdate, "get the status");
       }
    }

    public void clickOnContinue() throws Throwable {
        if(isVisibleOnly(DeliveryConfirmationPage.btnContinue, "click on continue"))
        {
            click(DeliveryConfirmationPage.btnContinue, "click on continue");
        }

    }
}