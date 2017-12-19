import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PgMenu {


    public static void clickTopMenuButton(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"//*[contains(@class, 'hamburger')]","Top left nav menu button");
        element.click();
        //allow time for menu to expand fully
        Common.sleep(1000);
        ExtentManager.stepReport(Status.INFO,"menu button was clicked");

    }

    public static void clickCreateAUserNameButton(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"//a[text() ='Sign In']/following-sibling::a[text() = 'Create a Username']","Top left create username button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"menu create a username button was clicked");

    }

}
