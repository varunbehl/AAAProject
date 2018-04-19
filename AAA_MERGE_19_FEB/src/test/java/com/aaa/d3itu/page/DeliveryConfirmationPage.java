package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class DeliveryConfirmationPage {
    public static By btnContinue;
    public static By txtStatusUpdate;




    static {
        btnContinue=By.xpath("//android.view.View[@content-desc='Continue']");
        txtStatusUpdate =By.id("com.aaa.d3itu:id/NotificationSuccessText");

    }
}
