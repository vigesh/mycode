package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.general;

public class Base_Objects extends general {
	
	
	public Base_Objects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")								public WebElement login_Username;
	@FindBy(id="login")									public WebElement login_Password;
	@FindBy(xpath="//input[@value='Login']")			public WebElement Login_btn;
	@FindBy(xpath="//span[contains(.,'close')]")		public WebElement Popup_close;
	@FindBy(xpath="//p[contains(@class,'super')]")		public WebElement Login_name;
	@FindBy(xpath="//a[contains(., 'Log Out')]")		public WebElement Log_out;
	}
