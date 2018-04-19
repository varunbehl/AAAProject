package com.aaa.rsow.lib;

import java.util.Hashtable;

import com.aaa.accelerators.ActionEngine;
import com.aaa.rsow.page.RSOMembershipPage;
import com.aaa.rsow.page.RSOWebHomePage;
import com.aaa.rsow.page.RSOWebLoginPage;

public class RSOWebLoginLib extends RSOWebHomeLib  {

	
	
	
	/**
	 *methodName :: clickSignIn
	 *description:: click on signIn
	 *date :: 18-Dec-2017
	 * author :: E002490
	 *@param
	 * throws Throwable
	 */
   public void clickSignIn() throws Throwable {
		waitForVisibilityOfElement(RSOWebLoginPage.lnkSignIn, "signIn");
		clickFeedbackPopUpCross();
		click(RSOWebLoginPage.lnkSignIn, "click on signIn");
		
		
   } 

	 /**
	 *methodName :: enterUsername
	 *description:: enter the username
	 *date :: 15-Dec-2017
	 * author :: E002490
	 *@param
	 * throws Throwable
	 */
   public void enterUserName(String username) throws Throwable {
		waitForVisibilityOfElement(RSOWebLoginPage.txtUserName, "username");
		click(RSOWebLoginPage.txtUserName, "click on username");
		type(RSOWebLoginPage.txtUserName,username, "type username");
		
   } 
   
   /**
  	 *methodName :: enterPassword
  	 *description:: enter the Password
  	 *date :: 15-Dec-2017
  	 *author :: E002490
  	 *@param
  	 * throws Throwable
  	 */
     public void enterPassword(String password) throws Throwable {
  		waitForVisibilityOfElement(RSOWebLoginPage.txtPassword, "password");
  		click(RSOWebLoginPage.txtPassword, "click on password");
  		type(RSOWebLoginPage.txtPassword,password ,"type password");
  		
     } 
     
     /**
   	 *methodName :: clickSubmit
   	 *description:: click on SignIn button
   	 *date :: 15-Dec-2017
   	 *author :: E002490
   	 *@param
   	 * throws Throwable
   	 */
      public void clickSubmit() throws Throwable {
   		waitForVisibilityOfElement(RSOWebLoginPage.btnSubmit, "signIn");
   		click(RSOWebLoginPage.btnSubmit, "click on signIn");
   	
   		
      } 
      
      
      /**
    	 *methodName :: enterUsernamePasswordAndSignIn
    	 *description:: enter the Username and Password and click on SignIn
    	 *date :: 15-Dec-2017
    	 *author :: E002490
    	 *@param
    	 * throws Throwable
    	 */
       public void enterUserNamePasswordAndSignIn(String username,String password ) throws Throwable {
    	   enterUserName(username);
    	   enterPassword(password);
    	   clickSubmit();
       } 
       
       /**
		 *methodName :: verifyClubLogin
		 *description:: Verify the Club Login page
		 *date :: 18-Dec-2017
		 *author :: E002490
		 *@param
		 * throws Throwable
		 */	
		    public boolean verifyClubLogin() throws Throwable {
		    	boolean verifyClubLogin = false;
		    	waitForVisibilityOfElement(RSOWebLoginPage.clubLogin,"club Login Page");
		    	verifyClubLogin = isElementPresent(RSOWebLoginPage.clubLogin,"club Login Page", true);
				return verifyClubLogin;			
		}
}
