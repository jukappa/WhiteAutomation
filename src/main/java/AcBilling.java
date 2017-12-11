import org.openqa.selenium.WebDriver;

public class AcBilling {

    //Verify the Billing header title is on page
    public static void verifyBillingHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[text() = 'Billing']","Billing page - Billing Header");
    }

    //verify statements header appears
    public static void verifyViewBillingStatementHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//span[text() = 'View Billing Statement']","Billing page - View Billing Statement Header");
    }

    //Verify the Amount due title is on page
    public static void verifyAmountDueHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//span[text() = 'Amount Due']","Billing page - Amount due Header");
    }

    //Verify the make a payment title is on page
    public static void makeAPaymentHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//button/*[text() = 'Make a Payment']","Billing page - make a payment Header");
    }

    //Verify the Manage Scheduled Payments title is on page
    public static void manageScheduledPaymentsHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//button/*[text() = 'Manage Scheduled Payments']","Billing page - Manage Scheduled Payments Header");
    }
    //Verify the Manage autopay title is on page
    public static void manageAutopayHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//button/*[contains(text(),'Manage Auto')]","Billing page - Manage autopay Header");
    }
}
