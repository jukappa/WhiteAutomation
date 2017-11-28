import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PgLanding{


    public static void enterUserName(WebDriver driver, String userName) {
        WebElement element = FindElement.waitForElementID(driver,"cc-username","login user name");
        element.clear();
        element.sendKeys(userName);
        ExtentManager.stepReport(Status.INFO,"Login User name was entered");

    }

    public static void enterPassword(WebDriver driver, String passWord) {
        WebElement element = FindElement.waitForElementID(driver,"cc-user-password", "login password");
        element.clear();
        element.sendKeys(passWord);
        ExtentManager.stepReport(Status.INFO,"Login Password was entered");

    }
    public static void clickSignIn(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"//kite-button[@class = 'sign-in']//button","Login sign in button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"login sign in was clicked");
    }
    public static void clickCreateAUsernameButton(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"//h2[text() = 'Sign In to Get Started']//following-sibling::a[text()='Create a Username']","Create a username button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"create a username button");
    }

    public static void clickForgotUserNameOrPassword(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"//a[text() = 'Forgot Username or Password?']","forgot username or password button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"forgot username or password button");
    }
}
