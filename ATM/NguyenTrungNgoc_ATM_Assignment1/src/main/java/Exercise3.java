import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


//Exercise 3:
//Step 1: Open ShopStyle Fashion Cash Back app.
//Step 2: Click to the “Skip” button.
//Step 3: Click to the “Shop Women's Fashion”.
//Step 4: Click to the “Brands”
//Step 5: Click to the first brands
//Step 6: Verify Newest, On Sale and Lowest Price should be displayed.


public class Exercise3 {
    @Test
    public void test03() {
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

        WebElement brandsTab = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"BRANDS\"]")));
        brandsTab.click();

        WebElement firstBrand = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView[@resource-id=\"com.shopstyle:id/filterName\"])[1]")));
        firstBrand.click();

        WebElement newest = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"NEWEST\"]")));
        WebElement onsale = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"ON SALE\"]")));
        WebElement lowestprice = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"LOWEST PRICE\"]")));

        Assert.assertTrue(newest.isDisplayed());
        System.out.println("Newest is Displayed with text: " + newest.getText());

        Assert.assertTrue(onsale.isDisplayed());
        System.out.println("Onsale is Displayed with text: " + onsale.getText());

        Assert.assertTrue(lowestprice.isDisplayed());
        System.out.println("Lowestprice is Displayed with text: " + lowestprice.getText());

        androidDriver.quit();
    }
}
