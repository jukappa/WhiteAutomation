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
}
