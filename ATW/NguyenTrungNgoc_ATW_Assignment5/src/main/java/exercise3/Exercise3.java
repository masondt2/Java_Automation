package exercise3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Exercise3 {
    @Test
    public void Test03() throws AWTException, IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Demo Site']")));

        //get Agile Element
        WebElement agile = driver.findElement(By.xpath("(//a[normalize-space()='Agile Project'])[1]"));
        int x = agile.getLocation().getX();
        int y = agile.getLocation().getY();

        //right click event
        WebElement rightClickButton = driver.findElement(By.xpath(" (//span[@class='context-menu-one btn btn-neutral'])[1]"));
        Actions action = new Actions(driver);
        WebElement editMenuItem = driver.findElement(By.xpath("(//span[normalize-space()='Edit'])[1]"));
        action.contextClick(rightClickButton).moveToElement(editMenuItem).click().perform();
        Thread.sleep(1000);

        //Screenshot
        Robot robot = new Robot();
        Rectangle rectangle = new Rectangle(x, y, 600, 150);
        BufferedImage image = robot.createScreenCapture(rectangle);
        File file = new File("./Screenshot/alert_exercise3.png");
        ImageIO.write(image, "png", file);

        Thread.sleep(1000);
        driver.quit();

    }
}
