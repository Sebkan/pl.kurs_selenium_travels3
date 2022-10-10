package pl.kurs_selenium.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pl.kurs_selenium.utils.DriverFactory;

public class BaseTest {
    private WebDriver driver;
    private ExtentHtmlReporter extentHtmlReporter;
    private ExtentReports extentReports;
    @BeforeSuite
    public void beforeSuite() {
        extentHtmlReporter = new ExtentHtmlReporter("index.html");
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
        driver.get("https://kurs-selenium.pl");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
