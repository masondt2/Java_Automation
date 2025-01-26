package PracticePOM.tests;

import PracticePOM.core.BaseTest;
import PracticePOM.pages.DashboardPage;
import PracticePOM.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFunctionCase1 extends BaseTest {
    @Test
    public void loginFunctionCaseValid() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.navigateToLoginPage("https://rawal-admin.themes-coder.net/admin/login?");
        loginPage.login("admin@email.com","123");

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.isDashboardTitleDisplayed());
        System.out.println("Login Successful. Dashboard Title Displayed: ");
    }
}
