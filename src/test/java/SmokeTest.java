import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class SmokeTest extends BaseTest {

    //Scenarios
    /*-Ask spectrum should be available for both un/authenticated users
    * -Verify Ask Spectrum can be minimized, reduced, and maximized
    * -Verify create user name link on main page and left nav menu both go to create username page
    * -Verify clicking forgot username/pass navigates to forgot page.
    * -Verify clicking "get Password radio button" goes to get password page
    * -Verify clicking "get username radio button" goes to get username page
    * -Verify clicking "get username and password radio button" goes to get username and password page
    * -Verify Billing page loads as expected
    * -Verify Internet page loads as expected
    * -Verify clicking device on Internet page will display device info with image,specs,and support.
    * -Verify Internet page will contain status, message(based on connection), and troubleshoot button
    * -Verify Internet page has right section with Check Email, Go to Security Suite, with optionals of Access Cloud Drive and Manage Web Space
    * Verify Internet > Trouble shoot > click reset, displays loading modal and once completed shows Continue and Issue Resolved button
    * Verify when clicking "Issue Resolved" button user is navigated to Internet page
    * -Verify Account Summary page loads as expected
    * Verify Your services and Equipment section includes icons for TV, Internet and Voice
    * Verify TV,Internet, and voice options all go to corresponding page
    * -Verify Settings page loads as expected
    * -Verify TV page loads as expected
    * -Verify Billing page loads as expected
    * -Verify Voice page loads as expected
    * -Verify mail icon directs to correct page
    * -Verify phone icon directs to correct page
    * -Verify support link directs to correct page
    * -Verify username link directs to support page
    * -Verify User can sign in
    * -Verify Username link directs to correct page
    * Verify if TV, Internet or Voice service is not included, upgrade link is present and directs to upgrade flow
    * Verify when creating a new username email comes from a "spectrum.net" account
    * Verify Search works as expected
    * */

    @Test
    public void smokeTest() throws AWTException {

        String[] browsers = {"ie"};

        //Account must have internet device
        String userName = "sstest01";
        String passWord = "Testing01";
        String last4Mac = "B52A";
        for (String browser : browsers) {
            ExtentManager.createTest(browser + " login", "Smoke Test");
            WebDriver driver = PreTest.getBrowserDrivers(browser);
            //driver.get("HTTPS://pc.engnew-spectrum.net/");
            driver.manage().window().maximize();
            driver.get("HTTPS://charternet:Chart3rn3t@www.engnew-spectrum.net");
            driver.get("https://www.engnew-spectrum.net");

            //Ask Spectrum unauthenticated user
            ExtentManager.createTest("Ask spectrum should be available for unauthenticated users", "Smoke Test");
            try {
                PgAskSpectrum.clickAskSpectrumChatButton(driver);
                AcAskSpectrum.verifyAskSpectrumWelcomeMessage(driver);
                PgAskSpectrum.clickSpectrumXButton(driver);
                PgAskSpectrum.clickSpectrumCloseButton(driver);
            } catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //create user name links
            ExtentManager.createTest("Verify create user name link on main page and left nav menu both go to create username page", "Smoke Test");
            try {
                PgMenu.clickTopMenuButton(driver);
                PgMenu.clickCreateAUserNameButton(driver);
                AcCreateUserName.verifyCreateUsernameTitle(driver);
                driver.navigate().back();
                PgLanding.clickCreateAUsernameButton(driver);
                AcCreateUserName.verifyCreateUsernameTitle(driver);
                driver.navigate().back();
            }catch(AssertionError|Exception e){
                PgNavigation.clickSpectrumHeader(driver);
            }

            //Forgot username/password link
            try {

                ExtentManager.createTest("Verify clicking forgot username/pass navigates to forgot page", "Smoke Test");
                PgLanding.clickForgotUserNameOrPassword(driver);
                AcForgotUsernamePassword.verifyGetUsernameOrPassword(driver);

                ExtentManager.createTest("Verify clicking 'get username radio button' goes to get username page", "Smoke Test");
                PgForgotUsernamePassword.selectRadioButton(driver, "get username");
                PgForgotUsernamePassword.clickContinueButton(driver);
                AcGetUsername.verifyGetUsernameTitle(driver);
                driver.navigate().back();

                ExtentManager.createTest("Verify clicking \"get Password radio button\" goes to get password page", "Smoke Test");
                PgForgotUsernamePassword.selectRadioButton(driver, "get password");
                PgForgotUsernamePassword.clickContinueButton(driver);
                AcGetPassword.verifyGetPasswordTitle(driver);
                driver.navigate().back();

                ExtentManager.createTest("Verify clicking \"get username and password radio button\" goes to get username and password page", "Smoke Test");
                PgForgotUsernamePassword.selectRadioButton(driver, "get username and password");
                PgForgotUsernamePassword.clickContinueButton(driver);
                AcGetUsernameAndPassword.verifyGetUserAndPassTitle(driver);
                PgNavigation.clickSpectrumHeader(driver);

            }catch(AssertionError|Exception e){
                PgNavigation.clickSpectrumHeader(driver);
            }

            ExtentManager.createTest("Verify User can sign in", "Smoke Test");
            QuickActions.login(driver, userName, passWord, browser);
            AcAccountSummary.waitForNoBillLoadingSpinner(driver);
            AcAccountSummary.ensureWhatsNewPopUpClosed(driver);

            //Account Summary
            ExtentManager.createTest("Verify Account Summary page loads as expected", "Smoke Test");
            try {
                AcAccountSummary.verifyBillingHeader(driver);
                AcAccountSummary.ensureWhatsNewPopUpClosed(driver);
            } catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //Billing
            ExtentManager.createTest("Verify Billing page loads as expected", "Smoke Test");
            try {
                PgNavigation.clickBillingLink(driver);
                AcAccountSummary.ensureWhatsNewPopUpClosed(driver);
                AcBilling.verifyBillingHeader(driver);
                AcBilling.verifyStatementsHeader(driver);
            } catch (AssertionError|Exception e){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //TV
            ExtentManager.createTest("Verify TV page loads as expected", "Smoke Test");
            try {
                PgNavigation.clickTVLink(driver);
                AcTV.verifyTVServicesAndEquipmentHeader(driver);
                AcTV.verifyToolsHeader(driver);
            } catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //Internet
            ExtentManager.createTest("Verify Internet page loads as expected", "Smoke Test");
            try {
                PgNavigation.clickInternetLink(driver);
                AcInternet.verifyInternetServicesAndEquipmentHeader(driver);
                AcInternet.verifyDevicesHeader(driver);

                ExtentManager.createTest("Verify Internet page has right section with Check Email, Go to Security Suite, with optionals of Access Cloud Drive and Manage Web Space", "Smoke Test");
                AcInternet.verifyCheckEmailLink(driver);
                AcInternet.verifyGotoSecuritySuiteLink(driver);

                ExtentManager.createTest("Verify clicking device on Internet page will display device info with image,specs,and support.", "Smoke Test");
                PgInternet.clickDeviceBasedOnRowNumber(driver,"1");
                AcDeviceInfo.verifyDeviceImagePresence(driver);
                AcDeviceInfo.verifySpecificationsTitle(driver);
                AcDeviceInfo.verifyProductSpecifications(driver,".+",".+");
                AcDeviceInfo.verifySupportTitle(driver);
                AcDeviceInfo.verifySupportLinkPresent(driver);
                driver.navigate().back();

                ExtentManager.createTest("Verify Internet > Trouble shoot > click reset, displays loading modal and once completed shows Continue and Issue Resolved button", "Smoke Test");
                PgInternet.clickTroubleShootButton(driver);
                PgInternetTroubleshooting.clickResetModemButton(driver);
                AcInternetTroubleshooting.verifyModemResetModal(driver);
                AcInternetTroubleshooting.waitForModemResetCompletion(driver);
                AcInternetTroubleshooting.verifyContinueButtonPresent(driver);
                AcInternetTroubleshooting.verifyIssueResolvedButtonPresent(driver);
                PgNavigation.clickSpectrumHeader(driver);

            } catch (AssertionError|Exception e){
                PgNavigation.clickSpectrumHeader(driver);

            }
            //Voice
            ExtentManager.createTest("Verify Voice page loads as expected", "Smoke Test");
            try {
                PgNavigation.clickVoiceLink(driver);
                QuickActions.ensureVerifyAccountPopUpClosed(driver,last4Mac);
                AcVoice.verifyVoiceServicesAndEquipmentHeader(driver);
                AcVoice.verifyDevicesHeader(driver);
            } catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //Settings
            ExtentManager.createTest("Verify Settings page loads as expected", "Smoke Test");
            try {
                PgNavigation.clickSettingsLink(driver);
                AcSettings.verifySettingsHeader(driver);
                AcSettings.verifyContactInfoHeader(driver);
            } catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //Ask Spectrum
            ExtentManager.createTest("Verify Ask Spectrum can be minimized, reduced, and maximized</br>"+"Ask spectrum should be available for authenticated users", "Smoke Test");
            try {
                PgAskSpectrum.clickAskSpectrumChatButton(driver);
                AcAskSpectrum.verifyAskSpectrumWelcomeMessage(driver);

                //get ask spectrum Y coordinate while maximized
                int maximizedY = AcAskSpectrum.getAskSpectrumCoordinate(driver, "y");
                PgAskSpectrum.clickSpectrumContractButton(driver);

                //ensures maximized chat is not still present before getting new coordinate
                Common.verifyElementNotVisible(driver,"//button[@id= 'alme-contract-button']",5);
                //get ask spectrum Y coordinate while reduced for comparison
                int contractedY = AcAskSpectrum.getAskSpectrumCoordinate(driver, "y");

                //verify maximized Y value to reduced Y value, if reduced value is higher, then ask spectrum successfully went to contracted version and was originally at max version
                Comparison.verifyHigherIntValue(contractedY,maximizedY);
                PgAskSpectrum.clickSpectrumMinimizeButton(driver);

                //ensures reduced chat is not still present before getting new coordinate
                Common.verifyElementNotVisible(driver,"//button[@id= 'alme-expand-button']",5);
                //get ask spectrum Y coordinate while minimized for comparison
                int minimizedY = AcAskSpectrum.getAskSpectrumCoordinate(driver,"y");
                //verify contracted Y value to minimized Y value, if minimized value is higher, then ask spectrum successfully minimized
                Comparison.verifyHigherIntValue(minimizedY,contractedY);


            } catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //mail
            ExtentManager.createTest("Verify mail icon directs to correct page", "Smoke Test");
            try {
                PgNavigation.clickmailLink(driver);
                String mailURL = driver.getCurrentUrl();
                Comparison.verifyStringMatch("https://mail2.(engprod|engnew)-spectrum.net.*",mailURL);
                driver.navigate().back();
            }catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //Voice online manager
            ExtentManager.createTest("Verify phone icon directs to correct page", "Smoke Test");
            try {
                PgNavigation.clickVoiceOnlineManagerLink(driver);
                String voiceURL = driver.getCurrentUrl();
                Comparison.verifyStringMatch("https://(engprod|www.engnew)-spectrum.net/voice/",voiceURL);
                driver.navigate().back();
            }catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //Support
            ExtentManager.createTest("Verify support link directs to correct page", "Smoke Test");
            try {
                PgNavigation.clickSupportLink(driver);
                String supportURL = driver.getCurrentUrl();
                Comparison.verifyStringMatch("http://(www.engnew|engprod)-spectrum.net/support/",supportURL);
                driver.navigate().back();
            }catch (AssertionError a){
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }

            //Username
            ExtentManager.createTest("Verify Username link directs to correct page", "Smoke Test");
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

