package pages;

import core.BasePage;
import core.BasicMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductCategoriesPage extends BasePage {
    public ProductCategoriesPage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "(//h3[normalize-space()='Product Categories'])[1]/..")
    private WebElement productCategoryTitle;

    @FindBy(xpath = "(//button[@class='btn ml-2 p-0 kt_notes_panel_toggle'])[1]/..")
    private WebElement addProductBtn;

    @FindBy(xpath = "//div[contains(@class,'tabslang')]/div")
    private List<WebElement> lstLanguage;

    @FindBy(xpath = "(//input[@name='name0'])[1]")
    private WebElement inputNameField;

    @FindBy(xpath = "//div[@class='ql-editor ql-blank']//p/..")
    private WebElement inputDescriptionField;

    public static String inputChrome = "Demo_Chrome_".concat(BasicMethod.generateRandomString(4));
    public static String inputFirefox = "Demo_Firefox_".concat(BasicMethod.generateRandomString(4));

    public void addProductCategoryChrome(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productCategoryTitle));
        addProductBtn.click();

        getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(lstLanguage));

        for(int i =0; i<lstLanguage.size(); i++){
            lstLanguage.get(i).click();

            WebElement inputNameFieldi = getDriver().findElement(By.xpath("(//input[@name='name"+i+"'])[1]"));
            inputNameFieldi.click();
            inputNameFieldi.sendKeys(inputChrome);

            getWebDriverWait().until(ExpectedConditions.visibilityOf(inputDescriptionField));
            inputDescriptionField.sendKeys(inputChrome);
        }
    }

    public void addProductCategoryFireFox() throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productCategoryTitle));
        Thread.sleep(2000);
        addProductBtn.click();

        getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(lstLanguage));

        for(int i =0; i<lstLanguage.size(); i++){
            lstLanguage.get(i).click();

            WebElement inputNameFieldi = getDriver().findElement(By.xpath("(//input[@name='name"+i+"'])[1]"));
            inputNameFieldi.click();
            inputNameFieldi.sendKeys(inputFirefox);

            getWebDriverWait().until(ExpectedConditions.visibilityOf(inputDescriptionField));
            inputDescriptionField.sendKeys(inputFirefox);
        }
    }


}
