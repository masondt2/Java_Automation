import org.testng.annotations.*;

public class TestNGAnnotations {
    //@BeforeSuite()
    @Test
    public void setupSuite(){
        System.out.println("@BeforeSuite started.");
    }

    //@BeforeTest
    @Test
    public void setupTests(){
        System.out.println("@BeforeTest started.");
    }

    //@BeforeClass
    @Test
    public void setupClass(){
        System.out.println("@BeforeClass started.");
    }

    //@BeforeMethod
    public void setupMethod(){
        System.out.println("@BeforeMethod has started.");
    }

    //@Test
    public void test(){
        System.out.println("@Test test.");
    }

    //@AfterMethod
    public void teardownTest(){
        System.out.println("@AfterMethod has started.");
    }

    //@AfterClass
    public void teardownClass(){
        System.out.println("@AfterClass has started.");
    }

    //@AfterTest
    public void teardownTests(){
        System.out.println("@AfterTest has started.");
    }

    //@AfterSuite
    public void teardownSuite(){
        System.out.println("@AfterSuite has started.");
    }
}
