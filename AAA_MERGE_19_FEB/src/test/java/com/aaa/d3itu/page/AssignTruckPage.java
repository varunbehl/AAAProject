package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class AssignTruckPage {

    public static By assignTruckP;
    public static By assignTruckW;
    public static By assignTruckX;


    static {
        assignTruckP=By.xpath("//android.view.View[contains(@content-desc,'5140/P')]");
        assignTruckW=By.xpath("//android.view.View[contains@content-desc,'5140/W']");
        assignTruckX=By.xpath("//android.view.View[contains@content-desc,'5140/X']");

    }
}
