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
import pages.HomePage;
import pages.LoginPage;
import utils.DataGenerateUtils;
import utils.JsonUtils;
import utils.Randomizer;

@Epic("Authentication")
@Feature("Login")
public class LoginTest {

    private LoginPage loginPage;
    private User user;
    private User admin;

    @BeforeClass
    public void setup() {
        user = JsonUtils.fromFileByKey(FrameworkConstants.ACCOUNT_JSON_PATH,
                UserRole.USER.getRoleName(), User.class);

        admin = JsonUtils.fromFileByKey(FrameworkConstants.ACCOUNT_JSON_PATH,
                UserRole.ADMIN.getRoleName(), User.class);
    }

    @BeforeMethod
    public void initPage() {
        UIActions action = new UIActions(DriverFactory.getDriver());
        HomePage home = new HomePage(action);

        loginPage = home.goToLoginPage();
    }

    @Test(testName = "Verify normal user can login successfully", groups = {"smoke"})
    @Severity(SeverityLevel.BLOCKER)
    public void userLoginSuccess() {
        loginPage.enterUsername(user.getUsername()).enterPassword(user.getPassword()).clickLogin();
        Asserts.assertEquals(loginPage.getToastMessage(), MessageConstants.LOGIN_SUCCESS,
                UIDescriptions.TOAST_MESSAGE);
    }

    @Test(testName = "Verify admin can login successfully", groups = {"smoke"})
    @Severity(SeverityLevel.BLOCKER)
    public void adminLoginSuccess() {
        HomePage homePage = loginPage.enterUsername(admin.getUsername())
                .enterPassword(admin.getPassword()).clickLogin();

        Asserts.assertEquals(homePage.getToastMessage(), MessageConstants.LOGIN_SUCCESS,
                UIDescriptions.TOAST_MESSAGE);

        Asserts.assertTrue(homePage.isAdminIconDisplayed(), UIDescriptions.ADMIN_ICON);
    }

    @Test(testName = "Verify user cannot login with invalid username", groups = {"functional"})
    @Severity(SeverityLevel.CRITICAL)
    public void loginFailWithInvalidUsername() {
        loginPage.enterUsername(Randomizer.randomAlphabets(5)).enterPassword(user.getPassword())
                .clickLogin();
        Asserts.assertEquals(loginPage.getToastMessage(),
                MessageConstants.LOGIN_INVALID_CREDENTIALS, UIDescriptions.TOAST_MESSAGE);
    }

    @Test(testName = "Verify user cannot login with invalid password", groups = {"functional"})
    @Severity(SeverityLevel.CRITICAL)
    public void loginFailWithInvalidPassword() {
        loginPage.enterUsername(user.getUsername()).enterPassword(DataGenerateUtils.password())
                .clickLogin();
        Asserts.assertEquals(loginPage.getToastMessage(),
                MessageConstants.LOGIN_INVALID_CREDENTIALS, UIDescriptions.TOAST_MESSAGE);
    }
}
