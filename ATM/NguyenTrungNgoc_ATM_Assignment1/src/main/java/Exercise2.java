import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

//Exercise 2:
//Step 1: Open ShopStyle Fashion Cash Back app.
//Step 2: Click to the “Skip” button.
//Step 3: Click to the “Shop Women's Fashion”.
//Step 4: Click to the Menu icon on top.
//Step 5: Click to the setting
//Step 6: Verify the Account, Preferences should be displayed.


public class Exercise2 {
    @Test
    public void test02() {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setAppPackage("com.shopstyle");
        uiAutomator2Options.setAppActivity("com.shopstyle.activity.HomeActivity");
        uiAutomator2Options.setUdid("R5CW229EAYR");
        uiAutomator2Options.setPlatformName("Android");

        AndroidDriver androidDriver = new AndroidDriver(uiAutomator2Options);
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(20));

        WebElement skipElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.shopstyle:id/skipText\"]")));
        skipElement.click();

        WebElement shopWomenFashionBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.shopstyle:id/btnFemale\"]")));
        shopWomenFashionBox.click();

        WebElement menuTopIcon = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id=\"com.shopstyle:id/toolbarSettings\"]")));
        menuTopIcon.click();

        WebElement accountSetting = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.shopstyle:id/list_item_section_text\" and @text=\"ACCOUNT\"]")));
        Assert.assertTrue(accountSetting.isDisplayed());
        System.out.println("Account is displayed with text: " + accountSetting.getText());

        WebElement preferencesSetting = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.shopstyle:id/list_item_section_text\" and @text=\"PREFERENCES\"]")));
        Assert.assertTrue(preferencesSetting.isDisplayed());
        System.out.println("Preferences is displayed with text: " + preferencesSetting.getText());

        androidDriver.quit();

    }
}
