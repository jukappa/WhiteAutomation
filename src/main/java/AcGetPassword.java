import org.openqa.selenium.WebDriver;

public class AcGetPassword {

    //verify get password title appears
    public static void verifyGetPasswordTitle(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//h1[@id = 'pageTitle'][contains(text(), 'Get Password')]", "get password page - get password Header");
    }
}
