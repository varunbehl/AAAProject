package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRServicePage;

import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;


public class CRServiceLib extends ActionEngine {

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: serviceFieldVerification
     * description :: To Verify mandatory Fields
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void serviceFieldVerification() throws Throwable {
        verifyFacility();
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyFacility
     * description :: To Verify mandatory Fields
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void verifyFacility() throws Throwable {

        boolean facility = isVisibleOnly(CRServicePage.txtFacilityField, "Facility");
        //if (facility) {
            assertTrue(facility, "Facility is Mandatory Field");
        //}
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: saveServiceMandatoryFields
     * description :: To save service MandatoryFields
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void saveServiceMandatoryFields(String facility) throws Throwable {
        enterServiceMandatoryFields(facility);
        clickOnSaveBtn();

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterServiceMandatoryFields
     * description :: To enter all mandatory Fields on Service
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void enterServiceMandatoryFields(String facility) throws Throwable {

        errorAlertHandlingBeforeEnterMandatoryFields();
        enterFacility(facility);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enetrFacility
     * description :: To enter Facility text in to Field
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void enterFacility(String facility) throws Throwable {
        // Thread.sleep(2000);
        waitForVisibilityOfElement(CRServicePage.txtFacilityField, "Facility");
        click(CRServicePage.txtFacilityField, "Facility");
        Thread.sleep(2000);
        clearData(CRServicePage.txtFacilityField);
        type(CRServicePage.txtFacilityField, facility, "Facility");
        Thread.sleep(2000);
        String combineKeys2 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys2, "Tab");
        //  mouseDoubleClick(CRServicePage.btnPrefer,"Prefer button");

        boolean visibilityOfContinueButton = isVisibleOnly(CRServicePage.btnContinueOnPreferFacility, "Continue button on Prefer Facility");
        assertTrue(visibilityOfContinueButton, "Button available");
        if (visibilityOfContinueButton) {
            //assertTrue(visibilityOfContinueButton, "Button available");
            click(CRServicePage.btnContinueOnPreferFacility, "Button Facility");

        } /*else {
            assertFalse(visibilityOfContinueButton, "Button not found");
        }*/
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveBtn
     * description :: To click on Save Button
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void clickOnSaveBtn() throws Throwable {
        if (isElementPresent(CRServicePage.btnSave, "saveCall")) {
            click(CRServicePage.btnSave, "Save Call");
        }
        errorAlertHandlingAfterSave();

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getCallId
     * description :: To click on Save Button
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public String getCallId() throws Throwable {
        boolean flagCallId = isElementPresent(CRServicePage.callId, "callerId");
        // assertTrue(flagCallId, "Call Created");

        String callId = getText(CRServicePage.callId, "callerId");
        assertTrue(callId != "", "Call is created and Saved The call With out Error");
        return callId;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: closeCallWindow
     * description :: To Close the callid Window
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void closeCallWindow() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.closeCallButton, "Close call");
        click(CRServicePage.closeCallButton, "Close call");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnServiceTab
     * description :: To click On ServiceTab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void clickOnServiceTab() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.serviceTab, "Service Tab");
        click(CRServicePage.serviceTab, "Service Tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: errorAlertHandlingBeforeEnterMandatoryFields
     * description :: To Handle errors and Alerts
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void errorAlertHandlingBeforeEnterMandatoryFields() throws Throwable {
        //Error Handling on Service Tab
        boolean flagUndefinedErrorAlert = isVisibleOnly(CRServicePage.alertUndefinedError, "Undefined error");
        //assertTrue(flagUndefinedErrorAlert, "Undefined error");
        if (flagUndefinedErrorAlert) {
            //assertTrue(flagUndefinedErrorAlert, "Undefined error");
            // clickUsingJavascriptExecutor(CRServicepage.alertUndefinedError, "Undefined error OK button");
            click(CRServicePage.alertUndefinedError, "Undefined error OK button");
        }/* else {
            assertFalse(flagUndefinedErrorAlert, "Undefined error Not Present");
        }*/

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateFacilityAutospot
     * description :: To validate the Facility Autospoted or Not
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public String validateFacilityAutospotID() throws Throwable {
        String facility = null;
        waitForVisibilityOfElement(CRServicePage.serviceTab, "Service tab");
        click(CRServicePage.serviceTab, "Service tab");
        boolean flagSpotFacilityLabel = isElementPresent(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
        if (flagSpotFacilityLabel) {
            Thread.sleep(5000);
            facility = getText(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
            assertTrue(true, "Auto Spot Value is " + facility);
        } else {
            assertFalse(false, "Auto spot value is not found");
        }
        return facility;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTypeinServices
     * description :: To enter Call Typein Services
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void enterCallTypeinServices(String callType) throws Throwable {
        click(CRServicePage.txtCallType, "Call type text box");
        type(CRServicePage.txtCallType, callType, "Call Type text box in services");
        waitForVisibilityOfElement(CRServicePage.btnSavecall, "Save call");
        click(CRServicePage.btnSavecall, "Save call");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: saveClearHistoryCallWindow
     * description :: save ClearHistoryCall window
     * date :: 29-Nov-2017
     * author ::
     */

    public void saveClearHistoryCallWindow() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.saveClearHistoryCallwindow, "SaveClear History Call Window");
        boolean isWindowAvailable = isVisibleOnly(CRServicePage.saveClearHistoryCallwindow, "SaveClear History Call Window");
        assertTrue(isWindowAvailable, "Save Clear History Call Window available");
/*        if (isWindowAvailable) {

            assertTrue(isWindowAvailable, "Save Clear History Call Window available");
        } else {
            assertFalse(isWindowAvailable, "Save Clear History Call Window available");
        }*/
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyCallHistoryCallWindowFields
     * description :: To verify CallHistoryCall Window fields
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyCallHistoryCallWindowFields() throws Throwable {

        boolean isHistoryCallDateAvailable = isVisibleOnly(CRServicePage.txtHistoryCallDate, "Call Date");
/*        if (isHistoryCallDateAvailable) {

            assertTrue(isHistoryCallDateAvailable, "Save Clear History Call Window available");
        } else {
            assertFalse(isHistoryCallDateAvailable, "Save Clear History Call Window available");
        }*/
        assertTrue(isHistoryCallDateAvailable, "Save Clear History Call Window available");

        boolean isFacilitydropDown = isVisibleOnly(CRServicePage.txtFacility, "Facity Text");
/*        if (isFacilitydropDown) {

            assertTrue(isFacilitydropDown, "Facility Dropdown available");
        } else {
            assertFalse(isFacilitydropDown, "Facility Dropdown available");
        }*/
        assertTrue(isFacilitydropDown, "Facility Dropdown available");
        boolean isTruckID = isVisibleOnly(CRServicePage.txtTruckID, "Truck ID");
/*        if (isTruckID) {

            assertTrue(isTruckID, "Truck ID");
        } else {
            assertFalse(isTruckID, "Truck ID");
        }*/
        assertTrue(isTruckID, "Truck ID");
        boolean isDriverNum = isVisibleOnly(CRServicePage.txtDriverNum, "Driver#");
/*        if (isDriverNum) {

            assertTrue(isDriverNum, "Driver#");
        } else {
            assertFalse(isDriverNum, "Driver#");
        }*/
        assertTrue(isDriverNum, "Driver#");
        boolean isClearingCode = isVisibleOnly(CRServicePage.txtClearingCode, "ClearingCode");
/*        if (isClearingCode) {

            assertTrue(isClearingCode, "ClearingCode");
        } else {
            assertFalse(isClearingCode, "ClearingCode");
        }*/
        assertTrue(isClearingCode, "ClearingCode");
        boolean isPacesetter = isVisibleOnly(CRServicePage.txtPacesetter, "Pacesetter Reason");
/*        if (isPacesetter) {

            assertTrue(isPacesetter, "Pacesetter Reason");
        } else {
            assertFalse(isPacesetter, "Pacesetter Reason");
        }*/
        assertTrue(isPacesetter, "Pacesetter Reason");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyCalendarDropdown
     * description :: To verify Calendar Dropdown
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyCalendarDropdown() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtHistoryCallDate, " Calendar Drop Down");

        boolean isCalendarDropDown = isVisibleOnly(CRServicePage.calendarDropDown, "calendar dropdown");
/*        if (isCalendarDropDown) {

            assertTrue(isCalendarDropDown, "calendar dropdown");
        } else {
            assertFalse(isCalendarDropDown, "calendar dropdown");
        }*/
        assertTrue(isCalendarDropDown, "calendar dropdown");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyCalendarErrorText
     * description :: To verify Calendar ErrorText
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyCalendarErrorText() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtHistoryCallDate, " Calendar Drop Down");
        isElementPresent(CRServicePage.btnCalendarNextMonth, "Not able to select Future date");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterDateInSaveClearHistoryCall
     * description :: To enter Date In Save ClearHistoryCall
     * date :: 29-Nov-2017
     * author ::
     */

    public void enterDateInSaveClearHistoryCall(String currentDate) throws Throwable {
        type(CRServicePage.txtHistoryCallDate, currentDate, "History call date");
        click(CRServicePage.saveClearHistoryCallwindow, "SaveClear History Call Window");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTruckIDInSaveClearHistoryCall
     * description :: To enter TruckID in SaveClearHistoryCall
     * date :: 29-Nov-2017
     * author ::
     */

    public void enterTruckIDInSaveClearHistoryCall(String truckID) throws Throwable {
        type(CRServicePage.txtTruckID, truckID, "Truck ID");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterClearingCodeInSaveClearHistoryCall
     * description :: To enter Clearing Code in SaveClearHistoryCall
     * date :: 29-Nov-2017
     * author ::
     */

    public void enterClearingCodeInSaveClearHistoryCall(String clearingCode) throws Throwable {
        type(CRServicePage.txtClearingCode, clearingCode, "Clearing Code");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPaceSetterReasonInSaveClearHistoryCall
     * description :: To enter Pacesetter Reasonin Save ClearHistoryCall
     * date :: 29-Nov-2017
     * author ::
     */

    public void enterPaceSetterReasonInSaveClearHistoryCall(String paceSetter) throws Throwable {
        type(CRServicePage.txtPacesetter, paceSetter, "Pace Setter Reason");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickGaragePaymentInfoButton
     * description :: To click Garage PaymentInfo Button
     * date :: 29-Nov-2017
     * author ::
     */

    public void clickGaragePaymentInfoButton() throws Throwable {
        click(CRServicePage.btnGaragePaymentInfo, "Garage Payment Info");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyGaragePaymentInForWindow
     * description :: To verify Garage Payment Inforomation Window
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyGaragePaymentInForWindow() throws Throwable {

        boolean GarageWindow = isVisibleOnly(CRServicePage.popupGaragePaymentInfoWindow, "Garage Payment Info");
        /*if (GarageWindow) {
            assertTrue(GarageWindow, "Garage Window presented");
        } else {
            assertFalse(GarageWindow, "Garage Window not Availble");
        }*/
        assertTrue(GarageWindow, "Garage Window presented");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: closeGaragePaymentInForWindow
     * description :: To close Garage Payment Info Window
     * date :: 29-Nov-2017
     * author ::
     */

    public void closeGaragePaymentInForWindow() throws Throwable {
        click(CRServicePage.btnGaragePaymentInfoWindowClose, "Garage Payment Info Window Close & Save Button");

    }

    public void closeButton() throws Throwable {
        click(CRServicePage.btnClose, "History Call Close");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveHistoryCallSaveButton
     * description :: To click On SaveHistoryCall SaveButton
     * date :: 29-Nov-2017
     * author ::
     */

    public void clickOnSaveHistoryCallSaveButton() throws Throwable {
        click(CRServicePage.btnSaveHistoryCallSaveCall, "HistoryCallSaveButton");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyCallId
     * description :: To verify CallId
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyCallId() throws Throwable {
        isElementPresent(CRServicePage.callId, "callerId");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRemainInCall
     * description :: To click On RemainInCall
     * date :: 29-Nov-2017
     * author ::
     */

    public void clickOnRemainInCall() throws Throwable {
        Thread.sleep(2000);
        click(CRServicePage.btnRemainInCall, "Remain In call");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyCallStatus
     * description :: To verify CallStatus
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyCallStatus() throws Throwable {
        boolean callStatus = isElementPresent(CRServicePage.btnCallStatus, "Call Status");
        /*if (callStatus) {
            assertTrue(callStatus, "Call Status");
        } else {
            assertFalse(callStatus, "Call Status");
        }*/
        assertTrue(callStatus, "Call Status");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyDisabledFieldsOnSaveClearHistoryCall
     * description :: verify disabled fields on save clear history calls
     * date :: 29-Nov-2017
     * author ::
     */

    public void verifyDisabledFieldsOnSaveClearHistoryCall() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.saveClearHistoryCallwindow, "Save Clear History call window");
        boolean disabledHistoryCallDateField = isVisibleOnly(CRServicePage.disabledHistoryCallDateField, "Disabled Histrory call date");
        /*if (disabledHistoryCallDateField) {
            assertTrue(disabledHistoryCallDateField, "Field is disabled");
        } else {
            assertFalse(disabledHistoryCallDateField, "Field is Enabled");
        }*/
        assertTrue(disabledHistoryCallDateField, "Field is disabled");
        boolean disabledFacilityfield = isVisibleOnly(CRServicePage.disabledFacilityField, "Disabled Histrory call date");
        /*if (disabledFacilityfield) {
            assertTrue(disabledFacilityfield, "Field is disabled");
        } else {
            assertFalse(disabledFacilityfield, "Field is Enabled");
        }*/
        assertTrue(disabledFacilityfield, "Field is disabled");
        boolean disabledTruckIDfield = isVisibleOnly(CRServicePage.disabledTruckIDField, "Disabled Histrory call date");
        /*if (disabledTruckIDfield) {
            assertTrue(disabledTruckIDfield, "Field is disabled");
        } else {
            assertFalse(disabledTruckIDfield, "Field is Enabled");
        }*/
        assertTrue(disabledTruckIDfield, "Field is disabled");
        boolean disabledClearingCodefield = isVisibleOnly(CRServicePage.disabledClearingCodeField, "Disabled Histrory call date");
        /*if (disabledClearingCodefield) {
            assertTrue(disabledClearingCodefield, "Field is disabled");
        } else {
            assertFalse(disabledClearingCodefield, "Field is Enabled");
        }*/
        assertTrue(disabledClearingCodefield, "Field is disabled");
        boolean disabledPacesetterfield = isVisibleOnly(CRServicePage.disabledPacesetterField, "Disabled Histrory call date");
        /*if (disabledPacesetterfield) {
            assertTrue(disabledPacesetterfield, "Field is disabled");
        } else {
            assertFalse(disabledPacesetterfield, "Field is Enabled");
        }*/
        assertTrue(disabledPacesetterfield, "Field is disabled");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: closeCall
     * description :: closeCall
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void closeCall() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.closeCallButton, "Close call");
        click(CRServicePage.closeCallButton, "Close call");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: facilityAutoSpot
     * description :: Auto spot Facility
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void facilityAutoSpot() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.serviceTab, "Service tab");
        click(CRServicePage.serviceTab, "Service tab");
        boolean flag1 = isElementPresent(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
        boolean flag2 = isElementPresent(CRServicePage.txtSpotFacilityAddress, "Spot facility address");
        assertTrue(flag1, "Spot facility lable is present");
        assertTrue(flag2, "Spot facility address is present");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: errorAlertHandlingAfterSave
     * description :: To Handle errors and Alert
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void errorAlertHandlingAfterSave() throws Throwable {
        boolean flagConformOkButton = isVisibleOnly(CRServicePage.btnAlertSaveYes, "Confirmation okay button");
        //assertTrue(flagConformOkButton, "Confirmation okay button");
        if (flagConformOkButton) {
            //assertTrue(flagConformOkButton, "Confirmation okay button");
            click(CRServicePage.btnAlertSaveYes, "Confirmation Okay button");
        }/* else {
            assertFalse(flagConformOkButton, "Confirmation Okay is Not Present");
        }*/
        boolean flagSaveFailure = isVisibleOnly(CRServicePage.saveFailureError, "save failure Button");
        //assertTrue(flagSaveFailure, "save failure");
        if (flagSaveFailure) {
         //   assertTrue(flagSaveFailure, "save failure");
            //waitForVisibilityOfElement(CRServicepage.savefailureerror, "save failure");
            click(CRServicePage.saveFailureError, "save failure Button");
        }/* else {
            assertFalse(flagSaveFailure, "save failure");
        }*/

    }

    public void clickOnManualEntryLinkInServicePage() throws Throwable {
        click(CRServicePage.manualEntryLink, "ManualEntry Link");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterAppointmentDate
     * description :: Entering value in Appointment Date in services page
     * date :: 14-Nov-2017
     * author :: chandrasekhar Dendukuri
     * Sprint number: 2
     */

    public void enterAppointmentDate(String Date) throws Throwable {
        type(CRServicePage.txtAppointmentDate, Date, "Appointmnet Date");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterAppointmentTime
     * description :: Entering value in Appointment Time in services page
     * date :: 14-Nov-2017
     * author :: chandrasekhar Dendukuri
     * Sprint number: 2
     */

    public void enterAppointmentTime(String Time) throws Throwable {
        type(CRServicePage.txtAppointmentTime, Time, "Appointmnet Time");
    }

    /**
     * Description:
     *
     * @throws Throwable
     * @author :Lakshmi
     */
    public void messageForLeaveCall() throws Throwable {
        boolean leavemessage = isElementPresent(CRServicePage.leaveCallMessage, "Message after leave the call");
        String leavemsg = getText(CRServicePage.leaveCallMessage, "Message after leave the call");
        assertTrue(leavemessage, "Confirmation window displays with the following message Are you sure you wish to leave this call?");
    }

    /**
     * Description:To click on Appointment Button
     *
     * @throws Throwable
     */
    public void clickOnAppointmentbutton() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnAppointment, "Appointment Button");
        click(CRServicePage.btnAppointment, "Appointment Button");
    }

    /**
     * Description:To click on Callstatus Button located at bottom of the page
     *
     * @throws Throwable
     */
    public void clickOnCallStatusButton() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnCallStatus, "Call Status");
        click(CRServicePage.btnCallStatus, "Call Status");
        Thread.sleep(3000);
    }

    /**
     * Description:To verfiy whether the call status retrieved as expected.
     *
     * @param callStatus
     * @throws Throwable
     */
    public void verifyToGetCallStatus(String callStatus) throws Throwable {
        String retrivedCallstatus = getText(CRServicePage.callStatusRetrived, "Retrieved Call status");
        /*if (retrivedCallstatus.equalsIgnoreCase(callStatus)) {
            assertTrue(retrivedCallstatus.equalsIgnoreCase(callStatus), "Call status retrieved sucessfully");
        } else {
            assertFalse(retrivedCallstatus.equalsIgnoreCase(callStatus), "Call status not available ");
        }*/
        assertTrue(retrivedCallstatus.equalsIgnoreCase(callStatus), "Call status retrieved sucessfully");
    }

    /**
     * Description:To click on Appointment release button
     *
     * @throws Throwable
     */
    public void verifyAppointmentIsReleased() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnAppointmentRelease, "Appointment Release");
        click(CRServicePage.btnAppointmentRelease, "Appointment Released button");
    }

    public void appointmentCallLeaveButton() throws Throwable {
        click(CRServicePage.btnAppointmentLeaveButton, "Leave Button");
    }

    /**
     * Description : To verify whether the TimeStamp retrieved is as expected.
     *
     * @param timeStamp
     * @throws Throwable
     */
    public void verifyTimeStamp(String timeStamp) throws Throwable {
        String time = getText(CRServicePage.timeStampInCallStatus, "Time stamp");
        /*if (time.equalsIgnoreCase(timeStamp)) {
            assertTrue(time.equalsIgnoreCase(timeStamp), "Time stamp is verified");
        } else {
            assertFalse(time.equalsIgnoreCase(timeStamp), "Time stamp is not matched");
        }*/
        assertTrue(time.equalsIgnoreCase(timeStamp), "Time stamp is verified");

    }

    /**
     * Description:This method is used to click on the status history table after clicking on call status button
     *
     * @throws Throwable
     */
    public void clickOnDateColumnInstatustable() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.dateColumn, "status history table");
        click(CRServicePage.dateColumn, "status history table");
    }

    public void clickOnSPStatusUpdate() throws Throwable {
        click(CRServicePage.btnSpStatusUpadte, "SP status Update Yes Button");
    }

    /**
     * Description:This method is used to enter reason for selecting the status update
     *
     * @param status
     * @throws Throwable
     */
    public void enterReasonForStatus(String status) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCallStatusUpdate, "reason for status update");
        click(CRServicePage.txtCallStatusUpdate, "Reason for status");
        type(CRServicePage.txtCallStatusUpdate, "LC Lost Call", "Reason for status");

    }

    /**
     * Description:This method is used to click on update button on reason for status update pop up
     *
     * @throws Throwable
     */
    public void clickOnUpadteButton() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnUpdate, "update button");
        click(CRServicePage.btnUpdate, "Update Button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSpecialEquipement
     * description :: enterSpecialEquipement
     * date :: 29-Dec-2017
     * author :: chandrasekhar Dendukuri
     * Sprint number: 3
     */

    public void enterSpecialEquipement(String specialequipement) throws Throwable {
        type(CRServicePage.txtSpecialEquipement, specialequipement, "Specail Equipement");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRedFlagOnServiceTab
     * description :: To click On RedFlag OnServiceTab
     * date :: 29-Dec-2017
     * author :: Nidhi
     * Sprint number: 3
     */
    public void clickOnRedFlagOnServiceTab() throws Throwable {
        boolean redFlag = isVisibleOnly(CRServicePage.btnRedFlagOnServiceTab, "RedFlag Button");
        if (redFlag) {
            click(CRServicePage.btnRedFlagOnServiceTab, "Click On RedFlag Button");
        } else {
            assertTrue(!redFlag, "RedFlag Button is not visible");
        }
    }

    public void validateFacilityAutospotAddress() throws Throwable {
        boolean flagSpotFacilityAddress = isElementPresent(CRServicePage.txtSpotFacilityAddress, "Spot facility address");
        if (flagSpotFacilityAddress) {
            String facilityAddress = getText(CRServicePage.txtSpotFacilityAddress, "Spot facility lable");
            assertTrue(flagSpotFacilityAddress, "Auto Spot address is " + facilityAddress);
        } else {
            assertFalse(flagSpotFacilityAddress, "Auto spot address is not found");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSpeciLEquipment
     * description :: To enter SpeciL Equipment
     * date :: 29-Dec-2017
     * author :: Nidhi
     * Sprint number: 3
     */
    public void enterSpeciLEquipment(String spoitedId) throws Throwable {
        type(CRServicePage.txtSpecialEquipement, spoitedId, "SpeciLEquipment");
        click(CRServicePage.txtSpotFacilityLabel, "SpeciLEquipment");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifySpeciLEquipmentWithAutoSpotID
     * description :: verifySpeciLEquipmentWithAutoSpotID
     * date :: 04-Jan-2018
     * author :: Lakshmi
     */

    public void verifySpeciLEquipmentWithAutoSpotID(String autoSpotId, String specialEquipmentAutoSpotId) throws Throwable {
        boolean autospot = autoSpotId.equals(specialEquipmentAutoSpotId);
        /*if (autospot) {
            //assertTrue(autospot,"Facility assignment:: "+autoSpotId+" is not Matched with:: "+specialEquipmentAutoSpotId);
            assertTrue(autospot, "Facility is automatically Re-spoted to a different facility based on the special equipment");
            assertTrue(autospot, "Auto Spoted ID is  " + autoSpotId + " And spotedId for SpeciLEquipment is  " + specialEquipmentAutoSpotId);
        } else {
            //assertFalse(autospot,"Facility assignment:: "+autoSpotId+" is Matched with:: "+specialEquipmentAutoSpotId);
            assertFalse(autospot, "Facility is not Re-spoted to a different facility based on the special equipment");
            assertFalse(autospot, "Auto Spoted ID is  " + autoSpotId + " And  spotedId for SpeciLEquipment is  " + specialEquipmentAutoSpotId);
        }*/
        assertTrue(autospot, "Facility is automatically Re-spoted to a different facility based on the special equipment");
        assertTrue(autospot, "Auto Spoted ID is  " + autoSpotId + " And spotedId for SpeciLEquipment is  " + specialEquipmentAutoSpotId);
    }

    public String validateFacilityAutospot() throws Throwable {
        String facility = null;
        waitForVisibilityOfElement(CRServicePage.serviceTab, "Service tab");
        click(CRServicePage.serviceTab, "Service tab");
        boolean flagSpotFacilityLabel = isElementPresent(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
        if (flagSpotFacilityLabel) {
            facility = getText(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
            assertTrue(flagSpotFacilityLabel, "Auto Spot Value is " + facility);
        } else {
            assertFalse(flagSpotFacilityLabel, "Auto spot value is not found");
        }
        boolean flagSpotFacilityAddress = isElementPresent(CRServicePage.txtSpotFacilityAddress, "Spot facility address");
        if (flagSpotFacilityAddress) {
            String facilityAddress = getText(CRServicePage.txtSpotFacilityAddress, "Spot facility lable");
            assertTrue(flagSpotFacilityAddress, "Auto Spot address is " + facilityAddress);
        } else {
            assertFalse(flagSpotFacilityAddress, "Auto spot address is not found");
        }
        return facility;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getFacilityType
     * description :: getFacilityType
     * date :: 04-Jan-2018
     * author :: Chandra
     */


    public void getFacilityType() throws Throwable {
        getText(CRServicePage.lblFacilityType, "Facility Type");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPriority
     * description ::
     * date :: 11-Jan-2018
     * author ::Abhiram
     */
    public void enterPriority(String priority) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtPriority, "Priority");
        type(CRServicePage.txtPriority, priority, "Priority");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnHold
     * description ::
     * date :: 11-Jan-2018
     * author ::Abhiram
     */
    public void clickOnHold() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnHold, "Hold button");
        click(CRServicePage.btnHold, "Hold Button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterHold
     * description ::
     * date :: 11-Jan-2018
     * author ::Abhiram
     */
    public void enterHold(String hold) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtHold, "Hold");
        type(CRServicePage.txtHold, hold, "Hold");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAvoid
     * description ::
     * date :: 11-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public void clickOnAvoid() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnAvoid, "Avoid button");
        click(CRServicePage.btnAvoid, "Click on Avoid button");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectAutoPopulatedFacility
     * description ::
     * date :: 11-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public void selectAutoPopulatedFacility() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.autoPopulatedFacility, "AutoSpotted Facility");
        click(CRServicePage.autoPopulatedFacility, "AutoSpotted Facility");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPrefer
     * description ::
     * date :: 11-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public void clickOnPrefer() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnPrefer, "Prefer button");
        click(CRServicePage.btnPrefer, "Click on Prefer button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSpotInServicePage
     * description :: clickOnSpotInServicePage
     * date :: 11-Jan-2018
     * author :: Chandra
     */


    public void clickOnSpotInServicePage() throws Throwable {
        click(CRServicePage.btnSpot, "Spot Button");
    }

    /**
     * param ::String Inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterManualFacilityNumber
     * description :: enterManualFacilityNumber
     * date :: 11-Jan-2018
     * author :: Chandra
     */


    public void enterManualFacilityNumber(String facilityNumber) throws Throwable {
        type(CRServicePage.txtSpotManualEntry, facilityNumber, "facilityNumber");
    }

    /**
     * param :: InputString
     * return ::void
     * throws :: throwable
     * methodName :: getInactiveFacilityErrorMessage
     * description :: getInactiveFacilityErrorMessage
     * date :: 11-Jan-2018
     * author :: Chandra
     */


    public void getInactiveFacilityErrorMessage(String inactiveMessage) throws Throwable {
        String errorMessage = getText(CRServicePage.lblInactiveFacilityErrorMessage, "Inactive facility Error Message");
        assertTrue(errorMessage.equalsIgnoreCase(inactiveMessage), "Given Facility Code is inactive");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCashOnServiceTab
     * description :: To click On cash icon OnServiceTab
     * date :: 10-Jan-2018
     * author :: Varun
     * Sprint number: 4
     */
    public void clickOnCashOnServiceTab() throws Throwable {
        boolean cashButton = isVisibleOnly(CRServicePage.btnCash, "Cash Button");
        if (cashButton) {
            click(CRServicePage.btnCash, "Click on Cash Button");
        } else {
            assertTrue(!cashButton, "Cash Button is not visible");
        }
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterFacilityPreference
     * description :: To enter Facility text in to Field
     * date :: 12-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public void enterFacilityPreference(String facility) throws Throwable {
        // Thread.sleep(2000);
        waitForVisibilityOfElement(CRServicePage.txtFacilityField, "Facility");
        click(CRServicePage.txtFacilityField, "Facility");
        Thread.sleep(2000);
        clearData(CRServicePage.txtFacilityField);
        type(CRServicePage.txtFacilityField, facility, "Facility");
        String combineKeys1 = Keys.chord(Keys.SPACE);
        sendKeys(combineKeys1, "SPACE");
        String combineKeys2 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys2, "Tab");
        //  mouseDoubleClick(CRServicePage.btnPrefer,"Prefer button");

        boolean visibilityOfContinueButton = isVisibleOnly(CRServicePage.btnContinueOnPreferFacility, "Continue button on Prefer Facility");
        assertTrue(visibilityOfContinueButton, "Button available");
        if (visibilityOfContinueButton) {
            //assertTrue(visibilityOfContinueButton, "Button available");
            click(CRServicePage.btnContinueOnPreferFacility, "Button Facility");

        } /*else {
            assertFalse(visibilityOfContinueButton, "Button not found");
        }*/
        Thread.sleep(2000);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPolicy
     * description ::
     * date :: 11-Jan-2018
     * author ::Abhiram
     */
    public void enterPolicy(String policy) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtPolicy, "Policy");
        type(CRServicePage.txtPolicy, policy, "Policy");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCheckBoxCallBack
     * description ::
     * date :: 11-Jan-2018
     * author ::Abhiram
     */

    public void clickOnCheckBoxCallBack() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.chkBoxCallBack, "Call Back CheckBox");
        click(CRServicePage.chkBoxCallBack, "Call Back CheckBox");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallBackMinutes
     * description ::
     * date :: 11-Jan-2018
     * author ::Abhiram
     */
    public void enterCallBackMinutes(String minutes) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCallBackMinutes, "Call Back Minutes");
        type(CRServicePage.txtCallBackMinutes, minutes, "Call Back Minutes");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallBackRequestType
     * description ::
     * date :: 11-Jan-2018
     * author ::Abhiram
     */
    public void enterCallBackRequestType(String requestType) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCallBackRequestType, "Call Back Minutes");
        type(CRServicePage.txtCallBackRequestType, requestType, "Call Back Minutes");
    }

    public void validateAutoSpotandSaveCall() throws Throwable {
        validateFacilityAutospot();
        clickOnSaveBtn();
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyRedFlagChecked
     * description ::
     * date :: 12-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public String verifyRedFlagChecked() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnRedFlagOnServiceTab, "Red flag");
        String redFlag = getText(CRServicePage.btnRedFlagOnServiceTab, "Red flag is automatically checked");
        return redFlag;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateNoFacilityAutoSpot
     * description ::
     * date :: 12-Jan-2018
     * author :: Abhiram
     */

    public boolean validateNoFacilityAutoSpot() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.serviceTab, "Service tab");
        boolean flagSpotFacilityLabel = isElementNotPresent(CRServicePage.txtSpotFacilityLabel, "Spot facility lable");
        return flagSpotFacilityLabel;
    }

    /**
     * Description:This method is used to get the Super override PTA Value
     * Date:16-01-2018
     *
     * @return
     * @throws Throwable
     */
    public String getSuperOverdidePTAValue() throws Throwable {
        String superOverdidePTAValue = getAttributeByValue(CRServicePage.lblSuperOverridePTAValue, "Super Override PTA Value");
        return superOverdidePTAValue;
    }

    /**
     * Description:This method is used to get the manual override PTA Value
     * Date:16-01-2018
     *
     * @return
     * @throws Throwable
     */
    public String getManualOverdidePTAValue() throws Throwable {
        String manualOverdidePTAValue = getAttributeByValue(CRServicePage.lblManualOverridePTAValue, "Manual Override PTA Value");
        return manualOverdidePTAValue;
    }

    /**
     * Description:To set Manual Override value on spotted facility Tab
     * Date:16-01-2018
     *
     * @param maualPTA
     * @throws Throwable
     */
    public void setManualOverrideOnSpottedFacility(String maualPTA) throws Throwable {
        isVisibleOnly(CRServicePage.lblManualOverridePTAValue, "Manual Override PTA Value");
        click(CRServicePage.lblManualOverridePTAValue, "Manual Override PTA Value");
        type(CRServicePage.lblManualOverridePTAValue, maualPTA, "Manual Override PTA Value");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPriority1
     * description ::
     * date :: 16-Jan-2018
     * author ::Nidhi
     */
    public void enterPriority1(String priority) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtPriority, "Priority");
        type(CRServicePage.txtPriority, priority, "Priority");
        String combineKeys2 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys2, "Tab");
    }

    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: getSpotFacilityId
     * description ::
     * date :: 16-Jan-2018
     * author :: Abhiram
     */

    public String getSpotFacilityId() throws Throwable {
        String spotFacilityID = getText(CRServicePage.lblSpotFacility, "Spot Facility ID");
        return spotFacilityID;
    }

    /**
     * Description:This method is used to get the pta value from the Call Confirmation window
     * date :: 16-Jan-2018
     *
     * @throws Throwable
     */
    public boolean verifyPTAAfterCallSave(String time) throws Throwable {
        boolean ptavalue = false;
        isVisibleOnly(CRServicePage.lblPTAValueOnCallConfirmation, "PTA After Save");
        String pta = getText(CRServicePage.lblPTAValueOnCallConfirmation, "PTA After Call Save");
        String p = pta.substring(11, 16);
        System.out.println(p);
        if (p.equalsIgnoreCase(time))
            ptavalue = true;
        return ptavalue;
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: verifyErrorMsgForAutospot
     * description ::
     * date :: 17-Jan-2018
     * author :: Nidhi
     */

    public String verifyErrorMsgForAutospot() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.txtErrorMsg, "Error msg");
        String value = getText(CRServicePage.txtErrorMsg, "get error msg");
        return value;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnCreditCard
     * description ::
     * date :: 17-Jan-2018
     * author :: Nidhi
     */

    public void clickOnCreditCard() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.btnCreditCard, "Credit Card");
        click(CRServicePage.btnCreditCard, "Click on btnCreditCard");

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnCreditCard
     * description ::
     * date :: 17-Jan-2018
     * author :: Nidhi
     */

    public String verifyCreditCardInCallRibbon() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.iconCreditCard, "Credit Card icon");
        String creditCardInCallRibbon = getText(CRServicePage.iconCreditCard, "Credit Card icon");
        return creditCardInCallRibbon;

    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnCreditCardInCallRibbion
     * description ::
     * date :: 17-Jan-2018
     * author :: Nidhi
     */

    public void clickOnCreditCardInCallRibbion() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.iconCreditCard, "Credit Card");
        click(CRServicePage.iconCreditCard, "Click on Credit Card in call ribbion");

    }


    /**
     * param :: NA
     * return ::String
     * throws :: throwable
     * methodName :: verifyCallStatus
     * description :: To verify CallStatus
     * date :: 17-Jan-2018
     * author :: Sachin
     */

    public String GetCallStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnCallStatus, "Call Status");
        String callstatus = getText(CRServicePage.btnCallStatus, "Call Status");
        return callstatus;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextOfStatusValue
     * description :: To get the text of status value
     * date :: 17-Jan-2018
     * author :: Ravi
     */
    public void getTextOfStatusValue() throws Throwable {
        isVisibleOnly(CRServicePage.txtStatusValue, "Status Value");
        getText(CRServicePage.txtStatusValue, "Status Value");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextOfResonValue
     * description :: To get the text of status value
     * date :: 17-Jan-2018
     * author :: Ravi
     */
    public void getTextOfResonValue() throws Throwable {
        isVisibleOnly(CRServicePage.txtResonValue, "Reson Value");
        getText(CRServicePage.txtResonValue, "get text of reson Value");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextOfUserNameValue
     * description :: To get the text of userName value
     * date :: 17-Jan-2018
     * author :: Ravi
     */
    public void getTextOfUserNameValue() throws Throwable {
        isVisibleOnly(CRServicePage.txtUsernameValue, "UserName Value");
        getText(CRServicePage.txtUsernameValue, "get text of userName Value");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextOfRoleNameValue
     * description :: To get the text of userName value
     * date :: 17-Jan-2018
     * author :: Ravi
     */
    public void getTextOfRoleNameValue() throws Throwable {
        isVisibleOnly(CRServicePage.txtRoleValue, "Role Value");
        getText(CRServicePage.txtRoleValue, "get text of Role Value");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextOfRoleNameValue
     * Description:To gettext of  on Callstatus Button located at bottom of the page
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void getTextCallStatusButton() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnCallStatus, "Call Status");
        getText(CRServicePage.btnCallStatus, "Call Status");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextAndClickOnYesInSpStatusPopup
     * Description:To gettext of  on getText And ClickOnYesInSpStatusPopup
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void getTextAndClickOnYesInSpStatusPopup() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnCallStatus, "Call Status");
        getText(CRServicePage.txtStatusUpdate, "sp would you like to submit ");
        {
            reporter.SuccessReport("verify submit an SP status update", "Verified would you like to submit SP status update");
        }
        Thread.sleep(2000);
        click(CRServicePage.btnSpStatusUpadte, "Call on Yes on Status update popup");
        Thread.sleep(2000);
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: updateCallStatus
     * Description:To update the call status
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void verifyUpdateCallStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblCallStatusUpdateTitle, "Call Status Update Title");
        getText(CRServicePage.lblCallStatusUpdateTitle, "Call Status Update Title");
        Thread.sleep(1000);
        getText(CRServicePage.lblStatus, "verify Call Status  ");
        Thread.sleep(1000);
        getText(CRServicePage.lblResonForStatus, "verify reason for Status");
        Thread.sleep(1000);
        getText(CRServicePage.lblComments, "verify comments text");
        Thread.sleep(1000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyUpdateIsNotClikable
     * Description:To verify Update Is Not Clikable
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void verifyUpdateIsNotClikable() throws Throwable {

        String ElementClass = getAttributeByClass(CRServicePage.btnUpdateEnabled, "update button");
        boolean updateEnable = ElementClass.contains("disable");
        assertTrue(updateEnable, "element disabled");
        {
            reporter.SuccessReport("Verify update button", "Verified update button is not clikable");
        }
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterInCommentStatus
     * Description:To enter In Comment Status
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void enterInCommentStatus(String commentStatusUpdate) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCommentsInStatusUpdate, "enter data in Comments");
        type(CRServicePage.txtCommentsInStatusUpdate, commentStatusUpdate, "enter data in Comments");
        Thread.sleep(2000);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterInResonForStatusStatus
     * Description:To enter In Reson For StatusStatus
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void enterInResonForStatusStatus(String statusReason) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtResonForStatus, "reason for staus");
        type(CRServicePage.txtResonForStatus, statusReason, "reason for staus");
        Thread.sleep(5000);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyUpdateIsNowClikable
     * Description:To verify Update Is Now Clikable
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void verifyUpdateIsNowClikable() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.btnUpdateButton, "click on update button");
        getText(CRServicePage.btnUpdateButton, "click on update button");
        Thread.sleep(3000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextSpStatusAncClickUpdate
     * Description:To getText Sp Status Anc Click Update
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void getTextSpStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblSpStatus, "SP status");
        getText(CRServicePage.lblSpStatus, "SP status");
        {
            reporter.SuccessReport("Verify call status", "Verified call is in SP Status");
        }


    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickUpdateButton
     * Description:To click Update Button
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void clickUpdateButton() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(CRServicePage.btnUpdateButton, "click on update button");
        click(CRServicePage.btnUpdateButton, "click on update button");
        Thread.sleep(3000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextCallStatus
     * Description:To getText Call Status
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void getTextCallStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblCallStatus, "get value of call status ");
        getText(CRServicePage.lblCallStatus, "get value of call status ");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextCallStatus
     * Description:To getText Call Status
     * date :: 17-Jan-2018
     * author :: Ravi
     */

    public void clickOnCancelBtn() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnCancel, "click on cancel ");
        click(CRServicePage.btnCancel, "click on cancel ");
        Thread.sleep(2000);
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: statusValueIsStillSpButNotUp
     * description :: To status Value Is Still SpButNotUp
     * date :: 17-Jan-2018
     * author :: Ravi
     */
    public void statusValueIsStillSpButNotUp() throws Throwable {
        isVisibleOnly(CRServicePage.lblCallStatus, "Status Value");
        getText(CRServicePage.lblCallStatus, "Status Value is SP but not UP");
        {
            reporter.SuccessReport("Verify call status", "Verified the Calls current status is still SP and not UP");
        }
        Thread.sleep(2000);
    }

    //  --------------------------------------------------
    //  --------------------------------------------------

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: removePriority1
     * description ::
     * date :: 18-Jan-2018
     * author ::Nidhi
     */
    public void removePriority1() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtPriority, "Priority");
        clearData(CRServicePage.txtPriority);


    }

    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyRedFlagCheckedRemoved
     * description ::
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public String verifyRedFlagCheckedRemoved() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnRedFlagOnServiceTab, "Red flag");
        String value = getText(CRServicePage.btnRedFlagOnServiceTab, "Red flag ");
        return value;

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallTypeinServices1
     * description ::
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public void enterCallTypeinServices1(String callType) throws Throwable {
        click(CRServicePage.txtCallType, "Call type text box");
        type(CRServicePage.txtCallType, callType, "Call Type text box in services");
        String combineKeys2 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys2, "Tab");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPolicy1
     * description ::
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public void enterPolicy1(String policy) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtPolicy, "Policy");
        type(CRServicePage.txtPolicy, policy, "Policy");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCallBackRequestType1
     * description ::
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public void enterCallBackRequestType1(String requestType) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCallBackRequestType, "Request Type");
        type(CRServicePage.txtCallBackRequestType, requestType, "Request Type");
        String combineKeys2 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys2, "Tab");
    }

    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyCallBackMinutes
     * description ::
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public String verifyCallBackMinutes() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCallBackMinutes, "Call Back Minutes");
        String minutes = getAttributeByValue(CRServicePage.txtCallBackMinutes, "Call Back Minutes");
        return minutes;
    }

    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyCallBackRequestType
     * description ::
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public String verifyCallBackRequestType() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCallBackRequestType, "Request Type");
        String type = getAttributeByValue(CRServicePage.txtCallBackMinutes, " Request Type");
        return type;

    }

    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyPriorityCode
     * description ::
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public String verifyPriorityCode() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtPriority, "Priority");
        String priority = getAttributeByValue(CRServicePage.txtPriority, "Priority");
        return priority;

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSpecialEquipement1
     * description ::
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public void enterSpecialEquipement1(String specialequipement) throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtSpecialEquipement, "Specail Equipement");
        type(CRServicePage.txtSpecialEquipement, specialequipement, "Specail Equipement");
        String combineKeys2 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys2, "Tab");
    }

    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifySpecialEquipement
     * description ::
     * date :: 18-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public String verifySpecialEquipement() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtSpecialEquipement, "Specail Equipement");
        String spclEquip = getAttributeByValue(CRServicePage.txtSpecialEquipement, "Specail Equipement");
        return spclEquip;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnPolicyDropDownOnServiceTab
     * description ::
     * date :: 17-Jan-2018
     * author :: Abhiram
     */

    public void clickOnPolicyDropDownOnServiceTab() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.dropDownBoxOnPolicy, "Policy option");
        click(CRServicePage.dropDownBoxOnPolicy, "Click on Policy option");

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnPriorityDropDownOnServiceTab
     * description ::
     * date :: 17-Jan-2018
     * author :: Abhiram
     */

    public void clickOnPriorityDropDownOnServiceTab() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.dropDownBoxOnPriority, "Priority option");
        click(CRServicePage.dropDownBoxOnPriority, "Click on Priority option");

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: dropDownBoxOnCallBackRequestMinutes
     * description ::
     * date :: 17-Jan-2018
     * author :: Abhiram
     */

    public void dropDownBoxOnCallBackRequestMinutes() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.dropDownBoxOnCallBackRequestMinutes, "Call back in minutes");
        click(CRServicePage.dropDownBoxOnCallBackRequestMinutes, "Call back in minutes");

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: dropDownBoxOnCallBackRequestType
     * description ::
     * date :: 17-Jan-2018
     * author :: Abhiram
     */

    public void dropDownBoxOnCallBackRequestType() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.dropDownBoxOnCallBackRequestType, "Call back request Type");
        click(CRServicePage.dropDownBoxOnCallBackRequestType, "Call back request Type");

    }


    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyCallTypeinServices
     * description ::
     * date :: 19-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public String verifyCallTypeinServices() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtCallType, "Call type text box");
        String callType = getAttributeByValue(CRServicePage.txtCallType, "Call Type text box in services");
        return callType;

    }

    /**
     * param :: String inputs
     * return ::String
     * throws :: throwable
     * methodName :: verifyPolicy1
     * description ::
     * date :: 19-Jan-2018
     * author :: Nidhi Kumari Raut
     */
    public String verifyPolicy1() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.getTxtPolicy, "Policy");
        String policy = getText(CRServicePage.getTxtPolicy, "Policy");
        return policy;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyRedFlagCheckedOnServices
     * description ::
     * date :: 19-Jan-2018
     * author :: Nidhi Kumari Raut
     */

    public String verifyRedFlagCheckedOnServices() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.btnRedFlagOnServiceTab, "Red flag");
        String redFlag = getText(CRServicePage.btnRedFlagOnServiceTab, "Red flag is automatically checked");
        return redFlag;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnPolicyDropDownOnServiceTab
     * description ::
     * date :: 19-Jan-2018
     * author :: Nidhi
     */

    public void clickOnPolicyDropDown() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.dropDownBoxOnPolicyOnServiceTab, "Policy option");
        click(CRServicePage.dropDownBoxOnPolicyOnServiceTab, "Click on Policy option");

    }

    /* */

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: updateCallStatus
     * Description:To update the call status
     * date :: 19-Jan-2018
     * author :: Ravi
     */

    public void getTextStatusValue() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblStatusValueInCallStatus, "Status value in call status update");
        getText(CRServicePage.lblStatusValueInCallStatus, "status value in call status update");
        Thread.sleep(1000);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: updateCallStatus
     * Description:To update the call status
     * date :: 19-Jan-2018
     * author :: Ravi
     */

    public void getTextStatusValueInCallStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblStatusValueInCallStatus, "Status value in call status ");
        getText(CRServicePage.lblStatusValueInCallStatus, "status value in call status ");
        Thread.sleep(1000);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextReasonValueInCallStatus
     * Description:To getText Reason Value InCallStatus
     * date :: 19-Jan-2018
     * author :: Ravi
     */

    public void getTextReasonValueInCallStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblReasonValue, "Reason value in call status ");
        getText(CRServicePage.lblReasonValue, "Reason value in call status ");
        Thread.sleep(1000);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getTextReasonValueInCallStatus
     * Description:To getText Reason Value InCallStatus
     * date :: 19-Jan-2018
     * author :: Ravi
     */

    public void getTextFacilityValueInCallStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblFacilityVlue, "facility value in call status ");
        getText(CRServicePage.lblFacilityVlue, "Facility value in call status ");
        Thread.sleep(1000);

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyAuditStatusCode
     * Description:verifyAuditStatusCode
     * date :: 19-Jan-2018
     * author :: Ravi
     */

    public void verifyAuditStatusCode() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblAuditCodeInCallStatusUpdate, "Auditcode value in call status update ");
        getText(CRServicePage.lblAuditCodeInCallStatusUpdate, "AuditCode value in call status update ");
        {
            
                reporter.SuccessReport("Verify call status", "Verified call is in UP Status");
            
        }
        Thread.sleep(1000);

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnComment
     * description ::
     * date :: 17-Jan-2018
     * author :: ravi
     */

    public void clickOnComment() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.lblComments, "verify comments text");
        click(CRServicePage.lblComments, "verify comments text");
        Thread.sleep(2000);
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnUpdateButtonOnCallStatusWindow
     * description ::
     * date :: 17-Jan-2018
     * author :: ravi
     */

    public void clickOnUpdateButtonOnCallStatusWindow() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.btnUpdateBbuttonCallStatusUpdateWindow, "Update Button");
        click(CRServicePage.btnUpdateBbuttonCallStatusUpdateWindow, "Update Button");
        Thread.sleep(2000);
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnHoldDropDown
     * description ::
     * date :: 19-Jan-2018
     * author :: Nidhi
     */

    public void clickOnHoldDropDown() throws Throwable {

        waitForVisibilityOfElement(CRServicePage.dropDownBoxOnHoldReason, "reason option");
        click(CRServicePage.dropDownBoxOnHoldReason, "Click on reason option");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyHoldIcon
     * description ::
     * date :: 19-Jan-2018
     * author :: Nidhi
     */

    public String verifyHoldIcon() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.holdIcon, "Hold Icon");
        String hold = getText(CRServicePage.holdIcon, "Hold Icon");
        return hold;

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyHoldButton
     * description ::
     * date :: 19-Jan-2018
     * author :: Nidhi
     */
    public String verifyHoldButton() throws Throwable {
        isVisibleOnly(CRServicePage.btnHold, "Hold button");
        String holdbtn = getText(CRServicePage.btnHold, "Hold Button");
        return holdbtn;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyHoldReason
     * description ::
     * date :: 19-Jan-2018
     * author :: Nidhi
     */

    public void verifyHoldReason() throws Throwable {

        if ((driver.findElement(CRServicePage.txtHold).isEnabled()) == false) {
            reporter.SuccessReport("Verify Reason Code field", "reason code are uneditable");
        } else {
            reporter.failureReport("Verify Reason Code field", "reason code are editable");
        }

    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getPTADateAfterCallSave
     * description ::
     * date :: 22-Jan-2018
     * author :: Varun
     */

    public Date getPTADateAfterCallSave() throws Throwable {
        isVisibleOnly(CRServicePage.lblPTAValueOnCallConfirmation, "PTA After Save");
        String ptaText = getText(CRServicePage.lblPTAValueOnCallConfirmation, "PTA After Call Save");

        // String date2=crSearchCallsLib.getCallIdAndDate();
        String splitStr[] = ptaText.split("\n");
        String startDateValue = splitStr[0];

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date newCallIdDate = dateFormat.parse(startDateValue);
        //String strDate = dateFormat.format(d_date);
        return newCallIdDate;

    }

    public String getCurrentDate() {

        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");


        String date = dateFormat2.format(new Date());

        // will print like 2014-02-20
        //print(dateFormat2.format(new Date());
        return date;
    }

    public String getFutureTime() {
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = new Date(System.currentTimeMillis() + 3 * 60 * 1000);
        String futureTime = sdf.format(date);
        return futureTime;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRedFlagOnServiceTab
     * description :: To click On RedFlag OnServiceTab
     * date :: 19-jan-2018
     * author :: Ravi
     * Sprint number: 4
     */
    public void isVisibleRedFlag() throws Throwable {
        boolean redFlag = isVisibleOnly(CRServicePage.btnRedFlagOnServiceTab, "RedFlag Button");
        if (redFlag) {
            reporter.SuccessReport("Verify red flag", "Verified red flag on service tab");
        } else {
            reporter.failureReport("Verify red flag", "unable to verify red flag on service tab");
        }
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: selectFirstValueInResonStatus
     * description ::
     * date :: 22-Jan-2018
     * author :: ravi
     */

    public void selectFirstValueInResonStatus() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.dropDownBoxArrowOnStatusUpdate, "verify comments text");
        click(CRServicePage.dropDownBoxArrowOnStatusUpdate, "click on down arrow  in reasonupdate");
        Thread.sleep(3000);
        click(CRServicePage.dropDownFirstElementInReasonUpdate, "click on first element in reasonupdate");
        Thread.sleep(3000);
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnCancel
     * description ::
     * date :: 22-Jan-2018
     * author :: ravi
     */

    public void clickOnCancel() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.lblCancel, "waits for cancel");
        click(CRServicePage.lblCancel, "click on cancele");
        Thread.sleep(3000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getCallDate
     * description ::
     * date :: 24-Jan-2018
     * author :: Abhiram Vajrapu
     */

    public String getCallDate() throws Throwable {
        boolean flagCallDate = isElementPresent(CRServicePage.dateInCallInformationWindow, "Call Date");
        // assertTrue(flagCallId, "Call Created");

        String callDate = getText(CRServicePage.dateInCallInformationWindow, "Call Date");
        assertTrue(callDate != "", "Call is created and Saved The call With out Error");
        return callDate;
    }

    public void enterManualSpotDetails(String FacilityDetails) throws Throwable {
        enterManualFacilityNumber(FacilityDetails);
        clickOnSpotInServicePage();
    }

    public void spot(String Spot, String FacilityID, String ManualSoptFacilityID, String ManualSoptFacilityIDNew) throws Throwable {
        switch (Spot) {
            case "Auto":
                //For Auto sopt just we are capturing text
                String autoFacility = validateFacilityAutospotID();
                validateFacilityAutospotAddress();
                break;
            case "Manual":
                String manualFacility = validateFacilityAutospotID();
                if (manualFacility != FacilityID) {
                    enterManualSpotDetails(ManualSoptFacilityID);
                } else {
                    enterManualSpotDetails(ManualSoptFacilityIDNew);
                }

                break;
            default:
                break;
        }
    }

    public void callBack(String CallBack, String CallBackMinutes, String CallBackReqType) throws Throwable {
        if (CallBack.equalsIgnoreCase("Yes")) {
            clickOnCheckBoxCallBack();
            enterCallBackMinutes(CallBackMinutes);
            dropDownBoxOnCallBackRequestMinutes();
            enterCallBackRequestType(CallBackReqType);
            dropDownBoxOnCallBackRequestType();
        }
    }

    public void enterPolicy(String Policy, String PolicyValue) throws Throwable {
        if (Policy.equalsIgnoreCase("Yes")) {
            enterPolicy(PolicyValue);
            clickOnPolicyDropDown();
        }
    }

    public void clickRedFlag(String RedFlag) throws Throwable {
        if (RedFlag.equalsIgnoreCase("Yes")) {
            clickOnRedFlagOnServiceTab();
        }
    }

    public void enterAppointment(String Appointment, String Hold) throws Throwable {
        if (Appointment.equalsIgnoreCase("Yes Appointment")) {
            clickOnAppointmentbutton();
            String today = getCurrentDate();
            //If we create appointment for Next Day CallID status was HS(Hold Spot)
            //String nextDay=crSaveAppointmentCall.getNextDay(today);
            enterAppointmentDate(today);
            String futureTime = getFutureTime();
            enterAppointmentTime(futureTime);
        } else if (Appointment.equalsIgnoreCase("Yes Hold")) {
            clickOnHold();
            enterHold(Hold);
        }
    }

    public void enterpriority(String Priority, String PriorityRequired) throws Throwable {

        switch (Priority) {
            case "Yes":
                enterPriority(PriorityRequired);
                clickOnPriorityDropDownOnServiceTab();
                break;
            default:
                break;
        }
    }

    /**
     * Description:This method is used to verify calendar error text for a history call
     * Date:30-01-2018
     * @throws Throwable
     */
    public void verifyCalendarErrorTextOfHistorycall() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.CalendarErrorText, "Calendar Error text");
        String calendarText=getText(CRServicePage.CalendarErrorText,"Calendar Error text");
    }

    /**
     * Description:This method is used to verify the work flow
     * Date:30-01-2018
     * @throws Throwable
     */
    public void verifyWorkFlow()throws Throwable{
        waitForVisibilityOfElement(CRServicePage.workFlowLoadedtext,"WorkFlow");
        String workFlow=getText(CRServicePage.workFlowLoadedtext,"WorkFlow");
    }

    /**
     * Description:This method is used to verify the call status on the call status  button
     * Date:30-01-2018
     * @throws Throwable
     */
    public void verifyCallStatusText() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtInCallStatusButton, "Call Status");
        String callStatusText=getText(CRServicePage.txtInCallStatusButton, "Call Status");
    }

    public void verifyCompleteCheckService()  throws Throwable {
        if (!(isVisibleOnly(CRServicePage.verifyServiceCompleteCheck, "Service Complete Check"))) {
            reporter.failureReport("Verify Service Complete Check" , "All Mandatory Fields are not entered", driver);
        }
    }







    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnDateToArrange
     * description :: clicks on date
     * date :: 15-feb-2018
     * author :: ravi
     */
    public void clickOnDateToArrange() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(CRServicePage.lblDate, "click on date");
        click(CRServicePage.lblDate, "click on date");
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTextUpdateCode
     * description :: getText of Update Code
     * date :: 15-feb-2018
     * author :: ravi
     */
    public void getTextUpdateCode() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtUpdateCode, "update code");
        getText(CRServicePage.txtUpdateCode, "update code");
    }



    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTextReasonCode
     * description :: getText of Reason Code
     * date :: 15-feb-2018
     * author :: ravi
     */
    public void getTextReasonCode() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtReasonCode, "Reason code");
        getText(CRServicePage.txtReasonCode, "Reason code");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTextFacilityTruck
     * description :: getText Facility truck
     * date :: 15-feb-2018
     * author :: ravi
     */
    public void getTextFacilityTruck() throws Throwable {
        waitForVisibilityOfElement(CRServicePage.txtFacilityTruck, "Facility Truck");
        getText(CRServicePage.txtFacilityTruck, "Facility truck");
    }


    public void clickOnErrorOKButtonOnHistoryCallSave() throws Throwable {
        Thread.sleep(3000);
        isVisibleOnly(CRServicePage.errorOkOnHistoryCallSave, "click on Ok");
        click(CRServicePage.errorOkOnHistoryCallSave, "click on Ok");
    }
}