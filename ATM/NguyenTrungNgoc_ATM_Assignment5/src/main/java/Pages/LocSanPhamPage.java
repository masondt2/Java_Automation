package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LocSanPhamPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@text=\"Thương hiệu\"]")
    private WebElement thuonghieu;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productList2:id/tv_name\" and @text=\"Samsung\"]")
    private WebElement samsung;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.productList2:id/btn_apply\"]")
    private WebElement apDungButton;

    public LocSanPhamPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void scrollToThuongHieu() {
        swipeUpToElement(androidDriver, thuonghieu);
    }

    public void selectSamsung() {
        webDriverWait.until(ExpectedConditions.visibilityOf(samsung));
        samsung.click();
    }

    public void clickToApDungButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(apDungButton));
        apDungButton.click();
    }
}
