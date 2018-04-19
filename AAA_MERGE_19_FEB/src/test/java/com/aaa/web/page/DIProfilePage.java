package com.aaa.web.page;
import org.openqa.selenium.By;

public class DIProfilePage {



    public static By dialogSetProfileName;
    public static By btnSaveAndContinue;
    public static By txtBoxHighligetedInRed;
    public static By lblUserProfileNameEmpty;
    public static By txtName;
    public static By lblIDSelectedSection;
    public static By lblStsSelectedSts;
    public static By DialogprofileWindow;
    public static By lblProfileName;
    public static By lblProfileNameInProfileMenuItems;
    public static By iconOpenDuplicateProfile;
    public static By iconCustomizeTheProfile;
    public static By btnArrowId;
    public static By drpdwnPriority;
    public static By drpdwnOrder;
    public static By btnSave;
    public static By btnSaveSettings;
    public static By iconCloseTheProfile;
    public static By lblFirstColumn;
    public static By btnDeleteThisUserProfile;
    public static By btnYesOnDeletePopUpWindow;
    public static By lblPriority;
    public static By lblOrder;
    public static By lblTabNameInProfileWindow;
    public static By lblTabNameInSettings;
    public static By lnkRemoveAll;
    public static By lblSecondListItemInAvailableSection;
    public static By lblAvailableSectionColumnsNames;
    public static By lblAvailableSectionColumnName;
    public static By lblSelectedSectionColumnsNames;
    public static By lblAvailableSectionHighlightedColumnsNames;
    public static By btnAdd;
    public static By btnRemove;
    public static By txtFilterAvailableSection;
    public static By txtFilterSelectedSection;
    public static By lblAvailableSectionFilteredColNames;
    public static By lblFirstColSelectedSection;
    public static By lblFirstColAvailableSection;
    public static By lblSelectedSectionAllColumns;
    public static By tabNamesProfileWindow;
    public static By lnkbtnResetToDefaultSettings;
    public static By chkBoxApplyToAlltabs;
    public static By btnYesConfirmationWindow;
    public static By btnYesApplyToAllWindow;
    public static By applyToAllWindow;
    public static By ddlHiddenTabList;
    public static By btnVIewHiddenProfile;
    public static By ddlHiddenTabListElements;
    public static  By ddlHiddenTabListElements1;
    public static By lblHiddenTabNamesInDropDown;
    public static By lblColumnNamesForTabs;
    public static By btnCancel;
    public static By lblItemFromContextMenu;
    public static By lblGen;
    public static By imgselectStar;
    public static By statusOnProfile;
    public  static  By iconPhoneProfileWIndow;
    public static By iconMinimizeProfileWindow;
    public static By maximizeProfileWinodw;
    public static By txtCallidOnProfileWindow;
    public static By lblcomments;
    public static By lblAutocomment;
    public static By comment;
    public static By listOfComments;
    static {
        dialogSetProfileName = By.xpath("//div[@aria-labelledby = 'ui-dialog-title-new-user-profile-dlg']");
        btnSaveAndContinue = By.id("new-user-profile-dlg-open");
        txtBoxHighligetedInRed = By.xpath("//input[@class='text ui-state-error ui-state-error-text']");
        lblUserProfileNameEmpty = By.id("new-user-profile-dlg-error");
        txtName = By.id("new-user-profile-dlg-name");
        lblIDSelectedSection = By.xpath("//div[@class='d3ui-panelsettings-container']//ul[@class='selected selectable-list ui-sortable']//span[contains(text(),'ID')]/../..");
        lblStsSelectedSts = By.xpath("//div[@class='d3ui-panelsettings-container']//ul[@class='selected selectable-list ui-sortable']//span[text()='Sts']/../..");
        DialogprofileWindow = By.xpath("//div[@class='profile-window-panel d3ui-panel ui-draggable ui-resizable top-displayed-panel']");
        lblProfileName = By.xpath("//div[@class='profile-window-name d3ui-panel-title']//span[@class='panel-title-label']");
        iconOpenDuplicateProfile = By.xpath("//a[@title='Open a duplicate profile']");
        iconCustomizeTheProfile = By.xpath("//a[@title='Customize the profile']");
        btnArrowId=By.cssSelector("ul[class='selected selectable-list ui-sortable'] li:nth-child(1) button");
        drpdwnPriority=By.xpath("//span[@class='priority-title']/../select");
        drpdwnOrder=By.xpath("//span[@class='order-title']/../select");
        btnSave =By.xpath("//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div[@class='ui-dialog-buttonset']//button[2]/span[(text()='Save')]");
        btnSaveSettings = By.xpath("//button[@title='Save profile settings']");
        iconCloseTheProfile = By.xpath("//div[@class='d3ui-panel-menu profile-menu']/a[@title='Close the profile']");
        lblFirstColumn = By.xpath("//div[@class='d3ui-datagrid-header']/div[@class='d3ui-datagrid-header-content']/div[1]");
        btnDeleteThisUserProfile = By.xpath("//button[@title='Permanently deletes user profile']");
        btnYesOnDeletePopUpWindow = By.id("confirmation-yes-btn");
        lblPriority = By.xpath("//span[@class='priority-title']");
        lblOrder = By.xpath("//span[@class='order-title']");
        //lblAllCalls = By.xpath("//label[text()='All Calls']");
        lblTabNameInSettings = By.xpath("//div[@class='profile-tab-title']/i");
        lnkRemoveAll = By.xpath("//div[@class='d3ui-panelsettings-container']//a[@class='remove-all-link']");
        lblSecondListItemInAvailableSection = By.xpath("//ul[@class='unselected selectable-list ui-sortable']/li[2]");
        btnAdd = By.xpath("//button[@title='Adds selected properties to the displayed properties list']");
        btnRemove = By.xpath("//button[@title='Removes selected properties from the displayed properties list']");
        txtFilterAvailableSection = By.xpath("//div[@class='d3ui-panelsettings-container']//div[@class='d3ui-panelsettings-data-fields']//input[@class='settings-tab-avail-col d3ui-field']");
        txtFilterSelectedSection = By.xpath("//div[@class='d3ui-panelsettings-container']//div[@class='d3ui-panelsettings-fields-to-display']//input[@class='settings-tab-sel-col d3ui-field']");
        lblAvailableSectionFilteredColNames = By.xpath("//ul[@class='unselected selectable-list ui-sortable']");
        lblFirstColAvailableSection = By.xpath("//ul[@class='unselected selectable-list ui-sortable']/li[2]");
        lblFirstColSelectedSection = By.xpath("//ul[@class='selected selectable-list ui-sortable']/li[1]");
        lblFirstColAvailableSection = By.xpath("//ul[@class='unselected selectable-list ui-sortable']/li[2]");
        lblFirstColSelectedSection = By.xpath("//ul[@class='selected selectable-list ui-sortable']/li[1]");
        lblSelectedSectionAllColumns = By.xpath("//div[@class='d3ui-panelsettings-fields-to-display']//ul[@class='selected selectable-list ui-sortable']");
        tabNamesProfileWindow = By.xpath("//div[@class='d3ui-datagrid active-profile-tab-table']//div[@class='d3ui-datagrid-header']");
        lnkbtnResetToDefaultSettings = By.xpath("//a[text()='Reset to Default Settings']");
        chkBoxApplyToAlltabs = By.className("profile-tab-apply-all-btn");
        btnYesConfirmationWindow = By.id("confirmation-yes-btn");
        btnYesApplyToAllWindow = By.id("confirmation-yes-btn");
        applyToAllWindow = By.xpath("//div[@aria-labelledby='ui-dialog-title-confirmation-box']");
        //ddlHiddenTabListElements = By.xpath("//ul[@class='hidden-tab-list d3ui-menu d3ui-menu-constrained']//li[@class='d3ui-menu-item d3ui-menu-item-counter']//span[2]");
        //ddlHiddenTabListElements = By.xpath("//ul[@class='hidden-tab-list d3ui-menu d3ui-menu-constrained']//li[@class='d3ui-menu-item d3ui-menu-item-counter']//a[@class='d3ui-menu-item-toggle']//span[2]");

        ddlHiddenTabListElements = By.xpath("//ul[@class='hidden-tab-list d3ui-menu d3ui-menu-constrained']//li[@class='d3ui-menu-item d3ui-menu-item-counter']//a[@class='d3ui-menu-item-toggle']//span[contains(@class,'d3ui-menu-item-label hidden-tab-name')]");
        ddlHiddenTabListElements1 = By.xpath("//ul[@class='hidden-tab-list d3ui-menu d3ui-menu-constrained']");
        ddlHiddenTabList = By.xpath("//ul[@class='hidden-tab-list d3ui-menu d3ui-menu-constrained']//li[@class='d3ui-menu-item d3ui-menu-item-counter']");
        btnVIewHiddenProfile = By.className("view-hidden-profile-tabs-btn");
        lblColumnNamesForTabs = By.xpath("//div[@class='d3ui-datagrid-header']//div[@class='d3ui-datagrid-header-content']");
        btnCancel = By.xpath("//button[@title='Cancel changes']");
        iconMinimizeProfileWindow = By.xpath("//a[@title='Minimize the profile']");
        maximizeProfileWinodw = By.xpath("//div[@id='window-pane-taskbar-items']//div[contains(@data-ref,'profile-window')]");
        lblAutocomment=By.xpath("//div[@id='COMMENTS_GROUP']//span[contains(text(),'Auto Comment')]");
        listOfComments=By.xpath("//div[@id='DISP_CANNED_COMMENTS']//span");

    }
    public static By lblProfileNameInProfileMenuItems(String ProfileName){
        String xpath = "//ul[@id='profile-dropdown-menu']//li//span[text()='"+ProfileName+"']";
        lblProfileNameInProfileMenuItems=By.xpath(xpath);
        return lblProfileNameInProfileMenuItems;
    }

    public static By lblTabNameInProfileWindow(String TabName){
        String xpath = "//label[text()='"+TabName+"']";
        lblTabNameInProfileWindow=By.xpath(xpath);
        return lblTabNameInProfileWindow;
    }

    public static By lblAvailableSectionColumnsNames(String ColName){
        String xpath = "//ul[@class='unselected selectable-list ui-sortable']//span[text()='"+ColName+"']/../..";
        lblAvailableSectionColumnsNames=By.xpath(xpath);
        return lblAvailableSectionColumnsNames;
    }

    public static By lblAvailableSectionColumnName(String ColName){
        String xpath = "//ul[@class='unselected selectable-list ui-sortable']//span[text()='"+ColName+"']/../..";
        lblAvailableSectionColumnName=By.xpath(xpath);
        return lblAvailableSectionColumnName;
    }

    public static By lblSelectedSectionColumnsNames(String ColName){
        String xpath = "//ul[@class='selected selectable-list ui-sortable']//span[text()='"+ColName+"']/../..";
        lblSelectedSectionColumnsNames=By.xpath(xpath);
        return lblSelectedSectionColumnsNames;
    }

    public static By lblAvailableSectionHighlightedColumnsNames(String ColName){
        String xpath = "//a[@class='field-item-btn ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-selected']//span[text()='"+ColName+"']";
        lblAvailableSectionHighlightedColumnsNames=By.xpath(xpath);
        return lblAvailableSectionHighlightedColumnsNames;
    }
    public static By lblHiddenTabNamesInDropDown(String TabName){
        String xpath = "//ul[@class='hidden-tab-list d3ui-menu d3ui-menu-constrained']//span[text()='"+TabName+"']";
        lblHiddenTabNamesInDropDown=By.xpath(xpath);
        return lblHiddenTabNamesInDropDown;
    }
    public static By selectLinkFromContextMenu(String callIDAndDate)throws  Throwable{
        String xpath = "//*[@id='callMenu-"+callIDAndDate+"']/div[7]/div/span";
        lblItemFromContextMenu=By.xpath(xpath);
        return lblItemFromContextMenu;
    }
    public static By getRGNFromProfileWindow(String callIdAndDate){
        //*[@id="up_1303_profile_3-20180212-20022"]/div[61]
        String xpath = "//*[contains(@id,'profile_3-"+callIdAndDate+"')]/div[61]"; //*[contains(@id,'profile_3-20180124-20063')]
        lblGen=By.xpath(xpath);
        return lblGen;
    }
    public static By selectFavoriteCallFromStatus(String callIdAndDate)throws  Throwable{
        String xpath = "//*[contains(@id,'profile_3-"+callIdAndDate+"')]//i[contains(@class,'icon-star')]"; //*[contains(@id,'profile_3-20180124-20063')]
        imgselectStar=By.xpath(xpath);
        return imgselectStar;
    }
    public static By statusOnPfofile(String callId){
        String xpath = "//*[contains(@id,'profile_3-"+callId+"')]/div[2]"; //*[contains(@id,'profile_3-20180124-20063')]
        statusOnProfile=By.xpath(xpath);
        return statusOnProfile;
    }

    public static By iconPhoneProfileWIndow(String callId, String callIdDate){
        String xpath = "//*[contains(@id,'"+callIdDate+"-"+callId+"')]//div[@class='d3ui-icon d3ui-icon-cm-2']";
        iconPhoneProfileWIndow=By.xpath(xpath);
        return iconPhoneProfileWIndow;
    }

    public static By txtCallidOnProfileWindow(String callId, String callIdDate){
        String xpath = "//div[contains(@id,'"+callIdDate+"-"+callId+"')]";
        txtCallidOnProfileWindow=By.xpath(xpath);
        return txtCallidOnProfileWindow;
    }
    public static By mouseHoverToCommentsInContextMenu(String callIDAndDate,String comments)throws  Throwable{
        String xpath = "//*[@id='callMenu-"+callIDAndDate+"']//span[contains(text(),'"+comments+"')]";
        lblcomments=By.xpath(xpath);
        return lblcomments;
    }

    public static By selectAutoComment(String AutoComment)throws  Throwable{
        String xpath = "//div[@id='DISP_CANNED_COMMENTS']//span[contains(text(),'"+AutoComment+"')]";
        comment=By.xpath(xpath);
        return comment;
    }
}
