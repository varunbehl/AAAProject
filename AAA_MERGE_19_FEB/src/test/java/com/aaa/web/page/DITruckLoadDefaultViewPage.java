package com.aaa.web.page;

import org.openqa.selenium.By;

/**
 * Created by e002222 on 09-02-2018.
 */
public class DITruckLoadDefaultViewPage {



    public static By lblCommentColmnOnDefaultTruckLoad;

    public static By activeTruckRowOnDefaultTruckLoad;
    public static By mouseHoverOnDriverOption;
    public static By lblSetDriverComment;
    public static By driverCommentWindow;
    public static By btnSaveDriverCommentWindow;
    public static By txtCommentField;
    public static By iconDriverComment;
    public static By txtCommentAdded;
    public static By lblClearDriverComment;
    public static By btnPopOutInDefaulttruckView;

    public static By btnActive;
    public static By inActiveTruckRowOnDefaultTruckLoad;
    public static By AllTruckRowOnDefaultTruckLoad;
    public static By AllActiveTruckRowOnDefaultTruckLoad;
    public static By AllInActiveTruckRowOnDefaultTruckLoad;
    public static By ActiveTruck;
    public static By lblSetTruckInactive;
    public static By lblSetTruckActive;
    public static By InActiveTruck;
    public static By inActiveTruckIDIcon;
    public static By activeTruckIDIcon;
    public static By lnkFacility;
    public static By callIdLnk;
    public static By lnkRemoveFromFavorites;


    public static By txtAllCallsCounter;
    public static By txtUnassignedCallsCounter;
    public static By lblUnassignedCallsGid;

    public static By truckA;
    public static By truckB;
    public static By setToActive;
    public static By setToInActive;
    public static By callStatus;
    public static By outOfVehicle;
    public static By inVehicle;
    public static By btnSaveOnOutOfVehiclePopup;
    public static By mouseHoverOnSetDriverStatusOption;
    public static By outOfVehicleStatus;
    public static By inVehicleStatus;
    public static By driverCommentIcon;


    public static By callIDOnTruckView;
    public static By lnkCallStatus;
    public static By lnlAssignCallStatus;
    public static By lnkOfFirstTruck;
    public static By truckIDFromCallsView;
    public static By truckIDOnTruckView;
    public static By lnkComments;
    public static By lblAutocomment;
    public static By comment;
    public static By listOfComments;

    public static By sppTruckDefaultView;

    public static By listOfTruckIDs;




    static {

        lblCommentColmnOnDefaultTruckLoad=By.id("tl-9");

        activeTruckRowOnDefaultTruckLoad=By.xpath("(//div[contains(@class, 'd3ui-icon d3ui-icon-calls-tl d3ui-icon-truck-ac')])[1]");
        mouseHoverOnDriverOption=By.xpath("//div[@title='Driver Options']");
        lblSetDriverComment=By.xpath("//div[@title='Set Driver Comment ...']");
        driverCommentWindow=By.id("add-driver-comment-dialog");
        btnSaveDriverCommentWindow=By.id("add-driver-comment-save");
        txtCommentField=By.id("driverComment");
        iconDriverComment=By.xpath("(//div[contains(@class, 'd3ui-icon d3ui-icon-calls-tl d3ui-icon-driver-comment')])[1]");
        txtCommentAdded=By.xpath("(//div[contains(@class, 'tl-truck-width-cell-9 d3ui-datagrid-call-cell')])[1]");
        lblClearDriverComment=By.xpath("//div[@title='Clear Driver Comment']");
        btnPopOutInDefaulttruckView = By.xpath("(//i[@class='icon-long-arrow-up'])[2]");

        btnActive=By.xpath("//span[text()='Active']");
        inActiveTruckRowOnDefaultTruckLoad= By.xpath("(//div[contains(@class, 'd3ui-icon d3ui-icon-calls-tl d3ui-icon-truck-in')])[1]");
        AllTruckRowOnDefaultTruckLoad= By.xpath("//div[contains(@class, 'd3ui-icon d3ui-icon-calls-tl d3ui-icon-truck')]");
        AllActiveTruckRowOnDefaultTruckLoad= By.xpath("//div[contains(@class, 'd3ui-icon d3ui-icon-calls-tl d3ui-icon-truck-ac')]");
        AllInActiveTruckRowOnDefaultTruckLoad= By.xpath("//div[contains(@class, 'd3ui-icon d3ui-icon-calls-tl d3ui-icon-truck-in')]");

        lblSetTruckInactive= By.xpath("//span[text()='Set Truck to Inactive']");
        lblSetTruckActive= By.xpath("//span[text()='Set Truck to Active']");



        txtAllCallsCounter= By.xpath("(//span[@class='d3ui-counter'])[3]");
        txtUnassignedCallsCounter= By.xpath("(//span[@class='d3ui-counter'])[4]");
        lblUnassignedCallsGid=By.id("truck-grid-unassigned-calls");


        truckA=By.xpath("//div[@id='truckload-truck-grid-data']//div[@data-truckid='A']");
        truckB=By.xpath("//div[@id='truckload-truck-grid-data']//div[@data-truckid='B']");
        setToActive=By.xpath("//*[contains(@id,'truckMenu')]//div[@title='Set Truck to Active']");
        setToInActive=By.xpath("//*[contains(@id,'truckMenu')]//div[@title='Set Truck to Inactive']");
        callStatus =By.xpath("//div[@class='profile-call-status-descr']");
        outOfVehicle=By.xpath("//*[contains(@class,'context-menu-item')][@title='Out-of-Vehicle']");
        inVehicle=By.xpath(" //*[contains(@class,'context-menu-item')][@title='In-Vehicle']");
        btnSaveOnOutOfVehiclePopup= By.xpath("//*[@id='set-driver-OutOfVehicle-save']//span");
        mouseHoverOnSetDriverStatusOption=By.xpath("//div[@title='Set Driver Status']");
        // outOfVehicleStatus=By.xpath("//*[contains(@class,'d3ui-icon d3ui-icon-calls-tl d3ui-icon-driver-ov')][@title='OV - OUT OF VEHICLE']");
        outOfVehicleStatus=By.xpath("//div[@data-truckid='B']//div[@title='OV - OUT OF VEHICLE']");
        inVehicleStatus=By.xpath("//div[@data-truckid='A']//div[@title='IV - IN VEHICLE']");
        driverCommentIcon= By.xpath("//div[@data-truckid='B']//div[@class='d3ui-icon d3ui-icon-calls-tl d3ui-icon-driver-comment']");


        lnkCallStatus= By.xpath("//div[@title='Call Status']");
        lnlAssignCallStatus= By.xpath("//div[@title='Assign (AS)']");
        lnkOfFirstTruck=By.xpath("(//div[@class='context-menu-group ALLOW_AS']/div)[1]");
        lblAutocomment=By.xpath("//div[@id='COMMENTS_GROUP']//span[contains(text(),'Auto Comment')]");
        listOfComments=By.xpath("//div[@id='DISP_CANNED_COMMENTS']//span");

        listOfTruckIDs= By.xpath("//div[@class='d3ui-datagrid-call-cell tl-call-width-cell-truck']");
        sppTruckDefaultView= By.xpath("//*[@id='truckload-dropdown-menu']//*[contains(text(),'Truckload - DEFAULT')]");


  }


    public static By ActiveTruckID(String TruckID) {

        ActiveTruck = By.xpath("//div[contains(@class, 'd3ui-icon d3ui-icon-calls-tl d3ui-icon-truck-ac')]/parent::div/following-sibling::div[(text()='"+TruckID+"')]");

        return ActiveTruck;
    }
    public static By InActiveTruckID(String TruckID) {

        InActiveTruck = By.xpath("//div[contains(@class, 'd3ui-icon d3ui-icon-calls-tl d3ui-icon-truck-in')]/parent::div/following-sibling::div[(text()='"+TruckID+"')]");

        return InActiveTruck;
    }
    public static By verifyInActiveIconOfTruckID(String TruckID) {

        inActiveTruckIDIcon = By.xpath("//div[(text()='"+TruckID+"')]/../div//div[@title='IN - INACTIVE']");

        return inActiveTruckIDIcon;
    }
    public static By verifyActiveIconOfTruckID(String TruckID) {

        activeTruckIDIcon = By.xpath("//div[(text()='"+TruckID+"')]/../div//div[@title='AC - ACTIVE']");

        return activeTruckIDIcon;
    }
    public static By selectFacility(String facility) {

        String xpath = "//*[@id='facility-list-data-panel']/li[contains(@data-facility-id,'"+facility+"')]";
        lnkFacility=By.xpath(xpath);
        return lnkFacility;
    }
    public static By selectCallIDOnTruckLoad(String callId){

        String xpath = "//*[contains(@id,'tl-callrow-"+callId+"')]";
        callIdLnk=By.xpath(xpath);
        return callIdLnk;
    }
    public static By lnkRemoveCallFavorite(String callIdAndDate){
        String xpath = "//*[contains(@id,'callMenu-"+callIdAndDate+"')]//span[contains(text(),'Remove from Favorites')]";
        lnkRemoveFromFavorites=By.xpath(xpath);
        return lnkRemoveFromFavorites;
    }


    public static By callIDInTruckDefaultView(String callId, String callIdDate){

        callIDOnTruckView=By.xpath("//*[tl-callrow-"+callIdDate+"-"+callId+"')]");
        return callIDOnTruckView;
    }

    public static By truckIDFromCallDefaultView(String callId, String callIdDate){

        truckIDFromCallsView=By.xpath("//*[contains(@id,'tl-callrow-"+callIdDate+"-"+callId+"')]//div[@class='d3ui-datagrid-call-cell tl-call-width-cell-truck']");
        return truckIDFromCallsView;
    }

    public static By truckIDOnTruckView(String truckID){

        truckIDOnTruckView=By.xpath("(//div[@data-truckid="+truckID+"])[1]");
        return truckIDOnTruckView;
    }
    public static By lnkCommentsInTruckLoadContextMenu(String callIdAndDate){
        String xpath = "//*[contains(@id,'callMenu-"+callIdAndDate+"')]//span[contains(text(),'Comments')]";
        lnkComments=By.xpath(xpath);
        return lnkComments;
    }
    public static By selectAutoComment(String AutoComment)throws  Throwable{
        String xpath = "//div[@id='DISP_CANNED_COMMENTS']//span[contains(text(),'"+AutoComment+"')]";
        comment=By.xpath(xpath);
        return comment;
    }
}
