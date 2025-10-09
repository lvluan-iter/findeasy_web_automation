package core.actions;

import core.logger.LogHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertActions {

    private WebDriver driver;
    private String description;

    public AlertActions(WebDriver driver) {
        this.driver = driver;
    }

    public AlertActions setDescription(String description) {
        this.description = description;
        return this;
    }

    private Alert getAlert() {
        try {
            return driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            LogHelper.error("No alert found while handling: {}", e, description);
            throw e;
        }
    }

    public String accept() {
        LogHelper.info("Accepting alert: {}", description);
        Alert alert = getAlert();
        String message = alert.getText().trim();
        alert.accept();
        LogHelper.info("Accepted alert with message: {}", message);
        return message;
    }

    public String dismiss() {
        LogHelper.info("Dismissing alert: {}", description);
        Alert alert = getAlert();
        String message = alert.getText().trim();
        alert.dismiss();
        LogHelper.info("Dismissed alert with message: {}", message);
        return message;
    }

    public String acceptWithText(String inputText) {
        LogHelper.info("Accepting prompt alert '{}' with input: {}", description, inputText);
        Alert alert = getAlert();
        String message = alert.getText().trim();
        alert.sendKeys(inputText);
        alert.accept();
        LogHelper.info("Accepted prompt alert with message: {}", message);
        return message;
    }

    public String getText() {
        Alert alert = getAlert();
        String message = alert.getText().trim();
        LogHelper.info("Reading alert text: {} → {}", description, message);
        return message;
    }
}