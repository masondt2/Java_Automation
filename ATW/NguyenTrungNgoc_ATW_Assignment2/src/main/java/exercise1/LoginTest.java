package exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void Test1() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.tiktok.com/");
        driver.manage().window().maximize();

       WebElement loginButton = driver.findElement(By.id("header-login-button"));
       loginButton.click();


    }
}
