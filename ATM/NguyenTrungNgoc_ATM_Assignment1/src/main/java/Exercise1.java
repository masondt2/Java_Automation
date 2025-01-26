import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

//Exercise 1:
//Step 1: Open ShopStyle Fashion Cash Back app.
//Step 2: Click to the “Skip” button.
//Step 3: Click to the “Shop Men's Fashion”.
//Step 4: Click to the “Categories”.
//Step 5: Click to the “Bags”.
//Step 6: Click to the “Backpacks”.
//Step 7: Click to the first item
//Step 8: Verify product price and product name should be displayed.

public class Exercise1 {
    @Test
    public void test01() {
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

        WebElement shopMenFashionBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.shopstyle:id/btnMale\"]")));
        shopMenFashionBox.click();

        WebElement categoriesTab = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"CATEGORIES\"]")));
        categoriesTab.click();

        WebElement bagsMenu = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.shopstyle:id/filterName\" and @text=\"    Bags\"]")));
        bagsMenu.click();

        WebElement backpacksSubMenu = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.shopstyle:id/filterName\" and @text=\"      Backpacks\"]")));
        backpacksSubMenu.click();

        WebElement firstProduct = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@content-desc=\"ShopStyle\"])[1]")));
        firstProduct.click();

        WebElement productName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.shopstyle:id/productBrand\"]")));
        WebElement productPrice = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.shopstyle:id/sale_price\"]")));

        Assert.assertTrue(productName.isDisplayed());
        System.out.println("Product name: " + productName.getText());

        Assert.assertTrue(productPrice.isDisplayed());
        System.out.println("Product price: " + productPrice.getText());

        androidDriver.quit();
    }
}
