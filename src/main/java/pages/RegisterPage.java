package pages;

import org.openqa.selenium.By;
import constants.UIDescriptions;
import core.actions.UIActions;

public class RegisterPage extends CommonPage {
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
        super(ui);
    }

    public RegisterPage enterUsername(String name) {
        ui.element(this.username, UIDescriptions.USERNAME_FIELD).waitTillVisible().fill(name);
        return this;
    }

    public RegisterPage enterPassword(String pass) {
        ui.element(password, UIDescriptions.PASSWORD_FIELD).waitTillVisible().fill(pass);
        return this;
    }

    public RegisterPage enterRewritePassword(String rpass) {
        ui.element(rewritePassword, UIDescriptions.REWRITE_PASSWORD).waitTillVisible().fill(rpass);
        return this;
    }

    public RegisterPage enterEmail(String mail) {
        ui.element(email, UIDescriptions.EMAIL).waitTillVisible().fill(mail);
        return this;
    }

    public RegisterPage enterFullName(String name) {
        ui.element(fullname, UIDescriptions.FULLNAME).waitTillVisible().fill(name);
        return this;
    }

    public RegisterPage selectGender(String gender) {
        ui.element(this.gender, UIDescriptions.GENDER).waitTillVisible()
                .selectByVisibleText(gender);
        return this;
    }

    public RegisterPage enterBirthdate(String birthday) {
        ui.element(birthdate, UIDescriptions.BIRTHDATE).waitTillVisible().fill(birthday);
        return this;
    }

    public RegisterPage enterPhone(String phoneNumber) {
        ui.element(phone, UIDescriptions.PHONE_NUMBER).waitTillVisible().fill(phoneNumber);
        return this;
    }

    public LoginPage clickRegister() {
        ui.element(registerBtn, UIDescriptions.REGISTER_BTN).waitTillVisible().click();
        return new LoginPage(ui);
    }

    public void register(String username, String password, String rpassword, String email,
            String name, String phone) {
        enterUsername(username);
        enterPassword(password);
        enterRewritePassword(rpassword);
        enterEmail(email);
        enterFullName(name);
        enterPhone(phone);
        clickRegister();
    }
}
