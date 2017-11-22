package utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.logging.Logger;

public class MyTestListener extends TestListenerAdapter {

    protected static Logger LOGGER;

    public MyTestListener() {
        LOGGER = MyLogger.getInstance();
    }

    @Override
    public void onTestStart(ITestResult testResult) {
        LOGGER.info("TEST STARTING: " + testResult.getTestClass() + " => " + testResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        LOGGER.info(testResult.getName() + " SUCCEEDED!");
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        LOGGER.warning(testResult.getName() + " FAILED with exception: " +
                MyLogger.MyFormatter.formatThrowable(testResult.getThrowable()).toString());
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        LOGGER.info(testResult.getName() + " SKIPPED!");
    }

}
