import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Common {

    //method to wait for x amount of milliseconds
    public static void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //returns random alphanumeric string of desired length



    public static String generateRandomString(int length) {
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }

        return builder.toString();
    }

    //wait until and element is visible for x amount of seconds before continuing
    public static void waitForElementVisibility(WebDriver driver, String xpath, int secondsToVerify) {

        for (int i = 1; i < secondsToVerify;i++){

            int elementVisible = driver.findElements(By.xpath(xpath)).size();
            if (elementVisible < 1){
                Common.sleep(1000);
            }else{
                break;
            }
        }
    }

    //verify an element is not present, will wait x amount of seconds for element to not be present before failing
    public static void verifyElementNotPresent(WebDriver driver, String xpath, int secondsToVerify) {

        int i = 0;
        boolean flag = FALSE;
        while (i < secondsToVerify * 4) {
            int element = driver.findElements(By.xpath(xpath)).size();
            if (element > 0) {
                Common.sleep(250);
                i++;
            } else {
                i = secondsToVerify * 4;
                flag = TRUE;
            }

        }
        if (!flag) {
            Assert.fail("Element xpath " + xpath + " was still present after " + secondsToVerify + " seconds");
        }
    }

    //verify an element is not visible, will wait x amount of seconds for element to not be present before failing
    public static void verifyElementNotVisible(WebDriver driver, String xpath, int secondsToVerify) {

        int i = 0;
        boolean flag = FALSE;
        while (i < secondsToVerify * 4) {
            boolean element = driver.findElement(By.xpath(xpath)).isDisplayed();
            if (element) {
                Common.sleep(250);
                i++;
            } else {
                i = secondsToVerify * 4;
                flag = TRUE;
            }

        }
        if (!flag) {
            Assert.fail("Element xpath " + xpath + " was still present after " + secondsToVerify + " seconds");
        }
    }

    //return boolean if element is present, will not fail regardless
    //boolean = TRUE - Element is present on page
    //boolean = FALSE - Element is not present on page
    public static boolean ElementPresent(WebDriver driver, String xpath, int secondsToVerify) {

        int i = 0;
        boolean flag = FALSE;
        while (i < secondsToVerify * 4) {
            int element = driver.findElements(By.xpath(xpath)).size();
            if (element > 0) {
                Common.sleep(250);
                i++;
            } else {
                i = secondsToVerify * 4;
                flag = TRUE;
            }

        }
        return flag;
    }

    public static boolean ElementVisible(WebDriver driver, String xpath, int secondsToVerify) {

        int i = 0;
        boolean flag = false;
        try {
            while (i < secondsToVerify * 4) {
                boolean element = driver.findElement(By.xpath(xpath)).isDisplayed();
                if (element) {
                    Common.sleep(250);
                    flag = TRUE;
                    i++;
                } else{
                    Common.sleep(250);
                    i++;
                }

            }
        } catch (Exception e) {
            flag = FALSE;

        }
        return flag;
    }

    //returns the row number within the test class where this method is used
    //(useful for troubleshooting.)
    public static int getMethodRowNumberInTestClass() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        int i = 0;
        for (StackTraceElement stackElement : stack) {
            if (stackElement.toString().toUpperCase().contains("TEST") && (!stackElement.toString().toUpperCase().contains("COMMON"))) {
                return Thread.currentThread().getStackTrace()[i].getLineNumber();
            } else {
                i++;
            }
        }
        return Integer.parseInt(null);
    }
}
