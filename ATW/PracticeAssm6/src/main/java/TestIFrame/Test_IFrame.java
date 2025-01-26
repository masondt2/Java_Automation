package TestIFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_IFrame {
    @Test
    public void Test_IFrame() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.navigate().to("http://webdevable.com/w3schools/tags/tryit5b70.html?filename=tryhtml_frame_cols");


        driver.switchTo().frame("iframeResult");

        WebElement frameA = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//frame[@src='frame_a.html']")));
        driver.switchTo().frame(frameA);

        WebElement frameAMessage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/p")));
        System.out.println(frameAMessage.getText());
    }
}
