import org.openqa.selenium.WebDriver;

public class AcInternet {

    //verify main services and equipment header title appears
    public static void verifyInternetServicesAndEquipmentHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[text() = 'Internet Service & Equipment']","Internet page - Internet Services & Equipment Header");
    }

    //verify Equipment header appears
    public static void verifyDevicesHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h2[contains(text(), 'Equipment')]","Internet page - Equipment Header");
    }

    //verify Check email link appears
    public static void verifyCheckEmailLink(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"(//button//span[contains(text(), 'Check Email')])[1]","Internet page - Check Email link");
    }

    //verify Go to Security suite link
    public static void verifyGotoSecuritySuiteLink(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"(//button[text() = 'Go to Security Suite\n" +
                "                    '])[1]","Internet page - Go to Security Suite");
    }

    //verify internet status header
    public static void verifyInternetStatusHeader(WebDriver driver, String connectionStatus) {
        String status = FindElement.waitForElementXpath(driver,"//span[contains(text(), 'Internet Status:')]//following-sibling::span[@id = 'signal-status-text']","Internet page - Internet Status connection").getText();
        Comparison.verifyStringMatch(connectionStatus,status.replace(" ",""));
    }

    //verify trouble shoot button
    public static void verifyTroubleShootButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"(//kite-button//button[text() = 'Troubleshoot'])[2]","Internet page - Trouble shoot button");
    }
}
