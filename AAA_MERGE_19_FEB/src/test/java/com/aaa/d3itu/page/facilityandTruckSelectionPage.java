package com.aaa.d3itu.page;
import org.openqa.selenium.By;

public class facilityandTruckSelectionPage {
    public static By truckP;
    public static By truckW;
    public static By truckX;
    public static By continueButton;
    public static By facilityDetails;
    
   

    static {
    	/*truckP = By.xpath("//*android.view.View[@text='P'] and [contains(@id,'result')]");
    	truckW = By.xpath("//*android.view.View[@text='W'] and [contains(@id,'result')]");
    	truckX = By.xpath("//*android.view.View[@text='X'] and [contains(@id,'result')]");
    	continueButton = By.xpath("//*android.view.View[@text='Continue']");
    	facilityDetails = By.className("android.widget.Spinner");*/

        truckP = By.xpath("//android.view.View[@content-desc='P']");
        truckW = By.xpath("//android.view.View[@content-desc='W']");
        truckX = By.xpath("//android.view.View[@content-desc='X']");
        continueButton = By.xpath("//android.view.View[@content-desc='Continue']");
        facilityDetails = By.className("android.widget.Spinner");
       
    }
}





