import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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

//Exercise 1:
//Create Automation Script to test google web page on Chrome .
//Step 1: Open browser Chrome
//Step 2: Navigate to http://google.com
//Step 3: Send keys with value =”appium testing”
//Step 4: Click first result on google page.
//Step 5: Verify page title. The page title should be “Appium: Mobile App Automation Made Awesome.”

public class Exercise1 {
    @Test
    public void TestExercise1() throws MalformedURLException, InterruptedException {
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

        androidDriver.get("https://google.com");
        WebElement searh = androidDriver.findElement(By.name("q"));
        searh.sendKeys("appium testing");
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

        Thread.sleep(1000);
        WebElement firsResult = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='MjjYud'])[1]//div[@class='y0NFKc XeGcx']")));
        firsResult.click();

        Thread.sleep(1000);
        WebElement accept = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Accept']")));
        accept.click();

        String titleVerify = "Appium: Mobile App Automation Made Awesome.";
        String titleResult = androidDriver.getTitle();
        System.out.println("Title result: "+titleResult);
        System.out.println("Title verify: "+titleVerify);
        Assert.assertTrue(titleResult.equals(titleVerify));
        System.out.println("Title of first page: "+titleResult);
    }
}
