package com.test.automation.UIAutomation.excelReader;

import java.util.Date;

import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.UIAutomation.testBase.TestBase;

public class TestDataDrivenScript extends TestBase
{
	@DataProvider(name="testData")
	public Object[][] dataSource()
	{
		return getData("TestData.xlsx","EmailDetails");
		//return testRecords;
	}
	
	@Test(dataProvider="testData")
	public void testRegister(String Server,
			String Port,
			String From,
			String Emailpassword,
			String To,
			String EmailUserName,
			String Subject,
			String MessageBody
			)
	{
		
		//boolean bvar = Boolean.parseBoolean(ASAP);
		System.out.println("********************************");
		System.out.println("Server:"+Server+"\t\t");
		System.out.println("Port:"+Port+"\t\t");
		System.out.println("From:"+From+"\t\t");
		System.out.println("Emailpassword:"+Emailpassword+"\t\t");
		System.out.println("To:"+To+"\t\t");
		System.out.println("EmailUserName:"+EmailUserName+"\t\t");
		System.out.println("Subject:"+Subject+"\t\t");
		System.out.println("MessageBody:"+MessageBody+"\t\t");
		
	/*	System.out.print("Position:"+Position+"\t\t");
		System.out.print("ActualSlots:"+ActualSlots+"\t\t");*/
	}

}
