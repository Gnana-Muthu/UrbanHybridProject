package com.mindtree.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.Uistore.SearchProductsUistore;



public class SearchManyProductsPageObjects extends SearchProductsUistore {
public WebDriver driver;
	
	public SearchManyProductsPageObjects(WebDriver driver)
	{
		this.driver=driver;
	}

	public WebElement Search()
    {
		try
		{
			return driver.findElement(search);
			
			
		}
		catch(Exception e)
		{
			System.out.println("cannot able to Search");
			return null;
		}
		
		
    }

	public void SearchProducts(String search)
    {
		try
		{
			Search().click();
			//logger.info("Search Many Products ");
			Search().sendKeys(search);
			Thread.sleep(2000L);
			Search().sendKeys(Keys.ENTER);
			Search().clear();
			
		}
		catch(Exception e)
		{
			System.out.println("cannot able to Search");
			
		}
		
		
    }

}
