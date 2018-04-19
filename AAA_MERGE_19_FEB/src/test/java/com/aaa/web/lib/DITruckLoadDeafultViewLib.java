package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;

import com.aaa.web.page.CRSearchCallsPage;
import com.aaa.web.page.CRVehicleTriagePage;
import com.aaa.web.page.DIHomePage;
import com.aaa.web.page.DITruckLoadDefaultViewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by e002222 on 09-02-2018.
 */
public class DITruckLoadDeafultViewLib extends ActionEngine {


    public List<WebElement> allFacility;
    public String facilityFromList;
    Boolean FacilityFlag;
    List<WebElement> commentsList = new ArrayList<WebElement>();
    public List<WebElement> allTruckIds;
    public String callIdFromList;
    Boolean truckIDFlag;
    /**
     * param ::
     * return ::Boolean
     * throws :: throwable
     * methodName :: verifyCommentColmnOnDefaultTruckLoad
     * description ::
     * date :: 06-feb-2018
     * author ::Varun
     */
    public Boolean verifyCommentColmnOnDefaultTruckLoad() throws Throwable
    {

        Boolean verifyCommentCol=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblCommentColmnOnDefaultTruckLoad, "Comment Column in Truck default view");
        return verifyCommentCol;
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: rightClickActiveDriverOnDefaultTruckLoad
     * description ::
     * date :: 12-feb-2018
     * author ::Varun
     */
    public void rightClickActiveDriverOnDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.activeTruckRowOnDefaultTruckLoad, "Active truck driver");
        rightClick(DITruckLoadDefaultViewPage.activeTruckRowOnDefaultTruckLoad, "Right click on active truck driver");
        Thread.sleep(5000);
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: rightClickActiveDriverOnDefaultTruckLoad
     * description ::
     * date :: 12-feb-2018
     * author ::Varun
     */
    public void mouseHoverOnDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.mouseHoverOnDriverOption, "Driver option");
        mouseHover(DITruckLoadDefaultViewPage.mouseHoverOnDriverOption, "Driver option");
        Thread.sleep(3000);
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickSetDriverCommentDefaultTruckLoad
     * description ::
     * date :: 12-feb-2018
     * author ::Varun
     */
    public void clickSetDriverCommentDefaultTruckLoad() throws Throwable
    {

        //mouseHover(DITruckLoadDefaultViewPage.lblSetDriverComment, "Set Driver comments");
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblSetDriverComment, "Set Driver comments");
        click(DITruckLoadDefaultViewPage.lblSetDriverComment, "Set Driver comments");
        Thread.sleep(5000);
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: typeDrivercomment
     * description ::
     * date :: 12-feb-2018
     * author ::Varun
     */
    public void typeDrivercomment(String comment) throws Throwable
    {



        type(DITruckLoadDefaultViewPage.txtCommentField, comment, "Enter driver Comment");
        Thread.sleep(5000);
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickDrivercommentSaveBtn
     * description ::
     * date :: 12-feb-2018
     * author ::Varun
     */
    public void clickDrivercommentSaveBtn() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.btnSaveDriverCommentWindow, "Save Button");
        click(DITruckLoadDefaultViewPage.btnSaveDriverCommentWindow, "Save Button");
        Thread.sleep(5000);
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyDrivercommentIcon
     * description ::
     * date :: 12-feb-2018
     * author ::Varun
     */
    public Boolean verifyDrivercommentIcon() throws Throwable
    {


        Boolean verifyCommentIcon=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.iconDriverComment, "Comment Icon");
        return verifyCommentIcon;

    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyDrivercommentTxt
     * description ::
     * date :: 12-feb-2018
     * author ::Varun
     */
    public String verifyDrivercommentTxt() throws Throwable
    {


        String driverComment=getText(DITruckLoadDefaultViewPage.txtCommentAdded, "Comment added");
        return driverComment;

    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyCommentIconHoverTxt
     * description ::
     * date :: 12-feb-2018
     * author ::Varun
     */
    public String verifyCommentIconHoverTxt() throws Throwable
    {


        String IconHoverComment=getAttributeValue(DITruckLoadDefaultViewPage.iconDriverComment, "title");
        return IconHoverComment;

    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickClearDriverCommentDefaultTruckLoad
     * description ::
     * date :: 12-feb-2018
     * author ::Varun
     */
    public void clickClearDriverCommentDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblClearDriverComment, "Clear Driver comments");
        click(DITruckLoadDefaultViewPage.lblClearDriverComment, "Clear Driver comments");
        Thread.sleep(10000);
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyNoDrivercommentIcon
     * description ::
     * date :: 12-feb-2018
     * author ::Varun
     */
    public Boolean verifyNoDrivercommentIcon() throws Throwable
    {


        Boolean verifyNoCommentIcon=waitForInVisibilityOfElement(DITruckLoadDefaultViewPage.iconDriverComment, "Comment Icon");
        return verifyNoCommentIcon;

    }





    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyActiveTruckOnDefaultTruckLoad
     * description ::
     * date :: 13-feb-2018
     * author ::Varun
     */
    public Boolean verifyActiveTruckOnDefaultTruckLoad() throws Throwable
    {
        Boolean verifyActiveTruck=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.activeTruckRowOnDefaultTruckLoad, "Verify Active trucks");
        return verifyActiveTruck;


    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyInActiveTruckOnDefaultTruckLoad
     * description ::
     * date :: 13-feb-2018
     * author ::Varun
     */
    public Boolean verifyInActiveTruckOnDefaultTruckLoad() throws Throwable
    {
        Boolean verifyInActiveTruck=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.inActiveTruckRowOnDefaultTruckLoad, "Verify InActive trucks");
        return verifyInActiveTruck;


    }





    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickActiveBtnOnDefaultTruckLoad
     * description ::
     * date :: 13-feb-2018
     * author ::Varun
     */
    public void clickActiveBtnOnDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.btnActive, "Active Button");
        click(DITruckLoadDefaultViewPage.btnActive, "Active Button");
        Thread.sleep(5000);

    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyAllActiveTrucksOnDefaultTruckLoad
     * description ::
     * date :: 13-feb-2018
     * author ::Varun
     */
    public Boolean verifyAllActiveTrucksOnDefaultTruckLoad() throws Throwable
    {
        Boolean verifyActiveTruck=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.AllActiveTruckRowOnDefaultTruckLoad, "All active trucks");
        return verifyActiveTruck;


    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: rightClickActiveSpecificTruckOnDefaultTruckLoad
     * description ::
     * date :: 13-feb-2018
     * author ::Varun
     */
    public void rightClickActiveSpecificTruckOnDefaultTruckLoad(String TRUCKID) throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.ActiveTruckID(TRUCKID), "Active truck driver");
        rightClick(DITruckLoadDefaultViewPage.ActiveTruckID(TRUCKID), "Right click on active truck driver");
        Thread.sleep(5000);
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickSetTruckToInactive
     * description ::
     * date :: 13-feb-2018
     * author ::Varun
     */
    public void clickSetTruckToInactive() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblSetTruckInactive, "Set truck to inactive");
        click(DITruckLoadDefaultViewPage.lblSetTruckInactive, "Set truck to inactive");
        Thread.sleep(5000);

    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickSetTruckToActive
     * description ::
     * date :: 13-feb-2018
     * author ::Varun
     */
    public void clickSetTruckToActive() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblSetTruckActive, "Set truck to Active");
        click(DITruckLoadDefaultViewPage.lblSetTruckActive, "Set truck to Active");
        Thread.sleep(5000);

    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: rightClickInActiveSpecificTruckOnDefaultTruckLoad
     * description ::
     * date :: 13-feb-2018
     * author ::Varun
     */
    public void rightClickInActiveSpecificTruckOnDefaultTruckLoad(String TRUCKID) throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.InActiveTruckID(TRUCKID), "In active truck driver");
        rightClick(DITruckLoadDefaultViewPage.InActiveTruckID(TRUCKID), "Right click on In active truck driver");
        Thread.sleep(5000);
    }


    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyIconChangeToInactive
     * description ::
     * date :: 14-feb-2018
     * author ::Varun
     */
    public Boolean verifyIconChangeToInactive(String TRUCKID) throws Throwable
    {


        Boolean verifyIconToInactive=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.verifyInActiveIconOfTruckID(TRUCKID), "Active status change to Inactive");
        return verifyIconToInactive;

    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyIconChangeToActive
     * description ::
     * date :: 14-feb-2018
     * author ::Varun
     */
    public Boolean verifyIconChangeToActive(String TRUCKID) throws Throwable
    {


        Boolean verifyIconToActive=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.verifyActiveIconOfTruckID(TRUCKID), "In Active status change to Active");
        return verifyIconToActive;

    }
    public void clickOnFacilityOnDefaultTruck(String facility)throws  Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.selectFacility(facility),"Click On Facility");
        click(DITruckLoadDefaultViewPage.selectFacility(facility),"Click On Facility");
    }

    public void rightClickOnCallIDOnTruckLoad(String CallIdAndDate)throws  Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.selectCallIDOnTruckLoad(CallIdAndDate),"Right Click On Call Id in truck Load");
        rightClick(DITruckLoadDefaultViewPage.selectCallIDOnTruckLoad(CallIdAndDate),"Right Click On Call Id in truck Load");
        Thread.sleep(5000);
    }
    public String getTextFromLinkRemoveFavoriteCall(String callIDAndDate)throws Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lnkRemoveCallFavorite(callIDAndDate),"Text From Remove From Favorite Link");
        String textRemoveFavorite = getText(DITruckLoadDefaultViewPage.lnkRemoveCallFavorite(callIDAndDate),"Text From Remove From Favorite Link");
        return textRemoveFavorite;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyandGetAllCallsCounter
     * description ::
     * date :: 14-feb-2018
     * author ::Varun
     */
    public String verifyandGetAllCallsCounter() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.txtAllCallsCounter, "All call counter");
        String allCallsCounter=getText(DITruckLoadDefaultViewPage.txtAllCallsCounter,"All calls counter");
        return allCallsCounter;

    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: verifyandGetUnassignedCallsCounter
     * description ::
     * date :: 14-feb-2018
     * author ::Varun
     */
    public String verifyandGetUnassignedCallsCounter() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.txtUnassignedCallsCounter, "Unassigned call counter");
        String unassignedCounter=getText(DITruckLoadDefaultViewPage.txtUnassignedCallsCounter,"Unassigned calls counter");
        return unassignedCounter;

    }


    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickUnassignedCallsGrid
     * description ::
     * date :: 14-feb-2018
     * author ::Varun
     */
    public void clickUnassignedCallsGrid() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblUnassignedCallsGid, "Unassigned call grid");
        click(DITruckLoadDefaultViewPage.lblUnassignedCallsGid, "Unassigned call grid");


    }

    //NIdhi
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: setTruckAtoInactive
     * description ::
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void setTruckAtoInactive() throws Throwable
    {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckA, "Truck A");
        rightClick(DITruckLoadDefaultViewPage.truckA,"Click on truck A");
        verifyTruckAAndsettoInactive();
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckAsettoInactive
     * description ::
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void verifyTruckAAndsettoInactive() throws Throwable {
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.setToInActive, "Truck A"))
        {
            click(DITruckLoadDefaultViewPage.setToInActive,"Click on truck A");
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: setTruckAtoInactive
     * description ::
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void setTruckBtoActive() throws Throwable
    {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckB, "Truck B");
        rightClick(DITruckLoadDefaultViewPage.truckB,"Click on truck B");
        verifyTruckBAndsettoActive();
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckBAndsettoInactive
     * description ::
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void verifyTruckBAndsettoActive() throws Throwable {
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.setToActive, "Truck B"))
        {
            click(DITruckLoadDefaultViewPage.setToActive,"Click on truck B");
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckAsettoActive
     * description ::
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void verifyTrucksettoActive() throws Throwable {
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.setToInActive, "Truck A"))
        {
            reporter.SuccessReport("Successfully changed from ","Active to Inactive automatically");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckAsettoActive
     * description ::
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void clickOnTruckB() throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckB, "Truck B");
        click(DITruckLoadDefaultViewPage.truckB, "Truck B");

    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getUpdatedStatus
     * description ::
     * date :: 12-feb-2018
     * author ::Nidhi
     */
    public void getUpdatedStatus() throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.callStatus, "Call");
        click(DITruckLoadDefaultViewPage.truckB, "Truck B");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: setTruckBToOutOfVehicle
     * description ::
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void setTruckBToOutOfVehicle() throws Throwable
    {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckB, "Truck B");
        rightClick(DITruckLoadDefaultViewPage.truckB,"Click on truck B");
        verifyTruckBAndsettoOutOfVehicle();
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTruckBToAddComment
     * description ::
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void clickOnTruckBToAddComment() throws Throwable
    {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckB, "Truck B");
        rightClick(DITruckLoadDefaultViewPage.truckB,"Click on truck B");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: setTruckBToInVehicle
     * description ::
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void setTruckBToInVehicle() throws Throwable
    {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckB, "Truck B");
        rightClick(DITruckLoadDefaultViewPage.truckB,"Click on truck B");
        verifyTruckBAndsettoInVehicle();
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckBAndsettoInVehicle
     * description ::
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void verifyTruckBAndsettoInVehicle() throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.mouseHoverOnSetDriverStatusOption, "Set Driver Status option");
        mouseHover(DITruckLoadDefaultViewPage.mouseHoverOnSetDriverStatusOption, "Set Driver Status option");
        Thread.sleep(3000);
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.inVehicle, "out of vehicle"))
        {
            click(DITruckLoadDefaultViewPage.inVehicle,"out of vehicle");
            Thread.sleep(2000);
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckBAndsettoOutOfVehicle
     * description ::
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void verifyTruckBAndsettoOutOfVehicle() throws Throwable {
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.mouseHoverOnSetDriverStatusOption, "Set Driver Status option");
        mouseHover(DITruckLoadDefaultViewPage.mouseHoverOnSetDriverStatusOption, "Set Driver Status option");
        Thread.sleep(3000);
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.outOfVehicle, "out of vehicle"))
        {
            click(DITruckLoadDefaultViewPage.outOfVehicle,"out of vehicle");
            Thread.sleep(2000);
            click(DITruckLoadDefaultViewPage.btnSaveOnOutOfVehiclePopup,"out of vehicle");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckBStatusOutOfVehicle
     * description ::
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void verifyTruckBStatusOutOfVehicle() throws Throwable {
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.outOfVehicleStatus, "vehicle status")) {

            reporter.SuccessReport("The driver status for truck B should have automatically changed from ","In-vehicle to Out-of-Vehicle");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTruckBStatusInVehicle
     * description ::
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void verifyTruckBStatusInVehicle() throws Throwable {
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.inVehicleStatus, "vehicle status")) {

            reporter.SuccessReport("The driver status for truck B should have automatically changed from ","Out-of-Vehicle  to In-Vehicle");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyDriverComment
     * description ::
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void verifyDriverComment() throws Throwable {
        if (waitForVisibilityOfElement(DITruckLoadDefaultViewPage.driverCommentIcon, "Comment icon")) {

            reporter.SuccessReport("The comment icon successfully","appeared on the driver ");
            mouseHover(DITruckLoadDefaultViewPage.driverCommentIcon, "Comment icon");
            Thread.sleep(2000);
            getText(DITruckLoadDefaultViewPage.driverCommentIcon, "Comment icon");
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyDriverCommentClear
     * description ::
     * date :: 14-feb-2018
     * author ::Nidhi
     */
    public void verifyDriverCommentClear() throws Throwable {
        if (!waitForVisibilityOfElement(DITruckLoadDefaultViewPage.driverCommentIcon, "Comment icon")) {

            reporter.SuccessReport("The comment icon successfully","removed for  the driver ");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyCallIdOnTruckDefaultViewPage
     * description ::
     * date :: 15-feb-2018
     * author ::Varun
     */
    public Boolean verifyCallIdOnTruckDefaultViewPage(String callID, String calldate)throws Throwable{
        Boolean callDisplayOnTruckDefault=waitForVisibilityOfElement(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate),"CallId On Truck default view page");
        return callDisplayOnTruckDefault;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: rightClickCallIdOnTruckDefaultViewPage
     * description ::
     * date :: 15-feb-2018
     * author ::Varun
     */
    public void rightClickCallIdOnTruckDefaultViewPage(String callID, String calldate)throws Throwable{

        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate),"CallId On Truck default view page");
        rightClick(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate), "CallId On Truck default view page");
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: mouseHoverOnCallStatusDefaultTruckLoad
     * description ::
     * date :: 15-feb-2018
     * author ::Varun
     */
    public void mouseHoverOnCallStatusDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lnkCallStatus, "Call status");
        mouseHover(DITruckLoadDefaultViewPage.lnkCallStatus, "Call status");
        Thread.sleep(2000);
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: mouseHoverOnAssignStatusDefaultTruckLoad
     * description ::
     * date :: 15-feb-2018
     * author ::Varun
     */
    public void mouseHoverOnAssignStatusDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lnlAssignCallStatus, "Assign Call status");
        mouseHover(DITruckLoadDefaultViewPage.lnlAssignCallStatus, "Assign Call status");
        Thread.sleep(2000);
    }
    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickOnAssignStatusTruckDefaultTruckLoad
     * description ::
     * date :: 15-feb-2018
     * author ::Varun
     */
    public void clickOnAssignStatusTruckDefaultTruckLoad() throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lnkOfFirstTruck, "Select truck");
        click(DITruckLoadDefaultViewPage.lnkOfFirstTruck, "Select truck");
        Thread.sleep(2000);
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: getTruckIDOfCallIDDefaultTruckLoad
     * description ::
     * date :: 15-feb-2018
     * author ::Varun
     */
    public String getTruckIDOfCallIDDefaultTruckLoad(String callID, String calldate) throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckIDFromCallDefaultView(callID, calldate), "Truck ID");
        String truckID=getText(DITruckLoadDefaultViewPage.truckIDFromCallDefaultView(callID, calldate), "Truck ID");
        Thread.sleep(2000);
        return truckID;
    }

    /**
     * param ::
     * return ::
     * throws :: throwable
     * methodName :: clickTruckIDOfCallID
     * description ::
     * date :: 15-feb-2018
     * author ::Varun
     */
    public void clickTruckIDOfCallID(String truckID) throws Throwable
    {


        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.truckIDOnTruckView(truckID), "Truck ID");
        click(DITruckLoadDefaultViewPage.truckIDOnTruckView(truckID), "Truck ID");
                Thread.sleep(2000);

    }
    public void mouseHoverToCommentsOnTruckLoad(String callIdAndDate)throws Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lnkCommentsInTruckLoadContextMenu(callIdAndDate),"Comments In truck Load Context Menu");
        mouseHover(DITruckLoadDefaultViewPage.lnkCommentsInTruckLoadContextMenu(callIdAndDate),"Move Mouse To Comments In truck Load Context Menu");
        Thread.sleep(3000);
    }
    public void mouseHoverOntoAutoComment()throws Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.lblAutocomment,"Auto Comments In truck Load Context Menu");
        mouseHover(DITruckLoadDefaultViewPage.lblAutocomment,"Move Mouse To Auto Comments In truck Load Context Menu");
        Thread.sleep(3000);
    }
    public void selectComment(String autoComment)throws  Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.selectAutoComment(autoComment),"Auto Comment ");
        click(DITruckLoadDefaultViewPage.selectAutoComment(autoComment),"Auto Comment ");
    }
    public List<String> getCommentsListFromTruckLoad()throws  Throwable{
        List<String> commentList = new ArrayList<>();
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.listOfComments,"Comments List In Truck Load");
        commentsList = getWebElementList(DITruckLoadDefaultViewPage.listOfComments,"get Comments List From TruckLoad");
        if(commentsList!=null){
            for(int i=0;i<commentsList.size();i++){
                String comments = commentsList.get(i).getText();
                commentList.add(comments);
            }
        }
        return commentList;
    }





    /**
     * param ::Hashtable<String, String> data
     * return ::void
     * throws :: throwable
     * methodName :: verifyAllTruckIDsOfCalls
     * description ::
     * date :: 10-feb-2018
     * Updated date :: 29-Jan-2018
     * author ::Varun
     */
    public void verifyAllTruckIDsOfCalls(String TruckID) throws Throwable {
        boolean verifySearchResults = !isVisibleOnly(DITruckLoadDefaultViewPage.listOfTruckIDs, "Truck IDs in Truck calls window ");
        if (verifySearchResults) {
            assertTrue(verifySearchResults,"No Record found");
        }
        else{
            allTruckIds = getWebElementList(DITruckLoadDefaultViewPage.listOfTruckIDs, "Truck IDs in Truck calls window");

            for (int i = 0; i < allTruckIds.size(); i++) {
                callIdFromList = allTruckIds.get(i).getText();
                //String callIdFromExcel = TruckID;
                if (callIdFromList.contains(TruckID)) {
                    truckIDFlag=true;

                }
                else {
                    truckIDFlag=false;
                    break;

                }
            }
            // if(flag==true) {
            assertTrue(truckIDFlag, "Call Id " + TruckID + "Exists in Selected List");
            //}

        }
        Thread.sleep(4000);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickCallIdOnTruckDefaultViewPage
     * description ::
     * date :: 18-feb-2018
     * author ::Varun
     */
    public void clickCallIdOnTruckDefaultViewPage(String callID, String calldate)throws Throwable{

        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate),"CallId On Truck default view page");
        click(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate),"CallId On Truck default view page");

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickSPPdefaultTruckView
     * description ::
     * date :: 18-feb-2018
     * author ::Varun
     */
    public void clickSPPdefaultTruckView()throws  Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.sppTruckDefaultView,"Default truckload");
        click(DITruckLoadDefaultViewPage.sppTruckDefaultView,"Default truckload");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: doubleClickOnCallIdOnTruckWindow
     * description ::
     * date :: 18-feb-2018
     * author ::Varun
     */

    public void doubleClickOnCallIdOnTruckWindow(String callID, String calldate)throws Throwable{
        waitForVisibilityOfElement(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate),"Click On CallId Truck Calls");
        mouseJSDoubleClick(DITruckLoadDefaultViewPage.callIDInTruckDefaultView(callID, calldate),"Click On CallId On Tuck calls");
    }



}
