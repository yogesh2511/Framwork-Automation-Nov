package com.test.automation.UIAutomation.tests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.UIAutomation.excelReader.excelReader;
import com.test.automation.UIAutomation.testBase.TestBase;
import com.test.automation.UIAutomation.uiActions.LoginPage;

public class VerifiyLoginWithDifferentRecords extends TestBase {
	public static Logger log = Logger.getLogger(VerifiyLoginWithDifferentRecords.class.getName());
	SoftAssert s_assert;

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		// String[][] testRecords = getData("TestData.xlsx", "LoginTestData");
		String[][] testRecords = getData(Config.getProperty("exelsheetname"), Config.getProperty("LoginsheetName"));
		return testRecords;
	}

	/*
	 * @BeforeTest public void setUp1() {
	 * 
	 * TestBase.initializeTestBaseSetup(Config.getProperty("browser"),
	 * Config.getProperty("testsiteurl")); log.info("open url succssfully");
	 * System.out.println(Config.getProperty("testsiteurl"));
	 * log.info(Config.getProperty("testsiteurl"));
	 * 
	 * }
	 */

	@Test(dataProvider = "loginData", timeOut = 15000)
	public void verifiyLoginWithDifferentRecords(String emailAddress, String password, String runMode)
			throws InterruptedException {
		s_assert = new SoftAssert();

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
				// jsp.beforelogin();
				driver.navigate().refresh();
				log.info("**********starting test**********");

				test = extent.startTest("verifiyLoginWithDifferentRecords");

				log.info("try to login with username:" + emailAddress + " and password" + password);
				test.log(LogStatus.INFO, "Email:" + emailAddress + " and password : " + password);

				boolean LoginSuccessStatus = LoginPage.loginToApplication(emailAddress, password);
				log.info("LoginSuccessStatus:" + LoginSuccessStatus);
				s_assert.assertEquals(true, LoginSuccessStatus);

				jsp.logout();
				boolean LogOutSuccessStatus = jsp.verifyLogOutSuccess();
				s_assert.assertEquals(LogOutSuccessStatus, true);
				test.log(LogStatus.INFO, "Logout successfully:" + LoginSuccessStatus);
				s_assert.assertAll();
				log.info("Login functionality working fine");
				log.info("**********finish test************");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
