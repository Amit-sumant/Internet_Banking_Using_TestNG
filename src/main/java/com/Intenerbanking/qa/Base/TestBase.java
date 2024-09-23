package com.Intenerbanking.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.Internetbaking.qa.Util.TestUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException
	{
		prop=new Properties();
		try 
		{
			FileInputStream fis=new FileInputStream("./src/main/java/com/Internetbaning/qa/Config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void initialization()
	{
		// This code for select the and open browser
		
		String strBrowserName = prop.getProperty("browser");
		
		if(strBrowserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			opt.addArguments("--disable-notifications");
			driver=new ChromeDriver(opt);
		}
		else
			if(strBrowserName.equals("edge"))
			{
				WebDriverManager.chromedriver().setup();
				EdgeOptions opt=new EdgeOptions();
				opt.addArguments("--remote-allow-origins=*");
				opt.addArguments("--disable-notifications");
				driver=new EdgeDriver(opt);
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtility.Implicit_Wait));
		
		driver.get(prop.getProperty("url"));
	}
	
	public void failedTestCases() throws IOException
	{
		File srcTarget = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trgFile=new File(".\\Screenshots\\\"+fileName +\".png\"");
		
		FileUtils.copyDirectory(srcTarget, trgFile);
		
	}

}
