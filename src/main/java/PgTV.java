import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PgTV {


//clicks the troubleshoot button in the Your Service section
    public static void clickTroubleShootButton(WebDriver driver) {

        //Wait till text is present before clicking trouble shoot button. (modal will not appear if clicked too soon)
        for (int i = 1; i < 15;i++) {
            Common.sleep(500);
            String troubleshootTextXpath = "//p[@class = 'connection-description ng-star-inserted']";
            String text = driver.findElement(By.xpath(troubleshootTextXpath)).getText();
            int count = text.length();
            if (count<5){
                Common.sleep(1000);
            } else{
                break;
            }
        }
        //Common.waitForElementVisibility(driver,troubleshootTextXpath,10);
        WebElement element = FindElement.waitForElementXpath(driver,"(//kite-button//button[text() = 'Troubleshoot'])[2]","TV page Trouble shoot button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"Troubleshoot button clicked successfully");

    }

    //refresh modal cancel button
    public static void clickRefreshModalCancelButton(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"//button[text() = 'Cancel']","TV page refresh modal cancel button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"refresh modal cancel button clicked successfully");

    }

    //refresh modal cancel button
    public static void clickRefreshModalRefreshButton(WebDriver driver) {
        Common.sleep(500);
        WebElement element = FindElement.waitForElementXpath(driver,"//button[text() = 'Refresh All Equipment']","TV page refresh modal Refresh all equipment button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"refresh modal refresh all equipment button clicked successfully");

    }

    //Click modal Continue button
    public static void clickModalContinueButton(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"(//button[text() = 'Continue'])[1]","TV page refresh modal Continue button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"refresh modal Continue button clicked successfully");

    }

    //Click modal Issue resolved button
    public static void clickModalIssueResolvedButton(WebDriver driver) {
        WebElement element = FindElement.waitForElementXpath(driver,"(//button[text() = 'Issue Resolved'])[1]","TV page refresh modal Issue Resolved button");
        element.click();
        ExtentManager.stepReport(Status.INFO,"refresh modal Issue Resolved button clicked successfully");
    }


}
