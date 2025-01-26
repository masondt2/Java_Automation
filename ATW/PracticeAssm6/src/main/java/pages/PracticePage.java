package pages;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PracticePage extends BasePage {
    public PracticePage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "//legend[normalize-space()='Switch To Alert Example']")
    private WebElement alertTitle;

    @FindBy(xpath = "//div[@id='alert-example-div']//input[@id='name']")
    private WebElement alertInput;

    @FindBy(xpath = "//input[@id='alertbtn']")
    private WebElement alertButton;

    public void navigateToPracticePage(String url) {
        getDriver().get(url);
    }

    public void inputAlert(String valueAlertInput){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(alertTitle));
        getWebDriverWait().until(ExpectedConditions.visibilityOf(alertInput));
        alertInput.sendKeys(valueAlertInput);
        alertButton.click();
    }

    public boolean verifyAlert(String valueAlertInput){
        try{

            Alert alert = getWebDriverWait().until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert message: " + alert.getText());
            Assert.assertTrue(alert.getText().contains(valueAlertInput));
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
