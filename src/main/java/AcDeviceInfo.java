import org.openqa.selenium.WebDriver;

public class AcDeviceInfo {

    //verify Device Info username header
    public static void verifyCreateUsernameTitle(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[text() = 'Device Info']","Device Info header");
    }

    //verify Specifications Header
    public static void verifySpecificationsTitle(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h3[@class = 'section-heading ng-scope']//div[text() = 'Specifications']","Specifications header");
    }

    //verify Support Header Presence
    public static void verifySupportTitle(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h3//div[text() = 'Support']","Support Title");
    }

    //verify Support Link
    public static void verifySupportLinkPresent(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h3//div[text() = 'Support']/ancestor::h3//following-sibling::div//a","Support Link");
    }

    //verify product specifications match expected
    public static void verifyProductSpecifications(WebDriver driver, String expectedManufacturer, String expectedModel ) {
        String actualManufacturer = FindElement.waitForElementXpath(driver,"//div[text() = 'Manufacturer']/following-sibling::span","Specifications Manufacturer Section").getText();
        String actualModel = FindElement.waitForElementXpath(driver,"//div[text() = 'Model']/following-sibling::span","Specifications Model Section").getText();

        Comparison.verifyStringMatch(expectedManufacturer,actualManufacturer);
        Comparison.verifyStringMatch(expectedModel,actualModel);
    }
    //verify device image present
    public static void verifyDeviceImagePresence(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//spectrum-gallery//div[contains(@class,'gallery-thumbnail-letterbox')]//img","Device Image");
    }


}
