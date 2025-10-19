package core.listeners;

import core.factory.DriverFactory;
import core.helper.LogHelper;
import core.utils.TestUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogHelper.fail("{}", result.getThrowable().getMessage());
        byte[] screenshot = TestUtils.takeScreenShot(DriverFactory.getDriver(), result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
