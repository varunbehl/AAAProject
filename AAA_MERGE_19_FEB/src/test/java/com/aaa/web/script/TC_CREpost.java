package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.syntax.jedit.InputHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static com.aaa.d3itu.page.LoginPage.login;

/**
 * Created by E002734 on 2/9/2018.
 */
public class TC_CREpost extends ActionEngine {
	LoginLib login = new LoginLib();
	public static String Member = "";
	CRMemberSearchLib member = new CRMemberSearchLib();
	CRHomeLib home = new CRHomeLib();
	CREpostLib ePost=new CREpostLib();
	DIHomeLib diHome = new DIHomeLib();




	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void navigationInEpost(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {

		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "navigationInEpost", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("navigationInEpost", TestData, "D3CallRecieving",intCounter);
    	
						this.reporter.initTestCaseDescription("1960: TC-CR Epost"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						CRHomeLib home = new CRHomeLib();
						login.login(data.get("LoginName"), data.get("Password"));
						Thread.sleep(10000);
						home.messageDialogBoxClose();
		
						ePost.clickOnDrpdwnHelp();
						ePost.clickOnEpost();
						ePost.verifyElectronicPost();
						ePost.getNumberOfMenuItemsPopulated();
						ePost.selectMenuItem();
						ePost.getNumberOfCategoriesItemsPopulated();
						ePost.selectCategoriesItem();
						ePost.getNumberOfDetailsDiscriptionData();
						ePost.clickOnAnotherMenuItems();
						ePost.getNumberOfDetailsDiscriptionData();
						ePost.getNumberOfCategoriesItemsPopulated();
						ePost.clickOnClearButton();
						Thread.sleep(5000);
						ePost.getNumberOfMenuItemsPopulated();
						Thread.sleep(5000);
						ePost.getNumberOfCategoriesItemsPopulated();
						ePost.getNumberOfDetailsDiscriptionData();
						ePost.clickOnCloseIcon();
						diHome.logOut();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			finally{
    				ePost.clickOnCloseIcon();
    				diHome.logOut();

    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1960",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }
	
	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void basicSearchInEpost(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "basicSearchInEpost", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("basicSearchInEpost", TestData, "D3CallRecieving",intCounter);
    	
						this.reporter.initTestCaseDescription("1960: TC-CR Epost"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						login.login(data.get("LoginName"), data.get("Password"));
						Thread.sleep(10000);
						home.messageDialogBoxClose();
						DIHomeLib diHome = new DIHomeLib();
						ePost.clickOnDrpdwnHelp();
						ePost.clickOnEpost();
						ePost.verifyElectronicPost();
						ePost.enterDataInKeyboard(data.get("KeyboardData"));
						ePost.clickOnSearchButton();
						ePost.getNumberOfMenuItemsPopulated();
					/*	ePost.selectMenuItem();
						ePost.selectCategoriesItem();*/
						ePost.clickOnHighlightednameInMenuAndCatergories();
						ePost.clickOnHighlightednameInCategories();
						Thread.sleep(3000);
						ePost.clickOnClearButton();
						Thread.sleep(3000);
						//	ePost.getNumberOfMenuItemsPopulated();
						ePost.getNumberOfDetailsDiscriptionData();
						ePost.getNumberOfCategoriesItemsPopulated();
						ePost.clickOnHighlightednameInMenuAndCatergories();
						ePost.clickOnCloseIcon();
						diHome.logOut();


    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			finally{
    				ePost.clickOnCloseIcon();
    				diHome.logOut();

    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("CR","1960",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }


	
	@Parameters({"StartRow","EndRow","nextTestJoin"})
	@Test()
	public void filteredSearchInEpost(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "filteredSearchInEpost", TestData, "D3CallRecieving");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("filteredSearchInEpost", TestData, "D3CallRecieving",intCounter);
    	
						this.reporter.initTestCaseDescription("1960: TC-CR Epost"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						DIHomeLib diHome = new DIHomeLib();
						login.login(data.get("LoginName"), data.get("Password"));
						Thread.sleep(10000);
						home.messageDialogBoxClose();
		
						ePost.clickOnDrpdwnHelp();
						ePost.clickOnEpost();
						ePost.verifyElectronicPost();
						ePost.enterDataInKeyboard(data.get("KeyboardData"));
						ePost.clickOnMenuCheckbox();
						ePost.clickOnCategoriesCheckbox();
						ePost.clickOnDetatilsCheckbox();
						ePost.clickOnSearchButton();
						ePost.clickOnHighlightednameInMenuAndCatergories();
						//ePost.getNumberOfMenuItemsPopulated();
						//ePost.selectMenuItem();
						ePost.clickOnHighlightednameInMenuAndCatergories();
						ePost.getNumberOfCategoriesItemsPopulated();
						//	ePost.clickOnHighlightednameInCategories();
						ePost.clickOnSearchButton();
						ePost.clickOnHighlightednameInMenuAndCatergories();
						Thread.sleep(5000);
						ePost.verifyDetailedInfoByCategoriesItemsPopulated();
						//	ePost.clickOnCloseIcon();
						ePost.clickOnPopout();
		
						ePost.selectMenuItem();
						ePost.clickOnPopIn();
						ePost.clickOnCloseIcon();
						diHome.logOut();
		    			}
		    			catch(Exception e)
		    			{
		    				ReportStatus.blnStatus=false;
		    			}
		    			finally{
		    				ePost.clickOnPopIn();
		    				ePost.clickOnCloseIcon();
		    				diHome.logOut();
		
		    			}
		    			ReportControl.fnEnableJoin();
		    			ReportStatus.fnUpdateResultStatus("CR","1960",ReportStatus.strMethodName,intCounter,browser);
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

