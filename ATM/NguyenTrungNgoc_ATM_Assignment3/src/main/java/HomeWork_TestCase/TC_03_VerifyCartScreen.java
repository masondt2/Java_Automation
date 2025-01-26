package HomeWork_TestCase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class TC_03_VerifyCartScreen {
    @Test
    public void Test_VerifyCartScreen() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setUdid("R5CW229EAYR");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAppPackage("com.company.rawal");
        uiAutomator2Options.setAppActivity("com.company.rawal.MainActivity");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://localhost:4723"), uiAutomator2Options);
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(20));

        WebElement cart = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"0\"]")));
        cart.click();

        WebElement signInTab = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Sign In\n" + "Tab 1 of 2\"]")));
        Assert.assertTrue(signInTab.isDisplayed());
        System.out.println(signInTab.getAttribute("content-desc").split("\n")[0] + " Tab: is Displayed");

        WebElement emailTextBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Enter your email\"]")));
        Assert.assertTrue(emailTextBox.isDisplayed());
        System.out.println("Email text box is Displayed with default text: " + emailTextBox.getText());

        WebElement passwordTextBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Enter your password\"]")));
        Assert.assertTrue(passwordTextBox.isDisplayed());
        System.out.println("Password text box is Displayed with default text: " + passwordTextBox.getText());

        WebElement signIn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Sign In\"]")));
        Assert.assertTrue(signIn.isDisplayed());
        System.out.println(signIn.getAttribute("content-desc") + " Button: is Displayed");

        System.out.println("==============================");

        WebElement signUp = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Sign Up\n" + "Tab 2 of 2\"]")));
        Assert.assertTrue(signUp.isDisplayed());
        System.out.println(signUp.getAttribute("content-desc").split("\n")[0] + " Tab: is Displayed");
        signUp.click();


        List<WebElement> lstSignUpEditText =webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.ScrollView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")));
        for (WebElement element : lstSignUpEditText) {
            Assert.assertTrue(element.isDisplayed());
            System.out.println(element.getText()+ ": is Displayed");
        }

        WebElement signUpButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Sign Up\"]")));
        Assert.assertTrue(signUpButton.isDisplayed());
        System.out.println(signUpButton.getAttribute("content-desc") + " Button: is Displayed");
    }
}
