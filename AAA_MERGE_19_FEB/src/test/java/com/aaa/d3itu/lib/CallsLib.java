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

public class CallsLib extends ActionEngineMobile {
    public ITestContext testcontext;

    public void setTestContext(ITestContext testContext) {
        this.testcontext = testContext;

    }
    PacesetterResolutionLib pacesetterResolutionlib =new PacesetterResolutionLib();
    VehicleLookupLib vehicleLookuplib = new VehicleLookupLib();
    ServicesLib serviceslib =new ServicesLib();
    DeliveryConfirmationLib deliveryConfirmationlib =new DeliveryConfirmationLib();
    AssignTruckLib assignTrucklib = new AssignTruckLib();


    public void clickOnAssignTruckAccept() throws Throwable {
        waitForVisibilityOfElement(CallsPage.assignTruckAccept, "click accept to assign truck ");
        click(CallsPage.assignTruckAccept, "click accept to assign truck");

    }

    public void getAssignStatus() throws Throwable {
        waitForVisibilityOfElement(CallsPage.statusAS, "get assign status");
        getText(CallsPage.statusAS, "Status is on assign state");

    }

    public void clickOnAssignCallToTruck() throws Throwable {
        waitForVisibilityOfElement(CallsPage.assignCallToTruck, "click on assign call to truck");
        click(CallsPage.assignCallToTruck, "click on assign call to truck");

    }


    public void getDispatchStatus() throws Throwable {
        waitForVisibilityOfElement(CallsPage.statusDI, "get dispatch status");
        getText(CallsPage.statusDI, "Status is on dispatch state");

    }

    public void clickOnNextStatus() throws Throwable {
        if(isVisibleOnly(CallsPage.nextStatus, "click on next status")) {
            click(CallsPage.nextStatus, "click on next status");
        }

    }

    public void getEnRouteStatus() throws Throwable {
        waitForVisibilityOfElement(CallsPage.statusER, "get enroute status");
        getText(CallsPage.statusER, "Status is on enroute state");

    }

    public void getOnLocationStatus() throws Throwable {
        waitForVisibilityOfElement(CallsPage.statusOL, "get on Location status");
        getText(CallsPage.statusOL, "Status is on Location state");

    }

    public void clickOkOnErrorPopup() throws Throwable {
        if(isVisibleOnly(CallsPage.errorPopup, "Error Popup"))
        {
            getText(CallsPage.errorPopupMsg, "Error Popup Msg");
            click(CallsPage.okOnErrorPopup, "Click on ok error popup");
        }
    }


    public void clickOnCallToClear() throws Throwable {
           waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
           // Thread.sleep(10000);
            Thread.sleep(2000);
            clickOkOnNewCallPopup();
           if(isVisibleOnly(CallsPage.callAsSP, "click on call"))
           {
            click(CallsPage.callAsSP, "click on call");
           }
           else
           {
            appiumDriver.scrollTo("SP");
            Thread.sleep(2000);
            waitForVisibilityOfElement(CallsPage.callAsSP, "click on call");
            click(CallsPage.callAsSP, "click on call");
            }
            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
           }

    public void clickOkOnNewCallPopup() throws Throwable {
     //   Thread.sleep(12000);
        waitForVisibilityOfElement(CallsPage.btnOkOnNewCallPopup, "call");
        getText(CallsPage.assignedCallPopup, "call");
        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
        click(CallsPage.btnOkOnNewCallPopup, "click on ok");

    }


    public void statusUpdateAsAs(String StatusUpdateAs) throws Throwable {
        if (waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner")) {
            if (StatusUpdateAs.equalsIgnoreCase("AS")) {
                Thread.sleep(2000);
                clickOnAssignCallToTruck();
                assignTrucklib.clickOnAssignTruck();
                clickOkOnNewCallPopup();
                getAssignStatus();
            }
        }
    }
    public void statusUpdateAsAssignment(String Assignmnet) throws Throwable {
        if (Assignmnet.equalsIgnoreCase("accept")) {
            clickOnAssignTruckAccept();
            waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");

        }
    }

    public void statusUpdateAsDI(String StatusUpdateDI) throws Throwable {
          waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
            if (StatusUpdateDI.equalsIgnoreCase("DI")) {
                waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                getDispatchStatus();
                clickOkOnErrorPopup();
                clickOnNextStatus();
                waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");

            }
        }



    public void statusUpdateAsER(String statusUpdateAsER) throws Throwable {
          waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
            if (statusUpdateAsER.equalsIgnoreCase("ER")) {
                waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                getEnRouteStatus();
                clickOkOnErrorPopup();
                clickOnNextStatus();
                waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");

            }
        }

    public void statusUpdateAsOL(String statusUpdateAsOL) throws Throwable {
        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
            if (statusUpdateAsOL.equalsIgnoreCase("OL")) {
                waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
                getOnLocationStatus();
                clickOnNextStatus();
                waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");

            }
        }

    public void statusUpdateAsTW(String statusUpdateAsTW) throws Throwable {
         waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
            if (statusUpdateAsTW.equalsIgnoreCase("TW")) {
                clickOnNextStatus();
                waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
            }
        }

    public void statusUpdateAsCL(String statusUpdateAsCL) throws Throwable {
        waitForInVisibilityOfElement(LaunchPage.spinner, "Spinner");
            if (statusUpdateAsCL.equalsIgnoreCase("CL")) {
                clickOnNextStatus();
                clickOnNextStatus();
                pacesetterResolutionlib.clickOnProblemKeys();
                vehicleLookuplib.clickOnContinue();
                deliveryConfirmationlib.clickOnContinue();
                serviceslib.clickOnSave();
                Thread.sleep(2000);
                deliveryConfirmationlib.getStatusUpdate();
            }
        }
    }

