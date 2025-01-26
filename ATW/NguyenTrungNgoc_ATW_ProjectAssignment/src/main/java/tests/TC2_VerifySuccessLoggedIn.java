package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TC2_VerifySuccessLoggedIn extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC2_VerifySuccessLoggedIn(String url, String username, String password, String messageVerify) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.VerifyLoginSuccessfully(messageVerify));

        System.out.println("Login Successful with mesage: " + messageVerify);
        System.out.println("========================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/FinalTest.xlsx", "TC2_Verifysuccessfullyloggedin", 1, 4);
    }
}

