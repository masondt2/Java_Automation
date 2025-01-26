package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ProfilePage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvName\"]")
    private WebElement welcomeGuestTitle;

    public ProfilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void clickToWelcomeGuest() {
        webDriverWait.until(ExpectedConditions.visibilityOf(welcomeGuestTitle));
        welcomeGuestTitle.click();
    }

    public boolean verifyProfileScreen(List<String> lstProfileSubMenuVerify) {
        try {
            String xpathProfileSubmenuElement = "//android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,\"wrteam.multivendor.customer:id\")]";
            List<String> lstProfileSubMenuDisplayed = scrollUntilEndAndReturnResult(xpathProfileSubmenuElement);
            Assert.assertEquals(lstProfileSubMenuDisplayed, lstProfileSubMenuVerify);
            System.out.println("List of profile submenu: ");
            for (String lst : lstProfileSubMenuDisplayed) {
                System.out.print(lst + ", ");
            }
            System.out.println();
            System.out.println("================================");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
