package exercise4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class PaymentAdjustmentsTest {
    @Test
    public void TestPaymentAdjustments() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://rawal-admin.themes-coder.net/admin/login");
        driver.manage().window().maximize();

        WebElement user = driver.findElement(By.id("email"));
        Assert.assertTrue(user.isDisplayed(), "User textbox is not displayed");
        user.clear();
        user.sendKeys("admin@email.com");

        WebElement password = driver.findElement(By.id("password"));
        Assert.assertTrue(password.isDisplayed(), "Password textbox is not displayed");
        password.clear();
        password.sendKeys("123");

        WebElement loginButton = driver.findElement(By.xpath("//button"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");

        loginButton.click();
        Thread.sleep(5000);
        WebElement accounts = driver.findElement(By.xpath("//span[text()='Accounts']"));
        Assert.assertTrue(accounts.isDisplayed(), "Accounts submenu is not displayed");
        accounts.click();

        WebElement payments = driver.findElement(By.xpath("//span[text()='Payments']"));
        Assert.assertTrue(payments.isDisplayed(), "Payments Adjustment submenu is not displayed");
        payments.click();

        WebElement accountTypeText1 = driver.findElement(By.xpath("(//label[text()='Account Type'])[1]"));
        WebElement accountTypeText2 = driver.findElement(By.xpath("(//label[text()='Account Type'])[2]"));
        WebElement liability1= driver.findElement(By.xpath("(//fieldset[@class='form-group mb-3'])[1]"));
        WebElement liability2= driver.findElement(By.xpath("(//fieldset[@class='form-group mb-3'])[2]"));
        Thread.sleep(3000);
        WebElement selectAccount1 = driver.findElement(By.xpath("(//div[@class='form-group child'])[1]"));
        WebElement selectAccount2 = driver.findElement(By.xpath("(//div[@class='form-group child'])[2]"));
        WebElement amountTextBox = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
        WebElement description = driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));

        Assert.assertTrue(accountTypeText1.isDisplayed(),"Account Type submenu 1 is not displayed");
        Assert.assertTrue(accountTypeText2.isDisplayed(),"Account Type submenu 2 is not displayed");
        Assert.assertTrue(liability1.isDisplayed(),"Liability text box 1 is not displayed");
        Assert.assertTrue(liability2.isDisplayed(),"Liability text box 2 is not displayed");
        Assert.assertTrue(selectAccount1.isDisplayed(),"Select Account 1 is not displayed");
        Assert.assertTrue(selectAccount2.isDisplayed(),"Select Account 2 is not displayed");
        Assert.assertTrue(amountTextBox.isDisplayed(),"Amount text box is not displayed");
        Assert.assertTrue(description.isDisplayed(),"Description text box is not displayed");
        Assert.assertTrue(submitButton.isDisplayed(),"Submit button is not displayed");

        driver.quit();
    }
}
