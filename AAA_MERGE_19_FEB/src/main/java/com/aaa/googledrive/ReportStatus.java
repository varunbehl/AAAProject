package com.aaa.googledrive;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class ReportStatus {
	public static boolean blnStatus=true;
	public static String strScriptName="";
	public static String strMethodName="";
	public static String spreadsheetId="1S8XS3qn1XKSs7uHemi0KrestdCcrO2KhFHi1ZyZlD1A";
	public static void fnDefaultReportStatus()
	{
		blnStatus=true;
	}
	
	public static void fnUpdateResultStatus(String strModuleName,String strTestCaseID,String strScriptName,int Iteration,String strBrowserNameIn) throws IOException, InterruptedException
	{
		try
		{
		String strStatus="";
		boolean blnStatus=ReportStatus.blnStatus;
		if(blnStatus)
		{
			strStatus="PASS";
		}
		else
		{
			strStatus="FAIL";
		}
		String spreadsheetId=ReportStatus.spreadsheetId;	
		//Get the Row Number
		String strNewScript=strScriptName+"_Row_"+Iteration;
		System.out.println(strNewScript);
		String strBrowserName="";
		if(strBrowserNameIn.toLowerCase().startsWith("f"))
		{
			strBrowserName="Firefox";
		}
		else if(strBrowserNameIn.toLowerCase().startsWith("c"))
		{
			strBrowserName="Chrome";
		}
		else if(strBrowserNameIn.toLowerCase().startsWith("a"))
		{
			strBrowserName="Android";
		}
		else if(strBrowserNameIn.toLowerCase().startsWith("ios"))
		{
			strBrowserName="IOS";
		}
		else if(strBrowserNameIn.toLowerCase().startsWith("ee"))
		{
			strBrowserName="EE";
		}
		String strSheetName="Test_Details_"+strBrowserName;
		int intRowNo=0;
		int intRowSearch=GoogleDriveAPI.fnGetRowNo(strSheetName, strNewScript);
		if(intRowSearch>0)
		{
			intRowNo=intRowSearch;			
		}
		else
		{
			int intRowStrength=0;
			//Find the New Row ID from "Configuation" Sheet
			if(strBrowserName.equals("Chrome"))
			{
				intRowStrength=2;
			}
			else if(strBrowserName.equals("IE"))
			{
				intRowStrength=3;
			}
			else if(strBrowserName.equals("Android"))
			{
				intRowStrength=4;
			}
			else if(strBrowserName.equals("IOS"))
			{
				intRowStrength=5;
			}
			else if(strBrowserName.equals("Firefox"))
			{
				intRowStrength=6;
			}
			else if(strBrowserName.equals("EE"))
			{
				intRowStrength=7;
			}
			
			//Get the Value of Row
			String range="Configuation!C"+intRowStrength+":C"+intRowStrength;
			String strData=GoogleDriveAPI.fnGetData(spreadsheetId, range);
			System.out.println(strData);
			//Update he Counter
			int intCounter=Integer.parseInt(strData)+1;
			String RowStart;
			String RowNo=String.valueOf(Integer.parseInt(strData));
			//Add Serial No
			RowStart="A"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, RowNo);
			//Add TestScript ID Name
			RowStart="B"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, strTestCaseID);
			//Script Name
			RowStart="C"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, strScriptName);
			//Script Iteration ID
			RowStart="D"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, strNewScript);
			//Add Module Name
			RowStart="E"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, strModuleName);
			//Add New Pass Count as 0
			RowStart="K"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, "0");			
			//Add New Fail Count as 0
			RowStart="N"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, "0");
			intRowNo=intCounter;
			if(strStatus.equals("PASS"))
			{
				//Update the Fail Row Value Intial
				RowStart="L"+intCounter;
				GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, "Not Available");			
				//Add New Fail Count as 0
				RowStart="M"+intCounter;
				GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, "Not Available");
			}
			else
			{
				//Update the Pass Row Value Intial
				//Update the Fail Row Value Intial
				RowStart="I"+intCounter;
				GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, "Not Available");			
				//Add New Fail Count as 0
				RowStart="J"+intCounter;
				GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, "Not Available");
			}
		}		
		//Update Current Status
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate localDate = LocalDate.now();
		String strDate=dtf.format(localDate);
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    String strTime=sdf.format(cal.getTime());
		//Update the Current Status
		GoogleDriveAPI.setValue(strSheetName, "F"+intRowNo, "F"+intRowNo, strStatus);
		//Update Current Date
		GoogleDriveAPI.setValue(strSheetName, "G"+intRowNo, "G"+intRowNo, strDate);
		//Update Current Time
		GoogleDriveAPI.setValue(strSheetName, "H"+intRowNo, "H"+intRowNo, strTime);
		if(strStatus.equals("PASS"))
		{
			//Update Pass Count
			String rangePassCount = strSheetName+"!K"+intRowNo+":K"+intRowNo;
			//Get the current Count of Pass
			String strPassCount=GoogleDriveAPI.fnGetData(spreadsheetId,rangePassCount);
			int CountPass=Integer.parseInt(strPassCount)+1;
			String strUpdatePassCount=String.valueOf(CountPass);
			GoogleDriveAPI.updateContentData(spreadsheetId,rangePassCount,strUpdatePassCount);
			//Update Last Pass Date
			String rangePassDate = strSheetName+"!I"+intRowNo+":I"+intRowNo;
			GoogleDriveAPI.updateContentData(spreadsheetId,rangePassDate,strDate);
			//Update Last Pass Time
			String rangePassTime = strSheetName+"!J"+intRowNo+":J"+intRowNo;
			GoogleDriveAPI.updateContentData(spreadsheetId,rangePassTime,strTime);
		}
		else
		{
			//Update Fail Count
			String rangeFailCount = strSheetName+"!N"+intRowNo+":N"+intRowNo;
			String strFailCount=GoogleDriveAPI.fnGetData(spreadsheetId,rangeFailCount);
			int CountFail=Integer.parseInt(strFailCount)+1;
			String strUpdateFailCount=String.valueOf(CountFail);
			GoogleDriveAPI.updateContentData(spreadsheetId,rangeFailCount,strUpdateFailCount);	
			//Update Last Fail Date
			String rangeFailDate = strSheetName+"!L"+intRowNo+":L"+intRowNo;
			GoogleDriveAPI.updateContentData(spreadsheetId,rangeFailDate,strDate);
			//Update Last Fail Time
			String rangeFailTime = strSheetName+"!M"+intRowNo+":M"+intRowNo;
			GoogleDriveAPI.updateContentData(spreadsheetId,rangeFailTime,strTime);
			//Update Last Fail Build
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
	
	public static void fnUpdateResultStatusEE(String strModuleName,String strTestCaseID,String strScriptName,String Context,String strMethodName,int Iteration,String strBrowserName) throws IOException, InterruptedException
	{
		try
		{
		String strStatus="";
		boolean blnStatus=ReportStatus.blnStatus;
		if(blnStatus)
		{
			strStatus="PASS";
		}
		else
		{
			strStatus="FAIL";
		}
		String spreadsheetId=ReportStatus.spreadsheetId;	
		//Get the Row Number
		String strNewScript=strScriptName+"_"+Context+"_"+strMethodName+"_Row_"+Iteration;
		System.out.println(strNewScript);
		String strSheetName="Test_Details_"+strBrowserName;
		int intRowNo=0;
		int intRowSearch=GoogleDriveAPI.fnGetRowNo(strSheetName, strNewScript);
		if(intRowSearch>0)
		{
			intRowNo=intRowSearch;			
		}
		else
		{
			int intRowStrength=0;
			//Find the New Row ID from "Configuation" Sheet
			if(strBrowserName.equals("Chrome"))
			{
				intRowStrength=2;
			}
			else if(strBrowserName.equals("IE"))
			{
				intRowStrength=3;
			}
			else if(strBrowserName.equals("Android"))
			{
				intRowStrength=4;
			}
			else if(strBrowserName.equals("IOS"))
			{
				intRowStrength=5;
			}
			else if(strBrowserName.equals("Firefox"))
			{
				intRowStrength=6;
			}
			else if(strBrowserName.equals("EE"))
			{
				intRowStrength=7;
			}
			
			//Get the Value of Row
			String range="Configuation!C"+intRowStrength+":C"+intRowStrength;
			String strData=GoogleDriveAPI.fnGetData(spreadsheetId, range);
			System.out.println(strData);
			//Update he Counter
			int intCounter=Integer.parseInt(strData)+1;
			String RowStart;
			String RowNo=String.valueOf(Integer.parseInt(strData));
			//Add Serial No
			RowStart="A"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, RowNo);
			//Add TestScript ID Name
			RowStart="B"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, strTestCaseID);
			//Script Name
			RowStart="C"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, strScriptName);
			//Script Iteration ID
			RowStart="D"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, strNewScript);
			//Add Module Name
			RowStart="E"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, strModuleName);
			//Add New Pass Count as 0
			RowStart="K"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, "0");			
			//Add New Fail Count as 0
			RowStart="N"+intCounter;
			GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, "0");
			intRowNo=intCounter;
			if(strStatus.equals("PASS"))
			{
				//Update the Fail Row Value Intial
				RowStart="L"+intCounter;
				GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, "Not Available");			
				//Add New Fail Count as 0
				RowStart="M"+intCounter;
				GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, "Not Available");
			}
			else
			{
				//Update the Pass Row Value Intial
				//Update the Fail Row Value Intial
				RowStart="I"+intCounter;
				GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, "Not Available");			
				//Add New Fail Count as 0
				RowStart="J"+intCounter;
				GoogleDriveAPI.setValue(strSheetName, RowStart, RowStart, "Not Available");
			}
		}		
		//Update Current Status
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate localDate = LocalDate.now();
		String strDate=dtf.format(localDate);
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    String strTime=sdf.format(cal.getTime());
		//Update the Current Status
		GoogleDriveAPI.setValue(strSheetName, "F"+intRowNo, "F"+intRowNo, strStatus);
		//Update Current Date
		GoogleDriveAPI.setValue(strSheetName, "G"+intRowNo, "G"+intRowNo, strDate);
		//Update Current Time
		GoogleDriveAPI.setValue(strSheetName, "H"+intRowNo, "H"+intRowNo, strTime);
		if(strStatus.equals("PASS"))
		{
			//Update Pass Count
			String rangePassCount = strSheetName+"!K"+intRowNo+":K"+intRowNo;
			//Get the current Count of Pass
			String strPassCount=GoogleDriveAPI.fnGetData(spreadsheetId,rangePassCount);
			int CountPass=Integer.parseInt(strPassCount)+1;
			String strUpdatePassCount=String.valueOf(CountPass);
			GoogleDriveAPI.updateContentData(spreadsheetId,rangePassCount,strUpdatePassCount);
			//Update Last Pass Date
			String rangePassDate = strSheetName+"!I"+intRowNo+":I"+intRowNo;
			GoogleDriveAPI.updateContentData(spreadsheetId,rangePassDate,strDate);
			//Update Last Pass Time
			String rangePassTime = strSheetName+"!J"+intRowNo+":J"+intRowNo;
			GoogleDriveAPI.updateContentData(spreadsheetId,rangePassTime,strTime);
		}
		else
		{
			//Update Fail Count
			String rangeFailCount = strSheetName+"!N"+intRowNo+":N"+intRowNo;
			String strFailCount=GoogleDriveAPI.fnGetData(spreadsheetId,rangeFailCount);
			int CountFail=Integer.parseInt(strFailCount)+1;
			String strUpdateFailCount=String.valueOf(CountFail);
			GoogleDriveAPI.updateContentData(spreadsheetId,rangeFailCount,strUpdateFailCount);	
			//Update Last Fail Date
			String rangeFailDate = strSheetName+"!L"+intRowNo+":L"+intRowNo;
			GoogleDriveAPI.updateContentData(spreadsheetId,rangeFailDate,strDate);
			//Update Last Fail Time
			String rangeFailTime = strSheetName+"!M"+intRowNo+":M"+intRowNo;
			GoogleDriveAPI.updateContentData(spreadsheetId,rangeFailTime,strTime);
			//Update Last Fail Build
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
}
