package tests.Functional;

import base.BaseTest;
import core.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test
    public void loginWithValidCredentials() {
        loginPage.login("luan123", "Luan@0907");

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        WebElement form = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/main/div[1]/div/div/div[3]/div[2]/div")));
        Assert.assertTrue(form.isDisplayed());
    }

    @Test
    public void loginWithInvalidUsername() {
        loginPage.login("", "Luan@0907");
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login\"]/p")));
        Assert.assertEquals(error.getText(), "Login failed. Please check your credentials and try again.");
    }

    @Test
    public void loginWithInvalidPassword() {
        loginPage.login("luan123", "Luan@");
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login\"]/p")));
        Assert.assertEquals(error.getText(), "Login failed. Please check your credentials and try again.");
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginPage.login("lua3", "Luan@");
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login\"]/p")));
        Assert.assertEquals(error.getText(), "Login failed. Please check your credentials and try again.");
    }
}
