package exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Exercise2 {
    @Test
    public void Test02() throws InterruptedException, IOException, AWTException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Demo Site']")));

        WebElement doubleClickBox = driver.findElement(By.xpath("(//button[normalize-space()='Double-Click Me To See Alert'])[1]"));
        Assert.assertTrue(doubleClickBox.isDisplayed(), "“Double-Click Me To See Alert” is not displayed");

        //get Alige element
        WebElement alige = driver.findElement(By.xpath("(//li[@class='dropdown'])[3]"));
        int x = alige.getLocation().getX();
        int y = alige.getLocation().getY();

        //double click
        Actions action = new Actions(driver);
        action.doubleClick(doubleClickBox).perform();
        Thread.sleep(1000);

        //Screenshot
        Robot robot = new Robot();
        Rectangle rectangle = new Rectangle(x, y, 600, 150);
        BufferedImage image = robot.createScreenCapture(rectangle);
        File file = new File("./Screenshot/alert_exercise2.png");
        ImageIO.write(image, "png", file);

        Thread.sleep(1000);
        driver.quit();
    }
}
