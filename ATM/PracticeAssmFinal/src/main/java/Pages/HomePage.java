package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends AppiumBase {

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvMessage\"]")
    private WebElement homeMessage;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvSkip\"]")
    private WebElement skipButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvNext\"]")
    private WebElement nextButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvNext\" and @text=\"GET STARTED\"]")
    private WebElement getStartedButton;

    public void clickToNext(){
        webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        nextButton.click();
    }

    public void clickToGetStarted(){
        webDriverWait.until(ExpectedConditions.visibilityOf(getStartedButton));
        getStartedButton.click();
    }

    public boolean verifyHomeScreen() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(homeMessage));

            Assert.assertTrue(homeMessage.isDisplayed());
            System.out.println("Message is displayed: "+homeMessage.getText());

            webDriverWait.until(ExpectedConditions.visibilityOf(skipButton));
            Assert.assertTrue(skipButton.isDisplayed());
            System.out.println("Skip button is displayed");

            webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
            Assert.assertTrue(nextButton.isDisplayed());
            System.out.println("Next button is displayed");

            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
