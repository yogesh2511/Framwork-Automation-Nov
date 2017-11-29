package com.test.automation.UIAutomation.customListener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.rangam.sourcpros.utility.ResourceHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.UIAutomation.config.EmailConfiguration;
import com.test.automation.UIAutomation.errorScreenShot.ErrorScreenShot;
import com.test.automation.UIAutomation.mailMoniter.MonitoringMail;
import com.test.automation.UIAutomation.mailMoniter.ZipFiles;
import com.test.automation.UIAutomation.testBase.TestBase;

public class Listener extends TestBase implements ITestListener {

	public static Logger log = Logger.getLogger(Listener.class.getName());
	String errorImagepath = null;

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			try {
				//test.log(LogStatus.FAIL,  "HTML", "Usage: BOLD TEXT");
				String methodName = result.getName();
				errorImagepath = ErrorScreenShot.getScreenShot(methodName, ".png", "FAILURE");
				test.log(LogStatus.FAIL, result.getThrowable());
				test.log(LogStatus.FAIL,errorImagepath);
				test.log(LogStatus.FAIL, "FAILURE method screenshot below" + test.addScreenCapture(errorImagepath));
								
				//test.log(LogStatus.FAIL, test.addScreenCapture(errorImagepath));
			} catch (Exception e)

			{
				log.info("Failed Method onTestFailure:"+e.getMessage());
				
			}
			extent.endTest(test);
			extent.flush();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		if (result.getStatus() == ITestResult.SKIP) 
		{
			try {

				String methodName = result.getName();
				errorImagepath = ErrorScreenShot.getScreenShot(methodName, ".png", "SKIPPED");
				test.log(LogStatus.SKIP, result.getThrowable());
				test.log(LogStatus.SKIP,errorImagepath);
				test.log(LogStatus.SKIP, "SKIP method screenshot below" + test.addScreenCapture(errorImagepath));
			} catch (Exception e)

			{
				log.info("Failed Method onTestSkipped:"+e.getMessage());
				
			}
			extent.endTest(test);
			extent.flush();
		}

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) 
		{
			try {

				String methodName = result.getName();
				errorImagepath = ErrorScreenShot.getScreenShot(methodName, ".png", "SUCCESS");
				test.log(LogStatus.PASS, methodName+" test is pass");
				test.log(LogStatus.PASS,errorImagepath);
				//test.log(LogStatus.PASS, "SUCCESS method screenshot below" + test.addScreenCapture(errorImagepath));
			} catch (Exception e)

			{
				log.info("Failed Method onTestSuccess:"+e.getMessage());
				//e.getMessage();
				//System.out.println(e.getMessage());
			}
			extent.endTest(test);
			extent.flush();
		}

	}

	@Override
	public void onFinish(ITestContext arg0) {
		try {
			String outputFolderPath = ResourceHelper.getResourcePath("\\Output");
			System.out.println("outputFolderPath:"+outputFolderPath);
			ZipFiles.zip(outputFolderPath,EmailConfiguration.attachmentName);
			MonitoringMail.sendmail(EmailConfiguration.server,
					EmailConfiguration.port,
					EmailConfiguration.from,
					EmailConfiguration.Emailpassword,
					EmailConfiguration.to,
					EmailConfiguration.cc,
					EmailConfiguration.Emailusername,
					EmailConfiguration.subject,
					EmailConfiguration.messageBody,
					EmailConfiguration.attachmentPath,
					EmailConfiguration.attachmentName);
			log.info("mail moniter method called");
			

		} catch (Exception e) {
			log.info("Failed Method onFinish:"+e.getMessage());
			System.out.println(e.getMessage());
			log.info("mail moniter method error message"+e.getMessage());
			
		}
		

	}

}
