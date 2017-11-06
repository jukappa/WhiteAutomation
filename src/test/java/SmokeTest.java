import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class SmokeTest extends BaseTest {


    @Test
    public void smokeTest() throws AWTException {

        String[] browsers = {"ie"};
        String userName = "sstest02";
        String passWord = "Testing01";
        String last4Mac = "b52a";
        for (String browser : browsers) {
            ExtentManager.createTest(browser + " login", "Smoke Test");
            WebDriver driver = PreTest.getBrowserDrivers(browser);
            //driver.get("HTTPS://pc.engnew-spectrum.net/");
            driver.manage().window().maximize();
            driver.get("HTTPS://charternet:Chart3rn3t@www.engnew-spectrum.net");
            driver.get("https://www.engnew-spectrum.net");
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

            //Ask Spectrum
            //currently not working with selenium IE
            try {
                PgAskSpectrum.clickAskSpectrumChatButton(driver);
                AcAskSpectrum.verifyAskSpectrumWelcomeMessage(driver);
                PgAskSpectrum.clickSpectrumXButton(driver);
                PgAskSpectrum.clickSpectrumCloseButton(driver);
            } catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //mail
            try {
                PgNavigation.clickmailLink(driver);
                String mailURL = driver.getCurrentUrl();
                Comparison.verifyStringMatch("https://mail2.(engprod|engnew)-spectrum.net.*",mailURL);
                driver.navigate().back();
            }catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }
            //Voice online manager
            try {
                PgNavigation.clickVoiceOnlineManagerLink(driver);
                String voiceURL = driver.getCurrentUrl();
                Comparison.verifyStringMatch("https://(engprod|www.engnew)-spectrum.net/voice/",voiceURL);
                driver.navigate().back();
            }catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //Support
            try {
                PgNavigation.clickSupportLink(driver);
                String supportURL = driver.getCurrentUrl();
                Comparison.verifyStringMatch("http://(www.engnew|engprod)-spectrum.net/support/",supportURL);
                driver.navigate().back();
            }catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //Username
            try {
                PgNavigation.clickUserNameLink(driver,userName);
                AcSettings.verifySettingsHeader(driver);
                AcSettings.verifyContactInfoHeader(driver);
                driver.navigate().back();
            }catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }
        }
    }
}

