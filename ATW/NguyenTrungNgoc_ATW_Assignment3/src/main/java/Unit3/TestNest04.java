package Unit3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class TestNest04 {
    @Test
    public void Test04() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://nest.botble.com/");
        driver.manage().window().maximize();

        Thread.sleep(8000);
        try {
            WebElement closeButton = driver.findElement(By.xpath("(//button[@class='btn-close'])[1]"));
            closeButton.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement popularProducts = driver.findElement(By.xpath("//h3[text()='Popular Products']"));
        js.executeScript("arguments[0].scrollIntoView(true);", popularProducts);

        Thread.sleep(2000);
        //List<WebElement> listTopCategories = driver.findElements(By.xpath("//h2[@class='text-truncate']"));
        List<WebElement> listPopularProduct = driver.findElements(By.xpath("//section[@class='product-tabs section-padding position-relative']//h2[@class='text-truncate']"));
        List<String> listTextResult = new ArrayList<>();
        Assert.assertTrue(listPopularProduct.size() >= 8, "Total popular products should be greater than 8");
        driver.quit();
    }
}
