package Pages;

import Core.AppiumBase;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AppiumBase {
    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
    }

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
    private WebElement emailTextBox;

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]")
    private WebElement loginButton;

    public void inputEmailPassword(String e, String p){
        webDriverWait.until(ExpectedConditions.visibilityOf(emailTextBox));
        emailTextBox.click();
        emailTextBox.sendKeys(e);
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

        passwordTextBox.click();
        passwordTextBox.sendKeys(p);
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickToLogin(){
        webDriverWait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }
}
