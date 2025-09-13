package base;

import factory.BrowserFactory;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

        WebDriver driver = BrowserFactory.getDriver(browser, headless);
        DriverFactory.setDriver(driver);

        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        if (DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().quit();
            DriverFactory.unload();
        }
    }
}
