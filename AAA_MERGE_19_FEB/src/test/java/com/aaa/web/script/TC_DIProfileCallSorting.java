package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.CRHomeLib;
import com.aaa.web.lib.DIHomeLib;
import com.aaa.web.lib.DILoginLib;
import com.aaa.web.lib.LoginRoleLib;
import com.aaa.web.page.DIHomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIProfileCallSorting extends DILoginLib {
	/************************************************************************
	* Script Name :-
	* Method Name :-
	* Module	  :- DI 
	* Test Case ID:-
	* Script Date :- 
	* Author      :- 
	* @param StartRow
	* @param EndRow
	* @param nextTestJoin
	* @throws Throwable
	*************************************************************************/
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void profileCallSorting(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIProfileCallsorting", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIProfileCallsorting", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1807: DI Profile call Sorting"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("DI");
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib home=new CRHomeLib();
		                DIHomePage diHomePage=new DIHomePage();
		                LoginRoleLib loginRole=new LoginRoleLib();
		                login(data.get("LoginName"),data.get("Password"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnProfile();
		                Thread.sleep(10000);
		                diHome.clickOnGearIconOfProfileWindow();
		                Thread.sleep(10000);
		                diHome.clickOnResetDefaultSettingOnProfileTab();
		                Thread.sleep(3000);
		                dragAndDrop(diHomePage.lnkStsOnProfileWindow,diHomePage.lnkZoneProfileWindow,"Drag and drop");
		                Thread.sleep(3000);
		                diHome.clickOnRemoveAllOnProfileTab();
		                diHome.enterFilterInProfileWindow(data.get("FilterId"));
		                diHome.clickOnIDOnProfileTab();
		                diHome.clickOnAddOnProfileTab();
		                clearData(diHomePage.txtFilterInProfileWindow);
		                diHome.enterFilterInProfileWindow(data.get("FilterDate"));
		                diHome.clickOnDateOnProfileTab();
		                diHome.clickOnAddOnProfileTab();
		
		                diHome.clickOnArrowButtonOfID();
		                diHome.verifyLabelPriorityOfIDOnProfileWindow();
		                diHome.verifyLabelOrderOfIDOnProfileWindow();
		                diHome.selectPriority(data.get("Priority"));
		                diHome.selectOrder(data.get("AscendingOrder"));
		                diHome.clickOnSaveButtonOfIDAndDateOnProfileWindow();
		                diHome.verifyIdTextOnprofileWindow(data.get("IDPriorityOrder"));
		
		                diHome.clickOnArrowButtonOfDate();
		                diHome.selectPriority(data.get("DatePriorityOrder"));
		                diHome.selectOrder(data.get("DescendingOrder"));
		                diHome.clickOnSaveButtonOfIDAndDateOnProfileWindow();
		                diHome.verifyIdTextOnprofileWindow(data.get("IDPriorityOrder"));
		                diHome.verifyDateTextOnprofileWindow(data.get("DatePriorityOrder"));
		                diHome.clickOnSaveSettingsButtonOfProfileWindow();
		
		                home.allErrorAlerts();
		                diHome.validateAscendingDescendingIcons();
		                diHome.clickOnTabNextToAllCallsInProfileWindow();
		                Thread.sleep(5000);
		                diHome.clickOnCallIDColumnOfProfileWindow();
		                diHome.validateSortingIsRemoved();
		                diHome.validateAscendingOrderofColumn();
		                diHome.verifyTinyPointerPointingUp();
		                //diHome.clickOnCallIDColumnOfProfileWindow();
		                diHome.validateDescendingOrderofColumn();
		                diHome.clickOnCallIDColumnOfProfileWindow();
		                diHome.validateSortingIsRemoved();
		                diHome.clickOnAllCallsTab();
		                diHome.validateAscendingDescendingIcons();
		                diHome.logOut();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1807",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
}

