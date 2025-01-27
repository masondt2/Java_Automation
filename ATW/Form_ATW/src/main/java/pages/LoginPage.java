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

    public void Login(String e, String p) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(loginTitleElement));
        emailTextboxElement.clear();
        emailTextboxElement.sendKeys(e);
        passwordTextboxElement.clear();
        passwordTextboxElement.sendKeys(p);
        loginButtonElement.click();
    }
}
