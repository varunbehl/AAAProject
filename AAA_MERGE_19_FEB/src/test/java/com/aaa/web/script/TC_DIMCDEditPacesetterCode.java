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

/**
 * Created by E002734 on 2/15/2018.
 */
public class TC_DIMCDEditPacesetterCode extends ActionEngine {

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
	DIHomeLib diHome = new DIHomeLib();
	DILoginLib diLogin = new DILoginLib();
	LoginRoleLib role = new LoginRoleLib();
	DIMCDLib mcdlib = new DIMCDLib();
	DILoginLib diLoginLib = new DILoginLib();
	String callID;
	CRHomeLib crHomeLib = new CRHomeLib();
	DIMCDLib diMCD = new DIMCDLib();



	/************************************************************************
	* Script Name :-
	* Method Name :-
	* Module	  :- DI 
	* Test Case ID:-
	* Script Date :- 
	* Author      :- 
	* @param StartRow
	* @param EndRow
	* @param nextTestJoin
	* @throws Throwable
	*************************************************************************/
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void diMcdEditPacesetterCode(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "diMcdEditPacesetterCode", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("diMcdEditPacesetterCode", TestData, "D3Dispatch",intCounter);
    	
						this.reporter.initTestCaseDescription("1823: TC-DI MCD Edit Pacesetter Code"+ " From Iteration " + StartRow + " to " + EndRow );
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
						crHomeLib.saveButton();
						crHomeLib.waitCloseAllBusyIconsResults();
						Thread.sleep(3000);
						//  callId1 = service.getCallId();
						callID = service.getCallId();
						service.closeCall();
						crHomeLib.logout();
						acceptAlert();
						Thread.sleep(2000);
						acceptAlert();
		
		//Navigating to DI dispatch
						navigateToApplication("DI");
						Thread.sleep(8000);
						diLogin.login(data.get("DILoginName"), data.get("DIPassword"));
						Thread.sleep(3000);
						role.clickOnProceedBtnInDispatchRoleLogin();
						diLoginLib.waitcloseAllBusyIcons();
						diHome.clickOnCloseIconOnQueueSelection();
						diHome.clickOnSearchCallsInDispatch();
						//  diHome.enterCallIDInfo(callId1);
						diHome.enterCallIDInfo(callID);
						diHome.clickOnSearchInSearchCalls();
						crHomeLib.waitCloseAllBusyIconsResults();
						diHome.clickOnCallDateOrIDLink();
						crHomeLib.waitCloseAllBusyIconsResults();
		
						diMCD.clickOnServiceTabInMCDWindow();
						diMCD.getFieldsToDisplayInPacesetter();
						diMCD.getEditAndClick();
						diMCD.getEditDropdownSelection();
		
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			finally{
    				dispatcherUpdate.clickOnCancel();
    				home.logout();

    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1823",ReportStatus.strMethodName,intCounter,browser);
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

