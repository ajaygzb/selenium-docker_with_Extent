package helper;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
public class ExtentManager {
 
    private static ExtentReports extent;
    private static ExtentSparkReporter htmlReporter;
 
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                extent = new ExtentReports();
                htmlReporter = new ExtentSparkReporter(workingDir + "/test-output/ExtentReportResults.html");
                extent.attachReporter(htmlReporter);
                htmlReporter.config().setCSS("css-string");
                htmlReporter.config().setDocumentTitle("Automation Report ");
                htmlReporter.config().setEncoding("utf-8");
                htmlReporter.config().setJS("js-string");
                htmlReporter.config().setProtocol(Protocol.HTTPS);
                htmlReporter.config().setReportName("QA Build");
                htmlReporter.config().setTheme(Theme.DARK);
                htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
            }
			/*
			 * else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			 * extent = new ExtentReports(workingDir +
			 * "/test-output/ExtentReportResults.html", true); extent.loadConfig(new
			 * File(workingDir+"//resources//html-config.xml")); } else{ extent = new
			 * ExtentReports(workingDir + "/test-output/ExtentReportResults.html", true);
			 * extent.loadConfig(new File(workingDir+"//resources//html-config.xml")); }
			 */
        }
        return extent;
    }
}