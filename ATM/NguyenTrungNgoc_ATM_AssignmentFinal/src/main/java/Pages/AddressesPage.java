package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddressesPage extends AppiumBase {
    public AddressesPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

//    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"wrteam.multivendor.customer:id\") and contains(@text,\"Other\")]/parent::android.widget.RelativeLayout/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout/android.widget.ImageView")
//    private WebElement checkBoxFollowAddressesType;

    public void selectTypeOfAddress(String addressesType) {
        String xpathCheckBoxFollowAddressesType = "//android.widget.TextView[@text='" + addressesType + "']/parent::android.widget.RelativeLayout/parent::android.widget.LinearLayout/parent::android.widget.LinearLayout/android.widget.ImageView";

        WebElement checkBoxFollowAddressesType = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathCheckBoxFollowAddressesType)));

        if (!checkBoxFollowAddressesType.isSelected()) {
            checkBoxFollowAddressesType.click();
        }

    }
}
