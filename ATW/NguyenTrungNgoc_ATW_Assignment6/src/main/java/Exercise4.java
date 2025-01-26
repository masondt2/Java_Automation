import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercise4 {
    @Test
    public void TestExercise04() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://webdevable.com/w3schools/tags/tryit5b70.html?filename=tryhtml_frame_cols");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Run »']")));

        //Switch to parent Frame
        driver.switchTo().frame("iframeResult");

        //Switch to A Frame
        // Xpath need to get by the root
        WebElement AFrame = driver.findElement(By.xpath("//frame[@src='frame_a.html']"));
        driver.switchTo().frame(AFrame);

        WebElement textOfAFrame = driver.findElement(By.xpath("//body/p"));

        //Check with expected text: “Note: The frameset, frame, and noframes elements are not supported in HTML5.”
        Assert.assertEquals(textOfAFrame.getText(), "Note: The frameset, frame, and noframes elements are not supported in HTML5.");

        driver.quit();
    }
}
