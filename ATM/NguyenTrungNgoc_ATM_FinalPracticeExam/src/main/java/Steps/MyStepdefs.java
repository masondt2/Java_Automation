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
    HomePage homePage = new HomePage();
    CategoryPage categoryPage = new CategoryPage();
    ListOfProductPage listOfProductPage = new ListOfProductPage();
    FilterPage filterPage = new FilterPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    AccountPage accountPage = new AccountPage();
    LoginPage loginPage = new LoginPage();
    ShippingMethodPage shippingMethodPage = new ShippingMethodPage();
    CountryRegionPage countryRegionPage = new CountryRegionPage();
    AddProductToCartPage addProductToCartPage = new AddProductToCartPage();
    CartDetailPage cartDetailPage = new CartDetailPage();

    @Given("Open Banggood Easy Online Shopping Application successfully")
    public void openBanggoodEasyOnlineShoppingApplicationSuccessfully() {
        homePage.clickAllowButton();
    }

    @When("Click to the Category on footer menu")
    public void clickToTheCategoryOnFooterMenu() {
        homePage.clickToTheCategoryOnFooterMenu();
    }

    @And("Scroll to Home and Garden in Left menu")
    public void scrollToHomeAndGardenInLeftMenu() {
        categoryPage.scrollToHomeAndGardenInLeftMenu();
    }

    @And("Click to Home and Garden in Left menu")
    public void clickToHomeAndGardenInLeftMenu() {
        categoryPage.clickToHomeAndGardenInLeftMenu();
    }

    @And("Click to Home Decor at the right category")
    public void clickToHomeDecorAtTheRightCategory() {
        categoryPage.clickToHomeDecorAtTheRightCategory();
    }

    @And("Click to Filter")
    public void clickToFilter() {
        listOfProductPage.clickToFilter();
    }

    @And("Select COD")
    public void selectCOD() {
        filterPage.selectCOD();
    }

    @And("Click Done")
    public void clickDone() {
        filterPage.clickDone();
    }

    @And("Click First Product")
    public void clickFirstProduct() {
        listOfProductPage.clickFirstProduct();
    }

    @Then("Verify Product Detail screen display Product Name")
    public void verifyProductDetailDisplayProductName() {
        Assert.assertTrue(productDetailPage.verifyProductDetailDisplayProductName());
    }

    @When("Click Account on footer menu")
    public void clickAccountOnFooterMenu() {
        homePage.clickAccountOnFooterMenu();
    }

    @And("Click View All Order")
    public void clickViewAllOrder() {
        accountPage.clickViewAllOrder();
    }

    @Then("Verify Login screen display Email")
    public void verifyLoginScreenDisplayEmail() {
        Assert.assertTrue(loginPage.verifyLoginScreenDisplayEmail());
    }

    @And("Verify Login screen display Password")
    public void verifyLoginScreenDisplayPassword() {
        Assert.assertTrue(loginPage.verifyLoginScreenDisplayPassword());
    }

    @And("Verify Login screen display Sign-In Button")
    public void verifyLoginScreenDisplaySignInButton() {
        Assert.assertTrue(loginPage.verifyLoginScreenDisplaySignInButton());
    }

    @When("Scroll to Hot Categories")
    public void scrollToHotCategories() {
        homePage.scrollToHotCategories();
    }

    @And("Click to Smartphone Category")
    public void clickToSmartphoneCategory() {
        homePage.clickToSmartphoneCategory();
    }

    @And("Click to Target Product")
    public void clickToTargetProduct(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String targetProductName = ls.getFirst().get("Value");
        listOfProductPage.clickToTargetProduct(targetProductName);

    }

    @And("Verify Product Detail screen display COD icon")
    public void verifyProductDetailScreenDisplayCODIcon() {
        Assert.assertTrue(productDetailPage.verifyProductDetailScreenDisplayCODIcon());
    }

    @And("Verify Product Detail screen display Product Price")
    public void verifyProductDetailScreenDisplayProductPrice() {
        Assert.assertTrue(productDetailPage.verifyProductDetailScreenDisplayProductPrice());
    }

    @And("Verify Product Detail screen display Buy Now Button")
    public void verifyProductDetailScreenDisplayBuyNowButton() {
        Assert.assertTrue(productDetailPage.verifyProductDetailScreenDisplayBuyNowButton());
    }

    @And("Verify Product Detail screen display Add to Cart Button")
    public void verifyProductDetailScreenDisplayAddToCartButton() {
        Assert.assertTrue(productDetailPage.verifyProductDetailScreenDisplayAddToCartButton());
    }

    @And("Scroll to Shipping")
    public void scrollToShipping() {
        productDetailPage.scrollToShipping();
    }

    @And("Change Shipping Address")
    public void changeShippingAddress(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String stateChange = ls.get(0).get("Value");
        String provinceChange = ls.get(1).get("Value");
        countryRegionPage.changeShippingAddress(stateChange, provinceChange);
    }

    @And("Click to Shipping")
    public void clickToShipping() {
        productDetailPage.clickToShipping();
    }

    @And("Click to SearchBox")
    public void clickToSearchBox() {
        shippingMethodPage.clickToSearchBox();
    }

    @And("Click to Continue")
    public void clickToContinue() {
        shippingMethodPage.clickToContinueButton();
    }

    @And("Click to Add to Cart")
    public void clickToAddToCart() {
        productDetailPage.clickToAddToCart();
    }

    @And("Click to Add to Cart Button")
    public void clickToAddToCartButton() {
        addProductToCartPage.clickToAddToCartButton();
    }

    @And("Click to Cart icon on Top")
    public void clickToCartIconOnTop() {
        productDetailPage.clickToCartIconOnTop();
    }

    @Then("Verify Cart Screen")
    public void verifyCartScreen() {
        Assert.assertTrue(cartDetailPage.verifyCartScreen());
    }
}
