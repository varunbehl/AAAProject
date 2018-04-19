package com.aaa.web.lib;

import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.CREpostPage;
import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.CRMemberSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;

import java.util.List;

/**
 * Created by E002734 on 2/9/2018.
 */
public class CREpostLib extends ActionEngine {
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnDrpdwnHelp
	 * description :: click on drop down in help
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void clickOnDrpdwnHelp() throws Throwable {
		dynamicWaitByLocator(CREpostPage.drpdwnHelp,6);
		waitForVisibilityOfElement(CREpostPage.drpdwnHelp, "wait for Drop down in help");
		click(CREpostPage.drpdwnHelp, "clicks on dropdown in help");
		dynamicWaitByLocator(CREpostPage.lblElectronicPost,2);
	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnEpost
	 * description :: click on E post
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void clickOnEpost() throws Throwable {
		waitForVisibilityOfElement(CREpostPage.lblEpost, "wait for E post");
		click(CREpostPage.lblEpost, "clicks on E post");
		dynamicWaitByLocator(CREpostPage.lblElectronicPost,3);
	}



	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: enterDataInKeyboard
	 * description :: enter Data In Keyboard
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void enterDataInKeyboard(String KeyboardData) throws Throwable {
		waitForVisibilityOfElement(CREpostPage.txtKeybord, "wait for keyboard");
		//	click(CREpostPage.lblEpost, "clicks on E post");
		type(CREpostPage.txtKeybord,KeyboardData, "Enter disney");
		dynamicWaitByLocator(CREpostPage.btnSearchButtonEpost,2);
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnSearchButton
	 * description :: click on search button
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void clickOnSearchButton() throws Throwable {
		waitForVisibilityOfElement(CREpostPage.btnSearchButtonEpost, "wait for search button in E post");
		click(CREpostPage.btnSearchButtonEpost, "clicks on search button in E post");
		dynamicWaitByLocator(CREpostPage.lblElectronicPost,2);
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnClearButton
	 * description :: click on clear button
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void clickOnClearButton() throws Throwable {
		waitForVisibilityOfElement(CREpostPage.btnClearEpost, "wait for clear button in E post");
		dynamicWaitByLocator(CREpostPage.btnClearEpost,3);
		click(CREpostPage.btnClearEpost, "clicks on clear button in E post");

	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnMenuCheckbox
	 * description :: click on menu check box
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void clickOnMenuCheckbox() throws Throwable {
		waitForVisibilityOfElement(CREpostPage.chkboxMenu, "wait for check box button in E post");
		boolean chkboxStatus = isCheckBoxSelected(CREpostPage.chkboxMenu);
		if(chkboxStatus)
		{
			click(CREpostPage.chkboxMenu, "menu check box button in E post");
		}
		/*mouseDoubleClick(CREpostPage.chkboxMenu, "clicks on menu check box button in E post");
		dynamicWaitByLocator(CREpostPage.chkboxMenu,5);
		//click(CREpostPage.chkboxMenu, "clicks on menu check box button in E post");*/
	}



	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnCategoriesCheckbox
	 * description :: click on categories check box
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void clickOnCategoriesCheckbox() throws Throwable {
		/*waitForVisibilityOfElement(CREpostPage.chkboxCategories, "wait for check box button in categories E post");
		dynamicWaitByLocator(CREpostPage.chkboxCategories,5);*/
		Thread.sleep(5000);
		waitForVisibilityOfElement(CREpostPage.chkboxCategories, "wait for check box button in E post");
		boolean chkboxStatus = isCheckBoxSelected(CREpostPage.chkboxCategories);
		if(!chkboxStatus)
		{
			click(CREpostPage.chkboxCategories, "categories check box button in E post");
		}

		/*mouseDoubleClick(CREpostPage.chkboxCategories, "clicks on categories check box button in E post");
		dynamicWaitByLocator(CREpostPage.chkboxCategories,3);*/
		//click(CREpostPage.chkboxCategories, "clicks on categories check box button in E post");
	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnDetatilsCheckbox
	 * description :: click on detail check box
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void clickOnDetatilsCheckbox() throws Throwable {
		waitForVisibilityOfElement(CREpostPage.chkboxDetails, "click on check box button in Details E post");
		Thread.sleep(5000);
	/*	boolean chkboxStatus = isCheckBoxSelected(CREpostPage.chkboxDetails);
		if(chkboxStatus)
		{
			click(CREpostPage.chkboxDetails, "details check box button in E post");
		}*/
		WebElement element=driver.findElement(By.xpath("//input[@id='electronic-posting-search-details']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		//selectByIndex(CREpostPage.chkboxDetails,6345,"click on check box button in Details E post");
		//keyBoardOperations(CREpostPage.chkboxDetails, Keys.SPACE, "click on check box button in Details E post");
		// mouseClick(CREpostPage.chkboxDetails, "click on check box button in Details E post");
		//clickUntilElementNotVisiable(CREpostPage.chkboxDetails,CREpostPage.chkboxDetails, "clicks on categories check box button in Details E post");
		dynamicWaitByLocator(CREpostPage.lblElectronicPost,5);
		//click(CREpostPage.chkboxDetails, "clicks on categories check box button in Details E post");
	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnHighlightednameInMenuAndCatergories
	 * description :: click on highlighted text in menu and catergories
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void clickOnHighlightednameInMenuAndCatergories() throws Throwable {

		Thread.sleep(6000);
		getText(CREpostPage.highlightDisney, "click highlighted text in menu");
		click(CREpostPage.highlightDisney, "click highlighted text in menu");
		dynamicWaitByLocator(CREpostPage.highlightDisney,5);
		//getText(CREpostPage.highlightDisney, "click highlighted text in menu");
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnHighlightednameInCategories
	 * description :: click on highlighted text in categories
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void clickOnHighlightednameInCategories() throws Throwable {
		waitForVisibilityOfElement(CREpostPage.highlightDisneyLastCategories, "wait for highlighted text in categories");
		//dynamicWaitByLocator(CREpostPage.highlightDisneyLastCategories,5);
		Thread.sleep(5000);
		click(CREpostPage.highlightDisneyLastCategories, "click highlighted text in categories");
		dynamicWaitByLocator(CREpostPage.highlightDisneyLastCategories,3);
		//getText(CREpostPage.highlightDisneyLastCategories, "click highlighted text in categories");
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnMenuItem
	 * description :: click on menu item
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void selectMenuItem() throws Throwable {
		dynamicWaitByLocator(CREpostPage.lblBatteryService,2);
		Thread.sleep(3000);
		click(CREpostPage.lblBatteryService, "click battery service");
		dynamicWaitByLocator(CREpostPage.lblBatteryService,2);
		getText(CREpostPage.lblBatteryService, "click battery service");
		//dynamicWaitByLocator(CREpostPage.lblElectronicPost,2);
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnCategoriesItem
	 * description :: click on categories item
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void selectCategoriesItem() throws Throwable {
		waitForVisibilityOfElement(CREpostPage.lblElectronicPost, "wait for  categories item");
		dynamicWaitByLocator(CREpostPage.lblGeorgia,2);
		click(CREpostPage.lblGeorgia, "select item in categories");
		getText(CREpostPage.lblGeorgia, "select item in categories");
		dynamicWaitByLocator(CREpostPage.lblElectronicPost,2);
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnAnotherMenuItems
	 * description :: click on another menu items
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void clickOnAnotherMenuItems() throws Throwable {
		waitForVisibilityOfElement(CREpostPage.lblERSoT, "wait for  menu items");
		dynamicWaitByLocator(CREpostPage.lblERSoT,2);
		click(CREpostPage.lblERSoT, "select another  item in menu item");
		dynamicWaitByLocator(CREpostPage.lblERSoT,2);
		getText(CREpostPage.lblERSoT, "select another  item in menu item");
	}
	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getNumberOfMenuItemsPopulated
	 * description :: getNumber Of MenuItems Populated
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public boolean getNumberOfMenuItemsPopulated() throws Throwable {
		dynamicWaitByLocator(CREpostPage.listMenuItems,3);
		List<WebElement> menuItems = driver.findElements(CREpostPage.listMenuItems);
		int totalCount=menuItems.size();
		int counter = 1;
		if(totalCount>1) {
			//this.reporter.SuccessReport("List of menu item  ", "  Total Menu items :  " + totalCount);

			for (int i = 0; i < menuItems.size(); i++) {
				this.reporter.SuccessReport("menu item name", +counter + "is " + menuItems.get(i).getText());
				counter++;
			}
		}
		else{
			this.reporter.SuccessReport("No categories found", +totalCount + "is Empty");
			//k++;
		}
		return true;

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getNumberOfMenuItemsPopulated
	 * description :: getNumber Of MenuItems Populated
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public boolean getNumberOfCategoriesItemsPopulated() throws Throwable {
		Thread.sleep(5000);
		dynamicWaitByLocator(CREpostPage.listCategories,3);
		List<WebElement> categories = driver.findElements(CREpostPage.listCategories);
		int totalCount=categories.size();
		if(totalCount>1){
			this.reporter.SuccessReport("List of categories item  ","  Total catergories items :  "+ totalCount );
			int counter=1;
			for (int i = 0; i < categories.size(); i++) {
				//this.reporter.SuccessReport("List of categories ","  Total categories :  "+ totalCount +"  and menu item  name is: " +categories.get(i).getText());
				this.reporter.SuccessReport("catergories item name",+counter+ "is "+  categories.get(i).getText());
				counter++;
			}
		}else {
			this.reporter.SuccessReport("No categories found",+totalCount+ "is Empty"  );

		}
		return true;

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnCloseIcon
	 * description :: click on close icon in E post
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void clickOnCloseIcon() throws Throwable {
		if(isVisibleOnly(CREpostPage.btnCloseEpost, "wait for close button")) {
			waitForVisibilityOfElement(CREpostPage.btnCloseEpost, "wait for close button");
			Thread.sleep(3000);
			click(CREpostPage.btnCloseEpost, "click on close button in e post");
			//dynamicWaitByLocator(CREpostPage.lblElectronicPost,2);
		}
	}

	/**
	 * param :: NA
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnAutospotFailMsgOk
	 * description ::
	 * * date :: 22-Jan-2018
	 * author :: Nidhi
	 */

	public void verifyElectronicPost() throws Throwable {
		//isElementPresent(CREpostPage.lblElectronicPost,"Electronic post visibility");
		dynamicWaitByLocator(CREpostPage.lblElectronicPost,3);
		getText(CREpostPage.lblElectronicPost,"Electronic post visibility");
		{
			this.reporter.SuccessReport("Successfully verified  ",
					" Electronic post   " );
		}

	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: getNumberOfDetailsDiscriptionData
	 * description :: get Number Of Details Discription Data
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public boolean getNumberOfDetailsDiscriptionData() throws Throwable {
		Thread.sleep(5000);
		dynamicWaitByLocator(CREpostPage.listDetailedInfo,5);
		List<WebElement> detaileInfo = driver.findElements(CREpostPage.listDetailedInfo);
		int totalCount=detaileInfo.size()-1;
		if(totalCount>1){
			this.reporter.SuccessReport("List of Detail information  ","  Total Detailed info items :  "+ totalCount );
			for (int i = 0; i < detaileInfo.size(); i++) {
				this.reporter.SuccessReport("detailed info name",+i+ "is "+  detaileInfo.get(i).getText());
			}
		}else {
			this.reporter.SuccessReport("No categories found",+totalCount+ "is Empty"  );

		}
		return true;

	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: verifyDetailedInfoByCategoriesItemsPopulated
	 * description :: verify Detailed Info By Clicking on Categories Items Populated
	 * date :: 12-feb-2018
	 * author :: Ravi
	 */
	public boolean verifyDetailedInfoByCategoriesItemsPopulated() throws Throwable {
		dynamicWaitByLocator(CREpostPage.listCategories,3);
		List<WebElement> categories = driver.findElements(CREpostPage.listCategories);
		int totalCount=categories.size();
		String detailedInformationText;
		if(totalCount>1){
			this.reporter.SuccessReport("List of categories item  ","  Total catergories items :  "+ totalCount );
			int j=1;
			for (int i = 0; i < categories.size(); i++) {
				//this.reporter.SuccessReport("List of categories ","  Total categories :  "+ totalCount +"  and menu item  name is: " +categories.get(i).getText());
				this.reporter.SuccessReport("catergories item name",+j+ "is "+  categories.get(i).getText());
				categories.get(i).click();
				Thread.sleep(5000);
				detailedInformationText = getText(CREpostPage.listDetailedInfo,"data populated in details info");
				assertTrue(detailedInformationText.toLowerCase().contains("disney"), "Text has displayed as excepted in Detailed Information textbox");
				j++;
			}
		}else {
			this.reporter.SuccessReport("No categories found",+totalCount+ "is Empty"  );

		}
		return true;

	}


	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnPopout
	 * description :: click on popout icon
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void clickOnPopout() throws Throwable {
		//waitForVisibilityOfElement(CREpostPage.btnCloseEpost, "wait for close button");
		//	dynamicWaitByLocator(CREpostPage.lblElectronicPost,2);
		Thread.sleep(3000);
		click(CREpostPage.imgPopout, "click on pop out in e post");
		//dynamicWaitByLocator(CREpostPage.lblElectronicPost,2);
	}

	/**
	 * param :: String inputs
	 * return ::void
	 * throws :: throwable
	 * methodName :: clickOnPopIn
	 * description :: click on pop in icon
	 * date :: 09-feb-2018
	 * author :: Ravi
	 */
	public void clickOnPopIn() throws Throwable {
		if (isVisibleOnly(CREpostPage.imgPopIn, "wait for pop-in")) {
			Thread.sleep(5000);
			click(CREpostPage.imgPopIn, "click on pop in e post");
			//dynamicWaitByLocator(CREpostPage.lblElectronicPost,2);
		}
	}



}
