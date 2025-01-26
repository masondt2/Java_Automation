package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ProductOfCategoryPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/productName\"]")
    private List<WebElement> lstProductNameElement;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Cart\"]")
    private WebElement cartIconOnTop;

    public ProductOfCategoryPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

//    String xpathAddToCart = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/productName\" and @text=\"Kurkure Namkeen - Masala Munch,\"]/parent::android.widget.RelativeLayout/parent::android.widget.RelativeLayout/following-sibling::android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button";
//    String xpathTextAfterAdd = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/productName\" and @text=\"Kurkure Namkeen - Masala Munch,\"]/parent::android.widget.RelativeLayout/parent::android.widget.RelativeLayout/following-sibling::android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView";
//    String xpathIncreaseButton = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/productName\" and @text=\"Kurkure Namkeen - Masala Munch,\"]/parent::android.widget.RelativeLayout/parent::android.widget.RelativeLayout/following-sibling::android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageButton[2]";


    public boolean verifyTheNumberOfTargetProduct(int numOfProductsVerify) {
        try {
            String xpathProductNameDisplayed = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/productName\"]";
            webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathProductNameDisplayed)));
            List<String> lstProductNameDisplayed = scrollUntilEndAndReturnResult(xpathProductNameDisplayed);
            Assert.assertEquals(lstProductNameDisplayed.size(), numOfProductsVerify);
            System.out.println("Number of products displayed: " + lstProductNameDisplayed.size());
            System.out.println("===============================");
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void clickToVerifyProduct(String productNameVerify) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(lstProductNameElement));
        String xpathProductVerify = "//*[contains(@resource-id, 'wrteam.multivendor.customer:id/productName') and contains(@text, \"" + productNameVerify + "\")]";
        swipeUpToElementWithXpath(androidDriver, xpathProductVerify);
        WebElement productVerify = androidDriver.findElement(By.xpath(xpathProductVerify));
        productVerify.click();
    }

    public void clickAddToCartWithQuantityProduc(int quantity, String productNameVerify) {
        String xpathAddToCart = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/productName\" and @text=\"" + productNameVerify + "\"]/parent::android.widget.RelativeLayout/parent::android.widget.RelativeLayout/following-sibling::android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button";
        String xpathTextAfterAdd = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/productName\" and @text=\"" + productNameVerify + "\"]/parent::android.widget.RelativeLayout/parent::android.widget.RelativeLayout/following-sibling::android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView";
        String xpathIncreaseButton = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/productName\" and @text=\"" + productNameVerify + "\"]/parent::android.widget.RelativeLayout/parent::android.widget.RelativeLayout/following-sibling::android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageButton[2]";

        swipeUpToElementWithXpath(androidDriver, xpathAddToCart);

        WebElement addToCartButtonFollowProduct = androidDriver.findElement(By.xpath(xpathAddToCart));
        addToCartButtonFollowProduct.click();

        WebElement textAfterAddToCart = androidDriver.findElement(By.xpath(xpathTextAfterAdd));
        WebElement increaseButton = androidDriver.findElement(By.xpath(xpathIncreaseButton));

        while (!(Integer.parseInt(textAfterAddToCart.getText()) == quantity)) {
            increaseButton.click();
        }

    }

    public void clickToCartIconOnTopScreen() {
        webDriverWait.until(ExpectedConditions.visibilityOf(cartIconOnTop));
        cartIconOnTop.click();
    }


}
