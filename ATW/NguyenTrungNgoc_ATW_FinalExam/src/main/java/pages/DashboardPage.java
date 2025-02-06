package pages;

import core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//button[@id='c-p-bn']")
    private WebElement acceptAllButtonElement;
    @FindBy(xpath = "//span[@class='hide-mob'][normalize-space()='The Treasure']")
    private WebElement treasureElement;
    @FindBy(xpath = "//h3[normalize-space()='Total Products']")
    private WebElement totalProductElement;
    @FindBy(xpath = "//h3[normalize-space()='Total Sales']")
    private WebElement totalSalesElement;
    @FindBy(xpath = "//h3[normalize-space()='Total Orders']")
    private WebElement totalOrdersElement;
    @FindBy(xpath = "//h5[normalize-space()='Top Products']")
    private WebElement topProductTitleElement;
    @FindBy(xpath = "(//table[@class='table mb-0']/tbody)[1]/tr")
    private List<WebElement> listTopProductElement;
    @FindBy(xpath = "//h5[normalize-space()='Orders']")
    private WebElement ordersElement;
    @FindBy(xpath = "//h5[normalize-space()='Recent Orders']")
    private WebElement recentOrdersElement;
    @FindBy(xpath = "(//table[@class='table mb-0'])[2]/tbody/tr")
    private List<WebElement> listrecentOrdersElement;
    @FindBy(xpath = "//span[normalize-space()='Shop']")
    private WebElement shopMenuElement;
    @FindBy(xpath = "//a[normalize-space()='Products']")
    private WebElement productsSubmenuElement;
    @FindBy(xpath = "//span[normalize-space()='Plans']")
    private WebElement plansMenuElement;
    @FindBy(xpath = "//span[@class='text-muted']")
    private WebElement lastestElement;

    public DashboardPage(WebDriver d) {
        super(d);
    }

    public boolean VerifyDashboardPageDisplayed(String noOfTopProduct, String noOfRecentOrder) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(acceptAllButtonElement));
        acceptAllButtonElement.click();

        boolean checkTheTreasure = treasureElement.isDisplayed();
        if (checkTheTreasure) {
            System.out.println("The treasure is displayed");
        }

        boolean checkTotalProduct = totalProductElement.isDisplayed();
        if (checkTotalProduct) {
            System.out.println("The total product is displayed");
        }

        boolean checkTotalSales = totalSalesElement.isDisplayed();
        if (checkTotalSales) {
            System.out.println("The total sales is displayed");
        }

        boolean checkTotalOrders = totalOrdersElement.isDisplayed();
        if (checkTotalOrders) {
            System.out.println("The total orders is displayed");
        }

        boolean checkTopProduct = topProductTitleElement.isDisplayed() && listTopProductElement.size() == Integer.parseInt(noOfTopProduct);
        if (checkTopProduct) {
            System.out.println("The top products : " + listTopProductElement.size() + " is Displayed");
        }

        boolean checkOrder = ordersElement.isDisplayed();
        if (checkOrder) {
            System.out.println("Orders is displayed");
        }

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", lastestElement);

        boolean checkRecentOrders = recentOrdersElement.isDisplayed() && listrecentOrdersElement.size() == Integer.parseInt(noOfRecentOrder);
        if (checkRecentOrders) {
            System.out.println("The recent orders is displayed with: " + listrecentOrdersElement.size());
        }

        return checkTheTreasure
                && checkTotalProduct
                && checkTotalSales
                && checkTotalOrders
                && checkTopProduct
                && checkOrder
                && checkRecentOrders;
    }

    public void NavigateToProductsPage() throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(shopMenuElement));
        shopMenuElement.click();
        Thread.sleep(4000);

        getWebDriverWait().until(ExpectedConditions.visibilityOf(productsSubmenuElement));
        productsSubmenuElement.click();
    }

    public void NavigateToPlansPage() throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(plansMenuElement));
        plansMenuElement.click();
        Thread.sleep(2000);
    }
}
