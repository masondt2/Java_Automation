package pages;

import core.BasePage;
import core.BasicMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class PlansPage extends BasePage {
    public PlansPage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "//h4[normalize-space()='Plans']/..")
    private WebElement plansTitle;

    @FindBy(xpath = "//div[@class='col-xxl-3 col-xl-4 col-lg-6 col-md-6 col-sm-6 col-12']//span[@class='price-badge bg-primary']")
    private List<WebElement> lstPlans;

    @FindBy(xpath = "(//table[@class='table mb-0 dataTable dataTable-table'])[1]/thead")
    private WebElement orderTableThead;

    @FindBy(xpath = "(//div[@class='dataTable-info'])[1]")
    private WebElement showing;

    @FindBy(xpath = "(//table[@class='table mb-0 dataTable dataTable-table'])[1]/tbody/tr")
    private List<WebElement> lstOrders;


    public boolean verifyPlansPage() {
        try{
            Assert.assertEquals(lstPlans.size(), 4);
            System.out.println("List of plans: ");
            for(WebElement plan : lstPlans){
                System.out.println(plan.getText());
            }
            BasicMethod.ScrollToElement(getDriver(),showing);

            System.out.println("List of orders displayed: "+lstOrders.size());
            Assert.assertEquals(lstOrders.size(), 10);

            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
