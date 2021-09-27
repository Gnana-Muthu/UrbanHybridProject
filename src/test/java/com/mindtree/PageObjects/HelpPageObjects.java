package com.mindtree.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.Uistore.HelpUistore;
import com.mindtree.Uistore.SearchProductsUistore;



public class HelpPageObjects extends HelpUistore{
public WebDriver driver;
	
	public HelpPageObjects(WebDriver driver)
	{
		this.driver=driver;
	}

	public void HelpDetails()
    {
		try
		{
			WebElement ClickHelp=driver.findElement(Help);
			ClickHelp.click();
			WebElement ClickSearch=driver.findElement(search);
			ClickSearch.click();
			ClickSearch.sendKeys("How do I track my order status?");
			ClickSearch.sendKeys(Keys.ENTER);
			
		}
		catch(Exception e)
		{
			System.out.println("cannot able to help");
			
		}
		
    }
	
     
}
