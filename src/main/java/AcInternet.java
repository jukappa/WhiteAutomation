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

    //verify Check email link appears
    public static void verifyCheckEmailLink(WebDriver driver) {
        FindElement.waitForElementID(driver,"my_internet_services_email_link","Internet page - Check Email link");
    }

    //verify Go to Security suite link
    public static void verifyGotoSecuritySuiteLink(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//a[@id = 'my_internet_services_email_link']//ancestor::ul//a[text() = 'Go to Security Suite']","Internet page - Go to Security Suite");
    }
}
