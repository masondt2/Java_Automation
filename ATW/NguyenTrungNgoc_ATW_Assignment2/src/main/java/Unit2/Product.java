package Unit2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Product {
    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://martfury.botble.com/admin/login");

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("username"));
        username.clear();
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("12345678");

        WebElement loginButton = driver.findElement(By.xpath("//button"));
        loginButton.click();

        driver.navigate().to("https://martfury.botble.com/admin/ecommerce/products/create");
        WebElement productName = driver.findElement(By.id("name"));
        productName.sendKeys("product 1");

        WebElement price = driver.findElement(By.id("price"));
        price.clear();
        price.sendKeys("10");

        WebElement salePrice = driver.findElement(By.id("sale_price"));
        salePrice.clear();
        salePrice.sendKeys("1");

        WebElement costPerItem = driver.findElement(By.id("cost_per_item"));
        costPerItem.clear();
        costPerItem.sendKeys("5");

        WebElement barcode = driver.findElement(By.id("barcode"));
        barcode.clear();
        barcode.sendKeys("UPC");

        WebElement weight = driver.findElement(By.id("weight"));
        weight.clear();
        weight.sendKeys("100");

        WebElement length = driver.findElement(By.id("length"));
        length.clear();
        length.sendKeys("8");

        WebElement wide  = driver.findElement(By.id("wide"));
        wide.clear();
        wide.sendKeys("2");

        WebElement height = driver.findElement(By.id("height"));
        height.clear();
        height.sendKeys("5");

        driver.quit();
    }
}
