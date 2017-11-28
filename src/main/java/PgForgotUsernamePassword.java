import org.openqa.selenium.WebDriver;

public class PgForgotUsernamePassword {

    //select specific radio button
    public static void selectRadioButton(WebDriver driver, String buttonName) {
        String xpath = null;
        switch (buttonName.toUpperCase()) {
            case "GET USERNAME":
                xpath = "//input[@value = 'username']/following-sibling::span";
                break;
            case "GET PASSWORD":
                xpath = "//input[@value = 'password']/following-sibling::span";
                break;
            case "GET USERNAME AND PASSWORD":
                xpath = "//input[@value = 'usernameAndPassword']/following-sibling::span";
                break;
        }
        FindElement.waitForElementXpath(driver, xpath, buttonName + " radio button").click();
    }

    //click continue button
    public static void clickContinueButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver, "//button[@type= 'submit'][text() = 'Continue']", "Continue button").click();
    }

    //click continue button
    public static void byPassZipCodeConfirmation(WebDriver driver, String zipCode) {

        driver.navigate().refresh();
        String URL = driver.getCurrentUrl();
        if (URL.matches("https://www.(engprod|engnew)-spectrum.net/unauthenticated-routing.*")){
            String zipFieldID = "zipcode";
            FindElement.waitForElementID(driver,zipFieldID,"Service zip code field").sendKeys(zipCode);
            PgForgotUsernamePassword.clickContinueButton(driver);
        }

    }
}
