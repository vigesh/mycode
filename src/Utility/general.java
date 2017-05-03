package Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Report.Extent_log;
import Utility.Constants;


	public class general extends Extent_log{
	
	public WebDriver driver;
	public String Path_pass=System.getProperty("user.dir")+"\\Report\\Screenshot\\Pass\\";
	public String Path_fail= System.getProperty("user.dir")+"\\Report\\Screenshot\\Fail\\";
	public Workbook workbook=null;

	public void urltoTest(){
		try
		{
			driver.get(Constants.URL);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Invalid URL");
		}
	}
	
	public  void waitforelementtoload(WebElement element){
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e)
		{
			
			logger.log(LogStatus.FAIL, "Failed to load the element");
		}
	}
	
	public  void waitforpagetoload()
	{
		try
		{
			 WebDriverWait wait = new WebDriverWait(driver, 30);

			    wait.until(new ExpectedCondition<Boolean>() {
			        public Boolean apply(WebDriver wdriver) {
			            return ((JavascriptExecutor) driver).executeScript(
			                "return document.readyState"
			            ).equals("complete");
			        }
			    });
		} 
		catch(Exception e)
		{
			
			logger.log(LogStatus.FAIL, "Failed for the Page to load");
			throw(e);
		}
	}
	
	
	public  void click_object(WebElement element) throws IOException{
		String Temp_value = null;
		try
		{
			element.isEnabled();
			//new Actions(driver).moveToElement(element);
			Temp_value=element.getText();
			Pass_Screenshot();
			element.click();
			logger.log(LogStatus.PASS, "Clicked on the object: "+Temp_value+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			Fail_Screenshot();
			logger.log(LogStatus.FAIL, "Clicked on the object: "+Temp_value+logger.addScreenCapture(Path_fail+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
			throw(e);
		}
	}
	
	public  void click_checkbox(WebElement element) throws IOException{
		String Temp_value = null;
		try
		{
			element.isSelected();
			element.click();
			Pass_Screenshot();
			logger.log(LogStatus.PASS, "Checkbox selected: "+Temp_value+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			Fail_Screenshot();
			logger.log(LogStatus.FAIL, "Clicked on the object: "+Temp_value+logger.addScreenCapture(Path_fail+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
	}
	
	
	public  void click_checkbox(WebElement element, String chkbox_value) throws IOException{
		String Temp_value = null;
		try
		{
			if(element.isSelected())
				{
				element.getAttribute("value").equalsIgnoreCase(chkbox_value);
				element.click();
				}
			Pass_Screenshot();
			logger.log(LogStatus.PASS, "Checkbox selected: "+Temp_value+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			Fail_Screenshot();
			logger.log(LogStatus.FAIL, "Clicked on the object: "+Temp_value+logger.addScreenCapture(Path_fail+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
	}
	public  void click_button(WebElement element) throws Exception{
		String Temp_value = null;
		try
		{
			element.isEnabled();
			
			if(element.getAttribute("value")!=null)
			{
				Temp_value=element.getAttribute("value");
			}
			else
			{
				Temp_value=element.getText();
			}
			element.click();
			Thread.sleep(2000);
			Pass_Screenshot();
			logger.log(LogStatus.PASS, "Clicked on the object: "+Temp_value+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			Fail_Screenshot();
			logger.log(LogStatus.FAIL, "Clicked on the object: "+Temp_value+logger.addScreenCapture(Path_fail+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
			throw(e);
		}
	}
	
	public  void sendText(WebElement element, String text) throws IOException{
		try
		{
			element.isEnabled();
			element.clear();
			element.sendKeys(text);
			Pass_Screenshot();
			logger.log(LogStatus.PASS, "Input text is : "+text+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			Fail_Screenshot();
			logger.log(LogStatus.FAIL, "Input text failed"+logger.addScreenCapture(Path_fail+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
	}
	
	public  void get_text(WebElement element) throws IOException{
		String temp_value=null;
		try
		{
			element.isEnabled();
			temp_value=element.getText();
			Pass_Screenshot();
			logger.log(LogStatus.PASS, "Value retrieved is: "+temp_value+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			Fail_Screenshot();
			logger.log(LogStatus.FAIL, "Retrieving text value failed"+logger.addScreenCapture(Path_fail+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
	}
	
	public  void validate_text(WebElement element, String text) throws IOException{
		String temp_value=null;
		try
		{
			element.isEnabled();
			temp_value=element.getText();
			if(text!=null){
				if(temp_value.contains(text))
				{
					Pass_Screenshot();
					logger.log(LogStatus.PASS, "Value retrieved is: "+temp_value+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
				}
			}
			else
			{
				Pass_Screenshot();
				logger.log(LogStatus.PASS, "Value retrieved is: "+temp_value+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
			}
			
		}
		catch(Exception e)
		{
			Fail_Screenshot();
			logger.log(LogStatus.FAIL, "Retrieving text value failed"+logger.addScreenCapture(Path_fail+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
	}
	
	public  void select_radiobutton(List<WebElement> element, String value) throws IOException{
		String temp_value=null;
		try
		{
			for(int i=0; i<element.size(); i++)
			{
				if(element.get(i).getAttribute("value").equals(value))
				{
					temp_value=element.get(i).getAttribute("value");
					element.get(i).click();
				}
			}
			Pass_Screenshot();
			logger.log(LogStatus.PASS, "Radio button selected is: "+temp_value+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			Fail_Screenshot();
			logger.log(LogStatus.FAIL, "Radio button not selected"+logger.addScreenCapture(Path_fail+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
	}
	
	public  void radiobtn_selected(List<WebElement> element) throws IOException{
		String temp_value = null;
		try
		{
			for(int i=0; i<element.size(); i++)
			{
				if(element.get(i).isSelected())
				{
					 temp_value=element.get(i).getAttribute("value");
				}
			}
			Pass_Screenshot();
			logger.log(LogStatus.PASS, "Radio button selected is :"+temp_value+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			Fail_Screenshot();
			logger.log(LogStatus.FAIL, "Radio button not selected"+logger.addScreenCapture(Path_fail+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
	}
	
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        Alert alert=driver.switchTo().alert();
	        alert.accept();
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	    	return false; 
	    }   // catch 
	}  
	
	public void validate_popupbox() throws IOException
	{
		try
		{
			if(isAlertPresent()==true)
			logger.log(LogStatus.PASS, "Popup handled successfully"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			if(isAlertPresent()==false)
			logger.log(LogStatus.FAIL, "Popup not detected"+logger.addScreenCapture(Path_fail+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
				
	}
	
	public  void checkbox_selected(WebElement element) throws IOException{
		String temp_value = null;
		try
		{
			new Select(element);
			if(element.isSelected())
			{
				temp_value=element.getText();
			}
			Pass_Screenshot();
			logger.log(LogStatus.PASS, "Checkbox selected is :"+temp_value+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			Fail_Screenshot();
			logger.log(LogStatus.FAIL, "Checkbox not selected"+logger.addScreenCapture(Path_fail+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
	}
	 
	public void Pass_Screenshot() throws IOException{
		 try
		 {
			 Constants.step_count=Constants.step_count+1;
			 String scr_shot = Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg" ;
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(scrFile, new File(scr_shot)); 
		 
		 }
		 catch (IOException e)
			{
				throw(e);
			}
	 }
	 
	    	
	public void Fail_Screenshot() throws IOException{
		 try
		 {
			 String scr_shot = Path_fail+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg" ;
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(scrFile, new File(scr_shot)); 
		 
		 }
		 catch (IOException e)
			{
				throw(e);
			}
	 }
	
	public void close_Browser()
	{
		try
		{
			driver.close();
		}
		catch(Exception e)
		{
			
		}
	}

	public void testexe_time()
	{
		try
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
			Date date = new Date();
			Constants.testexe_time = dateFormat.format(date);
			
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public void ValidatedropDownValues(WebElement element,ArrayList<String> value ) throws Exception
	{
	 int flag=0;
	 String temp = null;
	  
	 try{
		 	element.isEnabled();
		 	element.click();
		 	Select sel = new Select(element);
		 	List<WebElement> ele = sel.getOptions();
		 	Constants.validate_dropdown.clear();
		 	for (int i = 0; i<value.size(); i++)
		 		{
		 			for(WebElement obj :ele)
		 				{
		 					if (value.get(i).equals(obj.getText()))
		 						{
		 							temp=value.get(i);
		 							Constants.validate_dropdown.add(temp);
		 							flag=1;
								    break;
		 						}
		 				} 
		 		}
		    if (flag==1)
		    	{
		    		flag=0;
		    		Pass_Screenshot();
		    		logger.log(LogStatus.PASS, Constants.validate_dropdown+"values is present in dropdown"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		    	}
		   else
		   		{
			   Fail_Screenshot();
			   logger.log(LogStatus.FAIL, "Dropdown validation failed"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		   		}
	 }
	 catch (Exception e)
	 	{
		 	Fail_Screenshot();
		 	logger.log(LogStatus.FAIL, "Object not Exists"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		 	throw(e);
	 	}
	}
	
	public void dropdown_selected(WebElement element, String value ) throws Exception
	{
	 String temp = null;
	 
	 try{
		 	element.isEnabled();
		 	element.click();
		 	Select sel = new Select(element);
		 	WebElement dropdownelement = sel.getFirstSelectedOption();
		 	temp=dropdownelement.getText();
		 	Pass_Screenshot();
		    logger.log(LogStatus.PASS, "Drop down selected is : "+ temp +logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
	 	}
	 catch (Exception e)
	 	{
		 	Fail_Screenshot();
		 	logger.log(LogStatus.FAIL, "No dropdown is selected"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		 	throw(e);
	 	}
	}
	
	
	public void Select_dropdown(WebElement element, String VisibleText, int index, String value ) throws Exception
	{
	  
	 try{
		 	element.isEnabled();
		 	element.click();
		 	Select sel = new Select(element);
		 	String temp=null;
		 	if(VisibleText!="null")
		 	{
		 		sel.selectByVisibleText(VisibleText);
		 		temp=VisibleText;
		 	}
		 	else if(value!="null")
		 	{
		 		sel.selectByVisibleText(value);
		 		temp=value;
		 	}
		 	else
		 	{
		 		sel.selectByIndex(index);
		 		temp=String.valueOf(index);
		 	}
		 	Thread.sleep(2000);
		 	Pass_Screenshot();
		    logger.log(LogStatus.PASS, "Drop down selected is : "+ temp +logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
	 	}
	 catch (Exception e)
	 	{
		 	Fail_Screenshot();
		 	logger.log(LogStatus.FAIL, "No dropdown is selected"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		 	throw(e);
	 	}
	}
	
	public void assert_text(WebElement element, String Expected)
	{
		String temp=null;
		try
		{
			temp=element.getText();
			Assert.assertEquals(temp, Expected);
			logger.log(LogStatus.PASS, "Asserted text is : "+ temp +logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Assert Text Failed"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		 	
		}
	}
	
	public void window_handle()
	{
		try
		{
			for(String window:driver.getWindowHandles())
			{
				driver.switchTo().window(window);
			}
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Window Handle Failed");
		}
	}
	
	public void mouse_hover(WebElement element) throws IOException
	{
		try
		{
			Actions action=new Actions(driver);
			action.moveToElement(element).perform();
			Pass_Screenshot();
			logger.log(LogStatus.PASS, "Mouser Hover successful"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			Fail_Screenshot();
			logger.log(LogStatus.FAIL, "Mouse Hover Failed"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
	}
	
	public void mousehover_click(WebElement element) throws IOException
	{
		try
		{
			Actions action=new Actions(driver);
			action.moveToElement(element).click().perform();
			//waitforpagetoload();
			Pass_Screenshot();
			logger.log(LogStatus.PASS, "Mouser Hover click successful"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			Fail_Screenshot();
			logger.log(LogStatus.FAIL, "Mouse Hover click Failed"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
			throw(e);
		}
	}
	
	public void page_scroll(int co_ord_X, int co_ord_Y)
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy("+co_ord_X+", "+co_ord_Y+")", "");
			Thread.sleep(2000);
			Pass_Screenshot();
			logger.log(LogStatus.PASS, "page scrolled successfully"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Page scroll Failed"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
	}
	
	public void js_sendText(WebElement element, String Text)
	{
		try
		{
			element.isEnabled();
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].value='"+Text+"';", element);
			Thread.sleep(1000L);
			
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Page scroll Failed"+logger.addScreenCapture(Path_pass+Constants.testexe_time+"\\"+Constants.test_name+"\\"+Constants.step_count+".jpg"));
		}
	}
	
	public void verify_submenupages(List<WebElement> element, WebElement elem) throws Exception
	{
		try
		{
			
			/*for(WebElement e: element)
	  		{
				System.out.println(element);
				System.out.println(element.size());
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				mouse_hover(elem);
	  			mousehover_click(e);
	  			
	  		}*/
			for(int i=0; i<element.size(); i++)
			{
				WebElement e=element.get(i);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				mouse_hover(elem);
	  			mousehover_click(e);
			}
	  		//HtmlReportCreation.LogBody("Pass", "Navigation Bar values are displayed: "+Config.values, "scr_shot");
			
		}
		catch(Exception e)
		{
			//Log.error("Menu Options are not Displayed on the page ");
	  		//General.failScreenShot("Menu Options are not Displayed on the page ");
	  		throw(e);
		}
	}
	
	public void handleStaleElement(WebElement element) {
		  int count = 0;
		  
		  while (count < 4) {
		   try {
		  
		  
		  
		    element.clear();    
		   } catch (StaleElementReferenceException e) {
		    e.toString();
		    //System.out.println("Trying to recover from a stale element :" + e.getMessage());
		    count = count + 1;
		   }
		   count = count + 4;
		  }
		 }
}
	 
