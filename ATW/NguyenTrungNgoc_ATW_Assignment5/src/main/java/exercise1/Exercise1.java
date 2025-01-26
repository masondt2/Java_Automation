package exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class Exercise1 {
    @Test
    public void Test01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/drag_drop.html");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Selenium Drag and Drop Example:']")));

        WebElement dragElement = driver.findElement(By.xpath("(//li[@class='block13 ui-draggable'])[1]"));
        WebElement dropElement = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));

        Actions action = new Actions(driver);
        action.dragAndDrop(dragElement, dropElement).perform();

        Thread.sleep(2000);
        driver.quit();
    }
}
