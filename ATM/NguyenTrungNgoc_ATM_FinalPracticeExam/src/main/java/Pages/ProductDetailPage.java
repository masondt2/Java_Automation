package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductDetailPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_product_name\"]")
    private WebElement productName;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_tag\"]")
    private WebElement codIcon;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_product_price\"]")
    private WebElement productPrice;
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.banggood.client:id/btn_slide_buy\"]")
    private WebElement buyNowButton;
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.banggood.client:id/btn_slide_cart\"]")
    private WebElement addToCartButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_shipping_cost\"]")
    private WebElement shipping;
    @FindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.banggood.client:id/menu_cart_icon\"]")
    private WebElement cartIconOnTop;

    public ProductDetailPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public boolean verifyProductDetailDisplayProductName() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(productName));
            Assert.assertTrue(productName.isDisplayed());
            System.out.println("Product name displayed: " + productName.getText());

            System.out.println("===================");
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean verifyProductDetailScreenDisplayCODIcon() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(codIcon));
            Assert.assertTrue(codIcon.isDisplayed());
            System.out.println(codIcon.getText() + " :is displayed");

            System.out.println("===================");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyProductDetailScreenDisplayProductPrice() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(productPrice));
            Assert.assertTrue(productPrice.isDisplayed());
            System.out.println("Product Price: " + productPrice.getText());

            System.out.println("===================");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyProductDetailScreenDisplayBuyNowButton() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(buyNowButton));
            Assert.assertTrue(buyNowButton.isDisplayed());
            System.out.println(buyNowButton.getText() + " Button: is displayed");

            System.out.println("===================");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyProductDetailScreenDisplayAddToCartButton() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(addToCartButton));
            Assert.assertTrue(addToCartButton.isDisplayed());
            System.out.println(addToCartButton.getText() + " Button: is displayed");

            System.out.println("===================");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollToShipping() {
        swipeUpToElement(androidDriver, shipping);
    }

    public void clickToShipping() {
        webDriverWait.until(ExpectedConditions.visibilityOf(shipping));
        shipping.click();
    }

    public void clickToAddToCart() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
    }

    public void clickToCartIconOnTop() {
        webDriverWait.until(ExpectedConditions.visibilityOf(cartIconOnTop));
        cartIconOnTop.click();
    }

}
