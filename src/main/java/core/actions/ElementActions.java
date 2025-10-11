package core.actions;

import core.helper.LogHelper;
import core.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ElementActions {
    private WebDriver driver;
    private WebElement element;
    private By locator;
    private String description;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public ElementActions setElement(By locator, String description) {
        this.locator = locator;
        this.description = description;
        WaitHelper.visible(driver, this.locator, this.description);
        this.element = driver.findElement(locator);
        return this;
    }

    public ElementActions click() {
        LogHelper.info("Clicking on: {}", description);
        element.click();
        return this;
    }

    public ElementActions doubleClick() {
        LogHelper.info("Double-clicking on: {}", description);
        new Actions(driver).doubleClick(element).perform();
        return this;
    }

    public ElementActions hover() {
        LogHelper.info("Hovering over: {}", description);
        new Actions(driver).moveToElement(element).perform();
        return this;
    }

    public ElementActions scrollIntoView() {
        LogHelper.info("Scrolling into view: {}", description);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public String getText() {
        LogHelper.info("Getting text of: {}", description);
        return element.getText().trim();
    }

    public String getAttribute(String attribute) {
        LogHelper.info("Getting attribute '{}' of: {}", attribute, description);
        return element.getAttribute(attribute);
    }

    public boolean isVisible() {
        return element.isDisplayed();
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }

    public ElementActions jsClick() {
        LogHelper.info("Clicking via JS on: {}", description);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return this;
    }

    public ElementActions keyPress(CharSequence key) {
        LogHelper.info("Pressing key '{}' on: {}", key, description);
        element.sendKeys(key);
        return this;
    }

    public int getCount() {
        List<WebElement> elements = driver.findElements(locator);
        LogHelper.info("Getting count of: {} → {}", description, elements.size());
        return elements.size();
    }

    public ElementActions mouseClick() {
        LogHelper.info("Clicking via mouse action on: {}", description);
        new Actions(driver).moveToElement(element).click().perform();
        return this;
    }
}