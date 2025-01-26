package pages;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddPurchasePage extends BasePage {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    @FindBy(xpath = "//h2[normalize-space()='Add Purchase']")
    private WebElement addPurchaseTitleElement;

    @FindBy(xpath = "(//i[@id='addIcon'])[2]")
    private WebElement addSupplierButtonElement;

    @FindBy(xpath = "//input[@id='company']")
    private WebElement companyInputElement;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameInputElement;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement emailInputElement;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneInputElement;

    @FindBy(xpath = "//input[@id='address']")
    private WebElement addressInputElement;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityInputElement;

    @FindBy(xpath = "//input[@name='add_supplier']")
    private WebElement addSupplierElement;

    @FindBy(xpath = "//input[@id='add_item']")
    private WebElement addProductInputElement;

    @FindBy(xpath = "//input[@id='add_pruchase']")
    private WebElement submitButtonElement;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement alertMessageElement;

    public AddPurchasePage(WebDriver d) {
        super(d);
    }

    public void AddPurchase(String company, String name, String email, String phone, String address, String city, String addProductPurchase) throws InterruptedException {
        js.executeScript("arguments[0].scrollIntoView(true);", addPurchaseTitleElement);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addSupplierButtonElement));
        Thread.sleep(2000);
        addSupplierButtonElement.click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(companyInputElement));
        Thread.sleep(2000);
        companyInputElement.sendKeys(company);

        nameInputElement.sendKeys(name);
        emailInputElement.sendKeys(email+BaseTest.generateRandomString(3)+"@tecdairy.com");
        phoneInputElement.sendKeys(phone);
        addressInputElement.sendKeys(address);
        cityInputElement.sendKeys(city);

        addSupplierElement.click();
        Thread.sleep(2000);
        addProductInputElement.sendKeys(addProductPurchase);

        js.executeScript("arguments[0].scrollIntoView(true);", submitButtonElement);
        Thread.sleep(2000);
        submitButtonElement.click();
    }

    public boolean VerifyAddPurchasesMessage(String addPurchasesMessage) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(alertMessageElement));
        return alertMessageElement.getText().contains(addPurchasesMessage);
    }
}
