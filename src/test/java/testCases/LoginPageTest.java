package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;

public class LoginPageTest extends Base
{
	public static LoginPage lp;
	@BeforeMethod
	public void setUp()
	{
		initialize();
		lp = new LoginPage();
	}
	
	@Test
	public void login()
	{
		lp.login(prop.getProperty("username"),prop.getProperty("password"));

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
