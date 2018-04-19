package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class PacesetterResolutionPage {
    public static By towProblemKeys;
    public static By txttow;
    public static By txtTires;
    public static By tiresProblemKeys;
    public static By noServiceProblemKeys;
    public static By txtNoService;
    public static By batteryProblemKeys;
    public static By txtBattery;
    public static By fuelProblemKeys;
    public static By txtFuel;
    public static By extricationProblemKeys;
    public static By txtExtrication;
    public static By keysProblemKeys;
    public static By txtKeys;
    public static By miscellaneousProblemKeys;
    public static By txtMiscellaneous;






    static {
        towProblemKeys=By.xpath("//android.view.View[contains(@content-desc,'Overheated')]");
        txttow=By.xpath("//android.view.View[contains(@content-desc,'Tow')][1]");
        txtTires=By.xpath("//android.view.View[contains(@content-desc,'Tires')][1]");
        tiresProblemKeys=By.xpath("//android.view.View[contains(@content-desc,'Air-Up Tire Only')]");
        noServiceProblemKeys=By.xpath("//android.view.View[contains(@content-desc,'NSR - No Car And No Member')]");
        txtNoService=By.xpath("//android.view.View[contains(@content-desc,'No Service')][1]");
        txtBattery=By.xpath("//android.view.View[contains(@content-desc,'Battery')][1]");
        batteryProblemKeys=By.xpath("//android.view.View[contains(@content-desc,'Jump Start')]");
        txtFuel=By.xpath("//android.view.View[contains(@content-desc,'Fuel')][1]");
        fuelProblemKeys=By.xpath("//android.view.View[contains(@content-desc,'Fuel Delivery - Gasoline')]");
        txtExtrication=By.xpath("//android.view.View[contains(@content-desc,'Extrication')][1]");
        extricationProblemKeys=By.xpath("//android.view.View[contains(@content-desc,'Extrication Only')]");
        txtKeys=By.xpath("//android.view.View[contains(@content-desc,'Keys')][1]");
        keysProblemKeys=By.xpath("//android.view.View[contains(@content-desc,'Unlock Vehicle')]");
        txtMiscellaneous=By.xpath("//android.view.View[contains@content-desc,'Miscellaneous')][1]");
        miscellaneousProblemKeys=By.xpath("//android.view.View[contains(@content-desc,'Top-Up Coolant Only')]");


    }
}
