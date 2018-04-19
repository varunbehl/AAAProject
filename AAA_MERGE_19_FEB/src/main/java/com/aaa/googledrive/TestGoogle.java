package com.aaa.googledrive;

import java.io.IOException;

import com.sun.jna.platform.win32.OaIdl.SYSKIND;

public class TestGoogle {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//int row = GoogleDriveAPI.fnGetRowNo("IBE_UAT_Reg", "TC03_a_oneWayDomesticChangeDate");
		//GoogleDriveAPI.getResponse("IBE_UAT_Reg", "B"+row, "B"+row);
		//GoogleDriveAPI.setValue("IBE_UAT_Reg", "B2", "B2", "pass");
		System.out.println("Starts");
		
		//int intRw=GoogleDriveAPI.fnGetRowNo("Test_Details", "cancelDuplicateCall");
		//System.out.println("Rw No ==> " + intRw);
		//System.out.println("End Start");
		//ReportStatus.blnStatus=false;
		
		String strBrowserName;
		String strModuleName;
		String strTestCaseID;
		String strScriptName="successLoginAAA";
	//	ReportStatus.fnUpdateResultStatus("Test_Details", "cancelDuplicateCall");
		//ReportStatus.blnStatus=false;
		strScriptName="successLoginAAA";
		strBrowserName="Chrome";
		//int intIteraton=3;
		strModuleName="CR";
		strTestCaseID="2239";
		for(int intIteraton=1;intIteraton<=10;intIteraton++)
		{
			if(intIteraton==5)
			{
				ReportStatus.blnStatus=false;
			}
			else
			{
				ReportStatus.blnStatus=true;
			}
			ReportStatus.fnUpdateResultStatus(strModuleName,strTestCaseID,strScriptName,intIteraton,strBrowserName);
		}
		
		/*strBrowserName="IE";
		//int intIteraton=3;
		strModuleName="DR";
		strTestCaseID="2255";
		for(int intIteraton=1;intIteraton<=10;intIteraton++)
		{
			if(intIteraton==7)
			{
				ReportStatus.blnStatus=false;
			}
			else
			{
				ReportStatus.blnStatus=true;
			}
			ReportStatus.fnUpdateResultStatus(strModuleName,strTestCaseID,strScriptName,intIteraton,strBrowserName);
		}
		
		
		String strScriptName="successLoginAAA";
		String strBrowserName="Android";
		//int intIteraton=3;
		String strModuleName="CR";
		String strTestCaseID="2257";
		for(int intIteraton=1;intIteraton<=10;intIteraton++)
		{
			if(intIteraton==9)
			{
				ReportStatus.blnStatus=false;
			}
			else
			{
				ReportStatus.blnStatus=true;
			}
			ReportStatus.fnUpdateResultStatus(strModuleName,strTestCaseID,strScriptName,intIteraton,strBrowserName);
		}*/
	/*	strBrowserName="IOS";
		//int intIteraton=3;
		strModuleName="CR";
		strTestCaseID="2259";
		for(int intIteraton=1;intIteraton<=10;intIteraton++)
		{
			if(intIteraton==6)
			{
				ReportStatus.blnStatus=false;
			}
			else
			{
				ReportStatus.blnStatus=true;
			}
			ReportStatus.fnUpdateResultStatus(strModuleName,strTestCaseID,strScriptName,intIteraton,strBrowserName);
		}
		/*
		*/
	/*	strBrowserName="EE";
		//int intIteraton=3;
		strModuleName="CR";
		strTestCaseID="2279";
		String strContext="Web";
		String strMethod="Login";
		String[] arrData= {"LoginWeb","CheckDistance","CheckLeaveCall","DulicateCall","Battary","Facility","KeyLock","LocationFind","TimeZone","ManualSpot"};
		boolean blnSwitch=true;
		for(int intIteraton=1;intIteraton<=5;intIteraton++)
		{			
			for(int i=0;i<arrData.length;i++)
			{
				if(blnSwitch)
				{
					strContext="Web";
					blnSwitch=false;
				}
				else
				{
					strContext="Mobile";
					blnSwitch=true;
				}
				strMethod=arrData[i];
			
				ReportStatus.fnUpdateResultStatusEE(strModuleName,strTestCaseID,strScriptName,strContext,strMethod,intIteraton,strBrowserName);
			}
		}
		
		*/
		/*strBrowserName="Firefox";
		//int intIteraton=3;
		strModuleName="CR";
		strTestCaseID="2259";
		for(int intIteraton=1;intIteraton<=10;intIteraton++)
		{
			if(intIteraton==6)
			{
				ReportStatus.blnStatus=false;
			}
			else
			{
				ReportStatus.blnStatus=true;
			}
			ReportStatus.fnUpdateResultStatus(strModuleName,strTestCaseID,strScriptName,intIteraton,strBrowserName);
		}*/
	}

}
