package core.helper;

import constants.FrameworkConstants;
import core.enums.WaitType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitHelper {

    public static WebElement apply(WebDriver driver, By locator, String description, WaitType type) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.WAIT_TIMEOUT));
        LogHelper.info("Wait for element : {}", description);
        switch (type) {
            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(locator));
            case PRESENT:
                return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            case INVISIBLE:
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
                return null;
            case NONE:
            default:
                return driver.findElement(locator);
        }
    }
}