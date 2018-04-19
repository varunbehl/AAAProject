package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DIHomePage;
import com.aaa.web.page.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.Hashtable;


public class TC_DISPPLogin extends DILoginLib {


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

	public void ActiveUserValidUserNameAndValidPassword(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISPPLogin", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISPPLogin", TestData, "D3Dispatch",intCounter);
    	

						this.reporter.initTestCaseDescription("1769: DISPP Login"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						navigateToApplication("DI");
						DIHomeLib diHome = new DIHomeLib();
						LoginRoleLib loginRole = new LoginRoleLib();
		                enterUserName(data.get("ActiveManagerPNE"));
		                enterPassword(data.get("DIPassword"));
		                loginButton();
						loginRole.clickOnProceedBtnInDispatchRoleLogin();
						Thread.sleep(5000);
						waitcloseAllBusyIcons();
						diHome.closeFacilityWindow();
						waitForVisibilityOfElement(DIHomePage.lblSPPDisplatch,"SPP Dispatch");
						boolean SPPDispatch = isVisible(DIHomePage.lblSPPDisplatch,"SPP Dispatch");
						assertTrue(SPPDispatch,"Logged into the application without any errors");
						diHome.logOut();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1769",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
	
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

	public void ActiveUserValidUserNameAndInvalidPassword(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISPPLogin", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISPPLogin", TestData, "D3Dispatch",intCounter);
    	
						this.reporter.initTestCaseDescription("1769: DISPP Login"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						navigateToApplication("DI");
						enterUserName(data.get("ActiveManagerPNE"));
						enterPassword(data.get("DIInvalidPassword"));
						loginButton();
						Thread.sleep(5000);
						waitForVisibilityOfElement(LoginPage.errorMessageInvalidUserName,"Invalid UserName/Password Combination");
						String errorMEssage =getText(LoginPage.errorMessageInvalidUserName,"Invalid UserName/Password Combination").trim();
						assertTrue(errorMEssage.equalsIgnoreCase(data.get("ErrorInvalidUserNamePassword")),"Error displays Invalid UserName/Password Combination");
						click(LoginPage.btnErrorAlertOK,"OK");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1769",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

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

	public void InActiveUserValidUserNameAndValidPassword(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISPPLogin", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISPPLogin", TestData, "D3Dispatch",intCounter);
    	

						this.reporter.initTestCaseDescription("1769: DISPP Login"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						navigateToApplication("DI");
						DIHomeLib diHome = new DIHomeLib();
						enterUserName(data.get("InActiveUserManagerPNE"));
						enterPassword(data.get("DIPassword"));
						loginButton();
						Thread.sleep(5000);
						String errorMEssage =getText(LoginPage.errorMessageOnErrorAlert,"Your Account is Currently Inactive. Contact Your Supervisor to Activate Your Account.").trim();
						assertTrue(errorMEssage.equalsIgnoreCase(data.get("ErrorInactiveUser")),"Error displays Invalid UserName/Password Combination");
						click(LoginPage.btnErrorAlertOK,"OK");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1769",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }

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

	public void MultipleRoles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		 try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISPPLogin", TestData, "D3Dispatch");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISPPLogin", TestData, "D3Dispatch",intCounter);
	    	

							this.reporter.initTestCaseDescription("1769: DISPP Login"+ " From Iteration " + StartRow + " to " + EndRow );
							reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
							MultiUserLogin(data,data.get("UserRole1"));
							MultiUserLogin(data,data.get("UserRole2"));

	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("DI","1769",ReportStatus.strMethodName,intCounter,browser);
	    		}
	    	}
	    	catch (Exception e) 
	    	{
	    		e.printStackTrace();
	    		throw new RuntimeException(e);
	    	}
	    	ReportControl.fnNextTestJoin(nextTestJoin);
	    }


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

	public void NoSPPAccessUserValidUserNameAndValidPassword(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		 try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISPPLogin", TestData, "D3Dispatch");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISPPLogin", TestData, "D3Dispatch",intCounter);
	    	

							this.reporter.initTestCaseDescription("1769: DISPP Login"+ " From Iteration " + StartRow + " to " + EndRow );
							reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
							navigateToApplication("DI");
							DIHomeLib diHome = new DIHomeLib();
							enterUserName(data.get("NoSPPAccessUser"));
							enterPassword(data.get("DIPassword"));
							loginButton();
							Thread.sleep(5000);
							waitForVisibilityOfElement(LoginPage.errorMessageOnErrorAlert,"Access Denied. Your Role is Not Authorized to Use this Module.");
							String errorMEssage =getText(LoginPage.errorMessageOnErrorAlert,"Access Denied. Your Role is Not Authorized to Use this Module.").trim();
							assertTrue(errorMEssage.equalsIgnoreCase(data.get("NoSPPAccessError")),"Error displays:Access Denied. Your Role is Not Authorized to Use this Module.");
							click(LoginPage.btnErrorAlertOK,"OK");
	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("DI","1769",ReportStatus.strMethodName,intCounter,browser);
	    		}
	    	}
	    	catch (Exception e) 
	    	{
	    		e.printStackTrace();
	    		throw new RuntimeException(e);
	    	}
	    	ReportControl.fnNextTestJoin(nextTestJoin);
	    }
	 
	public void MultiUserLogin(Hashtable<String, String> data, String Role) throws Throwable{

		navigateToApplication("DI");
		DIHomeLib diHome = new DIHomeLib();
		LoginLib loginLib = new LoginLib();
		enterUserName(data.get("MultipleRolesUserName"));
		enterPassword(data.get("DIPassword"));
		loginButton();
		Thread.sleep(10000);
		waitForVisibilityOfElement(LoginPage.ddlRoleField,"Role Field login screen");
		boolean roleField = isVisible(LoginPage.ddlRoleField,"Role Field login screen");
		assertTrue(roleField," login screen displays the Role field");
		waitForVisibilityOfElement(LoginPage.ddnLocationField,"Location Field login screen");
		boolean locationField = isVisible(LoginPage.ddnLocationField,"Location Field login screen");
		assertTrue(locationField,"login screen displays Location Field");
		waitForVisibilityOfElement(LoginPage.ddnRole,"Role screen displays Drop Down");
		click(LoginPage.ddnRole," Role Drop Down button");

		String Role1SPPManager = getText(LoginPage.lblRoleSPPManager,"P3 - SPP Manager").trim();
		assertTrue(Role1SPPManager.equalsIgnoreCase(data.get("Role1SPPManager")),"P3 - SPP Manager");

		String Role1PPServiceProvider = getText(LoginPage.lblRoleServiceProvider,"PP - Service Provider Portal").trim();
		assertTrue(Role1PPServiceProvider.equalsIgnoreCase(data.get("Role2PPServiceProviderPortal")),"PP - Service Provider Portal");

		click(LoginPage.lblSelectRoleFromRoleDropDown(Role),"Role Selected "+Role);

		Thread.sleep(2000);
		click(LoginPage.LocationDropDownButton,"Location Drop Down");
		Thread.sleep(5000);

		//String locationItems = loginLib.GetLocationsFromLogin();
		String defaultLocation = getText(LoginPage.ddnLocationField,"Location Filed");
		assertTrue(defaultLocation != "","Locations is set, Location Name is  "+defaultLocation);

		click(LoginPage.lblSelectLocationFromLocationDropDown(data.get("Location")),"Selecting Location "+data.get("Location"));
		Thread.sleep(2000);

		boolean backToLogin = isElementPresent(LoginPage.btnBackToLogin,"Back to login");
		assertTrue(backToLogin,"Back to Login Button exist");

		boolean ProceedButton = isElementPresent(LoginPage.btnProceedLogin,"Proceed");
		assertTrue(ProceedButton,"Proceed Button exist");

		click(LoginPage.btnProceedLogin,"Proceed");
		waitcloseAllBusyIcons();
		diHome.closeFacilityWindow();
		waitForVisibilityOfElement(DIHomePage.lblSPPDisplatch,"SPP Dispatch");
		boolean SPPDispatch = isVisible(DIHomePage.lblSPPDisplatch,"SPP Dispatch");
		assertTrue(SPPDispatch,"Logged into the application without any errors");
		diHome.logOut();

	}

}
