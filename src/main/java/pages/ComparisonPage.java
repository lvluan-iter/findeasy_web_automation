package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComparisonPage {
    WebDriver driver;

    @FindBy(css = ".property")
    List<WebElement> properties;

    @FindBy(xpath = "//*[contains(text(),'So sánh ngay')]")
    WebElement submitBtn;

    public ComparisonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void choosePropertyComparison(int index) {
        properties.get(index).findElement(By.xpath(".//button[contains(., 'So sánh')]")).click();
    }

    public String getTittlePropertiesComparison(int index1, int index2) {
        WebElement property1 = properties.get(index1);
        WebElement property2 = properties.get(index2);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String title1 = (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].querySelector('h3').textContent;", property1);

        String title2 = (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].querySelector('h3').textContent;", property2);

        return title1 + "&" + title2;
    }

    public String compareTwo(int index1, int index2) {
        String title = getTittlePropertiesComparison(index1, index2);
        choosePropertyComparison(index1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement button =
                properties.get(index2).findElement(By.xpath(".//button[contains(., 'So sánh')]"));
        js.executeScript("arguments[0].click();", button);
        submitBtn.click();
        return title;
    }
}
