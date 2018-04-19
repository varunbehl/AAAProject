package com.aaa.mobile.page;

import org.openqa.selenium.By;

public class RSOWebHomePage {
	public static By clubCode;
	public static By goButton;
	public static By signOut;
	public static By giftMembershiPopCrossMark;	
	public static By feedbackPopCrossMark;
	static
	{
		clubCode=By.id("zipCode");
		goButton=By.id("goButton");
		signOut=By.id("ctl00_HeaderMenus_StaticLoginView_LogOutHyperlink");
		giftMembershiPopCrossMark=By.id("membershipsale-close-container");
		feedbackPopCrossMark=By.className("acsClassicInner");
	}
}
