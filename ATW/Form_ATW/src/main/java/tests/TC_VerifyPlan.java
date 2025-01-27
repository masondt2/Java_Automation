package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class TC_VerifyPlan extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC_VerifyPlan(String url, String user, String pass, String noOfTopProduct, String noOfRecentOrder, String planDisplay,String orderDisplay) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        //Step1
        loginPage.NavigateToLoginPage(url);
        Assert.assertTrue(loginPage.VerifyLoginPageDisplayed());

        //Step2
        loginPage.Login(user,pass);
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.VerifyDashboardPageDisplayed(noOfTopProduct, noOfRecentOrder));

        //Step3
        dashboardPage.NavigateToPlansPage();
        PlansPage plansPage = new PlansPage(getDriver());
        Assert.assertTrue(plansPage.VerifyPlansPageDisplay(planDisplay,orderDisplay));

        System.out.println("==================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/FinalExam.xlsx", "TC_VerifyPlan", 1, 7);
    }
}

