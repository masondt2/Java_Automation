package Steps;

import Pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class MyStepdefs {
    LoginPage homePage = new LoginPage();

    @And("Click to Target Product")
    public void clickToTargetProduct(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String targetProductName = ls.getFirst().get("Value");
        listOfProductPage.clickToTargetProduct(targetProductName);

    }

}
