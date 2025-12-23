package listeners;

import java.io.ByteArrayInputStream;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import core.factory.BrowserFactory;
import core.factory.DriverFactory;
import core.helper.LogHelper;
import core.utils.TestUtils;
import io.qameta.allure.Allure;
import utils.ConfigReader;

public class TestListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        LogHelper.info("=== START TEST SUITE: " + suite.getName() + " ===");
    }

    @Override
    public void onFinish(ISuite suite) {
        LogHelper.info("=== END TEST SUITE: " + suite.getName() + " ===");
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        LogHelper.info("===== START TEST: " + testName + " =====");

        String browser = ConfigReader.init().getProperty("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.init().getProperty("headless"));

        WebDriver driver = BrowserFactory.getDriver(browser, headless);
        DriverFactory.setDriver(driver);

        driver.get(ConfigReader.init().getProperty("url"));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogHelper.error("===== FAILED: " + result.getMethod().getMethodName() + " =====");

        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {
            byte[] screenshot =
                    TestUtils.takeScreenShot(driver, result.getMethod().getMethodName());
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        }
        cleanupDriver();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogHelper.info("===== PASSED: " + result.getMethod().getMethodName() + " =====");
        cleanupDriver();
    }

    private void cleanupDriver() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
            DriverFactory.unload();
        }
    }
}
