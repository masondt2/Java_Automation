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

    public DefaultDeliveryLocationPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"wrteam.multivendor.customer:id/searchView\"]")
    private WebElement searchPinTextBox;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvSearch\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvPinCode\"]")
    private List<WebElement> lstLocation;

    private String xpathTargetVerifyLocation = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvPinCode\" and @text=\"All\"]";


    public void selectTargetVerifyLocation(String loc) {
        String xpathTargetVerifyLocation = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvPinCode\" and @text=\""+loc+"\"]";
        WebElement targetVerifyLocation = androidDriver.findElement(By.xpath(xpathTargetVerifyLocation));
        targetVerifyLocation.click();
    }

    public boolean verifyDefaultDeliveryLocationScreen(List<String> lstVerify) {
        try{
            webDriverWait.until(ExpectedConditions.visibilityOf(searchPinTextBox));
            Assert.assertTrue(searchPinTextBox.isDisplayed());
            System.out.println(searchPinTextBox.getText() + " : is displayed ");

            webDriverWait.until(ExpectedConditions.visibilityOf(searchButton));
            Assert.assertTrue(searchButton.isDisplayed());
            System.out.println(searchButton.getText() + " : is displayed ");

            webDriverWait.until(ExpectedConditions.visibilityOfAllElements(lstLocation));
            List<String> lstResult = new ArrayList<>();
            for (WebElement element : lstLocation) {
                lstResult.add(element.getText());
            }

            Assert.assertEquals(lstVerify, lstResult);
            System.out.println("List of location displayed: ");
            for (String s : lstResult) {
                System.out.print(s);
                System.out.print(",");
            }
            System.out.println();

            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }




}
