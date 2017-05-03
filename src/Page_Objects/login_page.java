package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class login_page {
	
	protected WebDriver driver;
	
	public login_page()
	{
		 PageFactory.initElements(driver, this);
	}

	@FindBy(name="uid")			public WebElement Username;
	@FindBy(name="password")	public WebElement Password;
	@FindBy(name="btnLogin")	public WebElement Loginbutton;
	@FindBy(name="btnReset")	public WebElement Reset;
	@FindBy(linkText="Log out")	public WebElement Logout;
	@FindBy(xpath="html/body/table/tbody/tr/td/table/tbody/tr[3]/td")	public WebElement MngrID;
	 
}
