package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends AppiumBase {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvSkip\"]")
    private WebElement skipButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvNext\"]")
    private WebElement nextButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvNext\"]")
    private WebElement getStartedButton;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvMessage\"]")
    private WebElement lookForThingsAroundYou;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public boolean verifyHomeScreen() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(skipButton));
            Assert.assertTrue(skipButton.isDisplayed());
            System.out.println(skipButton.getText() + " Button: is displayed.");

            Assert.assertTrue(nextButton.isDisplayed());
            System.out.println(nextButton.getText() + " Button: is displayed.");

            Assert.assertTrue(lookForThingsAroundYou.isDisplayed());
            System.out.println(lookForThingsAroundYou.getText() + " : is displayed.");

            System.out.println("===============================");

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickToNext() {
        webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        nextButton.click();
    }

    public void clickToGetStarted() {
        webDriverWait.until(ExpectedConditions.visibilityOf(getStartedButton));
        getStartedButton.click();
    }


}
