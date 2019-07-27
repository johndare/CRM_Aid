package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.ContactsPage;
import pages.DeleteAllContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class DeleteAllContactsTest extends Base
{
	public static LoginPage lp;
	public static HomePage hp;
	public static ContactsPage cp;
	public static DeleteAllContactsPage dc;
	
	@BeforeMethod
	public void setUp()
	{
		initialize();
		lp = new LoginPage();
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
		cp=hp.contacts_link_click();
		dc = new DeleteAllContactsPage();
	}
	
	@Test(priority=1)
	public void selectCheckBox1()
	{
		dc.selectCheckBox();
	}
	@Test(priority=2)
	public void selectCheckBox2()
	{
		dc.selectCheckBox();
	}
	
}
