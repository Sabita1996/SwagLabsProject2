package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class Extend_Report_Manager extends TestBase
{
	 static ExtentReports report;
     public static ExtentReports getReportInstance()
     {
    	 if(report==null)
    	 {
    		 String reportName=new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
    		 ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("C:\\Users\\DELL\\eclipse-workspace\\Selanium_28_batch\\Extend_Reports\\report.html");
    		 report=new ExtentReports();
    		 report.attachReporter(htmlReporter);
    		 report.setSystemInfo("OS","Windows");
    		 report.setSystemInfo("Environment","SIT");
    		 report.setSystemInfo("Build Number","102.02.02.126");
    		 report.setSystemInfo("Browser","Chrome");
    		 htmlReporter.config().setDocumentTitle("UI Testing Documents");
    		 htmlReporter.config().setReportName("UI Test Report");
    	 }
		return report;
    	 
     }
}
