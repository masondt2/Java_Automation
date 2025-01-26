package Steps;

import Pages.CategoryPage;
import Pages.DashBoardPage;
import Pages.DefaultDeliveryLocationPage;
import Pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MyStepdefs {
    HomePage homePage = new HomePage();
    DefaultDeliveryLocationPage defaultDeliveryLocationPage = new DefaultDeliveryLocationPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    CategoryPage categoryPage = new CategoryPage();

    @Given("Open eCart Application successfully")
    public void openECartApplicationSuccessfully() {
        
    }

    @Then("Verify Home Screen")
    public void verifyHomeScreen() {
        Assert.assertTrue(homePage.verifyHomeScreen());
    }

    @When("Click to next")
    public void clickToNext() {
        homePage.clickToNext();
    }

    @And("Click to Get Started")
    public void clickToGetStarted() {
        homePage.clickToGetStarted();
    }

    @Then("Verify Default Delivery Location Screen")
    public void verifyDefaultDeliveryLocationScreen(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String strLocationVerify = ls.getFirst().get("Value");
        List<String> lstVerify = Arrays.asList(strLocationVerify.split(","));

        Assert.assertTrue(defaultDeliveryLocationPage.verifyDefaultDeliveryLocationScreen(lstVerify));

    }

    @And("Select Target Verify Location")
    public void selectTargetVerifyLocation(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String targetVerifyLocation = ls.getFirst().get("Value");
        defaultDeliveryLocationPage.selectTargetVerifyLocation(targetVerifyLocation);
    }

    @And("Click to Category menu item")
    public void clickToCategoryMenuItem() {
        dashBoardPage.clickToCategoryMenuItem();
    }

    @Then("Verify Category Screen")
    public void verifyCategoryScreen(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String num = ls.getFirst().get("Value");
        String lstNameVerify = ls.get(1).get("Value");
        List<String> lstNameVerifyList = Arrays.asList(lstNameVerify.split(","));
        Assert.assertTrue(categoryPage.verifyCategoryScreen(num, lstNameVerifyList));
    }
}
