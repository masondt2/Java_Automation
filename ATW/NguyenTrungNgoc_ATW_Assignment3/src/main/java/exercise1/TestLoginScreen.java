package exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginScreen {
    @Test
    public void TestLoginScreen() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://dokans.online/login");
        driver.manage().window().maximize();

        //Email address by Id
        WebElement emailId = driver.findElement(By.id("email"));
        Assert.assertTrue(emailId.isDisplayed(), "Email is not displayed");

        //Email address by name:
        WebElement emailName = driver.findElement(By.name("email"));
        Assert.assertTrue(emailName.isDisplayed(), "Email is not displayed");

        //Email address class:
        WebElement emailClass = driver.findElement(By.className("form-control"));
        Assert.assertTrue(emailClass.isDisplayed(), "Email is not displayed");

        //Email address XPath:
        WebElement emailXpath = driver.findElement(By.xpath("//input[@type='email']"));
        Assert.assertTrue(emailXpath.isDisplayed(), "Email is not displayed");

        //-----------------------------------------------------------------------------
        //Password text box Id
        WebElement passwordId = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordId.isDisplayed(), "Password is not displayed");

        //Password text box name
        WebElement passwordName = driver.findElement(By.name("password"));
        Assert.assertTrue(passwordName.isDisplayed(), "Password is not displayed");

        //Password text box class
        WebElement passwordClass = driver.findElement(By.className("form-control"));
        Assert.assertTrue(passwordClass.isDisplayed(), "Password is not displayed");

        //Password text box Xpath
        WebElement passwordXpath = driver.findElement(By.xpath("//input[@type='password']"));
        Assert.assertTrue(passwordXpath.isDisplayed(), "Password is not displayed");

        //-----------------------------------------------------------------------------
        // Remember Me check box class

        WebElement rememberClass = driver.findElement(By.className("custom-control-label"));
        Assert.assertTrue(rememberClass.isDisplayed(), "Remember me is not displayed");

        //Remember Me check box Xpath
        WebElement rememberXpath = driver.findElement(By.xpath("//label[@class='custom-control-label']"));
        Assert.assertTrue(rememberXpath.isDisplayed(), "Remember me is not displayed");

        //-----------------------------------------------------------------------------
        //Login button class
        WebElement loginButton = driver.findElement(By.className("form-group"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");

        //Login button Xpath
        WebElement loginXpath = driver.findElement(By.xpath("//button[@type='submit']"));
        Assert.assertTrue(loginXpath.isDisplayed(), "Login button is not displayed");

        //-----------------------------------------------------------------------------
        //Forgot Password class
        WebElement forgotPassClass = driver.findElement(By.className("float-right"));
        Assert.assertTrue(forgotPassClass.isDisplayed(), "Forgot Password is not displayed");

        //Forgot Password Xpath
        WebElement forgotPassXpath = driver.findElement(By.xpath("//a[@class='text-small']"));
        Assert.assertTrue(forgotPassXpath.isDisplayed(), "Forgot Password is not displayed");

        driver.quit();
    }
}
