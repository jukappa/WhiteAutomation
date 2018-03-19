import org.openqa.selenium.WebDriver;

public class AcTV {

    //verify TV service and equipment header
    public static void verifyTVServicesAndEquipmentHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[text() = 'TV Service & Equipment']","TV page - TV Service & Equipment Header");
    }

    //verify Equipment header
    public static void verifyEquipmentHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h2[contains(text(), 'Equipment')]","TV page - Equipment Header");
    }

    //verify refresh equipment modal not present
    public static void verifyRefreshEquipmentModalNotPresent(WebDriver driver) {
        String xpath = "//div[@id = 'cdk-overlay-4']";
        Common.verifyElementNotPresent(driver,xpath,5);

    }
    //verify STB reset modal
    public static void verifyRefreshingAllEquipmentModal(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//h3[text() = 'Refreshing All Equipment...']", "TV Troubleshooting - modem Reset modal");
    }

    //verify modem reset spinner
    public static void verifyRefreshingAllEquipmentSpinner(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//mat-progress-spinner", "TV Troubleshooting - Refresh progress spinner");
    }

    //verify successful refresh
    public static void verifySuccessfulRefreshModal(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//span[text() = 'All Equipment Has Been Refreshed']", "TV Troubleshooting - Refresh success modal");
    }

    //Waits until the modem reset modal is removed/completed
    public static void waitForModemResetCompletion(WebDriver driver) {

        for (int i = 0; i < 100; i++) {
            boolean modalPresent = Common.ElementVisible(driver, "//h3[text() = 'Refreshing All Equipment...']", 1);
            if (!modalPresent) {
                break;
            }
        }
    }

    //verify Unable to refresh modal
    public static void verifyUnableToRefreshModal(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//span[text() = 'Unable to Refresh Equipment']", "TV Troubleshooting - Unable to refresh modal");
        FindElement.waitForElementXpath(driver, "//span[text() = 'You recently refreshed your equipment. Please wait 15 minutes before refreshing again.']", "TV Troubleshooting - Unable to refresh text modal");

    }
}
