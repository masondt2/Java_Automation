package HomeWork_TestCase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class TC_02_VerifyMyAccountScreen {
    @Test
    public void Test_VerifyCategoryScreen() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setUdid("R5CW229EAYR");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAppPackage("com.company.rawal");
        uiAutomator2Options.setAppActivity("com.company.rawal.MainActivity");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://localhost:4723"), uiAutomator2Options);
        WebDriverWait webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(20));

        WebElement myAccount = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"My Account\n" + "Tab 4 of 4\"]")));
        myAccount.click();

        List<WebElement> lstMyOrderCategories = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.view.View[@content-desc=\"My Orders\n" + "View All >\"]/android.view.View/android.view.View/android.widget.ImageView")));

        WebElement myOrdersTitle = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"My Orders\n" + "View All >\"]")));

        WebElement helpTitle = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Help & info\"]")));

        List<WebElement> lstHelpCategoriesFirstRow = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.view.View[@content-desc=\"Help & info\"]/android.view.View/android.view.View/android.widget.ImageView")));

        List<WebElement> lstHelpCategoriesSecondRow = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.view.View[@content-desc=\"Help & info\"]/android.view.View/android.view.View/android.view.View")));

        Assert.assertTrue(myOrdersTitle.isDisplayed());
        System.out.println(myOrdersTitle.getAttribute("content-desc").split("\n")[0] + " title: is displayed");

        for (int i = 0; i < lstMyOrderCategories.size(); i++) {
            Assert.assertTrue(lstMyOrderCategories.get(i).isDisplayed());
            System.out.println(lstMyOrderCategories.get(i).getAttribute("content-desc") + ": is displayed");
        }

        Assert.assertTrue(helpTitle.isDisplayed());
        System.out.println(helpTitle.getAttribute("content-desc") + " title: is displayed");

        for (int i = 0; i < lstHelpCategoriesFirstRow.size(); i++) {
            Assert.assertTrue(lstHelpCategoriesFirstRow.get(i).isDisplayed());
            System.out.println(lstHelpCategoriesFirstRow.get(i).getAttribute("content-desc") + ": is displayed");
        }

        for (int i = 0; i < lstHelpCategoriesSecondRow.size(); i++) {
            Assert.assertTrue(lstHelpCategoriesSecondRow.get(i).isDisplayed());
            System.out.println(lstHelpCategoriesSecondRow.get(i).getAttribute("content-desc") + ": is displayed");
        }
    }
}
