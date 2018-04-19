package com.aaa.web.lib;

import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.DIHomePage;
import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.DIMCDPage;

import com.aaa.web.page.LoginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DIHomeLib extends ActionEngine {
    List<WebElement> allCallIds = null;
//    CommonLib commonLib=new CommonLib();
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnContinueQueuesInDispatch
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnContinueQueuesInDispatch() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.btnContinueOnQueueSelection, "dispatch continue queue");
        click(DIHomePage.btnContinueOnQueueSelection, "dispatch continue queue");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchCallsInDispatch
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnSearchCallsInDispatch() throws Throwable {
        Thread.sleep(5000);
        waitForVisibilityOfElement(DIHomePage.btnSearchCalls, "Search calls Link");
        click(DIHomePage.btnSearchCalls, "Search calls Link");
    }

    public void clickOnSearchCallsLink() throws Throwable {
        Thread.sleep(5000);
        waitForVisibilityOfElement(DIHomePage.lnkSearchCalls, "Search calls Link");
        click(DIHomePage.lnkSearchCalls, "Search calls Link");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: logOut
     * description :: logOut
     * date :: 05-Nov-2017
     * author ::
     */
    public void logOut() throws Throwable {
        //waitForVisibilityOfElement(CRHomePage.lnklogout,"logOut link");

        Thread.sleep(2000);
        boolean checkForLogout = isVisibleOnly(CRHomePage.lnkLogout, "logOut link");
        //assertTrue(checkForLogout, "logOut link appeared");
        if (checkForLogout) {
            //assertTrue(checkForLogout, "logOut link appeared");
            click(CRHomePage.lnkLogout, "logOut link");
            waitForVisibilityOfElement(CRHomePage.btnLogout, "logOut");
            click(CRHomePage.btnLogout, "Logout button");
            acceptAlert();
            CloseLogoutAlert();
        } /*else {
            assertFalse(checkForLogout, "Logout link not appeared");
        }*/
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: searchandSelectCallID
     * description :: To search with selected callID
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void searchAndSelectCallIDInDI(String CallID) throws Throwable {
        enterCallIDInfo(CallID);
        clickOnSearchInSearchCalls();
        clickOnCallDateOrIDLink();
    }

    public void searchAndSelectCallIDInSPPDI(String CallID) throws Throwable {
        enterCallIDInfo(CallID);
        clickOnSearchInSearchCalls();
        clickOnCallDateOrIDLink();
    }

    public void verifyPhoneTypeOnDIMCD(String PhoneType) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        String phoneTypeInDI = getText(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        assertTrue(!(phoneTypeInDI.equalsIgnoreCase(PhoneType)), "Expected Phone Type is displayed in Dispatch MCD");
        closeMcd();
    }

    public void closeMcd() throws Throwable {
        click(DIHomePage.btnMCDwindowClose, "Close MCD Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallIDInfo
     * description :: To enter CallID in textBox
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterCallIDInfo(String callID) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.txtSearchCallID, "Click on CallID Field");
        click(DIHomePage.txtSearchCallID, "Click on CallID Field");
        waitForVisibilityOfElement(DIHomePage.txtSearchCallID, "Type CallID");
        System.out.println(callID);
        type(DIHomePage.txtSearchCallID, callID, "Type CallID");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickonSearchinSearchCalls
     * description :: To Click on search Button
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnSearchInSearchCalls() throws Throwable {
        click(DIHomePage.SearchButton, "Search Button");


    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallDateOrIDLink
     * description :: To Click on CallIDOrDate Link
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnCallDateOrIDLink() throws Throwable {
        boolean flagCallIdLink = isElementPresent(DIHomePage.clickOnCallIdLinkInDI, "Click On CallIdOrDate Link");
        if (flagCallIdLink) {
            waitForVisibilityOfElement(DIHomePage.clickOnCallIdLinkInDI, "Click On CallIdOrDate Link");
            click(DIHomePage.clickOnCallIdLinkInDI, "Click On CallIdOrDate Link");
        } else {
            assertTrue(flagCallIdLink, "No Calls avilable for CallID");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallDateOrIDLink
     * description :: To Click on CallIDOrDate Link
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnProfile() throws Throwable {
        clickOnProfileMenu();
        clickOnProfile1UnderProfileMenu();
        Thread.sleep(22000);
    }

    public void clickOnProfile1UnderProfileMenu() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.linkProfile1InProfileMenu, "Click Profile under Profile Menu");
        click(DIHomePage.linkProfile1InProfileMenu, "Click Profile under Profile Menu");
    }


    public void clickOnProfileMenu() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Tab");
        click(DIHomePage.tabDiProfile, "Profile Tab");
    }

    //Double click on Call Id
    public void searchAndSelectCallIDOnProfile(String CallID) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.callIdInProfileMenu, "CallId in Profile");
        allCallIds = getWebElementList(DIHomePage.lblCallIDInProfileResultsWindow, "CallId in Profile");
        if (allCallIds != null) {
            for (int i = 0; i <= allCallIds.size(); i++) {
                String callIdFromList = allCallIds.get(i).getText();
                if (CallID.equals(callIdFromList)) {
                    Actions action = new Actions(driver);
                    action.doubleClick(allCallIds.get(i)).build().perform();
                }
            }
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyPhoneTypeOnProfile
     * description :: To verify the PhoneType On Profile
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyPhoneTypeOnProfile(String PhoneType) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        String phoneTypeInDI = getText(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        assertTrue(!(phoneTypeInDI.equalsIgnoreCase(PhoneType)), "Expected Phone Type is displayed in Dispatch Profile");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTruckLoad
     * description :: To click On Truck Load Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnTruckLoad() throws Throwable {
        clickOnTruckLoadTab();
        clickOnTruckLoadDefaultOption();
    }

    public void clickOnTruckLoadTab() throws Throwable {
        //wait(2000);
        waitForVisibilityOfElement(DIHomePage.tabTruckLoad, "TruckLoad Tab");
        click(DIHomePage.tabTruckLoad, "TruckLoad Tab");
    }

    public void clickOnTruckLoadDefaultOption() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.truckLoadDefaultView, "Default View On TruckLoad");
        click(DIHomePage.truckLoadDefaultView, "Default View On TruckLoad");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyPhoneTypeOnTruckLoad
     * description :: To verify the PhoneType On MCD
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyPhoneTypeOnTruckLoad(String PhoneType) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        String phoneTypeInDI = getText(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        assertTrue(!(phoneTypeInDI.equalsIgnoreCase(PhoneType)), "Expected Phone Type is displayed in Dispatch MCD");
        closeMcd();
       /* waitForVisibilityOfElement(DIHomePage.phoneTypeOnDefaultView, "get Phone Type");
        String phoneTypeInDI = getText(DIHomePage.phoneTypeOnDefaultView, "get Phone Type");
        *//*if (phoneTypeInDI.equalsIgnoreCase(PhoneType)) {
            assertTrue(phoneTypeInDI.equalsIgnoreCase(PhoneType), "Expected Phone Type is displayed in Dispatch TruckLoad");
        } else {
            assertFalse(phoneTypeInDI.equalsIgnoreCase(PhoneType), "Expected Phone Type is not displayed in Dispatch TruckLoad");
        }*//*
        assertTrue(phoneTypeInDI.equalsIgnoreCase(PhoneType), "Expected Phone Type is displayed in Dispatch TruckLoad");*/

    }

    //spp Dispatch
    public void clickForSearchCallID() throws Throwable {
        closeFacilityWindow();
        clickOnSearchCallsInDispatch();
        //searchandSelectCallID(callId);

    }

    public void closeFacilityWindow() throws Throwable {
        click(DIHomePage.closeFacilityWindow, "close Facility window");
    }

    public void verifyPhoneTypeOnSPPDIMCD(String PhoneType) throws Throwable {

        boolean emptyResults = isVisibleOnly(DIHomePage.emptyResultsForCallID, "Empty Results");
        if (emptyResults) {
            assertTrue(emptyResults, "No Records found with the give search criteria");
        } else {
            waitForVisibilityOfElement(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
            String phoneTypeInDI = getText(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
            assertTrue(phoneTypeInDI.equalsIgnoreCase(PhoneType), "Expected Phone Type is displayed in SPPDispatch MCD");
        }
    }

    public void verifyPhoneTypeInSPPTruckLoadDefault(String PhoneType) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.phoneTypeOnDefaultViewTruckLoad, "get Phone Type");
        String phoneTypeInSppDI = getText(DIHomePage.phoneTypeOnDefaultViewTruckLoad, "get Phone Type");
        assertTrue(!(phoneTypeInSppDI.equalsIgnoreCase(PhoneType)), "Expected Phone Type is displayed in SPPDispatch TruckLoad");
    }

    public void clickOnProfileInSPPDI() throws Throwable {
        clickOnProfileMenuSPPDI();
        clickOnProfile1UnderProfileMenuSPPDI();
    }

    public void clickOnProfile1UnderProfileMenuSPPDI() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.linkProfile1InProfileMenu, "Profile1 under Profile Menu");
        click(DIHomePage.linkProfile1InProfileMenu, "Profile1 under Profile Menu");
        Thread.sleep(10000);
    }


    public void clickOnProfileMenuSPPDI() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.profile1SPPDI, "Profile Tab");
        click(DIHomePage.profile1SPPDI, "Profile Tab");
    }

    public void verifyPhoneTypeOnProfileInSPPDI(String PhoneType) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        String phoneTypeInDI = getText(DIHomePage.labelPhoneTypeOnDIMCD, "get Phone Type");
        assertTrue(!(phoneTypeInDI.equalsIgnoreCase(PhoneType)), "Expected Phone Type is displayed in Dispatch Profile");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseIconOnQueueSelection
     * description :: clicking On Close icon On Queue Selection popup
     * date :: 18-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnCloseIconOnQueueSelection() throws Throwable {

        waitForVisibilityOfElement(DIHomePage.iconCloseOnQueueSelection, "Cancel Button is Available");

        boolean closeIconOnQueueSelection = isVisibleOnly(DIHomePage.iconCloseOnQueueSelection, "Close icon is Available");
        //assertTrue(closeIconOnQueueSelection, "Queue Selection popup Appeared");
        if (closeIconOnQueueSelection) {
         //   assertTrue(closeIconOnQueueSelection, "Queue Selection popup Appeared");
            click(DIHomePage.iconCloseOnQueueSelection, "Close Icon Queue Selection");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: sessionInNewTab
     * description :: Using this method we can open the session in new tab
     * date :: 18-Nov-2017
     * author :: Chandu Dendukuri
     */
    public void sessionInNewTab() throws Throwable {
        String currentUrl = driver.getCurrentUrl();
        boolean sessionURL = currentUrl.contains("=");
        if (sessionURL) {
            String currentSessionID[] = currentUrl.split("=");
            String sessionID = currentSessionID[1];
            openURLInNewWindow(currentUrl);
            waitForVisibilityOfElement(DIHomePage.lnkLogout, "LogoutLink");
            waitForVisibilityOfElement(DIHomePage.lnkLogout, "logOut link");
            boolean flag = isVisibleOnly(DIHomePage.lnkLogout, "logOut link");
            assertTrue(flag, "User logged in successfully");
            String newCurrentUrl = driver.getCurrentUrl();
            String newCurrentSessionID[] = newCurrentUrl.split("=");
            String newSessionID = newCurrentSessionID[1];
            //assertTrue(sessionID.equalsIgnoreCase(newSessionID), "Same session continued in the new tab");
        } else {
            //assertTrue(sessionURL, "Not contains Session id");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStartDate
     * description :: Entering Start date on Search callas window
     * date :: 20-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void enterStartDate(String startDate) throws Throwable {
        click(DIHomePage.txtStartDate, "Start Date text field");
        clearData(DIHomePage.txtStartDate);
        type(DIHomePage.txtStartDate, startDate, "Start Date text field");


    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getPTATimeZone
     * description :: Entering Start date on Search callas window
     * date :: 20-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public String getPTATimeZone() throws Throwable {

        String pstTimeZone = getText(DIHomePage.lblMCDPTATimeZone, "Verifying PTA Time Zone");
        return pstTimeZone;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: compareTimeZonesInCRDI
     * description :: Entering Start date on Search callas window
     * date :: 20-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void compareTimeZonesInCRDI(String pstTimeZone, String newZone) throws Throwable {
        boolean compareingTimeZones = pstTimeZone.equalsIgnoreCase(newZone);
/*        if (compareingTimeZones) {

            assertTrue(compareingTimeZones, "Breakdown location TIme Zone " + newZone + " " + " and MCD window Time Zone " + pstTimeZone + " are equal");
        } else {
            assertFalse(compareingTimeZones, "Breakdown location TIme Zone " + newZone + " " + " and MCD window Time Zone " + pstTimeZone + " are not equal");

        }*/
        assertTrue(compareingTimeZones, "Breakdown location TIme Zone " + newZone + " " + " and MCD window Time Zone " + pstTimeZone + " are equal");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDispatchTab
     * description :: Clicking on Dispatch Tab
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnDispatchTab() throws Throwable {


        //clickUntil(DIHomePage.btnDispatchTab, DIHomePage.btnDispatchTab, "Dispatch Tab");
        click(DIHomePage.btnDispatchTab, "Dispatch Tab");

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getDispatchQueueFirstFieldValue
     * description :: Retriving Dispatch Queue First Field Value
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public String getDispatchQueueFirstFieldValue() throws Throwable {
        String queueFirstValue = null;
        boolean dispatchQueue = isVisibleOnly(DIHomePage.lblQueueFieldFirstItem, "Dispatch Field Items");
        if (dispatchQueue) {
            queueFirstValue = getText(DIHomePage.lblQueueFieldFirstItem, "Dispatch Field Value");
            //clickUntil(DIHomePage.lblQueueFieldFirstItem,DIHomePage.lblQueueFieldFirstItem, "Dispatch Field Value");
            click(DIHomePage.lblQueueFieldFirstItem, "Dispatch Field Value");
        } else {
            assertTrue(dispatchQueue, "Dispatch Field Value are empty");
        }
        return queueFirstValue;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getDispatchQueueSecondFieldValue
     * description :: Retriving Dispatch Queue Second Field Value
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public String getDispatchQueueSecondFieldValue() throws Throwable {

        String queueSecondValue = null;
        boolean dispatchQueue = isVisibleOnly(DIHomePage.lblQueueFieldSecondItem, "Dispatch field Items");
        if (dispatchQueue) {
            queueSecondValue = getText(DIHomePage.lblQueueFieldSecondItem, "Dispatch Field Value");
            //clickUntil(DIHomePage.lblQueueFieldSecondItem,DIHomePage.lblQueueFieldSecondItem,"Dispatch Field Value");
            click(DIHomePage.lblQueueFieldSecondItem, "Dispatch Field Value");
        } else {
            assertTrue(dispatchQueue, "Dispatch Field Value are empty");
        }
        return queueSecondValue;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddButtonOnQueueWindow
     * description :: clicking On Add Button On Queue Window
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnAddButtonOnQueueWindow() throws Throwable {
        //clickUntil(DIHomePage.btnAddOnQueueWindow,DIHomePage.btnAddOnQueueWindow, "Add Button on dispatch window");
        click(DIHomePage.btnAddOnQueueWindow, "Add Button on dispatch window");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRemoveButtonOnQueueWindow
     * description :: clicking On Remove Button On Queue Window
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnRemoveButtonOnQueueWindow() throws Throwable {
        clickUntil(DIHomePage.btnRemoveOnQueueWindow, DIHomePage.btnRemoveOnQueueWindow, "Remove Button on dispatch window");
        click(DIHomePage.btnRemoveOnQueueWindow, "Remove Button on dispatch window");
    }

    /**
     * param :: String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInQueueFilterDispatch
     * description :: Entering value in Queue Filter Dispatch
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void enterValueInQueueFilterDispatch(String fieldValue) throws Throwable {


        boolean dispatchQueueFilter = isVisibleOnly(DIHomePage.txtQueueFilterDispatch, "Dispatch Queue Filter");
        if (dispatchQueueFilter) {

            //typeUntil(DIHomePage.txtQueueFilterDispatch, fieldValue,"Dispatch Queue Filter ");
            type(DIHomePage.txtQueueFilterDispatch, fieldValue, "Dispatch Queue Filter ");
        } else {
            assertTrue(dispatchQueueFilter, "Dispatch filter is appeared");
        }

    }

    /**
     * param :: String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInQueueFilterSelected
     * description :: Entering value in Queue Filter Selected
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void enterValueInQueueFilterSelected(String fieldValue) throws Throwable {

        waitForVisibilityOfElement(DIHomePage.txtQueueFilterSelected, "Selected Queue Filter");
        boolean selectedQueueFilter = isVisibleOnly(DIHomePage.txtQueueFilterSelected, "Selected Queue Filter");
        if (selectedQueueFilter) {

            //typeUntil(DIHomePage.txtQueueFilterSelected, fieldValue, "Dispatch Queue Filter ");
            type(DIHomePage.txtQueueFilterSelected, fieldValue, "Selected Queue Filter ");
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectAllLinkOnQueueWindow
     * description :: click on Select All link
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnSelectAllLinkOnQueueWindow() throws Throwable {
        //clickUntil(DIHomePage.lnkSelectAll,DIHomePage.lnkSelectAll,"Select All");
        click(DIHomePage.lnkSelectAll, "Select All");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFieldItemHighlightStatusCount
     * description :: Getting the size of highlighted field values
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void getFieldItemHighlightStatusCount() throws Throwable {
        int records = getElementsSize(DIHomePage.lblHighlightedFieldValue);
        /*if (records != 0) {
            assertTrue(true, records + " records are highlighted");
        } else {
            assertFalse(false, records + " No records found");
        }*/
        assertTrue(records != 0, records + " records are highlighted");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyEmptyRecordsInDispatch
     * description :: Verify no records found in dispatch queue
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyEmptyRecordsInDispatch() throws Throwable {

        int records = getElementsSize(DIHomePage.lblQueueFieldFirstItem);
        /*if (records == 0) {
            assertTrue(true, records + " records are Available in Dispatch Queue hence all records are moved into Selected Queue");
        } else {
            assertFalse(false, records + " No records found");
        }*/
        assertTrue(records == 0, records + " records are Available in Dispatch Queue hence all records are moved into Selected Queue");

       /* boolean record = isVisibleOnly(DIHomePage.lblQueueFieldFirstItem,"Records");
        if(!record)
        {
           assertTrue(record,"All Records are moved to Selected section");
        }else{
            assertFalse(record,"Records are not moved to selected section");
        }*/
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyEmptyRecordsInDispatch
     * description :: Verify no records found in dispatch queue
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyEmptyRecordsInSelected() throws Throwable {

        int records = getElementsSize(DIHomePage.lblQueueFieldFirstItemInSelected);
        boolean record = (records ==0 );
        /*if (records == 0) {
            assertTrue(true, records + " records are Available in Selected Queue hence all records are moved back to dispatch Queue");
        } else {
            assertFalse(false, records + " No records found");
        }*/
        //assertTrue(record, records + " records are Available in Selected Queue hence all records are moved back to dispatch Queue");
    }

    /**
     * param :: String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInQueueFilterSpot
     * description :: Entering value in Queue Filter Spot
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void enterValueInQueueFilterSpot(String fieldValue) throws Throwable {


        boolean spotQueueFilter = isVisibleOnly(DIHomePage.txtqueueFilterSpot, "Spot Queue Filter");
        if (spotQueueFilter) {

            typeUntil(DIHomePage.txtqueueFilterSpot, fieldValue, "Spot Queue Filter ");
            //type(DIHomePage.txtQueueFilterDispatch, fieldValue,"Dispatch Queue Filter ");
        } else {
            assertTrue(spotQueueFilter, "Spot filter is appeared");
        }
    }

    /**
     * param :: String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInSelectedFilterSpot
     * description :: Entering value in Queue Filter Spot
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void enterValueInSelectedFilterSpot(String fieldValue) throws Throwable {


        boolean spotQueueFilter = isVisibleOnly(DIHomePage.txtQueueFilterSelected, "Spot Selected Filter");
        if (spotQueueFilter) {

            typeUntil(DIHomePage.txtQueueFilterSelected, fieldValue, "Spot Selected Filter ");
            //type(DIHomePage.txtQueueFilterDispatch, fieldValue,"Dispatch Queue Filter ");
        } else {
            assertTrue(spotQueueFilter, "Spot filter is appeared");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseButtonOnQueueWindow
     * description :: clickOnCloseButtonOnQueueWindow
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnCloseButtonOnQueueWindow() throws Throwable {
        click(DIHomePage.btnCloseOnQueueWindow, "Close button");
    }

    /**
     * param ::String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectChangeSetQueueMenuItem
     * description :: selectChangeSetQueueMenuItem
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void selectChangeSetQueueMenuItem() throws Throwable {
        mouseClick(DIHomePage.lnkApplicationMenu, "Application Menu");
        click(DIHomePage.lnkChangeSetQueueSelection, "Change Set Queue Selection ");
        //selectByValue(DIHomePage.lnkApplicationMenu,UserProfile,"User Profile");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnChangeEditQueueSelection
     * description :: clickOnChangeEditQueueSelection
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnChangeEditQueueSelection() throws Throwable {
        boolean changeEditQueu = isVisibleOnly(DIHomePage.btnChangeEditQueueSelection, "Change Edit Button");
        assertTrue(changeEditQueu, "Change Edit Queue window appeared");
        if (changeEditQueu) {
         //   assertTrue(changeEditQueu, "Change Edit Queue window appeared");
            click(DIHomePage.btnChangeEditQueueSelection, "Change Edit Button");
        }/* else {
            assertFalse(changeEditQueu, "User Profile window not appeared");
        }*/

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyUserProfilePopupWindow
     * description :: verifyUserProfilePopupWindow
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyUserProfilePopupWindow() throws Throwable {
        boolean userProfileWindow = isVisibleOnly(DIHomePage.btnChangeEditQueueSelection, "Change Edit Button");
        /*if (userProfileWindow) {
            assertTrue(userProfileWindow, "User Profile window appeared");
        } else {
            assertFalse(userProfileWindow, "User Profile window not appeared");
        }*/
        assertTrue(userProfileWindow, "User Profile window appeared");
    }

    /**
     * description ::To click on Hidden tabs dropdown of profile Window
     * date :: 29-Dec-2017
     *
     * @throws Throwable
     * @author :Madhukar
     */
    public void clickOnHiddenTabsDropdown() throws Throwable {
        boolean hiddenTabs = isVisibleOnly(DIHomePage.drpdwnHiddenTabs, "Hidden Tabs");
        if (hiddenTabs) {
            click(DIHomePage.drpdwnHiddenTabs, "Hidden Tabs");
        } else {
            assertTrue(hiddenTabs, "Hidden tabs is visible");
        }
    }

    /**
     * description ::To select an Tab  from a HiddenTabs DropDown
     * date :: 29-Dec-2017
     *
     * @param tabName
     * @throws Throwable
     * @author: Madhukar
     */
    public void selectTabFromHiddenTabsDropDown(String tabName) throws Throwable {
        List<WebElement> allTabs = getWebElementList(DIHomePage.listOfHiddenTabs, "Hidden Tabs List");
        for (int i = 0; i < allTabs.size(); i++) {
            String tabItems = allTabs.get(i).getText();
            if (tabItems.equalsIgnoreCase(tabName)) {
                Actions action = new Actions(driver);

                action.click(allTabs.get(i));
            }
        }

    }

    /**
     * description ::To click on Tab plus button on Profile Window
     * date :: 29-Dec-2017
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void clickOnTabPlusButton() throws Throwable {
        boolean hiddenTabs = isVisibleOnly(DIHomePage.linkTabPlusButton, "Hidden Tabs");
        if (hiddenTabs) {
            click(DIHomePage.linkTabPlusButton, "Hidden Tabs");
        } else {
            assertTrue(hiddenTabs, "Hidden tabs is visible");
        }
    }

    /**
     * description ::To select a tab from Plus Button on Profile Window
     * date :: 29-Dec-2017
     *
     * @param tabName
     * @throws Throwable
     * @author: Madhukar
     */
    public void selectTabFromPlusButton(String tabName) throws Throwable {
        List<WebElement> allTabs = getWebElementList(DIHomePage.listOfHiddenTabsInPlusButton, "Hidden Tabs List");
        for (int i = 0; i < allTabs.size(); i++) {
            String tabItems = allTabs.get(i).getText();
            if (tabItems.equalsIgnoreCase(tabName)) {
                Actions action = new Actions(driver);

                action.click(allTabs.get(i));
            }
        }

    }

    /**
     * description :: To verify which status is available on Beyond ETA Tab
     *
     * @param etaStatus
     * @throws Throwable
     * @author: Madhukar
     * Date:29-12-2017
     */
    public void verifyStatusinBeyondETATab(String etaStatus) throws Throwable {
        boolean status = isVisibleOnly(DIHomePage.statusInBeyondETATabOnProfileWindow, "Status In BeyondETATab");
        if (status) {
            String statusInETA = getText(DIHomePage.statusInBeyondETATabOnProfileWindow, "Status");
            assertTrue(etaStatus.equalsIgnoreCase(statusInETA), etaStatus + "is found");
        } else {
            assertTrue(status, "Status in BeyondETATab is available");
        }
    }

    /**
     * description ::To minimize the Profile Window
     * Date:29-12-2017
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void clickToMinimizeProfileWindow() throws Throwable {
        boolean minimize = isVisibleOnly(DIHomePage.linkMinimizeProfileWindow, "minimize Button");
        if (minimize) {
            click(DIHomePage.linkMinimizeProfileWindow, "minimize Button");
        } else {
            assertTrue(minimize, "minimize Button visible");
        }
    }

    /**
     * description ::To open popped out Window
     * date:29-12-2017
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void clickToOpenPoppedOutWindow() throws Throwable {
        boolean poppedWindow = isVisibleOnly(DIHomePage.linkProfileWindowPoppedOut, "Poppedout Window");
        if (poppedWindow) {
            click(DIHomePage.linkProfileWindowPoppedOut, "Poppedout Window");
        } else {
            assertTrue(poppedWindow, "Poppedout window visible");
        }
    }

    /**
     * description ::To click on gear Icon On profile Window
     * date:29-12-2017
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void clickOnGearIconOfProfileWindow() throws Throwable {
        boolean gearIcon = isVisibleOnly(DIHomePage.linkSettingsGearIconOnProfileWindow, "Gear Icon");
        if (gearIcon) {
            click(DIHomePage.linkSettingsGearIconOnProfileWindow, "Gear Icon");
        } else {
            assertTrue(gearIcon, "Gear Icon Is visible");
        }
    }

    /**
     * Description:To click on Arrow button of ID
     * date:29-12-2017
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void clickOnArrowButtonOfID() throws Throwable {
        boolean idArrow = isVisibleOnly(DIHomePage.btnIDArrowOfProfileWindow, "Id Arrow Button");
        if (idArrow) {
            click(DIHomePage.btnIDArrowOfProfileWindow, "Id Arrow Button");
        } else {
            assertTrue(idArrow, "ID Arrow button is visible");
        }
    }

    /**
     * Description:To click on Arrow button of ID
     * date:29-12-2017
     *
     * @throws Throwable
     * @author: Nidhi Kumaru R
     */
    public void selectFasdfProfileMenuItem() throws Throwable {
        click(DIHomePage.lnkUserProfile, "User Profile");
        boolean idArrow = isVisibleOnly(DIHomePage.lnkFasdfProfileOnProfilesMenu, "FasdfProfile");
        if (idArrow) {
            click(DIHomePage.lnkFasdfProfileOnProfilesMenu, "FasdfProfile");
        } else {
            assertTrue(idArrow, "FasdfProfile is visible");
        }
    }

    /**
     * Description:To click on Arrow button of ID
     * date:29-12-2017
     *
     * @throws Throwable
     * @author: Nidhi Kumaru R
     */
    public void clickOnParamProfileMenuItem() throws Throwable {
        click(DIHomePage.lnkUserProfile, "User Profile");
        boolean idArrow = isVisibleOnly(DIHomePage.lnkParamProfileOnProfilesMenu, "Param Profile");
        if (idArrow) {
            click(DIHomePage.lnkParamProfileOnProfilesMenu, "Param Profile");
        } else {
            assertTrue(idArrow, "Param Profile is visible");
        }
    }

    /**
     * Description:To click on Arrow button of ID
     * date:29-12-2017
     *
     * @throws Throwable
     * @author: Nidhi Kumaru R
     */
    public void clickOnQaautoTwoMenuItem() throws Throwable {
        click(DIHomePage.lnkUserProfile, "User Profile");
        boolean idArrow = isVisibleOnly(DIHomePage.lnkQAAutoTwoProfileOnProfilesMenu, "QAAuto2 Profile");
        if (idArrow) {
            click(DIHomePage.lnkParamProfileOnProfilesMenu, "QAAuto2 Profile");
        } else {
            assertTrue(idArrow, "QAAuto2 Profile is visible");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRemoveAll
     * description :: clickOnRemoveAll
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnRemoveAll() throws Throwable {
        click(DIHomePage.lnkRemoveAll, "Remove all");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getQueueFieldFirstItemInSelected
     * description :: Verify no records found in dispatch queue
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public String getQueueFieldFirstItemInSelected() throws Throwable {

        String selectedFirstValue = null;
        boolean selectedQueue = isVisibleOnly(DIHomePage.lblQueueFieldFirstItemInSelected, "Dispatch Field Items");
        if (selectedQueue) {
            selectedFirstValue = getText(DIHomePage.lblQueueFieldFirstItemInSelected, "Dispatch Field Value");
            //clickUntil(DIHomePage.lblQueueFieldFirstItem,DIHomePage.lblQueueFieldFirstItem, "Dispatch Field Value");
            //click(DIHomePage.lblQueueFieldFirstItemInSelected,"Dispatch Field Value");
            mouseClick(DIHomePage.lblQueueFieldFirstItemInSelected, "Dispatch Field Value");
        } else {
            assertTrue(selectedQueue, "Dispatch Field Value are empty");
        }
        return selectedFirstValue;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: compareDispatchAndSelectedValues
     * description :: Verify no records found in dispatch queue
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void compareDispatchAndSelectedValues(String dispatch, String selected, String source, String Destination) throws Throwable {


        boolean results = dispatch.equalsIgnoreCase(selected);
        /*if (results) {
            assertTrue(results, "The " + source + " value" + dispatch + "is moved to " + Destination + " queue");
        } else {
            assertFalse(results, "The " + source + " value" + dispatch + "is not moved to " + Destination + " queue");
        }*/
        assertTrue(results, "The " + source + " value" + dispatch + "is moved to " + Destination + " queue");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyDragDropFunctionalityForDispatch
     * description :: verifyDragDropFunctionalityForDispatch
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyDragDropFunctionalityForDispatch() throws Throwable {
        dragAndDrop(DIHomePage.lblQueueFieldFirstItem, DIHomePage.areaSelectedResultsGrid, "Queue Field Item was moved into Selected field");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSpotTab
     * description :: verifyDragDropFunctionalityForDispatch
     * date :: 29-Dec-2017
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnSpotTab() throws Throwable {
        click(DIHomePage.btnSpotTab, "Spot Tab");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getSpotQueueFirstFieldValue
     * description :: Retriving Spot Queue First Field Value
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public String getSpotQueueFirstFieldValue() throws Throwable {
        String spotQueueFirstValue = null;
        boolean dispatchQueue = isVisibleOnly(DIHomePage.lblQueueFirstItemInSpotContainer, "Spot Field Items");
        if (dispatchQueue) {
            spotQueueFirstValue = getText(DIHomePage.lblQueueFirstItemInSpotContainer, "Spot Field Value");
            //clickUntil(DIHomePage.lblQueueFieldFirstItem,DIHomePage.lblQueueFieldFirstItem, "Dispatch Field Value");
            click(DIHomePage.lblQueueFirstItemInSpotContainer, "Spot Field Value");
        } else {
            assertTrue(dispatchQueue, "Spot Field Value are empty");
        }
        return spotQueueFirstValue;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getSpotSelectedQueueFirstFieldValue
     * description :: Retriving Spot Slected Queue First Field Value
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public String getSpotSelectedQueueFirstFieldValue() throws Throwable {
        String spotSelectedQueueFirstValue = null;
        boolean dispatchQueue = isVisibleOnly(DIHomePage.lblSelectedQueueFirstItemInSpotContainer, "Spot Field Items");
        if (dispatchQueue) {
            spotSelectedQueueFirstValue = getText(DIHomePage.lblSelectedQueueFirstItemInSpotContainer, "Spot Field Value");
            //clickUntil(DIHomePage.lblQueueFieldFirstItem,DIHomePage.lblQueueFieldFirstItem, "Dispatch Field Value");
            click(DIHomePage.lblSelectedQueueFirstItemInSpotContainer, "Spot Field Value");
        } else {
            assertTrue(dispatchQueue, "Spot Field Value are empty");
        }
        return spotSelectedQueueFirstValue;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFieldItemHighlightStatusCountInSpot
     * description :: Getting the size of highlighted field values in Spot
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void getFieldItemHighlightStatusCountInSpot() throws Throwable {
        int records = getElementsSize(DIHomePage.lblHighlightedFieldValueSpot);
        /*if (records != 0) {
            assertTrue(true, records + " records are highlighted");
        } else {
            assertFalse(false, records + " No records found");
        }*/
        assertTrue(records != 0, records + " records are highlighted");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectAllLinkOnSpotQueueWindow
     * description :: click on Select All link
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnSelectAllLinkOnSpotQueueWindow() throws Throwable {
        //clickUntil(DIHomePage.lnkSelectAll,DIHomePage.lnkSelectAll,"Select All");
        click(DIHomePage.lnkSelectAllSpot, "Select All");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyEmptyRecordsInSpot
     * description :: Verify no records found in Spot queue
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyEmptyRecordsInSpotSelected() throws Throwable {

        int records = getElementsSize(DIHomePage.lblSelectedQueueFirstItemInSpotContainer);
        /*if (records == 0) {
            assertTrue(true, records + " records are Available in Selected Queue hence all records are moved into Spot Queue");
        } else {
            assertFalse(false, records + " No records found");
        }*/
        assertTrue(records == 0, records + " records are Available in Selected Queue hence all records are moved into Spot Queue");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyEmptyRecordsInSpot
     * description :: Verify no records found in Spot queue
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyEmptyRecordsInSpotQueue() throws Throwable {

        int records = getElementsSize(DIHomePage.lblQueueFirstItemInSpotContainer);
        /*if (records == 0) {
            assertTrue(true, records + " records are Available in Spot Queue hence all records are moved into Selected Queue");
        } else {
            assertFalse(false, records + " No records found");
        }*/
        assertTrue(records == 0, records + " records are Available in Spot Queue hence all records are moved into Selected Queue");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyDragDropFunctionalityForSpot
     * description :: verifyDragDropFunctionalityForSpot
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void verifyDragDropFunctionalityForSpot() throws Throwable {
        dragAndDrop(DIHomePage.lblQueueFirstItemInSpotContainer, DIHomePage.areaSelectedResultsGrid, "Queue Field Item was moved into Selected field");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyRecordsCountInSpotSelected
     * description :: verifyRecordsCountInSpotSelected
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public int verifyRecordsCountInSpotSelected() throws Throwable {

        int records = getElementsSize(DIHomePage.lstSelectedQueueFields);
        /*if (records != 0) {
            assertTrue(true, records + " records are added into selected Queue");
        } else {
            assertFalse(false, records + " No records found");
        }*/
        assertTrue(records != 0, records + " records are added into selected Queue");
        return records;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: compareSavedRecordsSize
     * description :: compareSavedRecordsSize
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void compareSavedRecordsSize(int records, int recordsVerify) throws Throwable {

        /*if (records == recordsVerify) {
            assertTrue(true, "Records are saved successfully");
        } else {
            assertFalse(false, "Records not saved successfully");
        }*/
    	assertTrue(records == recordsVerify, "Records are saved successfully");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: escapeSendKeys
     * description :: escapeSendKeys
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void escapeSendKeys() throws Throwable {
        String combineKeys1 = Keys.chord(Keys.ESCAPE);
        sendKeys(combineKeys1, "Esc");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDispatchQueuePopup
     * description :: clickOnDispatchQueuePopup
     * date :: 01-Jan-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnDispatchQueuePopup() throws Throwable {
        click(DIHomePage.dispatchQueuePopup, "Highlighted Dispatch popup");

    }

    /**
     * Description:To click on Arrow button of Date on Profile Window
     * date:29-12-2017
     *
     * @throws Throwable
     */
    public void clickOnArrowButtonOfDate() throws Throwable {
        boolean dateArrow = isVisibleOnly(DIHomePage.btnDateArrowOfProfileWindow, "Date Arrow Button");
        if (dateArrow) {
            click(DIHomePage.btnDateArrowOfProfileWindow, "Date Arrow Button");
        } else {
            assertTrue(dateArrow, "Date Arrow button is visible");
        }
    }


    /**
     * Description:To verify priority label of ID on profile window
     * date:29-12-2017
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void verifyLabelPriorityOfIDOnProfileWindow() throws Throwable {
        boolean priority = isVisibleOnly(DIHomePage.lblPriorityOfIDOnProfileWindow, "Priority label");
        /*if (priority) {
            assertTrue(priority, "Priority label is visible");
        } else {
            assertFalse(priority, "Priority label is not visible");
        }*/
        assertTrue(priority, "Priority label is visible");
    }

    /**
     * Description:To verify priority label of ID on profile window
     * date:29-12-2017
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void verifyLabelOrderOfIDOnProfileWindow() throws Throwable {
        boolean order = isVisibleOnly(DIHomePage.lblOrderOfIDOnProfileWindow, "Priority label");
        /*if (order) {
            assertTrue(order, "Order label is visible");
        } else {
            assertFalse(order, "Order label is not visible");
        }*/
        assertTrue(order, "Order label is visible");
    }


    /**
     * Description:To select priority from ID on Profile Window
     * date:29-12-2017
     *
     * @param priority
     * @throws Throwable
     * @author: madhukar
     */
    public void selectPriority(String priority) throws Throwable {
        // JSClick(DIHomePage.drpdwnPriority,"Select priority");
        mouseClick(DIHomePage.drpdwnPriority, "Select priority");
        selectByValue(DIHomePage.drpdwnPriority, priority, "Select priority");
    }

    /**
     * Description:To select Order from ID on Profile Window
     * date:29-12-2017
     *
     * @param order
     * @throws Throwable
     * @author : Madhukar
     */
    public void selectOrder(String order) throws Throwable {
        mouseClick(DIHomePage.drpdwnOrder, "Select order");
        selectByVisibleText(DIHomePage.drpdwnOrder, order, "Select order");

    }

    /**
     * Description: To click on save button of ID on Profile Window
     * date:29-12-2017
     *
     * @throws Throwable
     * @author : Madhukar
     */
    public void clickOnSaveButtonOfIDAndDateOnProfileWindow() throws Throwable {
        boolean save = isVisibleOnly(DIHomePage.btnSaveOfIDAndDateOnProfileWindow, "Save button of ID and Date");
        if (save) {
            click(DIHomePage.btnSaveOfIDAndDateOnProfileWindow, "Save button of ID and date");
        } else {
            assertTrue(save, "Save button of ID is visible");
        }
    }


    /**
     * Description:To select Descending Order from date in Profile Window
     *
     * @param descOrder
     * @throws Throwable
     */
    public void selectDescendingOrderFromDate(String descOrder) throws Throwable {
        selectByVisibleText(DIHomePage.drpdwnDescendindOrder, descOrder, "Select priority");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateIdPriorityOrder
     * description :: This method validates wether ID displays with a "1" next to it to indicate it's priority order
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void validateIdPriorityOrder(String columnname) throws Throwable {
        String priorityNumber;
        if (columnname == "ID") {
            priorityNumber = getText(DIHomePage.txtIDvalue, "ID Priority Number");
        } else {
            priorityNumber = getText(DIHomePage.txtDateValue, "Date Priority Number");
        }

        /*if (priorityNumber == "1") {
            assertTrue(true, columnname + " now displays with a '1' next to it to indicate it's priority order");
        } else {
            assertFalse(false, columnname + " does not displays with a '1' next to it to indicate it's priority order");
        }*/
        assertTrue(priorityNumber == "1", columnname + " now displays with a '1' next to it to indicate it's priority order");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateAscendingDescendingIcons
     * description ::
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void validateAscendingDescendingIcons() throws Throwable {
        boolean iconAscending = isElementPresent(DIHomePage.iconSortAscensing, "Click On CallIdOrDate Link");
        boolean iconDescending = isElementPresent(DIHomePage.iconSortDescending, "Click On CallIdOrDate Link");

        /*if (iconAscending && iconDescending) {
            assertTrue(true, "Profile window columns have tiny triangles to indicate ascending and descending sorting");
        } else {
            assertFalse(false, "Profile window columns have tiny triangles to indicate ascending and descending sorting");
        }*/
        assertTrue((iconAscending && iconDescending), "Profile window columns have tiny triangles to indicate ascending and descending sorting");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateAscendingDescendingIcons
     * description ::
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void clickOnActionRequiredTabInProfileWindow() throws Throwable {
        clickUntil(DIHomePage.tabActionRequired, DIHomePage.tabActionRequired, "Action Required Tab");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateAscendingOrderofColumn
     * description :: This function clicks on Id Column in Action Required tab in Profile window
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void validateAscendingOrderofColumn() throws Throwable {
        boolean iconAescending = isElementPresent(DIHomePage.iconSortAscensingInProfileWindow, "Ascending Order icon in ID column of Profile window");

        /*if (iconAscending) {
            assertTrue(true, "Ascending order is verified");
        } else {
            assertFalse(false, "Not is ascending order");
        }*/
        assertTrue(iconAescending, "Ascending order is verified");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateDescendingOrderofColumn
     * description :: This function clicks on Id Column in Action Required tab in Profile window
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void validateDescendingOrderofColumn() throws Throwable {
        boolean iconDescending = isVisibleOnly(DIHomePage.iconSortDescendingInProfileWindow, "Ascending Order icon in ID column of Profile window");
        if(iconDescending)
        {
            click(DIHomePage.callIdInProfileMenu, "ID Column In profile Window");
        }
        assertTrue(!iconDescending, "Descending order is verified");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateDescendingOrderofColumn
     * description :: This function clicks on Id Column in Action Required tab in Profile window
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void validateSortingIsRemoved() throws Throwable {
        boolean iconAescending = isVisibleOnly(DIHomePage.iconSortAscensingInProfileWindow, "iCon Sorting");

        /*if (iconDescending) {
            assertTrue(true, "Sorting is removed from the column ");
        } else {
            assertFalse(false, "Sorting is not removed from the column");
        }*/
        assertTrue(iconAescending , "Sorting is removed from the column ");
    }


    /**
     * Description:To click on save settings button on Profile window
     * Date:01-01-2018
     *
     * @throws Throwable
     * @Author: Madhukar
     */
    public void clickOnSaveSettingsButtonOfProfileWindow() throws Throwable {
        boolean saveSettings = isVisibleOnly(DIHomePage.btnSaveSettingsInProfileWindow, "Save Settings Button");
        if (saveSettings) {
            click(DIHomePage.btnSaveSettingsInProfileWindow, "Save Settings Button");
        } else {
            assertTrue(saveSettings, "Save Settings button is visible");
        }
    }

    /**
     * Description:To click on Call ID Column Of Profile Window
     * Date:01-01-2018
     *
     * @throws Throwable
     * @Author: Madhukar
     */
    public void clickOnCallIDColumnOfProfileWindow() throws Throwable {
        boolean callIdColumn = isVisibleOnly(DIHomePage.iconSortDescendingInProfileWindow, "ID Column In profile Window");
        if (callIdColumn) {
            click(DIHomePage.callIdInProfileMenu, "ID Column In profile Window");
        }
    }

    /**
     * param ::String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectUserProfileMenuItem
     * description :: selectUserProfileMenuItem
     * date :: 01-01-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void selectUserProfileMenuItem() throws Throwable {
        mouseClick(DIHomePage.lnkApplicationMenu, "Application Menu");
        click(DIHomePage.lnkUserProfile, "User Selection Selection ");
        //selectByValue(DIHomePage.lnkApplicationMenu,UserProfile,"User Profile");
    }

    /**
     * param ::String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseButtonOnUserProfileWindow
     * description :: clickOnCloseButtonOnUserProfileWindow
     * date :: 01-01-2018
     * author :: Chandrasekhar Dendukuri
     */
    public void clickOnCloseButtonOnUserProfileWindow() throws Throwable {

        click(DIHomePage.btnCloseOnUserProfile, "Close button ");
        //selectByValue(DIHomePage.lnkApplicationMenu,UserProfile,"User Profile");
    }

    /* * Description:To click on All Calls Tab Of Profile Window
     * Date:01-01-2018
     * @throws Throwable
     * @Author: Madhukar
     */
    public void clickOnAllCallsTab() throws Throwable {
        boolean allCallsTab = isVisibleOnly(DIHomePage.tabAllCalls, "AllCalls Tab");
        if (allCallsTab) {
            click(DIHomePage.tabAllCalls, "AllCalls Tab");
        } else {
            assertTrue(allCallsTab, "Allcalls tab is visible ");
        }
    }

    /**
     * Description:To verify ID text on profile window
     *
     * @param txt_id
     * @throws Throwable
     */
    public void verifyIdTextOnprofileWindow(String txt_id) throws Throwable {
        boolean idText = isVisibleOnly(DIHomePage.txtIDvalue, "ID Text");
        if (idText) {
            String idValue = getText(DIHomePage.txtIDvalue, "ID Text");
        } else {
            assertTrue(idText, "ID Priority Order is Verified");
        }
    }

    /**
     * Description:To verify Date text on profile window
     *
     * @param txt_date
     * @throws Throwable
     */
    public void verifyDateTextOnprofileWindow(String txt_date) throws Throwable {
        boolean dateText = isVisibleOnly(DIHomePage.txtDateValue, "Date Text");
        if (dateText) {
            String dateValue = getText(DIHomePage.txtDateValue, "Date Text");
        } else {
            assertTrue(dateText, "Date Priority Order is Verified");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberNumberInfo
     * description :: To enter member number in textBox
     * date ::
     * author :: Nidhi
     */
    public void enterMemberNumberInfo(String MemberNumber) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.txtSearchMemberNumber, "Click on Member Number Field");
        click(DIHomePage.txtSearchMemberNumber, "Click on Member Number Field");
        waitForVisibilityOfElement(DIHomePage.txtSearchMemberNumber, "Type MemberNumber");
        System.out.println(MemberNumber);
        type(DIHomePage.txtSearchMemberNumber, MemberNumber, "Type MemberNumber");
    }

    /**
     * description :: To verify which status is available on Red Flag Tab
     * <p>
     * param verifyStatusinRedFlagTab
     *
     * @throws Throwable
     * @author: Nidhi
     * Date:02-Jan-2018
     */
    public void verifyStatusinRedFlagTab() throws Throwable {
        boolean status = isVisibleOnly(DIHomePage.statusInRedFlagTabOnProfileWindow, "Status In RedFlagcallTab");
        if (status) {
            String statusInRedFlag = getText(DIHomePage.statusInRedFlagTabOnProfileWindow, "Status");
            assertTrue(status, statusInRedFlag + "is Found");
        } else {
            assertTrue(status, "Status in RedFlagcallTab is available");

        }
    }

    /**
     * description ::To select an Tab  from a click On RedFlagCalls
     * date :: 02-02-2018
     * <p>
     * param tabName
     *
     * @throws Throwable
     * @author: Nidhi Kumari Raut
     */

    public void clickOnRedFlagCalls() throws Throwable {
        click(DIHomePage.lnkRedFlagInHiddenTabOne, "RedFlag Calls Link");
    }


    /* *
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectAllDispatchCallsAddAndContinueInQueueSelection
     * description :: select all dispatch calls click on add and continue in queue selection
     * date :: 01-Jan-2018
     * author :: Nidhi
*/
    public void selectAllDispatchCallsAddAndContinueInQueueSelection() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.dispatch, "click on dispatch");
        click(DIHomePage.dispatch, "click on dispatch");

        waitForVisibilityOfElement(DIHomePage.selectAll, "click on selectAll");
        click(DIHomePage.selectAll, "click on selectAll");

        waitForVisibilityOfElement(DIHomePage.add, "click on add");
        click(DIHomePage.add, "click on add");

        waitForVisibilityOfElement(DIHomePage.btnContinue, "click on continue");
        click(DIHomePage.btnContinue, "click on continue");
        Thread.sleep(4000);

    }
    
    
    /* *
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyRedFlagCallID
     * description :: 
     * date :: 03-Jan-2018
     * author :: Nidhi
*/

    public void verifyRedFlagCallID(String callIDWithRedFlag) throws Throwable {
        Thread.sleep(2000);
        click(DIHomePage.idInRedFlagTabInProfileWindow, "RedFlagCallHiddenTab");
        List<WebElement> allID = getWebElementList(DIHomePage.idInRedFlagTabInProfileWindow, "CallID List");
        for (int i = 0; i < allID.size(); i++) {

            String CallIDItems = allID.get(i).getText();
            Thread.sleep(2000);

            if (CallIDItems.equalsIgnoreCase(callIDWithRedFlag)) {
                assertTrue(true, "Call is Located" + CallIDItems);
            }
        }

    }


/* *
 * param :: String inputs
 * return ::void
 * throws :: throwable
 * methodName :: verifyNonRedFlagCallID
 * description :: 
 * date :: 03-Jan-2018
 * author :: Nidhi
*/

    public void verifyNonRedFlagCallID(String callID) throws Throwable {
        List<WebElement> allID = getWebElementList(DIHomePage.idInRedFlagTabInProfileWindow, "CallID List");
        for (int i = 0; i < allID.size(); i++) {
            String CallIDItems = allID.get(i).getText();
            /*if (CallIDItems.equalsIgnoreCase(callID)) {
                assertTrue(true, "Call is Located" + callID);
            } else {
                assertTrue(true, "Call is not Located" + callID);
            }*/
            assertFalse(CallIDItems.equalsIgnoreCase(callID), "Call is Located" + callID);
        }
        Thread.sleep(2000);
    }

/* *
 * param :: String inputs
 * return ::void
 * throws :: throwable
 * methodName :: verifyNonRedFlagCallID
 * description :: 
 * date :: 03-Jan-2018
 * author :: Nidhi
*/

    public void selectRedFlagCallTabOnHiddenTab() throws Throwable {
        boolean RedFlagCallHiddenTab = isVisibleOnly(DIHomePage.lnkRedFlagUnderHiddenTab, "RedFlagCallTab");
        if (RedFlagCallHiddenTab) {
            click(DIHomePage.lnkRedFlagUnderHiddenTab, "RedFlagCallHiddenTab");
        } else {
            clickOnTabPlusButton();
            selectRedFlagCallTabOnPlusIcon();
        }

    }

    /* *
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyNonRedFlagCallID
     * description ::
     * date :: 03-Jan-2018
     * author :: Nidhi
    */
    public void selectRedFlagCallTabOnPlusIcon() throws Throwable {
        boolean RedFlagCallPlusIcon = isVisibleOnly(DIHomePage.lnkRedFlagUnderAddMenuIcon, "RedFlagCallTab");
        if (RedFlagCallPlusIcon) {
            click(DIHomePage.lnkRedFlagUnderAddMenuIcon, "RedFlagCallHiddenTab");
        }
    }

    /**
     * Description:This method is used to click on tab next to all calls tab
     * Date:03-01-2017
     *
     * @throws Throwable
     * @author : Madhukar
     */
    public void clickOnTabNextToAllCallsInProfileWindow() throws Throwable {
        boolean nextTab = isVisibleOnly(DIHomePage.tabNextToAllCallsTab, "Action Required Tab");
        if (nextTab) {
            click(DIHomePage.tabNextToAllCallsTab, "Action Required Tab");
        } else {
            assertTrue(nextTab, "Action Required Tab is visible");
        }
    }

    /**
     * Description:This method is used to verify pointer in call is pointing up in tab next to all call Tab
     * Date:03-01-2017
     *
     * @throws Throwable
     * @author : Madhukar
     */
    public void verifyTinyPointerPointingUp() throws Throwable {
        boolean pointingUp = isVisibleOnly(DIHomePage.iconSortAscensing, "Icon pointing up");
        /*if (pointingUp) {
            assertTrue(pointingUp, "Verified Icon Pointing Up");
        } else {
            assertFalse(pointingUp, "Verified Icon Pointing Up");
        }*/
        assertTrue(pointingUp, "Verified Icon Pointing Up");
    }

    /**
     * Description:This method is used to select BeyondETA Tab from hidden Tabs
     * Date:03-01-2017
     *
     * @throws Throwable
     * @author : Madhukar
     */
    public void selectBeyonETATabOnHiddenTab() throws Throwable {
        boolean ETAHiddenTab = isVisibleOnly(DIHomePage.lnkBeyondETAUnderHiddenTab, "ETA Tab");
        if (ETAHiddenTab) {
            click(DIHomePage.lnkBeyondETAUnderHiddenTab, "ETA Tab in Hidden");
        } else {
            clickOnTabPlusButton();
            selectBeyonETATabOnPlusIcon();
        }

    }

    /**
     * Description:This method is used to select BeyondETA Tab from plus button icon
     * Date:03-01-2017
     *
     * @throws Throwable
     * @author : Madhukar
     */
    public void selectBeyonETATabOnPlusIcon() throws Throwable {
        boolean ETAPlusIcon = isVisibleOnly(DIHomePage.lnkBeyodETAUnderAddMenuIcon, "ETA Tab");
        if (ETAPlusIcon) {
            click(DIHomePage.lnkBeyodETAUnderAddMenuIcon, "ETA Tab in Plus Icon");
        } else {
            assertTrue(false, "ETA Tab Found");
        }

    }

    /**
     * Description:This method is used to click on param profile under profile dropdown
     * Date: 04-01-2017
     *
     * @throws Throwable
     * @author : Madhukar
     */
    public void clickOnParamUnderProfileMenu() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkParamProfileOnProfilesMenu, "Param under Profile Menu");
        boolean param = isVisibleOnly(DIHomePage.lnkParamProfileOnProfilesMenu, "Param under Profile Menu");
        if (param) {
            click(DIHomePage.lnkParamProfileOnProfilesMenu, "Param under Profile Menu");
        } else {
            assertTrue(param, "param is found");
        }
    }

    /**
     * description:This method is used to click on profile window
     * Date: 04-01-2017
     *
     * @throws Throwable
     */
    public void clickOnParamWindow() throws Throwable {
        boolean paramWindow = isVisibleOnly(DIHomePage.paramWindow, "param window");
        if (paramWindow) {
            click(DIHomePage.paramWindow, "param window");
        } else {
            assertTrue(paramWindow, "param window is found");
        }
    }

    /**
     * description:This method is used to Close Profile Window
     * Date: 04-01-2017
     *
     * @throws Throwable
     */
    public void clickToCloseProfileWindow() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkcloseProfileWindow, "close profile");
        boolean close = isVisibleOnly(DIHomePage.lnkcloseProfileWindow, "close profile");
        if (close) {
            click(DIHomePage.lnkcloseProfileWindow, "close profile");
        } else {
            assertTrue(close, "close button is found");
        }
    }

    public void selectQueuesandClickOnSearchCall() throws Throwable {
        clickOnContinueQueuesInDispatch();
        clickOnSearchCallsInDispatch();
    }

    /**
     * Description:This method is used to close facility PTA pop up
     * Date:12-01-2018
     *
     * @throws Throwable
     */
    public void clickOnCloseIconOnFacilityPTA() throws Throwable {

        waitForVisibilityOfElement(DIHomePage.iconCloseOnFacilityPTA, "Cancel Button is Available");

        boolean closeIconOnQueueSelection = isVisibleOnly(DIHomePage.iconCloseOnFacilityPTA, "Close icon is Available");
        if (closeIconOnQueueSelection) {

            click(DIHomePage.iconCloseOnFacilityPTA, "Close Icon Queue Selection");
        } else {
            assertTrue(closeIconOnQueueSelection, "Close Icon is appeared");
        }
    }

    /**
     * Description:This method is used to select an first  callId from search call table
     * Date:12-01-2018
     *
     * @throws Throwable
     */
    public void clickOnFirstCallIdInSearchCallsTable() throws Throwable {
        boolean callId = isVisibleOnly(DIHomePage.lnkFirstCallIdInDI, "First Call Id Link");
        if (callId) {
            click(DIHomePage.lnkFirstCallIdInDI, "First Call Id Link");
        } else {
            assertTrue(callId, "call id link found");
        }
    }

    /**
     * Description:This method is used to verify Hyper link on Message popup
     * Date:17-01-2018
     * @return
     * @throws Throwable
     */
    public boolean verifyHyperLinkOnMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkCallIdInMessagePopup, "HyperLink On Message popup");
        boolean messagePopup = isVisibleOnly(DIHomePage.lnkCallIdInMessagePopup, "HyperLink On Message popup");
        return messagePopup;
    }

    /**
     * Description:This method is used to click on hyper link on call id in message popup
     * Date:17-01-2018
     * @throws Throwable
     */
    public void clickOnHyperLinkOfMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkCallIdInMessagePopup, "HyperLink On Message popup");
        click(DIHomePage.lnkCallIdInMessagePopup, "HyperLink On Message popup");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSpotFacilityIDInfo
     * description ::
     * date :: 16-Jan-2018
     * author :: Abhiram
     */
    public void enterSpotFacilityIDInfoOnTruckLoad(String spotFacilityID) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.txtFacilityIDOnTruckLoad, "Click on Spot Facility ID Field");
        click(DIHomePage.txtFacilityIDOnTruckLoad, "Click on Spot Facility ID Field");
        waitForVisibilityOfElement(DIHomePage.txtFacilityIDOnTruckLoad, "Type Spot Facility ID");
        System.out.println(spotFacilityID);
        type(DIHomePage.txtFacilityIDOnTruckLoad, spotFacilityID, "Type SpotfacilityID");
        Thread.sleep(2000);
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSpotFacilityOntruckLoadTextBox
     * description ::
     * date :: 16-Jan-2018
     * author :: Abhiram
     */

    public void clickOnSpotFacilityOntruckLoadTextBox() throws Throwable {
        click(DIHomePage.lnkFacilityIDOnTruckLoad, "Spot Facility ID");
    }

    /**
     * param :: String
     * return ::void
     * throws :: throwable
     * methodName :: searchAndSelectCallIDOnTruckLoad
     * description ::
     * date :: 16-Jan-2018
     * author :: Abhiram
     */
//Double click on Call Id
    public void searchAndSelectCallIDOnTruckLoad(String CallID) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.callIdInTruckLoadMenu, "CallId in TruckLoad");
        allCallIds = getWebElementList(DIHomePage.lblCallIDResultsInTruckLoadWindow, "CallId in TruckLoad");
        if (allCallIds != null) {
            for (int i = 0; i <= allCallIds.size(); i++) {
                String callIdFromList = allCallIds.get(i).getText();
                if (CallID.equals(callIdFromList)) {
                    Actions action = new Actions(driver);
                    action.doubleClick(allCallIds.get(i)).build().perform();
                }
                allCallIds = getWebElementList(DIHomePage.lblCallIDResultsInTruckLoadWindow, "CallId in TruckLoad");
            }
        }
    }

    /**
     * Description:This method is used to verify ET status on Message popup
     * Date:17-01-2018
     * @author :Madhukar
     * @return
     * @throws Throwable
     */
    public void verifyETStatusOnMessagePopup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lblETStatusOnMessagePopup, "ET Status");
        getText(DIHomePage.lblETStatusOnMessagePopup, "ET Status");

    }

    /**
     * Description:This method is used to click on call ID In Message Popup
     * @param callId
     * @throws Throwable
     */
    public void clickOnCallIDOfMessagePopUp(String callId)throws Throwable{
        waitForVisibilityOfElement(DIHomePage.linkCallIDOnMessagePopUp(callId),""+callId);
        click(DIHomePage.linkCallIDOnMessagePopUp(callId),""+callId);
    }
    /**
     * Description:This method is used to click on call ID In Message Popup
     * @throws Throwable
     */
    public void clickOnMessagePopUpButton()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.lnkMessagePopup,"message popup window");
        click(DIHomePage.lnkMessagePopup,"message popup window");
    }

    /**
     * Description:This method is used to clear all messages In Message Popup
     * @throws Throwable
     */
     public void clearAllMessagesInMessagepopup()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.chkBoxMessagesInMessagepopup,"Message Popup Checkbox");
        click(DIHomePage.chkBoxMessagesInMessagepopup,"Message Popup Checkbox");
        click(DIHomePage.btnAcknowledgeOnMesssagepopup,"Acknowledge button");
     }


    /**
     * Description:This is used to sort the data in decending order
     * Date:19-01-2018
     * @return
     * @throws Throwable
     */
    public void dateDecendingOrder()throws Throwable{
        clickUntil(DIHomePage.lblDateHeaderInTruckLoad,DIHomePage.iconDesendingOrderForDate,"Date Decending Order");
    }

    /**
     * Description:This is used to sort the data in decending order
     * Date:19-01-2018
     * @return
     * @throws Throwable
     */
    public void searchAndClickOnCallIdOnProfileWindow(String callIDAndDate)throws Throwable{
        waitForVisibilityOfElement(DIHomePage.callIDInProfileTab(callIDAndDate),"Click On CallId On Profile Tab");
        mouseJSDoubleClick(DIHomePage.callIDInProfileTab(callIDAndDate),"Click On CallId On Profile Tab");
    }

    /**
     * Description:This is used to sort the data in decending order
     * Date:19-01-2018
     * @return
     * @throws Throwable
     */
    public void searchAndClickOnCallIdOnTruckloadWindow(String callIDAndDate)throws Throwable{
        waitForVisibilityOfElement(DIHomePage.callIDInTruckLoadTab(callIDAndDate),"Click On CallId On TruckLoad Tab");
        mouseJSDoubleClick(DIHomePage.callIDInTruckLoadTab(callIDAndDate),"Click On CallId On TruckLoad Tab");
    }


    /**
     * Description:This method is used to click on call ID In Message Popup
     * @throws Throwable
     */
    public void clickOnCloseiconOnSpotfacilityOnTruckLoad()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.lnkCloseSpotFacilityOnTruckLoad,"Close on Spot facility");
        click(DIHomePage.lnkCloseSpotFacilityOnTruckLoad,"Close on Spot facility");
    }

    /**
     * Description:This method is used to click on call ID In Message Popup
     * @throws Throwable
     */
    public void clickOnTruckLoadCloseWindow()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.lnkCloseIconOnTruckLoad,"Close on Close TruckLoad Window");
        click(DIHomePage.lnkCloseIconOnTruckLoad,"Close on Close TruckLoad Window");
    }

    public void clickOnOpenNewProfile() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.txtOpenNewProfile, "Open New Profile");
        click(DIHomePage.txtOpenNewProfile, "Open New Profile");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTypeAsLiveOnlyInDispatch
     * description ::
     * date :: 29-jan-2017
     * author ::Ravi
     */
    public void enterCallTypeAsLiveOnlyInDispatch(String LiveOnly) throws Throwable
    {
        waitForVisibilityOfElement(DIHomePage.selectCallsType, "select Calls as live calls");
        type(DIHomePage.selectCallsType,LiveOnly, "Search Calls live calls");
        Thread.sleep(2000);
        getText(DIHomePage.selectCallsType, "Search Calls live calls");
        Thread.sleep(1000);
    }

    public void clickonCloseInTruckLoad() throws Throwable {
    	clickOnCloseiconOnSpotfacilityOnTruckLoad();
        clickOnTruckLoadCloseWindow();
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTypeAsLiveOnlyInDispatch
     * description ::
     * date :: 29-jan-2017
     * author ::Ravi
     */
    public void openDiApplication() throws Throwable
    {
        if (isVisibleOnly(DIHomePage.lblOkeyAfterLogout, "lblOkeyAfterLogout")) {
            click(DIHomePage.lblOkeyAfterLogout, "lblOkeyAfterLogout");
            openURLInNewTab("https://qaautoap1.national.aaa.com:8443/D3Dispatch/login.jsp");
        } else {
            openURLInNewTab("https://qaautoap1.national.aaa.com:8443/D3Dispatch/login.jsp");
        }


    }
    public void clickOnProfileName(String profile) throws Throwable {
        waitForVisibilityOfElement(DIHomePage.profileNameInProfileList(profile), "select Calls as live calls");
        click(DIHomePage.profileNameInProfileList(profile), "Profile");
    }

    public void verifyActionReqTabOnProfile() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.labelActionReqTab, "Action Required Tab");

    }
    public void clickActionReqTabOnProfile() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.labelActionReqTab, "Action Required Tab");
        click(DIHomePage.labelActionReqTab, "Action Required Tab");
    }

    public Boolean verifyCallIdOnProfileWindow(String callID, String calldate)throws Throwable{
        Boolean callDisplayOnReqActionTab=waitForVisibilityOfElement(DIHomePage.callIDInActionrequiredProfileTab(callID, calldate),"CallId On Profile Tab");
        return callDisplayOnReqActionTab;
    }

    public void clickCallIdOnProfileWindow(String callID, String calldate)throws Throwable{

        waitForVisibilityOfElement(DIHomePage.callIDInActionrequiredProfileTab(callID, calldate),"CallId On Profile Tab");
        mouseJSDoubleClick(DIHomePage.callIDInActionrequiredProfileTab(callID, calldate), "CallId On Profile Tab");
    }

    public String getCallIdStatusOnProfileWindowOfActionReqTab(String callID, String calldate)throws Throwable{
        waitForVisibilityOfElement(DIHomePage.getcallIDStatusInActionrequiredProfileTab(callID, calldate),"CallId On Profile Tab");
        String status=getText(DIHomePage.getcallIDStatusInActionrequiredProfileTab(callID, calldate),"CallId On Profile Tab");
        return status;
    }


    public Boolean verifyCallIdIsNotOnProfileWindow(String callID, String calldate)throws Throwable{
        Boolean callDisplayOnReqActionTab=waitForInVisibilityOfElement(DIHomePage.callIDInActionrequiredProfileTab(callID, calldate), "CallId On Profile Tab");
        return callDisplayOnReqActionTab;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextDispatchTitle
     * description ::
     * date :: 5-feb-2017
     * author ::Ravi
     */
    public void getTextDispatchTitle() throws Throwable
    {
        waitForVisibilityOfElement(DIHomePage.lblDispathTitle, "dispatch title");
        getText(DIHomePage.lblDispathTitle, "Dispatch title");
        {
            reporter.SuccessReport("Successfully Navigated to ","Dispatch page");
        }
        Thread.sleep(1000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStartDateOnSearchCallsWindow
     * description ::
     * date :: 06-feb-2018
     * author ::Ravi
     */
    public void enterStartDateOnSearchCallsWindow(String StartDate) throws Throwable
    {

        waitForVisibilityOfElement(DIHomePage.txtStartDateOnSearchCallWindow, "Search Calls Window Start date");
        type(DIHomePage.txtStartDateOnSearchCallWindow,StartDate, "Search Calls Window Start date");
        Thread.sleep(3000);
    }



    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterEndDateOnSearchCallsWindow
     * description ::
     * date :: 06-feb-2018
     * author ::Ravi
     */
    public void enterEndDateOnSearchCallsWindow(String EndDate) throws Throwable
    {

        waitForVisibilityOfElement(DIHomePage.txtEndDateInSearchCallWindow, "Search Calls Window End date");
        type(DIHomePage. txtEndDateInSearchCallWindow,EndDate, "Search Calls Window End date");
        Thread.sleep(3000);
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnResetDefaultSettingOnProfileTab
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnResetDefaultSettingOnProfileTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkResetSetting, "Reset Settings");
        click(DIHomePage.lnkResetSetting, "Reset Settings");
    }

    public void verifyMessagePopUpOnDispatchHomepage()throws Throwable{
        if(isVisibleOnly(DIHomePage.lnkMessagesTabOnMessagePopUp,"Message PopUp"))
        {
        }else {
            click(DIHomePage.lnkMessagePopup,"Message popup link");
        }
    }

    public void popOutAndPopInMessagePopUpWindow()throws Throwable{
        isVisibleOnly(DIHomePage.lnkPopoutForMessagePopUp,"Message Popin and Popout");
        click(DIHomePage.lnkPopoutForMessagePopUp,"Message Popin and Popout");

    }

    public void clickOnNewMessageTab()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.lnkNewMessageTabOnMessagePopUp, "New Message Tab");
        click(DIHomePage.lnkNewMessageTabOnMessagePopUp,"New Message Tab");
    }

    public void clickOnAddressBookTab()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.addressBookTabOnMessagePopUp, "Address Book Tab");
        click(DIHomePage.addressBookTabOnMessagePopUp,"Address Book Tab");
    }

    public boolean verifyListOfUsersOnAddressBook()throws Throwable{
        boolean listOfUsers=isVisibleOnly(DIHomePage.listOfUsersOnAddressBookOnMessagepopup,"List of Users On Address Book");
        return listOfUsers;
    }

    public boolean verifyUserButtonIsHighligted()throws Throwable{
        boolean userbutton=isElementPresent(DIHomePage.rdbtnUserButtonHighlighted,"User Button is Highlighted");
        return userbutton;
    }

    public void selectCallTakerUserFromMessagePopup()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.callTakerUserOnMessagePopUp, " Call Taker user");
        click(DIHomePage.callTakerUserOnMessagePopUp, "Call Taker user");
    }

    public void clickOnAddRecipientButtonOnMessagePopup()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.btnAddRecipientOnMessagePopUp, "Add Recipient button");
        click(DIHomePage.btnAddRecipientOnMessagePopUp, "Add Recipient button");
    }

    public void clickOnSendButtonOnMessagePopup()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.btnSendMessage, "Send button");
        click(DIHomePage.btnSendMessage, "Send button");
    }

    public boolean verifyMessageTextFieldturnsRed()throws Throwable{
        boolean txtError=isVisibleOnly(DIHomePage.lblMessageTextBoxError,"Text Turns Red");
        getText(DIHomePage.lblMessageTextBoxError,"Text Turns Red");
        return txtError;
    }

    public void enterMessageInMessageTextBox(String message)throws Throwable{
        waitForVisibilityOfElement(DIHomePage.txtMessageTextBox, "Message Text Box");
        click(DIHomePage.txtMessageTextBox, "Message Text Box");
        type(DIHomePage.txtMessageTextBox,message ,"Message Text Box");
    }

    public String getCharacterslimitCount()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.lblCharactersRemaining,"Characters limit");
        String count=getText(DIHomePage.lblCharactersRemaining,"Characters limit");
        return count;

    }

    public void verifyMessageTextBoxCharacterslimit()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.lblCharactersRemaining,"Characters limit");
        getText(DIHomePage.lblCharactersRemaining,"Characters limit");

    }

    public boolean verifyNewMessageWindowClosedAndMessageWindowInFocus()throws Throwable{
        boolean messageTab=isVisibleOnly(DIHomePage.lnkMessagesTabOnMessagePopUp,"Message Window");
        return messageTab;
    }

    public void selectDispatchUserFromMessagePopup()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.dispatchUserOnMessagePopUp, "Dispatch User");
        click(DIHomePage.dispatchUserOnMessagePopUp, "Dispatch User");
    }

    public String verifyMessageSentAndViewedByRecipient()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.lblMessageOnMessagePopUp,"Message Received");
        String message=getText(DIHomePage.lblMessageOnMessagePopUp,"Message Received");
        return message;
    }

    public void clickOnGropsRadioButtonOnMessagePopup()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.rdbtnGroupOnMessagePopUp, "Groups Radio button");
        click(DIHomePage.rdbtnGroupOnMessagePopUp, "Groups Radio button");
    }

    public void selectGroupFromMessagePopup()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.recipientGroupOnMessagePopUp,"Recipient from Group");
        click(DIHomePage.recipientGroupOnMessagePopUp,"Recipient from Group");
    }

    public void verifyGroupAddedToRecipient()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.lblRecipientOnNewmessageTab,"Recipient from Group");
        getText(DIHomePage.lblRecipientOnNewmessageTab,"Recipient from Group");
    }

    public void clickOnCheckForReplyingMessage()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.chkboxFirstMessageInMessagePopUp,"Message Check box");
        click(DIHomePage.chkboxFirstMessageInMessagePopUp,"Message Check box");
    }

    public void clickOnreplybuttonOnMessagePopup()throws Throwable{
        waitForVisibilityOfElement(DIHomePage.btnReplyOnMessagePopUp,"Reply Button");
        click(DIHomePage.btnReplyOnMessagePopUp,"Reply Button");
    }


    public boolean verifyNoMessagesOnMessagePopup()throws Throwable{
        boolean messages=isElementNotPresent(DIHomePage.lblMessageOnMessagePopUp,"Messages on Message Popup");
        return messages;
    }



    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRemoveAllOnPrifileTab
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnRemoveAllOnProfileTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkRemoveAllProfileWindow, "Remove All");
        click(DIHomePage.lnkRemoveAllProfileWindow, "Remove All");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnZoneOnProfileTab
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnZoneOnProfileTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkZoneProfileWindow, "Zone On Profile Tab");
        click(DIHomePage.lnkZoneProfileWindow, "Zone On Profile Tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterFilterInProfileWindow
     * description ::
     * date :: 06-feb-2018
     * author ::
     */
    public void enterFilterInProfileWindow(String filter) throws Throwable
    {

        waitForVisibilityOfElement(DIHomePage.txtFilterInProfileWindow, "Filter");
        type(DIHomePage. txtFilterInProfileWindow,filter, "Filter");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnZoneOnProfileTab
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnIDOnProfileTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkIDInUnselectedProfileWindow, "ID On Profile Tab");
        click(DIHomePage.lnkIDInUnselectedProfileWindow, "ID On Profile Tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnZoneOnProfileTab
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnDateOnProfileTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkDateInUnselectedProfileWindow, "Date On Profile Tab");
        click(DIHomePage.lnkDateInUnselectedProfileWindow, "Date On Profile Tab");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddOnProfileTab
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnAddOnProfileTab() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.btnAddInProfileWindow, "Add On Profile Tab");
        click(DIHomePage.btnAddInProfileWindow, "Add On Profile Tab");
    }

    public void clickOnExpandOptionFromGroup() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.iconPlusOnGroupsOnMessagepopup, "Plus Icon");
        click(DIHomePage.iconPlusOnGroupsOnMessagepopup, "Plus Icon");
        Thread.sleep(2000);
        click(DIHomePage.dispatchUserOnMessagePopUp, "Dispatch User");
    }

    public void removeRecipientFormMessagePopUp() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.lnkRemoveRecipient, "Remove Recipient");
        click(DIHomePage.lnkRemoveRecipient, "Remove Recipient");
    }
    public void CloseLogoutAlert()  throws Throwable{
        boolean exist = isVisibleOnly(LoginPage.txtLoginName,"Login User Name");
        int counter = 0;
        while (!exist){
            acceptAlert();
            Thread.sleep(5000);
            exist = isVisibleOnly(LoginPage.txtLoginName,"Login User Name");
            if (exist){
                break;
            }
            if(counter > 10){
                break;
            }
            counter = counter + 1;
        }
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSelectedQueue
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnSelectedQueue()throws  Throwable{
            waitForVisibilityOfElement(DIHomePage.deleteSelectedQueues,"Select Queue from Selected Queues");
            click(DIHomePage.deleteSelectedQueues,"Select Queue from Selected Queues");

    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyFavoriteCallFromProfileMenu
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public boolean verifyFavoriteCallFromProfileMenu(String callIdAndDate)throws  Throwable {
        boolean favoriteFlag;
        boolean favoritesFlag = isVisibleOnly(DIHomePage.nofavoriteCalls, "No Favorites Calls");
        if (favoritesFlag) {
            assertTrue(favoritesFlag, "No Favorites Calls");
            favoriteFlag = false;
        } else {
            boolean favoriteCallFlag = isVisibleOnly(DIHomePage.favoriteCallsList(callIdAndDate), "Favorite Calls List");
            favoriteFlag = true;
        }
        return favoriteFlag;
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectQueueFromFavorites
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectQueueFromFavorites()throws  Throwable{
        waitForVisibilityOfElement(DIHomePage.btnQueueInFavorites,"Select Queue from favorites");
        click(DIHomePage.btnQueueInFavorites,"Select Queue from favorites");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getQueueSelectionLable
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
        public boolean getQueueSelectionLable()throws  Throwable{
        boolean queue = isVisibleOnly(DIHomePage.btnRemoveOnQueueWindow,"Queue selection popup avaialble");
        return queue;
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFavoritesInQueSelection
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnFavoritesInQueSelection()throws  Throwable{
        waitForVisibilityOfElement(DIHomePage.linkClickOnFavorites,"Click On Favorites in QueSelection");
        click(DIHomePage.linkClickOnFavorites,"Click On Favorites in QueSelection");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSpotFacilityIDInfo
     * description ::
     * date :: 15-feb-2018
     * author :: Nidhi
     */
    public void verifyAndEnterSpotFacilityIDInfoOnTruckLoad(String spotFacilityID) throws Throwable {
        if(waitForVisibilityOfElement(DIHomePage.closeIconOnFacilitySelectedOnTruckload, "close icon")) {
            click(DIHomePage.closeIconOnFacilitySelectedOnTruckload, "close icon");
        }
        waitForVisibilityOfElement(DIHomePage.txtFacilityIDOnTruckLoad, "Click on Spot Facility ID Field");
        click(DIHomePage.txtFacilityIDOnTruckLoad, "Click on Spot Facility ID Field");
        waitForVisibilityOfElement(DIHomePage.txtFacilityIDOnTruckLoad, "Type Spot Facility ID");
        System.out.println(spotFacilityID);
        type(DIHomePage.txtFacilityIDOnTruckLoad, spotFacilityID, "Type SpotfacilityID");
        Thread.sleep(2000);
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
    }

    /* *
    * param :: String inputs
    * return ::void
    * throws :: throwable
    * methodName :: selectRedFlagCallOnTabOnPlusIcon
    * description ::
    * date :: 03-Jan-2018
    * author :: Nidhi
   */
    public void selectRedFlagCallOnTabOnPlusIcon() throws Throwable {
        click(DIHomePage.linkTabPlusButton, "Click on Plus Button");
        boolean RedFlagCallPlusIcon = isVisibleOnly(DIHomePage.lnkRedFlagUnderAddMenuIcon, "RedFlagCallTab");
        if (RedFlagCallPlusIcon) {
            click(DIHomePage.lnkRedFlagUnderAddMenuIcon, "RedFlagCallPlusTab");
        }
    }

    /* *
   * param :: String inputs
   * return ::void
   * throws :: throwable
   * methodName :: verifyNonRedFlagCallID
   * description ::
   * date :: 03-Jan-2018
   * author :: Nidhi
  */
    public void selectRedFlagCallOnHiddenTab() throws Throwable {
        click(DIHomePage.drpdwnHiddenTabs, "Click on Hidden Button");
        boolean RedFlagCallHiddenIcon = isVisibleOnly(DIHomePage.lnkRedFlagUnderHiddenTab, "RedFlagCallTab");
        if (RedFlagCallHiddenIcon) {
            click(DIHomePage.lnkRedFlagUnderHiddenTab, "RedFlagCallHiddenTab");
        }
    }

    /* *
   * param :: String inputs
   * return ::void
   * throws :: throwable
   * methodName :: selectRedFlagCallOnProfileTab
   * description ::
   * date :: 03-Jan-2018
   * author :: Nidhi
  */
    public void selectRedFlagCallOnProfileTab() throws Throwable {
        boolean RedFlagCallProfileTab = isVisibleOnly(DIHomePage.lnkRedFlagUnderProfileTab, "RedFlagCallTab");
        if (RedFlagCallProfileTab) {
            click(DIHomePage.lnkRedFlagUnderProfileTab, "RedFlagCallProfileTab");
        }
    }

   /* *
   * param :: String inputs
   * return ::void
   * throws :: throwable
   * methodName :: selectRedFlagCall
   * description ::
   * date :: 03-Jan-2018
   * author :: Nidhi
  */
   public void selectRedflagCall() throws Throwable
   {
       selectRedFlagCallOnTabOnPlusIcon();
       selectRedFlagCallOnHiddenTab();
       selectRedFlagCallOnProfileTab();
   }

    public void clickOnTruckLoadDefaultOptioninSPP() throws Throwable {
        waitForVisibilityOfElement(DIHomePage.truckLoadDefaultViewinSPP, "Default View On TruckLoad");
        click(DIHomePage.truckLoadDefaultViewinSPP, "Default View On TruckLoad");
    }

}







