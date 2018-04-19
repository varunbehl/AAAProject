package com.aaa.web.page;

import org.openqa.selenium.By;

public class DISearchCallsPage {
	
    public static By txtMemberNumberinSearchCall;
    public static By btnSearchinSearchCall;
    public static By SelectRowsFromSearchCallTable;
    public static By selectSPStatusRow;
    public static By btnCallIDinSearchCall;
	public static By ddlClubinSearchCall;
	public static By callIdFromResultsRecordsinProfileTab;
	public static By callIdinProfileTab;
	public static By SelectFirstRow;
	public static By selectCallStatus;
	public static By startDate;
	public static By endDate;
	public static By selectOddRow;
	public static By callIDAndDateInSearclCallWindow;
	public static By txtMessageNoDataAvailableForSearchResults;
	public static By txtStartTime;
	public static By txtEndTime;
	public static By txtRAPNumber;
	public static By RAPOnSearchCallsInSearclCallWindow;
	public static By txtFacility;
	public static By txtTruck;
	public static By txtCallTaker;
	public static By clickOnCallIdLinkInSearchCalls;
	public static By txtCallTakerOnMCDWindow;
	public static By txtPhoneNumber;
	public static By txtClubCode;
	public static By ClubNumberOnSearchCallsInSearclCallWindow;
	public static By btnCloseSearchCalWindowbtnCloseSearchCalWindow;
	public static By btnCloseSearchCallsWindow;
	public static By lblNoMatchingRecordsFound;
	public static By txtMemberLastNameSearch;
	public static By MemberLastNameOnSearchCallsInSearclCallWindow;
	public static By txtMemberNumberSearch;
	public static By MemberNumberOnSearchCallsInSearclCallWindow;
	public static By txtYearVehicleInformation;
	public static By txtMakeVehicleInformation;
	public static By txtModelVehicleInformation;
	public static By FacilityDetailsOnSearchCallsInSearclCallWindow;
	public static By TruckIDDetailsOnSearchCallsInSearclCallWindow;
	public static By txtCity;
	public static By linkCallSummaryIconOnMemberspage;
	public static By phoneNumberOnCallSummaryPOPUp;
	public static By lblDateandTimeInMemberPage;
	public static By VehicleInfoOnSearchCallsInSearclCallWindow;
	public static By txtLocation;
	public static By CityOnSearchCallsInSearclCallWindow;
	public static By txtNoRecordsfoundOnSearchCalls;
	public static By btnSearchCallsSPP;
	public static By txtStatusInSearchCalls;
	public static By lblClearedCallRow;
	public static By selectClearCallStatusRow;

	public static By txtCommCenter;
	public static By lnkFirstCallIdInSearchResults;
	public static By btnClearOnSearchCalls;
	public static By lblInvalidSearchCriteriaErrorForDate;
	public static By btnSearchAgain;
	public static By lblFacilityOnSearchCallsTable;
	public static By lblMemberAndClubCodeOnSearchCallsTable;
	public static By txtMemberFirstNameSearch;
	public static By CallType;
	public static By drpdwnCallType;


	static {
	    txtMemberNumberinSearchCall = By.id("call-search-member-number");
	    btnSearchinSearchCall = By.id("call-search-search-button");
	    SelectRowsFromSearchCallTable = By.id("call-search-results-table");
	    selectSPStatusRow = By.xpath("//*[contains(@class,'d3ui-icon-status-SP')]");
	    btnCallIDinSearchCall = By.id("call-search-call-id");
		ddlClubinSearchCall=By.xpath("//*[@id=\"calldetails-tab-summary\"]/div/div[2]/fieldset[1]/div[2]/div[1]/span");
		callIdFromResultsRecordsinProfileTab=By.cssSelector("div[id='profile-tab-data-display'] div[class*='d3ui-datagrid-row profile-data-call-row profile-child-row']");
		callIdinProfileTab =By.id("profile_callid");//This is to select CallId  under profile menu
		SelectFirstRow = By.xpath("//*[@id='search-results']/tbody/tr");
		selectCallStatus = By.id("call-search-call-status");
		startDate = By.id("call-search-start-date");	
		endDate = By.id("call-search-end-date");
		selectOddRow = By.xpath("//*[contains(@class,'odd call-search-result row-selected')]");

		callIDAndDateInSearclCallWindow=By.cssSelector("table[id='call-search-results-table'] tbody tr[id*='call-'] td:nth-child(2)");
		txtMessageNoDataAvailableForSearchResults= By.xpath("//*[@class='odd lastsearchrecord']//*[contains(text(),'No matching records found, try refining your search')]");
		txtStartTime=By.id("call-search-start-time");
		txtEndTime=By.id("call-search-end-time");
		txtRAPNumber=By.id("call-search-rap-number");
		RAPOnSearchCallsInSearclCallWindow=By.cssSelector("table[id='call-search-results-table'] tbody tr[id*='call-'] td:nth-child(9)");
		txtFacility=By.id("call-search-facility");
		txtTruck=By.id("call-search-truck");
		txtCallTaker=By.id("call-search-call-taker");
		clickOnCallIdLinkInSearchCalls=By.cssSelector("table[id='call-search-results-table'] tbody tr[id*='call-'] a");
		txtCallTakerOnMCDWindow=By.xpath("//div[@id='mcd-call-header']/span/span[2]/span/span/span[2]/span");
		txtPhoneNumber=By.id("call-search-phone");
		txtClubCode=By.id("call-search-club-code");
		ClubNumberOnSearchCallsInSearclCallWindow=By.cssSelector("table[id='call-search-results-table'] tbody tr[id*='call-'] td:nth-child(5)");
		//btnCloseSearchCalWindow=By.xpath("//button[@id='call-search-close-btn']/span[2]");
		lblNoMatchingRecordsFound = By.xpath("//table[@id='call-search-results-table']//td[@class='dataTables_empty']");
		btnCloseSearchCallsWindow = By.id("call-search-close-btn");
		txtMemberLastNameSearch =By.xpath("//*[@id='call-search-last-name']");
		MemberLastNameOnSearchCallsInSearclCallWindow=By.cssSelector("table[id='call-search-results-table'] tbody tr[id*='call-'] td:nth-child(5)");
		txtMemberNumberSearch=By.xpath("//*[@id='call-search-member-number']");
		MemberNumberOnSearchCallsInSearclCallWindow=By.cssSelector("table[id='call-search-results-table'] tbody tr[id*='call-'] td:nth-child(5)");
		txtYearVehicleInformation=By.id("call-search-vehicle-year");
		txtMakeVehicleInformation=By.id("call-search-vehicle-make");
		txtModelVehicleInformation=By.id("call-search-vehicle-model");
		FacilityDetailsOnSearchCallsInSearclCallWindow=By.cssSelector("table[id='call-search-results-table'] tbody tr[id*='call-'] td:nth-child(8)");
		TruckIDDetailsOnSearchCallsInSearclCallWindow=By.cssSelector("table[id='call-search-results-table'] tbody tr[id*='call-'] td:nth-child(8)");
		txtCity=By.id("call-search-breakdown-city");
		linkCallSummaryIconOnMemberspage=By.xpath("//i[@class='icon-list-alt']");
		phoneNumberOnCallSummaryPOPUp=By.xpath("//span[@id='phone_number-hd-summary']");
		lblDateandTimeInMemberPage = By.xpath("//div[@id='mcd-call-header']/span/span[2]/span/span/span[1]");
		VehicleInfoOnSearchCallsInSearclCallWindow=By.cssSelector("table[id='call-search-results-table'] tbody tr[id*='call-'] td:nth-child(6)");
		txtLocation=By.id("call-search-breakdown-location");
		CityOnSearchCallsInSearclCallWindow=By.cssSelector("table[id='call-search-results-table'] tbody tr[id*='call-'] td:nth-child(7)");
		txtNoRecordsfoundOnSearchCalls=By.xpath("//*[@id='call-search-results-table']/tbody//*[contains(text(),'No matching records found, try refining your search')]");
		btnSearchCallsSPP = By.id("search-calls-lnk");
		txtStatusInSearchCalls=By.id("call-search-call-status");
		//lblClearedCallRow=By.xpath("//*[contains(@class,'d3ui-call-status-desc')][contains(text(),'03')]");
		lblClearedCallRow=By.xpath("//*[contains(@class,'d3ui-call-status-desc')][contains(text(),'G1')]");
        selectClearCallStatusRow = By.xpath("//*[contains(@class,'d3ui-icon-status-CL')]");

		txtCommCenter =By.xpath("//*[@id='call-search-comm-center']");
		lnkFirstCallIdInSearchResults=By.xpath("//table[@id='call-search-results-table']/tbody/tr[1]/td[2]/a");
		btnClearOnSearchCalls=By.id("call-search-clear-button");
		lblInvalidSearchCriteriaErrorForDate=By.xpath("//div[contains(@class,'error')][text()='E200: Invalid Search Criteria: The Start Date must be before the End Date.']");
		btnSearchAgain=By.id("call-search-back-btn");
		lblFacilityOnSearchCallsTable=By.xpath("//table[@id='call-search-results-table']/tbody/tr[1]/td[8]");
		lblMemberAndClubCodeOnSearchCallsTable=By.xpath("//table[@id='call-search-results-table']/tbody/tr[1]/td[5]");
		txtMemberFirstNameSearch =By.id("call-search-first-name");
		drpdwnCallType =By.xpath("//input[@id='call-search-calls-type-select']/../button");
	}

	public static By selectCallType(String callType){
		String xpath="//a[contains(text(),'"+callType+"')]";
		CallType=By.xpath(xpath);
		return CallType;
	}
}
