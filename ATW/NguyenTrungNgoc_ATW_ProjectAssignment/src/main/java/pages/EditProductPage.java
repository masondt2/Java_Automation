package pages;

import core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditProductPage extends BasePage {
    Actions actions = new Actions(getDriver());
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    @FindBy(xpath = "//label[normalize-space()='Product Type *']")
    private WebElement productTypeElement;
    @FindBy(xpath = "//label[normalize-space()='Product Name *']")
    private WebElement productNameElement;
    @FindBy(xpath = "//label[normalize-space()='Product Code *']")
    private WebElement productCodeElement;
    @FindBy(xpath = "//label[normalize-space()='Slug *']")
    private WebElement SlugElement;
    @FindBy(xpath = "//label[normalize-space()='Barcode Symbology *']")
    private WebElement BarcodeSymbologyElement;
    @FindBy(xpath = "//span[@id='select2-chosen-6']")
    private WebElement barcodeSymbologyBoxElement;
    @FindBy(xpath = "//input[@id='s2id_autogen6_search']")
    private WebElement barcodeSymbologySearchElement;
    @FindBy(xpath = "//span[@id='select2-chosen-13']")
    private WebElement taxMethodBox;
    @FindBy(name = "edit_product")
    private WebElement editProductButton;
    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement alertMessageElement;
    public EditProductPage(WebDriver d) {
        super(d);
    }
    //js.executeScript("arguments[0].scrollIntoView(true);", taxMethod);

    public boolean VerifyProductDetailPageDisplayed() {
        return productTypeElement.isDisplayed()
                && productNameElement.isDisplayed()
                && productCodeElement.isDisplayed()
                && SlugElement.isDisplayed()
                && BarcodeSymbologyElement.isDisplayed();
    }

    public void EditProduct(String barcodeSymbologyChange, String taxMethodChange) throws InterruptedException {
        js.executeScript("arguments[0].scrollIntoView(true);", barcodeSymbologyBoxElement);

        getWebDriverWait().until(ExpectedConditions.visibilityOf(barcodeSymbologyBoxElement));
        barcodeSymbologyBoxElement.click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(barcodeSymbologySearchElement));
        barcodeSymbologySearchElement.sendKeys(barcodeSymbologyChange);
        actions.sendKeys(Keys.ENTER).perform();

        js.executeScript("arguments[0].scrollIntoView(true);", taxMethodBox);
        taxMethodBox.click();
        Thread.sleep(1000);
        WebElement taxChangeElement = getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select2-result-label' and text()='" + taxMethodChange + "']")));
        taxChangeElement.click();

        js.executeScript("arguments[0].scrollIntoView(true);", editProductButton);
        editProductButton.click();
    }

    public boolean VerifyEditProductSuccess(String messageVerify) throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(alertMessageElement));
        Thread.sleep(3000);
        return alertMessageElement.getText().contains(messageVerify);
    }

}
