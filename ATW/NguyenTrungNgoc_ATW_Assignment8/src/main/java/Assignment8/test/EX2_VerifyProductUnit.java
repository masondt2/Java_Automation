package Assignment8.test;

import Assignment8.core.BaseTest;
import Assignment8.pages.DashboardPage;
import Assignment8.pages.LoginPage;
import Assignment8.pages.ProductUnitsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EX2_VerifyProductUnit extends BaseTest {
    @Test
    public void TestVerifyProductUnit() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage("https://rawal-admin.themes-coder.net/admin/login");
        loginPage.login("owner@email.com","123");

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Thread.sleep(3000);
        Assert.assertTrue(dashboardPage.IsLoginSuccessfull());

        dashboardPage.navigateToProductUnitPage();

        ProductUnitsPage productUnitsPage = new ProductUnitsPage(getDriver());
        Assert.assertTrue(productUnitsPage.IsProductUnitDisplayProperty());
    }
}
