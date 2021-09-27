package com.mindtree.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.Uistore.AddtoCartUistore;



public class AddtoCartPageObjects extends AddtoCartUistore {
public WebDriver driver;
	
	public AddtoCartPageObjects(WebDriver driver)
	{
		this.driver=driver;
	}

	public void Kidsroom()
    {
		try
		{
			Actions a=new Actions(driver);
			WebElement ClickSale=driver.findElement(Kidsroom);
			a.moveToElement(ClickSale).contextClick().build().perform();
		}
		catch(Exception e)
		{
			System.out.println("cannot able to Kidsroom");
			
		}
		
    }
	public void KidsChair()
    {
		try
		{
			WebElement Clickwood=driver.findElement(KidsChair);
			Clickwood.click();
			
			
		}
		catch(Exception e)
		{
			System.out.println("cannot able to KidsChair");
			
		}
		
    }
	public void Search()
    {
		try
		{
			WebElement ClickSearch=driver.findElement(search);
			ClickSearch.click();
			ClickSearch.sendKeys("stripey bunny");
			Thread.sleep(2000L);
			ClickSearch.sendKeys(Keys.ENTER);
			
		}
		catch(Exception e)
		{
			System.out.println("cannot able to Search");
			
		}
		
    }
	public void Addtocart()
    {
		try
		{
			Actions a=new Actions(driver);
			WebElement ClickPro1=driver.findElement(pro1);
			a.moveToElement(ClickPro1).contextClick().build().perform();
			WebElement ClickChair=driver.findElement(Prod1);
			ClickChair.click();
			WebElement Clickcart=driver.findElement(Cart);
			Clickcart.click();
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("cannot able to Addtocart");
			
		}
		
    }
	
	
     
}
