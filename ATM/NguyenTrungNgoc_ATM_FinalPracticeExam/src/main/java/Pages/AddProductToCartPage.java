package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProductToCartPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.banggood.client:id/btn_slide_cart\"]")
    private WebElement addToCartButton;

    public AddProductToCartPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void clickToAddToCartButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
    }
}
