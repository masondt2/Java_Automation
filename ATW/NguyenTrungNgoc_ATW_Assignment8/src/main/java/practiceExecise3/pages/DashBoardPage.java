package practiceExecise3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import practiceExecise3.core.BasePage;

public class DashBoardPage extends BasePage {
    public DashBoardPage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "(//li[@class='breadcrumb-item active'])[1]")
    private WebElement dashboardTitle;

    @FindBy(xpath = "(//span[normalize-space()='Catalog'])[1]")
    private WebElement catalogMenu;

    @FindBy(xpath = "(//span[normalize-space()='Products'])[1]")
    private WebElement productsSubMenu;

    @FindBy(xpath = "(//span[normalize-space()='Add Product'])[1]")
    private WebElement addProductSubMenu;

    public void navigateToAddProductPage() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(dashboardTitle));
        getWebDriverWait().until(ExpectedConditions.visibilityOf(catalogMenu));
        catalogMenu.click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productsSubMenu));
        productsSubMenu.click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addProductSubMenu));
        addProductSubMenu.click();
    }
}
