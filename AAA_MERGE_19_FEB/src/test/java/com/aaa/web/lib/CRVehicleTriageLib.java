package com.aaa.web.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRServicePage;
import com.aaa.web.page.CRVehicleTriagePage;

import org.openqa.selenium.Keys;



public class CRVehicleTriageLib extends ActionEngine {
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: vehicleFieldVerification
     * description ::
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void vehicleFieldVerification() throws Throwable {
        verifyVehicleType();
        verifyVehicleYear();
        verifyVehicleMake();
        verifyVehicleModel();
        verifyVehicleColor();
        verifyPacesetterCode();
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleType
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyVehicleType() throws Throwable {
        boolean flagvtype = isVisibleOnly(CRVehicleTriagePage.txtVehicleType, "Vehicle Type");
        //if (flagvtype) {
            assertTrue(flagvtype, "Vehicle Type is Mandatory Field");
        //}
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleYear
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyVehicleYear() throws Throwable {
        boolean flagvyear = isVisibleOnly(CRVehicleTriagePage.txtVehicleYear, "Vehicle Year");
        //if (flagvyear) {
            assertTrue(flagvyear, " Vehicle Year is Mandatory Field ");
        //}
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleMake
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyVehicleMake() throws Throwable {
        boolean flagvmake = isVisibleOnly(CRVehicleTriagePage.txtVehicleMake, "Make");
        //if (flagvmake) {
            assertTrue(flagvmake, "Make is Mandatory Field");
        //}
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleModel
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyVehicleModel() throws Throwable {
        boolean flagvmodel = isVisibleOnly(CRVehicleTriagePage.txtVehicleModel, "Model");
        //if (flagvmodel) {
            assertTrue(flagvmodel, "Model is Mandatory Field");
        //}
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleColor
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyVehicleColor() throws Throwable {
        boolean flagvColor = isVisibleOnly(CRVehicleTriagePage.txtVehicleColor, "Color");
        //if (flagvColor) {
            assertTrue(flagvColor, "Color is Mandatory Field");
        //}
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: verifyPacesetterCode
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void verifyPacesetterCode() throws Throwable {
        boolean flagvPacesetterCode = isVisibleOnly(CRVehicleTriagePage.txtPaceSetterCode, "PacesetterCode");
        //if (flagvPacesetterCode) {
            assertTrue(flagvPacesetterCode, "PacesetterCode is Mandatory Field");
        //}
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: cleanAndSaveVehicleDetails
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void cleanAndSaveVehicleDetails(String VehicleType, String VehicleYear, String VehicleMake, String VehicleModel, String VehicleColor, String pageSettercode) throws Throwable {
        clearVehicleMandatoryFields();
        enterandSaveVehicleMandatoryFields(VehicleType, VehicleYear, VehicleMake, VehicleModel, VehicleColor, pageSettercode);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clearVehicleMandatoryFields
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clearVehicleMandatoryFields() throws Throwable {
        click(CRVehicleTriagePage.vehicleTriageTab, "vehicle/TriageTab");
        /*home.clickOnManualEntryLink("vehicle");*/
        clearData(CRVehicleTriagePage.txtVehicleType);
        clearData(CRVehicleTriagePage.txtVehicleYear);
        clearData(CRVehicleTriagePage.txtVehicleMake);
        clearData(CRVehicleTriagePage.txtVehicleModel);
        clearData(CRVehicleTriagePage.txtVehicleColor);

    }

    public void enterandSaveVehicleMandatoryFields(String VehicleType, String VehicleYear, String VehicleMake, String VehicleModel, String VehicleColor, String paceSettercode) throws Throwable {
        errorAlertHandlingBeforeEnterMandatoryFields();
        enterVehicleType(VehicleType);
        Thread.sleep(1000);
        enterVehicleYear(VehicleYear);
        Thread.sleep(1000);
        enterVehicleMake(VehicleMake);
        Thread.sleep(1000);
        enterVehicleModel(VehicleModel);
        Thread.sleep(1000);
        enterVehicleColor(VehicleColor);
        Thread.sleep(1000);
        selectpaceSettercode(paceSettercode);

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleType
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterVehicleType(String VehicleType) throws Throwable {
        clearData(CRVehicleTriagePage.txtVehicleType);
        type(CRVehicleTriagePage.txtVehicleType, VehicleType, "VehicleType");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleYear
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterVehicleYear(String VehicleYear) throws Throwable {
        clearData(CRVehicleTriagePage.txtVehicleYear);
        type(CRVehicleTriagePage.txtVehicleYear, VehicleYear, "VehicleYear");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleMake
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterVehicleMake(String VehicleMake) throws Throwable {
        clearData(CRVehicleTriagePage.txtVehicleMake);
        Thread.sleep(2000);
        click(CRVehicleTriagePage.txtVehicleMake,"Make Field");
        type(CRVehicleTriagePage.txtVehicleMake, VehicleMake, "VehicleMake");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleModel
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterVehicleModel(String VehicleModel) throws Throwable {
        clearData(CRVehicleTriagePage.txtVehicleModel);
        type(CRVehicleTriagePage.txtVehicleModel, VehicleModel, "VehicleModel");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterVehicleColor
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterVehicleColor(String VehicleColor) throws Throwable {
        clearData(CRVehicleTriagePage.txtVehicleColor);
        type(CRVehicleTriagePage.txtVehicleColor, VehicleColor, "VehicleColor");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectpageSettercode
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void selectpaceSettercode(String paceSettercode) throws Throwable {
        click(CRVehicleTriagePage.txtPacesetterCode, "pageSettercode");
        type(CRVehicleTriagePage.txtPacesetterCode, paceSettercode, "pageSettercode");
        //mouseDoubleClick()
        //waitForVisibilityOfElement(CRVehicleTriagePage.doubleClickPaceCode, "Double Click on PaceSetterCode");
        mouseDoubleClick(CRVehicleTriagePage.doubleClickPaceCode, "Double click on pageSettercode");
        //Script Error
        Thread.sleep(2000);

        boolean flagScriptErrorOkButton = isVisibleOnly(CRVehicleTriagePage.scriptError, "Script Error OKAY button");

        if (flagScriptErrorOkButton) {

            //waitForVisibilityOfElement(CRVehicletriagepage.scriptError, "Script Error OKAY button");
            //assertTrue(flagScriptErrorOkButton, "Script Error OKAY button");
            click(CRVehicleTriagePage.scriptError, "Script error Okay button");

        } else {

            //waitForVisibilityOfElement(CRVehicletriagepage.scriptError, "Script Error OKAY button");

            boolean errorIconAvailablility = isVisibleOnly(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            //assertTrue(errorIconAvailablility, "Error icon available on error popup");
            if (errorIconAvailablility) {
               // assertTrue(errorIconAvailablility, "Error icon available on error popup");
                click(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            } /*else {
                assertFalse(errorIconAvailablility, "Error icon is not available on error popup");
            }*/


            String combineKeys3 = Keys.chord(Keys.TAB);

            sendKeys(combineKeys3, "Tab");

            //waitForVisibilityOfElement(CRVehicleTriagePage.scriptError, "Script Error OKAY button");

            String combineKeys2 = Keys.chord(Keys.SPACE);

            sendKeys(combineKeys2, "SPACE");

            /*       waitForVisibilityOfElement(CRVehicletriagepage.scriptError, "Script Error OKAY button");

               JSClick(CRVehicletriagepage.scriptError, "Script error Okay button");*/

        }
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnVehicleDestinationTab
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickOnVehicleTriageTab() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.vehicleTriageTab, "Vehicle Tab");
        click(CRVehicleTriagePage.vehicleTriageTab, "Vehicle Tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: errorAlertHandlingBeforeEnterMandatoryFields
     * description :: To Handle errors
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void errorAlertHandlingBeforeEnterMandatoryFields() throws Throwable {
        boolean flagscriprErr = isVisibleOnly(CRVehicleTriagePage.errorAlertOK, "Error Alert OK button");
        if (flagscriprErr) {
            click(CRVehicleTriagePage.errorAlertOK, "Error Alert OK Button");
        }
        boolean flagScriptErrorAlert = isVisibleOnly(CRVehicleTriagePage.scriptError, "Script Error OKAY button");
        if (flagScriptErrorAlert) {
            JSClick(CRVehicleTriagePage.scriptError, "Script error Okay button");
        }
        boolean flagConformButtonOk = isVisibleOnly(CRVehicleTriagePage.btnAlertSaveYes, "Confirmation okay button");
        if (flagConformButtonOk) {
            click(CRVehicleTriagePage.btnAlertSaveYes, "Confirmation Okay button");
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: vehicletriageTabsel
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void vehicletriageTabsel() throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.vehicleTriageTab, "Vehicle triage tab");
        click(CRVehicleTriagePage.vehicleTriageTab, "Vehicle tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: Vehicleinfolink
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void Vehicleinfolink() throws Throwable {
        isVisible(CRVehicleTriagePage.linkVehicleModel, "vehicle model");
        waitForVisibilityOfElement(CRVehicleTriagePage.linkVehicleModel, "Vehicle model");
        click(CRVehicleTriagePage.linkVehicleModel, "Vehicle model");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: Vehicletype
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void Vehicletype(String Vehicletype) throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.dropboxVehicleType, "Vehicle type");
        type(CRVehicleTriagePage.dropboxVehicleType, Vehicletype, "Vehicle Type");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: Entervehicleinfomanually
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void Entervehicleinfomanually(String Vehiclemodel) throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleSrch, "Vehicle model search");
        type(CRVehicleTriagePage.txtVehicleSrch, Vehiclemodel, "Vechile model search");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickVehicleSearchButton
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clickVehicleSearchButton() throws Throwable {
        //boolean falg = isVisibleOnly(CRVehicletriagepage.btnVehiclesrch, "Vechile search");
    	Thread.sleep(3000);
    	waitForVisibilityOfElement(CRVehicleTriagePage.btnVehicleSrch, "Vehicle search button");
        click(CRVehicleTriagePage.btnVehicleSrch, "Vehicle search button");
        mouseDoubleClick(CRVehicleTriagePage.btnVehicleSrch, "Vehicle search button");
        //JSClick(CRVehicletriagepage.btnVehiclesrch, "Vehicle search button");
        //JSClickUntil(CRVehicletriagepage.btnVehiclesrch, CRVehicletriagepage.btnVehiclesrch, "Vehicle search button");
        //mouseClick(CRVehicletriagepage.btnVehiclesrch, "Vehicle search button");
        //Thread.sleep(3000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: availableVehicleaftersrch
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void availableVehicleaftersrch() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.linkAvailbleVehicleModel, "Avilable vehicle models after search");
        dynamicWait(CRVehicleTriagePage.linkAvailbleVehicleModel);
        click(CRVehicleTriagePage.linkAvailbleVehicleModel, "Available vehicle model");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: vehicleColor
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void vehicleColor(String Vehiclecolor) throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.dropboxVehicleColor, "Vehiclecolor");
        clearData(CRVehicleTriagePage.txtVehicleColor);
        type(CRVehicleTriagePage.dropboxVehicleColor, Vehiclecolor, "Vehicle color");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: pacesetterCodegeneration_Keysissue
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void pacesetterCodegeneration_Keysissue() throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.linkKeys, "Keys link");
        click(CRVehicleTriagePage.linkKeys, "Keys link");
        waitForVisibilityOfElement(CRVehicleTriagePage.rdBtnKeysissue, "Key issue description");
        click(CRVehicleTriagePage.rdBtnKeysissue, "Key issue description radio button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validatePaceSetterCode
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void validatePaceSetterCode(String Pacesettercode) throws Throwable {

        if (isElementPresent(CRVehicleTriagePage.txtPaceSetterCode, "Pacesetter code text")) {

            String labelPaceSetter = getText(CRVehicleTriagePage.txtPaceSetterCode, "Pacesetter code text");
            assertTrue(labelPaceSetter.contains(Pacesettercode), "Expected pacesetter code :" + Pacesettercode);
        } else {
            waitForVisibilityOfElement(CRVehicleTriagePage.linkPacesetterCodeCancel, "Pacesetter code cancel link");
            click(CRVehicleTriagePage.linkPacesetterCodeCancel, "Pacesetter code cancel link");

        }


    }

    /**
     * �* param :: String inputs
     * �* return ::void
     * �* throws :: throwable
     * �* methodName :: enterVehicleDetails
     * �* description :: To enter Vehicle Details
     * �* date :: 05-Dec-2017
     * �* author ::Lakshmi Prasanna
     * �
     */
    public void enterVehicleDetails(String Vehicletype, String Vehiclecolor, String Vehiclemodel) throws Throwable {
        vehicletriageTabsel();
        if (isElementPresent(CRVehicleTriagePage.linkVehicleModel, "vehicle model")) {

            Vehicleinfolink();
            Vehicletype(Vehicletype);
            vehicleColor(Vehiclecolor);
        } else {
            Entervehicleinfomanually(Vehiclemodel);
            clickVehicleSearchButton();
            availableVehicleaftersrch();
            vehicleColor(Vehiclecolor);
        }
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectVehicleModel
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void selectVehicleModel() throws Throwable {
        clickOnVehicleTriageTab();
        selectExistingVehicleModel();
        generatePacesetterCode();
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clicOnVehicletriageTab
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void clicOnVehicletriageTab() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.tabVehicletriage, "Vehicle triage tab");
        click(CRVehicleTriagePage.tabVehicletriage, "Vehicle tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectExistingVehicleModel
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void selectExistingVehicleModel() throws Throwable {
        clickOnVehicleTriageTab();
        waitForVisibilityOfElement(CRVehicleTriagePage.linkVehicleModel, "Vehicle model");
        click(CRVehicleTriagePage.linkVehicleModel, "Vehicle model");
        Thread.sleep(2000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: generatePacesetterCode
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void generatePacesetterCode() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.linkKeys, "Keys link");
        click(CRVehicleTriagePage.linkKeys, "Keys link");
        waitForVisibilityOfElement(CRVehicleTriagePage.rdBtnKeysissue, "Key issue description");
        click(CRVehicleTriagePage.rdBtnKeysissue, "Key issue description radio button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectJumpStartFromBattery
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void selectJumpStartFromBattery() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.linkBattery, "Battery link");
        click(CRVehicleTriagePage.linkBattery, "Battery link");
        Thread.sleep(3000);
        waitForVisibilityOfElement(CRVehicleTriagePage.rdBtnBatteryIssue, "Key issue description");
        isElementPresent(CRVehicleTriagePage.batteryProblem, "Battery Problem Description");
        click(CRVehicleTriagePage.rdBtnBatteryIssue, "Key issue description radio button");
        Thread.sleep(3000);
       /* waitForVisibilityOfElement(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button");
        click(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button");*/
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPacesetterCodeBattery
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterPacesetterCodeBattery(String Pacesettercode) throws Throwable {
        isElementPresent(CRVehicleTriagePage.batteryProblem, "Battery Problem Description");
        waitForVisibilityOfElement(CRVehicleTriagePage.txtPacesetterCodeManual, "Pacesetter code manual entry");
        type(CRVehicleTriagePage.txtPacesetterCodeManual, Pacesettercode, "Pacesetter code manual");
        waitForVisibilityOfElement(CRVehicleTriagePage.selcManualPacesetterCodeBattery, "Select manual pacesettercode");
        mouseClick(CRVehicleTriagePage.selcManualPacesetterCodeBattery, "Select manual pacesettercode");
        Thread.sleep(3000);
        waitForVisibilityOfElement(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button");
        click(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button");

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: manualPacesetterCodekey
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void manualPacesetterCodekey(String Pacesettercode) throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.txtPacesetterCodeManual, "Pacesetter code manual entry");
        type(CRVehicleTriagePage.txtPacesetterCodeManual, Pacesettercode, "Pacesetter code manual");
        waitForVisibilityOfElement(CRVehicleTriagePage.selcManualPacesetterCodekey, "Select manual pacesettercode");
        mouseClick(CRVehicleTriagePage.selcManualPacesetterCodekey, "Select manual pacesettercode");
        if(isVisibleOnly(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button"))
        click(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validatePacesetterCode
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void validatePacesetterCode(String Pacesettercode) throws Throwable {
        //String PaceSetterCode = getText(CRVehicletriagepage.selectPacesettercode, "get Pacesetter code");
        assertTextMatching(CRVehicleTriagePage.selectPacesetterCode, Pacesettercode, "validate pace setter code");
    }

    /**
     * �* param :: String inputs
     * �* return ::void
     * �* throws :: throwable
     * �* methodName :: manpacecodeTow_enterpacesettcode
     * �* description :: To enter tow related pacesetter code manually
     * �* date :: 05-Dec-2017
     * �* author ::Parameswar Yenduri
     * �
     */

    public void manpacecodeTow_enterpacesettcode(String Pacesettercode) throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.txtPacesetterCodeManual, "Pacesetter code manual entry");
        type(CRVehicleTriagePage.txtPacesetterCodeManual, Pacesettercode, "pacesetter code manual entry");
        waitForVisibilityOfElement(CRVehicleTriagePage.selcManualPacesetterCodeTow, "Select manual pacesettercode with Tow");
        mouseClick(CRVehicleTriagePage.selcManualPacesetterCodeTow, "Select manual pacesettercode with Tow");
    }

    /**
     * �* param :: String inputs
     * �* return ::void
     * �* throws :: throwable
     * �* methodName :: manupacecodeTow_btn
     * �* description :: To handle popup
     * �* date :: 05-Dec-2017
     * �* author ::Parameswar Yenduri
     * �
     */

    public void manupacecodeTow_btn() throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button");
        click(CRVehicleTriagePage.btnDialogOkBtn, "pacesettercode manual entry ok button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectvehicle
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void selectvehicle() throws Throwable {

        clicOnVehicletriageTab();
        selectExistingVehicleModel();
        generatePacesetterCode();
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectExistingVehicleLink
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void selectExistingVehicleLink(String Vehicletype, String Vehiclecolor) throws Throwable {

        Vehicleinfolink();
        Vehicletype(Vehicletype);
        vehicleColor(Vehiclecolor);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterNewVechiledeatils
     * description :: To clear Mandatory Fields on Vehicle Tab
     * date :: 29-Nov-2017
     * author :: Lakshmi Prasanna
     */
    public void enterNewVechiledeatils(String Vehiclemodel, String Vehiclecolor) throws Throwable {
        Entervehicleinfomanually(Vehiclemodel);
        clickVehicleSearchButton();
        availableVehicleaftersrch();
        vehicleColor(Vehiclecolor);
    }

    /**
     * �* param :: String inputs
     * �* return ::void
     * �* throws :: throwable
     * �* methodName :: selectPaceSetterCode
     * �* description :: To handle popup
     * �* date :: 05-Dec-2017
     * �* author ::Lakshmi Prasanna
     * �
     */
    public void selectPaceSetterCode() throws Throwable {

        waitForVisibilityOfElement(CRVehicleTriagePage.linkKeys, "Keys link");
        click(CRVehicleTriagePage.linkKeys, "Keys link");
        Thread.sleep(5000);
        waitForVisibilityOfElement(CRVehicleTriagePage.rdBtnKeysissue, "Key issue description");
        click(CRVehicleTriagePage.rdBtnKeysissue, "Key issue description radio button");
        Thread.sleep(5000);
    }

    public void clickOnManualEntryLinkOnVehicle() throws Throwable {
        click(CRVehicleTriagePage.linkManualEntryLinkOnVehicleTriage, "ManualEntry Link");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFuel
     * description ::
     * date :: 18-Dec-2017
     * author ::
     */
    public void clickOnFuel() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.btnFuel, "Fuel");
        click(CRVehicleTriagePage.btnFuel, "Fuel");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnOutOfGas
     * description ::
     * date :: 18-Dec-2017
     * author ::
     */
    public void clickOnOutOfGas() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnOutOfGas, "Out Of Gas");
        click(CRVehicleTriagePage.rbtnOutOfGas, "Out Of Gas");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTire
     * description ::
     * date :: 18-Dec-2017
     * author ::
     */
    public void clickOnFlatTire() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.btnFlatTire, "Flat Tire");
        click(CRVehicleTriagePage.btnFlatTire, "Flat Tire");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTireFrontSide
     * description ::
     * date :: 18-Dec-2017
     * author ::
     */
    public void clickOnFlatTireFrontSide() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnDriverFrontSide, "Flat Tire Front Side");
        click(CRVehicleTriagePage.rbtnDriverFrontSide, "Flat Tire Front Side");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTireSpareTireYes
     * description ::
     * date :: 18-Dec-2017
     * author ::
     */
    public void clickOnFlatTireSpareTireYes() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnClickYesOnSpareTire, "Spare Tire Yes");
        click(CRVehicleTriagePage.rbtnClickYesOnSpareTire, "Spare Tire Yes");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTireLockingLugNuts
     * description ::
     * date :: 18-Dec-2017
     * author ::
     */
    public void clickOnFlatTireLockingLugNuts() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnClickOnLockingLugNuts, "Locking Lug Nuts");
        click(CRVehicleTriagePage.rbtnClickOnLockingLugNuts, "Locking Lug Nuts");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: selectExistingVehicle
     * description ::
     * date :: 18-Dec-2017
     * author ::
     */
    public void selectExistingVehicle() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.selectVehicle, "Vehicle model");
        click(CRVehicleTriagePage.selectVehicle, "Vehicle model");
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
    public void handleScriptErrorInVehicleTriagePage() throws Throwable {
        boolean flagScriptErrorOkButton = isVisibleOnly(CRVehicleTriagePage.scriptError, "Script Error OKAY button");
        if (flagScriptErrorOkButton) {
            //waitForVisibilityOfElement(CRVehicletriagepage.scriptError, "Script Error OKAY button");
            //assertTrue(flagScriptErrorOkButton, "Script Error OKAY button");
            click(CRVehicleTriagePage.scriptError, "Script error Okay button");
        } else {
            //waitForVisibilityOfElement(CRVehicletriagepage.scriptError, "Script Error OKAY button");
            boolean errorIconAvailablility = isVisibleOnly(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            //assertTrue(errorIconAvailablility, "Error icon available on error popup");
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
     * return ::void
     * throws :: throwable
     * methodName :: clickOnLeftLightOnRadioBtnOfBattery
     * description :: click on Left LightOn Radio Button
     * date :: 18-Dec-2017
     * author ::Nidhi
     */
    public void clickOnLeftLightOnRadioBtnOfBattery() throws Throwable {
        boolean leftLightLiteOnradioBtn = isVisibleOnly(CRVehicleTriagePage.radioBtnLeftLightOnBattery, "LeftLightOn RadioBtn");
        if (leftLightLiteOnradioBtn) {
            click(CRVehicleTriagePage.radioBtnLeftLightOnBattery, "Click On LeftLightOn RadioBtn");
        }else{
            assertTrue(!leftLightLiteOnradioBtn,"LeftLightOn RadioBtn is not visible");
        }
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: validatePaceSetterInSummaryPopUpWindow
     * description :: This Function is used to validate selected pace setter code is displayed in Call Summary POpUp window
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void validatePaceSetterInSummaryPopUpWindow(String pacesetter) throws Throwable {
        //waitForVisibilityOfElement(CRVehicleTriagePage.selectVehicle, "Vehicle model");
        String strSummaryPopUpPaceSetterCode = getText(CRVehicleTriagePage.lblPacesetterCodesInSummaryPopUp,"Call Summary Pop Up Pacesetter Code");
        assertTrue(pacesetter.equalsIgnoreCase(strSummaryPopUpPaceSetterCode), "Selected Pacesetter Codes is displayed Call Summary popup window");
        /*if ( pacesetter == strSummaryPopUpPaceSetterCode ){
            assertTrue(pacesetter == strSummaryPopUpPaceSetterCode, "Selected Pacesetter Codes is displayed Call Summary popup window");
        }
        else {
            assertFalse(pacesetter == strSummaryPopUpPaceSetterCode, "Selected Pacesetter Codes is displayed Call Summary popup window");
        }*/
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateQuestionDisplayedInTriageSection
     * description :: This Function validates if Question fires off and displays to the user in Triage Section
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void validateQuestionDisplayedInTriageSection() throws Throwable {

        String strTriageQuestion = getText(CRVehicleTriagePage.lblTriageQuestion,"Triage Question");
        assertTrue(strTriageQuestion != "", "Question fires off and displays to the user");
        /*if ( strTriageQuestion != "") {
            assertTrue(strTriageQuestion != "", "Question fires off and displays to the user");
        }
        else {
            assertFalse(strTriageQuestion != "", "Question not displayed to the user");
        }*/
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateNoPacesetterCodeAssigned
     * description :: This Function validates that No pacesetter code is assigned
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void validateNoPacesetterCodeAssigned(String pagesetterinfo) throws Throwable {
        String strPaceSetterInfo = getText(CRVehicleTriagePage.lblPaceSetterNotSelected,"Triage Question");
        assertTrue(strPaceSetterInfo.equalsIgnoreCase(pagesetterinfo), "No pacesetter code assigned");
        /*if ( strPaceSetterInfo.equalsIgnoreCase(pagesetterinfo) ) {
            assertTrue(strPaceSetterInfo.equalsIgnoreCase(pagesetterinfo), "No pacesetter code assigned");
        }
        else {
            assertFalse(strPaceSetterInfo.equalsIgnoreCase(pagesetterinfo), "pacesetter code is assigned");
        }*/
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName ::lblSelectedPaceSetterCodes
     * description ::get text for label pace setter codes
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void lblSelectedPaceSetterCodes() throws Throwable {
        boolean visibilityOfSelectedPaceSetterCodes = isVisibleOnly(CRVehicleTriagePage.lblCallSummaryPaceSetterCodes, " Label Pacesetter Codes");
        assertTrue(visibilityOfSelectedPaceSetterCodes, "Pace Setter Codes is available");
        if (visibilityOfSelectedPaceSetterCodes) {
         //   assertTrue(visibilityOfSelectedPaceSetterCodes, "Pace Setter Codes is available");
            String paceSetterCodes = getText(CRVehicleTriagePage.lblCallSummaryPaceSetterCodes, "Pace Setter Codes is available");
        }/* else {
            assertFalse(visibilityOfSelectedPaceSetterCodes, " Pace Setter Codes is not available");
        }*/
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallSummary
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnCallSummary() throws Throwable {
        click(CRVehicleTriagePage.btnCallSummary, "Call Summary Button");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: lblCallSummaryPaceSetterCodes
     * description ::get text for label pace setter codes in summary window
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public String lblCallSummaryPaceSetterCodes() throws Throwable {
        boolean visibilityOfSummaryPaceSetterCodes = isVisibleOnly(CRVehicleTriagePage.lblCallSummaryPaceSetterCodes, " Label Pacesetter Codes");
        assertTrue(visibilityOfSummaryPaceSetterCodes, "Summary Call Window.");

        String summaryPaceSetterCodes = getText(CRVehicleTriagePage.lblCallSummaryPaceSetterCodes, "Pace Setter Codes is available in Summary Window");
        assertTrue(visibilityOfSummaryPaceSetterCodes, "Pace Setter Codes is available in Summary Window");
        return summaryPaceSetterCodes;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: lblCallSummaryPaceSetterCodes
     * description ::get text for label pace setter codes in summary window
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterVehicleSearch(String vehicleSearch) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleSearch,"Vehicle Search");
        type(CRVehicleTriagePage.txtVehicleSearch,vehicleSearch, "Vehicle Search");

    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getVehcileSearchDetails
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getVehcileSearchDetails() throws Throwable {
        //String vehicleSearchDetailsLocator = String.valueOf(CRVehicleTriagePage.txtVehicleSearch);
        String vehicleSearchDetails = getAttributeByValue(CRVehicleTriagePage.txtVehicleSearch,"Vehicle Search");
        return vehicleSearchDetails;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTheVehicleSearchIcon
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnTheVehicleSearch() throws Throwable {
        click(CRVehicleTriagePage.lnkVehicleSearch, "Vehicle link search");
    }



    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTrim
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterTrim(String trim) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleTrim,"Vehicle trim");
        type(CRVehicleTriagePage.txtVehicleTrim,trim, "Vehicle trim");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTrimValue
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getTrimValue() throws Throwable {
        //String trimlocator = String.valueOf(CRVehicleTriagePage.txtVehicleTrim);
        String trim = getAttributeByValue(CRVehicleTriagePage.txtVehicleTrim,"Vehicle Trim");
        return trim;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterTag
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterTag(String tag) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleTag,"Vehicle tag");
        type(CRVehicleTriagePage.txtVehicleTag,tag, "Vehicle tag");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTagValue
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getTagValue() throws Throwable {
        //String taglocator = String.valueOf(CRVehicleTriagePage.txtVehicleTag);
        String tag = getAttributeByValue(CRVehicleTriagePage.txtVehicleTag,"Vehicle Tag");
        return tag;

    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterState
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterState(String state) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleState,"Vehicle state");
        type(CRVehicleTriagePage.txtVehicleState,state, "Vehicle state");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getStateValue
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getStateValue() throws Throwable {
        //String statelocator = String.valueOf(CRVehicleTriagePage.txtVehicleState);
        String state = getAttributeByValue(CRVehicleTriagePage.txtVehicleState,"Vehicle State");
        return state;

    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterFlat
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterFlat(String flat) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleFlat,"Vehicle flat");
        type(CRVehicleTriagePage.txtVehicleFlat,flat, "Vehicle flat");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFlatValue
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getFlatValue() throws Throwable {
        //String flatlocator = String.valueOf(CRVehicleTriagePage.txtVehicleFlat);
        String flat = getAttributeByValue(CRVehicleTriagePage.txtVehicleFlat,"Vehicle Flat");
        return flat;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterNote
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterNote(String note) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleNote,"Vehicle note");
        type(CRVehicleTriagePage.txtVehicleNote,note, "Vehicle note");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getNoteValue
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getNoteValue() throws Throwable {
        //String notelocator = String.valueOf(CRVehicleTriagePage.txtVehicleNote);
        String note = getAttributeByValue(CRVehicleTriagePage.txtVehicleNote,"Vehicle Note");
        return note;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnMoreInfoTab
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnMoreInfoTab() throws Throwable {
        click(CRVehicleTriagePage.btnMoreinfoTab, "click on more info tab");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterSubTypeOnMoreInfoTab
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterSubTypeOnMoreInfoTab(String subType) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabSubType,"More Info Tab subType");
        type(CRVehicleTriagePage.txtMoreInfoTabSubType,subType, "More Info Tab subType");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterEngineTypeOnMoreInfoTab
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterEngineTypeOnMoreInfoTab(String engineType) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabEngineType,"More Info Tab engineType");
        type(CRVehicleTriagePage.txtMoreInfoTabEngineType,engineType, "More Info Tab engineType");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterCommentOnMoreInfoTab
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterCommentOnMoreInfoTab(String comment) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabComment,"More Info Tab comment");
        type(CRVehicleTriagePage.txtMoreInfoTabComment,comment, "More Info Tab comment");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterLegnthOnMoreInfoTab
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterLegnthOnMoreInfoTab(String length) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabLength,"More Info Tab length");
        type(CRVehicleTriagePage.txtMoreInfoTabLength,length, "More Info Tab length");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterHeightOnMoreInfoTab
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterHeightOnMoreInfoTab(String height) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabHeight,"More Info Tab height");
        type(CRVehicleTriagePage.txtMoreInfoTabHeight,height, "More Info Tab height");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterWeightOnMoreInfoTab
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterWeightOnMoreInfoTab(String weight) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabWeight,"More Info Tab weight");
        type(CRVehicleTriagePage.txtMoreInfoTabWeight,weight, "More Info Tab weight");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterClassOnMoreInfoTab
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void enterClassOnMoreInfoTab(String Class) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtMoreInfoTabClass,"More Info Tab Class");
        type(CRVehicleTriagePage.txtMoreInfoTabClass,Class, "More Info Tab Class");
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: lblCallSummaryPaceSetterCodes
     * description ::get text for label pace setter codes in summary window
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void vehicleLinkTextAfterFilter() throws Throwable {
        boolean visibilityOfVehicleName = isVisibleOnly(CRVehicleTriagePage.lnkVehicleSearch, " Label Pacesetter Codes");
        assertTrue(visibilityOfVehicleName, "Pace Setter Codes is available in Summary Window");
        if (visibilityOfVehicleName) {
         //   assertTrue(visibilityOfVehicleName, "Pace Setter Codes is available in Summary Window");
            String vehicleName = getText(CRVehicleTriagePage.lnkVehicleSearch, "Pace Setter Codes is available in Summary Window");
        }/* else {
            assertFalse(visibilityOfVehicleName, " Pace Setter Codes is not available in Summary Window");
        }*/
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTheVehicleSearchIcon
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnTheVehicleSearchIcon() throws Throwable {
        //JSClick(CRVehicleTriagePage.lnkVehicleSearchIcon, "Vehicle link search Icon");
        String combineKeys3 = Keys.chord(Keys.TAB);
        sendKeys(combineKeys3, "Tab");
        Thread.sleep(3000);
        String combineKeys2 = Keys.chord(Keys.SPACE);
        sendKeys(combineKeys2, "SPACE");
        Thread.sleep(3000);
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnClearAllFileds
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnClearAllFileds() throws Throwable {
        click(CRVehicleTriagePage.lnkClearAllFIelds, "Clear All Fields");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTheTypeSearchFromDropDown
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnTheTypeSearchFromDropDown() throws Throwable {
        click(CRVehicleTriagePage.lnkVehicleTypeSearchFromDropDown, "Vehicle Type search");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTheModelSearchFromDropDown
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnTheModelSearchFromDropDown() throws Throwable {
        click(CRVehicleTriagePage.linVehicleModelSearchFromDropDown, "Vehicle Model search");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTheModelSearchFromDropDown
     * description ::
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public void clickOnTheClassSearchFromDropDown() throws Throwable {
        click(CRVehicleTriagePage.lnkClassFromMoreInfoTabFromDropDown, "Class search from More Info Tab");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTypeValue
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getTypeValue() throws Throwable {
        //String typelocator = String.valueOf(CRVehicleTriagePage.txtVehicleType);
        String type = getAttributeByValue(CRVehicleTriagePage.txtVehicleType,"Vehicle Type");
        return type;
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getMoreInfoTab
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public void getMoreInfoTab() throws Throwable {
        boolean visibilityOfMoreInfoTab = isVisibleOnly(CRVehicleTriagePage.btnMoreinfoTab, " More Info Tab");
        /*if (visibilityOfMoreInfoTab) {
            assertTrue(visibilityOfMoreInfoTab, "More Info Tab exists");
        } else {
            assertFalse(visibilityOfMoreInfoTab, "More Info Tab Not Appears");
        }*/
        assertTrue(visibilityOfMoreInfoTab, "More Info Tab exists");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getYearValue
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getYearValue() throws Throwable {
        //String yearlocator = String.valueOf(CRVehicleTriagePage.txtVehicleYear);
        String year = getAttributeByValue(CRVehicleTriagePage.txtVehicleYear,"Vehicle Year");
        return year;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMakeValue
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getMakeValue() throws Throwable {
        //String makelocator = String.valueOf(CRVehicleTriagePage.txtVehicleMake);
        String make = getAttributeByValue(CRVehicleTriagePage.txtVehicleMake,"Vehicle Make");
        return make;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getModelValue
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getModelValue() throws Throwable {
        //String modellocator = String.valueOf(CRVehicleTriagePage.txtVehicleModel);
        String model = getAttributeByValue(CRVehicleTriagePage.txtVehicleModel,"Vehicle Model");
        return model;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMoreInfoTypeSubType
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getMoreInfoTabSubType() throws Throwable {
        //String subTypelocator = String.valueOf(CRVehicleTriagePage.txtMoreInfoTabSubType);
        String subType = getAttributeByValue(CRVehicleTriagePage.txtMoreInfoTabSubType,"More Info Tab Sub-Type");
        return subType;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMoreInfoTypeEngine
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getMoreInfoTabEngine() throws Throwable {
        //String enginelocator = String.valueOf(CRVehicleTriagePage.txtMoreInfoTabEngineType);
        String engine = getAttributeByValue(CRVehicleTriagePage.txtMoreInfoTabEngineType,"More Info Tab Engine");
        return engine;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMoreInfoTypeComment
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getMoreInfoTabComment() throws Throwable {
        //String commentlocator = String.valueOf(CRVehicleTriagePage.txtMoreInfoTabComment);
        String comment = getAttributeByValue(CRVehicleTriagePage.txtMoreInfoTabComment,"More Info Tab Comment");
        return comment;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehicleTraigeTabExists
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public void verifyVehicleTraigeTabExists() throws Throwable {
        boolean visibilityOfVehicleTriageTab = isVisibleOnly(CRVehicleTriagePage.txtVehicleSearch,"Vehicle Search Box is Exists Under Vehcile Triage Tab");
        /*if (visibilityOfVehicleTriageTab) {
            assertTrue(visibilityOfVehicleTriageTab, "Vehicle/Triage section appeared");
        } else {
            assertFalse(visibilityOfVehicleTriageTab, "Vehicle/Triage section is not appears");
        }*/
        assertTrue(visibilityOfVehicleTriageTab, "Vehicle/Triage section appeared");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: verifyVehiclePriorKnownVehicleExists
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public void verifyVehiclePriorKnownVehicleExists() throws Throwable {
        boolean visibilityOfVehiclePriorKnownVehicle = isVisibleOnly(CRVehicleTriagePage.linkVehicleModel,"Prior Known Vehicle in Vehicle Triage Tab");
        /*if (visibilityOfVehiclePriorKnownVehicle) {
            assertTrue(visibilityOfVehiclePriorKnownVehicle, "Prior Known Vehicles are appeared");
        } else {
            assertFalse(visibilityOfVehiclePriorKnownVehicle, "Prior Known Vehicles are not appears");
        }*/
        assertTrue(visibilityOfVehiclePriorKnownVehicle, "Prior Known Vehicles are appeared");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTyreAirOnlyOption
     * description :: This Function is used to click on Air Only Option in Flat Tyre Section
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void clickOnFlatTyreInAirOnlyOption() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnAirOnly,"Air Only");
        click(CRVehicleTriagePage.rbtnAirOnly, "Air Only");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTyreAirOnlyOption
     * description :: This Function is used to click close icon in Selected Pacesetter code section
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void clickCloseIconInSelectedPaceSetterCodeSection() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.iconCloseSelectedPaceSetterCode,"Close Icon Selected Pacesetter Code Section");
        click(CRVehicleTriagePage.iconCloseSelectedPaceSetterCode, "Close Icon Selected Pacesetter Code Section");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: verifyIconBeginTriageHere
     * description :: This function validates if Icon Begin Triage is present or not
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void verifyIconBeginTriageHere() throws  Throwable{
        boolean flagTriageIcon = isVisibleOnly(CRVehicleTriagePage.iconBeginTriageHere, "Icon Begin Triage Here");
        /*if (flagTriageIcon) {
            assertTrue(flagTriageIcon, "The call no longer has that pacesetter code, Icon Begin Triage is Displayed");
        }else{
            assertFalse(flagTriageIcon,"The call has pacesetter code, Icon Begin Triage is not Displayed");
        }*/
        assertTrue(flagTriageIcon, "The call no longer has that pacesetter code, Icon Begin Triage is Displayed");
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: selectPaceSetterCodeforKeyIssue
     * description ::
     * date :: 01-Jan-2018
     * author :: Abhiram
     */
    public void selectPaceSetterCodeforKeyIssue() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.linkKeys, "Keys link");
        click(CRVehicleTriagePage.linkKeys, "Keys link");
        Thread.sleep(5000);
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnCarStyleInKeys, "Car lock Key Issue");
        click(CRVehicleTriagePage.rbtnCarStyleInKeys, "Car lock Key Issue radio button");
        Thread.sleep(5000);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterClassOnMoreInfoTab
     * description ::
     * date :: 02-Jan-2017
     * author ::Abhiram
     */
    public void enterPaceSetterCode(String paceSetterCode) throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtSelectedPaceSetterCodes,"Selected Pacesetter codes");
        type(CRVehicleTriagePage.txtSelectedPaceSetterCodes,paceSetterCode, "Selected Pacesetter codes");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTheSelectedPaceSetterCodeFromDropDown
     * description ::
     * date :: 02-Jan-2017
     * author ::Abhiram
     */
    public void clickOnTheSelectedPaceSetterCodeFromDropDown() throws Throwable {
        click(CRVehicleTriagePage.lnkSelectedPacesetterCodeFromDropDown, "Selected Pacesetter Code search");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCloseCallSummary
     * description ::
     * date :: 02-Jan-2017
     * author ::Abhiram
     */
    public void clickOnCloseCallSummary() throws Throwable {
        click(CRVehicleTriagePage.iconCloseCallSummary, "Close Call Summary");
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: scriptErrorHandle
     * description ::
     * date :: 02-Jan-2017
     * author ::Chandra
     */
    public void scriptErrorHandle() throws Throwable{
        boolean flagScriptErrorOkButton = isVisibleOnly(CRVehicleTriagePage.scriptError, "Script Error OKAY button");
        if (flagScriptErrorOkButton) {
            //waitForVisibilityOfElement(CRVehicletriagepage.scriptError, "Script Error OKAY button");
            //assertTrue(flagScriptErrorOkButton, "Script Error OKAY button");
            click(CRVehicleTriagePage.scriptError, "Script error Okay button");
        } else {
            //waitForVisibilityOfElement(CRVehicletriagepage.scriptError, "Script Error OKAY button");
            boolean errorIconAvailablility = isVisibleOnly(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            //assertTrue(errorIconAvailablility, "Error icon available on error popup");
            if (errorIconAvailablility) {
               // assertTrue(errorIconAvailablility, "Error icon available on error popup");
                click(CRVehicleTriagePage.iconErrorPopup, "Error icon on java script error popup");
            } /*else {
                assertFalse(errorIconAvailablility, "Error icon is not available on error popup");
            }*/
            String combineKeys3 = Keys.chord(Keys.TAB);
            sendKeys(combineKeys3, "Tab");
            //waitForVisibilityOfElement(CRVehicleTriagePage.scriptError, "Script Error OKAY button");
            String combineKeys2 = Keys.chord(Keys.SPACE);
            sendKeys(combineKeys2, "SPACE");
            /*       waitForVisibilityOfElement(CRVehicletriagepage.scriptError, "Script Error OKAY button");
               JSClick(CRVehicletriagepage.scriptError, "Script error Okay button");*/
        }
    }
   

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTyreAirOnlyOption
     * description :: This Function is used to click on Air Only Option in Flat Tyre Section
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void clickOnAirOnlyOptionInFlatTyreType() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnAirOnly,"Air Only");
        click(CRVehicleTriagePage.rbtnAirOnly, "Air Only");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnCallSummaryIcon
     * description :: This Function is used to click on Call Summary Icon
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void clickOnCallSummaryIcon() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.iconCallSummary,"Call Summary");
        click(CRVehicleTriagePage.iconCallSummary, "Call Summary");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTyreAirOnlyOption
     * description :: This Function is used to click on Air Only Option in Flat Tyre Section
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void clickOnOptionOneTyreChangeDriverSideFrontInFlatTyreType() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnOneTyreChangeDriverSideFront,"One Tyre Change-Driver Side Frony ");
        click(CRVehicleTriagePage.rbtnOneTyreChangeDriverSideFront, "One Tyre Change-Driver Side Frony");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnUnsureRbtnInOptionInFlatTyreType
     * description :: This Function is used to click on Unsure Radio Button for question Do you have a usable spare tyre in Flat tyre type
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void clickOnUnsureRbtnInOptionInFlatTyreType() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnUnsure,"Air Only");
        click(CRVehicleTriagePage.rbtnUnsure, "Air Only");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: closeCallSummaryWindow
     * description :: This Function is used close Call Summary Pop Up Window
     * date :: 1-Jan-2018
     * author :: Sachin
     */
    public void closeCallSummaryPopUpWindow() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.iconCloseCallSummaryPopUpWindow,"Close Icon in Call Summary Call Summary Pop Up Window");
        click(CRVehicleTriagePage.iconCloseCallSummaryPopUpWindow, "Close Icon in Call Summary Call Summary Pop Up Window");
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnTow
     * description ::
     * date :: 3-Jan-2018
     * author :: Chandra
     */
    public void clickOnTow() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.btnTow,"Tow Button");
        click(CRVehicleTriagePage.btnTow, "Tow Button");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnBrakeFailurOnTow
     * description ::
     * date :: 3-Jan-2018
     * author :: Chandra
     */
    public void clickOnBrakeFailurOnTow() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnBreakFailureOnTOWProblem,"Brake Failure");
        click(CRVehicleTriagePage.rbtnBreakFailureOnTOWProblem, "Brake Failure");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateSelectedPaceSetterCode
     * description :: This Function validates if selected page setter code is displayed in Selected Pacesetter section or not
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public void validateSelectedPaceSetterCode() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.lblSelectedPaceSetterCodes,"Selected Pacesetter Codes");
        String strSelectedPaceSetterCodes = getText(CRVehicleTriagePage.lblSelectedPaceSetterCodes,"Selected Pacesetter Codes");
        /*if ( strSelectedPaceSetterCodes != "") {
            assertTrue(strSelectedPaceSetterCodes != "", "Selected Pacesetter Codes is displayed, Name:"+strSelectedPaceSetterCodes);
        }
        else {
            assertFalse(strSelectedPaceSetterCodes != "", "Selected Pacesetter Codes is not displayed");
        }*/
        assertTrue(strSelectedPaceSetterCodes != "", "Selected Pacesetter Codes is displayed, Name:"+strSelectedPaceSetterCodes);
    }


    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTyreNeedsAirRadioButton
     * description :: This Function is used to click on Radio Button Flat Tyre Needs Air
     * date :: 3-Jan-2018
     * author :: Sachin
     */
    public void clickOnFlatTyreNeedsAirRadioButton() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnFlatTyreNeedsAir,"Flat tyre needs air");
        click(CRVehicleTriagePage.rbtnFlatTyreNeedsAir, "Flat tyre needs air");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getCodeNUmberFromSelectedPaceSetterCode
     * description :: This Function is used get the code from selected pacesetter code
     * date :: 2-Jan-2018
     * author :: Sachin
     */
    public String getCodeNumberFromSelectedPaceSetterCode() throws Throwable {

        String pacesettercode = getText(CRVehicleTriagePage.lblSelectedPaceSetterCodes,"Selected Pacesetter Code");
        String code = pacesettercode.substring(0,4);
        return code;
    }

    public void clickOnBatteryButton() throws Throwable {

        click(CRVehicleTriagePage.btnBattery,"Battery Button");
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnJumpStartRadioButton
     * description :: clickOnJumpStartRadioButton
     * date :: 4-Jan-2018
     * author :: Chandrasekhar
     */
    public void clickOnJumpStartRadioButton() throws Throwable {

        click(CRVehicleTriagePage.rdBtnBatteryIssue,"Battery Jump Start");
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnKeysButton
     * description :: clickOnKeysButton
     * date :: 4-Jan-2018
     * author :: Chandrasekhar
     */
    public void clickOnKeysButton() throws Throwable {

        click(CRVehicleTriagePage.btnKeys,"Keys Button");
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnKeysButton
     * description :: clickOnKeysButton
     * date :: 4-Jan-2018
     * author :: Chandrasekhar
     */
    public void clickOnKeysLockedRadioButton() throws Throwable {

        click(CRVehicleTriagePage.rdBtnKeysissue,"Lockout Pacesetter");
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickOnFlatTyreNeedsAirRadioButton
     * description :: This Function is used to click on Radio Button Flat Tyre Needs Air
     * date :: 4-Jan-2018
     * author :: Sachin
     */
    public void clickonProblemTypeButton(String problemtype) throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.btnProblemTypes(problemtype),""+problemtype);
        click(CRVehicleTriagePage.btnProblemTypes(problemtype), ""+problemtype);
    }

    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: clickonProblemTypeOptions
     * description :: This Function is used to click on Radio Button Flat Tyre Needs Air
     * date :: 4-Jan-2018
     * author :: Sachin
     */
    public void clickonProblemTypeOptions(String problemtypeoption) throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.rbtnProblemTypesOptions(problemtypeoption),""+problemtypeoption);
        click(CRVehicleTriagePage.rbtnProblemTypesOptions(problemtypeoption), ""+problemtypeoption);
        //mouseClick(CRVehicleTriagePage.rbtnProblemTypesOptions(problemtypeoption), ""+problemtypeoption);
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: clickOnBreakDownForRVType
     * description :: clickOnBreakDownForRVType
     * date :: 4-Jan-2018
     * author :: Chandrasekhar
     */
    public void clickOnBreakDownForRVType() throws Throwable {

        click(CRVehicleTriagePage.rbthBreakDownFailureForRVValue,"Lockout Pacesetter");
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: enterTag
     * description ::
     * date :: 5 JAN 2018
     * author ::Abhiram
     */
    public void clickTag() throws Throwable
    {
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVehicleTag,"Vehicle tag");
        click(CRVehicleTriagePage.txtVehicleTag,"Vehicle tag");
    }

    public void enterVehicleModelandColor(String vehicleModel, String vehicleColor) throws Throwable {
    	Entervehicleinfomanually(vehicleModel);
        clickVehicleSearchButton();
        availableVehicleaftersrch();
        vehicleColor(vehicleColor);
    }
    public void enterVehicleTypeandColor(String vehicleType, String vehicleColor) throws Throwable {
    	Vehicleinfolink();
        Vehicletype(vehicleType);
        enterVehicleColor(vehicleColor);
    }
    public void enterAndValidatePacesetterCode(String pacesetterCode) throws Throwable {
    	enterPacesetterCodeBattery(pacesetterCode );
        //validate pacesettercode
        validatePacesetterCode(pacesetterCode );
    	
    }
    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: getVehicleColor
     * description ::
     * date :: 19 JAN 2018
     * author ::Lakshmi Prasanna
     */
    public String getVehicleColor()throws  Throwable{
        String color = getAttributeByValue(CRVehicleTriagePage.dropboxVehicleColor,"Vehicle Color");
        return color;
    }


    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: verifyVehicleAvailable
     *  * description ::
     *  * retrivedTime :: 20-Jan-2018
     *  * author :: Abhiram
     *
     */
    public boolean verifyVehicleAvailable()throws  Throwable{

        //waitForVisibilityOfElement(CRVehicleTriagePage.linkVehicleModel, "Existing Vehicles are Not Visible");
        boolean vehicleAvailable = isVisibleOnly(CRVehicleTriagePage.linkVehicleModel, "Existing Vehicles are Not Visible");
        return vehicleAvailable;

    }
    public void enterProblemTypeManually(String ProblemType) throws Throwable {
    	enterPaceSetterCode(ProblemType);
        clickOnTheSelectedPaceSetterCodeFromDropDown();
        Thread.sleep(2000);
        handleScriptErrorInVehicleTriagePage();
    	
    }
    public void enterSingleProblemType(String ProblemType, String ProblemTypeOption1) throws Throwable {
    	clickonProblemTypeButton(ProblemType);
        Thread.sleep(3000);
        clickonProblemTypeOptions(ProblemTypeOption1);
        Thread.sleep(2000);
        handleScriptErrorInVehicleTriagePage();
    	
    }
    public void enterDoubleProblemType(String ProblemType, String ProblemTypeOption1, String ProblemTypeOption2) throws Throwable {
    	clickonProblemTypeButton(ProblemType);
        Thread.sleep(3000);
        clickonProblemTypeOptions(ProblemTypeOption1);
        Thread.sleep(2000);
        clickonProblemTypeOptions(ProblemTypeOption2);
        Thread.sleep(2000);
        handleScriptErrorInVehicleTriagePage();
    	
    }
	public void enterTripleProblemType(String ProblemType, String ProblemTypeOption1, String ProblemTypeOption2, String ProblemTypeOption3 ) throws Throwable {
		clickonProblemTypeButton(ProblemType);
        Thread.sleep(3000);
        clickonProblemTypeOptions(ProblemTypeOption1);
        Thread.sleep(2000);
        clickonProblemTypeOptions(ProblemTypeOption2);
        Thread.sleep(2000);
        clickonProblemTypeOptions(ProblemTypeOption3);
        Thread.sleep(2000);
        handleScriptErrorInVehicleTriagePage();
		
	}
    public void problemTriage( String ProblemTriage, String ProblemType) throws Throwable {
        if(ProblemTriage.equalsIgnoreCase("Manual")) {
            enterPaceSetterCodeManually(ProblemType);
        }
        else {
            selectProblem(ProblemType);
        }
    }
	
	 public void inputVehicleColor(String VehicleColor) throws Throwable {
	        clearData(CRVehicleTriagePage.txtVehicleColor);
	        enterVehicleColor(VehicleColor);
	        Thread.sleep(3000);
	    }
	
	 public void vehicleType(String VehicleType) throws Throwable {
         if((VehicleType.equalsIgnoreCase("MC")) ||
            (VehicleType.equalsIgnoreCase("PS")) ||
            (VehicleType.equalsIgnoreCase("RV")) ||
            (VehicleType.equalsIgnoreCase("TR")))
         {
             clearData(CRVehicleTriagePage.txtVehicleType);
             enterVehicleType(VehicleType);
             clickOnTheTypeSearchFromDropDown();
             Thread.sleep(3000);
         }
	 }
	 public void clickonManualEntryandEnterYearMakeModel(String EnterYear, String EnterMake, String EnterModel) throws Throwable {
		 clickOnManualEntryLinkOnVehicle();
         Thread.sleep(1000);
		 enterVehicleYear(EnterYear);
         Thread.sleep(2000);
         enterVehicleMake(EnterMake);
         enterVehicleModel(EnterModel);
	 }

    public void vehicleSearch(String VehicleSearch, String VehicleDetails ) throws Throwable {
        switch (VehicleSearch )
        {
            case "Existing" :
                boolean noVehicleLocationAvailable = verifyVehicleAvailable();
                if(noVehicleLocationAvailable)
                {
                    selectExistingVehicleModel();
                }
                else
                {
                    enterVehicleDetailsinSearchBar(VehicleDetails);
                }
                break;
            case "Manual" :
                enterVehicleDetailsManually(VehicleDetails);
                break;
            case "Year Make Model" :
                String VehicleDet[] = VehicleDetails.split("#");
                enterVehicleSearch(VehicleDet[0]);
                clickOnTheVehicleSearchIcon();
                clickOnTheVehicleSearch();
                vehicleColor(VehicleDet[1]);
                break;
            default :
                break;
        }
    }

    public void enterVehicleDetails(String VehicleSearch, String VehicleDetails ) throws Throwable {
        vehicleSearch(VehicleSearch,VehicleDetails);
    }
	 /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: enterPaceSetterCodeManually
     * description :: enterPaceSetterCodeManually
     * date :: 02-Jan-2018
     * author :: Chandrasekhar
     */
    public void enterPaceSetterCodeManually(String paceSettercode) throws Throwable {
        click(CRVehicleTriagePage.txtPacesetterCode, "paceSettercode");
        type(CRVehicleTriagePage.txtPacesetterCode, paceSettercode, "paceSettercode");
        waitForVisibilityOfElement(CRVehicleTriagePage.doubleClickPaceCode, "Double Click on PaceSetterCode");
        mouseDoubleClick(CRVehicleTriagePage.doubleClickPaceCode, "Double click on paceSettercode");
        Thread.sleep(2000);
    }
    
	 public void selectProblem(String Problem) throws Throwable {
		String ProblemType[] = Problem.split("#");
		clickonProblemTypeButton(ProblemType[0]);
        Thread.sleep(3000);
        for (int i = 1; i < ProblemType.length; i++) {
        	clickonProblemTypeOptions(ProblemType[i]);
        	Thread.sleep(3000);
        }      
		 
	 }
	 public void enterVehicleMandatoryFields(String VehicleDetails) throws Throwable {
	     String VehicleDet[] = VehicleDetails.split("#");
		 
		 errorAlertHandlingBeforeEnterMandatoryFields();
	        enterVehicleType(VehicleDet[0]);
	        Thread.sleep(1000);
	        enterVehicleYear(VehicleDet[1]);
	        Thread.sleep(1000);
	        enterVehicleMake(VehicleDet[2]);
	        Thread.sleep(1000);
	        enterVehicleModel(VehicleDet[3]);
	        Thread.sleep(1000);
	        enterVehicleColor(VehicleDet[4]);
	        Thread.sleep(1000);        
	 }
	 
	 public void enterVehicleDetailsManually(String VehicleDetails) throws Throwable {
		 clickOnManualEntryLinkOnVehicle();
		 enterVehicleMandatoryFields(VehicleDetails);
	 } 
	 
	 public void enterVehicleDetailsinSearchBar(String VehicleDetails) throws Throwable {
		 String VehicleDet[] = VehicleDetails.split("#");
		 enterVehicleSearch(VehicleDet[0]);
         clickOnTheVehicleSearchIcon();
         clickOnTheVehicleSearch();
         Thread.sleep(3000);
	     enterVehicleColor(VehicleDet[1]);
	 }

    public void verifyCompleteCheckVehicleTriage()  throws Throwable {
        if (!(isVisibleOnly(CRVehicleTriagePage.verifyVehicleTriageCompleteCheck, "Vehicle Triage Complete Check"))) {
            reporter.failureReport("Verify Vehicle Triage Complete Check" , "All Mandatory Fields are not entered", driver);
        }
    }

    /**
     *  * param :: NA
     *  * return ::void
     *  * throws :: throwable
     *  * methodName :: getVehicleText
     *  * description ::
     *  * retrivedTime :: 09-Feb-2018
     *  * author :: Abhiram
     *
     */
    public String getVehicleText()throws  Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.linkVehicleInformation, "Existing Vehicles Information");
        String vehicleAvailable = getText(CRVehicleTriagePage.linkVehicleInformation, "Existing Vehicles Information");
        return vehicleAvailable;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getColorValue
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getColorValue() throws Throwable {
        String color = getAttributeByValue(CRVehicleTriagePage.txtVehicleColor,"Vehicle Color");
        return color;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTypeLabel
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getTypeLabel() throws Throwable {
        String Type = getText(CRVehicleTriagePage.lblType,"Verified Type Label");
        return Type;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getYearLabel
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getYearLabel() throws Throwable {
        String Year = getText(CRVehicleTriagePage.lblYear,"Verified Type Label");
        return Year;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getMakeLabel
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getMakeLabel() throws Throwable {
        String Make = getText(CRVehicleTriagePage.lblMake,"Verified Type Label");
        return Make;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getModelLabel
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getModelLabel() throws Throwable {
        String Model = getText(CRVehicleTriagePage.lblModel,"Verified Model Label");
        return Model;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTrimLabel
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getTrimLabel() throws Throwable {
        String Trim = getText(CRVehicleTriagePage.lblTrim,"Verified Trim Label");
        return Trim;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getColorLabel
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getColorLabel() throws Throwable {
        String Color = getText(CRVehicleTriagePage.lblColor,"Verified Color Label");
        return Color;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getDrivelineLabel
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getDrivelineLabel() throws Throwable {
        String Driveline = getText(CRVehicleTriagePage.lblDriveline,"Verified Driveline Label");
        return Driveline;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getTagLabel
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getTagLabel() throws Throwable {
        String Tag = getText(CRVehicleTriagePage.lblTag,"Verified Tag Label");
        return Tag;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getStateLabel
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getStateLabel() throws Throwable {
        String State = getText(CRVehicleTriagePage.lblState,"Verified State Label");
        return State;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getFlatLabel
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getFlatLabel() throws Throwable {
        String Flat = getText(CRVehicleTriagePage.lblFlat,"Verified Flat Label");
        return Flat;
    }

    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getNoteLable
     * description ::
     * date :: 01-Jan-2018
     * author ::Abhiram
     */
    public String getNoteLable() throws Throwable {
        String Note = getText(CRVehicleTriagePage.lblNote,"Verified Note Label");
        return Note;
    }


    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: lblCallSummaryTroubleCodes
     * description ::get text for label pace setter codes in summary window
     * date :: 29-Dec-2017
     * author ::Abhiram
     */
    public String lblCallSummaryTroubleCodes() throws Throwable {
        boolean visibilityOfSummaryTroubleCodes = isVisibleOnly(CRVehicleTriagePage.lblcallSummaryTroubleCodes, " Label Trouble Codes");
        assertTrue(visibilityOfSummaryTroubleCodes, "Summary Call Window.");

        String summaryTroubleCodes = getText(CRVehicleTriagePage.lblcallSummaryTroubleCodes, "Trouble Codes is available in Summary Window");
        assertTrue(visibilityOfSummaryTroubleCodes, "Trouble Codes is available in Summary Window");
        return summaryTroubleCodes;
    }


    /**
     * Description:To click on RAP Tab Available on Vehicle triage page
     * Date: 12-02-2018
     * @Author : Madhukar
     * @throws Throwable
     */
    public void clickOnRAPTabOnVehicleTriage()throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.lnkRAPTab,"RAP TAB");
        click(CRVehicleTriagePage.lnkRAPTab,"RAP TAB");
    }

    /**
     * Description:To enter VIN for a RAP Call
     * Date: 12-02-2018
     * @Author : Madhukar
     * @param vin
     * @throws Throwable
     */
    public void enterVINForRAPOnVehicleTriage(String vin)throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.txtVinOnRAPtab,"VIN");
        type(CRVehicleTriagePage.txtVinOnRAPtab,vin,"Vin TextBox");
    }

    /**
     * Description:To click on ADD button Triage Section
     * Date: 16-02-2018
     * @Author : Sachin
     * @throws Throwable
     */
    public void clickOnAddButtonTriageSection()throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.btnAddTriageSection,"Add Button Triage Section");
        click(CRVehicleTriagePage.btnAddTriageSection,"Add Button Triage Section");
        Thread.sleep(5000);
    }
    /**
     * Description:To get error message text
     * Date: 16-02-2018
     * @Author : Sachin
     * @throws Throwable
     */
    public String  getTextInvalidCommentProvided()throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.lblInvalidTextProvided,"Invalid Comment Provided");
        String errorMessage  =getText(CRVehicleTriagePage.lblInvalidTextProvided,"Add Button Triage Section").trim();
        return errorMessage;
    }

    /**
     * Description:To get error message text
     * Date: 16-02-2018
     * @Author : Sachin
     * @throws Throwable
     */
    public void  EnterTextCommentTriageSection(String comments)throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.txtTriageComment,"Comments in Triage Section");
        type(CRVehicleTriagePage.txtTriageComment,comments,"Comments in Triage Section");
    }

    /**
     * param :: NA
     * return ::void
     * throws :: throwable
     * methodName :: validateSelectedPaceSetterCode
     * description :: This Function validates if selected page setter code is displayed in Selected Pacesetter section or not
     * date :: 29-Dec-2017
     * author :: Sachin
     */
    public String GetSelectedPaceSetterCode() throws Throwable {
        waitForVisibilityOfElement(CRVehicleTriagePage.lblSelectedPaceSetterCodes,"Selected Pacesetter Codes");
        String strSelectedPaceSetterCodes = getText(CRVehicleTriagePage.lblSelectedPaceSetterCodes,"Selected Pacesetter Codes");
        return strSelectedPaceSetterCodes;
    }

    /**
     *  return ::void
     * throws :: throwable
     * methodName :: clickOnCommentButton
     * Description:To click on comment button
     * Date: 18-02-2018
     * @Author : Ravi
     * @throws Throwable
     */
    public void clickOnCommentButton()throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.btnComment,"button comment");
        click(CRVehicleTriagePage.btnComment,"comment button");
        Thread.sleep(5000);
    }


    /**
     *  return ::void
     * throws :: throwable
     * methodName :: getDateAndTime
     * Description:To get Date And Time
     * Date: 18-02-2018
     * @Author : Ravi
     * @throws Throwable
     */
    public void getDateAndTime()throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.lblDateTime,"date and time");
        getText(CRVehicleTriagePage.lblDateTime,"overridden date and time");
        Thread.sleep(5000);
    }


    /**
     *  return ::void
     * throws :: throwable
     * methodName :: getCommentedValue
     * Description:To get Commented Value
     * Date: 18-02-2018
     * @Author : Ravi
     * @throws Throwable
     */
    public void getCommentedValue()throws Throwable{
        waitForVisibilityOfElement(CRVehicleTriagePage.txtCommentedValue,"commented value");
        getText(CRVehicleTriagePage.txtCommentedValue,"commented value");
        Thread.sleep(5000);
    }

}
