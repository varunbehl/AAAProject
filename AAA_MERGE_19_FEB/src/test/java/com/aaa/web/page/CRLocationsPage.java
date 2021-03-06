package com.aaa.web.page;

import org.openqa.selenium.By;

public class CRLocationsPage {
    public static By txtStreetAddress;
    public static By txtLocCity;
    public static By txtLocState;
    public static By txtLocCode;
    public static By locationTab;
    public static By txtStreetAddressInput;
    public static By errorNotifications;
    public static By alertUndefinedError;
    public static By errorAlertOK;
    public static By scriptError;
    public static By saveFailureError;
    public static By errorDialouge;
    public static By btnAlertSaveYes;
    public static By linkBrkDowLocAddr;
    public static By dropBoxBrkDownLocationCode;
    public static By txtBrkDowLocSrch;
    public static By labelSearchingInfo;
    public static By btnBrkDowLocSrch;
    public static By linkBrkDowSrchAddress;
    public static By linkBrkDownLocAddr;
    public static By dropboxBrkDowLocationCode;
    public static By linkManualEntryOnLocationTab;
    public static By txtCallComments;
    public static By btnCallsAdd;
    public static By btnViewComments;
    public static By lblCallTImeZone;
    public static By txtLandMark;
    public static By txtStreetNumber;
    public static By lnkDateTimeInCommentsPopup;
    public static By selectRowInCommentsPopup;
    public static By selectDateTimeInCommentsPopup;
    public static By selectDateTimeInCommentsPopupEvenRow;
    public static By iconMessageWindowClose;
    public static By txtStreetInputAddress;
    public static By linkSecondknownBrkDowLocAddr;
    public static By lnkRowSelectionInLocationResults;
    public static By txtNarthCrossstreet;
    public static By txtSouthCrossstreet;
    public static By txtZipOnLocations;
    public static By checkBoxHighway;
    public static By txtLatitude;
    public static By txtLongitude;
    public static By btnVerifyIt;
    public static By btnClearLocation;
    public static By txtBoxPickUpPoint;
    public static By lnkForAddressVerificationByLatitudeOrLongitude;
    public static By txtspecialCharacters;
    public static By recardListInResultsGrid;
    public static By txtCommentRowOneInCommentsPopup;
    public static By txtZipCode;
    public static By addressVerifiedBtn;
    public static By txtBlockRange;
    public static By btnComments;
    public static By txtCallBox;
    public static By lnkClickOnLocationCode;
    public static By lblFacilityType;
    public static By txtNormalRowOneInCommentsPopup;
    public static By locationNameLink;
    public static By txtCommentsCol;
    public static By dropBoxBrkDownCityCode;
    public static By dropBoxBrkDownStateCode;
    public static By linkAtlantaBrkDownLocAddr;
    public static By lblCommentTypeCommentWindow;
    public static By lblStatusCommentWindow;
    public static By lblDateTimeCommentWindow;
    public static By lblUserCommentWindow;
    public static By lblLocationCommentWindow;
    public static By verifyLocationsCompleteCheck;
    public static By ddnStateZip;

    static {
        locationTab = By.xpath("//*[@id=\"tab-locations\"]/span");
        linkBrkDowSrchAddress = By.cssSelector("table[id*='bl-search-results'] tbody a");
        btnBrkDowLocSrch = By.id("bl-search-btn1");
        labelSearchingInfo = By.id("locations-info-message-1-1");
        txtBrkDowLocSrch = By.id("bl-search-input1");
        txtStreetAddressInput = By.id("bl-street-input1");
        //txtStreetAddress = By.cssSelector("input[id='bl-street-input1'][class='d3ui-field d3ui-fielditem loc-street-field d3ui-required d3ui-show']");
        txtStreetAddress = By.cssSelector("input[id='bl-street-input1']");
        //txtLocCity = By.cssSelector("input[id='bl-city-input1'][class='d3ui-field loc-city-field ui-autocomplete-input ui-corner-left d3ui-show d3ui-required']");
        txtLocCity = By.cssSelector("input[id='bl-city-input1']");
        txtLocState = By.id("bl-state-input1");
        //txtLocCode = By.cssSelector("input[id='bl-location-code-input1'][class='d3ui-field loc-location-code-field ui-autocomplete-input ui-corner-left d3ui-show d3ui-required']");
        txtLocCode = By.cssSelector("input[id='bl-location-code-input1']");
        //Error Notification Locators
        errorNotifications = By.cssSelector("div[id*='d3-notification-']");
        alertUndefinedError = By.cssSelector("span[id*='ui-dialog-title-error-dialog-'] +a span");
        errorNotifications = By.cssSelector("div[id*='d3-notification-']");
        errorAlertOK = By.cssSelector("div[id*='error-dialog-'] + div div button span");
        scriptError = By.id("scripts-immediate-dialog-okayBtn");
        saveFailureError = By.cssSelector("div[id*='error-dialog-'][class='error-dialog ui-dialog-content ui-widget-content']");
        errorDialouge = By.cssSelector("div[id*='d3-notification-'][class='d3ui-notification d3ui-notification-error']");
        btnAlertSaveYes = By.id("confirmation-yes-btn");
        linkBrkDownLocAddr = By.xpath("//*[@id='loc-known-addresses-container-breakdown-workflow']/div[2]/div[2]/span/a");
        //dropboxBrkDowLocationCode = By.xpath("//*[@id=\"bl-location-code-input1\"]");
        dropBoxBrkDownLocationCode = By.id("bl-location-code-input1");
        linkManualEntryOnLocationTab=By.id("loc-manual-toggle-link-1");
        //adding comments
        txtCallComments=By.id("comment-input");
        txtCallComments=By.xpath("//textarea[@placeholder='Enter call comments here']");
        btnCallsAdd=By.id("comments-add-btn");
        btnViewComments=By.id("view-comments-btn");
        lblCallTImeZone = By.id("call-start-time");
        txtLandMark=By.id("bl-landmark-input1");
        txtStreetNumber=By.id("bl-number-input1");
        lnkDateTimeInCommentsPopup = By.cssSelector("table[id='comments-data-table'] tr a");
        selectRowInCommentsPopup = By.xpath("//table[@id='comments-data-table']/tbody/tr[1]");
        selectDateTimeInCommentsPopup = By.cssSelector("table[id='comments-data-table'] tr td[class='comment-date-time sorting_1']");
        selectDateTimeInCommentsPopupEvenRow = By.cssSelector("tr[class='comment-status-visible comment-type-normal even'] td[class='comment-date-time sorting_1']");
        iconMessageWindowClose=By.cssSelector("div[class='d3ui-panel-menu'] a");
        dropBoxBrkDownLocationCode=By.xpath("//*[@id='bl-location-code-input1']");
        txtStreetInputAddress=By.id("bl-number-input1");
        linkSecondknownBrkDowLocAddr=By.xpath("//*[@id='loc-known-addresses-container-breakdown-workflow']/div[3]/div[2]/span/a");
        lnkRowSelectionInLocationResults=By.xpath("//table[@id='bl-search-results1']/tbody/tr/td[2]/a");
        txtNarthCrossstreet=By.id("bl-cross-street-input1");
        txtSouthCrossstreet=By.id("bl-second-cross-street-input1");
        checkBoxHighway=By.id("bl-highway-checkbox1");
        txtLatitude=By.id("bl-latitude-input1");
        txtLongitude=By.id("bl-longitude-input1");
        btnVerifyIt=By.id("verify-address-1");
        btnClearLocation=By.xpath("//div[@id='bl-address1']/div[2]/div/button[2]/span");
        txtBoxPickUpPoint=By.id("bl-pickup-point-input1");
        lnkForAddressVerificationByLatitudeOrLongitude=By.xpath("//table[@id='verifying-results']/tbody/tr/td[2]/a");
        //txtspecialCharacters=By.xpath("//div[@id='confirmation-dialog-question']/div[2]/span[2]");
        txtspecialCharacters=By.xpath("//div[@id='confirmation-dialog-question']/div[1]");
        recardListInResultsGrid=By.xpath("//table[@id='bl-search-results1']/tbody/tr");
        txtCommentRowOneInCommentsPopup = By.xpath("//table[@id='comments-data-table']//tr[1]/td[@class=' comment-text']");
        txtZipCode=By.id("bl-zip-input1");
        addressVerifiedBtn=By.id("address-verified-1");
        txtBlockRange=By.id("bl-number-input1");
        btnComments = By.id("comments-btn-counter");
        txtCallBox = By.id("bl-highway-callbox-input1");
        lnkClickOnLocationCode = By.xpath("//ul[51]/li/a");
        lblFacilityType=By.id("cs-spot-facility-type");
        txtNormalRowOneInCommentsPopup = By.xpath("//table[@id='comments-data-table']//tr[1]/td[@class='comment-type']");
        locationNameLink= By.xpath("//a[contains(@class,'location-item-link')][contains(text(),'FLORIDA')]");
        txtCommentsCol = By.xpath("//table[@id='comments-data-table']//tbody/tr//td[@class=' comment-text']");
        dropBoxBrkDownCityCode = By.xpath("//ul[48]/li[1]/a");
        dropBoxBrkDownStateCode = By.xpath("//ul[45]/li[1]/a");
        linkAtlantaBrkDownLocAddr = By.xpath("//*[@id='loc-known-addresses-container-breakdown-workflow']//a[contains(text(),', GA')]");
        lblCommentTypeCommentWindow = By.xpath("//table[@id='comments-data-table']//tr/td[@class=' comment-type']");
        lblStatusCommentWindow = By.xpath("//table[@id='comments-data-table']//tbody/tr//td[@class=' comment-status']");
        lblDateTimeCommentWindow = By.xpath("//table[@id='comments-data-table']//tbody/tr//td[@class='comment-date-time sorting_1']");
        lblUserCommentWindow = By.xpath("//table[@id='comments-data-table']//tbody/tr//td[@class=' comment-employee']");
        lblLocationCommentWindow = By.xpath("//table[@id='comments-data-table']//tbody/tr//td[@class=' comment-location']");
        verifyLocationsCompleteCheck = By.xpath("//*[@id='tab-locations']//i[@class='tab-icon-complete icon-ok-sign']");
        ddnStateZip = By.xpath("//input[@id='bl-state-input1']/..//button");
    }

}