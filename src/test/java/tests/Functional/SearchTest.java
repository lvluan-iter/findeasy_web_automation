package tests.Functional;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchPage;

import java.time.Duration;

public class SearchTest extends TestBase {
    SearchPage searchPage;

    @BeforeClass
    public void setSearchPage() {
        searchPage = new SearchPage(driver);
        driver.get("https://propertyweb.onrender.com/search");
    }

    @Test
    public void searchValidKeyword() {
        String keyword = "nhà trọ";
        searchPage.searchForKey(keyword);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(
                driver.findElement(By.xpath("//p[contains(.,'Refined selection for')]")),
                keyword
        ));
    }

    @Test
    public void searchForNonExistenceProperty() {
        String keyword = "abcdxyz123";
        searchPage.searchForKey(keyword);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(
                driver.findElement(By.xpath("//p[contains(.,'Refined selection for')]")),
                keyword
        ));

        WebElement results = driver.findElement(By.xpath("//h2[contains(.,'Homes')]"));
        Assert.assertTrue(results.getText().contains("0"));
    }
}
