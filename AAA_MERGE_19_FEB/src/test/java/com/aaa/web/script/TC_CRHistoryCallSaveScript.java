package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.CRLocationsPage;
import com.aaa.web.page.CRVehicleTriagePage;

import freemarker.template.SimpleDate;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import jxl.write.DateFormat;


public class TC_CRHistoryCallSaveScript extends LoginLib {
  
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void HistoryCallSave(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "HistoryCallSave",TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("HistoryCallSave",TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR ERS History Call Save"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRServiceLib service = new CRServiceLib();
		
		
		                LoginRoleLib loginRole = new LoginRoleLib();
		
		
		                home.verifyandClickLogout();
		                navigateToApplication("CR");
		                login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		                home.messageDialogBoxClose();
		                home.workFlowSelectionForHistory();
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
		                //home.memberSearchTextBox(dataBean.getValue(data,"Membersearch"));
		                member.memberNumClick();
		                //member.clickOnMemberIdForHistoryCallSave();
		                //Enter primary phone number
		                member.enterMemberContactInfoPrimaryPhoneNumberRandomly(dataBean.getValue(data, "PhoneNumber"));
		                //enter prime phone type
		                member.membContInfoEnterPrimPhoneTypeCellular();
		               //enter prime phone radio button
		                member.clickPrimRadioBtnRowOne();
		                //member.enterPhoneNumber(dataBean.getValue(data,"PhoneNumber"));
		                locations.breakdownLocTabSel();
		                locations.enterBreakDownAddressOmniBarSearch(data.get("Breakdownaddress"));
		                //enter vehicle information
		                vehicle.vehicletriageTabsel();
		                String VehicleDet[] = data.get("Vehiclemodel").split("#");
		                vehicle.enterVehicleSearch(VehicleDet[0]);
		                vehicle.clickOnTheVehicleSearchIcon();
		                vehicle.clickOnTheVehicleSearch();
		                vehicle.vehicleColor(VehicleDet[1]);
		                vehicle.selectJumpStartFromBattery();
		                vehicle.handleScriptErrorInVehicleTriagePage();
		                home.allErrorAlerts();
		                service.clickOnServiceTab();
		                service.enterCallTypeinServices(dataBean.getValue(data, "callType"));
		                //home.saveButton();
		                service.saveClearHistoryCallWindow();
		                service.verifyCallHistoryCallWindowFields();
		                service.verifyCalendarDropdown();
		                String currentDate=getCurrentDate();
		                String nextDay=getNextDay(currentDate);
		                System.out.println("************date:"+nextDay);
		                service.enterDateInSaveClearHistoryCall(nextDay);
		                service.enterTruckIDInSaveClearHistoryCall(dataBean.getValue(data,"TruckID"));
		                service.enterClearingCodeInSaveClearHistoryCall(dataBean.getValue(data,"clearingcode"));
		                service.enterPaceSetterReasonInSaveClearHistoryCall(dataBean.getValue(data,"Pacesetter"));
		                service.clickOnSaveHistoryCallSaveButton();
		                service.verifyCalendarErrorTextOfHistorycall();
		                //home.allErrorAlerts();
		                service.clickOnErrorOKButtonOnHistoryCallSave();
		                home.allErrorAlerts();
		                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		                Date date = new Date();
		                String date1 = dateFormat.format(date);
		                System.out.println("************date:"+date1);
		                service.enterDateInSaveClearHistoryCall(date1);
		                service.enterTruckIDInSaveClearHistoryCall(dataBean.getValue(data,"TruckID"));
		                service.enterClearingCodeInSaveClearHistoryCall(dataBean.getValue(data,"clearingcode"));
		                service.enterPaceSetterReasonInSaveClearHistoryCall(dataBean.getValue(data,"Pacesetter"));
		                service.clickGaragePaymentInfoButton();
		                service.verifyGaragePaymentInForWindow();
		                service.closeGaragePaymentInForWindow();
		                service.clickOnSaveHistoryCallSaveButton();
		                Thread.sleep(8000);
		                service.verifyCallId();
		                service.clickOnRemainInCall();
		                service.verifyWorkFlow();
		                service.verifyCallStatusText();
		                home.saveButton();
		                service.verifyDisabledFieldsOnSaveClearHistoryCall();
		                service.closeButton();
		                home.verifyandClickLogout();
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

    public String getNextDay(String curDate)throws Exception{
        final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        final Date date = format.parse(curDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return format.format(calendar.getTime());
    }

    public String getCurrentDate(){
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String currentdate=sdf.format(date);
        return currentdate;
    }
}

