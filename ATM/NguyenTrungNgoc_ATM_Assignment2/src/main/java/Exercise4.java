import io.appium.java_client.android.AndroidDriver;
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

//Exercise 4:
//Create Automation Script to verify TiKi app
//appPackage: vn.tiki.app.tikiandroid
//appActivity: vn.tiki.app.tikiandroid.ui.SplashActivity
//Step 1: Open Tiki app on Android Device
//Step 4: Click Danh Muc San Pham
//Step 5: Click Điện Thoại – Máy Tính Bảng
//Step 6: Click to the Máy Tính Bảng
//Step 7: Click first the product and verify the product image, product name, product price and “Mua ngay”
//button must be displayed.

public class Exercise4 {
    @Test
    public void TestExercise4() throws MalformedURLException, InterruptedException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setPlatformName("Android");

        uiAutomator2Options.setUdid("R3CW50NTNBN");
        //uiAutomator2Options.setUdid("R5CW229EAYR");

        uiAutomator2Options.setAppPackage("vn.tiki.app.tikiandroid");
        uiAutomator2Options.setAppActivity("vn.tiki.android.shopping.homeV3.HomeActivity");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://localhost:4723"), uiAutomator2Options);
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));

        WebElement allow = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")));
        allow.click();

        try{
            WebElement whileusingtheappButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")));
            whileusingtheappButton.click();
            System.out.println("There is a 'While using the app Popup' ");
        }catch (Exception e){
            System.out.println("There is not any alert popup");
        }

        WebElement danhmuc = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id=\"vn.tiki.app.tikiandroid:id/icon\"])[3]")));
        danhmuc.click();

        WebElement dienthoaimaytinhbang = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.category2:id/tvName\" and @text=\"Điện Thoại - Máy Tính Bảng\"]")));
        dienthoaimaytinhbang.click();

        WebElement maytingbang = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid:id/tvName\" and @text=\"Máy tính bảng\"]")));
        maytingbang.click();

        WebElement firstProduct = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id=\"vn.tiki.app.tikiandroid:id/productV2ImageBadgeOverlay\"])[1]")));
        firstProduct.click();

        WebElement firstProductImage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"vn.tiki.app.tikiandroid.productDetail2:id/badgeContainer\"]/android.view.ViewGroup")));
        WebElement firstProductName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"pdp_product_name\"]")));
        WebElement firstProductPrice = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productDetail2:id/tv_price\"]")));
        WebElement muangayButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"vn.tiki.app.tikiandroid.productDetail2:id/button_buy_now\"]")));

        Assert.assertTrue(firstProductImage.isDisplayed());
        System.out.println("Image is displayed");

        Assert.assertTrue(firstProductName.isDisplayed());
        System.out.println("First Product Name is displayed : "+firstProductName.getText());

        Assert.assertTrue(firstProductPrice.isDisplayed());
        System.out.println("First Product Price is displayed : "+firstProductPrice.getText());

        Assert.assertTrue(muangayButton.isDisplayed());
        System.out.println("Mua Ngay Button is displayed with text: "+muangayButton.getText());
    }
}
