import com.aventstack.extentreports.Status;

public class Comparison {

    //method to verify two strings match
    //expectedString can be regex
    public static void verifyStringMatch(String expectedString, String actualString) {
        if (actualString.matches(expectedString)){
            ExtentManager.stepReport(Status.PASS,"expected string '"+expectedString+"' matches actual string '"+actualString);
        } else{
            ExtentManager.stepReport(Status.FAIL,"expected string '"+expectedString+"' does not match actual string '"+actualString);
        }
    }


}
