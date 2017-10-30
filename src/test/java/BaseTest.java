import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setUp(){
        extent = ExtentManager.GetExtent();
    }

    @AfterTest
    public void tearDown(){
        extent.flush();

    }
}
