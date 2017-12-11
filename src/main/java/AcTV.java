import org.openqa.selenium.WebDriver;

public class AcTV {

    //verify TV service and equipment header
    public static void verifyTVServicesAndEquipmentHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[text() = 'TV Service & Equipment']","TV page - TV Service & Equipment Header");
    }

    //verify Equipment header
    public static void verifyEquipmentHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h2[contains(text(), 'Equipment')]","TV page - Equipment Header");
    }
}
