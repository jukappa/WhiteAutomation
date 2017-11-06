import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

public class PgAskSpectrum {

    //click ask Spectrum chat button
    public static void clickAskSpectrumChatButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//button[@class = 'ask-spectrum-button']","Ask Spectrum chat button").click();
        ExtentManager.stepReport(Status.PASS,"Ask Spectrum button successfully clicked");
    }

    //click ask Spectrum X button
    public static void clickSpectrumXButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//button[@title = 'Close']","Ask Spectrum X button").click();
        ExtentManager.stepReport(Status.PASS,"Ask Spectrum X button successfully clicked");
    }

    //click ask Spectrum close button
    public static void clickSpectrumCloseButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//button[@id= 'submit-button']","Ask Spectrum close button").click();
        ExtentManager.stepReport(Status.PASS,"Ask Spectrum close button successfully clicked");
    }

}
