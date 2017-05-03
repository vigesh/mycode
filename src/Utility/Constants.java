package Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Constants extends ExcelUtil{
	
	//public static final String URL="http://demo.guru99.com/V4/";
	public static final String URL="http://mt000xspip92/srmbiz/ClientUserLogin.aspx";
	public static int step_count;
	public static String test_name;
	public static String testexe_time;
	/*public String Path_pass="C:\\Report\\Screenshot\\Pass\\"+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count;
	public String Path_fail= "C:\\Report\\Screenshot\\Fail\\"+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count;
	*/public static ArrayList<String> validate_dropdown=null;
	public static Map<String, String> Cellvalue  =new HashMap<String, String>();
	public static int iterationcount=0; 
	public static String sheet_name=null;
	public static String Test_name=null;
	public static String col_name=null; 
	public static String Test_status=null;
	public static ArrayList<String> Xlheader_name=new ArrayList<String>();
	public static String username = "v.vigesh@scintel.com";
	public static String password = "vigesh88";
	public static String emailfiletoattach=System.getProperty("user.dir")+"\\Report\\HTML_Report\\Guru99-Regression_Test Report_"+Constants.testexe_time+".html";
	public static Map<String, String> Writecellvalue  =new HashMap<String, String>();
	
}
