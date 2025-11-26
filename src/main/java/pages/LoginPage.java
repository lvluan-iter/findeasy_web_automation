package pages;

import constants.UIDescriptions;
import core.actions.UIActions;
import core.enums.WaitType;
import org.openqa.selenium.By;

public class LoginPage {
    private final UIActions ui;
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By btnLogin = By.xpath("//button[@type='submit']");
    private final By toastMessage = By.id("toast");
    private final By goToLoginBtn = By.xpath("//button[.='Đăng nhập']");
    private final By adminIcon = By.id("admin-icon");

    public LoginPage(UIActions ui) {
        this.ui = ui;
    }

    public void goToLoginPage() {
        ui.element(goToLoginBtn, UIDescriptions.GO_TO_LOGIN_BTN, WaitType.PRESENT).jsClick();
    }

    public void enterUsername(String username) {
        ui.input(usernameField, UIDescriptions.USERNAME_FIELD, WaitType.VISIBLE).fill(username);
    }

    public void enterPassword(String password) {
        ui.input(passwordField, UIDescriptions.PASSWORD_FIELD, WaitType.VISIBLE).fill(password);
    }

    public void clickLogin() {
        ui.element(btnLogin, UIDescriptions.LOGIN_BUTTON, WaitType.VISIBLE).click();
    }

    public String getToastMessage() {
        return ui.toast(toastMessage, UIDescriptions.TOAST_MESSAGE, WaitType.VISIBLE).getText();
    }

    public boolean isAdminIconDisplayed() {
        return ui.element(adminIcon, UIDescriptions.ADMIN_ICON, WaitType.VISIBLE).isVisible();
    }

    public void login(String username, String password) {
        goToLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}