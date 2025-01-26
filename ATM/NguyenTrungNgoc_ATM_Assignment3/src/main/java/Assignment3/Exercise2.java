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
import java.util.ArrayList;
import java.util.List;

//Exercise 2:
//Create Automation Script to verify TiKi app
//appPackage: vn.tiki.app.tikiandroid
//appActivity: vn.tiki.app.tikiandroid.ui.SplashActivity
//Step 1: Open TIKI App
//Step 2: Click Danh Muc San Pham
//Step 3: Scroll to “Hàng Quốc Tế” in Left menu
//Step 4: Scroll to panel “Laptop & Máy Vi Tính”
//Step 5: Click to the “Laptop”
//Step 6: Click to the first product.
//Step 7: Scroll to the “Thông tin chi tiết”
//Step 8: Verify “Danh mục”, “Thương Hiệu”, “Nơi Sản Xuất” and “SKU” would be displayed.

public class Exercise2 {
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

        String hangquocteXpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.category2:id/tvContent\" and @text=\"Cross Border - Hàng Quốc Tế\"]";
        BasicMethod.swipeUpLeftMenuToElement(androidDriver, hangquocteXpath);
        WebElement hangquocteElement = androidDriver.findElement(By.xpath(hangquocteXpath));
        hangquocteElement.click();

        String laptopAndMayViTinhXpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.category2:id/tvTitle\" and @text=\"Laptop & Máy Vi Tính\"]";
        BasicMethod.swipeUpToElement(androidDriver, laptopAndMayViTinhXpath);
        WebElement laptop = androidDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.category2:id/tvName\" and @text=\"Laptop\"]"));
        laptop.click();

        WebElement firstProductElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id=\"vn.tiki.app.tikiandroid:id/productV2ImageBadgeOverlay\"]")));
        firstProductElement.click();

//        WebElement firstProductName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"pdp_product_name\"]")));
//        Assert.assertTrue(firstProductName.isDisplayed());
//        System.out.println("Fist Product name: "+firstProductName.getText()+" is displayed.");
//
//        WebElement firstProductPrice = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productDetail2:id/tv_price\"]")));
//        Assert.assertTrue(firstProductPrice.isDisplayed());
//        System.out.println("First Product price: "+firstProductPrice.getText()+" is displayed.");

        String thongtinchitietXpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid:id/tvTitle\" and @text=\"Thông tin chi tiết\"]";
        BasicMethod.swipeUpToElement(androidDriver, thongtinchitietXpath);
        WebElement thongtinchitietElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thongtinchitietXpath)));
        System.out.println(thongtinchitietElement.getText() + ": is displayed.");

        String xemtatcaXpath = "//android.widget.TextView[@text=\"Xem tất cả\"]";
        BasicMethod.swipeUpToElement(androidDriver, xemtatcaXpath);

        WebElement titleInfor = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productDetail2:id/tvTitle\"]")));
        Assert.assertTrue(titleInfor.isDisplayed());

        List<WebElement> listCategories = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productDetail2:id/tvName\"]")));
        System.out.println("List of result categories displayed: ");
        System.out.println(titleInfor.getText());
        List<String> lstCategoriesNameUpcase = new ArrayList<>();
        lstCategoriesNameUpcase.add(titleInfor.getText().toUpperCase());

        for (WebElement element : listCategories) {
            Assert.assertTrue(element.isDisplayed());
            System.out.println(element.getText());
            lstCategoriesNameUpcase.add(element.getText().toUpperCase());
        }
        System.out.println("==============================");
        System.out.println("Verify “Danh mục”, “Thương Hiệu”, “Nơi Sản Xuất” and “SKU” would be displayed : ");
        List<String> lstCategoriesVerify = new ArrayList<>();
        lstCategoriesVerify.add("Danh mục");
        lstCategoriesVerify.add("Thương Hiệu");
        lstCategoriesVerify.add("Nơi Sản Xuất");
        lstCategoriesVerify.add("SKU");

        for (int i = 0; i < lstCategoriesVerify.size(); i++) {
            Assert.assertTrue(lstCategoriesNameUpcase.contains(lstCategoriesVerify.get(i).toUpperCase()), lstCategoriesVerify.get(i) + ": is NOT displayed.");
            System.out.println(lstCategoriesVerify.get(i) + ": is displayed");
        }
    }
}
