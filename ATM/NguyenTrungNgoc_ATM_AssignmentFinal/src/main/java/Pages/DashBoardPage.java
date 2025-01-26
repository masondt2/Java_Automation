package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class DashBoardPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Category\"]")
    private WebElement categoryMenu;
    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Profile\"]")
    private WebElement profileMenu;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTitle\" and @text=\"Fresh Vagetables\"]")
    private WebElement targetProduct;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTitle\" and @text=\"Fresh Vagetables\"]/parent::android.widget.RelativeLayout/parent::android.widget.RelativeLayout/following-sibling::android.widget.RelativeLayout")
    private WebElement nextTargetProduct;


    public DashBoardPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void clickToCategoryMenuItem() {
        webDriverWait.until(ExpectedConditions.visibilityOf(categoryMenu));
        categoryMenu.click();
    }

    public void scrollToTargetProduct(String targetProductName) {
        String xpathTargetProduct = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTitle\" and @text=\"" + targetProductName + "\"]";
        String xpathNextTargetProduct = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTitle\" and @text=\"" + targetProductName + "\"]/parent::android.widget.RelativeLayout/parent::android.widget.RelativeLayout/following-sibling::android.widget.RelativeLayout";

        swipeUpToElementWithXpath(androidDriver, xpathTargetProduct);
        swipeUpToElementWithXpathWithLowSpeed(androidDriver, xpathNextTargetProduct);
    }

    public boolean verifyNumOfTargetProductCategory(String targetProductName, int numOfProductsVerify) {
        try {

            String xpathAddToCartFollowTargetProduct = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTitle\" and @text=\"" + targetProductName + "\"]/parent::android.widget.RelativeLayout/following-sibling::androidx.recyclerview.widget.RecyclerView//*[contains(@resource-id, 'wrteam.multivendor.customer:id') and contains(@text, 'Add to Cart')]";
            List<WebElement> lstAddToCartFollowTargetProduct = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathAddToCartFollowTargetProduct)));
            Assert.assertEquals(lstAddToCartFollowTargetProduct.size(), numOfProductsVerify);
            System.out.println("Number of " + targetProductName + " displayed: " + numOfProductsVerify);
            System.out.println("==================================");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickToViewAll(String targetProductName) {
        String xpathViewAllFollowTargetProduct = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTitle\" and @text=\"" + targetProductName + "\"]/following-sibling::android.widget.TextView[@text= 'View All']";
        WebElement viewAllFollowTargetProduct = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathViewAllFollowTargetProduct)));
        viewAllFollowTargetProduct.click();
    }

    public void clickToProfileOnFooterMenu() {
        webDriverWait.until(ExpectedConditions.visibilityOf(profileMenu));
        profileMenu.click();
    }
}
