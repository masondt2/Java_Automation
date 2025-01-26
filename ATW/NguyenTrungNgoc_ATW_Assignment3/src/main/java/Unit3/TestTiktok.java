package Unit3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestTiktok {
    @Test
    public void testTIKTOK() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.tiktok.com/en/");
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));


        WebElement loginButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='header-login-button']")));
        loginButton.click();

        WebElement usePhone = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'Use phone / email / username')])[1]")));
        usePhone.click();

        WebElement loginWithUsername = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Log in with email or username'])[1]")));
        loginWithUsername.click();

        WebElement email = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Email or username'])[1]")));
        email.click();
        email.sendKeys("chungkhoan_anonymous");

        WebElement password = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Password'])[1]")));
        password.click();
        password.sendKeys("Huong90#");

        WebElement login = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='submit'][normalize-space()='Log in'])[1]")));
        login.click();

        Thread.sleep(60000);

        WebElement notNowButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='TUXButton-label' and text()='Not now']")));
        notNowButton.click();

        WebElement liveLeftMenu = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='css-1dhhdo4-SpanMainNavText e14l9ebt7' and text()='LIVE']")));
        liveLeftMenu.click();

        WebElement tieuBoKidClothing = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space()='tieubokidsclothing'])[1]")));
        tieuBoKidClothing.click();

        WebElement tieubo2 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='css-1wl4eri-H2UniqueId e1571njr6']")));
        tieubo2.click();

        WebElement thaTim = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-1mk0i7a-DivLikeBtnIcon ebnaa9i3']")));
        while(true) {
            thaTim.click();
        }
    }
}
