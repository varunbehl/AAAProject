package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class ServicesPage {
    public static By btnSave;
    public static By crossOnTechAssistError;




    static {
        btnSave=By.xpath("//android.view.View[@content-desc='Save']");
        crossOnTechAssistError=By.id("com.aaa.d3itu:id/NotificationInfoCloseButton");
    }
}
