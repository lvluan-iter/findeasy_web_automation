package core.utils;

import core.helper.LogHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class TestUtils {

    public static byte[] takeScreenShot(WebDriver driver, String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            File destFile = new File("screenshots/" + fileName + ".png");
            destFile.getParentFile().mkdirs();
            FileHandler.copy(srcFile, destFile);
            LogHelper.info("Screenshot saved: {}", destFile.getAbsolutePath());

            return ts.getScreenshotAs(OutputType.BYTES);

        } catch (IOException e) {
            LogHelper.error("Could not save screenshot: {}", e.getMessage());
            return new byte[0];
        } catch (Exception e) {
            LogHelper.error("Failed to capture screenshot: {}", e.getMessage());
            return new byte[0];
        }
    }
}
