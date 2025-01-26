package Assignment8.test;
import Assignment8.core.BaseTest;
import Assignment8.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EX1_TC2_InvalidEmailPassword extends BaseTest {
    @Test
    public void TestInvalidEmailPassword() throws InterruptedException {
        String emailSend = generateRandomString(5)+"@email.com";
        String passwordSend = generateRandomString(8);

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage("https://rawal-admin.themes-coder.net/admin/login");
        loginPage.login(emailSend,passwordSend);
        Thread.sleep(2000);

        Assert.assertTrue(loginPage.verifyMessageWhenLoginFail());
    }
}
