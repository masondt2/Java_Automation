package Assignment8.test;

import Assignment8.core.BaseTest;
import Assignment8.pages.DashboardPage;
import Assignment8.pages.LoginPage;
import Assignment8.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EX3_VerifyAddProduct extends BaseTest {
    @Test
    public void TestVerifyAddProduct() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage("https://rawal-admin.themes-coder.net/admin/login");
        loginPage.login("owner@email.com","123");

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.navigateToAddProductPage();

        ProductPage productPage = new ProductPage(getDriver());
        productPage.addMedia();
        productPage.addBasicInfor("123","trungngoc_demo2","trungngoc_demo2");

        productPage.addAdvancedInfor("Simple","pcs","KIA","10","1000","0.5",generateRandomString(5));

        Assert.assertTrue(productPage.IsSaveProductSuccessfully("Product Save Successfully!"));
        System.out.println("Product Save Successfully!");
    }
}
