package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCustomer_Magento extends Base_Objects {
	
	
	public AddCustomer_Magento(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//button[@title='Add New Customer']")				public WebElement Add_NewCustomer;
	@FindBy(xpath=".//*[@id='content']/div/div[2]/h3")					public WebElement Label_Newcustomer;
	@FindBy(xpath=".//*[@id='messages']/ul/li/ul/li/span")				public WebElement label_message;
	@FindBy(xpath=".//button[@title='Save Customer']")					public WebElement Save_customer;
	
	@FindBy(id="_accountwebsite_id")									public WebElement Associateto_website;
	@FindBy(id="_accountgroup_id")										public WebElement Accountgroup;
	@FindBy(xpath=".//*[@id='disable_auto_group_change']")				public WebElement GroupChange_Chkbox;
	@FindBy(id="_accountprefix")										public WebElement Prefix;
	@FindBy(id="_accountfirstname")										public WebElement Firstname;
	@FindBy(id="_accountmiddlename")									public WebElement Middlename;
	@FindBy(id="_accountlastname")										public WebElement Lastname;
	@FindBy(id="_accountsuffix")										public WebElement Suffix;
	@FindBy(id="_accountemail")											public WebElement Email;
	@FindBy(id="_accountdob")											public WebElement DOB;
	@FindBy(id="_accounttaxvat")										public WebElement Tax_or_Vatnumber;
	@FindBy(id="_accountgender")										public WebElement Gender;
	@FindBy(id="_accountsendemail")										public WebElement SendEmail;
	@FindBy(id="_accountpassword")										public WebElement Password;
	
}

