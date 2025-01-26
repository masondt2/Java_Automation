package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ListProductsPage extends BasePage {
    Actions actions = new Actions(getDriver());

    @FindBy(xpath = "//table[@id='PRData']/thead/tr/th")
    private List<WebElement> lstTitleTableElement;

    @FindBy(xpath = "//input[contains(@aria-controls,'PRData')]")
    private WebElement searchInputElement;

    @FindBy(xpath = "//h4[@id='myModalLabel']")
    private WebElement titleDetailProductElement;

    @FindBy(xpath = "//img[@id='pr-image']")
    private WebElement imageDetailElement;

    @FindBy(xpath = "//img[(@alt='FFR03')]")
    private WebElement barcodeElement;

    @FindBy(xpath = "//img[@alt='https://sma.tec.sh/admin/products/view/3']")
    private WebElement qrElement;

    @FindBy(xpath = "//div[@class='panel-heading']")
    private WebElement productDetailsElement;

    @FindBy(xpath = "//table[@class='table table-borderless table-striped dfTable table-right-left']/tbody/tr")
    private List<WebElement> lstInforProductElement;

    @FindBy(xpath = "//span[normalize-space()='Edit']")
    private WebElement editButton;

    public ListProductsPage(WebDriver d) {
        super(d);
    }

    public boolean VerifyProductTable(List<String> lstTitleVerify) {
        boolean flag = true;
        for (int i = 1, j = 0; i <= lstTitleVerify.size(); i++, j++) {
            flag = flag && lstTitleTableElement.get(i).getText().equals(lstTitleVerify.get(j));
            System.out.println(lstTitleTableElement.get(i).getText() + " " + flag);
        }
        return flag;
    }

    public void navigateToDetailProductPage(String productName) throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(searchInputElement));
        searchInputElement.sendKeys(productName);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='PRData']/tbody/tr[1]/td[4]"))).click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(titleDetailProductElement));
    }

    public boolean VerifyViewDetailsProduct(List<String> lstInforVerify) {
        boolean flag = true;
        for (int i = 2, j = 0; i < lstInforProductElement.size(); i++, j++) {
            flag = flag && lstInforProductElement.get(i).getText().equals((lstInforVerify.get(j)));
            System.out.println(lstInforProductElement.get(i).getText() + " " + flag);
        }
        return flag && imageDetailElement.isDisplayed()
                && imageDetailElement.isDisplayed()
                && barcodeElement.isDisplayed()
                && qrElement.isDisplayed()
                && productDetailsElement.isDisplayed();
    }

    public void navigateToEditProductPage() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(editButton));
        editButton.click();
    }
}
