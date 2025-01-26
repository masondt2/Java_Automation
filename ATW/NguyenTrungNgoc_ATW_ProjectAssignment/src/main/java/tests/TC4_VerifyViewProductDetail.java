package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ListProductsPage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TC4_VerifyViewProductDetail extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC4_VerifyViewProductDetail(String url, String username, String password, String productNameVerify, String inforsVerify) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.navigateToListProductsPage();

        ListProductsPage listProductsPage = new ListProductsPage(getDriver());

        listProductsPage.navigateToDetailProductPage(productNameVerify);

        List<String> lstInforVerify = new ArrayList<>(Arrays.asList(inforsVerify.split(",")));
        Assert.assertTrue(listProductsPage.VerifyViewDetailsProduct(lstInforVerify));

        System.out.println("========================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/FinalTest.xlsx", "TC4_VerifyViewProductDetail", 1, 5);
    }
}

