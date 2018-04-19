package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRVehicleTriagePage;
import com.aaa.web.page.CRVehicleTriagePage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;






import java.util.Hashtable;


public class TC_CRKeylockissue extends LoginLib
{
	String callId;

//String text = dataBean.getValue(,"text");
	

	@Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
	public void keyLockIssueRadioButton(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "keyLockIssueRadioButton", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("keyLockIssueRadioButton", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("ERS Cal Locksmith"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                enterMembershipDetailsandVehicleDetails(data);
		                selectRadioButtonKeysIssue(data);
		                validateAutoSpotanCallisSaved(data);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
	public void enterPacesetterCodeManuallyforKeyIssueScript(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "enterPacesetterCodeManuallyforKeyIssueScript", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("enterPacesetterCodeManuallyforKeyIssueScript", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("ERS Cal Locksmith"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                enterMembershipDetailsandVehicleDetails(data);
		                enterPacesetterCodeManuallyforKeyIssue(data);
		                validateAutoSpotanCallisSaved(data);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    
  

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
	public void enterPacesetterCodeforTowManuallyforKeyIssueScript(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "enterPacesetterCodeforTowManuallyforKeyIssueScript", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("enterPacesetterCodeforTowManuallyforKeyIssueScript", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("ERS Cal Locksmith"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                enterMembershipDetailsandVehicleDetails(data);
		                enterPacesetterCodeManuallyTowforKeyIssue(data);
		                validateAutoSpotanCallisSaved(data);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","7777",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
                
    public void enterMembershipDetailsandVehicleDetails(Hashtable<String, String> data) throws Throwable {
    	CRMemberSearchLib mem=new CRMemberSearchLib();
        CRLocationsLib loc=new CRLocationsLib();
        CRVehicleTriageLib veh=new CRVehicleTriageLib();
        CRServiceLib ser=new CRServiceLib();
        CRHomeLib home = new CRHomeLib();
        //launch application
        navigateToApplication("CR");
        //login to Application
        login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
        home.verifyHomeScreen();
        //enter and search member 
        home.memberSearchTextBox(dataBean.getValue(data,"Membersearch"));
        //search and close alert member
        mem.memberNumClick();
        //Enter primary phone number
        mem.enterMemberContactInfoPrimaryPhoneNumber(dataBean.getValue(data, "Primaryphonenum"));
        //enter prime phone type
        mem.membContInfoEnterPrimPhoneTypeCellular();
       //enter prime phone radio button
        mem.clickPrimRadioBtnRowOne();
        //enter breakdown location
        loc.breakdownLocTabSel();
        if(isElementPresent(CRLocationsPage.linkBrkDowLocAddr, "breakdown loacation address"))
        {
            loc.clickonBrkdownLocLink();
            loc.brkdownLocationCode(dataBean.getValue(data, "Breakdownlocationcode"));
        }
        else
        {
        	loc.enterTxtinBrkDowLocSrch(dataBean.getValue(data, "Breakdownaddress"));
            loc.brkDowLocSrchBtn();
            loc.brkdowLocAddrLink();
            loc.brkdownLocationCode(dataBean.getValue(data, "Breakdownlocationcode"));
        }
        //enter vehicle information
        veh.vehicletriageTabsel();
        if(isElementPresent(CRVehicleTriagePage.linkVehicleModel, "vehicle model")) 
        {
            veh.Vehicleinfolink();
            veh.Vehicletype(dataBean.getValue(data, "Vehicletype"));
            veh.enterVehicleColor(dataBean.getValue(data, "Vehiclecolor"));
        }
        else
        {
        	veh.Entervehicleinfomanually(dataBean.getValue(data, "Vehiclemodel"));
            veh.clickVehicleSearchButton();
            veh.availableVehicleaftersrch();
            veh.vehicleColor(dataBean.getValue(data, "Vehiclecolor"));
        } 
    }

    public void selectRadioButtonKeysIssue(Hashtable<String, String> data) throws Throwable {
    	//declarations
    	CRVehicleTriageLib veh=new CRVehicleTriageLib();
    	
    	veh.pacesetterCodegeneration_Keysissue();
        veh.validatePacesetterCode(data.get("Pacesettercode"));
    }
    
    public void enterPacesetterCodeManuallyforKeyIssue(Hashtable<String, String> data) throws Throwable {
    	//declarations
    	CRVehicleTriageLib veh=new CRVehicleTriageLib();
    	
    	veh.manualPacesetterCodekey(data.get("Pacesettercode"));
        veh.validatePacesetterCode(data.get("Pacesettercode"));
    }
    
    public void enterPacesetterCodeManuallyTowforKeyIssue(Hashtable<String, String> data) throws Throwable {
    	//declarations
    	CRVehicleTriageLib veh=new CRVehicleTriageLib();
    	CRTowDestinationLib Towlib=new CRTowDestinationLib();
    	
    	veh.manpacecodeTow_enterpacesettcode(data.get("Pacesettercode"));
        veh.validatePacesetterCode(data.get("Pacesettercode"));
        veh.manupacecodeTow_btn();
        Towlib.towLocation(data.get("Towpassengers"));
    }
    
    public void validateAutoSpotanCallisSaved(Hashtable<String, String> data) throws Throwable {
        //Declarations
    	CRVehicleTriageLib veh=new CRVehicleTriageLib();
        CRServiceLib ser=new CRServiceLib();
        LoginRoleLib ll = new LoginRoleLib();
        DIHomeLib dih = new DIHomeLib();
        DISearchCallsLib dis = new DISearchCallsLib();
        CRHomeLib crh = new CRHomeLib();
        
        ser.validateFacilityAutospot();
        ser.clickOnSaveBtn();
        callId = ser.getCallId();
        crh.logout();
        navigateToApplication("DI");
        enterLoginDetails(data.get("DILoginName"), data.get("DIPassword"));
        ll.selectRoleAndProceed(dataBean.getValue(data, "RoleinDispatch"));
        dih.clickOnContinueQueuesInDispatch();
        dih.clickOnSearchCallsInDispatch();
        dis.searchAndSelectCallID(callId);
        dih.logOut();
        
        
    }
}