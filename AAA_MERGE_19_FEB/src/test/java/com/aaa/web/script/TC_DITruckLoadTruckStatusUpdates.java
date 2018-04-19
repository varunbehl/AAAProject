package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.e2e.script.CR_DI;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DITruckLoadDefaultViewPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by e002222 on 13-02-2018.
 */
public class TC_DITruckLoadTruckStatusUpdates extends DILoginLib {




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

    public void verifyTruckStatusUpdateOnTruckLoad(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "verifyTruckStatusUpdateOnTruckLoad", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("verifyTruckStatusUpdateOnTruckLoad", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1809: TS-DI TruckLoad Truck Status Updates"+ " From Iteration " + StartRow + " to " + EndRow );
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
		
		                boolean verifyActiveTruck=DITruckload.verifyActiveTruckOnDefaultTruckLoad();
		                assertTrue(verifyActiveTruck, "verify active truck record");
		                boolean verifyInActiveTruck=DITruckload.verifyInActiveTruckOnDefaultTruckLoad();
		                assertTrue(verifyInActiveTruck, "verify Inactive truck record");
		
		                DITruckload.clickActiveBtnOnDefaultTruckLoad();
		
		                boolean verifyAllActiveRecords= DITruckload.verifyAllActiveTrucksOnDefaultTruckLoad();
		                assertTrue(verifyAllActiveRecords, "Verify all Active truck records");
		                DITruckload.clickActiveBtnOnDefaultTruckLoad();
		                boolean verifyActiveTruck1=DITruckload.verifyActiveTruckOnDefaultTruckLoad();
		                assertTrue(verifyActiveTruck1, "verify active truck record again");
		                boolean verifyInActiveTruck1=DITruckload.verifyInActiveTruckOnDefaultTruckLoad();
		                assertTrue(verifyInActiveTruck1, "verify Inactive truck record again");
		                DITruckload.rightClickActiveSpecificTruckOnDefaultTruckLoad(data.get("ActiveTruckID"));
		                DITruckload.clickSetTruckToInactive();
		                boolean verifyActiveToInactive=DITruckload.verifyIconChangeToInactive(data.get("ActiveTruckID"));
		                assertTrue(verifyActiveToInactive, "Status change to inactive");
		                DITruckload.rightClickInActiveSpecificTruckOnDefaultTruckLoad(data.get("InActiveTruckID"));
		                DITruckload.clickSetTruckToActive();
		                boolean verifyInActiveToActive=DITruckload.verifyIconChangeToActive(data.get("ActiveTruckID"));
		                assertTrue(verifyInActiveToActive, "Status change to Active");
		
		
		
		
		
		
		
		
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
    			ReportStatus.fnUpdateResultStatus("DI","1809",ReportStatus.strMethodName,intCounter,browser);
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
