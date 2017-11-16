package com.test.automation.UIAutomation.extendReport;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.test.automation.UIAutomation.testBase.TestBase;

public class ExtentReportDemo extends TestBase
{
	public static Logger log = Logger.getLogger(ExtentReportDemo.class.getName());
	public static ExtentReports extent;
	 
	 public static ExtentReports ExtentDemo(String reportName)
	{
		// HTMLReporter.config().setAutoCreateRelativePathMedia(true);
		 //System.getProperty("usr.dir")+"/extentconfig/extent-config.xml"
		
		 System.out.println("RootDirectory:"+RootDirectory);
		 String extendpath=RootDirectory+"\\extentconfig\\extent-config.xml";
		 System.out.println("extendpath:"+extendpath);
		 try{
			/* DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH:mm:ss");
			 Date date = new Date();
			 String date1 = dateFormat.format(date);
			// Date date=new Date();
			 System.out.println("Date:"+date1);*/
			 extent =new ExtentReports(System.getProperty("user.dir")+"/Output/"+reportName+".html", true,DisplayOrder.OLDEST_FIRST);
			extent.addSystemInfo("HostaName","Yogesh-PC")
			.addSystemInfo("Enviroment", "QA")
			.addSystemInfo("User Name", "Yogesh solanki");
			extent.loadConfig(new File(extendpath));
			
		 }
		 catch(Exception ex)
		 {
			 System.out.println(ex.getMessage());
		 }
		 return extent;
	}
}