package Assignment8.pages;
import Assignment8.core.BasePage;
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

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='help is-danger text-danger']")
    private WebElement warningMessage;

    public void navigateToLoginPage(String url) {
        getDriver().get(url);
    }

    public void login(String e, String p) throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(email));
        Thread.sleep(1000);
        email.clear();
        email.sendKeys(e);
        Thread.sleep(1000);
        password.clear();
        password.sendKeys(p);
        Thread.sleep(1000);
        loginButton.click();
    }

    public boolean verifyMessageWhenLoginFail(){
        return warningMessage.isDisplayed() && warningMessage.getText().equals("invalid Credentials");
    }
}
