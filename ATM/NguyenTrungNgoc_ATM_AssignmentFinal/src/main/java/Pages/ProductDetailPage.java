package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductDetailPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvProductName\"]")
    private WebElement productName;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvProductName\"]/parent::android.widget.RelativeLayout/following-sibling::android.widget.RelativeLayout[1]//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvPrice\"]")
    private WebElement productPrice;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Similar Products\"]")
    private WebElement similarProducts;
    @FindBy(xpath = "(//android.widget.Button[@resource-id=\"wrteam.multivendor.customer:id/btnAddToCart\"])[1]")
    private WebElement addToCartButton;
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"wrteam.multivendor.customer:id/btnCart\"]")
    private WebElement goToCartButton;

    public ProductDetailPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public boolean verifyTheProductDetailScreen(String productNameVerify, String productPriceVerify) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(productName));
            Assert.assertEquals(productName.getText(), productNameVerify);
            System.out.println("Product Name: " + productNameVerify);

            webDriverWait.until(ExpectedConditions.visibilityOf(productPrice));
            Assert.assertEquals(productPrice.getText(), productPriceVerify);
            System.out.println("Product Price: " + productPriceVerify);

            webDriverWait.until(ExpectedConditions.visibilityOf(similarProducts));
            Assert.assertTrue(similarProducts.isDisplayed());
            System.out.println(similarProducts.getText() + " : is displayed.");

            webDriverWait.until(ExpectedConditions.visibilityOf(addToCartButton));
            Assert.assertTrue(addToCartButton.isDisplayed());
            System.out.println(addToCartButton.getText() + " Button: is displayed.");

            webDriverWait.until(ExpectedConditions.visibilityOf(goToCartButton));
            System.out.println(goToCartButton.getText() + " Button: is displayed.");
            Assert.assertTrue(goToCartButton.isDisplayed());

            System.out.println("======================================");

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
