package com.test.automation.UIAutomation.uiActions.Dashboard;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.automation.UIAutomation.LandingPage.HomePage;
import com.test.automation.UIAutomation.testBase.TestBase;

public class DashboardAdminHeaderPage extends TestBase
{
	public static Logger log = Logger.getLogger(DashboardAdminHeaderPage.class.getName());
	public WebElement selectDaybtn(String Day)
	{
		WebElement element=driver.findElement(By.xpath("//a[contains(text(),'"+Day+"')]"));
		//driver.findElement(By.xpath("//a[@id='export']"))
		return element;
	}
	public WebElement selectExportbtn(String Day)
	{
		WebElement element=driver.findElement(By.xpath("//a[@id='export']"));
		return element;
	}
}
