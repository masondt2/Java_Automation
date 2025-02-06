import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Exercise2 {
    @Test
    public void TestExercise02() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.letskodeit.com/practice");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Practice Page']")));

        String WindowID = driver.getWindowHandle();

        WebElement windowButton = driver.findElement(By.id("openwindow"));
        windowButton.click();

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getPageSource().contains("All Courses")) {
                break;
            }
        }

        driver.manage().window().maximize();
        Thread.sleep(2000);

        //Scroll down to bottom of the web
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(2000);
        List<WebElement> lstCourse = driver.findElements(By.xpath("//div[@class='zen-course-list']"));

        Assert.assertEquals(lstCourse.size(), 11, "Course list should have 11 elements");
        driver.switchTo().window(WindowID);
        //driver.switchTo().defaultContent();

        driver.quit();
    }
}
