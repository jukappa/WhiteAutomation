import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class SmokeTest extends BaseTest {


    @Test
    public void smokeTest() throws AWTException {

        String[] browsers = {"Chrome","IE"};
        String userName = "sstest02";
        String passWord = "Testing01";
        String last4Mac = "b52a";
        for (String browser : browsers) {
            ExtentManager.createTest(browser + " login", "Verify Billing");
            WebDriver driver = PreTest.getBrowserDrivers(browser);
            //driver.get("HTTPS://pc.engnew-spectrum.net/");
            driver.manage().window().maximize();
            driver.get("HTTPS://charternet:Chart3rn3t@engprod-spectrum.net/");
            driver.get("HTTPS://engprod-spectrum.net/");
            QuickActions.login(driver, userName, passWord, browser);
            AcAccountSummary.waitForNoBillLoadingSpinner(driver);

            //Account Summary
            try {
                AcAccountSummary.verifyBillingHeader(driver);
                AcAccountSummary.ensureWhatsNewPopUpClosed(driver);
            } catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //Billing
            try {
                PgNavigation.clickBillingLink(driver);
                AcBilling.verifyBillingHeader(driver);
                AcBilling.verifyStatementsHeader(driver);
            } catch (AssertionError|Exception e){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //TV
            try {
                PgNavigation.clickTVLink(driver);
                AcTV.verifyTVServicesAndEquipmentHeader(driver);
                AcTV.verifyToolsHeader(driver);
            } catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //Internet
            try {
                PgNavigation.clickInternetLink(driver);
                AcInternet.verifyInternetServicesAndEquipmentHeader(driver);
                AcInternet.verifyDevicesHeader(driver);
            } catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }
            //Voice
            try {
                PgNavigation.clickVoiceLink(driver);
                QuickActions.ensureVerifyAccountPopUpClosed(driver,last4Mac);
                AcVoice.verifyVoiceServicesAndEquipmentHeader(driver);
                AcVoice.verifyDevicesHeader(driver);
            } catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //Settings
            try {
                PgNavigation.clickSettingsLink(driver);
                AcSettings.verifySettingsHeader(driver);
                AcSettings.verifyContactInfoHeader(driver);
            } catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

        }
    }
}

