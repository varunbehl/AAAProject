package com.aaa.web.script;


import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import com.aaa.web.page.DIHomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DIMessages extends ActionEngine {

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
    public void diMessages(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMessages", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMessages", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1603:DIMessages"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                DIHomeLib diHome = new DIHomeLib();
		                DILoginLib diLogin = new DILoginLib();
		                LoginLib login = new LoginLib();
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib loginRole = new LoginRoleLib();
		
		
		                navigateToApplication("DI");
		                login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                diLogin.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.verifyMessagePopUpOnDispatchHomepage();
		                diHome.popOutAndPopInMessagePopUpWindow();
		                Thread.sleep(5000);
		                switchToWindow();
		                diHome.popOutAndPopInMessagePopUpWindow();
		                switchToWindow();
		                Thread.sleep(3000);
		                diHome.clickOnNewMessageTab();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                boolean listOfusers = diHome.verifyListOfUsersOnAddressBook();
		                assertTrue(listOfusers, "List of Users Are Displayed");
		                boolean userButton = diHome.verifyUserButtonIsHighligted();
		                assertTrue(userButton, "User button is Highlighted");
		                diHome.selectCallTakerUserFromMessagePopup();
		                diHome.clickOnAddRecipientButtonOnMessagePopup();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(2000);
		                diHome.clickOnSendButtonOnMessagePopup();
		                boolean Error = diHome.verifyMessageTextFieldturnsRed();
		                assertTrue(Error, "Message field turns into red");
		                String countbefore = diHome.getCharacterslimitCount();
		                diHome.enterMessageInMessageTextBox(data.get("Message"));
		                String countAfter = diHome.getCharacterslimitCount();
		                int count = Integer.parseInt(countbefore) - data.get("Message").length();
		                String countLimit = Integer.toString(count);
		                assertTrue(countAfter.equalsIgnoreCase(countLimit), "Verified message window displays an indication showing limit of characters");
		                diHome.clickOnSendButtonOnMessagePopup();
		                boolean messageWindow = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
		                assertTrue(messageWindow, "New Message Window Closed And Message Window In Focus");
		                Thread.sleep(3000);
		                diHome.clickOnNewMessageTab();
		                Thread.sleep(5000);
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(3000);
		                diHome.selectDispatchUserFromMessagePopup();
		                diHome.clickOnAddRecipientButtonOnMessagePopup();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                diHome.enterMessageInMessageTextBox(data.get("Message"));
		                diHome.clickOnSendButtonOnMessagePopup();
		                Thread.sleep(15000);
		                String message = diHome.verifyMessageSentAndViewedByRecipient();
		                assertTrue(message.equalsIgnoreCase(data.get("Message")), "Message Received and viewed");
		                Thread.sleep(3000);
		                diHome.clickOnNewMessageTab();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(3000);
		                diHome.selectCallTakerUserFromMessagePopup();//
		                diHome.clickOnAddRecipientButtonOnMessagePopup();
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(2000);
		                diHome.enterMessageInMessageTextBox(data.get("Message"));//
		                diHome.clickOnSendButtonOnMessagePopup();
		                diHome.clearAllMessagesInMessagepopup();
		                home.allErrorAlerts();
		                openURLInNewWindow("https://qaautoap1.national.aaa.com:8443/D3Calls/login.jsp");
		                switchToWindow();
		                login.login(data.get("CrLoginName"), data.get("CrPassword"));
		                Thread.sleep(5000);
		                click(DIHomePage.lnkMessagePopup, "Message popup link");
		                String crMessage = diHome.verifyMessageSentAndViewedByRecipient();
		                assertTrue(crMessage.equalsIgnoreCase(data.get("Message")), "Message Received and viewed");
		                diHome.clearAllMessagesInMessagepopup();
		                home.allErrorAlerts();
		                home.verifyandClickLogout();
		                acceptAlert();
		                acceptAlert();
		                closeWindow();
		                switchToWindow();
		                Thread.sleep(3000);
		                diHome.clickOnNewMessageTab();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(3000);
		                diHome.clickOnGropsRadioButtonOnMessagePopup();
		                boolean listOfgroups = diHome.verifyListOfUsersOnAddressBook();
		                assertTrue(listOfgroups, "List of Groups Are Displayed");
		                diHome.clickOnExpandOptionFromGroup();
		                diHome.clickOnAddRecipientButtonOnMessagePopup();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(3000);
		                diHome.verifyGroupAddedToRecipient();
		                diHome.removeRecipientFormMessagePopUp();
		                diHome.clickOnAddressBookTab();
		                diHome.selectGroupFromMessagePopup();
		                diHome.clickOnAddRecipientButtonOnMessagePopup();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(3000);
		                diHome.verifyGroupAddedToRecipient();
		                diHome.enterMessageInMessageTextBox(data.get("Message"));
		                diHome.clickOnSendButtonOnMessagePopup();
		                boolean messagetab = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
		                assertTrue(messagetab, "New Message Window Closed And Message Window In Focus");
		                Thread.sleep(4000);
		                diHome.clickOnNewMessageTab();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();//
		                Thread.sleep(3000);
		                diHome.selectDispatchUserFromMessagePopup();
		                Thread.sleep(2000);
		                diHome.clickOnAddRecipientButtonOnMessagePopup();
		                Thread.sleep(2000);//
		                diHome.clickOnAddressBookTab();//
		                Thread.sleep(2000);
		                diHome.enterMessageInMessageTextBox(data.get("Message"));
		                diHome.clickOnSendButtonOnMessagePopup();
		                Thread.sleep(30000);
		                diHome.clickOnCheckForReplyingMessage();
		                diHome.clickOnreplybuttonOnMessagePopup();
		                diHome.enterMessageInMessageTextBox(data.get("Message"));
		                diHome.clickOnSendButtonOnMessagePopup();
		                Thread.sleep(20000);
		                diHome.verifyMessageSentAndViewedByRecipient();
		                Thread.sleep(20000);
		                diHome.clearAllMessagesInMessagepopup();
		                home.allErrorAlerts();
		                boolean noMessages = diHome.verifyNoMessagesOnMessagePopup();
		                assertTrue(noMessages, "No messages are Available");
		                diHome.logOut();
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1603",ReportStatus.strMethodName,intCounter,browser);
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
    public void diMessagesOnPoppedoutWindow(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIMessages", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIMessages", TestData, "D3Dispatch",intCounter);
    	
		                this.reporter.initTestCaseDescription("1603:DIMessages"+ " From Iteration " + StartRow + " to " + EndRow );
		                reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
		                DIHomeLib diHome = new DIHomeLib();
		                DILoginLib diLogin = new DILoginLib();
		                LoginLib login = new LoginLib();
		                CRHomeLib home = new CRHomeLib();
		                LoginRoleLib loginRole = new LoginRoleLib();
		
		                navigateToApplication("DI");
		                login.login(data.get("LoginNameForDI"), data.get("PasswordForDI"));
		                loginRole.clickOnProceedBtnInDispatchRoleLogin();
		                diLogin.waitcloseAllBusyIcons();
		                diHome.clickOnCloseIconOnQueueSelection();
		                diHome.verifyMessagePopUpOnDispatchHomepage();
		                diHome.popOutAndPopInMessagePopUpWindow();
		                Thread.sleep(5000);
		                switchToWindow();
		                Thread.sleep(3000);
		                diHome.clickOnNewMessageTab();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                boolean listOfusers = diHome.verifyListOfUsersOnAddressBook();
		                assertTrue(listOfusers, "List of Users Are Displayed");
		                boolean userButton = diHome.verifyUserButtonIsHighligted();
		                assertTrue(userButton, "User button is Highlighted");
		                diHome.selectCallTakerUserFromMessagePopup();
		                diHome.clickOnAddRecipientButtonOnMessagePopup();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(2000);
		                diHome.clickOnSendButtonOnMessagePopup();
		                boolean Error = diHome.verifyMessageTextFieldturnsRed();
		                assertTrue(Error, "Message field turns into red");
		                String countbefore = diHome.getCharacterslimitCount();
		                diHome.enterMessageInMessageTextBox(data.get("Message"));
		                String countAfter = diHome.getCharacterslimitCount();
		                int count = Integer.parseInt(countbefore) - data.get("Message").length();
		                String countLimit = Integer.toString(count);
		                assertTrue(countAfter.equalsIgnoreCase(countLimit), "Verified message window displays an indication showing limit of characters");
		                diHome.clickOnSendButtonOnMessagePopup();
		                boolean messageWindow = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
		                assertTrue(messageWindow, "New Message Window Closed And Message Window In Focus");
		                Thread.sleep(3000);
		                diHome.clickOnNewMessageTab();
		                Thread.sleep(5000);
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(3000);
		                diHome.selectDispatchUserFromMessagePopup();
		                diHome.clickOnAddRecipientButtonOnMessagePopup();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                diHome.enterMessageInMessageTextBox(data.get("Message"));
		                diHome.clickOnSendButtonOnMessagePopup();
		                Thread.sleep(15000);
		                String message = diHome.verifyMessageSentAndViewedByRecipient();
		                assertTrue(message.equalsIgnoreCase(data.get("Message")), "Message Received and viewed");
		                Thread.sleep(3000);
		                diHome.clickOnNewMessageTab();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(3000);
		                diHome.selectCallTakerUserFromMessagePopup();//
		                diHome.clickOnAddRecipientButtonOnMessagePopup();
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(2000);
		                diHome.enterMessageInMessageTextBox(data.get("Message"));//
		                diHome.clickOnSendButtonOnMessagePopup();
		                diHome.clearAllMessagesInMessagepopup();
		                home.allErrorAlerts();
		                diHome.popOutAndPopInMessagePopUpWindow();
		                Thread.sleep(8000);
		                switchToWindow();
		                openURLInNewWindow("https://qaautoap1.national.aaa.com:8443/D3Calls/login.jsp");
		                switchToWindow();
		                login.login(data.get("CrLoginName"), data.get("CrPassword"));
		                Thread.sleep(5000);
		                click(DIHomePage.lnkMessagePopup, "Message popup link");
		                String crMessage = diHome.verifyMessageSentAndViewedByRecipient();
		                assertTrue(crMessage.equalsIgnoreCase(data.get("Message")), "Message Received and viewed");
		                diHome.clearAllMessagesInMessagepopup();
		                home.allErrorAlerts();
		                home.verifyandClickLogout();
		                acceptAlert();
		                acceptAlert();
		                closeWindow();
		                switchToWindow();
		                Thread.sleep(3000);
		                diHome.popOutAndPopInMessagePopUpWindow();
		                Thread.sleep(5000);
		                switchToWindow();
		                Thread.sleep(3000);
		                diHome.clickOnNewMessageTab();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(3000);
		                diHome.clickOnGropsRadioButtonOnMessagePopup();
		                boolean listOfgroups = diHome.verifyListOfUsersOnAddressBook();
		                assertTrue(listOfgroups, "List of Groups Are Displayed");
		                diHome.clickOnExpandOptionFromGroup();
		                diHome.clickOnAddRecipientButtonOnMessagePopup();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(3000);
		                diHome.verifyGroupAddedToRecipient();
		                diHome.removeRecipientFormMessagePopUp();
		                diHome.clickOnAddressBookTab();
		                diHome.selectGroupFromMessagePopup();
		                diHome.clickOnAddRecipientButtonOnMessagePopup();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();
		                Thread.sleep(3000);
		                diHome.verifyGroupAddedToRecipient();
		                diHome.enterMessageInMessageTextBox(data.get("Message"));
		                diHome.clickOnSendButtonOnMessagePopup();
		                boolean messagetab = diHome.verifyNewMessageWindowClosedAndMessageWindowInFocus();
		                assertTrue(messagetab, "New Message Window Closed And Message Window In Focus");
		                Thread.sleep(4000);
		                diHome.clickOnNewMessageTab();
		                Thread.sleep(3000);
		                diHome.clickOnAddressBookTab();//
		                Thread.sleep(3000);
		                diHome.selectDispatchUserFromMessagePopup();
		                Thread.sleep(2000);
		                diHome.clickOnAddRecipientButtonOnMessagePopup();
		                Thread.sleep(2000);//
		                diHome.clickOnAddressBookTab();//
		                Thread.sleep(2000);
		                diHome.enterMessageInMessageTextBox(data.get("Message"));
		                diHome.clickOnSendButtonOnMessagePopup();
		                Thread.sleep(30000);
		                diHome.clickOnCheckForReplyingMessage();
		                diHome.clickOnreplybuttonOnMessagePopup();
		                diHome.enterMessageInMessageTextBox(data.get("Message"));
		                diHome.clickOnSendButtonOnMessagePopup();
		                Thread.sleep(20000);
		                diHome.verifyMessageSentAndViewedByRecipient();
		                Thread.sleep(20000);
		                diHome.clearAllMessagesInMessagepopup();
		                home.allErrorAlerts();
		                diHome.popOutAndPopInMessagePopUpWindow();
		                switchToWindow();
		                boolean noMessages = diHome.verifyNoMessagesOnMessagePopup();
		                assertTrue(noMessages, "No messages are Available");
		                diHome.logOut();
		                acceptAlert();
		                acceptAlert();
    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","1603",ReportStatus.strMethodName,intCounter,browser);
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


