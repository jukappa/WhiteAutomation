import org.openqa.selenium.WebDriver;

public class AcVoice {

    //verify voice service and equipment header
    public static void verifyVoiceServiceAndEquipmentHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[text() = 'Voice Service & Equipment']","Voice page - Voice Service & Equipment Header");
    }

    //verify Equipment header
    public static void verifyEquipmentHeader(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h2[contains(text() ,'Equipment')]","Voice page - Equipment Header");
    }
}
