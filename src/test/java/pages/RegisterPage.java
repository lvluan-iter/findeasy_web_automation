package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"register\"]/fieldset[1]/div[1]/div[1]/input")
    WebElement username;

    @FindBy(xpath = "//*[@id=\"register\"]/fieldset[1]/div[1]/div[2]/input")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"register\"]/fieldset[1]/div[2]/input")
    WebElement rewritePassword;

    @FindBy(xpath = "//*[@id=\"register\"]/fieldset[2]/div[1]/input")
    WebElement email;

    @FindBy(xpath = "//*[@id=\"register\"]/fieldset[2]/div[4]/input")
    WebElement phone;

    @FindBy(xpath = "//*[@id=\"register\"]/button")
    WebElement registerBtn;

    @FindBy(xpath = "//*[@id=\"register\"]/fieldset[2]/div[2]/input")
    WebElement nameField;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterUsername(String userName) {
        username.sendKeys(userName);
    }

    public void enterPassword(String passWord) {
        password.sendKeys(passWord);
    }

    public void enterRewritePassword(String rPassword) {
        rewritePassword.sendKeys(rPassword);
    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    public void enterFullName(String name) {
        nameField.sendKeys(name);
    }

    public void enterPhone(String phone) {
        this.phone.sendKeys(phone);
    }

    public void register(String username, String password, String rpassword, String email, String name, String phone) {
        enterUsername(username);
        enterPassword(password);
        enterRewritePassword(rpassword);
        enterEmail(email);
        enterFullName(name);
        enterPhone(phone);
        registerBtn.click();
    }
}
