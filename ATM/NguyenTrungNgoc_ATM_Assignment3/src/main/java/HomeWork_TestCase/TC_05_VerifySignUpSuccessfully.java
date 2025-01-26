package HomeWork_TestCase;

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

public class TC_05_VerifySignUpSuccessfully {
    @Test
    public void Test_VerifySignUpSuccessfully() throws MalformedURLException, InterruptedException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setUdid("R5CW229EAYR");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAppPackage("com.company.rawal");
        uiAutomator2Options.setAppActivity("com.company.rawal.MainActivity");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://localhost:4723"), uiAutomator2Options);
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(20));

        WebElement myAccount = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"My Account\n" + "Tab 4 of 4\"]")));
        myAccount.click();

        WebElement welcome = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"Welcome \n" + "Please Login\"]")));
        welcome.click();

        WebElement signUp = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Sign Up\n" + "Tab 2 of 2\"]")));
        signUp.click();

        Faker faker = new Faker();

        WebElement firstName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"First Name\"]")));
        firstName.click();
        String firstNameInput = faker.name().firstName();
        firstName.sendKeys(firstNameInput);
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));


        WebElement lastName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Last Name\"]")));
        lastName.click();
        lastName.sendKeys(faker.name().lastName());
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

        WebElement email = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Email\"]")));
        email.click();
        email.sendKeys(faker.internet().emailAddress());
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(2000);

        WebElement password = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Password\"]")));
        password.click();
        String pw = faker.internet().password();
        password.sendKeys(pw);
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

        WebElement confirmPassword = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Confirm Password\"]")));
        confirmPassword.click();
        confirmPassword.sendKeys(pw);
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

        WebElement signUpButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Sign Up\"]")));
        signUpButton.click();

        WebElement messagePopup = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]")));
        String messageResult = messagePopup.getAttribute("content-desc");
        System.out.println("Message displayed: " + messageResult);
        String messageVerify = "Welcome " + firstNameInput;
        System.out.println("Message verify: " + messageVerify);

        try {
            Assert.assertTrue(myAccount.isDisplayed());
            System.out.println("Already back to the My Account");
        } catch (Exception e) {
            System.out.println("App cannot back to the My Acount");
        }

        Assert.assertTrue(messageResult.contains(messageVerify));
    }
}
