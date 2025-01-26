package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartDetailPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.banggood.client:id/product_view\"]/android.widget.LinearLayout/android.widget.TextView")
    private WebElement productName;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_product_options\"]")
    private WebElement productSize;
    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.banggood.client:id/product_view\"]/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.TextView")
    private WebElement productPrice;
    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.banggood.client:id/product_view\"]/android.widget.LinearLayout/android.view.ViewGroup[2]//android.widget.EditText[@resource-id=\"com.banggood.client:id/edit_qty\"]")
    private WebElement quantity;

    public CartDetailPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public boolean verifyCartScreen() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(productName));
            Assert.assertTrue(productName.isDisplayed());
            System.out.println("Product Name: " + productName.getText());

            Assert.assertTrue(productSize.isDisplayed());
            System.out.println("Product Size: " + productSize.getText());

            Assert.assertTrue(productPrice.isDisplayed());
            System.out.println("Product Price: " + productPrice.getText());

            Assert.assertTrue(quantity.isDisplayed());
            System.out.println("Quantity: " + quantity.getText());
            System.out.println("===================");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
