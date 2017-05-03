package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Submenu extends Base_Objects{

	public Submenu(WebDriver driver) 
	{
		super(driver);
	}	
	
	/*	SALES		*/
	
	@FindBy(linkText="Sales")								public WebElement Sales;
	@FindBy(linkText="Orders")								public WebElement Orders;
	@FindBy(linkText="Invoices")							public WebElement Invoices;
	
	
	/*	CATALOG		*/
	
	@FindBy(linkText="Catalog")								public WebElement Catalog;
	@FindBy(linkText="Reviews and Ratings")					public WebElement Reviews_and_Ratings;
	@FindBy(linkText="Customer Reviews")					public WebElement Customer_Reviews;
	@FindBy(linkText="Pending Reviews")						public WebElement Pending_Reviews;
	@FindBy(linkText="All Reviews")							public WebElement All_Reviews;
	
	@FindBy(linkText="Manage Ratings")						public WebElement Manage_Ratings;
	
	
	/*	CUSTOMERS		*/
	
	
	@FindBy(linkText="Customers")							public WebElement Customers;
	@FindBy(linkText="Manage Customers")					public WebElement Manage_Customers;
	
	
}
