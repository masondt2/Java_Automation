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
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    VirtualCardPage virtualCardPage = new VirtualCardPage();
    BuyANewVirtualCardPage buyANewVirtualCardPage = new BuyANewVirtualCardPage();
    MenuLeftPage menuLeftPage = new MenuLeftPage();
    RequestMoneyPage requestMoneyPage = new RequestMoneyPage();
    SettingPage settingPage = new SettingPage();


    @Given("Open Wallet application successfully")
    public void openWalletApplicationSuccessfully() {
        homePage.clickToLoginHome();
    }

    @When("Input email & password")
    public void inputEmailPassword(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String emailInput = ls.get(0).get("Value");
        String passwordInput = ls.get(1).get("Value");
        loginPage.inputEmailPassword(emailInput, passwordInput);

    }

    @And("Click to login")
    public void clickToLogin() {
        loginPage.clickToLogin();
    }

    @Then("Verify The Dashboard screen display: Deposits and WithDrawals tab")
    public void verifyTheDashboardScreenDisplay() {
        Assert.assertTrue(dashboardPage.verifyTheDashboardScreenDisplay());
    }

    @And("Verify In Deposits tab display Deposit to Us Dollar with Amount =")
    public void verifyAmountInDepositsTab(DataTable dataTable) {
        List<Map<String, String>> ls = dataTable.asMaps();
        String amountVerify = ls.get(0).get("Value");
        Assert.assertTrue(dashboardPage.verifyAmountInDepositsTab(amountVerify));

    }

    @And("Click to icon Virtual Cards at footer menu")
    public void clickToVirtualCards() {
        dashboardPage.clickToIconVirtualCards();
    }

    @And("Click to Buy Card")
    public void clickToBuyCard() {
        virtualCardPage.clickToBuyCard();
    }

    @Then("Verify The Buy a New Virtual Card display Name textbox and Fund button")
    public void verifyTheBuyANewVirtualCardDisplay() {
        Assert.assertTrue(buyANewVirtualCardPage.verifyTheBuyANewVirtualCardDisplay());
    }

    @And("Click to menu left icon")
    public void clickToMenuLeftIcon() throws InterruptedException {
        dashboardPage.clickToMenuLeftIcon();
    }

    @And("Click to request")
    public void clickToRequest() {
        menuLeftPage.clickToRequest();
    }

    @Then("Verify The Request money display with Amount textbox, Email textbox, Request description and Send button")
    public void verifyTheRequestMoneyScrennDisplay() {
        Assert.assertTrue(requestMoneyPage.verifyTheRequestMoneyScrennDisplay());
    }

    @And("Click to Setting")
    public void clickToSetting() {
        menuLeftPage.clickToSetting();
    }

    @And("Scroll to Change Password")
    public void scrollToChangePassword() {
        settingPage.scrollToChangePassword();
    }

    @Then("Verify The Change password screen display 3 textbox: Current password, New password, Repeat New Password")
    public void verifyTheChangePasswordScreenDisplay() {
        Assert.assertTrue(settingPage.verifyTheChangePasswordScreenDisplay());
    }

    @And("Input Name on Card")
    public void inputNameOnCard() {
        buyANewVirtualCardPage.inputNameOnCard();
    }

    @And("Click to the Fund button")
    public void clickToTheFundButton(){
        buyANewVirtualCardPage.clickToTheFundButton();
    }

    @And("Add 10 USD amount")
    public void add10USDAmount(){
        buyANewVirtualCardPage.add10USDAmount();
    }

    @And("Click to next icon")
    public void clickToNextIcon() {
        buyANewVirtualCardPage.clickToNextIcon();
    }

    @Then("Verify The screen display error message: No sufficient funds")
    public void verifyTheScreenDisplayErrorMessageNoSufficientFunds() {
        Assert.assertTrue(buyANewVirtualCardPage.verifyTheScreenDisplayError());
    }
}
