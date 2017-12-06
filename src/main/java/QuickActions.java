
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class QuickActions {

    //Login method, Chrome seems to load slowly, adding a refresh helps load it a bit quicker
    public static void firstTimeLogin(WebDriver driver, String userName, String passWord, String browser) throws AWTException {
        PgLanding.enterUserName(driver, userName);
        PgLanding.enterPassword(driver, passWord);
        PgLanding.clickSignIn(driver);
        if (browser.toUpperCase().equals("CHROME")) {
            Common.sleep(4000);
            driver.navigate().refresh();
            PgLanding.enterUserName(driver, userName);
            PgLanding.enterPassword(driver, passWord);
            PgLanding.clickSignIn(driver);
            Common.sleep(1000);
            Robot rob = new Robot();
            rob.keyPress((KeyEvent.VK_ESCAPE));
            rob.keyRelease((KeyEvent.VK_ESCAPE));
            Common.sleep(1000);
            rob.keyPress((KeyEvent.VK_ESCAPE));
            rob.keyRelease((KeyEvent.VK_ESCAPE));
        } else if (browser.toUpperCase().equals("IE")) {
            Common.sleep(2000);
            PgLanding.clickSignIn(driver);
        }


    }

    //This method will ensure the verify account pop up is closed.  if pop up exists, mac is entered and continue clicked.
    //Otherwise it does nothing if it pop up does not appear
    public static void ensureCPNICompliant(WebDriver driver, String last4MacDigits) {

        String xpath = "//h2[text() = 'Verify Your Account']";
        String URL = driver.getCurrentUrl();
        if (URL.contains("cpni-roadblock")) {
            FindElement.waitForElementID(driver, "equipmentId", "Enter Mac Field").sendKeys(last4MacDigits);
            FindElement.waitForElementXpath(driver, "//button[@type = 'submit']", "verify Account Continue button").click();
        }
    }

    //Login method, Chrome seems to load slowly, adding a refresh helps load it a bit quicker
    public static void login(WebDriver driver, String userName, String passWord, String browser) throws AWTException {
        PgLanding.enterUserName(driver, userName);
        PgLanding.enterPassword(driver, passWord);
        PgLanding.clickSignIn(driver);
        if (browser.toUpperCase().equals("IE")) {
            Common.sleep(2000);
            PgLanding.clickSignIn(driver);
        }
    }

}
