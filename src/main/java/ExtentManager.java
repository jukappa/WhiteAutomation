
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static ExtentHtmlReporter htmlReporter;
    private static String filePath = "./extentreport.html";


    public static ExtentReports GetExtent() {
        if (extent != null)
            return extent; //avoid creating new instance of html file
        extent = new ExtentReports();
        extent.attachReporter(getHtmlReporter());
        return extent;
    }

    private static ExtentHtmlReporter getHtmlReporter() {

        htmlReporter = new ExtentHtmlReporter(filePath);

        // make the charts visible on report open
        htmlReporter.config().setChartVisibilityOnOpen(true);

        htmlReporter.config().setDocumentTitle("QAV automation report");
        htmlReporter.config().setReportName("Regression cycle");
        return htmlReporter;
    }

    public static ExtentTest createTest(String name, String description) {
        test = extent.createTest(name, description);
        return test;

    }

    public static void stepReport(Status status, String description) {

        if (status.equals(Status.FAIL)) {
            int lineFailure = Common.getMethodRowNumberInTestClass();
            test.log(status, description + " - Failed on Test Line " + lineFailure);
        } else {
            test.log(status, description);
        }
    }
}
