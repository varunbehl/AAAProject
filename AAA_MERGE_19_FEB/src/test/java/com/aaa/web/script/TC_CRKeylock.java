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

public class TC_CRKeylock extends LoginLib
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
		                //declarations
		                CRVehicleTriageLib veh=new CRVehicleTriageLib();
		                enterMembershipDetailsandVehicleDetails(data);
		                selectRadioButtonKeysIssue(data);
		              //validate pacesettercode
		                veh.validatePacesetterCode(dataBean.getValue(data,"Pacesettercode") );
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
    	
		                this.reporter.initTestCaseDescription("ERS Cal Locksmith");
		              //declarations
		                CRVehicleTriageLib veh=new CRVehicleTriageLib();
		                enterMembershipDetailsandVehicleDetails(data);
		                enterPacesetterCodeManuallyforKeyIssue(data);
		              //validate pacesettercode
		                veh.validatePacesetterCode(dataBean.getValue(data,"Pacesettercode") );
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
		                //declarations
		                CRVehicleTriageLib veh=new CRVehicleTriageLib();
		                enterMembershipDetailsandVehicleDetails(data);
		                enterPacesetterCodeManuallyTowforKeyIssue(data);
		              //validate pacesettercode
		                //veh.validatePacesetterCode(dataBean.getValue(data,"Pacesettercode") );
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
        home.verifyandClickLogout();
        //launch application
        navigateToApplication("CR");
        //login to Application
        login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
        home.verifyHomeScreen();
        //enter and search member 
        String Member = "";
        if (data.get("Member").equals("db")){
	        //fetch member details from db
	        //generating a random number everytime to fetch a new record everytime
	        int rownum = IntRandomNumberGenerator(50,1000);       
	        //member from db
	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
	        System.out.println("member : "+Member);
        }
        if(Member.isEmpty())
        {
        	Member = data.get("Membersearch");
        }
        home.memberSearchTextBox(Member);
        //home.memberSearchTextBox(dataBean.getValue(data,"Membersearch"));
        //search and close alert member
        mem.memberNumClick();
        //Enter primary phone number
        mem.enterMemberContactInfoPrimaryPhoneNumberRandomly(dataBean.getValue(data, "Primaryphonenum"));
        //enter prime phone type
        mem.membContInfoEnterPrimPhoneTypeCellular();
       //enter prime phone radio button
        mem.clickPrimRadioBtnRowOne();
        //enter breakdown location
        loc.breakdownLocTabSel();
        loc.enterBreakDownAddressOmniBarSearch(dataBean.getValue(data, "BreakdownAddress"));
        //enter vehicle informationBreakdownAddress
        veh.vehicletriageTabsel();
        String VehicleDet[] = (dataBean.getValue(data, "Vehiclemodel")).split("#");
        veh.enterVehicleSearch(VehicleDet[0]);
        veh.clickOnTheVehicleSearchIcon();
        veh.clickOnTheVehicleSearch();
        veh.vehicleColor(VehicleDet[1]);
    }

    public void selectRadioButtonKeysIssue(Hashtable<String, String> data) throws Throwable {
    	//declarations
    	CRVehicleTriageLib veh=new CRVehicleTriageLib();
    	veh.pacesetterCodegeneration_Keysissue();
    	veh.handleScriptErrorInVehicleTriagePage();
        veh.validatePacesetterCode(data.get("Pacesettercode"));
    }
    
    public void enterPacesetterCodeManuallyforKeyIssue(Hashtable<String, String> data) throws Throwable {
    	//declarations
    	CRVehicleTriageLib veh=new CRVehicleTriageLib();
    	veh.manualPacesetterCodekey(data.get("Pacesettercode"));
    	veh.handleScriptErrorInVehicleTriagePage();
        //veh.validatePacesetterCode(data.get("Pacesettercode"));
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
        veh.handleScriptErrorInVehicleTriagePage();
        ser.validateFacilityAutospot();
        ser.clickOnSaveBtn();
        callId = ser.getCallId();
        ser.closeCallWindow();
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