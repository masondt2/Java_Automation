package PracticePOM.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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
}
