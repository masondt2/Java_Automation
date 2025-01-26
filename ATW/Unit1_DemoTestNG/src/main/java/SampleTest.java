import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class SampleTest {
    @Test
    public void test1(){
        System.out.println("This is tes1 test and it will be Pass");
    }

    @Test
    public void test2(){
        System.out.println("This is tes2 test and it will be Fail");
    }

    @Test
    public void test3(){
        throw new SkipException("Skipping the test3 test method.");
    }

    private int i=1;
    @Test
    public void test4(){
        System.out.println("test 4 test method, invocation count is: " + i);
        if (i==1 || i==2)
        {
            System.out.println("test4 failed!");
            Assert.assertEquals(i,8);
        }
    }
}
