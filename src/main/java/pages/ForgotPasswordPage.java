package pages;

import org.openqa.selenium.By;
import constants.UIDescriptions;
import core.actions.UIActions;
import core.enums.WaitType;

public class ForgotPasswordPage extends CommonPage {
    private final By email = By.id("email");
    private final By submitBtn = By.xpath("//button[@type='submit']");
    private final By goToForgot = By.xpath("//a[contains(., 'Quên mật khẩu')]");

    public ForgotPasswordPage(UIActions ui) {
        super(ui);
    }

    public void goToForgotPassword() {
        ui.element(goToForgot, UIDescriptions.GO_TO_FORGOT_PASSWORD, WaitType.VISIBLE).click();
    }

    public void enterEmail(String mail) {
        ui.input(email, UIDescriptions.EMAIL, WaitType.VISIBLE).fill(mail);
    }

    public void clickSubmit() {
        ui.element(submitBtn, UIDescriptions.SUBMIT_BTN, WaitType.CLICKABLE).click();
    }

    public void sendForgotPassword(String email) {
        enterEmail(email);
        clickSubmit();
    }
}
