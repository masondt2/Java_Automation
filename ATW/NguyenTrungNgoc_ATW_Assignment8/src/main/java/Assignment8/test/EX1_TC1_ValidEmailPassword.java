package Assignment8.test;
import Assignment8.core.BaseTest;
import Assignment8.pages.DashboardPage;
import Assignment8.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EX1_TC1_ValidEmailPassword extends BaseTest {
    @Test
    public void TestValidEmailPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage("https://rawal-admin.themes-coder.net/admin/login");
        loginPage.login("admin@email.com","123");
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Thread.sleep(3000);
        Assert.assertTrue(dashboardPage.IsLoginSuccessfull());
    }
}
