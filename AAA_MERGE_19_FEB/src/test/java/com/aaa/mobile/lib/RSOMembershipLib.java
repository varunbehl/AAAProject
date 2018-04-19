package com.aaa.mobile.lib;

import java.util.Hashtable;


import com.aaa.accelerators.ActionEngineMobile;
import com.aaa.mobile.page.RSOMembershipPage;

public class RSOMembershipLib extends ActionEngineMobile{
	
	
	  /**
		 *methodName :: verifyMembershipCard
		 *description:: Verify the Membership Card
		 *date :: 18-Dec-2017
		 *author :: E002490
		 *@param
		 * throws Throwable
		 */	
		    public boolean verifyMembershipCard() throws Throwable {
		    	boolean verifyMembershipCard = false;
		    	waitForVisibilityOfElement(RSOMembershipPage.membershipCard,"membershipcard");
		    	verifyMembershipCard = isElementPresent(RSOMembershipPage.membershipCard,"membershipcard", true);
				return verifyMembershipCard;			
		}		
}
