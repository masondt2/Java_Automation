package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase03 {
    @Test
    public void TC_03() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.worksuite.biz/login");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement email = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("admin@example.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");

        WebElement login = driver.findElement(By.id("submit-login"));
        login.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='page-title d-none d-lg-flex']")));

        WebElement client = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='pl-3'][normalize-space()='Clients']")));
        client.click();

        WebElement heading = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='page-heading'])[1]")));

        WebElement startDateAndEnd = driver.findElement(By.xpath("//input[@id='datatableRange']"));
        startDateAndEnd.click();

        WebElement last6Month = driver.findElement(By.xpath("//li[normalize-space()='Last 6 Months']"));
        last6Month.click();

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search-text-field']"));
        searchBox.clear();
        searchBox.sendKeys("Kiley Barton");

        WebElement action = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdownMenuLink-13")));
        action.click();

        WebElement edit = driver.findElement(By.xpath("(//div[@class='dropdown-menu dropdown-menu-right show']/a)[2]"));
        edit.click();

        //verify update client
        WebElement accountDetails = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Account Details']")));

        WebElement clientName = driver.findElement(By.xpath("//input[@id='name']"));
        Assert.assertTrue(clientName.isDisplayed() && clientName.getAttribute("value").equals("Kiley Barton"), "Client Name is not displayed property!");

        WebElement clientEmail = driver.findElement(By.id("email"));
        Assert.assertTrue(clientEmail.isDisplayed() && clientEmail.getAttribute("value").equals("shanelle28@example.net3"), "Client Email is not displayed property!");

        WebElement receiveEmailNotify = driver.findElement(By.xpath("//label[normalize-space()='Receive email notifications?']"));
        Assert.assertEquals(receiveEmailNotify.getText(), "Receive email notifications?");

        WebElement yesButton = driver.findElement(By.xpath("//input[@id='notification-yes']"));
        Assert.assertTrue(yesButton.isSelected(), "Yes button is not selected!");

        WebElement status = driver.findElement(By.xpath("(//div[@class='col-lg-3 col-md-6'])[4]"));
        Assert.assertTrue(status.isDisplayed() && status.getText().contains("Status"), "Status is not displayed property!");

        WebElement activeStatus = driver.findElement(By.id("status-active"));
        Assert.assertTrue(activeStatus.isSelected(), "Yes Status is not selected!");

        WebElement companyNameLabel = driver.findElement(By.xpath("//label[normalize-space()='Company Name']"));
        Assert.assertTrue(companyNameLabel.isDisplayed() && companyNameLabel.getText().equals("Company Name"), "Company Name is not displayed property!");

        WebElement companyName = driver.findElement(By.id("company_name"));
        Assert.assertEquals(companyName.getAttribute("value"), "Walter Group");

        WebElement websiteLabel = driver.findElement(By.xpath("//label[normalize-space()='Official Website']"));
        Assert.assertTrue(websiteLabel.isDisplayed() && websiteLabel.getText().equals("Official Website"), "Official Website is not displayed property!");

        WebElement website = driver.findElement(By.id("website"));
        Assert.assertEquals(website.getAttribute("value"), "https://worksuite.biz");

        System.out.println("Client information has been verified.");
        driver.quit();
    }
}
