package com.aaa.d3itu.lib;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.*;

import java.util.Hashtable;

import io.appium.java_client.TouchAction;
import org.testng.ITestContext;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.d3itu.page.LoginPage;

public class ServicesLib extends ActionEngineMobile {
    public ITestContext testcontext;

    public void setTestContext(ITestContext testContext) {
        this.testcontext = testContext;

    }

    public void clickOnSave() throws Throwable {
        if(isVisibleOnly(ServicesPage.crossOnTechAssistError, "Cross Mark"))
        {
            click(ServicesPage.crossOnTechAssistError, "Click on Cross Mark");
        }
        waitForVisibilityOfElement(ServicesPage.btnSave, "click on save");
        click(ServicesPage.btnSave, "click on save");
    }

}
