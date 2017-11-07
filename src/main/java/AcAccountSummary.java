
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcAccountSummary {

    //Verify the Billing header in the billing section of account summary
    public static void verifyBillingHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h2[text() = 'Billing']","Billing Header");
    }

    //waits for the loading spinner to disappear before continuing next action
    public static void waitForNoBillLoadingSpinner(WebDriver driver) {

        (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'loading-overlay hidden']")));
    }

    //ensures the Whats new pop up is closed if it appears.
    //This method will do nothing if the pop up never appears
    public static void ensureWhatsNewPopUpClosed(WebDriver driver) {

        String xpathText = "See What's New on Spectrum.net";
        String modifiedText = "\""+xpathText+"\"";

        int elementPresence = driver.findElements(By.xpath("//*[text() = "+modifiedText+"]")).size();
        if (elementPresence> 0){
            PgOverview.clickDontShowThisAgainButton(driver);
            Common.sleep(1000);
        }
    }
}
