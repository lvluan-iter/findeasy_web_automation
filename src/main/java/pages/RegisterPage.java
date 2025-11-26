package pages;

import org.openqa.selenium.By;
import constants.UIDescriptions;
import core.actions.UIActions;
import core.enums.WaitType;

public class RegisterPage {
    private UIActions ui;

    By goToRegister = By.xpath("//a[contains(., 'Đăng ký')]");
    By username = By.id("username");
    By password = By.id("password");
    By rewritePassword = By.id("rewritepassword");
    By email = By.id("email");
    By fullname = By.id("fullname");
    By gender = By.id("gender");
    By birthdate = By.id("birthdate");
    By phone = By.id("phoneNumber");
    By registerBtn = By.xpath("//button[@type='submit']");

    public RegisterPage(UIActions ui) {
        this.ui = ui;
    }

    public void goToRegister() {
        ui.element(goToRegister, UIDescriptions.GO_TO_REGISTER, WaitType.VISIBLE).click();
    }

    public void enterUsername(String name) {
        ui.input(this.username, UIDescriptions.USERNAME_FIELD, WaitType.VISIBLE).fill(name);
    }

    public void enterPassword(String pass) {
        ui.input(password, UIDescriptions.PASSWORD_FIELD, WaitType.VISIBLE).fill(pass);
    }

    public void enterRewritePassword(String rpass) {
        ui.input(rewritePassword, UIDescriptions.REWRITE_PASSWORD, WaitType.VISIBLE).fill(rpass);
    }

    public void enterEmail(String mail) {
        ui.input(email, UIDescriptions.EMAIL, WaitType.VISIBLE).fill(mail);
    }

    public void enterFullName(String name) {
        ui.input(fullname, UIDescriptions.FULLNAME, WaitType.VISIBLE).fill(name);
    }

    public void selectGender(String gender) {
        ui.dropdown(this.gender, UIDescriptions.GENDER, WaitType.VISIBLE)
                .selectByVisibleText(gender);
    }

    public void enterBirthdate(String birthday) {
        ui.input(birthdate, UIDescriptions.BIRTHDATE, WaitType.VISIBLE).fill(birthday);
    }

    public void enterPhone(String phoneNumber) {
        ui.input(phone, UIDescriptions.PHONE_NUMBER, WaitType.VISIBLE).fill(phoneNumber);
    }

    public void clickRegister() {
        ui.element(registerBtn, UIDescriptions.REGISTER_BTN, WaitType.CLICKABLE).click();
    }

    public void register(String username, String password, String rpassword, String email,
            String name, String gender, String birthday, String phone) {
        enterUsername(username);
        enterPassword(password);
        enterRewritePassword(rpassword);
        enterEmail(email);
        enterFullName(name);
        selectGender(gender);
        enterBirthdate(birthday);
        enterPhone(phone);
        clickRegister();
    }
}
