package Pages;

import Core.AppiumBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Arrays;

public class CategoryPage extends AppiumBase {
    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.banggood.client:id/primary_cate_list\"]")
    private WebElement leftMenuBoundElement;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_category_name\" and @text=\"Home and Garden\"]")
    private WebElement homeAndGarden;
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_category_title\" and @text=\"Home Decor\"]")
    private WebElement homeDecor;

    public CategoryPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    public static void swipe(AndroidDriver driver, int startx, int starty, int endx, int endy) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), startx, starty));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), endx, endy));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(dragNDrop));
    }

    public static void swipeLeftMenuUp(AndroidDriver driver) {
        WebElement leftMenuElement = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.banggood.client:id/primary_cate_list\"]"));
        Dimension size = leftMenuElement.getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.2);
        int startx = size.width / 2;
        swipe(driver, startx, starty, startx, endy);
    }

    public static void swipeUpLeftMenuToElement(AndroidDriver driver, String xpath) {
        boolean elementFound = false;
        while (!elementFound) {
            try {
                // Kiểm tra xem phần tử có xuất hiện hay không
                WebElement element = driver.findElement(By.xpath(xpath));
                if (element.isDisplayed()) {
                    elementFound = true; // Nếu tìm  thấy, dừng lại
                }
            } catch (Exception e) {
                // Nếu không tìm thấy, cuộn
                swipeLeftMenuUp(driver);
            }
        }
    }

    public void scrollToHomeAndGardenInLeftMenu() {
        webDriverWait.until(ExpectedConditions.visibilityOf(leftMenuBoundElement));
        String xpathHomeAndGarden = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_category_name\" and @text=\"Home and Garden\"]";
        swipeUpLeftMenuToElement(androidDriver, xpathHomeAndGarden);

    }

    public void clickToHomeAndGardenInLeftMenu() {
        webDriverWait.until(ExpectedConditions.visibilityOf(homeAndGarden));
        homeAndGarden.click();
    }

    public void clickToHomeDecorAtTheRightCategory() {
        String xpathHomeDecor = "//android.widget.TextView[@resource-id=\"com.banggood.client:id/tv_category_title\" and @text=\"Home Decor\"]";
        swipeUpToElementWithXpath(androidDriver, xpathHomeDecor);
        homeDecor.click();
    }
}
