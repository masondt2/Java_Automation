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


public class TestCase01 {
    @Test
    public void TC_01() {
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

        //verify Left Menu:
        WebElement privateDashboard = driver.findElement(By.xpath("//a[normalize-space()='Private Dashboard']"));
        WebElement advancedDashboard = driver.findElement(By.xpath("//a[normalize-space()='Advanced Dashboard']"));
        WebElement leads = driver.findElement(By.xpath("//span[normalize-space()='Leads']"));
        WebElement hr = driver.findElement(By.xpath("//span[@class='pl-3'][normalize-space()='HR']"));
        WebElement work = driver.findElement(By.xpath("//span[normalize-space()='Work']"));
        WebElement finance = driver.findElement(By.xpath("//span[@class='pl-3'][normalize-space()='Finance']"));
        WebElement order = driver.findElement(By.xpath("//span[normalize-space()='Orders']"));
        WebElement ticket = driver.findElement(By.xpath("//span[normalize-space()='Tickets']"));
        WebElement event = driver.findElement(By.xpath("//span[normalize-space()='Events']"));

        Assert.assertTrue(privateDashboard.isDisplayed(), "Private Dashboard is not displayed");
        Assert.assertTrue(advancedDashboard.isDisplayed(), "Advanced Dashboard is not displayed");
        Assert.assertTrue(leads.isDisplayed(), "Leads is not displayed");
        Assert.assertTrue(hr.isDisplayed(), "HR is not displayed");
        Assert.assertTrue(work.isDisplayed(), "Work is not displayed");
        Assert.assertTrue(finance.isDisplayed(), "Finance is not displayed");
        Assert.assertTrue(order.isDisplayed(), "Order is not displayed");
        Assert.assertTrue(ticket.isDisplayed(), "Ticket is not displayed");
        Assert.assertTrue(event.isDisplayed(), "Event is not displayed");

        advancedDashboard.click();
        //Verify widget
        WebElement totalClient = driver.findElement(By.xpath("(//div[contains(@class,'col-xl-3 col-lg-6 col-md-6 mb-3')])[1]"));
        Assert.assertTrue(totalClient.isDisplayed() && (totalClient.getText()).contains("Total Clients"), "Total Client is not displayed");

        WebElement totalEmployees = driver.findElement(By.xpath("(//div[contains(@class,'col-xl-3 col-lg-6 col-md-6 mb-3')])[2]"));
        Assert.assertTrue(totalEmployees.isDisplayed() && (totalEmployees.getText()).contains("Total Employees"), "Total Employees is not displayed");


        WebElement totalProjects = driver.findElement(By.xpath("(//div[contains(@class,'col-xl-3 col-lg-6 col-md-6 mb-3')])[3]"));
        Assert.assertTrue(totalProjects.isDisplayed() && (totalProjects.getText()).contains("Total Projects"), "Total Projects is not displayed");

        WebElement dueInvoices = driver.findElement(By.xpath("(//div[contains(@class,'col-xl-3 col-lg-6 col-md-6 mb-3')])[4]"));
        Assert.assertTrue(dueInvoices.isDisplayed() && (dueInvoices.getText()).contains("Due Invoices"), "Due Invoices is not displayed");

        WebElement hoursLogged = driver.findElement(By.xpath("(//div[contains(@class,'col-xl-3 col-lg-6 col-md-6')])[5]"));
        Assert.assertTrue(hoursLogged.isDisplayed() && (hoursLogged.getText()).contains("Hours Logged"), "Hours Logged is not displayed");

        WebElement pendingTasks = driver.findElement(By.xpath("(//div[contains(@class,'col-xl-3 col-lg-6 col-md-6')])[6]"));
        Assert.assertTrue(pendingTasks.isDisplayed() && (pendingTasks.getText()).contains("Pending Tasks"), "Pending Tasks is not displayed");

        WebElement todayAttendance = driver.findElement(By.xpath("(//div[contains(@class,'col-xl-3 col-lg-6 col-md-6')])[7]"));
        Assert.assertTrue(todayAttendance.isDisplayed() && (todayAttendance.getText()).contains("Today Attendance"), "Today Attendance is not displayed");

        WebElement unresolvedTickets = driver.findElement(By.xpath("(//div[contains(@class,'col-xl-3 col-lg-6 col-md-6')])[8]"));
        Assert.assertTrue(unresolvedTickets.isDisplayed() && (unresolvedTickets.getText()).contains("Unresolved Tickets"), "Unresolved Tickets is not displayed");

    }
}
