package homework_TC;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase03 {
    @Test
    public void verifyEditCustomer() throws InterruptedException {
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

        WebElement customerMenu = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-magento-customer-customer")));
        customerMenu.click();


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Customers')]")));
        Thread.sleep(2000);

        WebElement allCustomer = driver.findElement(By.xpath("//span[normalize-space()='All Customers']"));
        allCustomer.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Customers']")));
        Thread.sleep(4000);

        WebElement searchBox = driver.findElement(By.id("fulltext"));
        searchBox.clear();
        searchBox.sendKeys("Veronica Costello");

        WebElement searchButton = driver.findElement(By.xpath("(//button[@aria-label='Search'])[1]"));
        searchButton.click();

        WebElement editButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Edit']")));
        editButton.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Veronica Costello']")));
        System.out.println("The Edit customer page display");
        Thread.sleep(3000);

        WebElement accountInfor = driver.findElement(By.xpath("//span[normalize-space()='Account Information']"));
        accountInfor.click();

        //Verify first name and last name
        WebElement firstName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[firstname]")));
        Assert.assertEquals(firstName.getAttribute("value"), "Veronica");
        System.out.println("First Name: "+firstName.getAttribute("value"));

        WebElement lastName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[lastname]")));
        Assert.assertEquals(lastName.getAttribute("value"), "Costello");
        System.out.println("Last Name: "+lastName.getAttribute("value"));

        driver.quit();
//        // Execute JavaScript to get the value of the disabled input
//        WebElement lastName = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[lastname]")));
//        String lastNameVerify = (String) jsExecutor.executeScript("return arguments[0].value;", lastName);
//        Assert.assertEquals(lastNameVerify, "Costello");
//        System.out.println("Last Name: "+lastNameVerify);
    }
}
