package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.CRRecentCallsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class CRRecentCallsLib extends ActionEngine {

    public List<WebElement> allCallIds;
    public List<WebElement> contactInfo;
    public String callIdFromList;
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

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getCallDateIDLabel
     * description ::
     * date :: 11-Jan-2018
     * author ::Chandra
     */
    public void getCallDateIDLabel() throws Throwable{
         String callIdandDateLabel=getText(CRRecentCallsPage.lblCallDateID,"Call Date ID label");
         //assertTrue(true,"Verified the displayed Call Date ID label    "+callIdandDateLabel);
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getContactInformationLabel
     * description ::
     * date :: 11-Jan-2018
     * author ::Chandra
     */
    public void getContactInformationLabel() throws Throwable{
        String contactInfoLabel=getText(CRRecentCallsPage.lblContactInformation,"Contact Inforamtion Label");
        //assertTrue(true,"Verified the displayed Contact Inforamtion Label    "+contactInfoLabel);
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getVehicleInformationLabel
     * description ::
     * date :: 11-Jan-2018
     * author ::Chandra
     */
    public void getVehicleInformationLabel() throws Throwable{
        String vehicelInfoLabel=getText(CRRecentCallsPage.lblVehicleInformation,"Vehicle Inforamtion Label");
        //assertTrue(true,"Verified the displayed Vehicle Inforamtion Label       "+vehicelInfoLabel);
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getActionLabel
     * description ::
     * date :: 11-Jan-2018
     * author ::Chandra
     */
    public void getActionLabel() throws Throwable{
        String actionLabel= getText(CRRecentCallsPage.lblActions,"Action Label");
        //assertTrue(true,"Verified the displayed Actions Label     "+actionLabel);
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRecentCallsFromDropDownMenu
     * description ::
     * date :: 11-Jan-2018
     * author ::Chandra
     */
    public void clickOnRecentCallsFromDropDownMenu() throws Throwable{
        click(CRRecentCallsPage.lnkRecentCalls,"Recent Calls");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getRecentCallsOptionName
     * description ::
     * date :: 11-Jan-2018
     * author ::Chandra
     */
    public void verifyRecentCallsOptionName()throws  Throwable{
        String recentCalls = getText(CRRecentCallsPage.lnkRecentCalls,"Recent Calls Option");
        //assertTrue(true,"Verified the RecentCalls Option & present with the name    "+recentCalls);
        //return recentCalls;
    }

    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectCallIDOnSearCallWindow
     * description ::
     * date :: 12-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public void searchAndSelectCallIDOnSearCallWindow(String callID) throws Throwable {
        waitForVisibilityOfElement(CRRecentCallsPage.lblCallDateIDResultValue, "Call ID in Search Call Window");
        allCallIds = getWebElementList(CRRecentCallsPage.lblCallDateIDResultValue, "Call ID in Search Call Window");
        if (allCallIds != null) {
            for (int i = 0; i < allCallIds.size(); i++) {
                String callIdAndDateFromList = allCallIds.get(i).getText();
                assertTrue(callIdAndDateFromList.contains(callID), "Recently Saved call id displayed in the list     " + callID);
                if (callIdAndDateFromList.contains(callID)) {
                    Actions action = new Actions(driver);
                    Thread.sleep(1000);
                   // mouseDoubleClick()
                    action.click(allCallIds.get(i)).build().perform();
                    //mouseDoubleClick(CRRecentCallsPage.lblCallDateIDResultValue,"Double cliock On recent call");
                }
            }
        }

    }
    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: getMemberNumberfromRecentCallSearch
     * description ::
     * date :: 12-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public String getMemberNumberfromRecentCallSearch(String callID)throws  Throwable{
        String memberNumber=null;
        //waitForVisibilityOfElement(CRRecentCallsPage.lblCallDateIDResultValue, "Call ID in Search Call Window");
        allCallIds = getWebElementList(CRRecentCallsPage.lblCallDateIDResultValue, "Call ID in Search Call Window");
        contactInfo = getWebElementList(CRRecentCallsPage.txtContactInformation,"Contact Information from");
        if (allCallIds != null) {
            for (int i = 0; i < allCallIds.size(); i++) {
                String callIdAndDateFromList = allCallIds.get(i).getText();
                //String callId[] = callIdAndDateFromList.split("\n");
               // String callid = callId[1];
                //get memberNumber form Most recently accessed calls window
                if (callIdAndDateFromList.contains(callID)) {
                    String contactInfoFromList = contactInfo.get(i).getText();
                    String info[] = contactInfoFromList.split("\n");
                    memberNumber = info[1];
                }
            }
        }
         return memberNumber;
    }
    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: verifyMostRecentlyAssociatedCallsWindow
     * description ::
     * date :: 16-Jan-2018
     * author ::Lakshmi Prasanna
     */
    public void verifyMostRecentlyAssociatedCallsWindow()throws Throwable{
      String mostRecentCalls=getText(CRRecentCallsPage.lblRecentCallsWIndowAvailablity,"MostRecent Calls");
      //assertTrue(true,"Verified the window & Window displays with Name   "+mostRecentCalls);
    }

   /* *//**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getStartDateSearchDetails
     * description ::
     * retrivedTime :: 04-Jan-2018
     * author ::Abhiram
     *//*
    public String getStartDateSearchDetails() throws Throwable {
        //String vehicleSearchDetailsLocator = String.valueOf(CRVehicleTriagePage.txtVehicleSearch);
        startDateInSearchDetails = getAttributeByValue(CRSearchCallsPage.txtStartDateInSearchCall,"Vehicle Search");
        return startDateInSearchDetails;

    }

    *//**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdAndDate
     * description ::
     * retrivedTime :: 04-Jan-2018
     * author ::Abhiram
     *//*
    public String getCallIdAndDate() throws Throwable {
        boolean visibilityOfCallIdAndDate = isVisibleOnly(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, " Call Id and Date is avaiable");
        String startDate = getText(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, "Call Id and Date is avaiable");
        if (visibilityOfCallIdAndDate) {
            assertTrue(visibilityOfCallIdAndDate, "Call Id and Date is avaiable");
             //String startDate = getText(CRSearchCallsPage.callIDDetailsOnSearchCallsInSearclCallWindow, "Call Id and Date is avaiable");
        } else {
            assertFalse(visibilityOfCallIdAndDate, " Call Id and Date is avaiable");
        }
        return startDate;
    }

    *//**
     * convertDateFormatToAnotherDateFormat, Function to convert one date format to another date format
     *
     * @param          (String), Actual date (e.g: Dec 5, 2017)
     * @param      f String), format of actualDate (e.g: MM dd, yyyy)
     * @param  of (String), Format what we required (e.g: dd/MM/yyyy)
     * @return : String
     *//*
    protected String convertDateFormatToAnotherDateFormat(String actualDate, String sourceFormat, String destinationFormat) throws Throwable {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sourceFormat);
        SimpleDateFormat sdf = new SimpleDateFormat(destinationFormat);
        Date date = simpleDateFormat.parse(actualDate);
        return sdf.format(date);
    }
    public void verifyStartAndEndDateOnSearchCallWindow(Hashtable<String, String> data) throws Throwable {
        //getCallIdAndDate();
        //String startDate=convertDateFormatToAnotherDateFormat(getStartDateSearchDetails(),"M/D/YYYY", "M/D/YYYY");

       *//* String abc=getStartDateSearchDetails();
        System.out.println("abc is +++++++++++++" + abc);*//*
        String date2=getCallIdAndDate();
        String splitStr[] = date2.split("\n");
        String startDateValue= splitStr[0];

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date d_date = dateFormat.parse(startDateValue);
        String strDate = dateFormat.format(d_date);
        assertTrue(true,strDate+"Date");
        String expectedStrDate= getStartDateSearchDetails();
        //boolean dateComparision = strDate==StrDate1;
        boolean dateComparision = strDate.equalsIgnoreCase(expectedStrDate);
        if(dateComparision){
            assertTrue(dateComparision,"Start date:: "+strDate+ " is same as expected:: "+expectedStrDate);
        }else{
            assertFalse(dateComparision,"Start date:: "+strDate+ " is same as expected:: "+expectedStrDate);
        }

        Thread.sleep(2000);
         *//*if(startDate.equalsIgnoreCase(startDateValue)){
            //if(timeInIntInMinute>stimeInIntInminute && timeInIntInMinute<etimeInIntInMinute){
            assertTrue(true, "The Start date entered is same as in result found");
        }else{
            assertFalse(false,"The Start date entered is not same as in result found");
        }
        convertDate();*//*

    }*/
    public void verifyeMberNumberInLoadedCall(String memberNumberFromRecentCalls,String memberNumber)throws Throwable{
        //if(memberNumberFromRecentCalls.equals(memberNumber)){
            assertTrue(memberNumberFromRecentCalls.equals(memberNumber),"Call loaded into Call Receiving without error");
        //}
    }

}