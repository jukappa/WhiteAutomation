
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class FindElement {



    public static WebElement waitForElementXpath (WebDriver driver,String xpath,String description){
        WebElement element;
        try {
            element = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            ExtentManager.stepReport(Status.PASS,description+ " successfully located");
            return element;
        }catch(Exception e){
            ExtentManager.stepReport(Status.FAIL,description+" was not located - Stack Trace - "+e);
            Assert.fail();
        }
        return null;
    }

    public static WebElement waitForElementID (WebDriver driver,String ID, String description){
        WebElement element;
        try {
            element = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id(ID)));
            ExtentManager.stepReport(Status.PASS,description+ " successfully located");
            return element;
        }catch(Exception e){
            ExtentManager.stepReport(Status.FAIL,description+" was not located - Stack Trace "+e);
            Assert.fail();
        }
        return null;
    }
}
