package exercise1;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Sceranio1 {
    //Method
    public static String generateRandomString(int numOfStr) {
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(numOfStr);
        for (int i = 0; i < numOfStr; i++) {
            int randomInt = random.nextInt(character.length());
            char randomChar = character.charAt(randomInt);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    @Parameters({"browser"})
    @Test
    public void Sceranio1(String browser) throws InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.WINDOWS);
        desiredCapabilities.setBrowserName(browser);

        WebDriver driver = new RemoteWebDriver(desiredCapabilities);

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().to("https://rawal-admin.themes-coder.net/admin/login");
        driver.manage().window().maximize();

        WebElement email = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("admin@email.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123");
        password.submit();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='subheader py-2 py-lg-6 subheader-solid']")));

        WebElement catalog = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Catalog']")));
        Thread.sleep(1000);
        catalog.click();

        WebElement productBrand = driver.findElement(By.xpath("//span[normalize-space()='Product Brands']"));

        productBrand.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Product Brands']")));

        Thread.sleep(1000);
        WebElement addButton = driver.findElement(By.xpath("//button[contains(@class,'btn ml-2 p-0 kt_notes_panel_toggle')]"));
        addButton.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Add Brand']")));

        WebElement brandName = driver.findElement(By.xpath("//input[@class='form-control']"));

        Actions action = new Actions(driver);

        if (browser.equals("chrome")) {
            String sendString;
            sendString = "Demo_Chrome_" + generateRandomString(5);
            brandName.sendKeys(sendString);

            WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
            submitButton.click();

            //Check Toast message displayed
            WebElement brandToastMessage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-toast v-toast-success']")));
            Assert.assertEquals(brandToastMessage.getText(), "Settings has been updated successfully");
            System.out.println(brandToastMessage.getText());

            //verify name and status
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Product Brands']")));

            WebElement searchBox = driver.findElement(By.xpath("//label[normalize-space()='Search:']"));
            searchBox.sendKeys(sendString);

            //Enter
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(3000);

            //verify can add successfully and status: active
            List<WebElement> resultElement = driver.findElements(By.xpath("(//tbody/tr)[1]/td"));

            //check name is displayed right
            Assert.assertEquals(resultElement.get(1).getText(), sendString);
            System.out.println(sendString);

            //check status is active
            Assert.assertEquals(resultElement.get(3).getText(), "active");
            System.out.println("active");
            driver.quit();

        } else if (browser.equals("firefox")) {
            String sendString1 = "Demo_Firefox_" + generateRandomString(4);
            brandName.sendKeys(sendString1);
            Thread.sleep(1000);
            WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
            submitButton.click();

            //Check Toast message displayed
            WebElement brandToastMessage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-toast v-toast-success']")));
            Assert.assertEquals(brandToastMessage.getText(), "Settings has been updated successfully");
            System.out.println(brandToastMessage.getText());

            //verify name and status
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Product Brands']")));

            //Thread.sleep(5000);
            WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
            searchBox.sendKeys(sendString1);
            //Enter
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(3000);

            //verify can add successfully and status: active
            List<WebElement> resultElement = driver.findElements(By.xpath("(//tbody/tr)[1]/td"));

            //check name is displayed right
            Assert.assertEquals(resultElement.get(1).getText(), sendString1);
            System.out.println(sendString1);

            //check status is active
            Assert.assertEquals(resultElement.get(3).getText(), "active");
            System.out.println("active");
            driver.quit();
        }
    }
}

