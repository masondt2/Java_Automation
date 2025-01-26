package Pages;

import Core.AppiumBase;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CountryRegionPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.banggood.client:id/et_search\"]")
    private WebElement searchTextBox;
    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.banggood.client:id/rv\"]/android.widget.LinearLayout[2]")
    private WebElement searchResultElement;

    public CountryRegionPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void changeShippingAddress(String stateChange, String provinceChange) {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchTextBox));
        searchTextBox.click();
        searchTextBox.sendKeys(stateChange);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchResultElement)).click();

        searchTextBox.click();
        searchTextBox.sendKeys(provinceChange);
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        webDriverWait.until(ExpectedConditions.visibilityOf(searchResultElement)).click();

    }
}
