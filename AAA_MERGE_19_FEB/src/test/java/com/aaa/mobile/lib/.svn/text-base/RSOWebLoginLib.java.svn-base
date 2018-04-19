package com.aaa.mobile.lib;

import java.util.Hashtable;

import com.aaa.accelerators.ActionEngine;

import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.page.RSOMembershipPage;
import com.aaa.mobile.page.RSOWebHomePage;
import com.aaa.mobile.page.RSOWebLoginPage;

public class RSOWebLoginLib extends ActionEngine  {

	
	
	
	/**
	 *methodName :: clickSignIn
	 *description:: click on signIn
	 *date :: 18-Dec-2017
	 * author :: E002490
	 *@param
	 * throws Throwable
	 */
   public void clickSignIn() throws Throwable {
	   Thread.sleep(5000);
		waitForVisibilityOfElement(RSOWebLoginPage.signIn, "signIn");
		click(RSOWebLoginPage.signIn, "click on signIn");
		
   } 

	 /**
	 *methodName :: enterUsername
	 *description:: enter the username
	 *date :: 15-Dec-2017
	 * author :: E002490
	 *@param
	 * throws Throwable
	 */
   public void enterUsername(String username) throws Throwable {
		waitForVisibilityOfElement(RSOWebLoginPage.userName, "username");
		getText(RSOWebLoginPage.userName, "username");
		click(RSOWebLoginPage.userName, "click on username");
		type(RSOWebLoginPage.userName,username, "type username");
		
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
  		waitForVisibilityOfElement(RSOWebLoginPage.password, "password");
  		getText(RSOWebLoginPage.password, "password");
  		click(RSOWebLoginPage.password, "click on password");
  		type(RSOWebLoginPage.password,password ,"type password");
  		
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
   		waitForVisibilityOfElement(RSOWebLoginPage.submit, "signIn");
   		click(RSOWebLoginPage.submit, "click on signIn");
   	
   		
      } 
      
      
      /**
    	 *methodName :: enterUsernamePasswordAndSignIn
    	 *description:: enter the Username and Password and click on SignIn
    	 *date :: 15-Dec-2017
    	 *author :: E002490
    	 *@param
    	 * throws Throwable
    	 */
       public void enterUsernamePasswordAndSignIn(String username,String password ) throws Throwable {
    	   enterUsername(username);
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
		    	waitForVisibilityOfElement(RSOWebLoginPage.userName,"club Login User Name");
		    	verifyClubLogin = isElementPresent(RSOWebLoginPage.userName,"club Login User Name", true);
				return verifyClubLogin;			
		}
}
