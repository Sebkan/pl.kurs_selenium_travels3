package pl.my_project.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.my_project.pages.HomePage;

import java.util.List;

public class OffersTest extends BaseTest{
    @Test
    public void checkOffersTest() {
       List<WebElement> headerNames = new HomePage(driver).goToOffers()
               .getHeaders();
       Assert.assertTrue(headerNames.size() == 7);
    }
}
