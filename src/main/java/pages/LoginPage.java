package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"login\"]/div[3]/input")
    WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"login\"]/div[4]/input")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"login\"]/button")
    WebElement btnLogin;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
