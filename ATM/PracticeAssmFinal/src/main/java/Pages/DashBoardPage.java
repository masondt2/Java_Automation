package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DashBoardPage extends AppiumBase {
    public DashBoardPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);}

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"wrteam.multivendor.customer:id/navigation_bar_item_icon_view\"])[2]")
    private WebElement categoryMenu;



    public void clickToCategoryMenuItem(){
        webDriverWait.until(ExpectedConditions.visibilityOf(categoryMenu));
        categoryMenu.click();
    }
}
