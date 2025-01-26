package exercise2;

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

public class Exercise2 {
    @Parameters({"browser"})
    @Test
    public void Test_Excerise2(String browser) throws InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.WINDOWS);
        desiredCapabilities.setBrowserName(browser);

        WebDriver driver = new RemoteWebDriver(desiredCapabilities);
        driver.navigate().to("https://rawal-admin.themes-coder.net/admin/login?");
        driver.manage().window().maximize();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement email = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("admin@email.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123");

        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='breadcrumb-item active']")));

        Thread.sleep(2000);
        WebElement catalog = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Catalog']")));
        catalog.click();

        WebElement product = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Products']")));
        product.click();

        WebElement addProduct = driver.findElement(By.xpath("//span[normalize-space()='Add Product']"));
        addProduct.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Add Product']")));
        Thread.sleep(2000);

        //Get Dynamics select
        WebElement selectOption = driver.findElement(By.xpath("//div[@class='multiselect__tags']"));
        selectOption.click();

        //Get input select and sendKeys
        Thread.sleep(1000);
        WebElement selectInput = driver.findElement(By.xpath("//input[@placeholder='Select one']"));
        selectInput.sendKeys("Cat1");

        //Enter
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

        //get Language
        List<WebElement> lstLanguage = driver.findElements(By.xpath("//ul[@id='pills-tab1']/li"));

        WebElement continueButton = driver.findElement(By.xpath("//a[@href='#ad-info']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", continueButton);

        String sendString = "Demo_AutoTest_By_Ngoc";

        for (int i = 1; i <= lstLanguage.size(); i++) {
            Thread.sleep(1000);
            WebElement lang = driver.findElement(By.xpath("(//ul[@id='pills-tab1']/li)[" + i + "]"));
            lang.click();

            WebElement name = driver.findElement(By.name("name" + (i - 1)));
            name.sendKeys(sendString);

            WebElement description = driver.findElement(By.xpath("(//textarea[@id='label-textarea'])[" + i + "]"));
            description.sendKeys(sendString);
        }

        WebElement addProTitle = driver.findElement(By.xpath("//h3[normalize-space()='Add Product']"));
        js.executeScript("window.scrollBy(0, -400);");

        WebElement addMedia = driver.findElement(By.xpath("//a[normalize-space()='Add Media']"));
        addMedia.click();

        Set<String> lstWindow = driver.getWindowHandles();
        for (String s : lstWindow) {
            driver.switchTo().window(s);
            if (driver.getPageSource().contains("Load More")) {
                break;
            }
        }

        WebElement firstImage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'thumbnail-imges')])[1]")));
        firstImage.click();

        WebElement chooseButton = driver.findElement(By.xpath("(//span[contains(text(),'Choose')])[1]"));
        chooseButton.click();

        //Update Advance information
        WebElement advanceInfo = driver.findElement(By.xpath("//a[normalize-space()='Advance Info']"));
        advanceInfo.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Advance Information']")));

        WebElement productType = driver.findElement(By.xpath("(//select[contains(@class,'single-select')])[1]"));
        Select selectProductType = new Select(productType);
        selectProductType.selectByVisibleText("Simple");

        WebElement selectUnit = driver.findElement(By.xpath("(//select[contains(@class,'single-select')])[2]"));
        Select select = new Select(selectUnit);
        select.selectByVisibleText("kilo");

        WebElement selectBrands = driver.findElement(By.xpath("(//select[contains(@class,'single-select')])[3]"));
        Select select1 = new Select(selectBrands);
        select1.selectByVisibleText("KIA");

        WebElement weight = driver.findElement(By.id("weight"));
        weight.sendKeys("10");

        WebElement price = driver.findElement(By.xpath("//input[@placeholder='Enter Price']"));
        price.sendKeys("1000");

        WebElement discountPrice = driver.findElement(By.xpath("//input[@placeholder='Enter Discount Price']"));
        discountPrice.sendKeys("0.1");

        WebElement sku = driver.findElement(By.xpath("//input[@placeholder='Enter Sku']"));
        sku.sendKeys(generateRandomString(10));

        js.executeScript("window.scrollBy(0, -400);");
        WebElement seoTab = driver.findElement(By.xpath("//a[normalize-space()='SEO']"));
        seoTab.click();

        WebElement save = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Save']")));
        save.click();

        //Verify message "Category has been updated successfully"
        WebElement productToastMessage = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-toast v-toast-success']")));
        Assert.assertEquals(productToastMessage.getText(), "Product Save Successfully!");
        System.out.println(productToastMessage.getText());

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Product List']")));
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));

        searchBox.sendKeys(sendString);
        action.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        WebElement resultElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//tbody/tr)[1]/td)[2]")));
        Assert.assertEquals(sendString, resultElement.getText());

        WebElement pos = driver.findElement(By.xpath("(//div[@class='posicon d-lg-block d-none'])[1]"));
        pos.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='WELCOME']")));
        Thread.sleep(10000);

        WebElement createdProduct = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='productContent'])[1]")));
        createdProduct.click();

        WebElement discountPriceDisplayed = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tbody/tr/td)[4]")));
        Assert.assertEquals(discountPriceDisplayed.getText(), "0.1");

        driver.quit();
    }
}
