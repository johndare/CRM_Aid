package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class ContactsPage extends Base
{
	@FindBy(xpath="//button[text()='New']")
	WebElement newBtn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ContactFormPage newBtn_click()
	{
		newBtn.click();
		return new ContactFormPage();
	}
	
}
