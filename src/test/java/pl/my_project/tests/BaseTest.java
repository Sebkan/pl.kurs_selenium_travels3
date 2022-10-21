package pl.my_project.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pl.my_project.utils.DriverFactory;

public class BaseTest {
    public WebDriver driver;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentReports extentReports;
    @BeforeSuite
    public void beforeSuite() {
        extentHtmlReporter = new ExtentHtmlReporter("SharingHotelTest.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
    }
    @AfterSuite
    public void afterSuite() {
        extentHtmlReporter.flush();
        extentReports.flush();
    }
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://kurs-selenium.pl");
    }
    @AfterMethod
    public void tearDown() {
       driver.quit();
    }
}
