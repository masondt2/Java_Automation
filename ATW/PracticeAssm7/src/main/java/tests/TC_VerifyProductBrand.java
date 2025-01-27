package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.ProductBrandsPage;

import java.io.IOException;

public class TC_VerifyProductBrand extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC_VerifyPlan(String url, String user, String pass) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(user, pass);

        DashBoardPage dashBoardPage = new DashBoardPage(getDriver());
        Assert.assertTrue(dashBoardPage.isDashBoardPagePresent());

        dashBoardPage.navigateToProductBrandsPage();
        Assert.assertTrue(dashBoardPage.isDashBoardPagePresent());

        dashBoardPage.navigateToProductBrandsPage();
        ProductBrandsPage productBrandsPage = new ProductBrandsPage(getDriver());

        Assert.assertFalse(productBrandsPage.isProductBrandsPagePresent());
        productBrandsPage.clickToAddBrand();

        Assert.assertFalse(productBrandsPage.isAddBrandPresent());

        System.out.println("==================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/Assm6_Data.xlsx", "TC_VerifyProductBrand", 1, 3);
    }
}

