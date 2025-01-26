package HomeWork_TestCase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TC_04_VerifySearchScreen {
    @Test
    public void Test_VerifySearchScreen() throws MalformedURLException, InterruptedException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setUdid("R5CW229EAYR");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAppPackage("com.company.rawal");
        uiAutomator2Options.setAppActivity("com.company.rawal.MainActivity");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://localhost:4723"), uiAutomator2Options);
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(20));

        WebElement searchBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"What are you looking for?\"]")));
        searchBox.click();

        WebElement searchInput = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"What are you looking for?\"]")));
        searchInput.click();
        searchInput.sendKeys("product 20");
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

        WebElement firstProduct = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Simple Product 20\n" + "$616.50\n" + "$822.00\n" + "-25%\"]")));
        String stringFirstProduct = firstProduct.getAttribute("content-desc");
        String[] titleFirstProduct = stringFirstProduct.split("\n");
        Assert.assertTrue(firstProduct.isDisplayed());
        System.out.println("First Product: " + titleFirstProduct[0]);

        WebElement secondProduct = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Variable Product 20\n" + "$540.64\n" + "$872.00\n" + "-38%\"]")));
        String stringSecondProduct = secondProduct.getAttribute("content-desc");
        String[] titleSecondProduct = stringSecondProduct.split("\n");
        Assert.assertTrue(secondProduct.isDisplayed());
        System.out.println("Second Product: " + titleSecondProduct[0]);
    }
}
