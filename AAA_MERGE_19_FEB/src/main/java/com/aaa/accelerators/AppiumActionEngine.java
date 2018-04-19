package com.aaa.accelerators;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aaa.report.ConfigFileReadWrite;
import com.aaa.report.ReporterConstants;
import com.aaa.utilities.Xls_Reader;

public class AppiumActionEngine extends TestEngineWeb{
	//Declarations
	private static final Logger LOG = Logger.getLogger(AppiumActionEngine.class);	
	private final String msgClickSuccess = "Successfully Clicked On ";
	private final String msgClickFailure = "Unable To Click On ";
	private final String msgTypeSuccess = "Successfully Typed On ";
	private final String msgTypeFailure = "Unable To Type On ";
	private final String msgIsElementFoundSuccess = "Successfully Found Element ";
	private final String msgIsElementFoundFailure = "Unable To Found Element ";
	public static Xls_Reader TestData = new Xls_Reader(System.getProperty("user.dir") + "/TestData/TestData.xlsx");
	public String gErrMsg = "";
	protected boolean reportIndicator = true;
	protected String CALL_RECEIVING_URL = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "callReceivingURL");
	protected String DISPATCH_URL = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "dispatchURL");
	protected String RSO_WEB_URL = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "RSOWebURL");
	protected String RSO_WEB_URL_MESTAG = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "RSOWebURLMestag");
	protected String landingURL;

	//AppiumActionEngineMethods
	/**
	 * click
	 * 
	 * @param locator
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public boolean click(By locator, String locatorName) throws Throwable
	{
		boolean status = false;
		try
		{
		this.appiumDriver.findElement(locator).click();
		this.reporter.SuccessReport("Click" , this.msgClickSuccess + locatorName);
		status = true;
		}
		catch(Exception e)
		{
			status = false;
			LOG.info(e.getMessage());
			this.reporter.failureReport("Click", this.msgClickFailure + locatorName, this.appiumDriver);
			
		}
		return status;
		
	}
	
	/**
	 * waitForVisibilityOfElement
	 * 
	 * @param locator
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public boolean waitForVisibilityOfElement(By by, String locatorName) throws Throwable {
		boolean flag = false;
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		LOG.info("Class name" + getCallerClassName() + "Method name : " + getCallerMethodName());
		LOG.info("Method : " + getCallerMethodName() + "  ::  Locator : " + locatorName);
		WebDriverWait wait = new WebDriverWait(this.appiumDriver, 25);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			flag = true;
			LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			return true;
		} catch (Exception e) {
			LOG.info("++++++++++++++++++++++++++++Catch Block Start+++++++++++++++++++++++++++++++++++++++++++");
			LOG.info("Class name" + getCallerClassName() + "Method name : " + getCallerMethodName());

			LOG.info("++++++++++++++++++++++++++++Catch Block End+++++++++++++++++++++++++++++++++++++++++++");
			return false;
		} finally {
			if (!flag) {
				reporter.failureReport("Visible of element is false :: ", "Element :: " + locatorName + " is not visible", this.appiumDriver);
			} else {
				reporter.SuccessReport("Visible of element is true :: ", "Element :: " + locatorName + "  is visible");
			}
		}
	}

	/**
	 * selectByIndex
	 * 
	 * @param locator
	 * @param index
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public boolean selectByIndex(By locator, int index,
			String locatorName) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(appiumDriver.findElement(locator));
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				this.reporter.failureReport("Select", "Option at index " + index
						+ " is Not Select from the DropDown" + locatorName);
				

			} else if (flag) {
				this.reporter.SuccessReport("Select", "Option at index " + index
						+ "is Selected from the DropDown" + locatorName);
				
			}
		}
	}
	
	/**
	 * isElementPresent
	 * 
	 * @param locator
	 * @param locatorName
	 * @param expected
	 * @return
	 * @throws Throwable
	 */
	public boolean isElementPresent(By by, String locatorName,boolean expected) throws Throwable
	{
		boolean status = false;
		try
		{
			this.appiumDriver.findElement(by);
			this.reporter.SuccessReport("isElementPresent" , this.msgIsElementFoundSuccess + locatorName);
			status = true;
		}
		catch(Exception e)
		{
			status = false;
			LOG.info(e.getMessage());
			if(expected == status)
			{
				this.reporter.SuccessReport("isElementPresent", "isElementPresent");
			}
			else
			{
				this.reporter.failureReport("isElementPresent", this.msgIsElementFoundFailure + locatorName, this.appiumDriver);
			}
		}
		return status;
	}
	
	/**
	 * type
	 * 
	 * @param locator
	 * @param testdata
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public boolean type(By locator, String testdata, String locatorName) throws Throwable
	{
		boolean status = false;
		try
		{
			this.appiumDriver.findElement(locator).clear();
			this.appiumDriver.findElement(locator).sendKeys(testdata);
			this.reporter.SuccessReport("type" , this.msgTypeSuccess + locatorName);
			status = true;
		}
		catch(Exception e)
		{
			status = false;
			LOG.info(e.getMessage());
			this.reporter.failureReport("type", this.msgTypeFailure + locatorName, this.appiumDriver);
		}
		
		return status;
	}
	
	/**
	 * Click
	 * 
	 * @param locator
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public boolean Click(By locator, String locatorName) throws Throwable
	{
		boolean status = false;
		try
		{
		this.driver.findElement(locator).click();
		this.reporter.SuccessReport("Click" , this.msgClickSuccess + locatorName);
		status = true;
		}
		catch(Exception e)
		{
			status = false;
			LOG.info(e.getMessage());
			this.reporter.failureReport("Click", this.msgClickFailure + locatorName, this.appiumDriver);
			
		}
		return status;
		
	}
	
	/**
	 * Type
	 * 
	 * @param locator
	 * @param testdata
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public boolean Type(By locator, String testdata, String locatorName) throws Throwable
	{
		boolean status = false;
		try
		{
			this.driver.findElement(locator).clear();
			this.driver.findElement(locator).sendKeys(testdata);
			this.reporter.SuccessReport("type" , this.msgTypeSuccess + locatorName);
			status = true;
		}
		catch(Exception e)
		{
			status = false;
			LOG.info(e.getMessage());
			this.reporter.failureReport("type", this.msgTypeFailure + locatorName, this.appiumDriver);
		}
		
		return status;
	}
	
	/**
	 * waitForElementPresent
	 * 
	 * @param locator
	 * @param locatorName
	 * @param secs
	 * @return
	 * @throws Throwable
	 */
	public boolean waitForElementPresent(By by, String locator, int secs)
			throws Throwable {
		boolean status = false;
		
		try {
			WebDriverWait wait = new WebDriverWait(this.appiumDriver, 3);
 			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			for (int i = 0; i < secs/2; i++)
			{
				List<WebElement> elements = this.appiumDriver.findElements(by);
				if (elements.size()>0)
				{
					status = true;
					return status;

				} 
				else
				{
					this.appiumDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				}
			}
	       
		
		} 
		catch (Exception e) {
			
			return status;
		} 
	
		return status;
		
	}
	/**
	 * WaitForElementPresent
	 * 
	 * @param locator
	 * @param locatorName
	 * @param secs
	 * @return
	 * @throws Throwable
	 */
	public boolean WaitForElementPresent(By by, String locator, int secs)
			throws Throwable {
		boolean status = false;
		
		try {
			WebDriverWait wait = new WebDriverWait(this.driver, 3);
 			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			for (int i = 0; i < secs/2; i++)
			{
				List<WebElement> elements = this.driver.findElements(by);
				if (elements.size()>0)
				{
					status = true;
					return status;

				} 
				else
				{
					this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				}
			}
	       
		
		} 
		catch (Exception e) {
			
			return status;
		} 
	
		return status;
		
	}
	/**
	 * getCallerClassName
	 * 
	 * @Parameter:
	 * @return:
	 */
	public static String getCallerClassName() {
		StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
		return stElements[3].getClassName();
	}

	/**
	 * getCallerMethodName
	 * 
	 * @Parameter:
	 * @return:
	 */
	public static String getCallerMethodName() {
		StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
		return stElements[3].getMethodName();
	}
	public void navigateToApplication(String url) throws Throwable{
		try {
			LOG.info("++++++++++++++++++++++++++++Navigate to URL start+++++++++++++++++++++++++++++++++++++++++++");
			LOG.info("++++++++++++++++++++++++++++"+url+"+++++++++++++++++++++++++++++++++++++++++++");
			Thread.sleep(2000);
			//driver.close();
			switch (url){
				case "CR":
					LOG.info("++++++++++++++++++++++++++++"+CALL_RECEIVING_URL+"+++++++++++++++++++++++++++++++++++++++++++");
					LOG.info("++++++++++++++++++++++++++++"+url+"+++++++++++++++++++++++++++++++++++++++++++");
					
					driver.get(CALL_RECEIVING_URL);
					acceptAlert();
					driver.navigate().to(CALL_RECEIVING_URL);
					acceptAlert();
					landingURL = CALL_RECEIVING_URL;
					break;
				case "DI":
					LOG.info("++++++++++++++++++++++++++++"+DISPATCH_URL+"+++++++++++++++++++++++++++++++++++++++++++");
					LOG.info("++++++++++++++++++++++++++++"+url+"+++++++++++++++++++++++++++++++++++++++++++");
					driver.get(DISPATCH_URL);
					acceptAlert();
					driver.navigate().to(DISPATCH_URL);
					acceptAlert();
					landingURL = DISPATCH_URL;
					break;
				case "RSOWEB":
					LOG.info("++++++++++++++++++++++++++++"+RSO_WEB_URL+"+++++++++++++++++++++++++++++++++++++++++++");
					LOG.info("++++++++++++++++++++++++++++"+url+"+++++++++++++++++++++++++++++++++++++++++++");
					//driver.navigate().to(RSO_WEB_URL);
					//acceptAlert();
					driver.get(RSO_WEB_URL);
					landingURL = RSO_WEB_URL;
					break;
				case "RSOWEBMestag":
					LOG.info("++++++++++++++++++++++++++++"+RSO_WEB_URL_MESTAG+"+++++++++++++++++++++++++++++++++++++++++++");
					LOG.info("++++++++++++++++++++++++++++"+url+"+++++++++++++++++++++++++++++++++++++++++++");
					//driver.navigate().to(RSO_WEB_URL);
					//acceptAlert();
					driver.get(RSO_WEB_URL_MESTAG);
					landingURL = RSO_WEB_URL_MESTAG;
					break;
			}
			Thread.sleep(5000);
			reporter.SuccessReport("Navigate to URL" + url,
					"Navigate to URL is successfull:" + landingURL);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
 /**
	 * Click on OK button on alert
	 */
	protected void acceptAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}


