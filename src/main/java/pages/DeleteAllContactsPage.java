package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class DeleteAllContactsPage extends Base
{
	
	public DeleteAllContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	String xpathStart = "//table[1]/tbody[1]/tr[";
	String xpathEnd = "]/td[1]";
	
	public void selectCheckBox()
	{
		List<WebElement> chkBoxes=driver.findElements(By.xpath("//div[contains(@class,'ui fitted read-only')]"));
		
		System.out.println("The Size"+chkBoxes.size());
		for(int i=1;i<=chkBoxes.size();i++)
		{
			driver.findElement(By.xpath(xpathStart+i+xpathEnd)).click();
		}
		
		driver.findElement(By.xpath("//div[@name='action']")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//div[@class='ui basic icon left attached button']")).click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
	}
	
	
	
}
