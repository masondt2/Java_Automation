package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PrintBarcodeLabelPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TC7_VerifyCreatePrintBarcode extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC7_VerifyCreatePrintBarcode(String url, String username, String password, String productName, String style, String printLabelsVerify, String inforsVerify) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.navigateToPrintBarcodeLabelPage();

        PrintBarcodeLabelPage printBarcodeLabelPage = new PrintBarcodeLabelPage(getDriver());
        List<String> lstPrintLabelVerify = new ArrayList<>(Arrays.asList(printLabelsVerify.split(",")));
        printBarcodeLabelPage.CreatePrintBarcodeLabelPage(productName, style, lstPrintLabelVerify);

        List<String> lstInforVerify = new ArrayList<>(Arrays.asList(inforsVerify.split(";")));
        Assert.assertTrue(printBarcodeLabelPage.VerifyBarcodeInforDisplay(lstInforVerify));

        System.out.println("========================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/FinalTest.xlsx", "TC7_VerifyCreatePrintBarcode", 1, 7);
    }
}

