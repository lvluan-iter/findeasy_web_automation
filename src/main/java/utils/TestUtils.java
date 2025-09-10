package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class TestUtils {

    public static void takeScreenShot(WebDriver driver, String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshots/" + fileName + ".png");
        destFile.getParentFile().mkdirs();

        try {
            FileHandler.copy(srcFile, destFile);
            System.out.println("📸 Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("❌ Could not save screenshot", e);
        }


    }
}
