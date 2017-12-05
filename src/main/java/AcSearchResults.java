import org.openqa.selenium.WebDriver;

public class AcSearchResults {
    public static void verifySpectrumResultsHeader(WebDriver driver, boolean allowZeroResults) {

        String regex = "Spectrum.net \\([1-9][0-9]* results\\)";
        if (allowZeroResults) {
            regex = "Spectrum.net \\(\\d+ results\\)";
        }
        String titleXpath = "//li[@class = 'active'][contains(@ng-class ,'charter')]";
        String title = FindElement.waitForElementXpath(driver, titleXpath, "Spectrum.net title header tab").getText();

        for (int i = 0; i < 15; i++) {
            if (title.matches(".*(\\d+).*")) {
                Comparison.verifyStringMatch(regex, title);
                break;
            } else {
                Common.sleep(1000);
            }
        }
    }
}
