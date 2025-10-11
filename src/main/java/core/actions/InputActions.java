package core.actions;

import constants.FrameworkConstants;
import core.helper.LogHelper;
import core.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputActions {
    private WebDriver driver;
    private WebElement element;
    private By locator;
    private String description;

    public InputActions(WebDriver driver) {
        this.driver = driver;
    }

    public InputActions setInput(By locator, String description) {
        this.locator = locator;
        this.description = description;
        WaitHelper.visible(driver, this.locator, this.description);
        this.element = driver.findElement(locator);
        return this;
    }

    private WebElement getElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.WAIT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public InputActions clear() {
        element = getElement();
        LogHelper.info("Clearing: {}", description);
        element.clear();
        return this;
    }

    public InputActions fill(String value) {
        element = getElement();
        LogHelper.info("Filling {} with value: {}", description, value);
        element.clear();
        element.sendKeys(value);
        return this;
    }

    public InputActions type(String value) {
        element = getElement();
        LogHelper.info("Typing {} as {}", description, value);
        element.sendKeys(value);
        return this;
    }

    public InputActions fillAndTab(String value) {
        element = getElement();
        LogHelper.info("Filling {} with {} and pressing TAB", description, value);
        element.clear();
        element.sendKeys(value + Keys.TAB);
        return this;
    }

    public InputActions typeAndTab(String value) {
        element = getElement();
        LogHelper.info("Typing {} as {} and pressing TAB", description, value);
        element.sendKeys(value + Keys.TAB);
        return this;
    }
}
