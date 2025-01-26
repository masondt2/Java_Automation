package Pages;

import Core.AppiumBase;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends AppiumBase {

    public CategoryPage() {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);}

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"wrteam.multivendor.customer:id/tvTitle\"]")
    private List<WebElement> lstCategory;

    public boolean verifyCategoryScreen(String num, List<String> lstVerify){
        List<String> lstCategoryName = new ArrayList<>();
        try{
            for(WebElement ele : lstCategory){
                lstCategoryName.add(ele.getText().trim().split(",")[0]);
            }
            Assert.assertEquals(lstCategoryName.size(), Integer.parseInt(num));
            System.out.println("Number of categories: " + lstCategory.size());

            Assert.assertEquals(lstVerify, lstCategoryName);
            System.out.print("List of categories: ");
            for(String lst : lstCategoryName){
                System.out.print(lst + ",");
            }

            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



}
