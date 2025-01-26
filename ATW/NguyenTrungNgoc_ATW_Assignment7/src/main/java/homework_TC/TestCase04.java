package homework_TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCase04 {
    @Test
    public void VerifyProductPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://osc-ultimate-demo.mageplaza.com/admin/admin/");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement userName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        userName.clear();
        userName.sendKeys("mageplaza");

        WebElement password = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        password.clear();
        password.sendKeys("demo123");

        WebElement loginButton = driver.findElement(By.xpath("//span[normalize-space()='Sign in']"));
        loginButton.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Dashboard']")));

        WebElement catalogMenu = driver.findElement(By.xpath("//span[normalize-space()='Catalog']"));
        catalogMenu.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[normalize-space()='Catalog']")));
        Thread.sleep(2000);

        WebElement product = driver.findElement(By.xpath("(//span[contains(text(),'Products')])[1]"));
        product.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Products']")));
        Thread.sleep(2000);

        //verify product page display
        WebElement addProduct = driver.findElement(By.xpath("//span[normalize-space()='Add Product']"));
        Assert.assertTrue(addProduct.isDisplayed(), "Add Product Button is not displayed");
        System.out.println("Add Product Button is displayed");

        WebElement searchBox = driver.findElement(By.id("fulltext"));
        Assert.assertTrue(searchBox.isDisplayed(), "Search Box is not displayed");

        WebElement searchButton = driver.findElement(By.xpath("(//button[contains(@aria-label,'Search')])[1]"));
        Assert.assertTrue(searchButton.isDisplayed(), "Search Button is not displayed");
        System.out.println("Search Key is displayed");

        Thread.sleep(3000);
        WebElement defaultView = driver.findElement(By.xpath("(//span[normalize-space()='Default View'])[1]"));
        defaultView.click();
        Thread.sleep(1000);

        WebElement saveViewAs = driver.findElement(By.xpath("(//a[contains(text(),'Save View As...')])[1]"));
        saveViewAs.click();

        WebElement newView = driver.findElement(By.xpath("(//input[contains(@aria-label,'New View')])[1]"));
        Assert.assertTrue(newView.isDisplayed(), "New View Button is not displayed");
        System.out.println("New view is displayed");

        WebElement column = driver.findElement(By.xpath("(//button[contains(@type,'button')])[4]"));
        System.out.println("Column is displayed");

        WebElement table = driver.findElement(By.xpath("//div[contains(@data-role,'grid-wrapper')]"));
        List<WebElement> lstProduct = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertTrue(table.isDisplayed() && !lstProduct.isEmpty());
        System.out.println("Table is displayed");

        driver.quit();
    }
}
