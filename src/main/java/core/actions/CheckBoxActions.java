package core.actions;

import core.helper.LogHelper;
import core.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxActions {
    private WebDriver driver;
    private WebElement element;
    private By locator;
    private String description;

    public CheckBoxActions(WebDriver driver) {
        this.driver = driver;
    }

    public CheckBoxActions setCheckBox(By locator, String description) {
        this.locator = locator;
        this.description = description;
        WaitHelper.visible(driver, this.locator, this.description);
        this.element = driver.findElement(locator);
        return this;
    }

    public CheckBoxActions check() {
        LogHelper.info("Checking " + description);
        if (!isChecked()) {
            element.click();
        }
        return this;
    }

    public CheckBoxActions uncheck() {
        LogHelper.info("Unchecking " + description);
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
