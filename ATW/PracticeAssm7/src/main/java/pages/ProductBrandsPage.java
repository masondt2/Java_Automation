package pages;

import core.BasePage;
import core.BasicMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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

    @FindBy(xpath = "//input[contains(@class,'form-control')]")
    private WebElement inputBrandField;

    public void inputBrandNameChrome() throws InterruptedException {
        String brandNameAdd = BasicMethod.generateRandomString(5);
        String brandName = "Demo_Chrome_".concat(brandNameAdd);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addProductBrandsBtn));
        Thread.sleep(1000);
        addProductBrandsBtn.click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addBrandTitle));
        getWebDriverWait().until(ExpectedConditions.visibilityOf(inputBrandField)).sendKeys(brandName);
    }

    public void inputBrandNameFireFox() throws InterruptedException {
        String brandNameAdd = BasicMethod.generateRandomString(4);
        String brandName = "Demo_FireFox_".concat(brandNameAdd);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addProductBrandsBtn));
        Thread.sleep(1000);
        addProductBrandsBtn.click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addBrandTitle));
        getWebDriverWait().until(ExpectedConditions.visibilityOf(inputBrandField)).sendKeys(brandName);
    }
}
