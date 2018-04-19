package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by E003999 on 20-12-2017.
 */
public class TC_CRSaveAppointmentCall extends LoginLib {
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void crSaveAppointmentCall(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crSaveAppointmentCall", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crSaveAppointmentCall", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Save Appointment Call"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                CRMemberSearchLib memeber = new CRMemberSearchLib();
		                CRLocationsLib locations = new CRLocationsLib();
		                CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
		                CRServiceLib service = new CRServiceLib();
		                navigateToApplication("CR");
		                login(data.get("LoginName"), data.get("Password"));
		                home.verifyHomeScreen();
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
		                locations.clickOnLocationTab();
		                locations.enterBreakDownAddressOmniBarSearch(data.get("Breakdownaddress"));
		                //locations.clickOnSecondKownBrkDowLocation();
		                vehicle.selectVehicleModel();
		                service.clickOnServiceTab();
		                service.clickOnAppointmentbutton();
		                String currentDate=getCurrentDate();
		                service.enterAppointmentDate(currentDate);
		                String futureTime=getFutureTime();
		                service.enterAppointmentTime(futureTime);
		                home.saveButton();
		                String SameDayCallIdHc=service.getCallId();
		                service.clickOnRemainInCall();
		                service.verifyAppointmentIsReleased();
		                service.clickOnCallStatusButton();
		                service.clickOnDateColumnInstatustable();
		                service.verifyToGetCallStatus(data.get("CallStatusForHC"));
		                String timeStamp=currentDate+futureTime;
		                service.verifyTimeStamp(timeStamp);
		                home.leaveButton();
		                service.appointmentCallLeaveButton();
		
		
		                home.memberSearchTextBox(Member);
		                memeber.memberNumClick();
		                locations.clickOnLocationTab();
		                locations.clickOnSecondKownBrkDowLocation();
		                vehicle.selectVehicleModel();
		                service.clickOnServiceTab();
		                service.clickOnAppointmentbutton();
		                String currentDateHc=getCurrentDate();
		                service.enterAppointmentDate(currentDateHc);
		                String futureTime1=getFutureTime();
		                service.enterAppointmentTime(futureTime1);
		                home.saveButton();
		                String SameDayCallIdHs=service.getCallId();
		                service.clickOnRemainInCall();
		                service.clickOnCallStatusButton();
		                service.verifyToGetCallStatus(data.get("CallStatusForHS"));
		                service.clickOnDateColumnInstatustable();
		                home.leaveButton();
		                service.appointmentCallLeaveButton();
		
		
		                home.messageDialogBoxClose();
		                home.memberSearchTextBox(Member);
		                memeber.memberNumClick();
		                locations.clickOnLocationTab();
		                locations.clickOnSecondKownBrkDowLocation();
		                vehicle.selectVehicleModel();
		                service.clickOnServiceTab();
		                service.clickOnAppointmentbutton();
		                String today=getCurrentDate();
		                String nextDay=getNextDay(today);
		                service.enterAppointmentDate(nextDay);
		                String futureTimeHc=getFutureTime();
		                service.enterAppointmentTime(futureTimeHc);
		                home.saveButton();
		                String nextDayCallIdHc=service.getCallId();
		                service.clickOnRemainInCall();
		                service.clickOnCallStatusButton();
		                service.clickOnDateColumnInstatustable();
		                service.verifyToGetCallStatus(data.get("CallStatusForHC"));
		                home.leaveButton();
		                service.appointmentCallLeaveButton();
		
		                home.messageDialogBoxClose();
		                home.memberSearchTextBox(Member);
		                memeber.memberNumClick();
		                locations.clickOnLocationTab();
		                locations.clickOnSecondKownBrkDowLocation();
		                vehicle.selectVehicleModel();
		                service.clickOnServiceTab();
		                service.clickOnAppointmentbutton();
		                String todayHs=getCurrentDate();
		                String nextDayHs=getNextDay(todayHs);
		                service.enterAppointmentDate(nextDayHs);
		                String futureTimeHs=getFutureTime();
		                service.enterAppointmentTime(futureTimeHs);
		                home.saveButton();
		                String nextDayCallIdHs=service.getCallId();
		                service.clickOnRemainInCall();
		                service.clickOnCallStatusButton();
		                service.clickOnDateColumnInstatustable();
		                service.verifyToGetCallStatus(data.get("CallStatusForHS"));
		                home.leaveButton();
		                service.appointmentCallLeaveButton();
		
		
		                home.messageDialogBoxClose();
		                home.memberSearchTextBox(Member);
		                memeber.memberNumClick();
		                locations.clickOnLocationTab();
		                locations.clickOnSecondKownBrkDowLocation();
		                vehicle.selectVehicleModel();
		                service.clickOnServiceTab();
		                service.clickOnAppointmentbutton();
		                String currentDateManual=getCurrentDate();
		                service.enterAppointmentDate(currentDateManual);
		                String futureTimeManual=getFutureTime();
		                service.enterAppointmentTime(futureTimeManual);
		                home.saveButton();
		                service.clickOnRemainInCall();
		                service.verifyAppointmentIsReleased();
		                service.clickOnServiceTab();
		                home.saveButton();
		                service.clickOnSPStatusUpdate();
		                service.enterReasonForStatus(data.get("CallStatusUpdate"));
		                service.clickOnUpadteButton();
		                service.clickOnRemainInCall();
		                service.clickOnCallStatusButton();
		                service.clickOnDateColumnInstatustable();
		                service.verifyToGetCallStatus(data.get("CallStatusForSP"));
		                home.logout();
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
    public String getCurrentDate(){
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String currentdate=sdf.format(date);
        return currentdate;
    }
    public String getFutureTime(){
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = new Date(System.currentTimeMillis()+3*60*1000);
        String futureTime=sdf.format(date);
        return futureTime;

    }
    public String getNextDay(String curDate)throws Exception{
        final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        final Date date = format.parse(curDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return format.format(calendar.getTime());
    }
}