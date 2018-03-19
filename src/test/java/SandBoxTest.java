import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;


public class SandBoxTest extends BaseTest {

    @Test
    public void test1() throws AWTException {

        String[] browsers = {"ie", "Chrome"};
        for (String browser : browsers) {
            ExtentManager.createTest(browser + " login", "Verify Billing");
            WebDriver driver = PreTest.getBrowserDrivers(browser);
            //driver.get("HTTPS://pc.engnew-spectrum.net/");
            driver.manage().window().maximize();
            driver.get("HTTPS://charternet:Chart3rn3t@engprod-spectrum.net/");
            driver.get("HTTPS://engprod-spectrum.net/");
            PgLanding.enterUserName(driver, "sstest02");
            PgLanding.enterPassword(driver, "Testing01");
            PgLanding.clickSignIn(driver);
            if (browser.equals("Chrome")) {
                Common.sleep(4000);
                driver.navigate().refresh();
                PgLanding.enterUserName(driver, "sstest02");
                PgLanding.enterPassword(driver, "Testing01");
                PgLanding.clickSignIn(driver);
            }
            AcAccountSummary.waitForNoBillLoadingSpinner(driver);
            AcAccountSummary.ensureWhatsNewPopUpClosed(driver);
            AcAccountSummary.verifyBillingHeader(driver);
            driver.quit();
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

    @Test
    public void test2() throws AWTException {

        String[] browsers = {"firefox"};
        for (String browser : browsers) {
            ExtentManager.createTest(browser + " login", "Verify Billing");
            WebDriver driver = PreTest.getBrowserDrivers(browser);
            //driver.get("HTTPS://pc.engnew-spectrum.net/");
            driver.manage().window().maximize();
            driver.get("http://www.gmail.com");
            //driver.quit();
        }
    }

    @Test
    public void test3() throws AWTException, IOException {


        String[] browsers = {"Chrome"};
        for (String browser : browsers) {
            ExtentManager.createTest(browser + " login", "Verify Billing");
            WebDriver driver = PreTest.getBrowserDrivers(browser);
            URL url = new URL("https://www.engnew-spectrum.net/");
            driver.get("https://charternet:Chart3rn3t@www.engnew-spectrum.net");
            driver.manage().window().maximize();
            ExtentManager.createTest("Verify User can sign in", "Smoke Test");
            PgLanding.enterUserName(driver, "sstest01");
            PgLanding.enterPassword(driver, "Testing01");
            PgLanding.clickSignIn(driver);
            //Common.sleep(10000);
            /*QuickActions.firstTimeLogin(driver, "sstest01", "Testing01", browser);
            AcAccountSummary.waitForNoBillLoadingSpinner(driver);*/
            //AcAccountSummary.ensureWhatsNewPopUpClosed(driver);
            HttpURLConnection huc = (HttpURLConnection)url.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            CookieHandler.setDefault(new CookieManager());
            System.out.println(huc.getResponseCode());
        }
    }

}