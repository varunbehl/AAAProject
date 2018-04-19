package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class CallsPage {
    public static By assignCallToTruck;
    public static By nextStatus;
    public static By statusDI;
    public static By statusER;
    public static By statusOL;
    public static By statusAS;
    public static By assignTruckAccept;
    public static By  callAsSP;
    public static By  txtNewCall;
    public static By  btnOkOnNewCallPopup;
    public static By  firstElement;
    public static By  assignedCallPopup;
    public static By  errorPopup;
    public static By  errorPopupMsg;
    public static By  okOnErrorPopup;




    static {
        assignCallToTruck = By.xpath("//android.view.View[@content-desc='Assign Call to Truck']");
        nextStatus=By.xpath("//android.view.View[@content-desc='Next Status']");
        statusDI=By.xpath("//android.view.View[@content-desc='DI']");
        statusAS=By.xpath("//android.view.View[@content-desc='AS']");
        statusER=By.xpath("//android.view.View[@content-desc='ER']");
        statusOL=By.xpath("//android.view.View[@content-desc='OL']");
        assignTruckAccept=By.xpath("//android.view.View[@content-desc='Accept']");
        callAsSP=By.xpath("//android.view.View[@content-desc='SP']");
        txtNewCall=By.xpath("//android.widget.TextVeiw[@text='New Call']");
        btnOkOnNewCallPopup=By.xpath("//android.widget.Button[@text='OK']");
        firstElement=By.className("android.view.View");
        assignedCallPopup=By.id("com.aaa.d3itu:id/PriorityDialogText");
        errorPopup=By.id("com.aaa.d3itu:id/ErrorTitle");
        errorPopupMsg=By.id("com.aaa.d3itu:id/ErrorDialogText");
        okOnErrorPopup=By.id("com.aaa.d3itu:id/ErrorDialogOkButton");
    }
}
