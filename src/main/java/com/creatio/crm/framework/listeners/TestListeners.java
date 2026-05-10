package com.creatio.crm.framework.listeners;

import org.testng.ITestListener;

//import java.lang.System.Logger;

//import java.util.logging.Logger;

//import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
//import org.testng.log4testng.Logger;
//import org.testng.log4testng.Logger;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.reports.Reports;

//import freemarker.log.Logger;

public class TestListeners extends Reports implements ITestListener{
	
	Reports reports = new Reports();
	
	 public void onTestStart(ITestResult result) {
	        String testMethodName = result.getMethod().getMethodName();
	        startReporting(testMethodName);
	    }

	    public void onTestSuccess(ITestResult result) {
	        String testMethodName = result.getMethod().getMethodName();
	       
	        logger.pass("Test Execution is successfully completed for Test Case : " + testMethodName);
	        stopReporting();
	    }

	    public void onTestFailure(ITestResult result) {
	        String testMethodName = result.getMethod().getMethodName();
	        logger.fail("Test Execution is Failed for Test Case : " + testMethodName);
	        logger.fail("Test Execution is Failed due to : " + result.getThrowable().getLocalizedMessage());
	        attachScreenshot(new BasePage().getDriver(), testMethodName);
	        stopReporting();
	    }

	    public void onTestSkipped(ITestResult result) {
	        String testMethodName = result.getMethod().getMethodName();
	        logger.fail("Test Execution is Skipped for Test Case : " + testMethodName);
	        logger.fail("Test Execution is Skipped due to : " + result.getThrowable().getLocalizedMessage());
	        attachScreenshot(new BasePage().getDriver(), testMethodName);
	        stopReporting();
	    }

}
