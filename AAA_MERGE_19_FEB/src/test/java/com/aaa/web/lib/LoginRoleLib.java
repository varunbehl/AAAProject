package com.aaa.web.lib;


import com.aaa.web.page.LoginRolePage;
import com.aaa.accelerators.ActionEngine;

public class LoginRoleLib extends ActionEngine {

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: selectRoleInDispatch
	 * description :: This is used to select the role from dropdown
	 * date :: 07-Dec-2017
	 * author :: Chandrasekhar Dendukuri
	 */

    public void selectRoleInDispatch(String role) throws Throwable {
    	//wait for Login Role to be displayed
		waitForVisibilityOfElement(LoginRolePage.txtLoginRole, "Login Role");
		//enter Login Role details
		type(LoginRolePage.txtLoginRole,role, "Role in Dispatch");
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnProceedBtnInDispatchRoleLogin
	 * description :: This is used to click on proceed button
	 * date :: 07-Dec-2017
	 * author :: Chandrasekhar Dendukuri
	 */

	public void clickOnProceedBtnInDispatchRoleLogin() throws Throwable {
		//wait for proceed login button to be displayed
		waitForVisibilityOfElement(LoginRolePage.btnProceedLogin, "Proceed to Login");
		//click on proceed login button
		click(LoginRolePage.btnProceedLogin, "Proceed button ");
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: selectRoleAndProceed
	 * description :: This is used to complete role section
	 * date :: 07-Dec-2017
	 * author :: Chandrasekhar Dendukuri
	 */
	public void selectRoleAndProceed(String role) throws Throwable {
		selectRoleInDispatch(role);
		clickOnProceedBtnInDispatchRoleLogin();
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: roleSelection Method
	 * description :: roleSelection Method
	 * date :: 07-Dec-2017
	 * author :: Chandu Dendukuri
	 */

	public void roleSelection(String role) throws Throwable {
		selectRoleInDispatch(role);
        verifyLocationField();
        verifyBackToLoginButton();
        clickOnProceedBtnInDispatchRoleLogin();
	}
	 /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyLocationField
     * description :: to verify location field availablity
     * date :: 07-Dec-2017
     * author :: Chandu Dendukuri*/

    public void verifyLocationField() throws Throwable {
        boolean locationPresence = isVisibleOnly(LoginRolePage.txtLocation, "Login Role");
/*        if (locationPresence) {
            assertTrue(locationPresence, "Role field is available");

        } else {
            assertFalse(locationPresence, "Role Field is not available");
        }*/
        assertTrue(locationPresence, "Role field is available");
    }
   /* *
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyBackToLoginButton
     * description :: verifyBackToLoginButton
     * date :: 07-Dec-2017
     * author :: Chandu Dendukuri
*/
    public void verifyBackToLoginButton() throws Throwable {
        //wait for proceed login button to be displayed
       boolean backToLogin = isVisibleOnly(LoginRolePage.btnBackToLogin, "Back to Login button");

/*        if(backToLogin)
        {
            assertTrue(backToLogin,"Back to Login Button available");

        }else
        {
            assertFalse(backToLogin,"Back to Login button is not available");
        }*/
       assertTrue(backToLogin,"Back to Login Button available");
    }
}