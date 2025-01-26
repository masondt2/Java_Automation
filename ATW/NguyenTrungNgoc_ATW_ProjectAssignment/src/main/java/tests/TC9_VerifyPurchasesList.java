package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ListPurchasesPage;
import pages.LoginPage;

public class TC9_VerifyPurchasesList extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC9_VerifyPurchasesList(String url, String username, String password, String formatDatetime, String referenceOrder, String noOfDisplay) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.navigateToListPurchasesPage();

        ListPurchasesPage listPurchasesPage = new ListPurchasesPage(getDriver());
        Assert.assertTrue(listPurchasesPage.VerifyPurchasesTableDisplayed(formatDatetime, referenceOrder, noOfDisplay));

        System.out.println("========================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/FinalTest.xlsx", "TC9_VerifyPurchasesList", 1, 6);
    }
}

