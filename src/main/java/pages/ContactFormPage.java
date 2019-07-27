package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class ContactFormPage extends Base
{
	@FindBy(xpath="//input[@name='first_name']")
	WebElement fn;
	
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement mn;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement ln;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contacts;
	
	public ContactFormPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String fname,String mname,String lname)
	{
		fn.sendKeys(fname);
		mn.sendKeys(mname);
		ln.sendKeys(lname);
		saveBtn.click();
	}
	
}
