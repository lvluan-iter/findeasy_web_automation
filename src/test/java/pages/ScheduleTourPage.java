package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ScheduleTourPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@type='tel']")
    WebElement phone;

    @FindBy(xpath = "//input[@type='date']")
    WebElement date;

    @FindBy(xpath = "//input[@type='time']")
    WebElement time;

    @FindBy(xpath = "//input[@type='email']")
    WebElement email;

    @FindBy(xpath = "//button[contains(.,'Đặt')]")
    WebElement submitBtn;

    public ScheduleTourPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterPhoneNumber(String phone) {
        this.phone.sendKeys(phone);
    }

    public void enterDate(String date) {
        this.date.sendKeys(date);
    }

    public void enterTime(String time) {
        this.time.sendKeys(time);
    }

    public void enterEmail(String email) {
        this.email.sendKeys(email);
    }

    public void scheduleTour(String phone, String date, String time, String email) {
        enterPhoneNumber(phone);
        enterDate(date);
        enterTime(time);
        enterEmail(email);
        submitBtn.click();
    }
}

