import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class TV_Equipment_RegressionTest extends BaseTest {

    //Scenarios
    /*-
    * -SPECNET-3805 CHTR Troubleshoot Worldbox_One Worldbox - Instructions to reset
    * -SPECNET-3822 CHTR Troubleshoot Worldbox and Digiital STB - Trouble shoot redirects to http://www.spectrum.net/support/TV/reboot-your-spectrum-receiver/
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_ADMIN User - Refreshing all equipment
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_Cancel Refresh - user returned to TV page
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_Greater Than One Digital STBs - Refreshing all equipment
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_HOH User - Refreshing all equipment
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_Refresh Complete_Continue - re-directed to http://www.spectrum.net/support/tv/tv-troubleshooting page.
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_Refresh Complete_Issue Resolved - modal closed and remain on TV page
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_STD User - Refreshing all equipment
    * -SPECNET-3997 Verify spinners within the reset modal on the TV service page
    * -SPECNET-3997 Verify that equipment can be reset again after 15 min on TV service page
    * -SPECNET-3997 Verify that equipment cannot be reset until in less than 15 min in TV service page

    * -SPECNET-319 Ensure all details are display from the STB on TV service page
    * -SPECNET-3698 Verify an image is shown under Equipment for the modem and router on TV service tab
    * -Specnet-3801 Adding Magnify image to font file (TV)
    * -Specnet-4484 Verify magnifying glass and device thumbnail are present
    * -SPECNET-5984 Edit nickname of the Digital STB or Worldbox on TV service page
    * -SPECNET-5985 show nickname display a previously nickname being set
    * -SPECNET-6380 Tooltip is displayed when expanding the device card on the TV service page
    * -SPECNET-7614 Validate Equipment list title should be changed to Equipment on TV service page
    * -SPECNET-7959 Validate Device display all the details under Equipment section from TV service tab

    *
    * -SPECNET-4248 Verify Activate Equipment link on TV service page
    * -SPECNET-4248 Verify Upgrade Your Service link on TV service page
    * -SPECNET-4248 Verify View Channel Lineup link on TV service page
    * -SPECNET-4248 Verify Watch TV link on TV service page
    *
    * SPECNET-2318 Ensure banner section is displayed when TV service is not available
    * SPECNET-4336 Ensure the ability to view TV equipment related videos within TV service tab
    * SPECNET-5805 Verify Display Footer Banner (TV)
    *
    * */

    //Scenario not automated
    /*/
    * SPECNET-9047 Unable to Display Nickename Modal_Message Sent to TV
    * SPECNET-9047 Unable to Display Nickname Modal
    * SPECNET-3697 Verify that power cycle instructions window buttons are not getting show on TV service page
    * SPECNET-284 Display of Unknown Equipment (TV)
    */

    //Scenarios descoped
    /*

    */


    @Test
    public void yourServiceCard() throws AWTException {
        //Scenarios
    /*
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_Cancel Refresh - user returned to TV page
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_ADMIN User - Refreshing all equipment
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_Greater Than One Digital STBs - Refreshing all equipment
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_HOH User - Refreshing all equipment
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_Refresh Complete_Continue - re-directed to http://www.spectrum.net/support/tv/tv-troubleshooting page.
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_Refresh Complete_Issue Resolved - modal closed and remain on TV page
    * -SPECNET-397 CHTR Troubleshoot Digital STBs_STD User - Refreshing all equipment
    * -SPECNET-3997 Verify spinners within the reset modal on the TV service page
    * -SPECNET-3997 Verify that equipment can be reset again after 15 min on TV service page
    * -SPECNET-3997 Verify that equipment cannot be reset until in less than 15 min in TV service page*/

        //Scenarios unable to currently automate
    /*SPECNET-3805 CHTR Troubleshoot Worldbox_One Worldbox - Instructions to reset
    * SPECNET-3822 CHTR Troubleshoot Worldbox and Digiital STB - Trouble shoot redirects to http://www.spectrum.net/support/TV/reboot-your-spectrum-receiver/
    */


        String[] browsers = {"chrome"};

        //Account must have internet device
        String twoSTBAccount = "sstest01";
        String adminTVAccount = "sstest02-04";
        String standardUser = "sstest03_std001";
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
                PgTV.clickResetModalCancelButton(driver);
                AcTV.verifyRefreshEquipmentModalNotPresent(driver);
                AcTV.verifyTVServicesAndEquipmentHeader(driver);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }

            //Tv page refreshing all equipment
            ExtentManager.createTest("SPECNET-397 CHTR Troubleshoot Digital STBs_HOH User - Refreshing all equipment<br>" +
                    "SPECNET-397 Verify spinners within the reset modal on the TV service page<br>" +
                    "SPECNET-397 CHTR Troubleshoot Digital STBs_Greater Than One Digital STBs - Refreshing all equipment", "yourServiceCard");
            try {
                PgTV.clickTroubleShootButton(driver);
                PgTV.clickResetModalRefreshButton(driver);
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
            ExtentManager.createTest("SPECNET-3997 Verify that equipment cannot be reset again in less than 15 min in TV service page", "yourServiceCard");
            try {
                driver.navigate().to("https://www.engnew-spectrum.net/my-tv-services/");
                PgTV.clickTroubleShootButton(driver);
                PgTV.clickResetModalRefreshButton(driver);
                AcTV.verifyUnableToResetModal(driver);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }

            //TV page no additional refresh for 15 mins
            ExtentManager.createTest("SPECNET-3997 Verify that equipment can be reset again after 15 min on TV service page", "yourServiceCard");
            try {
                driver.navigate().to("https://www.engnew-spectrum.net/my-tv-services/");
                Common.sleep(900000);
                PgTV.clickTroubleShootButton(driver);
                PgTV.clickResetModalRefreshButton(driver);
                AcTV.waitForModemResetCompletion(driver);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }
            //clicking issue resolved button and remain on TV page
            ExtentManager.createTest("SPECNET-397 CHTR Troubleshoot Digital STBs_Refresh Complete_Issue Resolved - modal closed and remain on TV page", "yourServiceCard");
            try {
                PgTV.clickModalIssueResolvedButton(driver);
                AcTV.verifyTVServicesAndEquipmentHeader(driver);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }
            //Verify refresh works with standard user
            ExtentManager.createTest("SPECNET-397 CHTR Troubleshoot Digital STBs_STD User - Refreshing all equipment", "yourServiceCard");
            try {
                PgNavigation.clickSignOutLink(driver);
                QuickActions.login(driver, standardUser, passWord1, "Chrome");
                PgNavigation.clickTVLink(driver);
                PgTV.clickTroubleShootButton(driver);
                PgTV.clickResetModalRefreshButton(driver);
                AcTV.waitForModemResetCompletion(driver);
                PgTV.clickModalIssueResolvedButton(driver);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }

            //Verify refresh works with admin user
            ExtentManager.createTest("SPECNET-397 CHTR Troubleshoot Digital STBs_ADMIN User - Refreshing all equipment", "yourServiceCard");
            try {
                PgNavigation.clickSignOutLink(driver);
                QuickActions.login(driver, adminTVAccount, passWord, "Chrome");
                PgNavigation.clickTVLink(driver);
                PgTV.clickTroubleShootButton(driver);
                PgTV.clickResetModalRefreshButton(driver);
                AcTV.waitForModemResetCompletion(driver);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }

        }
    }

    @Test
    public void equipmentCard() throws AWTException {
        //Scenarios
        /*

        -SPECNET-3698 Verify an image is shown under Equipment for the modem on TV service tab
        -Specnet-3801 Adding Magnify image to font file (TV)
        -Specnet-4484 Verify magnifying glass and device thumbnail are present
        -SPECNET-5984 Edit nickname of the Digital STB or Worldbox on TV service page
        -SPECNET-5985 show nickname display a previously nickname being set
        -SPECNET-6380 Tooltip is displayed when expanding the device card on the TV service page
        -SPECNET-7614 Validate Equipment list title should be changed to Equipment on TV service page
        -SPECNET-7959 Validate Device display all the details under Equipment section from TV service tab
        -SPECNET-319 Ensure all details are display from the STB on TV service page
        */

        String[] browsers = {"chrome"};

        //Account must have internet device
        String twoSTBAccount = "sstest01";
        String accountWithUpgradeLinks = "billpaytest05";
        String passWord = "Testing01";
        String passWord1 = "Testing02";
        String last4Mac = "B52A";
        String zipCode = "59102";
        String https = "https://";
        String environment = "ENGPROD";
        String securityPreText = "charternet:Chart3rn3t@";
        String baseURL = "www.engprod-spectrum.net";

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

            //Verify an image is shown under Equipment
            ExtentManager.createTest("SPECNET-3698 Verify an image is shown under Equipment", "SPECNET-3698 Verify an image is shown under Equipment for the modem and router on TV service tab");
            try {
                PgNavigation.clickTVLink(driver);
                AcTV.verifyEquipmentImage(driver, 1);
                PgTV.clickEquipmentCardArrow(driver, 1);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }

            ExtentManager.createTest("magnifying glass icon and modal", "Specnet-4484 Verify magnifying glass and device thumbnail are present" +
                    "Specnet-3801 Adding Magnify image to font file (TV)");
            try {
                AcTV.verifyTVMaginfyingGlassIcon(driver, 1);
                PgTV.clickTVMaginfyingGlassIcon(driver, 1);
                AcTV.verifyThumbNailImages(driver, 1);
                AcTV.verifyThumbNailImages(driver, 2);
                PgTV.clickThumbNailImages(driver, 1);
                AcTV.verifyFullViewImage(driver);
                PgTV.clickThumbNailImages(driver, 2);
                AcTV.verifyFullViewImage(driver);
                PgTV.clickModalCloseButton(driver);

            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }

            //Verify nick name is displayed and editable
            ExtentManager.createTest("TV nick name", "SPECNET-5984 Edit nickname of the Digital STB or Worldbox on TV service page" +
                    "SPECNET-5985 show nickname display a previously nickname being set");
            try {
                String randomString = Common.generateRandomString(10);
                PgTV.clickEditNickNameButton(driver, 1);
                PgTV.enterNickName(driver, 1, randomString);
                PgTV.clickNickNameSaveButton(driver, 1);
                AcTV.verifyCardNickName(driver, randomString);
                PgTV.clickEquipmentCardArrow(driver, 1);
                AcTV.verifyCardNickName(driver, randomString);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }

            //Verify nick name is displayed and editable
            ExtentManager.createTest("TV card tool tip", "SPECNET-6380 Tooltip is displayed when expanding the device card on the TV service page");
            try {
                PgTV.clickDeviceCardToolTip(driver, 1);
                AcTV.verifyToolTipDisplayedText(driver, 1);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }

            //Verify equipment title
            ExtentManager.createTest("TV equipment title", "SPECNET-7614 Validate Equipment list title should be changed to Equipment on TV service page");
            try {
                AcTV.verifyEquipmentHeader(driver);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }


            //Verify equipment make and model
            ExtentManager.createTest("TV equipment make and model", "SPECNET-7959 Validate Device display all the details under Equipment section from TV service tab" +
                    "SPECNET-319 Ensure all details are display from the STB on TV service page");
            try {
                AcTV.verifyDeviceManufacturer(driver, "Motorola", 1);
                AcTV.verifyDeviceModel(driver, "DCT2000", 1);
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }
        }
    }

    @Test
    public void exploreSection() throws AWTException {
        //Scenarios
        /*
    * SPECNET-4248 Verify Activate Equipment link on TV service page
    * SPECNET-4248 Verify Upgrade Your Service link on TV service page
    * SPECNET-4248 Verify View Channel Lineup link on TV service page
    * SPECNET-4248 Verify Watch TV link on TV service page
        */

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

            //Verify Upgrade your service link
            ExtentManager.createTest("Upgrade your service page", "SPECNET-4248 Verify Upgrade Your Service link on TV service page");
            try {
                PgNavigation.clickTVLink(driver);
                PgTV.clickUpgradeYourServiceLink(driver);
                QuickActions.loginPageLogin(driver,twoSTBAccount,passWord);
                Common.sleep(3000);
                AcTV.verifyUpgradeYourServicePage(driver);
                driver.get(https+baseURL+"/my-tv-services/");
            } catch (AssertionError | Exception e) {
                driver.get(https+baseURL+"/my-tv-services/");
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }

            //Verify view channel line up link
            ExtentManager.createTest("View Channel line up link", "SPECNET-4248 Verify Upgrade Your Service link on TV service page");
            try {
                PgTV.clickViewChannelLineupLink(driver);
                AcTV.verifyChannelLineupPage(driver);
                driver.navigate().back();
            } catch (AssertionError | Exception e) {
                driver.get(https+baseURL+"/my-tv-services/");
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }

            //Verify view channel line up link
            ExtentManager.createTest("Activate equipment link", "SPECNET-4248 Verify View Channel Lineup link on TV service page");
            try {
                PgTV.clickActivateEquipmentLink(driver);
                AcTV.verifyActivateEquipmentPage(driver);
                driver.navigate().back();
            } catch (AssertionError | Exception e) {
                driver.get(https+baseURL+"/my-tv-services/");
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }

            //Verify Watch TV link
            ExtentManager.createTest("Watch TV link", "SPECNET-4248 Verify Watch TV link on TV service page");
            try {
                PgTV.clickWatchTVLink(driver);
                AcTV.verifyWatchTVPage(driver);
                driver.navigate().back();
            } catch (AssertionError | Exception e) {
                ExtentManager.stepReport(Status.FAIL, String.valueOf(e));
            }

        }
    }
}

