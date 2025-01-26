package Steps;

import Pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MyStepdefs {
    HomePage homePage = new HomePage();
    DefaultDeliveryLocationPage defaultDeliveryLocationPage = new DefaultDeliveryLocationPage();
    DashBoardPage dashboardPage = new DashBoardPage();
    CategoryPage categoryPage = new CategoryPage();
    ProductOfCategoryPage productOfCategoryPage = new ProductOfCategoryPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    CartPage cartPage = new CartPage();
    WelcomeToeCartPage welcomeToeCartPage = new WelcomeToeCartPage();
    AddressesPage addressesPage = new AddressesPage();
    PaymentPage paymentPage = new PaymentPage();
    ProfilePage profilePage = new ProfilePage();

    @Given("Open eCart application successfully")
    public void openECartApplicationSuccessfully() {
    }

    @Then("Verify Home screen")
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

    @Then("Verify The Default Delivery Location screen")
    public void verifyTheDefaultDeliveryLocationScreen(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String strLocationVerify = ls.getFirst().get("Value");
        List<String> lsLocationVerify = Arrays.asList(strLocationVerify.split(","));
        Assert.assertTrue(defaultDeliveryLocationPage.verifyTheDefaultDeliveryLocationScreen(lsLocationVerify));
    }

    @And("Select target location")
    public void selectTargetLocation(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String targetLocationName = ls.getFirst().get("Value");
        defaultDeliveryLocationPage.selectTargetLocation(targetLocationName);
    }

    @And("Click to Category menu item")
    public void clickToCategoryMenuItem() {
        dashboardPage.clickToCategoryMenuItem();
    }

    @Then("Verify The Category screen")
    public void verifyTheCategoryScreen(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        int numOfProductsVerify = Integer.parseInt(ls.get(0).get("Value"));
        String strLstProductsVerify = ls.get(1).get("Value");
        List<String> lstProductsVerify = Arrays.asList(strLstProductsVerify.split(","));
        Assert.assertTrue(categoryPage.verifyTheCategoryScreen(numOfProductsVerify, lstProductsVerify));
    }

    @And("Scroll to Target Product")
    public void scrollToTargetProduct(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String targetProductName = ls.getFirst().get("Value");
        dashboardPage.scrollToTargetProduct(targetProductName);
    }

    @Then("Verify the number of Target Product in Category screen")
    public void verifyNumOfTargetProductCategory(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String targetProductName = ls.get(0).get("Value");
        int numOfProductsVerify = Integer.parseInt(ls.get(1).get("Value"));
        Assert.assertTrue(dashboardPage.verifyNumOfTargetProductCategory(targetProductName, numOfProductsVerify));

    }

    @And("Click to View All of Target Product")
    public void clickToViewAll(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String targetProductName = ls.getFirst().get("Value");
        dashboardPage.clickToViewAll(targetProductName);
    }

    @Then("Verify the number of Target Product in Product screen")
    public void verifyTheNumberOfTargetProductScreen(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        int numOfProductsVerify = Integer.parseInt(ls.getFirst().get("Value"));
        Assert.assertTrue(productOfCategoryPage.verifyTheNumberOfTargetProduct(numOfProductsVerify));
    }

    @And("Click to Verify Product")
    public void clickToVerifyProduct(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String productNameVerify = ls.getFirst().get("Value");
        productOfCategoryPage.clickToVerifyProduct(productNameVerify);
    }

    @Then("Verify The product detail screen")
    public void verifyTheProductDetailScreen(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String productNameVerify = ls.get(0).get("Value");
        String productPriceVerify = ls.get(1).get("Value");
        Assert.assertTrue(productDetailPage.verifyTheProductDetailScreen(productNameVerify, productPriceVerify));

    }

    @And("Click to Target Product Of Category Page")
    public void clickToTargetProductOfCategoryPage(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String targetProductName = ls.getFirst().get("Value");
        categoryPage.clickToTargetProductOfCategoryPage(targetProductName);
    }

    @And("Click Add to Cart with Quantity of Verify Product")
    public void clickAddToCartWithQuantityProduc(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        int quantity = Integer.parseInt(ls.get(0).get("Value"));
        String productNameVerify = ls.get(1).get("Value");
        productOfCategoryPage.clickAddToCartWithQuantityProduc(quantity, productNameVerify);

    }

    @And("Click to Cart icon on top screen")
    public void clickToCartIconOnTopScreen() {
        productOfCategoryPage.clickToCartIconOnTopScreen();
    }

    @Then("Verify Cart screen")
    public void verifyCartScreen(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String pincodeValueVerify = ls.get(0).get("Value");
        String productNameVerify = ls.get(1).get("Value");
        String productPriceVerify = ls.get(2).get("Value");
        String productMeasurementVerify = ls.get(3).get("Value");
        String quantityVerify = ls.get(4).get("Value");
        String productTotalPriceVerify = ls.get(5).get("Value");
        Assert.assertTrue(cartPage.verifyCartScreen(pincodeValueVerify, productNameVerify, productPriceVerify, productMeasurementVerify, quantityVerify, productTotalPriceVerify));

    }

    @And("Click to CONTINUE button")
    public void clickToCONTINUEButton() {
        cartPage.clickToCONTINUEButton();
    }

    @And("Click to Login button of Welcome toeCart")
    public void clickToLoginButton() {
        welcomeToeCartPage.clickToLoginButton();
    }

    @And("Select type of address")
    public void selectTypeOfAddress(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String addressesType = ls.getFirst().get("Value");
        addressesPage.selectTypeOfAddress(addressesType);
    }

    @Then("Verify Payment screen")
    public void verifyPaymentScreen(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String pincodeVerify = ls.get(0).get("Value");
        String grandTotalVerify = ls.get(1).get("Value");
        Assert.assertTrue(paymentPage.verifyPaymentScreen(pincodeVerify, grandTotalVerify));

    }

    @And("Click to Profile on footer menu")
    public void clickToProfileOnFooterMenu() {
        dashboardPage.clickToProfileOnFooterMenu();
    }

    @And("Click to Welcome Guest")
    public void clickToWelcomeGuest() {
        profilePage.clickToWelcomeGuest();
    }

    @Then("Verify The login screen on Welcome toeCart page")
    public void verifyTheLoginScreenOnWelcomeToeCartPage() {
        Assert.assertTrue(welcomeToeCartPage.verifyTheLoginScreenOnWelcomeToeCartPage());
    }

    @Then("Verify profile screen")
    public void verifyProfileScreen(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String profileSubMenuVerify = ls.getFirst().get("Value");
        List<String> lstProfileSubMenuVerify = Arrays.asList(profileSubMenuVerify.split(","));
        Assert.assertTrue(profilePage.verifyProfileScreen(lstProfileSubMenuVerify));
    }
}



