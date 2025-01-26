package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "//h2[normalize-space()='Login']")
    private WebElement loginTitleElement;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextboxElement;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTextboxElement;

    @FindBy(xpath = "//a[normalize-space()='Forgot Your Password?']")
    private WebElement forgotYourPasswordElement;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButtonElement;

    @FindBy(xpath = "//button[@id='super_admin_login']")
    private WebElement superAdminButtonElement;

    @FindBy(xpath = "//button[@id='owner_login']")
    private WebElement shopOwnerButtonElement;

    @FindBy(xpath = "//button[@id='manager_login']")
    private WebElement managerButtonElement;

    @FindBy(xpath = "//button[@id='accountant_login']")
    private WebElement accountantButtonElement;

    public void NavigateToLoginPage(String url) {
        getDriver().get(url);
    }

    public void Login(String e, String p) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(loginTitleElement));
        emailTextboxElement.clear();
        emailTextboxElement.sendKeys(e);
        passwordTextboxElement.clear();
        passwordTextboxElement.sendKeys(p);
        loginButtonElement.click();
    }

    public boolean VerifyLoginPageDisplayed() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(loginTitleElement));

        boolean checkLoginTitle = loginTitleElement.isDisplayed() && loginTitleElement.getText().equals("Login");
        if(checkLoginTitle){
            System.out.println("Title: Login is Displayed");
        }

        boolean checkEmail = emailTextboxElement.isDisplayed();
        if(checkEmail) {
            System.out.println("Email text box is Displayed");
        }

        boolean checkPassword = passwordTextboxElement.isDisplayed() ;
        if(checkPassword) {
            System.out.println("Password text box is Displayed");
        }

        boolean checkForgotYourPassword = forgotYourPasswordElement.isDisplayed();
        if(checkForgotYourPassword) {
            System.out.println("Forgot Your Password is Displayed");
        }

        boolean checkLoginButton = loginButtonElement.isDisplayed();
        if(checkLoginButton) {
            System.out.println("Login button is Displayed");
        }

        boolean checkSuperAdminButton = superAdminButtonElement.isDisplayed();
        if(checkSuperAdminButton) {
            System.out.println("Super Admin button is Displayed");
        }

        boolean checkShopOwnerButton = shopOwnerButtonElement.isDisplayed();
        if(checkShopOwnerButton) {
            System.out.println("Shop Owner button is Displayed");
        }

        boolean checkManagerButton = managerButtonElement.isDisplayed();
        if(checkManagerButton) {
            System.out.println("Manager button is Displayed");
        }

        boolean checkAccountantButton = accountantButtonElement.isDisplayed();
        if(checkAccountantButton) {
            System.out.println("Account ant button is Displayed");
        }

        return checkLoginTitle
                && checkEmail
                && checkPassword
                && checkForgotYourPassword
                && checkLoginButton
                && checkSuperAdminButton
                && checkShopOwnerButton
                &&checkManagerButton
                && checkAccountantButton;
    }

}
