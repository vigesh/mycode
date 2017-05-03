package Scripts;

//import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.LogStatus;
import Page_Objects.*;
import Utility.*;


public class driver extends general{

	ExcelUtil Excel=new ExcelUtil();
	
	@BeforeSuite
	public void beforeSuite() 
	{
		testexe_time();
		create_html();
	}
	
		
	@BeforeMethod
	@Parameters("browser")
	public  void beforemethod(String browser, Method method) throws Exception 
	{			
		start_test(method);
		Constants.step_count=0;
				if(browser.equalsIgnoreCase("firefox"))
			      {
			    	  driver = new FirefoxDriver();
			          driver.manage().window().maximize();
			          logger.log(LogStatus.PASS, "Browser instance selected is Firefox");
			      }
			      else if(browser.equalsIgnoreCase("chrome"))
			      {
			            System.setProperty("webdriver.chrome.driver","E:\\V.Vigesh\\Selenium Jars\\chromedriver.exe");
			            ChromeOptions options = new ChromeOptions();
			            options.addArguments("--test-type", "--disable-extensions");
			            driver = new ChromeDriver(options);
			            driver.manage().window().maximize();
			            logger.log(LogStatus.PASS, "Browser instance selected is Chrome");
			      }
			 
			      else if(browser.equalsIgnoreCase("ie"))
			      {
			    	  	System.setProperty("webdriver.ie.driver","E:\\V.Vigesh\\Selenium Jars\\IEDriverServer_Win32.exe");
			            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			            ieCapabilities.setCapability("ensureCleanSession", true);
			            driver = new InternetExplorerDriver(ieCapabilities);
			            driver.manage().window().maximize();
			            logger.log(LogStatus.PASS, "Browser instance selected is IE");
			      }
			      else 
			      {
			            throw new Exception("Browser is not Valid");
			      }
			 
			        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			        logger.log(LogStatus.INFO, "Regression Test started");
			        urltoTest();
		}
	
		
		@AfterMethod
		public  void aftermethod() 
		{
			logger.log(LogStatus.INFO, "Regression Test Complete");
			close_Browser();
			end_test();
		}
		
		
		 @AfterSuite
		 public void tearDown() throws Exception
		 {
			 //Here chrome is used since the attachment is best viewed in chrome, unable to view in Firefox and IE
			 System.setProperty("webdriver.chrome.driver","E:\\V.Vigesh\\Selenium Jars\\chromedriver.exe");
	         ChromeOptions options = new ChromeOptions();
	         options.addArguments("--test-type", "--disable-extensions");
	         driver = new ChromeDriver(options);
	         driver.manage().window().maximize();
			 driver.get(System.getProperty("user.dir")+"\\Report\\HTML_Report\\Guru99-Regression_Test Report_"+Constants.testexe_time+".html");
			 Email.sendmail("erseleniumtesting@gmail.com");
		}
		
		/*@Test(priority=1)
		public void guru99_Login() throws Exception{
			Constants.test_name="Login to Magento";
			Base_Objects BO = new Base_Objects(driver);
			Excel.ReadExcel("Login");
			
			try
			{
				sendText(BO.login_Username, Excel.xlvalue("Username"));
				sendText(BO.login_Password, Excel.xlvalue("Password"));
				click_button(BO.Login_btn);
				click_button(BO.Popup_close);
				validate_text(BO.Login_name, Excel.xlvalue("Username"));
				logger.log(LogStatus.INFO, "successfully logged in");
				click_object(BO.Log_out);
				Constants.Test_status="PASS";
				Excel.Write_excel("TestCase");
				
			}
				catch(Exception e)
				{
					logger.log(LogStatus.FAIL, "Login Failed");
					Constants.Test_status="FAIL";
					Excel.Write_excel("TestCase");
				}
		}
		
			
		@Test(priority=2)
		public void guru99_AddCustomer() throws Exception{
			Constants.test_name="Adding New Customer";
			AddCustomer_Magento POM = new AddCustomer_Magento(driver);
			Excel.ReadExcel("Login");
			sendText(POM.login_Username, Excel.xlvalue("Username"));
			sendText(POM.login_Password, Excel.xlvalue("Password"));
			click_button(POM.Login_btn);
			click_button(POM.Popup_close);
			Excel.ReadExcel("AddCustomer");
			for(int rowiterator=1; rowiterator<Constants.iterationcount+1; rowiterator++)
			{
				Excel.ReadExcel_list(Constants.sheet_name, rowiterator);
				logger.log(LogStatus.INFO, "Iteration No:"+rowiterator);
			 
			try
			{
				click_button(POM.Add_NewCustomer);
				get_text(POM.Label_Newcustomer);
				Select_dropdown(POM.Associateto_website, Excel.xlvalue("AssociateTo_Website"),-1,"");
				Select_dropdown(POM.Accountgroup, Excel.xlvalue("Group"),-1,"");
				click_object(POM.GroupChange_Chkbox);
				sendText(POM.Prefix, Excel.xlvalue("Prefix"));
				sendText(POM.Firstname, Excel.xlvalue("Firstname"));
				sendText(POM.Middlename, Excel.xlvalue("Middlename"));
				sendText(POM.Lastname, Excel.xlvalue("Lastname"));
				sendText(POM.Suffix, Excel.xlvalue("Suffix"));
				sendText(POM.Email, Excel.xlvalue("Email"));
				sendText(POM.DOB, Excel.xlvalue("DOB"));
				sendText(POM.Tax_or_Vatnumber, Excel.xlvalue("TaxorVat_number"));
				Select_dropdown(POM.Gender, Excel.xlvalue("Gender"),-1, "");
				sendText(POM.Password, Excel.xlvalue("Password"));
				click_button(POM.Save_customer);
				assert_text(POM.label_message, "The customer has been saved.");
				logger.log(LogStatus.INFO, "Customer added successfully");
				Constants.Test_status="PASS";
				Excel.Write_excel("TestCase");
			}
				catch(Exception e)
				{
					logger.log(LogStatus.FAIL, "Login Failed");
					Constants.Test_status="FAIL";
					Excel.Write_excel("TestCase");
				}
			}
		}
		
		@Test(priority=3)
		public void verify_submenu() throws Exception
		{
			Constants.test_name="Verifying Submenu";
			Submenu SM = new Submenu(driver);
			Excel.ReadExcel("Login");
			sendText(SM.login_Username, Excel.xlvalue("Username"));
			sendText(SM.login_Password, Excel.xlvalue("Password"));
			click_button(SM.Login_btn);
			click_button(SM.Popup_close);
			try
			{
				mouse_hover(SM.Catalog);
				mouse_hover(SM.Reviews_and_Ratings);
				mouse_hover(SM.Customer_Reviews);
				mousehover_click(SM.All_Reviews);
				page_scroll(0, 300);
				page_scroll(0, -150);
				Constants.Test_status="PASS";
				Excel.Write_excel("TestCase");				
			}
			catch(Exception e)
			{
				logger.log(LogStatus.FAIL, "Login Failed");
				Constants.Test_status="FAIL";
				Excel.Write_excel("TestCase");
			}
		}*/
		
		 @Test(priority=1)
		 public void login_SRM() throws Exception
		 {
			 try
			 {
				 ArrayList al=new ArrayList();
				 	Constants.test_name="Verifying Login";
					SRM srm = new SRM(driver);
					Excel.ReadExcel("Login");
					sendText(srm.txt_Username, Excel.xlvalue("Username"));
					sendText(srm.txt_Password, Excel.xlvalue("Password"));
					click_button(srm.Submit);
					Thread.sleep(2000L);
					verify_submenupages(srm.sale_submenu, srm.SalesTab);
					Constants.Test_status="PASS";
					Excel.Write_excel("TestCase");
				
					}
			 catch(Exception e)
			 {
				 	logger.log(LogStatus.FAIL, "Login Failed");
					Constants.Test_status="FAIL";
					Excel.Write_excel("TestCase");
			 }
		 }
}
