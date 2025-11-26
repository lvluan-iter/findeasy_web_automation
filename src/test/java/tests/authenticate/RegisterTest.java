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
    private RegisterPage page;

    @BeforeClass
    public void loadData() {
        guestData = JsonReader.readJsonByKey(FrameworkConstants.ACCOUNT_JSON_PATH, User.class,
                UserRole.GUEST.getRoleName());
    }

    @BeforeMethod
    public void initPage() {
        page = new RegisterPage(new UIActions(DriverFactory.getDriver()));
        page.goToRegister();
    }

    @Test(description = "Verify guest can register successfully with full form 's field",
            groups = {"smoke"})
    @Severity(SeverityLevel.BLOCKER)
    public void userRegisterSuccess() {
        page.enterUsername(guestData.getUsername());
        page.enterPassword(guestData.getPassword());
        page.enterRewritePassword(guestData.getPassword());
        page.enterEmail(guestData.getEmail());
        page.enterFullName(guestData.getFullname());
        page.selectGender(guestData.getGender());
        page.enterBirthdate(guestData.getBirthdate());
        page.enterPhone(guestData.getPhoneNumber());
        page.clickRegister();

        Asserts.assertEquals(page.getToastMessage(), MessageConstants.REGISTER_SUCCESS,
                UIDescriptions.TOAST_MESSAGE);
    }
}
