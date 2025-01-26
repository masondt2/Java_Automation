package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class WelcomeToeCartPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"wrteam.multivendor.customer:id/edtLoginMobile\"]")
    private WebElement mobileTextBox;
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"wrteam.multivendor.customer:id/imgLoginPassword\"]")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"wrteam.multivendor.customer:id/btnLogin\"]")
    private WebElement loginButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvForgotPass\"]")
    private WebElement forgotPassword;
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"wrteam.multivendor.customer:id/tvSignUp\"]")
    private WebElement signUpButton;

    public WelcomeToeCartPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void clickToLoginButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public boolean verifyTheLoginScreenOnWelcomeToeCartPage() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(mobileTextBox));
            Assert.assertTrue(mobileTextBox.isDisplayed());
            System.out.println("Mobile Text Box : is displayed");

            Assert.assertTrue(passwordTextBox.isDisplayed());
            System.out.println("Password Text Box : is displayed");

            Assert.assertTrue(loginButton.isDisplayed());
            System.out.println(loginButton.getText() + " Button: is displayed");

            Assert.assertTrue(forgotPassword.isDisplayed());
            System.out.println(forgotPassword.getText() + " : is displayed");

            Assert.assertTrue(signUpButton.isDisplayed());
            System.out.println(signUpButton.getText() + " Button: is displayed");

            System.out.println("==============================");
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
