package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CRDispatcherUpdatePage;
import com.aaa.web.page.CRHomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by E002734 on 2/13/2018.
 */
public class CRDispatcherUpdateLib extends ActionEngine {

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnMenuCheckbox
	 * description :: click On Menu Checkbox
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void clickOnMenuCheckbox() throws Throwable {
		waitForVisibilityOfElement(CRHomePage.lblCurrentCall, "wait for Current call in CR Homepage");
		dynamicWaitByLocator(CRHomePage.lblCurrentCall, 3);
			click(CRHomePage.lblCurrentCall, "Current call in CR Homepage");


	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnDispatcherUpdateInCurrentCall
	 * description :: click On Dispatcher Update In CurrentCall
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void clickOnDispatcherUpdateInCurrentCall() throws Throwable {
		waitForVisibilityOfElement(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "wait for dispatcher update status");
		dynamicWaitByLocator(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, 3);
		click(CRHomePage.lblDispatcherUpdateSatusInCurrentCall, "Dispatcher update status in homepage");


	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOfResonForStatus
	 * description ::getTextOfResonForStatus
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfResonForStatus() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.lblReasonForStatus, "wait for reason for status in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.lblReasonForStatus, 3);
		getText(CRDispatcherUpdatePage.lblReasonForStatus, "Reason for status in DUS");

	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOfStatus
	 * description :: getText Of Status
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfStatus() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.lblStatus, "wait for status in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.lblStatus, 3);
		getText(CRDispatcherUpdatePage.lblStatus, "Status in DUS");

	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOfBoldStatus
	 * description :: getText Of bold Status
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfBoldStatus() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.lblBoldStatus, "wait for bold status in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.lblBoldStatus, 3);
		getText(CRDispatcherUpdatePage.lblBoldStatus, "Bold Status in DUS");

	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOfBoldStatus
	 * description :: getText Of bold Status
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfBoldDispatchingInformation() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.lblBoldDispatchingInfo, "wait for bold Dispatching information in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.lblBoldDispatchingInfo, 3);
		getText(CRDispatcherUpdatePage.lblBoldDispatchingInfo, "Bold Dispatching Information in DUS");

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOfFacility
	 * description :: getText Of Facility
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfFacility() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.lblFacility, "wait for facility in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.lblFacility, 3);
		getText(CRDispatcherUpdatePage.lblFacility, "Facility in DUS");

	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOfTechnician
	 * description :: getText Of Technician
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfTechnician() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.lblTechnician, "wait for technician in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.lblTechnician, 3);
		getText(CRDispatcherUpdatePage.lblTechnician, "Technician in DUS");

	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOfTruck
	 * description :: getText Of truck
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfTruck() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.lblTruck, "wait for truck in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.lblTruck, 3);
		getText(CRDispatcherUpdatePage.lblTruck, "Truck in DUS");

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOfTimeStampOverride
	 * description :: getText Of Timestamp override
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfTimeStampOverride() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.lblBoldTimestamp, "wait for timestamp in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.lblBoldTimestamp, 3);
		getText(CRDispatcherUpdatePage.lblBoldTimestamp, "Timestamp in DUS");

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOfComments
	 * description :: getText Of Comments
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfComments() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.lblBoldComments, "wait for comments in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.lblBoldComments, 3);
		getText(CRDispatcherUpdatePage.lblBoldComments, "Comments in DUS");

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOfDate
	 * description :: getText Of Date
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfDate() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.lblDate, "wait for date in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.lblDate, 3);
		getText(CRDispatcherUpdatePage.lblDate, "Date in DUS");

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOfTime
	 * description :: getText Of Time
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfTime() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.lblTime, "wait for time in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.lblTime, 3);
		getText(CRDispatcherUpdatePage.lblTime, "Time in DUS");

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: click on update
	 * description :: click Of update
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void clickOnUpdate() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.btnUpdate, "wait for update in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.btnUpdate, 3);
		click(CRDispatcherUpdatePage.btnUpdate, "Update in DUS");

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOfCancel
	 * description :: getText Of cancel
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfCancel() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.btnCancel, "wait for cancel in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.btnCancel, 3);
		getText(CRDispatcherUpdatePage.btnCancel, "Cancel in DUS");

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOf dispatch upadate title
	 * description :: getText Of dispatch update title
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfDispatcherUpdateStatusTitle() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.lblDispatcherUpdateStatusPanel, "wait for dispatcher updates status title ");
		dynamicWaitByLocator(CRDispatcherUpdatePage.lblDispatcherUpdateStatusPanel, 3);
		getText(CRDispatcherUpdatePage.lblDispatcherUpdateStatusPanel, "dispatcher updates status title");

	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterInComments
	 * description :: Enter value in comments
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void enterInComments(String Comment) throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.txtCommentData, "wait for comment in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.txtCommentData, 3);
		type(CRDispatcherUpdatePage.txtCommentData,Comment, "wait for cancel in DUS");

	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterInReasonForStatus
	 * description :: enterInReasonForStatus
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void enterInReasonForStatus(String ReasonForStatus) throws Throwable {
		if(isVisibleOnly(CRDispatcherUpdatePage.drpReasonStatus, "Reason status")) {
			dynamicWaitByLocator(CRDispatcherUpdatePage.drpReasonStatus, 3);
			type(CRDispatcherUpdatePage.txtReasonForStatus, ReasonForStatus, "wait for cancel in DUS");
			String combineKeys3 = Keys.chord(Keys.TAB);
			sendKeys(combineKeys3, "Tab");
		}
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterInStatus
	 * description :: enter In Status
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void enterInStatus(String Status) throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.txtStatus, "wait for status in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.txtStatus, 3);
		type(CRDispatcherUpdatePage.txtStatus,Status, "wait for status in DUS");
		String combineKeys3 = Keys.chord(Keys.TAB);
		sendKeys(combineKeys3, "Tab");

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnStatusDrpdwnAndGetAllData
	 * description :: click On Status DrpdwnAndGetAllData
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void clickOnStatusDrpdwnAndGetAllData() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.drpStatus, "wait for status in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.drpStatus, 3);
		//click(CRDispatcherUpdatePage.txtStatus, "wait for status in DUS");
		setFocusAndClick(CRDispatcherUpdatePage.drpStatus, "drop down");
		//click(CRDispatcherUpdatePage.statusList, "wait for status in DUS");
		//dynamicWaitByLocator(CRDispatcherUpdatePage.statusList,3);
		Thread.sleep(3000);
		List<WebElement> statusList = driver.findElements(CRDispatcherUpdatePage.statusList);
		int totalCount = statusList.size();
		int counter = 1;
		if (totalCount > 69) {
			//this.reporter.SuccessReport("List of status item  ", "  Total status items :  " + totalCount);
			for (int i = 70; i < statusList.size(); i++) {
				this.reporter.SuccessReport("status name", +counter + "is " + statusList.get(i).getText());
				counter++;
			}
		} else {
			this.reporter.SuccessReport("No list  found", +totalCount + "is Empty");
			//k++;
		}
		//return true;
	}




		/**
		 * param :: String inputs
		 * return ::void
		 * throws :: throwable
		 * methodName :: enterTruckId
		 * description :: Enter value Of truck
		 * date :: 13-feb-2018
		 * author :: Ravi
		 */
		public void enterTruckId(String TruckValue) throws Throwable {
			waitForVisibilityOfElement(CRDispatcherUpdatePage.txtTruckId, "wait for truck in DUS");
			dynamicWaitByLocator(CRDispatcherUpdatePage.txtTruckId, 3);
			type(CRDispatcherUpdatePage.txtTruckId,TruckValue, "Truck in DUS");

		}



	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getTextOfErrorUpdateCode
	 * description :: getTextOfErrorUpdateCode
	 * date :: 14-feb-2018
	 * author :: Ravi
	 */
	public void getTextOfErrorUpdateCode() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.lblErrorUpdateCode, "wait for Reason for status in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.lblErrorUpdateCode, 3);
		getText(CRDispatcherUpdatePage.lblErrorUpdateCode, "error update code");


	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnCancel
	 * description :: clickOnCancel
	 * date :: 13-feb-2018
	 * author :: Ravi
	 */
	public void clickOnCancel() throws Throwable {
		if(isVisibleOnly(CRDispatcherUpdatePage.btnCancel, "cancel in DUS")){
			waitForVisibilityOfElement(CRDispatcherUpdatePage.btnCancel, "wait for cncel in DUS");
			dynamicWaitByLocator(CRDispatcherUpdatePage.btnCancel, 3);
			click(CRDispatcherUpdatePage.btnCancel, "Cancel in DUS");
		}
	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterTruckId
	 * description :: Enter value Of truck
	 * date :: 14-feb-2018
	 * author :: Ravi
	 */
	public void clearTruck() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.txtTruckId, "wait for truck in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.txtTruckId, 3);
		clearData(CRDispatcherUpdatePage.txtTruckId);

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enter facility
	 * description :: enter Facility
	 * date :: 14-feb-2018
	 * author :: Ravi
	 */
	public void enterFacility(String EnterFacility) throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.txtFacilityId, "wait for facility in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.txtFacilityId, 3);
	//	getText(CRDispatcherUpdatePage.txtFacilityId, "enter Facility in DUS");
		type(CRDispatcherUpdatePage.txtFacilityId,EnterFacility, "enter Facility in DUS");

	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName ::enterFacilityNotEditable
	 * description :: enterFacilityNotEditable
	 * date :: 14-feb-2018
	 * author :: Ravi
	 */
	public void enterFacilityNotEditable() throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.txtFacilityNotEditable, "wait for facility in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.txtFacilityNotEditable, 3);
		click(CRDispatcherUpdatePage.txtFacilityNotEditable,"facililty not editable");
		{
			this.reporter.SuccessReport("Successfully unable to change data in facility", "Unable to enter facility");
		}
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enter date
	 * description :: enter date
	 * date :: 14-feb-2018
	 * author :: Ravi
	 */
	public void enterDate(String Date) throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.txtDate, "wait for date in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.txtDate, 3);
		type(CRDispatcherUpdatePage.txtDate,Date,"enter Date in DUS");

	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enter date
	 * description :: enter Time
	 * date :: 14-feb-2018
	 * author :: Ravi
	 */
	public void enterTime(String Date) throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.txtTime, "wait for time in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.txtTime, 3);
		type(CRDispatcherUpdatePage.txtTime,Date,"enter time in DUS");

	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enter comment
	 * description :: enter comment
	 * date :: 14-feb-2018
	 * author :: Ravi
	 */
	public void enterComment(String Date) throws Throwable {
		waitForVisibilityOfElement(CRDispatcherUpdatePage.txtCommentData, "wait for txtCommentData in DUS");
		dynamicWaitByLocator(CRDispatcherUpdatePage.txtCommentData, 3);
		type(CRDispatcherUpdatePage.txtCommentData,Date,"enter txtCommentData in DUS");

	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnOKAndCancel
	 * description :: click On OKAndCancel
	 * date :: 18-feb-2018
	 * author :: Ravi
	 */
	public void clickOnOK() throws Throwable {
		if (isVisibleOnly(CRDispatcherUpdatePage.lblErrorOk, "Error ok button")){
			click(CRDispatcherUpdatePage.lblErrorOk, "Error ok button");
			dynamicWaitByLocator(CRDispatcherUpdatePage.btnCancel,3);
			//clickUntilElementNotVisiable(CRDispatcherUpdatePage.btnCancel,CRDispatcherUpdatePage.btnCancel ,"cancel button");
		}
		//clickUntilElementNotVisiable(CRDispatcherUpdatePage.btnCancel,CRDispatcherUpdatePage.btnCancel ,"cancel button");

	}
}
