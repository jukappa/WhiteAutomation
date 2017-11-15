import org.openqa.selenium.WebDriver;

public class AcForgotUsernamePassword {

    //verify get username or password title appears
    public static void verifyGetUsernameOrPassword(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//h1[@id = 'pageTitle'][contains(text(), 'Get Username or')]", "get username or password page - get username or password Header");
    }
}
