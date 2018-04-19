package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.accelerators.TestEngineWeb;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRVehicleTriagePage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;






import java.util.Hashtable;

public class TC_CRERSBattery extends LoginLib
{
	String callId;
   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void ERSBatteryJumpStart(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "ERSBatteryJumpStart", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ERSBatteryJumpStart", TestData, "D3CallRecieving",intCounter);
    	
		                TestEngineWeb.reporter.initTestCaseDescription("CR ERS Battery"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                //declarations
		                CRVehicleTriageLib veh=new CRVehicleTriageLib();
		                //enter membership details
		                enterMembershipDetailsandVehicleDetails(data);
		                //select problem 
		                veh.selectJumpStartFromBattery();
		                //validate pacesettercode
		                veh.validatePacesetterCode(dataBean.getValue(data,"Pacesettercode") );
		                //validate auto spot and call is saved
		                validateAutoSpotanCallisSaved(data);
		                
		                System.out.println("Test completed");
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
    public void ERSBatteryTruck(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "ERSBatteryTruck", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("ERSBatteryTruck", TestData, "D3CallRecieving",intCounter);
    	
		                TestEngineWeb.reporter.initTestCaseDescription("CR ERS Battery"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                //declarations
		                CRVehicleTriageLib veh=new CRVehicleTriageLib();
		                CRServiceLib ser=new CRServiceLib();
		                enterMembershipDetailsandVehicleDetails(data);
		                veh.enterPacesetterCodeBattery(dataBean.getValue(data,"Pacesettercode") );
		              //validate pacesettercode
		                veh.validatePacesetterCode(dataBean.getValue(data,"Pacesettercode") );
		                validateAutoSpotanCallisSaved(data);
		                System.out.println("Test completed");
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
        if (Member.isEmpty())
        {
        	Member = data.get("Membersearch");
        }
        home.memberSearchTextBox(Member);
        //home.memberSearchTextBox(dataBean.getValue(data,"Membersearch"));
        //search and close alert member
        mem.memberNumClick();
        //Enter primary phone number
        mem.enterMemberContactInfoPrimaryPhoneNumberRandomly(dataBean.getValue(data, "Primaryphonenum"));
        //enter prime phone type cellular
        mem.membContInfoEnterPrimPhoneTypeCellular();
       //enter prime phone radio button
        mem.clickPrimRadioBtnRowOne();
        //enter breakdown location
        loc.breakdownLocTabSel();
        loc.enterBreakDownAddressOmniBarSearch(data.get("Breakdownaddress"));
        //enter vehicle information
        veh.vehicletriageTabsel();
        String VehicleDet[] = data.get("Vehiclemodel").split("#");
        veh.enterVehicleSearch(VehicleDet[0]);
        veh.clickOnTheVehicleSearchIcon();
        veh.clickOnTheVehicleSearch();
        veh.vehicleColor(VehicleDet[1]);
    }
    
    public void validateAutoSpotanCallisSaved(Hashtable<String, String> data) throws Throwable {
        //Declarations
    	CRVehicleTriageLib veh=new CRVehicleTriageLib();
        CRServiceLib ser=new CRServiceLib();
        LoginRoleLib ll = new LoginRoleLib();
        DIHomeLib dih = new DIHomeLib();
        DISearchCallsLib dis = new DISearchCallsLib();
        CRHomeLib crh = new CRHomeLib();
        
        //veh.validatePaceSetterCode(data.get("Pacesettercode"));
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
        
        
        //navigateTo(CALL_RECEIVING_URL);
        
    }
    
}