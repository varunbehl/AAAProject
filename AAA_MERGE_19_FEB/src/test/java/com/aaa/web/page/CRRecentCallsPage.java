package com.aaa.web.page;

import org.openqa.selenium.By;

public class CRRecentCallsPage {
    public static By lnkRecentCalls;
    public static By lblRecentCallsWIndowAvailablity;
    public static By lblCallDateID;
    public static By lblContactInformation;
    public static By lblVehicleInformation;
    public static By lblActions;
    public static By lblCallDateIDResultValue;
    public static By btnClose;
    public static By txtContactInformation;

    static {
        lnkRecentCalls = By.id("recent-calls-btn");
        lblRecentCallsWIndowAvailablity=By.id("ui-dialog-title-recent-calls-dlg");
        lblCallDateID=By.cssSelector("div[id='recent-calls-table_wrapper'] div div div th:nth-child(1)");
        lblContactInformation=By.cssSelector("div[id='recent-calls-table_wrapper'] div div div th:nth-child(2)");
        lblVehicleInformation=By.cssSelector("div[id='recent-calls-table_wrapper'] div div div th:nth-child(3)");
        lblActions=By.cssSelector("div[id='recent-calls-table_wrapper'] div div div th:nth-child(4)");
        lblCallDateIDResultValue=By.xpath("//table[@id='recent-calls-table']/tbody/tr[contains(@id,'recent-call-')]/td[1]/a");
        btnClose=By.id("call-search-close-btn");
        txtContactInformation=By.xpath("//table[@id='recent-calls-table']/tbody/tr[contains(@id,'recent-call-')]/td[2]");


    }
}
