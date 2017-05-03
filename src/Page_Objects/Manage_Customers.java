package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Manage_Customers extends Base_Objects {
	

	public Manage_Customers(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//input[@type=checkbox]")	public WebElement Checkbox;
}
