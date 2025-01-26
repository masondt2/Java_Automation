package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PlansPage extends BasePage {
    public PlansPage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "//span[normalize-space()='Free Plan']")
    private WebElement freePlanElement;

    @FindBy(xpath = "//span[normalize-space()='Platinum']")
    private WebElement platiumElement;

    @FindBy(xpath = "//span[normalize-space()='Gold']")
    private WebElement goldElement;

    @FindBy(xpath = "//span[normalize-space()='Silver']")
    private WebElement silverElement;

    @FindBy(xpath = "//div[@class='col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12']")
    private List<WebElement> listPlansElement;

    @FindBy(xpath = "//table[@class='table mb-0 dataTable dataTable-table']/tbody/tr")
    private List<WebElement> listOrdersDisplayElement;

    //table[@class='table mb-0 dataTable dataTable-table']/tbody/tr

    public boolean VerifyPlansPageDisplay(String planDisplay, String orderDisplay){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(freePlanElement));

        boolean checkNoOfPlans = listPlansElement.size() == Integer.parseInt(planDisplay);
        if(checkNoOfPlans){
            System.out.println("Number of plans displayed: " + listPlansElement.size());
        }

        boolean flag = true;
        int countDisplay = 0;
        for( int i = 0; i < listPlansElement.size(); i++ ){
            if(listPlansElement.get(i).isDisplayed()){
                System.out.println(getDriver().findElement(By.xpath("(//div[@class='col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12'])["+(i+1)+"]//div[@class='card-body']/span")).getText()+ " is Displayed");
                countDisplay+=1;
            }
        }
        if (countDisplay != listPlansElement.size()){
            flag = false;
        }

        boolean checkNoOfOrders = listOrdersDisplayElement.size() == Integer.parseInt(orderDisplay);
        System.out.println("Number of orders displayed: " + listOrdersDisplayElement.size());

        return checkNoOfPlans && flag && checkNoOfOrders;

    }



}
