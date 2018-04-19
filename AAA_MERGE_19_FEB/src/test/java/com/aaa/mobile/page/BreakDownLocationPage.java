package com.aaa.mobile.page;

import org.openqa.selenium.By;

public class BreakDownLocationPage {
    public static By aaaLogo;
    public static By historyButton;
    public static By ersAdvisoryButton;
    public static By enterBreakdownLocation;
    public static By callAAA;
    public static By setBreakdownLocation;
    public static By breakdownLocation;
    public static By allowDeviceLocation;
    public static By addressBarField;
    public static By selectAddressFromList;
    public static By addressErrorOkButton;
    public static By addressIcon;
    public static By addressArrow;
    public static By activeRequestTitle;
    public static By activeRequestNotification;
    
	static {
        //aaaLogo = By.xpath("(//android.widget.ImageView)[1]");
        aaaLogo =  By.xpath("(//android.widget.ImageView[contains(@text,'AAALogo')]");

        historyButton = By.id("com.aaa.android.discounts:id/ers_history_button");
        ersAdvisoryButton = By.id("com.aaa.android.discounts:id/ers_advisory_button");
        activeRequestTitle = By.id("com.aaa.android.discounts:id/ers_service_history_title");

        activeRequestNotification=By.xpath("(//android.widget.TextView)[4]");

        setBreakdownLocation = By.id("com.aaa.android.discounts:id/ers_map_pin_pill");

        breakdownLocation = By.xpath("(//android.widget.ImageView)[0]");

        enterBreakdownLocation = By.id("com.aaa.android.discounts:id/search_src_text");
        allowDeviceLocation=By.id("com.android.packageinstaller:id/permission_allow_button");
        addressBarField=By.id("com.aaa.android.discounts:id/search_src_text");

       selectAddressFromList=By.xpath("(//android.widget.ImageView)[6]");
       //selectAddressFromList=By.xpath("(//android.widget.ImageView)[5]");

      //  addressErrorOkButton=By.xpath("//android.widget.Button[contains(@text,'Ok')]");
        addressErrorOkButton=By.id("android:id/button1");
        addressArrow=By.id("com.aaa.android.discounts:id/search_mag_icon");

       addressIcon=By.id("com.aaa.android.discounts:id/search_button");

	}
}




