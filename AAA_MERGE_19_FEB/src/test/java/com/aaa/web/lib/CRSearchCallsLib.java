package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.CRMemberSearchPage;
import com.aaa.web.page.CRSearchCallsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class CRSearchCallsLib extends ActionEngine {

    public List<WebElement> allCallIds;
    public List<WebElement> MemberLastName,allClubNumbers,allMemberNumber,allLocation,allCity,allVehicleYear,allVehicleMake,allVehicleModel,allRAP,memberPhoneNumber,allTruckID,allFacility;
    public String callIdFromList,MemberLastNameFromList,ClubNumbersFromList,MemberNumberFromList,allLocationFromList,allCityFromList,vehicleYearFromList,vehicleMakeFromList,vehicleModelFromList,RAPFromList,truckIDFromList,facilityFromList;
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
    public List<WebElement> allDates;
    Boolean callIDFlag, lastNameFlag,ClubNoFlag,MemberNumberFlag,locationFlag,CityFlag,vehicleYearFlag,vehicleMakeFlag,vehicleModelFlag,RAPFlag,memberPhoneFlag,truckIDFlag,FacilityFlag;



    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterRAPNumberOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterRAPNumberOnSearchCallsWindow(String RAPNumber) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtRAPNumber,"Search Calls Window RAPNumber");
        type(CRSearchCallsPage.txtRAPNumber,RAPNumber, "Search Calls Window RAPNumber");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterFacilityOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterFacilityOnSearchCallsWindow(String facility) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtFacility,"Search Calls Window facility");
        type(CRSearchCallsPage.txtFacility,facility, "Search Calls Window facility");
        Thread.sleep(2000);
        //driver.findElement(By.xpath("(//a[@class='ui-corner-all'])[20]")).click();
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTruckOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterTruckOnSearchCallsWindow(String truck) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtTruck,"Search Calls Window truck");
        type(CRSearchCallsPage.txtTruck,truck, "Search Calls Window truck");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTakerOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterCallTakerOnSearchCallsWindow(String callTaker) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtCallTaker,"Search Calls Window callTaker");
        type(CRSearchCallsPage.txtCallTaker,callTaker, "Search Calls Window callTaker");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStartDateOnSearchCallsWindow
     * description ::
     * date :: 04-Jan-2018
     * author ::Abhiram
     */
    public void enterStartDateOnSearchCallsWindow(String StartDate) throws Throwable
    {

        waitForVisibilityOfElement(CRSearchCallsPage.txtStartDateOnSearchCallWindow, "Search Calls Window Start date");
        type(CRSearchCallsPage.txtStartDateOnSearchCallWindow,StartDate, "Search Calls Window Start date");
        Thread.sleep(3000);
    }



    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPhoneNumberOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterPhoneNumberOnSearchCallsWindow(String phoneNumber) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtPhoneNumber, "Search Calls Window phoneNumber");
        type(CRSearchCallsPage.txtPhoneNumber,phoneNumber, "Search Calls Window phoneNumber");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterClubNumberOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterClubNumberOnSearchCallsWindow(String clubNumber) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtClubSearch,"Search Calls Window clubNumber");
        type(CRSearchCallsPage.txtClubSearch,clubNumber, "Search Calls Window clubNumber");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberLastNameSearchOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterMemberLastNameSearchOnSearchCallsWindow(String memberLastName) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtMemberLastNameSearch,"Search Calls Window memberLastName");
        type(CRSearchCallsPage.txtMemberLastNameSearch,memberLastName, "Search Calls Window memberLastName");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberNumberOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterMemberNumberOnSearchCallsWindow(String memberNumber) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtMemberNumberSearch,"Search Calls Window memberNumber");
        type(CRSearchCallsPage.txtMemberNumberSearch,memberNumber, "Search Calls Window memberNumber");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterYearVehicleInforationOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterYearVehicleInforationOnSearchCallsWindow(String vehicleYear) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtYearVehicleInformation,"Search Calls Window vehicleYear");
        type(CRSearchCallsPage.txtYearVehicleInformation,vehicleYear, "Search Calls Window vehicleYear");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMakeVehicleInforationOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterMakeVehicleInforationOnSearchCallsWindow(String vehicleMake) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtMakeVehicleInformation,"Search Calls Window vehicleMake");
        type(CRSearchCallsPage.txtMakeVehicleInformation,vehicleMake, "Search Calls Window vehicleMake");
        click(CRSearchCallsPage.txtCity, "city text box");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterModelVehicleInforationOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterModelVehicleInforationOnSearchCallsWindow(String vehicleModel) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtModelVehicleInformation,"Search Calls Window vehicleModel");
        type(CRSearchCallsPage.txtModelVehicleInformation,vehicleModel, "Search Calls Window vehicleModel");
        Thread.sleep(2000);

        //click(By.xpath("(//a[@class='ui-corner-all'])[19]"),"click on city");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLocationOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterLocationOnSearchCallsWindow(String location) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtLocation,"Search Calls Window location");
        type(CRSearchCallsPage.txtLocation,location, "Search Calls Window location");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCityOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterCityOnSearchCallsWindow(String city) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtCity,"Search Calls Window city");
        type(CRSearchCallsPage.txtCity,city, "Search Calls Window city");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallIdOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterCallIdOnSearchCallsWindow(String callid) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtCallId,"Search Calls Window callid");
        type(CRSearchCallsPage.txtCallId,callid, "Search Calls Window callid");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStartTimeOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterStartTimeOnSearchCallsWindow(String startTime) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtStartTime,"Search Calls Window startTime");
        type(CRSearchCallsPage.txtStartTime,startTime, "Search Calls Window startTime");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterEndTimeOnSearchCallsWindow
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterEndTimeOnSearchCallsWindow(String endTime) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtEndTime,"Search Calls Window endTime");
        type(CRSearchCallsPage.txtEndTime,endTime, "Search Calls Window endTime");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchCalls
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public void clickOnSearchCalls() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        click(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRSearchCallsPage.linkSearchCalls, "Search Calls");
        click(CRSearchCallsPage.linkSearchCalls, "Search Calls");
        Thread.sleep(2000);
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchCalls
     * description ::
     * date :: 01-Jan-2018
     * author ::Nidhi
     */
    public void clickOnSearchCallsAndSearchLink() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        click(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        waitForVisibilityOfElement(CRSearchCallsPage.linkSearchCalls, "Search Calls");
        click(CRSearchCallsPage.linkSearchCalls, "Search Calls");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnClearOnSearchCallsWindow
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public void clickOnClearOnSearchCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnClear, "Clear");
        click(CRSearchCallsPage.btnClear, "Clear");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchBtnOnSearchCallsWindow
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public void clickOnSearchBtnOnSearchCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnSearch, "Search");
        click(CRSearchCallsPage.btnSearch, "Search");
        Thread.sleep(5000);
       // boolean searchResult = driver.findElement(CRSearchCallsPage.searchResultFound).isDisplayed();
        boolean searchResult = false;
        searchResult = isVisibleOnly(CRHomePage.memberDetailsOnSearchCalls, "Results found");
        assertTrue(searchResult, "Results Found After Search");
        /*        if(searchResult) {
            assertTrue(searchResult, "Results Found After Search");

        }else{
            assertFalse(searchResult, "No Records Found After Search");
        }*/
        Thread.sleep(2000);
    }
    public void clickSearchAgainOnSearchCalls() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnSearchAgain, "Search Again");
        click(CRSearchCallsPage.btnSearchAgain, "Search Again");
        Thread.sleep(2000);

    }



    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectCallIDOnSearCallWindow
     * description ::
     * date :: 03-Jan-2018
     * Updated date :: 29-Jan-2018
     * author ::Abhiram/Varun
     */
    public void searchAndSelectCallIDOnSearCallWindow(String CallID) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Call ID in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found after search");
        }
        else{
            allCallIds = getWebElementList(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, "Call ID in Search Call Window");

            for (int i = 0; i < allCallIds.size(); i++) {
                callIdFromList = allCallIds.get(i).getText();
                String callIdFromExcel = CallID;
                if (callIdFromList.contains(callIdFromExcel)) {
                    callIDFlag=true;

                }
                else {
                    callIDFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(callIDFlag, "Call Id " + CallID + "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);
    }

    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectMemberLastNameOnSearCallWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void searchAndSelectMemberLastNameOnSearCallWindow(String MemberLastNameData) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Last Name in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found after search");
        }
        else{
            MemberLastName = getWebElementList(CRSearchCallsPage.MemberLastNameOnSearchCallsInSearclCallWindow, "Last Name in Search Call Window");

            for (int i = 0; i < MemberLastName.size(); i++) {
                MemberLastNameFromList = MemberLastName.get(i).getText();
                String LastnameFromExcel = MemberLastNameData;
                if (MemberLastNameFromList.contains(LastnameFromExcel)) {
                    lastNameFlag=true;

                }
                else {
                    lastNameFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(lastNameFlag, "Member Last Name " + MemberLastNameData+ "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);
    }
    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectClubNumberOnSearCallWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void searchAndSelectClubNumberOnSearCallWindow(String ClubNumber) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Club Number in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found after search");
        }
        else{
            allClubNumbers = getWebElementList(CRSearchCallsPage.ClubNumberOnSearchCallsInSearclCallWindow, "Club Number in Search Call Window");

            for (int i = 0; i < allClubNumbers.size(); i++) {
                ClubNumbersFromList = allClubNumbers.get(i).getText();
                String ClubNumberFromExcel = ClubNumber;
                if (ClubNumbersFromList.contains(ClubNumberFromExcel)) {
                    ClubNoFlag=true;

                }
                else {
                    ClubNoFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(ClubNoFlag, "Club Number " + ClubNumber + "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);
    }
    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectMemberNumberOnSearCallWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void searchAndSelectMemberNumberOnSearCallWindow(String MemberNumber) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Member Number in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found after search");
        }
        else{
            allMemberNumber = getWebElementList(CRSearchCallsPage.MemberNumberOnSearchCallsInSearclCallWindow, "Member Number in Search Call Window");

            for (int i = 0; i < allMemberNumber.size(); i++) {
                MemberNumberFromList = allMemberNumber.get(i).getText();
                String memberNumberFromExcel = MemberNumber;
                if (MemberNumberFromList.contains(memberNumberFromExcel)) {
                    MemberNumberFlag=true;

                }
                else {
                    MemberNumberFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(MemberNumberFlag, "Member Number " + MemberNumber + "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);
    }

    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectLocationOnSearCallWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void searchAndSelectLocationOnSearCallWindow(String BKDownStreetAddress) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Location in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found after search");
        }
        else{
            allLocation = getWebElementList(CRSearchCallsPage.LocationOnSearchCallsInSearclCallWindow, "Location in Search Call Window");

            for (int i = 0; i < allLocation.size(); i++) {
                allLocationFromList = allLocation.get(i).getText();
                String allLocationFromListFromExcel =BKDownStreetAddress;
                if (allLocationFromList.contains(allLocationFromListFromExcel)) {
                    locationFlag=true;

                }
                else {
                    locationFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(locationFlag, "Location " + BKDownStreetAddress + "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);

    }

    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectCityOnSearCallWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void searchAndSelectCityOnSearCallWindow(String BKDownCityLocation) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "City in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found after search");
        }
        else{
            allCity = getWebElementList(CRSearchCallsPage.CityOnSearchCallsInSearclCallWindow, "City in Search Call Window");

            for (int i = 0; i < allCity.size(); i++) {
                allCityFromList = allCity.get(i).getText();
                String cityFromExcel = BKDownCityLocation;
                if (allCityFromList.contains(cityFromExcel)) {
                    CityFlag=true;

                }
                else {
                    CityFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(CityFlag, "City " + BKDownCityLocation + "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);
    }
    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectVehicleYearOnSearCallWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void searchAndSelectVehicleYearOnSearCallWindow(String VehicleYear) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Vehicle Year in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found after search");
        }
        else{
            allVehicleYear = getWebElementList(CRSearchCallsPage.VehicleYearOnSearchCallsInSearclCallWindow, "Vehicle Year in Search Call Window");

            for (int i = 0; i < allVehicleYear.size(); i++) {
                vehicleYearFromList = allVehicleYear.get(i).getText();
                String vehicleYearFromExcel = VehicleYear;
                if (vehicleYearFromList.contains(vehicleYearFromExcel)) {
                    vehicleYearFlag=true;

                }
                else {
                    vehicleYearFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(vehicleYearFlag, "Vehicle Year " + VehicleYear + "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);

    }
    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectVehicleMakeOnSearCallWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void searchAndSelectVehicleMakeOnSearCallWindow(String VehicleMake) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Vehicle Make in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found after search");
        }
        else{
            allVehicleMake = getWebElementList(CRSearchCallsPage.VehicleMakeOnSearchCallsInSearclCallWindow, "Vehicle Make in Search Call Window");

            for (int i = 0; i < allVehicleMake.size(); i++) {
                vehicleMakeFromList = allVehicleMake.get(i).getText();
                String vehicleMakeFromExcel = VehicleMake;
                if (vehicleMakeFromList.contains(vehicleMakeFromExcel)) {
                    vehicleMakeFlag=true;

                }
                else {
                    vehicleMakeFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(vehicleMakeFlag, "Vehicle Make " + VehicleMake + "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);

    }

    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectVehicleModelOnSearCallWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void searchAndSelectVehicleModelOnSearCallWindow(String VehicleModel) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Vehicle Model in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found after search");
        }
        else{
            allVehicleModel = getWebElementList(CRSearchCallsPage.VehicleModelOnSearchCallsInSearclCallWindow, "Vehicle Model in Search Call Window");

            for (int i = 0; i < allVehicleModel.size(); i++) {
                vehicleModelFromList = allVehicleModel.get(i).getText();
                String vehicleModelFromExcel = VehicleModel;
                if (vehicleModelFromList.contains(vehicleModelFromExcel)) {
                    vehicleModelFlag=true;

                }
                else {
                    vehicleModelFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(vehicleModelFlag, "Vehicle Model " + VehicleModel + "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);
    }

    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectRAPOnSearCallWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void searchAndSelectRAPOnSearCallWindow(String RAP) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "RAP in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found after search");
        }
        else{
            allRAP = getWebElementList(CRSearchCallsPage.RAPOnSearchCallsInSearclCallWindow, "RAP in Search Call Window");

            for (int i = 0; i < allRAP.size(); i++) {
                RAPFromList = allRAP.get(i).getText();
                String RAPFromExcel = RAP;
                if (RAPFromList.contains(RAPFromExcel)) {
                    RAPFlag=true;

                }
                else {
                    RAPFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(RAPFlag, "RAP " + RAP+ "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickCallIDLinkOnSearchCallsWindow
     * description ::
     * date :: 04-jan-2017
     * author ::Abhiram
     */
    public void clickCallIDLinkOnSearchCallsWindow() throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.linkCallDateOnSearchCallsInSearclCallWindow,"Call ID link");
        click(CRSearchCallsPage.linkCallDateOnSearchCallsInSearclCallWindow, "Call ID link");

    }
    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndVerifyPhoneNumberOnSearCallWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Abhiram
     */
    public void searchAndVerifyPhoneNumberOnMembersPage(Hashtable<String, String> data) throws Throwable {


        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Phone number in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found after search");
        }
        else{
            memberPhoneNumber = getWebElementList(CRSearchCallsPage.phoneNumbersListOnSearchCallsInSearclCallWindow, "Phone number in Search Call Window");

            for (int i = 0; i < memberPhoneNumber.size(); i++) {
                String PhoneNumberFromList = memberPhoneNumber.get(i).getAttribute("value");
                String abc1=PhoneNumberFromList.substring(1,4);
                String abc2=PhoneNumberFromList.substring(6,8);
                String abc3=PhoneNumberFromList.substring(10,13);
                String memberPhone=abc1+abc2+abc3;
                String PhoneNumberFromExcel = data.get("PhoneNumber");
                if (memberPhone.contains(PhoneNumberFromExcel)) {
                    memberPhoneFlag=true;

                }
                else {
                    memberPhoneFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(memberPhoneFlag, "Phone Number " + data.get("PhoneNumber") + "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);



    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickCallSummaryIconOnMemberspage
     * description ::
     * date :: 04-jan-2017
     * author ::Abhiram
     */
    public void clickCallSummaryIconOnMemberspage(String PhoneNumber) throws Throwable
    {

        waitForVisibilityOfElement(CRSearchCallsPage.linkCallSummaryIconOnMemberspage,"Call Summary icon");

        click(CRSearchCallsPage.linkCallSummaryIconOnMemberspage, "Call Summary icon");
        waitForVisibilityOfElement(CRSearchCallsPage.phoneNumberOnCallSummaryPOPUp, "Summary Pop Up");
        Thread.sleep(3000);
        String phoneString1=getText(CRSearchCallsPage.phoneNumberOnCallSummaryPOPUp, "Phone number").substring(8, 11);
        String phoneString2=getText(CRSearchCallsPage.phoneNumberOnCallSummaryPOPUp, "Phone number").substring(13,16);
        String phoneString3=getText(CRSearchCallsPage.phoneNumberOnCallSummaryPOPUp, "Phone number").substring(17,21);

        String phone=phoneString1+phoneString2+ phoneString3;

        String callIdFromExcel = PhoneNumber;
        assertTrue(phone.equalsIgnoreCase(callIdFromExcel),"Phone Number is matching");
        /*if (phoneNumber.equalsIgnoreCase(callIdFromExcel)) {
            assertTrue(true,"Phone Number is matching");
        }
        else {
            assertFalse(false,"Phone Number is not matching");
        }*/
        Thread.sleep(2000);
    }

    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectTruckIDOnSearCallWindow
     * description ::
     * date :: 04-Jan-2018
     * author ::Abhiram
     */
    public void searchAndSelectTruckIDOnSearCallWindow(String TruckID) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Truck ID in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found after search");
        }
        else{
            allTruckID = getWebElementList(CRSearchCallsPage.TruckIDDetailsOnSearchCallsInSearclCallWindow, "Truck ID in Search Call Window");

            for (int i = 0; i < allTruckID.size(); i++) {
                truckIDFromList = allTruckID.get(i).getText();
                String truckIDFromExcel = TruckID;
                if (truckIDFromList.contains(truckIDFromExcel)) {
                    truckIDFlag=true;

                }
                else {
                    truckIDFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(truckIDFlag, "Truck ID " + TruckID + "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);
    }
    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectFacilityOnSearCallWindow
     * description ::
     * date :: 04-Jan-2018
     * author ::Abhiram
     */
    public void searchAndSelectFacilityOnSearCallWindow(String facility) throws Throwable {
        boolean verifySearchResults = isVisibleOnly(CRSearchCallsPage.txtMessageNoDataAvailableForSearchResults, "Facility in Search Call Window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found after search");
        }
        else{
            allFacility = getWebElementList(CRSearchCallsPage.FacilityDetailsOnSearchCallsInSearclCallWindow, "Facility in Search Call Window");

            for (int i = 0; i < allFacility.size(); i++) {
                facilityFromList = allFacility.get(i).getText();
                String facilityFromExcel = facility;
                if (facilityFromList.contains(facilityFromExcel)) {
                    FacilityFlag=true;

                }
                else {
                    FacilityFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(FacilityFlag, "Facility " + facility + "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);
    }

    /**
     * param ::NA
     * return ::void
     * throws :: throwable
     * methodName :: getDateFromMemberPageandChangeFormat
     * description ::
     * retrivedTime :: 03-Jan-2018
     * author ::Abhiram
     */

    public void getDateFromMemberPageandChangeFormat(String startTime, String EndTime) throws  Throwable{
        waitForVisibilityOfElement(CRSearchCallsPage.clickOnCallIdLinkInSearchCalls,"Click On Call ID");
        click(CRSearchCallsPage.clickOnCallIdLinkInSearchCalls, "Click On Call ID");
        Thread.sleep(5000);
        waitForVisibilityOfElement(CRSearchCallsPage.lblDateInMemberPage,"Getting Date From Member Tab");
        String dateDetails= getText(CRSearchCallsPage.lblDateInMemberPage,"Getting Date From Member Tab");
        String splitStr[] = dateDetails.split(",");
        String dateSplitted = splitStr[1];
        displayFormat = new SimpleDateFormat("HH:mm");
        parseFormat = new SimpleDateFormat("hh:mm a");
        date = parseFormat.parse(splitStr[1]);

        time = displayFormat.format(date);
        String splittime[] = time.split(":");
        String callTimeSplittedInHours = splittime[0];
        String callTimeSplittedInMinutes = splittime[1];
        callTimeInHours = Integer.parseInt(callTimeSplittedInHours);
        callTimeInMinutes = Integer.parseInt(callTimeSplittedInMinutes);

        startTimeInSearch = startTime;
        String splitstartTimeInSearch[] = startTimeInSearch.split(":");
        String startTimeSplittedInHours = splitstartTimeInSearch[0];
        String startTimeSplittedInMinute = splitstartTimeInSearch[1];
        startTimeInHours = Integer.parseInt(startTimeSplittedInHours);
        startTimeInMinutes = Integer.parseInt(startTimeSplittedInMinute);

        endTimeInSearch =EndTime;
        String splitEndTimeInExcel[] = endTimeInSearch.split(":");
        String endTimeSplittedInHours = splitEndTimeInExcel[0];
        String endTimeSplittedInMinutes = splitEndTimeInExcel[1];
        endTimeInHours = Integer.parseInt(endTimeSplittedInHours);
        endTimeInMinutes = Integer.parseInt(endTimeSplittedInMinutes);
        
        assertTrue((callTimeInHours >= startTimeInHours && callTimeInHours <= endTimeInHours),"The Call Time:: "+time +" is between:: "+startTimeInSearch+" start and End Time:: "+endTimeInSearch);
        /*if(callTimeInHours >= startTimeInHours && callTimeInHours <= endTimeInHours){
            //if(timeInIntInMinute>stimeInIntInminute && timeInIntInMinute<etimeInIntInMinute){
            assertTrue(true,"The Call Time:: "+time +" is between:: "+startTimeInSearch+" start and End Time:: "+endTimeInSearch);
        }else{
            assertFalse(false,"The Call Time "+time +" is not between "+startTimeInSearch+" start and End Time"+endTimeInSearch);
        }*/
        Thread.sleep(2000);
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getStartDateSearchDetails
     * description ::
     * retrivedTime :: 04-Jan-2018
     * author ::Abhiram
     */
    public String getStartDateSearchDetails() throws Throwable {
        //String vehicleSearchDetailsLocator = String.valueOf(CRVehicleTriagePage.txtVehicleSearch);
        startDateInSearchDetails = getAttributeByValue(CRSearchCallsPage.txtStartDateInSearchCall,"Start date in Search");
        return startDateInSearchDetails;

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdAndDate
     * description ::
     * retrivedTime :: 04-Jan-2018
     * author ::Abhiram
     */
    public String getCallIdAndDate() throws Throwable {
        boolean visibilityOfCallIdAndDate = isVisibleOnly(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, " Call Id and Date is avaiable");
        assertTrue(visibilityOfCallIdAndDate, "Call Id and Date is avaiable");
        String startDate = getText(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, "Call Id and Date is avaiable");
        
        /*if (visibilityOfCallIdAndDate) {
            assertTrue(visibilityOfCallIdAndDate, "Call Id and Date is avaiable");
             //String startDate = getText(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, "Call Id and Date is avaiable");
        } else {
            assertFalse(visibilityOfCallIdAndDate, " Call Id and Date is avaiable");
        }*/
        return startDate;
    }

    /**
     * convertDateFormatToAnotherDateFormat, Function to convert one date format to another date format
     *
     * @param actualDate        of (String), Actual date (e.g: Dec 5, 2017)
     * @param sourceFormat      of (String), format of actualDate (e.g: MM dd, yyyy)
     * @param destinationFormat of (String), Format what we required (e.g: dd/MM/yyyy)
     * @return : String
     */
    protected String convertDateFormatToAnotherDateFormat(String actualDate, String sourceFormat, String destinationFormat) throws Throwable {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sourceFormat);
        SimpleDateFormat sdf = new SimpleDateFormat(destinationFormat);
        Date date = simpleDateFormat.parse(actualDate);
        return sdf.format(date);
    }
    public void verifyStartAndEndDateOnSearchCallWindow(String expectedStartDate) throws Throwable {
        //getCallIdAndDate();
        //String startDate=convertDateFormatToAnotherDateFormat(getStartDateSearchDetails(),"M/D/YYYY", "M/D/YYYY");

       /* String abc=getStartDateSearchDetails();
        System.out.println("abc is +++++++++++++" + abc);*/
        String date2=getCallIdAndDate();
        String splitStr[] = date2.split("\n");
        String startDateValue= splitStr[0];

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date d_date = dateFormat.parse(startDateValue);
        String strDate = dateFormat.format(d_date);
        assertTrue(true,strDate+"Date");
       // String expectedStrDate= getStartDateSearchDetails();
        //boolean dateComparision = strDate==StrDate1;
        boolean dateComparision = strDate.equalsIgnoreCase(expectedStartDate);
        /*if(dateComparision){
            assertTrue(dateComparision,"Start date:: "+strDate+ " is same as expected:: "+expectedStartDate);
        }else{
            assertFalse(dateComparision,"Start date:: "+strDate+ " is same as expected:: "+expectedStartDate);
        }*/
        assertTrue(dateComparision,"Start date:: "+strDate+ " is same as expected:: "+expectedStartDate);
        Thread.sleep(2000);
         /*if(startDate.equalsIgnoreCase(startDateValue)){
            //if(timeInIntInMinute>stimeInIntInminute && timeInIntInMinute<etimeInIntInMinute){
            assertTrue(true, "The Start date entered is same as in result found");
        }else{
            assertFalse(false,"The Start date entered is not same as in result found");
        }
        convertDate();*/

    }

    public void convertDate() throws Throwable{

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date d_date = dateFormat.parse(startDateValue);

        String strDate = dateFormat.format(d_date);
    }


  /*  *//**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberFirstNameSearchOnSearchCallsWindow
     * description ::
     * date :: 11-jan-2017
     * author ::Ravi
     *//*
    public void enterMemberFirstNameSearchOnSearchCallsWindow(String MemberFirstName) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtMemberFirstNameSearch,"Search Calls Window member first Name");
        type(CRSearchCallsPage.txtMemberFirstNameSearch,MemberFirstName, "Search Calls Window member first Name");
    }*/


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberLastNameSearchOnSearchCallsWindow
     * description ::
     * date :: 11-jan-2017
     * author :: Ravi
     */
    public void enterMemberFirstNameAndLastNameOnSearchCallsWindow(String MemberFirstName,String memberLastName) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtMemberLastNameSearch,"Search Calls Window memberLastName");
        type(CRSearchCallsPage.txtMemberFirstNameSearch,MemberFirstName, "Search Calls Window member first Name");
        firstNameInSearch = getText(CRSearchCallsPage.txtMemberFirstNameSearch, "Search Calls Window memberLastName");
        type(CRSearchCallsPage.txtMemberLastNameSearch,memberLastName, "Search Calls Window memberLastName");
        lastNameInSearch =getText(CRSearchCallsPage.txtMemberLastNameSearch, "Search Calls Window memberLastName");

    }
    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectMemberLastNameOnSearCallWindow
     * description ::
     * date :: 11-Jan-2018
     * author ::Ravi
     */
    public void searchAndSelectMemberFirstandLastNameOnSearCallWindow(Hashtable<String, String> data) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.MemberLastNameOnSearchCallsInSearclCallWindow, "Member Last Name in Search Call Window");
        MemberLastName = getWebElementList(CRSearchCallsPage.MemberLastNameOnSearchCallsInSearclCallWindow, "Member Last Name in Search Call Window");
     boolean verification=true;

       boolean membersFirstName=true;
        boolean membersLstNaame=true;
        if (MemberLastName != null) {
            for (int i = 1; i < MemberLastName.size(); i++) {
                String MemberLastNameList =getText(CRSearchCallsPage.getFirstNameAndLastName(i),"astdynamically");
                membersFirstName= MemberLastNameList.contains(data.get("MemberFirstName"));
                membersLstNaame= MemberLastNameList.contains(data.get("MemberLastName"));
                if(!membersFirstName&&membersLstNaame)
                    verification=false;
                break;
                }
            assertTrue(verification,"verified first name and Last Name");
            Thread.sleep(2000);

            }
        }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterEndDateOnSearchCallsWindow
     * description ::
     * date :: 11-Jan-2018
     * author ::Ravi
     */
    public void enterEndDateOnSearchCallsWindow(String EndDate) throws Throwable
    {

        waitForVisibilityOfElement(CRSearchCallsPage.txtEndDateInSearchCall, "Search Calls Window End date");
        type(CRSearchCallsPage.txtEndDateInSearchCall,EndDate, "Search Calls Window End date");
        Thread.sleep(3000);
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCommCenterOnSearchCallsWindow
     * description ::
     * date :: 11-Jan-2017
     * author ::Ravi
     */
    public void enterCommCenterOnSearchCallsWindow(String commCenter) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtCommCenter,"Search Calls Window callTaker");
        type(CRSearchCallsPage.txtCommCenter,commCenter, "Search Calls Window callTaker");
        Thread.sleep(2000);
    }



    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFirstRowInSearchCalls
     * description ::click On First Row In Search Calls
     * date :: 11-Jan-2017
     * author ::Ravi
     */
    public void clickOnFirstRowInSearchCalls() throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.searchResultFound,"clicks on Search Calls row");
        click(CRSearchCallsPage.searchResultFound,"clicks on Search Calls row");
        Thread.sleep(2000);
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextAndClickOnOkOnInvalidErrorPopup
     * description ::gets the text of invalid error and clicks on ok
     * date :: 12-Jan-2017
     * author ::Ravi
     */
    public void getTextAndClickOnOkOnInvalidErrorPopup() throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.invalidSearchCriteriaError,"Invalid search criteria Error popup");
        getText(CRSearchCallsPage.invalidSearchCriteriaError,"Invalid search criteria Error popup");
        Thread.sleep(2000);
        click(CRSearchCallsPage.okOnInvalidError,"Invalid search criteria Error popup");
        Thread.sleep(2000);
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFirstRowInSearchCall
     * description ::clicks On FirstRow In SearchCall
     * date :: 12-Jan-2017
     * author ::Ravi
     */
    public void clickOnFirstRowInSearchCall() throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.searchResultFound,"Invalid search criteria Error popup");
        click(CRSearchCallsPage.searchResultFound,"Invalid search criteria Error popup");
        Thread.sleep(2000);
    }


    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectDatesOnSearCallWindow
     * description ::
     * date :: 12-Jan-2018
     * author ::Ravi
     */
    public void searchAndSelectDatesOnSearCallWindow(Hashtable<String, String> data) throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.dateInSearchCallsInSearclCallWindow, "Date in Search Call Window");
        allDates = getWebElementList(CRSearchCallsPage.dateInSearchCallsInSearclCallWindow, "Date in Search Call Window");
        if (allDates != null) {
            for (int i = 0; i < allDates.size(); i++) {
                String dateFromList = allDates.get(i).getText();
                String endDateArchiveFromExcel = data.get("EndDateArchive");
                /* if (dateFromList.contains(endDateArchiveFromExcel)) {
                    assertTrue(true,"Date Exists in Selected List");
                }
                else {
                    assertFalse(false,"Date Not Exists in selected List");
                }*/
                assertTrue(dateFromList.contains(endDateArchiveFromExcel),"Date Exists in Selected List");

                   // assertTrue(dateFromList.contains(endDateArchiveFromExcel),"Date Exists in Selected List");
            }
        }
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextOfNoMatchingRecords
     * description ::getText Of No Matching Records
     * date :: 12-Jan-2017
     * author ::Ravi
     */
    public void getTextOfNoMatchingRecords() throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtNoMatchingRecords,"Invalid search criteria Error popup");
        getText(CRSearchCallsPage.txtNoMatchingRecords,"Invalid search criteria Error popup");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTypeAsLiveOnly
     * description ::
     * date :: 12-jan-2017
     * author ::Ravi
     */
    public void enterCallTypeAsLiveOnly(String LiveOnly) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.selectCallsType, "select Calls as live calls");
        type(CRSearchCallsPage.selectCallsType,LiveOnly, "Search Calls live calls");
        Thread.sleep(2000);
        getText(CRSearchCallsPage.selectCallsType, "Search Calls live calls");
        Thread.sleep(1000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTypeAsLiveAndArchived
     * description ::
     * date :: 12-jan-2017
     * author ::Ravi
     */
    public void enterCallTypeAsLiveAndArchived(String LiveAndArchived) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.selectCallsType, "select Calls as live calls");
        type(CRSearchCallsPage.selectCallsType,LiveAndArchived, "Search Calls live calls");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextOfCallType
     * description ::
     * date :: 12-jan-2017
     * author ::Ravi
     */
    public void getTextOfCallType() throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.selectCallsType, "select Calls as live and archived");
        getText(CRSearchCallsPage.selectCallsType, "Search Calls live and archived");
        Thread.sleep(1000);
    }

   // assertTrue(true,strDate+"Date");
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextAndClickOnOkOnInvalidErrorPopupLiveOnly
     * description ::gets the text of invalid error on liveonly and clicks on ok
     * date :: 16-Jan-2017
     * author ::Ravi
     */
    public void getTextAndClickOnOkOnInvalidErrorPopupLiveOnly() throws Throwable
    {
        getText(CRSearchCallsPage.invalidSearchCriteriaErrorOnLiveOnly,"Invalid search criteria Error popup on live only");
        click(CRSearchCallsPage.okOnInvalidError,"Invalid search criteria Error popup");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextAndClickOnOkOnInvalidErrorPopupLiveAndArchived
     * description ::gets the text of invalid error on live and archived and clicks on ok
     * date :: 16-Jan-2017
     * author ::Ravi
     */
    public void getTextAndClickOnOkOnInvalidErrorPopupLiveAndArchived() throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.invalidSearchCriteriaErrorOnLiveAndArchive,"Invalid search criteria Error popup on live and archived");
        getText(CRSearchCallsPage.invalidSearchCriteriaErrorOnLiveAndArchive,"Invalid search criteria Error popup on live and archived");
        Thread.sleep(2000);
        click(CRSearchCallsPage.okOnInvalidError,"Invalid search criteria Error popup");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallsTypeInSearchCalls
     * description ::enter calls type in Calls dropdown in search calls window
     * date :: 16-Jan-2017
     * author ::Varun
     */
    public void enterCallsTypeInSearchCalls(String callType) throws Throwable
    {
        waitForVisibilityOfElement(CRSearchCallsPage.txtCallsInSearchCalls,"Calls type dropdown");
        type(CRSearchCallsPage.txtCallsInSearchCalls, callType, "Calls type dropdown");
        Thread.sleep(2000);
    }


    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdOnSearCallWindow
     * description ::
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public String getCallIdOnSearCallWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, "Call ID in Search Call Window");

        allCallIds = getWebElementList(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, "Call ID in Search Call Window");

        String callIdFromList = allCallIds.get(0).getText();
        System.out.println("call id is" + callIdFromList);
        String abc1=callIdFromList.substring(callIdFromList.lastIndexOf("#")+1);
        //int callId = Integer.parseInt(abc1);
        Thread.sleep(2000);
        return abc1;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickDuplicateIconOnSearCallWindow
     * description ::
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public void clickDuplicateIconOnSearCallWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.duplicateCallsIconInSearchCallWindow, "Duplicate Icon");
        click(CRSearchCallsPage.duplicateCallsIconInSearchCallWindow, "Duplicate icon");
        Thread.sleep(4000);


    }

    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdFromMemberTab
     * description ::
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public String getCallIdFromMemberTab() throws Throwable {
      // waitForVisibilityOfElement(CRMemberSearchPage.lblMemberCallId, "Call ID on Member tab");
        String callIdFromMemberTab = getText(CRMemberSearchPage.lblMemberCallId,"Call ID on Member Tab");
        System.out.println("call id is" + callIdFromMemberTab);

        Thread.sleep(2000);
        return callIdFromMemberTab;
    }
    /**
     * Description:This method is used to click on current calls dropdown
     * Date:17-Jan-2018
     * @throws Throwable
     */
    public void clickOnCurrentCallsDropDown() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.drpdwnCurrentCall, "Current Calls Menu");
        click(CRSearchCallsPage.drpdwnCurrentCall, "Current Calls Menu");
    }

    /**
     *  Description:This method is used to click on Send ETA Request under Current calls dropdown
     *  Date:17-Jan-2018
     * @throws Throwable
     */
    public void clickOnSendETARequestLink() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.lnkSendETARequest, "Send ETA Request");
        click(CRSearchCallsPage.lnkSendETARequest, "Send ETA Request");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRecentCallsInSearchCalls
     * description ::
     * date :: 17-Jan-2018
     * author ::Sachin
     */
    public void clickOnRecentCallsInSearchCalls() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        click(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRSearchCallsPage.linkRecentCalls, "Recent Calls");
        click(CRSearchCallsPage.linkRecentCalls, "Search Calls");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdAndDateFromRecentCalls
     * description ::
     * retrivedTime :: 017-Jan-2018
     * author ::Sachin
     */
    public String getCallIdAndDateFromRecentCalls() throws Throwable {
        boolean visibilityOfCallIdAndDate = isVisibleOnly(CRSearchCallsPage.callIDDetailsOnRecentCallsInRecentCallWindow, " Call Id and Date is avaiable");
        String startDate = getText(CRSearchCallsPage.callIDDetailsOnRecentCallsInRecentCallWindow, "Call Id and Date is avaiable");
        /*if (visibilityOfCallIdAndDate) {
            assertTrue(visibilityOfCallIdAndDate, "Call Id and Date is avaiable");
            //String startDate = getText(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, "Call Id and Date is avaiable");
        } else {
            assertFalse(visibilityOfCallIdAndDate, " Call Id and Date is avaiable");
        }*/
        assertTrue(visibilityOfCallIdAndDate, "Call Id and Date is avaiable");
        return startDate;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnCallIdOnRecentCallsWindow
     * description ::
     * retrivedTime :: 017-Jan-2018
     * author ::Sachin
     */
    public void ClickOnCallIdOnRecentCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.callIDDetailsOnRecentCallsInRecentCallWindow, "Call Id and Date");
        click(CRSearchCallsPage.callIDDetailsOnRecentCallsInRecentCallWindow, "Call Id and Date");
    }


   




    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickDuplicateCallIDConfYes
     * description ::
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public void clickDuplicateCallIDConfYes() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnDuplicateYes, "Yes");
        click(CRSearchCallsPage.btnDuplicateYes, "Yes");
        Thread.sleep(6000);


    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickDuplicateCallIDConfNo
     * description ::
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public void clickDuplicateCallIDConfNo() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnDuplicateNo, "No");
        click(CRSearchCallsPage.btnDuplicateNo, "No");
        Thread.sleep(4000);


    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickCloseBtnOnSearchCallwindow
     * description ::
     * date :: 16-Jan-2018
     * author ::Varun
     */
    public void clickCloseBtnOnSearchCallwindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnCloseSearchCalWindow, "Close");
        click(CRSearchCallsPage.btnCloseSearchCalWindow, "Close");
        Thread.sleep(4000);


    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRecentCallsOnSearchCalls
     * description ::
     * date :: 17-Jan-2018
     * author ::Varun
     */
    public void clickOnRecentCallsOnSearchCalls() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        click(CRSearchCallsPage.dropdownSearchCalls, "Search Calls");
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRSearchCallsPage.linkRecentCalls, "Recent Calls");
        click(CRSearchCallsPage.linkRecentCalls, "Recent Calls");
    }
    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdOnRecentCallWindow
     * description ::
     * date :: 17-Jan-2018
     * author ::Varun
     */
    public String getCallIdOnRecentCallWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.callIDDetailsOnRecentCallsInSearclCallWindow, "Call ID in Search Call Window");

        allCallIds = getWebElementList(CRSearchCallsPage.callIDDetailsOnRecentCallsInSearclCallWindow, "Call ID in Search Call Window");

        String callIdFromList = allCallIds.get(0).getText();
        System.out.println("call id is" + callIdFromList);
        String abc1=callIdFromList.substring(callIdFromList.lastIndexOf("#")+1);
        //int callId = Integer.parseInt(abc1);
        Thread.sleep(2000);
        return abc1;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickDuplicateIconOnRecentCallWindow
     * description ::
     * date :: 17-Jan-2018
     * author ::Varun
     */
    public void clickDuplicateIconOnRecentCallWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.duplicateCallsOnRecentCallsInSearclCallWindow, "Duplicate Icon");
        click(CRSearchCallsPage.duplicateCallsOnRecentCallsInSearclCallWindow, "Duplicate icon");
        Thread.sleep(4000);


    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseButton
     * description ::
     * date :: 17-Jan-2018
     * author ::Ravi
     */
    public void clickOnCloseButton() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.btnCloseSearchCall, "Duplicate Icon");
        click(CRSearchCallsPage.btnCloseSearchCall, "Duplicate icon");
        Thread.sleep(4000);


    }

    /**
     * Description:This method is used to click on the call ID&Date on search call window
     * date:18-01-2018
     * @author : madhuakar
     * @throws Throwable
     */
    public void clickOnCallIdDateOnSearchCallsWindow()throws Throwable{
        waitForVisibilityOfElement(CRSearchCallsPage.lnkCallIDOnSearchCalls,"Call ID And Date Link");
        click(CRSearchCallsPage.lnkCallIDOnSearchCalls,"Call ID And Date Link");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnCallIdOnSearchCallsWindow
     * description ::
     * retrivedTime :: 18-Jan-2018
     * author ::Sachin
     */
    public void ClickOnCallIdOnSearchCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRSearchCallsPage.clickOnCallIdLinkInSearchCalls, "Call Id and Date");
        click(CRSearchCallsPage.clickOnCallIdLinkInSearchCalls, "Call Id and Date");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextNoMatchingRecords
     * description ::getTextNoMatchingRecords
     * date :: 16-Jan-2017
     * author ::Ravi
     */
    public void getTextNoMatchingRecords() throws Throwable
    {
        getText(CRSearchCallsPage.invalidSearchCriteriaErrorOnLiveOnly,"Invalid search criteria Error popup on live only");
        click(CRSearchCallsPage.okOnInvalidError,"Invalid search criteria Error popup");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdInSearchCall
     * description ::getCallIdInSearchCall
     * date :: 31-Jan-2017
     * author ::Ravi
     */
    public String getCallIdInSearchCall() throws Throwable
    {
        getText(CRSearchCallsPage.lblDateInMemberPage,"call id and time");
        String callIdAndDate= getText(CRSearchCallsPage.lblDateInMemberPage,"Getting Date From Member Tab");
        String splitStr[] = callIdAndDate.split(",");
        String callIdAndDateSplit = splitStr[0];
        return callIdAndDateSplit;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStatusOnSearchCallsWindow
     * description ::
     * date :: 06-Feb-2017
     * author ::Varun
     */
    public void enterStatusOnSearchCallsWindow(String Status) throws Throwable
    {
        waitForVisibilityOfElement(CRHomePage.txtCallStatus,"Search Calls Window RAPNumber");
        type(CRHomePage.txtCallStatus,Status, "Search Calls Window RAPNumber");
    }




}
