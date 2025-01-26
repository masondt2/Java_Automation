package Unit3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class TestNest05 {
    @Test
    public void TestDealsOfTheDay() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://nest.botble.com/");
        driver.manage().window().maximize();

        Thread.sleep(8000);
        try {
            WebElement closeButton = driver.findElement(By.xpath("(//button[@class='btn-close'])[1]"));
            closeButton.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //scroll to Deals Of The Day
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement dealsOfTheDay = driver.findElement(By.xpath("//h3[normalize-space()='Deals Of The Day']"));
        js.executeScript("arguments[0].scrollIntoView(true);", dealsOfTheDay);
        Thread.sleep(2000);

        //Check the screen should display 4 Deals Of The Day
        List<WebElement> listDeals = dealsOfTheDay.findElements(By.xpath("//div[@class='col-xxl-3 col-xl-4 col-lg col-md-6']"));
        Assert.assertEquals(listDeals.size(), 4,"Deals of The Day should be 4");

        for(WebElement deal : listDeals){
            System.out.println(deal.getText());
        }
    }
}
