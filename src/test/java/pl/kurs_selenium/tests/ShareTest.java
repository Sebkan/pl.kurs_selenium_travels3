package pl.kurs_selenium.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.kurs_selenium.pages.HomePage;
import pl.kurs_selenium.utils.SeleniumHelper;

import java.io.IOException;

public class ShareTest extends BaseTest {
    @Test
    public void shareHotelTest() throws IOException {
        ExtentTest test = extentReports.createTest("Choosing and sharing the hotel details");
        WebElement details = new HomePage(driver)
                .bookHotel("Oasis")
                .shareHotelVia("messenger")
                .getDetailsText();
        test.log(Status.PASS,"Hotel and sharing method correctly chosen", SeleniumHelper.getScreenshot(driver));
        Assert.assertEquals(details.getText(),"DETAILS");
    }
}
