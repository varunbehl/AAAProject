package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class LoginPage {
    public static By userName;
    public static By password;
    public static By login;
   

    static {
    	/*userName = By.id("login-username-input");
    	password = By.className("login-password-input");
    	login = By.xpath("//android.view.View[@text='Login']");*/

        userName =By.xpath("//android.widget.EditText[@text='Username:']");
        password =By.xpath("//android.widget.EditText[@text='Password:']");
        login = By.xpath("(//android.view.View[@text='Login'])[2]");
       
    }
}




