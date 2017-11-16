import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PgInternetTroubleshooting {


    public static void clickResetModemButton(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"//button[text() = 'Reset Modem']","Internet Troubleshooting reset modem button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"Reset modem button clicked successfully");

    }

}
