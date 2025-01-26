import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercise3 {
    @Test
    public void TestExercise03() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("runbtn")));

        //Switch to parent Frame
        driver.switchTo().frame("iframeResult");

        //Switch to check Frame
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@title='Iframe Example']"));
        driver.switchTo().frame(frameElement);

        WebElement title = driver.findElement(By.xpath("//body/h1"));

        //Check expected text as “This page is displayed in an iframe”
        Assert.assertEquals(title.getText(), "This page is displayed in an iframe");

        driver.quit();
    }
}
