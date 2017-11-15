import org.openqa.selenium.WebDriver;

public class AcCreateUserName {

    //verify create username header
    public static void verifyCreateUsernameTitle(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h1[text() = 'Create Username']","Create Username header");
    }

}
