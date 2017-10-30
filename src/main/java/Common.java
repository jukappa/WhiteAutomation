package Utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Common {

    public static void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void verifyElementNotPresent(WebDriver driver, String xpath, int secondsToVerify) {

        int i = 0;
        boolean flag = FALSE;
        while (i < secondsToVerify * 4) {
            int element = driver.findElements(By.xpath(xpath)).size();
            if (element > 0) {
                Common.sleep(250);
            } else {
                i = secondsToVerify * 4;
                flag = TRUE;
            }

        }
        if (!flag) {
            Assert.fail("Element xpath " + xpath + " was still present after " + secondsToVerify + " seconds");
        }
    }

    public static boolean ElementPresent(WebDriver driver, String xpath, int secondsToVerify) {

        int i = 0;
        boolean flag = FALSE;
        while (i < secondsToVerify * 4) {
            int element = driver.findElements(By.xpath(xpath)).size();
            if (element > 0) {
                Common.sleep(250);
            } else {
                i = secondsToVerify * 4;
                flag = TRUE;
            }

        }
        return flag;
    }

    //returns the row number within the test class
    public static int getMethodRowNumberInTestClass() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        int i = 0;
        for (StackTraceElement stackElement : stack) {
            if (stackElement.toString().toUpperCase().contains("TEST")&& (!stackElement.toString().toUpperCase().contains("COMMON"))) {
                return Thread.currentThread().getStackTrace()[i].getLineNumber();
            } else {
                i++;
            }
        }
        return Integer.parseInt(null);
    }
}
