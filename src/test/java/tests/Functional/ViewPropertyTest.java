package tests.Functional;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ViewPropertyPage;

import java.time.Duration;
import java.util.List;

public class ViewPropertyTest extends TestBase {
    ViewPropertyPage page;

    @BeforeClass
    public void setPage() {
        page = new ViewPropertyPage(driver);
        driver.get("https://propertyweb.onrender.com/");
    }

    @Test
    public void viewAValidPropertyDetail() {
        String tittle = page.getTittle(0);
        page.viewDetailProperty(0);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("propertydetail"));
        String currentTitle = driver.findElement(By.xpath("//h1[contains(@class,'text-3xl')]")).getText();
        Assert.assertEquals(currentTitle,tittle);
    }




}
