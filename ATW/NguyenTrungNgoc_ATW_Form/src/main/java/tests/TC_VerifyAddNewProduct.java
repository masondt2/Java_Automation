package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.io.IOException;

public class TC_VerifyAddNewProduct extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC_VerifyAddNewProduct(String url, String user, String pass, String noOfTopProduct, String noOfRecentOrder, String shopProductDisplay, String productCategory, String price, String lastPrice, String stockQuality,String messageVerify ) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        //Step1
        loginPage.NavigateToLoginPage(url);
        Assert.assertTrue(loginPage.VerifyLoginPageDisplayed());

        //Step2
        loginPage.Login(user,pass);
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.VerifyDashboardPageDisplayed(noOfTopProduct, noOfRecentOrder));

        //Step3
        dashboardPage.NavigateToProductsPage();
        ProductsPage productsPage = new ProductsPage(getDriver());
        Assert.assertTrue(productsPage.VerifyProducTableDisplayed(shopProductDisplay));

        //Step4,5,6
        productsPage.CreateNewProduct(productCategory,price,lastPrice,stockQuality);
        productsPage.VerifyMessageSaveProduct(messageVerify);
        System.out.println(messageVerify);

        System.out.println("==================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/ /FinalExam.xlsx", "TC_VerifyAddNewProduct", 1, 11);
    }
}

