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

public class TestCase01 {
    @Test
    public void VerifyLoginPage() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://osc-ultimate-demo.mageplaza.com/admin/admin/");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='Magento Admin Panel']")));

        WebElement labelUserName = driver.findElement(By.xpath("//label[@for='username']"));
        Assert.assertTrue(labelUserName.isDisplayed());
        System.out.println("username combobox is displayed");

        WebElement labelPassword = driver.findElement(By.xpath("//label[@for='login']"));
        Assert.assertTrue(labelPassword.isDisplayed());
        System.out.println("password text is displayed");

        WebElement LoginButton = driver.findElement(By.xpath("//span[normalize-space()='Sign in']"));
        Assert.assertTrue(LoginButton.isDisplayed());
        System.out.println("SignIn button is displayed");

        WebElement forgotPassword = driver.findElement(By.xpath("//a[normalize-space()='Forgot your password?']"));
        Assert.assertTrue(forgotPassword.isDisplayed() && forgotPassword.getText().equals("Forgot your password?"));
        System.out.println("Forgot password button is displayed");

        //Input information
        WebElement usernameInput = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameInput.clear();
        usernameInput.sendKeys("mageplaza");

        WebElement passwordInput = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        passwordInput.clear();
        passwordInput.sendKeys("demo123");
        passwordInput.submit();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Dashboard']")));
        System.out.println("Login successfully with Dashboard");

        driver.quit();
    }
}
