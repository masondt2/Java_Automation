package Pages;

import Core.AppiumBase;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BuyANewVirtualCardPage extends AppiumBase {
    public BuyANewVirtualCardPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @FindBy(xpath = "//android.widget.EditText")
    private WebElement nameTextBox;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Fund your new Virtual Card\"]")
    private WebElement fundButton;

    @FindBy(xpath = "//android.widget.Button")
    private WebElement nextButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[3]/android.view.View")
    private WebElement messageResult;

    public boolean verifyTheBuyANewVirtualCardDisplay(){
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(nameTextBox));
            Assert.assertTrue(nameTextBox.isDisplayed());
            System.out.println("Name Text Box is displayed with text: " + nameTextBox.getAttribute("hint"));

            Assert.assertTrue(fundButton.isDisplayed());
            System.out.println("Fund button is displayed with text: " + fundButton.getAttribute("content-desc"));

            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void inputNameOnCard(){
        webDriverWait.until(ExpectedConditions.visibilityOf(nameTextBox));
        nameTextBox.click();
        nameTextBox.sendKeys(faker.name().fullName());
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickToTheFundButton(){
        webDriverWait.until(ExpectedConditions.visibilityOf(fundButton));
        fundButton.click();
    }

    public void add10USDAmount(){
        webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        int x =200;
        int y = 2000;
        tap(x, y);
        androidDriver.pressKey(new KeyEvent(AndroidKey.DEL));
        androidDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        androidDriver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickToNextIcon(){
        //webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        nextButton.click();
    }

    public boolean verifyTheScreenDisplayError(){
        try{
            webDriverWait.until(ExpectedConditions.visibilityOf(messageResult));
            Assert.assertTrue(messageResult.isDisplayed()&&messageResult.getAttribute("content-desc").equals("No sufficient funds"));
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
