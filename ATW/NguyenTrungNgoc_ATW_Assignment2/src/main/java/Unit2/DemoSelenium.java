package Unit2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class DemoSelenium {

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://martfury.botble.com/admin/login");

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("username"));
        username.clear();
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("12345678");

        WebElement loginButton = driver.findElement(By.xpath("//button"));
        loginButton.click();

        driver.quit();
    }
}
