package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ListOfProductPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_filter_label\"]")
    private WebElement filter;
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.banggood.client:id/iv_product\"])[1]")
    private WebElement firstProductElement;

    public ListOfProductPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void clickToFilter() {
        webDriverWait.until(ExpectedConditions.visibilityOf(filter));
        filter.click();
    }

    public void clickFirstProduct() {
        webDriverWait.until(ExpectedConditions.visibilityOf(firstProductElement));
        firstProductElement.click();
    }

    public void clickToTargetProduct(String targetProductName) {
        String xpathTargetProduct = "//android.widget.TextView[contains(@resource-id,\"com.banggood.client:id/tv_product_name\") and contains(@text,\"" + targetProductName + "\")]";
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTargetProduct))).click();
        } catch (Exception e) {
            swipeUpToElementWithXpath(androidDriver, xpathTargetProduct);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTargetProduct))).click();
        }
    }
}
