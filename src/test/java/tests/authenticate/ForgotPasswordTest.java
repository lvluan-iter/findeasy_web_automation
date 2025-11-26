package tests.authenticate;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import constants.FrameworkConstants;
import constants.MessageConstants;
import constants.UIDescriptions;
import core.actions.UIActions;
import core.assertions.Asserts;
import core.enums.UserRole;
import core.factory.DriverFactory;
import core.utils.JsonReader;
import core.utils.Randomizer;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.User;
import pages.ForgotPasswordPage;

@Epic("Authentication")
@Feature("Forgot Password")
public class ForgotPasswordTest {

    private User normalUser;
    private ForgotPasswordPage page;

    @BeforeClass
    public void loadData() {
        normalUser = JsonReader.readJsonByKey(FrameworkConstants.ACCOUNT_JSON_PATH, User.class,
                UserRole.USER.getRoleName());
    }

    @BeforeMethod
    public void initPage() {
        page = new ForgotPasswordPage(new UIActions(DriverFactory.getDriver()));
        page.goToForgotPassword();
    }

    @Test(description = "Verify user can send forgot password request successfully",
            groups = {"smoke"})
    @Severity(SeverityLevel.BLOCKER)
    public void forgotPasswordSuccess() {
        page.sendForgotPassword(normalUser.getEmail());
        Asserts.assertEquals(page.getAlertMessage(), MessageConstants.FORGOT_PASSWORD_SUCCESS,
                UIDescriptions.ALERT_MESSAGE);
    }

    @Test(description = "Verify user cannot send forgot password request with email not exist",
            groups = {"functional"})
    @Severity(SeverityLevel.CRITICAL)
    public void forgotPasswordInvalidEmail() {
        page.sendForgotPassword(Randomizer.randomEmail());
        Asserts.assertEquals(page.getAlertMessage(), MessageConstants.EMAIL_NOT_EXIST_MESSAGE,
                UIDescriptions.ALERT_MESSAGE);
    }
}
