package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement alertMessageElement;
    @FindBy(xpath = "//h2[normalize-space()='Overview Chart']")
    private WebElement overviewChartElement;
    @FindBy(xpath = "//h2[normalize-space()='Quick Links']")
    private WebElement quickLinkElement;
    @FindBy(xpath = "//h2[normalize-space()='Latest Five']")
    private WebElement latestFiveElement;
    @FindBy(xpath = "(//div[@class='col-sm-6'])[1]")
    private WebElement bestSellerElement1;
    @FindBy(xpath = "(//div[@class='col-sm-6'])[2]")
    private WebElement bestSellerElement2;
    @FindBy(xpath = "//span[normalize-space()='Products']")
    private WebElement productsMenuElement;
    @FindBy(xpath = "//span[normalize-space()='List Products']")
    private WebElement listProductsSubMenuElement;

    @FindBy(xpath = "//span[normalize-space()='Print Barcode/Label']")
    private WebElement printBarcodeLabelSubMenuElement;

    @FindBy(xpath = "//span[normalize-space()='Sales']")
    private WebElement salesMenuElement;

    @FindBy(xpath = "//span[normalize-space()='Add Sale']")
    private WebElement addSalesSubMenuElement;

    @FindBy(xpath = "//span[normalize-space()='Purchases']")
    private WebElement purchasesMenuElement;

    @FindBy(xpath = "//span[normalize-space()='List Purchases']")
    private WebElement listPurchasesSubMenuElement;

    @FindBy(xpath = "//span[normalize-space()='Add Purchase']")
    private WebElement addPurchasesSubMenuElement;

    public DashboardPage(WebDriver d) {
        super(d);
    }

    public boolean VerifyLoginSuccessfully(String messageVerify) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(alertMessageElement));
        return alertMessageElement.getText().contains(messageVerify) && overviewChartElement.isDisplayed()
                && quickLinkElement.isDisplayed() && latestFiveElement.isDisplayed()
                && bestSellerElement1.isDisplayed() && bestSellerElement2.isDisplayed();
    }

    public void navigateToListProductsPage() throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productsMenuElement));
        Thread.sleep(2000);
        productsMenuElement.click();
        Thread.sleep(2000);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(listProductsSubMenuElement));
        listProductsSubMenuElement.click();
    }

    public void navigateToPrintBarcodeLabelPage() throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productsMenuElement));
        Thread.sleep(1000);
        productsMenuElement.click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(printBarcodeLabelSubMenuElement));
        printBarcodeLabelSubMenuElement.click();
    }

    public void navigateToAddSalePage() throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(salesMenuElement));
        Thread.sleep(1000);
        salesMenuElement.click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addSalesSubMenuElement));
        addSalesSubMenuElement.click();
    }

    public void navigateToListPurchasesPage() throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(purchasesMenuElement));
        Thread.sleep(2000);
        purchasesMenuElement.click();

        getWebDriverWait().until(ExpectedConditions.visibilityOf(listPurchasesSubMenuElement));
        listPurchasesSubMenuElement.click();
    }

    public void navigateToAddPurchasesPage() throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(purchasesMenuElement));
        Thread.sleep(2000);
        purchasesMenuElement.click();

        getWebDriverWait().until(ExpectedConditions.visibilityOf(addPurchasesSubMenuElement));
        addPurchasesSubMenuElement.click();
    }


}
