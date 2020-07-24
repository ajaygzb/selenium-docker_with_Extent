/*
 * package Listeners;
 * 
 * import java.io.File; import java.util.List; import java.util.Map;
 * 
 * import org.testng.IReporter; import org.testng.IResultMap; import
 * org.testng.ISuite; import org.testng.ISuiteResult; import
 * org.testng.ITestContext; import org.testng.ITestResult; import
 * org.testng.xml.XmlSuite;
 * 
 * import com.aventstack.extentreports.ExtentReports; import
 * com.aventstack.extentreports.ExtentTest;
 * 
 * public class ExtentReporterNG implements IReporter { private ExtentReports
 * extent; private ExtentTest test;
 * 
 * @Override public void generateReport(List<XmlSuite> xmlSuites, List<ISuite>
 * suites, String outputDirectory) { extent = new ExtentReports(); //
 * extent.lhttp://marketplace.eclipse.org/marketplace-client-intro?mpc_install=
 * 3644319oadConfig(new File(System.getProperty("user.dir")+ File.separator +
 * "resources"+File.separator+"html-config.xml")); //
 * System.out.println("loaded extent config");
 * 
 * 
 * for (ISuite suite : suites) { Map<String, ISuiteResult> result =
 * suite.getResults();
 * 
 * for (ISuiteResult r : result.values()) { ITestContext context =
 * r.getTestContext();
 * 
 * buildTestNodes(context.getPassedTests(), LogStatus.PASS);
 * buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
 * buildTestNodes(context.getSkippedTests(), LogStatus.SKIP); } }
 * 
 * extent.flush(); extent.close(); }
 * 
 * private void buildTestNodes(IResultMap tests, LogStatus status) {
 * 
 * if (tests.size() > 0) { for (ITestResult result : tests.getAllResults()) {
 * test = extent.startTest(result.getMethod().getDescription());
 * 
 * test.getTest().startedTime = getTime(result.getStartMillis());
 * test.getTest().endedTime = getTime(result.getEndMillis());
 * 
 * test.getTest().getStartedTime(); test.getTest().getEndedTime();
 * 
 * for (String group : result.getMethod().getGroups())
 * test.assignCategory(group);
 * 
 * String message = "Test " + status.toString().toLowerCase() + "ed";
 * 
 * if (result.getThrowable() != null) message =
 * result.getThrowable().getMessage();
 * 
 * test.log(status, message);
 * 
 * extent.endTest(test); } } }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */