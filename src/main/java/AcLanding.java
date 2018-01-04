import org.openqa.selenium.WebDriver;

public class AcLanding {

    //Verify the Billing header title is on page
    public static void verifySignInToGetStartedSection(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//h2[text() = 'Sign In to Get Started']","verified Landing page title");
    }

}
