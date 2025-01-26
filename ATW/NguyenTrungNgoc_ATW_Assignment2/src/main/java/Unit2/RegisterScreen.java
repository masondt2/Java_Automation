package Unit2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegisterScreen {
    @Test
    public void Test2(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://martfury.botble.com/register");

        driver.manage().window().maximize();

        WebElement fullName = driver.findElement(By.id("name"));
        fullName.clear();
        fullName.sendKeys("Nguyen Trung Ngoc");

        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("trungngocdt2@gmail.com");

        WebElement phone = driver.findElement(By.id("phone"));
        phone.clear();
        phone.sendKeys("1234567890");

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("11112222");

        WebElement confirmPassword = driver.findElement(By.name("password_confirmation"));
        confirmPassword.clear();
        confirmPassword.sendKeys("11112222");

        driver.quit();
    }
}
