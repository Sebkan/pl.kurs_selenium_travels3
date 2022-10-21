package pl.my_project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    @FindBy(name = "firstname")
    private WebElement firstName;
    @FindBy(name = "lastname")
    private WebElement lastName;
    @FindBy(name = "phone")
    private WebElement phone;
    @FindBy(name = "email")
    private WebElement email;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "confirmpassword")
    private WebElement confirmPassword;
    @FindBy(xpath = "//button[contains(text(),'Sign')]")
    private WebElement signUpButton;
    private WebDriver driver;
    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public RegisteredUserPage registerUser(String fName, String lName,String mobile, String emailAdress, String pass, String confPass) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        phone.sendKeys(mobile);
        email.sendKeys(emailAdress);
        password.sendKeys(pass);
        confirmPassword.sendKeys(confPass);
        return new RegisteredUserPage(driver);
    }

}
