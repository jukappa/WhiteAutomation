import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

public class PgNavigation {



    //Clicks the top account summary navigation link
    public static void clickAccountSummaryLink(WebDriver driver) {
        String linkXpath = "//div[@class = 'app-header-local']//span[text() = 'Account Summary']";
        FindElement.waitForElementXpath(driver,linkXpath,"Top Account Summary navigation link").click();
        ExtentManager.stepReport(Status.PASS, "Top Account Summary navigation link clicked successfully");
    }

    //Clicks the top account summary navigation link
    public static void clickSpectrumHeader(WebDriver driver) {
        Common.sleep(1000);
        String linkXpath = "//span//img[@alt = 'Spectrum logo']";
        FindElement.waitForElementXpath(driver,linkXpath,"Top Spectrum header").click();
        ExtentManager.stepReport(Status.PASS, "Top Spectrum header link clicked successfully");
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
        String linkXpath = "//span//mat-icon[contains(@class ,'email-icon')]";
        FindElement.waitForElementXpath(driver,linkXpath,"mail icon link").click();
        ExtentManager.stepReport(Status.PASS, "mail icon link clicked successfully");
    }
    //Clicks the phone icon button
    public static void clickVoiceOnlineManagerLink(WebDriver driver) {
        String linkXpath = "//div[@class = 'app-header-utility']//*[contains(@class, 'phone-icon')]";
        FindElement.waitForElementXpath(driver,linkXpath,"phone icon link").click();
        ExtentManager.stepReport(Status.PASS, "phone icon link clicked successfully");
    }
    //Clicks Support link
    public static void clickSupportLink(WebDriver driver) {
        String linkXpath = "//span[contains(text() ,'Support')]";
        FindElement.waitForElementXpath(driver,linkXpath,"Support link").click();
        ExtentManager.stepReport(Status.PASS, "Support link clicked successfully");
    }

    //Clicks Sign out Link
    public static void clickSignOutLink(WebDriver driver) {
        String linkXpath = "//span[text() = 'Sign Out']";
        FindElement.waitForElementXpath(driver,linkXpath,"Support link").click();
        ExtentManager.stepReport(Status.PASS, "Sign out link clicked successfully");
    }

    //Clicks Search button icon
    public static void clickSearchButtonIcon(WebDriver driver) {
        String linkXpath = "//button//mat-icon[@aria-label= 'Search']";
        FindElement.waitForElementXpath(driver,linkXpath,"Search button icon").click();
        ExtentManager.stepReport(Status.PASS, "Search button icon clicked successfully");
    }

    //enter text into search field
    public static void enterTextSearchField(WebDriver driver, String text) {
        String linkXpath = "//div[@class = 'search-row']//input";
        FindElement.waitForElementXpath(driver,linkXpath,"Search button text field").sendKeys(text);
        ExtentManager.stepReport(Status.PASS, "Search button text field text entered successfully");
    }

    //Clicks Search button
    public static void clickSearchButton(WebDriver driver) {
        //wait added to avoid issue with clicking search too fast
        Common.sleep(1000);
        String linkXpath = "//button[@aria-label='View all results']";
        FindElement.waitForElementXpath(driver,linkXpath,"Search button").click();
        ExtentManager.stepReport(Status.PASS, "Search button successfully");
    }
}
