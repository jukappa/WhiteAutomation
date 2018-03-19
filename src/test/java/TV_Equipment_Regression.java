import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class TV_Equipment_Regression extends BaseTest {

    //Scenarios
    /*-
    * SPECNET-3805 CHTR Troubleshoot Worldbox_One Worldbox - Instructions to reset
    * SPECNET-3822 CHTR Troubleshoot Worldbox and Digiital STB - Trouble shoot redirects to http://www.spectrum.net/support/TV/reboot-your-spectrum-receiver/
    * SPECNET-397 CHTR Troubleshoot Digital STBs_ADMIN User - Refreshing all equipment
    * SPECNET-397 CHTR Troubleshoot Digital STBs_Cancel Refresh - user returned to TV page
    * SPECNET-397 CHTR Troubleshoot Digital STBs_Greater Than One Digital STBs - Refreshing all equipment
    * SPECNET-397 CHTR Troubleshoot Digital STBs_HOH User - Refreshing all equipment
    * SPECNET-397 CHTR Troubleshoot Digital STBs_Refresh Complete_Continue - re-directed to http://www.spectrum.net/support/tv/tv-troubleshooting page.
    * SPECNET-397 CHTR Troubleshoot Digital STBs_Refresh Complete_Issue Resolved - modal closed and remain on TV page
    * SPECNET-397 CHTR Troubleshoot Digital STBs_STD User - Refreshing all equipment
    * SPECNET-3997 Verify spinners within the reset modal on the TV service page
    * SPECNET-3997 Verify that equipment can be reset again after 15 min on TV service page
    * SPECNET-3997 Verify that equipment cannot be reset until in less than 15 min in TV service page
    *
    * SPECNET-2318 Ensure banner section is displayed when TV service is not available
    * SPECNET-284 Display of Unknown Equipment (TV)
    * SPECNET-319 Ensure all details are display from the STB on TV service page
    * SPECNET-3697 Verify that power cycle instructions window buttons are not getting show on TV service page
    * SPECNET-3698 Verify an image is shown under Equipment for the modem and router on TV service tab
    * Specnet-3801 Adding Magnify image to font file (TV)
    * SPECNET-4248 Verify Activate Equipment link on TV service page
    * SPECNET-4248 Verify Upgrade Your Service link on TV service page
    * SPECNET-4248 Verify View Channel Lineup link on TV service page
    * SPECNET-4248 Verify Watch TV link on TV service page
    * SPECNET-4336 Ensure the ability to view TV equipment related videos within TV service tab
    * Specnet-4484 Verify magnifying glass and device thumbnail are present
    * SPECNET-5805 Verify Display Footer Banner (TV)
    * SPECNET-5984 Edit nickname of the Digital STB or Worldbox on TV service page
    * SPECNET-5985 show nickname display a previously nickname being set
    * SPECNET-6380 Tooltip is displayed when expanding the device card on the TV service page
    * SPECNET-7614 Validate Equipment list title should be changed to Equipment on TV service page
    * SPECNET-7959 Validate Device display all the details under Equipment section from TV service tab
    * SPECNET-9047 Unable to Display Nickename Modal_Message Sent to TV
    * SPECNET-9047 Unable to Display Nickname Modal
    * */

    //Scenario not automated
    /*/

    */

    //Scenarios descoped
    /*

    */


    @Test
    public void yourServiceCard() throws AWTException {
        //Scenarios
    /*
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_Cancel Refresh - user returned to TV page
    * SPECNET-3805 CHTR Troubleshoot Worldbox_One Worldbox - Instructions to reset
    * SPECNET-3822 CHTR Troubleshoot Worldbox and Digiital STB - Trouble shoot redirects to http://www.spectrum.net/support/TV/reboot-your-spectrum-receiver/
    * SPECNET-397 CHTR Troubleshoot Digital STBs_ADMIN User - Refreshing all equipment
    * SPECNET-397 CHTR Troubleshoot Digital STBs_Greater Than One Digital STBs - Refreshing all equipment
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_HOH User - Refreshing all equipment
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_Refresh Complete_Continue - re-directed to http://www.spectrum.net/support/tv/tv-troubleshooting page.
    * SPECNET-397 CHTR Troubleshoot Digital STBs_Refresh Complete_Issue Resolved - modal closed and remain on TV page
    * SPECNET-397 CHTR Troubleshoot Digital STBs_STD User - Refreshing all equipment
    * -SPECNET-397 Verify spinners within the reset modal on the TV service page
    * -SPECNET-3997 Verify that equipment can be reset again after 15 min on TV service page
    * SPECNET-3997 Verify that equipment cannot be reset until in less than 15 min in TV service page*/


        String[] browsers = {"chrome"};

        //Account must have internet device
        String twoSTBAccount = "sstest01";
        String accountWithUpgradeLinks = "billpaytest05";
        String passWord = "Testing01";
        String passWord1 = "Testing02";
        String last4Mac = "B52A";
        String zipCode = "59102";
        String https = "https://";
        String environment = "ENGNEW";
        String securityPreText = "charternet:Chart3rn3t@";
        String baseURL = "www.engnew-spectrum.net";

        for (String browser : browsers) {
            ExtentManager.createTest(browser + " login", "Smoke Test");
            WebDriver driver = PreTest.getBrowserDrivers(browser);
            //driver.get("HTTPS://pc.engnew-spectrum.net/");
            driver.manage().window().maximize();
            driver.get(https + securityPreText + baseURL);
            driver.get(https + baseURL);

            ExtentManager.createTest("Verify User can sign in", "Smoke Test");
            QuickActions.firstTimeLogin(driver, twoSTBAccount, passWord, browser, environment);
            AcAccountSummary.waitForNoBillLoadingSpinner(driver);
            AcAccountSummary.ensureWhatsNewPopUpClosed(driver);

            //Tv page cancel refresh
            ExtentManager.createTest("SPECNET-397 CHTR Troubleshoot Digital STBs_Cancel Refresh - user returned to TV page", "yourServiceCard");
            try {
                PgNavigation.clickTVLink(driver);
                PgTV.clickTroubleShootButton(driver);
                PgTV.clickRefreshModalCancelButton(driver);
                AcTV.verifyRefreshEquipmentModalNotPresent(driver);
                AcTV.verifyTVServicesAndEquipmentHeader(driver);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }

            //Tv page refreshing all equipment
            ExtentManager.createTest("SPECNET-397 CHTR Troubleshoot Digital STBs_HOH User - Refreshing all equipment<br>" +
                    "SPECNET-397 Verify spinners within the reset modal on the TV service page", "yourServiceCard");
            try {
                PgTV.clickTroubleShootButton(driver);
                PgTV.clickRefreshModalRefreshButton(driver);
                AcTV.verifyRefreshingAllEquipmentModal(driver);
                AcTV.verifyRefreshingAllEquipmentSpinner(driver);
                AcTV.waitForModemResetCompletion(driver);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }


            //TV page refreshing
            ExtentManager.createTest("SPECNET-397 CHTR Troubleshoot Digital STBs_Refresh Complete_Continue - re-directed to http://www.spectrum.net/support/tv/tv-troubleshooting page.", "yourServiceCard");

            try {
                PgTV.clickModalContinueButton(driver);
                AcTVTroubleShooting.verifyTVtroubleShootingTitle(driver);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));

            }
            //TV page no additional refresh for 15 mins
            ExtentManager.createTest("SPECNET-3997 Verify that equipment can be reset again after 15 min on TV service page", "yourServiceCard");
            try {
                driver.navigate().to("https://www.engnew-spectrum.net/my-tv-services/");
                PgTV.clickTroubleShootButton(driver);
                PgTV.clickRefreshModalRefreshButton(driver);
                AcTV.verifyUnableToRefreshModal(driver);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }
        }
    }
}

