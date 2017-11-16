import org.openqa.selenium.WebDriver;

public class AcGetUsernameAndPassword {

    //verify get username or password title appears
    public static void verifyGetUserAndPassTitle(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//h1[@id = 'pageTitle'][contains(text(), 'Get Username and')]", "get username and password - get username and password Header");
    }
}
