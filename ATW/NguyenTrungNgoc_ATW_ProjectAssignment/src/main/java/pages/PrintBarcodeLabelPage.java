package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class PrintBarcodeLabelPage extends BasePage {
    Actions actions = new Actions(getDriver());
    @FindBy(xpath = "//label[normalize-space()='Add Product']")
    private WebElement addProductElement;

    @FindBy(xpath = "//label[normalize-space()='Style *']")
    private WebElement styleElement;

    @FindBy(xpath = "(//div[@class='form-group'])[6]/label")
    private List<WebElement> lstPrintTitleElement;

    @FindBy(id = "add_item")
    private WebElement addProductInputElement;

    @FindBy(xpath = "//div[@id='s2id_style']")
    private WebElement styleBoxElement;

    @FindBy(xpath = "//input[@id='s2id_autogen1_search']")
    private WebElement styleSearchElement;

    @FindBy(xpath = "//input[@name='print']")
    private WebElement updateButtonElement;

    //Print Barcode Label after updating:
    @FindBy(xpath = "//span[@class='product_image']//img")
    private WebElement imageElement;

    @FindBy(xpath = "//img[@alt='FFR02']")
    private WebElement barcodeElement;

    @FindBy(xpath = "//div[@class='barcodea4']//span")
    private List<WebElement> lstPrintInforElement;

    public PrintBarcodeLabelPage(WebDriver d) {
        super(d);
    }

    public boolean VerifyPrintBarcodeLabelPageDisplay(List<String> lstPrintVerify) {
        boolean flag = true;
        for (int i = 0, j = 0; i < lstPrintTitleElement.size(); i++, j++) {
            if (!(lstPrintTitleElement.get(i).getText().toUpperCase().equals(lstPrintVerify.get(j).toUpperCase()))) {
                flag = false;
            }
            ;
            System.out.println(lstPrintTitleElement.get(i).getText() + " :" + flag);
        }
        return flag && addProductElement.isDisplayed() && styleElement.isDisplayed();
    }

    public void CreatePrintBarcodeLabelPage(String productName, String style, List<String> lstPrintCheckVerify) throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addProductInputElement));
        addProductInputElement.sendKeys(productName);
        Thread.sleep(1000);
        styleBoxElement.click();
        Thread.sleep(1000);
        styleSearchElement.sendKeys(style);
        actions.sendKeys(Keys.ENTER).perform();

        //get List of Label Print WebElement Checked
        List<WebElement> lstBoxCheckedPrint = getDriver().findElements(By.xpath("//div[@class='icheckbox_square-blue checked']/input"));
        List<WebElement> lstLabelCheckedPrint = new ArrayList<WebElement>();
        for (int i = 0; i < lstBoxCheckedPrint.size(); i++) {
            WebElement labelElement = getDriver().findElement(By.xpath("//label[@for='" + lstBoxCheckedPrint.get(i).getAttribute("name") + "']"));
            lstLabelCheckedPrint.add(labelElement);
        }

        //get List of Label Print WebElement Unchecked
        List<WebElement> lstBoxUnCheckedPrint = getDriver().findElements(By.xpath("//div[@class='icheckbox_square-blue']/input"));
        List<WebElement> lstLabelUnCheckedPrint = new ArrayList<WebElement>();
        for (int i = 0; i < lstBoxUnCheckedPrint.size(); i++) {
            WebElement labelElement = getDriver().findElement(By.xpath("//label[@for='" + lstBoxUnCheckedPrint.get(i).getAttribute("name") + "']"));
            lstLabelUnCheckedPrint.add(labelElement);
        }

        //Compare list Checked with list input
        for (int i = 0; i < lstLabelCheckedPrint.size(); i++) {
            int count = 0;
            for (int j = 0; j < lstPrintCheckVerify.size(); j++) {
                if (lstLabelCheckedPrint.get(i).getText().toUpperCase().equals(lstPrintCheckVerify.get(j).toUpperCase())) {
                    count++;
                }
            }
            if (count == 0) {
                lstLabelCheckedPrint.get(i).click();
            }
        }

        //Compare list UnChecked with list input
        for (int i = 0; i < lstLabelUnCheckedPrint.size(); i++) {
            int count = 0;
            for (int j = 0; j < lstPrintCheckVerify.size(); j++) {
                if (lstLabelUnCheckedPrint.get(i).getText().toUpperCase().equals(lstPrintCheckVerify.get(j).toUpperCase())) {
                    count++;
                }
            }
            if (count != 0) {
                lstLabelUnCheckedPrint.get(i).click();
            }
        }

        updateButtonElement.click();

    }

    public boolean VerifyBarcodeInforDisplay(List<String> lstInforVerify) {
        boolean flag = true;
        for (int i = 1, j = 0; i < lstPrintInforElement.size() - 1; i++, j++) {
            if (!(lstPrintInforElement.get(i).getText().toUpperCase().contains(lstInforVerify.get(j).toUpperCase()))) {
                flag = false;
            }
            ;
            System.out.println(lstPrintInforElement.get(i).getText() + " :" + flag);
        }
        if (imageElement.isDisplayed()) {
            System.out.println("product_image is displayed");
        }
        if (barcodeElement.isDisplayed()) {
            System.out.println("barcode_image is displayed");
        }
        return flag && imageElement.isDisplayed() && barcodeElement.isDisplayed();
    }
}
