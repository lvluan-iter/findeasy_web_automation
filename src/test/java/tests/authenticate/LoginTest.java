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
import pages.LoginPage;

@Epic("Authentication")
@Feature("Login")
public class LoginTest {
    private LoginPage page;
    private User normalUser;
    private User adminUser;

    @BeforeClass
    public void setup() {
        normalUser = JsonReader.readJsonByKey(FrameworkConstants.ACCOUNT_JSON_PATH, User.class,
                UserRole.USER.getRoleName());

        adminUser = JsonReader.readJsonByKey(FrameworkConstants.ACCOUNT_JSON_PATH, User.class,
                UserRole.ADMIN.getRoleName());
    }

    @BeforeMethod
    public void initPage() {
        page = new LoginPage(new UIActions(DriverFactory.getDriver()));
        page.goToLoginPage();
    }

    @Test(description = "Verify normal user can login successfully", groups = {"smoke"})
    @Severity(SeverityLevel.BLOCKER)
    public void userLoginSuccess() {
        page.login(normalUser.getUsername(), normalUser.getPassword());
        Asserts.assertEquals(page.getToastMessage(), MessageConstants.LOGIN_SUCCESS,
                UIDescriptions.TOAST_MESSAGE);
    }

    @Test(description = "Verify admin can login successfully", groups = {"smoke"})
    @Severity(SeverityLevel.BLOCKER)
    public void adminLoginSuccess() {
        page.login(adminUser.getUsername(), adminUser.getPassword());
        Asserts.assertEquals(page.getToastMessage(), MessageConstants.LOGIN_SUCCESS,
                UIDescriptions.TOAST_MESSAGE);
        Asserts.assertTrue(page.isAdminIconDisplayed(), UIDescriptions.ADMIN_ICON);
    }

    @Test(description = "Verify user cannot login with invalid username", groups = {"functional"})
    @Severity(SeverityLevel.CRITICAL)
    public void loginFailWithInvalidUsername() {
        page.login(Randomizer.randomAlphaNumeric(5), normalUser.getPassword());
        Asserts.assertEquals(page.getToastMessage(), MessageConstants.LOGIN_INVALID_CREDENTIALS,
                UIDescriptions.TOAST_MESSAGE);
    }

    @Test(description = "Verify user cannot login with invalid password", groups = {"functional"})
    @Severity(SeverityLevel.CRITICAL)
    public void loginFailWithInvalidPassword() {
        page.login(normalUser.getUsername(), Randomizer.randomAlphaNumeric(8));
        Asserts.assertEquals(page.getToastMessage(), MessageConstants.LOGIN_INVALID_CREDENTIALS,
                UIDescriptions.TOAST_MESSAGE);
    }
}
