import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PgInternet {


    public static void clickDeviceBasedOnRowNumber(WebDriver driver, String rowNum) {
        WebElement element = FindElement.waitForElementXpath(driver,"//ul[contains(@class , 'device-list-detailed')]//span[text() = 'View Device Info']["+rowNum+"]","Internet page device");
        element.click();
        ExtentManager.stepReport(Status.INFO,"Internet Device on row "+rowNum+" clicked successfully");

    }

    public static void clickTroubleShootButton(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"//a[text() = 'Troubleshoot']","Internet page Trouble shoot button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"Troubleshoot button clicked successfully");

    }
}
