package pl.kurs_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserPage {
    private WebDriver driver;
    public RegisteredUserPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
}
