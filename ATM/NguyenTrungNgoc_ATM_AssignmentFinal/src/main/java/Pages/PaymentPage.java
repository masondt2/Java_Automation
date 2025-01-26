package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PaymentPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvShippingDetailTitle\"]")
    private WebElement shippingDetailTitle;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvAddress\"]")
    private WebElement addressWithPinCode;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvSelectDeliveryDate\"]")
    private WebElement preferredDelivery;
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"wrteam.multivendor.customer:id/lytGrandTotal\"]/android.widget.LinearLayout/android.widget.TextView[1]")
    private WebElement grandTotalText;
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"wrteam.multivendor.customer:id/lytGrandTotal\"]/android.widget.LinearLayout/android.widget.TextView[2]")
    private WebElement grandTotalValue;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvItemName\"]")
    private WebElement productName;
    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvSubTotal\"])[1]")
    private WebElement totalPrice;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Subtotal\"]")
    private WebElement subtotal;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Delivery Charge\"]")
    private WebElement deliveryCharge;
    @FindBy(xpath = "//android.widget.TextView[@text=\"You saved \"]")
    private WebElement youSaved;

    public PaymentPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public boolean verifyPaymentScreen(String pincodeVerify, String grandTotalVerify) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(shippingDetailTitle));

            String[] pinCodeDisplayed = addressWithPinCode.getText().split(",");
            String pinCodeResult = pinCodeDisplayed[pinCodeDisplayed.length - 1].replaceAll("[\\s\u00A0]", "");

            Assert.assertEquals(pinCodeResult, pincodeVerify.replaceAll("[\\s\u00A0]", ""));
            System.out.println("Shipping Detail with: " + pincodeVerify);

            Assert.assertTrue(preferredDelivery.isDisplayed());
            System.out.println(preferredDelivery.getText() + " : is displayed.");

            Assert.assertTrue(productName.isDisplayed());
            System.out.println("Product Name: " + productName.getText());

            Assert.assertTrue(totalPrice.isDisplayed());
            System.out.println("Total Price: " + totalPrice.getText());

            Assert.assertTrue(grandTotalText.isDisplayed() && grandTotalValue.isDisplayed() && grandTotalValue.getText().equals(grandTotalVerify));
            System.out.println(grandTotalText.getText() + " : " + grandTotalValue.getText());

            Assert.assertTrue(subtotal.isDisplayed());
            System.out.println(subtotal.getText() + " : is displayed.");

            Assert.assertTrue(deliveryCharge.isDisplayed());
            System.out.println(deliveryCharge.getText() + " : is displayed.");

            Assert.assertTrue(youSaved.isDisplayed());
            System.out.println(youSaved.getText() + " : is displayed.");

            System.out.println("==================================");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
