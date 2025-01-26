package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AppiumBase {
    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]")
    private WebElement loginHome;


    public void clickToLoginHome(){
        webDriverWait.until(ExpectedConditions.visibilityOf(loginHome));
        loginHome.click();
    }

    //android.widget.ImageView[contain(@content-desc,'My Account')]
}
