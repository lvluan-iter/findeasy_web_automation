package core.actions;

import core.enums.WaitType;
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

    public ElementActions element(By locator, String desc, WaitType type) {
        return new ElementActions(driver).setElement(locator, desc, type);
    }

    public InputActions input(By locator, String desc, WaitType type) {
        return new InputActions(driver).setInput(locator, desc, type);
    }

    public DropDownActions dropdown(By locator, String desc, WaitType type) {
        return new DropDownActions(driver).setDropDown(locator, desc, type);
    }

    public CheckBoxActions checkbox(By locator, String desc, WaitType type) {
        return new CheckBoxActions(driver).setCheckBox(locator, desc, type);
    }

    public AlertActions alert(String desc) {
        return new AlertActions(driver).setAlert(desc);
    }

    public ToastActions toast(By locator, String desc, WaitType type) {
        return new ToastActions(driver).setToast(locator, desc, type);
    }
}
