package exercise3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductUnitsTest {
    @Test
    public void TestProductUnits() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://rawal-admin.themes-coder.net/admin/login?");
        driver.manage().window().maximize();

        WebElement user = driver.findElement(By.id("email"));
        Assert.assertTrue(user.isDisplayed(),"User not displayed");
        user.clear();
        user.sendKeys("admin@email.com");

        WebElement password = driver.findElement(By.id("password"));
        Assert.assertTrue(password.isDisplayed(),"Password not displayed");
        password.clear();
        password.sendKeys("123");

        WebElement loginButton = driver.findElement(By.xpath("//button"));
        Assert.assertTrue(loginButton.isDisplayed(),"Login button not displayed");
        loginButton.click();
        Thread.sleep(5000);

        WebElement catalog = driver.findElement(By.xpath("//span[text()='Catalog']"));
        Assert.assertTrue(catalog.isDisplayed(),"Catalog not displayed");
        catalog.click();

        WebElement productUnit = driver.findElement(By.xpath("//span[text()='Product Units']"));
        Assert.assertTrue(productUnit.isDisplayed(),"Product unit not displayed");
        productUnit.click();
        Thread.sleep(5000);

        WebElement id = driver.findElement(By.xpath("//th[@aria-label='ID: activate to sort column descending']"));
        WebElement action = driver.findElement(By.xpath("//th[@aria-label='Action']"));
        WebElement name = driver.findElement(By.xpath("(//th[@aria-label='unit: activate to sort column ascending'])[1]"));
        WebElement status = driver.findElement(By.xpath("(//th[@aria-label='unit: activate to sort column ascending'])[2]"));

        Assert.assertTrue(id.isDisplayed(),"ID not displayed");
        Assert.assertTrue(name.isDisplayed(),"Name not displayed");
        Assert.assertTrue(status.isDisplayed(),"Status not displayed");
        Assert.assertTrue(action.isDisplayed(),"Action not displayed");

        driver.quit();
    }
}
