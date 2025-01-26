package pages;

import core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddSalePage extends BasePage {
    Actions actions = new Actions(getDriver());
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    @FindBy(xpath = "//span[@id='select2-chosen-12']")
    private WebElement customerBoxElement;
    @FindBy(xpath = "//input[@id='s2id_autogen12_search']")
    private WebElement customerSearchElement;
    @FindBy(xpath = "//input[@id='add_item']")
    private WebElement addProductInputElement;

    //div[@class='select2-result-label' and text()='Completed']
    //sale status choose
    @FindBy(xpath = "//span[@id='select2-chosen-5']")
    private WebElement saleStatusBoxElement;

    //div[@class='select2-result-label' and text()='Partial']
    //payment status choose
    @FindBy(xpath = "//span[@id='select2-chosen-6']")
    private WebElement paymentStatusBoxElement;
    @FindBy(xpath = "//input[@id='add_sale']")
    private WebElement submitButtonElement;
    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement saveAlertElement;
    public AddSalePage(WebDriver d) {
        super(d);
    }

    public void addSale(String customerName, String productName, String saleStatus, String paymentStatus) throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(customerBoxElement));
        Thread.sleep(2000);
        customerBoxElement.click();
        //customerSearchElement.clear();
        customerSearchElement.sendKeys(customerName);
        Thread.sleep(2000);
        actions.sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);
        addProductInputElement.sendKeys(productName);
        actions.sendKeys(Keys.ENTER).perform();

        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", submitButtonElement);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(submitButtonElement));
        saleStatusBoxElement.click();
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select2-result-label' and text()='" + saleStatus + "']"))).click();

        Thread.sleep(2000);
        paymentStatusBoxElement.click();
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select2-result-label' and text()='" + paymentStatus + "']"))).click();

        submitButtonElement.click();

    }

    public boolean VerifyAddSaleAlertMessage(String alertMessageVerify) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(saveAlertElement));
        return saveAlertElement.getText().contains(alertMessageVerify);
    }
}
