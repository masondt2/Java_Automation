package Assignment8.test;
import Assignment8.core.BaseTest;
import Assignment8.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EX1_TC3_EmptyEmail extends BaseTest {
    @Test
    public void TestEmptyEmail() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage("https://rawal-admin.themes-coder.net/admin/login");
        loginPage.login("","");
        Thread.sleep(2000);
        Assert.assertTrue(loginPage.verifyMessageWhenLoginFail());
    }
}
