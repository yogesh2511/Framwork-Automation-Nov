package com.test.automation.UIAutomation.ruffwork;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.test.automation.UIAutomation.errorScreenShot.ErrorScreenShot;
import com.test.automation.UIAutomation.extendReport.ExtentUtil;

public class Extent_ReportTest {
	WebDriver driver;

	@Test(groups = { "Regression" })
	public void test1() {

		try {
			System.setProperty("webdriver.chrome.driver", "D:\\Java_Project\\UIAutomation\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.google.co.in");

			String image = ErrorScreenShot.getScreenShot("test1", ".png", "Error");
			ExtentUtil.fetchTest().addScreenCaptureFromPath(image);
			ExtentUtil.fetchTest().info("Testing log", MediaEntityBuilder.createScreenCaptureFromPath(image).build());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("testng");
		Assert.assertEquals(true, true);
	}

	@Test(groups = { "Regression" })
	public void test2() {
		System.out.println("testng 2");
		Assert.assertEquals(false, true);
	}

	@Test(groups = { "Smoke" })
	public void test3() {
		System.out.println("testng 3");
		Assert.assertEquals(true, true);
	}

	@Test(groups = { "Smoke" })
	public void test4() {
		System.out.println("testng 4");
		Assert.assertEquals(false, true);
	}

}
