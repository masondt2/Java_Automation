package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LaptopMayViTinhPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@text=\"Hàng mới\"]")
    private WebElement hangmoi;
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"vn.tiki.app.tikiandroid:id/productV2ImageBadgeOverlay\"])[1]")
    private WebElement firstProductImage;

    public LaptopMayViTinhPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void clickToHangMoi() {
        webDriverWait.until(ExpectedConditions.visibilityOf(hangmoi));
        hangmoi.click();
    }

    public void clickToFirstProductImage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(firstProductImage));
        firstProductImage.click();
    }
}
