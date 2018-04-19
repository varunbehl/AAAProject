package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DITruckLoadDefaultViewPage;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by e002222 on 09-02-2018.
 */
public class TC_DITruckLoadDriverComments extends DILoginLib {


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

    public void verifyDriverCommentsOnTruckLoad(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyDriverCommentsOnTruckLoad", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyDriverCommentsOnTruckLoad", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1821: TS-DI TruckLoad Driver Comments"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                DITruckLoadDeafultViewLib DITruckload= new DITruckLoadDeafultViewLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRServiceLib services = new CRServiceLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CR_DI crDI = new CR_DI();
		                CommonLib commonLib = new CommonLib();
		                DISearchCallsLib diSearchCalls = new DISearchCallsLib();
		                DIMCDLib diMCD = new DIMCDLib();
		                navigateToApplication("DI");
		                waitcloseAllBusyIcons();
		                login(data.get("DILoginName"),data.get("DIPassword"));
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                Thread.sleep(10000);
		                diHome.clickOnCloseButtonOnQueueWindow();
		
		                String winHandleBefore = driver.getWindowHandle();
		                diHome.clickOnTruckLoad();
		                        String Popoutvalue=data.get("Screen");
		                switch(Popoutvalue){
		                    case "Popout":
		
		                        click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView,"Pop Out clicked");
		                        Thread.sleep(5000);
		                        for (String handle : driver.getWindowHandles()) {
		
		                            driver.switchTo().window(handle);}
		                        break;
		                    default :
		                        break;
		
		                }
		
		                Thread.sleep(5000);
		
		
		
		
		
		
		
		                diHome.enterSpotFacilityIDInfoOnTruckLoad(data.get("Facility"));
		                //crDI.callFlow(data);
		                assertTrue(DITruckload.verifyCommentColmnOnDefaultTruckLoad(), "Comment column visible");
		                Thread.sleep(5000);
		                DITruckload.rightClickActiveDriverOnDefaultTruckLoad();
		                DITruckload.mouseHoverOnDefaultTruckLoad();
		                DITruckload.clickSetDriverCommentDefaultTruckLoad();
		                DITruckload.typeDrivercomment(data.get("DriverComment"));
		                DITruckload.clickDrivercommentSaveBtn();
		                assertTrue(DITruckload.verifyDrivercommentIcon(), "Comment Icon");
		                String ExpComent = DITruckload.verifyDrivercommentTxt();
		                assertTrue(data.get("DriverComment").equalsIgnoreCase(ExpComent), "Comment is present");
		                String IconCommentExp=DITruckload.verifyCommentIconHoverTxt();
		                assertTrue(data.get("DriverComment").equalsIgnoreCase(IconCommentExp), "Icon comment text");
		                Thread.sleep(2000);
		
		
		                DITruckload.rightClickActiveDriverOnDefaultTruckLoad();
		                DITruckload.mouseHoverOnDefaultTruckLoad();
		                DITruckload.clickSetDriverCommentDefaultTruckLoad();
		                DITruckload.typeDrivercomment(data.get("EditDriverComment"));
		                DITruckload.clickDrivercommentSaveBtn();
		                Thread.sleep(5000);
		                assertTrue(DITruckload.verifyDrivercommentIcon(), "Comment Icon");
		                String ExpEditComent = DITruckload.verifyDrivercommentTxt();
		                assertTrue(data.get("EditDriverComment").equalsIgnoreCase(ExpEditComent), "Comment is present after edit");
		                String IconEditCommentExp=DITruckload.verifyCommentIconHoverTxt();
		                assertTrue(data.get("EditDriverComment").equalsIgnoreCase(IconEditCommentExp), "Icon comment text after edit");
		                Thread.sleep(2000);
		
		
		                DITruckload.rightClickActiveDriverOnDefaultTruckLoad();
		                DITruckload.mouseHoverOnDefaultTruckLoad();
		                DITruckload.clickClearDriverCommentDefaultTruckLoad();
		                boolean verifyNoCommentIcon=DITruckload.verifyNoDrivercommentIcon();
		                assertTrue(verifyNoCommentIcon, "Comment Icon Invisibility");
		
		                Thread.sleep(2000);
		
		
		
		                switch(Popoutvalue){
		                    case "Popout":
		                       // click(DITruckLoadDefaultViewPage.btnPopOutInDefaulttruckView,"Pop Out clicked");
		                        Thread.sleep(5000);
		                        driver.close();
		
		                        break;
		                    default :
		                        break;
		
		                }
		
		
		
		
		                    driver.switchTo().window(winHandleBefore);
		
		
		
		                //driver.switchTo().defaultContent();
		
		
		                diHome.logOut();
		                Thread.sleep(5000);
		                acceptAlert();
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1821",ReportStatus.strMethodName,intCounter,browser);
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
