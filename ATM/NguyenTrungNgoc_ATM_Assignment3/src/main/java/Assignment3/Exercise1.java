package Assignment3;
import HomeWork_TestCase.BasicMethod;
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
import java.util.List;

//Exercise 1:
//Create Automation Script to verify TiKi app
//appPackage: vn.tiki.app.tikiandroid
//appActivity: vn.tiki.app.tikiandroid.ui.SplashActivity
//Step 1: Open TIKI App
//Step 2: Click Danh Muc San Pham
//Step 3: Click Điện Gia Dụng in left menu
//Step 4: Scroll to “Thiet Bi Gia Đình” and Click to “Tất cả”
//Step 5: Click first the product and verify the product name, product price would be displayed.
//Step 6: Scroll to Thông tin chi tiết
//Step 7: Verify product category display.

public class Exercise1 {
    @Test
    public void Test_Exercise1() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setUdid("R5CW229EAYR");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAppPackage("vn.tiki.app.tikiandroid");
        uiAutomator2Options.setAppActivity("vn.tiki.android.shopping.homeV3.HomeActivity");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://localhost:4723"), uiAutomator2Options);
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));

        WebElement allow = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")));
        allow.click();

        WebElement danhmuc = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid:id/smallLabel\" and @text=\"Danh mục\"]")));
        danhmuc.click();

        String diengiadungXpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.category2:id/tvContent\" and @text=\"Điện Gia Dụng\"]";
        BasicMethod.swipeUpLeftMenuToElement(androidDriver, diengiadungXpath);
        WebElement diengiadung = androidDriver.findElement(By.xpath(diengiadungXpath));
        diengiadung.click();

        String thietbigiadinhXpath = "//android.widget.TextView[@text=\"Thiết bị gia đình\"]";
        BasicMethod.swipeUpToElement(androidDriver, thietbigiadinhXpath);
        WebElement tatcaElement = androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"TẤT CẢ\"]"));
        tatcaElement.click();

        WebElement firstProductElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id=\"vn.tiki.app.tikiandroid:id/productV2ImageBadgeOverlay\"])[1]")));
        firstProductElement.click();

        WebElement firstProductName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"pdp_product_name\"]")));
        Assert.assertTrue(firstProductName.isDisplayed());
        System.out.println("Fist Product name is displayed: " + firstProductName.getText());

        WebElement firstProductPrice = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productDetail2:id/tv_price\"]")));
        Assert.assertTrue(firstProductPrice.isDisplayed());
        System.out.println("First Product price is displayed: " + firstProductPrice.getText());

        String thongtinchitietXpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid:id/tvTitle\" and @text=\"Thông tin chi tiết\"]";
        BasicMethod.swipeUpToElement(androidDriver, thongtinchitietXpath);
        WebElement thongtinchitietElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thongtinchitietXpath)));
        System.out.println(thongtinchitietElement.getText() + ": is displayed.");

        String xemtatcaXpath = "//android.widget.TextView[@text=\"Xem tất cả\"]";
        BasicMethod.swipeUpToElement(androidDriver, xemtatcaXpath);

        WebElement titleInfor = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productDetail2:id/tvTitle\"]")));
        Assert.assertTrue(titleInfor.isDisplayed());
        System.out.println("List of categories: ");
        System.out.println(titleInfor.getText()+ ": is displayed.");

        List<WebElement> listCategories = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productDetail2:id/tvName\"]")));
        for (WebElement element : listCategories) {
            Assert.assertTrue(element.isDisplayed());
            System.out.println(element.getText() + ": is displayed.");
        }
    }
}
