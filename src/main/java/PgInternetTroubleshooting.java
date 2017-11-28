import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PgInternetTroubleshooting {


    public static void clickResetModemButton(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"//button[text() = 'Reset Modem']","Internet Troubleshooting reset modem button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"Reset modem button clicked successfully");

    }

    public static void clickModalIssueResolvedButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//a[@class = 'btn primary-btn btn-lrg'][text() = 'Issue Resolved ']", "Internet Troubleshooting reset modem - Issue Resolved button").click();
        ExtentManager.stepReport(Status.INFO,"Issue Resolved button clicked successfully");
    }

}
