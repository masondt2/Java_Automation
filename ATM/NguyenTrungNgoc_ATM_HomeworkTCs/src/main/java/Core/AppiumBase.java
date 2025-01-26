package Core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import net.datafaker.Faker;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class AppiumBase {
    public static AndroidDriver androidDriver;
    public static WebDriverWait webDriverWait;
    public void createDriver() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setUdid("R5CW229EAYR");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAppPackage("com.example.flutter_phpwallet");
        uiAutomator2Options.setAppActivity("com.example.flutter_phpwallet.MainActivity");

         androidDriver = new AndroidDriver(new URL("http://localhost:4723"), uiAutomator2Options);
         webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));

    }

    public static Faker faker = new Faker();

    public void closeDriver() {
        androidDriver.quit();
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

    public static void swipeMobileUp(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.2);
        int startx = size.width / 2;
        swipe(driver, startx, starty, startx, endy);
    }

    public static void swipeUpToElement(AndroidDriver driver, WebElement elementTarget) {
        boolean elementFound = false;
        while (!elementFound) {
            try {
                if (elementTarget.isDisplayed()) {
                    elementFound = true;
                }
            } catch (Exception e) {
                swipeMobileUp(driver);
            }
        }
    }

    public static void tap(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        androidDriver.perform(Arrays.asList(tap));
    }
}
