package pl.kurs_selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.kurs_selenium.utils.SeleniumHelper;

import java.util.List;

public class HomePage {
    @FindBy(xpath = "//i[@class='icon-money-2 go-right']")
    private List<WebElement> currencyLink;
    @FindBy(xpath = "//a[@class='loader wow animated']")
    private List<WebElement> bookNowButton;
    @FindBy(xpath = "//a[contains(text(),'Offers')]")
    private WebElement offersButton;
    @FindBy(xpath = "//a[text()=' My Account ']")
    private List<WebElement> myAccountLink;
    @FindBy(xpath = "//a[text()='  Sign Up']")
    private List<WebElement> signUpLink;
    private static Logger logger = LogManager.getLogger();
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public HomePage chooseCurrency(WebDriver driver, String currency) {
        logger.info("Moving the mouse over the currency icon");
        currencyLink.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent( e-> {
                    Actions actions = new Actions(driver);
                    actions.moveToElement(e).perform();
                });
        logger.info("Waiting for the currency list to appear");
        String xpath = String.format("//li//a[contains(text(),'%s')]",currency.toUpperCase());
        SeleniumHelper.waitForPresence(driver,By.xpath(xpath));
        driver.findElements(By.xpath(xpath)).stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        logger.info("Click on the currency performed");
        return this;
    }
    public List<WebElement> getCurrencyName(String currency) {
        String xpath = String.format("//h3//small[contains(text(),'%s')]",currency.toUpperCase());
        SeleniumHelper.waitForVisibility(driver,By.xpath(xpath));
        return driver.findElements(By.xpath(xpath));
    }
    public HotelPage bookHotel(String name) {
        logger.info("Start to move mouse over a chosen hotel name");
        String xpath = String.format("//h4[contains(text(),'%s')]",name);
        WebElement hotel = driver.findElement(By.xpath(xpath));
        Actions actions = new Actions(driver);
        actions.moveToElement(hotel).perform();
        logger.info("Clicking the chosen Book Now button");
        bookNowButton.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        logger.info("Button clicked");
        return new HotelPage(driver);
    }
    public OffersPage goToOffers() {
        offersButton.click();
        return new OffersPage(driver);
    }
    public SignUpPage signUp(){
        myAccountLink.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        signUpLink.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        return new SignUpPage(driver);
    }

}
