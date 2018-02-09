package com.test.automation.UIAutomation.customListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.test.automation.UIAutomation.extendReport.ExtentUtil;

public class TestListenerAdapter implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		ExtentUtil.createTest(result.getMethod().getMethodName());
		String[] categories = result.getMethod().getGroups();
		for (String category : categories) {
			ExtentUtil.fetchTest().assignCategory(category);
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentUtil.fetchTest().pass("Passed");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentUtil.fetchTest().fail("Failed");
		}
		

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		if (ExtentUtil.getExtentReports() == null) {
			ExtentUtil.createReporter("extentreport.html");
			
		}
	}

	@Override
	public void onFinish(ITestContext context) {

		ExtentUtil.saveReporter();
	}

}
