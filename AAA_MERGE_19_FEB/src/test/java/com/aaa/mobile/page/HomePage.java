package com.aaa.mobile.page;
import org.openqa.selenium.By;

public class HomePage {
    public static By MenuButton;
    public static By aaaLogo;
    public static By HomeLabel;
    public static By autoRefreshButton;
    public static By loginButton;
    public static By aaaMaps;
    public static By roadSideAssisstanceLabel;
    public static By roadSideAssisstanceWithoutActiveRequest;
    public static By joinAAA;
    public static By batteyQuote;
 	public static By realTimeJoin;
    public static By hamburgerButton;
    public static By activeRequestLabel;
    public static By firstAndLastName;
    public static By redRoadsideAssitance;


    static {
        MenuButton = By.className("android.widget.ImageButton");
        aaaLogo = By.className("android.widget.ImageView");
        HomeLabel = By.xpath("//android.widget.TextView[@text='Home']");
        autoRefreshButton = By.id("com.aaa.android.discounts:id/menu_refresh_cards");
        loginButton = By.id("com.aaa.android.discounts:id/menu_login");
        aaaMaps = By.xpath("//android.widget.TextView[@text='AAA Maps']");

        roadSideAssisstanceLabel = By.xpath("(//android.widget.ImageView)[6]");
      // roadSideAssisstanceLabel = By.xpath("(//android.widget.ImageView[contains(@text,'Roadside Assistance')]");

        joinAAA = By.xpath("//android.widget.TextView[@text='Join AAA']");
        batteyQuote = By.xpath("//android.widget.TextView[@text='Battery Quote']");
        realTimeJoin = By.xpath("//android.widget.TextView[@text='Real Time Join']");

        hamburgerButton = By.xpath("(//android.widget.ImageButton)[1]");

        activeRequestLabel=By.xpath("//android.widget.TextView[@text='Active Request']");

       roadSideAssisstanceWithoutActiveRequest= By.xpath("(//android.widget.ImageView)[4]");
       // roadSideAssisstanceWithoutActiveRequest = By.xpath("(//android.widget.ImageView[contains(@text,'Roadside Assistance')]");

        firstAndLastName=By.xpath("//android.widget.TextView[@text='Regina Haskin']");
        redRoadsideAssitance= By.xpath("//android.widget.TextView[@text='Roadside Assistance']");


	}
}


  