package core.actions;

import core.helper.LogHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class UIActions {

    private WebDriver driver;
    private Actions actions;

    public UIActions(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void gotoUrl(String url, String description) {
        LogHelper.info("Navigating to: " + description);
        driver.get(url);
    }

    public void refreshPage() {
        LogHelper.info("Refreshing page");
        driver.navigate().refresh();
    }

    public void goBack() {
        LogHelper.info("Navigating back");
        driver.navigate().back();
    }

    public void goForward() {
        LogHelper.info("Navigating forward");
        driver.navigate().forward();
    }

    public void keyPress(CharSequence key, String description) {
        LogHelper.info("Pressing key: " + description);
        actions.sendKeys(key).perform();
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        LogHelper.info("Getting page title: " + title);
        return title;
    }

    public ElementActions element(By locator, String desc) {
        return new ElementActions(driver).setElement(locator, desc);
    }

    public InputActions input(By locator, String desc) {
        return new InputActions(driver).setInput(locator, desc);
    }

    public DropDownActions dropdown(By locator, String desc) {
        return new DropDownActions(driver).setDropDown(locator, desc);
    }

    public CheckBoxActions checkbox(By locator, String desc) {
        return new CheckBoxActions(driver).setCheckBox(locator, desc);
    }

    public AlertActions alert(String desc) {
        return new AlertActions(driver).setAlert(desc);
    }
}
