package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TC1_VerifyLoginPage extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC1_VerifyLoginPage(String url) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        Assert.assertTrue(loginPage.VerifyLoginPage());

        System.out.println("Login page is Displayed.");
        System.out.println("========================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/FinalTest.xlsx", "TC1_VerifyLoginPage", 1, 1);
    }
}

