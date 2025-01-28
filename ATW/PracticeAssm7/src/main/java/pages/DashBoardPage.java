package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashBoardPage extends BasePage {
    public DashBoardPage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "(//div[@class='subheader py-2 py-lg-6 subheader-solid'])[1]")
    private WebElement dashboardTitle;

    @FindBy(xpath = "//span[normalize-space()='Catalog']/..")
    private WebElement catalogMenu;

    @FindBy(xpath = "//span[normalize-space()='Product Brands']/..")
    private WebElement productBrands;

    @FindBy(xpath = "(//span[normalize-space()='Product Categories'])[1]/..")
    private WebElement productCategory;

    public void navigateToProductBrandsPage() throws InterruptedException {
        //getWebDriverWait().until(ExpectedConditions.visibilityOf(catalogMenu));
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(catalogMenu));
        Thread.sleep(1000);
        catalogMenu.click();

        getWebDriverWait().until(ExpectedConditions.visibilityOf(productBrands));
        productBrands.click();
    }

    public void navigateToProductCategoriesPage() throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(catalogMenu));
        Thread.sleep(2000);
        catalogMenu.click();

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(productCategory));
        productCategory.click();
    }
}
