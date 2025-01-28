package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.ProductBrandsPage;
import pages.ProductCategoriesPage;

import java.io.IOException;

public class TC_VerifyProductCategory extends BaseTest {
    @Test(dataProvider = "data")
    public void TC_VerifyProductCategory_Chrome(String url, String user, String pass) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(user, pass);

        DashBoardPage dashBoardPage = new DashBoardPage(getDriver());

        dashBoardPage.navigateToProductCategoriesPage();

        ProductCategoriesPage productCategoriesPage = new ProductCategoriesPage(getDriver());

        productCategoriesPage.addProductCategoryChrome();



        System.out.println("==================");
    }

    @Test(dataProvider = "data")
    public void TC_VerifyProductCategory_FireFox(String url, String user, String pass) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(user, pass);

        DashBoardPage dashBoardPage = new DashBoardPage(getDriver());

        dashBoardPage.navigateToProductCategoriesPage();

        ProductCategoriesPage productCategoriesPage = new ProductCategoriesPage(getDriver());

        productCategoriesPage.addProductCategoryFireFox();

        System.out.println("==================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/Assm6_Data.xlsx", "TC_VerifyProductCategory", 1, 3);
    }
}

