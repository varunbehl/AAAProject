package com.aaa.web.lib;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.CRMemberSearchPage;
import com.aaa.web.page.LoginPage;

import java.util.Hashtable;

/*
import java.util.Hashtable;
import static com.sun.javafx.text.ScriptMapper.data;
*/


public class CRHomeLib extends ActionEngine {

  /*  LoginLib login = new LoginLib();*/

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: logOut
     * description :: logOut
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void logout() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.lnkLogout, "logOut link");

        Thread.sleep(3000);
        boolean checkForLogout = isVisibleOnly(CRHomePage.lnkLogout, "logOut link");
        if (checkForLogout) {
            waitCloseAllBusyIconsResults();
            //assertTrue(checkForLogout, "logOut link appeared");
            click(CRHomePage.lnkLogout, "logOut link");
            Thread.sleep(2000);
            waitForVisibilityOfElement(CRHomePage.btnLogout, "logOut");
            click(CRHomePage.btnLogout, "Logout button");
            acceptAlert();
            CloseLogoutAlert();
        } else {
            assertFalse(checkForLogout, "Logout link not appeared");
        }
        Thread.sleep(5000);
    }
    /*  LoginLib login = new LoginLib();*/

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyLogout
     * description :: verifyandclickLogout
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void verifyandClickLogout() throws Throwable {
        //waitForVisibilityOfElement(CRHomePage.lnklogout,"logOut link");

        Thread.sleep(3000);
        boolean checkForLogout = isVisibleOnly(CRHomePage.lnkLogout, "logOut link");
        if (checkForLogout) {
            waitCloseAllBusyIconsResults();
            //assertTrue(checkForLogout, "logOut link appeared");
            click(CRHomePage.lnkLogout, "logOut link");
            Thread.sleep(2000);
            waitForVisibilityOfElement(CRHomePage.btnLogout, "logOut");
            click(CRHomePage.btnLogout, "Logout button");
            acceptAlert();
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: VerifyHomeScreen
     * description :: Verifying Home screen by checking logOut link
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void verifyHomeScreen() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.lnkLogout, "logOut");
        Thread.sleep(3000);
        boolean closeMessagesPresent = isVisibleOnly(CRHomePage.closeMessages, "close Messages");
        if (closeMessagesPresent) {
            click(CRHomePage.closeMessages, "close Messages");
        }
        boolean flag = isVisibleOnly(CRHomePage.lnkLogout, "logOut");
        if (flag) {
            reporter.SuccessReport("Logout", "You are logged into Call receiving Home Page");
        } else
        	reporter.failureReport("Logout", "Your login attempts is failed");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: VerifyHomeScreen
     * description :: Verifying Home screen by checking logOut link
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void memberSearchTextBox(String Membersearch) throws Throwable {
        click(CRHomePage.txtSearchMemberText, "Member Search box");
        type(CRHomePage.txtSearchMemberText, Membersearch, "Search Value");
        Thread.sleep(2000);
        System.out.println("Wrong" + Membersearch);
        click(CRHomePage.btnSearchButton, "Search Button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: saveButton
     * description :: Call Receiving Save button
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void saveButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnMemberSave, "Member Save button");
        click(CRHomePage.btnMemberSave, "Member Save button");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: CancelButton
     * description :: Call Receiving cancel button
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void cancelButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnMemberCancel, "Member Cancel button");
        click(CRHomePage.btnMemberCancel, "Member Cancel button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: LeaveButton
     * description :: Call Receiving Leave button
     * date :: 05-Nov-2017
     * author :: Chandu Dendukuri
     */
    public void leaveButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnMemberLeave, "Member leave button");
        click(CRHomePage.btnMemberLeave, "Member Leave button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: DuplicateButton
     * description :: Call Receiving Duplicate button
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void duplicateButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnMemberDuplicate, "Member Duplicate button");
        click(CRHomePage.btnMemberDuplicate, "Member Duplicate button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: allErrorAlerts
     * description :: To handle all types of errors
     * date :: 05-Nov-2017
     * author :: Laskhmi Prasana
     */
    public void allErrorAlerts() throws Throwable {

        //This condition is to handle confirmation message for save/Cancel/Leave/Logout button alerts
        boolean isErrorOccured = isVisibleOnly(CRHomePage.alertConfirmation, ": Confirmation alert");
        //getText(CRHomePage.alertConfirmation,"Confirmation alert");
        if (isErrorOccured) {
            click(CRHomePage.alertConfirmationYesButton, ": Confirmation alert Yes button");
        } 
        boolean isUndefinedError = isVisibleOnly(CRHomePage.unDefinedError, "Undefined Error");
        if (isUndefinedError) {
            click(CRHomePage.unDefinedError, "Undefined error");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memPageManualEntry
     * description :: Member page manual entry link
     * date :: 05-Nov-2017
     * author :: chandrasekhar Dendukuri
     */
    public void memPageManualEntry() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.memberPageManualEntry, "Member page manual entry link");
        click(CRHomePage.memberPageManualEntry, "Member Page Manual entry link");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnManualEntryLink
     * description :: Click the Manual Entry link on Tabs
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasana
     */
//    public void clickOnManualEntryLink(String tabName) throws  Throwable{
//
//        if(tabName.equalsIgnoreCase("member")) {
//            boolean falg = isElementPresent(CRHomePage.lnkManualEntryonMem, "Manual Entry");
//            if (falg) {
//                waitForVisibilityOfElement(CRHomePage.lnkManualEntryOnMem, "Manual Entry Link");
//                click(CRMemberSearchPage.lnkManualEntryOnMem, "Manual Entry");
//            }
//        }
//        else if(tabName.equalsIgnoreCase("location")){
//            boolean falg = isElementPresent(CRHomePage.lnkManualEntryonLoc, "Manual Entry");
//            if (falg) {
//                waitForVisibilityOfElement(CRHomePage.lnkManualEntryonLoc, "Manual Entry Link");
//
//                click(CRHomePage.lnkManualEntryonLoc, "Manual Entry");
//            }
//
//        }else if(tabName.equalsIgnoreCase("vehicle")){
//
//            boolean falg = isElementPresent(CRHomePage.lnkManualEntryonVehic, "Manual Entry");
//            if (falg) {
//                waitForVisibilityOfElement(CRHomePage.lnkManualEntryonVehic, "Manual Entry Link");
//                click(CRHomePage.lnkManualEntryonVehic, "Manual Entry");
//            }
//        } else if(tabName.equalsIgnoreCase("tow")) {
//
//            boolean falg = isElementPresent(CRHomePage.lnkManualEntryonTow, "Manual Entry");
//            if (falg) {
//                waitForVisibilityOfElement(CRHomePage.lnkManualEntryonTow, "Manual Entry Link");
//                click(CRHomePage.lnkManualEntryonTow, "Manual Entry");
//            }
//        }
//    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: sessionInNewTab
     * description :: Using this method we can open the session in new tab
     * date :: 05-Nov-2017
     * author :: Chandu Dendukuri
     */
    public void sessionInNewTab() throws Throwable {
        String currentUrl = driver.getCurrentUrl();
        String currentSessionID[] = currentUrl.split("=");
        String sessionID = currentSessionID[1];
        openURLInNewWindow(currentUrl);
        waitForVisibilityOfElement(CRHomePage.lnkLogout, "LogoutLink");
        waitForVisibilityOfElement(CRHomePage.lnkLogout, "logOut link");
        boolean flag = isVisibleOnly(CRHomePage.lnkLogout, "logOut link");
        assertTrue(flag, "User logged in successfully");
        String newCurrentUrl = driver.getCurrentUrl();
        String newCurrentSessionID[] = newCurrentUrl.split("=");
        String newSessionID = newCurrentSessionID[1];
        assertTrue(sessionID.equalsIgnoreCase(newSessionID), "Same session continued in the new tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: waitcloseAllBusyIconsResults
     * description :: Application loading wait for memberseatch results
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public void waitCloseAllBusyIconsResults() throws Throwable {
        int iCounter = 0, loading;
        boolean status = true;
        do {
            iCounter++;
            loading = getElementsSize(CRMemberSearchPage.iconResultLoadingSpinner);
            if (loading == 0) {
                status = true;
                break;
            } else {
                status = false;
                //LOG.info("iCounter appearStatus " + iCounter);
            }
            if (iCounter > 100) {
                status = false;
                break;
            }
        }
        while (iCounter <= 100);
        if (status) {
            LOG.info("All spinners are closed");
        } else {
            LOG.info("All spinners are not closed");
        }
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyLoggedInUserRole
     * description :: This is to validate login functionality with difference combinations
     * date :: 08-Dec-2017
     * author :: Chandu Dendukuri
     */
    /*public String verifyLoggedInUserRole() throws Throwable {
        rolevalue = getText(CRHomePage.lblHeaderUserName, "Logged in user Role");
        boolean verifyLoggedInUserRole = isVisibleOnly(CRHomePage.lblheaderUsername, "Logged in user Role");
        if (verifyLoggedInUserRole) {
            assertTrue(verifyLoggedInUserRole, "User logged into the application with selected user id/role");
        } else {
            assertFalse(verifyLoggedInUserRole, "User Not logged in with selected user id/role");
        }
        return rolevalue;
    }*/

    /**
     * Description:This method is used to click on workflow dropdown button and select only for History workflow
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void workFlowSelectionForHistory() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.workFlowDropDown, "WorkFlow dropdown");
        click(CRHomePage.workFlowDropDown, "Workflow dropdown");
        click(CRHomePage.historyWorkFlow, "historyWorkFlow");

    }

    /**
     * Description:This method is used to click on drop down button for workflow selection like Accident,Member,
     * History,Public Agency,RAP
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void clickOnWorkFlowDropdown() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.workFlowDropDown, "WorkFlow dropdown");
        click(CRHomePage.workFlowDropDown, "Workflow dropdown");
    }

    public void messageDialogBoxClose() throws Throwable {
        //waitForVisibilityOfElement(CRHomePage.iconMsgClose,"Message Alert Close");
        boolean messageCloseIcon = isVisibleOnly(CRHomePage.iconMsgClose, "Message Alert Close");
        if (messageCloseIcon) {
            assertTrue(messageCloseIcon, "Message Dialog window appeared ");
            click(CRHomePage.iconMsgClose, "Message Alert Close");
        } else
            assertFalse(messageCloseIcon, "Message Dialog window not appeared");
    }

    public void clickOnSearchCallsLink() throws Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRHomePage.searchCallsLink, "SearchCall Link");
        click(CRHomePage.searchCallsLink, "SearchCall Link");
    }

    public void clickOnCallIdOnSearchCalls() throws Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRHomePage.linkCallIdOnSearchCalls, "Click on CallId Link");
        click(CRHomePage.linkCallIdOnSearchCalls, "Click on CallId Link");
    }


    public void clickOnSearchButtonOnSearchCalls() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.searchButtonForCallSearch, "Click on Search Button On Search Calls");
        click(CRHomePage.searchButtonForCallSearch, "Click on Search Button On Search Calls");
    }


    public void enterCallIdForSearch(String callID) throws Throwable {
        waitForVisibilityOfElement(CRHomePage.txtSearchCallID, "Click on CallID Field");
        click(CRHomePage.txtSearchCallID, "Click on CallID Field");
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRHomePage.txtSearchCallID, "Type CallID");
        type(CRHomePage.txtSearchCallID, callID, "Type CallID");
    }


    public void clickOnSearchCallDroupDown() throws Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRHomePage.drpdwnSearchCalls, "SearchCall DroupDown");
        click(CRHomePage.drpdwnSearchCalls, "SearchCall DroupDown");
    }


    public void verifyPhoneNumbersForUpdation(String oldPhoneNumber, String updatedPhoneNumber) throws Throwable {
        boolean verifyPhoneNumbers = oldPhoneNumber.equals(updatedPhoneNumber);
        if (verifyPhoneNumbers) {
            assertTrue(verifyPhoneNumbers, "Changes are Updated after Leave the Call");
        } else {
            assertTrue(!verifyPhoneNumbers, "Changes are Not Updated after Leave the Call");
        }

    }

    public String getPhoneNumberFromMemberDetailsInSearchCalls() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.memberDetailsOnSearchCalls, "Getting PhoneNumber From Member Details");
        String memdetails = getText(CRHomePage.memberDetailsOnSearchCalls, "Getting PhoneNumber From Member Details");
        // System.out.println("MemberDetails"+memdetails);
        String splitStr[] = memdetails.split("\\n");
        String phoneNumber = splitStr[1].substring(0, 9);
        return phoneNumber;
    }

    public void messageForLeaveCall() throws Throwable {
        boolean leavemessage = isElementPresent(CRHomePage.leaveCallMessage, "Message after leave the call");
        String leavemsg = getText(CRHomePage.leaveCallMessage, "Message after leave the call");
        assertTrue(leavemessage, "Confirmation window displays with the following message Are you sure you wish to leave this call?");
    }

    public void clickOnContinueButtonOnKillCallPopup() throws Throwable {
        boolean killCallContinueButton = isVisibleOnly(CRHomePage.btnKillCallContinue, "Kill call button");
        assertTrue(killCallContinueButton, "Kill Call button Appeared");
        if (killCallContinueButton) {
           // assertTrue(killCallContinueButton, "Appeared");
            click(CRHomePage.btnKillCallContinue, "Kill Call button");
        } /*else {
            assertFalse(killCallContinueButton, "Kill Call button Not appeared");
        }*/
    }

    public void validateDispatchCodeInSearchCallsPoPUpWindow(String dispatchCode) throws Throwable {
        boolean DispatchCode = isVisibleOnly(CRHomePage.lblDispatchCodeInSearchCallWindow, "Dispatch Code");

        if (DispatchCode) {
            String dispatchCodes = getText(CRHomePage.lblDispatchCodeInSearchCallWindow, "Dispatch Code");
                assertTrue(dispatchCode.equalsIgnoreCase(dispatchCodes), "Trouble code on the call maps to the pacesetter code ");
        } else {
            assertFalse(false, "Trouble code/Dispatch code note displayed on Search Calls Pop Up Window ");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseIconOnSearchCallsWindow
     * description :: This function clicks on Close Icon on Search Calls PopUp window
     * date :: 2-Jan-2018
     * author :: Sachin
     */

    public void clickOnCloseIconOnSearchCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.iconClickOnCloseIconOnSearchCalls, "Close Icon");
        click(CRHomePage.iconClickOnCloseIconOnSearchCalls, "Close Icon");
    }

    public boolean getErrorFoundForGeoCode() throws Throwable {
        //boolean errorGeoCode = false;
        boolean errorGeoCode = isVisibleOnly(CRHomePage.unDefinedError, "GeoCode is not there for Provided address");
        if (errorGeoCode) {
            assertFalse(errorGeoCode, "Failed to GeoCode the provided  Address error alert found");
            click(CRHomePage.unDefinedError, "Clicked on GeoCode OK Button");
        } else {
            assertTrue(!errorGeoCode, "Failed to GeoCode the provided  Address error alert NOT found");
        }
        return errorGeoCode;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: allErrorAlertsNoButton
     * description :: This function clicks on No button on Pop Up
     * date :: 8-Jan-2018
     * author :: Sachin
     */

    public void allErrorAlertsNoButton() throws Throwable {

        //This condition is to handle confirmation message for save/Cancel/Leave/Logout button alerts
        boolean isErrorOccured = isVisibleOnly(CRHomePage.alertConfirmation, ": Confirmation alert");
        //getText(CRHomePage.alertConfirmation,"Confirmation alert");
        //assertTrue(isErrorOccured,"Confirmation alert button");
        if (isErrorOccured) {
            reporter.SuccessReport("Error message occured", "Error message occured");
            // assertTrue(isErrorOccured,"Confirmation alert No button");
            click(CRHomePage.alertConfirmationNoButton, ": Confirmation alert No button");
        } /*else {
            assertFalse(isErrorOccured, "Confirmation alert Yes button");
        }*/
        boolean isUndefinedError = isVisibleOnly(CRHomePage.unDefinedError, "Undefined Error");
        //assertTrue(isUndefinedError, "Undefined error found");
        if (isUndefinedError) {
            //assertTrue(isUndefinedError, "Undefined error");
            click(CRHomePage.unDefinedError, "Undefined error");
        } /*else {
            assertFalse(isUndefinedError, "un-defined error not found");
        }*/

    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnInternalIcon
     * description :: This function clicks on Iternal Icon
     * date :: 11-Jan-2018
     * author :: Sachin
     */
    public void clickOnInternalIcon() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.iconInernal, "Inernal Icon");
        click(CRHomePage.iconInernal, "Inernal Icon");
    }


    /**
     * Description:This method is used to verify whether PTA flag is Available
     * Date:16-01-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyPTAFlag() throws Throwable {
        boolean ptaFlag = isVisibleOnly(CRHomePage.iconPTAFalg, "PTA FLAG");
        return ptaFlag;
    }

    /**
     * Description:This method is used to get the PTA Value
     * Date:16-01-2018
     *
     * @return
     * @throws Throwable
     */
    public void verifyPTAValue() throws Throwable {
        String ptaValue = getText(CRHomePage.lblPTAvalue, "PTA Value");

    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: ValidateConfirmationPopUpWindow
     * description :: This function to validate if confirmatin Pop Up window displays
     * date :: 16-Jan-2018
     * author :: Sachin
     */
    public void ValidateConfirmationPopUpWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.confirmationPopUp, "Confirmation Pop Up Window");
        boolean isExists = isVisibleOnly(CRHomePage.confirmationPopUp, "Confirmation Pop Up Window");
        assertTrue(isExists, "Confirmation Pop Up Window displays");
    }

    /**
     * param :: String Input
     * return ::void
     * throws :: throwable
     * methodName :: SetCommentsConfirmationWindow
     * description :: This function to enter comments in Confirmation Window Text area
     * date :: 16-Jan-2018
     * author :: Sachin
     */
    public void SetCommentsConfirmationWindow(String comments) throws Throwable {
        waitForVisibilityOfElement(CRHomePage.txtAreaComments, "Comments text area");
        type(CRHomePage.txtAreaComments, comments, "Comments text area");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: GetCommentsConfirmationWindow
     * description :: This function to get the text from comments text area in Confirmation Window
     * date :: 16-Jan-2018
     * author :: Sachin
     */
    public String GetCommentsConfirmationWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.txtAreaComments, "Comments text area");
        String comments = getAttributeByValue(CRHomePage.txtAreaComments, "Comments text area");
        return comments;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: ClickOnYesButtonOnConfirmationWindow
     * description :: This function to click on Yes Button on Confirmation Window
     * date :: 16-Jan-2018
     * author :: Sachin
     */
    public void ClickOnYesButtonOnConfirmationWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.alertConfirmationYesButton, "Yes Button");
        click(CRHomePage.alertConfirmationYesButton, "Yes Button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnConfirmationAlert
     * description :: clickOnConfirmationAlert
     * date :: 16-Jan-2018
     * author :: Chandra
     */
    public void clickOnConfirmationAlert() throws Throwable {

        boolean isErrorOccured = isVisibleOnly(CRHomePage.alertConfirmation, ": Confirmation alert");
        //if (isErrorOccured) {
        assertTrue(isErrorOccured, "Confirmation alert Yes button");
        click(CRHomePage.alertConfirmationYesButton, ": Confirmation alert Yes button");
        //} else {
        //    assertFalse(isErrorOccured, "Confirmation alert Yes button");
        //}
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: DuplicateButton
     * description :: Call Receiving Duplicate button
     * date :: 16-jan-2017
     * author :: Ravi
     */
    public void getTextD3CallReceivingText() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.d3CallReceivingTxt, "wait for d3 call receiving text");
        getText(CRHomePage.d3CallReceivingTxt, "get text of d3  call receving text");
    }


    /**
     * Description:This method is used to verify ETA update message
     * Date:17-01-2018
     *
     * @throws Throwable
     */
    public void verifyPopupMessageForETAUpdate() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.notificationMessage, "ETA Updated Message Popup");
        getText(CRHomePage.notificationMessage, "ETA Updated Message Popup");
    }

    /**
     * Description:This method is used to verify ETA time
     * Date:17-01-2018
     *
     * @throws Throwable
     */
    public String verifyETATime() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.etaTime, "ETA Time");
        String etaTime = getText(CRHomePage.etaTime, "ETA Time");
        String eta=etaTime.substring(0,5);
        return eta;
    }

    /**
     * Description:This method is used to click on workflow dropdown button and select only for RAP workflow
     *
     * @throws Throwable
     * @author: Chandu
     */
    public void workFlowSelectionForRAP() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.workFlowDropDown, "WorkFlow dropdown");
        click(CRHomePage.workFlowDropDown, "Workflow dropdown");
        click(CRHomePage.menuRapCallSelction, "RAP workflow selection");
        //click(CRHOmePage.)
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: GetCallElapsedTime
     * description :: This function gets the elapsed time of the call
     * date :: 16-Jan-2018
     * author :: Sachin
     */
    public String GetCallElapsedTime() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.lblElapsedTime, "Elapsed Time");
        String elapsedTime = getText(CRHomePage.lblElapsedTime, "Elapsed Time");
        return elapsedTime;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseButtonOnRecentCallsWindow
     * description :: This function clicks on Close Button on Recent Calls PopUp window
     * date :: 17-Jan-2018
     * author :: Sachin
     */

    public void clickOnCloseButtonOnRecentCallsWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnCloseOnRecentCallsWindow, "Close Icon");
        click(CRHomePage.btnCloseOnRecentCallsWindow, "Close Icon");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnContinueButtonOnWarningWindow
     * description :: This function clicks on Continue button on Warning Window
     * * date :: 17-Jan-2018
     * author :: Sachin
     */

    public void clickOnContinueButtonOnWarningWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnKillCallContinue, "Continue Button");
        click(CRHomePage.btnKillCallContinue, "Continue Button");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnExpandAllCommentsInStausHistoryWindow
     * description :: This function clicks Expand All Comments link on Status History Window
     * * date :: 17-Jan-2018
     * author :: Sachin
     */

    public void clickOnExpandAllCommentsInStausHistoryWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.linkExpandAllComments, "Expand All Comments");
        click(CRHomePage.linkExpandAllComments, "Expand All Comments");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: GetCommentsFromStatusHistoryWindow
     * description :: This function gets the comments frm Status History Window
     * * date :: 17-Jan-2018
     * author :: Sachin
     */

    public String GetCommentsFromStatusHistoryWindow() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.txtCommentsStatusHistoryWindow, "Comments");
        String comments = getText(CRHomePage.txtCommentsStatusHistoryWindow, "Comments");
        return comments;
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallSummaryButton
     * description :: This function clicks on Call Summary BUtton
     * * date :: 18-Jan-2018
     * author :: Sachin
     */

    public void clickOnCallSummaryButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.iconCallSummary, "Call Summary");
        click(CRHomePage.iconCallSummary, "Call Summary");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: saveButton
     * description :: This function clicks on Save button
     * date :: 05-Nov-2017
     * author :: 18-Jan-2018
     */
    public void savButton() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.btnSaveArchCall, "Save button");
        click(CRHomePage.btnSaveArchCall, "Save button");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseIconOnStatusHistoryPage
     * description :: This function clicks on Close Icon on Status History Window
     * * date :: 17-Jan-2018
     * author :: Sachin
     */

    public void clickOnCloseIconOnStatusHistoryPage() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.iconCloseOnStatusHostoryWindow, "Close Icon");
        click(CRHomePage.iconCloseOnStatusHostoryWindow, "Close Icon");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAutospotFailMsgOk
     * description ::
     * * date :: 22-Jan-2018
     * author :: Nidhi
     */

    public void clickOnAutospotFailMsgOk() throws Throwable {
        if(isVisibleOnly(CRHomePage.autospotFailMsgOk, "ok button"))
        {
            click(CRHomePage.autospotFailMsgOk, "ok button");
        }
    }
    public void getErrorMessageTextFromAlert() throws Throwable {
        if(isVisibleOnly(CRHomePage.lblErrorMessage, "Error message button"))
        {
            String err = getText(CRHomePage.lblErrorMessage, "error message button");
            click(CRHomePage.unDefinedError, "Closed Error message");
            //reporter.failureReport();
        }
        else
            reporter.SuccessReport("Status", "Saved successful");
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

    public boolean verifyErrorMessageVisibility() throws Throwable{
        boolean errorMessageVisibility = isVisibleOnly(CRHomePage.lblErrorMessageOnUndefinedError,"Error message");
        return errorMessageVisibility;
    }

    public String getErrorMessageFromPopup() throws Throwable{
        String errorMessage = getText(CRHomePage.lblErrorMessageOnUndefinedError,"Error message");
        return errorMessage;
    }

    public void clickOnOkayButtonInErrorAlert() throws Throwable{
        click(CRHomePage.unDefinedError,"Okay button");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCurrentCall
     * description :: click On CurrentCall
     * date :: 13-feb-2017
     * author :: Ravi
     */
    public void clickOnCurrentCall() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.lblCurrentCall, "Current call");
        click(CRHomePage.lblCurrentCall, "Current call");
        Thread.sleep(5000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDispatchStatusUpdate
     * description :: click On Dispatch Status Update
     * date :: 13-feb-2017
     * author :: Ravi
     */
    public void clickOnDispatchStatusUpdate() throws Throwable {
        waitForVisibilityOfElement(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher update status ");
        click(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher Update Satus in CurrentCall");
        Thread.sleep(5000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyDispatchStatusUpdateNotPresent
     * description :: verifyDispatchStatusUpdateNotPresent
     * date :: 13-feb-2017
     * author :: Ravi
     */
    public void verifyDispatchStatusUpdateNotPresent() throws Throwable {
        //waitForVisibilityOfElement(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher update status ");
        Thread.sleep(3000);
        isElementNotPresent(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher Update Satus in CurrentCall");
        {
            reporter.SuccessReport("Dispatcher Update status", "window not displays");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyDispatchStatusUpdatePresent
     * description :: verifyDispatchStatusUpdatePresent
     * date :: 13-feb-2017
     * author :: Ravi
     */
    public void verifyDispatchStatusUpdatePresentAndClick() throws Throwable {
        //waitForVisibilityOfElement(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher update status ");
        Thread.sleep(3000);
        isVisibleOnly(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher Update Satus in CurrentCall");
        click(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher Update Satus in CurrentCall");
        {
            reporter.SuccessReport("Dispatcher Update status", "window displays");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verify Add phone number
     * description :: verify Add phone number
     * date :: 13-feb-2017
     * author :: Ravi
     */
    public void verifyAddPhoneNumber() throws Throwable {
        //waitForVisibilityOfElement(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher update status ");
        Thread.sleep(3000);
        getText(CRHomePage.lblAddPhone,"Add phone number text");

    }

}
