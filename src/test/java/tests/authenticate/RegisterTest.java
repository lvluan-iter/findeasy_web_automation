package tests.authenticate;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import api.AssertApiResponse;
import constants.MessageConstants;
import constants.UIDescriptions;
import core.actions.UIActions;
import core.assertions.Asserts;
import core.factory.DriverFactory;
import enums.HttpStatus;
import enums.UserRole;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import models.User;
import pages.HomePage;
import pages.RegisterPage;
import services.UserService;
import utils.DataGenerateUtils;

@Epic("Authentication")
@Feature("Register")
public class RegisterTest {
    private User guestData;
    private RegisterPage page;
    private boolean isRegistered = false;

    @BeforeMethod
    public void initPage() {
        UIActions action = new UIActions(DriverFactory.getDriver());
        HomePage home = new HomePage(action);

        page = home.goToLoginPage().goToRegister();

        guestData = User.builder().username(DataGenerateUtils.username())
                .password(DataGenerateUtils.password()).email(DataGenerateUtils.email())
                .fullname(DataGenerateUtils.fullName()).gender(DataGenerateUtils.gender())
                .birthdate(DataGenerateUtils.birthday().toString())
                .phoneNumber(DataGenerateUtils.phone()).build();
    }

    @Test(testName = "Verify guest can register successfully with full form 's field",
            groups = {"smoke"})
    @Severity(SeverityLevel.BLOCKER)
    public void userRegisterSuccess() {
        page.enterUsername(guestData.getUsername()).enterPassword(guestData.getPassword())
                .enterRewritePassword(guestData.getPassword()).enterEmail(guestData.getEmail())
                .enterFullName(guestData.getFullname()).selectGender(guestData.getGender())
                .enterBirthdate(guestData.getBirthdate()).enterPhone(guestData.getPhoneNumber())
                .clickRegister();

        Asserts.assertEquals(page.getToastMessage(), MessageConstants.REGISTER_SUCCESS,
                UIDescriptions.TOAST_MESSAGE);
        isRegistered = true;
    }

    @Test(testName = "Verify guest can register successfully with required form 's field",
            groups = {"smoke"})
    @Severity(SeverityLevel.BLOCKER)
    public void userRegisterWithRequiredFieldsOnly() {
        page.enterUsername(guestData.getUsername()).enterPassword(guestData.getPassword())
                .enterRewritePassword(guestData.getPassword()).enterEmail(guestData.getEmail())
                .enterFullName(guestData.getFullname()).enterPhone(guestData.getPhoneNumber())
                .clickRegister();

        Asserts.assertEquals(page.getToastMessage(), MessageConstants.REGISTER_SUCCESS,
                UIDescriptions.TOAST_MESSAGE);
        isRegistered = true;
    }

    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        if (!isRegistered)
            return;
        UserService service = UserService.init(UserRole.ADMIN);

        Response createdUserResponse =
                service.getUserByUsername(guestData.getUsername()).getResponse();
        User createdUser =
                AssertApiResponse.assertThat(createdUserResponse).succeeded().resultAs(User.class);

        if (createdUser != null) {
            Response deleteResponse = service.deleteUser(createdUser.getId()).getResponse();
            AssertApiResponse.assertThat(deleteResponse).status(HttpStatus.NO_CONTENT);
            isRegistered = false;
        }
    }
}
