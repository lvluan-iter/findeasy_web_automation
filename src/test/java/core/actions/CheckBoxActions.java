package core.actions;

import core.enums.WaitType;
import core.helper.LogHelper;
import core.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxActions {
    private WebDriver driver;
    private WebElement element;
    private String description;

    public CheckBoxActions(WebDriver driver) {
        this.driver = driver;
    }

    public CheckBoxActions setCheckBox(By locator, String description, WaitType type) {
        this.description = description;
        WaitHelper.apply(driver, locator, this.description, type);
        this.element = driver.findElement(locator);
        return this;
    }

    public CheckBoxActions check() {
        LogHelper.info("Checking {}", description);
        if (!isChecked()) {
            element.click();
        }
        return this;
    }

    public CheckBoxActions uncheck() {
        LogHelper.info("Unchecking {}", description);
        if (isChecked()) {
            element.click();
        }
        return this;
    }

    public boolean isChecked() {
        LogHelper.info("Checking status of " + description);
        return element.isSelected();
    }
}
