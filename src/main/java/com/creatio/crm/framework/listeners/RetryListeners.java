package com.creatio.crm.framework.listeners;

import org.testng.ITestResult;

//import com.creatio.crm.framework.reports.ITestResult;

public class RetryListeners {
	
	int count = 0;
    int retryCount = 2;

    //
    public boolean retry(ITestResult result) {

        if (!result.isSuccess()) { // verify whether test case is failed
            if (count < retryCount) { // verify count value is less than max retry count
                count++; // increase count by 1 every time
                return true; // retry test case
            }
        }

        return false; // no need to retry as test is successful
    }

}
