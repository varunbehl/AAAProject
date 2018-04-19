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

public class TC_CRManualEnterMembershipSave extends ActionEngine {
    String callId;
    String callsAllowedBeforeMemberCall;
    String callsAllowedAfterMemberCall;
  

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void memberFieldsSaveByManualEntry(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "MemberFieldsSave", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("MemberFieldsSave", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("Manual Enter Membership Save"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRLocationsLib location = new CRLocationsLib();
		                CRTowDestinationLib towdestination = new CRTowDestinationLib();
		                CRHomeLib home = new CRHomeLib();
		                CRServiceLib service = new CRServiceLib();
		                Thread.sleep(5000);
		                login.login(data.get("LoginName"),data.get("Password"));
		                home.messageDialogBoxClose();
		                String Member = data.get("Membersearch");
		                member.currentCallClose();
		                /*callsAllowedBeforeMemberCall =member.memberCallsAllowedInMemberDetailsSection();
		                System.out.println("callsAllowedBeforeMemberCall"+callsAllowedBeforeMemberCall);*/
		                member.verifyManualEntryLink();
		                member.clickOnManualEntryLinkInMember();
		                member.memFieldsVerification();
		                home.memberSearchTextBox(data.get("Membersearch"));
		                member.memberNumClick();
		                member.labelMemberLevelInMemberDetailsSection();
		                callsAllowedBeforeMemberCall =member.memberCallsAllowedInMemberDetailsSection();
		                System.out.println("callsAllowedBeforeMemberCall"+callsAllowedBeforeMemberCall);
		                member.clickOnManualEntryLinkInMember();
		                member.enterMemberMandatoryFields(data.get("FirstName"),data.get("LastName"),data.get("Address"),data.get("City"),
		                        data.get("State"),data.get("Zip"),data.get("Email"), data.get("PhoneNumber"),
		                        data.get("PhoneType"),Member,
		                        data.get("MemberLevel"),data.get("Expiration"),data.get("Status"));
		                location.clickOnLocationTab();
		                location.enterBreakDownAddressOmniBarSearch(data.get("Breakdownaddress"));
		                vehicle.clickOnVehicleTriageTab();
		                String VehicleDet[] = data.get("Vehiclemodel").split("#");
		                vehicle.enterVehicleSearch(VehicleDet[0]);
		                vehicle.clickOnTheVehicleSearchIcon();
		                vehicle.clickOnTheVehicleSearch();
		                vehicle.vehicleColor(VehicleDet[1]);
		                vehicle.clickOnFuel();
		                vehicle.clickOnOutOfGas();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.waitCloseAllBusyIconsResults();
		                home.saveButton();
		                home.allErrorAlerts();
		                callId = service.getCallId();
		                service.closeCallWindow();
		                home.memberSearchTextBox(Member);
		                member.memberNumClick();
		                callsAllowedAfterMemberCall =member.memberCallsAllowedInMemberDetailsSection();
						String callsActiveAfterCall = member.getCurrentCallsForMember();                
				        System.out.println("callsAllowedAfterMemberCall"+callsAllowedAfterMemberCall);
		                member.veryfyCallCountForMember(callsAllowedBeforeMemberCall,callsAllowedAfterMemberCall);
		                Thread.sleep(5000);
		                home.memberSearchTextBox(data.get("Membersearch_wrongId"));
		                Thread.sleep(5000);
		                member.clickOnManualEntryLinkInMember();
		                Thread.sleep(5000);
		                member.enterMemberMandatoryFields(data.get("FirstName"),data.get("LastName"),data.get("Address"),data.get("City"),
		                        data.get("State"),data.get("Zip"),data.get("Email"), data.get("PhoneNumber"),
		                        data.get("PhoneType"),Member,
		                        data.get("MemberLevel"),data.get("Expiration"),data.get("Status"));
		                location.clickOnLocationTab();
		                location.clickOnManualEntryLinkInLocation();
		                location.enterAndSaveLocationMandatoryFields(data.get("BKDownStreetAddress"), data.get("BKDownCityLocation"), data.get("BKDownState"), data.get("BKDownLocCode"));
		                vehicle.clickOnVehicleTriageTab();
		                vehicle.clickOnManualEntryLinkOnVehicle();
		                vehicle.enterandSaveVehicleMandatoryFields(data.get("VehicleType"),data.get("VehicleYear"),data.get("VehicleMake"),data.get("VehicleModel"),data.get("VehicleColor"),data.get("PaceSettercode"));
		                towdestination.clickOnTowDestinationTab();
		                Thread.sleep(5000);
		                login.waitcloseAllBusyIconsResults();
						acceptAlert();               
				        vehicle.handleScriptErrorInVehicleTriagePage();
		                towdestination.clickOnManualEntryLinkOnTowDestination();
		                towdestination.enterTowDestinationMandatoryFields(data.get("TowPassengers"));
		                service.clickOnServiceTab();
		                service.enterServiceMandatoryFields(data.get("Facilitty"));
		                home.saveButton();
		                home.allErrorAlerts();
		                callId = service.getCallId();
		                service.closeCallWindow();
		                home.clickOnSearchCallDroupDown();
		                home.clickOnSearchCallsLink();
		                home.enterCallIdForSearch(callId);
		                home.clickOnSearchButtonOnSearchCalls();
		                member.verifyTheCreatedCall(callId);
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



