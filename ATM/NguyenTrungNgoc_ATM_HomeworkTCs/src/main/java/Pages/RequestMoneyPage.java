package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class RequestMoneyPage extends AppiumBase {
    public RequestMoneyPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")
    private List<WebElement> lstTextBoxRequestMoney;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Send MoneyRequest\"]")
    private WebElement sendMoneyButton;

    public boolean verifyTheRequestMoneyScrennDisplay(){
        try{
            webDriverWait.until(ExpectedConditions.visibilityOf(sendMoneyButton));
            for (WebElement e: lstTextBoxRequestMoney){
                Assert.assertTrue(e.isDisplayed());
                System.out.println(e.getAttribute("hint")+" Text Box is displayed.");
            }
            Assert.assertTrue(sendMoneyButton.isDisplayed());
            System.out.println(sendMoneyButton.getAttribute("content-desc")+" Button is displayed.");

            return true;
        }catch (Exception e){
            return false;
        }
    }
}
