package Assignment8.pages;
import Assignment8.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "//li[@class='breadcrumb-item active']")
    private WebElement dashboardIcon;

    @FindBy(xpath = "//span[normalize-space()='Catalog']")
    private WebElement catalogMenu;

    @FindBy(xpath = "//span[normalize-space()='Product Units']")
    private WebElement productUnits;

    @FindBy(xpath = "//span[normalize-space()='Products']")
    private WebElement productMenu;

    @FindBy(xpath = "//span[normalize-space()='Add Product']")
    private WebElement addProduct;


    public boolean IsLoginSuccessfull(){
        return dashboardIcon.isDisplayed();
    }

    public void navigateToProductUnitPage() throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(catalogMenu));
        catalogMenu.click();
        Thread.sleep(2000);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productUnits));
        productUnits.click();
        Thread.sleep(2000);
    }

    public void navigateToAddProductPage() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(catalogMenu));
        catalogMenu.click();

        getWebDriverWait().until(ExpectedConditions.visibilityOf(productMenu));
        productMenu.click();

        getWebDriverWait().until(ExpectedConditions.visibilityOf(addProduct));
        addProduct.click();

    }
}
