import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

public class PgAccountSummary {

    //click your services and equipment section TV button
    public static void clickServicesAndEquipmentTVButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//div[@class = 'service-name']//span[text() = 'TV']","TV button").click();
        ExtentManager.stepReport(Status.PASS,"TV button successfully clicked");
    }
    //click your services and equipment section Internet & WiFi button
    public static void clickServicesAndEquipmentInternetButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//div[@class = 'service-name']//span[text() = 'Internet & WiFi']","Internet & WiFi button").click();
        ExtentManager.stepReport(Status.PASS,"Internet & WiFi button successfully clicked");
    }

    //click your services and equipment section Voice button
    public static void clickServicesAndEquipmentVoiceButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//div[@class = 'service-name']//span[text() = 'Voice']","Voice button").click();
        ExtentManager.stepReport(Status.PASS,"Voice button successfully clicked");
    }

    //clicks the first add service button available for your services and equipment
    public static void clickFirstAddServiceButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"(//a[@class = 'service-icon']//div[@class = 'add-service'])[1]","First Add service button").click();
        ExtentManager.stepReport(Status.PASS,"First Add service button successfully clicked");
    }


}
