package com.aaa.accelerators;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aaa.commonutilities.CoreUtilities;
import com.aaa.commonutilities.CustomTestListenerCT;
import com.aaa.commonutilities.ExtentReportThread;
import com.aaa.report.CReporter;
import com.aaa.report.CReporterAppium;
import com.aaa.report.CReporter_Mobile;
import com.aaa.report.ConfigFileReadWrite;
import com.aaa.report.Mobiledriver;
import com.aaa.report.ReporterConstants;
import com.aaa.support.ExcelReader;
import com.aaa.support.MyListener;
import com.aaa.utilities.DataBean;
import com.aaa.utilities.WriteIntoExcel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author in01518
 */

/**
 * @author 
 */
@Listeners(CustomTestListenerCT.class)
public class TestEngine {
	public final Logger LOG = Logger.getLogger(TestEngine.class);
	protected AppiumDriver appiumDriver = null;
	protected WebDriver WebDriver = null;
	public static EventFiringWebDriver driver = null;
    public static CReporterAppium reporter = null;
	public ITestContext ctx = null;
	public static String gTestCaseDesc=null;

	/* cloud platform */
	public String browser = null;
	public String version = null;
	public String platform = null;
	public String seleniumgridurl=null;
	public String environment = null;
	public static String Environment = null;
	public String localBaseUrl = null;
	public String cloudBaseUrl = null;
	public String userName = null;
	public String accessKey = null;
	public String cloudImplicitWait = null;
	public String cloudPageLoadTimeOut = null;
	public String updateJira = null;
	public String buildNumber = "";
	public String jobName = "";
	public String executedFrom = null;
	public String executionType = null;
	public String suiteExecution = null;
	public String suiteStartTime = null;
	/*String APP_BASE_URL = ConfigFileReadWrite.read(
			ReporterConstants.configReporterFile, "baseUrl");*/
	public String APP_BASE_URL = null;
	public String SUMMARY_REPORTER_BASEURL = null;
	public static String LOCATION_CLIENT_LOGO = null;
	private final String msgTypeSuccess = "Successfully Entered value ";
	

	public static long startTime;
	public static String fileName = System.getProperty("user.dir")
			+ "/TestData/TestData.xls";
	public static ExcelReader xlsrdr = new ExcelReader(fileName);
	public static DataBean dataBean = new DataBean();
	public static WriteIntoExcel excelEntry = new WriteIntoExcel();
	public HashMap<String, String> mapObj = new HashMap<String, String>();

	// Below parameters are for update the test data into Excel at run time
	public static String testCase;
	public static String globalsheetName = null;
	public static int gTestCaseStartRowNum = 0;

	public static String gTestData = System.getProperty("user.dir")
			+ File.separator + "TestData" + File.separator + "TestData.xlsx";
	//declared variable for testdata multiple iterations of a testcase
	//public static ArrayList<String> listofTestCaseDescription = new ArrayList<String>();
	public static HashMap<String,String> listofTestCaseDescription = new HashMap<String,String>();
	public static int i=0;
	public static DesiredCapabilities capabilitiesForAppium = new DesiredCapabilities();
	public static Mobiledriver ad=new Mobiledriver();
	private final String msgTypeFailure = "Unable To Type On ";
	private final String msgIsElementFoundSuccess = "Successfully Found Element ";
	/**/
	// private DesiredCapabilities capabilitiesForAppium = new
	// DesiredCapabilities();
	@Parameters({"executionType", "suiteExecuted"})
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext ctx, String type, String suite)
			throws Throwable {
		startTime = System.currentTimeMillis();
		ctx.setAttribute("browser", System.getenv("Browsers"));
		LOG.info("--------------------------------------------------------------------------");
		LOG.info("------------------Suite :: " + suite
				+ "------------------------------");
		LOG.info("Execution Start Time :: " + startTime);
		LOG.info("Test Data Path :: " + fileName);
		LOG.info("Executing on :: " + System.getenv("Browsers"));
		LOG.info("---------------------------End Suite Details-----------------------------------");
		executionType = type;
		suiteExecution = suite;
		PropertyConfigurator.configure(System.getProperty("user.dir")
				+ "/Log.properties");
		// ReportStampSupport.calculateSuiteStartTime();
		// ObjectRepository.storeIdentification();
		// ObjectRepository.storeValue();

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy hh mm ss SSS");
		String formattedDate = sdf.format(date);
		suiteStartTime = formattedDate.replace(":", "_").replace(" ", "_");
	}

	@BeforeTest
	@Parameters({ "automationName", "browserName", "browserVersion", "environment",
			"platformName","app","appPackage","platformVersion","appiumUrl","deviceName","appActivity","udid"})
	public void beforeTest(String automationName, String browserName,
			String browserVersion, String environment, String platformName,String app,String appPackage,String platformVersion,String appiumUrl,String deviceName,String appActivity,String udid,ITestContext iTestContext)
			throws IOException, InterruptedException {
		LOG.info("---------------------");
		LOG.info("-----Before Test----");
		LOG.info("---------------------");
		LOG.info("Execution Start Time :: " + startTime);
		LOG.info("browser name :: " + browser + " Browser version :: "
				+ browserVersion + " platform ::" + platformName);
		String testName = iTestContext.getName();
		APP_BASE_URL = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "emBaseUrl");
		SUMMARY_REPORTER_BASEURL = APP_BASE_URL;
		
		this.browser = browserName;
		this.version = browserVersion;
		this.platform = platformName;
		this.environment = environment;
		Environment = environment;
		this.localBaseUrl = ReporterConstants.APP_BASE_URL;
		this.userName = ReporterConstants.SAUCELAB_USERNAME;
		this.accessKey = ReporterConstants.SAUCELAB_ACCESSKEY;
		this.executedFrom = System.getenv("COMPUTERNAME");
		this.cloudImplicitWait = ReporterConstants.CLOUD_IMPLICIT_WAIT;
		this.cloudPageLoadTimeOut = ReporterConstants.CLOUD_PAGELOAD_TIMEOUT;
		this.updateJira = "";
		
		final StringBuilder appPath=new StringBuilder().append(System.getProperty("user.dir")+ "/TestApps/"+app);

		if (environment.equalsIgnoreCase("local")) {
			if (browserName.equalsIgnoreCase("Chrome")
					&& platformName.equalsIgnoreCase("Android")) {
				DesiredCapabilities capabilitiesAndroid = new DesiredCapabilities();
				capabilitiesAndroid.setCapability("browserName", browserName);
				capabilitiesAndroid.setCapability("deviceName", deviceName);
				capabilitiesAndroid.setCapability("name", testName);
				capabilitiesAndroid.setCapability("platformName", platformName);
				capabilitiesAndroid.setCapability("maxSession", "2");
				capabilitiesAndroid.setCapability("maxInstances", "2");
				WebDriver = new RemoteWebDriver(new URL(appiumUrl), capabilitiesAndroid);
			}
			/*if (browser.equalsIgnoreCase("safari")
					&& platformName.equalsIgnoreCase("ios")) {

				DesiredCapabilities capabilitiesAndroid = new DesiredCapabilities();
				capabilitiesAndroid.setCapability("browserName", browserName);
				capabilitiesAndroid.setCapability("deviceName", deviceName);
				capabilitiesAndroid.setCapability("platformName", platformName);
				capabilitiesAndroid.setCapability("maxSession", "2");
				capabilitiesAndroid.setCapability("maxInstances", "2");
				WebDriver = new RemoteWebDriver(new URL(appiumUrl), capabilitiesAndroid);
			}*/
			
			if (platformName.equalsIgnoreCase("android") && !app.equalsIgnoreCase("NA")) {
				//capabilitiesForAppium.setCapability(MobileCapabilityType.ROTATABLE,rotatable.equalsIgnoreCase("true")== true ? true : false);
				//capabilitiesForAppium.setCapability(MobileCapabilityType.BROWSER_NAME, browsername);	
				capabilitiesForAppium.setCapability(MobileCapabilityType.APP_PACKAGE, appPackage);
				capabilitiesForAppium.setCapability(MobileCapabilityType.APP, appPath);
				capabilitiesForAppium.setCapability("name", testName);
				capabilitiesForAppium.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
				//capabilitiesForAppium.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
				capabilitiesForAppium.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
				capabilitiesForAppium.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				capabilitiesForAppium.setCapability(MobileCapabilityType.APP_ACTIVITY, appActivity);
				
				capabilitiesForAppium.setCapability("udid", udid);
				capabilitiesForAppium.setCapability("unicodekeyboard", true);
				capabilitiesForAppium.setCapability("resetkeyboard", true);
				
				appiumDriver = new AndroidDriver(new URL(appiumUrl),capabilitiesForAppium);
				//AndroidDriver AndroidDriver = new AndroidDriver(new URL(appiumUrl),capabilitiesForAppium);
				appiumDriver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
				ad.test(appiumDriver);


				reporter = CReporterAppium.getCReporter(deviceName, platformName,platformVersion, false);
								
		}


			if (platformName.equalsIgnoreCase("ios") && !app.equalsIgnoreCase("NA")) {
				//capabilitiesForAppium.setCapability(MobileCapabilityType.ROTATABLE,rotatable.equalsIgnoreCase("true")== true ? true : false);
				//capabilitiesForAppium.setCapability(MobileCapabilityType.BROWSER_NAME, browsername);	
				capabilitiesForAppium.setCapability(MobileCapabilityType.APP_PACKAGE, appPackage);
				//capabilitiesForAppium.setCapability(MobileCapabilityType.APP_ACTIVITY, "");
				capabilitiesForAppium.setCapability("name", testName);
				capabilitiesForAppium.setCapability(MobileCapabilityType.APP, appPath);
				capabilitiesForAppium.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
				capabilitiesForAppium.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
				capabilitiesForAppium.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				capabilitiesForAppium.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
				capabilitiesForAppium.setCapability("unicodekeyboard", true);
				capabilitiesForAppium.setCapability("resetkeyboard", true);
				capabilitiesForAppium.setCapability("udid", udid);
				appiumDriver = new IOSDriver(new URL(appiumUrl),capabilitiesForAppium);
				appiumDriver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
				reporter = CReporterAppium.getCReporter(deviceName, platformName,platformVersion, false);
				ad.test(appiumDriver);
		}
	}
}
	@Parameters({"browserName","platformName"})
	@AfterTest(alwaysRun = true)
	public void afterTest(ITestContext ctx, String browserName,String platformName) throws Exception {
		this.browser=browserName;
		if(browser.equalsIgnoreCase("Chrome") && platformName.equalsIgnoreCase("Android"))
			driver.quit();
		/*if(appiumDriver!=null && !browserName.equalsIgnoreCase("NA"))
		
			appiumDriver.close();*/
	}
	
	// @Parameters({"browser"})
	@BeforeClass(alwaysRun = true)
	// @BeforeTest
	@Parameters({"automationName", "browserName", "browserVersion", "environment",
		"platformName","app","appPackage","platformVersion","appiumUrl","deviceName","seleniumgridurl"})
	public void beforeClass( String automationName, String browserName,
						   String browserVersion, String environment, String platformName,String app,String appPackage,String platformVersion,String appiumUrl,String deviceName,String seleniumgridurl, ITestContext iTestContext)
			throws IOException, InterruptedException {
		
	/*	switch (this.getClass().getName()) {
		case "showroom":
			APP_BASE_URL = ConfigFileReadWrite.read(
					ReporterConstants.configReporterFile, "cesBaseUrl");
			break;
		case "twx":
			APP_BASE_URL = ConfigFileReadWrite.read(
					ReporterConstants.configReporterFile, "baseUrl");
			break;
		case ""
		default:
			break;
		}*/
		/*SUMMARY_REPORTER_BASEURL=APP_BASE_URL;*/
		APP_BASE_URL = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "emBaseUrl");
		SUMMARY_REPORTER_BASEURL = APP_BASE_URL;
		String testName = iTestContext.getName();
		String PacakgeName = this.getClass().getCanonicalName().toLowerCase();
		if(PacakgeName.contains("mobile")){
			APP_BASE_URL="Mobile";
			LOCATION_CLIENT_LOGO = ReporterConstants.LOCATION_MOBILE_LOGO;
		}
		SUMMARY_REPORTER_BASEURL=APP_BASE_URL;
		
		/*
		 * PropertyConfigurator.configure(System.getProperty("user.dir")+
		 * "\\Log.properties");
		 * LOG.info(System.getProperty("user.dir")+"\\Log.properties")
		 * ;
		 * 
		 * 
		 * 
		 */
		/* get configuration */
		// String webbrowser = System.getenv("Browsers");
		// this.browser = (String)ctx.getAttribute("browser");
		LOG.info("---------------------");
		LOG.info("-----Before Class----");
		LOG.info("---------------------");
		LOG.info("Execution Start Time :: " + startTime);
		LOG.info("browser name :: " + browser + " Browser version :: "
				+ browserVersion + " platform ::" + platformName);

		this.browser = browserName;
		this.version = browserVersion;
		this.platform = platformName;
		this.environment = environment;
		Environment = environment;
		this.seleniumgridurl=seleniumgridurl;
		this.localBaseUrl = ReporterConstants.APP_BASE_URL;
		this.userName = ReporterConstants.SAUCELAB_USERNAME;
		this.accessKey = ReporterConstants.SAUCELAB_ACCESSKEY;
		this.executedFrom = System.getenv("COMPUTERNAME");
		this.cloudImplicitWait = ReporterConstants.CLOUD_IMPLICIT_WAIT;
		this.cloudPageLoadTimeOut = ReporterConstants.CLOUD_PAGELOAD_TIMEOUT;
		this.updateJira = "";
		
		/**/

		LOG.info(environment);
		if (environment.equalsIgnoreCase("local")) {
			if(appiumUrl.equalsIgnoreCase("NA")){
			LOG.info("Selenium Grid URL"+seleniumgridurl);
			this.setWebDriverForLocal(browser,seleniumgridurl);}
		}
	
		/*reporter = CReporter.getCReporter(browser, platformName, environment,
				true);
		driver = new EventFiringWebDriver(this.WebDriver);
		MyListener myListener = new MyListener();
		driver.register(myListener);
		driver.get(SUMMARY_REPORTER_BASEURL);
		// Driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		reporter.calculateSuiteStartTime();
		LOG.info("---------------------");
		LOG.info("---End Before Class--");
		LOG.info("---------------------");*/
		//reporter = CReporter.getCReporter(browser, platformName, environment, true);
		APP_BASE_URL = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "emBaseUrl");
        SUMMARY_REPORTER_BASEURL = APP_BASE_URL;
		if (app.equalsIgnoreCase("NA")) {
			driver = new EventFiringWebDriver(WebDriver);
			MyListener myListener = new MyListener();
			driver.register(myListener);
			driver.get(SUMMARY_REPORTER_BASEURL);
			// Driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			if (!browser.equalsIgnoreCase("Chrome")
					&& !platformName.equalsIgnoreCase("Android"))
				driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//reporter.calculateSuiteStartTime();
			LOG.info("---------------------");
			LOG.info("---End Before Class--");
			LOG.info("---------------------");
			reporter = CReporterAppium.getCReporter(browser, platformName, environment, true);
		}
		else{
		reporter = CReporterAppium.getCReporter(deviceName, platformName,platformVersion, false);
		}
		if(this.appiumDriver==null){
			this.appiumDriver=ad.test(appiumDriver);
		}

		reporter.calculateSuiteStartTime();
		LOG.info("*****************+END calculateSuiteStartTime");
		LOG.info("---------------------");
		LOG.info("---End Before Class--");
		LOG.info("---------------------");
		
		// set test for ExtentReports
		ExtentReportThread.startTest(testName);
	}

	@Parameters({"browserName"})
	@AfterClass(alwaysRun = true)
	// public void close(String browser) throws Exception{
	// @AfterTest
	public void afterTest(String browserName) throws Throwable {
		if (browser.equalsIgnoreCase("firefox")) {

			driver.quit();
			LOG.info("Driver quit ::" + browser);
			/*
			 * Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
			 * Runtime.getRuntime().exec(
			 * "taskkill /F /IM plugin-container.exe");
			 * Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
			 */
		} else if (browser.equalsIgnoreCase("chrome")) {
			LOG.info("After class executing...");
			//this.WebDriver.navigate().back();
			driver.quit();
			LOG.info("Driver quit ::" + browser);
			/*
			 * Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
			 * Runtime.getRuntime().exec(
			 * "taskkill /F /IM plugin-container.exe");
			 * Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
			 */
		} else if (browser.equalsIgnoreCase("ie")) {
			driver.quit();
			LOG.info("Driver quit ::" + browser);
			/*
			 * Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
			 * Runtime.getRuntime().exec(
			 * "taskkill /F /IM plugin-container.exe");
			 * Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
			 */
		} else if (browser.equalsIgnoreCase("edge")) {
			driver.quit();
			LOG.info("Driver quit ::" + browser);
			/*
			 * Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
			 * Runtime.getRuntime().exec(
			 * "taskkill /F /IM plugin-container.exe");
			 * Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
			 */
		} else {
			try {
				driver.quit();
				LOG.info("Driver quit ::" + browser);
			} catch (Exception e) {
			}
		}
		// Driver.close();
		reporter.calculateSuiteExecutionTime();
		//reporter.createHtmlSummaryReport(ReporterConstants.APP_BASE_URL, true);
		reporter.createHtmlSummaryReport(SUMMARY_REPORTER_BASEURL, true);
		reporter.closeSummaryReport();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		int k=0;
		// get browser info
		// reporter = CReporter.getCReporter(deviceName, platformName,
		// platformVersion, true);
		//list object is the value of testcasedescription
		HashMap<String,Integer> tcDescriptionMapObject  = new HashMap<String,Integer>();
		for(int j=0;j<listofTestCaseDescription.size();j++){
			if(tcDescriptionMapObject.get(listofTestCaseDescription.get(j).replace(" ",""))==null)
			  tcDescriptionMapObject.put(listofTestCaseDescription.get(j).replace(" ",""),j);
		  }
 		 if(listofTestCaseDescription.size()==0){
			 k=0;
		 }else{
			  k= tcDescriptionMapObject.get(listofTestCaseDescription.get(i).replace(" ",""));
			  i=i+1;
		 }
		 		//LOG.info("listofTestCaseDescriptionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"+listofTestCaseDescription.get(i));
				reporter.initTestCase(
						this.getClass()
								.getName()
								.substring(0,
										this.getClass().getName().lastIndexOf(".")),
						method.getName()+"-"+k,null, true); 
				//i=i+1;
	}
	
	@Parameters({"browserName","appiumUrl"})
	@AfterMethod
	public void afterMethod() throws Throwable {
		LOG.info("After method executing...");
		reporter.calculateTestCaseExecutionTime();
		reporter.closeDetailedReport();
		reporter.updateTestCaseStatus();
		if(i==0){
		this.reporter.initTestCaseDescriptionUpdated(gTestCaseDesc/*listofTestCaseDescription.get(i)*/);
		}else{
			this.reporter.initTestCaseDescriptionUpdated(/*gTestCaseDesc*/listofTestCaseDescription.get(i-1));
		}
		
	}

	public void setWebDriverForLocal( String browser,String seleniumgridurl) throws IOException,
			InterruptedException {
		DesiredCapabilities capab=null;
		switch (browser) {
			case "firefox":
				final FirefoxProfile firefoxProfile = new FirefoxProfile();
				firefoxProfile.setPreference("browser.download.dir", System.getProperty("user.dir") + "\\Downloads");
				firefoxProfile.setPreference("browser.download.folderList", 2);
				firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
						"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"
								+ "application/pdf;"
								+ "application/vnd.openxmlformats-officedocument.wordprocessingml.document;"
								+ "text/plain;"
								+ "text/csv");
				firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
				firefoxProfile.setPreference("pdfjs.disabled", true);

				firefoxProfile.setPreference("xpinstall.signatures.required", false);
				capab=DesiredCapabilities.firefox();
				capab.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
				if(seleniumgridurl.equalsIgnoreCase("local")){
				this.WebDriver = new FirefoxDriver(firefoxProfile);
				}
				LOG.info("Driver launch ::" + browser);
				break;
				case "ie":
				capab = DesiredCapabilities.internetExplorer();
				File file = new File("Drivers\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver",file.getAbsolutePath());
				//To disable popup blocker.
				capab.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
				//to enable protected mode settings
				capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				capab.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				//to get window focus
				capab.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,true);
				//  to set zoom level is set to 100% so that the native mouse events can be set to the correct coordinates.
				capab.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
				capab.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
				capab.setCapability(InternetExplorerDriver.NATIVE_EVENTS,false);
				Process p = Runtime
						.getRuntime()
						.exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
				p.waitFor();
				if(seleniumgridurl.equalsIgnoreCase("local")){
				this.WebDriver = new InternetExplorerDriver(capab);
				}
				break;
			case "chrome":
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\Downloads");

				capab = DesiredCapabilities.chrome();
				System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_32Bit.exe");
				ChromeOptions options = new ChromeOptions();

				options.setExperimentalOption("prefs", chromePrefs);
				capab.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				options.addArguments("test-type");
				options.addArguments("chrome.switches", "--disable-extensions");
				capab.setCapability(ChromeOptions.CAPABILITY, options);
				if(seleniumgridurl.equalsIgnoreCase("local")){
				this.WebDriver = new ChromeDriver(capab);
				}
				LOG.info("Driver launch ::" + browser);
				break;
			case "edge":
				LOG.info("In the case Edge");
				System.setProperty("webdriver.edge.driver",
						"Drivers\\MicrosoftWebDriver.exe");
				capab = DesiredCapabilities.edge();
				if(seleniumgridurl.equalsIgnoreCase("local")){
				this.WebDriver = new EdgeDriver(capab);
				}
				LOG.info("Driver launch ::" + browser);
				break;

			case "Safari":
				for (int i = 1; i <= 10; i++) {
					try {
						if(seleniumgridurl.equalsIgnoreCase("local")){
						this.WebDriver = new SafariDriver();
						}
						break;
					} catch (Exception e1) {
						// Runtime.getRuntime().exec("taskkill /F /IM Safari.exe");
						// Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
						// Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
						continue;
					}
				}
		}
		//ReporterConstants.SELENIUM_GRID_HUB_URL
		System.out.println("");
		if(!seleniumgridurl.equalsIgnoreCase("local")){
		this.WebDriver=new RemoteWebDriver(new URL(seleniumgridurl), capab);
		}
	}

	
	public String getBrowser() {
		return this.browser;
	}
	
	@Parameters({"executionType", "suiteExecuted"})
	@AfterSuite(alwaysRun = true)
	public void afterSuite(ITestContext ctx, String type, String suite)
			throws Throwable {
		startTime = System.currentTimeMillis();
		ctx.setAttribute("browser", System.getenv("Browsers"));
		LOG.info("--------------------------------------------------------------------------");
		LOG.info("------------------Suite :: " + suite
				+ "------------------------------");
		LOG.info("AfterSuite Start Time :: " + startTime);
		LOG.info("---------------------------End After Suite Details-----------------------------------");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy hh mm ss SSS");
		String formattedDate = sdf.format(date);
		suiteStartTime = formattedDate.replace(":", "_").replace(" ", "_");
		System.out.println("After Suite end time ==============>" + suiteStartTime);
		LOG.info("Before killing "+browser+" browser");
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver_32Bit.exe");
		Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer64bit.exe");
		Runtime.getRuntime().exec("taskkill /F /IM MicrosoftWebDriver.exe");
		LOG.info("After killing "+browser+" browser");
	}

	/**
	 * keyBoardOperations
	 *
	 * @param locator     of (By)
	 * @param testData    of (Keys)
	 * @param locatorName of (String)
	 * @return boolean
	 */
	public boolean keyBoardOperations(By locator, Keys testData, String locatorName) throws Throwable {
		boolean status;
		try {
			LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			LOG.info("Method : Type  ::  Locator : " + locatorName + " :: Data :" + testData);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			LOG.info("Waiting for element :");
			//wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			LOG.info("Locator is Visible :: " + locator);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			appiumDriver.findElement(locator).sendKeys(testData);
			LOG.info("Typed the Locator data :: " + testData);
			LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

			reporter.SuccessReport("Enter text in :: " + locatorName, msgTypeSuccess + testData);
			status = true;
		} catch (Exception e) {
			status = false;
			LOG.info(e.getMessage());
			reporter.failureReport("Enter text in :: " + locatorName, msgTypeFailure + testData, driver);
		}
		return status;
	}
}
