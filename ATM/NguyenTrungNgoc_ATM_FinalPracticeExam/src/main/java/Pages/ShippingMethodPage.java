package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShippingMethodPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_country_name\"]")
    private WebElement searchBox;
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.banggood.client:id/btn_continue\"]")
    private WebElement continueButton;

    public ShippingMethodPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void clickToSearchBox() {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.click();
    }


    public void clickToContinueButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();
    }


}
