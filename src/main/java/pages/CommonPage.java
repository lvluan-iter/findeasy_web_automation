package pages;

import org.openqa.selenium.By;
import constants.UIDescriptions;
import core.actions.UIActions;

public class CommonPage {
    protected final UIActions ui;
    private final By toastMessage = By.id("toast");

    public CommonPage(UIActions ui) {
        this.ui = ui;
    }

    public String getToastMessage() {
        return ui.element(toastMessage, UIDescriptions.TOAST_MESSAGE).waitTillVisible().getText();
    }

    public String getAlertMessage() {
        return ui.alert(UIDescriptions.ALERT_MESSAGE).getText();
    }
}
