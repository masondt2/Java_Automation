package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestCase05 {
    @Test
    public void TC_05() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.worksuite.biz/login");
        driver.manage().window().maximize();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement email = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("admin@example.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");

        password.submit();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='page-title d-none d-lg-flex']")));

        WebElement work = driver.findElement(By.xpath("//span[normalize-space()='Work']"));
        work.click();

        WebElement project = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Projects']")));
        project.click();

        //verify The table displayed 10 Projects
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='page-heading'])[1]")));

        Thread.sleep(1000);
        List<WebElement> listProject = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(listProject.size(), 10, "Number of projects should be 10");

        //
        WebElement searchBox = driver.findElement(By.id("search-text-field"));
        searchBox.sendKeys("Financial planning and budgeting tool");
        Thread.sleep(10000);

        //Check can search successfully
        List<WebElement> prjFound = driver.findElements(By.xpath("//table/tbody/tr"));
        Assert.assertFalse(prjFound.isEmpty(), "No projects found");

        //Thread.sleep(1000);
        //System.out.println(prjFound.getFirst().getText());
        Assert.assertTrue(prjFound.getFirst().getText().contains("Financial planning and budgeting tool"), "Projects displayed wrong.");

        WebElement dropdown = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdownMenuLink-3")));
        dropdown.click();

        //Thread.sleep(1000);
        WebElement view = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='View']")));
        view.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='page-title d-none d-lg-flex']")));

        //verify Project progrees
        WebElement projectProgress = driver.findElement(By.xpath("//h4[normalize-space()='Project Progress']"));
        Assert.assertTrue(projectProgress.isDisplayed() && projectProgress.getText().equals("Project Progress"), "Project Progress is not displayed property");

        //Check StartDate
        WebElement startDate = driver.findElement(By.xpath("//div[contains(@class,'p-start-date mb-xl-0 mb-lg-3')]"));
        Assert.assertTrue(startDate.isDisplayed() && startDate.getText().contains("Start Date") && startDate.getText().contains("28-04-2024"), "Start Date is not displayed property");

        //Check Deadline
        WebElement deadline = driver.findElement(By.xpath("//div[contains(@class,'p-end-date')]"));
        Assert.assertTrue(deadline.isDisplayed() && deadline.getText().contains("Deadline") && deadline.getText().contains("28-08-2024"), "Deadline is not displayed property");

        //Check Client
        WebElement client = driver.findElement(By.xpath("(//div[contains(@class,'col-md-6 mb-4')])[2]"));
        Assert.assertTrue(client.isDisplayed() && client.getText().contains("Client") && client.getText().contains("Lola Crona I"));

        //Check Statistics
        WebElement statistics = driver.findElement(By.xpath("(//div[@class='col-sm-12'])[1]"));
        Assert.assertTrue(statistics.isDisplayed() && statistics.getText().equals("Statistics"));

        //Check 5 Statistics tab
        //Check Budget
        WebElement budget = driver.findElement(By.xpath("(//div[contains(@class,'d-block text-capitalize')])[1]"));
        Assert.assertTrue(budget.isDisplayed() && budget.getText().contains("Project Budget"));

        //Check Hours Logged
        WebElement hoursLogged = driver.findElement(By.xpath("(//div[contains(@class,'d-block text-capitalize')])[2]"));
        Assert.assertTrue(hoursLogged.isDisplayed() && hoursLogged.getText().contains("Hours Logged"));

        //Check Earnings
        WebElement earnings = driver.findElement(By.xpath("(//div[contains(@class,'d-block text-capitalize')])[3]"));
        Assert.assertTrue(earnings.isDisplayed() && earnings.getText().contains("Earnings"));

        //Check Expenses
        WebElement expenses = driver.findElement(By.xpath("(//div[contains(@class,'d-block text-capitalize')])[4]"));
        Assert.assertTrue(expenses.isDisplayed() && expenses.getText().contains("Expenses"));

        //Check Profit
        WebElement profit = driver.findElement(By.xpath("(//div[contains(@class,'d-block text-capitalize')])[5]"));
        Assert.assertTrue(profit.isDisplayed() && profit.getText().contains("Profit"));

        //Check Project Details
        WebElement projectDetails = driver.findElement(By.xpath("//div[contains(@class,'col-md-12 mb-4')]//div[contains(@class,'card-header bg-white border-0 text-capitalize d-flex justify-content-between pt-4')]"));
        Assert.assertTrue(projectDetails.isDisplayed() && projectDetails.getText().equals("Project Details"));

        //Scroll to Project Details
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", projectDetails);

        WebElement textProject = driver.findElement(By.xpath("//div[@class='card-body pt-2 d-flex justify-content-between align-items-center']"));
        String textCheck = "Eum qui a minus maiores nesciunt. Dolor numquam ratione est doloremque eum consequatur maxime ut. Omnis et et asperiores autem omnis voluptatem. Omnis voluptas maiores debitis nulla fuga voluptatem et. Velit asperiores rem ad.";
        Assert.assertTrue(textProject.getText().equals(textCheck));

        WebElement memberTab = driver.findElement(By.xpath("(//span[contains(text(),'Members')])[1]"));
        Assert.assertTrue(memberTab.isDisplayed(), "Member Tab is not displayed");
        memberTab.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Members']")));

        List<WebElement> lstRowMembers = driver.findElements(By.xpath("//tbody/tr"));
        List<String> lstNameMembers = new ArrayList<>();

        Assert.assertEquals(lstRowMembers.size(), 5, "Total Members should be 5");
        int columnIndex = 1;

        // Get the second column for each row
        for (WebElement row : lstRowMembers) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            lstNameMembers.add(cells.get(columnIndex).getText());
        }

        //Verify list name members contains: "Mr. Vern Parisian", "Dr. Milo Veum", "Dr. Milo Veum", "Demarco O'Kon", "Norene Schaefer"
        Assert.assertTrue(lstNameMembers.get(0).contains("Mr. Vern Parisian"));
        Assert.assertTrue(lstNameMembers.get(1).contains("Dr. Milo Veum"));
        Assert.assertTrue(lstNameMembers.get(2).contains("Dr. Milo Veum"));
        Assert.assertTrue(lstNameMembers.get(3).contains("Demarco O'Kon"));
        Assert.assertTrue(lstNameMembers.get(4).contains("Norene Schaefer"));

        driver.quit();
    }
}
