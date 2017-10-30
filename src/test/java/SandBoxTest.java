import Utils.Common;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;


public class SandBoxTest extends BaseTest{

    @Test
    public void test1() throws AWTException {

        String[] browsers = {"ie","Chrome"};
        for (String browser : browsers) {
            ExtentManager.createTest(browser +" login", "Verify Billing");
            WebDriver driver = PreTest.getBrowserDrivers(browser);
            //driver.get("HTTPS://pc.engnew-spectrum.net/");
            driver.manage().window().maximize();
            driver.get("HTTPS://charternet:Chart3rn3t@engprod-spectrum.net/");
            driver.get("HTTPS://engprod-spectrum.net/");
            PgLanding.enterUserName(driver, "sstest02");
            PgLanding.enterPassword(driver, "Testing01");
            PgLanding.clickSignIn(driver);
            if (browser.equals("Chrome")){
                Common.sleep(4000);
                driver.navigate().refresh();
                PgLanding.enterUserName(driver, "sstest02");
                PgLanding.enterPassword(driver, "Testing01");
                PgLanding.clickSignIn(driver);
            }
            AcOverview.waitForNoBillLoadingSpinner(driver);
            AcOverview.ensureWhatsNewPopUpClosed(driver);
            AcOverview.verifyBillingHeader(driver);

        }
    }

/*    @Test
    public void removingTrailingDecimal() {

        float number = 200;
        String stringNum = String.valueOf(number);

        String num = new Float(number).toString().replaceAll("\\.0", "");

        String newNum = num + "Kg";

        if (!stringNum.contains(".0")) {
            System.out.println(number);
        } else {
            String newNumber = stringNum.replace(".0", "");
            System.out.println(newNumber);
        }
        String formatted = NumberFormat.getInstance().format(number);
        System.out.println(formatted);

    }*/

}






















