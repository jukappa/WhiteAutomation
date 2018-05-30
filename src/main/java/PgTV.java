import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PgTV {


//clicks the troubleshoot button in the Your Service section
    public static void clickTroubleShootButton(WebDriver driver) {

        //Wait till text is present before clicking trouble shoot button. (modal will not appear if clicked too soon)
        for (int i = 1; i < 15;i++) {
            Common.sleep(500);
            String troubleshootTextXpath = "//p[@class = 'connection-description ng-star-inserted']";
            String text = driver.findElement(By.xpath(troubleshootTextXpath)).getText();
            int count = text.length();
            if (count<5){
                Common.sleep(1000);
            } else{
                break;
            }
        }
        //Common.waitForElementVisibility(driver,troubleshootTextXpath,10);
        WebElement element = FindElement.waitForElementXpath(driver,"(//kite-button//button[text() = 'Troubleshoot'])[2]","TV page Trouble shoot button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"Troubleshoot button clicked successfully");

    }

    //refresh modal cancel button
    public static void clickResetModalCancelButton(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"//button[text() = 'Cancel']","TV page reset modal cancel button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"reset modal cancel button clicked successfully");

    }

    //refresh modal cancel button
    public static void clickResetModalRefreshButton(WebDriver driver) {
        Common.sleep(500);
        WebElement element = FindElement.waitForElementXpath(driver,"//button[text() = 'Reset All Equipment']","TV page reset modal Refresh all equipment button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"reset modal reset all equipment button clicked successfully");

    }

    //Click modal Continue button
    public static void clickModalContinueButton(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"(//button[text() = 'Continue'])[1]","TV page reset modal Continue button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"reset modal Continue button clicked successfully");

    }

    //Click modal Issue resolved button
    public static void clickModalIssueResolvedButton(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"(//button[text() = 'Issue Resolved'])[1]","TV page refresh modal Issue Resolved button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"reset modal Issue Resolved button clicked successfully");
    }
    //Click modal thumbnail close button
    public static void clickModalCloseButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//button[@aria-label = 'Close dialog']", "TV modal close button clicked" ).click();
        Common.sleep(1000);
    }

    //-----------------------------------------------------------------------------------------------------------------------\\
    //                                                                                                                       \\
    //EQUIPMENT CARD SECTION ACTIONS                                                                                         \\
    //                                                                                                                       \\
    //-----------------------------------------------------------------------------------------------------------------------\\

    //Click the equipment card arrow to expand or retract card.
    //cardNumber = the card you want to expand or minimize. (1 = top card, 2 = card below it)

    public static void clickEquipmentCardArrow(WebDriver driver, int cardNumber) {
        WebElement element = FindElement.waitForElementXpath(driver,"(//spectrum-dynamic-collapse-card//spectrum-icon[@fonticon = 'down-caret-fill-icon'])["+cardNumber+"]","TV page card arrow button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"TV equipment Card number "+cardNumber+" arrow clicked successfully");
    }

    //click magnifying glass icon
    public static void clickTVMaginfyingGlassIcon(WebDriver driver, int cardNumber) {
        FindElement.waitForElementXpath(driver, "(//spectrum-icon[@class = 'magnify-icon'])[" + cardNumber + "]", "device magnifying image").click();
    }

    //Click TV modal thumbnail images
    public static void clickThumbNailImages(WebDriver driver, int cardNumber) {
        FindElement.waitForElementXpath(driver, "(//div[@class = 'spectrum-modal-container']//spectrum-cms-fallback-img//img[contains(@src,'.png')])[" + cardNumber + "]//ancestor::button", "TV modal thumbnail image " + cardNumber +" clicked" ).click();
    }

    //Click TV device edit nickname
    public static void clickEditNickNameButton(WebDriver driver, int cardNumber) {
        FindElement.waitForElementXpath(driver, "(//button[contains(text(), 'Edit Nickname')])[" + cardNumber + "]", "TV card edit nickname card number " + cardNumber +" clicked" ).click();
    }

    //Click TV device edit nickname
    public static void enterNickName(WebDriver driver, int cardNumber, String nickName) {
        FindElement.waitForElementXpath(driver, "(//input[@name = 'nickname'])[" + cardNumber + "]", "Edit Nickname" ).clear();
        FindElement.waitForElementXpath(driver, "(//input[@name = 'nickname'])[" + cardNumber + "]", "Edit Nickname" ).sendKeys(nickName);
    }

    //Click nick name save button
    public static void clickNickNameSaveButton(WebDriver driver, int cardNumber) {
        FindElement.waitForElementXpath(driver, "(//button[text() = 'Save'])[" + cardNumber + "]", "Click save button" ).click();
    }

    //Click Tool tip
    public static void clickDeviceCardToolTip(WebDriver driver, int cardNumber) {
        FindElement.waitForElementXpath(driver, "(//spectrum-icon[@aria-label = 'Show Nickname Tooltip'])[" + cardNumber + "]", "Click device card tooltip" ).click();
    }

    //-----------------------------------------------------------------------------------------------------------------------\\
    //                                                                                                                       \\
    //Explore card actions                                                                                                   \\
    //                                                                                                                       \\
    //-----------------------------------------------------------------------------------------------------------------------\\

    //Click Upgrade Your Service Link
    public static void clickUpgradeYourServiceLink(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "(//kite-button//span[text() = 'Upgrade Your Service'])[1]", "Click Upgrade your service link" ).click();
    }

    //Click view channel Lineup
    public static void clickViewChannelLineupLink(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "(//kite-button//span[text() = 'View Channel Lineup'])[1]", "Click view channel Lineup link" ).click();
    }

    //Click Activate Equipment
    public static void clickActivateEquipmentLink(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "(//kite-button//span[text() = 'Activate Equipment'])[1]", "Click Activate Equipment link" ).click();
    }

    //Click Watch TV
    public static void clickWatchTVLink(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "(//kite-button//span[text() = 'Watch TV'])[1]", "Click Watch TV link" ).click();
    }
}
