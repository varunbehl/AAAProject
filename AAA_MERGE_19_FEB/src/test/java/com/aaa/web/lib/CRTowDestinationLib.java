package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRTowDestinationPage;
import com.aaa.web.page.CRVehicleTriagePage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;




public class CRTowDestinationLib extends ActionEngine {
    List<WebElement> allRepairShops = null;

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearTowMadatoryFields
     * description :: To clear Mandatory Fields on ToDestination Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void towDestinationFieldVerification() throws Throwable {
        verifyTowPassengers();
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearTowMadatoryFields
     * description :: To clear Mandatory Fields on ToDestination Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void verifyTowPassengers() throws Throwable {
        boolean flagtowPassengers = isVisibleOnly(CRTowDestinationPage.txtNumberOfTowPassengers, "TowPassengers");
        /*if (flagtowPassengers)
        {
            assertTrue(flagtowPassengers, "TowPassengers is Mandatory Field");
        }*/
        assertTrue(flagtowPassengers, "TowPassengers is Mandatory Field");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearTowMadatoryFields
     * description :: To clear Mandatory Fields on ToDestination Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void clearAndSaveTowDestinationDetails(String numberOfTowPassengers) throws Throwable{
        clearTowMadatoryFields();
        saveTowDetails(numberOfTowPassengers);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearTowMadatoryFields
     * description :: To clear Mandatory Fields on ToDestination Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clearTowMadatoryFields()throws Throwable {

        clearData(CRTowDestinationPage.txtNumberOfTowPassengers);


    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: saveTowDetails
     * description :: To save TowDetails
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void saveTowDetails(String numberOfTowPassengers) throws Throwable {
        enterTowDestinationMandatoryFields(numberOfTowPassengers);
        /*clickonSaveBtn();*/

    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTowDestinationMandatoryFields
     * description :: To Enter all mandatory Fields on Tow
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterTowDestinationMandatoryFields(String numberOfTowPassengers) throws Throwable {
        Thread.sleep(2000);
        errorAlertHandlingBeforeEnterMandatoryFields();
        enterTowPassengers(numberOfTowPassengers);
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearTowMadatoryFields
     * description :: To clear Mandatory Fields on ToDestination Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void enterTowPassengers(String numberOfTowPassengers) throws  Throwable {
        Thread.sleep(2000);
        waitForVisibilityOfElement(CRTowDestinationPage.txtNumberOfTowPassengers,"TowPassengers");
        click(CRTowDestinationPage.txtNumberOfTowPassengers, "TowPassengers");
        clearData(CRTowDestinationPage.txtNumberOfTowPassengers);
        type(CRTowDestinationPage.txtNumberOfTowPassengers, numberOfTowPassengers, "TowPassengers");
        Thread.sleep(2000);
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearTowMadatoryFields
     * description :: To clear Mandatory Fields on ToDestination Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void clickOnTowDestinationTab() throws Throwable {
        waitForVisibilityOfElement(CRTowDestinationPage.towDestinationTab,"Towdestination Tab");
        click(CRTowDestinationPage.towDestinationTab, "Towdestination Tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: errorAlertHandlingBeforeEnterMandatoryFields
     * description :: To Handle error and alert
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void errorAlertHandlingBeforeEnterMandatoryFields() throws Throwable {
        //Error Handling on Tow Tab
        boolean flagErrorAlert = isVisibleOnly(CRTowDestinationPage.errorAlertOK, "Error Alert OK button");
        //assertTrue(flagErrorAlert,"Error Alert OK button");
        if(flagErrorAlert) {
            //assertTrue(flagErrorAlert,"Error Alert OK button");
            click(CRTowDestinationPage.errorAlertOK, "Error Alert OK Button");
        }/*else{
            assertFalse(flagErrorAlert,"Error Alert Not Present");
        }*/
        boolean flagScriptError=isVisibleOnly(CRTowDestinationPage.scriptError, "Script Error OKAY button");
        //assertTrue(flagScriptError,"Script Error OKAY button");
        /*if (flagScriptError) {
            assertTrue(flagScriptError,"Script Error OKAY button");
        }else{
            assertFalse(flagScriptError,"Script Error is Not Present");
        }*/
        boolean flagConforOkButton=isElementPresent(CRTowDestinationPage.btnAlertSaveYes, "Confirmation okay button");
        //assertTrue(flagConforOkButton,"Confirmation okay button");
        if(flagConforOkButton) {
           // assertTrue(flagConforOkButton,"Confirmation okay button");
            click(CRTowDestinationPage.btnAlertSaveYes, "Confirmation Okay button");
        }
        /*else{
            assertFalse(flagConforOkButton,"Confirmation Okay button Not Present");
        }*/
        /*Boolean flag = isVisibleOnly(CRTowdestinationpage.errorNotifications, "Error notification");
        assertTrue(flag, "Error notification appeared");*/
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearTowMadatoryFields
     * description :: To clear Mandatory Fields on ToDestination Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */

    public void towLocation(String towPassengers) throws Throwable {

        waitForVisibilityOfElement(CRTowDestinationPage.towDestinationTab,"Tow tab");
        click(CRTowDestinationPage.towDestinationTab,"Tow tab");
        waitForVisibilityOfElement(CRTowDestinationPage.btnDialogOkBtn,"Tow ok button");
        click(CRVehicleTriagePage.btnDialogOkBtn,"Tow ok button");
        waitForVisibilityOfElement(CRTowDestinationPage.linkTowLocation,"Tow location link");
        click(CRTowDestinationPage.linkTowLocation,"Tow location link");
        waitForVisibilityOfElement(CRTowDestinationPage.txtTowPassenger,"Tow passengers");
        type(CRTowDestinationPage.txtTowPassenger,towPassengers,"pacesetter code manual entry");

    }
    public void clickOnManualEntryLinkOnTowDestination() throws  Throwable{
        Thread.sleep(2000);
        click(CRTowDestinationPage.linkManualEntryLinkOnTowDestination,"ManualEntry Link");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTowLocationName
     * description :: enterTowLocationName
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void enterTowLocationName(String towLocation) throws Throwable {

        //click(CRTowDestinationPage.txtTowLocationName,"Location address");
        type(CRTowDestinationPage.txtTowLocationName,towLocation,"Location address");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterFirstCrossStreet
     * description :: enterFirstCrossStreet
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void enterFirstCrossStreet(String firstCrossStreet) throws Throwable {

        //click(CRTowDestinationPage.txtTowCrossStreetInput,"First Cross Street address");
        type(CRTowDestinationPage.txtTowCrossStreetInput,firstCrossStreet,"First Cross Street address");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSecondCrossStreet
     * description :: enterSecondCrossStreet
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void enterSecondCrossStreet(String secondCrossStreet) throws Throwable {

        //click(CRTowDestinationPage.txtTowSecondCrossStreetInput,"Second Cross Street address");
        type(CRTowDestinationPage.txtTowSecondCrossStreetInput,secondCrossStreet,"Second Cross Street address");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCityCodeInTow
     * description :: enterCityCodeInTow
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void enterCityCodeInTow(String city) throws Throwable {

        //click(CRTowDestinationPage.txtTowCity,"City in Tow destination");
        type(CRTowDestinationPage.txtTowCity,city,"City in Tow Destination");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterStateInTow
     * description :: enterStateInTow
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void enterStateInTow(String state) throws Throwable {

        //click(CRTowDestinationPage.txtTowState,"State in Tow destination");
        type(CRTowDestinationPage.txtTowState,state,"State in Tow Destination");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLandMarkInTow
     * description :: enterLandMarkInTow
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void enterLandMarkInTow(String landMark) throws Throwable {

        //click(CRTowDestinationPage.txtTowLandMark,"State in Tow destination");
        type(CRTowDestinationPage.txtTowLandMark,landMark,"LandMark in Tow Destination");
        //click(CRTowDestinationPage.txtTowSecondCrossStreetInput,"Clicking on another ");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getLatitudeValueInTow
     * description :: enterLandMarkInTow
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void getLatitudeValueInTow() throws Throwable {

        String latitude=getAttributeByValue(CRTowDestinationPage.txtlatitude,"Latitude");
        //assertTrue(true,"Latitude value is" +latitude);
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getLatitudeValueInTow
     * description :: enterLandMarkInTow
     * date :: 03-01-2018
     * author :: Chandrasekhar
     */

    public void getLogitudeValueInTow() throws Throwable {

        String Logitude=getAttributeByValue(CRTowDestinationPage.txtLogitude,"Logitude");
        //assertTrue(true,"logitude value is" +Logitude);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnExistingTowDetinationLink
     * description ::
     * date :: 11-Jan-2018
     * author :: Abhiram
     */

    public void clickOnExistingTowDetinationLink() throws Throwable {

        waitForVisibilityOfElement(CRTowDestinationPage.linkTowLocation,"Tow location link");
        click(CRTowDestinationPage.linkTowLocation,"Tow location link");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAARTowDetinationLink
     * description ::
     * date :: 11-Jan-2018
     * author :: Abhiram
     */

    public void clickOnAARTowDetinationLink() throws Throwable {

        waitForVisibilityOfElement(CRTowDestinationPage.linkAARInTowDestination,"AAR link");
        click(CRTowDestinationPage.linkAARInTowDestination,"AAR link");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowMilesForBasicLevellessThan5Miles
     * description :: To verify Tow Miles For Basic Level lessThan 5 Miles
     * date :: 11-01-2018
     * author :: Lakshmi Prasanna
     */
    public boolean verifyTowMilesForBasicLevellessThan5Miles(String allowedMilesForBasedOnLevel) throws Throwable {
        boolean flagMiles = false;
        Thread.sleep(2000);
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i=0; i<allRepairShops.size(); i++) {
                String MileFromResult = getText(CRTowDestinationPage.getMilesList(i+1), "Miles From results");
                int noOfAllowedMilesForBasicMemberInteger = Integer.parseInt(allowedMilesForBasedOnLevel);
                double noOfMileFromResult = Double.parseDouble(MileFromResult);
                //String location = getText(CRTowDestinationPage.getLocationListOnTow(i), "Miles From results");

                if (noOfMileFromResult <= noOfAllowedMilesForBasicMemberInteger) {
                    //System.out.println("-------MileFromResult" + MileFromResult);

                    Actions action = new Actions(driver);
                    WebElement locationLink = findWebElement(CRTowDestinationPage.getLocationListOnTow(i+1), "Location Link");
                    String locationName = locationLink.getText();
                    flagMiles = (noOfMileFromResult <= noOfAllowedMilesForBasicMemberInteger);
                    assertTrue(flagMiles, "Tow destination is  " + allowedMilesForBasedOnLevel + " miles less than  from the breakdown location & destination miles are:  " + noOfMileFromResult + "And Tow Location is   " + locationName);
                    Thread.sleep(3000);
                    action.click(locationLink).build().perform();
                    Thread.sleep(3000);
                    break;
                }

            }

        }
        return flagMiles;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: mouseHoverTowMileDetailsOnTowDestination
     * description :: Tool tip fpr tow Mile Details
     * date :: 11-01-2018
     * author :: Lakshmi Prasanna
     */

    public void mouseHoverTowMileDetailsOnTowDestination()throws  Throwable{
        Thread.sleep(3000);
        mouseHover(CRTowDestinationPage.towMilesDetailsToolTip,"Tow Miles Details ToolTip");
        Thread.sleep(3000);

    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyEstimatedtowmiles
     * description :: To verify Estimated tow miles from Tool Tip
     * date :: 18-01-2018
     * author :: Lakshmi Prasanna
     */
    public void verifyEstimatedtowmiles()throws  Throwable{
        waitForVisibilityOfElement(CRTowDestinationPage.lblEstimatedTowMilesInTowToolTip,"Estimated Tow miles");
        mouseHoverTowMileDetailsOnTowDestination();
        Thread.sleep(3000);
        String towMileagesDetail = getText(CRTowDestinationPage.lblToolTipTowMilageDetails,"Tow Milage details");
        Thread.sleep(3000);
        String estimatedTowMileslabel=getText(CRTowDestinationPage.lblEstimatedTowMilesInTowToolTip,"Estimated Tow miles Label");
        Thread.sleep(3000);
        String estimatedTowMilesValue=getText(CRTowDestinationPage.lblEstimatedTowMilesValuesInTowToolTip,"Estimated Tow miles Value");
        boolean estimatedMiles = estimatedTowMileslabel != null;
        assertTrue(estimatedMiles,"Verified the "+estimatedTowMileslabel+ " On  "+towMileagesDetail+"  And Estimated Tow Miles are  "+estimatedTowMilesValue);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyEntitledMiles
     * description :: To verify Entitled Miles from Tool Tip
     * date :: 18-01-2018
     * author :: Lakshmi Prasanna
     */
    public void verifyEntitledMiles()throws  Throwable{
        waitForVisibilityOfElement(CRTowDestinationPage.lblEntitleMilesInTowToolTip,"Entitle Miles");
        mouseHoverTowMileDetailsOnTowDestination();
        Thread.sleep(3000);
        String towMileagesDetail = getText(CRTowDestinationPage.lblToolTipTowMilageDetails,"Tow Milage details");
        Thread.sleep(3000);
        String entitleMileslabel=getText(CRTowDestinationPage.lblEntitleMilesInTowToolTip,"Entitle Miles Label");
        Thread.sleep(3000);
        String entitleMilesValue=getText(CRTowDestinationPage.lblEntitleMilesValuesInTowToolTip,"Entitle Miles Value");
        boolean entitleMiles = entitleMileslabel != null;
        assertTrue(entitleMiles,"Verified the "+entitleMileslabel+" On  "+towMileagesDetail+"  And Entitle Miles are  "+entitleMilesValue);
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyEstimatedOverMiles
     * description :: To verify EstimateOver Miles from Tool Tip
     * date :: 18-01-2018
     * author :: Lakshmi Prasanna
     */
    public String verifyEstimatedOverMiles()throws  Throwable{
        waitForVisibilityOfElement(CRTowDestinationPage.lblEstimatedOverMilesInTowToolTip,"Estimated OverMiles");
        mouseHoverTowMileDetailsOnTowDestination();
        Thread.sleep(3000);
        String towMileagesDetail = getText(CRTowDestinationPage.lblToolTipTowMilageDetails,"Tow Milage details");
        Thread.sleep(3000);
        String estimatedOverMileslabel=getText(CRTowDestinationPage.lblEstimatedOverMilesInTowToolTip,"Estimated OverMiles Label");
        Thread.sleep(3000);
        String estimatedOverMilesValue=getText(CRTowDestinationPage.lblEstimatedOverMilesValuesInTowToolTip,"Estimated OverMiles Value");
        boolean estimatedOverMiles = estimatedOverMileslabel != null;
        assertTrue(estimatedOverMiles,"Verified the "+estimatedOverMileslabel+" On  "+towMileagesDetail+"  And Estimated Over Miles are  "+estimatedOverMilesValue);
        return estimatedOverMilesValue;
    }
    public void enterExistingTowDestAddr(String towPassengers) throws Throwable {
        clickOnExistingTowDetinationLink();
        enterTowPassengers(towPassengers);
    }
    public void enterFullAddress(String locationAddress, String crossStreet, String secondCrossStreet, String city, String state, String landMark, String towPassengers) throws Throwable {
        enterTowLocationName(locationAddress);
        enterFirstCrossStreet(crossStreet);
        enterSecondCrossStreet(secondCrossStreet);
        enterCityCodeInTow(city);
        enterStateInTow(state);
        enterLandMarkInTow(landMark);
        Thread.sleep(2000);
        getLatitudeValueInTow();
        getLogitudeValueInTow();
        enterTowPassengers(towPassengers);
    }
    public void selectAARandEnterPassengerDetails(String towPassengers) throws Throwable {
        clickOnAARTowDetinationLink();
        enterTowPassengers(towPassengers);
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowDestinationTab
     * description ::
     * date :: 12-Jan-2018
     * author :: Nidhi
     */
    public String verifyTowDestinationTab()throws  Throwable{
        isVisibleOnly(CRTowDestinationPage.towDestinationTab,"Tow Destination Tab");
        String value= getText(CRTowDestinationPage.towDestinationTab,"Tow Destination Tab");
        return value;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: alertForTowMilesOffer
     * description :: alert For Tow Miles Offer
     * date :: 03-01-2018
     * author :: Lakshmi Prasanna
     */
    public void alertForTowMilesOffer() throws Throwable {
        Thread.sleep(1000);
        //waitForInVisibilityOfElement(CRTowDestinationPage.btnAlertForTowOffer,"Alert For Tow offer");
        boolean towOffer = isVisibleOnly(CRTowDestinationPage.btnAlertForTowOffer, "Alert For Tow offer");
        if (towOffer) {
            click(CRTowDestinationPage.btnAlertForTowOffer, "Alert For Tow offer");
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnShowCriteriaCollapseButton
     * description :: To click On Show Criteria Collapse Button
     * date :: 03-01-2018
     * author :: Lakshmi Prasanna
     */
    public void clickOnShowCriteriaCollapseButton()throws  Throwable{
        click(CRTowDestinationPage.btnShowCrireria,"Show Criteria");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterMilesToSearchRepairShopWithInRange
     * description :: To enter Miles To Search RepairShop WithInRange
     * date :: 03-01-2018
     * author :: Lakshmi Prasanna
     */
    public void enterMilesToSearchRepairShopWithInRange(String searchMiles)throws Throwable{
        Thread.sleep(2000);
        type(CRTowDestinationPage.txtSearchMilesWithInRange,searchMiles,"Miles to Search with in Range");
    }
    public void clickOnSearchButtonOnTow()throws  Throwable{
        click(CRTowDestinationPage.btnTowSearchButton,"Search button");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowMilesForSpecifedLevel
     * description :: To verify Tow Miles For SpecifedLevel
     * date :: 11-01-2018
     * author :: Lakshmi Prasanna
     */
    public boolean verifyTowMilesBasedOnLevel(String allowedMilesForBasedOnLevel) throws Throwable {
        String MileFromResult = null;
        boolean flagMiles = false;

        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i=0; i<allRepairShops.size(); i++) {
                //System.out.println("allRepairShops" + allRepairShops.get(i).getText());
                MileFromResult = getText(CRTowDestinationPage.getMilesList(i+1), "Miles From results");
                if (MileFromResult.equals("N/A")) {
                    //scrollBottom();
                    Actions action = new Actions(driver);
                    //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)");
                    WebElement MilesNALink = findWebElement(CRTowDestinationPage.getMilesList(i+1), "Miles NA link");
                    Thread.sleep(4000);
                    //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)");
                    action.click(MilesNALink).build().perform();
                    Thread.sleep(4000);
                    MileFromResult = getText(CRTowDestinationPage.getMilesList(i+1), "Miles From results");
                }
                int noOfAllowedMilesForBasicMemberInteger = Integer.parseInt(allowedMilesForBasedOnLevel);
                double noOfMileFromResult = Double.parseDouble(MileFromResult);
                //String location = getText(CRTowDestinationPage.getLocationListOnTow(i), "Miles From results");

                if (noOfMileFromResult >= noOfAllowedMilesForBasicMemberInteger) {
                    //System.out.println("-------MileFromResult" + MileFromResult);

                    Actions action = new Actions(driver);
                    WebElement locationLink = findWebElement(CRTowDestinationPage.getLocationListOnTow(i+1), "Location Link");
                    String locatinName = locationLink.getText();
                    flagMiles = (noOfMileFromResult >= noOfAllowedMilesForBasicMemberInteger);
                    assertTrue(flagMiles, "Tow destination is  Greater Than  " + noOfAllowedMilesForBasicMemberInteger + " miles from the breakdown location & destination miles are : " + noOfMileFromResult + "  And Tow Location is   " + locatinName);
                    Thread.sleep(2000);
                    action.click(locationLink).build().perform();
                    Thread.sleep(4000);
                    break;
                }

            }

        }
        return flagMiles;
    }

   /* public void verifyTowMilesForPlusMember50Miles(String allowedMilesForPlusOnLevel)throws  Throwable{
        allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
        if (allRepairShops != null) {
            for (int i=1; i<allRepairShops.size(); i++) {
                //System.out.println("allRepairShops" + allRepairShops.get(i).getText());
                String MileFromResult = getText(CRTowDestinationPage.getMilesList(i), "Miles From results");
                if(MileFromResult.equals("N/A")){
                    //scrollBottom();
                    Actions action = new Actions(driver);
                    //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)");
                    WebElement MilesNALink=findWebElement(CRTowDestinationPage.getMilesList(i),"Miles NA link");
                    Thread.sleep(3000);
                    //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)");
                    action.click(MilesNALink).build().perform();
                    Thread.sleep(3000);
                    MileFromResult = getText(CRTowDestinationPage.getMilesList(i), "Miles From results");
                }
                double noOfAllowedMilesForPlusMemberInteger=Double.parseDouble(allowedMilesForPlusOnLevel);
                double noOfMileFromResult= Double.parseDouble(MileFromResult);
                //String location = getText(CRTowDestinationPage.getLocationListOnTow(i), "Miles From results");

                if (noOfMileFromResult >= noOfAllowedMilesForPlusMemberInteger) {
                    //System.out.println("-------MileFromResult" + MileFromResult);
                    assertTrue(noOfMileFromResult >= noOfAllowedMilesForPlusMemberInteger,"Tow destination that is approximately 50 miles from the breakdown location & destination miles : "+noOfMileFromResult);
                    Actions action = new Actions(driver);
                    WebElement locationLink=findWebElement(CRTowDestinationPage.getLocationListOnTow(i),"Location Link");
                    Thread.sleep(2000);
                    action.click(locationLink).build().perform();
                    Thread.sleep(1000);
                    break;
                }
            }
        }
    }*/
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowMilesForPlusMemberApproximately50Miles
     * description :: To verify TowMiles For PlusMember Approximately 50Miles
     * date :: 11-01-2018
     * author :: Lakshmi Prasanna
     */
    public boolean verifyTowMilesForPlusMemberApproximately50Miles(String aboveSpecifiedMiles, String belowSpecifiedMiles) throws Throwable {
        boolean milesFlag = false;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i=0; i<allRepairShops.size(); i++) {
                //System.out.println("allRepairShops" + allRepairShops.get(i).getText());
                String MileFromResult = getText(CRTowDestinationPage.getMilesList(i+1), "Miles From results");
                if (MileFromResult.equals("N/A")) {
                    //scrollBottom();
                    Actions action = new Actions(driver);
                    //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)");
                    WebElement MilesNALink = findWebElement(CRTowDestinationPage.getMilesList(i+1), "Miles NA link");
                    Thread.sleep(3000);
                    //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)");
                    action.click(MilesNALink).build().perform();
                    Thread.sleep(3000);
                    MileFromResult = getText(CRTowDestinationPage.getMilesList(i+1), "Miles From results");
                }
                //double noOfAllowedMilesForPlusMemberInteger=Double.parseDouble(allowedMilesForPlusOnLevel);
                double aboveSpecifiedMilesDouble = Double.parseDouble(aboveSpecifiedMiles);
                double belowSpecifiedMilesDouble = Double.parseDouble(belowSpecifiedMiles);
                double noOfMileFromResult = Double.parseDouble(MileFromResult);
                //String location = getText(CRTowDestinationPage.getLocationListOnTow(i), "Miles From results");

                if (aboveSpecifiedMilesDouble <= noOfMileFromResult && belowSpecifiedMilesDouble >= noOfMileFromResult) {
                    //System.out.println("-------MileFromResult" + MileFromResult);

                    Actions action = new Actions(driver);
                    WebElement locationLink = findWebElement(CRTowDestinationPage.getLocationListOnTow(i+1), "Location Link");
                    String location = locationLink.getText();
                    milesFlag = (aboveSpecifiedMilesDouble <= noOfMileFromResult && belowSpecifiedMilesDouble >= noOfMileFromResult);
                    //assertTrue(aboveSpecifiedMilesDouble <= noOfMileFromResult && belowSpecifiedMilesDouble >= noOfMileFromResult,"Tow destination that is approximately 50 miles from the breakdown location & destination miles : "+noOfMileFromResult+"  And Tow Location is   "+location);
                    assertTrue(milesFlag, "Tow destination that is approximately 50 miles from the breakdown location & destination miles : " + noOfMileFromResult + "  And Tow Location is   " + location);
                    Thread.sleep(2000);
                    action.click(locationLink).build().perform();
                    Thread.sleep(1000);
                    break;
                }
            }
        }
        return  milesFlag;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowMilesForMembersInBetweenTheMileRange
     * description :: To verify TowMiles For Members InBetween TheMileRange
     * date :: 11-01-2018
     * author :: Lakshmi Prasanna
     */
    public boolean verifyTowMilesForMembersInBetweenTheMileRange(String aboveSpecifiedMiles, String belowSpecifiedMiles) throws Throwable {
        String MileFromResult = null;
        boolean flagMiles = false;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i=0; i<allRepairShops.size(); i++) {
                //System.out.println("allRepairShops" + allRepairShops.get(i).getText());
                MileFromResult = getText(CRTowDestinationPage.getMilesList(i+1), "Miles From results");

                if (MileFromResult.equals("N/A")) {
                    //scrollBottom();
                    Actions action = new Actions(driver);
                    //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)");
                    WebElement MilesNALink = findWebElement(CRTowDestinationPage.getMilesList(i+1), "Miles NA link");
                    Thread.sleep(4000);
                    //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1500)");
                    action.click(MilesNALink).build().perform();
                    Thread.sleep(4000);
                    MileFromResult = getText(CRTowDestinationPage.getMilesList(i+1), "Miles From results");
                }
                double aboveSpecifiedMilesInt = Double.parseDouble(aboveSpecifiedMiles);
                double belowSpecifiedMilesInt = Double.parseDouble(belowSpecifiedMiles);
                double noOfMileFromResult = Double.parseDouble(MileFromResult);
                //String location = getText(CRTowDestinationPage.getLocationListOnTow(i), "Miles From results");

                if (aboveSpecifiedMilesInt <= noOfMileFromResult && belowSpecifiedMilesInt >= noOfMileFromResult) {
                    //System.out.println("-------MileFromResult" + MileFromResult);

                    Actions action = new Actions(driver);
                    WebElement locationLink = findWebElement(CRTowDestinationPage.getLocationListOnTow(i+1), "Location Link");
                    String location = locationLink.getText();
                    flagMiles = (aboveSpecifiedMilesInt <= noOfMileFromResult && belowSpecifiedMilesInt >= noOfMileFromResult);
                    //assertTrue((aboveSpecifiedMilesInt <= noOfMileFromResult && belowSpecifiedMilesInt >= noOfMileFromResult),"Tow destination is approximately between 80 and 100 miles from the breakdown location, but not greater than (>) 100 miles. & destination miles  are: "+noOfMileFromResult+ "  And Tow Location is "+location);
                    assertTrue(flagMiles, "Tow destination is approximately between "+aboveSpecifiedMiles+ " And " +belowSpecifiedMiles+ " & destination miles  are: " + noOfMileFromResult + "  And Tow Location is " + location);
                    Thread.sleep(3000);
                    action.click(locationLink).build().perform();
                    Thread.sleep(3000);
                    break;
                }

            }
        }
        return flagMiles;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: popupNotificationForRSPreferalPinnedToUnpinned
     * description ::
     * date :: 17-Jan-2018
     * author :: Abhiram
     */
    public void popupNotificationForRSPreferalPinnedToUnpinned()throws  Throwable{
        waitForInVisibilityOfElement(CRTowDestinationPage.popupNotificationForRSPreferalPinnedToUnpinned,"RSP Notification Pinned to Unpinned");
        click(CRTowDestinationPage.popupNotificationForRSPreferalPinnedToUnpinned,"RSP Notification Pinned to Unpinned");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: popupNotificationForRSPreferalGetTitle
     * description ::
     * date :: 17-Jan-2018
     * author ::Abhiram Vajrapu
     */
    public void popupNotificationForRSPreferalGetTitle() throws Throwable {
        getText(CRTowDestinationPage.popupNotificationForRSPreferalGetTitle, "RSP Referal Status.");
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: popupNotificationForRSPreferalUnPinned
     * description ::
     * date :: 17-Jan-2018
     * author :: Abhiram
     */
    public void popupNotificationForRSPreferalUnPinned()throws  Throwable{
        waitForInVisibilityOfElement(CRTowDestinationPage.popupNotificationForRSPreferalUnPinned,"RSP Notification Unpinned");
        click(CRTowDestinationPage.popupNotificationForRSPreferalUnPinned,"RSP Notification Unpinned");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRVType
     * description ::
     * date :: 18-Jan-2018
     * author :: Lakshmi Prasanna
     */
    public void clickOnRVType()throws  Throwable{
        click(CRTowDestinationPage.chkBoxRVType,"Select Rv Type");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getAutoSearchCriteriaInTowDestinationTab
     * description ::getAutoSearchCriteriaInTowDestinationTab
     * date :: 18-Jan-2018
     * author :: Chandra
     */
    public String getAutoSearchCriteriaInTowDestinationTab() throws Throwable {
        Thread.sleep(2000);
        String address = getText(CRTowDestinationPage.lblAutoSearchResults, "Search address");
        return address;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTowDestinationResultsList
     * description :: verifyTowDestinationResultsList
     * date :: 18-01-2018
     * author :: Chandra
     */
    public int verifyTowDestinationResultsList() throws Throwable {

        int towDestinationResultsCount=0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops, "No Tow Destinations Available in Table");
        } else {
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            towDestinationResultsCount = allRepairShops.size();
            for (int i = 0; i < allRepairShops.size(); i++) {
                String towDestinationResults = allRepairShops.get(i).getText();
                assertTrue(allRepairShops != null, "Tow Destination:: '" + towDestinationResults + "'");
            }



        }
        return towDestinationResultsCount;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnReferalIcon
     * description :: clickOnReferalIcon
     * date :: 18-01-2018
     * author :: Chandra
     */
    public void clickOnReferalIcon() throws Throwable {
        boolean referalIcon=isVisibleOnly(CRTowDestinationPage.iconReferal,"Referal icon in Tow Destination ");
        assertTrue(referalIcon,"Referal icon");
        click(CRTowDestinationPage.iconReferal,"Referal icon in Tow Destination ");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getLatLongValue
     * description :: clickOnReferalIcon
     * date :: 18-01-2018
     * author :: Chandra
     */
    public void getLatLongValue() throws Throwable {
        getText(CRTowDestinationPage.lblLatLog,"Latitude and Logitude values");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getDisatanceInTow
     * description :: getDisatanceInTow
     * date :: 18-01-2018
     * author :: Chandra
     */
    public void getDisatanceInTow(String allowedMilesForBasedOnLevel) throws Throwable {
        String MileFromResult = null;

        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.repairShopResultList, "Repair shops List on TowDestination Tab");
            for (int i = 1; i < allRepairShops.size(); i++) {
                MileFromResult = getText(CRTowDestinationPage.getMilesList(i), "Miles From results");
                if (MileFromResult.equals("N/A")) {

                    Actions action = new Actions(driver);
                    WebElement MilesNALink = findWebElement(CRTowDestinationPage.getMilesList(i), "Miles NA link");
                    Thread.sleep(3000);
                    action.click(MilesNALink).build().perform();
                    Thread.sleep(3000);
                    MileFromResult = getText(CRTowDestinationPage.getMilesList(i), "Miles From results");
                }
                Thread.sleep(1000);
                double noOfAllowedMilesForBasicMemberInteger = Double.parseDouble(allowedMilesForBasedOnLevel);
                double noOfMileFromResult = Double.parseDouble(MileFromResult);


                if (noOfMileFromResult <= noOfAllowedMilesForBasicMemberInteger) {
                    assertTrue(noOfMileFromResult <= noOfAllowedMilesForBasicMemberInteger, "Tow destination is  less Than  " + noOfAllowedMilesForBasicMemberInteger + " miles from the breakdown location & destination miles : " + noOfMileFromResult);
                }
            }
        }
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getVehicleValueInTowSearch
     * description :: getVehicleValueInTowSearch
     * date :: 18-01-2018
     * author :: Chandra
     */
    public String getVehicleValueInTowSearch() throws Throwable {
        String getValue = getAttributeByValue(CRTowDestinationPage.txtVehicleValueInTowScreen,"Vehicle Value in Tow Destination Search criteria");
        return getValue;
    }
    /* param ::
     * return ::void
     * throws :: throwable
     * methodName :: getVehicleValueInTowSearch
     * description :: getVehicleValueInTowSearch
     * date :: 18-01-2018
     * author :: Chandra
     */
    public Boolean compareTwoValues(String getValue,String inputValue) throws Throwable {
        boolean comparedValues = getValue.equalsIgnoreCase(inputValue);
        assertTrue(comparedValues,"'"+getValue+"' and' "+inputValue+"' Both are same' ");
        return comparedValues;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInVehicle
     * description :: getVehicleValueInTowSearch
     * date :: 18-01-2018
     * author :: Chandra
     */
    public void enterValueInVehicle(String MakeValue) throws Throwable {
        click(CRTowDestinationPage.txtOpenTime,"Time");
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        sendKeys(combineKeys3, "Tab");
        clearData(CRTowDestinationPage.txtVehicleValueInTowScreen);
        type(CRTowDestinationPage.txtVehicleValueInTowScreen,MakeValue,"Vehicle Make");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInDate
     * description :: enterValueInDate
     * date :: 19-01-2018
     * author :: Chandra
     */
    public void enterValueInDate(String date) throws Throwable {
        type(CRTowDestinationPage.txtOpenOnDate,date,"Date Value");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getDateValue
     * description :: getDateValue
     * date :: 19-01-2018
     * author :: Chandra
     */
    public String getDateValue() throws Throwable {
        String Date = getAttributeByValue(CRTowDestinationPage.txtOpenOnDate,"Date Value");
        return Date;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: enterValueInDate
     * description :: enterValueInDate
     * date :: 19-01-2018
     * author :: Chandra
     */
    public void enterValueInTime(String time) throws Throwable {
        type(CRTowDestinationPage.txtOpenTime,time,"Time Value");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTRCCheckBox
     * description :: clickOnTRCCheckBox
     * date :: 19-01-2018
     * author :: Chandra
     */
    public void clickOnTRCCheckBox() throws Throwable {

        click(CRTowDestinationPage.chkBoxTRC,"Check box TRC");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyTRCStatus
     * description :: verifyTRCStatus
     * date :: 19-01-2018
     * author :: Chandra
     */
    public int verifyTRCStatus() throws Throwable {
        int  TRCCount=0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.iconTRC, "Total Repair Care Tow Destination");
            TRCCount = allRepairShops.size();
            for (int i = 0; i < allRepairShops.size(); i++) {
                String towDestinationResults = allRepairShops.get(i).getText();
                assertTrue(allRepairShops != null, "Total Repair Care Tow Destination Count:: '" + towDestinationResults + "'");
            }

        }
        return TRCCount;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnOpenOnCheckBox
     * description :: clickOnOpenOnCheckBox
     * date :: 19-01-2018
     * author :: Chandra
     */
    public void clickOnOpenOnCheckBox() throws Throwable {

        click(CRTowDestinationPage.chkBoxOpenOn,"Check box Open On Date");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAARnCheckBox
     * description :: clickOnAARnCheckBox
     * date :: 19-01-2018
     * author :: Chandra
     */
    public void clickOnAARnCheckBox() throws Throwable {

        click(CRTowDestinationPage.chkBoxAAR,"Check box AAR");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnAutoGlass
     * description :: clickOnAutoGlass
     * date :: 19-01-2018
     * author :: Chandra
     */
    public void clickOnAutoGlass() throws Throwable {

        click(CRTowDestinationPage.chkBoxAutoGlass,"Check box AutoGlass");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnRepairShopVerificationCloseButton
     * description :: click On RepairShop Verification CloseButton
     * date :: 19-01-2018
     * author :: Lakshmi Prasanna
     */
    public void clickOnRepairShopVerificationCloseButton()throws  Throwable {
        boolean closebutton = isVisibleOnly(CRTowDestinationPage.btnRepairShopVerificationCloseButton, "Click On Cancel Button");
        if (closebutton) {
            Thread.sleep(2000);
            click(CRTowDestinationPage.btnRepairShopVerificationCloseButton, "Click On Cancel Button");
        }
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTextFromAlertOnTowDestinationMiles
     * description :: get Text From AlertOn Tow DestinationMiles
     * date :: 19-01-2018
     * author :: Lakshmi Prasanna
     */
    public void getTextFromAlertOnTowDestinationMiles()throws  Throwable{
        boolean repairshopvisibility=isVisibleOnly(CRTowDestinationPage.txtFromAlertRegardingTowDestination,"Text From Alert RepairShop Verification");
        if(repairshopvisibility) {
            String repairShopMessage = getText(CRTowDestinationPage.txtFromAlertRegardingTowDestination, "Text From Alert RepairShop Verification");
            assertTrue(repairshopvisibility,"repairShopMessage");
        }
    }

    /**
     *  * param :: NA
     *  * return ::boolean
     *  * throws :: throwable
     *  * methodName :: verifyAddressAvailableInTowDestination
     *  * description ::
     *  * retrivedTime :: 22-Jan-2018
     *  * author :: Abhiram
     *
     */
    public boolean verifyAddressAvailableInTowDestination()throws  Throwable{

        //waitForVisibilityOfElement(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Existing Address are Not Visible in Tow Destination Page");
        boolean towDestinationAddressAvailable = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Existing Address are Not Visible in Tow Destination Page");
        return towDestinationAddressAvailable;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCollisinCheckBox
     * description :: clickOnCollisinCheckBox
     * date :: 23-01-2018
     * author :: Chandra
     */
    public void clickOnCollisinCheckBox() throws Throwable {

        click(CRTowDestinationPage.chkBoxCollision,"Check box AAR");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAARStatus
     * description :: verifyAARStatus
     * date :: 23-01-2018
     * author :: Chandra
     */
    public int verifyAARStatus() throws Throwable {
        int  TRCCount=0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.iconAAR, "Total Repair Care Tow Destination");
            TRCCount = allRepairShops.size();
            for (int i = 0; i < allRepairShops.size(); i++) {
                String towDestinationResults = allRepairShops.get(i).getText();
                assertTrue(allRepairShops != null, "Total Repair Care Tow Destination Count:: '" + towDestinationResults + "'");
            }

        }
        return TRCCount;
    }

    public void clickOnRepairShopCheckboxOnTow()throws  Throwable{
        click(CRTowDestinationPage.chkBoxRepairShop,"Repair shop Checkbox");
    }

    public void clickOnRVCheckboxOnTow()throws  Throwable{
        click(CRTowDestinationPage.chkBoxRV,"Repair shop Checkbox");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyAutoGlassStatus
     * description :: verifyAutoGlassStatus
     * date :: 23-01-2018
     * author :: Chandra
     */
    public int verifyAutoGlassStatus() throws Throwable {
        int  TRCCount=0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.iconAAR, "Total Repair Care Tow Destination");
            TRCCount = allRepairShops.size();
            for (int i = 0; i < allRepairShops.size(); i++) {
                String towDestinationResults = allRepairShops.get(i).getText();
                assertTrue(allRepairShops != null, "Total Repair Care Tow Destination Count:: '" + towDestinationResults + "'");
            }

        }
        return TRCCount;
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyCollisionStatus
     * description :: verifyCollisionStatus
     * date :: 23-01-2018
     * author :: Chandra
     */
    public int verifyCollisionStatus() throws Throwable {
        int  TRCCount=0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.iconAAR, "Total Repair Care Tow Destination");
            TRCCount = allRepairShops.size();
            for (int i = 0; i < allRepairShops.size(); i++) {
                String towDestinationResults = allRepairShops.get(i).getText();
                assertTrue(allRepairShops != null, "Total Repair Care Tow Destination Count:: '" + towDestinationResults + "'");
            }

        }
        return TRCCount;
    }


    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyRVStatus
     * description :: verifyRVStatus
     * date :: 23-01-2018
     * author :: Chandra
     */
    public int verifyRVStatus() throws Throwable {
        int  TRCCount=0;
        boolean repairShops = isVisibleOnly(CRTowDestinationPage.txtMessageNoDataAvailableForTowDestinations, "Repair shops ");
        if (repairShops) {
            assertTrue(repairShops,"No Tow Destinations Available in Table");
        }
        else{
            allRepairShops = getWebElementList(CRTowDestinationPage.iconAAR, "Total Repair Care Tow Destination");
            TRCCount = allRepairShops.size();
            for (int i = 0; i < allRepairShops.size(); i++) {
                String towDestinationResults = allRepairShops.get(i).getText();
                assertTrue(allRepairShops != null, "Total Repair Care Tow Destination Count:: '" + towDestinationResults + "'");
            }

        }
        return TRCCount;
    }
    
    public void rspReferal(String RSPReferral) throws Throwable{

        if (RSPReferral.equalsIgnoreCase("Yes")) {
            popupNotificationForRSPreferalUnPinned();
            popupNotificationForRSPreferalGetTitle();
            popupNotificationForRSPreferalPinnedToUnpinned();
        }
    }
    
    public void clickOnManualEntryAndEnterTowDestDetails(String TDLocationAddress, String TDcrossStreet, String TDsecondCrossStreet, String TDCity, String TDState, String TDLandMark, String Towpassengers ) throws Throwable {
    	clickOnManualEntryLinkOnTowDestination();
        enterTowLocationName(TDLocationAddress);
        enterFirstCrossStreet(TDcrossStreet);
        enterSecondCrossStreet(TDsecondCrossStreet);
        enterCityCodeInTow(TDCity);
        enterStateInTow(TDState);
        enterLandMarkInTow(TDLandMark);
        enterTowPassengers(Towpassengers);
    }
    
    public void enterTowDestinationAddress(String WillThisCallBeATow, String TowDestination, String RSPReferral , String TowAddress) throws Throwable {
        if(WillThisCallBeATow.equalsIgnoreCase("Yes")) {
            clickOnTowDestinationTab();
            handleScriptError();
            String TowAddressVal[] =  TowAddress.split("#");
            switch (TowDestination) {
                case "Existing":
                    boolean noAddressLocationAvailable = verifyAddressAvailableInTowDestination();
                    if (noAddressLocationAvailable) {
                        enterTowDestinationLocationFields(TowAddress);
                    } else {
                        enterExistingTowDestAddr(TowAddressVal[9]);
                    }
                    break;
                case "Full Address":
                    enterTowDestinationLocationFields(TowAddress);
                    break;
                case "AAR":
                    boolean noLocationAvailable = verifyAddressAvailableInTowDestination();
                    if (noLocationAvailable) {
                        enterTowDestinationLocationFields(TowAddress);
                    }
                    else {
                        clickOnAARTowDetinationLink();
                    }
                    //add pinned
                    if (RSPReferral.equalsIgnoreCase("Yes")) {
                        popupNotificationForRSPreferalGetTitle();
                    }
                    enterTowPassengers(TowAddressVal[9]);
                    //add unpinned
                    break;
                default:
                    break;
            }
            verifyCompleteCheckTowDestination();
        }
    }

    public void verifyCompleteCheckTowDestination()  throws Throwable {
        if (!(isVisibleOnly(CRTowDestinationPage.verifyTowDestinationCompleteCheck, "Tow Destination Complete Check"))) {
            reporter.failureReport("Verify Tow Destination Complete Check" , "All Mandatory Fields are not entered", driver);
        }
    }

    public boolean verifyTowDestinationTabAvailablity()throws Throwable{
        boolean towTabVerification = isVisibleOnly(CRTowDestinationPage.towDestinationTab,"Tow Destination Tab");
        return towTabVerification;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: handleScriptErrorInVehicleTriagePage
     * description ::
     * date :: 18-Dec-2017
     * author ::
     */
    public void handleScriptError() throws Throwable {
        boolean flagScriptErrorOkButton = isVisibleOnly(CRVehicleTriagePage.scriptError, "Script Error OKAY button");
        if (flagScriptErrorOkButton) {
            //waitForVisibilityOfElement(CRVehicletriagepage.scriptError, "Script Error OKAY button");
            assertTrue(flagScriptErrorOkButton, "Script Error OKAY button");
            click(CRVehicleTriagePage.scriptError, "Script error Okay button");
        } else {
            //waitForVisibilityOfElement(CRVehicletriagepage.scriptError, "Script Error OKAY button");
            boolean errorIconAvailablility = isVisibleOnly(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            assertTrue(errorIconAvailablility, "Error icon available on error popup");
            if (errorIconAvailablility) {
             //   assertTrue(errorIconAvailablility, "Error icon available on error popup");
                click(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            }/* else {
                assertFalse(errorIconAvailablility, "Error icon is not available on error popup");
            }*/
            String combineKeys3 = Keys.chord(Keys.TAB);
            sendKeys(combineKeys3, "Tab");
            //waitForVisibilityOfElement(CRVehicleTriagePage.scriptError, "Script Error OKAY button");
            String combineKeys2 = Keys.chord(Keys.SPACE);
            sendKeys(combineKeys2, "SPACE");
            /* waitForVisibilityOfElement(CRVehicletriagepage.scriptError, "Script Error OKAY button");
               JSClick(CRVehicletriagepage.scriptError, "Script error Okay button");*/
        }
    }

    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: enterStreetAddressNo
     * description ::
     * date :: 06-02-2018
     * author :: Abhiram
     */
    public void enterStreetAddressNo(String StreetAddressNo) throws Throwable {
        //waitForInVisibilityOfElement(CRTowDestinationPage.txtTowStreetAddressNo,"Street Address Number");
        type(CRTowDestinationPage.txtTowStreetAddressNo,StreetAddressNo,"Street Address Number");
    }

    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: enterStreetAddressName
     * description ::
     * date :: 06-02-2018
     * author :: Abhiram
     */
    public void enterStreetAddressName(String StreetAddressName) throws Throwable {
        waitForVisibilityOfElement(CRTowDestinationPage.txtTowStreetAddressName,"Street Address Name");
        type(CRTowDestinationPage.txtTowStreetAddressName,StreetAddressName,"Street Address Name");
    }

    /**
     * param ::String
     * return ::void
     * throws :: throwable
     * methodName :: enterStreetAddressName
     * description ::
     * date :: 06-02-2018
     * author :: Abhiram
     */
    public void enterZIP(String ZIP) throws Throwable {
        waitForVisibilityOfElement(CRTowDestinationPage.txtTowZIP,"ZIP");
        type(CRTowDestinationPage.txtTowZIP,ZIP,"ZIP");
    }

    public void enterTowDestinationLocationFields(String TowAddress) throws Throwable {
        String TowAddressVal[] =  TowAddress.split("#");
        Thread.sleep(2000);
        errorAlertHandlingBeforeEnterMandatoryFields();
        clickOnManualEntryLinkOnTowDestination();
        enterTowLocationName(TowAddressVal[0]);
        enterStreetAddressNo(TowAddressVal[1]);
        enterStreetAddressName(TowAddressVal[2]);
        enterFirstCrossStreet(TowAddressVal[3]);
        enterSecondCrossStreet(TowAddressVal[4]);
        enterCityCodeInTow(TowAddressVal[5]);
        enterStateInTow(TowAddressVal[6]);
        enterZIP(TowAddressVal[7]);
        enterLandMarkInTow(TowAddressVal[8]);
        enterTowPassengers(TowAddressVal[9]);
    }
}




