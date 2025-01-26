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

public class TC6_VerifyPrintBarcodeLabel extends BaseTest {
    @Test(dataProvider = "data")
    public void TestTC6_VerifyPrintBarcodeLabel(String url, String username, String password, String stringPrintVerify) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage(url);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.navigateToPrintBarcodeLabelPage();

        PrintBarcodeLabelPage printBarcodeLabelPage = new PrintBarcodeLabelPage(getDriver());
        List<String> lstPrintVerify = new ArrayList<>(Arrays.asList(stringPrintVerify.split(",")));
        printBarcodeLabelPage.VerifyPrintBarcodeLabelPageDisplay(lstPrintVerify);
        Assert.assertTrue(printBarcodeLabelPage.VerifyPrintBarcodeLabelPageDisplay(lstPrintVerify));

        System.out.println("The Print Barcode/Label page is verified!");
        System.out.println("========================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/FinalTest.xlsx", "TC6_VerifyPrintBarcodeLabel", 1, 4);
    }
}

