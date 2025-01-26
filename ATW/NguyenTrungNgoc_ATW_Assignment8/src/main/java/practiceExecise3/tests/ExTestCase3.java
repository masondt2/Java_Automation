package practiceExecise3.tests;

import org.testng.annotations.Test;
import practiceExecise3.core.BaseTest;
import practiceExecise3.pages.DashBoardPage;
import practiceExecise3.pages.LoginPage;

public class ExTestCase3 extends BaseTest {
    @Test
    public void TestCase3(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage("https://rawal-admin.themes-coder.net/admin/login?");
        loginPage.login("admin@email.com", "123");

        DashBoardPage dashboardPage = new DashBoardPage(getDriver());
        dashboardPage.navigateToAddProductPage();
    }

}
