package pl.my_project.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.my_project.pages.HomePage;
import pl.my_project.utils.SeleniumHelper;

import java.io.IOException;
import java.util.List;

public class CurrencyTest extends BaseTest{

    @Test
    public void currencyChangeTest() throws IOException {
        ExtentTest test = extentReports.createTest("Currency Change Test");
        String currency = "usd";
        test.log(Status.PASS,"Default currency displayed",SeleniumHelper.getScreenshot(driver));
        List<WebElement> currencyNames = new HomePage(driver)
                .chooseCurrency(driver,currency)
                .getCurrencyName(currency);
        Assert.assertTrue(currencyNames.size() > 0);
        test.log(Status.PASS,"Currency changed successfully, display of new currency updated", SeleniumHelper.getScreenshot(driver));
    }
}
