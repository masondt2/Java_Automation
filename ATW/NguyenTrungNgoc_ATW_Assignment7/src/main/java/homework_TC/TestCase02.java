package homework_TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase02 {
    @Test
    public void VerifyCreateNewCustomer() throws InterruptedException {
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

        //WebElement allCustomer = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-magento-customer-customer-manage")));
        WebElement allCustomer = driver.findElement(By.xpath("//span[normalize-space()='All Customers']"));
        allCustomer.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Customers']")));

        WebElement addNewCustomer = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Add New Customer']")));
        addNewCustomer.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='New Customer']")));
        Thread.sleep(4000);

        //Input required information
        WebElement associateToWebsiteSelect = driver.findElement(By.xpath("(//select[@class='admin__control-select'])[1]"));
        Select assToWebSelect = new Select(associateToWebsiteSelect);
        assToWebSelect.selectByVisibleText("Main Website");
        Thread.sleep(1000);

        WebElement group = driver.findElement(By.xpath("(//select[@class='admin__control-select'])[2]"));
        Select groupSelect = new Select(group);
        groupSelect.selectByVisibleText("Retailer");

        WebElement firstName = driver.findElement(By.xpath("(//input[@class='admin__control-text'])[2]"));
        firstName.sendKeys("Nguyen");

        WebElement lastName = driver.findElement(By.xpath("(//input[@class='admin__control-text'])[4]"));
        lastName.sendKeys("Thi Ngoc");

        WebElement email = driver.findElement(By.xpath("(//input[@class='admin__control-text'])[6]"));
        email.sendKeys("trungngoc1@gmail.com");

        WebElement saveCustomer = driver.findElement(By.id("save"));
        saveCustomer.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Customers']")));

        WebElement message = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-ui-id='messages-message-success']")));
        Assert.assertEquals(message.getText(),"You saved the customer.");
        System.out.println("Save customer has been verified");

        Thread.sleep(2000);
        driver.quit();

    }
}
