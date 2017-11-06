import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

public class PgNavigation {

    //Clicks the top account summary navigation link
    public static void clickAccountSummaryLink(WebDriver driver) {
        String linkXpath = "//div[@class = 'app-header-local']//span[text() = 'Account Summary']";
        FindElement.waitForElementXpath(driver,linkXpath,"Top Account Summary navigation link").click();
        ExtentManager.stepReport(Status.PASS, "Top Account Summary navigation link clicked successfully");
    }

    //Clicks the top Billing navigation link
    public static void clickBillingLink(WebDriver driver) {
        String linkXpath = "//div[@class = 'app-header-local']//span[text() = 'Billing']";
        FindElement.waitForElementXpath(driver,linkXpath,"Top Billing navigation link").click();
        ExtentManager.stepReport(Status.PASS, "Top Billing navigation link clicked successfully");
    }

    //Clicks the top TV navigation link
    public static void clickTVLink(WebDriver driver) {
        String linkXpath = "//div[@class = 'app-header-local']//span[text() = 'TV']";
        FindElement.waitForElementXpath(driver,linkXpath,"Top TV navigation link").click();
        ExtentManager.stepReport(Status.PASS, "Top TV navigation link clicked successfully");
    }

    //Clicks the top Internet navigation link
    public static void clickInternetLink(WebDriver driver) {
        String linkXpath = "//div[@class = 'app-header-local']//span[text() = 'Internet']";
        FindElement.waitForElementXpath(driver,linkXpath,"Top TV navigation link").click();
        ExtentManager.stepReport(Status.PASS, "Top Internet navigation link clicked successfully");
    }

    //Clicks the top Voice navigation link
    public static void clickVoiceLink(WebDriver driver) {
        String linkXpath = "//div[@class = 'app-header-local']//span[text() = 'Voice']";
        FindElement.waitForElementXpath(driver,linkXpath,"Top Voice navigation link").click();
        ExtentManager.stepReport(Status.PASS, "Top Voice navigation link clicked successfully");
    }

    //Clicks the top Settings navigation link
    public static void clickSettingsLink(WebDriver driver) {
        String linkXpath = "//div[@class = 'app-header-local']//span[text() = 'Settings']";
        FindElement.waitForElementXpath(driver,linkXpath,"Top Settings navigation link").click();
        ExtentManager.stepReport(Status.PASS, "Top Settings navigation link clicked successfully");
    }
    //Clicks the mail icon button
    public static void clickmailLink(WebDriver driver) {
        String linkXpath = "//span[@class = 'mat-button-wrapper']//md-icon[contains(@class ,'email-icon')]";
        FindElement.waitForElementXpath(driver,linkXpath,"mail icon link").click();
        ExtentManager.stepReport(Status.PASS, "mail icon link clicked successfully");
    }
    //Clicks the phone icon button
    public static void clickVoiceOnlineManagerLink(WebDriver driver) {
        String linkXpath = "//div[@class = 'app-header-utility']//md-icon[contains(@class, 'phone-icon')]";
        FindElement.waitForElementXpath(driver,linkXpath,"phone icon link").click();
        ExtentManager.stepReport(Status.PASS, "phone icon link clicked successfully");
    }
    //Clicks Support link
    public static void clickSupportLink(WebDriver driver) {
        String linkXpath = "//span[@class = 'mat-button-wrapper']//span[text() = 'Support']";
        FindElement.waitForElementXpath(driver,linkXpath,"Support link").click();
        ExtentManager.stepReport(Status.PASS, "Support link clicked successfully");
    }

    //Clicks Support link
    public static void clickUserNameLink(WebDriver driver, String userName) {
        String linkXpath = "//span[@class = 'mat-button-wrapper']//span[text() = '"+userName+"']";
        FindElement.waitForElementXpath(driver,linkXpath,"Support link").click();
        ExtentManager.stepReport(Status.PASS, "username link clicked successfully");
    }
}
