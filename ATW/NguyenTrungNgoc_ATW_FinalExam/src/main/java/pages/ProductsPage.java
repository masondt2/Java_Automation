package pages;

import core.BasePage;
import core.BasicMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver d) {
        super(d);
    }


    @FindBy(xpath = "//h4[normalize-space()='Products']")
    private WebElement productsTitleElement;

    @FindBy(xpath = "//table[@id='pc-dt-satetime-sorting']/tbody/tr")
    private List<WebElement> listProductsDisplayedElement;

    @FindBy(xpath = "//a[@class='btn btn-sm btn-icon  btn-primary me-2']")
    private WebElement createButtonElement;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameElement;

    @FindBy(xpath = "//div[@class=' col-lg-6 col-md-6']//div[2]//div[1]//div[1]//input[1]")
    private WebElement productCategorySelectElement;

    @FindBy(xpath = "//input[@id='SKU']")
    private WebElement skuElement;

    @FindBy(xpath = "//input[@id='price']")
    private WebElement priceElement;

    @FindBy(xpath = "//input[@id='last_price']")
    private WebElement lastPriceElement;

    @FindBy(xpath = "//input[@id='quantity']")
    private WebElement stockQualityElement;

    @FindBy(xpath = "//a[@id='submit-all']")
    private WebElement saveElement;

    @FindBy(xpath = "//div[@class='toast-body']")
    private WebElement messageSaveElement;


    public boolean VerifyProducTableDisplayed(String shopProductDisplay) throws InterruptedException {
        Thread.sleep(5000);
        boolean check = false;
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productsTitleElement));
        if(listProductsDisplayedElement.size() == Integer.parseInt(shopProductDisplay)){
            check = true;
            System.out.println("Number of products displayed in the table: " + listProductsDisplayedElement.size());
        }
        return check;
    }

    public void CreateNewProduct(String productCategory, String price, String lastPrice, String stockQuality) throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(createButtonElement));
        createButtonElement.click();

        getWebDriverWait().until(ExpectedConditions.visibilityOf(nameElement));
        nameElement.sendKeys(BasicMethod.generateRandomString(5));

        Thread.sleep(1000);
        productCategorySelectElement.click();
        Thread.sleep(1000);
        productCategorySelectElement.sendKeys(productCategory);
        BasicMethod.ENTER(getDriver());

        Thread.sleep(1000);
        skuElement.sendKeys(BasicMethod.generateRandomString(3));

        priceElement.sendKeys(price);
        lastPriceElement.sendKeys(lastPrice);
        stockQualityElement.sendKeys(stockQuality);


        BasicMethod.ScrollToElement(getDriver(),saveElement);
        Thread.sleep(2000);
        saveElement.click();
    }

    public boolean VerifyMessageSaveProduct(String messageVerify) throws InterruptedException {
        Thread.sleep(1000);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(messageSaveElement));
        System.out.println(messageSaveElement.getText());
        return messageSaveElement.getText().contains(messageVerify);
    }

}
