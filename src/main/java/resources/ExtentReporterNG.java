package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports report;
	
	public static ExtentReports getReporterObject() {
		
		String reportLocation = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportLocation);
		spark.config().setReportName("Sagar's Test Report");
		spark.config().setDocumentTitle("Automation Result");
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Tester", "Sagar Shrestha");
		return report;
	}

}
