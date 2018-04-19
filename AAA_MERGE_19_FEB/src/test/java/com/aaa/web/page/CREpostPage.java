package com.aaa.web.page;

import org.openqa.selenium.By;

/**
 * Created by E002734 on 2/9/2018.
 */
public class CREpostPage {


	public static By drpdwnHelp;
	public static By lblEpost;
	public static By txtKeybord;
	public static By btnSearchButtonEpost;
	public static By btnClearEpost;
	public static By chkboxMenu;
	public static By chkboxCategories;
	public static By chkboxDetails;
	public static By lblBatteryService;
	public static By lblGeorgia;
	public static By lblElectronicPost;
	public static By listMenuItems;
	public static By listCategories;
	public static By listDetailedInfo;
	public static By highlightDisney;
	public static By highlightDisneyLastCategories;
	public static By btnCloseEpost;
	public static By lblERSoT;
	public static By lblClubCode;
	public static By imgPopout;
	public static By imgPopIn;


	static {


		drpdwnHelp=By.xpath("(//i[contains(@class,'icon-caret-down')])[4]");
		lblEpost=By.xpath("//span[contains(@class,'d3ui-menu-item-label')][text()='E. Post']");
		txtKeybord=By.xpath("//input[@id='electronic-post-search-field']");
		btnSearchButtonEpost=By.xpath("//button[@id='electronic-posting-search-btn']");
		btnClearEpost=By.xpath("//button[@id='electronic-posting-clear-btn']");
		chkboxMenu=By.xpath("//input[@id='electronic-posting-search-menu']");
		chkboxCategories=By.id("electronic-posting-search-categories");
		chkboxDetails=By.xpath("//input[@id='electronic-posting-search-details']");
		//chkboxDetails=By.xpath("//[contains(@for,'electronic-posting-search-details'][text()='Search Details']");
		lblBatteryService=By.xpath("//li[contains(@data-order,'Battery Service Cities')][text()='Battery Service Cities']");
		lblClubCode=By.xpath("//li[contains(@data-order,'Club Codes/Cities/States')][text()='Club Codes/Cities/States']");
		lblERSoT=By.xpath("//li[contains(@data-order,'ERS OT')][text()='ERS OT']");
		lblGeorgia=By.xpath("//li[contains(@data-order,'1')][text()='Georgia']");
		lblElectronicPost=By.xpath(".//span[@id='ui-dialog-title-electronic-posting-window']");
		listMenuItems=By.xpath("//div[@id='electronic-posting-menu-menu']//li");
		listCategories=By.xpath("//div[@id='electronic-posting-categories-menu']//li");
		listDetailedInfo=By.xpath("//div[@id='electronic-posting-text-container']/div");
		highlightDisney=By.xpath("//span[contains(@class,'d3ui-search-highlight')][text()='Disney']");
		highlightDisneyLastCategories=By.xpath("(//span[contains(@class,'d3ui-search-highlight')][text()='Disney'])[last()]");
		btnCloseEpost=By.xpath("//button[@id='electronic-post-footer-close-btn']");
		imgPopout=By.xpath("//span[contains(@class,'ui-icon ui-icon-arrowthick-1-ne panel-pop-out')][text()='Pop-Out']");
		imgPopIn=By.xpath("//*[contains(@class,'ui-icon ui-icon-arrowthick-1-sw panel-pop-in')][text()='Pop-In']");

	}



}
