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

public class TestCase02 {
    @Test
    public void TC_02() throws InterruptedException {
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

        WebElement lead = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Leads']")));
        lead.click();

        WebElement leadContact = driver.findElement(By.xpath("//a[@title='Lead Contact']"));
        leadContact.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='page-title d-none d-lg-flex']")));

        WebElement searchBox = driver.findElement(By.id("search-text-field"));
        searchBox.sendKeys("ro");
        Thread.sleep(2000);

        WebElement showing = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='lead-contact-table_info']")));
        if (showing.getText().equals("Showing 0 to 0 of 0 entries")) {
            System.out.println("No search information found");
            driver.quit();
        } else {
            WebElement firstName = driver.findElement(By.xpath("((//table[@id='lead-contact-table']/tbody/tr)[1]/td)[3]//a"));
            firstName.click();
            //Verify tab
            WebElement profileTab = driver.findElement(By.xpath("//span[normalize-space()='Profile']"));
            Assert.assertTrue(profileTab.isDisplayed() && (profileTab.getText()).contains("Profile"), "Profile Tab is not displayed");

            WebElement dealTab = driver.findElement(By.xpath("//span[normalize-space()='Deals']"));
            Assert.assertTrue(dealTab.isDisplayed() && dealTab.getText().contains("Deals"), "Deals Tab is not displayed");

            WebElement noteTab = driver.findElement(By.xpath("//span[normalize-space()='Notes']"));
            Assert.assertTrue(noteTab.isDisplayed() && noteTab.getText().contains("Notes"), "Notes Tab is not displayed");

            System.out.println("3 Tab are verified!");

            //verify information
            WebElement name = driver.findElement(By.xpath("(//div[@class='col-12 px-0 pb-3 d-lg-flex d-md-flex d-block'])[1]"));
            Assert.assertTrue(name.isDisplayed() && name.getText().contains("Name") && name.getText().contains("Roma Kreiger"), "Name is not displayed");

            WebElement emailInfor = driver.findElement(By.xpath("(//div[@class='col-12 px-0 pb-3 d-lg-flex d-md-flex d-block'])[2]"));
            Assert.assertTrue(emailInfor.isDisplayed() && emailInfor.getText().contains("Email") && emailInfor.getText().contains("fake@example.com"), "Email is not displayed");

            WebElement companyName = driver.findElement(By.xpath("(//div[@class='col-12 px-0 pb-3 d-lg-flex d-md-flex d-block'])[5]"));
            Assert.assertTrue(companyName.isDisplayed() && companyName.getText().contains("Company Name") && companyName.getText().contains("Strosin, Senger and Bauch"), "Company Name is not displayed");

            WebElement website = driver.findElement(By.xpath("(//div[@class='col-12 px-0 pb-3 d-lg-flex d-md-flex d-block'])[6]"));
            Assert.assertTrue(website.isDisplayed() && website.getText().contains("Website") && website.getText().contains("https://worksuite.biz"), "Website is not displayed");

            WebElement mobile = driver.findElement(By.xpath("(//div[@class='col-12 px-0 pb-3 d-lg-flex d-md-flex d-block'])[7]"));
            Assert.assertTrue(mobile.isDisplayed() && mobile.getText().contains("Mobile") && mobile.getText().contains("+1.629.306.6105"), "Mobile is not displayed");

            WebElement address = driver.findElement(By.xpath("(//div[@class='col-12 px-0 pb-3 d-lg-flex d-md-flex d-block'])[13]"));
            Assert.assertTrue(address.isDisplayed() && address.getText().contains("Address") && address.getText().contains("5333 Luisa Route Jeannebury, VA 02057-9403"), "Address is not displayed");

            System.out.println("Information is verified");
            driver.quit();
        }
    }
}
