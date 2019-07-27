package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.ContactFormPage;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import utility.Utility;

public class ContactFormPageTest extends Base
{
	
	public static LoginPage lp;
	public static HomePage hp;
	public static ContactsPage cp;
	public static ContactFormPage cfp;
	@BeforeMethod
	public void setUp()
	{
		initialize();
		lp = new LoginPage();
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
		cp=hp.contacts_link_click();
		cfp=cp.newBtn_click();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=Utility.getData(prop.getProperty("sheetname"));
		return data;
	}
	
	
	@Test(dataProvider="getData")
	public void  createNewContact(String fname,String mname,String lname)
	{
		cfp.createNewContact(fname, mname, lname);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
}
