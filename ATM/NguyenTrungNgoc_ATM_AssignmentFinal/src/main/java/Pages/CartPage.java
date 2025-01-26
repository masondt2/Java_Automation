package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class CartPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.RelativeLayout[@resource-id=\"wrteam.multivendor.customer:id/lytPinCode\"]/android.widget.TextView")
    private List<WebElement> lstPinCode;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvProductName\"]")
    private WebElement productName;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvProductName\"]/parent::android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    private WebElement productPrice;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvProductName\"]/parent::android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[3]")
    private WebElement productMeasurement;
    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"wrteam.multivendor.customer:id/lytQuantity\"]/android.widget.TextView")
    private WebElement quanlity;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvProductName\"]/parent::android.widget.RelativeLayout/android.widget.LinearLayout/following-sibling::android.widget.TextView")
    private WebElement productTotalPrice;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvDelete\"]")
    private WebElement delete;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvAction\"]")
    private WebElement saveForLater;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvPromoCode\"]")
    private WebElement usePromoCode;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvConfirmOrder\"]")
    private WebElement continueButton;

    public CartPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public boolean verifyCartScreen(String pincodeValueVerify, String productNameVerify, String productPriceVerify, String productMeasurementVerify, String quantityVerify, String productTotalPriceVerify) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElements(lstPinCode));
            String pincodeDisplayed = lstPinCode.getLast().getText();

            Assert.assertEquals(pincodeDisplayed, pincodeValueVerify);
            System.out.println(lstPinCode.getFirst().getText() + lstPinCode.getLast().getText());

            Assert.assertEquals(productName.getText(), productNameVerify);
            System.out.println("Product Name: " + productNameVerify);

            Assert.assertEquals(productPrice.getText(), productPriceVerify);
            System.out.println("Product Price: " + productPriceVerify);

            Assert.assertEquals(productMeasurement.getText(), productMeasurementVerify);
            System.out.println("Product Measurement: " + productMeasurementVerify);

            Assert.assertTrue(quanlity.isDisplayed() && quanlity.getText().equals(quantityVerify));
            System.out.println("Product Quantity: " + quantityVerify);

            double priceDisplayed = Double.parseDouble(productPrice.getText().replaceAll("\\$", ""));
            int quantityDisplayed = Integer.parseInt(quanlity.getText());
            double totalPriceResult = priceDisplayed * quantityDisplayed;

            Assert.assertEquals(totalPriceResult, Double.parseDouble(productTotalPriceVerify.replaceAll("\\$", "")));
            Assert.assertEquals(totalPriceResult, Double.parseDouble(productTotalPrice.getText().replaceAll("\\$", "")));
            System.out.println("Product Total Price: " + productTotalPriceVerify);

            Assert.assertTrue(delete.isDisplayed());
            System.out.println(delete.getText() + " Button: is displayed.");

            Assert.assertTrue(saveForLater.isDisplayed());
            System.out.println(saveForLater.getText() + " Button: is displayed.");

            Assert.assertTrue(usePromoCode.isDisplayed());
            System.out.println(usePromoCode.getText() + " : is displayed.");

            Assert.assertTrue(continueButton.isDisplayed());
            System.out.println(continueButton.getText() + " : is displayed.");

            System.out.println("==========================================");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickToCONTINUEButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();
    }

}
