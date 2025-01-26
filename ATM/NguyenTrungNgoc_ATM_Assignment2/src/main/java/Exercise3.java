import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

//Exercise 3:
//Create Automation Script to verify hybrid app
//Hybridtestapp.zip
//appPackage: com.example.hybridtestapp
//appActivity: com.example.hybridtestapp.MainActivity
//Step 1: Open app on Android Device
//Step 2: Input FirstName, LastName, Age, UserName, Password
//Step 3: Click Register
//Step 4: Verify FirstName on the screen.

public class Exercise3 {
    @Test
    public void TestExercise3() throws MalformedURLException, InterruptedException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setUdid("R3CW50NTNBN");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAppPackage("com.example.hybridtestapp");
        uiAutomator2Options.setAppActivity("com.example.hybridtestapp.MainActivity");
       // uiAutomator2Options.setChromedriverExecutable("C:\\Users\\Admin\\Downloads\\chromedriver-ver129\\chromedriver-win64\\chromedriver.exe");
        uiAutomator2Options.setChromedriverExecutable("C:\\Users\\nhung\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        Faker faker = new Faker();

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://localhost:4723"), uiAutomator2Options);
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(20));

        WebElement continueButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/continue_button\"]")));
        continueButton.click();

        WebElement okButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")));
        okButton.click();

        androidDriver.context("WEBVIEW_com.example.hybridtestapp");

        WebElement firstName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fname")));
        String firstNameInput = faker.name().firstName();
        firstName.sendKeys(firstNameInput);

        WebElement lastName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lname")));
        lastName.sendKeys(faker.name().lastName());

        WebElement age = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age")));
        age.sendKeys(faker.number().digits(2));
        Thread.sleep(1000);

        WebElement userName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        userName.sendKeys(faker.name().name());

        WebElement password = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("psw")));
        String psw = faker.internet().password();
        password.sendKeys(psw);

        WebElement registerButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register")));
        registerButton.click();

        String messageResult = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body"))).getText();
        Assert.assertTrue(messageResult.contains(firstNameInput));
        System.out.println(messageResult);

    }
}
