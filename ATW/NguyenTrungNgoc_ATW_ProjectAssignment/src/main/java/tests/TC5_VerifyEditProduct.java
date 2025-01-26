package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.EditProductPage;
import pages.ListProductsPage;
import pages.LoginPage;

public class TC5_VerifyEditProduct extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC5_VerifyEditProduct(String url, String username, String password, String productNameVerify, String barcodeSymbologyChange, String taxMethodChange, String messageVerify) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.navigateToListProductsPage();

        ListProductsPage listProductsPage = new ListProductsPage(getDriver());

        listProductsPage.navigateToDetailProductPage(productNameVerify);
        listProductsPage.navigateToEditProductPage();

        EditProductPage editProductPage = new EditProductPage(getDriver());
        Assert.assertTrue(editProductPage.VerifyProductDetailPageDisplayed());
        System.out.println("Product detail page is displayed!");

        editProductPage.EditProduct(barcodeSymbologyChange, taxMethodChange);
        System.out.println("Product has been edited successfully!");
        Assert.assertTrue(editProductPage.VerifyEditProductSuccess(messageVerify));

        System.out.println(messageVerify);
        System.out.println("========================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/FinalTest.xlsx", "TC5_VerifyEditProduct", 1, 7);
    }
}

