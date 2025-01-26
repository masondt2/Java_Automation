package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class DashboardPage extends AppiumBase {
    @FindBy(xpath = "//android.view.View[@content-desc=\"Deposits\"]")
    private WebElement depositesTab;
    @FindBy(xpath = "//android.view.View[@content-desc=\"Withdrawals\"]")
    private WebElement withdrawalsTab;
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Load more deposits\"]")
    private WebElement loadMoreDeposits;
    @FindBy(xpath = "//android.view.View[@content-desc=\"You're All Caught Up !\"]")
    private WebElement allCaughtUpButton;
    @FindBy(xpath = "//android.view.View[contains(@content-desc,'Deposit to') and contains(@content-desc,'Us Dollar')]")
    private List<WebElement> depositToUsDollar;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Virtual Cards\n" + "Tab 2 of 3\"]")
    private WebElement virtualCard;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[1]")
    private WebElement menuLeftIcon;

    public DashboardPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public boolean verifyTheDashboardScreenDisplay() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(depositesTab));
            Assert.assertTrue(depositesTab.isDisplayed());
            System.out.println(depositesTab.getAttribute("content-desc") + " Tab: is Displayed");

            Assert.assertTrue(withdrawalsTab.isDisplayed());
            System.out.println(withdrawalsTab.getAttribute("content-desc") + " Tab: is Displayed");

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyAmountInDepositsTab(String amountVerify) {
        boolean meetsRequirements = false;
        do {
            try {
                if (loadMoreDeposits.isDisplayed()) {
                    loadMoreDeposits.click();
                }
            } catch (Exception e) {
                try {
                    for (WebElement element : depositToUsDollar) {
                        if (element.isDisplayed() && element.getAttribute("content-desc").split("\n")[5].equals(amountVerify)) {
                            meetsRequirements = true;
                            System.out.println("In Deposits tab display Deposit to Us Dollar with Amount = " + amountVerify);
                        }
                    }
                } catch (Exception e1) {
                    swipeMobileUp(androidDriver);
                }
            }

            try {
                if (allCaughtUpButton.isDisplayed()) {
                    break;
                }
            } catch (Exception _) {
                swipeMobileUp(androidDriver);
            }

        } while (!meetsRequirements);
        return meetsRequirements;
    }

    public void clickToIconVirtualCards(){
        webDriverWait.until(ExpectedConditions.visibilityOf(virtualCard));
        virtualCard.click();
    }

    public void clickToMenuLeftIcon() throws InterruptedException {
        Thread.sleep(2000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(menuLeftIcon));
        menuLeftIcon.click();
    }
}
