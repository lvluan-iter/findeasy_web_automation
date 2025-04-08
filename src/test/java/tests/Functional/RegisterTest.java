package tests.Functional;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.time.Duration;

public class RegisterTest extends TestBase {
    private RegisterPage page;
    @BeforeClass
    public void setupPage() {
        page = new RegisterPage(driver);
    }

    @Test
    public void registerWithAllValidInfomation() {
        driver.get("https://propertyweb.onrender.com/register");
        page.register("luan12345", "Luan@0907", "Luan@0907", "luanle@gmail.com", "Luan", "093323944");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[contains(text(),'successfully')]")
        ));
        Assert.assertTrue(message.isDisplayed());
    }

    @Test
    public void registerWithExistUsername() {
        driver.get("https://propertyweb.onrender.com/register");
        page.register("luan123", "Luan@0907", "Luan@0907", "luanle@gmail.com", "Luan", "093323944");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[contains(text(),'exists')]")
        ));
        Assert.assertTrue(message.isDisplayed());
    }

    @Test
    public void registerPasswordDoesNotMatching() {
        driver.get("https://propertyweb.onrender.com/register");
        page.register("luan123", "Luan@0907", "Luan@090", "luanle@gmail.com", "Luan", "093323944");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[contains(text(),'Nhập lại mật khẩu không khớp')]")
        ));
        Assert.assertTrue(message.isDisplayed());
    }
}
