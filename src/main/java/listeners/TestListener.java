package listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Log;
import reports.ExtentManager;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        Log.getLogger(getClass()).info("=== TEST STARTED ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flushReports();
        Log.getLogger(getClass()).info("=== TEST FINISHED ===");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.createTest(result.getMethod().getMethodName());
        Log.getLogger(getClass()).info("Starting test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().pass("Test Passed");
        Log.getLogger(getClass()).info("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getTest().fail("Test Failed: " + result.getThrowable());
        Log.getLogger(getClass()).error("Test failed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().skip("Test Skipped");
        Log.getLogger(getClass()).warn("Test skipped: " + result.getMethod().getMethodName());
    }
}
