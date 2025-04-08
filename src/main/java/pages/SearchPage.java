package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
    WebElement searchBar;

    @FindBy(xpath = "//button[contains(.,'Search')]")
    WebElement searchBtn;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterSearchKey(String key) {
        searchBar.sendKeys(key);
    }

    public void searchForKey(String key) {
        enterSearchKey(key);
        searchBtn.click();
    }
}
