package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductBrandsPage extends BasePage {
    public ProductBrandsPage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "//h3[normalize-space()='Product Brands']")
    private WebElement productBrandsTitle;

    @FindBy(xpath = "(//button[@class='btn ml-2 p-0 kt_notes_panel_toggle'])[1]")
    private WebElement addProductBrandsBtn;

    @FindBy(xpath = "(//h4[normalize-space()='Add Brand'])[1]")
    private WebElement addBrandTitle;

    public boolean isProductBrandsPagePresent() {
        return productBrandsTitle.isDisplayed();
    }

    public boolean isAddBrandPresent() {
        return addBrandTitle.isDisplayed();
    }

    public void clickToAddBrand() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addProductBrandsBtn)).click();
    }
}
