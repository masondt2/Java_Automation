package exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest {
    @Test
    public void Test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //Step 1: Navigate to the https://rawal-admin.themes-coder.net/admin/login
        driver.navigate().to("https://rawal-admin.themes-coder.net/admin/login?");
        driver.manage().window().maximize();

        //Step 2: Input username: admin@email.com
        WebElement user = driver.findElement(By.id("email"));
        Assert.assertTrue(user.isDisplayed(),"User textbox not found");
        user.clear();
        user.sendKeys("admin@email.com");

        //Step 3: Input password: 123
        WebElement password = driver.findElement(By.id("password"));
        Assert.assertTrue(password.isDisplayed(),"Password textbox not found");
        password.clear();
        password.sendKeys("123");

        //Step 4: Click to the Login button
        WebElement loginButton = driver.findElement(By.xpath("//button"));
        Assert.assertTrue(loginButton.isDisplayed(),"Login button not found");
        loginButton.click();

        //Step 5: Verify Rawal dashboard should be displayed: Left menu (Media, Catalog, Stoke / Inventory,
        //Quotations), Orders panel, Products panel, Users panel and Sale panel.
        Thread.sleep(5000);
        WebElement mediaMenu = driver.findElement(By.xpath("//span[text()='Media']"));
        WebElement catalogMenu = driver.findElement(By.xpath("//span[text()='Catalog']"));
        WebElement stockMenu = driver.findElement(By.xpath("//span[text()='Stock / Inventory']"));
        WebElement quotationMenu = driver.findElement(By.xpath("//span[text()='Quotations']"));

        WebElement ordersPanel = driver.findElement(By.xpath("//h3[text()='Orders']"));
        WebElement productsPanel = driver.findElement(By.xpath("//h3[text()='Products']"));
        WebElement usersPanel = driver.findElement(By.xpath("//h3[text()='Users']"));
        WebElement salesPanel = driver.findElement(By.xpath("//h3[text()='Sales']"));

        Assert.assertTrue(mediaMenu.isDisplayed(),"Media menu not found");
        Assert.assertTrue(catalogMenu.isDisplayed(),"Catalog menu not found");
        Assert.assertTrue(stockMenu.isDisplayed(),"Stock menu not found");
        Assert.assertTrue(quotationMenu.isDisplayed(),"Quotation menu not found");
        Assert.assertTrue(ordersPanel.isDisplayed(),"Orders panel not found");
        Assert.assertTrue(productsPanel.isDisplayed(),"Products panel not found");
        Assert.assertTrue(usersPanel.isDisplayed(),"Users panel not found");
        Assert.assertTrue(salesPanel.isDisplayed(),"Sales panel not found");

        driver.quit();
    }
}
