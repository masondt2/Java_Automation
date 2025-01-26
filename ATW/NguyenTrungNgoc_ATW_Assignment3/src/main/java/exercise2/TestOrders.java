package exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestOrders {
    @Test
    public void TestOrder() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://saka-cart.dokans.online/login");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("email"));
        Assert.assertTrue(email.isDisplayed(), "Email is not displayed");
        email.sendKeys("saka-cart@email.com");

        WebElement password = driver.findElement(By.id("password"));
        Assert.assertTrue(password.isDisplayed(), "Password is not displayed");
        password.sendKeys("rootadmin");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
        loginButton.click();

        Thread.sleep(5000);
        // Click to Order
        WebElement orderSubmenu = driver.findElement(By.xpath("//span[text()='Orders']"));
        Assert.assertTrue(orderSubmenu.isDisplayed(), "Orders is not displayed");
        orderSubmenu.click();

        WebElement allOrders = driver.findElement(By.xpath("//a[text()='All Orders']"));
        Assert.assertTrue(allOrders.isDisplayed(), "All Orders is not displayed");
        allOrders.click();

        //Write xpath of order total, payment status base on order name.
        String orderName = "SAKA736";
        List<WebElement> listOrderTotal = driver.findElements(By.xpath("(//a[text()='" + orderName + "']//ancestor::tr)/td[5]"));
        for (WebElement order : listOrderTotal) {
            Assert.assertTrue(order.isDisplayed(), "Order is not displayed");
        }

        List<WebElement> listPayment = driver.findElements(By.xpath("(//a[text()='" + orderName + "']//ancestor::tr)/td[6]"));
        for (WebElement payment : listPayment) {
            Assert.assertTrue(payment.isDisplayed(), "Payment is not displayed");
        }

        //Write xpath to get 4 first order in Orders table
        List<WebElement> list4FirstOrder = driver.findElements(By.xpath("(//tbody[@class='list font-size-base rowlink'])//tr[position()<=4]"));
        Assert.assertEquals(list4FirstOrder.size(), 4, "There are no more orders");

        driver.quit();
    }
}
