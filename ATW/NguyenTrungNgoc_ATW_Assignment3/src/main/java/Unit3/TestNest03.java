package Unit3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNest03 {
    @Test
    public void Test03() throws InterruptedException {
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
        // The screen should be displayed 10 top categories
        //Scroll web to "Top Categories
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0, 600);");
        WebElement topCategories = driver.findElement(By.xpath("//h3[text()='Top Categories']"));
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView(true);", topCategories);

        //Verify 10 top categories
        WebElement milksAndDairies = driver.findElement(By.xpath("//a[text()='Milks and Dairies']"));
        WebElement clothingAndBeauty = driver.findElement(By.xpath("//a[text()='Clothing & beauty']"));
        WebElement petToy = driver.findElement(By.xpath("//a[text()='Pet Toy']"));
        WebElement bakingMaterial = driver.findElement(By.xpath("//a[text()='Baking material']"));
        WebElement freshFruit = driver.findElement(By.xpath("//a[text()='Fresh Fruit']"));
        WebElement wineAndDrink = driver.findElement(By.xpath("//a[text()='Wines & Drinks']"));
        WebElement freshSeafood = driver.findElement(By.xpath("//a[text()='Fresh Seafood']"));
        WebElement fastFood = driver.findElement(By.xpath("//a[text()='Fast food']"));
        WebElement vegetables = driver.findElement(By.xpath("//a[text()='Vegetables']"));
        WebElement breadAndJuice = driver.findElement(By.xpath("//a[@title='Bread and Juice']"));

        Assert.assertTrue(milksAndDairies.isDisplayed(), "Milks and Dairies is not displayed");
        Assert.assertTrue(clothingAndBeauty.isDisplayed(), "Clothing And Beauty is not displayed");
        Assert.assertTrue(petToy.isDisplayed(), "Pet Toy is not displayed");
        Assert.assertTrue(bakingMaterial.isDisplayed(), "Baking Material is not displayed");
        Assert.assertTrue(freshFruit.isDisplayed(), "Fresh Fruit is not displayed");
        Assert.assertTrue(wineAndDrink.isDisplayed(), "Wines & Drinks is not displayed");
        Assert.assertTrue(freshSeafood.isDisplayed(), "Fresh Seafood is not displayed");
        Assert.assertTrue(fastFood.isDisplayed(), "Fast Food is not displayed");
        Assert.assertTrue(vegetables.isDisplayed(), "Vegetables is not displayed");
        Assert.assertTrue(breadAndJuice.isDisplayed(), "Bread and Juice is not displayed");

        driver.quit();
    }
}
