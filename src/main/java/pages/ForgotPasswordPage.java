package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[2]/form/div/input")
    WebElement email;

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[2]/form/button")
    WebElement submitBtn;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterEmail(String email) {
        this.email.sendKeys(email);
    }

    public void sendForgotPassword(String email) {
        enterEmail(email);
        submitBtn.click();
    }
}
