package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DefaultDeliveryLocationPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"wrteam.multivendor.customer:id/searchView\"]")
    private WebElement searchPinTextBox;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvSearch\"]")
    private WebElement searchButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvPinCode\"]")
    private List<WebElement> lstLocationsElement;

    public DefaultDeliveryLocationPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    //android.widget.TextView[@resource-id="wrteam.multivendor.customer:id/tvPinCode" and @text="All"]
    public boolean verifyTheDefaultDeliveryLocationScreen(List<String> lstLocationsVerify) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElements(lstLocationsElement));
            List<String> lstLocationsDisplayed = new ArrayList<>();

            for (WebElement element : lstLocationsElement) {
                lstLocationsDisplayed.add(element.getText());
            }

            Assert.assertEquals(lstLocationsDisplayed, lstLocationsVerify);

            System.out.println("List of locations are displayed: ");
            for (String location : lstLocationsDisplayed) {
                System.out.print(location + ", ");
            }
            System.out.println();
            System.out.println("===================================");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void selectTargetLocation(String targetLocationName) {
        String xpathTargetLocation = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvPinCode\" and @text=\"" + targetLocationName + "\"]";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTargetLocation))).click();

    }
}
