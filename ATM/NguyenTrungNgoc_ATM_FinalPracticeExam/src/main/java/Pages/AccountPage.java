package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_view_all\"]")
    private WebElement viewAllOrders;

    public AccountPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void clickViewAllOrder() {
        webDriverWait.until(ExpectedConditions.visibilityOf(viewAllOrders));
        viewAllOrders.click();
    }
}
