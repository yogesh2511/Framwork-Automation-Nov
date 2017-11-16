package com.test.automation.UIAutomation.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.test.automation.UIAutomation.mailMoniter.MonitoringMail;
import com.test.automation.UIAutomation.testBase.TestBase;

public class ConfigConfiguration extends TestBase 
{
	
	Properties or;
	File file;
	FileInputStream input;
	
	
	public static  String testsiteurl;
	public static   String browser;
	public static  String implicitwait;
	public static   String retryfailedtest;
	public static  String exelsheetname;
	public static  String LoginsheetName;
	public static  String RIPLLoginTestData;
	public static  String SingleLoginTestData;	
	public static  String RegisterDetailsTestData;
	public static String UpdateRegisterdetails;
	
	//testsiteurl=http://demo.sourcepros.com/
	/*browser=chrome
			implicit.wait=10
			retryfailedtest=2
			exelsheetname=TestData.xlsx
			LoginsheetName=LoginTestData
			RIPLLoginTestData=RIPLLoginTestData
			SingleLoginTestData=SingleLoginTestData
			RegisterDetailsTestData=RegisterDetailsTestData
			UpdateRegisterdetails=UpdateRegisterdetails*/
	
	
	public static Logger log = Logger.getLogger(ConfigConfiguration.class.getName());
	
	public ConfigConfiguration()
	{
		try {
			 or=new Properties();
			 file= new File(System.getProperty("user.dir") + "//resources//properties//Config.properties");
			input=new FileInputStream(file);
			or.load(input);	
			ConfigConfiguration.testsiteurl=or.getProperty("testsiteurl");
			ConfigConfiguration.browser=or.getProperty("browser");
			ConfigConfiguration.implicitwait=or.getProperty("implicit.wait");
			ConfigConfiguration.retryfailedtest=or.getProperty("retryfailedtest");
			ConfigConfiguration.exelsheetname=or.getProperty("exelsheetname");
			ConfigConfiguration.LoginsheetName=or.getProperty("LoginsheetName");
			ConfigConfiguration.RIPLLoginTestData=or.getProperty("RIPLLoginTestData");
			ConfigConfiguration.SingleLoginTestData=or.getProperty("SingleLoginTestData");
			ConfigConfiguration.RegisterDetailsTestData=or.getProperty("RegisterDetailsTestData");
			ConfigConfiguration.UpdateRegisterdetails=or.getProperty("UpdateRegisterdetails");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	
	
	/*public static final String server="mail.rangam.com";
	public static final  String port="25";
	public static final String from = "yogeshsolanki@rangam.com";
	public static final  String Emailpassword = "june@2017";
	public static final String to ="yogeshsolanki@rangam.com";
	public static final String Emailusername="yogeshsolanki@rangam.com";
	public static final String cc = "yogeshsolanki@rangam.com";
	//qateam@rangam.com  kedarhukeri@rangam.com
//	public static String[] bcc = {"yogeshsolanki@rangam.com"};
	public static final String subject = "Automation Report";	
	public static final  String messageBody ="Please Find Attachment For the Report";
	public static final  String attachmentPath=RootDirectory+"\\extentconfig\\AutomationReport.html";
	public static final String attachmentName="AutomationReport.html";*/
	
	
	
	
	
}
