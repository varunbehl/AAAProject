package com.aaa.web.lib;

import com.aaa.e2e.script.CR_DI;
import com.aaa.web.page.LoginPage;

import java.util.Hashtable;

public class CommonLib extends LoginLib {
    public static String callIDCreated;
    public static String spotIDCreated;
    public static String callDateCreated;
    public static String callIDAndDateCombined;
    public static String [] callandfacilityId = new String[3];
    //Declarations
    CRLocationsLib crLocationsLib =new CRLocationsLib();
    CRVehicleTriageLib crVehicleTriageLib = new CRVehicleTriageLib();
    CRMemberSearchLib crMemberSearchLib =new CRMemberSearchLib();
    CRServiceLib crServiceLib = new CRServiceLib();
    CRHomeLib crHomeLib = new CRHomeLib();
    CRTowDestinationLib crTowDestinationLib = new CRTowDestinationLib();
    DILoginLib diLoginLib=new DILoginLib();
    LoginRoleLib loginRoleLib = new LoginRoleLib();
    DIMCDLib dimcdLib = new DIMCDLib();
    DIHomeLib diHomeLib = new DIHomeLib();

    public void callReceivingLogin(String UserName, String Password, String LoginRole, String Role) throws Throwable {
        navigateToApplication("CR");
        crHomeLib.verifyandClickLogout();
        //Thread.sleep(3000);
        switch (LoginRole) {
            case "CR":
               // Thread.sleep(2000);
                login(UserName,Password);
                break;
            case "DI":
                //Thread.sleep(2000);
                login(UserName,Password);
                loginRoleLib.roleSelection(Role);
                Thread.sleep(4000);
                loginRoleLib.clickOnProceedBtnInDispatchRoleLogin();
                //autodi1	auto123!! DI-Dispatcher
                break;
            case "AD":
                login(UserName,Password);
                loginRoleLib.roleSelection(Role);
                loginRoleLib.clickOnProceedBtnInDispatchRoleLogin();
                //autoad1	auto123!!  AD-Administrator
                break;
            default:
                break;
        }
        crMemberSearchLib.clickOnPartialCallCloseButton();
        crHomeLib.messageDialogBoxClose();
    }


    //*** Supporting Main Methods
    public void crMemberSearchTab(String Member, String MemberSearch, String dbServer, String dbqueryFileName, String colomnName, String PhoneNumber, String Primaryphonenum1 ) throws Throwable
    {
        crMemberSearchLib.enterMembershipDetails(Member,MemberSearch, dbServer,dbqueryFileName, colomnName, PhoneNumber,Primaryphonenum1);
        crMemberSearchLib.verifyCompleteCheckMember();
    }
    public void crLocationsTab(String BreakdownSearch,String BreakdownType,String crossStreet,String secondCrossStreet,String LandMark,String Address) throws Throwable
    {
        crLocationsLib.breakdownLocTabSel();
        crLocationsLib.breakdownSearchAndBreakdownType(BreakdownSearch, BreakdownType, crossStreet, secondCrossStreet, LandMark, Address);
        crLocationsLib.verifyCompleteCheckLocation();
    }
    public void crVehicleTriageTab(String VehicleSearch, String VehicleDetails, String ProblemTriage, String ProblemType ) throws Throwable
    {
        crVehicleTriageLib.clickOnVehicleTriageTab();
        crVehicleTriageLib.enterVehicleDetails(VehicleSearch,VehicleDetails);
        crVehicleTriageLib.problemTriage(ProblemTriage,ProblemType);
        crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
        crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
        crHomeLib.allErrorAlerts();
        crVehicleTriageLib.verifyCompleteCheckVehicleTriage();
    }
    public void crTowDestinationTab(String WillThisCallBeATow, String TowDestination, String RSPReferral , String TowAddress) throws Throwable
    {
        crTowDestinationLib.enterTowDestinationAddress(WillThisCallBeATow,TowDestination,RSPReferral,TowAddress);

    }


    public void callReceivingLogout() throws Throwable
    {
        crHomeLib.logout();
        CloseLogoutAlert();

    }

    /****************************************************** DISPATCH ******************************************************/
    public void dispatchLogin(String UserName, String Password, String LoginRole, String Role) throws Throwable {
        diHomeLib.logOut();
    	switch (LoginRole) {
            case "DI":
                diLoginLib.login(UserName,Password);
                loginRoleLib.clickOnProceedBtnInDispatchRoleLogin();
                diLoginLib.waitcloseAllBusyIcons();
                diHomeLib.clickOnCloseIconOnQueueSelection();
                break;
            case "AD":
                diLoginLib.login(UserName,Password);
                Thread.sleep(4000);
                loginRoleLib.roleSelection(Role);
                waitcloseAllBusyIcons();
                diHomeLib.clickOnCloseIconOnQueueSelection();
                break;
            default:
                break;
        }
    }

    public void dispatchlogout(String CallFlow) throws Throwable
    {
        dimcdLib.clickOnMCDCloseWindow();
        if (CallFlow.equalsIgnoreCase("Truckload"))
        {
            diHomeLib.clickonCloseInTruckLoad();
        }
        diHomeLib.logOut();
        CloseLogoutAlert();
    }

    public String[] completeCall(String CompleteCall) throws Throwable {
        switch (CompleteCall) {
            case "Save":
                crHomeLib.saveButton();
                crHomeLib.allErrorAlerts();
                callIDCreated = crServiceLib.getCallId();
                spotIDCreated = crServiceLib.getSpotFacilityId();
                callDateCreated=crServiceLib.getCallDate();
                crServiceLib.closeCall();
                break;
            case "Cancel":
                crHomeLib.cancelButton();
                //below function will click on Yes on confirmation window
                crHomeLib.allErrorAlerts();
                break;
            default:
                break;
        }
        callandfacilityId[0] = callIDCreated;
        callandfacilityId[1] = spotIDCreated;
        callandfacilityId[2] = callDateCreated;
        return callandfacilityId;
    }

    public void crServiceTab(String priority,String priorityRequired,String appointment,String hold,String redFlag,String policy,String policyValue,String Callback,String CallBackMinutes,String CallBackReqType,String Spot,String ResoptFacilityID,String ManualSoptFacilityID,String ManualSoptFacilityIDNew,String specialequipement,String CompleteCall)throws Throwable
    //crServiceTab(data.get( "Priority"),data.get("PriorityRequired"),data.get("Appointment"),data.get( "Hold"),data.get( "RedFlag"),data.get( "Policy"),data.get( "PolicyValue"),data.get( "CallBack"),data.get( "CallBackMinutes"),data.get( "CallBackReqType"),data.get("Spot"),data.get("ResoptFacilityID"),data.get("ManualSoptFacilityID"),data.get("ManualSoptFacilityIDNew"),data.get("specialequipement"),data.get( "CompleteCall"));
    {

        crServiceLib.clickOnServiceTab();
        crServiceLib.enterpriority(priority,priorityRequired);
        crServiceLib.enterAppointment(appointment,hold);
        crServiceLib.clickRedFlag(redFlag);
        crServiceLib.enterPolicy(policy,policyValue);
        crServiceLib.callBack(Callback,CallBackMinutes,CallBackReqType);
        crServiceLib.spot(Spot,ResoptFacilityID,ManualSoptFacilityID,ManualSoptFacilityIDNew);
        crServiceLib.enterSpecialEquipement(specialequipement);
        completeCall(CompleteCall);
        callReceivingLogout();
    }

public void crCallCreation(String CRLoginName,String CRPassword,String LoginRoleCallReceiving,String role,String Member,String Membersearch,String dbServer,String dbqueryFileName,String colomnName,String PhoneNumber,String Primaryphonenum1,
                           String VehicleSearch,String VehicleDetails,String ProblemTriage,String ProblemType,
                           String WillThisCallBeATow,String TowDestination,String RSPReferral,String TowAddress,String OmniBarAddress) throws Throwable{
        Thread.sleep(3000);
   callReceivingLogin(CRLoginName,CRPassword,LoginRoleCallReceiving,role);
   crMemberSearchTab(Member,Membersearch,dbServer,dbqueryFileName, colomnName,PhoneNumber,Primaryphonenum1);
   crLocationsLib.breakdownLocTabSel();
   crLocationsLib.enterBreakDownAddressOmniBarSearch(OmniBarAddress);
   crVehicleTriageTab(VehicleSearch,VehicleDetails, ProblemTriage,ProblemType);
   crVehicleTriageLib.handleScriptErrorInVehicleTriagePage();
   crHomeLib.allErrorAlerts();
   crTowDestinationTab(WillThisCallBeATow,TowDestination,RSPReferral,TowAddress);
    }
public void CloseLogoutAlert()  throws Throwable{
	boolean exist = isVisibleOnly(LoginPage.txtLoginName,"Login User Name");
	int counter = 0;
	while (!exist){
		acceptAlert();
		Thread.sleep(5000);
		exist = isVisibleOnly(LoginPage.txtLoginName,"Login User Name");
		if (exist){
			break;
		}
		if(counter > 10){
			break;
		}
		counter = counter + 1;
	}
}
}
