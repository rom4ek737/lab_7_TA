package com.epam.lab7.hw3;

import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(MyListener.class);

    public void onTestStart(ITestResult var1) {
        LOGGER.info("The test have been started!");
    }

    public void onTestSuccess(ITestResult var1) {
        LOGGER.info("Gmail login and delete some messages was successful");
    }

    public void onTestFailure(ITestResult var1) {
        LOGGER.info("Gmail login and delete some messages was unsuccessful");
    }

    public void onTestSkipped(ITestResult var1) {
        LOGGER.info("Gmail test was skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult var1) {
        LOGGER.info("Test failed but within success percentage");
    }

    public void onStart(ITestContext var1) {
        LOGGER.info("Start");
    }

    public void onFinish(ITestContext var1) {
        LOGGER.info("Finish");
    }
}
