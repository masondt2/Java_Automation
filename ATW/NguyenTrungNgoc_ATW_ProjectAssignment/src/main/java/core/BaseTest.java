package core;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;

public class BaseTest {
    private WebDriver driver;

    //Method create Random String
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

    @Parameters({"browser"})
    @BeforeTest
    public void BeforeTest(String browser) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.WINDOWS);
        desiredCapabilities.setBrowserName(browser);
        driver = new RemoteWebDriver(desiredCapabilities);
    }

    @AfterTest
    public void AfterTest() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
