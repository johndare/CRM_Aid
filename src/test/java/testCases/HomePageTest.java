package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base
{
	public static LoginPage lp;
	public static HomePage hp;
	@BeforeMethod
	public void setUp()
	{
		initialize();
		lp = new LoginPage();
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	@Test
	public void contactLink_click()
	{
		hp.contacts_link_click();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
