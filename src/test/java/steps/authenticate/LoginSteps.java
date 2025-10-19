package steps.authenticate;

import configs.TestContext;
import constants.UIDescriptions;
import core.assertions.Asserts;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
    private final LoginPage page;

    public LoginSteps(TestContext context) {
        this.page = new LoginPage(context.getUi());
    }

    @When("Input the username as {string}")
    public void inputTheUsernameAs(String username) {
        page.enterUsername(username);
    }

    @When("Input the password as {string}")
    public void inputThePasswordAs(String password) {
        page.enterPassword(password);
    }


    @When("Click on login submit button")
    public void clickOnLoginSubmitButton() {
        page.clickLogin();
    }


    @Then("Verify success toast display message like {string}")
    public void verifySuccessToastDisplayMessageLike(String expectedMessage) {
        String actualMessage = page.getToastMessage();
        Asserts.assertEquals(actualMessage, expectedMessage, UIDescriptions.TOAST_MESSAGE);
    }

    @Given("Click on go to login page button")
    public void clickOnGoToLoginPageButton() {
        page.goToLoginPage();
    }

    @And("Verify admin icon is displayed")
    public void verifyAdminIconIsDisplayed() {
        Asserts.assertTrue(page.isAdminIconDisplayed(), UIDescriptions.ADMIN_ICON);
    }
}
