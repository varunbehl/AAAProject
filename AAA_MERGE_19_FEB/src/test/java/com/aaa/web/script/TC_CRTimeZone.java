package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E001133 on 27-11-2017.
 */
public class TC_CRTimeZone extends DILoginLib {
        String callID;
        String pstTimeZone;
        String newZone;
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

    public void crTimeZone(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crTimeZoneVerification", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crTimeZoneVerification", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Time Zone"+ " From Iteration " + StartRow + " to " + EndRow );
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
		                login(data.get("CRLoginName"),data.get("Password"));
		                waitcloseAllBusyIcons();
		                home.messageDialogBoxClose();
		                String Member = "";
		                if (data.get("Member").equals("db")){
		        	        //fetch member details from db
		        	        //generating a random number everytime to fetch a new record everytime
		        	        int rownum = IntRandomNumberGenerator(50,1000);       
		        	        //member from db
		        	        Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"),data.get("dbqueryFileName"),data.get("colomnName"),rownum);
		        	        System.out.println("member : "+Member);
		                }
		                else
		                {
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
		                //home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                locations.breakdownLocTabSel();
		                locations.enterBreakDownAddressOmniBarSearch(data.get("Breakdownaddress"));
		                locations.enterCallComments(data.get("CallComments"));
		                locations.clickOnCallCommentsAddButton();
		                locations.enterCallComments(data.get("CallComments"));
		                locations.clickOnCallCommentsAddButton();
		                newZone=locations.compareTimeZones(data.get("stateValue"),data.get("oldStateValue"));
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.vehicletriageTabsel();
		                String VehicleDet[] = data.get("Vehiclemodel").split("#");
		                crVehicleTriageLib.enterVehicleSearch(VehicleDet[0]);
		                crVehicleTriageLib.clickOnTheVehicleSearchIcon();
		                crVehicleTriageLib.clickOnTheVehicleSearch();
		                crVehicleTriageLib.vehicleColor(VehicleDet[1]);
		                /*crVehicleTriageLib.selectExistingVehicleModel();*/
		                crVehicleTriageLib.clickOnFuel();
		                crVehicleTriageLib.clickOnOutOfGas();
		                crHomeLib.saveButton();
		                //crHomeLib.allErrorAlerts();
		                waitcloseAllBusyIcons();
		                Thread.sleep(10000);
		                callID=services.getCallId();
		                services.closeCallWindow();
		                diHome.logOut();
		                navigateToApplication("DI");
		                login(data.get("DILoginName"),data.get("Password"));
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.clickOnSearchCallsInDispatch();
		                diHome.enterStartDate(data.get("StartDate"));
		                diHome.enterCallIDInfo(callID);
		                diHome.clickOnSearchInSearchCalls();
		                diHome.clickOnCallDateOrIDLink();
		                pstTimeZone=diHome.getPTATimeZone();
		                diHome.compareTimeZonesInCRDI(pstTimeZone,newZone);
		                //dimcdLib.clickOnCloseCallButton();
		                diHome.logOut();
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

}
