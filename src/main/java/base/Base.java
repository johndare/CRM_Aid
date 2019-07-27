package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import eventListener.EventListener;
import utility.Utility;

public class Base 
{
	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver efwd;
	public static EventListener el;
	public Base()
	{
		try 
		{
			FileInputStream ip = new FileInputStream("F:/Selenium/Programs/CRM_Aid/src/main/java/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void initialize()
	{
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	
		efwd = new EventFiringWebDriver(driver);
		el = new EventListener();
		efwd.register(el);
		driver = efwd;
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Utility.imp_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utility.p_l_t, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
}
