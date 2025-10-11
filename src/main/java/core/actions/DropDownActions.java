package core.actions;

import core.helper.LogHelper;
import core.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropDownActions {
    private WebDriver driver;
    private Select select;
    private By locator;
    private String description;

    public DropDownActions(WebDriver driver) {
        this.driver = driver;
    }

    public DropDownActions setLocator(By locator, String description) {
        this.locator = locator;
        this.description = description;
        WaitHelper.visible(driver, this.locator, this.description);
        this.select = new Select(driver.findElement(locator));
        return this;
    }

    public DropDownActions selectByValue(String value) {
        LogHelper.info("Selecting value {} from {}", value, description);
        select.selectByValue(value);
        return this;
    }

    public DropDownActions selectByVisibleText(String text) {
        LogHelper.info("Selecting text {} from {}", text, description);
        select.selectByVisibleText(text);
        return this;
    }

    public DropDownActions selectByIndex(int index) {
        LogHelper.info("Selecting index {} from {}", index, description);
        select.selectByIndex(index);
        return this;
    }

    public List<String> getAllOptions() {
        LogHelper.info("Getting all options from {}", description);
        List<String> optionsText = new ArrayList<>();
        for (WebElement option : select.getOptions()) {
            optionsText.add(option.getText().trim());
        }
        return optionsText;
    }

    public List<String> getAllSelectedOptions() {
        LogHelper.info("Getting all selected options from {}", description);
        List<String> selectedTexts = new ArrayList<>();
        for (WebElement option : select.getAllSelectedOptions()) {
            selectedTexts.add(option.getText().trim());
        }
        return selectedTexts;
    }
}

