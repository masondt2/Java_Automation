package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SettingPage extends AppiumBase {
    public SettingPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @FindBy(xpath = "//android.view.View[@content-desc=\"Change password\"]")
    private WebElement changePassord;

    @FindBy(xpath = "(//android.widget.Button[@content-desc=\"Submit\"])[2]")
    private WebElement submitButton;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Change password\"]/following-sibling::android.widget.EditText")
    private List<WebElement> lstTextBoxChangePassword;

    public void scrollToChangePassword(){
        swipeUpToElement(androidDriver, changePassord);
        swipeUpToElement(androidDriver, submitButton);
    }

    public boolean verifyTheChangePasswordScreenDisplay(){
        try{
            Assert.assertEquals(lstTextBoxChangePassword.size(), 3);
            System.out.println("List of textbox in Chage password screen: "+lstTextBoxChangePassword.size());

            for(WebElement element:lstTextBoxChangePassword){
                Assert.assertTrue(element.isDisplayed());
                System.out.println(element.getAttribute("hint")+" Text Box is displayed.");
            }

            return true;
        }catch (Exception e){
            return false;
        }
    }
}
