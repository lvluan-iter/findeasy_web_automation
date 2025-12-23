package pages;

import org.openqa.selenium.By;
import constants.UIDescriptions;
import core.actions.UIActions;

public class LoginPage extends CommonPage {
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By btnLogin = By.xpath("//button[@type='submit']");
    private final By goToRegister = By.xpath("//a[contains(., 'Đăng ký')]");
    private final By goToForgot = By.xpath("//a[contains(., 'Quên mật khẩu')]");

    public LoginPage(UIActions ui) {
        super(ui);
    }

    public RegisterPage goToRegister() {
        ui.element(goToRegister, UIDescriptions.GO_TO_REGISTER).waitTillVisible().click();
        return new RegisterPage(ui);
    }

    public ForgotPasswordPage goToForgotPassword() {
        ui.element(goToForgot, UIDescriptions.GO_TO_FORGOT_PASSWORD).waitTillVisible().click();
        return new ForgotPasswordPage(ui);
    }

    public LoginPage enterUsername(String username) {
        ui.element(usernameField, UIDescriptions.USERNAME_FIELD).waitTillVisible().fill(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        ui.element(passwordField, UIDescriptions.PASSWORD_FIELD).waitTillVisible().fill(password);
        return this;
    }

    public HomePage clickLogin() {
        ui.element(btnLogin, UIDescriptions.LOGIN_BUTTON).waitTillVisible().click();
        return new HomePage(ui);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
