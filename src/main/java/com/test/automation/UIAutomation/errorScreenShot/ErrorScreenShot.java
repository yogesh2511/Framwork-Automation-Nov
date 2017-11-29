package com.test.automation.UIAutomation.errorScreenShot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.apache.commons.io.FileUtils;
import com.test.automation.UIAutomation.testBase.TestBase;

public class ErrorScreenShot extends TestBase
{
	public static String getScreenShot(String methodname, String imageExtension,String folderName)
	{
		String dest = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File destFile = null ;
		//String methodName = methodname;

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\Output\\"+folderName;
			System.out.println("image path:"+(String) reportDirectory +"_"+methodname + "_" + formater.format(calendar.getTime()) + imageExtension);
			log.info((String) reportDirectory +"_"+methodname + "_" + formater.format(calendar.getTime()) + imageExtension);
			 dest = (String) reportDirectory +"_"+methodname + "_" + formater.format(calendar.getTime()) + imageExtension;
			log.info("Dest="+dest);
			 destFile = new File((String) reportDirectory +"_"+methodname + "_" + formater.format(calendar.getTime()) + imageExtension);
			/*String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/resources/ScreenShots/"+folderName;
			 destFile = new File((String) reportDirectory + "/screenshot/"+ methodName + "_" + formater.format(calendar.getTime()) + imageExtension);
			*/ //System.out.println("destFile:"+destFile.toString());
			System.out.println("reportDirectory:"+reportDirectory);
			//destFile = new File((String) reportDirectory + methodName + "_" + formater.format(calendar.getTime()) + imageExtension);
			FileUtils.copyFile(scrFile, destFile);
			
			log.info("image path : "+destFile.getAbsolutePath());
			log.info("Take screenshot completed");
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			return dest;
		} 
		catch (Exception e) {
			log.error(e.getMessage());
			System.out.println("ErrorScreenShot(class)->getScreenShot(method) error:"+e.getMessage());
		}
		
		return dest;
		
		
	}

}
