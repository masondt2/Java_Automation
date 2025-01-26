package Unit3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNest02 {
    @Test
    public void Test02() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://nest.botble.com");
        driver.manage().window().maximize();
        Thread.sleep(10000);

        WebElement closeButton = driver.findElement(By.xpath("(//button[@type='button'])[3]"));
        closeButton.click();

        Thread.sleep(2000);
        WebElement home = driver.findElement(By.xpath("(//a[@href='https://nest.botble.com/'])[1]"));
        WebElement shop = driver.findElement(By.xpath("(//a[@href='https://nest.botble.com/products'])[3]"));
        WebElement stores = driver.findElement(By.xpath("(//a[@href='https://nest.botble.com/stores'])[1]"));
        WebElement product = driver.findElement(By.xpath("(//a[@href='https://nest.botble.com/products/seeds-of-change-organic-quinoe' and contains(text(),'Product')])[1]"));
        WebElement blog = driver.findElement(By.xpath("(//a[@href='https://nest.botble.com/blog'])[1]"));
        WebElement faq = driver.findElement(By.xpath("(//a[@href='https://nest.botble.com/faq'])[1]"));
        WebElement contact = driver.findElement(By.xpath("(//a[@href='https://nest.botble.com/contact'])[1]"));

        Assert.assertTrue(home.isDisplayed());
        Assert.assertTrue(shop.isDisplayed());
        Assert.assertTrue(stores.isDisplayed());
        Assert.assertTrue(product.isDisplayed());
        Assert.assertTrue(blog.isDisplayed());
        Assert.assertTrue(faq.isDisplayed());
        Assert.assertTrue(contact.isDisplayed());

    }
}
