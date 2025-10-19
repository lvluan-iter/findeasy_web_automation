package runners;

import constants.FrameworkConstants;
import core.listeners.TestListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
@CucumberOptions(
        features = FrameworkConstants.FEATURES_PATH,
        glue = {"steps", "configs"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
