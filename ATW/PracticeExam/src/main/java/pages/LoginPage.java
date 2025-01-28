package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "(//h2[normalize-space()='Login'])[1]")
    private WebElement loginTitle;

    @FindBy(xpath = "(//input[@id='email'])[1]")
    private WebElement emailTextBox;

    @FindBy(xpath = "(//input[@id='password'])[1]")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//a[normalize-space()='Forgot Your Password?']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//button[@id='login_button']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[@id='super_admin_login']")
    private WebElement supperAdminButton;

    @FindBy(xpath = "//button[@id='owner_login']")
    private WebElement shopOwnerButton;

    @FindBy(xpath = "//button[@id='manager_login']")
    private WebElement managerButton;

    @FindBy(xpath = "//button[@id='accountant_login']")
    private WebElement accountantButton;

    public void navigateToLoginPage(String url) {
        getDriver().get(url);
    }

    public void login(String e, String p) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(loginTitle));
        emailTextBox.clear();
        emailTextBox.sendKeys(e);
        passwordTextBox.clear();
        passwordTextBox.sendKeys(p);
        loginButton.click();

    }

    public boolean verifyLoginPage(){
        try{
            getWebDriverWait().until(ExpectedConditions.visibilityOf(loginTitle));
            Assert.assertTrue(loginTitle.isDisplayed());
            System.out.println("Login title is displayed");

            getWebDriverWait().until(ExpectedConditions.visibilityOf(emailTextBox));
            Assert.assertTrue(emailTextBox.isDisplayed());
            System.out.println("Email text box is displayed");

            Assert.assertTrue(passwordTextBox.isDisplayed());
            System.out.println("Password text box is displayed");

            Assert.assertTrue(forgotPasswordLink.isDisplayed());
            System.out.println("Forgot your password link is displayed");

            Assert.assertTrue(supperAdminButton.isDisplayed());
            System.out.println("Supper Admin button is displayed");

            Assert.assertTrue(shopOwnerButton.isDisplayed());
            System.out.println("Shop owner button is displayed");

            Assert.assertTrue(managerButton.isDisplayed());
            System.out.println("Manager button is displayed");

            Assert.assertTrue(accountantButton.isDisplayed());
            System.out.println("Accountant button is displayed");

            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
