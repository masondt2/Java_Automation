package PracticePOM.pages;

import PracticePOM.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver d) {
        super(d);
    }

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "(//button[normalize-space()='Login'])[1]")
    private WebElement loginButton;

    public void navigateToLoginPage(String url) {
        getDriver().get(url);
    }

    public void login(String e, String p) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(email));
        email.clear();
        email.sendKeys(e);
        password.clear();
        password.sendKeys(p);
        loginButton.click();
    }
}
