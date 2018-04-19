package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRLeaveCall extends ActionEngine {
    String callId;
    String phoneNumber;
    String phoneNum;
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void leaveCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "leaveCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("leaveCall", TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("Leave Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRLocationsLib location = new CRLocationsLib();
		                CRTowDestinationLib towdestination = new CRTowDestinationLib();
		                CRHomeLib home = new CRHomeLib();
		                CRServiceLib service = new CRServiceLib();
		
		                login.login(data.get("LoginName"),data.get("Password"));
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
		                member.currentCallClose();
		               // String numberOfcalls1 = member.getCurrentCallsForMember();
		                member.clickOnManualEntryLinkInMember();
		                member.enterMemberMandatoryFields(data.get("FirstName"),data.get("LastName"),data.get("Address"),data.get("City"),
		                        data.get("State"),data.get("Zip"),data.get("Email"), data.get("PhoneNumber"),
		                        data.get("PhoneType"),Member,
		                        data.get("MemberLevel"),data.get("Expiration"),data.get("Status"));
		
		                location.clickOnLocationTab();
		                location.enterBreakDownAddressOmniBarSearch(data.get("BreakdownAddress"));
		                /*location.clickonBrkdownLocLink();*/
		                vehicle.clickOnVehicleTriageTab();
		                String VehicleDet[] = data.get("Vehiclemodel").split("#");
		                vehicle.enterVehicleSearch(VehicleDet[0]);
		                vehicle.clickOnTheVehicleSearchIcon();
		                vehicle.clickOnTheVehicleSearch();
		                vehicle.vehicleColor(VehicleDet[1]);
		                vehicle.clickOnFuel();
		                vehicle.clickOnOutOfGas();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                service.clickOnSaveBtn();
		                home.allErrorAlerts();
		                callId = service.getCallId();
		                service.closeCallWindow();
		                //Call created
		                home.clickOnSearchCallDroupDown();
		                home.clickOnSearchCallsLink();
		                home.enterCallIdForSearch(callId);
		                home.clickOnSearchButtonOnSearchCalls();
		                home.clickOnCallIdOnSearchCalls();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                vehicle.scriptErrorHandle();
		                member.enterPhoneNumber(data.get("PhoneNumber_Different"));
		                phoneNumber = member.getPhoneNumber();
		                vehicle.scriptErrorHandle();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.leaveButton();
		
		               // member.selectType(data.get("PhoneType"));
		               // member.clickPrimRadioBtnRowOne();
		                //home.leaveButton();
		                home.messageForLeaveCall();
		                home.allErrorAlerts();
		
		                home.clickOnSearchCallDroupDown();
		                home.clickOnSearchCallsLink();
		                home.enterCallIdForSearch(callId);
		                home.clickOnSearchButtonOnSearchCalls();
		                //home.clickOnCallIdOnSearchCalls();
		                phoneNum=home.getPhoneNumberFromMemberDetailsInSearchCalls();
		                home.verifyPhoneNumbersForUpdation(phoneNumber,phoneNum);
		                member.closeSearchCallsWindow();
		                home.logout();
		
		
		
		
		
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
