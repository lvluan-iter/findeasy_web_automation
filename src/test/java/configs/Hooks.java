package configs;

import core.actions.UIActions;
import core.factory.BrowserFactory;
import core.factory.DriverFactory;
import core.utils.ConfigReader;
import core.utils.TestUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    protected UIActions ui;

    @Before
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

        WebDriver driver = BrowserFactory.getDriver(browser, headless);
        DriverFactory.setDriver(driver);
        ui = new UIActions(DriverFactory.getDriver());
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = TestUtils.takeScreenShot(DriverFactory.getDriver(), scenario.getName());
            scenario.attach(screenshot, "image/pmg", "");
        }

        if (DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().quit();
            DriverFactory.unload();
        }
    }
}
