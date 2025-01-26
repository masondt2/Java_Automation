package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DienThoaiMayTinhBangPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productList2:id/filter_text\"]")
    private WebElement locButton;
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"vn.tiki.app.tikiandroid:id/productV2ImageBadgeOverlay\"])[1]")
    private WebElement firstDTMTBProductImage;

    public DienThoaiMayTinhBangPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void clickToTheLocButton() {
        swipeUpToElement(androidDriver, locButton);
        locButton.click();
    }

    public void clickToTheFirstDienThoaiMayTinhBangProduct() {
        swipeUpToElement(androidDriver, firstDTMTBProductImage);
        firstDTMTBProductImage.click();
    }
}
