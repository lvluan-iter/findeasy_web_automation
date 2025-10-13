package core.listeners;

import core.factory.DriverFactory;
import core.helper.LogHelper;
import core.utils.TestUtils;
import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        LogHelper.info("========== STARTING TEST SUITE: {} ==========", context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        LogHelper.info("Starting Test: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogHelper.pass(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogHelper.fail(result.getMethod().getMethodName());
        LogHelper.error("Failure reason: {}", result.getThrowable());
        byte[] screenshot = TestUtils.takeScreenShot(DriverFactory.getDriver(), result.getName());
        if (screenshot.length > 0) {
            Allure.addAttachment("Screenshot - " + result.getName(),
                    new ByteArrayInputStream(screenshot));
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogHelper.skip(result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        LogHelper.info("========== FINISHED TEST SUITE: {} ==========", context.getName());
    }
}
