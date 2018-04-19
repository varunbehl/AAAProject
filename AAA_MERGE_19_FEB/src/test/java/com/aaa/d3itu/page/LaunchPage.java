package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class LaunchPage {
    public static By environment;
    public static By submit;
    public static By spinner;

   

    static {
    	//environment = By.className("android.widget.EditText");
        environment = By.xpath("//android.widget.EditText[@text='Club Alias']");
    	//submit = By.className("android.widget.Button");
        submit = By.xpath("//android.widget.Button");
        spinner=By.id("com.aaa.d3itu:id/progressBar2");
    }
}





