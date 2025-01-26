package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"pdp_product_name\"]")
    private WebElement firstroductName;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productDetail2:id/tv_price\"]")
    private WebElement firstProductPrice;

    public ProductDetailPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public boolean verifyFirstProductDisplay() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(firstroductName));
            System.out.println("First Product Name is displayed: " + firstroductName.getText());

            swipeUpToElement(androidDriver, firstProductPrice);
            System.out.println("First Product Price is displayed: " + firstProductPrice.getText());

            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
