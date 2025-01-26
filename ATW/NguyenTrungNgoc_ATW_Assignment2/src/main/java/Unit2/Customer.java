package Unit2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Customer {
    @Test
    public void test() {
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

        driver.navigate().to("https://martfury.botble.com/admin/customers/create");
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("Mason");

        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("masondt289@gmail.com");

        WebElement phone = driver.findElement(By.id("phone"));
        phone.clear();
        phone.sendKeys("1234567890");

//        WebElement dob = driver.findElement(By.id("dob"));
//        dob.clear();
//        dob.sendKeys("10/04/1990");

        WebElement password1 = driver.findElement(By.id("password"));
        password1.clear();
        password1.sendKeys("111222333");

        WebElement passConfirm = driver.findElement(By.id("password_confirmation"));
        passConfirm.clear();
        passConfirm.sendKeys("111222333");

        WebElement privateNote = driver.findElement(By.id("private_notes"));
        privateNote.clear();
        privateNote.sendKeys("Hi, This is a Private Note");

        driver.quit();

    }
}
