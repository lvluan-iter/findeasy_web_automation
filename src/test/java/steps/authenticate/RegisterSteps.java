package steps.authenticate;

import configs.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class RegisterSteps {
    private final RegisterPage page;

    public RegisterSteps(TestContext context) {
        page = new RegisterPage(context.getUi());
    }

    @Given("Click on go to register page button")
    public void clickOnGoToRegisterPageButton() {
        page.goToRegister();
    }

    @When("Input the register username as {string}")
    public void inputTheRegisterUsernameAs(String name) {
        page.enterUsername(name);
    }


    @And("Input the register password as {string}")
    public void inputTheRegisterPasswordAs(String password) {
        page.enterPassword(password);
    }

    @And("Input the rewrite password as {string}")
    public void inputTheRewritePasswordAs(String rpassword) {
        page.enterRewritePassword(rpassword);
    }

    @And("Input the email as {string}")
    public void inputTheEmailAs(String mail) {
        page.enterEmail(mail);
    }

    @And("Input the fullname as {string}")
    public void inputTheFullnameAs(String fullname) {
        page.enterFullName(fullname);
    }

    @And("Select gender as {string}")
    public void selectGenderAs(String gender) {
        page.selectGender(gender);
    }

    @And("Input the birthdate as {string}")
    public void inputTheBirthdateAs(String day) {
        page.enterBirthdate(day);
    }

    @And("Input the phone number as {string}")
    public void inputThePhoneNumberAs(String phone) {
        page.enterPhone(phone);
    }
}
