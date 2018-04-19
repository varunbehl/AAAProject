package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC_CRCDXMemberLookUp extends LoginLib {
  

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void cdxMemberLookUp(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "cdxMemberLookUp", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("cdxMemberLookUp", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("cdxMemberLookUp"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib memeber = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		
		 				navigateToApplication("CR");          
					    login(data.get("LoginName"), data.get("Password"));
		                home.messageDialogBoxClose();
						home.verifyHomeScreen();    
			            home.memberSearchTextBox(data.get("CdxMember"));
		                memeber.verifyClubCodeForCdxmember(data.get("CityClubcode"));
		                memeber.memberNumber();
		                memeber.memberNumClick();
		                fieldValidations();
		                home.leaveButton();
		                home.allErrorAlerts();
		                memeber.enterDataInClubCode(data.get("CityClubcode"));
		                home.memberSearchTextBox(data.get("9DigitMemberID"));
		                memeber.memberNumber();
		                memeber.memberNumClick();
		                fieldValidations();
		                home.leaveButton();
		                home.allErrorAlerts();
		                memeber.verifyClubCode();
		                memeber.enterDataInClubCode(data.get("ClubCode"));
		                home.memberSearchTextBox(data.get("10DigitValidPhoneNumber"));
		                memeber.verifyListOfMembernames();
		                home.leaveButton();
		                home.allErrorAlerts();
		                memeber.enterDataInClubCode(data.get("ClubCode"));
		                home.memberSearchTextBox(data.get("LessThan7DigitNumber"));
		                memeber.emptySearchResults();
		                home.memberSearchTextBox(data.get("10DigitInValidPhoneNumber"));
		                memeber.emptySearchResults();
		                home.leaveButton();
		                home.allErrorAlerts();
		                memeber.enterDataInClubCode(data.get("CityClubcode"));
		                home.memberSearchTextBox(data.get("ValidLastName"));
		                memeber.verifyWildCardForLastName();
		                memeber.memberNumClick();
		                fieldValidations();
		                home.leaveButton();
		                home.allErrorAlerts();
		                memeber.enterDataInClubCode(data.get("CityClubcode"));
		                home.memberSearchTextBox(data.get("LastNameDontExist"));
		                memeber.emptySearchResults();
		                home.leaveButton();
		                home.allErrorAlerts();
		                home.memberSearchTextBox(data.get("LastNameFirstName"));
		                memeber.verifyWildCardForLastName();
		                memeber.memberNumClick();
		                fieldValidations();
		                home.leaveButton();
		                home.allErrorAlerts();
		                memeber.enterDataInClubCode(data.get("CityClubcode"));
		                home.memberSearchTextBox(data.get("CdxMember"));
		                memeber.memberNumClick();
		                fieldValidations();
						home.logout();                System.out.println("Test completed");
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

    public void fieldValidations() throws Throwable {
        CRMemberSearchLib memeber = new CRMemberSearchLib();
        memeber.labelMemberShipNumberInMemberDetailsSection();
        memeber.labelMemberSinceInMemberDetailsSection();
        memeber.labelMemberLevelInMemberDetailsSection();
        memeber.labelMemberTypeInMemberDetailsSection();
        memeber.labelMemberExpirationInMemberDetailsSection();
        memeber.labelMemberStatusInMemberDetailsSection();
        memeber.memberCallsAllowedInMemberDetailsSection();
        memeber.memberCallsRemainingInMemberDetailsSection();
        memeber.memberCallsUsedInMemberDetailsSection();
        memeber.memberCurrentCallsInMemberDetailsSection();
        memeber.memberChargeableCallsInMemberDetailsSection();
        memeber.labelMemberFirstNameInMemberDetailsSection();
        memeber.labelMemberLastNameInMemberDetailsSection();
        memeber.labelMemberZipCodeInMemberDetailsSection();
        memeber.labelMemberStateInMemberDetailsSection();
        memeber.labelMemberCityInMemberDetailsSection();
    }
}


