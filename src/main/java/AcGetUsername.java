import org.openqa.selenium.WebDriver;

public class AcGetUsername {

    //verify get username title appears
    public static void verifyGetUsernameTitle(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//h1[@id = 'pageTitle'][contains(text(), 'Get Username')]", "get username page - get username Header");
    }
}
