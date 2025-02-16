package exercise3;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProviderSample {
    @DataProvider(name="List Color Test")
    public static Object[][] listColor(){
        return new Object[][] {{"red","#f00"},{"green","#0f0"},{"blue","#00f"},{"cyan","#0ff"},{"magenta","#f0f"},{"yellow","#ff0"},{"black","#000"}};
    }

    @Test(dataProvider="List Color Test")
    public void Test(String color, String value){
        System.out.println("Color: "+color);
        System.out.println(" Value: "+value);
    }
}
