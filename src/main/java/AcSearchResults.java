import org.openqa.selenium.WebDriver;

public class AcSearchResults {
    public static void verifySpectrumResultsHeader(WebDriver driver) {
        String titleXpath = "//li[@class = 'active'][contains(@ng-class ,'charter')]";
        String resultsXpath = "//li[@class = 'active'][contains(@ng-class ,'charter')]//small";
        String title = FindElement.waitForElementXpath(driver, titleXpath, "Spectrum.net title header tab").getText();
        String results = FindElement.waitForElementXpath(driver, resultsXpath, "Spectrum.net results header tab").getText();
        Comparison.verifyStringMatch("Spectrum.net \\(\\d+ results\\)", title+" "+results);

    }
}
