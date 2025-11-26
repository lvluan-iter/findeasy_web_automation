package pages;

import org.openqa.selenium.By;
import constants.UIDescriptions;
import core.actions.UIActions;
import core.enums.WaitType;

public class CommonPage {
    protected final UIActions ui;
    private final By toastMessage = By.id("toast");

    public CommonPage(UIActions ui) {
        this.ui = ui;
    }

    public String getToastMessage() {
        return ui.toast(toastMessage, UIDescriptions.TOAST_MESSAGE, WaitType.VISIBLE).getText();
    }
}
