package pages;

import org.openqa.selenium.By;
import constants.UIDescriptions;
import core.actions.UIActions;

public class ForgotPasswordPage extends CommonPage {
    private final By email = By.id("email");
    private final By submitBtn = By.xpath("//button[@type='submit']");

    public ForgotPasswordPage(UIActions ui) {
        super(ui);
    }

    public ForgotPasswordPage enterEmail(String mail) {
        ui.element(email, UIDescriptions.EMAIL).waitTillVisible().fill(mail);
        return this;
    }

    public ForgotPasswordPage clickSubmit() {
        ui.element(submitBtn, UIDescriptions.SUBMIT_BTN).waitTillVisible().click();
        return this;
    }

    public void sendForgotPassword(String email) {
        enterEmail(email);
        clickSubmit();
    }
}
