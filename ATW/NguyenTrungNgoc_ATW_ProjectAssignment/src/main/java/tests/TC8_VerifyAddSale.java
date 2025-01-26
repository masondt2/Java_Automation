package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddSalePage;
import pages.DashboardPage;
import pages.LoginPage;

public class TC8_VerifyAddSale extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC8_VerifyAddSale(String url, String username, String password, String customerName, String productName, String saleStatus, String paymentSatus, String alertMessageVerify) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.navigateToAddSalePage();

        AddSalePage addSalePage = new AddSalePage(getDriver());
        addSalePage.addSale(customerName, productName, saleStatus, paymentSatus);
        Assert.assertTrue(addSalePage.VerifyAddSaleAlertMessage(alertMessageVerify));

        System.out.println(alertMessageVerify);
        System.out.println("========================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/FinalTest.xlsx", "TC8_VerifyAddSale", 1, 8);
    }
}

