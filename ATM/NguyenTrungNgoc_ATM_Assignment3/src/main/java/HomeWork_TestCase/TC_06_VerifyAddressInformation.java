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

public class TC_06_VerifyAddressInformation {
    @Test
    public void Test_VerifyAddressInformation() throws MalformedURLException, InterruptedException {
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

        WebElement signIn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Sign In\n" + "Tab 1 of 2\"]")));
        signIn.click();

        WebElement emailInput = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Enter your email\"]")));
        emailInput.click();
        emailInput.sendKeys("lnnguyensonlam@gmail.com");
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));


        WebElement passwordInput = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Enter your password\"]")));
        passwordInput.click();
        passwordInput.sendKeys("16111990");
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

        WebElement signInButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Sign In\"]")));
        signInButton.click();

        WebElement homeIcon = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"Home\n" + "Tab 1 of 4\"]")));
        homeIcon.click();

        WebElement searchButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"What are you looking for?\"]")));
        searchButton.click();

        WebElement searchInput = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"What are you looking for?\"]")));
        searchInput.click();
        searchInput.sendKeys("Simple Product 20");
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

        WebElement firstProduct = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Simple Product 20\n" + "$616.50\n" + "$822.00\n" + "-25%\"]")));
        firstProduct.click();

        WebElement addToCart = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"ADD TO CART\"]")));
        addToCart.click();
        Thread.sleep(2000);

        WebElement back = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button")));
        back.click();
        Thread.sleep(2000);

        WebElement cart = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"0\"]")));
        cart.click();

        WebElement productInforElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Simple Product 20\n" + "$822.00\n" + "CategoryMen\n" + "Quantity1\"]")));
        String productInforString = productInforElement.getAttribute("content-desc");
        String[] productInfor = productInforString.split("\n");
        String productName = productInfor[0];

        WebElement orderTotalValue = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.view.View[@content-desc=\"$822.00\"])[2]")));
        String orderTotal = orderTotalValue.getAttribute("content-desc");

        Assert.assertTrue(productName.equals("Simple Product 20"));
        System.out.println("Product Name:  " + productName);

        Assert.assertTrue(orderTotal.equals("$822.00"));
        System.out.println("Order Total: " + orderTotal);

        WebElement proceedToCheckout = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Proceed to Checkout\"]")));
        proceedToCheckout.click();

        WebElement addANewAddress = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Add A New Address\"]")));
        addANewAddress.click();
        Thread.sleep(2000);

        WebElement firstName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"First Name\"]")));
        Assert.assertTrue(firstName.isDisplayed());
        System.out.println(firstName.getAttribute("content-desc") + ": is displayed");

        WebElement lastName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Last Name\"]")));
        Assert.assertTrue(lastName.isDisplayed());
        System.out.println(lastName.getAttribute("content-desc") + ": is displayed");

        WebElement country = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Country\"]")));
        Assert.assertTrue(country.isDisplayed());
        System.out.println(country.getAttribute("content-desc") + ": is displayed");

        WebElement pickLocation = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Pick Location\"]")));
        Assert.assertTrue(pickLocation.isDisplayed());
        System.out.println(pickLocation.getAttribute("content-desc") + ": is displayed");

        WebElement address = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Address\"]")));
        Assert.assertTrue(address.isDisplayed());
        System.out.println(address.getAttribute("content-desc") + ": is displayed");

        WebElement phone = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Phone\"]")));
        Assert.assertTrue(phone.isDisplayed());
        System.out.println(phone.getAttribute("content-desc") + ": is displayed");

        WebElement postCode = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Post Code\"]")));
        Assert.assertTrue(postCode.isDisplayed());
        System.out.println(postCode.getAttribute("content-desc") + ": is displayed");

        WebElement saveAndContinue = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc=\"Save & Continue\"]")));
        Assert.assertTrue(saveAndContinue.isDisplayed());
        System.out.println(saveAndContinue.getAttribute("content-desc") + ": is displayed");
    }
}
