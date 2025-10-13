package pages;

import constants.UIDescriptions;
import core.actions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
    private final UIActions ui;
    private final By usernameField = By.xpath("//*[@id=\"login\"]/div[3]/input");
    private final By passwordField = By.xpath("//*[@id=\"login\"]/div[4]/input");
    private final By btnLogin = By.xpath("//*[@id=\"login\"]/button");

    public LoginPage(UIActions ui) {
        this.ui = ui;
    }

    @Step("Enter username: {username}")
    public void enterUsername(String username) {
        ui.input(usernameField, UIDescriptions.USERNAME_FIELD).fill(username);
    }

    @Step("Enter password: {password}")
    public void enterPassword(String password) {
        ui.input(passwordField, UIDescriptions.PASSWORD_FIELD).fill(password);
    }

    @Step("Click login button")
    public void clickLogin() {
        ui.element(btnLogin, UIDescriptions.LOGIN_BUTTON).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}