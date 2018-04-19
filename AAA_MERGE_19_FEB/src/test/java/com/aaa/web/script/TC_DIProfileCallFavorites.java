package com.aaa.web.script;

import com.aaa.accelerators.ActionEngine;
import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.utilities.TestUtil;
import com.aaa.web.lib.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_DIProfileCallFavorites extends ActionEngine {
    public static String callID;
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String callDateCreated;
    public static String callIDAndDateCombined;
    public static String [] callandfacilityId = new String[3];


    LoginLib login = new LoginLib();
    DIHomeLib diHome = new DIHomeLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    LoginRoleLib loginRole = new LoginRoleLib();
    DILoginLib diLogin = new DILoginLib();
    CommonLib common = new CommonLib();
    CRServiceLib services = new CRServiceLib();
    CRHomeLib home = new CRHomeLib();
    DIProfileLib profileLib =  new DIProfileLib();
    DIMCDLib mcdLib = new DIMCDLib();
    DISearchCallsLib diSearchCalls = new DISearchCallsLib();
    DITruckLoadDeafultViewLib truckLoad = new DITruckLoadDeafultViewLib();
    CRMemberSearchLib crMemberSearchLib = new CRMemberSearchLib();
    CRLocationsLib crLocationsLib = new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRTowDestinationLib tow = new CRTowDestinationLib();
    CRServiceLib service = new CRServiceLib();
   
    /************************************************************************
    * Script Name :-
    * Method Name :-
    * Module	  :- DI 
    * Test Case ID:-
    * Script Date :- 
    * Author      :- 
    * @param StartRow
    * @param EndRow
    * @param nextTestJoin
    * @throws Throwable
    *************************************************************************/
    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void profileCallFavorites(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
    	try
    	{
    		int intStartRow=StartRow;
    		int intEndRow=ReportControl.fnGetEndRowCunt(EndRow, "DIProfileCallFavorites", TestData, "D3Dispatch");
    		for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++)
    		{
    			try {
    					ReportStatus.fnDefaultReportStatus();
    					ReportControl.intRowCount=intCounter;
    					Hashtable<String, String> data=TestUtil.getDataByRowNo("DIProfileCallFavorites", TestData, "D3Dispatch",intCounter);
    	
    					this.reporter.initTestCaseDescription("2025 DIProfileCallFavorites"+ " From Iteration " + StartRow + " to " + EndRow );
    					reporter.SuccessReport("Iteration Number : ","**************Iteration Number::  "+ intCounter+"   **************");
			            navigateToApplication("CR");
			            Thread.sleep(4000);
			            login.login(data.get("LoginName"), data.get("Password"));
			            crHomeLib.messageDialogBoxClose();
			           // crMemberSearchLib.clickOnPartialCallCloseButton();
			           String Member = "";
			            if (data.get("Member").equals("db")) {
			                //fetch member details from db
			                //generating a random number everytime to fetch a new record everytime
			                int rownum = IntRandomNumberGenerator(50, 1000);
			                //member from db
			                Member = CommonDb.selectRandomMemberFromDB(data.get("dbServer"), data.get("dbqueryFileName"), data.get("colomnName"), rownum);
			                System.out.println("member : " + Member);
			            } else {
			                Member = data.get("Membersearch");
			            }
			            crHomeLib.memberSearchTextBox(Member);
			            //crHomeLib.memberSearchTextBox(data.get("Membersearch"));
			            crMemberSearchLib.memberNumClick();
			            crMemberSearchLib.ClickPrimRadioBtnInRowTwo();
			            //crMemberSearchLib.labelMemberLevelInMemberDetailsSection();
			            Thread.sleep(2000);
			            crLocationsLib.clickOnLocationTab();
			            crLocationsLib.enterTxtinBrkDowLocSrch(data.get("Breakdownaddress"));
			            crLocationsLib.brkDowLocSrchBtn();
			            crLocationsLib.brkdowLocAddrLink();
			            crLocationsLib.acceptAddressDifferenceAlert();
			            crLocationsLib.brkdownLocationCode(dataBean.getValue(data, "Breakdownlocationcode"));
			            crVehicleTriageLib.clickOnVehicleTriageTab();
			
			            crVehicleTriageLib.enterVehicleSearch(data.get("VehicleDetails"));
			            Thread.sleep(2000);
			            crVehicleTriageLib.clickOnTheVehicleSearchIcon();
			            crVehicleTriageLib.clickOnTheVehicleSearch();
			            // crVehicleTriageLib.availableVehicleaftersrch();
			            Thread.sleep(2000);
			            crVehicleTriageLib.enterVehicleColor(data.get("Color"));
			            //*crVehicleTriageLib.clickOnFuel();
			            //crVehicleTriageLib.clickOnOutOfGas();//
			            crVehicleTriageLib.clickonProblemTypeButton(data.get("ProblemType"));
			            Thread.sleep(3000);
			            crVehicleTriageLib.clickonProblemTypeOptions(data.get("ProblemTypeOption1"));
			            Thread.sleep(3000);
			            //crHomeLib.allErrorAlerts();
			            crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			            ///crHomeLib.allErrorAlerts();
			            Thread.sleep(2000);
			            tow.clickOnTowDestinationTab();
			            crHomeLib.waitCloseAllBusyIconsResults();
			            //crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
			            crVehicleTriageLib.scriptErrorHandle();
			            Thread.sleep(3000);
			            tow.clickOnAARTowDetinationLink();
			            //tow.clickOnManualEntryLinkOnTowDestination();
			            tow.enterTowPassengers(data.get("TowPassengers"));
			            Thread.sleep(2000);
			            service.clickOnServiceTab();
			            crHomeLib.waitCloseAllBusyIconsResults();
			            //service.enterManualSpotDetails(data.get("SPPFacilitySpot"));
			            crHomeLib.allErrorAlerts();
			            String facilify = service.validateFacilityAutospot();
			            crHomeLib.saveButton();
			            crHomeLib.waitCloseAllBusyIconsResults();
			            Thread.sleep(3000);
			            getCallIDAndDate();
			            callID = service.getCallId();
			            service.closeCall();
			            crHomeLib.logout();
			            acceptAlert();
			            Thread.sleep(2000);
			            acceptAlert();
			
			                //Navigate to Dispatch
			                navigateToApplication("DI");
			                Thread.sleep(3000);
			                login.login(data.get("DILoginName"), data.get("DIPassword"));
			                crHomeLib.waitCloseAllBusyIconsResults();
			                //loginRole.clickOnProceedBtnInDispatchRoleLogin();
			                diHome.clickOnCloseIconOnQueueSelection();
			
			                diHome.clickOnProfileMenu();
			                diHome.clickOnProfileName(data.get("ProfileName"));
			                Thread.sleep(2000);
			                callIDAndDateCombined = callandfacilityId[2].substring(0,4) + callandfacilityId[2].substring(5,7)+ callandfacilityId[2].substring(8,10)+callandfacilityId[2].substring(4,5)+callandfacilityId[0];
			                diHome.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombined);
			                crHomeLib.waitCloseAllBusyIconsResults();
			                //String rgn = profileLib.getRGNFromProfileWindow("20180213-20004");
			                // diHome.searchAndClickOnCallIdOnProfileWindow("20180212-20048");
			                String favoriteStatusonProfileBefore = profileLib.getFavoriteStatusFromProfile(callIDAndDateCombined);
			                diHome.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombined);
			                String favoriteStatusonMCDBefore = mcdLib.getStarStatusOnMCDWindow();
			                mcdLib.closeTheOpendCallInMCD();
			                Thread.sleep(3000);
			                profileLib.rightClickOnCallIdOnProfileWindow(callIDAndDateCombined);
			                Thread.sleep(3000);
			                profileLib.clickOnAddToFavorites(callIDAndDateCombined);
			                String favoriteStatusonProfile = profileLib.getFavoriteStatusFromProfile(callIDAndDateCombined);
			                boolean statusOnProfileFlag = !favoriteStatusonProfile.equalsIgnoreCase(favoriteStatusonProfileBefore);
			                assertTrue(statusOnProfileFlag, "Verified the call , Call Marked with  star on the profile window");
			                diHome.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombined);
			                //mcdLib.getStarStatusOnMCDWindow();
			                String favoriteStatusAfter = mcdLib.getStarStatusOnMCDWindow();
			                boolean starStatus = !favoriteStatusAfter.equalsIgnoreCase(favoriteStatusonMCDBefore);
			                assertTrue(starStatus, "Verified The call in the MCD Window,Call is marked with star to indicate it is favorited");
			                mcdLib.closeTheOpendCallInMCD();
			                //diHome.selectUserProfileMenuItem();
			                diHome.selectChangeSetQueueMenuItem();
			                //diHome.clickOnFavoritesInQueSelection();
			                diHome.clickOnSelectedQueue();
			                diHome.clickOnRemoveButtonOnQueueWindow();
			                diHome.clickOnContinueQueuesInDispatch();
			                crHomeLib.waitCloseAllBusyIconsResults();
			                diHome.clickOnProfileMenu();
			                diHome.clickOnProfileName(data.get("FavoriteCalls"));
			                crHomeLib.waitCloseAllBusyIconsResults();
			                boolean favoritesFlag = diHome.verifyFavoriteCallFromProfileMenu(callIDAndDateCombined);
			                assertTrue(favoritesFlag, "Verified the favorited call,& Favorite call still appears in  profile list ");
			
			                diHome.selectChangeSetQueueMenuItem();
			                diHome.clickOnFavoritesInQueSelection();
			                diHome.selectQueueFromFavorites();
			                diHome.clickOnAddButtonOnQueueWindow();
			                diHome.clickOnContinueQueuesInDispatch();
			                crHomeLib.waitCloseAllBusyIconsResults();
			                diHome.clickOnProfileMenu();
			                diHome.clickOnProfileName(data.get("ProfileName"));
			                crHomeLib.waitCloseAllBusyIconsResults();
			                Thread.sleep(3000);
			                profileLib.rightClickOnCallIdOnProfileWindow(callIDAndDateCombined);
			                profileLib.clickOnRemoveFromFavorites(callIDAndDateCombined);
			                diHome.clickOnProfileMenu();
			                diHome.clickOnProfileName(data.get("FavoriteCalls"));
			                crHomeLib.waitCloseAllBusyIconsResults();
			                Thread.sleep(3000);
			                boolean favoriteFlag = diHome.verifyFavoriteCallFromProfileMenu(callIDAndDateCombined);
			                assertTrue(favoriteFlag, "Verified the profile list for favorite call & call is no longer a favorite call");
			                //Verify Favorite Call Thr Status ,On Profile
			                diHome.clickOnProfileMenu();
			                diHome.clickOnProfileName(data.get("ProfileName"));
			                crHomeLib.waitCloseAllBusyIconsResults();
			                profileLib.setFavoriteCallFromStatus(callIDAndDateCombined);
			                Thread.sleep(2000);
			                diHome.searchAndClickOnCallIdOnProfileWindow(callIDAndDateCombined);
			                String favoriteCallStatusInProfile = mcdLib.getStarStatusOnMCDWindow();
			                boolean favoriteCallMCDFlag = !favoriteCallStatusInProfile.equalsIgnoreCase(favoriteStatusonMCDBefore);
			                assertTrue(favoriteCallMCDFlag, "Verified The call From Profile & Call is marked with star ,to indicate it is favorited");
			
			                //Verify Favorite Call Thr Status ,On MCD
			                diHome.clickOnSearchCallsInDispatch();
			                diHome.enterCallIDInfo(callID);
			                //diHome.enterCallIDInfo("20004");
			                diHome.clickOnSearchInSearchCalls();
			                crHomeLib.waitCloseAllBusyIconsResults();
			                diHome.clickOnCallDateOrIDLink();
			                String favoriteStatusOnMCD = mcdLib.getStarStatusOnMCDWindow();
			                boolean statusFlag = !favoriteStatusOnMCD.equalsIgnoreCase(favoriteStatusonMCDBefore);
			                assertTrue(statusFlag, "Verified The call From MCD & Call is marked with star ,to indicate it is favorited");
			                mcdLib.closeTheOpendCallInMCD();
			                Thread.sleep(2000);
			                //Put Status From Status
			                //Verify Favorite Call Thr Status ,On Truck
			                diHome.clickOnTruckLoadTab();
			                diHome.clickOnTruckLoadDefaultOption();
			                diHome.enterSpotFacilityIDInfoOnTruckLoad(facilify);
			                truckLoad.clickOnFacilityOnDefaultTruck(facilify);
			                crHomeLib.waitCloseAllBusyIconsResults();
			                Thread.sleep(3000);
			                truckLoad.rightClickOnCallIDOnTruckLoad(callIDAndDateCombined);
			                crHomeLib.waitCloseAllBusyIconsResults();
			                String removeFromFavorite = data.get("TextRemoveFromFavorite");
			                String txtRemoveFavoriteCall = truckLoad.getTextFromLinkRemoveFavoriteCall(callIDAndDateCombined);
			                boolean favoriteflag = removeFromFavorite.equalsIgnoreCase(txtRemoveFavoriteCall);
			                assertTrue(favoriteflag, "Verified The call From Truck Load & Call is marked with star ,to indicate it is favorited");
			                crHomeLib.logout();
			                acceptAlert();
			                Thread.sleep(2000);
			                acceptAlert();

    			}
    			catch(Exception e)
    			{
    				ReportStatus.blnStatus=false;
    			}
    			ReportControl.fnEnableJoin();
    			ReportStatus.fnUpdateResultStatus("DI","2025",ReportStatus.strMethodName,intCounter,browser);
    		}
    	}
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		throw new RuntimeException(e);
    	}
    	ReportControl.fnNextTestJoin(nextTestJoin);
    }


    public String[] getCallIDAndDate() throws Throwable {
        callIDCreated = services.getCallId();
        spotIDCreated = services.getSpotFacilityId();
        callDateCreated=services.getCallDate();
        callandfacilityId[0] = callIDCreated;
        callandfacilityId[1] = spotIDCreated;
        callandfacilityId[2] = callDateCreated;

        return callandfacilityId;
    }
}
