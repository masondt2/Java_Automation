package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AppiumBase {
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
    private WebElement allowButton;
    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.banggood.client:id/main_tab_category\"]")
    private WebElement categoryMenu;
    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.banggood.client:id/main_tab_account\"]")
    private WebElement accountMenu;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Hot Categories\"]")
    private WebElement hotCategories;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_title\" and @text=\"Smartphones\"]")
    private WebElement smartphonesCategory;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public void clickAllowButton() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(allowButton));
            allowButton.click();
        } catch (Exception e) {
            System.out.println("Allow popup did not appear");
        }
    }

    public void clickToTheCategoryOnFooterMenu() {
        webDriverWait.until(ExpectedConditions.visibilityOf(categoryMenu));
        categoryMenu.click();
    }

    public void clickAccountOnFooterMenu() {
        webDriverWait.until(ExpectedConditions.visibilityOf(accountMenu));
        accountMenu.click();
    }

    public void scrollToHotCategories() {
        String xpathHotCategories = "//android.widget.TextView[@text=\"Hot Categories\"]";
        swipeUpToElementWithXpath(androidDriver, xpathHotCategories);
    }

    public void clickToSmartphoneCategory() {
        webDriverWait.until(ExpectedConditions.visibilityOf(smartphonesCategory));
        smartphonesCategory.click();
    }

}
