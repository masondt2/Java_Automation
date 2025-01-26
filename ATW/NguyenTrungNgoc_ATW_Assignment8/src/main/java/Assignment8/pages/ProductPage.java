package Assignment8.pages;

import Assignment8.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "//h3[normalize-space()='Add Product']")
    private WebElement addProductIcon;

    @FindBy(xpath = "//a[normalize-space()='Add Media']")
    private WebElement addMedia;

    @FindBy(xpath = " //div[@class='tab-pane fade active show']//div//a[@id='loadMore']")
    private WebElement loadMore;

    @FindBy(xpath = "(//div[contains(@class,'thumbnail-imges')])[1]")
    private WebElement firstImage;

    @FindBy(xpath = "(//span[contains(text(),'Choose')])[1]")
    private WebElement chooseButton;

    @FindBy(xpath = "//div[@class='multiselect__tags']")
    private WebElement categories;

    @FindBy(xpath = "//input[@placeholder='Select one']")
    private WebElement inputCategories;

    @FindBy(xpath = "(//ul[@id='pills-tab1'])/li")
    private List<WebElement> lstLang;

    @FindBy(xpath = "//a[normalize-space()='Advance Info']")
    private WebElement advanceInfor;

    @FindBy(xpath = "(//select[contains(@class,'single-select')])[1]")
    private WebElement productType;


    @FindBy(xpath = "(//select[contains(@class,'single-select')])[2]")
    private WebElement units;

    @FindBy(xpath = "(//select[contains(@class,'single-select')])[3]")
    private WebElement brand;

    @FindBy(xpath = "//input[@id='weight']")
    private WebElement weight;

    @FindBy(xpath = "//input[@placeholder='Enter Price']")
    private WebElement price;

    @FindBy(xpath = "//input[@placeholder='Enter Discount Price']")
    private WebElement discount;

    @FindBy(xpath = "//input[@placeholder='Enter Sku']")
    private WebElement sku;

    @FindBy(xpath = "//a[normalize-space()='SEO']")
    private WebElement seo;

    @FindBy(xpath = "//a[normalize-space()='Save']")
    private WebElement save;

    @FindBy(xpath = "//div[@class='v-toast v-toast-success']")
    private WebElement messageSaveProduct;


    public void addMedia() throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addMedia));
        addMedia.click();

        Set<String> lstWindow = getDriver().getWindowHandles();
        for (String s : lstWindow) {
            getDriver().switchTo().window(s);
            if(getDriver().getPageSource().contains("Load More")){
                break;
            }
        }

        firstImage.click();
        chooseButton.click();
        Thread.sleep(2000);
    }

    public void addBasicInfor(String categoryName, String productName, String descriptionName) throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(categories));
        categories.click();
        Thread.sleep(1000);
        inputCategories.sendKeys(categoryName);
        Actions action = new Actions(getDriver());
        action.sendKeys(Keys.ENTER).perform();

        for(int i=1; i<=lstLang.size(); i++){
            lstLang.get(i-1).click();
            WebElement nameElement = getDriver().findElement(By.name("name"+(i-1)));
            nameElement.sendKeys(productName);
            WebElement descriptionElement = getDriver().findElement(By.xpath("(//textarea[@id='label-textarea'])["+i+"]"));
            descriptionElement.sendKeys(descriptionName);
        }
    }

    public void addAdvancedInfor(String productypeName, String unitsName, String brandName, String weightIn, String priceIn, String discountIn, String skuIn) throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(advanceInfor));
        advanceInfor.click();

        Select selectProductype = new Select(productType);
        selectProductype.selectByVisibleText(productypeName);

        Select selectUnits = new Select(units);
        selectUnits.selectByVisibleText(unitsName);

        Select selectBrand = new Select(brand);
        selectBrand.selectByVisibleText(brandName);

        weight.sendKeys(weightIn);
        price.sendKeys(priceIn);
        discount.sendKeys(discountIn);
        sku.sendKeys(skuIn);

        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, -400);");

        seo.click();
        save.click();

        Set<String> lstWindow = getDriver().getWindowHandles();
        for (String s : lstWindow) {
            getDriver().switchTo().window(s);
            if(getDriver().getPageSource().contains("Product Save Successfully!")){
                break;
            }
        }
    }

    public boolean IsSaveProductSuccessfully(String expectedMessage) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(messageSaveProduct));
        return messageSaveProduct.getText().equals(expectedMessage);
    }
}
