package Assignment8.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Random;

public class BaseTest {
    private WebDriver driver;

    @BeforeTest
    public void BeforeTest(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterTest
    public void AfterTest(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

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
}
