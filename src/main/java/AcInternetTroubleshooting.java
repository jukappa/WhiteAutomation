import org.openqa.selenium.WebDriver;

public class AcInternetTroubleshooting {

    //verify modem reset modal
    public static void verifyModemResetModal(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//h2[text() = 'Modem Reset']", "Internet Troubleshooting - modem Reset modal");
    }

    //Waits until the modem reset modal is removed/completed
    public static void waitForModemResetCompletion(WebDriver driver) {

        for (int i = 0; i < 100; i++) {
            boolean modalPresent = Common.ElementVisible(driver, "//h2[text() = 'Modem Reset']", 1);
            if (!modalPresent) {
                break;
            }
        }
    }

    //Verify continue button is present
    public static void verifyContinueButtonPresent(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//div[contains(@class, 'visible')]//a[text() = 'Continue ']", "Internet Troubleshooting - Continue button");
    }

    //Verify issue resolved button is present

    public static void verifyIssueResolvedButtonPresent(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//div[contains(@class, 'visible')]//a[text() = 'Issue Resolved ']", "Internet Troubleshooting - Continue button");
    }

}
