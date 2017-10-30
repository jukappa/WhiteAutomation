import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PreTest {
    static ExtentTest test;
    public static WebDriver getBrowserDrivers(String browserNames) {
        String[] browser = {browserNames};
        for (String browserCycle : browser) {
            String name = null;
            String path = null;
            WebDriver driver = null;
            switch (browserCycle.toUpperCase()) {
                case "CHROME":
                    name = "webdriver.chrome.driver";
                    //Gets value in environment variables(uses directory path to specific driver)
                    path = System.getenv("CHROME_DRIVER");
                    System.setProperty(name, path);
                    return new ChromeDriver();
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
                    System.setProperty(name, path);
                    return new InternetExplorerDriver(caps);

                case "EDGE":
                    name = "webdriver.edge.driver";
                    path = System.getenv("EDGE_DRIVER");
                    System.setProperty(name, path);
                    return new EdgeDriver();

                default:
                    System.out.println("Ensure entered browser is one of the following 'Chrome','Firefox','edge','IE'");

            }
            test.log(Status.PASS, browserCycle +" driver set");
        }
        return null;
    }

}
