import org.openqa.selenium.WebDriver;

public class AcTV {

    //verify TV services and equipment header
    public static void verifyTVServicesAndEquipmentHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[text() = 'TV Services & Equipment']","TV page - TV Services & Equipment Header");
    }

    //verify tools header
    public static void verifyToolsHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//section//h1[text() = 'Tools']","Billing page - Statements Header");
    }
}
