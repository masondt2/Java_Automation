package exercise3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProduct {
    @Test
    public void TestProductMenu() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://saka-cart.dokans.online/login");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        Assert.assertTrue(email.isDisplayed(), "Email is not displayed");
        email.clear();
        email.sendKeys("saka-cart@email.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        Assert.assertTrue(password.isDisplayed(), "Password is not displayed");
        password.clear();
        password.sendKeys("rootadmin");

        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
        loginButton.click();

        Thread.sleep(8000);
        WebElement product = driver.findElement(By.xpath("//span[normalize-space()='Products']"));
        Assert.assertTrue(product.isDisplayed(), "Products is not displayed");
        product.click();
        Thread.sleep(2000);

        WebElement allProduct = driver.findElement(By.xpath("//a[normalize-space()='All Products']"));
        Assert.assertTrue(allProduct.isDisplayed(), "All products is not displayed");
        allProduct.click();
        Thread.sleep(2000);

        // Write xpath to click to Edit of first product
        WebElement editFirstProduct = driver.findElement(By.xpath("//tr[@id='row74']//a[1]"));
        Assert.assertTrue(editFirstProduct.isDisplayed(), "Edit first product is not displayed");
        editFirstProduct.click();
        Thread.sleep(2000);

        // Product Name input
        WebElement productName = driver.findElement(By.xpath("//input[@name='title']"));
        Assert.assertTrue(productName.isDisplayed(), "Product Name is not displayed");

        //Slug
        WebElement slug = driver.findElement(By.xpath("//input[@name='slug']"));
        Assert.assertTrue(slug.isDisplayed(), "Slug is not displayed");

        //Short Description input
        WebElement shortDescription = driver.findElement(By.xpath("//textarea[@name='excerpt']"));
        Assert.assertTrue(shortDescription.isDisplayed(), "Short description is not displayed");

        //Brand combobox
        WebElement brandCombobox = driver.findElement(By.xpath("//select[@name='brand']"));
        Assert.assertTrue(brandCombobox.isDisplayed(), "Brand is not displayed");

        //Category input
        WebElement categoryInput = driver.findElement(By.xpath("//span[@role='combobox']"));
        Assert.assertTrue(categoryInput.isDisplayed(), "Category is not displayed");

        //Featured input
        WebElement featureInput = driver.findElement(By.xpath("//select[@name='featured']"));
        Assert.assertTrue(featureInput.isDisplayed(), "Feature is not displayed");

        driver.quit();
    }
}
