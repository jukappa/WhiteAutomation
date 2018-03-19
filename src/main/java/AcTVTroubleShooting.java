import org.openqa.selenium.WebDriver;

public class AcTVTroubleShooting {

    //Class for https://www.engnew-spectrum.net/support/tv/tv-troubleshooting/

    //verify TV Troubleshooting title
    public static void verifyTVtroubleShootingTitle(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//h1[text() = 'TV Troubleshooting']", "TV troubleshooting page - TV Troubleshooting title");
    }
}

