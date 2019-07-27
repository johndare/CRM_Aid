package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class HomePage extends Base
{
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contact_link;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ContactsPage contacts_link_click()
	{
		contact_link.click();
		return new ContactsPage();
	}
	
	
}
