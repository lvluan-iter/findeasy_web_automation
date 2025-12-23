package core.actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import constants.FrameworkConstants;
import core.helper.LogHelper;

public class ElementActions {
    private WebDriver driver;
    private By locator;
    private String description;
    private final WebDriverWait wait;

    public ElementActions(WebDriver driver, By locator, String description) {
        this.driver = driver;
        this.locator = locator;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.WAIT_TIMEOUT));
        this.description = description;
    }

    public static ElementActions setElement(WebDriver driver, By locator, String description) {
        return new ElementActions(driver, locator, description);
    }

    private WebElement element() {
        return driver.findElement(locator);
    }

    public ElementActions click() {
        LogHelper.info("Clicking on: {}", description);
        element().click();
        return this;
    }

    public ElementActions doubleClick() {
        LogHelper.info("Double-clicking on: {}", description);
        new Actions(driver).doubleClick(element()).perform();
        return this;
    }

    public ElementActions hover() {
        LogHelper.info("Hovering over: {}", description);
        new Actions(driver).moveToElement(element()).perform();
        return this;
    }

    public ElementActions scrollIntoView() {
        LogHelper.info("Scrolling into view: {}", description);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                element());
        return this;
    }

    public String getText() {
        LogHelper.info("Getting text of: {}", description);
        return element().getText().trim();
    }

    public String getAttribute(String attribute) {
        LogHelper.info("Getting attribute '{}' of: {}", attribute, description);
        return element().getAttribute(attribute);
    }

    public ElementActions waitTillVisible() {
        LogHelper.info("Waiting till visible: {}", description);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    public ElementActions waitTillClickable() {
        LogHelper.info("Waiting till clickable: {}", description);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return this;
    }

    public ElementActions waitTillInvisible() {
        LogHelper.info("Waiting till invisible: {}", description);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        return this;
    }

    public ElementActions waitTillPresent() {
        LogHelper.info("Waiting till present: {}", description);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this;
    }

    public boolean isVisible() {
        return element().isDisplayed();
    }

    public boolean isEnabled() {
        return element().isEnabled();
    }

    public ElementActions jsClick() {
        LogHelper.info("Clicking via JS on: {}", description);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element());
        return this;
    }

    public ElementActions keyPress(CharSequence key) {
        LogHelper.info("Pressing key '{}' on: {}", key, description);
        element().sendKeys(key);
        return this;
    }

    public int getCount() {
        List<WebElement> elements = driver.findElements(locator);
        LogHelper.info("Getting count of: {} → {}", description, elements.size());
        return elements.size();
    }

    public ElementActions mouseClick() {
        LogHelper.info("Clicking via mouse action on: {}", description);
        new Actions(driver).moveToElement(element()).click().perform();
        return this;
    }

    public ElementActions clear() {
        LogHelper.info("Clearing: {}", description);
        element().clear();
        return this;
    }

    public ElementActions fill(String value) {
        LogHelper.info("Filling {} with value: {}", description, value);
        element().sendKeys(value);
        return this;
    }

    public ElementActions fillAndTab(String value) {
        LogHelper.info("Filling {} with {} and pressing TAB", description, value);
        element().sendKeys(value + Keys.TAB);
        return this;
    }

    public ElementActions check() {
        LogHelper.info("Checking {}", description);
        if (!isChecked()) {
            element().click();
        }
        return this;
    }

    public ElementActions uncheck() {
        LogHelper.info("Unchecking {}", description);
        if (isChecked()) {
            element().click();
        }
        return this;
    }

    public boolean isChecked() {
        LogHelper.info("Checking status of " + description);
        return element().isSelected();
    }

    private Select select() {
        return new Select(element());
    }

    public ElementActions selectByValue(String value) {
        LogHelper.info("Selecting value {} from {}", value, description);
        select().selectByValue(value);
        return this;
    }

    public ElementActions selectByVisibleText(String text) {
        LogHelper.info("Selecting text {} from {}", text, description);
        select().selectByVisibleText(text);
        return this;
    }

    public ElementActions selectByIndex(int index) {
        LogHelper.info("Selecting index {} from {}", index, description);
        select().selectByIndex(index);
        return this;
    }

    public List<String> getAllOptions() {
        LogHelper.info("Getting all options from {}", description);
        List<String> optionsText = new ArrayList<>();
        for (WebElement option : select().getOptions()) {
            optionsText.add(option.getText().trim());
        }
        return optionsText;
    }

    public List<String> getAllSelectedOptions() {
        LogHelper.info("Getting all selected options from {}", description);
        List<String> selectedTexts = new ArrayList<>();
        for (WebElement option : select().getAllSelectedOptions()) {
            selectedTexts.add(option.getText().trim());
        }
        return selectedTexts;
    }
}
