import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

public class AcTV {

    //verify TV service and equipment header
    public static void verifyTVServicesAndEquipmentHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//h1[text() = 'TV Service & Equipment']", "TV page - TV Service & Equipment Header");
    }

    //verify Equipment header
    public static void verifyEquipmentHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//h2[contains(text(), 'Equipment')]", "TV page - Equipment Header");
    }

    //verify refresh equipment modal not present
    public static void verifyRefreshEquipmentModalNotPresent(WebDriver driver) {
        String xpath = "//div[@id = 'cdk-overlay-4']";
        Common.verifyElementNotPresent(driver, xpath, 5);

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
            boolean modalPresent = Common.ElementVisible(driver, "//h3[text() = 'Resetting All Equipment...']", 1);
            if (!modalPresent) {
                break;
            }
        }
    }

    //verify Unable to refresh modal
    public static void verifyUnableToResetModal(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//span[text() = 'Unable to Reset Equipment']", "TV Troubleshooting - Unable to refresh modal");
        FindElement.waitForElementXpath(driver, "//span[text() = 'You recently reset your equipment. Please wait 15 minutes before resetting it again.']", "TV Troubleshooting - Unable to reset text modal");

    }

    //-----------------------------------------------------------------------------------------------------------------------\\
    //                                                                                                                       \\
    //EQUIPMENT CARD SECTION ASSERTIONS                                                                                      \\
    //                                                                                                                       \\
    //-----------------------------------------------------------------------------------------------------------------------\\

    //Waits until the modem reset modal is removed/completed
    public static void verifyEquipmentImage(WebDriver driver, int cardNumber) {

        int sizeY = FindElement.waitForElementXpath(driver, "(//div[contains(@class,'spectrum-card__thumbnail-container')]//img)[" + cardNumber + "]", "device image").getSize().getHeight();
        if (sizeY > 0 && sizeY < 150) {
            ExtentManager.stepReport(Status.PASS, "Equipment image from card "+cardNumber+" is present");
        } else{
            ExtentManager.stepReport(Status.FAIL, "Equipment image from card "+cardNumber+" is not present or broken image is displayed");
        }
    }

    //Verify the magnifying glass is present
    public static void verifyTVMaginfyingGlassIcon(WebDriver driver, int cardNumber) {
        FindElement.waitForElementXpath(driver, "(//spectrum-icon[@class = 'magnify-icon'])[" + cardNumber + "]", "device magnifying image");
    }

    //Verify full view modal image present
    public static void verifyFullViewImage(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//div[@class = 'letterbox']//img[contains(@src,'.png')]", "full view modal image");
    }

    //Verify TV modal thumbnail images
    public static void verifyThumbNailImages(WebDriver driver, int cardNumber) {
        FindElement.waitForElementXpath(driver, "(//div[@class = 'spectrum-modal-container']//spectrum-cms-fallback-img//img[contains(@src,'.png')])[" + cardNumber + "]", "TV modal thumbnail image " + cardNumber +"" );
    }

    //Verify open/closed device card nick name
    public static void verifyCardNickName(WebDriver driver, String expectedText) {
        FindElement.waitForElementXpath(driver, "//span//i[text() = '"+expectedText+"']", "TV device card nick name " + expectedText +"" );
    }

    //Verify tool tip text
    public static void verifyToolTipDisplayedText(WebDriver driver, int cardNumber) {
        String expectedText = "Displays message on TV connected to this equipment.";
       String text = FindElement.waitForElementXpath(driver, "(//spectrum-icon[@aria-label = 'Show Nickname Tooltip']//ancestor::div//div[@class = 'kite-tooltip-wrapper'])[" + cardNumber + "]", "TV device tooltip").getText();
       if (text.equals(expectedText)){
           ExtentManager.stepReport(Status.PASS, "Expected text of '"+expectedText+"' matches actual text of '"+text+"'");
       } else{
           ExtentManager.stepReport(Status.FAIL, "Expected text of '"+expectedText+"' does not match actual text of '"+text+"'");
       }
    }
    //verify device Manufacturer
    public static void verifyDeviceManufacturer(WebDriver driver, String expectedManufacturer, int cardNumber) {
        FindElement.waitForElementXpath(driver, "(//div[@class = 'network-information']//div[text() = 'Manufacturer']//following-sibling::span[text() = '"+expectedManufacturer+"'])["+cardNumber+"]", "Device Manufacturer name");
    }
    //verify device Model
    public static void verifyDeviceModel(WebDriver driver, String expectedModel, int cardNumber) {
        FindElement.waitForElementXpath(driver, "(//div[@class = 'network-information']//div[text() = 'Model']//following-sibling::span[text() = '"+expectedModel+"'])["+cardNumber+"]", "Device Model name");
    }

    //-----------------------------------------------------------------------------------------------------------------------\\
    //                                                                                                                       \\
    //Explore card assertions                                                                                                 \\
    //                                                                                                                       \\
    //-----------------------------------------------------------------------------------------------------------------------\\

    //Verify Upgrade your service link
    public static void verifyUpgradeYourServicePage(WebDriver driver) {
        String URL = driver.getCurrentUrl();
        Comparison.verifyStringMatch(".*buy.spectrum.com.*",URL);
    }

    //Verify Channel lineup page
    public static void verifyChannelLineupPage(WebDriver driver) {
        String URL = driver.getCurrentUrl();
        Comparison.verifyStringMatch(".*/tv/channel-lineup/",URL);
    }

    //verify Activate Equipment page
    public static void verifyActivateEquipmentPage(WebDriver driver) {
        String URL = driver.getCurrentUrl();
        Comparison.verifyStringMatch(".*activate.spectrum.net.*",URL);
    }

    //verify Watch TV page
    public static void verifyWatchTVPage(WebDriver driver) {
        String URL = driver.getCurrentUrl();
        Comparison.verifyStringMatch(".*watch.spectrum.net.*",URL);
    }
}
