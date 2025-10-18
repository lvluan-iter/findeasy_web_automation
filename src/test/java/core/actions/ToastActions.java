package core.actions;

import core.enums.WaitType;
import core.helper.LogHelper;
import core.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToastActions {
    private WebDriver driver;
    private WebElement toastElement;
    private String description;

    public ToastActions(WebDriver driver) {
        this.driver = driver;
    }

    public ToastActions setToast(By locator, String description, WaitType type) {
        this.description = description;
        WaitHelper.apply(driver, locator, description, type);
        this.toastElement = driver.findElement(locator);
        return this;
    }

    public String getText() {
        String message = toastElement.getText().trim();
        LogHelper.info("Text of {} is: {}", description, message);
        return message;
    }
}