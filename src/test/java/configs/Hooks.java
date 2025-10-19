package configs;

import core.actions.UIActions;
import core.factory.BrowserFactory;
import core.factory.DriverFactory;
import core.helper.LogHelper;
import core.utils.ConfigReader;
import core.utils.TestUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp(Scenario scenario) {
        LogHelper.info("===== START SCENARIO: " + scenario.getName() + " =====");

        String browser = ConfigReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

        WebDriver driver = BrowserFactory.getDriver(browser, headless);
        DriverFactory.setDriver(driver);
        context.setUi(new UIActions(driver));
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = TestUtils.takeScreenShot(DriverFactory.getDriver(), scenario.getName());
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }

        LogHelper.info("===== END SCENARIO: " + scenario.getName() + " - STATUS: " + scenario.getStatus() + " =====");

        if (DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().quit();
            DriverFactory.unload();
        }
    }
}
