package com.aaa.web.lib;

import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.CRMemberSearchPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Hashtable;
import java.util.List;

/**
 * Created by E001133 on 27-11-2017.
 */
public class CRMemberSearchLib extends LoginLib {
    List<WebElement> callList = null;

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberNumberCol
     * description :: Getting member number coloum values to compare the results with expected value
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberNumberCol(String memberSearch) throws Throwable {

        String memNum = getText(CRMemberSearchPage.lblMemberNumberColumnValue, "Member number");//Getting the First product
        assertTrue(memNum.contains(memberSearch), memNum + " Given details Search Results are same");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberNumberCol
     * description :: Getting member number coloum values to compare the results with expected value
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberNumClick() throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.lblMemberNumberColumnValue, "Member Number");
        click(CRMemberSearchPage.lblMemberNumberColumnValue, "Member Number");
        Thread.sleep(3000);
        boolean alertCloseVisibility = isVisibleOnly(CRMemberSearchPage.alertClose, "Close Alert");
        if (alertCloseVisibility) {
            mouseDoubleClick(CRMemberSearchPage.alertClose, "Close Alert");
        }
        //waitForVisibilityOfElement(CRMemberSearchPage.alertClose, "Close Alert");
        // mouseDoubleClick(CRMemberSearchPage.alertClose, "Close Alert");
        boolean scriptErrorAvailablity = isVisibleOnly(CRMemberSearchPage.scriptError, "Script Error OKAY button");
        if (scriptErrorAvailablity) {
            click(CRMemberSearchPage.scriptError, "Script error Okay button");
        }


    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: lblMemberNameColumnValue
     * description :: Getting member number coloum values to compare the results with expected value
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void memberNameCol(String memberSearch) throws Throwable {

        String name = getText(CRMemberSearchPage.lblMemberNameColumnValue, "Member Name");//Getting the First product
        assertTrue(name.contains(memberSearch), name + " Given details Search Results are same");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: membernameaddressCol
     * description :: Member nameaddress
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void membernameaddressCol(String memberSearch) throws Throwable {

        String name1 = getText(CRMemberSearchPage.lblMemberNameColumnValue, "Member Name");//Getting the First product
        String address = getText(CRMemberSearchPage.lblMemberAddressColumnValue, "Address");
        String inputvalues[] = memberSearch.split(", ");
        String nameInput = inputvalues[0].toUpperCase();
        String addressInput = inputvalues[1];
        String nameaddress = name1.concat(address);
        assertTrue(nameaddress.contains(nameInput), nameInput + " :is found in results ");
        assertTrue(nameaddress.contains(addressInput), addressInput + " :is found in results ");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberEmailCol
     * description :: Member Email Col
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberEmailCol(String membersearch) throws Throwable {
        String email = getText(CRMemberSearchPage.lblMemberContactColumnValue, "Email");//Getting the First product
        assertTrue(email.contains(membersearch), email + " Given details Search Results are same");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberPhoneCol
     * description :: Member Name Search
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberPhoneCol(String memberSearch) throws Throwable {
        String phone = getText(CRMemberSearchPage.lblMemberContactColumnValue, "Phone");//Getting the First product
        assertTrue(phone.contains(memberSearch), phone + " :is found in results ");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: CurrentCallClose
     * description :: Member Name Search
     * date :: 05-Dec-2017
     * author :: chandu
     */
    //This should be used to handle current calls popup after clicking on the member number details
    public void currentCallClose() throws Throwable {
        boolean flagCurrentCallClose = isVisibleOnly(CRMemberSearchPage.iconcurrentcallClose, "Current call close");
        if (flagCurrentCallClose) {
            //waitForVisibilityOfElement(CRMemberSearchPage.iconcurrentcallClose,"Current call popup");
            click(CRMemberSearchPage.iconcurrentcallClose, "Current call popup closed");
        }
        boolean flagScriptError = isVisibleOnly(CRMemberSearchPage.scriptError, "Script Error OKAY button");
        if (flagScriptError) {
            //waitForVisibilityOfElement(CRMemberSearchPage.scriptError,"Script error Okay button");
            click(CRMemberSearchPage.scriptError, "Script error Okay button");
        } else {
            String combineKeys2 = Keys.chord(Keys.SPACE);
            sendKeys(combineKeys2, "SPACE");
        }


    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberDetailsVerification
     * description :: memberDetailsVerification
     * date :: 30-Nov-2017
     * author :: chandu
     */
    public void memberFirstNameVerification() throws Throwable {

        String FirstName = getText(CRMemberSearchPage.lblMemberFirstName, "Member First Name");
        assertTrue(FirstName != null, FirstName + " :is the Member First Name");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberDetailsVerification
     * description :: memberDetailsVerification
     * date :: 30-Nov-2017
     * author :: chandu
     */
    public String memberLastNameVerification() throws Throwable {

        String lastName = getText(CRMemberSearchPage.lblMemberLastName, "Member Last Name");
        assertTrue(lastName != null, lastName + " :is the Member Last Name");
    return lastName;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberNumberVerification
     * description :: memberNumberVerification
     * date :: 30-Nov-2017
     * author :: chandu
     */
    public void memberNumberVerification() throws Throwable {

        String memberNumber = getText(CRMemberSearchPage.lblMemberNumberTxt, "Member number");
        assertTrue(memberNumber != null, memberNumber + " :is the Member number");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberZipVerification
     * description :: memberZipVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberZipVerification() throws Throwable {

        String zip = getText(CRMemberSearchPage.lblMemberZipCode, "Member zip");
        assertTrue(zip != null, zip + " :is the Member zip");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberCityVerification
     * description :: memberCityVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberCityVerification() throws Throwable {

        String city = getText(CRMemberSearchPage.lblMemberCity, "Member City");
        assertTrue(city != null, city + " :is the Member City");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberStateVerification
     * description :: memberStateVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberStateVerification() throws Throwable {

        String state = getText(CRMemberSearchPage.lblMemberState, "Member State");
        assertTrue(state != null, state + " :is the Member State");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberSinceVerification
     * description :: memberSinceVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberSinceVerification() throws Throwable {

        String since = getText(CRMemberSearchPage.lblMemberSince, "Member Since");
        assertTrue(since != null, since + " :is the Member Since");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberLevelVerification
     * description :: memberLevelVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public String memberLevelVerification() throws Throwable {
        String level = getText(CRMemberSearchPage.lblMemberLevel, "Member level");
        assertTrue(level != null, level + " :is the Member Level");
        return level;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberTypeVerification
     * description :: memberTypeVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberTypeVerification() throws Throwable {

        String type = getText(CRMemberSearchPage.lblMemberType, "Member type");
        assertTrue(type != null, type + " :is the Member type");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberExpirationVerification
     * description :: memberExpirationVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberExpirationVerification() throws Throwable {

        String expiration = getText(CRMemberSearchPage.lblMemberExpiration, "Member Expiration");
        assertTrue(expiration != null, expiration + " :is the Member Expiration");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberStatusVerification
     * description :: memberStatusVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberStatusVerification() throws Throwable {

        String status = getText(CRMemberSearchPage.lblMemberStatus, "Member Status");
        assertTrue(status != null, status + " :is the Member Status");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberEmailVerification
     * description :: memberEmailVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberEmailVerification() throws Throwable {

        String email = getAttributeValue(CRMemberSearchPage.txtMemberEmailId, "Member email");
        assertTrue(email != null, email + " :is the Member email");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: errorNotification
     * description :: checkingFor error notification
     * date :: 11-Dec-2017
     * author :: Chandrasekhar
     */
    public void errorNotificationPresence() throws Throwable {


        boolean errorNotification = isVisibleOnly(CRMemberSearchPage.errorNotification, "Error Notification");
        assertTrue(errorNotification, "Error Notification appeared");
    }

    public void emptySearchResults() throws Throwable {

        String results = getText(CRMemberSearchPage.emptyResults, "Empty Search Results");//Getting the First product
        boolean emptySearchResult = isVisibleOnly(CRMemberSearchPage.emptyResults, "Empty Search Results");
        assertTrue(emptySearchResult, results + "Details not found");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberPhoneVerification
     * description :: memberPhoneVerification
     * date :: 05-Dec-2017
     * author :: chandu
     */
    public void memberPhoneVerification() throws Throwable {

        String phone = getAttributeValue(CRMemberSearchPage.txtMemberPhone, "Member Phone");
        assertTrue(phone != null, phone + " :is the Member Phone");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: waitcloseAllBusyIconsResults
     * description :: Application loading wait for memberseatch results
     * date :: 29-Nov-2017
     * author :: chandu
     */
    public void waitcloseAllBusyIconsResults() throws Throwable {
        int iCounter = 0, loading;
        boolean status = true;
        do {
            iCounter++;
            loading = getElementsSize(CRMemberSearchPage.iconResultLoadingSpinner);
            if (loading == 0) {
                status = true;
                break;
            } else {
                status = false;
                LOG.info("iCounter appearStatus " + iCounter);
            }
            if (iCounter > 1000) {
                status = false;
                break;
            }
        }
        while (iCounter <= 1000);
        if (status) {
            LOG.info("All spinners are closed");
        } else {
            LOG.info("All spinners are not closed");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memFieldsVerification
     * description :: To Verify All mandatory Fields on member Page
     * date :: 29-Nov-2017
     * author :: chandu
     */

    public void memFieldsVerification() throws Throwable {

        verifyClubCode();
        verifyFirstName();
        verifyLastName();
        verifyaddressline1();
        verifyaddressline2();
        verifyCity();
        verifyState();
        verifyZip();
        verifyMemberSience();
        verifyMemberNumber();
        verifyMemberlevel();
        verifyMemberexpiration();
        verifyMemberStatus();
        verifyMemberPrimPhone();
        //verifyMemberPhone1();
        //verifyMemberPhone2();
        verifyMemberPhoneType();
        verifyPrimaryPhoneRadioButton();
    }

    public void cleanAndSaveMemberDetails(String firstName, String lastName, String address, String city, String state, String zipCode, String email, String phoneNumber, String phoneType, String memberNumber, String memberLevel, String expiration, String status) throws Throwable {
        clearMemberMandatoryFields();
        enterMemberMandatoryFields(firstName, lastName, address, city, state, zipCode, email, phoneNumber, phoneType, memberNumber, memberLevel, expiration, status);
    }

    public void verifyClubCode() throws Throwable {
        boolean flagclubcode = isVisibleOnly(CRMemberSearchPage.clubCode, "clubCode");
        assertTrue(flagclubcode, "clubCode is verified and it is a mandatory field ");
        if (flagclubcode) {
            String clubCode = getText(CRMemberSearchPage.clubCode, "Retrieved Club code is ");   
        }

    }

    public void verifyFirstName() throws Throwable {
        boolean flagFName = isVisibleOnly(CRMemberSearchPage.txtFirstName, "Firest Name");
        assertTrue(flagFName, "Firest Name is Mandatory Field");
    }

    public void verifyLastName() throws Throwable {
        boolean flagLName = isVisibleOnly(CRMemberSearchPage.txtLastName, "Last Name");
        assertTrue(flagLName, "Last Name is Mandatory Field");
    }

    public void verifyaddressline1() throws Throwable {
        boolean flagAddress = isVisibleOnly(CRMemberSearchPage.txtAddressLine1, "Address");
        
            assertTrue(flagAddress, "Address is Mandatory Field");
        
    }

    public void verifyaddressline2() throws Throwable {
        boolean flagAddress = isVisibleOnly(CRMemberSearchPage.txtAddressLine2, "Address2");
        
            assertTrue(flagAddress, "Address2 is Mandatory Field");
        
    }

    public void verifyCity() throws Throwable {
        boolean flagCity = isVisibleOnly(CRMemberSearchPage.txtCity, "City");
        
            assertTrue(flagCity, "City is Mandatory Field");
        
    }

    public void verifyMemberSience() throws Throwable {
        boolean flagCity = isVisibleOnly(CRMemberSearchPage.txtMbrSince, "Member Sience");
        
            assertTrue(flagCity, "MemberSience is Mandatory Field");
        
    }

    public void verifyState() throws Throwable {
        boolean flagState = isVisibleOnly(CRMemberSearchPage.txtState, "State");
        
            assertTrue(flagState, "State is Mandatory Field");
        
    }

    public void verifyZip() throws Throwable {
        boolean flagzip = isVisibleOnly(CRMemberSearchPage.txtZip, "ZipCode");
        
            assertTrue(flagzip, "ZipCode is Mandatory Field");
        
    }

    public void verifyMemberNumber() throws Throwable {
        boolean Membernumber = isVisibleOnly(CRMemberSearchPage.txtMemberNumber, "Membernumber");
        
            assertTrue(Membernumber, "Membernumber is Mandatory Field");
        
    }

    public void verifyMemberlevel() throws Throwable {
        boolean flagMemberlevel = isVisibleOnly(CRMemberSearchPage.txtMemberLevel, "Memberlevel");
        
            assertTrue(flagMemberlevel, "Memberlevel is Mandatory Field");
        
    }

    public void verifyMemberexpiration() throws Throwable {
        boolean flagexpiration = isVisibleOnly(CRMemberSearchPage.txtMemberExpiration, "Memberexpiration");
        
            assertTrue(flagexpiration, "Memberexpiration is Mandatory Field");
        
    }

    public void verifyMemberStatus() throws Throwable {
        boolean flagstatus = isVisibleOnly(CRMemberSearchPage.txtMemberStatus, "status");
        
            assertTrue(flagstatus, "status is Mandatory Field");
        
    }

    public void verifyMemberPrimPhone() throws Throwable {
        boolean flagph = isVisibleOnly(CRMemberSearchPage.txtPhone_NumberFirstRow, "txtphone_number");
        
            assertTrue(flagph, "txtphone_number is Mandatory Field");
        
    }

    public void verifyMemberPhone1() throws Throwable {
        boolean txtphone_number1 = isVisibleOnly(CRMemberSearchPage.txtPhone_NumberSecondRow, "txtphone_number1");
        
            assertTrue(txtphone_number1, "txtphone_number1 is Mandatory Field");
        
    }

    public void verifyMemberPhone2() throws Throwable {
        boolean txtphone_number2 = isVisibleOnly(CRMemberSearchPage.txtPhone_NumberThirdRow, "txtphone_number2");
        
            assertTrue(txtphone_number2, "txtphone_number2 is Mandatory Field");
        
    }

    public void verifyMemberPhoneType() throws Throwable {
        boolean phoneType = isVisibleOnly(CRMemberSearchPage.txtPhoneType, "phoneType");
        
            assertTrue(phoneType, "phoneType is Mandatory Field");
        
    }

    public void verifyPrimaryPhoneRadioButton() throws Throwable {
        boolean phoneType = isVisibleOnly(CRMemberSearchPage.rbutnprimary_phone, "Primary Phone Radio Button Is a Mandatory Field");
        
            assertTrue(phoneType, "Primary Phone Radio Button Is a Mandatory Field");
        
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearMemMandatoryFields
     * description :: To Clear all mandatory Fields on memberTab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clearMemberMandatoryFields() throws Throwable {
        clearData(CRMemberSearchPage.txtFirstName);
        clearData(CRMemberSearchPage.txtLastName);
        clearData(CRMemberSearchPage.txtAddressLine1);
        clearData(CRMemberSearchPage.txtCity);
        clearData(CRMemberSearchPage.txtState);
        clearData(CRMemberSearchPage.txtZip);
        clearData(CRMemberSearchPage.txtMemberNumber);
        clearData(CRMemberSearchPage.txtMemberLevel);
        clearData(CRMemberSearchPage.txtMemberExpiration);
        clearData(CRMemberSearchPage.txtMemberStatus);
        clearData(CRMemberSearchPage.txtPhone_NumberFirstRow);

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterMemberMandatoryFields
     * description :: To Enter all mandatory Fields on member
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterMemberMandatoryFields(String firstName, String lastName, String address, String city, String state, String zipCode, String email, String phoneNumber, String phoneType, String memberNumber, String memberLevel, String expiration, String status) throws Throwable {
        //Method to handile errors and Alerts
        errorAlertHandlingBeforeEnterMandatoryFields();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddressLine(address);
        enterCity(city);
        enterState(state);
        enterZip(zipCode);
        enterEmail(email);
        enterPhoneNumber(phoneNumber);
        selectType(phoneType);
        clickPrimRadioBtnRowOne();
        enterMemberNumber(memberNumber);
        enterMemberLevel(memberLevel);
        enterExpiration(expiration);
        enterStatus(status);

    }

    public void enterFirstName(String firstName) throws Throwable {
        clearData(CRMemberSearchPage.txtFirstName);
        type(CRMemberSearchPage.txtFirstName, firstName, "First Name");
    }

    public void enterLastName(String lastName) throws Throwable {
        clearData(CRMemberSearchPage.txtLastName);
        type(CRMemberSearchPage.txtLastName, lastName, "Last Name");
    }

    public void enterAddressLine(String address) throws Throwable {
        clearData(CRMemberSearchPage.txtAddressLine1);
        type(CRMemberSearchPage.txtAddressLine1, address, "Address");
    }

    public void enterCity(String city) throws Throwable {
        Thread.sleep(2000);
        clearData(CRMemberSearchPage.txtCity);
        type(CRMemberSearchPage.txtCity, city, "City");
        click(CRMemberSearchPage.txthonorific, "City");
    }

    public void enterState(String state) throws Throwable {
        clearData(CRMemberSearchPage.txtState);
        click(CRMemberSearchPage.txtState, "State");
        type(CRMemberSearchPage.txtState, state, "State");
        click(CRMemberSearchPage.txthonorific, "State");
    }

    public void enterZip(String zipCode) throws Throwable {
        clearData(CRMemberSearchPage.txtZip);
        type(CRMemberSearchPage.txtZip, zipCode, "Zip Code");
    }

    public void enterEmail(String email) throws Throwable {
        clearData(CRMemberSearchPage.txtEmail);
        type(CRMemberSearchPage.txtEmail, email, "Email");
    }

    public void enterPhoneNumber(String phoneNumber) throws Throwable {
        clearData(CRMemberSearchPage.txtPhone_NumberFirstRow);
        click(CRMemberSearchPage.txtPhone_NumberFirstRow, "PhoneNumber");
        type(CRMemberSearchPage.txtPhone_NumberFirstRow, phoneNumber, "PhoneNumber");
    }

    public void selectType(String phoneType) throws Throwable {
        click(CRMemberSearchPage.txtPhoneType, "Type");
        waitForVisibilityOfElement(CRMemberSearchPage.txtPhoneType, "PhoneType");
        selectByVisibleText(CRMemberSearchPage.txtPhoneType, phoneType, "PhoneType");
    }

    /**
     * Description:This method is used to click on row One prim radioButton
     *
     * @throws Throwable
     */
    public void clickPrimRadioBtnRowOne() throws Throwable {
        click(CRMemberSearchPage.radiodbtnPrimRowOne, "primary_phoneRadioButton ");
    }

    public void enterMemberNumber(String memberNumber) throws Throwable {
        clearData(CRMemberSearchPage.txtMemberNumber);
        type(CRMemberSearchPage.txtMemberNumber, memberNumber, "MemberNumber");
    }

    public void enterMemberLevel(String memberLevel) throws Throwable {
        clearData(CRMemberSearchPage.txtMemberLevel);
        type(CRMemberSearchPage.txtMemberLevel, memberLevel, "MemberLevel");
    }

    public void enterExpiration(String expiration) throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.txtMemberExpiration, "Expiration");
        // click(CRMemberSearchPage.txtMemberExpiration, "Expiration");
        clearData(CRMemberSearchPage.txtMemberExpiration);
        // type(CRMemberSearchPage.txtMemberExpiration, expiration, "Expiration");
        //errorAlertHandlingBeforeEnterMandatoryFields();
        type(CRMemberSearchPage.txtMemberExpiration, expiration, "Expiration");
        Thread.sleep(2000);
        errorAlertHandlingBeforeEnterMandatoryFields();
        //type(CRMemberSearchPage.txtMemberExpiration, expiration, "Expiration");
        click(CRMemberSearchPage.txtType, "Type");
        Thread.sleep(2000);
    }


    public void enterStatus(String status) throws Throwable {
        clearData(CRMemberSearchPage.txtMemberStatus);
        waitForVisibilityOfElement(CRMemberSearchPage.txtMemberStatus, "Status");
        type(CRMemberSearchPage.txtMemberStatus, status, "Status");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: errorAlertHandlingBeforeEnterMandatoryFields
     * description :: To Handle Errors and Alerts Before enter Fields
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void
    errorAlertHandlingBeforeEnterMandatoryFields() throws Throwable {
        //Error Handling IN Member Page
        boolean flagErrorAlertOkButton = isVisibleOnly(CRMemberSearchPage.errorAlertOK, "Error Alert OK button");
        
        if (flagErrorAlertOkButton) {
            //assertTrue(flagErrorAlertOkButton, "Error Alert OK Button");
            click(CRMemberSearchPage.errorAlertOK, "Error Alert OK Button");

        } /*else {
            assertFalse(flagErrorAlertOkButton, "Error Alert OK Button is Not Present");

        }*/
        boolean flagCRMembersearchpageScriptError = isVisibleOnly(CRMemberSearchPage.scriptError, "CRMembersearchpag.scriptError");
        //assertTrue(flagCRMembersearchpageScriptError, "Script error Okay button");
        if (flagCRMembersearchpageScriptError) {
           // assertTrue(flagCRMembersearchpageScriptError, "Script error Okay button");
            JSClick(CRMemberSearchPage.scriptError, "Script error Okay button");
        }/* else {
            assertFalse(flagCRMembersearchpageScriptError, "CRMembersearchpag.scriptError is not present");
        }*/
        boolean flagConfirmationokaybutton = isVisibleOnly(CRMemberSearchPage.btnAlertSaveYes, "Confirmation okay button");
        //assertTrue(flagConfirmationokaybutton, "Confirmation Okay button");
           if (flagConfirmationokaybutton) {
            //assertTrue(flagConfirmationokaybutton, "Confirmation Okay button");
            click(CRMemberSearchPage.btnAlertSaveYes, "Confirmation Okay button");
        }/* else {
            assertFalse(flagConfirmationokaybutton, "Confirmation Okay button is not present");
        }*/

        Boolean flagErrornotification = isVisibleOnly(CRMemberSearchPage.errorNotifications, "Error notification");
        //assertTrue(flagErrornotification, "Error notification appeared");
        if (flagErrornotification) {
           // assertTrue(flagErrornotification, "Error notification appeared");
            click(CRMemberSearchPage.errorNotifications, "Error notification");
        }/* else {
            assertFalse(flagErrornotification, "Error notification is not appeared");
        }*/
        boolean expirationErrorMessage = isVisibleOnly(CRMemberSearchPage.errorAlertOK, "Expiration Date Allert");
        //assertTrue(expirationErrorMessage, "expirationErrorMessage");
        if (expirationErrorMessage) {
            //assertTrue(expirationErrorMessage, "expirationErrorMessage");
            click(CRMemberSearchPage.errorAlertOK, "expirationErrorMessage");
        }/* else {
            assertTrue(!expirationErrorMessage, "expirationErrorMessage Not Present");
        }*/

        boolean flagErrorOkButton = isVisibleOnly(CRMemberSearchPage.alertUndefinedError, "Error notification");
        if (flagErrorOkButton) {
            //assertTrue(flagErrorOkButton, "Error notification appeared");
            click(CRMemberSearchPage.alertUndefinedError, "Error notification");
        } else {
            String combineKeys3 = Keys.chord(Keys.SPACE);
            sendKeys(combineKeys3, "SPACE");
        }


    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: membContinfo_Enterprimphonenum
     *  * description :: To enter member primphone
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */
    public void enterMemberContactInfoPrimaryPhoneNumber(String Primaryphonenum) throws Throwable {
        Thread.sleep(3000);

        waitForVisibilityOfElement(CRMemberSearchPage.txtPhone_NumberFirstRow, "Primary phone number textbox");
        type(CRMemberSearchPage.txtPhone_NumberFirstRow, Primaryphonenum, "Primary phone number textbox");
        Thread.sleep(3000);
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: membContinfo_Enterprimphonetype
     *  * description :: To enter member primphone type
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */

    public void membContInfoEnterPrimPhoneTypeCellular() throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.txtPhoneType, "Phonenumber type");
        selectByVisibleText(CRMemberSearchPage.txtPhoneType, "Cellular", "Phone number type");
    }

    /**
     *  * param :: String inputs
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: membContinfo_Selectprimphrdbtn
     *  * description :: To select member prim phone radio button
     *  * date :: 05-Dec-2017
     *  * author ::Parameswar Yenduri
     *  
     */

    public void membContinfoSelectprimphrdbtn() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.radiodbtnPrimRowOne, "Primay phone radio button");
        click(CRMemberSearchPage.radiodbtnPrimRowOne, "Primary phone radio button");

    }

    /**
     * Description:This method will check DEL checkbox,clicks on AddPhone button,enters new phone number,
     * selects phonetype,check prim checkbox and check the temp checkBox.
     *
     * @throws Throwable
     */
    public void tempDelete() throws Throwable {
        memberNumClick();
        clickDelCheckBoxRowTwo();
        clickAddPhoneBtn();
        enterRandomSecondaryPhoneNumberinThirdRow();
        enterRandomPrimaryPhoneNumberinFirstRow();
        selectPhoneTypeinRowThree();
        ClickPrimRadioBtnInRowThree();
        clickTempCheckBoxinThirdRow();
    }

    /**
     * Description:To click on Row two del checkBox on MemberContactInformation
     *
     * @throws Throwable
     */
    public void clickDelCheckBoxRowTwo() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.chkBoxDelCheckBoxSecondRow, "Del CheckBox");
        click(CRMemberSearchPage.chkBoxDelCheckBoxSecondRow, "Del CheckBox");
    }

    /**
     * Description:To click on AddPhone Button on MemberContactInformation
     *
     * @throws Throwable
     */
    public void clickAddPhoneBtn() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.addPhoneButton, "Add Phone");
        click(CRMemberSearchPage.addPhoneButton, "Add Phone");
    }

    /**
     * Description:To enter random member's phone number in Row Three on MemberContactInformation
     *
     * @throws Throwable
     */
    public void enterRandomSecondaryPhoneNumberinThirdRow() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.addPhoneNumberTextThirdRow, "Phone Number TextBox");
        click(CRMemberSearchPage.addPhoneNumberTextThirdRow, "Phone Number TextBox");
        clearData(CRMemberSearchPage.addPhoneNumberTextThirdRow);
        click(CRMemberSearchPage.addPhoneNumberTextThirdRow, "Phone Number TextBox");
        type(CRMemberSearchPage.addPhoneNumberTextThirdRow, "4115" + generateRandomNumber(6), "PhoneNumber");
    }

    /**
     * Description:To enter random member's phone number in Row One on MemberContactInformation
     *
     * @throws Throwable
     */
    public void enterRandomPrimaryPhoneNumberinFirstRow() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.addPhoneNumberTextFirstRow, "Phone Number TextBox");
        type(CRMemberSearchPage.addPhoneNumberTextFirstRow, "4115" + generateRandomNumber(6), "PhoneNumber");
    }

    /**
     * Description:To click on row three phoneType Dropdown on MemberContactInformation
     *
     * @throws Throwable
     */
    public void selectPhoneTypeinRowThree() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.dropDownPhoneTypeRowThree, "Phone Number type");
        selectByVisibleText(CRMemberSearchPage.dropDownPhoneTypeRowThree, "Business", "Phonenumber type");
    }

    /**
     * Description:To click on row three prim Radio button on MemberContactInformation
     *
     * @throws Throwable
     */
    public void ClickPrimRadioBtnInRowThree() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.radiobtnPrimInRowThree, "Phone Number type");
        click(CRMemberSearchPage.radiobtnPrimInRowThree, "prim Radio Button");
    }

    /**
     * Description:To click on row three temp checkBox on MemberContactInformation
     *
     * @throws Throwable
     */
    public void clickTempCheckBoxinThirdRow() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.chkBoxTempCheckBoxRowThree, "Phone Number type");
        click(CRMemberSearchPage.chkBoxTempCheckBoxRowThree, "Temp CheckBox");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberNumberCol
     * description :: To check member contactInfo is not null
     * date :: 05-Dec-2017
     * author :: Madhukar
     */
    public void memberNumberColNullValueCheck() throws Throwable {

        String memNum = getText(CRMemberSearchPage.lblMemberNumberColumnValue, "Member number");//Getting the First product
        assertTrue(memNum != null, "Contact information is not null");
    }

    /**
     * Description:This method is used only to click on MemberId link for HistoryCallSave and handle the popup.
     *
     * @throws Throwable
     */
    public void clickOnMemberIdForHistoryCallSave() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.linkMemberId, "Member Id");
        click(CRMemberSearchPage.linkMemberId, "Member Id");
        handlePopup();
    }

    public void handlePopup() throws Throwable {
        if (isVisible(CRMemberSearchPage.alertClose, "PopUp Window Cancel")) {
            click(CRMemberSearchPage.alertClose, "PopUp Window Cancel");
        }
    }

    public void memberSrchPageMandDetails(String Primaryphonenum) throws Throwable {
        memberNumClick();
        currentCallClose();
        enterMemberContactInfoPrimaryPhoneNumber(Primaryphonenum);
        membContInfoEnterPrimPhoneTypeCellular();
        membContinfoSelectprimphrdbtn();
    }

    /**
     * Description:This method verify whether MemberShipNumber is visible and to retrieve the MemberShip Number.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String labelMemberShipNumberInMemberDetailsSection() throws Throwable {
        String membershipNumber = null;
        boolean visibilityOfMemberNumberLabel = isVisibleOnly(CRMemberSearchPage.lblMemberShipNumber, "Member Number label");
        //assertTrue(visibilityOfMemberNumberLabel, "Member number value is available in member details Section");
        if (visibilityOfMemberNumberLabel) {
           // assertTrue(visibilityOfMemberNumberLabel, "Member number value is available in member details Section");
            membershipNumber = getText(CRMemberSearchPage.lblMemberShipNumber, "Member number value from member number details section");
        }/* else {
            assertFalse(visibilityOfMemberNumberLabel, "Member number is not available");
        }*/
        return membershipNumber;
    }

    /**
     * Description:This method verify whether Member Since is visible and to retrieve the Member Since value.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void labelMemberSinceInMemberDetailsSection() throws Throwable {
        boolean visibilityOfMemberSinceLabel = isVisibleOnly(CRMemberSearchPage.lblMemberSince, "Member Since label");
        assertTrue(visibilityOfMemberSinceLabel, "Member since value is available in member details Section");
        if (visibilityOfMemberSinceLabel) {
           // assertTrue(visibilityOfMemberSinceLabel, "Member since value is available in member details Section");
            String memberSince = getText(CRMemberSearchPage.lblMemberSince, "Member since value from member number details section");
        }/* else {
            assertFalse(visibilityOfMemberSinceLabel, "Member since is not available");
        }*/
    }

    /**
     * Description:This method verify whether Member Level is visible and to retrieve the Member Level.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void labelMemberLevelInMemberDetailsSection() throws Throwable {
        boolean visibilityOfMemberLevelLabel = isVisibleOnly(CRMemberSearchPage.lblMemberLevel, "Member Level label");
        assertTrue(visibilityOfMemberLevelLabel, "Member Level value is available in member details Section");
        if (visibilityOfMemberLevelLabel) {
            //assertTrue(visibilityOfMemberLevelLabel, "Member Level value is available in member details Section");
            String memberLevel = getText(CRMemberSearchPage.lblMemberLevel, "Member level value from member number details section");
        }/* else {
            assertFalse(visibilityOfMemberLevelLabel, "Member level is not available");
        }*/
    }

    /**
     * Description:This method verify whether Member Type is visible and to retrieve the Member Type.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void labelMemberTypeInMemberDetailsSection() throws Throwable {
        boolean visibilityOfMemberTypeLabel = isVisibleOnly(CRMemberSearchPage.lblMemberType, "Member Type label");
        assertTrue(visibilityOfMemberTypeLabel, "Member Type value is available in member details Section");
        if (visibilityOfMemberTypeLabel) {
           // assertTrue(visibilityOfMemberTypeLabel, "Member Type value is available in member details Section");
            String memberType = getText(CRMemberSearchPage.lblMemberType, "Member Type value from member number details section");
        }/* else {
            assertFalse(visibilityOfMemberTypeLabel, "Member Type is not available");
        }*/
    }

    /**
     * Description:This method verify whether Member Expiration date is visible and to retrieve the Member Expiration date.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void labelMemberExpirationInMemberDetailsSection() throws Throwable {
        boolean visibilityOfMemberExpirationLabel = isVisibleOnly(CRMemberSearchPage.lblMemberExpiration, "Member Expiration label");
        assertTrue(visibilityOfMemberExpirationLabel, "Member Expiration value is available in member details Section");
        if (visibilityOfMemberExpirationLabel) {
         //   assertTrue(visibilityOfMemberExpirationLabel, "Member Expiration value is available in member details Section");
            String memberExpiration = getText(CRMemberSearchPage.lblMemberExpiration, "Member Expiration value from member number details section");
        }/* else {
            assertFalse(visibilityOfMemberExpirationLabel, "Member Expiration is not available");
        }*/
    }

    /**
     * Description:This method verify whether Member status is visible and to retrieve the Member Status Details.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void labelMemberStatusInMemberDetailsSection() throws Throwable {
        boolean visibilityOfMemberStatusLabel = isVisibleOnly(CRMemberSearchPage.lblMemberStatus, "Member Status label");
        assertTrue(visibilityOfMemberStatusLabel, "Member Status value is available in member details Section");
        if (visibilityOfMemberStatusLabel) {
         //   assertTrue(visibilityOfMemberStatusLabel, "Member Status value is available in member details Section");
            String memberStatus = getText(CRMemberSearchPage.lblMemberStatus, "Member Status value from member number details section");
        }/* else {
            assertFalse(visibilityOfMemberStatusLabel, "Member Status is not available");
        }*/
    }

    /**
     * Description:This method verify whether Calls Allowed is visible and to retrieve the No.of Calls Allowed.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public String memberCallsAllowedInMemberDetailsSection() throws Throwable {
        String callsAllowed = null;
        boolean visibilityOfCallsAllowed = isVisibleOnly(CRMemberSearchPage.memberCallsAllowed, "Calls Allowed");
        assertTrue(visibilityOfCallsAllowed, "Calls Allowed is available in member details Section");
        if (visibilityOfCallsAllowed) {
         //   assertTrue(visibilityOfCallsAllowed, "Calls Allowed is available in member details Section");
            callsAllowed = getText(CRMemberSearchPage.memberCallsAllowed, "Calls Allowed value from member number details section");
            //System.out.println("Number of calls"+callsAllowed);
        }/* else {
            assertFalse(visibilityOfCallsAllowed, "Calls Allowed is not available");
        }*/
        return callsAllowed;
    }

    /**
     * Description:This method verify whether Calls Remaining is visible and to retrieve the no.of calls remaining.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void memberCallsRemainingInMemberDetailsSection() throws Throwable {
        boolean visibilityOfCallsRemaining = isVisibleOnly(CRMemberSearchPage.memberCallsRemaining, "Calls Remaining");
        assertTrue(visibilityOfCallsRemaining, "Calls Remaining is available in member details Section");
        if (visibilityOfCallsRemaining) {
         //   assertTrue(visibilityOfCallsRemaining, "Calls Remaining is available in member details Section");
            String callsRemaining = getText(CRMemberSearchPage.memberCallsRemaining, "Calls Remaining value from member number details section");
        }/* else {
            assertFalse(visibilityOfCallsRemaining, "Calls Remaining is not available");
        }*/
    }

    /**
     * Description:This method verify whether Calls Used is visible and to retrieve the no.of Calls used.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void memberCallsUsedInMemberDetailsSection() throws Throwable {
        boolean visibilityOfCallsUsed = isVisibleOnly(CRMemberSearchPage.memberCallsUsed, "Calls Used");
        assertTrue(visibilityOfCallsUsed, "Calls Used is available in member details Section");
        if (visibilityOfCallsUsed) {
         //   assertTrue(visibilityOfCallsUsed, "Calls Used is available in member details Section");
            String callsUsed = getText(CRMemberSearchPage.memberCallsUsed, "Calls Used value from member number details section");
        }/* else {
            assertFalse(visibilityOfCallsUsed, "Calls Used is not available");
        }*/
    }

    /**
     * Description:This method verify whether CurrentCalls  is visible and to retrieve the no.of CurrentCalls.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void memberCurrentCallsInMemberDetailsSection() throws Throwable {
        boolean visibilityOfCurrentCalls = isVisibleOnly(CRMemberSearchPage.memberCurrentCalls, " Current Calls");
        //assertTrue(visibilityOfCurrentCalls, "Current Calls is available in member details Section");
        if (visibilityOfCurrentCalls) {
         //   assertTrue(visibilityOfCurrentCalls, "Current Calls is available in member details Section");
            String currentCalls = getText(CRMemberSearchPage.memberCurrentCalls, "Current Calls value from member number details section");
        }/* else {
            assertFalse(visibilityOfCurrentCalls, " Current Calls is not available");
        }*/
    }

    /**
     * Description:This method verify whether ChargeableCalls is visible and to retrieve the no.of ChargeableCalls.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void memberChargeableCallsInMemberDetailsSection() throws Throwable {
        boolean visibilityOfChargeableCalls = isVisibleOnly(CRMemberSearchPage.memberChargeableCalls, " Chargeable Calls");
        assertTrue(visibilityOfChargeableCalls, "Chargeable Calls is available in member details Section");
        if (visibilityOfChargeableCalls) {
         //   assertTrue(visibilityOfChargeableCalls, "Chargeable Calls is available in member details Section");
            String currentCalls = getText(CRMemberSearchPage.memberChargeableCalls, "Chargeable Calls value from member number details section");
        }/* else {
            assertFalse(visibilityOfChargeableCalls, " Chargeable Calls is not available");
        }*/
    }

    /**
     * Description:This method verify whether MemberFirstName is visible and to retrieve the MemberFirstName.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void labelMemberFirstNameInMemberDetailsSection() throws Throwable {
        boolean visibilityOfMemberNameLabel = isVisibleOnly(CRMemberSearchPage.lblMemberFirstName, "Member FirstName label");
        assertTrue(visibilityOfMemberNameLabel, "Member FirstName is available in member details Section");
        if (visibilityOfMemberNameLabel) {
         //   assertTrue(visibilityOfMemberNameLabel, "Member FirstName is available in member details Section");
            String memberFirstName = getText(CRMemberSearchPage.lblMemberFirstName, "FirstName value from member number details section");
        }/* else {
            assertFalse(visibilityOfMemberNameLabel, "FirstName is not available");
        }*/
    }

    /**
     * Description:This method verify whether MemberLastName is visible and to retrieve the MemberLastName.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void labelMemberLastNameInMemberDetailsSection() throws Throwable {
        boolean visibilityOfMemberLastNameLabel = isVisibleOnly(CRMemberSearchPage.lblMemberLastName, "Member LastName label");
        assertTrue(visibilityOfMemberLastNameLabel, "Member LastName is available in member details Section");
        if (visibilityOfMemberLastNameLabel) {
         //   assertTrue(visibilityOfMemberLastNameLabel, "Member LastName is available in member details Section");
            String memberLastName = getText(CRMemberSearchPage.lblMemberLastName, "Member LastName value from member number details section");
        }/* else {
            assertFalse(visibilityOfMemberLastNameLabel, "Member LastName is not available");
        }*/
    }

    /**
     * Description:This method verify whether Member ZipCode is visible and to retrieve the Member Zipcode.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void labelMemberZipCodeInMemberDetailsSection() throws Throwable {
        boolean visibilityOfZipCodeLabel = isVisibleOnly(CRMemberSearchPage.lblMemberZipCode, "Member Zipcode label");
        assertTrue(visibilityOfZipCodeLabel, "Member Zipcode is available in member details Section");
        if (visibilityOfZipCodeLabel) {
         //   assertTrue(visibilityOfZipCodeLabel, "Member Zipcode is available in member details Section");
            String memberZipcode = getText(CRMemberSearchPage.lblMemberZipCode, "Member Zipcode value from member number details section");
        }/* else {
            assertFalse(visibilityOfZipCodeLabel, "Member Zipcode is not available");
        }*/
    }

    /**
     * Description:This method verify whether Member state is visible and to retrieve the Member's state.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void labelMemberStateInMemberDetailsSection() throws Throwable {
        boolean visibilityOfStateLabel = isVisibleOnly(CRMemberSearchPage.lblMemberState, "Member State label");
        assertTrue(visibilityOfStateLabel, "Member State is available in member details Section");
        if (visibilityOfStateLabel) {
         //   assertTrue(visibilityOfStateLabel, "Member State is available in member details Section");
            String state = getText(CRMemberSearchPage.lblMemberState, "Member State value from member number details section");
        }/* else {
            assertFalse(visibilityOfStateLabel, "Member State is not available");
        }*/
    }

    /**
     * Description:This method verify whether Member's City is visible and to retrieve the Member's City.
     *
     * @throws Throwable
     * @author :Madhukar
     * date :: 12-Dec-2017
     */
    public void labelMemberCityInMemberDetailsSection() throws Throwable {
        boolean visibilityOfCityLabel = isVisibleOnly(CRMemberSearchPage.lblMemberCity, "Member City label");
        assertTrue(visibilityOfCityLabel, "Member City is available in member details Section");
        if (visibilityOfCityLabel) {
         //   assertTrue(visibilityOfCityLabel, "Member City is available in member details Section");
            String city = getText(CRMemberSearchPage.lblMemberCity, "Member City value from member number details section");
        }/* else {
            assertFalse(visibilityOfCityLabel, "Member City is not available");
        }*/
    }

    /**
     * Description:This method is used to verify whether member Number is visible or not and to get member number details
     * after searching in the omni search bar.
     * Date:15-12-2017
     *
     * @throws Throwable
     */
    public void memberNumber() throws Throwable {
        boolean visibilityOfMemberNumber = isVisibleOnly(CRMemberSearchPage.lblMemberNumberColumnValue, "Member Number");
        assertTrue(visibilityOfMemberNumber, "Member Number is available");
        if (visibilityOfMemberNumber) {
         //   assertTrue(visibilityOfMemberNumber, "Member Number is available");
            String memberNumber = getText(CRMemberSearchPage.lblMemberNumberColumnValue, "Member Number value");
        }/* else {
            assertFalse(visibilityOfMemberNumber, "Member Number is not available");
        }*/
    }

    /**
     * Description:This method is used to verify whether member Name is visible or not and to get member number details
     * after searching in the omni search bar.
     * Date:15-12-2017
     *
     * @throws Throwable
     */
    public void memberName() throws Throwable {
        boolean visibilityOfMemberName = isVisibleOnly(CRMemberSearchPage.lblMemberNameColumnValue, "Member Name");
        assertTrue(visibilityOfMemberName, "Member Name is available");
        if (visibilityOfMemberName) {
         //   assertTrue(visibilityOfMemberName, "Member Name is available");
            String memberName = getText(CRMemberSearchPage.lblMemberNameColumnValue, "Member Name value");
        }/* else {
            assertFalse(visibilityOfMemberName, "Member Name is not available");
        }*/
    }

    /**
     * Description:This method is used to verify whether member Address is visible or not and to get member number details
     * after searching in the omni search bar.
     * Date:15-12-2017
     *
     * @throws Throwable
     */
    public void memberAddress() throws Throwable {
        boolean visibilityOfMemberAddress = isVisibleOnly(CRMemberSearchPage.lblMemberAddressColumnValue, "Member Address");
        assertTrue(visibilityOfMemberAddress, "Member Address is available");
        if (visibilityOfMemberAddress) {
         //   assertTrue(visibilityOfMemberAddress, "Member Address is available");
            String memberAddress = getText(CRMemberSearchPage.lblMemberAddressColumnValue, "Member Address value");
        }/* else {
            assertFalse(visibilityOfMemberAddress, "Member Address is not available");
        }*/
    }

    /**
     * Description:This method is used to verify whether MemberContactInfo is visible or not and to get member number details
     * after searching in the omni search bar.
     * Date:15-12-2017
     *
     * @throws Throwable
     */
    public void memberContactInfo() throws Throwable {
        boolean visibilityOfMemberContactInfo = isVisibleOnly(CRMemberSearchPage.lblMemberAddressColumnValue, "Member ContactInfo");
        assertTrue(visibilityOfMemberContactInfo, "Member ContactInfo is available");
        if (visibilityOfMemberContactInfo) {
         //   assertTrue(visibilityOfMemberContactInfo, "Member ContactInfo is available");
            String memberContactInfo = getText(CRMemberSearchPage.lblMemberAddressColumnValue, "Member ContactInfo value");
        }/* else {
            assertFalse(visibilityOfMemberContactInfo, "Member ContactInfo is not available");
        }*/
    }

    /**
     * Description:This method is used to enter text in ScratchPad
     *
     * @param text
     * @throws Throwable
     */
    public void enterTextInScratchPad(String text) throws Throwable {
        type(CRMemberSearchPage.txtScratchPad, text, "ScratchPad");
        mouseDoubleClick(CRMemberSearchPage.txtScratchPad,  "ScratchPad");
    }

    /**
     * Description:This method is used to click on change of Address Radio Button to edit the address manually.
     *
     * @throws Throwable
     */
    public void clickOnChangeOfAddressRadioBtn() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.radiobtnChangeOfAddress, "Change Of address");
        click(CRMemberSearchPage.radiobtnChangeOfAddress, "Change Of address");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memFieldsVerification
     * description :: To Verify All mandatory Fields on member Page
     * date :: 18-December-2017
     * author :: chandu
     */
    public void clickOnManualEntryLinkInMember() throws Throwable {
        boolean manualEntryLinkVerification = isVisible(CRMemberSearchPage.lnkManualEntryOnMember, "ManualEntry Link");
        assertTrue(manualEntryLinkVerification, "ManualEntry Link is Present");
        waitForVisibilityOfElement(CRMemberSearchPage.lnkManualEntryOnMember, "ManualEntry Link");
        click(CRMemberSearchPage.lnkManualEntryOnMember, "ManualEntry Link");
    }

    /**
     * Description:This method is used to verify whether scratch pad is visible or not.
     *
     * @throws Throwable
     */
    public void verifyScratchPad() throws Throwable {
        click(CRMemberSearchPage.iconScratchPad, "Scratch Pad Icon");
        boolean visibilityOfSctatchPad = isVisibleOnly(CRMemberSearchPage.txtScratchPad, "Scratch Pad");
        assertTrue(visibilityOfSctatchPad, "ScratchPad is visible ");
        if (visibilityOfSctatchPad) {
            String text = getText(CRMemberSearchPage.txtScratchPad, "Scratch Pad");
            assertTrue(text.isEmpty(), "Scratch Pad is empty");
            /*if (text.equalsIgnoreCase(null)) {
                assertTrue(text.equalsIgnoreCase(null), "Scratch Pad is empty");
            } else {
                assertFalse(text.equalsIgnoreCase(null), "Scratch Pad is not  empty");
            }*/
            //assertTrue(visibilityOfSctatchPad, "ScratchPad is visible ");

        }/* else {
            assertFalse(visibilityOfSctatchPad, "ScratchPad is not visible");
        }*/
    }

    /**
     * Description:To get current calls from the list.
     *
     * @param callid
     * @throws Throwable
     * @author: lakshmi
     */
    public void currentCallRecord(String callid) throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.listOfCallsID, "CallId in Profile");
        callList = getWebElementList(CRMemberSearchPage.listOfCallsID, "CallId in Profile");
        if (callList != null) {
            System.out.println(callList.size());
            for (int i = 0; i <= callList.size(); i++) {
                //for (int j = 0; j <= i; j++) {
                String callIdFromList = callList.get(i).getText();
                //if (callid.equals(callIdFromList)) {
                    //Actions action = new Actions(driver);
                    // action.doubleClick(callList.get(i));
                    assertTrue(callid.equals(callIdFromList), "Created Call Record present");

                    //}
                //}
            }
        }
    }

    /**
     * Description:To enter the data in club code
     *
     * @param clubCode
     * @throws Throwable
     */
    public void enterDataInClubCode(String clubCode) throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.btnClubCodeSearch, "Club Code Button");
        click(CRMemberSearchPage.btnClubCodeSearch, "Club Code Button");
        click(CRMemberSearchPage.txtClubCode, "Enter Club Code");
        clearData(CRMemberSearchPage.txtClubCode);
        type(CRMemberSearchPage.txtClubCode, clubCode, "Enter Club Code");
        //JSClick(CRMemberSearchPage.cityClubCode,"Club Code of city");

    }

    /**
     * Description:This method is used to verify the wild card for the names which are searched in omni search bar.
     *
     * @throws Throwable
     */
    public void verifyWildCardForLastName() throws Throwable {
        boolean visibilityOfMemberName = isVisibleOnly(CRMemberSearchPage.lblMemberNameColumnValue, "Member Name");
        if (visibilityOfMemberName) {
            assertTrue(visibilityOfMemberName, "Member Name is available");
            String memberName = getText(CRMemberSearchPage.lblMemberNameColumnValue, "Member Name value");
            boolean wildCard = memberName.contains(",");
            //if (wildCard) {
                assertTrue(wildCard, "wildcard is visible");
            /*} else {
                assertFalse(wildCard, "wildcard not visible");
            }*/

        } else {
            assertFalse(visibilityOfMemberName, "wildcard is visible");
        }
    }

    /**
     * Description:This method is used to get current calls for a member.
     *
     * @return
     * @throws Throwable
     * @author: lakshmi
     */
    public String getCurrentCallsForMember() throws Throwable {
        String currentCalls = null;
        boolean visibilityOfCurrentCalls = isVisibleOnly(CRMemberSearchPage.memberCurrentCalls, " Current Calls");
        assertTrue(visibilityOfCurrentCalls, "Current Calls is available in member details Section");
        if (visibilityOfCurrentCalls) {
         //   assertTrue(visibilityOfCurrentCalls, "Current Calls is available in member details Section");
            currentCalls = getText(CRMemberSearchPage.memberCurrentCalls, "Current Calls value from member number details section");
        }/* else {
            assertFalse(visibilityOfCurrentCalls, " Current Calls is not available");
        }*/
        return currentCalls;
    }

    /**
     * Description:This verify no.of calls for a member after leaving the call.
     *
     * @throws Throwable
     * @author :Lakshmi
     * date :: 19-Dec-2017
     */
    public void verifyNumberOfCalls(String numcalls1, String numCalls2) throws Throwable {
        boolean numberOfCalls = numcalls1.equals(numCalls2);
        //if (numberOfCalls) {
            assertTrue(numberOfCalls, "Call was Saved In to the live call System");
        /*} else {
            assertTrue(!numberOfCalls, "Call was Not Saved In to the live call System");
        }*/
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLocationTab
     * description ::
     * date :: 19-Dec-2017
     * author :: Abhiram Vajrapu
     */
    public void clickOnMemberTab() throws Throwable {
        Thread.sleep(6000);
        waitForVisibilityOfElement(CRMemberSearchPage.memberTab, "Member Tab");
        click(CRMemberSearchPage.memberTab, "Member Tab");
    }

    /**
     * Description:This method is to verify club code is updated automatically for a cdx member .
     *
     * @param cityClubCode
     * @throws Throwable
     */
    public void verifyClubCodeForCdxmember(String cityClubCode) throws Throwable {
        boolean flagclubcode = isVisibleOnly(CRMemberSearchPage.txtClubCode, "clubCode textbox");
        if (flagclubcode) {
            click(CRMemberSearchPage.txtClubCode, "clubCode textbox");
            click(CRMemberSearchPage.memberTab, "Member Tab");
            String clubCode = getText(CRMemberSearchPage.clubCode, "Retrieved Club code ");
            if (clubCode.equalsIgnoreCase(cityClubCode)) {
                assertFalse(flagclubcode, "clubCode is automatically updated ");
            } else {
                assertTrue(flagclubcode, "Club code is not updated");
                //As if above steps failed then we need to enter Club code manually
                click(CRMemberSearchPage.clubCode, "Click on Club Code text box");
                type(CRMemberSearchPage.txtClubCode, cityClubCode, "Enter Club Code");
                click(CRMemberSearchPage.btnSearchButton, "Search Button");
            }
        }
    }

    /**
     * Description:This method is used to verify list of members available for any search criteria.
     *
     * @throws Throwable
     */
    public void verifyListOfMembernames() throws Throwable {
        boolean listOfMembers = isVisibleOnly(CRMemberSearchPage.listOfLastNames, "List of member names");
        //if (listOfMembers) {
            assertTrue(listOfMembers, "All members with the entered details are returned");
        /*} else {
            assertFalse(listOfMembers, "All members with the entered details are not returned");
        }*/
    }

    /**
     * Description:Get phone Number for verification .
     *
     * @return
     * @throws Throwable
     */
    public String getPhoneNumber() throws Throwable {
        String phoneNumber = getText(CRMemberSearchPage.txtPhone_NumberFirstRow, "PhoneNumber");
        return phoneNumber;
    }

    /**
     * Description:This method verify whether CurrentCalls  is visible and to retrieve the no.of CurrentCalls.
     *
     * @throws Throwable
     * @author :Abhiram
     * date :: 20-Dec-2017
     */
    public void memberCurrentCalls() throws Throwable {
        boolean visibilityOfCurrentCalls = isVisibleOnly(CRMemberSearchPage.memberCurrentCalls, " Current Calls");
        assertTrue(visibilityOfCurrentCalls, "Current Calls is available in member details Section");
        if (visibilityOfCurrentCalls) {
         //   assertTrue(visibilityOfCurrentCalls, "Current Calls is available in member details Section");
            String currentCalls = getText(CRMemberSearchPage.memberCurrentCalls, "Current Calls value from member number details section");
            int result = Integer.parseInt(currentCalls);
            boolean callCountresult = result != 1;
            //if (callCountresult) {
                assertTrue(callCountresult, "Call count is verified and not matched to 1");
            /*} else {
                assertFalse(callCountresult, "call count is verified and it is matched to 1");
            }*/

        }/* else {
            assertFalse(visibilityOfCurrentCalls, " Current Calls is not available");
        }*/
    }

    public void closeSearchCallsWindow() throws Throwable {
        boolean closeCallWindow = isVisibleOnly(CRMemberSearchPage.iconSearchCallClose, "Close search call window");
        assertTrue(closeCallWindow, "Close call window appeared");
        if (closeCallWindow) {
           // assertTrue(closeCallWindow, "Close call window appeared");
            Thread.sleep(1000);
            click(CRMemberSearchPage.iconSearchCallClose, "Close search call window");
        }/* else {
            assertFalse(closeCallWindow, "Close call window not appeared");
        }*/
    }

    public void verifyTheCreatedCall(String callId) throws Throwable {
        String callIdAndDateFromCurrentCallWindow = getText(CRMemberSearchPage.linkCallID, "Callid from current Calls");
        callIdAndDateFromCurrentCallWindow.split("\n");
        String splitStr[] = callIdAndDateFromCurrentCallWindow.split("\\n");
        String calliddetails = splitStr[1];
        String callIdValue[] = calliddetails.split("#");
        String splitedCallIDValue = callIdValue[1];
//        String callidfromCurrentCallWindow = calliddetails.substring(1,4);
        boolean verifyCallIds = callId.equals(splitedCallIDValue);
        //if (verifyCallIds) {
            assertTrue(verifyCallIds, "Call created with member who is not present in Database");
        /*} else {
            assertTrue(!verifyCallIds, "Call is not created with member who is not present in Database");
        }*/

    }

    public void verifyManualEntryLink() throws Throwable {
        boolean manualEntryLink = isVisible(CRMemberSearchPage.lnkManualEntryOnMember, "ManualEntry Link");
        //if (manualEntryLink) {
            assertTrue(manualEntryLink, "ManualEntry Link is Present");
        /*} else {
            assertTrue(!manualEntryLink, "ManualEntry Link is Not Present");
        }*/

    }

    public void veryfyCallCountForMember(String callsAllowedBeforeMemberCall, String callsAllowedAfterMemberCall) throws Throwable {
        boolean callcount = callsAllowedBeforeMemberCall.equals(callsAllowedAfterMemberCall);
        //if (callcount) {
            assertTrue(callcount, "call was Not counted against the member as an entitlement ");
        /*} else {
            assertTrue(!callcount, "call was counted against the member as an entitlement");
        }*/

    }

    public void clickOnPartialCallCloseButton() throws Throwable {
        boolean partialCall = isVisibleOnly(CRMemberSearchPage.partialCall, "Partial Call Close Icon");
        if (partialCall) {
            click(CRMemberSearchPage.closeIconOnPartialCall, "Partial Call close icon");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickPrimRadioBtnSecondRow
     * description ::
     * date :: 11-01-2018
     * author :: Lakshmi prasanna
     */
    public void clickPrimRadioBtnSecondRow() throws Throwable {
        click(CRMemberSearchPage.radiodbtnPrimRowTwo, "primary_phoneRadioButton ");
    }

    /**
     * Description:This method verify whether Calls Remaining is visible and to retrieve the no.of calls remaining.
     *
     * @throws Throwable methodName :: verifyMemberCallsRemainingInMemberDetailsSection
     *                   description :: To Verify member calls remaining on members detail section
     * @author :Varun
     * date :: 11-Jan-2018
     */

    public int CallsRemainingInMemberDetailsSection() throws Throwable {

        String callsRemaining = getText(CRMemberSearchPage.memberCallsRemaining, "Calls Remaining value from member number details section");
        int RemainingCalls = Integer.parseInt(callsRemaining);
        System.out.println(RemainingCalls);

        return RemainingCalls;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: memberSearchTextBox
     * description :: enter data in Member Search textBox
     * date :: 05-Nov-2017
     * author :: chandu
     */
    public void memberSearchTextBox(String Membersearch) throws Throwable {
        click(CRHomePage.txtSearchMemberText, "Member Search box");
        type(CRHomePage.txtSearchMemberText, Membersearch, "Search Value");
        Thread.sleep(2000);
        System.out.println("Wrong" + Membersearch);
        click(CRHomePage.btnSearchButton, "Search Button");
    }

    public void enterMemberDetails(String Member, String PrimaryPhone) throws Throwable {
        memberSearchTextBox(Member);
        //search and close alert member
        memberNumClick();
        //Enter primary phone number
        enterMemberContactInfoPrimaryPhoneNumberRandomly(PrimaryPhone);
        //enterMemberContactInfoPrimaryPhoneNumber(PrimaryPhone);
        //enter prime phone type cellular
        membContInfoEnterPrimPhoneTypeCellular();
        //enter prime phone radio button
        clickPrimRadioBtnRowOne();
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSecondaryPhoneType
     * description :: enter enter Secondary PhoneType
     * date :: 12-jan-18
     * author :: Lakshmi Prasanna
     */
    public void enterSecondaryPhoneType(String phoneType) throws Throwable {
        type(CRMemberSearchPage.txtSecondaryPhoneType, phoneType, "Secondary Phone Type");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: membershipRenewAlertYes
     * description :: accept membership renew
     * date :: 12-Jan-2018
     * author :: Varun
     */

    public void membershipRenewAlertYes() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.btnMembershipRenewYes, "Yes");
        click(CRMemberSearchPage.btnMembershipRenewYes, "Yes");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: membershipRenewAlertNo
     * description :: decline membership renew
     * date :: 12-Dec-2017
     * author :: Varun
     */

    public void membershipRenewAlertNo() throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.btnMembershipRenewNo, "No");
        click(CRMemberSearchPage.btnMembershipRenewNo, "No");
    }

    /**
     * Description:To click on row two prim Radio button on MemberContactInformation
     *
     * @throws Throwable
     */
    public void ClickPrimRadioBtnInRowTwo() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.radiobtnPrimInRowTwo, "Phone Number type");
        click(CRMemberSearchPage.radiobtnPrimInRowTwo, "prim Radio Button");
    }

    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getConfirmationPopup
     * description ::
     * date :: 16-Jan-2018
     * author :: Nidhi
     */

    public String getConfirmationPopup() throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.confirmationDialogQuestion, "Dialog Question");
        String value = getText(CRMemberSearchPage.confirmationDialogQuestion, "Dialog Question");
        getText(CRMemberSearchPage.btnYesOnConfirmationDialogQuestion, "Dialog Question");
        getText(CRMemberSearchPage.btnNoOnConfirmationDialogQuestion, "Dialog Question");
        return value;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: checkOnSmsCheckBox
     * description ::
     * date :: 16-Jan-2018
     * author :: Nidhi
     */

    public void checkOnSmsCheckBox() throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.chkBoxSms, "check");
        click(CRMemberSearchPage.chkBoxSms, "check on SMS");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyLongTowAllowed
     * description ::
     * date :: 17-Jan-2018
     * author :: Lakshmi Prasanna
     */
    public void verifyLongTowAllowed(String longTowAllowed)throws  Throwable{
        Thread.sleep(2000);
        String longTowallowedValue = getText(CRMemberSearchPage.txtLongTowAllowedValue,"Long Tow Allowed");
        //if(longTowallowedValue.equalsIgnoreCase(longTowAllowed)){
            assertTrue((longTowallowedValue.equalsIgnoreCase(longTowAllowed)),"Verified the ALLOW_LONG_TOW parameter and ALLOW_LONG_TOW is set to  "+longTowallowedValue);
        //}

    }

    /**
     * Description:This method is used to click on workflow dropdown button and select only for History workflow
     * @throws Throwable
     * @author: Madhukar
     */
    public void mandatoryFieldsForRAPCall(String firstName,String lastName,long ran,String paymentCode) throws Throwable {
        type(CRMemberSearchPage.txtFirstName,firstName,"First Name");
        type(CRMemberSearchPage.txtLastName,lastName,"Last Name");
        String numberAsString = new Long(ran).toString();
        type(CRMemberSearchPage.txtRapCallNumber,numberAsString,"Rap call number");
        type(CRMemberSearchPage.txtRapPaymentResponsibilityCode,paymentCode,"Payment Responsibility Code");

        // click(CRHomePage.)

    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnClubClodeSuggestedOption
     * description ::
     * date :: 16-Jan-2018
     * author :: Nidhi
     */

    public void clickOnClubClodeSuggestedOption() throws Throwable {

        click(CRMemberSearchPage.clubCodeSelectionForRAPCall, "Club code selection");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterRAPonMemberTab
     * description :: enter enter Secondary PhoneType
     * date :: 17-jan-18
     * author :: Varun
     */
    public void enterRAPonMemberTab(String RAPNumber) throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.txtRapCallNumber, "RAP number");
        type(CRMemberSearchPage.txtRapCallNumber, RAPNumber, "RAP number");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSecondPhoneNumber
     * description :: enter enter Secondary PhoneType
     * date :: 17-jan-18
     * author :: Varun
     */

    public void enterSecondPhoneNumber(String secondPhoneNumber) throws Throwable {
        clearData(CRMemberSearchPage.txtPhone_NumberSecondRow);
        click(CRMemberSearchPage.txtPhone_NumberSecondRow, "Second Phone Number");
        type(CRMemberSearchPage.txtPhone_NumberSecondRow, secondPhoneNumber, "Second Phone Number");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSecondPhoneNumber
     * description :: enter enter Secondary PhoneType
     * date :: 17-jan-18
     * author :: Chnadu
     */
    public void verifyIsRapWorkFlowSet()throws  Throwable{
        boolean workFlow = isVisibleOnly(CRMemberSearchPage.lnkRapEntitlements,"RapEntitlements in RAP WorkFlow");
        assertTrue(workFlow,"WorkFlow is set to RAP");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getPhoneNumberFirstRecord
     * description :: getPhoneNumberFirstRecord
     * date :: 22-Jan-18
     * author :: Abhiram
     */
    public String getPhoneNumberFirstRecord()throws  Throwable{
        String phoneNumber = getAttributeByValue(CRMemberSearchPage.txtPhoneNumberFirstRecord,"Phone Number");
        return phoneNumber;

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getPhoneNumberFirstRecord
     * description :: getPhoneNumberFirstRecord
     * date :: 22-Jan-18
     * author :: Abhiram
     */
    public String getPhoneTypeFirstRecord()throws  Throwable{
        String phoneType = getAttributeByValue(CRMemberSearchPage.txtPhoneTypeFirstRecord,"Phone Type");
        return phoneType;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: currentCallCloseForfacilityWithDuplicate
     * description :: Member Name Search
     * date :: 22-Dec-2017
     * author :: Varun
     */
//This method is specific to duplicating call with facility
    public void currentCallCloseForfacilityWithDuplicate() throws Throwable {
        boolean flagCurrentCallClose = isVisibleOnly(CRMemberSearchPage.iconcurrentcallClose, "Current call close");
        if (flagCurrentCallClose) {
            //waitForVisibilityOfElement(CRMemberSearchPage.iconcurrentcallClose,"Current call popup");
            click(CRMemberSearchPage.iconcurrentcallClose, "Current call popup closed");
        } else {
            assertTrue(flagCurrentCallClose, "Current call popup Visible");
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: confirmationAlert
     * description :: confirmationAlert
     * date :: 29-Jan-2018
     * author :: Varun
     */

    public void confirmationAlert() throws Throwable {
        waitForVisibilityOfElement(CRMemberSearchPage.btnMembershipRenewYes, "Yes");
        click(CRMemberSearchPage.btnMembershipRenewYes, "Yes");
    }
public void enterMembershipDetails(String Member, String Membersearch, String dbServer, String dbqueryFileName,  String colomnName, String PhoneNumber, String Primaryphonenum1 ) throws Throwable {
        
        //home.verifyandClickLogout();
        if (Member.equals("db")){
	        //fetch member details from db
	        //generating a random number everytime to fetch a new record everytime
	        int rownum = IntRandomNumberGenerator(10,100);
            //int rownum = 3;
            //member from db
	        Member = CommonDb.selectRandomMemberFromDB(dbServer,dbqueryFileName,colomnName,rownum);
	        System.out.println("member : "+Member);
        }
        //if (Member.equals(""))
        if (Member.isEmpty())
        {
        	Member = Membersearch;
        }
        //enter Member Details
        //enter phone number
        if(PhoneNumber.equalsIgnoreCase("Existing"))
        {
            memberSearchTextBox(Member);
            //search and close alert member
            memberNumClick();
            if(getPhoneNumberFirstRecord().isEmpty())
            {
                enterMemberContactInfoPrimaryPhoneNumberRandomly(Primaryphonenum1);
            }
            if(getPhoneTypeFirstRecord().isEmpty())
            {
                membContInfoEnterPrimPhoneTypeCellular();
            }
            clickPrimRadioBtnRow();
        }
        else
        {
            enterMemberDetails(Member,Primaryphonenum1);
        }
    }

public void enterMemberContactInfoPrimaryPhoneNumberRandomly(String Primaryphonenum) throws Throwable {
    Thread.sleep(3000);

    waitForVisibilityOfElement(CRMemberSearchPage.txtPhone_NumberFirstRow, "Primary phone number textbox");
    type(CRMemberSearchPage.txtPhone_NumberFirstRow, Primaryphonenum+generateRandomNumber(7), "Primary phone number textbox");
    Thread.sleep(3000);
}

    public void verifyCompleteCheckMember()  throws Throwable {
        if (!(isVisibleOnly(CRMemberSearchPage.verifyMemberCompleteCheck, "Member Complete Check"))) {
            reporter.failureReport("Verify Member Complete Check" , "All Mandatory Fields are not entered", driver);
        }
    }
    public String getPhoneNumberFromCallerInfo() throws Throwable {

        waitForVisibilityOfElement(CRMemberSearchPage.linkCallSummaryIconOnMemberspage, "Call Summary icon");

        //click(CRMemberSearchPage.linkCallSummaryIconOnMemberspage, "Call Summary icon");
        //waitForVisibilityOfElement(CRMemberSearchPage.phoneNumberOnCallSummaryPOPUp, "Summary Pop Up");
        //Thread.sleep(3000);
        String phoneString1 = getText(CRMemberSearchPage.phoneNumberOnCallSummaryPOPUp, "Phone number").substring(8, 11);
        String phoneString2 = getText(CRMemberSearchPage.phoneNumberOnCallSummaryPOPUp, "Phone number").substring(13, 16);
        String phoneString3 = getText(CRMemberSearchPage.phoneNumberOnCallSummaryPOPUp, "Phone number").substring(17, 21);

        String phoneNumber = phoneString1 + phoneString2 + phoneString3;
        return phoneNumber;
    }

    /**
     * Description:This method is used to click on row One prim radioButton
     *
     * @throws Throwable
     */
    public void clickPrimRadioBtnRow() throws Throwable {
        click(CRMemberSearchPage.radiodbtnPrimRow, "primary_phoneRadioButton ");
    }
}
