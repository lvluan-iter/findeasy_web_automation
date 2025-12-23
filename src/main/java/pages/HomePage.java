package pages;

import org.openqa.selenium.By;
import constants.UIDescriptions;
import core.actions.UIActions;

public class HomePage extends CommonPage {
    private final By goToLoginBtn = By.xpath("//button[.='Đăng nhập']");
    private final By goToProfileButton = By.xpath("// button[.//i[contains(@class, 'fa-user')]]");
    private final By adminIcon = By.id("admin-icon");

    public HomePage(UIActions ui) {
        super(ui);
    }

    public LoginPage goToLoginPage() {
        ui.element(goToLoginBtn, UIDescriptions.GO_TO_LOGIN_BTN).waitTillPresent().jsClick();
        return new LoginPage(ui);
    }

    public void goToUserProfile() {
        ui.element(goToProfileButton, UIDescriptions.GO_TO_PROFILE_BUTTON).waitTillPresent()
                .jsClick();
    }

    public boolean isAdminIconDisplayed() {
        return ui.element(adminIcon, UIDescriptions.ADMIN_ICON).waitTillVisible().isVisible();
    }
}
