package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PracticePage;

import java.io.IOException;

public class TC1_VerifyAlert extends BaseTest {
    @Test(dataProvider = "data")
    public void Test_TC1_VerifyAlert(String url, String alertInputVerify) throws IOException, InterruptedException {
        PracticePage practicePage = new PracticePage(getDriver());
        practicePage.navigateToPracticePage(url);
        practicePage.inputAlert(alertInputVerify);
        Assert.assertTrue(practicePage.verifyAlert(alertInputVerify));

        System.out.println("==================");
    }

    @DataProvider(name = "data")
    public Object[][] getData() {
        return ExcelUtils.getTableArray("src/main/resources/TestDataAssm6.xlsx", "TC1_Alert", 1, 2);
    }
}

