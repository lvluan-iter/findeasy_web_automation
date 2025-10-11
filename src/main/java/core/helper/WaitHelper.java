package core.helper;

import constants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitHelper {

    private static final Duration WAIT_DURATION = Duration.ofSeconds(FrameworkConstants.WAIT_TIMEOUT);

    private WaitHelper() {
    }

    public static void visible(WebDriver driver, By locator, String description) {
        LogHelper.info("Waiting for visibility of element: {}", description);
        new WebDriverWait(driver, WAIT_DURATION).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void clickable(WebDriver driver, By locator, String description) {
        LogHelper.info("Waiting for element to be clickable: {}", description);
        new WebDriverWait(driver, WAIT_DURATION).until(ExpectedConditions.elementToBeClickable(locator));
    }
}