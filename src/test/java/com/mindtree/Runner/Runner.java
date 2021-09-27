package com.mindtree.Runner;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.PageObjects.AddWishListPageObjects;
import com.mindtree.PageObjects.CompareProductsPageObjects;
import com.mindtree.PageObjects.HelpPageObjects;
import com.mindtree.PageObjects.AddtoCartPageObjects;
import com.mindtree.PageObjects.SearchManyProductsPageObjects;
import com.mindtree.PageObjects.SearchProductsPageObjects;
import com.mindtree.PageObjects.StoreProductPageObjects;
import com.mindtree.PageObjects.TrackloginPageObjects;
import com.mindtree.Reusable.ReusableComponents;
import com.mindtree.Utilities.ExcelDriven;
import com.mindtree.Utilities.Sendmail;


public class Runner extends ReusableComponents
{
	//Logger logger=Logger.getLogger(ReusableComponents.class);
	@BeforeClass
	public void initialize() throws IOException {
		try {
			driver=setup();
			driver.get(baseURL);
			logger.info("Url is opened");
		}catch(Exception e) {
			
		}
		
	}
	@Test(priority=2)
	
	public void sale() {
		driver.get(baseURL);
		AddtoCartPageObjects Kr=new AddtoCartPageObjects(driver);
		Kr.Kidsroom();
		Kr.KidsChair();
		Kr.Search();
		Kr.Addtocart();
		
	}
	
	@Test(priority=1)
	
	public void loginTest() {
		driver.get(baseURL);
		logger.info("Url is opened");
		TrackloginPageObjects tl=new TrackloginPageObjects(driver);
		tl.Track();
		tl.LoginDetails();
		tl.LoginData();
	}
	
	
	@Test(priority=3)
	
	public void SearchProduct() {
		driver.get(baseURL);
		logger.info("Url is opened");
		SearchProductsPageObjects sp =new SearchProductsPageObjects(driver);
		logger.info("SearchProducts");
		sp.Search();
		logger.info("Add Filters to SearchProducts");
		sp.Filters();
		
		
	}
	@Test(priority=7)
	public void Store()throws InterruptedException {
		
		StoreProductPageObjects st=new StoreProductPageObjects(driver);
		logger.info("Click Store");
		st.Store();
		st.CheckHead();
		
	}
	@Test(priority=6)
	public void TvClick()throws InterruptedException {
		driver.get(baseURL);
		logger.info("Url is opened");
		StoreProductPageObjects st=new StoreProductPageObjects(driver);
		logger.info("Click Tv");
		st.Tv();
		
	}
	@Test(priority=5)
	public void CustomerDetails()throws InterruptedException {
		driver.get(baseURL);
		logger.info("Url is opened");
		HelpPageObjects c=new HelpPageObjects(driver);
		c.HelpDetails();
		logger.info("Get Customer Details");
		
	}
	@Test(priority=9)
	public void AddWhislist() {
		driver.get(baseURL);
		logger.info("Url is opened");
		AddWishListPageObjects aw=new AddWishListPageObjects(driver);
		logger.info("SearchProducts");
		aw.Search();
		logger.info("Add Filters to SearchProducts");
		aw.Filters();
		aw.AddWishList();
				
	}
	@Test(priority=4)
	public void Compare() throws InterruptedException {
		driver.get(baseURL);
		logger.info("Url is opened");
		CompareProductsPageObjects cp =new  CompareProductsPageObjects(driver);
		logger.info("SearchProducts");
		cp.Search();
		logger.info("Add Filters to SearchProducts");
		cp.Filters();
		logger.info("Add Recommedation to SearchProducts");
		cp.Recommended();
		logger.info("Add Compare to SearchProducts");
		cp.Compare();
		 
	}
	
	
	@Test(priority=8,dataProvider="getexceldata")
	public void SearchManyProduct(String search) throws InterruptedException {
		driver.get(baseURL);
		logger.info("Url is opened");
		SearchManyProductsPageObjects sp=new SearchManyProductsPageObjects(driver);
		sp.SearchProducts(search);
	}
	
	
	
	@DataProvider
	public Object[][] getexceldata() throws IOException{
		ExcelDriven d=new ExcelDriven();
		ArrayList<String> data= d.getData("Bed");
		int s=data.size();
		Object[][] searchdata=new Object[s][1];
		for(int i=0;i<s;i++) {
			searchdata[i][0]=data.get(i);
		}
		return searchdata;
		
	}
	@AfterSuite
	public void test() {
		Sendmail.sentEmail();
	}
	
}
