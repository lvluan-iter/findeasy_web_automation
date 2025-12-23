package tests.authenticate;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import constants.FrameworkConstants;
import constants.MessageConstants;
import constants.UIDescriptions;
import core.actions.UIActions;
import core.assertions.Asserts;
import core.factory.DriverFactory;
import enums.UserRole;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.User;
import pages.ForgotPasswordPage;
import pages.HomePage;
import utils.JsonUtils;
import utils.Randomizer;

@Epic("Authentication")
@Feature("Forgot Password")
public class ForgotPasswordTest {

    private User user;
    private ForgotPasswordPage page;

    @BeforeClass
    public void loadData() {
        user = JsonUtils.fromFileByKey(FrameworkConstants.ACCOUNT_JSON_PATH,
                UserRole.USER.getRoleName(), User.class);
    }

    @BeforeMethod
    public void initPage() {
        HomePage home = new HomePage(new UIActions(DriverFactory.getDriver()));
        page = home.goToLoginPage().goToForgotPassword();
    }

    @Test(description = "Verify user can send forgot password request successfully",
            groups = {"smoke"})
    @Severity(SeverityLevel.BLOCKER)
    public void forgotPasswordSuccess() {
        page.enterEmail(user.getEmail()).clickSubmit();
        Asserts.assertEquals(page.getAlertMessage(), MessageConstants.FORGOT_PASSWORD_SUCCESS,
                UIDescriptions.ALERT_MESSAGE);
    }

    @Test(description = "Verify user cannot send forgot password request with email not exist",
            groups = {"functional"})
    @Severity(SeverityLevel.CRITICAL)
    public void forgotPasswordInvalidEmail() {
        page.enterEmail(Randomizer.randomEmail()).clickSubmit();
        Asserts.assertEquals(page.getAlertMessage(), MessageConstants.ERROR_OCCURED,
                UIDescriptions.ALERT_MESSAGE);
    }
}
