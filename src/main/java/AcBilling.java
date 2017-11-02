import org.openqa.selenium.WebDriver;

public class AcBilling {

    //Verify the Billing header title is on page
    public static void verifyBillingHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[text() = 'Billing']","Billing page - Billing Header");
    }

    //verify statements header appears
    public static void verifyStatementsHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h2//div[text() = 'Statements']","Billing page - Statements Header");
    }
}
