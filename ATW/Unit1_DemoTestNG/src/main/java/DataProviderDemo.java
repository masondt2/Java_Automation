import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
    @DataProvider(name = "Account_Test")
    public static Object[][] listAccountTest(){
        return new Object[][] {{"test1@gmail.com","123456"},{"test2@gmail.com","789654"}};
    }

    @Test(dataProvider = "Account_Test")
    public void test(String username, String password){
        System.out.println("Parameter for Username is: "+username);
        System.out.println("Parameter for Password is: "+password);
    }
}
