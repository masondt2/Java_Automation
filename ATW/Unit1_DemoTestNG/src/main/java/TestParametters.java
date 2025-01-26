import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParametters {
    @Parameters({"username","password"})
    @Test
    public void testCaseTwo(String username, String password) {
        System.out.println("Parameter username is: "+username);
        System.out.println("Parameter password is: "+password);
    }
}
