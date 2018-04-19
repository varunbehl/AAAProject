package com.aaa.web.lib;

import static org.testng.Assert.assertTrue;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRLocationsPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CRLocationsLib extends ActionEngine {
    List<WebElement> tableColumnData = null;
    List<WebElement> tableCommentTypeCol = null;
    List<WebElement> tableCommentStatus = null;
    List<WebElement> tableCommentTimeStamp = null;
    List<WebElement> tableCommentUser = null;
    List<WebElement> tableCommentLocation = null;

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void locationFieldsVerification() throws Throwable {
        verifyStreetAddress();
        verifyBreakDownCity();
        verifyBreakDownState();
        verifyBreakDownLocationCode();

    }

    public void clearAndSaveLocationDetails(String enterBreakdownAddress, String enterBreakdownCityLocation, String enterBreakdownState, String enterBreakdownLocationCode) throws Throwable {
        clearLocationMandatoryFields();
        enterAndSaveLocationMandatoryFields(enterBreakdownAddress, enterBreakdownCityLocation, enterBreakdownState, enterBreakdownLocationCode);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void searchBreakDownLocation(String enterBreakdownLocationCode) throws Throwable {
        clickOnLocationTab();
        clickOnExistingBreakDwnLoc();
        enterBrkDownLocCode(enterBreakdownLocationCode);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyStreetAddress() throws Throwable {
        boolean flagstreetadd = isVisibleOnly(CRLocationsPage.txtStreetAddress, "Street Address");
            assertTrue(flagstreetadd, "Street Address is Mandatory Field");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyBreakDownCity() throws Throwable {
        boolean flagLocCity = isVisibleOnly(CRLocationsPage.txtLocCity, "City");
        
            assertTrue(flagLocCity, " Location : City is Mandatory Field ");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyBreakDownState() throws Throwable {
        boolean flagLocState = isVisibleOnly(CRLocationsPage.txtLocState, "State");
            assertTrue(flagLocState, "Location : State is Mandatory Field");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyBreakDownLocationCode() throws Throwable {
        boolean flagLocCode = isVisibleOnly(CRLocationsPage.txtLocCode, "Location Code");
            assertTrue(flagLocCode, "Location : Location Code is Mandatory Field");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnLocationTab() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.locationTab, "Location Tab");
        click(CRLocationsPage.locationTab, "Location Tab");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clearLocationMandatoryFields() throws Throwable {
        //clickonmanualEntryLink("location");
        clearData(CRLocationsPage.txtStreetAddress);
        clearData(CRLocationsPage.txtLocCity);
        clearData(CRLocationsPage.txtLocState);
        clearData(CRLocationsPage.txtLocCode);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterAndSaveLocationMandatoryFields
     * description :: To Enter all Mandatory Fields on Location
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterAndSaveLocationMandatoryFields(String enterBreakdownAddress, String enterBreakdownCityLocation, String enterBreakdownState, String enterBreakdownLocationCode) throws Throwable {
        Thread.sleep(2000);
        errorAlertHandlingBeforeEnterMandatoryFields();
        enterBKDownStreetAddress(enterBreakdownAddress);
        enterBKDownCityLocation(enterBreakdownCityLocation);
        enterBKDownState(enterBreakdownState);
        enterBKDownLocCode(enterBreakdownLocationCode);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterBKDownStreetAddress(String enterBreakdownAddress) throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.txtStreetAddressInput, "BKDownStreetAddress");
        click(CRLocationsPage.txtStreetAddressInput, "BKDownStreetAddress");
        clearData(CRLocationsPage.txtStreetAddressInput);
        type(CRLocationsPage.txtStreetAddressInput, enterBreakdownAddress, "BKDownStreetAddress");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterBKDownCityLocation(String enterBreakdownCityLocation) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLocCity, "BKDownCityLocation");
        click(CRLocationsPage.txtLocCity, "BKDownCityLocation");
        //clearData(CRLocationsPage.txtLocCity);
        type(CRLocationsPage.txtLocCity, enterBreakdownCityLocation, "BKDownCityLocation");
        click(CRLocationsPage.txtStreetInputAddress, "BKDownCityLocation");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterBKDownState(String enterBreakdownState) throws Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRLocationsPage.txtLocState, "BKDownState");
        click(CRLocationsPage.txtLocState, "BKDownState");
        //clearData(CRLocationsPage.txtLocState);
        //selectByVisibleText(CRLocationsPage.txtLocState, enterBreakdownState, "BKDownState");
        type(CRLocationsPage.txtLocState, enterBreakdownState, "BKDownState");
        click(CRLocationsPage.txtStreetInputAddress, "BKDownCityLocation");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterBKDownLocCode(String enterBreakdownLocationCode) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLocCode, "BKDownLocCode");
        clearData(CRLocationsPage.txtLocCode);
        type(CRLocationsPage.txtLocCode, enterBreakdownLocationCode, "BKDownCode");
        Thread.sleep(1000);
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: errorAlertHandlingBeforeEnterMandatoryFields
     * description :: To Handle Errors and Alerts
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void errorAlertHandlingBeforeEnterMandatoryFields() throws Throwable {
        //Error Handling on Location Tab
        boolean flagErrorAlertOk = isVisibleOnly(CRLocationsPage.errorAlertOK, "Error Alert OK button");
        //assertTrue(flagErrorAlertOk, "Error Alert OK button");
        if (flagErrorAlertOk) {
            click(CRLocationsPage.errorAlertOK, "Error Alert OK Button");
        }
        boolean scripterrorflag = isVisibleOnly(CRLocationsPage.scriptError, "Script Error OKAY button");
        if (scripterrorflag) {
            JSClick(CRLocationsPage.scriptError, "Script error Okay button");
        }
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: clickonBrkdownloclink
     *  * description :: To click on already available breakdown location link
     *  * date :: 05-Dec-2017
     *  * author ::Lakshmi Prasanna
     *  
     */
    public void breakdownLocTabSel() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.locationTab, "Locations tab");
        click(CRLocationsPage.locationTab, "Locations tab");
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: brkdowlocaddrlink
     *  * description :: brkdowlocaddrlink
     *  * date :: 05-Dec-2017
     *  * author ::Lakshmi Prasanna
     *  
     */
    public void enterLocationDetails(String enterBreakdownLocationCode, String enterBreakdownLocationSearch) throws Throwable {
        if (isElementPresent(CRLocationsPage.linkBrkDownLocAddr, "breakdown loacation address")) {
            clickonBrkdownLocLink();
            brkdownLocationCode(enterBreakdownLocationCode);
        } else {
            enterTxtinBrkDowLocSrch(enterBreakdownLocationSearch);
            brkDowLocSrchBtn();
            brkdowLocAddrLink();
            brkdownLocationCode(enterBreakdownLocationCode);

        }
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: clickonBrkdownloclink
     *  * description :: To click on already available breakdown location link
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */

    public void clickonBrkdownLocLink() throws Throwable {


        isElementPresent(CRLocationsPage.linkBrkDownLocAddr, "breakdown loacation address");
        waitForVisibilityOfElement(CRLocationsPage.linkBrkDownLocAddr, "Breakdown location address");
        click(CRLocationsPage.linkBrkDownLocAddr, "Breakdown location address");
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: brkdownLocationcode
     *  * description :: brkdownLocationcode
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */

    public void brkdownLocationCode(String enterBreakdownLocationCode) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(CRLocationsPage.dropBoxBrkDownLocationCode, "Breakdownlocation code");
        type(CRLocationsPage.dropBoxBrkDownLocationCode, enterBreakdownLocationCode, "Breakdownlocationcode");
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: Entertxtinbrkdowlocsrch
     *  * description :: To enter breakdown location address manually
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */


    public void enterTxtinBrkDowLocSrch(String enterBreakdownLocationSearch) throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.txtBrkDowLocSrch, "Breakdown location search");
        click(CRLocationsPage.txtBrkDowLocSrch, "Location search box");
        type(CRLocationsPage.txtBrkDowLocSrch, enterBreakdownLocationSearch, "Breakdownlocaddress");

        click(CRLocationsPage.labelSearchingInfo, "Click");
        mouseClick(CRLocationsPage.txtBrkDowLocSrch, "Breakdownlocaddress");
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: brkdowlocSrchbtn
     *  * description :: brkdowlocSrchbtn
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */

    public void brkDowLocSrchBtn() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.btnBrkDowLocSrch, "Breakdown location search button");
        click(CRLocationsPage.btnBrkDowLocSrch, "Breakdown location search");
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: brkdowlocaddrlink
     *  * description :: brkdowlocaddrlink
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */

    public void brkdowLocAddrLink() throws Throwable {
        //waitForInVisibilityOfElement(CRLocationsPage.linkBrkDowSrchAddress, "Link brkdown address search");
        click(CRLocationsPage.linkBrkDowSrchAddress, "Link brkdown address search");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void clickOnExistingBreakDwnLoc() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.linkBrkDownLocAddr, "Breakdown location address");
        click(CRLocationsPage.linkBrkDownLocAddr, "Breakdown location address");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearLocationMandatoryFields
     * description :: To click on Manual Entry Link,by passing the Tab Name
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void enterBrkDownLocCode(String enterBreakdownLocationCode) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.dropBoxBrkDownLocationCode, "Breakdownlocation code");
        type(CRLocationsPage.dropBoxBrkDownLocationCode, enterBreakdownLocationCode, "Breakdownlocationcode");
    }

    public void clickOnManualEntryLinkInLocation() throws Throwable {
        click(CRLocationsPage.linkManualEntryOnLocationTab, "ManualEntry Link");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallComments
     * description :: To enter call comments in comments text field
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */

    public void enterCallComments(String callComments) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtCallComments, "Call comments");
        type(CRLocationsPage.txtCallComments, callComments, "Call comments entered");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallCommentsAddButton
     * description :: Click on call comments add button
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */

    public void clickOnCallCommentsAddButton() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.btnCallsAdd, "Call comments Add button");
        click(CRLocationsPage.btnCallsAdd, "Call comments Add button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallCommentsButton
     * description :: clickOnCallCommentsButton
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */

    public void clickOnCallCommentsButton() throws Throwable {
        click(CRLocationsPage.btnViewComments, "Call comments View button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickIconMessageWindowClose
     * description :: clickIconMessageWindowClose
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */

    public void clickIconMessageWindowClose() throws Throwable {
        click(CRLocationsPage.iconMessageWindowClose, "Icon window close");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: compareTimeZones
     * description :: getCallStartTimeAndZone
     * date :: 19-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */

    public String compareTimeZones(String stateValue, String oldStateValue) throws Throwable {
        //enterBKDownState("oldStateValue");
        getText(CRLocationsPage.lblCallTImeZone, "Verified Start Call Time with time Zone of the break down Location");
        type(CRLocationsPage.txtLocState, oldStateValue, "Entered the break down location");
        click(CRLocationsPage.txtLandMark, "Tabbed out from Location State field");
        clickOnCallCommentsButton();
        // List<WebElement> allComments = getWebElementList(CRLocationsPage.selectRowInCommentsPopup, "Date Time ");
        String firstRowDateTime = getText(CRLocationsPage.selectDateTimeInCommentsPopup, "Verified the comment displays with a time stamp of the breakdown locations time zone");
        String secondRowDateTime = getText(CRLocationsPage.selectDateTimeInCommentsPopupEvenRow, "Verified the comment displays with a time stamp of the breakdown locations time zone");

        String date[] = firstRowDateTime.split(" ");
        String timeStamp = date[1];

        String oldRecordDate[] = secondRowDateTime.split(" ");
        String oldRecordTimeStamp = oldRecordDate[1];
        //click(CRLocationsPage.iconMessageWindowClose,"Message Icon closed");
        clickIconMessageWindowClose();
/*
            enterBKDownState("stateValue");
*/

        clearData(CRLocationsPage.txtLocState);
        type(CRLocationsPage.txtLocState, stateValue, "Entered Another break down location to change the TimeZone");


        click(CRLocationsPage.txtStreetNumber, "Tabbed out from Location State field");
        String timeZone = getText(CRLocationsPage.lblCallTImeZone, "Verified Start Call Time with time Zone After changing the break down Location for Second Comment is");
        String time[] = timeZone.split("m ");
        String zone = time[1];
        clearData(CRLocationsPage.txtLocState);
        type(CRLocationsPage.txtLocState, stateValue, "State Value");
        click(CRLocationsPage.txtStreetNumber, "Tabbed out from Location State field");
        String newTimeZone = getText(CRLocationsPage.lblCallTImeZone, "Verified Start Call Time with time Zone After changing the break down Location for first comment is");
        String newTime[] = newTimeZone.split("m ");
        String newZone = newTime[1];

        click(CRLocationsPage.btnViewComments, "View Comments");
        String firstRowDateTimeAfterStateChange = getText(CRLocationsPage.selectDateTimeInCommentsPopup, "New Message Date Time");
        String secondRowDateTimeAfterStateChange = getText(CRLocationsPage.selectDateTimeInCommentsPopupEvenRow, "Old Message DateTIme");

        String dateAfter[] = firstRowDateTimeAfterStateChange.split(" ");
        String timeStampAfter = dateAfter[1];

        String oldRecordDateAfter[] = secondRowDateTimeAfterStateChange.split(" ");
        String oldRecordTimeStampAfter = oldRecordDateAfter[1];
        click(CRLocationsPage.iconMessageWindowClose, "Message Icon closed");

        boolean zoneMatching = zone == newZone;
        assertTrue(zoneMatching, "Old Time in the window is: " + timeStamp + "" + zone + "After State changes old time changed to New time Zone is: " + timeStampAfter + " " + newZone + " are not matched");
        return newZone;
    }

    public void clickOnSecondKownBrkDowLocation() throws Throwable {
        boolean location = isVisibleOnly(CRLocationsPage.linkSecondknownBrkDowLocAddr, "Second Known break down Location");
        assertTrue(location, "Second Known break down Location is available");
        if (location) {
            click(CRLocationsPage.linkSecondknownBrkDowLocAddr, "Second Known break down Location");
        }
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: clickOnClearLocationButton
     * description :: To click on Clear Location Button
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnClearLocationButton() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.btnClearLocation, "Clear Location Button");
        click(CRLocationsPage.btnClearLocation, "Clicking on Clear Location Button");
        // boolean clickOnClearLocationButton = isVisibleOnly(CRLocationsPage.btnClearLocation,"Clicking on Clear Location Button");
        // if(clickOnClearLocationButton) {
        // click(CRLocationsPage.btnClearLocation,"Clicking on Clear Location Button");
        //}else{
        // assertTrue(!clickOnClearLocationButton,"Clear Location Button is not visible");
        //}
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: acceptAddressDifferenceAlert
     * description ::To accept Address Difference Alert
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void acceptAddressDifferenceAlert() throws Throwable {

        Thread.sleep(2000);
        boolean btnAlertSaveYes = isVisibleOnly(CRLocationsPage.btnAlertSaveYes, "Click on Yes to use the Address");
        if (btnAlertSaveYes) {
            waitForVisibilityOfElement(CRLocationsPage.btnAlertSaveYes, "Click on Yes to use the Address");
            click(CRLocationsPage.btnAlertSaveYes, "Click on Yes to use the Address");
        } else {
            assertFalse(btnAlertSaveYes, "Click on Yes to use the Address alert is Not Present");
        }
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLocationResultsLink
     * description ::To click On Location Results Link for Row selection
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnLocationResultsLink() throws Throwable {
        isVisibleOnly(CRLocationsPage.lnkRowSelectionInLocationResults, "Select the link on Location Results");
        waitForVisibilityOfElement(CRLocationsPage.lnkRowSelectionInLocationResults, "Select the link on Location Results");
        click(CRLocationsPage.lnkRowSelectionInLocationResults, "Click on Location Results link");
    }


    /**
     * return ::void
     * throws :: throwable
     * methodName :: breakDownStreetNameVerification
     * description ::To Verify the Break Down Street Name is Matched Or Not with Search value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyBreakDownStreetValue() throws Throwable {
        String bkDownStreetAddress = getBKDownStreetAddress();
        boolean streetValue = !bkDownStreetAddress.isEmpty();
        assertTrue(streetValue, "Verified the street Address with returned Value & Street Address is populated     " + bkDownStreetAddress);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getBKDownStreetAddress
     * description :: To get BKDown Street Address
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public String getBKDownStreetAddress() throws Throwable {
        String streetAddress = getAttributeByValue(CRLocationsPage.txtStreetAddressInput, "Street Address");

        return streetAddress;

    }

    /** param  String
     * return ::void
     * throws :: throwable
     * methodName :: crossStreetsVerification
     * description ::To Verify the crossStreet is Matched Or Not with Search value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    /**
     * param  String
     * return ::void
     * throws :: throwable
     * methodName :: verifyNarthCrossStreetFieldValue
     * description ::To verify Narth Cross Street Field Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyNarthCrossStreetFieldValue() throws Throwable {
        String narthCrossStreet = getNarthCrossStreetsValue();
        boolean crossStreetValue = !narthCrossStreet.isEmpty();
        assertTrue(crossStreetValue, "Verified the NarthCross street with returned Value & NarthCross Street is populated       " + narthCrossStreet);
    }

    public String getNarthCrossStreetsValue() throws Throwable {
        //String northcrossStreet = String.valueOf(CRLocationsPage.txtNarthCrossstreet);
        String northCrossStreetValue = getAttributeByValue(CRLocationsPage.txtNarthCrossstreet, "North Cross Street");
        return northCrossStreetValue;

    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: verifySouthCrossStreetFieldValue
     * description ::To verify South Cross Street Field Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void verifySouthCrossStreetFieldValue() throws Throwable {
        String southCrossStreet = getSouthCrossStreetsValue();
        boolean crossStreetValue = !southCrossStreet.isEmpty();
        assertTrue(crossStreetValue, "Verified the SouthCross street with returned Value & SouthCross Street is Populated      " + southCrossStreet);
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: getSouthCrossStreetsValue
     * description ::To get South Cross Streets Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public String getSouthCrossStreetsValue() throws Throwable {
        //String southCrossStreet = String.valueOf(CRLocationsPage.txtSouthCrossstreet);
        String southCrossStreetValue = getAttributeByValue(CRLocationsPage.txtSouthCrossstreet, "South Cross Street");
        return southCrossStreetValue;

    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: pickPointFieldVerification
     * description ::To Verify pick Point Field
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void pickPointFieldVerification() throws Throwable {

    }


    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterLatitude
     * description ::To enter Latitude Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void enterLatitude(String latitude) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLatitude, "Latitude");
        type(CRLocationsPage.txtLatitude, latitude, "Enter Latitude value");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: enterLongitude
     * description ::To enter Longitude Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void enterLongitude(String longitude) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLongitude, "Longitude");
        type(CRLocationsPage.txtLongitude, longitude, "Enter Longitude value");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: clickOnVerifyItButton
     * description ::To click On VerifyIt Button,For validate address in Locations
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnVerifyItButton() throws Throwable {
        isVisibleOnly(CRLocationsPage.btnVerifyIt, "VerifyIt Button");
        waitForVisibilityOfElement(CRLocationsPage.btnVerifyIt, "VerifyIt Button");
        click(CRLocationsPage.btnVerifyIt, "Click on VerifyIt Button");
    }


    /**
     * return ::void
     * throws :: throwable
     * methodName :: verifyCityField
     * description ::To verify city Name
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyCityField() throws Throwable {

        String city = getCityValue();
        boolean cityValue = !city.isEmpty();
        assertTrue(cityValue, "Verified the City Field Name with returned Value & City Name is populated       " + city);
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: getCityValue
     * description ::To get City Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public String getCityValue() throws Throwable {
        //String cityLocator = String.valueOf(CRLocationsPage.txtLocCity);
        String cityValue = getAttributeByValue(CRLocationsPage.txtLocCity, "City");
        return cityValue;
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: verifyStateField
     * description ::To verify StateField
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyStateField() throws Throwable {
        String state = getStateValue();
        boolean stateValue = !state.isEmpty();
        assertTrue(stateValue, "Verified the State Field Name with returned Value & State Name is populated     " + state);
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: verifyLatitudeField
     * description :: To verify Latitude Field
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyLatitudeField() throws Throwable {
        String latitude = getLatitudeValue();
        boolean latitudeValue = !latitude.isEmpty();
        assertTrue(latitudeValue, "Latitude is Populated      " + latitude);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getLatitudeValue
     * description :: Retriving the latitude value from field
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public String getLatitudeValue() throws Throwable {

        //String Latitudelocator = String.valueOf(CRLocationsPage.txtLatitude);
        String latitudeValue = getAttributeByValue(CRLocationsPage.txtLatitude, "Latitude Field Value");
        return latitudeValue;

    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: getStateValue
     * description ::To get State Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public String getStateValue() throws Throwable {
        //String StateLocator = String.valueOf(CRLocationsPage.txtLocState);
        String stateValue = getAttributeByValue(CRLocationsPage.txtLocState, "State Field Value");
        return stateValue;
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: verifySpecialCharactersWithResults
     * description ::To verify Special Characters With Results
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void verifySpecialCharactersWithResults(String specialCharacters) throws Throwable {
        String specialCharactersString = getText(CRLocationsPage.txtspecialCharacters, "Special Characters String");
        int specialCharactersMatch = specialCharacters.compareTo(specialCharactersString);
        assertTrue(specialCharactersMatch != 0, "Results returned with exact match and Also special characters are displayed properly");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: getNumberOfResultsRecordsInResultsGrid
     * description ::To get Number Of Records InResultsGrid
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void getNumberOfRecordsInResultsGrid() throws Throwable {
        int resultsList = getElementsSize(CRLocationsPage.recardListInResultsGrid);
        // if(resultsList!=0){
        assertTrue(resultsList != 0, "Found the results with Point of Interest,Number of records are " + resultsList);
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: verifyLandMarkField
     * description ::To verify LandMarkField is populated with POI(Point of Interest) name
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public boolean verifyLandMarkField() throws Throwable {
        boolean landMrk;
        String landMark = getLandMarkField();
        boolean landMarkValue = !landMark.isEmpty();
        assertTrue(landMarkValue, "Verified the LandMark Field Name with returned Value & LandMark Field is populated");
        landMrk = true;

        return landMrk;
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: getLandMarkField
     * description ::To getLand Mark Field Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public String getLandMarkField() throws Throwable {
        //String LandMarkLocator = String.valueOf(CRLocationsPage.txtLandMark);
        String landMarkValue = getAttributeByValue(CRLocationsPage.txtLandMark, "LandMark Field Value");
        return landMarkValue;
    }
    /**
     * return ::void
     * throws :: throwable
     * methodName :: verifyPointsOfInterest
     * description ::To verify PointsOfInterest
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
            /*public void verifyPointsOfInterest(String pointsOfInterest)throws Throwable{
                getNumberOfRecordsInResultsGrid(pointsOfInterest);
                verifyLandMarkField(pointfsOfInterest);
            }*/

    /**
     * return ::void
     * throws :: throwable
     * methodName :: getNumberOfRecordsWithWildCardSearch
     * description ::To get Number OfRecords WithWild CardSearch
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void getNumberOfRecordsWithWildCardSearch() throws Throwable {
        int resultsList = getElementsSize(CRLocationsPage.recardListInResultsGrid);
        //if(resultsList!=0){
        assertTrue(resultsList != 0, "Found the results For WildCard search" + resultsList);
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddressLinkAfterLongitudeAndLatitudeVerification
     * description ::To click On Address Link After Longitude And Latitude Verification
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnAddressLinkAfterLongitudeAndLatitudeVerification() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.lnkForAddressVerificationByLatitudeOrLongitude, "Address Link");
        click(CRLocationsPage.lnkForAddressVerificationByLatitudeOrLongitude, "Click on AddressLink");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: addressVerificationBasedOnLongitudeAndLatitude
     * description ::For address Verification Based On Longitude And Latitude
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void addressVerificationBasedOnLongitudeAndLatitude(String latitude, String longitude) throws Throwable {
        enterLatitude(latitude);
        enterLongitude(longitude);
        clickOnVerifyItButton();

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getLogitudeValue
     * description :: Retriving the Logitude value from field
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public String getLongitudeValue() throws Throwable {

        String longitudeValue = getAttributeByValue(CRLocationsPage.txtLongitude, "longitude locator");
        return longitudeValue;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsInCommentPopUp
     * description :: This method validates the comments in first row of comments column in Comments PopUp window
     * date :: 29-Dec-2017
     * author :: Sachin
     */

    public void validateComentsInCommentPopUp(String comments) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Column data");
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                assertTrue(commentsCol.equalsIgnoreCase(comments), "Comments entered displayed in Comment PopUp window");
                if (existsVal) {
                    //assertTrue(commentsCol.equalsIgnoreCase(comments), "Comments entered displayed in Comment PopUp window");
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(false, "Comments entered not displayed in Comment PopUp window");
            }
        }
    }

    /**
     * return ::String return
     * throws :: throwable
     * methodName :: getZipCodeValue
     * description ::To get Zip Code Value
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public String getZipCodeValue() throws Throwable {
        //String zipCodelocator = String.valueOf(CRLocationsPage.txtZipCode);
        String zipCodeValue = getAttributeByValue(CRLocationsPage.txtZipCode, "Zip Code ");
        return zipCodeValue;
    }

    /**
     * return ::String return
     * throws :: throwable
     * methodName :: verifyZipCodeField
     * description ::To verify Zip Code Field
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyZipCodeField() throws Throwable {
        String zipCode = getZipCodeValue();
        boolean zipCodeValue = !zipCode.isEmpty();
        assertTrue(zipCodeValue, "Verified the Zip Code with returned Value & Zip Code is populated");
    }

    public void verifyTheEmptyFieldsAfterClear() {

    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: verifyAddressVerifiedBtn
     * description ::To verify Address Verified Button
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyAddressVerifiedBtn() throws Throwable {
        boolean addressVerified = isVisibleOnly(CRLocationsPage.addressVerifiedBtn, "Langitude/Latitude Verified On The Screen");
        assertTrue(addressVerified, "Langitude/Latitude Verified On The Screen");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: pickPointFieldVerification
     * description ::To Verify pick Point Field
     * date :: 02-Jan-2018
     * author :: Lakshmi Prasanna
     */
    public void veryfyPickUpPoints() throws Throwable {

        String southCrossStreet = getPickOupPointsFromdroupDown();
        boolean pickUpPointsValue = !southCrossStreet.isEmpty();
        assertTrue(pickUpPointsValue, "Verified the pick up points & PickUp Points are populated in the drop down");
    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: getPickOupPointsFromdroupDown
     * description ::To get PickOup Points From droupDown
     * date :: 29-Dec-2017
     * author :: Lakshmi Prasanna
     */
    public String getPickOupPointsFromdroupDown() throws Throwable {

        String pickUpPointsValue = getAttributeByValue(CRLocationsPage.txtBoxPickUpPoint, "Pick Up Points ");
        return pickUpPointsValue;

    }

    /**
     * return ::void
     * throws :: throwable
     * methodName :: verifyLandMarkFieldForPointOfInterest
     * description ::To verify Land MarkField For PointOfInterest
     * date :: 02-Jan-2018
     * author :: Lakshmi Prasanna
     */


    public void verifyLandMarkFieldForPointOfInterest(String pointOfInterest) throws Throwable {
        String landMark = getLandMarkField();
        boolean landMarkValue = !landMark.isEmpty();
        assertTrue(landMarkValue, "Land Mark is Populated ,populated Land Mark is    " + landMark);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyLongitude
     * description :: To verify Longitude
     * date :: 3-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyLongitude() throws Throwable {
        String longitude = getLongitudeValue();
        boolean longitudeValue = !longitude.isEmpty();
        assertTrue(longitudeValue, "Longitude  is Populated         " + longitude);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getBlockRange
     * description :: To get Block Range
     * date :: 3-Jan-2018
     * author :: Lakshmi Prasanna
     */
    public void verifyBlockRange() throws Throwable {
        String blockRange = getBlockRange();
        boolean blockRangeNullCheck = !blockRange.isEmpty();
        assertTrue(blockRangeNullCheck, "Block Range is Populated   " + blockRange);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getBlockRange
     * description :: To get Block Range
     * date :: 2-Jan-2018
     * author :: Lakshmi Prasanna
     */
    public String getBlockRange() throws Throwable {
        String blockRange = getAttributeByValue(CRLocationsPage.txtStreetNumber, "Block Range ");
        return blockRange;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: varifyCommentBoxExists
     * description :: This method validates the comments box exists
     * date :: 3-Jan-2017
     * author :: Sachin
     */

    public void verifyCommentBoxExists() throws Throwable {

        boolean commentBox = isVisibleOnly(CRLocationsPage.txtCallComments, "Comment Box");
        assertTrue(commentBox, "Comments Box exists");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getCallComments
     * description :: Click on call comments add button
     * date :: 3-Jan-2018
     * author :: Sachin
     */
    public String getCallComments() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtCallComments, "Call comments");
        String comments = getText(CRLocationsPage.txtCallComments, "Call comments");
        return comments;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateCommentsErrorMessage
     * description :: This function validates if error message is displayed or not
     * date :: 3-Jan-2018
     * author :: Sachin
     */
    public void validateCommentsErrorMessage(String expComments, String actComments) throws Throwable {
        boolean value = expComments.equalsIgnoreCase(actComments);
        assertTrue(value, "Error messsage not displays:");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getCallComments
     * description :: Click on call comments add button
     * date :: 3-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public String getCommentsCountFromCommentsButton() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.btnComments, "Comments Button");
        String commentsCount = getText(CRLocationsPage.btnComments, "Comments Button");
        return commentsCount;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: VerifyCallReceivesPacesetterCode
     * description :: This function validates comments before and after adding them
     * date :: 3-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void VerifyCallReceivesPacesetterCode(String initialValue, String finalValue) throws Throwable {
    	assertTrue(initialValue != finalValue, "Call receives a pacesetter code");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterNonMandatoryFieldsInLocations
     * description :: enterNonMandatoryFieldsInLocations
     * date :: 3-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void enterNonMandatoryFieldsInLocations(String landMark, String firstStreetAddress, String NorthCrossStreet, String SouthCrossStreet, String zipCode) throws Throwable {
        click(CRLocationsPage.txtStreetNumber, "First Street Address ");
        type(CRLocationsPage.txtStreetNumber, firstStreetAddress, "First Street Address");
        click(CRLocationsPage.txtNarthCrossstreet, "North Cross Street");
        type(CRLocationsPage.txtNarthCrossstreet, NorthCrossStreet, "North Cross Steet");
        click(CRLocationsPage.txtSouthCrossstreet, "South Cross Street");
        type(CRLocationsPage.txtSouthCrossstreet, SouthCrossStreet, "South Cross Steet");
        click(CRLocationsPage.txtZipCode, "Zip Code");
        type(CRLocationsPage.txtZipCode, zipCode, "Zip Code");
        click(CRLocationsPage.txtLandMark, "LandMark");
        type(CRLocationsPage.txtLandMark, landMark, "Land Mark");
    }

    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: clickOnLocationCodeDropDown
     *  * description :: T
     *  * retrivedTime :: 04-Jan-2017
     *  * author :: Chandra
     *  
     */
    public void clickOnLocationCodeDropDown() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.lnkClickOnLocationCode, "Click On Location DropDown");
        click(CRLocationsPage.lnkClickOnLocationCode, "Click on Location Code Dropdown");
    }

    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: clickOnCallBox
     *  * description :: T
     *  * retrivedTime :: 04-Jan-2017
     *  * author :: Chandra
     *  
     */
    public void clickOnCallBox() throws Throwable {
        click(CRLocationsPage.txtCallBox, "Tabbed out");
    }

    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: enterBlockRange
     *  * description :: To enter Street Number
     *  * retrivedTime :: 04-Jan-2017
     *  * author :: Lakshmi Prasanna
     *  
     */
    public void enterBlockRange(String streetNumber) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtStreetNumber, "StreetNumber");
        click(CRLocationsPage.txtStreetNumber, "StreetNumber");
        type(CRLocationsPage.txtStreetNumber, streetNumber, "StreetNumber");
    }

    public void enterSouthCrossStreetValue(String southCrossStreet) throws Throwable {
        type(CRLocationsPage.txtSouthCrossstreet, southCrossStreet, "South Cross Street");
    }

    public void enterZipCode(String zipCode) throws Throwable {
        String zipcode = getText(CRLocationsPage.txtZipCode,"");
        if (zipcode.isEmpty()){
            type(CRLocationsPage.txtZipCode, zipCode, "Zip Code");
        }

    }

    public void enterNorthCrossstreetValue(String northCrossStreet) throws Throwable {
        click(CRLocationsPage.txtNarthCrossstreet, "North Cross Street");
        type(CRLocationsPage.txtNarthCrossstreet, northCrossStreet, "North Cross Street");

    }

    public void selectBreakDownLocationandCode(String breakDownLocationCode) throws Throwable {
        clickonBrkdownLocLink();
        brkdownLocationCode(breakDownLocationCode);
    }

    public void enterBreakDownLocationandCode(String breakDownAddress, String breakDownLocationCode) throws Throwable {
        enterTxtinBrkDowLocSrch(breakDownAddress);
        brkDowLocSrchBtn();
        brkdowLocAddrLink();
        brkdownLocationCode(breakDownLocationCode);
    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: getLocationCode
     * * description :: T
     * * retrivedTime :: 16-Jan-2017
     * * author :: Lakshmi Prasanna
     */
    public String getLocationCode() throws Throwable {
        String locationCode = getAttributeByValue(CRLocationsPage.dropBoxBrkDownLocationCode, "LocationCode");
        return locationCode;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCrossStreetInLocations
     * description :: enterCrossStreetInLocations
     * date :: 17-Jan-2018
     * author :: Abhiram
     */
    public void enterCrossStreetInLocations(String NorthCrossStreet, String SouthCrossStreet) throws Throwable {

        click(CRLocationsPage.txtNarthCrossstreet, "North Cross Street");
        type(CRLocationsPage.txtNarthCrossstreet, NorthCrossStreet, "North Cross Steet");
        click(CRLocationsPage.txtSouthCrossstreet, "South Cross Street");
        type(CRLocationsPage.txtSouthCrossstreet, SouthCrossStreet, "South Cross Steet");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLandmarkInLocations
     * description :: enterLandmarkInLocations
     * date :: 17-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void enterLandmarkInLocations(String landMark) throws Throwable {

        click(CRLocationsPage.txtLandMark, "LandMark");
        type(CRLocationsPage.txtLandMark, landMark, "Land Mark");
    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: getTextAndClickOnlocationNameLink
     * * description :: getText And Click On locationNameLink
     * * retrivedTime :: 16-Jan-2017
     * * author :: Ravi
     */
    public void getTextAndClickOnlocationNameLink() throws Throwable {
        getText(CRLocationsPage.locationNameLink, "get text of location");
        click(CRLocationsPage.locationNameLink, "get text of location");
    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: verifyLocationAvailable
     * * description :: T
     * * retrivedTime :: 16-Jan-2017
     * * author :: Abhiram
     */
    public boolean verifyLocationAvailable() throws Throwable {

        //waitForVisibilityOfElement(CRLocationsPage.linkBrkDownLocAddr, "Existing Address are Not Visible");
        boolean locationAvailable = isVisibleOnly(CRLocationsPage.linkBrkDownLocAddr, "Existing Address are Not Visible");
        return locationAvailable;

    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: clickOnCityCodeDropDown
     * * description ::
     * * retrivedTime :: 19-Jan-2017
     * * author :: Abhiram
     */
    public void clickOnCityCodeDropDown() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.dropBoxBrkDownCityCode, "Click On state DropDown");
        click(CRLocationsPage.dropBoxBrkDownCityCode, "Click on state Code Dropdown");

    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: enterStreetAddressNumber
     * * description ::
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram 
     */
    public void enterStreetAddressNumber(String streetNumber) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtStreetNumber, "StreetNumber");
        type(CRLocationsPage.txtStreetNumber, streetNumber, "Successfully Enter StreetNumber");
    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: enterStreetAddress
     * * description ::
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram 
     */
    public void enterStreetAddress(String streetAddress) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtStreetAddressInput, "Street Address");
        type(CRLocationsPage.txtStreetAddressInput, streetAddress, "Successfully Enter Street Address");
    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: enterNorthCrossStreet
     * * description ::
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram 
     */
    public void enterNorthCrossStreet(String NorthCrossStreet) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtNarthCrossstreet, "North Cross Street");
        type(CRLocationsPage.txtNarthCrossstreet, NorthCrossStreet, "Successfully Enter North Cross Street");
    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: enterNorthCrossStreet
     * * description ::
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram 
     */
    public void enterSouthCrossStreet(String SouthCrossStreet) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtSouthCrossstreet, "South Cross Street");
        type(CRLocationsPage.txtSouthCrossstreet, SouthCrossStreet, "Successfully Enter South Cross Street");
    }


    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: enterLocationCity
     * * description ::
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram 
     */
    public void enterLocationCity(String locationCity) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLocCity, "Location City");
        type(CRLocationsPage.txtLocCity, locationCity, "Successfully Enter Location City");
    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: enterLocationState
     * * description ::
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram 
     */
    public void enterLocationState(String locationState) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLocState, "Location State");
        type(CRLocationsPage.txtLocState, locationState, "Successfully Enter Location State");
    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: enterLocationZip
     * * description ::
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram 
     */
    public void enterLocationZip(String locationZip) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtZipCode, "Location Zip");
        type(CRLocationsPage.txtZipCode, locationZip, "Successfully Enter Location Zip");
    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: enterLocationZip
     * * description ::
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram 
     */
    public void enterLocationLandmark(String locationLandmark) throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtLandMark, "Location Landmark");
        type(CRLocationsPage.txtLandMark, locationLandmark, "Successfully Enter Location Landmark");
    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: clickOnStateCodeDropDown
     * * description ::
     * * retrivedTime :: 20-Jan-2018
     * * author :: Abhiram
     */
    public void clickOnStateCodeDropDown() throws Throwable {

        waitForVisibilityOfElement(CRLocationsPage.dropBoxBrkDownStateCode, "Click On state DropDown");
        click(CRLocationsPage.dropBoxBrkDownStateCode, "Click on state Code Dropdown");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAtlantaExistingBreakDwnLoc
     * description ::
     * date :: 20-Jan-2018
     * author :: Lakshmi Prasanna
     */

    public void clickOnAtlantaExistingBreakDwnLoc() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.linkAtlantaBrkDownLocAddr, "Click on Atlanta Breakdown Location");
        click(CRLocationsPage.linkAtlantaBrkDownLocAddr, "Click on Atlanta Breakdown Location");
    }

    /**
     * * param :: NA
     * * return ::void
     * * throws :: throwable
     * * methodName :: verifyAtlantaLocationAvailable
     * * description :: T
     * * retrivedTime :: 16-Jan-2017
     * * author :: Abhiram
     */
    public boolean verifyAtlantaLocationAvailable() throws Throwable {

        //waitForVisibilityOfElement(CRLocationsPage.linkAtlantaBrkDownLocAddr, "Existing Atlanta Address are Not Visible");
        boolean atlantaLocationAvailable = isVisibleOnly(CRLocationsPage.linkAtlantaBrkDownLocAddr, "Existing Atlanta Address are Not Visible");
        return atlantaLocationAvailable;

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsInCommentPopUp
     * description :: This method validates the comments in first row of comments column in Comments PopUp window
     * date :: 20-Jan -2018
     * author :: Sachin
     */

    public void validateComentsTypeInCommentWindow(String comments, String ColumnType) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Type");
        tableCommentTypeCol = getWebElementList(CRLocationsPage.lblCommentTypeCommentWindow, "Comments Type");
        String commentType = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();
                commentType = tableCommentTypeCol.get(i).getText().toString().trim();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    boolean existsValType = commentType.equalsIgnoreCase(ColumnType);
                    assertTrue(commentType.equalsIgnoreCase(ColumnType), "Comments has type" + commentType);
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(false, "Comments has type" + commentType);
            }
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsNotAvailableInCommentPopUp
     * description :: This method validates the comments in first row of comments column in Comments PopUp window
     * date :: 21-Dec-2017
     * author :: Sachin
     */

    public void validateComentsNotAvailableInCommentPopUp(String comments) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Column data");
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                assertTrue(existsVal, "Comments entered displayed in Comment PopUp window");
                if (existsVal) {
                    //assertTrue(false, "Comments entered displayed in Comment PopUp window");
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(flow, "Hidden comments " + comments + "not displayed in Comment PopUp window after changing the Status to Hidden.");
            }
        }
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsInCommentPopUp
     * description :: This method validates the comments in first row of comments column in Comments PopUp window
     * date :: 20-Jan -2018
     * author :: Sachin
     */

    public void validateComentsStatusInCommentWindow(String comments, String ColumnStatus) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Status");
        tableCommentStatus = getWebElementList(CRLocationsPage.lblStatusCommentWindow, "Comments Status");
        String commentStatus = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();
                commentStatus = tableCommentStatus.get(i).getText().toString().trim();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    boolean existsValType = commentStatus.equalsIgnoreCase(ColumnStatus);
                    assertTrue(ColumnStatus.equalsIgnoreCase(commentStatus), "Comments has Status" + commentStatus);
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(false, "Comments has Status" + commentStatus);
            }
        }
    }

    public void validateComentsDateTimeCommentWindow(String comments, String ColumnTimeStamp) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Status");
        tableCommentTimeStamp = getWebElementList(CRLocationsPage.lblDateTimeCommentWindow, "Comments Date Time");
        String commentTimeStamp = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();
                commentTimeStamp = tableCommentTimeStamp.get(i).getText().toString().trim();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    boolean existsValType = commentTimeStamp.equalsIgnoreCase(commentTimeStamp);
                    assertTrue(ColumnTimeStamp.equalsIgnoreCase(commentTimeStamp), "Comments has Date Time" + ColumnTimeStamp);
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(false, "Comments has Date Time" + ColumnTimeStamp);
            }
        }
    }

    public void validateComentsUserCommentWindow(String comments, String ColumnUser) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Status");
        tableCommentUser = getWebElementList(CRLocationsPage.lblUserCommentWindow, "Comments User");
        String commentUser = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();
                commentUser = tableCommentUser.get(i).getText().toString().trim();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    String commentUser1 = commentUser.replaceAll("[^\\w\\d\\s]", " ");
                    String ColumnUser1 = ColumnUser.replaceAll("[^\\w\\d\\s]", " ");
                    assertTrue((commentUser1.equalsIgnoreCase(ColumnUser1)),"Comments has User" + commentUser);
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(flow, "Comments has User" + commentUser);
            }
        }
    }

    public void validateLocationCommentWindow(String comments, String ColumnLocation) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Status");
        tableCommentLocation = getWebElementList(CRLocationsPage.lblLocationCommentWindow, "Comments Location");
        String commentLocation = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();
                commentLocation = tableCommentLocation.get(i).getText().toString().trim();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    assertTrue(ColumnLocation.equalsIgnoreCase(commentLocation), "Comments has Location" + commentLocation);
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(flow, "Comments has Location" + commentLocation);
            }
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: GetComentTypeFromommentWindow
     * description :: This method validates the comments in first row of comments column in Comments PopUp window
     * date :: 20-Jan -2018
     * author :: Sachin
     */

    public String GetComentTypeFromommentWindow(String comments) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments");
        tableCommentTypeCol = getWebElementList(CRLocationsPage.lblCommentTypeCommentWindow, "Comments Type");
        String commentType = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    commentType = tableCommentTypeCol.get(i).getText().toString().trim();
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(false, "Comments not available in comment window " + comments);
            }
        }
        return commentType;
    }

    public String GetDateTimeFromCommentWindow(String comments) throws Throwable {
        tableColumnData = getWebElementList(CRLocationsPage.txtCommentsCol, "Comments Status");
        tableCommentTimeStamp = getWebElementList(CRLocationsPage.lblDateTimeCommentWindow, "Comments Date Time");
        String commentTimeStamp = null;
        if (tableColumnData != null) {
            boolean flow = true;
            for (int i = 0; i <= tableColumnData.size() - 1; i++) {
                String commentsCol = tableColumnData.get(i).getText().toString().trim();
                boolean existsVal = commentsCol.equalsIgnoreCase(comments);
                if (existsVal) {
                    commentTimeStamp = tableCommentTimeStamp.get(i).getText().toString().trim();
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(false, "Comments not available in comment window" + comments);
            }
        }
        return commentTimeStamp;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsInCommentPopUp
     * description :: This method validates the comments in first row of comments column in Comments PopUp window
     * date :: 20-Jan -2018
     * author :: Sachin
     */

    public boolean validateComentsTypeInCommentWindow(String ColumnType) throws Throwable {
        tableCommentTypeCol = getWebElementList(CRLocationsPage.lblCommentTypeCommentWindow, "Comments Type");
        String commentType;
        boolean TypeVal = false;
        if (tableCommentTypeCol != null) {
            boolean flow = true;
            for (int i = 0; i <= tableCommentTypeCol.size() - 1; i++) {

                commentType = tableCommentTypeCol.get(i).getText().toString().trim();

                boolean typeExist = commentType.equalsIgnoreCase(ColumnType);
                if (typeExist) {
                    TypeVal = true;
                    break;
                }
            }
        }
        return TypeVal;
    }
    
    public void clickOnManualEntryAndEnterLocationDetails(String LandMark, String Address, String crossStreet, String secondCrossStreet , String Zip, String StreetAddress, String City, String State, String LocationCode) throws Throwable {
    	clickOnManualEntryLinkInLocation();
        enterNonMandatoryFieldsInLocations(LandMark, Address, crossStreet, secondCrossStreet, Zip);
        enterAndSaveLocationMandatoryFields(StreetAddress, City, State, LocationCode);
        enterBKDownLocCode(LocationCode);
        Thread.sleep(2000);
        clickOnLocationCodeDropDown();
        Thread.sleep(5000);
    }

    public void breakdownSearchAndBreakdownType(String BreakdownSearch, String BreakdownType, String crossStreet, String secondCrossStreet, String LandMark, String Address) throws Throwable {
        //breakdownLocTabSel();
        if(((BreakdownSearch.equalsIgnoreCase("Existing Address")) && (BreakdownType.equalsIgnoreCase("Cross st")))||
                ((BreakdownSearch.equalsIgnoreCase("Existing Address")) && (BreakdownType.equalsIgnoreCase("Landmark")))||
                ((BreakdownSearch.equalsIgnoreCase("Existing Address")) && (BreakdownType.equalsIgnoreCase("Full Address"))))
        {
            String AddressBreakDown[] = Address.split("#");
            //Check for location Available
            boolean noAddressAvailable = verifyLocationAvailable();
            //Check for Atlanta location Available
            boolean noAtlantaLocationAvailable = verifyAtlantaLocationAvailable();
            if(noAddressAvailable && noAtlantaLocationAvailable )
            {
                clickOnAtlantaExistingBreakDwnLoc();
                String northCrossStreetValue = getNarthCrossStreetsValue();
                if(northCrossStreetValue.isEmpty())
                {
                    enterNorthCrossStreet(crossStreet);
                }
                String southCrossStreetValue = getSouthCrossStreetsValue();
                if(southCrossStreetValue.isEmpty())
                {
                    enterSouthCrossStreet(secondCrossStreet);
                }
                String landmarkValue = getLandMarkField();
                if(landmarkValue.isEmpty())
                {
                    enterLocationLandmark(LandMark);
                }
                String locationCodeValue = getLocationCode();
                if(locationCodeValue.isEmpty())
                {
                    enterBKDownLocCode(AddressBreakDown[5]);
                }
            }
            else
            {
                enterBreakDownLocationManually(Address);

            }
        }

        else if(((BreakdownSearch.equalsIgnoreCase("Manual")) && (BreakdownType.equalsIgnoreCase("Full Address"))) ||
                ((BreakdownSearch.equalsIgnoreCase("Manual")) && (BreakdownType.equalsIgnoreCase("Cross st")))||
                ((BreakdownSearch.equalsIgnoreCase("Manual")) && (BreakdownType.equalsIgnoreCase("Landmark"))))
        {
            enterBreakDownLocationManually(Address);
        }

        else if(((BreakdownSearch.equalsIgnoreCase("Omnibar")) && (BreakdownType.equalsIgnoreCase("Full Address"))) ||
                ((BreakdownSearch.equalsIgnoreCase("Omnibar")) && (BreakdownType.equalsIgnoreCase("Cross st")))||
                ((BreakdownSearch.equalsIgnoreCase("Omnibar")) && (BreakdownType.equalsIgnoreCase("Landmark"))))
        {
            enterBreakDownAddressOmniBarSearch(Address);

        }
    }

    public void enterStreetNumber(String StreetNumber) throws Throwable {
    	click(CRLocationsPage.txtStreetNumber, "Street NUmber ");
        type(CRLocationsPage.txtStreetNumber, StreetNumber, "Street Number");
    }
    public void enterBreakDownAddressOmniBarSearch(String OmniBarAddress) throws Throwable {
    	String OmniAddress[] = OmniBarAddress.split("#");
    	
    	enterTxtinBrkDowLocSrch(OmniAddress[0]);
        brkDowLocSrchBtn();
        Thread.sleep(5000);
        getNumberOfRecordsInResultsGrid();
        clickOnLocationResultsLink();
        acceptAddressDifferenceAlert();
        verifyAddressVerifiedBtn();
        String locationCodeValue = getLocationCode();
        if(locationCodeValue.isEmpty())
        {
            enterBKDownLocCode(OmniAddress[1]);
        }
    }
    
    public void enterBreakDownLocationMandatoryFields(String Address) throws Throwable {
    	String AddressVal[] =  Address.split("#");
    	
    	Thread.sleep(2000);
        errorAlertHandlingBeforeEnterMandatoryFields();
        enterStreetNumber(AddressVal[0]);
        enterBKDownStreetAddress(AddressVal[1]);
        enterBKDownCityLocation(AddressVal[2]);
        enterBKDownState(AddressVal[3]);
        enterZipCode(AddressVal[4]);
        verifyAddressVerifiedBtn();
        enterBKDownLocCode(AddressVal[5]);
    }
    
    public void enterBreakDownLocationManually(String Address) throws Throwable {
    	clickOnManualEntryLinkInLocation();
    	enterBreakDownLocationMandatoryFields(Address);
    }

    public void verifyCompleteCheckLocation()  throws Throwable {
        if (!(isVisibleOnly(CRLocationsPage.verifyLocationsCompleteCheck, "Location Complete Check"))) {
            reporter.failureReport("Verify Location Complete Check" , "All Mandatory Fields are not entered", driver);
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: GetComentsFromCommentWindow
     * description :: This method gets the comments from first row of comment window
     * date :: 16-Feb -2018
     * author :: Sachin
     */

    public String GetComentsFromCommentWindow() throws Throwable {
        waitForVisibilityOfElement(CRLocationsPage.txtCommentsCol, "Comments");
        String comment = getText(CRLocationsPage.txtCommentsCol, "Comments Type");
        return comment;
    }
}
