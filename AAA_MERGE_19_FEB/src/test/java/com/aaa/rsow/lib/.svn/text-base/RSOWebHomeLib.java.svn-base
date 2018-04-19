package com.aaa.rsow.lib;
import com.aaa.accelerators.ActionEngine;
import com.aaa.rsow.page.RSOWebHomePage;

public class RSOWebHomeLib extends ActionEngine {

		
	 /**
	 *methodName :: enterClubCode
	 *description:: enter the Club Code
	 *date :: 15-Dec-2017
	 *author :: E002490
	 *@param
	 * throws Throwable
	  */
    public void enterClubCode(String clubCode) throws Throwable {
		try {
		System.out.println("");
			waitForVisibilityOfElement(RSOWebHomePage.txtClubCode, "club code");
			//click(RSOWebHomePage.txtClubCode, "club code");
			type(RSOWebHomePage.txtClubCode, clubCode, "club code");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
			waitForVisibilityOfElement(RSOWebHomePage.btnGoButton, "go button");
			click(RSOWebHomePage.btnGoButton, "go button");		
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
		    	waitForVisibilityOfElement(RSOWebHomePage.lnkSignOut,"signOut");
		    	click(RSOWebHomePage.lnkSignOut,"signOut");
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
				boolean giftMembershipPopupClose = isVisibleOnly(RSOWebHomePage.iconGiftMembershiPopCrossMark, "popCrossMark");
				  if(giftMembershipPopupClose)
					{
						assertTrue(giftMembershipPopupClose, "Close button of giftMembership Popup appeared");
						click(RSOWebHomePage.iconGiftMembershiPopCrossMark, "click on popCrossMark");
					}else
					{
						assertFalse(giftMembershipPopupClose, "Close button not appeared");
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
				boolean feedbackPopupClose = isVisibleOnly(RSOWebHomePage.iconFeedbackPopClose, "popCrossMark");
			  if(feedbackPopupClose)
				{
					assertTrue(feedbackPopupClose, "Close button of Feedback Popup appeared");
					click(RSOWebHomePage.iconFeedbackPopClose, "click on Feedback popCrossMark");
				}else
				{
					assertFalse(feedbackPopupClose, "Close button of Feedback Popup not appeared");
				}
		  } 
	    
		  
		  /**
			 *methodName :: clearBrowserCookies
			 *description::  clear Browser Cookies
			 *date :: 22-Dec-2017
			 *author :: E002490
			 *@param
			 * throws Throwable
			 */	
			    public void clearBrowserCookies() throws Throwable {
			    	 driver.manage().deleteAllCookies();
		                this. reporter.SuccessReport("Clear all browser cookies and cache", "All browser cookies and cache cleared successfully");
			}
}
