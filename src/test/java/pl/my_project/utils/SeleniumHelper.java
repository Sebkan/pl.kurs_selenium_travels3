package pl.my_project.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SeleniumHelper {
    private static WebDriverWait wait;
    public static MediaEntityModelProvider getScreenshot (WebDriver driver) throws IOException {
        return MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver)).build();
    }
    private static String takeScreenshot(WebDriver driver) throws IOException {
        int randomNumber = (int)(Math.random()*100);
        String path = "src/test/resources/screenshots/screenshot"+randomNumber+".png";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File(path));
        return path;
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForElementToBeClickable(WebDriver driver, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitForVisibility(WebDriver driver, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void waitForPresence(WebDriver driver, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static void waitForVisibility(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
