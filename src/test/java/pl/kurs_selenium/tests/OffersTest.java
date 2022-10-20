package pl.kurs_selenium.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.kurs_selenium.pages.HomePage;
import pl.kurs_selenium.pages.OffersPage;

import java.util.List;

public class OffersTest extends BaseTest{
    @Test
    public void checkOffersTest() {
       List<WebElement> headerNames = new HomePage(driver).goToOffers()
               .getHeaders();
       Assert.assertTrue(headerNames.size() == 7);
    }
}
