package com.aaa.mobile.lib;
import java.util.Hashtable;

import com.aaa.mobile.page.BreakDownLocationPage;
import org.testng.ITestContext;
import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.page.NotificationsPage;

public class NotificationsLib extends ActionEngineMobile {
	public ITestContext testcontext;

	public void setTestContext(ITestContext testContext) {
		this.testcontext = testContext;
	}
	
	/**
	 *methodName : verifyPermissionLabel
	 *description: verify the permission label
	 *param
	 * throws Throwable
	 */	
	public boolean verifyPermissionLabel() throws Throwable {
		boolean permissionMessage = false;
		permissionMessage = isElementPresent(NotificationsPage.permissionLabel, "Permission Message", true);
		if (permissionMessage){
			permissionMessage = true;
		}
		return permissionMessage;
	}
	
	/**
	 *methodName : verifyPushNotificationsLabel
	 *description: verify the push notifications label
	 *param
	 * throws Throwable
	 */	
	public boolean verifyPushNotificationsLabel() throws Throwable {
		boolean verifyPushNotifications = false;
		waitForVisibilityOfElement(NotificationsPage.pushNotificationsLabel, "push Notifications Message");
		verifyPushNotifications = isElementPresent(NotificationsPage.pushNotificationsLabel, "push Notifications Message", true);
		return verifyPushNotifications;				
	}
	
	/**
	 *methodName : clickAllowPermissions
	 *description: click on allow permissions
	 *param
	 * throws Throwable
	 */	
	public void clickAllowPermissions() throws Throwable {
		waitForVisibilityOfElement(NotificationsPage.allowButton, "Allow Permissions");
		click(NotificationsPage.allowButton,"Allow Permissions");
	}
	
	/**
	 *methodName : yesPushNotificationsLabel
	 *description: Click on yes Push Notifications
	 *param
	 * throws Throwable
	 */	
	public void yesPushNotificationsLabel() throws Throwable {
		waitForVisibilityOfElement(NotificationsPage.yesPushNotificationsLabel, "Allow Push Notifications");
		click(NotificationsPage.yesPushNotificationsLabel,"yes allow Push Notifications");
        Thread.sleep(3000);
	}

	/**
	 *methodName : clickCancelReqAndOk
	 *description: Click on CancelReq and then on ok followed by ok on cancel request
	 *param
	 * throws Throwable
	 */
	public void clickCancelReqAndOk() throws Throwable {
		waitForVisibilityOfElement(NotificationsPage.yesCancelReq, "click on CancelReq Yes");
		click(NotificationsPage.yesCancelReq, "click on CancelReq Yes");
        Thread.sleep(5000);
		click(NotificationsPage.okLabelMapService, "click on MapServiceOkLabel");
		Thread.sleep(2000);
		click(NotificationsPage.okUnableToDetect, "click on unableToDetectOk");
		Thread.sleep(2000);
		click(NotificationsPage.okLabelRequestCancelled, "click on requestCancelledOkLabel");

	}
	/**
	 *methodName : clickUntillOkDisappears
	 *description: click Untill Ok Disappears
	 *param
	 * throws Throwable
	 */
	public void clickUntillOkDisappears()throws Throwable {
		waitForVisibilityOfElement(NotificationsPage.allowButton,"Allow Permissions");
		click(BreakDownLocationPage.allowDeviceLocation, "allow Device Location");
		Thread.sleep(3000);
		int count = 0;
		do {
			if (!waitForElementPresent(BreakDownLocationPage.addressErrorOkButton, "address error ok", 10)) {
				break;
			} else {
				click(BreakDownLocationPage.addressErrorOkButton, "address error ok");
			}
		} while (count <= 3);
		if (count >= 3) {
			reporter.failureReport("address error ok", "Exceeded the max '3' trails");
		}
	}


	/**
	 *methodName : clickignoreReceivedRequest
	 *description: click ignore Received Request
	 *param
	 * throws Throwable
	 */
	public void clickignoreReceivedRequest() throws Throwable {
		waitForVisibilityOfElement(NotificationsPage.ignoreReceivedRequest, "ignore Received Request");
		click(NotificationsPage.ignoreReceivedRequest,"click ignore Received Request");
	}

	/**
	 *methodName : clickshowReceivedRequest
	 *description: click show Received Request
	 *param
	 * throws Throwable
	 */
	public void clickshowReceivedRequest() throws Throwable {
		waitForVisibilityOfElement(NotificationsPage.showReceivedRequest, "show Received Request");
		click(NotificationsPage.showReceivedRequest,"click show Received Request");
	}

	/**
	 *methodName : clickunableAuthorizeServiceCancel
	 *description: click unable Authorize Service Cancel
	 *param
	 * throws Throwable
	 */
	public void clickunableAuthorizeServiceCancel() throws Throwable {
		waitForVisibilityOfElement(NotificationsPage.cancelUnableAuthorizeService, "unable Authorize Service Cancel");
		click(NotificationsPage.cancelUnableAuthorizeService,"click unable Authorize Service Cancel");
	}

	/**
	 *methodName : clickunableAuthorizeServiceCallAAA
	 *description: click unable Authorize Service CallAAA
	 *param
	 * throws Throwable
	 */
	public void clickunableAuthorizeServiceCallAAA() throws Throwable {
		waitForVisibilityOfElement(NotificationsPage.callAAAUnableAuthorizeService, "unable Authorize Service CallAAA");
		click(NotificationsPage.callAAAUnableAuthorizeService,"click unable Authorize Service CallAAA");
	}
}
