package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilterPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_name\" and @text=\"COD\"]")
    private WebElement cod;
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.banggood.client:id/btn_done\"]")
    private WebElement doneButton;

    public FilterPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void selectCOD() {
        webDriverWait.until(ExpectedConditions.visibilityOf(cod));
        cod.click();
    }

    public void clickDone() {
        webDriverWait.until(ExpectedConditions.visibilityOf(doneButton));
        doneButton.click();
    }
}
