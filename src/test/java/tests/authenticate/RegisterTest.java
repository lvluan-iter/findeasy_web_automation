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
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.User;
import pages.RegisterPage;


@Epic("Authentication")
@Feature("Register")
public class RegisterTest {

    private User guestData;
    private RegisterPage register;

    @BeforeClass
    public void loadData() {
        guestData = JsonReader.readJsonByKey(FrameworkConstants.ACCOUNT_JSON_PATH, User.class,
                UserRole.GUEST.getRoleName());
    }

    @BeforeMethod
    public void initPage() {
        register = new RegisterPage(new UIActions(DriverFactory.getDriver()));
        register.goToRegister();
    }

    @Test(description = "Verify guest can register successfully with full form 's field",
            groups = {"smoke"})
    @Severity(SeverityLevel.BLOCKER)
    public void userRegisterSuccess() {
        register.register(guestData.getUsername(), guestData.getPassword(), guestData.getPassword(),
                guestData.getEmail(), guestData.getFullname(), guestData.getGender(),
                guestData.getBirthdate(), guestData.getPhoneNumber());
        Asserts.assertEquals(register.getToastMessage(), MessageConstants.REGISTER_SUCCESS,
                UIDescriptions.TOAST_MESSAGE);
    }

    // -----------------------------------------------------------
    // 2. USERNAME ALREADY EXISTS
    // -----------------------------------------------------------
    @Test(description = "Verify register fails when username already exists",
            groups = {"functional"})
    @Severity(SeverityLevel.CRITICAL)
    public void registerFailUsernameExists() {

        Allure.step("Fill form with existing username");
        register.enterUsername(guestData.getUsername()); // từ JSON
        register.enterPassword(guestData.getPassword());
        register.enterRewritePassword(guestData.getPassword());

        // random email để tránh email trùng
        register.enterEmail("exists_" + Randomizer.randomAlphaNumeric(6) + "@gmail.com");

        register.enterFullName("User Exists");
        register.enterPhone("0911222333");

        Allure.step("Click register button");
        register.clickRegister();

        Allure.step("Verify username exists message");
        Asserts.assertEquals(register.getToastMessage(), MessageConstants.REGISTER_USERNAME_EXISTS,
                UIDescriptions.TOAST_MESSAGE);
    }

    // -----------------------------------------------------------
    // 3. PASSWORD MISMATCH
    // -----------------------------------------------------------
    @Test(description = "Verify register fails when passwords do not match",
            groups = {"functional"})
    @Severity(SeverityLevel.CRITICAL)
    public void registerFailPasswordMismatch() {

        String username = "guest_" + Randomizer.randomAlphaNumeric(6);
        String email = "guest_" + Randomizer.randomAlphaNumeric(6) + "@gmail.com";

        Allure.step("Fill form with mismatched passwords");
        register.enterUsername(username);
        register.enterPassword("Pass@1234");
        register.enterRewritePassword("Pass@9999"); // ❌ mismatch

        register.enterEmail(email);
        register.enterFullName("Mismatch User");
        register.enterPhone("0911002200");

        Allure.step("Click register button");
        register.clickRegister();

        Allure.step("Verify password mismatch message");
        Asserts.assertEquals(register.getToastMessage(),
                MessageConstants.REGISTER_PASSWORD_NOT_MATCH, UIDescriptions.TOAST_MESSAGE);
    }
}
