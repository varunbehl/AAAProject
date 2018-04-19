
package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRMemberSearchPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRPhoneTypesScript extends CRHomeLib{
    String callId;
    String spotID;
    String callDate;
    String callIDAndDateCombined;

   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void phoneTypeverification(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "validatePhoneTypes", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("validatePhoneTypes", TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("CR Phone Types"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib crhome = new CRHomeLib();
		                DIHomeLib dihome = new DIHomeLib();
		                LoginRoleLib loginrole = new LoginRoleLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRLocationsLib location = new CRLocationsLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRServiceLib service = new CRServiceLib();
		                DIMCDLib dimcdLib=new DIMCDLib();
		                
		                navigateToApplication("CR");
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		                crhome.verifyHomeScreen();
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
		                crhome.memberSearchTextBox(Member);
		                member.memberNumClick();
		                member.labelMemberLevelInMemberDetailsSection();
		                member.enterMemberContactInfoPrimaryPhoneNumberRandomly(dataBean.getValue(data, "Primaryphonenum"));
		                member. membContInfoEnterPrimPhoneTypeCellular();
		                member.clickPrimRadioBtnRowOne();
		                //member.currentCallClose();
		                location.breakdownLocTabSel();
		                location.enterBreakDownAddressOmniBarSearch(data.get("Breakdownaddress"));
		                //enter vehicle information
		                vehicle.vehicletriageTabsel();
		                String VehicleDet[] = data.get("Vehiclemodel").split("#");
		                vehicle.enterVehicleSearch(VehicleDet[0]);
		                vehicle.clickOnTheVehicleSearchIcon();
		                vehicle.clickOnTheVehicleSearch();
		                vehicle.vehicleColor(VehicleDet[1]);
		                /*location.enterLocationDetails(dataBean.getValue(data, "Breakdownlocationcode"),dataBean.getValue(data, "Breakdownaddress"));
		
		                vehicle.enterVehicleDetails(dataBean.getValue(data, "Vehicletype"),dataBean.getValue(data, "Vehiclecolor"),dataBean.getValue(data, "Vehiclemodel"));
		               */ //vehicle.selectPaceSetterCode();
		                vehicle.selectJumpStartFromBattery();
		                if (isVisibleOnly(CRMemberSearchPage.scriptError, "Script Error OKAY button"))
		                    click(CRMemberSearchPage.scriptError, "Script error Okay button");
		                crhome.allErrorAlerts();
		                service.validateFacilityAutospot();
		                service.enterManualFacilityNumber(data.get("Facility"));
		                service.clickOnSpotInServicePage();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                crhome.saveButton();
		                login.waitcloseAllBusyIconsResults();
		                //service.errorAlertHandlingAfterSave();
		                spotID = service.getSpotFacilityId();
		                callDate=service.getCallDate();
		                callId = service.getCallId();
		                service.closeCallWindow();
		                //LogOut
		                crhome.logout();
		
		                navigateToApplication("DI");
		                //login.diLogin(data);
		                login.login(data.get("DILoginName"), data.get("DIPassword"));
		                loginrole.roleSelection(data.get("RoleinDispatch"));
		                dihome.clickOnContinueQueuesInDispatch();
		
		                //Verify Phonetype on Search Tab
		                dihome.clickOnSearchCallsInDispatch();
		                dihome.searchAndSelectCallIDInDI(callId);
		                dimcdLib.clickOnMemberTabInMCDWindow();
		                dihome.verifyPhoneTypeOnDIMCD(data.get("PhoneType"));
		
		                //Verify on Profile Tab
		                dihome.clickOnProfile();
		                callIDAndDateCombined = callDate.substring(0,4) + callDate.substring(5,7)+ callDate.substring(8,10)+callDate.substring(4,5)+callId;
		                dihome.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombined);
		                dimcdLib.clickOnMemberTabInMCDWindow();
		                dihome.verifyPhoneTypeOnProfile(data.get("PhoneType"));
		
		                //Verify Phone Type on TruckLoad Tab
		                dihome.clickOnTruckLoad();
		                dihome.enterSpotFacilityIDInfoOnTruckLoad(spotID); //spotIDCreated
		                Thread.sleep(5000);
		                dihome.dateDecendingOrder();
		                callIDAndDateCombined = callDate.substring(0,4) + callDate.substring(5,7)+ callDate.substring(8,10)+callDate.substring(4,5)+callId;
		                dihome.searchAndClickOnCallIdOnTruckloadWindow(callIDAndDateCombined);
		                dimcdLib.clickOnMemberTabInMCDWindow();
		                dihome.verifyPhoneTypeOnTruckLoad(data.get("PhoneType"));
		                dihome.clickonCloseInTruckLoad();
		                //LogOut DI Application
		                crhome.logout();
		
		                //Navigate To SPP and Login With SPP Login Credentials
		                navigateToApplication("DI");
		                //login.sppLogin(data);
		                //SPP -- verify Phone Type on SearchCall Tab
		                login.login(data.get("sppLogin"), data.get("sppPassword"));
		                dihome.clickForSearchCallID();
		                dihome.searchAndSelectCallIDInSPPDI(callId);
		                dimcdLib.clickOnMemberTabInMCDWindow();
		                //dihome.verifyPhoneTypeOnSPPDIMCD(data.get("PhoneType"));
		                dihome.verifyPhoneTypeOnDIMCD(data.get("PhoneType"));
		
		                //SPP -- Verify PhoneType In Profile
		                dihome.clickOnProfileMenu();
		                dihome.clickOnProfile1UnderProfileMenuSPPDI();
		                callIDAndDateCombined = callDate.substring(0,4) + callDate.substring(5,7)+ callDate.substring(8,10)+callDate.substring(4,5)+callId;
		                dihome.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombined);
		                //dihome.searchAndSelectCallIDOnProfile(callIDAndDateCombined);
		                dihome.verifyPhoneTypeOnProfileInSPPDI(data.get("PhoneType"));
		                dihome.closeMcd();
		
		                //SPP -- TruckLoad Tab
		                dihome.clickOnTruckLoadTab();
		                dihome.clickOnTruckLoadDefaultOptioninSPP();
		                dihome.searchAndClickOnCallIdOnTruckloadWindow(callIDAndDateCombined);
		                Thread.sleep(3000);
		                dimcdLib.clickOnMemberTabInMCDWindow();
		                dihome.verifyPhoneTypeInSPPTruckLoadDefault(data.get("PhoneType"));
		                dihome.closeMcd();
		                crhome.logout();
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

