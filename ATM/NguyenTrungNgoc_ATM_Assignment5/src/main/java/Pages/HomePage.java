package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AppiumBase {
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
    private WebElement allow;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"vn.tiki.app.tikiandroid:id/smallLabel\" and @text=\"Danh mục\"]")
    private WebElement danhmucsanpham;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void clickToDanhMucSanPham() {
        webDriverWait.until(ExpectedConditions.visibilityOf(danhmucsanpham));
        danhmucsanpham.click();
    }

    public void acceptAllowPopup() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(allow));
            allow.click();
        } catch (Exception e) {
            System.out.println("Allow popup did not appear");
        }
    }


}
