package com.Internetbanking.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Intenerbanking.qa.Base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath="//marquee[@class='heading3']")
	WebElement welcomeText;
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement newCust;

	public HomePage() throws IOException 
	{
		super();
		
		PageFactory.initElements(driver, this);
	}
	
	public String welcomeTitle()
	{
		String strtext = welcomeText.getText();
		
		return strtext;
	}
	
	public NewCustomer clickonNewCustomer() throws IOException
	{
		newCust.click();
		
		return new NewCustomer();
	}
	

}
