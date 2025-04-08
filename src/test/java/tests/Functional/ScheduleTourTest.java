package tests.Functional;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ScheduleTourPage;
import pages.ViewPropertyPage;

import java.time.Duration;

public class ScheduleTourTest extends TestBase {
    ViewPropertyPage viewPropertyPage;
    ScheduleTourPage page;

    @BeforeClass
    public void setPage() {
        viewPropertyPage = new ViewPropertyPage(driver);
        page = new ScheduleTourPage(driver);
        driver.get("https://propertyweb.onrender.com/");
    }

    @Test
    public void scheduleAValidTour() {
        viewPropertyPage.viewDetailProperty(0);
        page.scheduleTour("0336555650","04/08/2025","14:30","luanle.31211027594@st.ueh.edu.vn");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("successfully"));
    }
}
