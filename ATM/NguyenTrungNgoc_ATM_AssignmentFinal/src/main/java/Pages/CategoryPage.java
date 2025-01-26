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

public class CategoryPage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTitle\"]")
    private List<WebElement> lstProductNameElements;

    public CategoryPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public boolean verifyTheCategoryScreen(int numOfProductsVerify, List<String> lstProductsVerify) {
        try {

            List<String> lstProductsNameDisplayed = new ArrayList<>();
            for (WebElement element : lstProductNameElements) {
                lstProductsNameDisplayed.add(element.getText().trim().split(",")[0]);
            }

            Assert.assertEquals(lstProductsNameDisplayed.size(), numOfProductsVerify);
            System.out.println("Category screen displayed: " + numOfProductsVerify + " products: ");

            Assert.assertEquals(lstProductsNameDisplayed, lstProductsVerify);

            for (String s : lstProductsNameDisplayed) {
                System.out.print(s + ", ");
            }
            System.out.println();
            System.out.println("=================================");

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickToTargetProductOfCategoryPage(String targetProductName) {
        String xpathTargetProduct = "//android.widget.TextView[contains(@resource-id, 'wrteam.multivendor.customer:id/tvTitle') and contains(@text, '" + targetProductName + "')]";
        WebElement targetProduct = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTargetProduct)));
        targetProduct.click();
    }
}
