package core.actions;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import constants.FrameworkConstants;
import core.helper.LogHelper;

public class AlertActions {

    private WebDriver driver;
    private Alert alert;
    private String description;

    public AlertActions(WebDriver driver, String description) {
        this.driver = driver;
        this.description = description;
    }

    public static AlertActions setAlert(WebDriver driver, String description) {
        return new AlertActions(driver, description);
    }

    public AlertActions waitAlertIsPresent() {
        LogHelper.info("Waiting till alert is present: {}", description);
        alert = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.WAIT_TIMEOUT))
                .until(ExpectedConditions.alertIsPresent());
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
