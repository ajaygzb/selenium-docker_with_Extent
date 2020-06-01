package helper;
import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
 
//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
public class ExtentManager {
 
    private static ExtentReports extent;
 
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                extent = new ExtentReports(workingDir + "\\test-output\\ExtentReportResults.html", true);
                extent.loadConfig(new File(workingDir+"//resources//html-config.xml"));
            }
            else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                extent = new ExtentReports(workingDir + "/test-output/ExtentReportResults.html", true);
                extent.loadConfig(new File(workingDir+"//resources//html-config.xml"));
            } else{
                extent = new ExtentReports(workingDir + "/test-output/ExtentReportResults.html", true);
                extent.loadConfig(new File(workingDir+"//resources//html-config.xml"));
            }
        }
        return extent;
    }
}