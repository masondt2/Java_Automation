import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercise1 {
    @Test
    public void TestExercise01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.letskodeit.com/practice");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Practice Page']")));

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Demo");

        WebElement alertButton = driver.findElement(By.id("alertbtn"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Demo"), "'Demo' Text should be displayed.");
        Thread.sleep(1000);

        alert.accept();
        driver.quit();
    }
}
