import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;

public class AskSpectrumTest extends BaseTest {

    //-----------------Scenarios-------------------------\\
    /* -Verify live chat window opens when clicked--(availability and functionality of Live chat_IVA interface)
    *  -Verify live chat window can be minimized--(availability and functionality of Live chat_IVA interface)
    *  Verify when live chat is maximized content is shifted to the left to be visible--(availability and functionality of resize CTA_IVA interface_Overlay window)
    *  Verify when live chat is size reduced page content is normal--(availability and functionality of resize CTA_IVA interface_Right tray window)
    *  Verify when in reduced state the following buttons are present- chat icon, header, sound, Maximize, close--(Availabilitytoadjust_preset_settings_IVA interface_minimize button functionalityIVA window and Verification of IVA launch point widget)
    *  Verify when in reduced state clicking close then reopening will bring chat back in reduced state--(Availabilitytoadjust_preset_settings_IVA interface_minimize button functionalityIVA window and Verification of IVA launch point widget)
    *  Verify when maximized clicking close then reopening will bring chat back in maximized state--(Availabilitytoadjust_preset_settings_IVA interface_minimize button functionalityIVA window and Verification of IVA launch point widget)
    *  Verify when clicking sound icon, it changes from on and Off--(Availabilitytoadjust_preset_settings_IVA interface_Verification_of_Sound_CTA and Ability_to_move_IVA interface window)
    *  Verify reduced chat window can be dragged and dropped--(Availabilitytoadjust_preset_settings_IVA interface_Verification_of_Sound_CTA and Ability_to_move_IVA interface window)
    *  Verify in maximized state the following - chat icon, header, sound button, resize button, close button, intro message, input form field, send button --(Desktop_Availability and display of IVA _Intelligent Virtual Assistant_ or Ask Spectrum_Desktop_1280 px or wider)
    *  Verify when chat is maximized, window is fixed--(Desktop_Availability and display of IVA _Intelligent Virtual Assistant_ or Ask Spectrum_Desktop_1280 px or wider)
    *  Verify when clicking send, entered text will appear in chat--(Desktop_Availability and display of IVA _Intelligent Virtual Assistant_ or Ask Spectrum_Desktop_1280 px or wider)
    *  Scroll bar should be present if chat history becomes too large--(Desktop_Availability and display of IVA _Intelligent Virtual Assistant_ or Ask Spectrum_Desktop_1280 px or wider)
    *  Open new tab with live chat.  Let original chat idle and verify history is cleared on timeout-- (Functionality IVA interface_Do not close the window_After timeout_Timeout message in the first IVA Window)
    *  Verify when clicking a link within chat, new window is opened and chat remains open on original page--(Functionality IVA interface_When any link is clicked_within IVA Interface window_Loading of IVA window)
    *  Verify when clicking close button, modal appears confirming request, with cancel and close buttons present--(Verification of functionality of close button in IVA and Display of close modal on IVA window _IVA window is Minimized or maximized)
    *  Verify clicking cancel, the chat stays present--(Verification of functionality of close button in IVA and Display of close modal on IVA window _IVA window is Minimized or maximized)
    *  Verify when clicking close, the chat minimizes--(Verification of functionality of close button in IVA and Display of close modal on IVA window _IVA window is Minimized or maximized)
    * */

    //Not included or repeat scenarios//
    /*Functionality IVA interface_Do not close the window_Timeout
    IVA_Verification of feedback button_Desktop
    Mobile_Availability of IVA _Intelligent Virtual Assistant_ or Ask Spectrum
    Tablet_Availability of IVA _Intelligent Virtual Assistant_ or Ask Spectrum_Tablet
    Verification of secured transaction functionality of IVA _Intelligent Virtual Assistant_or Ask Spectrum_Desktop_Tablet*/

    @Test
    public void AskSpectrum() throws AWTException {

        String[] browsers = {"Chrome"};
        String userName = "sstest02";
        String passWord = "Testing01";
        String last4Mac = "B52A";
        for (String browser : browsers) {
            ExtentManager.createTest(browser + " set up", "Ask Spectrum");
            WebDriver driver = PreTest.getBrowserDrivers(browser);
            //driver.get("HTTPS://pc.engnew-spectrum.net/");
            driver.manage().window().maximize();
            driver.get("HTTPS://charternet:Chart3rn3t@www.engnew-spectrum.net");
            driver.get("https://www.engnew-spectrum.net");
            QuickActions.login(driver, userName, passWord, browser);
            AcAccountSummary.waitForNoBillLoadingSpinner(driver);

            ExtentManager.createTest("Verify live chat window opens when clicked","ALM scenario 'availability and functionality of Live chat_IVA interface'");
            PgAskSpectrum.clickAskSpectrumChatButton(driver);
            AcAskSpectrum.verifyAskSpectrumWelcomeMessage(driver);

            ExtentManager.createTest("Verify live chat window can be minimized", "ALM Scenario 'Verify live chat window can be minimized'");
            PgAskSpectrum.clickSpectrumContractButton(driver);
            //ensures maximized chat is not still present before getting new coordinate
            Common.verifyElementNotVisible(driver,"//button[@id= 'alme-contract-button']",5);
            int preY = AcAskSpectrum.getAskSpectrumCoordinate(driver, "y");
            PgAskSpectrum.clickSpectrumMinimizeButton(driver);
            //ensures contracted chat is not still present before getting new coordinate
            Common.verifyElementNotVisible(driver,"//button[@id= 'alme-expand-button']",5);
            int postY = AcAskSpectrum.getAskSpectrumCoordinate(driver,"y");
            Comparison.verifyHigherIntValue(postY,preY);

            ExtentManager.createTest("Verify when live chat is maximized content is shifted to the left to be visible", "ALM Scenario 'availability and functionality of resize CTA_IVA interface_Overlay window'");
            int preMagnifyingX = AcAskSpectrum.getMagnifyingGlassCoordinate(driver,"X");

            driver.quit();
        }
    }
}

