import org.openqa.selenium.WebDriver;

public class AcVoice {

    //verify voice services and equipment header
    public static void verifyVoiceServicesAndEquipmentHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[@id = 'pageTitle'][text() = 'Voice Services & Equipment']","Voice page - Voice Services & Equipment Header");
    }

    //verify devices header
    public static void verifyDevicesHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[@class = 'section-heading'][contains(text() , 'Devices')]","Voice page - Devices Header");
    }
}
