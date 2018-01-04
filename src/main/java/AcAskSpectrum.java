import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

public class AcAskSpectrum {
    public static void verifyAskSpectrumWelcomeMessage(WebDriver driver){
        String welcomeXpath = "//div[@class = 'user-message message ng-binding']";
        String message = FindElement.waitForElementXpath(driver,welcomeXpath,"Ask Spectrum Welcome message").getText();
        String expectedMessage = "Hi, how can I help you today? I can answer questions about your Spectrum products and services, or transfer you to an agent for more assistance.";

        if (message.equals(expectedMessage)){
            ExtentManager.stepReport(Status.PASS,"expected message matched actual message");
        }else{
            ExtentManager.stepReport(Status.FAIL,"Expected message '"+expectedMessage+"' did not match actual message of '"+message+"'.");
        }
    }

    //get ask Spectrum x/y coordinates
    public static int getAskSpectrumCoordinate(WebDriver driver, String desiredCoordinate) {
        if (desiredCoordinate.toUpperCase().matches("X")) {
            return FindElement.waitForElementID(driver, "alme-container-label", "Ask Spectrum chat box").getLocation().getX();
        }else{
            return FindElement.waitForElementID(driver, "alme-container-label", "Ask Spectrum chat box").getLocation().getY();
        }
    }

    //get magnifying glass x/y coordinates
    public static int getMagnifyingGlassCoordinate(WebDriver driver, String desiredCoordinate) {
        if (desiredCoordinate.toUpperCase().matches("X")) {
            return FindElement.waitForElementXpath(driver, "//button[@class = 'search icon-button large']//md-icon[contains(@class, 'search-icon')]", "Search magnifying glass icon").getLocation().getX();
        }else{
            return FindElement.waitForElementID(driver, "//button[@class = 'search icon-button large']//md-icon[contains(@class, 'search-icon')]", "Search magnifying glass icon").getLocation().getY();
        }
    }

    //verify chat bubble icon
    public static void verifyChatIcon(WebDriver driver) {
       FindElement.waitForElementXpath(driver,"//div[@id = 'almeDescribeHeader']//span[@class = 'alme__chat__bubble--bottom-outline']","IVA chat bubble icon");
    }

    //verify ask spectrum IVA header
    public static void verifyAskSpectrumHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//div[@id = 'almeDescribeHeader']//span[text() = 'Ask Spectrum']","IVA chat bubble icon");
    }

    //verify ask spectrum sound icon
    public static void verifySoundIcon(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//div[@id = 'alme-header']//button[@id = 'alme-sound-off']","Ask spectrum IVA sound icon");
    }

    //verify ask spectrum contract button
    public static void verifyContractButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//div[@id = 'alme-header']//button[@id = 'alme-contract-button']","Ask spectrum IVA contract button");
    }

    //verify ask spectrum close button
    public static void verifyCloseButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//div[@id = 'alme-header']//button[@id = 'alme-close-button']","Ask spectrum IVA close button");
    }

    //verify ask spectrum message field
    public static void verifyMessageField(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//input[@id = 'alme-input-field']","Ask spectrum IVA message field");
    }

    //verify ask spectrum send button
    public static void verifySendButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//input[@id = 'alme-input-button']","Ask spectrum IVA message field");
    }
}
