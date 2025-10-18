package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewPropertyPage {
    WebDriver driver;

    @FindBy(css = ".property")
    List<WebElement> properties;

    public ViewPropertyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getTittle(int index) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return  (String) javascriptExecutor.executeScript(
                "return arguments[0].querySelector('h3').textContent.trim()", properties.get(index)
        );
    }

    public void viewDetailProperty(int index) {
        properties.get(index)
                .findElement(By.xpath("//button[contains(text(),'View Details')]")).click();
    }
}
