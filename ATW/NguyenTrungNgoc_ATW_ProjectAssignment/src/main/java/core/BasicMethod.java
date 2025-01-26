package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicMethod {
    //Scroll
//    JavascriptExecutor js = (JavascriptExecutor) getDriver();
//    js.executeScript("arguments[0].scrollIntoView(true);", submitButtonElement);

    //enter
//    Actions actions = new Actions(getDriver());
//    actions.sendKeys(Keys.ENTER).perform();
//
    //generate random strings
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

    //generate random strings
    public static String generateRandomNumber(int numOfStr) {
        String character = "0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(numOfStr);
        for (int i = 0; i < numOfStr; i++) {
            int randomInt = random.nextInt(character.length());
            char randomChar = character.charAt(randomInt);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
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

    //Method to check list String DESC by Collections
    public static boolean isSortedDescendingByCollections(List<String> list) {
        // create the new copy of check list
        List<String> sortedList = new ArrayList<>(list);

        // arrange the copy list as DESC
        Collections.sort(sortedList, Collections.reverseOrder());

        // compare check list with arranged list
        return list.equals(sortedList);
    }

    //Method to check list String ASC by Collections
    public static boolean isSortedAscendingByCollections(List<String> list) {
        // create the new copy of check list
        List<String> sortedList = new ArrayList<>(list);

        // arrange the copy list as ASC
        Collections.sort(sortedList);

        // compare check list with arranged list
        return list.equals(sortedList);
    }

    public static void main(String[] args) {
        String input = "%test@123";
        String regex = "^[a-zA-Z]+[a-zA-Z]*$";
        // Tạo pattern để tìm ký tự '@'
        Pattern atPattern = Pattern.compile("@");
        Matcher atMatcher = atPattern.matcher(input);

        // Tạo pattern để tìm ký tự '%'
        Pattern percentPattern = Pattern.compile("%");
        Matcher percentMatcher = percentPattern.matcher(input);

        // Kiểm tra xem cả hai ký tự '@' và '%' đều xuất hiện trong chuỗi không
        boolean containsAt = atMatcher.find();
        boolean containsPercent = percentMatcher.find();
        if (containsAt && containsPercent) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }

        //kiểm tra xem 4 chữ cái đầu trong chuỗi có phải là "test" không
        String regex4character = "^test";
        String input4character = "test @1234 Ngoc";
        Pattern regex4characterPattern = Pattern.compile(regex4character);
        Matcher regex4characterMatcher = regex4characterPattern.matcher(input4character);
        if (regex4characterMatcher.find()) {
            System.out.println("Match test found");
        } else {
            System.out.println("Match test not found");
        }

        //các định dạng ngày phổ biến:
//        "yyyy-MM-dd": Định dạng năm-tháng-ngày, ví dụ: 2024-09-13.
//        "MM/dd/yyyy": Định dạng tháng/ngày/năm, ví dụ: 09/13/2024.
//        "dd/MM/yyyy": Định dạng ngày/tháng/năm, ví dụ: 13/09/2024.
//        "yyyy-MM-dd'T'HH:mm:ss": Định dạng ngày giờ, ví dụ: 2024-09-13T15:30:00.
//        "dd MMM yyyy": Định dạng ngày tháng với tên tháng viết tắt, ví dụ: 13 Sep 2024.
//        "EEEE, MMMM d, yyyy": Định dạng ngày tháng với tên đầy đủ của ngày trong tuần và tháng, ví dụ: Friday, September 13, 2024.

//        y: Năm(e.g., yyyy cho năm đầy đủ, yy cho năm hai chữ số).
//        M:Tháng(e.g., MM cho tháng, MMM cho tên viết tắt của tháng, MMMM cho tên đầy đủ của tháng).
//        d:Ngày trong tháng(e.g., dd cho ngày).
//        H:Giờ theo định dạng 24 giờ(e.g., HH).
//        m:Phút(e.g., mm).
//        s:Giây(e.g., ss).
//        a:AM / PM(e.g., a).
//        E:Tên đầy đủ hoặc viết tắt của ngày trong tuần (e.g., EEE cho viết tắt, EEEE cho đầy đủ).

        List<String> list = new ArrayList<>();
        list.add("yeu");
        list.add("ngoc");
        list.add("anh");
        System.out.println(isSortedDescendingByCollections(list));
        String random3number = generateRandomNumber(3);
        System.out.println(random3number);



        //Screenshot
//        Robot robot = new Robot();
//        Rectangle rectangle = new Rectangle(x, y, 600, 150);
//        BufferedImage image = robot.createScreenCapture(rectangle);
//        File file = new File("./Screenshot/alert_exercise2.png");
//        ImageIO.write(image, "png", file);
        //get Alige element
//        WebElement alige = driver.findElement(By.xpath("(//li[@class='dropdown'])[3]"));
//        int x = alige.getLocation().getX();
//        int y = alige.getLocation().getY();


        //drop drag
//        WebElement dragElement = driver.findElement(By.xpath("(//li[@class='block13 ui-draggable'])[1]"));
//        WebElement dropElement = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));
//
//        Actions action = new Actions(driver);
//        action.dragAndDrop(dragElement, dropElement).perform();

        //double click
//        Actions action = new Actions(driver);
//        action.doubleClick(doubleClickBox).perform();
//        Thread.sleep(1000);


        //right click event
//        WebElement rightClickButton = driver.findElement(By.xpath(" (//span[@class='context-menu-one btn btn-neutral'])[1]"));
//        Actions action = new Actions(driver);
//        WebElement editMenuItem = driver.findElement(By.xpath("(//span[normalize-space()='Edit'])[1]"));
//        action.contextClick(rightClickButton).moveToElement(editMenuItem).click().perform();


//        Set<Cookie> cookieSet = driver.manage().getCookies();
//        for (Cookie cookie : cookieSet) {
//            System.out.println(cookie.getDomain());
//            System.out.println(cookie.getValue());
//        }

    }
}
