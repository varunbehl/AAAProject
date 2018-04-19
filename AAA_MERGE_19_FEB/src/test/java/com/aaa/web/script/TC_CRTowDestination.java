package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRMemberSearchPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRTowDestination extends ActionEngine {

    public String address;
    public String getValue;
    public int towDestinationResultsCount;
    public int towDestinationResultsCountForSearchMiles;
    public int towDestinationResultsCountForModSearchMiles;
    public int towDestinationMakeSearchResultCount;
    public int towDestinationMakeSearchResultCountForHours;
    public String resultCount;
    public String resultCountForSearchMiles;
    public String resultCountForSearchModMiles;
    public String searchtowDestinationMakeSearchResultCount;
    public String searchtowDestinationMakeSearchResultCountForHours;
    public String Date;
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void automaticSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"towDestination", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("towDestination", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1949:TS-Tow Destination"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRHomeLib home = new CRHomeLib();
		                CRServiceLib service = new CRServiceLib();
		                CRRecentCallsLib recent = new CRRecentCallsLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		
		                navigateToApplication("CR");
		                login.login(data.get("CRLoginName"), data.get("Password"));
		                login.waitcloseAllBusyIconsResults();
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
		                /*member.enterMemberContactInfoPrimaryPhoneNumber(data.get("PhoneNumber"));
		                member.selectType(data.get("PhoneType"));*/
		                locations.breakdownLocTabSel();
		                locations.clickOnManualEntryLinkInLocation();
		                locations.enterNonMandatoryFieldsInLocations(data.get("LandMark"),data.get("Address"),data.get("crossStreet"),data.get("secondCrossStreet"),data.get("Zip"));
		                locations.enterAndSaveLocationMandatoryFields(data.get("StreetAddress"),data.get("City"),data.get("State"),data.get("LocationCode"));
		                locations.enterBKDownLocCode(data.get("LocationCode"));
		                /*Thread.sleep(2000);
		                locations.clickOnLocationCodeDropDown();*/
		                Thread.sleep(5000);
		                locations.acceptAddressDifferenceAlert();
		                crVehicleTriageLib.clickOnVehicleTriageTab();
		                crVehicleTriageLib.clickOnManualEntryLinkOnVehicle();
		                Thread.sleep(1000);
		                crVehicleTriageLib.enterVehicleType(data.get("ReEnterType"));
		                crVehicleTriageLib.clickOnTheTypeSearchFromDropDown();
		                Thread.sleep(3000);
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                //crVehicleTriageLib.getMoreInfoTab();
		                Thread.sleep(2000);
		                crVehicleTriageLib.enterVehicleYear(data.get("ReEnterYear"));
		                Thread.sleep(2000);
		                crVehicleTriageLib.enterVehicleMake(data.get("ReEnterMake"));
		                crVehicleTriageLib.enterVehicleModel(data.get("ReEnterModel"));
		                crVehicleTriageLib.enterVehicleColor(data.get("Color"));
		                Thread.sleep(3000);
		                crVehicleTriageLib.clickOnTow();
		                crVehicleTriageLib.clickOnBrakeFailurOnTow();
		                crVehicleTriageLib.scriptErrorHandle();
		                Thread.sleep(4000);
		
		                tow.clickOnTowDestinationTab();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                towDestinationResultsCount=tow.verifyTowDestinationResultsList();
		                resultCount=String.valueOf(towDestinationResultsCount);
		                address=tow.getAutoSearchCriteriaInTowDestinationTab();
		                String inputvalues[] = address.split(", ");
		                String addressInput = inputvalues[0];
		                String vehicleType = inputvalues[1];
		                assertTrue(vehicleType.equalsIgnoreCase(data.get("ReEnterMake")),"Given Vehicle:: '"+data.get("ReEnterMake")+"' ::Search criteria is matched with call criteria::  '"+vehicleType+"'");
		                assertTrue(addressInput.contains(data.get("StreetAddress").toUpperCase()),"Given address:: '"+data.get("StreetAddress")+"' ::search criteria is matched with Call criteria::  '"+addressInput+"'");
		                Thread.sleep(1000);
		                tow.clickOnAARTowDetinationLink();
		                tow.popupNotificationForRSPreferalGetTitle();
		                tow.enterTowPassengers(data.get("Towpassengers"));
		                tow.getLatLongValue();
		                reporter.SuccessReport("Radius Search","Radius Search Starting");
		                //radius Search
		                tow.clickOnManualEntryLinkOnTowDestination();
		                tow.clickOnShowCriteriaCollapseButton();
		                Thread.sleep(2000);
		                tow.enterMilesToSearchRepairShopWithInRange(data.get("searchMiles"));
		                Thread.sleep(4000);
		                tow.clickOnShowCriteriaCollapseButton();
		                Thread.sleep(2000);
		                tow.clickOnShowCriteriaCollapseButton();
		                tow.clickOnSearchButtonOnTow();
		                tow.getAutoSearchCriteriaInTowDestinationTab();
		                Thread.sleep(5000);
		                towDestinationResultsCountForSearchMiles=tow.verifyTowDestinationResultsList();
		                Thread.sleep(2000);
		                tow.getDisatanceInTow(data.get("searchMiles"));
		                resultCountForSearchMiles=String.valueOf(towDestinationResultsCountForSearchMiles);
		                //tow.compareTwoValues(towDestinationResultsCount,towDestinationResultsCountForSearchMiles);
		                //assertFalse(resultCount!=resultCountForSearchMiles,"Search Results are changed for"+data.get("searchMiles")+"Miles From::  '"+verifyTowDestinationResultsList+"' ::To::  '"+towDestinationResultsCountForSearchMiles);
		                assertTrue(resultCount!=resultCountForSearchMiles,"Results are found");
		                Thread.sleep(2000);
		                //tow.clickOnManualEntryLinkOnTowDestination();
		                tow.clickOnShowCriteriaCollapseButton();
		                tow.enterMilesToSearchRepairShopWithInRange(data.get("ModifiedSearchMiles"));
		                Thread.sleep(2000);
		                tow.clickOnSearchButtonOnTow();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                tow.getAutoSearchCriteriaInTowDestinationTab();
		                towDestinationResultsCountForModSearchMiles=tow.verifyTowDestinationResultsList();
		                tow.getDisatanceInTow(data.get("ModifiedSearchMiles"));
		                resultCountForSearchModMiles=String.valueOf(towDestinationResultsCountForModSearchMiles);
		                assertTrue(resultCountForSearchModMiles!=resultCountForSearchMiles,"Search Results are changed for"+data.get("searchMiles")+"Miles From::  '"+towDestinationResultsCountForSearchMiles+"' ::To::  '"+towDestinationResultsCountForModSearchMiles);
		                Thread.sleep(2000);
		                reporter.SuccessReport("Vehicle","Vehicle");
		                tow.clickOnShowCriteriaCollapseButton();
		                Thread.sleep(2000);
		                getValue=tow.getVehicleValueInTowSearch();
		                tow.compareTwoValues(getValue,data.get("ReEnterMake"));
		                tow.getDisatanceInTow(data.get("ModifiedSearchMiles"));
		                Thread.sleep(2000);
		                //Tow Destination changes has to be validated
		               // tow.clickOnShowCriteriaCollapseButton();
		               // Thread.sleep(2000);
		                tow.enterValueInVehicle(data.get("MakeValue"));
		                Thread.sleep(1000);
		                tow.clickOnSearchButtonOnTow();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                tow.getAutoSearchCriteriaInTowDestinationTab();
		                towDestinationMakeSearchResultCount=tow.verifyTowDestinationResultsList();
		                searchtowDestinationMakeSearchResultCount=String.valueOf(towDestinationResultsCountForModSearchMiles);
		                tow.getDisatanceInTow(data.get("ModifiedSearchMiles"));
		                //assertFalse(searchtowDestinationMakeSearchResultCount!=resultCountForSearchModMiles,"Search Results are changed for"+data.get("searchMiles")+"Miles From::  '"+towDestinationResultsCountForModSearchMiles+"' ::To::  '"+verifyTowDestinationResultsList);
		                assertTrue(searchtowDestinationMakeSearchResultCount!=resultCountForSearchModMiles,"Results are found");
		
		                reporter.SuccessReport("Hours","Hours");
		                tow.clickOnShowCriteriaCollapseButton();
		                Thread.sleep(2000);
		                tow.clickOnOpenOnCheckBox();
		                Date=tow.getDateValue();
		                tow.enterValueInDate(Date);
		                Thread.sleep(2000);
		                tow.enterValueInTime(data.get("time"));
		                Thread.sleep(1000);
		                tow.clickOnSearchButtonOnTow();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(2000);
		                tow.getAutoSearchCriteriaInTowDestinationTab();
		                towDestinationMakeSearchResultCountForHours= tow.verifyTowDestinationResultsList();
		                searchtowDestinationMakeSearchResultCountForHours=String.valueOf(towDestinationMakeSearchResultCountForHours);
		                assertTrue(searchtowDestinationMakeSearchResultCount!=searchtowDestinationMakeSearchResultCountForHours,"Results are found");
		                Thread.sleep(5000);
		
		                reporter.SuccessReport("Shop Type","Shop Type");
		                tow.clickOnRepairShopCheckboxOnTow();
		                Thread.sleep(5000);
		                tow.clickOnShowCriteriaCollapseButton();
		                Thread.sleep(2000);
		
		                tow.clickOnTRCCheckBox();
		                tow.clickOnSearchButtonOnTow();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(2000);
		                tow.clickOnRepairShopCheckboxOnTow();
		                Thread.sleep(5000);
		                tow.getAutoSearchCriteriaInTowDestinationTab();
		                //tow.getDisatanceInTow(data.get("searchMiles"));
		                tow.verifyTRCStatus();
		                //resultCountForSearchMiles=String.valueOf(towDestinationResultsCountForSearchMiles);
		
		                Thread.sleep(5000);
		                tow.clickOnShowCriteriaCollapseButton();
		                Thread.sleep(2000);
		
		                tow.clickOnTRCCheckBox();
		                tow.clickOnAARnCheckBox();
		                tow.clickOnSearchButtonOnTow();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(2000);
		                tow.clickOnRepairShopCheckboxOnTow();
		                Thread.sleep(5000);
		                tow.getAutoSearchCriteriaInTowDestinationTab();
		                //tow.getDisatanceInTow(data.get("searchMiles"));
		                tow.verifyAARStatus();
		
		                Thread.sleep(5000);
		                tow.clickOnShowCriteriaCollapseButton();
		                Thread.sleep(2000);
		
		                tow.clickOnAARnCheckBox();
		                tow.clickOnAutoGlass();
		                tow.clickOnSearchButtonOnTow();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(2000);
		                tow.clickOnRepairShopCheckboxOnTow();
		                Thread.sleep(5000);
		                tow.getAutoSearchCriteriaInTowDestinationTab();
		                //tow.getDisatanceInTow(data.get("searchMiles"));
		                tow.verifyAutoGlassStatus();
		
		                Thread.sleep(5000);
		                tow.clickOnShowCriteriaCollapseButton();
		                Thread.sleep(2000);
		
		                tow.clickOnAutoGlass();
		                tow.clickOnCollisinCheckBox();
		                tow.clickOnSearchButtonOnTow();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(2000);
		                tow.clickOnRepairShopCheckboxOnTow();
		                Thread.sleep(5000);
		                tow.getAutoSearchCriteriaInTowDestinationTab();
		                //tow.getDisatanceInTow(data.get("searchMiles"));
		                tow.verifyCollisionStatus();
		
		                Thread.sleep(5000);
		                tow.clickOnShowCriteriaCollapseButton();
		                Thread.sleep(2000);
		
		
		                tow.clickOnCollisinCheckBox();
		                tow.clickOnRVCheckboxOnTow();
		                tow.clickOnSearchButtonOnTow();
		                crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
		                Thread.sleep(2000);
		                tow.clickOnRepairShopCheckboxOnTow();
		                Thread.sleep(5000);
		                tow.getAutoSearchCriteriaInTowDestinationTab();
		                //tow.getDisatanceInTow(data.get("searchMiles"));
		                tow.verifyRVStatus();
		
		                home.leaveButton();
		                home.clickOnConfirmationAlert();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1949",ReportStatus.strMethodName,intCounter,browser);
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
