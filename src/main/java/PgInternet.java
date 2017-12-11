import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PgInternet {


    public static void clickEquipmentBasedOnRowNumber(WebDriver driver, String rowNum) {
        WebElement element = FindElement.waitForElementXpath(driver,"(//spectrum-dynamic-collapse-card/div)["+rowNum+"]","Internet page equipment");
        element.click();
        ExtentManager.stepReport(Status.INFO,"Internet Equipment on row "+rowNum+" clicked successfully");

    }

    public static void clickTroubleShootButton(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"(//button[text() = 'Troubleshoot'])[2]","Internet page Trouble shoot button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"Troubleshoot button clicked successfully");

    }

    public static void closeModemResetModalIfPresent(WebDriver driver) {
        String xpath = "//div[@class = 'modal-content']//button[@cc-track-click = '.closebtn']";

        boolean visible = Common.ElementVisible(driver,xpath,3);

        if (visible) {
            WebElement element = FindElement.waitForElementXpath(driver,xpath,"Modem reset modal x button");
            element.click();
            ExtentManager.stepReport(Status.INFO,"Modem reset modal closed successfully");
        }

    }
}
