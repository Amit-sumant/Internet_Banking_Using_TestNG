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

public class New_Customer_TestCases extends TestBase
{
	HomePage homepage;
	LoginPage loginpage;
	NewCustomer ncust;

	public New_Customer_TestCases() throws IOException 
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
	@Test (priority=1)
	public void pageTextLabel() throws IOException
	{
		ncust = homepage.clickonNewCustomer();
		
		String strText = ncust.getPageText();
		Assert.assertEquals(strText, "Add New Customer");
	}
	
	@Test (priority=2)
	public void navigateToNewCustomer() throws InterruptedException, IOException
	{
		
		ncust = homepage.clickonNewCustomer();
	}
	
	@Test (priority=3)
	public void enterDetails() throws InterruptedException, IOException
	{
		ncust = homepage.clickonNewCustomer();
		ncust.clickonSubmit();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
