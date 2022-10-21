package pl.my_project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OffersPage {
    @FindBy(xpath = "//h4[@class='ellipsis bold mb0 go-right RTL']")
    private List<WebElement> offersHeaders;

    private WebDriver driver;
    public OffersPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public List<WebElement> getHeaders() {
        return offersHeaders;

    }
}
