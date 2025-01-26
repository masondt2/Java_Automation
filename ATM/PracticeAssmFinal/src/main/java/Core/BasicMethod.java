package Core;

//import org.apache.commons.io.FileUtils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

public class BasicMethod {

    //generate random strings
    public static String generateRandomString(int numOfStr) {
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(numOfStr);
        for (int i = 0; i < numOfStr; i++) {
            int randomInt = random.nextInt(character.length());
            char randomChar = character.charAt(randomInt);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    //generate random strings
    public static String generateRandomNumber(int numOfStr) {
        String character = "0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(numOfStr);
        for (int i = 0; i < numOfStr; i++) {
            int randomInt = random.nextInt(character.length());
            char randomChar = character.charAt(randomInt);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    public static void swipeMobileUp(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.2);
        int startx = size.width / 2;
        swipe(driver, startx, starty, startx, endy);
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

    public static void swipeUpToElement(AndroidDriver driver, String xpath) {
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
                swipeMobileUp(driver);
            }
        }
    }

    public boolean verifyxxxxx() {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
        //System.out.println("===================");
    }
}