package tests.Functional;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;

import java.time.Duration;

public class ForgotPasswordTest extends TestBase {
    private ForgotPasswordPage forgotPasswordPage;

    @BeforeClass
    public void setUpPage() {
        forgotPasswordPage = new ForgotPasswordPage(driver);
        driver.get("https://propertyweb.onrender.com/forgot-password");
    }

    @Test
    public void enterAValidRegisteredEmail() {
        forgotPasswordPage.sendForgotPassword("luanle.31211027594@st.ueh.edu.vn");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals(message,"Reset link sent! Please check your email.");
    }

    @Test
    public void enterAnUnregisteredEmail() {
        forgotPasswordPage.sendForgotPassword("luanle.31211027594@ueh.edu.vn");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertTrue(message.contains("not found"));
    }
}
