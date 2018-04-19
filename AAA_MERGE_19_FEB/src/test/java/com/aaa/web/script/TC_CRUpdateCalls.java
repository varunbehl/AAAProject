package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.accelerators.ActionEngine;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRServicePage;
import com.aaa.web.page.CRVehicleTriagePage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRUpdateCalls extends ActionEngine {
	LoginLib login = new LoginLib();
	CRMemberSearchLib member = new CRMemberSearchLib();
	CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
	CRLocationsLib location = new CRLocationsLib();
	CRTowDestinationLib towdestination = new CRTowDestinationLib();
	CRHomeLib home = new CRHomeLib();
	CRServiceLib service = new CRServiceLib();
	CRServiceLib services = new CRServiceLib();




	 @Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void crUpdateCalls(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		 try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crUpdateCalls", TestData, "D3CallRecieving");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crUpdateCalls", TestData, "D3CallRecieving",intCounter);
	    	
						this.reporter.initTestCaseDescription("1713: TC-Update Calls"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						login.login(data.get("LoginName"), data.get("Password"));
						member.clickOnPartialCallCloseButton();
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
						member.clickPrimRadioBtnSecondRow();
		
						location.clickOnLocationTab();
						location.clickOnManualEntryLinkInLocation();
						location.enterBlockRange(data.get("StreetNumber1"));
						String streenNumber = location.getBlockRange();
						boolean streenNumberValue = streenNumber != null;
						assertTrue(streenNumberValue,"verified the Streen Number that is entered in Breakdown Location & entered StreenNumber    "+streenNumber);
						location.enterBKDownStreetAddress(data.get("StreetAddress1"));
						String streetAddressValue=location.getBKDownStreetAddress();
						boolean streetAddress = streetAddressValue != null;
						assertTrue(streetAddress,"Verified the Street Address That is entered in Breakdown Location & entered StreetAddress   "+streetAddressValue);
						location.enterBKDownCityLocation(data.get("City1"));
						String cityValue=location.getCityValue();
						boolean city=cityValue != null;
						assertTrue(city,"Verified the City That is entered in Breakdown Location & entered city   "+cityValue);
						location.enterBKDownState(data.get("State1"));
						String stateValue=location.getStateValue();
						boolean state = stateValue != null;
						assertTrue(state,"Verified the State That is entered in Breakdown Location & entered State  "+stateValue);
						location.enterBKDownLocCode(data.get("LocationCode1"));
						String locationCodeValue=location.getLocationCode();
						boolean locationCode=locationCodeValue != null;
						assertTrue(locationCode,"Verified the Location Code that is entered in Breakdown Location & entered LocationCode   "+locationCodeValue);
						vehicle.clickOnVehicleTriageTab();
						vehicle.selectExistingVehicleModel();
						Thread.sleep(2000);
						vehicle.clickonProblemTypeButton(data.get("ProblemType1"));
						Thread.sleep(3000);
						vehicle.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
						service.clickOnServiceTab();
						Thread.sleep(3000);
						service.validateNoFacilityAutoSpot();
						Thread.sleep(2000);
						home.saveButton();
						home.allErrorAlerts();
						home.allErrorAlerts();
						services.clickOnRemainInCall();
						Thread.sleep(2000);
						home.allErrorAlerts();
						services.clickOnCallStatusButton();
						home.allErrorAlerts();
						home.allErrorAlerts();
						services.verifyToGetCallStatus(data.get("CallStatusForRE"));
						services.getTextOfStatusValue();
						services.getTextOfResonValue();
						services.getTextOfUserNameValue();
						services.getTextOfRoleNameValue();
						services.clickOnCallStatusButton();
						service.clickOnServiceTab();
						services.enterManualFacilityNumber(data.get("facilityNumber"));
						services.clickOnSpotInServicePage();
						Thread.sleep(5000);
						vehicle.scriptErrorHandle();
						services.validateFacilityAutospotID();
						Thread.sleep(2000);
						services.getTextCallStatusButton();
						home.saveButton();
						Thread.sleep(2000);
						services.getTextAndClickOnYesInSpStatusPopup();
						Thread.sleep(2000);
						services.verifyUpdateCallStatus();
						services.verifyUpdateIsNotClikable();
						services.enterInCommentStatus(data.get("commentStatusUpdate1"));
						Thread.sleep(2000);
						services.verifyUpdateIsNotClikable();
						Thread.sleep(2000);
						services.enterInResonForStatusStatus(data.get("statusReason1"));
						services.clickOnComment();
						services.verifyUpdateIsNowClikable();
						Thread.sleep(2000);
						home.allErrorAlerts();
						services.clickUpdateButton();
						Thread.sleep(2000);
						services.clickOnRemainInCall();
						home.allErrorAlerts();
						home.allErrorAlerts();
						services.getTextCallStatus();
						services.clickOnCallStatusButton();
						home.allErrorAlerts();
						services.getTextStatusValueInCallStatus();
						Thread.sleep(2000);
						services.getTextFacilityValueInCallStatus();
						home.clickOnExpandAllCommentsInStausHistoryWindow();
						home.clickOnCloseIconOnStatusHistoryPage();
						home.saveButton();
						services.verifyUpdateCallStatus();
						services.verifyAuditStatusCode();
						services.enterInCommentStatus(data.get("commentStatusUpdate2"));
						//services.enterInResonForStatusStatus(data.get("statusReason2"));
						services.selectFirstValueInResonStatus();
						services.clickUpdateButton();
						home.allErrorAlerts();
						services.clickOnRemainInCall();
						home.allErrorAlerts();
						services.statusValueIsStillSpButNotUp();
						home.allErrorAlerts();
		
						location.clickOnLocationTab();
						Thread.sleep(5000);
						location.clickOnManualEntryLinkInLocation();
						Thread.sleep(3000);
						location.enterTxtinBrkDowLocSrch(data.get("AddressLookup"));
						Thread.sleep(3000);
						location.brkDowLocSrchBtn();
						Thread.sleep(3000);
						location.getNumberOfRecordsInResultsGrid();
						Thread.sleep(3000);
						location.clickOnLocationResultsLink();
						Thread.sleep(3000);
						location.acceptAddressDifferenceAlert();
						Thread.sleep(3000);
						//location.clickOnManualEntryLinkInLocation();
						location.enterBlockRange(data.get("StreetNumber2"));
						String StreetNumber2=getAttributeByValue(CRLocationsPage.txtStreetNumber,"street number 2");
						Thread.sleep(3000);
						location.enterBKDownStreetAddress(data.get("StreetAddress2"));
						String StreetAddress2=getAttributeByValue(CRLocationsPage.txtStreetAddressInput,"street address 2");
						Thread.sleep(3000);
						location.enterBKDownCityLocation(data.get("City2"));
						String city2=getAttributeByValue(CRLocationsPage.txtLocCity,"city 2");
						Thread.sleep(3000);
						location.enterBKDownState(data.get("State2"));
						String State2=getAttributeByValue(CRLocationsPage.txtLocState,"State 2");
						Thread.sleep(3000);
						location.enterBKDownLocCode(data.get("LocationCode2"));
						/*Thread.sleep(3000);
						location.clickOnLocationCodeDropDown();*/
						String locationcode2=getAttributeByValue(CRLocationsPage.txtLocCode,"location code2");
						Thread.sleep(3000);
						vehicle.clickOnVehicleTriageTab();
						Thread.sleep(3000);
						vehicle.clickOnManualEntryLinkOnVehicle();
						Thread.sleep(3000);
						vehicle.selectExistingVehicleModel();
						Thread.sleep(3000);
						vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
						Thread.sleep(3000);
						vehicle.enterPaceSetterCode(data.get("PaceSetterCode2"));
						vehicle.clickOnTheSelectedPaceSetterCodeFromDropDown();
						String paceSetterCode2=getAttributeByValue(CRVehicleTriagePage.txtSelectedPaceSetterCodes,"paceSetterCode 2");
						Thread.sleep(3000);
						//vehicle.handleScriptErrorInVehicleTriagePage();
						service.clickOnServiceTab();
						services.enterManualFacilityNumber(data.get("facilityNumber"));
						home.allErrorAlerts();
						services.clickOnSpotInServicePage();
						Thread.sleep(5000);
						vehicle.scriptErrorHandle();
						services.validateFacilityAutospotID();
						String facilityNumber=getAttributeByValue(CRServicePage.txtSpotFacilityLabel,data.get("facilityNumber"));
						service.clickOnRedFlagOnServiceTab();
		
						String redFlag2=getText(CRServicePage.btnRedFlagOnServiceTab,"Red falg");
						Thread.sleep(3000);
						home.saveButton();
						services.verifyUpdateCallStatus();
						Thread.sleep(3000);
						services.verifyAuditStatusCode();
						Thread.sleep(3000);
						services.enterInCommentStatus(data.get("commentStatusUpdate2"));
						//services.enterInResonForStatusStatus(data.get("statusReason2"));
						services.selectFirstValueInResonStatus();
						services.clickUpdateButton();
						home.allErrorAlerts();
						services.clickOnRemainInCall();
						home.allErrorAlerts();
		
						location.clickOnLocationTab();
						Thread.sleep(5000);
						location.clickOnManualEntryLinkInLocation();
						Thread.sleep(3000);
						location.enterTxtinBrkDowLocSrch(data.get("AddressLookup"));
						Thread.sleep(3000);
						location.brkDowLocSrchBtn();
						Thread.sleep(3000);
						location.getNumberOfRecordsInResultsGrid();
						Thread.sleep(3000);
						location.clickOnLocationResultsLink();
						Thread.sleep(3000);
						location.acceptAddressDifferenceAlert();
						assertTextStringMatching(StreetNumber2,data.get("StreetNumber2"));
						Thread.sleep(2000);
						assertTextStringMatching(StreetAddress2,data.get("StreetAddress2"));
						Thread.sleep(2000);
						//assertTextStringMatching(southCrossStreetValue2,data.get("'SouthCrossStreet2"));
						Thread.sleep(2000);
						assertTextStringMatching(city2,data.get("City2"));
						Thread.sleep(2000);
						assertTextStringMatching(State2,data.get("State2"));
						Thread.sleep(2000);
						//write location code
						location.enterBKDownLocCode(data.get("LocationCode2"));
						/*Thread.sleep(3000);
						location.clickOnLocationCodeDropDown();*/
						Thread.sleep(2000);
						vehicle.clickOnVehicleTriageTab();
						Thread.sleep(3000);
						vehicle.clickOnManualEntryLinkOnVehicle();
						Thread.sleep(3000);
						vehicle.selectExistingVehicleModel();
						Thread.sleep(3000);
						vehicle.validatePacesetterCode(data.get("PaceSetterCode2"));
						//vehicle.clickCloseIconInSelectedPaceSetterCodeSection();
						Thread.sleep(3000);
						vehicle.handleScriptErrorInVehicleTriagePage();
						service.clickOnServiceTab();
						home.allErrorAlerts();
						assertTextStringMatching(facilityNumber,data.get("facilityNumber"));
						home.allErrorAlerts();
						services.clickOnSpotInServicePage();
						Thread.sleep(5000);
						vehicle.scriptErrorHandle();
						services.validateFacilityAutospotID();
						service.isVisibleRedFlag();
						home.saveButton();
						service.clickOnCancel();
						home.allErrorAlerts();
						home.logout();

	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("CR","1713",ReportStatus.strMethodName,intCounter,browser);
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