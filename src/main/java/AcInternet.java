import org.openqa.selenium.WebDriver;

public class AcInternet {

    //verify main services and equipment header title appears
    public static void verifyInternetServicesAndEquipmentHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[@id = 'pageTitle'][text() = 'Internet Services & Equipment']","Internet page - Internet Services & Equipment Header");
    }

    //verify devices header appears
    public static void verifyDevicesHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[@class = 'section-heading'][contains(text() , 'Devices')]","Internet page - Devices Header");
    }
}
