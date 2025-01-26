package exercise2;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckPassFailTest {
    CheckPassFail check = new CheckPassFail();
    @Test
    @Parameters("mark1")
    public void testCheckPassFail1(int mark1) {
        System.out.println("Checking mark1: "+mark1);
        check.checkPassFail(mark1);
    }

    @Test
    @Parameters("mark2")
    public void testCheckPassFail2(int mark2) {
        System.out.println("Checking mark2: "+mark2);
        check.checkPassFail(mark2);
    }
}
