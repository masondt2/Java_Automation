package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuLeftPage extends AppiumBase {
    public MenuLeftPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
    }

    @FindBy(xpath = "//android.view.View[@content-desc=\"Request\"]")
    private WebElement requestSubMenu;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Settings\"]")
    private WebElement settingSubMenu;

    public void clickToRequest(){
        webDriverWait.until(ExpectedConditions.visibilityOf(requestSubMenu));
        requestSubMenu.click();
    }

    public void clickToSetting(){
        swipeUpToElement(androidDriver, settingSubMenu);
        settingSubMenu.click();
    }
}
