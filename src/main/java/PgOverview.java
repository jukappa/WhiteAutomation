
import org.openqa.selenium.WebDriver;

public class PgOverview {

    public static void clickDontShowThisAgainButton(WebDriver driver) {
        FindElement.waitForElementXpath(driver,"//button[@class = 'kite-button link md']","Dont show this again button").click();
    }
}
