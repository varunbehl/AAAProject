package com.aaa.web.lib;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.aaa.web.page.DIMCDPage;
import com.aaa.web.page.LoginPage;
import com.aaa.accelerators.ActionEngine;

import org.apache.bcel.generic.GOTO;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DIMCDLib extends ActionEngine {
    List<WebElement> CommentsMCDWindow = new ArrayList<WebElement>();
    List<WebElement> cannedCommentsList = new ArrayList<WebElement>();
    String spotStatus;
    String assignStatus;
    String facilityStatus;
    String dispatchStatus;
    String enrouteStatus;
    String locationStatus;
    String clearStatus;
    boolean emptryRecords;
    boolean recordsPanelNotFund;
    String towDestinationAddress;
    String city;
    String State;
    String Zip;
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAssign
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnAssign() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnAsignCallinMCD, "Assign Call Link");
        click(DIMCDPage.btnAsignCallinMCD, "Assign Call Link");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateAssign
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public boolean validateAssign() throws Throwable {
        Thread.sleep(3000);
        //waitForVisibilityOfElement(DIMCDPage.btnAsignCallinMCD, "Assign Call Link");
        boolean visibility = isVisibleOnly(DIMCDPage.btnAsignCallinMCD, "Assign Call Link");
        return visibility;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectFacility
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectFacility() throws Throwable {
        Thread.sleep(3000);
        boolean isFacilityBVisible = isVisibleOnly(DIMCDPage.selectFacility, "Select Facility");
        if (isFacilityBVisible) {
            waitForVisibilityOfElement(DIMCDPage.selectFacility, "Select Facility");
            click(DIMCDPage.selectFacility, "Select facility");
        }
        boolean isFacilityZVisible = isVisibleOnly(DIMCDPage.selectFacilityZ, "Select Facility");
        if (isFacilityZVisible) {
            waitForVisibilityOfElement(DIMCDPage.selectFacilityZ, "Select Facility");
            click(DIMCDPage.selectFacilityZ, "Select facility");
        }
        boolean FacilityBVisible = isVisibleOnly(DIMCDPage.selectFacilityB, "Select Facility");
        if (FacilityBVisible) {
            waitForVisibilityOfElement(DIMCDPage.selectFacilityB, "Select Facility");
            click(DIMCDPage.selectFacilityB, "Select facility");
        }
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectDispatch
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectDispatch() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnDispatchUpdateinMCD, "Dispatch Update");
        click(DIMCDPage.btnDispatchUpdateinMCD, "Select Dispatch");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectEnroute
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectEnroute() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnEnrouteUpdateinMCD, "Enroute Update");
        click(DIMCDPage.btnEnrouteUpdateinMCD, "Select btnEnrouteUpdateinMCD");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectEnrouteTime
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectEnrouteTime() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.selEnrouteTimeinMCD, "Enroute Time");
        click(DIMCDPage.selEnrouteTimeinMCD, "Select enroute Time");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectOnLocation
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectOnLocation() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnOnLocationUpdateinMCD, "On Location Update");
        click(DIMCDPage.btnOnLocationUpdateinMCD, "Select On Location");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectClearCall
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectClearCall() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnClearCallUpdateinMCD, "Clear call Update");
        click(DIMCDPage.btnClearCallUpdateinMCD, "Select clear call");
    }

    public void selectCancelinClearCall() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.cancelinMCDClearCall, "Select Cancel");
        click(DIMCDPage.cancelinMCDClearCall, "Select Cancel");
    }

    public void selectServiceNotEnroute() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.cancelCallServiceNotEnroute, "Cancel Service Not EnRoute");
        click(DIMCDPage.cancelCallServiceNotEnroute, "Cancel Service Not EnRoute");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectExitCode
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void selectExitCode() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.selectPacesetterCodeJumpStart, "enter Pace setter code information");
        click(DIMCDPage.selectPacesetterCodeJumpStart, "Select select Pacesetter Code Jump Start");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnContinue
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnContinue() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.continueButton, "continue call clearing");
        click(DIMCDPage.continueButton, "click on continue call clearing");
        Thread.sleep(6000);
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickAndEnterBatteryTestedInformation
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickAndEnterBatteryTestedInformation(String odoMeterReading, String comments) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.batteryTestedYes, "battery tested yes");
        click(DIMCDPage.batteryTestedYes, "click on battery tested yes");
        click(DIMCDPage.batteryFailedTestNo, "click on battery failed test NO");
        type(DIMCDPage.odometerReading, odoMeterReading, "ODOMETER Reading");
        type(DIMCDPage.enterComments, comments, "Done a Jump Start");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSubmit
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void clickOnSubmit() throws Throwable {
        Thread.sleep(3000);
        boolean continueButtonVisible = isVisibleOnly(DIMCDPage.continueButton, "Continue Button");
        if (continueButtonVisible) {
            click(DIMCDPage.continueButton, "click on Continue Button");
            waitForVisibilityOfElement(DIMCDPage.enterComments, "Cancelled call QA ");
            type(DIMCDPage.enterComments, "Cancelled call QA ", "Cancelled call QA ");
        }
        boolean submitButtonVisible = isVisibleOnly(DIMCDPage.submitButton, "submit Button");
        if (submitButtonVisible) {
            waitForVisibilityOfElement(DIMCDPage.submitButton, "submit Button");
            click(DIMCDPage.submitButton, "click on submit Button");
            Thread.sleep(10000);
            if (isVisibleOnly(LoginPage.errorAlertOK, "Okay Button")) {
                click(LoginPage.errorAlertOK, "Okay Button");
            }
        }


    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: capturePaceCodeInDispatch
     * description ::
     * date :: 05-Nov-2017
     * author ::
     */
    public void capturePaceCodeInDispatch(String paceSetterCode) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblPaceSetterCodeInMCD, "Pacesetter code in dispatch");
        String pacecodeindispatch = getText(DIMCDPage.lblPaceSetterCodeInMCD, "Pacesetter code in dispatch");
        //assertTrue(pacecodeindispatch.contains(dataBean.getValue(data, "Pacecodeindispatch")), "Excpeted pacesetter code has been displayed in dispacth");
        //assertTrue(pacecodeindispatch.equalsIgnoreCase(dataBean.getValue(data,"Pacecodeindispatch")),"Excpeted pacesetter code has been displayed in dispacth");
        String currentPaceCode[] = pacecodeindispatch.split("-");
        String PaceCodeValue = currentPaceCode[0]; //L302
        String PaceCodeText = currentPaceCode[1]; //No Crank
        //L302 No Crank - Bat Svc (non-AAA Bat)
        String getPaceCode = paceSetterCode;
        assertTrue(PaceCodeValue.contains(getPaceCode), "PaceCode is same");
        assertTrue(PaceCodeText.contains(getPaceCode), getPaceCode + "PaceCode is same");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseCallButton
     * description ::
     * date :: 19-Dec-2017
     * author ::Abhiram Vajrapu
     */
    public void clickOnCloseCallButton() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnCloseCall, "Close Call");
        click(DIMCDPage.btnCloseCall, "Close Call");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseCallButton
     * description ::
     * date :: 19-Dec-2017
     * author ::Abhiram Vajrapu
     */
    public void clickOnPaceSetterResolutionCode() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.selPaceSetterResolutionCode, "Select PaceSetter Resolution Code");
        click(DIMCDPage.selPaceSetterResolutionCode, "Select PaceSetter Resolution Code");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: labelCallCleared
     * description ::
     * date :: 19-Dec-2017
     * author ::Abhiram Vajrapu
     */
    public String labelCallCleared(String StatusUpdateCL) throws Throwable {
        Thread.sleep(70000);
        if (StatusUpdateCL.equalsIgnoreCase("CL")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallClearedStatus, "Call Cleared");
            String callClearedStatus = getText(DIMCDPage.lblCallClearedStatus, "Call Cleared");
            if (callClearedStatus.contains("CL")) {
                reporter.SuccessReport("Call Cleared Status:", "Call Cleared Status Verified");
            } else {
                reporter.failureReport("Call Cleared Status:", "Call Cleared Status Not Verified");
            }
        }
        return StatusUpdateCL;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterReason
     * description ::
     * date :: 20-Dec-2017
     * author ::
     */
    public void enterReason(String reason) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.txtReason, "Enter Reason");
        type(DIMCDPage.txtReason, reason, "Enter Reason");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterReason
     * description ::
     * date :: 20-Dec-2017
     * author ::
     */
    public void clickOnMCDCloseWindow() throws Throwable {
        Thread.sleep(3000);
        isVisibleOnly(DIMCDPage.btnWindowCloseInMCD, "Close MCD Window");
        waitForVisibilityOfElement(DIMCDPage.btnWindowCloseInMCD, "Close MCD Window");
        click(DIMCDPage.btnWindowCloseInMCD, "Close MCD Window");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnUpdate
     * description ::
     * date :: 29-Dec-2017
     * author ::Nidhi
     */
    public void clickOnUpdate() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnUpdateOnStatusUpdate, "Status Update Tab");
        click(DIMCDPage.btnUpdateOnStatusUpdate, "Status Update Tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterReasonOnStatusUpdateTab
     * description ::
     * date :: 29-Dec-2017
     * author ::Nidhi
     */
    public void enterReasonOnStatusUpdateTab(String Class) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtReasonOnStatusUpdate, "reason on status update tab");
        Thread.sleep(3000);
        type(DIMCDPage.txtReasonOnStatusUpdate, Class, "reason on status update tab");
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStatusOnStatusUpdateTab
     * description ::
     * date :: 29-Dec-2017
     * author ::Nidhi
     */

    public void enterStatusOnStatusUpdateTab(String Class) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtStatusOfStatusUpdateInMCD, "reason on status update tab");
        type(DIMCDPage.txtStatusOfStatusUpdateInMCD, Class, "reason on status update tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnStatusUpdateTab
     * description ::
     * date :: 29-Dec-2017
     * author ::Nidhi
     */
    public void clickOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.tabStatusUpdateInMCD, "update button");
        click(DIMCDPage.tabStatusUpdateInMCD, "update button");
    }

    /**
     * description ::TO click on ETA button On MCD Window
     * date :: 29-Dec-2017
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void clickOnETAButtonOnMCDWindow() throws Throwable {
        boolean ETA = isVisibleOnly(DIMCDPage.btnETAinMCD, "ETA Button");
        if (ETA) {
            click(DIMCDPage.btnETAinMCD, "ETA Button");
        } else {
            assertTrue(ETA, "ETA Button is visible");
        }
    }

    /**
     * description ::To set the time for ETA
     * date :: 29-Dec-2017
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void setTimeForETA() throws Throwable {
        boolean setTime = isVisibleOnly(DIMCDPage.setTimeForETA, "Set time for ETA");
        if (setTime) {
            click(DIMCDPage.setTimeForETA, "Set time for ETA");
        } else {
            assertTrue(setTime, "set time for eta is found");
        }
    }

    /**
     * description ::To click on status update Tab on MCD Window
     * date :: 29-Dec-2017
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void clickOnStatusUpdateTabOnMCDWindow() throws Throwable {
        boolean statusUpdateTab = isVisibleOnly(DIMCDPage.tabStatusUpdateInMCD, "Status Update Tab");
        if (statusUpdateTab) {
            click(DIMCDPage.tabStatusUpdateInMCD, "Status Update Tab");
        } else {
            assertTrue(statusUpdateTab, "Status Update Tab is visible");
        }
    }

    /**
     * description ::To enter the status in status update tab on MCD Window
     * date :: 29-Dec-2017
     *
     * @param statusForStatusUpdate
     * @throws Throwable
     * @author: Madhukar
     */
    public void enterStatusInStatusUpdateTab(String statusForStatusUpdate) throws Throwable {
        boolean statusupdate = isVisibleOnly(DIMCDPage.txtStatusOfStatusUpdateInMCD, "status Text box");
        if (statusupdate) {
            click(DIMCDPage.txtStatusOfStatusUpdateInMCD, "status Text box");
            type(DIMCDPage.txtStatusOfStatusUpdateInMCD, statusForStatusUpdate, "Update status in StatusUpdate Tab");
        } else {
            assertTrue(statusupdate, "able to enter status");
        }

    }

    /**
     * description ::To enter Reason in status update tab on MCD Window
     * date :: 29-Dec-2017
     *
     * @param reasonForStatusUpdate
     * @throws Throwable
     */
    public void enterReasonInStatusUpdateTab(String reasonForStatusUpdate) throws Throwable {
        boolean reason = isVisibleOnly(DIMCDPage.txtReasonOfStatusUpdateInMCD, "status Text box");
        if (reason) {
            Thread.sleep(4000);
            click(DIMCDPage.txtReasonOfStatusUpdateInMCD, "Reason in StatusUpdate Tab");
            Thread.sleep(2000);
            type(DIMCDPage.txtReasonOfStatusUpdateInMCD, reasonForStatusUpdate, "Reason in StatusUpdate Tab");
            Thread.sleep(4000);

        } else {
            assertTrue(reason, "able to enter status");
        }

    }

    /**
     * Description:To click on update button of Status Update button on Profile window
     * date:29-12-2017
     *
     * @throws Throwable
     * @author: Madhukar
     */
    public void clickOnUpdateButtonInStatusUpdateTab() throws Throwable {
        boolean update = isVisibleOnly(DIMCDPage.btnUpdateOfStatusUpdateTabInMCD, "Update Button");
        if (update) {
            click(DIMCDPage.btnUpdateOfStatusUpdateTabInMCD, "Update Button");
        } else {
            assertTrue(update, "Update Button visible");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectFacilityOnAssignTabInMCD
     * description ::
     * date :: 01-Jan-2018
     * author ::Nidhi
     */
    public void selectFacilityOnAssignTabInMCD() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.selectFacilityOnAssignTabInMCD, "Select Facility");
        click(DIMCDPage.selectFacilityOnAssignTabInMCD, "Select facility");
    }

    /**
     * Description:This method is used to select second facility on Assign tab
     * Date:03-01-2018
     *
     * @throws Throwable
     * @author : Madhukar
     */
    public void selectSecondFacilityOnAssignTabInMCD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.selectSecondFacilityOnAssignTabInMCD, "select facility");
        boolean facility = isVisibleOnly(DIMCDPage.selectSecondFacilityOnAssignTabInMCD, "select facility");
        if (facility) {
            click(DIMCDPage.selectSecondFacilityOnAssignTabInMCD, "select facility");
        } else {
            assertTrue(facility, "facility is available");
        }
    }

    /**
     * Description:This method is used to select second facility on Dispatch tab
     * Date:03-01-2018
     *
     * @throws Throwable
     * @author : Madhukar
     */
    public void selectSecondFacilityOnDispatchTabInMCD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.selectSecondFacilityOnDispatchTabInMCD, "select facility");
        boolean facility = isVisibleOnly(DIMCDPage.selectSecondFacilityOnDispatchTabInMCD, "select facility");
        if (facility) {
            click(DIMCDPage.selectSecondFacilityOnDispatchTabInMCD, "select facility");
        } else {
            assertTrue(facility, "facility is available");
        }
    }

    /**
     * description ::To enter Reason in status update tab on MCD Window
     * date ::  03-Jan-2018
     * author ::Nidhi
     *
     * @param reasonForRedFlagStatusUpdate
     * @throws Throwable
     */
    public void enterReasonForRedFlagInStatusUpdateTab(String reasonForRedFlagStatusUpdate) throws Throwable {
        boolean reason = isVisibleOnly(DIMCDPage.txtReasonOfStatusUpdateInMCD, "status Text box");
        if (reason) {
            click(DIMCDPage.txtReasonOfStatusUpdateInMCD, "Reason in StatusUpdate Tab");
            type(DIMCDPage.txtReasonOfStatusUpdateInMCD, reasonForRedFlagStatusUpdate, "Reason in StatusUpdate Tab");
        } else {
            assertTrue(reason, "able to enter status");
        }

    }

    /**
     * Description:This method is used to verify Member FirstName On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberFirstNameOnSummaryTab() throws Throwable {
        boolean firstName = isVisibleOnly(DIMCDPage.lblMemberFirstNameOnSummaryTabinMCD, "Member First Name");
        return firstName;
    }

    /**
     * Description:This method is used to verify Member LastName On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberLastNameOnSummaryTab() throws Throwable {
        boolean lastName = isVisibleOnly(DIMCDPage.lblMemberLastNameOnSummaryTabinMCD, "Member Last Name");
        return lastName;
    }

    /**
     * Description:This method is used to verify Member Number On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberNumberOnSummaryTab() throws Throwable {
        boolean memberNumber = isVisibleOnly(DIMCDPage.lblMemberNumberOnSummaryTabinMCD, "Member Number");
        return memberNumber;
    }

    /**
     * Description:This method is used to verify Member Address On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberAddressOnSummaryTab() throws Throwable {
        boolean memberAddress = isVisibleOnly(DIMCDPage.lblMemberAddressOnSummaryTabinMCD, "Member Address");
        return memberAddress;
    }

    /**
     * Description:This method is used to verify Member City On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberCityOnSummaryTab() throws Throwable {
        boolean memberCity = isVisibleOnly(DIMCDPage.lblMemberCityOnSummaryTabinMCD, "Member City");
        return memberCity;
    }

    /**
     * Description:This method is used to verify Member state On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberStateOnSummaryTab() throws Throwable {
        boolean memberState = isVisibleOnly(DIMCDPage.lblMemberStateOnSummaryTabinMCD, "Member State");
        return memberState;
    }

    /**
     * Description:This method is used to verify Member Zip On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberZipOnSummaryTab() throws Throwable {
        boolean memberZip = isVisibleOnly(DIMCDPage.lblMemberZipOnSummaryTabinMCD, "Member Zip");
        return memberZip;
    }

    /**
     * Description:This method is used to verify BreakDown location On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyBreakDownLocationOnSummaryTab() throws Throwable {
        boolean breakdwnLoc = isVisibleOnly(DIMCDPage.lblBreakdownAddressLocationOnSummaryTabinMCD, "BreakDown Location");
        return breakdwnLoc;
    }

    /**
     * Description:This method is used to verify vehicle year On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyVehicleYearOnSummaryTab() throws Throwable {
        boolean year = isVisibleOnly(DIMCDPage.lblVehicleYearOnSummaryTabinMCD, "Vehicle year");
        return year;
    }

    /**
     * Description:This method is used to verify vehicle make On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyVehicleMakeOnSummaryTab() throws Throwable {
        boolean make = isVisibleOnly(DIMCDPage.lblVehicleMakeOnSummaryTabinMCD, "Vehicle Make");
        return make;
    }


    /**
     * Description:This method is used to verify vehicle Model On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyVehicleModelOnSummaryTab() throws Throwable {
        boolean model = isVisibleOnly(DIMCDPage.lblVehicleModelOnSummaryTabinMCD, "Vehicle Model");
        return model;
    }

    /**
     * Description:This method is used to verify vehicle Color On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyVehicleColorOnSummaryTab() throws Throwable {
        boolean color = isVisibleOnly(DIMCDPage.lblVehicleColorOnSummaryTabinMCD, "Vehicle Color");
        return color;
    }

    /**
     * Description:This method is used to verify Pacesetter code  On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyPaceSetterCodeOnSummaryTab() throws Throwable {
        boolean pacesetter = isVisibleOnly(DIMCDPage.lblPaceSetterCodeOnSummaryTabinMCD, "Pacesetter Code");
        return pacesetter;
    }


    /**
     * Description:This method is used to verify Trouble Code On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyTroubleCodeOnSummaryTab() throws Throwable {
        boolean troubleCode = isVisibleOnly(DIMCDPage.lblTroubleCodeOnSummaryTabinMCD, "Trouble Code");
        return troubleCode;
    }

    /**
     * Description:This method is used to verify Function Code On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyFunctionCodeOnSummaryTab() throws Throwable {
        boolean functionCode = isVisibleOnly(DIMCDPage.lblFunctionCodeOnSummaryTabinMCD, "Function Code");
        return functionCode;
    }

    /**
     * Description:This method is used to verify Faclity Id and Name On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyFaclityIdandNameOnSummaryTab() throws Throwable {
        boolean faclity = isVisibleOnly(DIMCDPage.lblFacilityIdAndNameOnSummaryTabinMCD, "facility name and id");
        return faclity;
    }

    /**
     * Description:This method is used to verify Truck load button On SummaryTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyTruckLoadButtonOnSummaryTab() throws Throwable {
        boolean truckLoad = isVisibleOnly(DIMCDPage.btnTruckLoadOnSummaryTabinMCD, "truck load button");
        return truckLoad;
    }

    /**
     * Description:This method is used to on Member Tab In MCD Window
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public void clickOnMemberTabInMCDWindow() throws Throwable {
        boolean memberTab = isVisibleOnly(DIMCDPage.lnkMemberTabinMCD, "Member Tab");
        if (memberTab) {
            click(DIMCDPage.lnkMemberTabinMCD, "Member Tab");
        } else {
            assertTrue(memberTab, "member tab is found");
        }
    }

    /**
     * Description:This method is used to verify Member Number on Member tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberNumberOnMemberTab() throws Throwable {
        boolean memberNumber = isVisibleOnly(DIMCDPage.lblMemberNumberOnMemberTabinMCD, "Member Number");
        return memberNumber;
    }

    /**
     * Description:This method is used to verify Member First Name on Member tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberFirstNameOnMemberTab() throws Throwable {
        boolean firstName = isVisibleOnly(DIMCDPage.lblMemberFirstNameOnMemberTabinMCD, "Member First Name");
        return firstName;
    }

    /**
     * Description:This method is used to verify Member Last Name on Member tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberLastNameOnMemberTab() throws Throwable {
        boolean lastName = isVisibleOnly(DIMCDPage.lblMemberLastNameOnMemberTabinMCD, "Member Last Name");
        return lastName;
    }

    /**
     * Description:This method is used to verify Member Address on Member tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberAddressOnMemberTab() throws Throwable {
        boolean address = isVisibleOnly(DIMCDPage.lblMemberAddressOnMemberTabinMCD, "Member Address");
        return address;
    }

    /**
     * Description:This method is used to verify Member Level on Member tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberLevelOnMemberTab() throws Throwable {
        boolean level = isVisibleOnly(DIMCDPage.lblMemberLevelOnMemberTabinMCD, "Level");
        return level;
    }

    /**
     * Description:This method is used to verify Member status on Member tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberStatusOnMemberTab() throws Throwable {
        boolean status = isVisibleOnly(DIMCDPage.lblMemberStatusOnMemberTabinMCD, "Status");
        return status;
    }

    /**
     * Description:This method is used to verify Expiration on Member tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberExpirationOnMemberTab() throws Throwable {
        boolean expiration = isVisibleOnly(DIMCDPage.lblMemberExpirationDateOnMemberTabinMCD, "Expiration");
        return expiration;
    }

    /**
     * Description:This method is used to verify Calls Used on Member tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberCallsUsedOnMemberTab() throws Throwable {
        boolean callsUsed = isVisibleOnly(DIMCDPage.lblMemberCallsUsedOnMemberTabinMCD, "Calls Used");
        return callsUsed;
    }

    /**
     * Description:This method is used to verify Calls Allowed on Member tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberCallsAllowedOnMemberTab() throws Throwable {
        boolean callsAllowed = isVisibleOnly(DIMCDPage.lblMemberCallsAllowedOnMemberTabinMCD, "Calls Allowed");
        return callsAllowed;
    }

    /**
     * Description:This method is used to verify Long Tow is  Allowed on Member tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyLongTowAllowedOnMemberTab() throws Throwable {
        boolean towAllowed = isVisibleOnly(DIMCDPage.lblLongTowAllowedOnMemberTabinMCD, "Long Tow Allowed");
        return towAllowed;
    }

    /**
     * Description:This method is used to verify Phone Number on Member tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberPhoneNumberOnMemberTab() throws Throwable {
        boolean phoneNo = isVisibleOnly(DIMCDPage.lblMemberPhoneNumberOnMemberTabinMCD, "Phone Number");
        return phoneNo;
    }


    /**
     * Description:This method is used to on Service Tab In MCD Window
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public void clickOnServiceTabInMCDWindow() throws Throwable {
        boolean memberTab = isVisibleOnly(DIMCDPage.lnkServiceTabinMCD, "Service Tab");
        if (memberTab) {
            click(DIMCDPage.lnkServiceTabinMCD, "Service Tab");
        } else {
            assertTrue(memberTab, "Service tab is found");
        }
    }

    /**
     * Description:This method is used to verify PaceSetter code on service tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyPacesetterCodeOnServiceTab() throws Throwable {
        boolean pacesetterCode = isVisibleOnly(DIMCDPage.lblPaceSetterCodeOnServiceTabinMCD, "Pacesetter Code");
        return pacesetterCode;
    }

    /**
     * Description:This method is used to verify Trouble code on service tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyTroubleCodeOnServiceTab() throws Throwable {
        boolean troubleCode = isVisibleOnly(DIMCDPage.lblTroubleCodeOnServiceTabinMCD, "Trouble Code");
        return troubleCode;
    }

    /**
     * Description:This method is used to verify Sevice Type Info on service tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyServiceTypeinfoOnServiceTab() throws Throwable {
        boolean serviceType = isVisibleOnly(DIMCDPage.lblServiceTypeInfoOnServiceTabinMCD, "Sevice Type Info");
        return serviceType;
    }

    /**
     * Description:This method is used to verify Facility Name And number On ServiceTab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyFacilityNameAndnumberOnServiceTab() throws Throwable {
        boolean facilityNameAndNumber = isVisibleOnly(DIMCDPage.lblFacilityNameAndNumberOnServiceTabinMCD, "Facility Name And Number");
        return facilityNameAndNumber;
    }

    /**
     * Description:This method is used to verify ShowBatteryServiceHistory Button On Service Tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyShowBatteryServiceHistoryButtonOnServiceTab() throws Throwable {
        boolean batteryService = isVisibleOnly(DIMCDPage.btnShowBatteryServiceHistory, "Battery Service history button");
        return batteryService;
    }

    /**
     * Description:This method is used to on Locations Tab In MCD Window
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public void clickOnLocationsTabInMCDWindow() throws Throwable {
        boolean locationsTab = isVisibleOnly(DIMCDPage.lnkLocationsTabinMCD, "Locations Tab");
        if (locationsTab) {
            click(DIMCDPage.lnkLocationsTabinMCD, "Locations Tab");
        } else {
            assertFalse(locationsTab, "Locations tab is not found");
        }
    }

    /**
     * Description:This method is used to verify BreakDown Location On Service Tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyBreakDownLocationOnLocationsTab() throws Throwable {
        boolean breakDownLoc = isVisibleOnly(DIMCDPage.lblBreakDownLocationOnLocationsTabinMCD, "BreakDown Location");
        return breakDownLoc;
    }

    /**
     * Description:This method is used to verify Tow Destination On Service Tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyTowDestinationOnLocationsTab() throws Throwable {
        boolean towdestination = isVisibleOnly(DIMCDPage.lblTowDestinationOnLocationsTabinMCD, "Tow Destination ");
        return towdestination;
    }

    /**
     * Description:This method is used to on Vehicle Tab In MCD Window
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public void clickOnVehicleTabInMCDWindow() throws Throwable {
        boolean locationsTab = isVisibleOnly(DIMCDPage.lnkVehicleTabinMCD, "Vehicle Tab");
        if (locationsTab) {
            click(DIMCDPage.lnkVehicleTabinMCD, "Vehicle Tab");
        } else {
            assertTrue(locationsTab, "Vehicle tab is found");
        }
    }

    /**
     * Description:This method is used to verify vehicle type on vehicle tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyVehicleTypeOnVehicleTab() throws Throwable {
        boolean type = isVisibleOnly(DIMCDPage.lblVehicleTypeOnVehicleTabinMCD, "Vehicle Type");
        return type;
    }

    /**
     * Description:This method is used to verify vehicle year on vehicle tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyVehicleYearOnVehicleTab() throws Throwable {
        boolean year = isVisibleOnly(DIMCDPage.lblVehicleYearOnVehicleTabinMCD, "Vehicle year");
        return year;
    }

    /**
     * Description:This method is used to verify vehicle make on vehicle tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyVehicleMakeOnVehicleTab() throws Throwable {
        boolean make = isVisibleOnly(DIMCDPage.lblVehicleMakeOnVehicleTabinMCD, "Vehicle make");
        return make;
    }

    /**
     * Description:This method is used to verify vehicle model on vehicle tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyVehicleModelOnVehicleTab() throws Throwable {
        boolean make = isVisibleOnly(DIMCDPage.lblVehicleModelOnVehicleTabinMCD, "Vehicle model");
        return make;
    }

    /**
     * Description:This method is used to verify vehicle color on vehicle tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyVehicleColorOnVehicleTab() throws Throwable {
        boolean make = isVisibleOnly(DIMCDPage.lblVehicleColorOnVehicleTabinMCD, "Vehicle Color");
        return make;
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSP
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnSP() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnSPOnMCDWindow, "Clicked on SP button");
        click(DIMCDPage.btnSPOnMCDWindow, "Clicked on SP button");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTW
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnTW() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnTWOnMCDWindow, "Clicked on TW button");
        click(DIMCDPage.btnTWOnMCDWindow, "Clicked on TW button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMemberHome
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnMemberHome() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnMemberHomeOnMCDWindow, "Clicked on Member Home button");
        click(DIMCDPage.btnMemberHomeOnMCDWindow, "Clicked on Member Home button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnNoTowPerformed
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnNoTowPerformed() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnNoTowPerformedOnMCDWindow, "Clicked on No Tow Performed button");
        click(DIMCDPage.btnNoTowPerformedOnMCDWindow, "Clicked on No Tow Performed button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRepairFacility
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnRepairFacility() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnRepairFacilityOnMCDWindow, "Clicked on Repair Facility button");
        click(DIMCDPage.btnRepairFacilityOnMCDWindow, "Clicked on Repair Facility button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRepairFacility
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnOtherLocation() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnOtherLocationOnMCDWindow, "Clicked on Other Location button");
        click(DIMCDPage.btnOtherLocationOnMCDWindow, "Clicked on Other Location button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRepairFacility
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnOriginalTowDestination() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnOriginalTowDestinationOnMCDWindow, "Clicked on Original Tow Destination button");
        click(DIMCDPage.btnOriginalTowDestinationOnMCDWindow, "Clicked on Original Tow Destination button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnNoGo
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnNoGo() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnNOGOOnMCDWindow, "Clearing Screen");
        click(DIMCDPage.btnNOGOOnMCDWindow, "Clicked on No Go button");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnNoGo
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnNoService() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnNOServiceOnMCDWindow, "Clicked on No Service button");
        click(DIMCDPage.btnNOServiceOnMCDWindow, "Clicked on No Service button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSubmitButton
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnSubmitButton() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.submitButton, "submit Button");
        click(DIMCDPage.submitButton, "click on submit Button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCommentsOnMCDWindow
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */

    public void enterCommentsOnMCDWindow(String comments) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCommentOnMCDWindow, "Comments entered");
        type(DIMCDPage.txtCommentOnMCDWindow, comments, "Comments entered");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterAddressOnMCDWindow
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */

    public void enterAddressOnMCDWindow(String address) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtAddressOnMCDWindow, "Address entered");
        type(DIMCDPage.txtAddressOnMCDWindow, address, "Address entered");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchIcon
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnSearchIcon() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.iconSearchAddressOnMCDWindow, "Clicked on Search Icon");
        click(DIMCDPage.iconSearchAddressOnMCDWindow, "Clicked on Search Icon");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFirstLinkOnAddress
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public void clickOnFirstLinkOnAddress() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.lnkClickOnFirstLink, "Clicked on First Link");
        click(DIMCDPage.lnkClickOnFirstLink, "Clicked on First Link");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallSpottedStatus
     * description ::
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public String lblCallSpottedStatus() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblCallSpottedStatus, "Call Spotted Status is available");
        String spottedStatus = getText(DIMCDPage.lblCallSpottedStatus, "Call Spotted Status is available");
        if (spottedStatus.contains("SP")) {
            reporter.SuccessReport("Spotted Status:", "Spotted Status Verified");
        } else {
            reporter.failureReport("Spotted Status:", "Spotted Status Not Verified");
        }
        return spottedStatus;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallAssignedStatus
     * description ::
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public String lblCallAssignedStatus(String StatusUpdateAS) throws Throwable {
        Thread.sleep(30000);
        if (StatusUpdateAS.equalsIgnoreCase("AS")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallAssignedStatus, "Call Assigned Status is available");
            String assignStatus = getText(DIMCDPage.lblCallAssignedStatus, "Call Assigned Status is available");
            if (assignStatus.contains("AS")) {
                reporter.SuccessReport("Assign Status:", "Assign Status Verified");
            } else {
                reporter.failureReport("Assign Status:", "Assign Status Not Verified");
            }
        }
        return StatusUpdateAS;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallDispatchedStatus
     * description ::
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public String lblCallDispatchedStatus(String StatusUpdateDI) throws Throwable {
        Thread.sleep(30000);
        if (StatusUpdateDI.equalsIgnoreCase("DI")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallDispatchedStatus, "Call Dispatched Status is available");
            String dispatchedStatus = getText(DIMCDPage.lblCallDispatchedStatus, "Call Dispatched Status is available");
            if (dispatchedStatus.contains("DI")) {
                reporter.SuccessReport("Dispatched Status:", "Dispatched Status Verified");
            } else {
                reporter.failureReport("Dispatched Status:", "Dispatched Status Not Verified");
            }
        }
        return StatusUpdateDI;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallENRouteStatus
     * description ::
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public String lblCallENRouteStatus(String StatusUpdateER) throws Throwable {
        Thread.sleep(30000);
        if (StatusUpdateER.equalsIgnoreCase("ER")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallENRouteStatus, "Call EN-Route Status is available");
            String enRouteStatus = getText(DIMCDPage.lblCallENRouteStatus, "Call EN-Route Status is available");
            if (enRouteStatus.contains("ER")) {
                reporter.SuccessReport("En Route Status:", "En Route Status Verified");
            } else {
                reporter.failureReport("En Route Status:", "En Route Status Not Verified");
            }
        }
        return StatusUpdateER;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallOnLocationStatus
     * description ::
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */

    public String lblCallOnLocationStatus(String StatusUpdateOL) throws Throwable {
        Thread.sleep(30000);
        if (StatusUpdateOL.equalsIgnoreCase("OL")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallOnLocationStatus, "Call On-Location Status is available");
            String onLocationStatus = getText(DIMCDPage.lblCallOnLocationStatus, "Call On-Location Status is available");
            if (onLocationStatus.contains("OL")) {
                reporter.SuccessReport("On Location Status:", "On Location Status Verified");
            } else {
                reporter.failureReport("On Location Status:", "On Location Status Not Verified");
            }
        }
        return StatusUpdateOL;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallTowStatus
     * description ::
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public String lblCallTowStatus(String StatusUpdateTW) throws Throwable {
        Thread.sleep(40000);
        if (StatusUpdateTW.equalsIgnoreCase("TW")) {
            waitForVisibilityOfElement(DIMCDPage.lblCallTowStatus, "Call Tow Status is available");
            String towStatus = getText(DIMCDPage.lblCallTowStatus, "Call Tow Status is available");
            if (towStatus.contains("TW")) {
                reporter.SuccessReport("Tow Status:", "Tow Status Verified");
            } else {
                reporter.failureReport("Tow Status:", "Tow Status Not Verified");
            }
        }
        return StatusUpdateTW;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterfacilityOnStatusUpdateWindow
     * description ::
     * date :: 17-Jan-2018
     * author :: Abhiram
     */

    public void enterfacilityOnStatusUpdateWindow(String reSpotFacilityID) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtFacilityInStautusUpdateWindow, "Spot Facility entered");
        type(DIMCDPage.txtFacilityInStautusUpdateWindow, reSpotFacilityID, "Spot Facility entered");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropDownOnFacilityOnStatusUpdateWindow
     * description ::
     * date :: 17-Jan-2018
     * author ::Abhiram
     */
    public void clickOnDropDownOnFacilityOnStatusUpdateWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.dropDownFacilityInStautusUpdateWindow, "Clicked on Facility");
        click(DIMCDPage.dropDownFacilityInStautusUpdateWindow, "Clicked on Facility");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: dropDownReasonInStautusUpdateWindow
     * description ::
     * date :: 17-Jan-2018
     * author ::Abhiram
     */
    public void dropDownReasonInStautusUpdateWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.dropDownReasonInStautusUpdateWindow, "Clicked on Reason");
        click(DIMCDPage.dropDownReasonInStautusUpdateWindow, "Clicked on Reason");
    }

    /**
     * Description:This method is used to verify Function Code On ServiceTab
     * date ::  18-Jan-2018
     *
     * @return
     * @throws Throwable
     * @author :Madhukar
     */
    public boolean verifyFunctionCodeOnServiceTab() throws Throwable {
        boolean functionCode = isVisibleOnly(DIMCDPage.lblFunctionCodeOnServiceTabinMCD, "FunctionCode");
        return functionCode;
    }

    /**
     * Description:This method is used to TruckLoad Button On ServiceTab
     * date ::  18-Jan-2018
     *
     * @return
     * @throws Throwable
     * @author :Madhukar
     */
    public boolean verifyTruckLoadButtonOnServiceTab() throws Throwable {
        boolean truckLoadButton = isVisibleOnly(DIMCDPage.btnTruckLoadOnServiceTabinMCD, "Truck Load Button");
        return truckLoadButton;
    }

    /**
     * Description:This method is used to LongTowUsed On MemberTab
     * date ::  18-Jan-2018
     *
     * @return
     * @throws Throwable
     * @author :Madhukar
     */
    public boolean verifyLongTowUsedOnMemberTab() throws Throwable {
        boolean longTowUsed = isVisibleOnly(DIMCDPage.lblLongTowUsedOnMemberTabinMCD, "LongTowUsed");
        return longTowUsed;
    }

    /**
     * Description:This method is used to DOB On MemberTab
     * date ::  18-Jan-2018
     *
     * @return
     * @throws Throwable
     * @author :Madhukar
     */
    public boolean verifyDOBOnMemberTab() throws Throwable {
        boolean dOB = isVisibleOnly(DIMCDPage.lblDOBOnMemberTabinMCD, "DOB On MemberTab");
        return dOB;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: splitFacilityNameAndNumberOnServiceTabinDIMCD
     * description ::
     * date :: 16-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public String splitFacilityNameAndNumberOnServiceTabinDIMCD() throws Throwable {

        String facilityNameAndFacilityNumber = getText(DIMCDPage.lblFacilityNameAndNumberOnServiceTabinDIMCD, "Facility Name and ID is available");
        String currentPaceCode[] = facilityNameAndFacilityNumber.split("-");
        String facilityName = currentPaceCode[0]; //facilityname
        String facilityNumber = currentPaceCode[1]; //facilitynumber
        return facilityNumber;
    }

    /**
     * Description:This method is used to verify Language preference on Member tab
     * date ::  18-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyLanguagepreferenceOnMemberTab() throws Throwable {
        boolean languagePreference = isVisibleOnly(DIMCDPage.lblLanguagePreferenceOnMemberTabinMCD, "Language preference");
        return languagePreference;
    }

    /**
     * Description:This method is used to verify ETA Time on MCD window
     * Date:19-01-2018
     *
     * @return
     * @throws Throwable
     */
    public String verifyETATimeOnMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblETATimeOnMCDWindow, "ETA Time on MCD Page");
        String etaTimeAndDate = getText(DIMCDPage.lblETATimeOnMCDWindow, "ETA Time on MCD Page");
        String etaTime = etaTimeAndDate.substring(11, 16);
        return etaTime;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validateComentsInMCDWindow
     * description :: This method validates the comments in MCD wndow
     * date :: 20-Dec-2018
     * author :: Sachin
     */

    public void validateComentsInMCDWindow(String comments) throws Throwable {
        CommentsMCDWindow = getWebElementList(DIMCDPage.lblCommentsInMCDWindow, "Comments MCD Window");
        if (CommentsMCDWindow != null) {
            boolean flow = true;
            String commentsCol = "";
            for (int i = 0; i <= CommentsMCDWindow.size() - 1; i++) {
                commentsCol = CommentsMCDWindow.get(i).getText().toString();

                boolean existsVal = commentsCol.equalsIgnoreCase(comments);

                if (existsVal) {
                    assertTrue(commentsCol.equalsIgnoreCase(comments), "Comments entered displayed in MCD window" + commentsCol);
                    flow = false;
                    break;
                }
            }
            if (flow) {
                assertTrue(false, "Comments entered not displayed in MCD window" + commentsCol);
            }
        }
    }

    /**
     * Description:This method is used to verify Member Level on Member tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberTypeOnMemberTab() throws Throwable {
        boolean type = isVisibleOnly(DIMCDPage.lblMemberTypeOnMemberTabinMCD, "Type");
        return type;
    }

    /**
     * * param :: NA
     * * return ::boolean
     * * throws :: throwable
     * * methodName :: verifyAddressAvailableInTowDestination
     * * description ::
     * * retrivedTime :: 22-Jan-2018
     * * author :: Abhiram
     */
    public boolean verifyAddressAvailableForOtherLocationInMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtMessageNoDataAvailableForOtherLocationInMCDWindow, "Existing Address are Not Visible in MCD Window");
        boolean mcdWindowAddressAvailable = isVisibleOnly(DIMCDPage.txtMessageNoDataAvailableForOtherLocationInMCDWindow, "Existing Address are Not Visible in MCD Window");
        return mcdWindowAddressAvailable;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnEnterAddressManuallyForOtherLocationInMCDWindow
     * description ::
     * date :: 23-Jan-2018
     * author ::Abhiram
     */
    public void clickOnEnterAddressManuallyForOtherLocationInMCDWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.linkEnterAddreddManuallyForOttherLocationInMCDWindow, "Clicked on Enter Address Manually");
        click(DIMCDPage.linkEnterAddreddManuallyForOttherLocationInMCDWindow, "Clicked on Enter Address Manually");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCrossStreet1ForOtherLocationInMCDWindow
     * description ::
     * date :: 23-Jan-2018
     * author :: Abhiram
     */

    public void enterCrossStreet1ForOtherLocationInMCDWindow(String crossStreet1) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtEnterCrossStreeet1ForOtherLocationInMCDWindow, "cross Street 1 entered");
        type(DIMCDPage.txtEnterCrossStreeet1ForOtherLocationInMCDWindow, crossStreet1, "cross Street 1 entered");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCrossStreet2ForOtherLocationInMCDWindow
     * description ::
     * date :: 23-Jan-2018
     * author :: Abhiram
     */

    public void enterCrossStreet2ForOtherLocationInMCDWindow(String crossStreet2) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtEnterCrossStreeet2ForOtherLocationInMCDWindow, "cross Street 2 entered");
        type(DIMCDPage.txtEnterCrossStreeet2ForOtherLocationInMCDWindow, crossStreet2, "cross Street 2 entered");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLocationForOtherLocationInMCDWindow
     * description ::
     * date :: 23-Jan-2018
     * author :: Abhiram
     */

    public void enterLocationForOtherLocationInMCDWindow(String location) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtEnterLocationForOtherLocationInMCDWindow, "Location entered");
        type(DIMCDPage.txtEnterLocationForOtherLocationInMCDWindow, location, "Location entered");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCityForOtherLocationInMCDWindow
     * description ::
     * date :: 23-Jan-2018
     * author :: Abhiram
     */

    public void enterCityForOtherLocationInMCDWindow(String city) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtEnterCityForOtherLocationInMCDWindow, "City entered");
        type(DIMCDPage.txtEnterCityForOtherLocationInMCDWindow, city, "City entered");
    }

    /**
     * Description:This method is used to verify vehicle color on vehicle tab
     * date ::  11-Jan-2018
     *
     * @return
     * @throws Throwable
     */
    public boolean verifyBatteryQuestionnaireInMCDWindow() throws Throwable {
        boolean batteryQuestionnaire = isVisibleOnly(DIMCDPage.lblBatteryQuestionnaireInMCDWindow, "Battery Questionnaire");
        return batteryQuestionnaire;
    }

    /**
     * Description:This method is used to verify Status update dropdown on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyDropDownButtonOfStatusOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.drpdwnStatusOnStatusUpdateTabInMCDWindow, "Status Drop Down On Status Update Tab");
        boolean statusDropDown = isVisibleOnly(DIMCDPage.drpdwnStatusOnStatusUpdateTabInMCDWindow, "Status Drop Down On Status Update Tab");
        return statusDropDown;
    }

    /**
     * Description:This method is used to verify Reason textbox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyReasonTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtReasonOfStatusUpdateInMCD, "Reason On Status Update Tab");
        boolean reason = isVisibleOnly(DIMCDPage.txtReasonOfStatusUpdateInMCD, "Reason On Status Update Tab");
        return reason;
    }

    /**
     * Description:This method is used to verify Facility TextBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyFacilityTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtFacilityInStautusUpdateWindow, "Facility On Status Update Tab");
        boolean Facility = isVisibleOnly(DIMCDPage.txtFacilityInStautusUpdateWindow, "Facility On Status Update Tab");
        return Facility;
    }

    /**
     * Description:This method is used to verify truck textBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyTruckTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtTruckInStautusUpdateTab, "Truck On Status Update Tab");
        boolean Truck = isVisibleOnly(DIMCDPage.txtTruckInStautusUpdateTab, "Truck On Status Update Tab");
        return Truck;
    }

    /**
     * Description:This method is used to verify Zone textBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyZoneTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtZoneInStautusUpdateTab, "Zone On Status Update Tab");
        boolean Zone = isVisibleOnly(DIMCDPage.txtZoneInStautusUpdateTab, "Zone On Status Update Tab");
        return Zone;
    }

    /**
     * Description:This method is used to verify Tech textBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyTechTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtTechInStautusUpdateTab, "Tech On Status Update Tab");
        boolean Tech = isVisibleOnly(DIMCDPage.txtTechInStautusUpdateTab, "Tech On Status Update Tab");
        return Tech;
    }

    /**
     * Description:This method is used to verify ETA textBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyETATextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtETAInStautusUpdateTab, "ETA On Status Update Tab");
        boolean ETA = isVisibleOnly(DIMCDPage.txtETAInStautusUpdateTab, "ETA On Status Update Tab");
        return ETA;
    }

    /**
     * Description:This method is used to verify Date textBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyDateTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtDateInStautusUpdateTab, "Date Field On Status Update Tab");
        boolean Date = isVisibleOnly(DIMCDPage.txtDateInStautusUpdateTab, "Date Field Status Update Tab");
        return Date;
    }

    /**
     * Description:This method is used to verify Time textBox on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyTimeTextBoxOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtTimeInStautusUpdateTab, "Time On Status Update Tab");
        boolean time = isVisibleOnly(DIMCDPage.txtTimeInStautusUpdateTab, "Time On Status Update Tab");
        return time;
    }

    /**
     * Description:This method is used to verify comments field on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyCommentsOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCommentsInStautusUpdateTab, "Comments On Status Update Tab");
        boolean comments = isVisibleOnly(DIMCDPage.txtCommentsInStautusUpdateTab, "Comments On Status Update Tab");
        return comments;
    }

    /**
     * Description:This method is used to verify cancel button on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyCancelButtoOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnCancelOfStatusUpdateTabInMCD, "Cancel Button On Status Update Tab");
        boolean cancelButton = isVisibleOnly(DIMCDPage.btnCancelOfStatusUpdateTabInMCD, "Cancel Button On Status Update Tab");
        return cancelButton;
    }

    /**
     * Description:This method is used to verify update button on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyUpdateButtoOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnUpdateOfStatusUpdateTabInMCD, "Update Button On Status Update Tab");
        boolean Update = isVisibleOnly(DIMCDPage.btnUpdateOfStatusUpdateTabInMCD, "Update Button On Status Update Tab");
        return Update;
    }
    /**
     * Description:This method is used to click on status dropdown on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public void clickOnStatusDropdownOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.drpdwnStatusOnStatusUpdateTabInMCDWindow, "Status Dropdown Button and List Of Status Update Codes are available");
        click(DIMCDPage.drpdwnStatusOnStatusUpdateTabInMCDWindow, "Status Dropdown Button and List Of Status Update Codes are available");
    }

    /**
     * Description:This method is used to click on Reason dropdown on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public void clickOnReasonDropdownOnStatusUpdateTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtReasonOnStatusUpdate, "Reason TextBox");
        click(DIMCDPage.txtReasonOnStatusUpdate, "Reason TextBox");
        click(DIMCDPage.drpdwnReasonOnStatusUpdateTabInMCDWindow, "Reason Dropdown and List of Reason Codes are available");
    }

    /**
     * Description:This method is used to get call status on MCD window
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public String getCallStatusOnMCDwindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblCallStatusOnMCDWindow, "Call Status");
        String status = getText(DIMCDPage.lblCallStatusOnMCDWindow, "Call Status");
        return status;
    }

    /**
     * Description:This method is used to  verify No Truck Error Message on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public void verifyNoTruckErrorMessage() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.noTruckErrorText, "No Truck Error Message");
        getText(DIMCDPage.noTruckErrorText, "No Truck Error Message");
        click(DIMCDPage.btnOKForNoTruckError, "OK Button For No Truck Error Message");
    }
    /**
     * Description:This method is used to enter TruckID on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public void enterTruckIDOnStatusUpdateTab(String truckID) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtTruckInStautusUpdateTab, "Truck ID");
        type(DIMCDPage.txtTruckInStautusUpdateTab, truckID, "Truck ID");
    }
    /**
     * Description:This method is used to verify reason dropdown is grayed out on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyReasonDropdownIsGrayedOutOnStatusTab() throws Throwable {
        click(DIMCDPage.txtReasonOnStatusUpdate,"Reason TextBox");
        boolean reasonDrpDwn = isElementPresent(DIMCDPage.drpdwnReasonGrayedOnStatusUpdateTabInMCDWindow, "Reason dropdown is Grayed out");
        return reasonDrpDwn;
    }
    /**
     * Description:This method is used to verify ETA Alert text on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public boolean verifyETAAlertOnStatusTab() throws Throwable {
        boolean etaAlert = isElementPresent(DIMCDPage.txtETAFieldAlert, "ETA Mandatory Field Alert");
        return etaAlert;
    }
    /**
     * Description:This method is used to enter ETA time on Status Update Tab
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public void enterETATimeOnStatusUpdateTab(String eta)throws Throwable{
        waitForVisibilityOfElement(DIMCDPage.txtETAInStautusUpdateTab, "ETA On Status Update Tab");
        type(DIMCDPage.txtETAInStautusUpdateTab,eta,"ETA On Status Update Tab");

    }

    /**
     * Description:This method is used to verify whether ETA Time is Updated on MCD Window
     * Date:29-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public void verifyETAIsUpdatedOnMCDWindow()throws Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblETATimeOnMCDWindow, "ETA Time on MCD Page");
        getText(DIMCDPage.lblETATimeOnMCDWindow, "ETA Time on MCD Page");
    }

    public boolean verifyReasonTextBoxIsGrayedOutStatusTab() throws Throwable {
        boolean reason = isElementPresent(DIMCDPage.txtReasonGrayedout, "Reason Textbox is grayed out ");
        return reason;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPaymentButtonOnOCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public void clickOnPaymentButtonOnOCDWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnPaymentOnMCDWindow, "Payment Button");
        mouseHover(DIMCDPage.btnPaymentOnMCDWindow,"Hover on Payment Button");
        mouseDoubleClick(DIMCDPage.btnPaymentOnMCDWindow,"Hover on Payment Button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterServiceAndChargesOnMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public void enterServiceAndChargesOnMCDWindow(String serviceType) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.drpDwnServicesAndChargesInMCDWindow, "Enter Serivice");
        type(DIMCDPage.drpDwnServicesAndChargesInMCDWindow,serviceType, "Enter Serivice");
        Thread.sleep(3000);
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDropDownValueServiceAndChargesOnMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public void clickOnDropDownValueServiceAndChargesOnMCDWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.drpDwnServicesAndChargesValueOnMCDWindow, "Click Value Payment Charges");
        click(DIMCDPage.drpDwnServicesAndChargesValueOnMCDWindow, "Click Value Payment Charges");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveButtonInServiceAndChargesOnMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public void clickOnSaveButtonInServiceAndChargesOnMCDWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnSaveInServiceAndChargesInMCDWindow, "Click Save Button On Service And Charges");
        click(DIMCDPage.btnSaveInServiceAndChargesInMCDWindow, "Click Save Button On Service And Charges");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCostInServiceAndChargesInMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */

    public void enterCostInServiceAndChargesInMCDWindow(String cost) throws Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(DIMCDPage.txtCostInServiceAndChargesInMCDWindow, "Enter Cost");
        type(DIMCDPage.txtCostInServiceAndChargesInMCDWindow, cost, "Enter Cost");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCostInServiceAndChargesInMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */

    public void enterCashCollectedInServiceAndChargesInMCDWindow(String cashCollected) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCashCollectedInServiceAndChargesInMCDWindow, "Enter Cash Collected");
        type(DIMCDPage.txtCashCollectedInServiceAndChargesInMCDWindow, cashCollected, "Enter Cash Collected");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseButtonInServiceAndChargesOnMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public void clickOnCloseButtonInServiceAndChargesOnMCDWindow() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnCloseInSericeAndChargesInMCDWindow, "Click Close Button On Service And Charges");
        click(DIMCDPage.btnCloseInSericeAndChargesInMCDWindow, "Click Close Button On Service And Charges");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyErrorMessageAtReasonInMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public boolean verifyErrorMessageAtReasonInMCDWindow() throws Throwable {
        boolean errorMessage = isVisibleOnly(DIMCDPage.errorMessageAtEnterReasonOnMCDWindow, "Error");
        return errorMessage;
    }

    /**
     * Description:This method is used to get Pacesetter code  On SummaryTab
     * date ::  29-Jan-2018
     * @return
     * @throws Throwable
     */
    public String getPaceSetterCodeOnSummaryTab() throws Throwable {
        String pacesetter = getText(DIMCDPage.lblPaceSetterCodeOnSummaryTabinMCD, "Pacesetter Code");
        return pacesetter;
    }
    /**
     * Description:This method is used to get Pacesetter code  On SummaryTab
     * date ::  29-Jan-2018
     * @return
     * @throws Throwable
     */
    public String getTroubleCodeOnSummaryTab() throws Throwable {
        String troubleCode = getText(DIMCDPage.lblTroubleCodeOnSummaryTabinMCD, "Trouble Code");
        return troubleCode;
    }

    /**
     * Description:This method is used to verify Member Level on Member getMemberLevelOnMemberTabtab
     * date ::  11-Jan-2018
     * @return
     * @throws Throwable
     */
    public String getMemberLevelOnMemberTab() throws Throwable {
        String level = getText(DIMCDPage.lblMemberLevelOnMemberTabinMCD, "Level");
        return level;
    }

    public void enterAddressDetailsManuallyinMCD(String address,String crossStreet, String secondCrossStreet, String city ) throws Throwable {
        clickOnEnterAddressManuallyForOtherLocationInMCDWindow();
        enterLocationForOtherLocationInMCDWindow(address);
        enterCrossStreet1ForOtherLocationInMCDWindow(crossStreet);
        enterCrossStreet2ForOtherLocationInMCDWindow(secondCrossStreet);
        enterCityForOtherLocationInMCDWindow(city);
    }

    public void clickonSubmitandVerifyClearCallLabel(String StatusUpdateCL) throws Throwable {
        clickOnSubmitButton();
        Thread.sleep(5000);
        labelCallCleared(StatusUpdateCL);
    }

    public void closeErrorAlert() throws Throwable {
        waitForVisibilityOfElement(LoginPage.errorAlertOK,"OK Button");
        if(isVisibleOnly(LoginPage.errorAlertOK,"OK Button"))
        {
            assertTrue(isVisibleOnly(LoginPage.errorAlertOK,"Error alert"), ":OK Button");
            click(LoginPage.errorAlertOK,"Error alert OK button");
        }else{
            assertTrue(isVisibleOnly(LoginPage.errorAlertOK,"Error alert"), ":OK Button");
        }
    }

    public void selectExitCodeandEnterReasonandClickonContinue(String reason,String goResolutionCode,String StatusUpdateCL) throws Throwable {
        boolean errorMessage = false;
        selectExitCode();
        clickOnContinue();
        Thread.sleep(3000);
        errorMessage = verifyErrorMessageAtReasonInMCDWindow();
        if(errorMessage)
        {
            closeErrorAlert();
            clearData(DIMCDPage.txtReason);
            enterReason(reason);
            clickOnContinue();
        }
        else
        {
            if(goResolutionCode.equalsIgnoreCase("GO")) {
                clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
            }
        }
    }
    public void batteyInfo(String batteryInfo, String odometerReading, String Comments,String StatusUpdateCL) throws Throwable {
        if (batteryInfo.equalsIgnoreCase("Info Input")) {
            boolean batteryQuestionAvailable = verifyBatteryQuestionnaireInMCDWindow();
            if (batteryQuestionAvailable) {
                if (batteryInfo.equalsIgnoreCase("Info Input")) {
                    clickAndEnterBatteryTestedInformation(odometerReading, Comments);
                    Thread.sleep(5000);
                    clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                }
            } else {
                //clickonSubmitandVerifyClearCallLabel();
                labelCallCleared(StatusUpdateCL);
            }
        }
    }
    public void towConfirmation(String TowConfirmation,String TowConfComment,String TowConfEnterAddress,String MCDLocationAddress,String MCDcrossStreet, String MCDsecondCrossStreet, String MCDCity, String TowConfEnterOtherAddress,String StatusUpdateCL) throws Throwable {
        boolean verifyAddressAvailableForOtherLocationInMCDWindow = false;
        switch (TowConfirmation ){
            case "NoTowPerform" :
                clickOnNoTowPerformed();
                Thread.sleep(5000);
                clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                break;
            case "Original" :
                clickOnOriginalTowDestination();
                Thread.sleep(5000);
                clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                break;
            case "MemberHome" :
                boolean memberHomeAvailability = verifyMemberHome();
                if(memberHomeAvailability) {
                    clickOnMemberHome();
                    enterCommentsOnMCDWindow(TowConfComment);
                    Thread.sleep(5000);
                    clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                }
                else
                {
                    clickOnNoTowPerformed();
                    Thread.sleep(5000);
                    clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                }
                break;
            case "RepairFacility" :
                clickOnRepairFacility();
                enterAddressOnMCDWindow(TowConfEnterAddress);
                clickOnSearchIcon();
                Thread.sleep(4000);
                verifyAddressAvailableForOtherLocationInMCDWindow = verifyAddressAvailableForOtherLocationInMCDWindow();
                if(verifyAddressAvailableForOtherLocationInMCDWindow)
                {

                    enterAddressDetailsManuallyinMCD(MCDLocationAddress, MCDcrossStreet, MCDsecondCrossStreet, MCDCity);
                }
                else
                {
                    clickOnFirstLinkOnAddress();
                }
                enterCommentsOnMCDWindow(TowConfComment);
                Thread.sleep(5000);
                clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                break;
            case "Other" :
                clickOnOtherLocation();
                enterAddressOnMCDWindow(TowConfEnterOtherAddress);
                clickOnSearchIcon();
                Thread.sleep(4000);
                verifyAddressAvailableForOtherLocationInMCDWindow = verifyAddressAvailableForOtherLocationInMCDWindow();
                if(verifyAddressAvailableForOtherLocationInMCDWindow)
                {
                    enterAddressDetailsManuallyinMCD(MCDLocationAddress, MCDcrossStreet, MCDsecondCrossStreet, MCDCity);

                }
                else
                {
                    clickOnFirstLinkOnAddress();
                }
                enterCommentsOnMCDWindow(TowConfComment);
                Thread.sleep(5000);
                clickonSubmitandVerifyClearCallLabel(StatusUpdateCL);
                break;
            default :
                break;
        }
    }

    public void resolutionCode(String ResolutionCode, String Reason,String batteryInfo,String goResolutionCode,String StatusUpdateCL) throws Throwable {
        switch (ResolutionCode ){
            case "Go" :
                selectExitCodeandEnterReasonandClickonContinue(Reason,goResolutionCode,StatusUpdateCL);

                labelCallCleared(StatusUpdateCL);
                break;
            case "NoGo" :
                clickOnNoGo();
                selectExitCodeandEnterReasonandClickonContinue(Reason,goResolutionCode,StatusUpdateCL);
                break;
            case "NoService" :
                clickOnNoService();
                selectExitCodeandEnterReasonandClickonContinue(Reason,goResolutionCode,StatusUpdateCL);
                if(batteryInfo.isEmpty())
                {
                    labelCallCleared(StatusUpdateCL);
                }

                break;
            default :
                break;
        }
    }

    public void statusUpdateAsCL(String StatusUpdateCL) throws Throwable
    {
        if (StatusUpdateCL.equalsIgnoreCase("CL")) {
            Thread.sleep(2000);
            selectClearCall();
        }
    }
    public boolean verifyOkErrorAlert() throws Throwable {
        boolean okErrorAlertAvailable = isVisibleOnly(LoginPage.btnErrorAlertOK, "Existing Vehicles are Not Visible");
        return okErrorAlertAvailable;
    }
    public void closeErrorAlertOKButton() throws Throwable {
        if(isVisibleOnly(LoginPage.btnErrorAlertOK,"OK Button"))
        {
            click(LoginPage.btnErrorAlertOK,"Error alert OK button");
        }
    }
    public void statusUpdateAsTW(String StatusUpdateTW) throws Throwable
    {
        if (StatusUpdateTW.equalsIgnoreCase("TW")) {
            clickOnTW();
            Thread.sleep(2000);
            closeErrorAlertOKButton();
            boolean noTowLableAvailable = verifyOkErrorAlert();
            if(!noTowLableAvailable) {
                lblCallTowStatus(StatusUpdateTW);
            }
        }
    }
    public void statusUpdateAsOL(String StatusUpdateOL) throws Throwable
    {
        if (StatusUpdateOL.equalsIgnoreCase("OL")) {
            selectOnLocation();
            Thread.sleep(2000);
            lblCallOnLocationStatus(StatusUpdateOL);
        }
    }

    public void statusUpdateAsETA(String StatusUpdateETA) throws Throwable
    {
        if (StatusUpdateETA.equalsIgnoreCase("ETA")) {
            clickOnETAButtonOnMCDWindow();
            setTimeForETA();
        }
    }
    public void statusUpdateAsER(String StatusUpdateER) throws Throwable
    {
        if (StatusUpdateER.equalsIgnoreCase("ER")) {
            selectEnroute();
            selectEnrouteTime();
            Thread.sleep(2000);
            lblCallENRouteStatus(StatusUpdateER);
        }
    }
    public void statusUpdateAsDI(String StatusUpdateDI) throws Throwable
    {
        if (StatusUpdateDI.equalsIgnoreCase("DI")) {
            selectDispatch();
            Thread.sleep(2000);
            lblCallDispatchedStatus(StatusUpdateDI);
        }
    }
    public void statusUpdateAsAS(String StatusUpdateAS) throws Throwable
    {
        if (StatusUpdateAS.equalsIgnoreCase("AS")) {
            clickOnAssign();
            selectFacility();
            Thread.sleep(2000);
            lblCallAssignedStatus(StatusUpdateAS);
        }
    }
    public void statusUpdateAsSP(String StatusUpdateSP) throws Throwable
    {
        switch (StatusUpdateSP) {
            case "SP" :
                lblCallSpottedStatus();
                break;
            default :
                break;
        }
    }

    public void verifyFacilityAndEnterReasonAndReSpot(String SPEnterReason, String FacilityID) throws Throwable {
	    	/*String facilityNumberBeforeReport = splitFacilityNameAndNumberOnServiceTabinDIMCD();
            reporter.failureReport("Facility Number Before Respot","Facility Number Before Respot is:: " + facilityNumberBeforeReport);*/
        clickOnSP();
        enterReasonOnStatusUpdateTab(SPEnterReason);
        enterfacilityOnStatusUpdateWindow(FacilityID);
        clickOnUpdate();
            /*splitFacilityNameAndNumberOnServiceTabinDIMCD();
            String facilityNumberAfterReport = splitFacilityNameAndNumberOnServiceTabinDIMCD();
            reporter.failureReport("Facility Number After Respot","Facility Number After Respot is:: " + facilityNumberAfterReport);*/
        lblCallSpottedStatus();
    }

    public void paymentForRAPCall(String cost,String cashCollected,String serviceType,String towServiceType ) throws Throwable
    {
        Thread.sleep(4000);
        clickOnPaymentButtonOnOCDWindow();
        enterServiceAndChargesOnMCDWindow(serviceType);
        Thread.sleep(2000);
        //enterSecondServiceAndChargesOnMCDWindow(towServiceType);
        //clickOnDropDownValueServiceAndChargesOnMCDWindow();
        enterCostInServiceAndChargesInMCDWindow(cost);
        enterCashCollectedInServiceAndChargesInMCDWindow(cashCollected);
        clickOnSaveButtonInServiceAndChargesOnMCDWindow();
        clickOnCloseButtonInServiceAndChargesOnMCDWindow();

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: captureTroubleCodeInDispatch
     * description ::
     * date :: 29-jan-2018
     * author ::Varun
     */
    public String captureTroubleCodeInDispatch() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblTroubleCodeOnSummaryTabinMCD, "Trouble code in Summary");
        String troubleCodeindispatch = getText(DIMCDPage.lblTroubleCodeOnSummaryTabinMCD, "Trouble code in Summary");
        //assertTrue(pacecodeindispatch.contains(dataBean.getValue(data, "Pacecodeindispatch")), "Excpeted pacesetter code has been displayed in dispacth");
        //assertTrue(pacecodeindispatch.equalsIgnoreCase(dataBean.getValue(data,"Pacecodeindispatch")),"Excpeted pacesetter code has been displayed in dispacth");
       /* String currentPaceCode[] = pacecodeindispatch.split("-");
        String PaceCodeValue = currentPaceCode[0]; //L302
        String PaceCodeText = currentPaceCode[1]; //No Crank
        //L302 No Crank - Bat Svc (non-AAA Bat)
        String getPaceCode = troubleCode;
        assertTrue(PaceCodeValue.contains(getPaceCode), "PaceCode is same");
        assertTrue(PaceCodeText.contains(getPaceCode), getPaceCode + "PaceCode is same");*/
        return troubleCodeindispatch;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: captureTroubleCodeInDropdownDispatch
     * description ::
     * date :: 29-jan-2018
     * author ::Varun
     */
    public String captureTroubleCodeInDropdownDispatch() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtTroubleCodeDropdown, "Trouble code in dispatch dropdown");
        String troubleCodeDrpdwndispatch = getAttributeByValue(DIMCDPage.txtTroubleCodeDropdown, "Trouble code in dispatch dropdown ");
        //assertTrue(pacecodeindispatch.contains(dataBean.getValue(data, "Pacecodeindispatch")), "Excpeted pacesetter code has been displayed in dispacth");
        //assertTrue(pacecodeindispatch.equalsIgnoreCase(dataBean.getValue(data,"Pacecodeindispatch")),"Excpeted pacesetter code has been displayed in dispacth");
       /* String currentPaceCode[] = pacecodeindispatch.split("-");
        String PaceCodeValue = currentPaceCode[0]; //L302
        String PaceCodeText = currentPaceCode[1]; //No Crank
        //L302 No Crank - Bat Svc (non-AAA Bat)
        String getPaceCode = troubleCode;
        assertTrue(PaceCodeValue.contains(getPaceCode), "PaceCode is same");
        assertTrue(PaceCodeText.contains(getPaceCode), getPaceCode + "PaceCode is same");*/
        return troubleCodeDrpdwndispatch;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: capturePaceSetterCodeDispatchSummary
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public String capturePaceSetterCodeDispatchSummary() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtPaceSetterCodeSummaryTab, "PaceSetter code in Summary");
        String paceSetterCode = getText(DIMCDPage.txtPaceSetterCodeSummaryTab, "PaceSetter code in Summary ");
        //assertTrue(pacecodeindispatch.contains(dataBean.getValue(data, "Pacecodeindispatch")), "Excpeted pacesetter code has been displayed in dispacth");
        //assertTrue(pacecodeindispatch.equalsIgnoreCase(dataBean.getValue(data,"Pacecodeindispatch")),"Excpeted pacesetter code has been displayed in dispacth");
       /* String currentPaceCode[] = pacecodeindispatch.split("-");
        String PaceCodeValue = currentPaceCode[0]; //L302
        String PaceCodeText = currentPaceCode[1]; //No Crank
        //L302 No Crank - Bat Svc (non-AAA Bat)
        String getPaceCode = troubleCode;
        assertTrue(PaceCodeValue.contains(getPaceCode), "PaceCode is same");
        assertTrue(PaceCodeText.contains(getPaceCode), getPaceCode + "PaceCode is same");*/
        return paceSetterCode;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: captureReasonDispatchDrpDwn
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public String captureReasonDispatchDrpDwn() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtReason, "Reason in dropdown");
        String reasonCode = getText(DIMCDPage.txtReason, "Reason in dropdown ");
        //assertTrue(pacecodeindispatch.contains(dataBean.getValue(data, "Pacecodeindispatch")), "Excpeted pacesetter code has been displayed in dispacth");
        //assertTrue(pacecodeindispatch.equalsIgnoreCase(dataBean.getValue(data,"Pacecodeindispatch")),"Excpeted pacesetter code has been displayed in dispacth");
       /* String currentPaceCode[] = pacecodeindispatch.split("-");
        String PaceCodeValue = currentPaceCode[0]; //L302
        String PaceCodeText = currentPaceCode[1]; //No Crank
        //L302 No Crank - Bat Svc (non-AAA Bat)
        String getPaceCode = troubleCode;
        assertTrue(PaceCodeValue.contains(getPaceCode), "PaceCode is same");
        assertTrue(PaceCodeText.contains(getPaceCode), getPaceCode + "PaceCode is same");*/
        return reasonCode;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void clickPaymentonAPD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.iconPaymentOnMCDWindow, "Payment icon");
        click(DIMCDPage.iconPaymentOnMCDWindow, "Payment Icon");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectServicesDrpDwnOnPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void selectServicesDrpDwnOnPaymentonAPD(String services) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.drpdwnServicesOnPaymentOfMCD, "Services Dropdown");
        click(DIMCDPage.drpdwnServicesOnPaymentOfMCD, "Services Dropdown");
        type(DIMCDPage.drpdwnServicesOnPaymentOfMCD,services,"Services and Charges dropdown");

    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterCashCollectedOnPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void enterCashCollectedOnPaymentonAPD(String services) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCashCollectedAPD, "Cash Collected");
        click(DIMCDPage.txtCashCollectedAPD, "Cash Collected");
        type(DIMCDPage.txtCashCollectedAPD,services,"Cash Collected");

    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterServiceCostOnPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void enterServiceCostOnPaymentonAPD(String services) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCostAPD, "Service Cost");
        click(DIMCDPage.txtCostAPD, "Service Cost");
        type(DIMCDPage.txtCostAPD,services,"Service Cost");

    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickSaveBtnOnPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void clickSaveBtnOnPaymentonAPD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnAPDSave, "Save");
        click(DIMCDPage.btnAPDSave, "Save");


    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickCloseBtnOnPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void clickCloseBtnOnPaymentonAPD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnCloseAPD, "Close");
        click(DIMCDPage.btnCloseAPD, "Close");


    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickSubmitBtnOnPaymentonAPD
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void clickSubmitBtnOnPaymentonAPD() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnSubmitAPD, "Submit");
        click(DIMCDPage.btnSubmitAPD, "Submit");


    }

    /**
     * Description:This method is used to enter comments in status update tab.
     * Date:30-01-2018
     *
     * @param comments
     * @throws Throwable
     * @Author : Madhukar
     */

    public void enterCommentsOnStatusUpdateTab(String comments) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtCommentsInStautusUpdateTab, "Comments Field");
        type(DIMCDPage.txtCommentsInStautusUpdateTab, comments, "Comments Field");
    }

    /**
     * Description:This method is used to click on status history link on MCD Window
     * Date:30-01-2018
     *
     * @throws Throwable
     * @Author : Madhukar
     */
    public void clickOnStatusHistoryLinkOnMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkStatusHistory, "Status History Link");
        click(DIMCDPage.lnkStatusHistory, "Status History Link");
    }

    /**
     * Description:This method is used to get the call status from status history tab on MCD Window
     * Date:30-01-2018
     *
     * @throws Throwable
     * @Author : Madhukar
     */
    public void getStatusFromStatusHistoryTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblStatusOnStatusHistoryTab, "Update Status");
        getText(DIMCDPage.lblStatusOnStatusHistoryTab, "Update Status");

    }

    /**
     * Description:This method is used to get the reason from status history tab on MCD Window
     * Date:30-01-2018
     *
     * @throws Throwable
     * @Author : Madhukar
     */
    public void getReasonFromStatusHistoryTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblReasonOnStatusHistoryTab, "Reason");
        getText(DIMCDPage.lblReasonOnStatusHistoryTab, "Reason");
    }

    /**
     * Description:This method is used to click plus icon to view comments on status history tab
     * Date:30-01-2018
     *
     * @throws Throwable
     * @Author : Madhukar
     */
    public void clickOnPlusIconInStatusHistoryTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkPlusIconForCommentsOnStatusHistoryTab, "Plus Icon");
        click(DIMCDPage.lnkPlusIconForCommentsOnStatusHistoryTab, "Plus Icon");
    }

    /**
     * Description:This method is used to view and verify comments on status history tab
     * Date:30-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public String verifyCommentsFromStatusHistoryTab() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblPlusIconForCommentsSectionOnStatusHistoryTab, "Comments");
        String comments = getText(DIMCDPage.lblPlusIconForCommentsSectionOnStatusHistoryTab, "Comments");
        return comments;
    }

    /**
     * Description:This method is used to get Facility ID And Name On Summary Tab Of MCD Window
     * Date:30-01-2018
     *
     * @return
     * @throws Throwable
     * @Author : Madhukar
     */
    public String getFacilityIDAndNameOnSummaryTabOfMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblFacilityIdAndNameOnSummaryTabinMCD, "FacilityIdAndName");
        String facilityNameAndID = getText(DIMCDPage.lblFacilityIdAndNameOnSummaryTabinMCD, "FacilityIdAndName");
        return facilityNameAndID;
    }

    /**
     * Description:This method is used to maximize MCD Window
     * Date:30-01-2018
     *
     * @throws Throwable
     * @Author : Madhukar
     */
    public void maximizeMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkMaximizeMCDWindow, "PoppedOut Window");
        click(DIMCDPage.lnkMaximizeMCDWindow, "PoppedOut Window");
    }

    /**
     * Description:This method is used to minimize MCD Window
     * Date:30-01-2018
     *
     * @throws Throwable
     * @Author : Madhukar
     */
    public void minimizeMCDWindow() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkMinimizeMCDWindow, "Pop in Window");
        click(DIMCDPage.lnkMinimizeMCDWindow, "Pop in Window");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clearCallID
     * description ::
     * date :: 30-jan-2018
     * author ::Varun
     */
    public void clearCallID(String clearType,String TowConfirmation,String TowConfComment,String TowConfEnterAddress,String MCDLocationAddress,String MCDcrossStreet, String MCDsecondCrossStreet, String MCDCity, String TowConfEnterOtherAddress, String reason) throws Throwable {
        switch (clearType) {
            case "GO":
                spotStatus = getCallStatusOnMCDwindow();
                //getCallStatusOnMCDwindow();
                clickOnAssign();
                Thread.sleep(1000);
                assignStatus=getCallStatusOnMCDwindow();
                assertTrue(spotStatus!=assignStatus,"Status changed from   "+spotStatus+" To "+assignStatus);
                selectFacility();
                Thread.sleep(1000);
                facilityStatus=getCallStatusOnMCDwindow();
                assertTrue(facilityStatus!=assignStatus,"Status changed from   "+assignStatus+" To "+facilityStatus);
                selectDispatch();
                Thread.sleep(1000);
                dispatchStatus=getCallStatusOnMCDwindow();
                assertTrue(facilityStatus!=dispatchStatus,"Status changed from  "+facilityStatus+" To "+dispatchStatus);
                selectEnroute();
                selectEnrouteTime();
                Thread.sleep(1000);
                enrouteStatus=getCallStatusOnMCDwindow();
                assertTrue(enrouteStatus!=dispatchStatus,"Status changed from  "+dispatchStatus+" To "+enrouteStatus);
                selectOnLocation();
                Thread.sleep(1000);
                locationStatus=getCallStatusOnMCDwindow();
                assertTrue(locationStatus!=enrouteStatus,"Status changed from  "+enrouteStatus+" To "+locationStatus);
                Thread.sleep(1000);
                selectClearCall();
                selectExitCode();
                enterReason(reason);
                clickOnContinue();
                clickOnSubmit();
                clearStatus=getCallStatusOnMCDwindow();
                assertTrue(locationStatus!=clearStatus,"Status changed from  "+locationStatus+" To "+clearStatus+" Call Cleared Successfully");

                Thread.sleep(2000);
                break;
            case "NoGo":
                spotStatus = getCallStatusOnMCDwindow();
                //getCallStatusOnMCDwindow();
                clickOnAssign();
                Thread.sleep(1000);
                assignStatus = getCallStatusOnMCDwindow();
                assertTrue(spotStatus!=assignStatus,"Status changed from   "+spotStatus+" To "+assignStatus);
                selectFacility();
                Thread.sleep(1000);
                facilityStatus=getCallStatusOnMCDwindow();
                assertTrue(facilityStatus!=assignStatus,"Status changed from   "+assignStatus+" To "+facilityStatus);
                selectDispatch();
                Thread.sleep(1000);
                dispatchStatus=getCallStatusOnMCDwindow();
                assertTrue(facilityStatus!=dispatchStatus,"Status changed from  "+facilityStatus+" To "+dispatchStatus);
                selectEnroute();
                selectEnrouteTime();
                Thread.sleep(1000);
                enrouteStatus=getCallStatusOnMCDwindow();
                assertTrue(enrouteStatus!=facilityStatus,"Status changed from  "+dispatchStatus+" To "+enrouteStatus);
                selectOnLocation();
                Thread.sleep(1000);
                locationStatus=getCallStatusOnMCDwindow();
                assertTrue(locationStatus!=enrouteStatus,"Status changed from  "+enrouteStatus+" To "+locationStatus);
                selectClearCall();
                // selectClearCall();
                clickOnNoGo();
                selectExitCode();
                enterReason(reason);
                clickOnContinue();
                //clickOnOriginalTowDestination();
                clickOnNoTowPerformed();
                clickOnSubmit();
                Thread.sleep(1000);
                clearStatus=getCallStatusOnMCDwindow();
                assertTrue(locationStatus!=clearStatus,"Status changed from  "+locationStatus+" To "+clearStatus+" Call Cleared Successfully");


            /*Thread.sleep(2000);
            getCallStatusOnMCDwindow();*/
                break;

            default:
                break;
        }
    }




    /**
     * Description:This method is used to verify Member Level on Member getMemberLevelOnSummaryTabtab
     * date ::  30-Jan-2018
     * @return
     * @throws Throwable
     */
    public String getMemberLevelOnSummaryTab() throws Throwable {
        Thread.sleep(1000);
        String memberLevel = getText(DIMCDPage.lblMemberLevelOnSummaryTab, "Member Level on Summary Tab");
        return memberLevel;
    }


    public String getCallTakerName()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.txtCallTaker,"Call Taker Name");
        String callTaker = getText(DIMCDPage.txtCallTaker,"Call Taker Name");
        return callTaker;
    }

    public String getphoneNumberFromMCD(String phoneNumber)throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.phoneNumberValue(phoneNumber),"Phone Number");
        String phoneNumber1 = getText(DIMCDPage.phoneNumberValue(phoneNumber),"Phone Number");
        String phoneNum[] = phoneNumber.split(" ");
        String phone1 = phoneNum[0].substring(1,4);
        String phone2[] = phoneNum[1].split("-");
        String phone3 = phone2[0];
        String phone4 = phone2[1];

    /*String phoneString1=getText(DIMCDPage.phoneNumberONMCD,"Phone Number").substring(1,3);
    String phoneString2=getText(DIMCDPage.phoneNumberONMCD,"Phone Number").substring(6,8);
    String phoneString3=getText(DIMCDPage.phoneNumberONMCD,"Phone Number").substring(10,13);*/
        Thread.sleep(3000);
        String phoneNumberFromResults=phone1+phone3+ phone4;
        return phoneNumberFromResults;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: mousehoverAndClickOnPencil
     * description ::
     * date :: 29-Jan-2018
     * author ::
     */
    public void mousehoverAndClickOnPencil() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");
   /* mouseHoverByJavaScript(DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");
    getText(DIMCDPage.editIconOnPencilIcon, "edit icon on Pencil icon in MCD Window");
    Thread.sleep(1000);*/
        mouseDoubleClick(DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");

        // clickUntilElementNotVisiable(DIMCDPage.imgPencilIcon,DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");

    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddButton
     * description ::
     * date :: 31-Jan-2018
     * author ::Ravi
     */
    public void clickOnAddButton() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnAdd, "Click on add button");
        click(DIMCDPage.btnAdd, "click on add button ");

    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterAddCommentAndSave
     * description ::
     * date :: 31-Jan-2018
     * author ::Ravi
     */
    public void enterAddCommentAndSave(String AddComment) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtAddComment, "wait for txt Add Comment");
        type(DIMCDPage.txtAddComment, AddComment, "Add Comment from testdata");
        Thread.sleep(2000);
        click(DIMCDPage.btnSave, "save button");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCommentedData
     * description ::
     * date :: 31-Jan-2018
     * author ::Ravi
     */
    public void clickOnCommentedData() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.commentedData, "Click on commented data");
        getText(DIMCDPage.commentedData, "click on commented Data ");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getStatusOnCurrentButton
     * description ::
     * date :: 2-Jan-2018
     * author ::Lakshmi
     */
    public String getStatusOnCurrentButton()throws  Throwable{
        String currentStatus=getAttributeByClass(DIMCDPage.btnHighlightedStatus,"Highlighted status    ");
        return currentStatus;
    }
    /**
     * param ::
     * return ::Param
     * throws :: throwable
     * methodName :: getStatusOnNextButton
     * description ::
     * date :: 2-Jan-2018
     * author ::Lakshmi
     */
    public String getStatusOnNextButton()throws  Throwable{
        String nextStatus=getAttributeByClass(DIMCDPage.btnNextSelected,"Next status     ");
        return nextStatus;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTheStatusChange
     * description ::
     * date :: 2-Jan-2018
     * author ::Lakshmi
     */
    public boolean verifyTheStatusChange(String currentStatus, String nextStatus, String currentStatusData, String nextStatusData) throws Throwable {
        boolean statusFlag = false;
        if (currentStatus.contains(currentStatusData) && nextStatus.contains(nextStatusData)) {
            statusFlag = true;
        }
        return statusFlag;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyClearingTabOnSPPMCDWindow
     * description ::
     * date :: 2-Jan-2018
     * author ::Lakshmi
     */
    public boolean verifyClearingTabOnSPPMCDWindow() throws Throwable {

        waitForVisibilityOfElement(DIMCDPage.lblClearingTab, "Clearing Tab on MCD Window");
        boolean clearingWindow = isVisibleOnly(DIMCDPage.lblClearingTab, "Clearing Tab on MCD Window");
        return clearingWindow;
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getCallTakerFromMCDWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Lakshmi
     */
    public String getCallTakerFromMCDWindow()throws  Throwable

    {
        waitForVisibilityOfElement(DIMCDPage.txtCallTaker, "Call Taker on MCD Window");
        isVisibleOnly(DIMCDPage.txtCallTaker, "Call Taker on MCD Window");
        String callTakerOnMCDWindow = getText(DIMCDPage.txtCallTaker, "Call Taker on MCD Window");
        return callTakerOnMCDWindow;
    }


    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: closeFacilityPTAWindow
     * description ::
     * date :: 03-Jan-2018
     * author ::Lakshmi
     */
    public void closeFacilityPTAWindow()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.btnPtaClose,"Facility PTA close button");
        click(DIMCDPage.btnPtaClose,"Facility PTA close button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSecondServiceAndChargesOnMCDWindow
     * description ::
     * date :: 29-Jan-2018
     * author :: Abhiram
     */
    public void enterSecondServiceAndChargesOnMCDWindow(String towServiceType) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.drpDwnAddSecondServicesAndChargesInMCDWindow, "Enter Service");
        type(DIMCDPage.drpDwnAddSecondServicesAndChargesInMCDWindow,towServiceType, "Enter Service");
        Thread.sleep(3000);
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnBidCallButton
     * description ::
     * date :: 03-Jan-2018
     * author ::Lakshmi
     */
    public void clickOnBidCallButton()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.btnBidCallInMCD,"Bid Call Button");
        click(DIMCDPage.btnBidCallInMCD,"Bid Call Button");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getTruckIdFromMCDWindow
     * description ::
     * date :: 05-Jan-2018
     * author ::Lakshmi
     */

    public String getTruckIdFromMCDWindow()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblTruckIDOnMCDSummaryScreen,"Truck ID");
        String truckId = getText(DIMCDPage.lblTruckIDOnMCDSummaryScreen,"Truck ID");
        //String truckid = truckId.substring(0,1);
        //String truck = truckid[0];
        return truckId;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnDeclineButton
     * description ::
     * date :: 05-Jan-2018
     * author ::Lakshmi
     */

    public void clickOnDeclineButton()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.btnDeclainCallinMCD,"Decline Button");
        click(DIMCDPage.btnDeclainCallinMCD,"Decline Button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPoppedOutButton
     * description ::
     * date :: 05-Jan-2018
     * author ::Lakshmi
     */
    public void clickOnPoppedOutButton()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.btnPopOutInMCD,"PoppedOut Button");
        isVisibleOnly(DIMCDPage.btnPopOutInMCD,"PoppedOut Button");
        click(DIMCDPage.btnPopOutInMCD,"PoppedOut Button");
    }
    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: verifyPoppedOutWindow
     * description ::
     * date :: 05-Jan-2018
     * author ::Lakshmi
     */
    public boolean verifyPoppedOutWindow()throws  Throwable{
        boolean poppedIn=isVisibleOnly(DIMCDPage.lnkMinimizeMCDWindow,"PoppedIn");
        return poppedIn;
    }
    /**
     * param ::
     * return ::boolean
     * throws :: throwable
     * methodName :: clickOnPoppedInButton
     * description ::
     * date :: 05-Jan-2018
     * author ::Lakshmi
     */
    public void clickOnPoppedInButton()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lnkMinimizeMCDWindow,"PoppedIn Button");
        click(DIMCDPage.lnkMinimizeMCDWindow,"PoppedIn Button");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getResaonCodeForClearedCallInMCDWindow
     * description ::
     * date :: 05-Feb-2018
     * author ::Chandra
     */
    public String getResaonCodeForClearedCallInMCDWindow()throws  Throwable{
        String reasonCode= getText(DIMCDPage.lblReasonCodeOnMCDHisotryWindow,"Cleared call Reason Code");
        return reasonCode;
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: clickOnCloseIconOnHistoryStatus
     * description ::
     * date :: 05-Feb-2018
     * author ::Chandra
     */
    public void clickOnCloseIconOnHistoryStatus()throws  Throwable{
        click(DIMCDPage.iconCloseOnStatusHistoryTabInMCDWindow,"Close History Icon");

    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getPacesetterValue
     * description ::
     * date :: 05-Jan-2018
     * author ::Ravi
     */
    public void getPacesetterValue()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblPaceSetterValueInMCD,"Paceseter value");
        getText(DIMCDPage.lblPaceSetterValueInMCD,"pacesetter value");
    }
    /**
     * Description:To enter details on Battery service tab
     * @param odoMeterReading
     * @param comments
     * @param testCode
     * @param batteryType
     * @param batteryPrice
     * @throws Throwable
     */
    public void clickAndEnterBatteryInformation(String odoMeterReading, String comments,String testCode,String batteryType,String batteryPrice) throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.batteryTestedYes, "battery tested yes");
        click(DIMCDPage.batteryTestedYes, "click on battery tested yes");
        type(DIMCDPage.txtTestCodeBattery, testCode, "Test Code");
        click(DIMCDPage.batteryFailedTestYes, "click on battery failed test Yes");
        click(DIMCDPage.batteryChargeYes, "Battery Charge Yes");
        click(DIMCDPage.batteryWarrantyYes, "Battery Warranty Yes");
        type(DIMCDPage.txtBatteryType, batteryType, "Battery Type");
        type(DIMCDPage.txtBatteryPrice, batteryPrice, "Battery Price");
        type(DIMCDPage.odometerReading, odoMeterReading, "ODOMETER Reading");
        type(DIMCDPage.enterComments, comments, "Done a Jump Start");

    }

    /**
     * Description:To verify Address Verified Icon on original Tow destination Tab.
     * @return
     * @throws Throwable
     */
    public boolean verifyAddressverifiedIconOnOriginalTowDestinationTab()throws Throwable{
        boolean addressVerified=isVisibleOnly(DIMCDPage.iconAddressverifiedOnOriginalTowDestinaton,"Address verified ");
        return addressVerified;
    }
    public boolean verifyOriginalTowDestination() throws Throwable {
        Thread.sleep(3000);
        boolean originalTowdestination = isVisibleOnly(DIMCDPage.btnOriginalTowDestinationOnMCDWindow, "Original Tow Destination button");
        return originalTowdestination;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: lblCallBDStatus
     * description ::
     * date :: 05-Feb-2018
     * author ::Varun
     */
    public void lblCallBDStatus() throws Throwable {
        getText(DIMCDPage.lblCallBDStatus, "Call BD Status is available");
    }


    public void selectBDStatus() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.btnBDUpdateinMCD, "BD status Update");
        click(DIMCDPage.btnBDUpdateinMCD, "Select BD");
    }

    public void statusUpdateAsBD(String StatusUpdateBD) throws Throwable
    {
        if (StatusUpdateBD.equalsIgnoreCase("BD")) {
            selectBDStatus();
            Thread.sleep(2000);
            lblCallBDStatus();
        }
    }

    public String lblCallCAStatus() throws Throwable {
        String Status=getText(DIMCDPage.lblCallCAStatus, "Call BD Status is available");
        return Status;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPencilIcon
     * description ::
     * date :: 6-feb-2018
     * author ::
     */
    public void clickOnPencilIcon() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");
        mouseDoubleClick(DIMCDPage.imgPencilIcon, "Pencil icon on MCD Window");
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickOnMCDMinimiseIcon
     * description ::
     * date :: 06-Feb-2018
     * author ::varun
     */
    public void clickOnMCDMinimiseIcon()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.linkMinimizeMCDwindow, "MCD minimise");
        click(DIMCDPage.linkMinimizeMCDwindow,"MCD minimise");

    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickAckOnMCDwindow
     * description ::
     * date :: 06-Feb-2018
     * author ::varun
     */
    public void clickAckOnMCDwindow()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.btnAcknowledgeMCD, "ACK button");
        click(DIMCDPage.btnAcknowledgeMCD,"ACK button");

    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickOnDuplicateCallButton
     * description ::
     * date :: 08-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public void clickOnDuplicateCallIcon()throws Throwable{
        isVisibleOnly(DIMCDPage.btnDupeCallOnMCD,"Duplicate Call Icon");
        click(DIMCDPage.btnDupeCallOnMCD,"Duplicate Call Icon");
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyDuplicateCallButton
     * description ::
     * date :: 08-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyDuplicateCallButton()throws  Throwable{

        mouseHover(DIMCDPage.btnDupeCallOnMCD,"Duplicate Call Icon");
        Thread.sleep(4000);
        waitForVisibilityOfElement(DIMCDPage.btnDupeCallPopUpNameOnMCD,"Duplicate Call Icon");
        String dupeCallButtonText = getText(DIMCDPage.btnDupeCallPopUpNameOnMCD,"Duplicate Call Name");
        return dupeCallButtonText;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyDulicateThisCallTab
     * description ::
     * date :: 08-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyDulicateThisCallTab()throws  Throwable{
        String duplicateCallTab = getText(DIMCDPage.txtDuplicateCallTab,"Duplicate Tab");
        return duplicateCallTab;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyCurrentCallInfoOption
     * description ::
     * date :: 08-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyCurrentCallInfoOption()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblCurrentCallOption,"Current Call On DuplicateCall Tab");
        String currentCallInfo = getText(DIMCDPage.lblCurrentCallOption,"Current Call On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the Current Call option , Option name on the Duplicate Call Tab  is   ",currentCallInfo);
        return currentCallInfo;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifryCallIdOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    //verifyCurrentCallInfoOption
    public String verifryCallIdOnDuplicateThisCallTab()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblCallIDOnDuplicateCallTab,"Call ID Option On DuplicateCall Tab");
        String callID = getText(DIMCDPage.lblCallIDOnDuplicateCallTab,"Call ID Option On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the Call ID option , Option name on the Duplicate Call Tab is   ",callID);
        return callID;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifryFacilityOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifryFacilityOnDuplicateThisCallTab()throws  Throwable{
     waitForVisibilityOfElement(DIMCDPage.lblFacilityOnDuplicateCallTab,"Facility Option On DuplicateCall Tab");
     String facility = getText(DIMCDPage.lblFacilityOnDuplicateCallTab,"Facility Option On DuplicateCall Tab");
     //reporter.SuccessReport("Verified the Facility Option  , Option name on the Duplicate Call Tab is   ",facility);
     return facility;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyTruckOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyTruckOnDuplicateThisCallTab()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblTruckOnDuplicateCallTab,"Truck Option On DuplicateCall Tab");
        String truck = getText(DIMCDPage.lblTruckOnDuplicateCallTab,"Truck Option On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the Truck Option  , Option name on the Duplicate Call Tab is   ",truck);
        return truck;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyPaceSetterCodeOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyPaceSetterCodeOnDuplicateThisCallTab()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblPaceSetterOnDuplicateCallTab,"PaceSetter Code Option On DuplicateCall Tab");
        String paceSetterCode = getText(DIMCDPage.lblPaceSetterOnDuplicateCallTab,"PaceSetter Code Option On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the PaceSetter Code Option  , Option name on the Duplicate Call Tab is   ",paceSetterCode);
        return paceSetterCode;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyStatusOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyStatusOnDuplicateThisCallTab()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblStatusOnDuplicateCallTab,"Status  Option On DuplicateCall Tab");
        String status = getText(DIMCDPage.lblPaceSetterOnDuplicateCallTab,"Status Option On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the Status Option  , Option name on the Duplicate Call Tab is   ",status);
        return status;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyNewDuplicateCallInfoOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyNewDuplicateCallInfoOnDuplicateThisCallTab()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblNewDulicateCallInformationOnDuplicateCallTab,"New Duplicate Call Info Option On DuplicateCall Tab");
        String newDulicateCall = getText(DIMCDPage.lblNewDulicateCallInformationOnDuplicateCallTab,"New Duplicate Call Info Option On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the New Duplicate Call Info Option  , Option name on the Duplicate Call Tab is   ",newDulicateCall);
        return newDulicateCall;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifySpotToFacilityDrpDwnOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifySpotToFacilityDrpDwnOnDuplicateThisCallTab()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblSpotToFacilityOnDuplicateCallTab,"Spot To Facility Drop-Down  On DuplicateCall Tab");
        String spotToFacility = getText(DIMCDPage.lblSpotToFacilityOnDuplicateCallTab,"Spot To Facility Drop-Down  On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the Spot To Facility Drop-Down    , Option name on the Duplicate Call Tab is   ",spotToFacility);
        return spotToFacility;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyPaceSetterDrpDwnOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyPaceSetterDrpDwnOnDuplicateThisCallTab()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblPaceSetterCodeDrpDwnOnDuplicateCallTab,"PaceSetter Code Drop-Down  On DuplicateCall Tab");
        String paceSetterDrpDwn= getText(DIMCDPage.lblPaceSetterCodeDrpDwnOnDuplicateCallTab,"PaceSetter Code Drop-Down On DuplicateCall Tab");
        //reporter.SuccessReport("Verified the PaceSetter Code Drop-Down   , Option name on the Duplicate Call Tab is   ",paceSetterDrpDwn);return
        return paceSetterDrpDwn;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyReasonDrpDwnOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyReasonDrpDwnOnDuplicateThisCallTab()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblReasonDrpDwnOnDuplicateCallTab,"Reason Drop-Down  On DuplicateCall Tab");
        String reason= getText(DIMCDPage.lblReasonDrpDwnOnDuplicateCallTab,"Reason Drop-Down On DuplicateCall Tab");
        return reason;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyCommentsOnDuplicateThisCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String verifyCommentsOnDuplicateThisCallTab()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblCommentsDrpDwnOnDuplicateCallTab,"Comments  On DuplicateCall Tab");
        String comments= getText(DIMCDPage.lblCommentsDrpDwnOnDuplicateCallTab,"Comments On DuplicateCall Tab");
        return comments;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickOnDuplicateCallButton
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public void clickOnDuplicateCallButton()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.btnDuplicateCallOnDuplicateCallTab,"Duplicate Call Button On Duplicate This Call Tab");
        click(DIMCDPage.btnDuplicateCallOnDuplicateCallTab,"Duplicate Call Button On Duplicate This Call Tab");

    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyErrorMessageForMandatoryFields
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String  verifyErrorMessageForMandatoryFields()throws Throwable{
        waitForVisibilityOfElement(DIMCDPage.errMsgForMandatoryFieldsOnDuplicateCallTab,"Error Message for Mandatory Fields On Duplicate This Call Tab");
        isVisibleOnly(DIMCDPage.errMsgForMandatoryFieldsOnDuplicateCallTab,"Error Message for Mandatory Fields On Duplicate This Call Tab");
        String erroMsg = getText(DIMCDPage.errMsgForMandatoryFieldsOnDuplicateCallTab,"Error Message for Mandatory Fields On Duplicate This Call Tab");
        Thread.sleep(3000);
        //click(DIMCDPage.btnErrorMsgOkOnDuplicateCallTab,"Click On Error alrert Ok Button");
        return erroMsg;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: enterFacilityToSpotOnDuplicateCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public void enterFacilityToSpotOnDuplicateCallTab(String facility)throws  Throwable{
        isVisibleOnly(DIMCDPage.txtSpotFacility,"Facility to spot");
        type(DIMCDPage.txtSpotFacility,facility,"Facility to spot");
        click(DIMCDPage.lnkToSelectFacilityOnNewDuplicateCall,"Select Facility From Droup Down");
        Thread.sleep(2000);
        click(DIMCDPage.txtAreaForComments,"Click On Comments");
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: getSelectedFacility
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String getSelectedFacility()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.txtSpotFacility,"Facility to spot");
       String facility =  getAttributeByValue(DIMCDPage.txtSpotFacility,"Facility to spot");
        return facility;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: enterPaceSetterCodeOnDuplicateCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public void enterPaceSetterCodeOnDuplicateCallTab(String paceSetterCode)throws  Throwable{
        isVisibleOnly(DIMCDPage.txtPaceSetterCode,"PaceSetter Code");
        type(DIMCDPage.txtPaceSetterCode,paceSetterCode,"PaceSetter Code");
        click(DIMCDPage.lnkToSelectPacesetterCode,"Select PaceSetterCode");
        Thread.sleep(2000);
        click(DIMCDPage.txtAreaForComments,"Click On Comments");
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: getSelectedPaceSetterCode
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String getSelectedPaceSetterCode()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.txtPaceSetterCode,"Selected PaceSetter Code");
        String paceSetterCode = getAttributeByValue(DIMCDPage.txtPaceSetterCode,"Selected PaceSetter Code");
        return paceSetterCode;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: enterReasonOnDuplicateCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public void enterReasonOnDuplicateCallTab(String reason)throws  Throwable{
        isVisibleOnly(DIMCDPage.txtReasonOnDuplicateCallTab,"Reason on Duplicate Call Tab");
        type(DIMCDPage.txtReasonOnDuplicateCallTab,reason,"Reason on Duplicate Call Tab");
        click(DIMCDPage.lnkSelectReasonOnNewDuplicateCall,"Select Reason Duplicate Call Tab");
        Thread.sleep(2000);
        click(DIMCDPage.txtAreaForComments,"Click On Comments");
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: getSelectedReason
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String getSelectedReason()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.txtReasonOnDuplicateCallTab,"Reason on Duplicate Call Tab");
        String reason = getAttributeByValue(DIMCDPage.txtReasonOnDuplicateCallTab,"Reason on Duplicate Call Tab ");
        return reason;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: enterCommentsOnDuplicateCallTab
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public void enterCommentsOnDuplicateCallTab(String comments)throws  Throwable{
        isVisibleOnly(DIMCDPage.txtAreaForComments,"Comments On Duplicate call Tab");
        type(DIMCDPage.txtAreaForComments,comments,"Comments On Duplicate call Tab");
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: getEnteredComments
     * description ::
     * date :: 09-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public String getEnteredComments()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.txtAreaForComments,"Comments On Duplicate call Tab");
        String comments = getAttributeByValue(DIMCDPage.txtAreaForComments,"Comments On Duplicate call Tab");
        return comments;
    }
    public boolean compareTwoValues(String getValue,String inputValue) throws Throwable {
        boolean comparedValues = getValue.contains(inputValue);
        assertTrue(comparedValues,"'"+getValue+"' and' "+inputValue+"' Both are same' ");
        return comparedValues;
    }
    public void clickOnErrorAlrertOkButton()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.btnErrorMsgOkOnDuplicateCallTab,"Click On Error alrert Ok Button");
        click(DIMCDPage.btnErrorMsgOkOnDuplicateCallTab,"Click On Error alrert Ok Button");
    }
    public void clickOnAdditionalInfoLinkInMCDServiceTab()throws Throwable{
        click(DIMCDPage.lnkEditAdditionalInfo,"Additional Info Link");
    }
    public String enterSpecialEquipmentInMCDServiceTab(String specialEqupementInMCD)throws Throwable{
        type(DIMCDPage.txtSpecialEquipementInMCDServiceTab,specialEqupementInMCD,"Special Equipement value");
        return specialEqupementInMCD;
    }
    public String enterReasonForStatus(String reasonForStatus)throws Throwable{
        type(DIMCDPage.txtReasonCodeInUpdateStatus,reasonForStatus,"Reason For Status value");
        return reasonForStatus;
    }
    public String enterCommentsInUpdateCallStatus(String comments)throws Throwable{
        type(DIMCDPage.txtCommentsInUpdateStatus,comments,"Comments For Status value");
        return comments;
    }
    public void clickOnUpdateButtonInUpdateStatus()throws Throwable{
        click(DIMCDPage.btnUpdatebuttonOnUpdateStatusPopup,"Update button in update status");
    }
    public void clickOnSaveButtonInSpecialEquiptmentSection() throws Throwable{
        click(DIMCDPage.btnSpecialEquipementSaveButton,"Save button");
    }
    public String getSpecialEquipmentValueInMCDServiceTab() throws Throwable{
        String specialEquipmentValue=getText(DIMCDPage.lblSpecialEquipmentInMCDServiceTab,"Special equipment value");
        return specialEquipmentValue;
    }
    public String getlblLatestCommentsInMCDWindow() throws Throwable{
        String savedComments=getText(DIMCDPage.lblLatestCommentsInMCDWindow,"Comments");
        return savedComments;
    }
    public void clickOnDateHeaderToSortDate() throws Throwable{
        click(DIMCDPage.sortdateInHisotrywindow,"Date wise sort");

    }
    public String getStatusInHistoryStatusScreenInMCDWindow() throws Throwable{
        String historyStatus=getText(DIMCDPage.lblStatusInHistoryStatus,"Status In History Status");
        return historyStatus;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyMemberHome
     * description ::
     * date :: 12-Jan-2018
     * author ::
     */
    public boolean verifyMemberHome() throws Throwable {
        boolean MemberHomeAvailable = isVisibleOnly(DIMCDPage.btnMemberHomeOnMCDWindow, "Member Home button");
        return MemberHomeAvailable;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getCallIdFromMcdWindow
     * description ::
     * date :: 11-Feb-2018
     * author ::
     */
    public String getCallIdFromMcdWindow() throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblCallIdOnMcdWindow,"Call Id From MCD Window");
        String callid = getText(DIMCDPage.lblCallIdOnMcdWindow,"Get Call Id From MCD Window");
        return callid;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getPaceSetterCodeFromSummary
     * description ::
     * date :: 11-Feb-2018
     * author ::
     */
    public String getPaceSetterCodeFromSummary()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblPaceSetterCodeInMCD,"PaceSetter Code In Summary");
        String paceSetterCode = getText(DIMCDPage.lblPaceSetterCodeInMCD,"PaceSetter Code In Summary");
        String currentPaceCode[] = paceSetterCode.split("-");
        String PaceCodeValue = currentPaceCode[0]; //L302
        return PaceCodeValue;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFacilityFromFacilitySummary
     * description ::
     * date :: 11-Feb-2018
     * author ::
     */
    public String getFacilityFromFacilitySummary()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblFacilityOnFacilitySummary,"Facility In Summary");
        Thread.sleep(2000);
        String facility = getText(DIMCDPage.lblFacilityOnFacilitySummary,"Facility In Summary");
        //String facilityFromSummary[] = facility.split(":");
        //String facilityValue = facilityFromSummary[1];
        return facility;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: closeTheOpendCallInMCD
     * description ::
     * date :: 11-Feb-2018
     * author ::
     */
    public void closeTheOpendCallInMCD()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lnkToCloseTheOpendCallInMCD,"Close The opened call");
        click(DIMCDPage.lnkToCloseTheOpendCallInMCD,"Close The opened call");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getStarStatusByClassName
     * description ::
     * date :: 12-Feb-2018
     * author ::
     */
    public String getStarStatusOnMCDWindow()throws  Throwable{
     waitForVisibilityOfElement(DIMCDPage.lblStarColor,"Getting the Star Status");
     String starStatus = getAttributeByClass(DIMCDPage.lblStarColor,"Getting the Star Status By Class Name");
     //String starStatus = getCssValue(DIMCDPage.lblStarColor,"4px solid yellow");
     return starStatus;
    }
    /**Validate datapoints on MCD Window**/
    public boolean verifyShowBatteryServiceHistoryButtonForRAPCall()throws Throwable{
        boolean showBatteryServiceHistory=isVisibleOnly(DIMCDPage.btnShowBatteryServiceHistoryForRAP,"Show Battery Service History");
        return showBatteryServiceHistory;
    }

    public boolean verifyShowDuplicateCallHistoryButtonForRAPCall()throws Throwable{
        boolean showDuplicateCallHistory=isVisibleOnly(DIMCDPage.btnShowDuplicateCallHistoryForRAP,"Show Duplicate Call History");
        return showDuplicateCallHistory;
    }

    public boolean verifyVehicleVinOnServiceTabForRAPCall()throws Throwable{
        boolean VehicleVin=isVisibleOnly(DIMCDPage.lblvehiclevinOnServiceTabOfMCD,"Vehicle Vin");
        return VehicleVin;
    }

    public boolean verifyVehicleOdometerOnServiceTabForRAPCall()throws Throwable{
        boolean odometer=isVisibleOnly(DIMCDPage.lblvehicleOdometerOnServiceTabOfMCD,"Odometer");
        return odometer;
    }

    public boolean verifyVehicleIsRAPOnlyOnServiceTabForRAPCall()throws Throwable{
        boolean isRAP=isVisibleOnly(DIMCDPage.lblvehicleIsRAPCallOnServiceTabOfMCD,"Is RAP Call");
        return isRAP;
    }

    public boolean verifyVehicleRAPEDSNumberOnServiceTabForRAPCall()throws Throwable{
        boolean rapEDSCallNumber=isVisibleOnly(DIMCDPage.lblvehicleRAPEDSCallNumberOnServiceTabOfMCD,"RAP EDS Call Number");
        return rapEDSCallNumber;
    }

    public boolean verifyRAPIconOnServiceTabForRAPCall()throws Throwable{
        boolean rapICON=isVisibleOnly(DIMCDPage.iconRAPCall,"RAP Icon");
        return rapICON;
    }
    public boolean verifyUpdatePanelContainerVisibility()throws Throwable{
        boolean updatePanelVisibility=isVisibleOnly(DIMCDPage.btnBidCallInMCD,"Visibility of Update Panel Container");
        return updatePanelVisibility;
    }

    public boolean verifyEditCallButtonOnMCDWindow() throws Throwable{
        boolean editCall=isVisibleOnly(DIMCDPage.btnEditOnMCD,"Edit Call button");
        return editCall;
    }
    public boolean verifyDuplicateCallButtonOnMCDWindow() throws Throwable{
        boolean duplicateCall=isVisibleOnly(DIMCDPage.btnDupeCallOnMCD,"Duplicate Call button");
        return duplicateCall;
    }
    public boolean verifyPrintCallButtonOnMCDWindow() throws Throwable{
        boolean printCall=isVisibleOnly(DIMCDPage.btnPrintCallOnMCD,"Print Call button");
        return printCall;
    }
    public boolean verifyPaymentButtonOnMCDWindow() throws Throwable{
        boolean paymentButton=isVisibleOnly(DIMCDPage.iconPaymentOnMCDWindow,"Payment button");
        return paymentButton;
    }
    public boolean verifyCreditCardButtonOnMCDWindow() throws Throwable{
        boolean creditCard=isVisibleOnly(DIMCDPage.btnCrediCardOnMCD,"Payment button");
        return creditCard;
    }

    public void clickOnOkayButtonInErrorAlert() throws Throwable{
        click(DIMCDPage.unDefinedError,"Okay button");
    }
    public String selectBatterlyResolutionCodeInMCDClearWindow() throws Throwable{
        Thread.sleep(2000);
        //mouseDoubleClick(DIMCDPage.lblBatteryResoultionCodeOnClearingCall,"G306 Pace settercode selected");
        click(DIMCDPage.lblBatteryResoultionCodeOnClearingCall,"G306 Pace settercode selected");
        String paceSetterCode=getText(DIMCDPage.lblBatteryResoultionCodeOnClearingCall,"G306 Pace settercode selected");
        return paceSetterCode;
    }
    public void clearCallProcess() throws Throwable {

                spotStatus = getCallStatusOnMCDwindow();
                //getCallStatusOnMCDwindow();
                clickOnAssign();
                Thread.sleep(1000);
                assignStatus=getCallStatusOnMCDwindow();
                assertTrue(spotStatus!=assignStatus,"Status changed from   "+spotStatus+" To "+assignStatus);
                selectFacility();
                Thread.sleep(1000);
                facilityStatus=getCallStatusOnMCDwindow();
                assertTrue(facilityStatus!=assignStatus,"Status changed from   "+assignStatus+" To "+facilityStatus);
                selectDispatch();
                Thread.sleep(1000);
                dispatchStatus=getCallStatusOnMCDwindow();
                assertTrue(facilityStatus!=dispatchStatus,"Status changed from  "+facilityStatus+" To "+dispatchStatus);
                selectEnroute();
                selectEnrouteTime();
                Thread.sleep(1000);
                enrouteStatus=getCallStatusOnMCDwindow();
                assertTrue(enrouteStatus!=dispatchStatus,"Status changed from  "+dispatchStatus+" To "+enrouteStatus);
                selectOnLocation();
                Thread.sleep(1000);
                locationStatus=getCallStatusOnMCDwindow();
                assertTrue(locationStatus!=enrouteStatus,"Status changed from  "+enrouteStatus+" To "+locationStatus);
                Thread.sleep(1000);
                selectClearCall();
                //clickOnContinue();

        }

//Show Battery Services Buttons and its screen values
    public void clickOnShowBatteryServiceHistory()throws Throwable{
        click(DIMCDPage.btnShowBatteryServiceHistoryForRAP,"Show Battery Service History Button");
        }

        public boolean verifyShowBatteryServiceHisotryTabAvailablity()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.iconCloseBatteryInformationTab,"Battery Information Tab");
        boolean tabAvailablity = isVisibleOnly(DIMCDPage.iconCloseBatteryInformationTab,"Battery Information Tab");
        return tabAvailablity;
    }
    public String getDateAndCallIdInShowBatteryHistory()throws  Throwable{
        String dateAndCallId = getText(DIMCDPage.lblDateAndCallIdInShowBatteryHistory,"Call ID and date of the battery call");
        return dateAndCallId;
    }

    public String getResoultionCodeLableInShowBatteryHistory()throws  Throwable{
        String resolutionLabel = getText(DIMCDPage.lblResoultionCodeLableInShowBatteryHistory,"Resolution Code Lable");
        return resolutionLabel;
    }
    public String getResoultionCodeValueInShowBatteryHistory()throws  Throwable{
        String resolutionValue = getText(DIMCDPage.lblResoultionCodeValueInShowBatteryHistory,"Resolution Code Value");
        return resolutionValue;
    }
    public String getTestCodeLabelInShowBatteryHistory()throws  Throwable{
        String testCodeLabel = getText(DIMCDPage.lblTestCodeLabelInShowBatteryHistory,"Test Code Label");
        return testCodeLabel;
    }
    public String getTestCodeValueInShowBatteryHistory()throws  Throwable{
        String testCodeValue = getText(DIMCDPage.lblTestCodeValueInShowBatteryHistory,"Test Code Value");
        return testCodeValue;
    }
    public String getlblFacilityLabelInShowBatteryHistory()throws  Throwable{
        String facilityLabel = getText(DIMCDPage.lblFacilityLabelInShowBatteryHistory,"Facility Label");
        return facilityLabel;
    }
    public String getlblFacilityValueInShowBatteryHistory()throws  Throwable{
        String facilityValue = getText(DIMCDPage.lblFacilityValueInShowBatteryHistory,"Facility Value");
        return facilityValue;
    }
    public String getVehicleLableInShowBatteryHistory()throws  Throwable{
        String vehicleLabel = getText(DIMCDPage.lblVehicleLableInShowBatteryHistory,"Vehicle Label");
        return vehicleLabel;
    }
    public String getFacilityValueInShowBatteryHistory()throws  Throwable{
        String vehicleValue = getText(DIMCDPage.lblVehicleValueInShowBatteryHisotry,"Vehicle Value");
        return vehicleValue;
    }
    public void clickOnBatteryInformationCloseIcon()throws Throwable{
        click(DIMCDPage.iconCloseBatteryInformationTab,"Close Battery Information Tab");
    }

    public void clickOnDateAndCallIdInShowBatteryHistory()throws  Throwable{
        click(DIMCDPage.lblDateAndCallIdInShowBatteryHistory,"Call ID and date of the battery call");
    }
    public boolean verifyPrintButton ()throws  Throwable{
        boolean buttonVisibility=click(DIMCDPage.btnPrintInBatteryServiceHistory,"Print Button in Battery service history");
        return buttonVisibility;
    }
    public String getMemberNumberOnSummaryTab() throws Throwable {
        String memberNumber = getText(DIMCDPage.lblMemberNumberOnSummaryTabinMCD, "Member Number");
        return memberNumber;
    }
    public void verifyPopedUpOrPopedInMCDWindow(String popedinStatus) throws Throwable {
        switch(popedinStatus){
            case "Yes":
               clickOnPoppedOutButton();
                break;
            default:
                break;
        }
    }
    public void verifyPopedUpOrPopedOutMCDWindow(String popedOutStatus) throws Throwable {
        switch(popedOutStatus){
            case "Yes":
                clickOnPoppedInButton();
                break;
            default:
                break;
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectFacilityOnAssignTabForDataUpdate
     * description ::
     * date :: 12-Feb-2018
     * author ::Nidhi
     */
    public void selectFacilityOnAssignTabForDataUpdate() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.selectFacilityOnAssignTabForDataUpdate, "Select Facility");
        click(DIMCDPage.selectFacilityOnAssignTabForDataUpdate, "Select facility");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnEditLinkOfMemberSummaryInMCDWindow
     * description ::
     * date :: 15-Feb-2018
     * author ::chandra
     */
    public void clickOnEditLinkOfMemberSummaryInMCDWindow() throws Throwable {
        click(DIMCDPage.lnkEditInMemberSummaryInMCDWindow, "Edit Link");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAddCommentsButton
     * description ::
     * date :: 14-Feb-2018
     * author ::
     */
    public void clickOnAddCommentsButton() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnAddInMCDWindow, "Add Comments Button");
        click(DIMCDPage.btnAddInMCDWindow, "Click On Add Comments Button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCannedCommentsDroupDownLink
     * description ::
     * date :: 14-Feb-2018
     * author ::
     */
    public void clickOnCannedCommentsDroupDownLink() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lnkCannedCommentsDroupDown, "Canned Comments Droup Down");
        click(DIMCDPage.lnkCannedCommentsDroupDown, "Canned Comments Droup Down");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectCannedComment
     * description ::
     * date :: 14-Feb-2018
     * author ::
     */
    public void selectCannedComment(String CannedComment) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.selectCannedComment(CannedComment), "Canned Comment");
        click(DIMCDPage.selectCannedComment(CannedComment), "Select Canned Comment");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveButton
     * description ::
     * date :: 14-Feb-2018
     * author ::
     */
    public void clickOnSaveButton() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnSaveCannedComments, "Save  button");
        click(DIMCDPage.btnSaveCannedComments, "Canned Comments Save button");
    }

    public boolean commentVerification(String callIDAndDateCombined, String verificationTime, String verificationText) throws Throwable {
        boolean flag = false;
        String selectedComment = getText(DIMCDPage.lblCommentsInMCDWindow, "Get selected Comment From Comments Section");
        //WebElement element = driver.findElement(locator);
        String timeInComments = getText(DIMCDPage.lblESTTimeInComments, "Get Time From Comments Section");
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss a z");
        Date dateTime = format.parse(timeInComments);
        Date dateTime2 = format.parse(verificationTime.substring(9));
        String ti = verificationTime.substring(0, 8);
        long difference = dateTime2.getTime() - dateTime.getTime();
        long differenceSeconds = difference / 1000;
        if (timeInComments.contains(verificationTime) && (differenceSeconds <= 0 && differenceSeconds >= -60) && (selectedComment.contains(verificationText))) {
            flag = true;
        }
        return flag;
    }

    public String currentTime() {
        Date today = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss a z");
        //Uncomment it if required in US time zone
        //df.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
        String time = df.format(today);
        return time;
    }

    public List<String> getCannedCommentsList() throws Throwable {
        List<String> commentsList = new ArrayList<>();
        String comments;
        waitForVisibilityOfElement(DIMCDPage.listCannedComments, "Canned commentsList");
        cannedCommentsList = getWebElementList(DIMCDPage.listCannedComments, "Canned Comments List");
        if(cannedCommentsList!=null){
            for(int i=0;i<cannedCommentsList.size();i++) {
                comments = cannedCommentsList.get(i).getText();
                commentsList.add(comments);
            }

        }

        return commentsList;
    }

    public boolean verifyCannedCommentsInList(String cannedComment1, String cannedComment2, List<String> cannedCommentList) throws Throwable {
        boolean commentsFlag=false;
        boolean cannedcommentsFlag = (cannedCommentList.contains(cannedComment1) && cannedCommentList.contains(cannedComment2));
        if (cannedcommentsFlag) {
            commentsFlag = true;
        }
        return commentsFlag;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: selectFacilityOnAssignTabForDataUpdate
     * description ::
     * date :: 12-Feb-2018
     * author ::Nidhi
     *//*
    public void selectFacilityOnAssignTabForDataUpdate() throws Throwable {
        Thread.sleep(3000);
        waitForVisibilityOfElement(DIMCDPage.selectFacilityOnAssignTabForDataUpdate, "Select Facility");
        click(DIMCDPage.selectFacilityOnAssignTabForDataUpdate, "Select facility");
    }*/
    public String getStatusUpdateValueInMCDWindow()throws  Throwable{
        String updateStatus = getText(DIMCDPage.txtUpdateStatus,"Update status");
        return updateStatus;
    }


    public void selectExitCodeandChangeReasonandClickonContinue(String reason) throws Throwable {
        boolean errorMessage = false;
        selectExitCode();
        clickOnContinue();
        Thread.sleep(3000);
        errorMessage = verifyErrorMessageAtReasonInMCDWindow();
        if(errorMessage)
        {
            closeErrorAlert();
            clearData(DIMCDPage.txtReason);
            enterReason(reason);
            clickOnContinue();
        }

    }


    /**
     *Description:This method is used to verify Tow Destination Field on MCD for a RAP call.
     * Date:14-02-2018
     * @author :Madhukar
     * @return
     * @throws Throwable
     */
    public boolean verifyTowDestinationForRAPCall()throws Throwable{
        boolean towDestination=isVisibleOnly(DIMCDPage.lblTowDestinationOnLocationsForRAPTabinMCD,"Tow Destination");
        return towDestination;
    }
    /**
     *Description:This method is used to verify Member ClubCode Field on MCD for a RAP call.
     * Date:14-02-2018
     * @author :Madhukar
     * @return
     * @throws Throwable
     */
    public boolean verifyMemberClubCodeForRAPCall()throws Throwable{
        boolean clubCode=isVisibleOnly(DIMCDPage.lblMemberClubCodeOnMemberTabinMCD,"Member Club Code");
        return clubCode;
    }

    /**
     * Description:This method is used to get Call Date From MCD Window
     * Date:14-02-2018
     * @author :Madhukar
     * @throws Throwable
     */
    public void getCallDateFromMCD()throws Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblCallDateInMCD,"CallID Date");
        getText(DIMCDPage.lblCallDateInMCD,"CallID Date");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: labelCallCleared
     * description ::
     * date :: 15-Feb-2018
     * author ::Nidhi
     */
    public void getLabelCallCleared() throws Throwable {
        if(waitForVisibilityOfElement(DIMCDPage.lblCallCAStatus, "Call Cleared")) {
            getText(DIMCDPage.lblCallCAStatus, "Call Cleared");
            reporter.SuccessReport("The status of the call", "changed to CA");
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAalphabeticalOrderOfCannedComments
     * description ::
     * date :: 12-Feb-2018
     * author ::Lakshmi Prasanna
     */
    public boolean verifyAlphabeticalOrderOfCannedComments(List cannedCommentList)throws  Throwable{
        if (!cannedCommentList.isEmpty()) {
            Iterator<String> it = cannedCommentList.iterator();
            String prev = it.next();
            //while (it.hasNext()) {
            for(int i=0;i<cannedCommentList.size();i++){
                String next = it.next();
                if (prev.compareTo(next) > 0) {
                    return false;
                }
                prev = next;
            }
        }
        return true;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyPoppedOutButtonOnMCD
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public boolean verifyPoppedOutButtonOnMCD()throws Throwable{
        boolean poppedOutFlag = isVisibleOnly(DIMCDPage.lnkMaximizeMCDWindow,"Popped Out Button Is Visible");
        return poppedOutFlag;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getAddButtonName
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public String getAddButtonName()throws Throwable{
        waitForVisibilityOfElement(DIMCDPage.btnAdd, "Add button");
        String addButtonName = getText(DIMCDPage.btnAdd, "Add button");
        return addButtonName;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTheAddCommentScreen
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public String verifyTheAddCommentScreen()throws Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblAddCommentsScreen,"Add comment Screen name");
        String AddCommentsScreen = getText(DIMCDPage.lblAddCommentsScreen,"Get Add comment Screen name");
        return AddCommentsScreen;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTheAddCommentsScreenAsModal
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public boolean verifyTheAddCommentsScreenAsModal()throws Throwable{
        boolean isScreenModal =false;
        String callID = getCallIdFromMcdWindow();
        if(callID == null){
            isScreenModal=true;
        }
        return isScreenModal;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCancelButtonOnAddCommentsScreen
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void clickOnCancelButtonOnAddCommentsScreen()throws Throwable{
        waitForVisibilityOfElement(DIMCDPage.btnCancelOnAddComments,"Cancel Button On Add Comments Screen");
        click(DIMCDPage.btnCancelOnAddComments,"Cancel Button On Add Comments Screen");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAddCommentsWindowCloses
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public boolean verifyAddCommentsWindowCloses()throws Throwable{
        boolean isAddcommentsWindowvisible = isVisibleOnly(DIMCDPage.lnkCannedCommentsDroupDown,"Verifing the Canned Comments DroupDown");
        return isAddcommentsWindowvisible;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getCommentCountOnCommentSection
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public String getCommentCountOnCommentSection()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.commentCountValueOnCommentSection,"Comments count ");
        String commentsCount = getText(DIMCDPage.commentCountValueOnCommentSection,"Get Comments count from Comments Section");
        return commentsCount;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterComments
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void enterComments(String comment) throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtAddComment, "wait for txt Add Comment");
        type(DIMCDPage.txtAddComment, comment, "Add Comment from testdata");
        Thread.sleep(2000);
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getEnteredCommentsInTextArea
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public String getEnteredCommentsInTextArea() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.txtAddComment, "Get Added Comment");
        String comment =  getAttributeByValue(DIMCDPage.txtAddComment, "Get Added Comments");
        return comment;
    }

    public String getCommentsFromCommentsSection()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblCommentsInMCDWindow, "Comment From Comments Section");
        String selectedComment = getText(DIMCDPage.lblCommentsInMCDWindow, "Get selected Comment From Comments Section");
        return selectedComment;
    }
    public void editTheComments()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblCommentsInMCDWindow,"Double click On Comments");
        mouseJSDoubleClick(DIMCDPage.lblCommentsInMCDWindow,"Double click On Comments");
    }
    public String verifyEditCommentScreen()throws  Throwable{
        waitForVisibilityOfElement(DIMCDPage.lblEditComment,"Edit comment Lable");
        String editComment = getText(DIMCDPage.lblEditComment,"Edit comment Lable Name");
        return editComment;
    }
    public void clickOnCanceButtonOnEditCall()throws Throwable{
        waitForVisibilityOfElement(DIMCDPage.btnCancelOnEditComment,"Cancel Button On Comments Edit Screen");
        click(DIMCDPage.btnCancelOnEditComment,"Cancel Button On Comments Edit Screen");
    }
    public boolean visibilityOfAddButtonOnCommentsSection()throws  Throwable{
        boolean isAddButtonVisible = isVisibleOnly(DIMCDPage.btnAdd,"Add Button On Comments Section");
        return isAddButtonVisible;
    }
    public void changeTheStatusOfCommentsFromVisibleToHidden()throws Throwable{
        selectByIndex(DIMCDPage.statusHiddenOrVisible,1,"Status Changed To Hidden");
    }
    public void clickOnSaveButtonOnEditCommentScreen()throws Throwable{
        waitForVisibilityOfElement(DIMCDPage.btnSaveOnEditCommentScreen,"Save Button");
        click(DIMCDPage.btnSaveOnEditCommentScreen,"Save Button");
    }
    public String hiddenCommentStatus(String callIDAndDate)throws  Throwable{
        isVisibleOnly(DIMCDPage.hiddenCommentStatus(callIDAndDate),"Status Of Comment after Hiding ");
        String status = getText(DIMCDPage.hiddenCommentStatus(callIDAndDate),"Status Of Comment after Hiding ");
        return status;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFieldsToDisplayInPacesetter
     * description ::getFields To Display In Pacesetter
     * date :: 16-Feb-2018
     * author ::Ravi
     */
    public void getFieldsToDisplayInPacesetter() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.lblFirstPacesetterValue, "first pacesetter value") ;
        getText(DIMCDPage.lblFirstPacesetterValue, "first pacesetter value");
        getText(DIMCDPage.lblSecondPacesetterValue, "second pacesetter value");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getEditLink
     * description ::
     * date :: 16-Feb-2018
     * author ::Ravi
     */
    public void getEditAndClick() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.editLink, "edit link");
        getText(DIMCDPage.editLink, "get edit icon");
        dynamicWaitByLocator(DIMCDPage.editLink, 3);
        click(DIMCDPage.editLink, "click on edit icon");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyEditDropdownSection
     * description ::
     * date :: 16-Feb-2018
     * author ::Ravi
     */
    public void verifyEditDropdownSection() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.editLink, "edit link");
        getText(DIMCDPage.editLink, "get edit icon");
        dynamicWaitByLocator(DIMCDPage.editLink, 3);
        click(DIMCDPage.editLink, "click on edit icon");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getEditLink
     * description ::
     * date :: 16-Feb-2018
     * author ::Ravi
     */
    public void getEditDropdownSelection() throws Throwable {
        waitForVisibilityOfElement(DIMCDPage.btnSaveInService, "wait for save button");

        isVisibleOnly(DIMCDPage.drpDwnPacesetterCode1, "pacesetter code 1 is visible");
        isVisibleOnly(DIMCDPage.drpDwnPacesetterCode1, "pacesetter code 2 is visible");
        getText(DIMCDPage.btnSaveInService, "get save ");
        getText(DIMCDPage.btnCancelInService, "get cancel");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getEditLink
     * description ::
     * date :: 16-Feb-2018
     * author ::Ravi
     */
    public void getListOfPacesetterCode1Dropdwn() throws Throwable {
  /*  waitForVisibilityOfElement(DIMCDPage.drpDwnPacesetterCode1, "wait for pacesetter code1");

    click(DIMCDPage.drpDwnPacesetterCode1, "click on pacesetter 1 dropdown");
   */

    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnPoppedOutButtonInActionRequiredTab
     * description ::
     * date :: 16-Feb-2018
     * author ::Nidhi
     */
    public void clickOnPoppedOutButtonInActionRequiredTab()throws  Throwable{
        if(waitForVisibilityOfElement(DIMCDPage.btnPopOutInActionRequiredTab,"PoppedOut Button")) {
            isVisibleOnly(DIMCDPage.btnPopOutInActionRequiredTab, "PoppedOut Button");
            click(DIMCDPage.btnPopOutInActionRequiredTab, "PoppedOut Button");
            Thread.sleep(5000);
            switchToWindow();
            Thread.sleep(3000);
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickToClosePoppedOutButtonInActionRequiredTab
     * description ::
     * date :: 16-Feb-2018
     * author ::Nidhi
     */
    public void clickToClosePoppedOutButtonInActionRequiredTab()throws  Throwable{
        if(waitForVisibilityOfElement(DIMCDPage.btnPopOutInActionRequiredTab,"PoppedOut Button")) {
            isVisibleOnly(DIMCDPage.btnPopOutInActionRequiredTab, "PoppedOut Button");
            click(DIMCDPage.btnPopOutInActionRequiredTab, "PoppedOut Button");
            Thread.sleep(5000);
            switchToWindow();
        }
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTowDestinationEditLink
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void clickOnTowDestinationEditLinkInMCD() throws Throwable {
        click(DIMCDPage.lnkEditTowDestinationInServicesTabInMCDWindow, "Tow destination Edit");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnBreakDownLocationsEditLink
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void clickOnBreakDownLocationsEditLinkInMCD() throws Throwable {
        click(DIMCDPage.lnkEditBreakDownLocationInServicesTabInMCDWindow, "BreakDown Locations Edit");
    }
    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterStreetNumber
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterStreetNumberInMCD(String streetNumber) throws Throwable {
        type(DIMCDPage.txtStreetNumberInServicesTabInMCDWindow, streetNumber,"Street Number");
        return streetNumber;
    }
    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterStreetNumber
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterStreetNameInMCD(String streetName) throws Throwable {
        type(DIMCDPage.txtStreetNameInServicesTabInMCDWindow, streetName,"Street Name");
        return streetName;
    }
    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterFirstCrossStreet
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterFirstCrossStreetInMCD(String crossstreet) throws Throwable {
        type(DIMCDPage.txtCrossStreet1InServicesTabInMCDWindow, crossstreet,"first Cross Street ");
        return crossstreet;
    }
    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterSecondCrossStreet
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterSecondCrossStreetInMCD(String secondcrossstreet) throws Throwable {
        type(DIMCDPage.txtCrossStreet2InServicesTabInMCDWindow, secondcrossstreet,"Second Cross Street ");
        return secondcrossstreet;
    }
    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterCity
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterCityInMCD(String city) throws Throwable {
        type(DIMCDPage.txtCityInServicesTabInMCDWindow, city,"City ");
        return city;
    }

    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterStateInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterStateInMCD(String state) throws Throwable {
        type(DIMCDPage.txtStateInServicesTabInMCDWindow, state,"State ");
        return state;
    }
    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterZipInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterZipInMCD(String zip) throws Throwable {
        type(DIMCDPage.txtZipInServicesTabInMCDWindow, zip,"Zip ");
        return zip;
    }
    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterLandMarkInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterLandMarkInMCD(String landMark) throws Throwable {
        type(DIMCDPage.txtLandMarkInServicesTabInMCDWindow, landMark,"LandMark ");
        return landMark;
    }
    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterLatitudeInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterLatitudeInMCD(String Latitude) throws Throwable {
        type(DIMCDPage.txtLatitudeInServicesTabInMCDWindow, Latitude,"Latitude ");
        return Latitude;
    }
    /**
     * param :: input string
     * return ::void
     * throws :: throwable
     * methodName :: enterLongitudeInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterLongitudeInMCD(String Longitude) throws Throwable {
        type(DIMCDPage.txtLongitudeInServicesTabInMCDWindow, Longitude,"Longitude ");
        return Longitude;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getAddressVerifiedInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public boolean getAddressVerifiedInMCD() throws Throwable {
        boolean addressVerified = isVisibleOnly(DIMCDPage.lblAddressVerifiedInServicesTabInMCDWindow, "Address Verified");
        return addressVerified;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterUpdateReasonInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterUpdateReasonInMCD(String updateReason) throws Throwable {
        type(DIMCDPage.txtUpdateReasonInServicesTabInMCDWindow,updateReason,"Update Reason");
        return updateReason;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSaveButtonInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void clickOnSaveButtonInMCDWindow() throws Throwable {
        click(DIMCDPage.btnSaveButtonInServicesTabInMCDWindow,"Save Button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCancelButtonInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void clickOnCancelButtonInMCDWindow() throws Throwable {
        click(DIMCDPage.btnCancelButtonInServicesTabInMCDWindow,"Cancel Button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyBreakDownLoactionsTabInMCDWIndow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public boolean verifyBreakDownLoactionsTabInMCDWIndow() throws Throwable {
     boolean breakDownlocation= isVisibleOnly(DIMCDPage.btnCancelButtonInServicesTabInMCDWindow,"Breakdown location Tab");
     return breakDownlocation;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyBreakDownLoactionsTabInMCDWIndow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void closeBreakDownLoactionsTabInMCDWIndow() throws Throwable {
        click(DIMCDPage.btnCancelButtonInServicesTabInMCDWindow,"BreakDown locations Tab");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterAddressInSearvicesInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterAddressInSearvicesInMCDWindow(String addressSearch) throws Throwable {
        type(DIMCDPage.txtAddressSearchInServicesInMCDWindow,addressSearch,"AddressSearch");
        return addressSearch;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnSearchButtonInServicesInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void clickOnSearchButtonInServicesInMCDWindow() throws Throwable {
        click(DIMCDPage.btnSearchButtonInServicesInMCDWindow,"Search button");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnManualAddressEntryInServicesInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public void clickOnManualAddressEntryInServicesInMCDWindow() throws Throwable {
        click(DIMCDPage.lnkManualAddressEntryInTowDestinationInMCDWindow,"Manual Address Entry ");
    }
    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLocationNameInTowDestinationInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterLocationNameInTowDestinationInMCDWindow(String towLocationName) throws Throwable {
        type(DIMCDPage.txtLocationNameInTowDestinationInMCDWindow,towLocationName,"Locaiton Name ");
        return towLocationName;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTowDestinationAddressFromResults
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getTowDestinationAddressFromResults() throws Throwable {
        boolean emptryRecords= getEmptryRecordErrorMessageInMCD();
        boolean recordsPanelNotFund = verifySearchResultsGridAvailablity();
        if(!emptryRecords || !recordsPanelNotFund){
             towDestinationAddress=getText(DIMCDPage.lnkSelectFirstRowInSearchResultsInBreakDownLoaciton,"Tow Destination Address");
             city = getText(DIMCDPage.lblCityInTowDestinationSearchResultsGridInServicesInMCD,"City Value");
             State = getText(DIMCDPage.lblStateInTowDestinationSearchResultsGridInServicesInMCD,"State Value");
             Zip= getText(DIMCDPage.lblZipInTowDestinationSearchResultsGridInServicesInMCD,"Zip Value");



        }else   {
                     assertFalse(emptryRecords,"Recrods not found");
                }
         String searchedAddress = towDestinationAddress + " "+ city+" " + State + " "+ Zip;
        return searchedAddress;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTowDestinationAddressInResultsGrid
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public void clickOnTowDestinationAddressInResultsGrid() throws Throwable {
       boolean emptryRecords= getEmptryRecordErrorMessageInMCD();
        if(emptryRecords) {
            assertFalse(emptryRecords,"Records not found");
        }else{
            mouseDoubleClick(DIMCDPage.lnkSelectFirstRowInSearchResultsInBreakDownLoaciton,"Tow Destination Address");
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfStreetNumberInMCDWindow
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfStreetNumberInMCDWindow() throws Throwable {
        String streetNumber=getAttributeByValue(DIMCDPage.txtStreetNumberInServicesTabInMCDWindow,"StreetNumber value");
        return streetNumber;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfStreetNameInMCDWindow
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfStreetNameInMCDWindow() throws Throwable {
        String streetName=getAttributeByValue(DIMCDPage.txtStreetNameInServicesTabInMCDWindow,"Street Name");
        return streetName;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfFirstCrossStreetInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfFirstCrossStreetInMCD() throws Throwable {
        String crossStreet=getAttributeByValue(DIMCDPage.txtCrossStreet1InServicesTabInMCDWindow,"first Cross Street ");
        return crossStreet;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfSecondCrossStreetInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfSecondCrossStreetInMCD() throws Throwable {
        String secondcrossstreet= getAttributeByValue(DIMCDPage.txtCrossStreet2InServicesTabInMCDWindow, "Second Cross Street ");
        return secondcrossstreet;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfCityInMCD
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String getValueOfCityInMCD() throws Throwable {
        String city=getAttributeByValue(DIMCDPage.txtCityInServicesTabInMCDWindow,"City ");
        return city;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfStateInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfStateInMCD() throws Throwable {
        String state=getAttributeByValue(DIMCDPage.txtStateInServicesTabInMCDWindow,"State ");
        return state;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfZipInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfZipInMCD() throws Throwable {
        String zip=getAttributeByValue(DIMCDPage.txtZipInServicesTabInMCDWindow,"Zip ");
        return zip;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterLandMarkInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfLandMarkInMCD() throws Throwable {
        String landMark=getAttributeByValue(DIMCDPage.txtLandMarkInServicesTabInMCDWindow,"LandMark ");
        return landMark;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfLatitudeInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfLatitudeInMCD() throws Throwable {
        String Latitude=getAttributeByValue(DIMCDPage.txtLatitudeInServicesTabInMCDWindow,"Latitude ");
        return Latitude;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getValueOfLongitudeInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public String getValueOfLongitudeInMCD() throws Throwable {
        String Longitude=getAttributeByValue(DIMCDPage.txtLongitudeInServicesTabInMCDWindow,"Longitude ");
        return Longitude;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getEmptryRecordErrorMessageInMCD
     * description ::
     * date :: 17-Feb-2018
     * author ::Chandu
     */
    public boolean getEmptryRecordErrorMessageInMCD() throws Throwable {
        boolean emptryRecords=isVisibleOnly(DIMCDPage.lblEmptyResultsRowInSearchResultsInMCDWIndow,"Emptry Records ");
        return emptryRecords;
    }

    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCommentsInTowDestinationAndLocationsTabsInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String enterCommentsInTowDestinationAndLocationsTabsInMCDWindow(String comments) throws Throwable {
        type(DIMCDPage.txtCommentsInEditLocationsAndTowDestinationsTabs,comments,"comments");
        return comments;
    }
    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCommentsInTowDestinationAndLocationsTabsInMCDWindow
     * description ::
     * date :: 16-Feb-2018
     * author ::Chandu
     */
    public String validateErrorMessage() throws Throwable {
       String errorMessage= getText(DIMCDPage.lblErrorMessageOnAlert,"Error Message");
        return errorMessage;
    }
    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnErrorOkayButtonInMCDWindow
     * description ::
     * date :: 18-Feb-2018
     * author ::Chandu
     */
   public void clickOnErrorOkayButtonInMCDWindow()throws Throwable{
       click(DIMCDPage.btnOkayOnErrorMessage,"Okay Button");
   }
    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnGetCoOrdinatesInMCD
     * description ::
     * date :: 18-Feb-2018
     * author ::Chandu
     */
    public void clickOnGetCoOrdinatesInMCD()throws Throwable{
        click(DIMCDPage.btnGetAddressCoordinatesInMCDWindow,"Get Address Coordinates");
    }
    public boolean verifySearchResultsGridAvailablity() throws Throwable{
        boolean resultsVisibiltiy = isVisibleOnly(DIMCDPage.resultsGridVerifications,"Results Grid");
        return resultsVisibiltiy;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getAddressFromResults
     * description ::
     * date :: 18-Feb-2018
     * author ::Chandu
     */
    public String getAddressFromResults() throws Throwable {
            towDestinationAddress=getText(DIMCDPage.lnkSelectFirstRowInSearchResultsInBreakDownLoaciton,"Tow Destination Address");
            city = getText(DIMCDPage.lblCityInTowDestinationSearchResultsGridInServicesInMCD,"City Value");
            State = getText(DIMCDPage.lblStateInTowDestinationSearchResultsGridInServicesInMCD,"State Value");
            Zip= getText(DIMCDPage.lblZipInTowDestinationSearchResultsGridInServicesInMCD,"Zip Value");
            String searchedAddress = towDestinationAddress + " "+ city+" " + State + " "+ Zip;
            return searchedAddress;
    }
    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyErrorMessageAvailability
     * description ::
     * date :: 18-Feb-2018
     * author ::Chandu
     */
    public boolean verifyErrorMessageAvailability() throws Throwable {
        boolean errorMessageAvailability= isVisibleOnly(DIMCDPage.lblErrorMessageOnAlert,"Error Message");
        return errorMessageAvailability;
    }
    /**
     * param :: inputs
     * return ::void
     * throws :: throwable
     * methodName :: closeBreakDownLocaitonTabInMCD
     * description ::
     * date :: 18-Feb-2018
     * author ::Chandu
     */
    public void closeBreakDownLocaitonTabInMCD() throws Throwable {
        click(DIMCDPage.iconBreakDownLocationsCloseInMCDWindow,"Breakdown location tab");

    }

}
