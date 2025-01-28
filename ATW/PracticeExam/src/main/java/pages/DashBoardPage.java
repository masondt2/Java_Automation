package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class DashBoardPage extends BasePage {
    public DashBoardPage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "//button[@id='c-p-bn']")
    private WebElement acceptAll;

    @FindBy(xpath = "//span[@class='hide-mob'][normalize-space()='The Treasure']/..")
    private WebElement treasure;

    @FindBy(xpath = "//h3[normalize-space()='Total Products']/../../../..")
    private WebElement totalProduct;

    @FindBy(xpath = "(//table[@class='table mb-0'])[1]//tbody/tr")
    private List<WebElement> lstTopProducts;

    @FindBy(xpath = "//span[normalize-space()='Plans']/..")
    private WebElement plansMenu;

    public void navigateToPlansPage() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(plansMenu));
        plansMenu.click();
    }

    public boolean verifyDashBoardPage(String numOfTopProductVerify) {
        try{
            getWebDriverWait().until(ExpectedConditions.visibilityOf(acceptAll));
            acceptAll.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("No Accept All displayed");
        }

        try {
            getWebDriverWait().until(ExpectedConditions.visibilityOf(treasure));
            Assert.assertTrue(treasure.isDisplayed());
            System.out.println("Treasure is displayed");

            Assert.assertTrue(totalProduct.isDisplayed());
            System.out.println("Total product is displayed");

            getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(lstTopProducts));
            Assert.assertEquals(lstTopProducts.size(),Integer.parseInt(numOfTopProductVerify));
            System.out.println("Number of top products: "+numOfTopProductVerify);

            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
