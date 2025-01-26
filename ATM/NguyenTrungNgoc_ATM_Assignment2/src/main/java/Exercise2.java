import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

//Exercise 2:
//Create Automation Script to test Shopee web page on Chrome.
//Step 1: Open browser Chrome
//Step 2: Navigate to https://www.lazada.vn/
//Step 3: Click to the “LazMall”
//Step 4: Verify screen should be display Search textbox, Search Button.

public class Exercise2 {
    @Test
    public void TestExercise2() throws MalformedURLException, InterruptedException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("UiAutomator2");

        uiAutomator2Options.setUdid("R3CW50NTNBN");
        //uiAutomator2Options.setUdid("R5CW229EAYR");

        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setCapability(CapabilityType.BROWSER_NAME,"chrome");

        //ver128
        uiAutomator2Options.setChromedriverExecutable("C:\\Users\\nhung\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        //ver129:
        //uiAutomator2Options.setChromedriverExecutable("C:\\Users\\Admin\\Downloads\\chromedriver-ver129\\chromedriver-win64\\chromedriver.exe");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://localhost:4723"), uiAutomator2Options);
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(20));

        androidDriver.get("https://www.lazada.vn/");

        WebElement lazMall = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='LazMall']")));
        lazMall.click();

        Thread.sleep(2000);
        WebElement closeImage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='lazmall-channel-popup--closeBtn--3dNEUwe']")));
        closeImage.click();

        WebElement searchTextBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lazmall-channel-header-search_text']")));
        WebElement searchButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lazmall-channel-header-search_btn']")));

        Assert.assertTrue(searchTextBox.isDisplayed());
        System.out.println("Search textbox is displayed");

        Assert.assertTrue(searchButton.isDisplayed());
        System.out.println("Search Button is displayed");
    }
}
