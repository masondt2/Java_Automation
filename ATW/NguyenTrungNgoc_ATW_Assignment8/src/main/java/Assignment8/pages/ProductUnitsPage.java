package Assignment8.pages;

import Assignment8.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductUnitsPage extends BasePage {
    public ProductUnitsPage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "//h3[normalize-space()='Product Units']")
    private WebElement productUnitsIcon;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> lsProductUnits;

    public boolean IsProductUnitDisplayProperty(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(productUnitsIcon));
        String nameOfFirstProduct = lsProductUnits.get(0).findElement(By.xpath("((//tbody/tr)[1]/td)[2]")).getText();
        System.out.println("Name of First Product: "+nameOfFirstProduct);
        String nameOfSecondProduct = lsProductUnits.get(1).findElement(By.xpath("((//tbody/tr)[2]/td)[2]")).getText();
        System.out.println("Name of Second Product: "+nameOfSecondProduct);
        return !(lsProductUnits.isEmpty()) && !(nameOfFirstProduct.isEmpty()) && !(nameOfSecondProduct.isEmpty());
    }
}
