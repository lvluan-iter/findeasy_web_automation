package core.actions;

import core.helper.LogHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertActions {

    private WebDriver driver;
    private Alert alert;
    private String description;

    public AlertActions(WebDriver driver) {
        this.driver = driver;
    }

    public AlertActions setAlert(String description) {
        this.alert = driver.switchTo().alert();
        this.description = description;
        LogHelper.info("Switched to alert: {}", description);
        return this;
    }

    public String accept() {
        LogHelper.info("Accepting alert: {}", description);
        String message = alert.getText().trim();
        alert.accept();
        LogHelper.info("Accepted alert with message: {}", message);
        return message;
    }

    public String dismiss() {
        LogHelper.info("Dismissing alert: {}", description);
        String message = alert.getText().trim();
        alert.dismiss();
        LogHelper.info("Dismissed alert with message: {}", message);
        return message;
    }

    public String acceptWithText(String inputText) {
        LogHelper.info("Accepting prompt alert '{}' with input: {}", description, inputText);
        String message = alert.getText().trim();
        alert.sendKeys(inputText);
        alert.accept();
        LogHelper.info("Accepted prompt alert with message: {}", message);
        return message;
    }

    public String getText() {
        String message = alert.getText().trim();
        LogHelper.info("Reading alert text: {} → {}", description, message);
        return message;
    }
}