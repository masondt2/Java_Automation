package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase04 {
    @Test
    public void TC_04() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.worksuite.biz/login");
        driver.manage().window().maximize();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement email = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("admin@example.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");

        password.submit();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='page-title d-none d-lg-flex']")));

        WebElement hr = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='HR']")));
        hr.click();

        WebElement designation = driver.findElement(By.xpath("//a[normalize-space()='Designation']"));
        designation.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='page-heading'])[1]")));

        Thread.sleep(2000);
        WebElement teamLead = driver.findElement(By.xpath("//a[contains(text(),'Team Lead')]"));
        teamLead.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Designation Details']")));

        WebElement optionButton = driver.findElement(By.xpath("//button[@aria-haspopup='true']"));
        optionButton.click();

        WebElement edit = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Edit')]")));
        edit.click();

        driver.quit();
    }
}
