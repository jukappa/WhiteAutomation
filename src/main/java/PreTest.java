import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public class PreTest {
    static ExtentTest test;

    public static WebDriver getBrowserDrivers(String browserNames) {

        String name = null;
        String path = null;
        WebDriver driver = null;
        switch (browserNames.toUpperCase()) {
            case "CHROME":
                name = "webdriver.chrome.driver";
                //Gets value in environment variables(uses directory path to specific driver)
                path = System.getenv("CHROME_DRIVER");
                System.setProperty("webdriver.chrome.driver","./src//lib//chromedriver");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
                capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
                System.setProperty(name, path);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                //options.addArguments("--start-maximized");
                options.addArguments("--disable-web-security");
                options.addArguments("--allow-running-insecure-content");
                capabilities.setCapability("chrome.binary",path);
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                return new ChromeDriver(capabilities);
            case "FIREFOX":
            case "FIRE FOX":
                name = "webdriver.gecko.driver";
                path = System.getenv("FIREFOX_DRIVER");
                System.setProperty(name, path);
                return new FirefoxDriver();
            case "IE":
            case "INTERNET EXPLORER":
                name = "webdriver.ie.driver";
                path = System.getenv("IE_DRIVER");
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability("ignoreZoomSetting", true);
                caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS,false);
                /*caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
                caps.acceptInsecureCerts();
                caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);*/
                //caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
                //caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");

                System.setProperty(name, path);
                //InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                //ieOptions.introduceFlakinessByIgnoringSecurityDomains();
                return new InternetExplorerDriver(caps);

            case "EDGE":
                name = "webdriver.edge.driver";
                path = System.getenv("EDGE_DRIVER");
                System.setProperty(name, path);
                return new EdgeDriver();

            default:
                System.out.println("Ensure entered browser is one of the following 'Chrome','Firefox','edge','IE'");

        }
        test.log(Status.PASS, browserNames + " driver set");

        return null;
    }
}
