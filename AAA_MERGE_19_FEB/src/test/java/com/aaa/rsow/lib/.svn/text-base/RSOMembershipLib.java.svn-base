package com.aaa.rsow.lib;

import java.util.Hashtable;
import com.aaa.accelerators.ActionEngine;
import com.aaa.rsow.page.RSOMembershipPage;

public class RSOMembershipLib extends ActionEngine{
	
	
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
		    	waitForVisibilityOfElement(RSOMembershipPage.imgMembershipCard,"membershipcard");
		    	verifyMembershipCard = isElementPresent(RSOMembershipPage.imgMembershipCard,"membershipcard", true);
				return verifyMembershipCard;			
		}		
}
