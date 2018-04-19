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
 * Created by E001133 on 27-11-2017.
 */
public class TC_DILogin extends DILoginLib {

	/**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: loginWithValidUserNameAndInvalidPassword
     * description :: valdUsernamewithInvalidPassword
     * date :: 18-Dec-2017
     * author :: Chandu Dendukuri
     */
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

    public void loginWithValidUserNameAndInvalidPassword(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIvalidUsernameInvalidpassword", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIvalidUsernameInvalidpassword", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("DI Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("DI");
		                DIHomeLib diHome = new DIHomeLib();
		                loginValidation(data.get("LoginName"),data.get("Password"));
		                //diHome.logOut();
		                System.out.println("Test completed");

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: loginWithInactiveUser
     * description :: Validation for inactive user details
     * date :: 18-Dec-2017
     * author :: Chandu Dendukuri
     */
   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void loginWithInactiveUser(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIloginWithInactiveUser", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIloginWithInactiveUser", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("DI Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("DI");
		                loginValidation(data.get("LoginName"),data.get("Password"));
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
       /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: sucessLogin
     * description :: successful login functionality
     * date :: 18-12-2017
     * author :: Chandu Dendukuri
     */
   
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void successLogin(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISuccessLogin", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISuccessLogin", TestData, "D3Dispatch",intCounter);
    	

		                this.reporter.initTestCaseDescription("DI Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("DI");
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                login(data.get("LoginName"),data.get("Password"));
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.logOut();
		                /*home.allErrorAlerts();*/
		                System.out.println("Test completed");            	
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: sucessLogin
     * description :: successful login functionality
     * date :: 18-12-2017
     * author :: Chandu Dendukuri
     */
   /* @DataProvider
    public Object[][] getTestDataFor_ChangePassword() {
        return TestUtil.getData("Changepassword", TestData, "D3Dispatch");
    }
    @Test(dataProvider = "getTestDataFor_ChangePassword")

    public void changePassword(Hashtable<String, String> data) throws Throwable {
        try {
            if (data.get("RunMode").equals("Y")) {
                this.reporter.initTestCaseDescription("DI Login");
                CRHomeLib home=new CRHomeLib();
                navigateToApplication("DI");
                enterUserName(data.get("LoginName"));
                enterPassword(data.get("Password"));
                changePasswordButton();
                verifyChangePassword(data.get("NewPassword"),data.get("Confirm password"),data.get("PasswordChangeAlert"));
                home.allErrorAlerts();
                System.out.println("Test completed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }*/
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: sessionTest
     * description :: Session testing
     * date :: 18-12-2017
     * author :: Chandu Dendukuri
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void sessionTest(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISessionTest", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISessionTest", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("DI Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                DIHomeLib diHome = new DIHomeLib();
		                navigateToApplication("DI");
		                login(data.get("LoginName"),data.get("Password"));
		                role.clickOnProceedBtnInDispatchRoleLogin();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.sessionInNewTab();
		                diHome.logOut();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: SelectROle
     * description :: SelectRole
     * date :: 18-12-2017
     * author :: Chandu Dendukuri
     */
  
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void SelectRole(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DISelectRole", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DISelectRole", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("DI Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                DIHomeLib diHome = new DIHomeLib();
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib role = new LoginRoleLib();
		                navigateToApplication("DI");
		                login(data.get("LoginName"),data.get("Password"));
		                role.roleSelection(data.get("RoleinDispatch"));
		                waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.logOut();
		                System.out.println("Test completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: multiLoingAttemptsValidation
     * description :: multiple login attempts
     * date :: 18-12-2017
     * author :: Chandu Dendukuri
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void multiLoginAttemptsValidation(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMAX_PSWD_TRIES", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMAX_PSWD_TRIES", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("DI Login"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                navigateToApplication("DI");
		                mulipleLoginAttemps(data.get("LoginName"),data.get("Password"));
		                System.out.println("Test Completed");
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","7777",ReportStatus.strMethodName,intCounter,browser);
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
