package com.aaa.web.page;

import org.openqa.selenium.By;

/**
 * Created by E002734 on 2/13/2018.
 */
public class CRDispatcherUpdatePage {

	public static By lblStatus;
	public static By lblReasonForStatus;
	public static By lblFacility;
	public static By lblTruck;
	public static By lblTechnician;
	public static By lblDate;
	public static By lblTime;
	public static By btnUpdate;
	public static By btnCancel;
	public static By lblBoldStatus;
	public static By lblBoldDispatchingInfo;
	public static By lblBoldTimestamp;
	public static By lblBoldCancel;
	public static By lblDispatcherUpdateStatusPanel;
	public static By txtFacilityId;
	public static By txtCommentData;
	public static By txtReasonForStatus;
	public static By lblBoldComments;
	public static By txtStatus;
	public static By txtDate;
	public static By txtTime;
	public static By drpStatus;
	public static By drpReasonStatus;
	public static By drpFacility;
	public static By drpTruck;
	public static By statusList;
	public static By txtTruckId;
	public static By lblErrorUpdateCode;
	public static By txtFacilityNotEditable;
	public static By lblErrorOk;


	static {

		lblStatus=By.xpath("//label[contains(@for,'dsu-status')][text()='Status:']");
		lblReasonForStatus=By.xpath("//label[contains(@for,'dsu-reason')][text()='Reason For Status:']");
		lblFacility=By.xpath("//label[contains(@for,'dsu-facility')][text()='Facility:']");
		lblTruck=By.xpath("//label[contains(@for,'dsu-truck')][text()='Truck:']");
		lblTechnician=By.xpath("//label[contains(@for,'dsu-driver')][text()='Technician:']");
		lblDate=By.xpath("//label[contains(@for,'dsu-override-date')][text()='Date:']");
		lblTime=By.xpath("//label[contains(@for,'dsu-override-time')][text()='Time:']");
		btnUpdate=By.xpath("//span[contains(@class,'ui-button-text')][text()='Update']");
		btnCancel=By.xpath("(//span[contains(@class,'ui-button-text')][text()='Cancel'])[5]");
		lblBoldStatus=By.xpath("//legend[text()='Status:']");
		lblBoldDispatchingInfo=By.xpath("//legend[text()='Dispatching Information:']");
		lblBoldTimestamp=By.xpath("//legend[text()='Timestamp Override:']");
		lblBoldComments=By.xpath("//legend[text()='Comments:']");
		lblBoldCancel=By.xpath("//legend[text()='Comments:']");
		lblDispatcherUpdateStatusPanel=By.xpath(".//span[@id='ui-dialog-title-dispatcher-panel']");
		txtFacilityId=By.xpath("//input[@id='dsu-facility']");
		txtCommentData=By.xpath("//textarea[@id='dsu-comments']");
		txtReasonForStatus=By.xpath("//input[@id='dsu-reason']");
		txtStatus=By.xpath("//input[@id='dsu-status']");
		txtDate=By.xpath("//input[@id='dsu-override-date']");
		txtTime=By.xpath("//input[@id='dsu-override-time']");
		drpStatus=By.xpath("(//div[@id='dispatcher-panel']//span[text()='View Options'])[1]");
		drpReasonStatus=By.xpath("(//div[@id='dispatcher-panel']//span[text()='View Options'])[2]");
		drpFacility=By.xpath("(//div[@id='dispatcher-panel']//span[text()='View Options'])[3]");
		drpTruck=By.xpath("(//div[@id='dispatcher-panel']//span[text()='View Options'])[4]");
		statusList=By.xpath("//ul[contains(@class,'ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all')]//li");
        txtTruckId=By.xpath("//input[@id='dsu-truck']");
		lblErrorUpdateCode=By.xpath("//div[contains(@class,'formErrorContent')][text()='This field is required for update']");
		txtFacilityNotEditable=By.xpath("(//input[contains(@class,'ui-autocomplete-input ui-corner-left')][contains(@readonly,'readonly')])[3]");
		lblErrorOk=By.xpath("//span[contains(@class,'ui-button-text')][text()='OK']");



	}
}
