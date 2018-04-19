

package test.webmobile;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.accelerators.TestEngineWeb;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.CRServicePage;
import com.aaa.web.page.CRVehicleTriagePage;
import com.sun.jna.platform.win32.OaIdl.SYSKIND;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRCancelCalls2 extends ActionEngine {
	String problemTypes;
	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test
	public void ValidatekillProcessForCallsnew1(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try {
			System.out.println(StartRow);
			System.out.println(EndRow);
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crCancelCalls", TestData, "D3CallRecieving");
			System.out.println(intEndRow);
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
						ReportStatus.fnDefaultReportStatus();
						ReportControl.intRowCount=intCounter;
						Hashtable<String, String> data=TestUtil.getDataByRowNo("crCancelCalls", TestData, "D3CallRecieving",intCounter);
						System.out.println("Row N0==> "+ intCounter);
						this.reporter.initTestCaseDescription("1707:TC-ValidatekillProcessForCallsnew1 == " + "from " + intStartRow + " to " + intEndRow);
						//reporter.SuccessReport("Web Script Iteration ", "Iteration No ==> " + data.get("iterationNumber") );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ Integer.parseInt(data.get("IterationNumber").replace(".0", ""))+"   **************");
						CRHomeLib home = new CRHomeLib();
						CRLocationsLib locations = new CRLocationsLib();
						CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
						CRMemberSearchLib memeber = new CRMemberSearchLib();
						CRSearchCallsLib search = new CRSearchCallsLib();
						CRServiceLib service = new CRServiceLib();
						// Logging into the application
						LoginToApplication(data);
						//EnteringRequiredFieldsForCall(data);
						Thread.sleep(5000);
						home.logout();
						acceptAlert();
						Thread.sleep(5000);
			            System.out.println("Test completed");	
			           
					}
					catch(Exception e)
					{
						ReportStatus.blnStatus=false;
					}
				 ReportControl.fnEnableJoin();
				 System.out.println("browser");
				 ReportStatus.fnUpdateResultStatus("CR","34677",ReportStatus.strMethodName,intCounter,browser);
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}

	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test
	public void ValidatekillProcessForCallsNext(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try {
			System.out.println(StartRow);
			System.out.println(EndRow);
			int intStartRow=StartRow;
			int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crCancelCalls", TestData, "D3CallRecieving");
			System.out.println(intEndRow);
			for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
			{
				try {
						ReportStatus.fnDefaultReportStatus();
						ReportControl.intRowCount=intCounter;
						Hashtable<String, String> data=TestUtil.getDataByRowNo("crCancelCalls", TestData, "D3CallRecieving",intCounter);
						System.out.println("Row N0==> "+ intCounter);
						this.reporter.initTestCaseDescription("1707:TC-ValidatekillProcessForCallsNext == " + "from " + intStartRow + " to " + intEndRow);
						//reporter.SuccessReport("Web Script Iteration ", "Iteration No ==> " + data.get("iterationNumber") );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ Integer.parseInt(data.get("IterationNumber").replace(".0", ""))+"   **************");
						CRHomeLib home = new CRHomeLib();
						CRLocationsLib locations = new CRLocationsLib();
						CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
						CRMemberSearchLib memeber = new CRMemberSearchLib();
						CRSearchCallsLib search = new CRSearchCallsLib();
						CRServiceLib service = new CRServiceLib();
						// Logging into the application
						LoginToApplication(data);
						//EnteringRequiredFieldsForCall(data);
						Thread.sleep(5000);
						home.logout();
						acceptAlert();
						Thread.sleep(5000);
			            System.out.println("Test completed");	
			           
					}
					catch(Exception e)
					{
						ReportStatus.blnStatus=false;
					}
				 ReportControl.fnEnableJoin();
				 System.out.println("browser");
				 ReportStatus.fnUpdateResultStatus("CR","34678",ReportStatus.strMethodName,intCounter,browser);
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		ReportControl.fnNextTestJoin(nextTestJoin);
	}
	
	


	public void LoginToApplication(Hashtable<String, String> data) throws Throwable {
		LoginLib login = new LoginLib();
		CRHomeLib home = new CRHomeLib();
		// Logging into the application
		navigateToApplication("CR");
		login.login(data.get("LoginName"), data.get("Password"));
		Thread.sleep(5000);
		home.allErrorAlertsNoButton();
		home.messageDialogBoxClose();
	}

	public void EnteringRequiredFieldsForCall(Hashtable<String, String> data)throws Throwable {

		//this.reporter.initTestCaseDescription("1707:TC-Cancel Calls");
		CRHomeLib home = new CRHomeLib();
		CRLocationsLib locations = new CRLocationsLib();
		CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		CRMemberSearchLib memeber = new CRMemberSearchLib();
		CRSearchCallsLib search = new CRSearchCallsLib();
		CRServiceLib service = new CRServiceLib();
		// Logging into the application
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
        	Member = data.get("MemberNumber");
        }
        home.memberSearchTextBox(Member);
		//home.memberSearchTextBox(data.get("MemberNumber"));
		memeber.memberNumClick();
		memeber.currentCallClose();
		memeber.clickPrimRadioBtnSecondRow();
		// Locations Page Starts
		locations.clickOnLocationTab();
		Thread.sleep(3000);
		locations.clickOnSecondKownBrkDowLocation();
		Thread.sleep(3000);
		// Vehicle Triage Page Starts here
		vehicle.clickOnVehicleTriageTab();
		//vehicle.selectExistingVehicleModel();
		vehicle.clickOnManualEntryLinkOnVehicle();
		vehicle.enterVehicleType(data.get("VehicleType"));
		Thread.sleep(3000);
		vehicle.enterVehicleYear(data.get("VehicleYear"));
		Thread.sleep(1000);
		vehicle.enterVehicleMake(data.get("VehicleMake"));
		Thread.sleep(1000);
		vehicle.enterVehicleModel(data.get("VehicleModel"));
		Thread.sleep(1000);
		vehicle.enterVehicleColor(data.get("VehicleColor"));
		Thread.sleep(1000);
		vehicle.clickTag();
		vehicle.clickonProblemTypeButton(data.get("TriageType"));
		Thread.sleep(2000);
		vehicle.clickonProblemTypeOptions(data.get("TriageTypeOption"));
	}

}