package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ListPurchasesPage extends BasePage {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @FindBy(xpath = "//table[@id='POData']/tbody/tr")
    private List<WebElement> lstPurchasesElement;

    @FindBy(xpath = "//a[normalize-space()='Next >']")
    private WebElement nextButtonElement;

    //private List<String> lstTextDateOfTable = new ArrayList<>();

    private List<String> lstReferenceNoOfTable = new ArrayList<>();

    public ListPurchasesPage(WebDriver d) {
        super(d);
    }

    //Method to check datetime Format: dd/MM/yyyy HH:mm:ss
    public static boolean isValidDateTime(String format, String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        try {
            LocalDateTime.parse(dateTimeString, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    //Method to check list String DESC
    private static boolean isSortedDescending(List<String> listCheck) {
        for (int i = 1; i < listCheck.size(); i++) {
            if (listCheck.get(i - 1).compareTo(listCheck.get(i)) < 0) {
                return false;
            }
        }
        return true;
    }

    //Method to check list String ASC
    private static boolean isSortedAscending(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public Boolean VerifyPurchasesTableDisplayed(String formatDatetime, String referenceOrder, String noOfDisplay) throws InterruptedException {
        js.executeScript("arguments[0].scrollIntoView(true);", nextButtonElement);
        Thread.sleep(2000);

        boolean checkNoDisplay = lstPurchasesElement.size() == Integer.parseInt(noOfDisplay);
        if (checkNoDisplay) {
            System.out.println("Dispayed " + lstPurchasesElement.size() + " Purchases");
        }

        boolean checkformatDatetime = true;
        for (int i = 0; i < lstPurchasesElement.size(); i++) {
            String textDatei = getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='POData']/tbody/tr[" + (i + 1) + "]/td[2]"))).getText();
            if (!(isValidDateTime(formatDatetime, textDatei))) {
                checkformatDatetime = false;
                break;
            } else {
                System.out.println(textDatei + " is verified!");
            }
        }

        boolean checkReferenceOrder = true;
        for (int i = 0; i < lstPurchasesElement.size(); i++) {
            String textReferenceNoi = getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='POData']/tbody/tr[" + (i + 1) + "]/td[3]"))).getText();
            lstReferenceNoOfTable.add(textReferenceNoi);
        }
        if (referenceOrder.toUpperCase().equals("DESC")) {
            checkReferenceOrder = isSortedDescending(lstReferenceNoOfTable);
            System.out.println("Reference No order by DESC");
        } else if (referenceOrder.toUpperCase().equals("ASC")) {
            checkReferenceOrder = isSortedAscending(lstReferenceNoOfTable);
            System.out.println("Reference No order by ASC");
        }

        return checkNoDisplay && checkformatDatetime && checkReferenceOrder;
    }
}
