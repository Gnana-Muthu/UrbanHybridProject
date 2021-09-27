package com.mindtree.Reusable;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ReusableComponents {

	ReusableMethod rm =new ReusableMethod();
	public String baseURL=rm.getApplicationURL();
	public static WebDriver driver;
	public static Logger logger; 
	public String br=rm.getBrowser();
	
	
	@BeforeClass
	public WebDriver setup() {
		
		logger=Logger.getLogger("UrbanLadder");
		BasicConfigurator.configure();
		PropertyConfigurator.configure("Log4j.properties");
		if(br.equalsIgnoreCase("chrome"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver", rm.getChromepath());
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rm.getFirefoxpath());
			driver=new FirefoxDriver();
		} 
		else if(br.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", rm.getIEpath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	  public void getScreenshot(String result) throws IOException {
	        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(src,new File("C:\\Users\\M1070888\\eclipse-workspace\\UrbanladderHybridFramework\\ScreenShots\\"+result+"screenshot.png"));
	}
	

	
	


}
