/**
 * 12/27/2017 Created by Neil McCormick
 * This is the page object definitions Menu Bar page 
 * for the RSO redesign app.
 */
package com.aaa.mobile.rsoredesign.page;

import org.openqa.selenium.By;

public class StandaloneMenuBarPage {
	public static By CallAAA;
	public static By Title;
	public static By BackButton;
	
	/**
	 * Method Name: initialize
	 * Description: Receives a string detailing the platform name in which the test is running.
	 * Based on the platform it will decide how to initialize the PageObject Factory.
	 * @param platform
	 */
	public static void initialize(String platform){
		
		if(platform.equals("iOS"))
		{
			BackButton = By.id("Back");
			CallAAA = By.id("");//RSO-46 - Missing Call AAA button.
			Title = By.id("");
		}
		if(platform.equals("Android")){
			CallAAA = By.id("Call AAA");
			BackButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton");
			Title = By.xpath("	/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView");
		}
	}
}
