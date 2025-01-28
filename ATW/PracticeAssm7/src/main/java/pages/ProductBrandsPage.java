package pages;

import core.BasePage;
import core.BasicMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;
import javax.swing.*;
import java.awt.*;

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

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    private WebElement searchField;

    //@FindBy(xpath = "//div[@class='v-toast v-toast-success v-toast-enter-to']")
    //@FindBy(xpath = "//div[@class='v-toast v-toast-success']")
    @FindBy(xpath = "//a[@class='v-toast-btn-clear']/..")
    private WebElement toastElement;

    public static String chromeBrandNameAdd = BasicMethod.generateRandomString(5);
    public static String chromeBrandName = "Demo_Chrome_".concat(chromeBrandNameAdd);

    public static String firefoxBrandNameAdd = BasicMethod.generateRandomString(4);
    public static String firefoxBrandName = "Demo_FireFox_".concat(firefoxBrandNameAdd);

    Actions actions = new Actions(getDriver());

    public void inputBrandNameChrome() throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addProductBrandsBtn));
        Thread.sleep(1000);
        addProductBrandsBtn.click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addBrandTitle));
        getWebDriverWait().until(ExpectedConditions.visibilityOf(inputBrandField)).sendKeys(chromeBrandName);

        getWebDriverWait().until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }

    public void inputBrandNameFireFox() throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addProductBrandsBtn));
        Thread.sleep(1000);
        addProductBrandsBtn.click();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(addBrandTitle));
        getWebDriverWait().until(ExpectedConditions.visibilityOf(inputBrandField)).sendKeys(firefoxBrandName);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }

    public boolean verifyChromeProductBrandCreateSuccess(){
        try{
            getWebDriverWait().until(ExpectedConditions.visibilityOf(toastElement));
            System.out.println(toastElement.getText());
            Assert.assertEquals(toastElement.getText(), "Settings has been updated successfully");

            getWebDriverWait().until(ExpectedConditions.visibilityOf(searchField));
            searchField.sendKeys(chromeBrandName);

            actions.sendKeys(Keys.ENTER).perform();
            Thread.sleep(5000);


            List<WebElement> lstResultElement = getDriver().findElements(By.xpath("//table[@id='productbrandTable']/tbody/tr"));
            getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(lstResultElement));

            for(int i=1; i<=lstResultElement.size(); i++){
                String statusi = getDriver().findElement(By.xpath("//table[@id='productbrandTable']/tbody/tr["+i+"]/td[4]")).getText();
                System.out.println(statusi);
                Assert.assertEquals(statusi, "active");
            }

            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean verifyFireFoxProductBrandCreateSuccess(){
        try{
            getWebDriverWait().until(ExpectedConditions.visibilityOf(toastElement));
            System.out.println(toastElement.getText());
            Assert.assertEquals(toastElement.getText(), "Settings has been updated successfully");

            getWebDriverWait().until(ExpectedConditions.visibilityOf(searchField));
            searchField.sendKeys(firefoxBrandName);

            actions.sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);
            actions.sendKeys(Keys.ENTER).perform();
            Thread.sleep(3000);

            List<WebElement> lstResultElement = getDriver().findElements(By.xpath("//table[@id='productbrandTable']/tbody/tr"));
            getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(lstResultElement));

            for(int i=1; i<=lstResultElement.size(); i++){
                String statusi = getDriver().findElement(By.xpath("//table[@id='productbrandTable']/tbody/tr["+i+"]/td[4]")).getText();
                System.out.println(statusi);
                Assert.assertEquals(statusi, "active");
            }

            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
