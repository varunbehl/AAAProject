package com.aaa.mobile.page;
import org.openqa.selenium.By;

public class NotificationsPage {
    public static By allowButton;
    public static By denyButton;
    public static By permissionLabel;
    public static By welcomeMessage;
    public static By zipCodePreMessage;
    public static By pushNotificationsLabel;
    public static By yesPushNotificationsLabel;
    public static By noPushNotificationsLabel;
    public static By AAAMobileTitle;
    public static By ignoreReceivedRequest;
    public static By showReceivedRequest;
    public static By yesCancelReq;
    public static By noCancelReq;
    public static By okLabelMapService;
    public static By okUnableToDetect;
    public static By okLabelRequestCancelled;
    public static By okProblemSubmittingReq;
    public static By callAAAProblemSubmittingReq;
    public static By cancelUnableAuthorizeService;
    public static By callAAAUnableAuthorizeService;

    static {
        allowButton = By.id("com.android.packageinstaller:id/permission_allow_button");
        denyButton = By.id("com.android.packageinstaller:id/permission_deny_button");
        permissionLabel = By.id("com.android.packageinstaller:id/permission_message");
        welcomeMessage = By.id("com.aaa.android.discounts:id/tv_welcome_message");
        zipCodePreMessage = By.id("com.aaa.android.discounts:id/tv_pre_message");
        pushNotificationsLabel = By.id("com.aaa.android.discounts:id/md_content");
        yesPushNotificationsLabel = By.id("com.aaa.android.discounts:id/md_buttonDefaultPositive");
        noPushNotificationsLabel = By.id("com.aaa.android.discounts:id/md_buttonDefaultNegative");
        AAAMobileTitle = By.id("com.aaa.android.discounts:id/md_title");
        ignoreReceivedRequest=By.xpath("//android.widget.TextView[contains(@text,'Ignore')]");
        showReceivedRequest=By.xpath("//android.widget.TextView[contains(@text,'Show')]");
       // yesCancelReq = By.id("android:id/button1");
        yesCancelReq = By.xpath("//android.widget.TextView[contains(@text,'Yes')]");

       // noCancelReq = By.id("android:id/button2");
        noCancelReq = By.xpath("//android.widget.TextView[contains(@text,'No')]");

      //  okLabelMapService= By.id("android:id/button3");
        okLabelMapService= By.xpath("//android.widget.Button[contains(@text,'Ok')]");

      //  okUnableToDetect=By.id("android:id/button2");
        okUnableToDetect=By.xpath("//android.widget.Button[contains(@text,'Ok')]");

      //  okLabelRequestCancelled=By.id("android:id/button1");
        okLabelRequestCancelled=By.xpath("//android.widget.Button[contains(@text,'Ok')]");

      //  okProblemSubmittingReq=By.id("android:id/button2");
        okProblemSubmittingReq=By.xpath("//android.widget.Button[contains(@text,'Ok')]");

       // callAAAProblemSubmittingReq=By.id("android:id/button1");
        callAAAProblemSubmittingReq=By.xpath("//android.widget.Button[contains(@text,'CALL AAA')]");

        cancelUnableAuthorizeService=By.xpath("//android.widget.Button[contains(@text,'Cancel')]");
        callAAAUnableAuthorizeService=By.xpath("//android.widget.Button[contains(@text,'CALL AAA')]");




    }
}
