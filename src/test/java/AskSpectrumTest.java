import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class AskSpectrumTest extends BaseTest {

    //-----------------Scenarios-------------------------\\
    /*
    Verify Authenticated user can access IVA and Welcome message appears
    Verify Un-authenticated user can access IVA and Welcome message appears
    Verify when maximized, IVA has chat icon,header,sound button,resize button, close button, intro message, input field,send button
    Verify when reduced, IVA has chat icon,header,sound button,resize button,minimize button, close button, intro message, input field,send button
    Verify IVA can be maximized, reduced, minimized, closed
    Verify Sound icon changes on/off when clicked
    Verify user is able to drag and drop IVA
    Verify clicking send, message is sent
    Verify IVA can be scrolled
    Verify time out message appears when IVA times out
    Verify when clicking a link in IVA, Position of IVA will not move on new page load
    Verify IVA is not displayed on mobile
    Verify IVA is displayed on tablet
    Verify when confirming close of IVA, IVA will be minimized
    Verify when cancelling closing of IVA, close pop up will close and IVA will remain open

    Ask spectrum - Verification to Ensure successful IVA launch
    availability and functionality of resize CTA_IVA interface_Overlay window
    availability and functionality of resize CTA_IVA interface_Right tray window
    Availability to adjust_preset_settings_IVA interface_minimize button functionalityIVA window and Verification of IVA launch point widget
    Availabilitytoadjust_preset_settings_IVA interface_Verification_of_Sound_CTA and Ability_to_move_IVA interface window
    Desktop_Availability and display of IVA _Intelligent Virtual Assistant_ or Ask Spectrum_Desktop_1280 px or wider
    Functionality IVA interface_Do not close the window_After timeout_Timeout message in the first IVA Window
    Functionality IVA interface_Do not close the window_Timeout
    Functionality IVA interface_When any link is clicked_within IVA Interface window_Loading of IVA window
    IVA_Verification of feedback button_Desktop
    Mobile_Availability of IVA _Intelligent Virtual Assistant_ or Ask Spectrum
    Tablet_Availability of IVA _Intelligent Virtual Assistant_ or Ask Spectrum_Tablet
    Verification of functionality of close button in IVA and Display of close modal on IVA window _IVA window is Minimized or maximized
    Verification of secured transaction functionality of IVA _Intelligent Virtual Assistant_or Ask Spectrum_Desktop_Tablet
    */

    //Not included, descoped, or repeat scenarios//
    /*
    availability and functionality of Live chat_IVA interface (Descoped, No longer in "need help?")
    IVA_Verification of feedback button_Desktop(dont understand)
    Verification of secured transaction functionality of IVA _Intelligent Virtual Assistant_or Ask Spectrum_Desktop_Tablet(Dont understand)

     */


    @Test
    public void AskSpectrum() throws AWTException {

        String[] browsers = {"chrome"};

        //Account must have internet device
        String userName = "sstest01";
        String passWord = "Testing01";
        String last4Mac = "B52A";
        String zipCode = "59102";
        String https = "https://";
        String securityPreText = "charternet:Chart3rn3t@";
        String baseURL = "www.engnew-spectrum.net";
        String accountWithUpgradeLinks = "billpaytest01";
        for (String browser : browsers) {
            ExtentManager.createTest(browser + " login", "Smoke Test");
            WebDriver driver = PreTest.getBrowserDrivers(browser);
            driver.manage().window().maximize();
            driver.get(https + securityPreText + baseURL);
            driver.get(https + baseURL);

            //Ask Spectrum unauthenticated user
            ExtentManager.createTest("Ask spectrum should be available for unauthenticated users", "Smoke Test");
            try {
                PgAskSpectrum.clickAskSpectrumChatButton(driver);
                AcAskSpectrum.verifyAskSpectrumWelcomeMessage(driver);
                PgAskSpectrum.clickSpectrumXButton(driver);
                PgAskSpectrum.clickSpectrumCloseButton(driver);
            } catch (AssertionError a) {
                //failure reporting is performed in 'try' method above, this try catch block simply prevents test from stopping on fail.
            }
        }
    }
}

