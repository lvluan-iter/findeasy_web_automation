package base;

import core.actions.UIActions;
import core.factory.BrowserFactory;
import core.factory.DriverFactory;
import core.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected UIActions ui;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

        WebDriver driver = BrowserFactory.getDriver(browser, headless);
        DriverFactory.setDriver(driver);
        ui = new UIActions(DriverFactory.getDriver());
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
