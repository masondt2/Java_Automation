package PracticePOM.pages;

import PracticePOM.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver d) {
        super(d);
    }

    @FindBy(xpath = "(//li[@class='breadcrumb-item active'])[1]")
    private WebElement dashboardTitle;

    public boolean isDashboardTitleDisplayed() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(dashboardTitle));
        return dashboardTitle.isDisplayed();
    }
}
