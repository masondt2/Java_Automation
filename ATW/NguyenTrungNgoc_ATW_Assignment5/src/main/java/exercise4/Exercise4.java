package exercise4;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Exercise4 {
    @Test
    public void Test04() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://tiki.vn/");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='tiki-logo']")));

        Set<Cookie> cookieSet = driver.manage().getCookies();
        for (Cookie cookie : cookieSet) {
            System.out.println(cookie.getDomain());
            System.out.println(cookie.getValue());
        }
        driver.quit();
    }
}
