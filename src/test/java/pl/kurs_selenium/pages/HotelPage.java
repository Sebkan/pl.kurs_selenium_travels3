package pl.kurs_selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.kurs_selenium.utils.SeleniumHelper;

import java.util.Set;

public class HotelPage {
    @FindBy(xpath = "//img[@alt='sharethis sharing button']")
    private WebElement shareButton;
    @FindBy(xpath = "//div[text()='Details']")
    private WebElement detailsText;
    private WebDriver driver;
    private static Logger logger = LogManager.getLogger();
    public HotelPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public HotelPage shareHotelVia(String application) {
        logger.info("Clicking the share button");
        String xpath = String.format("//div[@data-network='%s']",application);
        try{
            driver.findElement(By.xpath(xpath)).click();
        } catch (NoSuchElementException e) {
            shareButton.click();
            SeleniumHelper.waitForElementToBeClickable(driver, By.xpath(xpath));
            driver.findElement(By.xpath(xpath)).click();
        }
        logger.info("Share button clicked");
        logger.info("Switching to the new window");
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows){
                if(!window.equals(originalWindow)){
                    driver.switchTo().window(window);
                }
        }
        logger.info("Switching to the new window completed");
        logger.info("Closing the window");
        driver.close();
        logger.info("Window closed, switching to the original window");
        driver.switchTo().window(originalWindow);
        logger.info("Switching to the original window completed");
        return this;
    }
    public WebElement getDetailsText() {
        return detailsText;
    }

}
