package com.test.automation.UIAutomation.testBase;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.UIAutomation.config.ElementLoad;
import com.test.automation.UIAutomation.config.EmailConfiguration;
import com.test.automation.UIAutomation.config.PropertiesfilesLoad;
import com.test.automation.UIAutomation.customListener.Listener;
import com.test.automation.UIAutomation.errorScreenShot.ErrorScreenShot;
import com.test.automation.UIAutomation.excelReader.Excel_Reader;
import com.test.automation.UIAutomation.extendReport.ExtentReportDemo;
import com.test.automation.UIAutomation.uiActions.LoginPage;

import org.openqa.selenium.support.ui.Select;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

//import TestNgPkg.ExtentReportDemo;

public class TestBase {
	public static WebDriver driver = null;

	/*
	 * public static ExtentReports extent=ExtentReportDemo.ExtentDemo(); public
	 * static ExtentTest test;
	 */
	public static ElementLoad ElementLoaderObj;
	//public static excelReader reader;
	public static Excel_Reader excel;
	//public static String path;
	public static String OS = System.getProperty("os.name").toLowerCase();
	public static Properties Config = new Properties();
	//public static Properties OR = new Properties();
	public static Properties loginPropertyFile = new Properties();
	public static Properties hompagePropertyFile = new Properties();
	public static Properties CandidateDetailsPropertyFile = new Properties();
	public static Properties CandidateListPropertyFile = new Properties();
	public static Properties RequirementDetailsPropertyFile = new Properties();
	public static Properties NewRequirementsDetailsPropertyFile = new Properties();
	public static FileInputStream fConfig, fhomepage, floginpage, fCandidateDetails, fCandidateList,fRequirementDetailsFIS,fNewRequirementsDetails;//FOR
	public static Properties ORr;
	public static FileInputStream file;
	public static ArrayList<String> handles = new ArrayList<String>();

	public static JavascriptExecutor js = (JavascriptExecutor) driver;  
	public static String RootDirectory = System.getProperty("user.dir");

	public static String log4jConfPath = System.getProperty("user.dir")+ File.separator + "\\resources\\logs\\log4j.properties";
    //System.out.println("log4jConfigFile:"+log4jConfigFile);
	
	//public static String log4jConfPath = "log4j.properties";
	public static Logger log = Logger.getLogger(TestBase.class.getName());
	public static WebDriverWait wait;
	public static String driverPath = RootDirectory + "\\drivers\\";

	public static ExtentReports extent = ExtentReportDemo.ExtentDemo("AutomationReport");
	public static ExtentTest test;
	public static Listener lis = new Listener();
	public static EmailConfiguration config2 = new EmailConfiguration();
	public static LoginPage jsp;
	public static PropertiesfilesLoad pfload;
	public static ElementLoad elmentload = new ElementLoad();
	public static ErrorScreenShot errorscrenshot = new ErrorScreenShot();

	@BeforeSuite
	public static void setUp() {
		if (driver == null) {

			if (OS.contains("mac os x")) {
				try {
					fConfig = new FileInputStream(
							System.getProperty("user.dir") + "//resources//properties//Config.properties");
					Config.load(fConfig);
					// log.debug("Config File Loading");
					/*fOR = new FileInputStream(
							System.getProperty("user.dir") + "//resources//properties//OR.properties");
					OR.load(fOR);*/
					// log.debug("OR File Loading");
					fhomepage = new FileInputStream(
							System.getProperty("user.dir") + "//resources//properties//Requirements.properties");
					hompagePropertyFile.load(fhomepage);
					floginpage = new FileInputStream(
							System.getProperty("user.dir") + "//resources//properties//LoginPage.properties");
					loginPropertyFile.load(floginpage);
					fCandidateDetails = new FileInputStream(
							System.getProperty("user.dir") + "//resources//properties//CandidateDetails.properties");
					CandidateDetailsPropertyFile.load(fCandidateDetails);
					fCandidateList = new FileInputStream(
							System.getProperty("user.dir") + "//resources//properties//CandidateList.properties");
					CandidateListPropertyFile.load(fCandidateList);
					fRequirementDetailsFIS = new FileInputStream(
							System.getProperty("user.dir") + "//resources//properties//RequirementsDetails.properties");
					RequirementDetailsPropertyFile.load(fRequirementDetailsFIS);
					
					
					fNewRequirementsDetails = new FileInputStream(
							System.getProperty("user.dir") + "//resources/properties//NewRequirementsDetails.properties");
					NewRequirementsDetailsPropertyFile.load(fNewRequirementsDetails);
					
					// log.debug("login property File Loaded sucessfully");
				} catch (Exception e) {

					e.printStackTrace();
				}

			} else {

				try {

					fConfig = new FileInputStream(
							System.getProperty("user.dir") + "/resources/properties/Config.properties");
					Config.load(fConfig);
					log.debug("Config File Loaded sucessfully");
					/*fOR = new FileInputStream(System.getProperty("user.dir") + "/resources/properties/OR.properties");
					OR.load(fOR);*/
					log.debug("OR File Loaded sucessfully");
					fhomepage = new FileInputStream(
							System.getProperty("user.dir") + "/resources/properties/Requirements.properties");
					hompagePropertyFile.load(fhomepage);
					log.debug("homepage File Loaded sucessfully");
					floginpage = new FileInputStream(
							System.getProperty("user.dir") + "/resources/properties/LoginPage.properties");
					loginPropertyFile.load(floginpage);
					log.debug("login property File Loaded sucessfully");
					fCandidateDetails = new FileInputStream(
							System.getProperty("user.dir") + "/resources/properties/CandidateDetails.properties");
					CandidateDetailsPropertyFile.load(fCandidateDetails);
					fCandidateList = new FileInputStream(
							System.getProperty("user.dir") + "/resources/properties/CandidateList.properties");
					CandidateListPropertyFile.load(fCandidateList);
					
					fRequirementDetailsFIS = new FileInputStream(
							System.getProperty("user.dir") + "/resources/properties/RequirementsDetails.properties");
					RequirementDetailsPropertyFile.load(fRequirementDetailsFIS);
					
					
					fNewRequirementsDetails = new FileInputStream(
							System.getProperty("user.dir") + "/resources/properties/NewRequirementsDetails.properties");
					NewRequirementsDetailsPropertyFile.load(fNewRequirementsDetails);
					
				} catch (Exception e) {

					e.printStackTrace();
				}

			}

		}

	}

	@BeforeTest
	public void setUp1() {

		TestBase.initializeTestBaseSetup(Config.getProperty("browser"), Config.getProperty("testsiteurl"));
		log.info("open url succssfully");
		System.out.println(Config.getProperty("testsiteurl"));
		log.info(Config.getProperty("testsiteurl"));

	}

	private static WebDriver setDriver(String browserType, String appURL) {
		
		switch (browserType.toLowerCase()) {
		case "chrome":
			driver = initChromeDriver(appURL);
			log.info("chrome browser");
			// test=extent.startTest("Chrome browser");
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			log.info("firefox browser");
			// test=extent.startTest("firefox browser");
			break;
		case "ie":
			driver = initIEDriver(appURL);
			log.info("IE browser");
			// test=extent.startTest("html browser");
			break;
		default:
			log.info("browser :"+ browserType + " is invalid, browser of choice..");
			System.out.println("browser : " + browserType + " is invalid,  browser of choice..");
			//driver = initFirefoxDriver(appURL);
		}
		return driver;
	}

	private static WebDriver initChromeDriver(String appURL) {

		// System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		
		
		
		 driver = new ChromeDriver();
		/* EventFiringWebDriver driver = new EventFiringWebDriver(driver1);
		 WebEventListener eventListener= new WebEventListener();
		 driver.register(eventListener);*/
		
		// driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.navigate().to(appURL);
		 
		// test=extent.startTest("Redirected to URL");
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		// System.out.println("Launching firefox with new profile..");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		
		System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to(appURL);
		// test=extent.startTest("Redirected to URL");
		return driver;
	}

	private static WebDriver initIEDriver(String appURL) {
		System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
		 driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		driver.navigate().to(appURL);
		// test=extent.startTest("Redirected to URL");
		return driver;
	}

	// new HtmlUnitDriver()
	public static void initializeTestBaseSetup(String browserType, String appURL) {
		try {

			PropertyConfigurator.configure(log4jConfPath);
			setDriver(browserType, appURL);
			log.info("creating object of " + browserType + "and URL of: " + appURL);
		} catch (Exception e) {
			System.out.println("BrowserType Error....." + e.getStackTrace());
		}
	}

	public static void waitForVisitibilty(WebElement element) {
		wait = new WebDriverWait(driver, 60);
		//wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void click(WebElement element) {
		waitForVisitibilty(element);
		element.click();
	}

	public static void clear(WebElement element) {
		waitForVisitibilty(element);
		element.clear();
	}

	public static void sendKeys(WebElement element, String keyword) {
		waitForVisitibilty(element);
		element.clear();
		element.sendKeys(keyword);
	}

	public static boolean isPageLoaded(WebElement element) {

		waitForVisitibilty(element);
		return element.isDisplayed();

	}

	public static boolean isElementPresent(WebElement element) {

		waitForVisitibilty(element);
		log.info("element is present:" + element.toString());
		return element.isDisplayed();

	}

	public static String getText(WebElement element) {
		waitForVisitibilty(element);
		return element.getText();
	}

	public static WebElement linkText(WebElement element, String Keyword) {
		waitForVisitibilty(element);
		return element = driver.findElement(By.partialLinkText(Keyword));
	}

	public static String getAttributeVolume(WebElement element, String attribute) {
		waitForVisitibilty(element);
		return element.getAttribute(attribute);
	}

	public static ElementLoad ElementLoad() {

		try {
			ElementLoaderObj = new ElementLoad();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ElementLoaderObj;
	}

	public static String[][] getData(String excelname, String sheetName) {
		String[][] data = null;

		try {
			String excelpath = RootDirectory + "\\resources\\excel\\" + excelname;
			log.info("excel path:" + excelpath);
			//System.out.println("excel path:" + excelpath);
			excel = new Excel_Reader(excelpath);
			data = excel.getDataFromSheet(sheetName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

	public static String getCellData(String excelname, String sheetName, String colName, int rowNum) {
		String data = null;

		try {
			String excelpath = RootDirectory + "\\resources\\excel\\" + excelname;
			log.info("excel path:" + excelpath);
			//System.out.println("excel path:" + excelpath);
			excel = new Excel_Reader(excelpath);
			data = excel.getCellData( sheetName,  colName,  rowNum);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}
	
	public static void getWindowHandle() {
		try {
			
			for (String winHandle : driver.getWindowHandles()) {
				try {

					handles.add(winHandle);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getWindowTitle() {
		getWindowHandle();
		String Windowtitle = null;
		for (int i = 0; i < handles.size(); i++) {
			// log.info("handle for loop:" + handles.get(i).toString());
			driver.switchTo().window(handles.get(i).toString());
			Windowtitle = driver.getTitle();
			log.info("Window Title:" + Windowtitle);
		}
		return Windowtitle;
	}

	public static void Select(WebElement element, String visibletext) {
		waitForVisitibilty(element);
		Select oSelect = new Select(element);
		List<WebElement> oSize = oSelect.getOptions();
		int iListSize = oSize.size();
		for (int i = 0; i < iListSize; i++) {
			// Storing the value of the option
			String sValue = oSelect.getOptions().get(i).getText();
			// Printing the stored value
			System.out.println(sValue);
			// Putting a check on each option that if any of the option is equal
			// to 'Africa" then select it
			if (sValue.equals(visibletext)) {
				oSelect.selectByIndex(i);
				break;
			}
		}
	}
	
	
	public static void JavaExecute(WebElement element)
	{
		waitForVisitibilty(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);		
	}
	
	
	@AfterSuite(alwaysRun=true)
	public static void close()
	{
		log.info("**********AfterSuite Close Browser**********");

		test = extent.startTest("AfterSuite Close Browser");
		test.log(LogStatus.INFO, "Close close successfully:");
		test.log(LogStatus.INFO, "Driver quite successfully:");
		driver.close();
		driver.quit();
		
	}

}
