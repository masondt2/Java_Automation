package exercise1;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static exercise1.Sceranio1.generateRandomString;

public class Sceranio2 {
    @Parameters({"browser"})
    @Test(priority = 2)
    public void TestSceranio2(String browser) throws InterruptedException {
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
        Thread.sleep(1000);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='subheader py-2 py-lg-6 subheader-solid']")));

        WebElement catalog = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Catalog']")));
        Thread.sleep(1000);
        catalog.click();

        WebElement productCatagories = driver.findElement(By.xpath("//span[normalize-space()='Product Categories']"));
        productCatagories.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Product Categories']")));
        Thread.sleep(3000);

        WebElement addButton = driver.findElement(By.xpath("//button[contains(@class,'btn ml-2 p-0 kt_notes_panel_toggle')]"));
        addButton.click();

        String chromeName = "Demo_Chrome_" + generateRandomString(5);
        String firefoxName = "Demo_Firefox_" + generateRandomString(4);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Add Category']")));
        //Get list language
        List<WebElement> lstLang = driver.findElements(By.xpath("//div[@class='tabslang']/div"));
        for (int i = 1; i <= lstLang.size(); i++) {
            WebElement lang = driver.findElement(By.xpath("(//div[@class='tabslang']/div)[" + i + "]"));
            lang.click();

            WebElement descriptionInput = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));

            //Update name for each Chrome and FireFox
            WebElement name = driver.findElement(By.name("name" + (i - 1)));
            if (browser.equals("chrome")) {
                name.sendKeys(chromeName);
                descriptionInput.sendKeys(chromeName);

            } else if (browser.equals("firefox")) {
                name.sendKeys(firefoxName);
                descriptionInput.sendKeys(firefoxName);
            }
        }

        //Scroll down
        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);

        Thread.sleep(2000);
        WebElement selectOption = driver.findElement(By.xpath("//select[@class='js-example-basic-single js-states form-control bg-transparent']"));
        Select select = new Select(selectOption);
        select.selectByVisibleText("Cat1");

        WebElement slugInput = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
        slugInput.sendKeys("demo");

        WebElement updateMedia = driver.findElement(By.xpath("//button[normalize-space()='Upload Category Media']"));

        WebElement updateIcon = driver.findElement(By.xpath("//button[normalize-space()='Upload Category Icon']"));

        //Current window
        String windowID = driver.getWindowHandle();

        //Update Category Media
        updateMedia.click();
        Set<String> lsWindow = driver.getWindowHandles();
        for (String ls : lsWindow) {
            driver.switchTo().window(ls);
            if (driver.getPageSource().contains("Load More")) {
                break;
            }
        }
        WebElement firstImage = driver.findElement(By.xpath("(//div[contains(@class,'thumbnail-imges')])[1]"));
        firstImage.click();

        Thread.sleep(1000);
        WebElement chooseButton = driver.findElement(By.xpath("(//span[contains(text(),'Choose')])[1]"));
        chooseButton.click();

        //Update Icon
        updateIcon.click();
        Set<String> lsWindow1 = driver.getWindowHandles();
        for (String ls : lsWindow) {
            driver.switchTo().window(ls);
            if (driver.getPageSource().contains("Load More")) {
                break;
            }
        }
        WebElement firstImage1 = driver.findElement(By.xpath("(//div[contains(@class,'thumbnail-imges')])[11]"));
        firstImage1.click();

        Thread.sleep(1000);
        WebElement chooseButton1 = driver.findElement(By.xpath("(//span[contains(text(),'Choose')])[2]"));
        chooseButton1.click();

        submitButton.click();
        Thread.sleep(1000);

        //Verify message "Category has been updated successfully"
        WebElement categoryToastMessage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-toast v-toast-success']")));
        Assert.assertEquals(categoryToastMessage.getText(), "Category has been updated successfully");
        System.out.println(categoryToastMessage.getText());

        //Verify create successfully
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Product Categories']")));
        WebElement searchBox = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
        Actions action = new Actions(driver);

        WebElement tableNameCreate = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//tbody/tr)[1]/td)[2]")));

        if (browser.equals("chrome")) {
            searchBox.sendKeys(chromeName);
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(3000);
            Assert.assertEquals(chromeName, tableNameCreate.getText());

        } else if (browser.equals("firefox")) {
            searchBox.sendKeys(firefoxName);
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);
            action.sendKeys(Keys.ENTER).perform();
            Thread.sleep(3000);
            Assert.assertEquals(firefoxName, tableNameCreate.getText());
        }

        driver.quit();
    }
}
