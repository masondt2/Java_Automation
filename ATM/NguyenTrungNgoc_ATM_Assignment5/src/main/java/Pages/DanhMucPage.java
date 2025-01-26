package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DanhMucPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.category2:id/tvName\" and @text=\"Laptop - Máy Vi Tính - Linh kiện\"]")
    private WebElement laptopMayViTinh;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid.category2:id/tvName\" and @text=\"Điện Thoại - Máy Tính Bảng\"]")
    private WebElement dienthoaimaytinhbang;

    public DanhMucPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void scrolToLaptopMayViTinh() {
        swipeUpToElement(androidDriver, laptopMayViTinh);
    }

    public void clickToLaptopMayViTinh() {
        laptopMayViTinh.click();
    }

    public void clickToDienthoaimaytinhbang() {
        webDriverWait.until(ExpectedConditions.visibilityOf(dienthoaimaytinhbang));
        dienthoaimaytinhbang.click();
    }
}
