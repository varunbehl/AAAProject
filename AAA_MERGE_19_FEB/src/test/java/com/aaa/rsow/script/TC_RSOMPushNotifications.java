package com.aaa.rsow.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DISearchCallsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_RSOMPushNotifications  extends DILoginLib {
	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void webPushNotifications(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "webPushNotifications", TestData, "RSOMobile");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("webPushNotifications", TestData, "RSOMobile",intCounter);
		
						this.reporter.initTestCaseDescription("1650 : Push notification"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			    		
						LoginLib login = new LoginLib();
						DILoginLib diLoginLib = new DILoginLib();
						LoginRoleLib role = new LoginRoleLib();
						DIHomeLib diHome = new DIHomeLib();
						DIMCDLib dimcdLib = new DIMCDLib();
						DISearchCallsPage diSearchCallsPage=new DISearchCallsPage();
						//need to add in ActionEngine
						navigateToApplication("DI");
						diLoginLib.login(data.get("DILoginName"),data.get("DIPassword"));
						role.clickOnProceedBtnInDispatchRoleLogin();
						diLoginLib.waitcloseAllBusyIcons();
						diHome.clickOnCloseIconOnQueueSelection();
						diHome.clickOnSearchCallsInDispatch();
						diHome.enterMemberNumberInfo(data.get("MemberNumber"));
						diHome.clickOnSearchInSearchCalls();
						diHome.clickOnCallDateOrIDLink();
						dimcdLib.clickOnAssign();
						dimcdLib.selectFacilityOnAssignTabInMCD();
						dimcdLib.selectDispatch();
						dimcdLib.selectEnroute();
						dimcdLib.selectEnrouteTime();
						dimcdLib.selectOnLocation();
						dimcdLib.selectClearCall();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("RSO","1650",ReportStatus.strMethodName,intCounter,browser);
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
