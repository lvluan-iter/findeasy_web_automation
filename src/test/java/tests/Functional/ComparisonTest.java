package tests.Functional;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ComparisonPage;

import java.time.Duration;
import java.util.List;

public class ComparisonTest extends TestBase {
    ComparisonPage comparisonPage;

    @BeforeClass
    public void setPage() {
        comparisonPage = new ComparisonPage(driver);
        driver.get("https://propertyweb.onrender.com/");
    }

    @Test
    public void compareTwoValidProperty() {
        String expectedTitle = comparisonPage.compareTwo(0, 1);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("compare"));

        WebElement titleBar = driver.findElement(By.xpath("//div[contains(@class,'space-x-2')]"));
        List<WebElement> titles = titleBar.findElements(By.xpath(".//span[contains(@class,'font-medium')]"));

        StringBuilder currentTitle = new StringBuilder();
        for (WebElement title : titles) {
            wait.until(ExpectedConditions.visibilityOf(title));
            String text = title.getText().trim();
            currentTitle.append(text);
        }
        String cleanETitle = expectedTitle.replaceAll(" ","");
        String cleanCTitle = currentTitle.toString().replaceAll(" ","");
        Assert.assertEquals(cleanCTitle, cleanETitle);
    }

}
