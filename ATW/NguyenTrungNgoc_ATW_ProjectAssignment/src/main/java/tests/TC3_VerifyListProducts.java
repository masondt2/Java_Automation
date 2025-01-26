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

public class TC3_VerifyListProducts extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC3_VerifyListProducts(String url, String username, String password, String titleStings) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.navigateToListProductsPage();

        ListProductsPage listProductsPage = new ListProductsPage(getDriver());

        List<String> lstTitleVerify = new ArrayList<>(Arrays.asList(titleStings.split(",")));
        Assert.assertTrue(listProductsPage.VerifyProductTable(lstTitleVerify));

        System.out.println("========================");

    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/FinalTest.xlsx", "TC3_VerifyListProducts", 1, 4);
    }
}

