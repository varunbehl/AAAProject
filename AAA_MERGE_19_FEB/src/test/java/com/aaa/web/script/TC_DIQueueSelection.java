package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_DIQueueSelection extends DILoginLib {
        String queueSecondValue;
        String queueFirstValue;
        String selectedFirstValue;
        String spotQueueFirstValue;
        String spotSelectedQueueFirstValue;
        int records;
        int recordsVerify;
        String queueFirstValueNotAdded;

	/**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: loginWithValidUserNameAndInvalidPassword
     * description :: valdUsernamewithInvalidPassword
     * date :: 18-Dec-2017
     * author :: Chandu Dendukuri
     */
    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void DIQueueSelection(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIQueueSelection", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIQueueSelection", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("2031-TS-DI Queue Selection"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib crHomeLib = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRServiceLib services = new CRServiceLib();
		                DIMCDLib dimcdLib = new DIMCDLib();
		
		                navigateToApplication("DI");
		                waitcloseAllBusyIcons();
		                login(data.get("DILoginName"),data.get("Password"));
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                Thread.sleep(10000);
		                boolean queue= diHome.getQueueSelectionLable();
		                assertTrue(queue,"Queue selection popup appeared");
		                diHome.clickOnDispatchTab();
		                diHome.clickOnRemoveAll();
		                queueFirstValue=diHome.getDispatchQueueFirstFieldValue();
		                diHome.clickOnAddButtonOnQueueWindow();
		                Thread.sleep(5000);
		                diHome.enterValueInQueueFilterSelected(queueFirstValue);
		                selectedFirstValue=diHome.getQueueFieldFirstItemInSelected();
		                diHome.compareDispatchAndSelectedValues(queueFirstValue,selectedFirstValue,"Dispatch","Selected");
		                diHome.clickOnRemoveButtonOnQueueWindow();
		                Thread.sleep(2000);
		                diHome.enterValueInQueueFilterDispatch(selectedFirstValue);
		                diHome.compareDispatchAndSelectedValues(queueFirstValue,selectedFirstValue,"Selected","Dispatch");
		                diHome.clickOnSelectAllLinkOnQueueWindow();
		                diHome.getFieldItemHighlightStatusCount();
		                diHome.clickOnAddButtonOnQueueWindow();
		                diHome.verifyEmptyRecordsInDispatch();
		                diHome.clickOnRemoveAll();
		                diHome.verifyEmptyRecordsInSelected();
		                diHome.verifyDragDropFunctionalityForDispatch();
		                diHome.clickOnContinueQueuesInDispatch();
		                waitcloseAllBusyIcons();
		                Thread.sleep(2000);
		                diHome.selectChangeSetQueueMenuItem();
		                Thread.sleep(2000);
		                diHome.clickOnSpotTab();
		                spotQueueFirstValue=diHome.getSpotQueueFirstFieldValue();
		                diHome.clickOnAddButtonOnQueueWindow();
		                Thread.sleep(2000);
		                diHome.enterValueInSelectedFilterSpot(spotQueueFirstValue);
		                spotSelectedQueueFirstValue=diHome.getSpotSelectedQueueFirstFieldValue();
		                diHome.compareDispatchAndSelectedValues(spotQueueFirstValue,spotSelectedQueueFirstValue,"Spot","Selected");
		                diHome.clickOnRemoveButtonOnQueueWindow();
		                Thread.sleep(2000);
		                diHome.enterValueInQueueFilterSpot(spotSelectedQueueFirstValue);
		                diHome.compareDispatchAndSelectedValues(spotQueueFirstValue,spotSelectedQueueFirstValue,"Selected","Spot");
		                diHome.clickOnSelectAllLinkOnSpotQueueWindow();
		                diHome.getFieldItemHighlightStatusCountInSpot();
		                diHome.clickOnAddButtonOnQueueWindow();
		                diHome.verifyEmptyRecordsInSpotQueue();
		                diHome.clickOnRemoveAll();
		                diHome.verifyEmptyRecordsInSpotSelected();
		                diHome.verifyDragDropFunctionalityForSpot();
		                diHome.clickOnDispatchTab();
		                diHome.getDispatchQueueFirstFieldValue();
		                diHome.getDispatchQueueSecondFieldValue();
		                diHome.clickOnSpotTab();
		                diHome.getSpotQueueFirstFieldValue();
		                diHome.clickOnAddButtonOnQueueWindow();
		                records=diHome.verifyRecordsCountInSpotSelected();
		                diHome.clickOnContinueQueuesInDispatch();
		                Thread.sleep(2000);
		                diHome.selectChangeSetQueueMenuItem();
		                Thread.sleep(2000);
		                recordsVerify=diHome.verifyRecordsCountInSpotSelected();
		                diHome.compareSavedRecordsSize(records,recordsVerify);
		                waitcloseAllBusyIcons();
		                Thread.sleep(2000);
		                diHome.clickOnDispatchTab();
		                //diHome.selectChangeSetQueueMenuItem();
		                queueFirstValueNotAdded=diHome.getDispatchQueueFirstFieldValue();
		                diHome.clickOnCloseButtonOnQueueWindow();
		
		                Thread.sleep(2000);
		                diHome.logOut();
		
		                waitcloseAllBusyIcons();
		                Thread.sleep(2000);
		                login(data.get("DILoginName"),data.get("Password"));
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnDispatchTab();
		                Thread.sleep(2000);
		                diHome.enterValueInQueueFilterSelected(queueFirstValueNotAdded);
		                diHome.verifyEmptyRecordsInSelected();
		                queueFirstValueNotAdded=diHome.getDispatchQueueFirstFieldValue();
		                diHome.clickOnCloseIconOnQueueSelection();
		
		                Thread.sleep(2000);
		                diHome.logOut();
		                waitcloseAllBusyIcons();
		                Thread.sleep(2000);
		                login(data.get("DILoginName"),data.get("Password"));
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnDispatchTab();
		                Thread.sleep(2000);
		                diHome.enterValueInQueueFilterSelected(queueFirstValueNotAdded);
		                diHome.verifyEmptyRecordsInSelected();
		                queueFirstValueNotAdded=diHome.getDispatchQueueFirstFieldValue();
		                diHome.clickOnDispatchQueuePopup();
		                //diHome.escapeSendKeys();
		                String combineKeys1 = Keys.chord(Keys.ESCAPE);
		                sendKeys(combineKeys1, "Esc");
		                diHome.clickOnCloseIconOnQueueSelection();
		                Thread.sleep(2000);
		
		                diHome.selectUserProfileMenuItem();
		                diHome.verifyUserProfilePopupWindow();
		                diHome.clickOnChangeEditQueueSelection();
		                diHome.clickOnCloseButtonOnQueueWindow();
		                crHomeLib.messageDialogBoxClose();
		                diHome.logOut();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2031",ReportStatus.strMethodName,intCounter,browser);
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