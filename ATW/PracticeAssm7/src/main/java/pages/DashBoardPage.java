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

    @FindBy(xpath = "//li[@class='breadcrumb-item active']")
    private WebElement dashboardTitle;

    @FindBy(xpath = "//span[normalize-space()='Catalog']")
    private WebElement catalogMenu;

    @FindBy(xpath = "//span[normalize-space()='Product Brands']")
    private WebElement productBrands;

    public boolean isDashBoardPagePresent(){
        return dashboardTitle.isDisplayed();
    }

    public void navigateToProductBrandsPage(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(catalogMenu));
        catalogMenu.click();

        getWebDriverWait().until(ExpectedConditions.visibilityOf(productBrands));
        productBrands.click();
    }
}
