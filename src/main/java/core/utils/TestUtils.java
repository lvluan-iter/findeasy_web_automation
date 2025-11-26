package core.utils;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TestUtils {

    public static byte[] takeScreenShot(WebDriver driver, String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            File destFile = new File("screenshots/" + fileName + ".png");
            destFile.getParentFile().mkdirs();
            FileHandler.copy(srcFile, destFile);

            return ts.getScreenshotAs(OutputType.BYTES);

        } catch (Exception e) {
            return new byte[0];
        }
    }
}
