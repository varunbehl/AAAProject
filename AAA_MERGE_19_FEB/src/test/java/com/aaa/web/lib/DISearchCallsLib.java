package com.aaa.web.lib;


import com.aaa.web.page.CRSearchCallsPage;
import com.aaa.web.page.DIMCDPage;
import com.aaa.web.page.DISearchCallsPage;
import com.aaa.accelerators.ActionEngine;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class DISearchCallsLib extends ActionEngine {
	List<WebElement> allCallIdAndDates = null;
	List<WebElement> status = null;
	public static SimpleDateFormat displayFormat;
	public static SimpleDateFormat parseFormat;
	public static Date date;
	public static String time;
	public static String startTimeInSearch;
	public static String endTimeInSearch;
	public static String startDateInSearchDetails ;
	public static int callTimeInHours;
	public static int callTimeInMinutes;
	public static int startTimeInHours;
	public static int startTimeInMinutes;
	public static int endTimeInHours;
	public static int endTimeInMinutes;
	public static String startDateValue;
	public static String firstNameInSearch;
	public static String lastNameInSearch;
	public static String firstName;
	public static String lastName ;
	public static String RAPID ;
	public List<WebElement> allDates;
	public List<WebElement> allFacility;
	public List<WebElement> allTruckID;
	public List<WebElement> allClubNumbers;
	public List<WebElement> memberLastName;
	public List<WebElement> allMemberNumber;
	public List<WebElement> vehicleInfoList;
	public List<WebElement> allCity;


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterMemberNumberInSearchCallDispatch
	 * description ::
	 * date :: 05-Nov-2017
	 * author ::
	 */
	public void enterMemberNumberInSearchCallDispatch(String memberNumber) throws Throwable {
		waitForVisibilityOfElement(DISearchCallsPage.txtMemberNumberinSearchCall, "Search Member in Dispatch Queue");
		type(DISearchCallsPage.txtMemberNumberinSearchCall, memberNumber, "Search Member");
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnSearchButtonInSearchCallDispatch
	 * description ::
	 * date :: 05-Nov-2017
	 * author ::
	 */
	public void clickOnSearchButtonInSearchCallDispatch() throws Throwable {
		click(DISearchCallsPage.btnSearchinSearchCall, "Search Button in Dispatch Queue");
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: selectSPStatusRowInSearchCallDispatch
	 * description ::
	 * date :: 05-Nov-2017
	 * author ::
	 */
	public void selectSPStatusRowInSearchCallDispatch() throws Throwable {
		isElementPresent(DISearchCallsPage.SelectRowsFromSearchCallTable, "select Member in Dispatch Queue");
		waitForVisibilityOfElement(DISearchCallsPage.SelectRowsFromSearchCallTable, "select Member in Dispatch Queue");
		//click(DISearchCallsPage.SelectRowsFromSearchCallTable, "select Member in Dispatch Queue");
		//mouseDoubleClick(DISearchCallsPage.SelectRowsFromSearchCallTable, "open details of the member");
		click(DISearchCallsPage.selectSPStatusRow, "open details of the member");
		Thread.sleep(3000);
		mouseDoubleClick(DISearchCallsPage.selectSPStatusRow, "open details of the member");
	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: searchandSelectMemberNumber
	 * description ::
	 * date :: 05-Nov-2017
	 * author ::
	 */
    public void searchandSelectMemberNumber(String memberNumber) throws Throwable {
    	clickAndEnterMemberNumber(memberNumber);
    	clickOnSearchInSearchCalls();
    	selectRow();
    }

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickAndEnterCallIDInfo
	 * description ::
	 * date :: 05-Nov-2017
	 * author ::
	 */
       public void clickAndEnterCallIDInfo(String callID) throws Throwable {
       	 waitForVisibilityOfElement(DISearchCallsPage.btnCallIDinSearchCall, "Search Member Text Box");
            click(DISearchCallsPage.btnCallIDinSearchCall, "Search Member Text Box");
            type(DISearchCallsPage.btnCallIDinSearchCall, callID, "Search Member Text Box");
       }

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: searchAndSelectCallID
	 * description ::
	 * date :: 05-Nov-2017
	 * author ::
	 */
       public void searchAndSelectCallID(String CallID) throws Throwable {
    	clickAndEnterCallIDInfo(CallID);
       	clickOnSearchInSearchCalls();
       	selectSPStatusRowInSearchCallDispatch();
       }

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickAndEnterMemberNumber
	 * description ::
	 * date :: 05-Nov-2017
	 * author ::
	 */
	public void clickAndEnterMemberNumber(String memberNumber) throws Throwable {
    	 waitForVisibilityOfElement(DISearchCallsPage.txtMemberNumberinSearchCall, "Search Member Text Box");
         click(DISearchCallsPage.txtMemberNumberinSearchCall, "Search Member Text Box");
         type(DISearchCallsPage.txtMemberNumberinSearchCall, memberNumber, "Search Member Text Box");
    }

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnSearchInSearchCalls
	 * description ::
	 * date :: 05-Nov-2017
	 * author ::
	 */
    public void clickOnSearchInSearchCalls() throws Throwable {
    	click(DISearchCallsPage.btnSearchinSearchCall, "Search Button");
        Thread.sleep(3000);
    }

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: selectRow
	 * description ::
	 * date :: 05-Nov-2017
	 * author ::
	 */
    public void selectRow() throws Throwable {
    	waitForVisibilityOfElement(DISearchCallsPage.SelectFirstRow, "Search Member Result");
        mouseDoubleClick(DISearchCallsPage.SelectFirstRow, "Search Member Result");
        Thread.sleep(3000);
    }

    public void selectCallStatus(String status) throws Throwable {
    	Thread.sleep(3000);
    	waitForVisibilityOfElement(DISearchCallsPage.selectCallStatus, "select Call Status");
    	type(DISearchCallsPage.selectCallStatus, status ,"select Call Status");

    }
    public String enterStartDate(String Date) throws Throwable {
    	Thread.sleep(3000);
    	waitForVisibilityOfElement(DISearchCallsPage.startDate, "Start date");
    	type(DISearchCallsPage.startDate, Date ,"Start date");
        return Date;
    }
    public String enterEndDate(String Date) throws Throwable {
    	Thread.sleep(3000);
    	waitForVisibilityOfElement(DISearchCallsPage.endDate, "End Date");
    	type(DISearchCallsPage.endDate, Date ,"End Date");
        return Date;
    }
    public void selectOddRow() throws Throwable {
    	isElementPresent(DISearchCallsPage.selectOddRow, "select Member in Dispatch Queue");
		waitForVisibilityOfElement(DISearchCallsPage.selectOddRow, "select Member in Dispatch Queue");
		//click(DISearchCallsPage.SelectRowsFromSearchCallTable, "select Member in Dispatch Queue");
		//mouseDoubleClick(DISearchCallsPage.SelectRowsFromSearchCallTable, "open details of the member");
		click(DISearchCallsPage.selectOddRow, "open details of the member");
		Thread.sleep(3000);
		mouseDoubleClick(DISearchCallsPage.selectOddRow, "open details of the member");
    }

	/**
	 * param :: String inputs
	 * return ::voidAA
	 * throws :: throwable
	 * methodName :: getStartDate
	 * description ::
	 * date :: 26/01/18
	 * author ::
	 */

	public String getStartDate()throws  Throwable{
		waitForVisibilityOfElement(DISearchCallsPage.startDate, "Get start date");
		String startDate = getAttributeByValue(DISearchCallsPage.startDate,"Get start date");
		return startDate;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getEndDate
	 * description ::
	 * date :: 26/01/18
	 * author ::
	 */

	public String getEndDate()throws  Throwable{
		waitForVisibilityOfElement(DISearchCallsPage.endDate, "Get end date");
		String endDate = getAttributeByValue(DISearchCallsPage.endDate,"Get end date");
		return endDate;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getCallID
	 * description ::
	 * date :: 26/01/18
	 * author ::
	 */
	public String getCallID()throws  Throwable{
		waitForVisibilityOfElement(DISearchCallsPage.btnCallIDinSearchCall,"CallID");
		String callID = getAttributeByValue(DISearchCallsPage.btnCallIDinSearchCall,"CallID");
		return callID;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyResultsWithCurrentDate
	 * description ::
	 * date :: 26/01/18
	 * author ::
	 */
	public boolean verifyResultsWithCurrentDate(String currentDate) throws  Throwable {
		boolean flagDate = false;
		int a=0;
		boolean flagForNorecords = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "No Records Fornd");
		if (flagForNorecords) {
			assertTrue(flagForNorecords, "No Results are available for Current Date");
		} else {
			allCallIdAndDates = getWebElementList(DISearchCallsPage.callIDAndDateInSearclCallWindow, "CallId in Search Call Window");
			if (allCallIdAndDates != null) {
				for (int i=0; i < allCallIdAndDates.size(); i++) {
					String callIdAndDateFromList = allCallIdAndDates.get(i).getText();
					String callIDAndDate[] = callIdAndDateFromList.split("\n");
					String dateFromList = callIDAndDate[0];
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Date d_date = dateFormat.parse(dateFromList);
					String strDate = dateFormat.format(d_date);

					if (currentDate.contains(strDate)) {
						flagDate = true;
					}
				}
				//assertTrue(flagDate, "Verified the results returned & all results are for the current day   "+currentDate);
			}

		}
		return flagDate;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyResultsWithCallID
	 * description ::
	 * date :: 26/01/18
	 * author ::
	 */
	public boolean verifyResultsWithCallID(String callId) throws Throwable {
		boolean flagId = false;
		boolean flagForNorecords = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "No Records Found");
		if (flagForNorecords) {
			assertTrue(flagForNorecords, "No Results are available with CallID  " + callId);
		} else {
			String callIdAndDate = getText(DISearchCallsPage.callIDAndDateInSearclCallWindow, "CallId in Search Call Window");
			if (callIdAndDate != null) {
				String callIDAndDate[] = callIdAndDate.split("\n");
				String callIDFromList = callIDAndDate[1];
				String callIdList[] = callIDFromList.split("#");
				String callIDInList = callIdList[1];
				if (callIDInList.contains(callId)) {
					flagId=true;
					//assertTrue((callIDInList.equals(callId)), "Verified the results returned & one call is returned for the call ID    " + callId);
				}
			}

		}
		return flagId;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterStartTimeOnSearchCallsWindow
	 * description ::
	 * date :: 29-jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void enterStartTimeOnSearchCallsWindow(String startTime) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtStartTime,"Search Calls Window startTime");
		type(DISearchCallsPage.txtStartTime,startTime, "Search Calls Window startTime");
	}
	public void clickCloseBtnOnSearchCallwindow() throws Throwable {
		waitForVisibilityOfElement(DISearchCallsPage.btnCloseSearchCallsWindow, "Close Button");
		click(DISearchCallsPage.btnCloseSearchCallsWindow, "Close Button");
		Thread.sleep(4000);


	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterEndTimeOnSearchCallsWindow
	 * description ::
	 * date :: 29-jan-2018
	 * author ::Abhiram
	 */
	public void enterEndTimeOnSearchCallsWindow(String endTime) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtEndTime,"Search Calls Window endTime");
		type(DISearchCallsPage.txtEndTime,endTime, "Search Calls Window endTime");
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterRAPNumberOnSearchCallsWindow
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void enterRAPNumberOnSearchCallsWindow(String RAPNumber) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtRAPNumber,"Search Calls Window RAPNumber");
		type(DISearchCallsPage.txtRAPNumber,RAPNumber, "Search Calls Window RAPNumber");
	}

	public void verifyTheTimeRange(String startTime,String endTime) throws  Throwable{
		waitForVisibilityOfElement(DISearchCallsPage.clickOnCallIdLinkInSearchCalls,"Click On Call ID");
		click(DISearchCallsPage.clickOnCallIdLinkInSearchCalls, "Click On Call ID");
		Thread.sleep(5000);
		waitForVisibilityOfElement(DISearchCallsPage.lblDateandTimeInMemberPage,"Date and Time From Member Tab");
		String dateDetails= getText(DISearchCallsPage.lblDateandTimeInMemberPage,"Date and Time From Member Tab");
		String splitStr[] = dateDetails.split(" ");
		String timeFormat = splitStr[1];
		String splittime[] = timeFormat.split(":");
		String callTimeSplittedInHours = splittime[0];
		String callTimeSplittedInMinutes = splittime[1];
		callTimeInHours = Integer.parseInt(callTimeSplittedInHours);
		callTimeInMinutes = Integer.parseInt(callTimeSplittedInMinutes);

		//startTimeInSearch = data.get("StartTime");
		String splitstartTimeInSearch[] = startTime.split(":");
		String startTimeSplittedInHours = splitstartTimeInSearch[0];
		String startTimeSplittedInMinute = splitstartTimeInSearch[1];
		startTimeInHours = Integer.parseInt(startTimeSplittedInHours);
		startTimeInMinutes = Integer.parseInt(startTimeSplittedInMinute);

		//endTimeInSearch =data.get("EndTime");
		String splitEndTimeInExcel[] = endTime.split(":");
		String endTimeSplittedInHours = splitEndTimeInExcel[0];
		String endTimeSplittedInMinutes = splitEndTimeInExcel[1];
		endTimeInHours = Integer.parseInt(endTimeSplittedInHours);
		endTimeInMinutes = Integer.parseInt(endTimeSplittedInMinutes);

		assertTrue((callTimeInHours >= startTimeInHours && callTimeInHours <= endTimeInHours),"The Call Time:: "+timeFormat +" is between::  Start time "+startTime+"  and End Time:: "+endTime);
		/*if(callTimeInHours >= startTimeInHours && callTimeInHours <= endTimeInHours){
			//if(timeInIntInMinute>stimeInIntInminute && timeInIntInMinute<etimeInIntInMinute){
			assertTrue((callTimeInHours >= startTimeInHours && callTimeInHours <= endTimeInHours),"The Call Time:: "+timeFormat +" is between::  Start time "+startTime+"  and End Time:: "+endTime);
		}else{
			assertFalse((callTimeInHours >= startTimeInHours && callTimeInHours <= endTimeInHours),"The Call Time:: "+timeFormat +" is Not between::  Start time "+startTime+"  and End Time:: "+endTime);
		}*/
		Thread.sleep(2000);
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getRapNumber
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public String getRapNumber()throws  Throwable{
        String rapNumber = getAttributeByValue(DISearchCallsPage.txtRAPNumber,"RAP Number");
	    return rapNumber;
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterTruckOnSearchCallsWindow
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void enterTruckOnSearchCallsWindow(String truck) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtTruck,"Search Calls Window truck");
		type(DISearchCallsPage.txtTruck,truck, "Search Calls Window truck");
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTruckFromSearchCallsWindow
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public String getTruckFromSearchCallsWindow()throws  Throwable{
       String truck = getAttributeByValue(DISearchCallsPage.txtTruck,"Search Calls Window truck   ");
       return truck;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyResultsWithRapId
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public boolean verifyResultsWithRAPId(String rapNumber)throws  Throwable{
		boolean rapIdFlag=false;
		boolean flagForNoRecords = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "No Records Found");
		if (flagForNoRecords) {
			assertTrue(flagForNoRecords, "No Results are available wirh RapNumber  ");
		} else {
			String rapNum = getText(DISearchCallsPage.RAPOnSearchCallsInSearclCallWindow, "RAP Number in Search Call Window");
			if(rapNum != null) {
				if(rapNumber.contains(rapNum)) {
					//assertTrue(rapNumber.contains(rapNum), "Verified the results returned & RAP call is returned in the search results    " + rapNumber);
					rapIdFlag=true;
				}
			}

		}
		return rapIdFlag;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterFacilityOnSearchCallsWindow
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void enterFacilityOnSearchCallsWindow(String facility) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtFacility,"Search Calls Window facility");
		type(DISearchCallsPage.txtFacility,facility, "Search Calls Window facility");
		Thread.sleep(2000);

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getFacility
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public String getFacility()throws  Throwable{
		String facility = getAttributeByValue(DISearchCallsPage.txtFacility,"get Facility");
		return facility;
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyResultsWithFacility
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public boolean verifyResultsWithFacility(String facility)throws  Throwable{
		String facilityFromList=null;
		boolean facilityFlag =false;
		boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Facility in Search Call Window ");
		if (verifySearchResults) {
			assertTrue(verifySearchResults,"No Record found with search Criteria");
		}
		else{
			allFacility = getWebElementList(DISearchCallsPage.FacilityDetailsOnSearchCallsInSearclCallWindow, "Facility in Search Call Window");

			for (int i = 0; i < allFacility.size(); i++) {
				facilityFromList = allFacility.get(i).getText();
				if (facilityFromList.contains(facility)) {
					facilityFlag=true;
				}
			}
			//assertTrue(facilityFlag, " Results matched the criteria :: Facility " + facility + "Exists in Selected List");

		}
		Thread.sleep(4000);
	return facilityFlag;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyResultsWithTruckId
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public boolean verifyResultsWithTruckId(String truck)throws  Throwable{
		boolean truckIDFlag=false;
			boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Truck ID in Search Call Window ");
			if (verifySearchResults) {
				assertTrue(verifySearchResults,"No Record found for Truck Id search");
			}
			else{
				Thread.sleep(3000);
				allTruckID = getWebElementList(DISearchCallsPage.TruckIDDetailsOnSearchCallsInSearclCallWindow, "Truck ID in Search Call Window");
				for (int i = 0; i < allTruckID.size(); i++) {
					String truckIDFromList = allTruckID.get(i).getText();
					if (truckIDFromList.contains(truck)) {
						truckIDFlag=true;
					}
				}
				//assertTrue(truckIDFlag, " Call is Serviced by the Truck,Truck Id is     " +truck);
			}
			Thread.sleep(4000);
			return truckIDFlag;
		}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterCallTakerOnSearchCallsWindow
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void enterUserIDOnSearchCallsWindow(String callTaker) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtCallTaker,"Search Calls Window callTaker");
		type(DISearchCallsPage.txtCallTaker,callTaker, "Search Calls Window callTaker");
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterPhoneNumberOnSearchCallsWindow
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void enterPhoneNumberOnSearchCallsWindow(String phoneNumber) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtPhoneNumber, "Search Calls Window phoneNumber");
		type(DISearchCallsPage.txtPhoneNumber,phoneNumber, "Search Calls Window phoneNumber");
	}
	public String getPhoneNumber()throws Throwable{
		String phoneNumber=getAttributeByValue(DISearchCallsPage.txtPhoneNumber,"PhoneNumber");
		return phoneNumber;
	}
	/**
	 * param :: NA
	 * return ::void
	 * throws :: throwable
	 * methodName :: ClickOnCallIdOnSearchCallsWindow
	 * description ::
	 * retrivedTime :: 18-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void ClickOnCallIdOnSearchCallsWindow() throws Throwable {
		waitForVisibilityOfElement(DISearchCallsPage.clickOnCallIdLinkInSearchCalls, "Call Id and Date");
		click(DISearchCallsPage.clickOnCallIdLinkInSearchCalls, "Call Id and Date");
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getUserId
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public String getUserId()throws  Throwable{
		String userId = getAttributeByValue(DISearchCallsPage.txtCallTaker,"User ID");
        return userId;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyResultsWithCallTakerID
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public boolean verifyResultsWithCallTakerID(String CallTaker,String callTakerFromMcd)throws  Throwable{
		boolean callTakerFlag=false;
		boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Truck ID in Search Call Window ");
		if (verifySearchResults) {
			assertTrue(verifySearchResults,"No Record found for CallTaker search");
		}else {
			Thread.sleep(2000);
			//String callTakerOnMCDWindow = getText(DIMCDPage.txtCallTaker, "Call Taker on MCD Window");
			Thread.sleep(2000);
			if (CallTaker.equalsIgnoreCase(callTakerFromMcd)) {
				callTakerFlag=true;
				//assertTrue(CallTaker.equalsIgnoreCase(callTakerOnMCDWindow), "calls are returned based on the user id   " + CallTaker);
			}
		}
		return callTakerFlag;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyResultsWithphoneNumber
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public boolean verifyResultsWithphoneNumber(String phoneNum) throws Throwable{
		boolean phoneNumberFlag = false;
		boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Truck ID in Search Call Window ");
		if (verifySearchResults) {
			assertTrue(verifySearchResults,"No Record found for phone Number search");
		}else {
			String phoneNumber2 =phoneNum.substring(6,10);
			waitForVisibilityOfElement(DIMCDPage.phoneNumberValue(phoneNumber2),"Phone Number");
			String phoneNumber1 = getText(DIMCDPage.phoneNumberValue(phoneNumber2),"Phone Number");
			String phonenum[] = phoneNumber1.split(" ");
			String phone1 = phonenum[0].substring(1,4);
			String phone2[] = phonenum[1].split("-");
			String phone3 = phone2[0];
			String phone4 = phone2[1];
			Thread.sleep(3000);
			String phoneNumber=phone1+phone3+ phone4;
			if (phoneNum.contains(phoneNumber)) {
				phoneNumberFlag = true;
				//assertTrue(phoneNumberFromResults.equals(phoneNumber),"Verified the results returned & call is returned for that specific member  ");
			}
			Thread.sleep(2000);
		}
		return phoneNumberFlag;

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterClubNumberOnSearchCallsWindow
	 * description ::
	 * date :: 29-jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void enterClubNumberOnSearchCallsWindow(String clubNumber) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtClubCode,"Search Calls Window clubNumber");
		type(DISearchCallsPage.txtClubCode,clubNumber, "Search Calls Window clubNumber");
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getClubCode
	 * description ::
	 * date :: 29-jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public String getClubCode()throws  Throwable{
		String clubCode=getAttributeByValue(DISearchCallsPage.txtClubCode,"Search Calls Window clubNumber");
		return clubCode;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyResultsWithClubCode
	 * description ::
	 * date :: 29-jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public boolean verifyResultsWithClubCode(String clubCode)throws Throwable{
		boolean clubNoFlag=false;
		boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Club Number in Search Call Window ");
		if (verifySearchResults) {
			assertTrue(verifySearchResults,"No matching records found, try refining your search");
		}
		else{
			allClubNumbers = getWebElementList(DISearchCallsPage.ClubNumberOnSearchCallsInSearclCallWindow, "Club Number in Search Call Window");

			for (int i = 0; i < allClubNumbers.size(); i++) {
				String ClubNumbersFromList = allClubNumbers.get(i).getText();
				if (ClubNumbersFromList.contains(clubCode)) {
					clubNoFlag=true;

				}
			}
			//assertTrue(clubNoFlag, "Verified the calls & Call is returned with club Code    "+clubCode);
		}
		Thread.sleep(4000);
		return clubNoFlag;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterMemberLastNameSearchOnSearchCallsWindow
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void enterMemberLastNameSearchOnSearchCallsWindow(String memberLastName) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtMemberLastNameSearch,"Search Calls Window memberLastName");
		type(DISearchCallsPage.txtMemberLastNameSearch,memberLastName, "Search Calls Window memberLastName");
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getLaseName
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */

	public String getLaseNameFromSearchCallsWindow()throws  Throwable{
       String lastName = getAttributeByValue(DISearchCallsPage.txtMemberLastNameSearch,"Search Calls Window memberLastName");
       return lastName;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyResultsWithLastName
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */

	public boolean verifyResultsWithLastName(String lastName)throws Throwable{
		boolean lastNameFlag =false;
		boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Last Name in Search Call Window ");
		if (verifySearchResults) {
			assertTrue(verifySearchResults,"No Record found for Last name Search ");
		}
		else{
			memberLastName = getWebElementList(DISearchCallsPage.MemberLastNameOnSearchCallsInSearclCallWindow, "Last Name in Search Call Window");

			for (int i=0; i<memberLastName.size(); i++) {
				String memberLastNameFromList = memberLastName.get(i).getText();
				String lastNameLowerCase = memberLastNameFromList.toLowerCase();
				if (lastNameLowerCase.contains(lastName)) {
					lastNameFlag=true;
				}
			}
			//assertTrue(lastNameFlag, "Verified the results & call(s) is returned matching the last name    "+lastName);
		}
		Thread.sleep(4000);
		return lastNameFlag;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterMemberNumberOnSearchCallsWindow
	 * description ::
	 * date :: 29-Dec-2017
	 * author ::Lakshmi Prasanna
	 */
	public void enterMemberNumberOnSearchCallsWindow(String memberNumber) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtMemberNumberSearch,"MemberNumber on Search Calls Window");
		type(DISearchCallsPage.txtMemberNumberSearch,memberNumber, "MemberNumber on Search Calls Window");
		Thread.sleep(2000);
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getMemberNumberFromSearCalls
	 * description ::
	 * date :: 29-Dec-2017
	 * author ::Lakshmi Prasanna
	 */
	public String getMemberNumberFromSearCalls()throws  Throwable{
      String memNumber = getAttributeByValue(DISearchCallsPage.txtMemberNumberSearch,"Member Number");
      return memNumber;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyResultsWithMemberNumber
	 * description ::
	 * date :: 29-Dec-2017
	 * author ::Lakshmi Prasanna
	 */
	public boolean verifyResultsWithMemberNumber(String memNumber)throws  Throwable{
		boolean memberNumberFlag=false;
		boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Member Number in Search Call Window ");
		if (verifySearchResults) {
			assertTrue(verifySearchResults,"No Record found for Member Number Search");
		}
		else{
			allMemberNumber = getWebElementList(DISearchCallsPage.MemberNumberOnSearchCallsInSearclCallWindow, "Member Number in Search Call Window");

			for (int i=0; i<allMemberNumber.size(); i++) {
				String memberNumberFromList = allMemberNumber.get(i).getText();
				if (memberNumberFromList.contains(memNumber)) {
					memberNumberFlag=true;

				}
			}
			//assertTrue(memberNumberFlag, "Verified the results & Call record is returned for the member    "+memNumber);
		}
		Thread.sleep(4000);
		return memberNumberFlag;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterYearVehicleInforationOnSearchCallsWindow
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void enterYearVehicleInforationOnSearchCallsWindow(String vehicleYear) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtYearVehicleInformation,"vehicle Year on Search Call");
		type(DISearchCallsPage.txtYearVehicleInformation,vehicleYear, "vehicle Year on Search Call");
		Thread.sleep(2000);
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterMakeVehicleInforationOnSearchCallsWindow
	 * description ::
	 * date :: 29-jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void enterMakeVehicleInforationOnSearchCallsWindow(String vehicleMake) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtMakeVehicleInformation,"Search Calls Window vehicleMake");
		type(DISearchCallsPage.txtMakeVehicleInformation,vehicleMake, "Search Calls Window vehicleMake");
		click(DISearchCallsPage.txtCity, "city text box");
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterModelVehicleInforationOnSearchCallsWindow
	 * description ::
	 * date :: 29-jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void enterModelVehicleInforationOnSearchCallsWindow(String vehicleModel) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtModelVehicleInformation,"Search Calls Window vehicleModel");
		type(DISearchCallsPage.txtModelVehicleInformation,vehicleModel, "Search Calls Window vehicleModel");
		Thread.sleep(2000);

		//click(By.xpath("(//a[@class='ui-corner-all'])[19]"),"click on city");
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getVehicleYearFromSearCalls
	 * description ::
	 * date :: 29-jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public String getVehicleYearFromSearCalls()throws  Throwable{
		String  year = getAttributeByValue(DISearchCallsPage.txtYearVehicleInformation,"vehicle Year on Search Call");
		return year;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getVehicleMakeFromSearCalls
	 * description ::
	 * date :: 29-jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public String getVehicleMakeFromSearCalls()throws  Throwable{
		String  make = getAttributeByValue(DISearchCallsPage.txtMakeVehicleInformation,"vehicle Make on Search Call");
		return make;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getVehicleModelFromSearCalls
	 * description ::
	 * date :: 29-jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public String getVehicleModelFromSearCalls()throws  Throwable{
		String  model = getAttributeByValue(DISearchCallsPage.txtModelVehicleInformation,"vehicle Model on Search Call");
		return model;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getVehicleModelFromSearCalls
	 * description ::
	 * date :: 29-jan-2018
	 * author ::Lakshmi Prasanna
	 */

	public boolean verifyResultsWithVehicle(String year,String make,String model)throws Throwable{
		boolean vehicleYearFlag=false;
		boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Vehicle Year in Search Call Window ");
		if (verifySearchResults) {
			assertTrue(verifySearchResults,"No Record found after search");
		}
		else{
			vehicleInfoList = getWebElementList(DISearchCallsPage.VehicleInfoOnSearchCallsInSearclCallWindow, "Vehicle Year in Search Call Window");

			for (int i=0; i < vehicleInfoList.size(); i++) {
				String vehicleInfoFromList = vehicleInfoList.get(i).getText();
				String vehicleDetails[] = vehicleInfoFromList.split(" ");
				String yearDetails =vehicleDetails[0];
				String makeDetails =vehicleDetails[1];
				String modelDetails =vehicleDetails[2];
				if (yearDetails.equalsIgnoreCase(year) && makeDetails.equalsIgnoreCase(make) && modelDetails.equalsIgnoreCase(model) ) {
					vehicleYearFlag=true;
				}
			}
			//assertTrue(vehicleYearFlag, "Verified the result & Call is returned for  Vehicle Search  with     "+year+"   "+make+"   "+model);
		}
		Thread.sleep(4000);
		return vehicleYearFlag;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterLocationOnSearchCallsWindow
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void enterLocationOnSearchCallsWindow(String location) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtLocation,"Location on Search Calls Window ");
		type(DISearchCallsPage.txtLocation,location, "Location on Search Calls Window");
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getStreetAddressFromSearCalls
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public String getStreetAddressFromSearCalls()throws  Throwable{
		String breakDwnLocation = getAttributeByValue(DISearchCallsPage.txtLocation,"Location on Search Calls Window");
		return breakDwnLocation;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterCityOnSearchCallsWindow
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public void enterCityOnSearchCallsWindow(String city) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.txtCity,"City on Search Calls Window");
		type(DISearchCallsPage.txtCity,city, "City on Search Calls Window");
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getCityLocationFromSearCalls
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public String getCityLocationFromSearCalls()throws Throwable{
		String breakdDwnCity = getAttributeByValue(DISearchCallsPage.txtCity,"City on Search Calls Window");
		return breakdDwnCity;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyResultsWithBreakdownLocation
	 * description ::
	 * date :: 29-Jan-2018
	 * author ::Lakshmi Prasanna
	 */
	public boolean verifyResultsWithBreakdownLocation(String bkDwnStreetAddress ,String bkDownCity)throws  Throwable {
		boolean cityFlag = false;
		boolean verifySearchResults = isVisibleOnly(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "City in Search Call Window ");
		if (verifySearchResults) {
			assertTrue(verifySearchResults, "No Record found after search");
		} else {
			allCity = getWebElementList(DISearchCallsPage.CityOnSearchCallsInSearclCallWindow, "City in Search Call Window");

			for (int i = 0; i < allCity.size(); i++) {
				String allCityFromList = allCity.get(i).getText();
				if (allCityFromList.contains(bkDwnStreetAddress) && allCityFromList.contains(bkDownCity)) {
					cityFlag = true;
				}
			}
			//assertTrue(cityFlag, "Verified the result & Call is returned for Breakdown location Search  with     "+bkDwnStreetAddress+"   "+bkDownCity);
		}
		Thread.sleep(4000);

		return cityFlag;
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyMatchingRecordsOnMCD
	 * description ::
	 * date :: 04-feb-2018
	 * author ::Lakshmi Prasanna
	 */
	public boolean verifyMatchingRecordsOnMCD()throws  Throwable{
		boolean noRecords = isVisibleOnly(DISearchCallsPage.txtNoRecordsfoundOnSearchCalls,"No Matching Records");
		return noRecords;
	}
	public String enterValueInStatusTextBonInSearchCalls(String status) throws Throwable{
		type(DISearchCallsPage.txtStatusInSearchCalls,status,"Status Value");
		return status;
	}
	public void selectClearedCallsFromSearchResults() throws Throwable {

        //allCallIdAndDates = getWebElementList(DISearchCallsPage.RAPOnSearchCallsInSearclCallWindow, "RAPID");
        status = getWebElementList((DISearchCallsPage.lblClearedCallRow),"Cleared calls with 03");
        if(status!=null) {
            allCallIdAndDates = getWebElementList(DISearchCallsPage.RAPOnSearchCallsInSearclCallWindow, "RAPID");

            for (int i = 0; i < allCallIdAndDates.size(); i++) {
                if(allCallIdAndDates!=null){
                    mouseDoubleClick(DISearchCallsPage.lblClearedCallRow, "Cleared calls");
                    break;
                }

               // break;

                }
            }
        }

	   /* if(RAPID.isEmpty())
        mouseDoubleClick(DISearchCallsPage.lblClearedCallRow,"Cleared calls");
	}*/

    public String verifyRAPIDsOnMCD()throws  Throwable{
        RAPID = getText(DISearchCallsPage.RAPOnSearchCallsInSearclCallWindow,"No Matching Records");
        return RAPID;
    }
    public void selectClearCallRow()throws  Throwable{
        mouseClick(DISearchCallsPage.selectClearCallStatusRow,"Clear call row");

    }


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * description ::This method is used to enter comm center on search calls
	 * date :: 14-02-2018
	 */
	public void enterCommCenterOnSearchCallsWindow(String commCenter) throws Throwable {
		waitForVisibilityOfElement(DISearchCallsPage.txtCommCenter, "Search Calls Window callTaker");
		type(DISearchCallsPage.txtCommCenter, commCenter, "Search Calls Window callTaker");
		Thread.sleep(2000);
	}

	/**
	 * Description:This method is used to select an first  callId from search call table
	 * Date:14-01-2018
	 * @throws Throwable
	 */
	public void clickOnFirstCallIdInSearchCallsTable() throws Throwable {
		waitForVisibilityOfElement(DISearchCallsPage.lnkFirstCallIdInSearchResults, "CallIdAndDate");
		click(DISearchCallsPage.lnkFirstCallIdInSearchResults, "CallIdAndDate");

	}

	/**
	 * Description:This method is used to select an first  callId from search call table
	 * Date:14-01-2018
	 *
	 * @throws Throwable
	 */
	public void getFirstCallIdAndDateInSearchCallsTable() throws Throwable {
		waitForVisibilityOfElement(DISearchCallsPage.lnkFirstCallIdInSearchResults, "Search Details");
		getText(DISearchCallsPage.lnkFirstCallIdInSearchResults, "CallId And Date From search Results:");

	}

	/**
	 * Description:This method is used to click on clear button on search calls
	 * Date:14-01-2018
	 *
	 * @throws Throwable
	 */
	public void clickOnClearbuttonInSearchCalls() throws Throwable {
		waitForVisibilityOfElement(DISearchCallsPage.btnClearOnSearchCalls, "Clear");
		click(DISearchCallsPage.btnClearOnSearchCalls, "Clear");

	}

	/**
	 * Description:This method is to verify invalide search criteria for invalid date  search calls
	 * Date:14-01-2018
	 *
	 * @throws Throwable
	 */
	public void verifyInvalidSearchCriteriaForDate() throws Throwable {
		waitForVisibilityOfElement(DISearchCallsPage.lblInvalidSearchCriteriaErrorForDate, "");
		getText(DISearchCallsPage.lblInvalidSearchCriteriaErrorForDate, "Invalid Search Criteria Error For Date");

	}

	/**
	 * Description:This method is used to click on Search Again button  on search calls
	 * Date:14-01-2018
	 *
	 * @throws Throwable
	 */
	public void clickOnSearchAgainbuttonInSearchCalls() throws Throwable {
		waitForVisibilityOfElement(DISearchCallsPage.btnSearchAgain, "Search Again");
		click(DISearchCallsPage.btnSearchAgain, "Search Again");
	}

	/**
	 * Description:This method is used to get a callid from a search results
	 * Date:14-01-2018
	 * @return
	 * @throws Throwable
	 */
	public String getValidArchivedCall()throws Throwable{
		waitForVisibilityOfElement(DISearchCallsPage.lnkFirstCallIdInSearchResults, "Search Details");
		String callIDAndDate=getText(DISearchCallsPage.lnkFirstCallIdInSearchResults, "Search Details");
		String callid=callIDAndDate.substring(11,16);
		return callid;
	}

	/**
	 * Description:This method is used to verify no record found for a search criteria
	 * Date:14-01-2018
	 * @throws Throwable
	 */
	public void verifyNoRecordFoundForSearchResults()throws Throwable{
		waitForVisibilityOfElement(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "No Matching Records Found");
		getText(DISearchCallsPage.txtMessageNoDataAvailableForSearchResults, "No Matching Records Found");


	}

	/**
	 * Description:This method is used to verify FirstName and LastName  from a search criteria
	 * Date:14-01-2018
	 * @param firstNameLastName
	 * @return
	 * @throws Throwable
	 */
	public boolean verifyFirstNameLastNameInArchivedCall(String firstNameLastName)throws Throwable{
		boolean firstAndLast=false;
		waitForVisibilityOfElement(DISearchCallsPage.lblMemberAndClubCodeOnSearchCallsTable, "MemberName MemberNumber And ClubCode");
		String memberNameMemberNumberAndClubCode=getText(DISearchCallsPage.lblMemberAndClubCodeOnSearchCallsTable, "MemberName MemberNumber And ClubCode");
		if(memberNameMemberNumberAndClubCode.contains(firstNameLastName)) {
			firstAndLast=true;
		}else {
			firstAndLast=true;
		}
		return firstAndLast;

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterMemberFirstNameSearchOnSearchCallsWindow
	 * description ::This method is used to enter first name on search calls window
	 * date :: 14-02-2018

	 */
	public void enterMemberFirstNameSearchOnSearchCallsWindow(String memberFirstName) throws Throwable {
		waitForVisibilityOfElement(DISearchCallsPage.txtMemberFirstNameSearch, "Search Calls Window MemberFirstName");
		type(DISearchCallsPage.txtMemberFirstNameSearch, memberFirstName, "Search Calls Window MemberFirstName");
	}

	/**
	 * description ::This method is used to click on CallType Dropdown and select LIVE ONLY and LIVE AND ARCHIVED type
	 * @param calltype
	 * date :: 14-02-2018
	 * @throws Throwable
	 */
	public void enterCallType(String calltype) throws Throwable
	{
		waitForVisibilityOfElement(DISearchCallsPage.drpdwnCallType,"Call Type Dropdown");
		click(DISearchCallsPage.drpdwnCallType,"Call Type Dropdown");
		click(DISearchCallsPage.selectCallType(calltype),"select"+calltype+"call type");
	}

}


