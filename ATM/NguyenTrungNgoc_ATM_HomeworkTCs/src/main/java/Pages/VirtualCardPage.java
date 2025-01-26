package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VirtualCardPage extends AppiumBase {
    public VirtualCardPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
    }

    @FindBy(xpath = "//android.view.View[@content-desc=\"Buy card\"]")
    private WebElement buycard;

    public void clickToBuyCard(){
        webDriverWait.until(ExpectedConditions.visibilityOf(buycard));
        buycard.click();
    }
}
