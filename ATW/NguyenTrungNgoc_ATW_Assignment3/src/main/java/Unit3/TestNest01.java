package Unit3;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNest01 {
    @Test
    public void Test01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://nest.botble.com");
        driver.manage().window().maximize();
        Thread.sleep(8000);

        try {
            WebElement closeButton = driver.findElement(By.xpath("(//button[@type='button'])[3]"));
            closeButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("Popup is not displayed");
        }

        WebElement catagories = driver.findElement(By.xpath("//div[@class='product-cat-label']"));
        WebElement search = driver.findElement(By.name("q"));

        Assert.assertTrue(catagories.isDisplayed());
        Assert.assertTrue(search.isDisplayed());

    }
}
