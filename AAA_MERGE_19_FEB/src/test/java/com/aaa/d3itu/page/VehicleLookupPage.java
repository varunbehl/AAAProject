package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class VehicleLookupPage {
    public static By btnContinue;
    public static By drpDwnYear;
    public static By drpDwnMake;
    public static By drpDwnModel;
    public static By drpDwnEngine;
    public static By drpDwnTransmission;
    public static By drpDwnDriveline;
    public static By vehicleYear;
    public static By vehicleMake;
    public static By vehicleModel;
    public static By vehicleEngine;
    public static By vehicleTransmission;
    public static By vehicleDriveline;




    static {
        btnContinue=By.xpath("//android.view.View[@content-desc='Continue']");
        drpDwnYear =By.xpath("//android.widget.Spinner[@content-desc='Select Year']");
        drpDwnMake =By.xpath("//android.widget.Spinner[@content-desc='Select Make']");
        drpDwnModel=By.xpath("//android.widget.Spinner[@content-desc='Select Model']");
        drpDwnEngine =By.xpath("//android.widget.Spinner[@content-desc='Select Engine']");
        drpDwnTransmission =By.xpath("//android.widget.Spinner[@content-desc='Select Transmission']");
        drpDwnDriveline =By.xpath("//android.widget.Spinner[@content-desc='Select Driveline']");
        vehicleYear= By.className("android.view.View");
        vehicleMake=By.className("android.view.View");
        vehicleModel=By.className("android.view.View");
        vehicleEngine=By.className("android.view.View");
        vehicleTransmission=By.className("android.view.View");
        vehicleDriveline=By.className("android.view.View");
    }
}
