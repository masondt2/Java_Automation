package Unit2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetInTouchScreen {
    @Test
    public void TestGetInTouchScreen() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://martfury.botble.com/contact");
        driver.manage().window().maximize();

        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("Mason");

        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("masondt289@gmail.com");

        WebElement address = driver.findElement(By.id("address"));
        address.clear();
        address.sendKeys("hanoi,VietNam");

        WebElement phone = driver.findElement(By.id("phone"));
        phone.clear();
        phone.sendKeys("1234567890");

        WebElement subject = driver.findElement(By.id("subject"));
        subject.clear();
        subject.sendKeys("Hi Mason");

        WebElement content = driver.findElement(By.id("content"));
        content.clear();
        content.sendKeys("Hi Mason, This is a test");

        WebElement sendButton = driver.findElement(By.xpath("//button"));
        sendButton.click();

        driver.quit();
    }
}
