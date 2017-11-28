import com.aventstack.extentreports.Status;

public class Comparison {

    //method to verify two strings match
    //expectedString can be regex
    public static void verifyStringMatch(String expectedString, String actualString) {
        if (actualString.matches(expectedString)){
            ExtentManager.stepReport(Status.PASS,"expected string '"+expectedString+"' matches actual string '"+actualString+"'");
        } else{
            ExtentManager.stepReport(Status.FAIL,"expected string '"+expectedString+"' does not match actual string '"+actualString+"'");
        }
    }

    //method to verify two strings match
    //expectedString can be regex
    public static void verifyHigherIntValue(int higherIntValue, int lowerIntValue) {
        if (higherIntValue > lowerIntValue){
            ExtentManager.stepReport(Status.PASS,"expected higher int value of '"+higherIntValue+"' is greater than expected lower value of '"+lowerIntValue+"'");
        } else{
            ExtentManager.stepReport(Status.FAIL,"expected higher int value of '"+higherIntValue+"' is not greater than expected lower value of '"+lowerIntValue+"'");
        }
    }


}
