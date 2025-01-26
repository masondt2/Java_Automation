package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddPurchasePage;
import pages.DashboardPage;
import pages.LoginPage;

public class TC10_VerifyAddPurchases extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC10_VerifyAddPurchases(String url, String username, String password, String companyName, String name, String email, String phone, String address, String city, String addProductPurchase, String addPurchasesMessage) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.navigateToAddPurchasesPage();

        AddPurchasePage addPurchasePage = new AddPurchasePage(getDriver());
        addPurchasePage.AddPurchase(companyName, name, email, phone, address, city, addProductPurchase);
        Assert.assertTrue(addPurchasePage.VerifyAddPurchasesMessage(addPurchasesMessage));

        System.out.println(addPurchasesMessage);
        System.out.println("========================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/FinalTest.xlsx", "TC10_VerifyAddPurchases", 1, 11);
    }
}

