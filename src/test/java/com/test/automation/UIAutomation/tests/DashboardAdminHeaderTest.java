package com.test.automation.UIAutomation.tests;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.UIAutomation.LandingPage.Pages;
import com.test.automation.UIAutomation.LoginPage.LoginPage;
import com.test.automation.UIAutomation.helper.BrowserHelper;
import com.test.automation.UIAutomation.helper.JavaScriptHelper;
import com.test.automation.UIAutomation.helper.WaitHelper;
import com.test.automation.UIAutomation.testBase.TestBase;

public class DashboardAdminHeaderTest extends TestBase {
	public static Logger log = Logger.getLogger(DashboardAdminHeaderTest.class.getName());
	SoftAssert s_assert = new SoftAssert();

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		String[][] testRecords = getData(Config.getProperty("exelsheetname"),
				Config.getProperty("SingleLoginTestData"));
		return testRecords;
	}

	@Test(dataProvider = "loginData", timeOut = 15000, priority = 0)
	public void Logins(String emailAddress, String password, String runMode) throws InterruptedException {

		if (runMode.equalsIgnoreCase("n")) {
			log.info("verifiyLoginWithDifferentRecords method skipped");
			test = extent.startTest("verifiyLoginWithDifferentRecords");
			test.log(LogStatus.INFO, "verifiyLoginWithDifferentRecords method skipped");
			test.log(LogStatus.SKIP, "Login and logout skipped");
			throw new SkipException("Skipping this exception");
		}

		else {
			try {
				jsp = new LoginPage(driver);

				driver.navigate().refresh();
				log.info("**********starting test**********");

				test = extent.startTest("Logins");

				log.info("try to login with username:" + emailAddress + " and password" + password);
				test.log(LogStatus.INFO, "Email:" + emailAddress + " and password : " + password);

				boolean LoginSuccessStatus = LoginPage.loginToApplication(emailAddress, password);
				log.info("LoginSuccessStatus:" + LoginSuccessStatus);

				log.info("Login functionality working fine");
				log.info("**********finish test************");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Test(dependsOnMethods = "Logins", priority = 1)
	public void selctCandidateListPage() throws InterruptedException 
	{
		Pages.homapage().subHeaderMethod("Dashboard", "Admin Header");
		click(Pages.DashboardAdminHeaderPage().selectDaybtn("Day"));
		click(Pages.DashboardAdminHeaderPage().selectExportbtn("Export"));
	}
	
	
	
}
