package com.aaa.mobile.lib;

import java.util.Hashtable;




import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.accelerators.AppiumActionEngine;
import com.aaa.mobile.page.RSOMembershipPage;
import com.aaa.mobile.page.RSOWebHomePage;
import com.aaa.mobile.page.RSOWebLoginPage;

public class RSOWebHomeLib extends ActionEngine  {

		
	 /**
	 *methodName :: enterClubCode
	 *description:: enter the Club Code
	 *date :: 15-Dec-2017
	 *author :: E002490
	 *@param
	 * throws Throwable
	  */
    public void enterClubCode(String clubCode) throws Throwable {
		waitForVisibilityOfElement(RSOWebHomePage.clubCode, "club code");
		getText(RSOWebHomePage.clubCode, "club code");
		click(RSOWebHomePage.clubCode, "club code");
		type(RSOWebHomePage.clubCode, clubCode, "club code");
		
    }
		
		
    /**
	 *methodName :: clickOnGo
	 *description:: click on go
	 *date :: 15-Dec-2017
	 *author :: E002490
	 *@param
	 * throws Throwable
	 */	
	    public void clickOnGo() throws Throwable {
			waitForVisibilityOfElement(RSOWebHomePage.goButton, "go button");
			click(RSOWebHomePage.goButton, "go button");		
	}
	
	    /**
		 *methodName :: enterClubCodeAndClickGo
		 *description:: enter the club code and click on go
		 *date :: 15-Dec-2017
		 *author :: E002490
		 *@param
		 * throws Throwable
		 */	
		public void enterClubCodeAndClickGo(String clubCode) throws Throwable {
			enterClubCode(clubCode);
			clickOnGo();
			
		}
		
		  /**
		 *methodName :: clickSignOut
		 *description:: click on Sign Out
		 *date :: 18-Dec-2017
		 *author :: E002490
		 *@param
		 * throws Throwable
		 */	
		    public void clickSignOut() throws Throwable {
		    	waitForVisibilityOfElement(RSOWebHomePage.signOut,"signOut");
		    	click(RSOWebHomePage.signOut,"signOut");
		}
		    
		    /**
			 *methodName :: clickGiftMembershipPopUpCross
			 *description:: click on pop cross mark
			 *date :: 18-Dec-2017
			 * author :: E002490
			 *@param
			 * throws Throwable
			 */
		  public void clickGiftMembershipPopUpCross() throws Throwable {
				if(isVisibleOnly(RSOWebHomePage.giftMembershiPopCrossMark, "popCrossMark"))
				{
					click(RSOWebHomePage.giftMembershiPopCrossMark, "click on popCrossMark");
				}
		  } 
		  
		  /**
			 *methodName :: clickFeedbackPopUpCross
			 *description:: click on pop cross mark
			 *date :: 19-Dec-2017
			 * author :: E002490
			 *@param
			 * throws Throwable
			 */
		  public void clickFeedbackPopUpCross() throws Throwable {
				if(isVisibleOnly(RSOWebHomePage.feedbackPopCrossMark, "popCrossMark"))
				{
					click(RSOWebHomePage.feedbackPopCrossMark, "click on popCrossMark");
				}
		  } 
	    
}
