package Core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppiumBase {
    public static AndroidDriver androidDriver;
    public static WebDriverWait webDriverWait;

    public static void tap(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        androidDriver.perform(Arrays.asList(tap));
    }

    public static void swipeMobileUp(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.2);
        int startx = size.width / 2;
        swipe(driver, startx, starty, startx, endy);
    }

    public static void swipeMobileUpLowSpeed(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.72);
        int startx = size.width / 2;
        swipeLow(driver, startx, starty, startx, endy);
    }

    public static void swipeLeftMenuUp(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.2);
        int startx = size.width / 8;
        swipe(driver, startx, starty, startx, endy);
    }

    public static void swipeMobileDown(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.2);
        int startx = size.width / 2;
        swipe(driver, startx, endy, startx, starty);
    }

    public static void rightLeftSwipe(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.9);
        int endx = (int) (size.width * 0.1);
        int starty = size.height / 2;
        swipe(driver, startx, starty, endx, starty);
    }

    public static void leftRightSwipe(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.9);
        int endx = (int) (size.width * 0.1);
        int starty = size.height / 2;
        swipe(driver, endx, starty, startx, starty);
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

    public static void swipeLow(AndroidDriver driver, int startx, int starty, int endx, int endy) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), startx, starty));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), endx, endy));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(dragNDrop));
    }

    public static void swipeUpLeftMenuToElement(AndroidDriver driver, String xpath) {
        boolean elementFound = false;
        while (!elementFound) {
            try {
                // check if element is displayed
                WebElement element = driver.findElement(By.xpath(xpath));
                if (element.isDisplayed()) {
                    elementFound = true; // If found >> Stop
                }
            } catch (Exception e) {
                // If not found element >> Scroll
                swipeLeftMenuUp(driver);
            }
        }
    }

    public static void swipeUpToElementWithXpath(AndroidDriver driver, String xpath) {
        boolean elementFound = false;
        while (!elementFound) {
            try {
                // check if element is displayed
                WebElement element = driver.findElement(By.xpath(xpath));
                if (element.isDisplayed()) {
                    elementFound = true; // If found >> Stop
                }
            } catch (Exception e) {
                // If not found element >> Scroll
                swipeMobileUp(driver);
            }
        }
    }

    public static void swipeUpToElementWithXpathWithLowSpeed(AndroidDriver driver, String xpath) {
        boolean elementFound = false;
        while (!elementFound) {
            try {
                // check if element is displayed
                WebElement element = driver.findElement(By.xpath(xpath));
                if (element.isDisplayed()) {
                    elementFound = true; // If found >> Stop
                }
            } catch (Exception e) {
                // If not found element >> Scroll
                swipeMobileUpLowSpeed(driver);
            }
        }
    }

    public static void swipeUpToElement(AndroidDriver driver, WebElement elementTarget) {
        boolean elementFound = false;
        while (!elementFound) {
            try {
                // check if element is displayed
                if (elementTarget.isDisplayed()) {
                    elementFound = true; // If found >> Stop
                }
            } catch (Exception e) {
                // If not found element >> Scroll
                swipeMobileUp(driver);
            }
        }
    }

    public static void scrollUntilEnd(String xpathElements) {

        // xpathElenments: xpath of all elemenst >> return List Elements

        boolean canScrollMore = true;
        while (canScrollMore) {
            // Check number of list Element before scroll
            List<WebElement> initialElements = androidDriver.findElements(By.xpath(xpathElements));
            int initialCount = initialElements.size();

            // Scroll down
            swipeMobileUp(androidDriver);

            //Wait to update
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Check number of list Element after scroll
            List<WebElement> newElements = androidDriver.findElements(By.xpath(xpathElements));
            int newCount = newElements.size();

            // If cannot scroll >> Stop scroll
            canScrollMore = newCount > initialCount;
        }
    }

    public static List<String> scrollUntilEndAndReturnResult(String xpathElements) {

        // xpathElenments: xpath of all elemenst >> return List Elements
        List<String> lstresults = new ArrayList<>();
        List<WebElement> Elements = androidDriver.findElements(By.xpath(xpathElements));
        //webDriverWait.until(ExpectedConditions.visibilityOf(Elements.get(0)));
        for (WebElement element : Elements) {
            lstresults.add(element.getText());
        }

        boolean canScrollMore = true;
        while (canScrollMore) {
            // Check number of list Element before scroll
            List<WebElement> initialElements = androidDriver.findElements(By.xpath(xpathElements));
            int initialCount = initialElements.size();

            // Scroll down
            swipeMobileUp(androidDriver);

            //Wait to update
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Check number of list Element after scroll
            List<WebElement> newElements = androidDriver.findElements(By.xpath(xpathElements));
            int newCount = newElements.size();
            for (WebElement element : newElements) {
                if (!lstresults.contains(element.getText())) {
                    lstresults.add(element.getText());
                }
            }

            // If cannot scroll >> Stop scroll
            canScrollMore = newCount > initialCount;
        }
        return lstresults;
    }

    public void createDriver() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setAutomationName("UiAutomator2");
        uiAutomator2Options.setUdid("R5CW229EAYR");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setAppPackage("wrteam.multivendor.customer");
        uiAutomator2Options.setAppActivity("wrteam.multivendor.customer.activity.SplashActivity");

        androidDriver = new AndroidDriver(new URL("http://localhost:4723"), uiAutomator2Options);
        webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));

    }

    public void closeDriver() {
        //androidDriver.quit();
    }
}
