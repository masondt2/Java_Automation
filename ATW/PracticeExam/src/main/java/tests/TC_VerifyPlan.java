package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.PlansPage;

import java.io.IOException;

public class TC_VerifyPlan extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC_VerifyPlan(String url, String email, String pass, String numOfTopProductVerify) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        Assert.assertTrue(loginPage.verifyLoginPage());

        loginPage.login(email, pass);

        DashBoardPage dashBoardPage = new DashBoardPage(getDriver());
        Assert.assertTrue(dashBoardPage.verifyDashBoardPage(numOfTopProductVerify));

        dashBoardPage.navigateToPlansPage();
        PlansPage plansPage = new PlansPage(getDriver());

        Assert.assertTrue(plansPage.verifyPlansPage());

        System.out.println("==================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/FinalExam.xlsx", "TC_VerifyPlan", 1, 4);
    }
}

