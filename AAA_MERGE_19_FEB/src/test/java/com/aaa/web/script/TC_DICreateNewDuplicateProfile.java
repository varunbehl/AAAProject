

package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.*;
import com.thoughtworks.selenium.webdriven.commands.IsVisible;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DICreateNewDuplicateProfile extends ActionEngine {

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
	public void CreateNewDuplicateProfile(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DICreateNewDuplicateProfile", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DICreateNewDuplicateProfile", TestData, "D3Dispatch",intCounter);
    	
						this.reporter.initTestCaseDescription("2018:TC-Create New Duplicate Profile"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						DIHomeLib diHome = new DIHomeLib();
						CRHomeLib home=new CRHomeLib();
						DIProfileLib profile = new DIProfileLib();
						DILoginLib diLogin = new DILoginLib();
						LoginToApplication(data,data.get("LoginName"), data.get("Password"));
						//Step 1
						waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
						click(DIHomePage.tabDiProfile, "Profile Menu Item");
						//Step 2
						boolean OpenNewProfileSection =isVisible(DIHomePage.txtOpenNewProfile,"+ Open New Profile");
						assertTrue(OpenNewProfileSection,"'+ Open New Profile selection' displays");
						//Step 3
						diHome.clickOnOpenNewProfile();
						boolean setProfileName = isVisibleOnly(DIProfilePage.dialogSetProfileName,"Set Profile Name Dialog");
						assertTrue(setProfileName,"'Set Profile Name' window appears");
						//Step 4
						click(DIProfilePage.btnSaveAndContinue,"Save & Continue");
						// Verifying field is highlighted in Red
						boolean textBoxHighlightedInRed = isVisible(DIProfilePage.txtBoxHighligetedInRed,"Name TextBox field in Set Profile Namw window");
						assertTrue(textBoxHighlightedInRed,"Name TextBox field is highlighted in Red");
						String profileNameError = getText(DIProfilePage.lblUserProfileNameEmpty,"User Profile Name is Empty").trim();
						assertTrue(profileNameError.equalsIgnoreCase(data.get("UserProfileNameEmpty")),"Error displays User profile name is empty");
						//Step 5
						type(DIProfilePage.txtName,data.get("ProfileName"),"Name");
						click(DIHomePage.btnSaveAndContinueInSetProfileNameWindow,"Save & Continue");
						Thread.sleep(4000);
		
						boolean profileWindow = isVisible(DIProfilePage.DialogprofileWindow,"Profile Window");
						assertTrue(profileWindow,"Profile Window Exists");
		
						String profileNameCom  = getText(DIProfilePage.lblProfileName,"Profile Name displays on Profile Window");
						String profileName = profileNameCom.substring(profileNameCom.lastIndexOf('-') + 1).trim();
						assertTrue(profileName.equalsIgnoreCase(data.get("ProfileName")),"Profile Name exists on Profile Window");
						// Step 6
						Thread.sleep(10000);
						click(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
						Thread.sleep(6000);
						dragAndDrop(DIProfilePage.lblIDSelectedSection,DIProfilePage.lblStsSelectedSts,"Drag and Drop");
						click(DIProfilePage.btnArrowId,"Id Arrow Button");
		
						profile.selectPriority(data.get("Priority"));
						Thread.sleep(2000);
						profile.selectOrder(data.get("AscendingOrder"));
						Thread.sleep(2000);
						//diHome.clickOnSaveButtonOfIDAndDateOnProfileWindow();
						click(DIProfilePage.btnSave, "Save button for ID");
						Thread.sleep(2000);
						click(DIProfilePage.btnSaveSettings, "Save Settings Button");
						home.allErrorAlerts();
						Thread.sleep(9000);
						click(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
						//Step 7
						String firstColValue = getText(DIProfilePage.lblFirstColSelectedSection,"First Column Selected Section");
						assertTrue(firstColValue.contains(data.get("FirstColumnName")),"Field is now displayed as the first column");
						click(DIProfilePage.btnCancel,"Cancel");
						Thread.sleep(9000);
						click(DIProfilePage.iconCloseTheProfile,"Close The Profile");
						//diHome.clickToCloseProfileWindow();
						diHome.clickOnProfileMenu();
						boolean profileNameExist = isVisible(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
						assertTrue(profileNameExist,"profile name is listed in Custom Profiles, Profile Name is: "+data.get("ProfileName"));
						// Step 10
						click(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
						Thread.sleep(9000);
						boolean openDuplicateProfile = isVisible(DIProfilePage.iconOpenDuplicateProfile,"Open Duplicate Profile Button in Profile Window");
						assertTrue(openDuplicateProfile,"'Open a duplicate profile' button exist");
						// Step 11
						String columValue = getText(DIProfilePage.lblFirstColumn,"First Column Name").trim();
						assertTrue(columValue.equalsIgnoreCase(data.get("FirstColumnName")),"First Column Value is:"+columValue);
						// Step 12
						click(DIProfilePage.iconOpenDuplicateProfile,"Open a Duplicate Profile");
						boolean setProfileNameWindow = isVisibleOnly(DIProfilePage.dialogSetProfileName,"Set Profile Name Dialog");
						assertTrue(setProfileNameWindow,"'Set Profile Name' window appears");
						// Step 13
						type(DIProfilePage.txtName,data.get("ProfileNameDuplicate"),"Name");
						click(DIHomePage.btnSaveAndContinueInSetProfileNameWindow,"Save & Continue");
						Thread.sleep(9000);
		
						String columValueDuplicate = getText(DIProfilePage.lblFirstColumn,"First Column Name").trim();
						assertTrue(columValueDuplicate.equalsIgnoreCase(data.get("FirstColumnName")),"First Column Value is:"+columValue);
						click(DIProfilePage.iconCloseTheProfile,"Close The Profile");
						Thread.sleep(5000);
						waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
						click(DIHomePage.tabDiProfile, "Profile Menu Item");
						profileNameExist = isVisible(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
						assertTrue(profileNameExist,"profile name is listed in Custom Profiles, Profile Name is: "+data.get("ProfileName"));
		
						profileNameExist = isVisible(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileNameDuplicate")),"Profile Name in Profile Menu Items "+data.get("ProfileNameDuplicate"));
						assertTrue(profileNameExist,"profile name is listed in Custom Profiles, Profile Name is: "+data.get("ProfileNameDuplicate"));
						diHome.logOut();
						Thread.sleep(5000);
						
		
						LoginToApplication(data,data.get("LoginName"), data.get("Password"));
						waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
						click(DIHomePage.tabDiProfile, "Profile Menu Item");
		
						profileNameExist = isVisible(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
						assertTrue(profileNameExist,"profile name is listed in Custom Profiles, Profile Name is: "+data.get("ProfileName"));
		
						profileNameExist = isVisible(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileNameDuplicate")),"Profile Name in Profile Menu Items "+data.get("ProfileNameDuplicate"));
						assertTrue(profileNameExist,"profile name is listed in Custom Profiles, Profile Name is: "+data.get("ProfileNameDuplicate"));
						diHome.logOut();
						Thread.sleep(10000);
						
						// Verifying created Profile names is not displayed in Profile menu after logging in with different user
						LoginToApplication(data,data.get("LoginNameNew"), data.get("Password"));
						waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Menu Item");
						click(DIHomePage.tabDiProfile, "Profile Menu Item");
						profileNameExist = isVisibleOnly(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
						assertTrue(!profileNameExist,"profile name is not listed in Custom Profiles, Profile Name is: "+data.get("ProfileName"));
		
						profileNameExist = isVisibleOnly(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileNameDuplicate")),"Profile Name in Profile Menu Items "+data.get("ProfileNameDuplicate"));
						assertTrue(!profileNameExist,"profile name is not listed in Custom Profiles, Profile Name is: "+data.get("ProfileNameDuplicate"));
						diHome.logOut();
						Thread.sleep(5000);
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2018",ReportStatus.strMethodName,intCounter,browser);
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
	public void DeleteUserProfiles(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
		 try
	    	{
	    		int intStartRow=StartRow;
	    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DICreateNewDuplicateProfile", TestData, "D3Dispatch");
	    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
	    		{
	    			try {
	    					ReportStatus.fnDefaultReportStatus();
	    					ReportControl.intRowCount=intCounter;
	    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DICreateNewDuplicateProfile", TestData, "D3Dispatch",intCounter);
	    	
						this.reporter.initTestCaseDescription("2018:TC-Create New Duplicate Profile"+ " From Iteration " + StartRow + " to " + EndRow );
						reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
						DIHomeLib diHome = new DIHomeLib();
						DILoginLib dilogin = new DILoginLib();
						DILoginLib diLogin = new DILoginLib();
						LoginToApplication(data,data.get("LoginName"), data.get("Password"));
						waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Tab");
						click(DIHomePage.tabDiProfile, "Profile Menu Item");
						waitForVisibilityOfElement(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
						click(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileName")),"Profile Name in Profile Menu Items "+data.get("ProfileName"));
		
						waitForVisibilityOfElement(DIProfilePage.DialogprofileWindow,"Profile Window");
						Thread.sleep(9000);
						waitForVisibilityOfElement(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
						//waitForElementToBeClickable(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
						mouseDoubleClick(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
						waitForVisibilityOfElement(DIProfilePage.btnDeleteThisUserProfile,"Delete This User Profile");
						click(DIProfilePage.btnDeleteThisUserProfile,"Delete This User Profile");
						waitForVisibilityOfElement(DIProfilePage.btnYesOnDeletePopUpWindow,"Yes Button on Delete Pop Up");
						click(DIProfilePage.btnYesOnDeletePopUpWindow,"Yes Button on Delete Pop Up");
						Thread.sleep(5000);
						waitForVisibilityOfElement(DIHomePage.tabDiProfile, "Profile Tab");
						click(DIHomePage.tabDiProfile, "Profile Menu Item");
						waitForVisibilityOfElement(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileNameDuplicate")),"Profile Name in Profile Menu Items "+data.get("ProfileNameDuplicate"));
						click(DIProfilePage.lblProfileNameInProfileMenuItems(data.get("ProfileNameDuplicate")),"Profile Name in Profile Menu Items "+data.get("ProfileNameDuplicate"));
						waitForVisibilityOfElement(DIProfilePage.DialogprofileWindow,"Profile Window");
						Thread.sleep(9000);
						//waitForElementToBeClickable(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
						waitForVisibilityOfElement(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
						mouseDoubleClick(DIProfilePage.iconCustomizeTheProfile,"Customize the Profile");
						waitForVisibilityOfElement(DIProfilePage.btnDeleteThisUserProfile,"Delete This User Profile");
						click(DIProfilePage.btnDeleteThisUserProfile,"Delete This User Profile");
						waitForVisibilityOfElement(DIProfilePage.btnYesOnDeletePopUpWindow,"Yes Button on Delete Pop Up");
						click(DIProfilePage.btnYesOnDeletePopUpWindow,"Yes Button on Delete Pop Up");
						diHome.logOut();
	    			}
	    			catch(Exception e)
	    			{
	    				ReportStatus.blnStatus=false;
	    			}
	    			ReportControl.fnEnableJoin();
	    			ReportStatus.fnUpdateResultStatus("DI","2018",ReportStatus.strMethodName,intCounter,browser);
	    		}
	    	}
	    	catch (Exception e) 
	    	{
	    		e.printStackTrace();
	    		throw new RuntimeException(e);
	    	}
	    	ReportControl.fnNextTestJoin(nextTestJoin);
	    }


	public void LoginToApplication(Hashtable<String, String> data,String username,String password) throws Throwable {
		DILoginLib diLogin = new DILoginLib();
		DIHomeLib diHome = new DIHomeLib();
		LoginRoleLib loginRole=new LoginRoleLib();
		navigateToApplication("DI");
		diLogin.login(username, password);
		Thread.sleep(5000);
		loginRole.clickOnProceedBtnInDispatchRoleLogin();
		Thread.sleep(15000);
		diLogin.waitcloseAllBusyIcons();
		Thread.sleep(5000);
		diHome.clickOnCloseIconOnQueueSelection();
		Thread.sleep(5000);
	}

}