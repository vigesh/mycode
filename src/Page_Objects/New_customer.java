package Page_Objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class New_customer {
	
	public New_customer(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="New Customer")	public WebElement New_customer;//New Customer tab
	@FindBy(className="heading3")	public WebElement Mngr_ID;//New Customer tab
	
	@FindBy(xpath="//input[@name='name']")	public WebElement Customername;
	@FindBy(xpath="//input[@name='rad1']")	public List<WebElement> Gender;
	@FindBy(xpath="//input[@name='dob']")	public WebElement DOB;
	@FindBy(xpath="//textarea[@name='addr']")	public WebElement Address;
	@FindBy(xpath="//input[@name='city']")	public WebElement City;
	@FindBy(xpath="//input[@name='state']")	public WebElement State;
	@FindBy(xpath="//input[@name='pinno']")	public WebElement Pinno;
	@FindBy(xpath="//input[@name='telephoneno']")	public WebElement Telephone_no;
	@FindBy(xpath="//input[@name='emailid']")	public WebElement Email_Id;
	@FindBy(xpath="//input[@name='password']")	public WebElement Password;
	@FindBy(xpath="//input[@name='sub']")	public WebElement Submit;
	@FindBy(xpath="//input[@name='res']")	public WebElement Reset;
}
