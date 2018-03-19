import org.openqa.selenium.WebDriver;

public class AcSettings {

    //verify main settings title appears
    public static void verifySettingsHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[@id = 'pageTitle'][text() = 'Settings']","Settings page - Settings Header");
    }

    //verify contact info header
    public static void verifyContactInfoHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//cc-section[@id = 'contact-info']//div[text() = 'Contact Info']","Settings page - Contact Info Header");
    }

}
