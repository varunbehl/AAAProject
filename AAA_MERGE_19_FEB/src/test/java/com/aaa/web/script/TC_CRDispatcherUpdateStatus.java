package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E002734 on 2/13/2018.
 */
public class
TC_CRDispatcherUpdateStatus extends CRDispatcherUpdateLib {

	LoginLib login = new LoginLib();
	CRMemberSearchLib member = new CRMemberSearchLib();
	CRVehicleTriageLib vehicle = new CRVehicleTriageLib();
	CRLocationsLib location = new CRLocationsLib();
	CRTowDestinationLib towdestination = new CRTowDestinationLib();
	CRHomeLib home = new CRHomeLib();
	CRServiceLib service = new CRServiceLib();
	CRServiceLib services = new CRServiceLib();
	CRDispatcherUpdateLib dispatcherUpdate=new CRDispatcherUpdateLib();
	CommonLib common=new CommonLib();

	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void crDispatcherUpdateCalls(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "crDispatcherUpdateCalls", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("crDispatcherUpdateCalls", TestData, "D3CallRecieving",intCounter);
    	
						this.reporter.initTestCaseDescription("1963: TC-CR Dispatcher Update Status"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						login.login(data.get("CRLoginName"), data.get("CRPassword"));
						member.clickOnPartialCallCloseButton();
						home.messageDialogBoxClose();
						member.currentCallClose();
		
						home.clickOnCurrentCall();
						home.verifyDispatchStatusUpdateNotPresent();
		
						String Member = "";
						/*if (data.get("Member").equals("db")){
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
						}*/
						home.memberSearchTextBox(Member);
						home.memberSearchTextBox(data.get("Membersearch"));
						member.memberNumClick();
						member.currentCallClose();
						member.clickPrimRadioBtnSecondRow();
						location.clickOnLocationTab();
						location.enterBreakDownAddressOmniBarSearch(data.get("Address"));
						vehicle.clickOnVehicleTriageTab();
						vehicle.enterVehicleDetailsinSearchBar(data.get("Vehiclemodel"));
						vehicle.enterPaceSetterCodeManually(data.get("pacesettercode"));
						Thread.sleep(3000);
						vehicle.handleScriptErrorInVehicleTriagePage();
						home.allErrorAlerts();
						service.clickOnServiceTab();
						Thread.sleep(3000);
						vehicle.handleScriptErrorInVehicleTriagePage();
						home.allErrorAlerts();
						service.validateFacilityAutospot();
						Thread.sleep(3000);
						home.saveButton();
						vehicle.handleScriptErrorInVehicleTriagePage();
						home.allErrorAlerts();
						services.clickOnRemainInCall();
						vehicle.handleScriptErrorInVehicleTriagePage();
						home.allErrorAlerts();
						Thread.sleep(3000);
		
						home.clickOnCurrentCall();
						home.verifyDispatchStatusUpdatePresentAndClick();
						dispatcherUpdate.getTextOfDispatcherUpdateStatusTitle();
						dispatcherUpdate.getTextOfStatus();
						dispatcherUpdate.getTextOfBoldStatus();
						dispatcherUpdate.getTextOfResonForStatus();
						dispatcherUpdate.getTextOfBoldDispatchingInformation();
						dispatcherUpdate.getTextOfFacility();
						dispatcherUpdate.getTextOfTruck();
						dispatcherUpdate.getTextOfTechnician();
						dispatcherUpdate.getTextOfTimeStampOverride();
						dispatcherUpdate.getTextOfDate();
						dispatcherUpdate.getTextOfTime();
						dispatcherUpdate.getTextOfComments();
						dispatcherUpdate.clickOnStatusDrpdwnAndGetAllData();
		
		
						//Status updates AK ,AS ,DI ,ER ,OL
		
						dispatcherUpdate.clearTruck();
						dispatcherUpdate.enterInStatus(data.get("AK"));
						dispatcherUpdate.clickOnUpdate();
						dispatcherUpdate.clickOnOK();
						dispatcherUpdate.clickOnCancel();
						services.clickOnCallStatusButton();
						home.allErrorAlerts();
						home.allErrorAlerts();
						services.clickOnDateToArrange();
						//services.verifyToGetCallStatus(data.get("UpdatedAsAK"));
						services.getTextUpdateCode();
						services.clickOnCallStatusButton();
		
		
						home.clickOnCurrentCall();
						home.verifyDispatchStatusUpdatePresentAndClick();
						dispatcherUpdate.clearTruck();
						dispatcherUpdate.enterInStatus(data.get("AS"));
						dispatcherUpdate.enterInReasonForStatus(data.get("01"));
						dispatcherUpdate.enterTruckId(data.get("A"));
						dispatcherUpdate.clickOnUpdate();
						dispatcherUpdate.clickOnOK();
						dispatcherUpdate.clickOnCancel();
						services.getTextCallStatusButton();
						services.clickOnCallStatusButton();
						home.allErrorAlerts();
						home.allErrorAlerts();
						services.clickOnDateToArrange();
						//services.verifyToGetCallStatus(data.get("CallStatusForRE"));
						services.getTextUpdateCode();
						services.getTextReasonCode();
						services.getTextFacilityTruck();
						services.clickOnCallStatusButton();
		
		
		
						home.clickOnCurrentCall();
						home.verifyDispatchStatusUpdatePresentAndClick();
						dispatcherUpdate.clearTruck();
						dispatcherUpdate.enterInStatus(data.get("DI"));
						dispatcherUpdate.enterInReasonForStatus(data.get("01"));
						dispatcherUpdate.enterTruckId(data.get("H"));
						dispatcherUpdate.clickOnUpdate();
						/*dispatcherUpdate.clickOnOK();*/
						dispatcherUpdate.clickOnCancel();
						Thread.sleep(2000);
						services.getTextCallStatusButton();
						services.clickOnCallStatusButton();
						home.allErrorAlerts();
						home.allErrorAlerts();
						services.clickOnDateToArrange();
						//services.verifyToGetCallStatus(data.get("CallStatusForRE"));
						services.getTextUpdateCode();
						//services.getTextReasonCode();
						services.getTextFacilityTruck();
						services.clickOnCallStatusButton();
		
		
		
						home.clickOnCurrentCall();
						home.verifyDispatchStatusUpdatePresentAndClick();
						dispatcherUpdate.clearTruck();
						dispatcherUpdate.enterInStatus(data.get("ER"));
						//dispatcherUpdate.enterInReasonForStatus(data.get("01"));
						dispatcherUpdate.enterTruckId(data.get("Z"));
						dispatcherUpdate.clickOnUpdate();
						dispatcherUpdate.clickOnOK();
						dispatcherUpdate.clickOnCancel();
						services.getTextCallStatusButton();
						services.clickOnCallStatusButton();
						home.allErrorAlerts();
						home.allErrorAlerts();
						services.clickOnDateToArrange();
						services.getTextUpdateCode();
						//services.getTextFacilityTruck();
						services.clickOnCallStatusButton();
		
		
						home.clickOnCurrentCall();
						home.verifyDispatchStatusUpdatePresentAndClick();
						dispatcherUpdate.clearTruck();
						dispatcherUpdate.enterInStatus(data.get("OL"));
						//dispatcherUpdate.enterInReasonForStatus(data.get("01"));
						dispatcherUpdate.enterTruckId(data.get("A"));
						dispatcherUpdate.clickOnUpdate();
						dispatcherUpdate.clickOnOK();
						dispatcherUpdate.clickOnCancel();
						services.getTextCallStatusButton();
						services.clickOnCallStatusButton();
						home.allErrorAlerts();
						home.allErrorAlerts();
						services.clickOnDateToArrange();
						//services.verifyToGetCallStatus(data.get("CallStatusForRE"));
						services.getTextUpdateCode();
						//services.getTextReasonCode();
						services.getTextFacilityTruck();
						services.clickOnCallStatusButton();
		
		
						//Status update missing reason code, Red flag
		
						home.clickOnCurrentCall();
						home.verifyDispatchStatusUpdatePresentAndClick();
						dispatcherUpdate.clearTruck();
						dispatcherUpdate.enterInStatus(data.get("RF"));
						dispatcherUpdate.clickOnUpdate();
						dispatcherUpdate.clickOnOK();
						dispatcherUpdate.getTextOfErrorUpdateCode();
						dispatcherUpdate.clickOnCancel();
		
						home.clickOnCurrentCall();
						home.verifyDispatchStatusUpdatePresentAndClick();
						dispatcherUpdate.clearTruck();
						dispatcherUpdate.enterInStatus(data.get("RF"));
						dispatcherUpdate.clearTruck();
						dispatcherUpdate.enterInReasonForStatus(data.get("ON"));
						dispatcherUpdate.clickOnUpdate();
						dispatcherUpdate.clickOnOK();
						dispatcherUpdate.clickOnCancel();
						service.clickOnServiceTab();
						vehicle.handleScriptErrorInVehicleTriagePage();
						home.allErrorAlerts();
						//find redflag
		
		
						home.clickOnCurrentCall();
						home.verifyDispatchStatusUpdatePresentAndClick();
						dispatcherUpdate.clearTruck();
						dispatcherUpdate.enterInStatus(data.get("TC"));
						dispatcherUpdate.clickOnUpdate();
						dispatcherUpdate.getTextOfErrorUpdateCode();
						dispatcherUpdate.clickOnOK();
						dispatcherUpdate.clickOnCancel();
		
		
		
						home.clickOnCurrentCall();
						home.verifyDispatchStatusUpdatePresentAndClick();
						dispatcherUpdate.clearTruck();
						dispatcherUpdate.enterInStatus(data.get("TC"));
						dispatcherUpdate.enterInReasonForStatus(data.get("1A"));
						dispatcherUpdate.clickOnUpdate();
						dispatcherUpdate.clickOnOK();
						dispatcherUpdate.clickOnCancel();
						vehicle.handleScriptErrorInVehicleTriagePage();
						home.allErrorAlerts();
						services.clickOnCallStatusButton();
						home.allErrorAlerts();
						home.allErrorAlerts();
						services.clickOnDateToArrange();
						services.getTextUpdateCode();
						services.getTextReasonCode();
						services.clickOnCallStatusButton();
		
		
		
						//SP status
		
						home.clickOnCurrentCall();
						home.verifyDispatchStatusUpdatePresentAndClick();
						//dispatcherUpdate.enterInStatus(data.get("TC"));
						dispatcherUpdate.clearTruck();
						dispatcherUpdate.enterFacilityNotEditable();
						dispatcherUpdate.enterInStatus(data.get("SP"));
						dispatcherUpdate.enterFacility(data.get("EnterFacility"));
						dispatcherUpdate.enterInReasonForStatus(data.get("AR"));
						dispatcherUpdate.clickOnUpdate();
						dispatcherUpdate.clickOnOK();
						dispatcherUpdate.clickOnCancel();
						vehicle.handleScriptErrorInVehicleTriagePage();
						home.allErrorAlerts();
						services.clickOnCallStatusButton();
						home.allErrorAlerts();
						home.allErrorAlerts();
						services.clickOnDateToArrange();
						services.getTextUpdateCode();
						services.getTextReasonCode();
						services.getTextFacilityTruck();
						services.clickOnCallStatusButton();
		
		
						//TimeStamp Override
		
						home.clickOnCurrentCall();
						home.verifyDispatchStatusUpdatePresentAndClick();
						dispatcherUpdate.enterInStatus(data.get("UP"));
		                dispatcherUpdate.enterDate(data.get("Date"));
						Thread.sleep(3000);
						dispatcherUpdate.enterTime(data.get("Time"));
						dispatcherUpdate.enterInComments(data.get("Comment"));
						//need to entere reason but not there in rqm
						//gettext comment window
						dispatcherUpdate.enterInReasonForStatus(data.get("01"));
						dispatcherUpdate.clickOnUpdate();
						vehicle.clickOnCommentButton();
						vehicle.getDateAndTime();
						vehicle.getCommentedValue();
						services.clickOnCallStatusButton();
		
						dispatcherUpdate.clickOnOK();
						dispatcherUpdate.clickOnCancel();
		                home.logout();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			finally{
    				dispatcherUpdate.clickOnOK();
    				dispatcherUpdate.clickOnCancel();
    				home.logout();

    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1963",ReportStatus.strMethodName,intCounter,browser);
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

