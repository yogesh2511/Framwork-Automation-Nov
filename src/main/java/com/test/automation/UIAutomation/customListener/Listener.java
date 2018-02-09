package com.test.automation.UIAutomation.customListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.UIAutomation.config.EmailConfiguration;
import com.test.automation.UIAutomation.errorScreenShot.ErrorScreenShot;
import com.test.automation.UIAutomation.mailMoniter.MonitoringMail;
import com.test.automation.UIAutomation.mailMoniter.ZipFiles;
import com.test.automation.UIAutomation.testBase.TestBase;
import com.test.automation.UIAutomation.utility.ResourceHelper;

public class Listener extends TestBase implements ITestListener {
	public static Logger log = Logger.getLogger(Listener.class.getName());
	String errorImagepath = null;

	@Override
	public void onStart(ITestContext arg0) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				// test.log(LogStatus.FAIL, "HTML", "Usage: BOLD TEXT");
				String methodName = result.getName();
				errorImagepath = ErrorScreenShot.getScreenShot(methodName, ".png", "FAILURE");
				File file = new File(errorImagepath);
				String path = "file://" + errorImagepath.toString();
				test.log(LogStatus.FAIL, result.getThrowable());
				test.log(LogStatus.FAIL, path);
				String encodstring = encodeFileToBase64Binary(file);
				String base = "data:image/png;base64," + encodstring;
				test.log(LogStatus.FAIL, "Failed method screenshot below" + test.addBase64ScreenShot(base));
				Reporter.log("<a href='" + base + "'> <img src='" + base + "' height='100' width='100'/> </a>");
			} catch (Exception e)

			{
				log.info("Failed Method onTestFailure:" + e.getMessage());

			}
			extent.endTest(test);
			extent.flush();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		if (result.getStatus() == ITestResult.SKIP) {
			try {

				String methodName = result.getName();
				errorImagepath = ErrorScreenShot.getScreenShot(methodName, ".png", "SKIPPED");
				File file = new File(errorImagepath);
				String path = "file://" + errorImagepath.toString();
				test.log(LogStatus.SKIP, result.getThrowable());
				test.log(LogStatus.SKIP, path);
				String encodstring = encodeFileToBase64Binary(file);
				String base = "data:image/png;base64," + encodstring;
				test.log(LogStatus.SKIP, "SKIP method screenshot below" + test.addBase64ScreenShot(base));
				Reporter.log("<a href='" + base + "'> <img src='" + base + "' height='100' width='100'/> </a>");

			} catch (Exception e)

			{
				log.info("Failed Method onTestSkipped:" + e.getMessage());

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

		if (result.getStatus() == ITestResult.SUCCESS) {
			try {

				/*String methodName = result.getName();
				errorImagepath = ErrorScreenShot.getScreenShot(methodName, ".png", "SUCCESS");*/
				test.log(LogStatus.PASS, result.getName() + ": Test is pass");
				test.log(LogStatus.PASS, errorImagepath);
				// test.log(LogStatus.PASS, "SUCCESS method screenshot below" +
				// test.addScreenCapture(errorImagepath));
			} catch (Exception e)

			{
				log.info("Failed Method onTestSuccess:" + e.getMessage());
				// e.getMessage();
				// System.out.println(e.getMessage());
			}
			extent.endTest(test);
			extent.flush();
		}

	}

	@Override
	public void onFinish(ITestContext arg0) {
		try {
			String outputFolderPath = ResourceHelper.getResourcePath("\\Output");
			System.out.println("outputFolderPath:" + outputFolderPath);
			ZipFiles.zip(outputFolderPath, EmailConfiguration.attachmentName);
			MonitoringMail.sendmail(EmailConfiguration.server, EmailConfiguration.port, EmailConfiguration.from,
					EmailConfiguration.Emailpassword, EmailConfiguration.to, EmailConfiguration.cc,
					EmailConfiguration.Emailusername, EmailConfiguration.subject, EmailConfiguration.messageBody,
					EmailConfiguration.attachmentPath, EmailConfiguration.attachmentName);
			log.info("mail moniter method called");

		} catch (Exception e) {
			log.info("Failed Method onFinish:" + e.getMessage());
			System.out.println(e.getMessage());
			log.info("mail moniter method error message" + e.getMessage());

		}

	}

	private static String encodeFileToBase64Binary(File file) {
		String encodedfile = null;
		try {
			FileInputStream fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encodedfile;
	}
}
