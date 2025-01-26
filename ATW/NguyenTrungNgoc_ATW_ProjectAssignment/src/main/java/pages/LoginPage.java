package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(name = "identity")
    private WebElement username;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(xpath = "//button[@class='btn btn-success pull-right']")
    private WebElement loginButton;
    @FindBy(xpath = "//label[normalize-space()='Remember me']")
    private WebElement rememberme;

    public LoginPage(WebDriver d) {
        super(d);
    }

    public void navigateToLoginPage(String url) {
        getDriver().get(url);
    }

    public boolean VerifyLoginPage() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(username));
        return username.isDisplayed() && password.isDisplayed() && loginButton.isDisplayed() && rememberme.isDisplayed();
    }

    public void login(String u, String p) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(username));
        username.clear();
        username.sendKeys(u);
        password.clear();
        password.sendKeys(p);
        loginButton.click();
    }
}
