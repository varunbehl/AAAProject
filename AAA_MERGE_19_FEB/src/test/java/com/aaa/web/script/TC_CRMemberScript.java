package com.aaa.web.script;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.CRHomeLib;
import com.aaa.web.lib.CRMemberSearchLib;
import com.aaa.web.lib.CommonDb;
import com.aaa.web.lib.LoginLib;
import com.aaa.web.lib.LoginRoleLib;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by E001133 on 27-11-2017.
 */

public class TC_CRMemberScript extends CRMemberSearchLib {
    
    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: membnumSearch
     * description :: This is to validate login functionality with difference combinations
     * date :: 05-Dec-2017
     * author :: Chandu Dendukuri
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void membnumSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "memnumSearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("memnumSearch", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Member Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                home.verifyandClickLogout();
		                navigateToApplication("CR");
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
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
		                	Member = data.get("Membersearch");
		                }
		                home.memberSearchTextBox(Member);
		                //home.memberSearchTextBox(dataBean.getValue(data,"Membersearch"));
		                memberNumberCol(Member);
		                home.leaveButton();
		                home.allErrorAlerts();
		                home.logout();
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
    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: membemailSearch
     * description :: This is to validate login functionality with difference combinations
     * date :: 05-Dec-2017
     * author :: Chandu Dendukuri
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void membemailSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "mememailSearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("mememailSearch", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Member Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                home.verifyandClickLogout();
		                navigateToApplication("CR");
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		                home.verifyHomeScreen();
		                home.memberSearchTextBox(dataBean.getValue(data,"Membersearch"));
		                memberEmailCol(dataBean.getValue(data,"Membersearch"));
		                home.leaveButton();
		                home.allErrorAlerts();
		                home.logout();
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
    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: membnameSearch
     * description :: This is to validate login functionality with difference combinations
     * date :: 05-Dec-2017
     * author :: Chandu Dendukuri
     */
   
    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void memnamesearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "memnamesearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("memnamesearch", TestData, "D3CallRecieving",intCounter);
		    	
		                this.reporter.initTestCaseDescription("CR Member Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                navigateToApplication("CR");
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		                home.verifyHomeScreen();
		                //home.messageDialogBoxClose();
		                home.memberSearchTextBox(dataBean.getValue(data,"Membersearch"));
		                
		                /*login(data);
		                home.memberSearchTextbox(data);*/
		                memberNameCol(dataBean.getValue(data,"Membersearch"));
		                home.leaveButton();
		                home.allErrorAlerts();
		                home.logout();
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

    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: nineDigitMemberSearch
     * description :: This is to validate login functionality with difference combinations
     * date :: 05-Dec-2017
     * author :: Chandu Dendukuri
     */
 

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void nineDigitMemberSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "nineDigitMemberSearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("nineDigitMemberSearch", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Member Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                navigateToApplication("CR");
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		                home.verifyHomeScreen();
		                //home.messageDialogBoxClose();
		                home.memberSearchTextBox(dataBean.getValue(data,"Membersearch"));
		                emptySearchResults();
		                home.leaveButton();
		                home.allErrorAlerts();
		                home.logout();
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

    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: membnameaddressSearch
     * description :: This is to validate login functionality with difference combinations
     * date :: 05-Dec-2017
     * author :: Chandu Dendukuri
     */
  

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void memnameaddressSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "memnameaddressSearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("memnameaddressSearch", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Member Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                home.verifyandClickLogout();
		                navigateToApplication("CR");
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		                home.verifyHomeScreen();
		                //home.messageDialogBoxClose();
		                home.memberSearchTextBox(dataBean.getValue(data,"Membersearch"));
		                membernameaddressCol(dataBean.getValue(data, "Membersearch"));
		                home.leaveButton();
		                home.allErrorAlerts();
		                home.logout();
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
    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: membPhoneSearch
     * description :: This is to validate login functionality with difference combinations
     * date :: 05-Dec-2017
     * author :: Chandu Dendukuri
     */
   

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()

    public void memphoneSearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "memphoneSearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("memphoneSearch", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Member Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                home.verifyandClickLogout();
		                navigateToApplication("CR");
		                login.login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		                home.verifyHomeScreen();
		                //home.messageDialogBoxClose();
		                home.memberSearchTextBox(dataBean.getValue(data,"Membersearch"));
		                memberPhoneCol(dataBean.getValue(data,"Membersearch"));
		                home.leaveButton();
		                home.allErrorAlerts();
		                home.logout();
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
    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: HistorySearch
     * description :: This is to validate login functionality with difference combinations
     * date :: 07-Dec-2017
     * author :: Chandu Dendukuri
     */
    
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void historySearch(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "memHistorySearch", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("memHistorySearch", TestData, "D3CallRecieving",intCounter);
    	
		                this.reporter.initTestCaseDescription("CR Member Search"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                CRHomeLib home = new CRHomeLib();
		                LoginLib login = new LoginLib();
		                CRMemberSearchLib member = new CRMemberSearchLib();
		                LoginRoleLib role = new LoginRoleLib();
		                home.verifyandClickLogout();
		                navigateToApplication("CR");
		                login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
		                home.verifyHomeScreen();
		                //home.messageDialogBoxClose();
		                //role.RoleSelection(data);
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
		                member.memberNumClick();
		                //emptySearchResults();
		                member.clickOnManualEntryLinkInMember();
		                //home.clickOnManualEntryLink("member");
		                //memberNumberValidation();
		
		           /* memberPhoneCol(data);*/
		                home.leaveButton();
		                home.allErrorAlerts();
		                home.logout();
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
    /**
     * param :: Hashtable with string inputs
     * return ::void
     * throws :: throwable
     * methodName :: membSearch
     * description :: This is to validate login functionality with difference combinations
     * date :: 05-Dec-2017
     * author :: Chandu Dendukuri
     */
/*
    @DataProvider
    public Object[][] getTestDataFor_memSearch() {
        return TestUtil.getData("memSearch", TestData, "D3CallRecieving");
    }

    @Test(dataProvider = "getTestDataFor_memSearch")

    public void membSearch(Hashtable<String, String> data) throws Throwable {
        try {
            if (data.get("RunMode").equals("Y")) {
                this.reporter.initTestCaseDescription("CR Member Search");
                CRHomeLib home = new CRHomeLib();
                LoginLib login = new LoginLib();
                home.verifyandClickLogout();
                login(dataBean.getValue(data,"LoginName"),dataBean.getValue(data,"Password"));
                home.memberSearchTextBox(dataBean.getValue(data,"Membersearch"));
                memberNumberCol(dataBean.getValue(data, "Membersearch"));
                home.leaveButton();
                memberEmailCol(dataBean.getValue(data, "Membersearch"));
                home.leaveButton();
                memberNameCol(dataBean.getValue(data, "Membersearch"));
                home.leaveButton();
                membernameaddressCol(dataBean.getValue(data, "Membersearch"));
                home.leaveButton();
                memberPhoneCol(dataBean.getValue(data, "Membersearch"));
                home.leaveButton();
                home.logout();
                System.out.println("Test completed");

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
*/
}
