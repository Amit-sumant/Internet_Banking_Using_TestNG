package com.Internet_Banking_TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Intenerbanking.qa.Base.TestBase;
import com.Internetbanking.qa.Pages.HomePage;
import com.Internetbanking.qa.Pages.LoginPage;
import com.Internetbanking.qa.Pages.NewCustomer;

import junit.framework.Assert;

public class HomePage_TestCase extends TestBase
{
	HomePage homepage;
	LoginPage loginpage;
	NewCustomer ncust;

	public HomePage_TestCase() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void validateWelcomeText()
	{
		String str = homepage.welcomeTitle();
		Assert.assertEquals(str, "Welcome To Manager's Page of Guru99 Bank");
	}
	
	@Test
	public void clickonNewCustomer() throws IOException
	{
		ncust = homepage.clickonNewCustomer();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}