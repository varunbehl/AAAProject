package com.aaa.accelerators;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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
import org.openqa.selenium.remote.Augmenter;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aaa.commonutilities.CustomTestListenerCT;
import com.aaa.commonutilities.ExtentReportThread;
import com.aaa.googledrive.ReportStatus;
import com.aaa.report.BrowserContext;
import com.aaa.report.CReporterWeb;
import com.aaa.report.ConfigFileReadWrite;
import com.aaa.report.Mobiledriver;
import com.aaa.report.ReporterConstants;
import com.aaa.report.TestResult;
import com.aaa.support.ExcelReader;
import com.aaa.support.MyListener;
import com.aaa.utilities.DataBean;
import com.aaa.utilities.WriteIntoExcel;
import com.sun.jna.platform.win32.OaIdl.SYSKIND;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;


@Listeners(CustomTestListenerCT.class)
public class TestEngineWeb {
    public static Logger LOG = Logger.getLogger(TestEngineWeb.class);
	public static AppiumDriver appiumDriver = null;
    public WebDriver WebDriver = null;
    public static EventFiringWebDriver driver = null;
    public static CReporterWeb reporter = null;
    public ITestContext ctx = null;
    public static String gTestCaseDesc = null;
	/*public static CRHomeLib homeLib1= null;*/

    /* cloud platform */
    public String browser = null;
    public String version = null;
    public String platform = null;
    public String seleniumgridurl = null;
    public String environment = null;
    public static String Environment = null;
    public String localBaseUrl = null;
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
    public String APP_BASE_URL = null;
    public String SUMMARY_REPORTER_BASEURL = null;
    public String CALL_RECEIVING_URL = null;
    public String DISPATCH_URL = null;
    public String RSO_WEB_URL = null;
    public String RSO_WEB_URL_MESTAG = null;
    public static String LOCATION_CLIENT_LOGO = null;

    public static long startTime;
    public static String fileName = System.getProperty("user.dir") + "/TestData/TestData.xls";
    public static ExcelReader xlsrdr = new ExcelReader(fileName);
    public static DataBean dataBean = new DataBean();
    public static WriteIntoExcel excelEntry = new WriteIntoExcel();
    public HashMap<String, String> mapObj = new HashMap<>();
    public static String platformNameMobile=null; 
    // Below parameters are for update the test data into Excel at run time
    public static String globalsheetName = null;
    public static int gTestCaseStartRowNum = 0;

    public static String gTestData = System.getProperty("user.dir") + File.separator + "TestData" + File.separator
            + "TestData.xlsx";
    public static ArrayList<String> listofTestCaseDescription = new ArrayList<>();
    public static int i = 0;

    public static Hashtable<String, String> Global_DataTable = null;
    public static boolean blnResultStatus=false;

    //For Mobile Web Intigration
	public static DesiredCapabilities capabilitiesForAppium = new DesiredCapabilities();
	public static Mobiledriver ad=new Mobiledriver();
	private final String msgTypeSuccess = "Successfully Entered value ";
	private final String msgTypeFailure = "Unable To Type On ";
    
    @Parameters({ "executionType", "suiteExecuted"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext ctx, String type, String suite) throws Throwable {
        startTime = System.currentTimeMillis();
        ctx.setAttribute("browser", System.getenv("Browsers"));
        LOG.info(System.getenv("Browsers"));
        LOG.info("--------------------------------------------------------------------------");
        LOG.info("------------------Suite :: " + suite + "------------------------------");
        LOG.info("Execution Start Time :: " + startTime);
        LOG.info("Test Data Path :: " + fileName);
        LOG.info("Executing on :: " + System.getenv("Browsers"));
        LOG.info("---------------------------End Suite Details-----------------------------------");
        executionType = type;
        suiteExecution = suite;
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/Log.properties");

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy hh mm ss SSS");
        String formattedDate = sdf.format(date);
        suiteStartTime = formattedDate.replace(":", "_").replace(" ", "_");
        LOG.info("Suite time ==============>" + suiteStartTime);
        ReportControl.fnReportDefault();
        
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({ "automationName", "browser", "browserVersion", "environment", "platformName","platformNameMobile","app","platformVersion","appPackage","autoStart", "seleniumgridurl","deviceName","appActivity","udid","appiumUrl" })
    public void beforeClass(String automationName, String browser, String browserVersion, String environment,
                            String platformName,String platformNameMobile,String app,String platformVersion,String appPackage, String autoStart,String seleniumgridurl,String deviceName,String appActivity,String udid,String appiumUrl,ITestContext iTestContext)
            throws IOException, InterruptedException {
        // set and get system property at before class
        String testName = iTestContext.getName();

        APP_BASE_URL = ConfigFileReadWrite.read(ReporterConstants.configReporterFile, "emBaseUrl");
        SUMMARY_REPORTER_BASEURL = APP_BASE_URL;

        LOG.info("---------------------");
        LOG.info("-----Before Class----");
        LOG.info("---------------------");
        LOG.info("Execution Start Time :: " + startTime);
        LOG.info(
                "browser name :: " + browser + " Browser version :: " + browserVersion + " platform ::" + platformName);

        this.browser = browser;
        this.version = browserVersion;
        this.platform = platformName;
        this.environment = environment;
        Environment = environment;
        this.platformNameMobile=platformNameMobile;
        this.seleniumgridurl = seleniumgridurl;
        this.localBaseUrl = ReporterConstants.APP_BASE_URL;
        this.userName = ReporterConstants.SAUCELAB_USERNAME;
        this.accessKey = ReporterConstants.SAUCELAB_ACCESSKEY;
        this.executedFrom = System.getenv("COMPUTERNAME");
        this.cloudImplicitWait = ReporterConstants.CLOUD_IMPLICIT_WAIT;
        this.cloudPageLoadTimeOut = ReporterConstants.CLOUD_PAGELOAD_TIMEOUT;
        this.updateJira = "";
        if(ReportControl.strAutoStart==null)
        {
        	//ReportControl.strAutoStart=autoStart;
        	ReportControl.fnIntilizeControl(autoStart);
        }
        ReportControl.intRowCount=1;
        LOCATION_CLIENT_LOGO = ReporterConstants.CES_LOCATION_CLIENT_LOGO;
        LOG.info(environment);
        if(ReportControl.strAutoStart.equals("web"))
        {
		        if (environment.equalsIgnoreCase("local")) {
		            LOG.info("Selenium Grid URL" + seleniumgridurl);
		            this.setWebDriverForLocal(browser, seleniumgridurl);
		        }
		        else if (environment.equalsIgnoreCase("cloudSauceLabs")) {
		            this.setRemoteWebDriverForCloudSauceLabs(testName);
		        }
		        else if (environment.equalsIgnoreCase("cloudSauceLabsJenkins")) {
		            this.updateConfigurationForCloudSauceLabsJenkins();
					/* set remoteWebDriver for cloudsaucelabs */
		            this.setRemoteWebDriverForCloudSauceLabs(testName);
		        }
		        else if (environment.equalsIgnoreCase("cloudBrowserStackJenkins")) {
					/* TBD: Not Implemented For Running Using Jenkins */
		            this.updateConfigurationForCloudBrowserStackJenkins();
		        }
		        if(ReportControl.blnJoin==false)
		        {
		        	
		           	if(reporter==null)
		        	{
		        		reporter = CReporterWeb.getCReporter(browser, platformName, environment, true);
		        	}
		        	else
		        	{
		        		BrowserContext browserContext = BrowserContext.getBrowserContext(browser, version, platform);
	        			CReporterWeb.mapBrowserContextReporter.put(browserContext, reporter);
		        	}
		        }
		        else
		        {
		        	if(reporter==null)
		        	{
		        		reporter = CReporterWeb.getCReporter(browser, platformName, environment, true);
		        	}
		        	else
		        	{
		        		if(reporter!=null)
		        		{
		        		
		        			BrowserContext browserContext = BrowserContext.getBrowserContext(browser, version, platform);
		        			CReporterWeb.mapBrowserContextReporter.put(browserContext, reporter);		        			
		        		}
		        	}
		        }
		        driver = new EventFiringWebDriver(this.WebDriver);
		        if (!environment.equalsIgnoreCase("cloudSaucelabs")) {
		            MyListener myListener = new MyListener();
		            driver.register(myListener);
		        }
		        driver.get(SUMMARY_REPORTER_BASEURL);
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		        reporter.calculateSuiteStartTime();
		        ReportControl.strCurrentExecution="web";
		        
		        
        }
        else if(ReportControl.strAutoStart.equals("mobile"))
        {
        	final StringBuilder appPath=new StringBuilder().append(System.getProperty("user.dir")+ "/TestApps/"+app);

    		if (environment.equalsIgnoreCase("local")) {
    		    			
    			if (platformNameMobile.equalsIgnoreCase("android") && !app.equalsIgnoreCase("NA")) {
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
    				if(ReportControl.blnJoin==false)
    			    {
    					if(reporter==null) 
    					{
    						reporter = CReporterWeb.getCReporter(deviceName, platformName,platformVersion, true);
    					}
    					else
    		        	{
    		        		BrowserContext browserContext = BrowserContext.getBrowserContext(browser, version, platform);
    		        		CReporterWeb.mapBrowserContextReporter.put(browserContext, reporter);
    		        	}
    			    }
    				else
    				{
    					if(reporter==null)
    		        	{
    		        		reporter = CReporterWeb.getCReporter(deviceName, platformName, environment, true);
    		        	}
    		        	else
    		        	{
    		        		if(reporter!=null)
    		        		{
    		        			BrowserContext browserContext = BrowserContext.getBrowserContext(browser, version, platform);
    		        			CReporterWeb.mapBrowserContextReporter.put(browserContext, reporter);
    		        		}
    		        		
    		        	}
    				}
    				reporter.calculateSuiteStartTime();
    		}
    		else if (platformNameMobile.equalsIgnoreCase("ios") && !app.equalsIgnoreCase("NA")) {
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
    				ad.test(appiumDriver);
    				if(ReportControl.blnJoin==false)
    			    {
    					if(reporter==null) 
    					{
    						reporter = CReporterWeb.getCReporter(deviceName, platformName,platformVersion, true);
    					}
    					else
    		        	{
    		        		BrowserContext browserContext = BrowserContext.getBrowserContext(browser, version, platform);
    		        		CReporterWeb.mapBrowserContextReporter.put(browserContext, reporter);
    		        	}
    			    }
    				else
    				{
    					if(reporter==null)
    		        	{
    		        		reporter = CReporterWeb.getCReporter(deviceName, platformName, environment, true);
    		        	}
    		        	else
    		        	{
    		        		if(reporter!=null)
    		        		{
    		        			BrowserContext browserContext = BrowserContext.getBrowserContext(browser, version, platform);
    		        			CReporterWeb.mapBrowserContextReporter.put(browserContext, reporter);
    		        		}
    		        		
    		        	}
    				}
    				reporter.calculateSuiteStartTime();    			    			
    		}
    			ReportControl.strCurrentExecution="mobile";
    	}
        }
        /*****************/
        LOG.info("---------------------");
        LOG.info("---End Before Class--");
        LOG.info("---------------------");

        // set test for ExtentReports
        ExtentReportThread.startTest(testName);
    }

    @Parameters({ "browser" })
    @AfterClass(alwaysRun = true)
    public void afterClass(String browser) throws Throwable {
    	if(ReportControl.strCurrentExecution.equals("mobile"))
    	{
    		//appiumDriver.close();
    		appiumDriver.closeApp();
    		appiumDriver.quit();    		
    	}
    	else if(ReportControl.strCurrentExecution.equals("web"))
    	{
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
	
	            // this.WebDriver.navigate().back();
	            //driver.close();
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
	                LOG.warn("Driver exception ::" + e.getMessage());
	            }
	        }
    	}
      /*  if(ReportControl.blnSplit==false)
        {
        reporter.calculateSuiteExecutionTime();
        reporter.createHtmlSummaryReport(SUMMARY_REPORTER_BASEURL, true);
        reporter.closeSummaryReport();
        }*/
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        int k;
        // get browser info
        // reporter = CReporter.getCReporter(deviceName, platformName,
        // platformVersion, true);
        // list object is the value of testcasedescription
        HashMap<String, Integer> tcDescriptionMapObject = new HashMap<>();
        for (int j = 0; j < listofTestCaseDescription.size(); j++) {
            if (tcDescriptionMapObject.get(listofTestCaseDescription.get(j).replace(" ", "")) == null)
                tcDescriptionMapObject.put(listofTestCaseDescription.get(j).replace(" ", ""), j);
        }
        if (listofTestCaseDescription.size() == 0) {
            k = 0;
        } else {
            k = tcDescriptionMapObject.get(listofTestCaseDescription.get(i).replace(" ", ""));
            i = i + 1;
        }
        if(ReportControl.blnJoin==false)
        {
        reporter.initTestCase(this.getClass().getName().substring(0, this.getClass().getName().lastIndexOf(".")),
                method.getName() + "-" + k, null, true);
        }
        ReportStatus.strMethodName=method.getName();
        ReportStatus.blnStatus=true;
        // i=i+1;
    }
    
    @AfterMethod
    public void afterMethod() throws Throwable {
        LOG.info("After method executing...");
        if(ReportControl.blnJoin==false)
        {
        	reporter.calculateTestCaseExecutionTime();
        	reporter.closeDetailedReport();
        	reporter.updateTestCaseStatus();
        }
        if (i == 0) {
            this.reporter.initTestCaseDescriptionUpdated(
                    gTestCaseDesc /*listofTestCaseDescription.get(i)*/ );
        } else {
            this.reporter.initTestCaseDescriptionUpdated(/* gTestCaseDesc */listofTestCaseDescription.get(i - 1));
        }
        LOG.info("The value of the path is " + gTestData);
        LOG.info("The value of test case description" + gTestCaseDesc);

        // Global_DataTable.clear();
        dataBean.cleanMapObj();
        // excelEntry.writeXLSXFile();
    }

    public void setWebDriverForLocal(String browser, String seleniumgridurl) throws IOException, InterruptedException {
        DesiredCapabilities capab = null;

        switch (browser) {
            case "firefox":
                capab = DesiredCapabilities.firefox();
                System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
                final FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("browser.download.dir", System.getProperty("user.dir") + "\\Downloads");
                firefoxProfile.setPreference("browser.download.folderList", 2);
                firefoxProfile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");
                firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;" + "application/pdf;"
                                + "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" + "text/plain;"
                                + "text/csv;" + "application/octet-stream");
                firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
                firefoxProfile.setPreference("pdfjs.disabled", true);

                firefoxProfile.setPreference("xpinstall.signatures.required", false);

                capab.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

                if (seleniumgridurl.equalsIgnoreCase("local")) {
                    this.WebDriver = new FirefoxDriver();
                }
                LOG.info("Driver launch ::" + browser);
                break;

            case "ie":
                capab = DesiredCapabilities.internetExplorer();
                File file = new File("Drivers\\IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                // To disable popup blocker.
                capab.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
                // to enable protected mode settings
                capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capab.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

                // to get window focus
                capab.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
                // to set zoom level is set to 100% so that the native mouse events
                // can be set to the correct coordinates.
                capab.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                capab.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
                capab.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
                Process p = Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
                p.waitFor();
                if (seleniumgridurl.equalsIgnoreCase("local")) {
                    this.WebDriver = new InternetExplorerDriver(capab);
                }
                break;
            case "chrome":
                HashMap<String, Object> chromePrefs = new HashMap<>();
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
                if (seleniumgridurl.equalsIgnoreCase("local")) {
                    this.WebDriver = new ChromeDriver(capab);
                }
                LOG.info("Driver launch ::" + browser);
                break;
            case "edge":
                LOG.info("In the case Edge");
                System.setProperty("webdriver.edge.driver", "Drivers\\MicrosoftWebDriver.exe");
                capab = DesiredCapabilities.edge();
                if (seleniumgridurl.equalsIgnoreCase("local")) {
                    this.WebDriver = new EdgeDriver(capab);
                }
                LOG.info("Driver launch ::" + browser);
                break;

            case "Safari":
                for (int i = 1; i <= 10; i++) {
                    try {
                        if (seleniumgridurl.equalsIgnoreCase("local")) {
                            this.WebDriver = new SafariDriver();
                        }
                        break;
                    } catch (Exception e1) {
                    }
                }
        }
        // ReporterConstants.SELENIUM_GRID_HUB_URL
        LOG.info("");
        if (!seleniumgridurl.equalsIgnoreCase("local")) {
            this.WebDriver = new Augmenter().augment(new RemoteWebDriver(new URL(seleniumgridurl), capab));
        }
    }

    private void setRemoteWebDriverForCloudSauceLabs(String testName) throws IOException, InterruptedException {
        String testBuild = System.getProperty("automation.name");
        String systemUserName = System.getProperty("saucelabs.user.name");
        String systemAccessKey = System.getProperty("saucelabs.access.key");
        String userName = systemUserName == null ? "test" : systemUserName;
        String accessKey = systemAccessKey == null ? "test" : systemAccessKey;
        String url = "https://" + userName + ":" + accessKey + "@ondemand.saucelabs.com:443/wd/hub";
        DesiredCapabilities desiredCapabilities;
        switch (this.browser.toLowerCase()) {
            case "safari":
                desiredCapabilities = DesiredCapabilities.safari();
                break;
            case "edge":
                desiredCapabilities = DesiredCapabilities.edge();
                break;
            case "ie":
                desiredCapabilities = DesiredCapabilities.internetExplorer();
                break;
            case "firefox":
                desiredCapabilities = DesiredCapabilities.firefox();
                break;
            case "chrome":
                desiredCapabilities = DesiredCapabilities.chrome();
                break;
            default:
                desiredCapabilities = DesiredCapabilities.chrome();
                break;

        }
        desiredCapabilities.setCapability(CapabilityType.VERSION, this.version);
        desiredCapabilities.setCapability(CapabilityType.PLATFORM, this.platform);
        desiredCapabilities.setCapability("build", testBuild);
        desiredCapabilities.setCapability("name", testName);
        desiredCapabilities.setCapability("requireWindowFocus", true);
        desiredCapabilities.setCapability("recordVideo", "true");
        desiredCapabilities.setCapability("recordScreenshots", "false");
        desiredCapabilities.setCapability("maxDuration", 10800);
        this.WebDriver = new RemoteWebDriver(new URL(url), desiredCapabilities);
    }

    private void updateConfigurationForCloudSauceLabsJenkins() {
        this.browser = System.getenv("Browsers");
        this.version = System.getenv("SELENIUM_VERSION");
        this.platform = System.getenv("SELENIUM_PLATFORM");
        this.userName = System.getenv("SAUCE_USER_NAME");
        this.accessKey = System.getenv("SAUCE_API_KEY");
        this.buildNumber = System.getenv("BUILD_NUMBER");
        this.jobName = System.getenv("JOB_NAME");
		/* For Debug Purpose */
        LOG.info("Debug: browser = " + this.browser);
        LOG.info("Debug: version = " + this.version);
        LOG.info("Debug: platform = " + this.platform);
        LOG.info("Debug: userName = " + this.userName);
        LOG.info("Debug: accessKey = " + this.accessKey);
        LOG.info("Debug: executedFrom = " + this.executedFrom);
        LOG.info("Debug: BUILD_NUMBER = " + this.buildNumber);
        LOG.info("Debug: jobName = " + this.jobName);
    }

    /* TBD: Not Implemented For Running Using Jenkins */
    private void updateConfigurationForCloudBrowserStackJenkins() {
    }

    public String getBrowser() {
        return this.browser;
    }

    @Parameters({ "executionType", "suiteExecuted" })
    @AfterSuite(alwaysRun = true)
    public void afterSuite(ITestContext ctx, String type, String suite) throws Throwable {
        startTime = System.currentTimeMillis();
        ctx.setAttribute("browser", System.getenv("Browsers"));
        LOG.info("--------------------------------------------------------------------------");
        LOG.info("------------------Suite :: " + suite + "------------------------------");
        LOG.info("AfterSuite Start Time :: " + startTime);
        LOG.info("---------------------------End After Suite Details-----------------------------------");
        reporter.calculateSuiteExecutionTime();
        reporter.createHtmlSummaryReport(SUMMARY_REPORTER_BASEURL, true);
        reporter.closeSummaryReport();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy hh mm ss SSS");
        String formattedDate = sdf.format(date);
        suiteStartTime = formattedDate.replace(":", "_").replace(" ", "_");
        LOG.info("After Suite end time ==============>" + suiteStartTime);
        LOG.info("Before killing " + browser + " browser");
        /*Runtime.getRuntime().exec("taskkill /F /IM chromedriver_32Bit.exe");
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer64bit.exe");
        Runtime.getRuntime().exec("taskkill /F /IM MicrosoftWebDriver.exe");*/
        LOG.info("After killing " + browser + " browser");
        System.out.println(reporter.reportPath);
        System.out.println(System.getProperty("user.dir")); 
        String strLocation=fnGetRemteFolderLocation();
        if(strLocation.equals("NA")==false)
        {
        	System.out.println("Result Folder is Updating to share path");
        	Date todaysDate = new Date();
        	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");
        	String strDateTime=formatter.format(todaysDate);
        	String formattedDate1 = formatter.format(todaysDate).replace(":", "_").replaceAll(" ", "");
        	String strFlderName=strLocation+"/"+formattedDate1;
        	File theDir = new File(strFlderName);
        	if(theDir.exists())
        	{
        		theDir.delete();
        	}
        	new File(strFlderName).mkdir();
        	System.out.println("Copy of Result Folder is Updating to share path " );
        	System.out.println(strFlderName);
            FileUtils.copyDirectory(new File(reporter.reportPath), theDir);
            System.out.println("Result Folder is Updated to Share Path" );
        }
      
        
    }
    
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
    
    public static String fnGetRemteFolderLocation()
	{
		String strLocation="NA";
		try {

            File f = new File("C:\\Jenkins\\RemoteFolderLcation.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
                System.out.println(readLine);
                strLocation=readLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

		return strLocation;
	}    
}
