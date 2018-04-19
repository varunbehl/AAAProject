package com.aaa.web.script;


import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_CRWorkFlowScript extends CRHomeLib {
    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void workFlows(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow,"fieldValidation", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("fieldValidation", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("1679:TC-CR-WorkFlows"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                LoginLib login = new LoginLib();
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRLocationsLib location = new CRLocationsLib();
		                CRTowDestinationLib tow = new CRTowDestinationLib();
		                CRServiceLib service = new CRServiceLib();
		                home.verifyandClickLogout();
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		                home.messageDialogBoxClose();
		               /* String Member = "";
		                /*if (data.get("Member").equals("db")){
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
		                member.memberNumClick();
		                member.currentCallClose();
		                member.memberNumClick();*/
		                //home.clickOnManualEntryLink("member");
		                member.clickOnManualEntryLinkInMember();
		                member.memFieldsVerification();
		                member.cleanAndSaveMemberDetails(dataBean.getValue(data,"FirstName"), (dataBean.getValue(data,"LastName")) , (dataBean.getValue(data,"Address")),  (dataBean.getValue(data,"City")),(dataBean.getValue(data,"State")), (dataBean.getValue(data,"Zip")), (dataBean.getValue(data,"Email")) ,(dataBean.getValue(data,"PhoneNumber")),(dataBean.getValue(data,"Type")) , (dataBean.getValue(data,"MemberNumber")), (dataBean.getValue(data,"MemberLevel")) ,  (dataBean.getValue(data,"Expiration")) , (dataBean.getValue(data,"Status")));
		                //member.cleanAndSaveMemberDetails(data);
		
		
		                vehicle.clickOnVehicleTriageTab();
		                vehicle.clickOnManualEntryLinkOnVehicle();
		                //home.clickOnManualEntryLink("vehicle");
		                vehicle.vehicleFieldVerification();
		                vehicle.cleanAndSaveVehicleDetails(dataBean.getValue(data,"VehicleType") ,dataBean.getValue(data,"VehicleYear") ,dataBean.getValue(data,"VehicleMake"),dataBean.getValue(data,"VehicleModel"),dataBean.getValue(data,"VehicleColor"),dataBean.getValue(data,"pacesetterCode"));
		
		                location.clickOnLocationTab();
		                location.clickOnManualEntryLinkInLocation();
		                //home.clickOnManualEntryLink("location");
		                location.locationFieldsVerification();
		                location.clearAndSaveLocationDetails(dataBean.getValue(data,"BKDownStreetAddress"), dataBean.getValue(data,"BKDownCityLocation"), dataBean.getValue(data,"BKDownState") , dataBean.getValue(data,"BKDownLocCode"));
		
		                tow.clickOnTowDestinationTab();
		                login.waitcloseAllBusyIconsResults();
		                tow.clickOnManualEntryLinkOnTowDestination();
		                //home.clickOnManualEntryLink("tow");
		                tow.clearAndSaveTowDestinationDetails(dataBean.getValue(data,"TowPassengers"));
		                tow.towDestinationFieldVerification();
		
		                service.clickOnServiceTab();
		                //service.clickOnManualEntryLinkInServicePage();
		                //home.clickOnManualEntryLink("Service");
		                service.serviceFieldVerification();
		                service.saveServiceMandatoryFields(dataBean.getValue(data,"Facility"));
		                service.getCallId();
		                service.closeCallWindow();
		
		                home.logout();
		
		
		                System.out.println("Test completed");

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1679",ReportStatus.strMethodName,intCounter,browser);
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


