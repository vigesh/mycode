package Report;

import java.lang.reflect.Method;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Utility.*;

public class Extent_log  {
	
	 public  ExtentTest logger;
	 public  ExtentReports report;
	 
	 public  void create_html() {
		 		 
		try
		{
			report=new ExtentReports(System.getProperty("user.dir")+"\\Report\\HTML_Report\\Guru99-Regression_Test Report_"+Constants.testexe_time+".html", true);
			report.addSystemInfo("Environment","QA-Regression");
			report.assignProject("Automation Report");
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "HTML report is not available in the given path");
		}
	}
	 
	 public void start_test(Method method){
		 try
		 {
			 logger = report.startTest( (method.getName()),method.getName()); //Test Case Start Here
			 logger.assignAuthor("Vigesh"); //Test Script Author Name
			 logger.assignCategory("Regression Test "); //Test Category Defined Here
		 }
		 catch(Exception e)
		 {
			logger.log(LogStatus.FAIL, "Start Fest Failed");
		}
	 }
	 
	 public void end_test(){
		 try{
			 report.endTest(logger);
			 report.flush();
		}
		 catch(Exception e)
		 {
			logger.log(LogStatus.FAIL, "End Test Failed");
		}
	 }
}
