package core.actions;

import core.helper.LogHelper;
import core.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputActions {
    private WebDriver driver;
    private WebElement element;
    private String description;

    public InputActions(WebDriver driver) {
        this.driver = driver;
    }

    public InputActions setInput(By locator, String description) {
        this.description = description;
        WaitHelper.visible(driver, locator, this.description);
        this.element = driver.findElement(locator);
        return this;
    }

    public InputActions clear() {
        LogHelper.info("Clearing: {}", description);
        element.clear();
        return this;
    }

    public InputActions fill(String value) {
        LogHelper.info("Filling {} with value: {}", description, value);
        element.clear();
        element.sendKeys(value);
        return this;
    }

    public InputActions type(String value) {
        LogHelper.info("Typing {} as {}", description, value);
        element.sendKeys(value);
        return this;
    }

    public InputActions fillAndTab(String value) {
        LogHelper.info("Filling {} with {} and pressing TAB", description, value);
        element.clear();
        element.sendKeys(value + Keys.TAB);
        return this;
    }

    public InputActions typeAndTab(String value) {
        LogHelper.info("Typing {} as {} and pressing TAB", description, value);
        element.sendKeys(value + Keys.TAB);
        return this;
    }
}
