package Page_Objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SRM {

	public SRM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txtUsername")									public WebElement txt_Username;
	@FindBy(id="txtPassword")									public WebElement txt_Password;
	@FindBy(id="submit")										public WebElement Submit;
	@FindBy(xpath="//div[@class(.,'subtitle')]")				public WebElement home_pageHeader;
	@FindBy(xpath=".//*[@id='s4-titlerow']/div/div/ul/li")		public List<WebElement> Nav_bar;
	@FindBy(xpath="//*[@id='ctl00_liApproval']/ul//li/a")			public List<WebElement> sale_submenu;
	@FindBy(id = "ctl00_lnkApprovals") 														public WebElement SalesTab;
}
