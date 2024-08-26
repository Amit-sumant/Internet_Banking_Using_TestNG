package com.Internet_Banking_TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Intenerbanking.qa.Base.TestBase;
import com.Internetbanking.qa.Pages.HomePage;
import com.Internetbanking.qa.Pages.LoginPage;

public class Login_TestCase extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;

	public Login_TestCase() throws IOException 
	{
		super();
		//this is Super keyword
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		
		loginpage=new LoginPage();
		
	}
	
	@Test (priority = 1)
	public void loginPageTitleTestValidate()
	{
		String title = loginpage.validateTitle();
		
		Assert.assertEquals(title, "Guru99 Bank Home Page");
	}
	
	@Test (priority = 2)
	public void pageLogo()
	{
		Boolean logo = loginpage.pageLogo();
		Assert.assertTrue(logo);
	}
	
	@Test (priority = 3)
	public void enterCredentials() throws IOException
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
